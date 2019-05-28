package com.kevin.io.bio;

import java.io.*;

/**
 * @author caonanqing
 * @version 1.0
 * @description     指定OutputStreamWriter的编码
 * @createDate 2019/5/24
 */
public class OutputStreamWriteEncodeDemo {

    public static void main(String[] args) {
        File file = new File("F:/Test1.txt");

        outputStreamWriteEncode(file);    // OutputStreamWriter转换流，指定编码并将输出的字符流变为字节流
    }

    /**
     * OutputStreamWriter转换流，指定编码并将输出的字符流变为字节流
     * @param file
     */
    private static void outputStreamWriteEncode(File file) {

        FileOutputStream fos = null;
        OutputStreamWriter osw = null;
        try {
            fos = new FileOutputStream(file);   // 建立字节输出流
            osw = new OutputStreamWriter(fos,"utf-8");  // 将字节输出流转换成字符输出流
            osw.write("hello ");
            osw.write("world ");
            osw.flush();        // 刷新缓冲
            System.out.println("写入成功");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                osw.close();     // 关闭转换流
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fos.close();    // 关闭输出流
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
