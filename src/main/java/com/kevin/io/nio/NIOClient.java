package com.kevin.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.charset.Charset;

/**
 * @author caonanqing
 * @version 1.0
 * @description     NIO客户端
 * @createDate 2019/5/27
 */
public class NIOClient {

    public static void main(String[] args) {

        String data = "队列，解析json，解析xml，多线程，socket，日志，集合，数组，加解密";
        try {
            // 1.建立一个通道
            DatagramChannel channel = DatagramChannel.open();
            // 2.建立缓冲区
            ByteBuffer buffer = Charset.forName("utf-8").encode(data);
            // 3.发送数据
            channel.send(buffer,new InetSocketAddress("127.0.0.1",8989));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
