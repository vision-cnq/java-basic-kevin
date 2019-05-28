package com.kevin.io.bio;

import java.io.*;

/**
 * @author caonanqing
 * @version 1.0
 * @description
 *
 * 在IO包中，实际上只有字节流，字符流是在字节流的基础上转换出来的。
 * 转换流用于在字节流和字符流之间转换。
 *
 * JDK提供了两种转换流
 *  1.InputStreamReader:
 *      (1)是Reader的子类，将输入的字节流变为字符流，即：将一个字节流的输入对象变为字符流的输入对象。
 *      (2)InputStreamReader需要和InputStream“套接”，它可以将字节流中读入的字节解码成字符
 *  2.OutputStreamWriter：
 *      (1)是Writer的子类，将输出的字符流变为字节流，即：将一个字符流的输出对象变为字节流的输出对象。
 *      (2)OutputStreamWriter需要和OutputStream“套接”，它可以将要写入字节流的字符编码成字节
 *  3.转换步骤：
 *     （1）写出数据：程序—转换流—>OutputStreamWriter—字节流—>文件
 *     （2）读入数据：程序<—转换流—InputStreamWriter<—字节流—文件
 * @createDate 2019/5/24
 */
public class OutputStreamWriteDemo {

    public static void main(String[] args) {
        File file = new File("F:/Test1.txt");

        outputStreamWrite(file);    // OutputStreamWriter转换流，将输出的字符流变为字节流
    }

    /**
     *  OutputStreamWriter转换流，将输出的字符流变为字节流
     * @param file
     */
    private static void outputStreamWrite(File file) {

        FileOutputStream fos = null;
        OutputStreamWriter osw = null;
        BufferedWriter bw = null;
        try {
            fos = new FileOutputStream(file);       // 建立字节输出流
            osw = new OutputStreamWriter(fos);      // 将字节输出流转换为字符流
            bw = new BufferedWriter(osw);       // 放到缓冲中

            bw.write("hello ");     // 写入文件
            bw.newLine();       // 换行
            bw.write("world ");
            System.out.println("写入成功");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bw.close();     // 关闭缓冲流
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                osw.close();    // 关闭转换流
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fos.close();    // 关闭流
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
