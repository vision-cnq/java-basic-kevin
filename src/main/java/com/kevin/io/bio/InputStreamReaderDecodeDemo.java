package com.kevin.io.bio;

import java.io.*;

/**
 * @author caonanqing
 * @version 1.0
 * @description     指定InputStreamReader的编码
 * @createDate 2019/5/24
 */
public class InputStreamReaderDecodeDemo {

    public static void main(String[] args) {
        File file = new File("F:" + File.separator + "Test.txt");

        inputStreamReaderDecode(file);    // InputStreamReader转换流，将输入的字节流转换成字符流
    }

    /**
     * InputStreamReader转换流，指定编码并将输入的字节流转换成字符流
     * @param file
     */
    private static void inputStreamReaderDecode(File file) {
        FileInputStream fis = null;
        InputStreamReader isr = null;
        try {
            fis = new FileInputStream(file);    // 创建字节流
            isr = new InputStreamReader(fis, "utf-8");    // 指定编码并转换成字符流
            char[] c = new char[1024];
            int len = 0;
            while((len = isr.read(c)) != -1){       // 每次读取1024个字节
                String str = new String(c, 0, len);
                System.out.println(str);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                isr.close();    // 关闭转换流
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fis.close();    // 关闭流
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


}
