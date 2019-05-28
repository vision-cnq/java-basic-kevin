package com.kevin.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Iterator;

/**
 * @author caonanqing
 * @version 1.0
 * @description     NIO 服务器端UDP，使用Selector选择器，非阻塞
 *      流程：
 *          1.创建Selector选择器；
 *          2.将Channel通道修改为非阻塞模式（只有Socket才能修改为非阻塞模式，FileChannel不能修改），并将通道注册至Selector；
 *          3.Selector调用select方法对通道进行选择。
 * @createDate 2019/5/27
 */
public class NIOSelectorServer {

    public static void main(String[] args) {
        try {
            // 1.创建Selector选择器
            Selector selector = Selector.open();
            // 2.建立Channel通道
            DatagramChannel channel = DatagramChannel.open();
            channel.configureBlocking(false);   // 设置为非阻塞模式
            channel.bind(new InetSocketAddress("127.0.0.1",8999));
            // 此通道注册在Selector时关注是否可读
            channel.register(selector,SelectionKey.OP_READ);
            while (true) {
                // 如果没有一个注册到此Selector上通道就绪，则阻塞。反之，只要有一个通道就绪，则不会阻塞。
                selector.select();
                // 选择就绪的通道
                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                while (iterator.hasNext()) {
                    SelectionKey key = iterator.next();
                    iterator.remove();

                    if (key.isReadable()) { // 收到客户端数据
                        receive(key);
                    }
                    if(key.isWritable()) {  // 服务端通道准备好向客户端发送数据

                    }
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void receive(SelectionKey key) throws IOException {
        DatagramChannel channel = (DatagramChannel) key.channel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        channel.receive(buffer);
        System.out.println(new String(buffer.array()));
    }
}
