package com.kevin.io.aio;

/**
 * @author caonanqing
 * @version 1.0
 * @description     服务器端启动类
 *      启动服务器，采用异步非阻塞模式
 * @createDate 2019/5/28
 */
public class TimeServer {

    public static void main(String[] args) {
        int port = 8010;
        new Thread(new AsyncTimeServerHandler(port),"AIO-AsyncTimeServerHandler-001").start();
    }
}
