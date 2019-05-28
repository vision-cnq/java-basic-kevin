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
public class FileOutputStreamDemo {

    public static void main(String[] args) {
        File file = new File("F:/Test1.txt");

        outputWrite(file);    // 创建文件并写入内容，以字节流的方式
    }

    /**
     *
     * 创建文件并写入内容，以字节流的方式
     * (1)FileOutputStream(File file)
     * (2)FileOutputStream(String name)
     * (3)FileOutputStream(String name,boolean append)//追加模式
     * 注意：
     *      <1>前两种构造方法在向文件中写入数据时将覆盖文件中原有的内容
     *      <2>创建FileOutputStream实例时，如果相应的文件并不存在，则会自动建成一个空的文件
     * @param f
     */
    public static void outputWrite(File f){

        OutputStream output = null;
        try {
            output = new FileOutputStream(f); // 建立字节输出流，覆盖文件
            //output = new FileOutputStream(f, true); // 在原有内容上追加内容
            output.write("写入数据1".getBytes());
            output.write("写入数据2".getBytes());

            byte[] b = "写入数据3".getBytes();
            output.write(b,0,3);    // 设置长度写入数据
            System.out.println("写入成功");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                output.close();     // 关闭流
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
