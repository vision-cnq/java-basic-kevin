package com.kevin.exception;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author kevin
 * @version 1.0
 * @description     使用try-catch处理异常
 * @createDate 2018/12/24
 */
public class ExceptionDemo2 {

    public static void main(String[] args) {
        readMyFile();
    }

    public static void readMyFile(){

        FileReader reader = null;
        try {
            reader = new FileReader("C:\\Users\\kevin\\Desktop\\Test02.java");
            System.out.println("step1");
            char read = (char) reader.read(); //只读取第一个字符
            System.out.println(read);
        } catch (FileNotFoundException e) {
            System.out.println("step2");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("step3");
            try {
                if(reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
