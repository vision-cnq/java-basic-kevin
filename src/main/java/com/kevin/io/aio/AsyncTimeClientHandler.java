package com.kevin.io.aio;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.CountDownLatch;

/**
 * @author caonanqing
 * @version 1.0
 * @description     客户端请求服务端后，同时也作为回调类
 * @createDate 2019/5/28
 */
public class AsyncTimeClientHandler implements CompletionHandler<Void,AsyncTimeClientHandler>, Runnable {

    private AsynchronousSocketChannel client;

    private String host;

    private int port;

    private CountDownLatch latch;

    public AsyncTimeClientHandler(String host, int port) {
        this.host = host;
        this.port = port;
        try {
            // 初始化一个AsynchronousSocketChannel
            client = AsynchronousSocketChannel.open();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        latch = new CountDownLatch(1);
        // 连接服务端，并将自身作为连接成功时的回调handler
        client.connect(new InetSocketAddress(host, port),this, this);
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 连接服务端成功时的回调
     * @param result
     * @param attachment
     */
    @Override
    public void completed(Void result, AsyncTimeClientHandler attachment) {

        // 请求参数
        byte[] req = "query time order".getBytes();
        // 分配写缓存区
        ByteBuffer write = ByteBuffer.allocate(req.length);
        // 往写缓存区写请求body
        write.put(req);
        write.flip();
        // 将缓存中的数据写到channel，同时使用匿名内部类做完成后回调
        client.write(write, write, new CompletionHandler<Integer, ByteBuffer>() {
            @Override
            public void completed(Integer result, ByteBuffer byteBuffer) {
                // 如果缓存数据中还有数据，接着写
                if(byteBuffer.hasRemaining()) {
                    client.write(byteBuffer,byteBuffer,this);
                } else {
                    ByteBuffer readBuffer = ByteBuffer.allocate(1024);
                    // 读取服务端的返回到缓存，采用匿名内部类做写完缓存后的回调handler
                    client.read(readBuffer, readBuffer, new CompletionHandler<Integer, ByteBuffer>() {
                        // 从缓存中读取数据，做业务处理
                        @Override
                        public void completed(Integer result, ByteBuffer buffer) {
                            buffer.flip();
                            byte[] bytes = new byte[buffer.remaining()];
                            buffer.get(bytes);
                            String body;
                            try {
                                body = new String(bytes, "UTF-8");
                                System.out.println("now body is: " + body);
                                latch.countDown();
                            } catch (UnsupportedEncodingException e) {
                                e.printStackTrace();
                            }
                        }

                        // 从缓存读取数据失败，
                        @Override
                        public void failed(Throwable exc, ByteBuffer attachment) {
                            // 关闭client，释放channel相关联的一切资源
                            try {
                                client.close();
                                latch.countDown();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    });
                }
            }

            /**
             * 缓存写入channel失败
             * @param exc
             * @param attachment
             */
            @Override
            public void failed(Throwable exc, ByteBuffer attachment) {
                // 关闭client，释放channel相关联的一切资源
                try {
                    client.close();
                    latch.countDown();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * 连接服务端失败
     * @param exc
     * @param attachment
     */
    @Override
    public void failed(Throwable exc, AsyncTimeClientHandler attachment) {
        try {
            client.close();
            latch.countDown();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
