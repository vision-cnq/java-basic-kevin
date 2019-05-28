package com.kevin.io.bio;

import java.io.*;

/**
 * @author caonanqing
 * @version 1.0
 * @description     读取某个文件，以缓冲字符流的方式一行行的读取
 * @createDate 2019/5/24
 */
public class BufferedReaderDemo {

    public static void main(String[] args) {
        File file = new File("F:" + File.separator + "Test.txt");
        bufferedReader(file);
    }

    /**
     * 读取某个文件，以缓冲字符流的方式一行行的读取
     *
     * 文本推荐使用字符流读取
     * @param file
     */
    private static void bufferedReader(File file) {
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader(file);  // 创建字符流读取文本
            br = new BufferedReader(fr);    // 放到缓冲中

            String str;
            while((str = br.readLine()) != null){   // 每次读取一行数据
                System.out.println(str);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close(); // 关闭缓冲流
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fr.close(); // 关闭流
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
