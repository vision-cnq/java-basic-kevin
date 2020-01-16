package com.kevin.io.aio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.util.concurrent.CountDownLatch;

/**
 * @author caonanqing
 * @version 1.0
 * @description     任务类的实现
 * @createDate 2019/5/28
 */
public class AsyncTimeServerHandler implements Runnable{

    private int port;

    CountDownLatch latch;

    AsynchronousServerSocketChannel asynchronousServerSocketChannel;

    public AsyncTimeServerHandler(int port) {
        // 服务端启动端口号
        this.port = port;
        try {
            // 创建一个AsynchronousServerSocketChannel对象，工厂方法
            asynchronousServerSocketChannel = AsynchronousServerSocketChannel.open();
            // 绑定端口号
            asynchronousServerSocketChannel.bind(new InetSocketAddress(port));
            System.out.println("the time server is start on port: " + port);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void run() {
        // 是一个并发工具类，允许一个线程等待另一个线程完成后再执行
        // 这里是为了防止主线程启动完成后关闭
        latch = new CountDownLatch(1);
        doAccept();
        try {
            // 阻塞直到count down to 0
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    /**
     * 连接成功后的回调方法
     */
    private void doAccept() {
        // 该方法是异步的接受来自通信的客户端的连接请求，连接成功后调用CompletionHandler的completed或者failed方法
        asynchronousServerSocketChannel.accept(this, new AcceptCompletionHandler());

    }
}
