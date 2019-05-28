package com.kevin.io.file;

import java.io.File;
import java.io.FilenameFilter;

/**
 * @author caonanqing
 * @version 1.0
 * @description     获取指定路径下的所有文件
 *
 * 获取指定路径的所有文件名，不包括子路径
 * 获取指定路径的所有文件名，包括子路径
 * 获取指定路径的所有以.java结尾的文件，不包括子路径
 * 获取指定路径的所有以.java结尾的文件，包括子路径
 * @createDate 2019/5/24
 */
public class ListFileDemo  {

    //深度遍历的目录
    //filter:过滤器
    //list:容器,存放符合条件的file对象
    static FilenameFilter filter = new FilenameFilter() {
        @Override
        public boolean accept(File dir, String name) {
            return name.endsWith(".java");
        }
    };

    public static void main(String[] args) {
        File f = new File("C:\\Users\\caonanqing\\Desktop\\test");

        //showFiles(f);    // 获取指定路径的所有文件名，不包括子路径
        //showAllFiles(f);    // 获取指定路径的所有文件名，包括子路径
        //showJavaFiles(f);     // 获取指定路径的所有以.java结尾的文件，不包括子路径
        showAllJavaFiles(f); // 获取指定路径的所有以.java结尾的文件，包括子路径
    }

    /**
     * 获取指定路径的所有文件名，不包括子路径
     * @param f
     */
    public static void showFiles(File f){
        File[] files = f.listFiles();
        System.out.println("Licenses中的文件个数是："+files.length);
        System.out.println("遍历得到的Licenses中所有文件名是：");
        for(File fi:files){
            System.out.println(fi.getName());
        }
    }

    /**
     * 获取指定路径的所有文件名，包括子路径
     * @param f
     */
    public static void showAllFiles(File f){
        if(f != null) {
            if(f.isDirectory()) {   // 判断是否为目录
                File[] files = f.listFiles();   // 返回当前正在遍历的目录中的文件和目录的File实例数组
                if(files != null) {
                    for (File file : files) {
                        showAllFiles(file);
                    }
                }
            } else {
                System.out.println(f.getPath());    // 输出当前文件
            }
        }
    }

    /**
     * 获取指定路径的所有以.java结尾的文件，不包括子路径
     * @param f
     */
    public static void showJavaFiles(File f){
        //列出所有.java文件
        File[] javaFiles = f.listFiles();
        System.out.println("\n目录"+f.getName()+"下的.java文件");
        for(File file : javaFiles) {
            if(filter.accept(file, file.getName())){
                System.out.println(file.getPath());
            }
        }
    }

    /**
     * 获取指定路径的所有以.java结尾的文件，包括子路径
     * @param f
     */
    public static void showAllJavaFiles(File f){
        if(f != null){
            File[] files=f.listFiles(); // 返回当前正在遍历的目录中的文件和目录的File实例数组
            for(File file:files){
                if(file.isDirectory()){
                    //如果是目录，则递归
                    showAllJavaFiles(file);
                }else{
                    //文件
                    //过滤文件：将符合条件的file对象输出
                    if(filter.accept(f, file.getName())){
                        System.out.println(file.getPath());
                    }
                }
            }
        }
    }



}
