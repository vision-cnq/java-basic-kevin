package com.kevin.io.aio;

/**
 * @author caonanqing
 * @version 1.0
 * @description     客户端启动类
 * @createDate 2019/5/28
 */
public class TimeClient {

    public static void main(String[] args) {
        String host = "127.0.0.1";
        int port = 8010;
        for (int i = 0; i < 10; i++) {
            new Thread(new AsyncTimeClientHandler(host, port)).start();
        }
        //new Thread(new AsyncTimeClientHandler(host, port),"AIO-AsyncTimeClientHandler-002").start();
        //new Thread(new AsyncTimeClientHandler(host, port),"AIO-AsyncTimeClientHandler-003").start();
    }
}
