package com.kevin.io.nio;

import com.kevin.io.bio.IOUtil;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

/**
 * @author caonanqing
 * @version 1.0
 * @description     读写本地文件
 *      从文件中读取数据写入Buffer，应用程序从Buffer中获取数据
 * @createDate 2019/5/27
 */
public class FileChannelDemo {

    public static void main(String[] args) {
        File src = new File("README.md");
        File desc = new File("README_OUT.md");

        //FileChannelDemo.readChannel(src);    // 读取文件
        //FileChannelDemo.writeChannel(desc);    // 写入文件
        FileChannelDemo.rwChannel(src,desc);    // 读写文件

    }

    /**
     *      读取数据
     * 从文件中读取数据写入Buffer，应用程序从Buffer中获取数据
     * @param file
     */
    public static void readChannel(File file){
        RandomAccessFile raf = null;
        try {
            raf = new RandomAccessFile(file,"rw");       // 使用随机访问流读取文件
            FileChannel channel = raf.getChannel();             // 建立FileChannel通道
            ByteBuffer buffer = ByteBuffer.allocate(1024);      //设置缓冲区数组的总长度
            channel.read(buffer);       // 将通道的数据写入Buffer
            buffer.flip();          // 读写转换
            System.out.println(new String(buffer.array()));     // 打印数据
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtil.closes(raf);
        }
    }

    /**
     *      写文件
     * 从应用程序中将数据输出到文件中
     * @param file
     */
    public static void writeChannel(File file){

        String str = "队列，解析json，解析xml，多线程，socket，日志，集合，数组，加解密";

        RandomAccessFile raf = null;
        //FileOutputStream raf = null;
        try {
            raf = new RandomAccessFile(file, "rw");     // 建立随机访问流，文件不存在则新建，存在，没有设置指定位置重0开始写入
            //fos = new FileOutputStream(file);     // 文件存在会删除重新生成
            FileChannel fileChannel = raf.getChannel();     // 建立通道
            ByteBuffer buffer = Charset.forName("utf-8").encode(str);   // 将数据封装到Buffer中
            fileChannel.write(buffer);  // 写入文件
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtil.closes(raf);
            //IOUtil.closes(fos);
        }
    }

    /**
     *      读写文件
     * 从一个文件读数据，再写到另一个文件
     * @param src
     * @param desc
     */
    public static void rwChannel(File src, File desc){

        RandomAccessFile rafR = null;
        RandomAccessFile rafW = null;
        try {
            rafR = new RandomAccessFile(src, "rw");     // 获取源文件
            rafW = new RandomAccessFile(desc, "rw");    // 创建目标文件
            FileChannel rChannel = rafR.getChannel();    // 建立读取通道
            ByteBuffer buffer = ByteBuffer.allocate(1024);  // 设置缓冲区大小
            rChannel.read(buffer);      // 将读取通道的数据写入缓冲区
            buffer.flip();              // 读写转换
            FileChannel wChannel = rafW.getChannel();   // 建立写入通道
            wChannel.write(buffer);     // 将缓冲区数据写入到写入通道
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtil.closes(rafR,rafW);
        }
    }


}
