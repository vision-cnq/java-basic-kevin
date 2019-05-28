package com.kevin.io.bio;

import java.io.*;

/**
 * @author caonanqing
 * @version 1.0
 * @description     缓冲流
 *
 * 缓冲流是处理流的一种，建立在相应的节点流之上，对读写的数据提供了缓冲的功能，提高了读写的效率，还增加了一些新的方法
 *
 * JDK提供了四种缓冲流：
 * （1）BufferedInputStream可以对InputStream流进行包装
 * （2）BufferedOutputStream可以对任何的OutputStream流进行包装
 * （4）BufferedReader可以对任何的Reader流进行包装
 *      *还增加了readLine()方法用于一次读取一行字符串
 * （5）BufferedWriter可以对任何的Writer流进行包装
 *      *新增了方法newLine()用与写出一个行分隔符
 * 对于缓冲输出流，写出的数据会缓存在内存缓存区中，关闭此流前要用flush()方法将缓存区中的数据立即写出，关闭缓存流会自动关闭缓存流所包装的所有底层流
 * @createDate 2019/5/24
 */
public class BufferedInputStreamDemo {

    public static void main(String[] args) {
        File file = new File("F:" + File.separator + "Test.txt");

        bufferedInputRead(file);   // 读取某个文件，以缓冲字节流的方式
    }

    /**
     * 读取某个文件，以缓冲字节流的方式
     * @param f
     */
    private static void bufferedInputRead(File f) {

        FileInputStream fis = null;
        BufferedInputStream bis = null;
        try {
            fis = new FileInputStream(f);       // 使用字节流读取
            bis = new BufferedInputStream(fis); // 放到缓冲中
            byte[] b = new byte[1024];
            int len = 0;
            System.out.println("开始使用缓冲流，进行读取：");
            while((len = bis.read(b)) != -1) {
                System.out.println(new String(b));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bis.close();        // 关闭缓冲流
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fis.close();        // 关闭流
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
