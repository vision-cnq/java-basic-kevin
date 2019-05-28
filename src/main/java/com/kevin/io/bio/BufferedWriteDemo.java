package com.kevin.io.bio;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author caonanqing
 * @version 1.0
 * @description     创建文件并写入内容，以缓冲字符流的方式
 * @createDate 2019/5/24
 */
public class BufferedWriteDemo {

    public static void main(String[] args) {
        File file = new File("F:/Test1.txt");
        bufferedWriter(file);
    }

    /**
     * 创建文件并写入内容，以缓冲字符流的方式
     * @param file
     */
    private static void bufferedWriter(File file) {
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            fw = new FileWriter(file);      // 使用字符流写入
            bw = new BufferedWriter(fw);    // 放到缓冲中
            bw.write("\t"+"白日依山尽");
            bw.newLine();
            bw.write("\t"+"黄河入海流");
            bw.newLine();
            bw.write("\t"+"欲穷千里目");
            bw.newLine();
            bw.write("\t"+"更上一层楼");
            bw.newLine();
            bw.flush();
            System.out.println("写入成功");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bw.close();     // 关闭缓冲流
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fw.close();     // 关闭流
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }


}
