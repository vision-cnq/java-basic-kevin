package com.kevin.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.charset.Charset;

/**
 * @author caonanqing
 * @version 1.0
 * @description      NIO客户端UDP（此处只有一个客户端）
 * @createDate 2019/5/27
 */
public class NIOSelectorClient {

    public static void main(String[] args) {
        String data = "队列，解析json，解析xml，多线程，socket，日志，集合，数组，加解密";

        try {
            DatagramChannel channel = DatagramChannel.open();
            ByteBuffer buffer = Charset.forName("utf-8").encode(data);
            channel.send(buffer,new InetSocketAddress("127.0.0.1",8999));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
