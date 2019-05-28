package com.kevin.io.nio;

import com.kevin.io.bio.IOUtil;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

/**
 * @author caonanqing
 * @version 1.0
 * @description         通过新的API——transferFrom读文件并写文件
 *
 *      通过transferFrom就能将一个通道直接输出到另一个通道而不需要缓冲区做中转。
 * @createDate 2019/5/27
 */
public class TransferFromDemo {

    public static void main(String[] args) {
        File src = new File("README.md");
        File desc = new File("README_OUT.md");

        TransferFromDemo.rwChannel(src,desc);    // 读写文件
    }

    /**
     *      读写文件
     * 从一个文件读数据，再写到另一个文件
     * @param src
     * @param desc
     */
    public static void rwChannel(File src,File desc){
        RandomAccessFile rafR = null;
        RandomAccessFile rafW = null;
        try {
            rafR = new RandomAccessFile(src, "rw");     // 使用随机访问类读取文件
            rafW = new RandomAccessFile(desc, "rw");     // 使用随机访问类读取文件
            FileChannel rChannel = rafR.getChannel();     // 建立读取通道
            FileChannel wChannel = rafW.getChannel();     // 建立写入通道
            wChannel.transferFrom(rChannel,0,rChannel.size());  // 使用transferFrom就能将一个通道直接输出到另一个通道而不需要缓冲区做中转
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtil.closes(rafW);
            IOUtil.closes(rafR);
        }
    }


}
