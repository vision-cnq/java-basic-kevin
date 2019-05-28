package com.kevin.io.bio;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * @author caonanqing
 * @version 1.0
 * @description     服务器端UDP
 *      同步、阻塞
 * @createDate 2019/5/27
 */
public class IOServer {

    public static void main(String[] args) {

        try {
            DatagramSocket socket = new DatagramSocket(8989);
            byte[] data = new byte[1024];
            DatagramPacket packet = new DatagramPacket(data, data.length);
            socket.receive(packet);     // 服务器端在没接收到数据时，会在此处被阻塞
            System.out.println(new String(packet.getData()));
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
