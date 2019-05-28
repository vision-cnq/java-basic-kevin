package com.kevin.io.bio;

import java.io.*;

/**
 * @author caonanqing
 * @version 1.0
 * @description     拷贝文件
 * @createDate 2019/5/24
 */
public class CopyFileDemo {

    public static void main(String[] args) {

        File src = new File("F:" + File.separator + "test.csv");
        File dest = new File("F:" + File.separator + "test_out.csv");
        //copyByFile1(src,dest);  //拷贝文件，方式一：无缓冲读写文件
        copyByFile2(src,dest,2048);  //拷贝文件，方式二：自定义数组做缓冲读写文件
        copyByFile3(src,dest);  //拷贝文件，方式三：使用Buffered类使用默认大小缓冲来读写文件,默认是8192字节
        copyByFile4(src,dest,8192*2);  //拷贝文件，方式四：使用Buffered类自定义大小缓冲来读写文件
    }

    /**
     * 拷贝文件，方式一：无缓冲读写文件
     * @param src   拷贝的文件
     * @param dest  拷贝的路径
     */
    private static void copyByFile1(File src,File dest){

        long start = System.currentTimeMillis();
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(src);
            fos = new FileOutputStream(dest);
            int b = 0;
            while((b = fis.read()) != -1){
                fos.write(b);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtil.closes(fos,fis);
            /*try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }*/
        }
        System.out.println("使用FileOutputStream拷贝大小"+src.length()+"的文件未使用缓冲数组耗时："+(System.currentTimeMillis()-start)+"毫秒");
    }

    /**
     * 拷贝文件，方式二：自定义数组做缓冲读写文件
     * @param src   拷贝的文件
     * @param dest  拷贝的路径
     */
    private static void copyByFile2(File src,File dest,int size){

        long start = System.currentTimeMillis();
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(src);
            fos = new FileOutputStream(dest);
            int b = 0;
            byte[] buff = new byte[size];   // 定义一个缓冲数组
            // 读取一定量的数据（read返回值表示这次读了多少个数据）放入数组中
            while ((b = fis.read(buff)) != -1){
                // 一次将读入到数组中的有效数据（索引[0,b]范围的数据）写入输出流中
                fos.write(buff,0,b);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            IOUtil.closes(fos,fis);
        }
        System.out.println("使用FileOutputStream拷贝大小"+src.length()+"的文件使用了缓冲数组耗时："+(System.currentTimeMillis()-start)+"毫秒");
    }

    /**
     * 拷贝文件，方式三：使用Buffere类使用默认大小缓冲来读写文件
     * @param src   拷贝的文件
     * @param dest  拷贝的路径
     */
    private static void copyByFile3(File src,File dest){

        long start = System.currentTimeMillis();
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            bis = new BufferedInputStream(new FileInputStream(src));
            bos = new BufferedOutputStream(new FileOutputStream(dest));

            int b = 0;
            // 读取一定量的数据（read返回值表示这次读了多少个数据）放入数组中
            while ((b = bis.read()) != -1){
                // 使用Buffered重写的write方法进行写入数据。该方法看似未缓冲实际做了缓冲处理
                bos.write(b);
            }
            bos.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            IOUtil.closes(bos,bis);
            /*try {
                bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }*/
        }
        System.out.println("使用Buffered拷贝大小"+src.length()+"的文件使用了缓冲数组耗时："+(System.currentTimeMillis()-start)+"毫秒");

    }

    /**
     * 拷贝文件，方式四：使用Buffered类自定义大小缓冲来读写文件
     * @param src   拷贝的文件
     * @param dest  拷贝的路径
     */
    private static void copyByFile4(File src,File dest,int size){

        long start = System.currentTimeMillis();
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            bis = new BufferedInputStream(new FileInputStream(src));
            bos = new BufferedOutputStream(new FileOutputStream(dest));

            int b = 0;
            byte[] buff = new byte[size];
            // 读取一定量的数据（read返回值表示这次读了多少个数据）放入数组中
            while ((b = bis.read(buff)) != -1){
                // 使用Buffered重写的write方法进行写入数据。该方法看似未缓冲实际做了缓冲处理
                bos.write(buff,0,b);
            }
            bos.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            IOUtil.closes(bos,bis);
        }
        System.out.println("使用Buffered拷贝大小"+src.length()+"的文件使用了缓冲数组耗时："+(System.currentTimeMillis()-start)+"毫秒");

    }


}
