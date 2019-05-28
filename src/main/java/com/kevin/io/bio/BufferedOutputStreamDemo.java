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
public class BufferedOutputStreamDemo {

    public static void main(String[] args) {
        File file = new File("F:/Test1.txt");

        bufferedOutputWrite(file);    // 创建文件并写入内容，以缓冲字节流的方式
    }

    /**
     *  创建文件并写入内容，以缓冲字节流的方式
     * @param f
     */
    private static void bufferedOutputWrite(File f) {
        FileOutputStream fos = null;
        BufferedOutputStream bos = null;
        try {
            fos = new FileOutputStream(f);      // 使用字节流写入
            bos = new BufferedOutputStream(fos);    // 放到缓冲中
            bos.write("缓冲字节流写入数据1".getBytes());
            bos.write("缓冲字节流写入数据2".getBytes());
            bos.flush();    // 刷新缓冲
            System.out.println("写入数据成功");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bos.close();    // 关闭缓冲流
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
