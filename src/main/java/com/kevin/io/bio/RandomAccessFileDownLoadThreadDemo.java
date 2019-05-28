package com.kevin.io.bio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author caonanqing
 * @version 1.0
 * @description     使用多线程下载文件
 * @createDate 2019/5/27
 */
public class RandomAccessFileDownLoadThreadDemo {

    public static void main(String[] args) {

        // 源文件
        File src = new File("README.md");
        // 目标文件
        File desc = new File("README_OUT.md");

        // 源文件大小
        long length = src.length();

        // 启动两个线程并分配下载任务
        new DownLoadThread(0,src,desc,length/2).start();
        new DownLoadThread(length/2,src,desc,length-(length/2)).start();

    }
}

// 读写线程类
class DownLoadThread extends Thread {

    private long start;     //开始下载的位置
    private File src;       //源文件
    private File desc;      //目标文件
    private long total;     //下载总量

    /**
     *
     * @param start     开始下载的位置
     * @param src       源文件
     * @param desc      目标文件
     * @param total     下载总量
     */
    public DownLoadThread(long start, File src, File desc, long total) {
        this.start = start;
        this.src = src;
        this.desc = desc;
        this.total = total;
    }

    @Override
    public void run() {

        RandomAccessFile src = null;
        RandomAccessFile desc = null;
        try {
            // 需要指定位置读写，所以使用随机访问流
            src = new RandomAccessFile(this.src, "rw");
            desc = new RandomAccessFile(this.desc, "rw");

            // 源文件和目标文件都是从start开始
            src.seek(start);
            desc.seek(start);

            // 开始读写，自定义缓冲区进行读写
            byte[] arr = new byte[1024];
            int len;
            long count = 0;
            while ((len = src.read(arr)) != -1) {
                // 分三种情况
                if(len + count > total) {           // 1.当读取时操作该线程的下载总量时需要改变len
                    len = (int)(total - count);
                    desc.write(arr,0,len);
                    System.out.println(Thread.currentThread().getName()+"当前操作数据量超出，改变写入长度");
                    // 证明该线程下载任务已经完毕，结束读写操作。
                    break;
                } else if(len + count < total) {    // 2.证明还没有下载到总量，直接将内容写入
                    desc.write(arr,0,len);
                    // 并且使计数器任务累加
                    count += arr.length;
                    System.out.println(Thread.currentThread().getName()+"正在下载中");
                } else {                            // 3.证明刚好到下载总量
                    desc.write(arr,0,len);
                    System.out.println(Thread.currentThread().getName()+"下载完毕");
                    // 结束读写
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
          IOUtil.closes(src,desc);
        }
    }
}
