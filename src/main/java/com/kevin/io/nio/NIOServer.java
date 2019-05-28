package com.kevin.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

/**
 * @author caonanqing
 * @version 1.0
 * @description     NIO 服务器端，不使用Selector选择器，阻塞，与BIO的区别不大，只是代码简洁了
 * @createDate 2019/5/27
 */
public class NIOServer {
    public static void main(String[] args) {

        try {
            // 1.打开服务器监听通道
            DatagramChannel channel = DatagramChannel.open();
            // 2.设置监听的IP和端口
            channel.socket().bind(new InetSocketAddress("127.0.0.1",8989));
            // 3.建立缓冲区用于保存接收到的数据
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            // 4.接收数据
            channel.receive(buffer);
            // 打印数据
            System.out.println(new String(buffer.array()));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
