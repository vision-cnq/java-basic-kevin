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
public class InputStreamReaderDemo {

    public static void main(String[] args) {
        File file = new File("F:" + File.separator + "Test.txt");

        inputStreamReader(file);    // InputStreamReader转换流，将输入的字节流转换成字符流
    }

    /**
     *  InputStreamReader转换流，将输入的字节流转换成字符流
     */
    private static void inputStreamReader(File file){

        InputStream is = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        try {
            is = new FileInputStream(file);     // 输入字节流
            isr = new InputStreamReader(is);    // 将字节流转换成字符流
            br = new BufferedReader(isr);       // 放到缓冲中
            String str;
            while((str = br.readLine()) != null){   // 一行行的读取数据
                System.out.println(str);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();     // 关闭缓冲流
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                isr.close();    // 关闭转换流
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                is.close();     //关闭流
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
