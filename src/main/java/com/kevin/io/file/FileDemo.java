package com.kevin.io.file;

import java.io.File;
import java.util.Date;

/**
 * @author caonanqing
 * @version 1.0
 * @description     文件操作类
 *
 * 在 Java 中，File 类是 java.io 包中唯一代表磁盘文件本身的对象。File 类定义了一些与平台无关的方法来操作文件，
 * File类主要用来获取或处理与磁盘文件相关的信息，像文件名、 文件路径、访问权限和修改日期等，还可以浏览子目录层次结构。
 *
 * File 类表示处理文件和文件系统的相关信息。也就是说，File 类不具有从文件读取信息和向文件写入信息的功能，它仅描述文件本身的属性。
 * @createDate 2019/5/23
 */
public class FileDemo {

    public static void main(String[] args) {

        String filePath = "C:\\Users\\caonanqing\\Desktop\\test\\";
        String fileName = "Test.txt";
        // 创建File，参数为文件路径
        // File file = new File(filePath + fileName);

        // 创建File，参数为路径、文件名
        File file = new File(filePath,fileName);
        System.out.println("文件名："+file.getName());
        System.out.println("文件长度："+file.length()+"字节");
        System.out.println("文件路径："+file.getPath());
        System.out.println("文件是否存在："+(file.exists() ? "存在" : "不存在"));
        System.out.println("文件或者目录："+(file.isFile() ? "是文件" : "不是文件"));
        System.out.println("文件或者目录："+(file.isDirectory() ? "是文件夹" : "不是文件夹"));
        System.out.println("是否可读："+(file.canRead() ? "可读取":"不可读取"));
        System.out.println("是否可写："+(file.canWrite() ? "可写入":"不可写入"));
        System.out.println("是否隐藏："+(file.isHidden() ?"隐藏":"不隐藏"));
        System.out.println("最后修改时间："+new Date(file.lastModified()));
    }
}
