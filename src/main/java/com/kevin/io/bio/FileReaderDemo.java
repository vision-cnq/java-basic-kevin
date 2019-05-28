package com.kevin.io.bio;

import java.io.*;

/**
 * @author caonanqing
 * @version 1.0
 * @description     读取某个文件，以字符流的方式
 *
 * (1)FileReader(File file):在给定File从中读取数据的File的情况下创建一个新的FileReader
 * (2)FileReader(String fileName):在给定从中读取数据数据的文件名的情况下创建一个新的FileReader
 * @createDate 2019/5/24
 */
public class FileReaderDemo {

    public static void main(String[] args) {
        File file = new File("F:" + File.separator + "Test.txt");

        reader(file);
    }

    /**
     * 读取某个文件，以字符流的方式
     *
     * 文本推荐使用字符流读取
     * @param f
     */
    public static void reader(File f){
        Reader reader = null;
        try {
            reader = new FileReader(f);     // 使用字符流读取
            char[] c = new char[1024];      // 创建字符数组保存数据
            int len = 0;
            while((len = reader.read(c)) != -1) {   // 读取文本数据，每次读取1024字节
                String str = new String(c, 0, len);
                System.out.println(str);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close(); // 关闭流
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
