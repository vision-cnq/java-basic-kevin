package com.kevin.io.bio;

import java.io.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * @author caonanqing
 * @version 1.0
 * @description     用GZIP进行简单压缩，单个文件压缩
 *
 *      CheckedInputStream：
 * @createDate 2019/5/28
 */
public class GZIPCompressDemo {

    public static void main(String[] args) {
        String fileName = "README_OUT.md";  // 被压缩的文件
        String name = "test.gz";    // 压缩
        //GZIPcompressDemo.compress(fileName,name);   // 压缩文件
        GZIPCompressDemo.uncompress(name);      // 读取压缩的文件
    }

    /**
     * GZIP压缩文件
     */
    public static void compress(String fileName, String name){

        BufferedReader in = null;
        BufferedOutputStream out = null;
        try {
            // 获取需要压缩的文件，因为是文本使用了Reader，设置了编码，避免出现中文乱码
            in = new BufferedReader(new InputStreamReader(new FileInputStream(fileName),"utf-8"));
            // 压缩到的位置
            out = new BufferedOutputStream(new GZIPOutputStream(new FileOutputStream(name)));
            System.out.println("开始压缩文件...");
            int c;
            while ((c = in.read()) != -1) {
                // 注，这里是压缩一个字符文件，前面是以字符流来读的，不能直接存入c，因为c已是Unicode码，
                // 这样会丢掉信息的（当然本身编码格式就不对），所以这里要以utf-8来解后再存入。
                out.write(String.valueOf((char)c).getBytes("utf-8"));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtil.closes(in,out);
        }

    }

    /**
     * GZIP读取压缩包中的文件
     */
    public static void uncompress(String name){
        BufferedReader in = null;
        try {
            // 使用GZIPInputStream包装InputStream流，使其具有解压特性
            in = new BufferedReader(new InputStreamReader(new GZIPInputStream(new FileInputStream(name)),"utf-8"));
            String s;
            // 读取压缩文件里的内容
            while ((s = in.readLine()) != null)
                System.out.println(s);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtil.closes(in);
        }
    }

}
