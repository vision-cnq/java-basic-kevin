package com.kevin.io.bio;

import java.io.*;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

/**
 * @author caonanqing
 * @version 1.0
 * @description    用Zip进行多文件压缩
 *
 *      如果要压缩文件夹中的内容要遍历文件夹中的文件和子文件夹。
 * @createDate 2019/5/28
 */
public class ZIPCompressDemo {

    /**
     *      压缩成zip文件
     * @param srcFileName       源文件（带压缩文件或文件夹）
     * @param zipFileName       目的地Zip文件
     */
    public void zip(String srcFileName, String zipFileName){
        System.out.println("压缩中...");
        ZipOutputStream out = null;
        BufferedOutputStream bos = null;
        try {
            // 创建zip输出流
            out = new ZipOutputStream(new FileOutputStream(zipFileName));
            // 创建缓冲输出流
            bos = new BufferedOutputStream(out);
            // 源文件
            File source = new File(srcFileName);
            // 调用函数
            compress(out,bos,source,source.getName());
            System.out.println("压缩完成...");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtil.closes(bos,out);
        }

    }

    // 使用递归将子目录都压缩
    private void compress(ZipOutputStream out, BufferedOutputStream bos, File source, String name) throws IOException {
        // 如果路径为目录(文件夹)
        if(source.isDirectory()) {
            // 取出文件夹中的文件(或子文件夹)
            File[] files = source.listFiles();

            if(files.length == 0) { // 如果文件夹为空，则只需在，目的地zip文件中写入一个目录
                System.out.println(name + "/");

                out.putNextEntry(new ZipEntry(name + "/"));
            } else {    // 如果文件夹不为空，则递归调用compress，文件夹中的每一个文件（或文件夹）进行压缩
                for (int i=0;i<files.length;i++) {
                    compress(out,bos,files[i],name+"/"+files[i].getName());
                }
            }
        } else {  // 如果不是目录（文件夹），即为文件，则先写入目录进入点，之后将文件写入zip文件中
            out.putNextEntry(new ZipEntry(name));
            FileInputStream fis = new FileInputStream(source);
            BufferedInputStream bis = new BufferedInputStream(fis);
            byte[] b = new byte[1024];
            int len = 0;
            System.out.println(name);
            // 源文件写入到zip文件中
            while((len = bis.read(b)) != -1) {
                bos.write(b);
            }
            bos.flush();    // 刷新缓冲
            IOUtil.closes(bis,fis);
        }

    }

    /**
     * 解压zip文件
     * @param srcFileName       zip源文件
     * @param destDirPath   解压后的目标文件夹
     */
    public void unzip(String srcFileName, String destDirPath) {

        long start = System.currentTimeMillis();

        File srcFile = new File(srcFileName);

        // 判断是否存在
        if(!srcFile.exists()) {
            throw new RuntimeException(srcFile.getPath() + "所指文件不存在");
        }

        // 开始解压
        ZipFile zipFile = null;
        try {
            zipFile = new ZipFile(srcFile);
            Enumeration<?> entries = zipFile.entries(); // 获取压缩包中的文件
            while (entries.hasMoreElements()) {     // 遍历所有文件（文件夹）
                ZipEntry entry = (ZipEntry) entries.nextElement();
                System.out.println("解压" + entry.getName());

                if(entry.isDirectory()) { // 如果是文件夹，则创建文件夹
                    String dirPath = destDirPath + File.separator + entry.getName();
                    File dir = new File(dirPath);
                    dir.mkdir();
                } else {    // 如果是文件，先创建文件再写入内容
                    File file = new File(destDirPath + File.separator + entry.getName());
                    // 保证文件的父文件夹必须存在
                    if(!file.getParentFile().exists()) {
                        file.getParentFile().mkdirs();  // 如果不存在则创建
                    }
                    file.createNewFile();   // 创建文件
                    InputStream is = zipFile.getInputStream(entry); // 将压缩文件内容写入到这个文件中
                    BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));    // 将输出文件放到缓冲流
                    int len = 0;
                    byte[] buf = new byte[1024];    // 设置缓冲区
                    while ((len = is.read(buf)) != -1) {
                        bos.write(buf, 0, len);
                    }
                    bos.flush();    // 刷新缓冲
                    // 关闭流
                    IOUtil.closes(bos,is);
                }
            }
            long end = System.currentTimeMillis();
            System.out.println("解压完成, 耗时: " + (end - start) + "毫秒");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭流
            IOUtil.closes(zipFile);
        }

    }


    public static void main(String[] args) {
        // 压缩前的文件
        String srcName = "E:\\Java-project\\JavaBase\\src\\main\\resources";
        // 压缩的文件
        String zipName = "test.zip";
        // 解压后的文件
        String descName = "test";

        ZIPCompressDemo zipCom = new ZIPCompressDemo();
        zipCom.zip(srcName, zipName);   // 压缩

        zipCom.unzip(zipName, descName);    // 解压
    }

}
