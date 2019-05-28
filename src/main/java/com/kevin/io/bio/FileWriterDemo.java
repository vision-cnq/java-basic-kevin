package com.kevin.io.bio;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * @author caonanqing
 * @version 1.0
 * @description     创建文件并写入内容，以字符流的方式
 * @createDate 2019/5/24
 */
public class FileWriterDemo {

    public static void main(String[] args) {
        File file = new File("F:/Test1.txt");
        writer(file);
    }

    /**
     * 创建文件并写入内容，以字符流的方式
     *
     * （1）FileWriter(File file) ：根据给定的 File 对象构造一个 FileWriter 对
     * （2）FileWriter(File file, boolean append) ：根据给定的 File 对象构造一个 FileWriter 对象。
     * （3）FileWriter(String fileName) ：根据给定的文件名构造一个 FileWriter 对象。
     * （4）FileWriter(String fileName, boolean append)：根据给定的文件名以及指示是否附加写入数据的 boolean 值来构造 FileWriter 对象。
     * @param f
     */
    public static void writer(File f){
        Writer writer = null;
        try {
            writer = new FileWriter(f);     // 使用字符流写入
            writer.write("字符流方式写入数据1");
            writer.write("字符流方式写入数据2");
            char[] c = {'a','b','c'};
            writer.write(c);    // 写入数据
            writer.flush();     // 刷新缓冲
            System.out.println("写入成功");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                writer.close();     // 关闭流
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
