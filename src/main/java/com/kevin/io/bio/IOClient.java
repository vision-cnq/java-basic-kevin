package com.kevin.io.bio;

import java.io.IOException;
import java.net.*;

/**
 * @author caonanqing
 * @version 1.0
 * @description     客户端UDP
 * @createDate 2019/5/27
 */
public class IOClient {

    public static void main(String[] args) {

        String data = "队列，解析json，解析xml，多线程，socket，日志，集合，数组，加解密";
        try {
            DatagramSocket socket = new DatagramSocket();
            DatagramPacket packet = new DatagramPacket(
                    data.getBytes(),data.getBytes().length,InetAddress.getByName("127.0.0.1"),8989);
            socket.send(packet);
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
