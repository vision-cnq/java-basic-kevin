package com.kevin.io.bio;

import java.io.*;

/**
 * @author caonanqing
 * @version 1.0
 * @description     IO流基本原理
 *      数据流（stream）是指数据通信的通道。
 *      java程序中对程序的输入、输出操作是以流的方式进行的。
 *
 * IO流的分类：
 *  按流向分：
 *      (1)输入流：程序从数据源读取数据的流
 *      (2)输出流：程序向数据原写入数据的流
 *  按数据传输单位分：
 *      (1)字节流：以字节为单位传输数据的流
 *      (2)字符流：以字符为单位传输数据的流
 *  按功能分：
 *      (1)节点流：用于直接操作目标设备的流
 *      (2)处理流：是对一个已存在的连接和封装，通过对数据的处理为程序提供更为强大，灵活的读写功能
 *
 * <1>InputStream:read(xx)读取字节系列方法
 * <2>OutputStream:writer(xx)写入字节系列方法
 * <3>Reader:read(xx)读取字符系列方法
 * <4>Writer:writer(xx)写入字符系列方法
 *
 * @createDate 2019/5/23
 */
public class FileInputStreamDemo {

    public static void main(String[] args) {
        File file = new File("F:" + File.separator + "Test.txt");

        inputRead(file);   // 读取某个文件，以字节流的方式
    }

    /**
     * 读取某个文件，以字节流的方式
     * (1)FileInputStream(File file)
     * (2)FileInputStream(String name)
     * @param f
     */
    public static void inputRead(File f){

        InputStream input = null;
        try {
            input = new FileInputStream(f);     // 使用字节流读取
            byte[] b = new byte[1024];
            int len = 0;
            while ((len = input.read(b)) != -1){    // 每次读取1024字节，保存到b数组中
                System.out.println(new String(b));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                input.close();  // 关闭流
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
