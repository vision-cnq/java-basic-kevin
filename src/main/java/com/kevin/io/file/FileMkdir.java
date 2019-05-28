package com.kevin.io.file;

import java.io.File;

/**
 * @author caonanqing
 * @version 1.0
 * @description     创建文件夹
 *
 *  File.separator ：
 * （1）在UNIX系统上，此字段的值为 ’/ ’;在window系统上，它为‘\’
 * （2）为了程序的跨平台性，文件的路径应该用这个属性值来代表
 *  mkdir()创建文件夹
 *  mkdirs()创建所有文件夹
 * @createDate 2019/5/24
 */
public class FileMkdir {

    public static void main(String[] args) {

        File f = new File("F:" + File.separator + "test01");
        boolean flag = f.mkdir();           // 在已有路径中创建文件夹
        System.out.println(flag ? "文件创建成功" : "文件创建失败");
        System.out.println(f.getPath());    // 获取当前路径
        System.out.println(f.getParent());  // 获取上一级路径


        File f1 = new File("F:" + File.separator + "test01" + File.separator + "test02" + File.separator + "test03");
        boolean f0 = f1.mkdir();            // 因为test02文件夹不存在，无法创建test03
        System.out.println(f0 ? "文件创建成功" : "文件创建失败");
        boolean flag1 = f1.mkdirs();        // 可以创建所有的文件夹，test02和test03都会被创建
        System.out.println(flag1 ? "文件创建成功" : "文件创建失败");
        System.out.println(f1.getPath());
        System.out.println(f1.getParent());
    }
}
