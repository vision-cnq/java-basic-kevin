package com.kevin.io.aio;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

/**
 * @author caonanqing
 * @version 1.0
 * @description     客户端连接成功或者失败后的回调处理类
 * @createDate 2019/5/28
 */
public class AcceptCompletionHandler implements CompletionHandler<AsynchronousSocketChannel, AsyncTimeServerHandler> {

    /**
     * 成功的回调方法
     * @param result
     * @param attachment
     */
    @Override
    public void completed(AsynchronousSocketChannel result, AsyncTimeServerHandler attachment) {
        /**
         * 服务端已经接收客户端成功了，为什么还要调用accept方法，因为一个channel可以接收成千上万个客户端
         * 当调用asynchronousServerSocketChannel.accept(this,new AcceptCompletionHandler())方法后，又有新的
         * 客户端连接接入，所以需要继续调用他的accept方法，接受其它客户端的接入，最终形成一个循环
         */
        attachment.asynchronousServerSocketChannel.accept(attachment,this);
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        /**
         * 异步读操作，参数的定义，第一个参数：接收缓冲区，用于异步从channel读取数据包
         * 第二个参数：异步channel携带的附件，通知回调的时候作为入参参数，这里是作为ReadCompletionHandler的入参
         * 通知回调的业务handler，也就是数据从channel读到ByteBuffer完成后的回调handler，这里是ReadCompletionHandler
         */
        result.read(buffer,buffer,new ReadCompletionHandler(result));
    }

    /**
     * 失败的回调方法
     * @param exc
     * @param attachment
     */
    @Override
    public void failed(Throwable exc, AsyncTimeServerHandler attachment) {
        exc.printStackTrace();
        AsyncTimeServerHandler result = (AsyncTimeServerHandler)attachment;
        result.latch.countDown();
    }
}
