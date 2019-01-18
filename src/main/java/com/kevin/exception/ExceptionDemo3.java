package com.kevin.exception;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author kevin
 * @version 1.0
 * @description     使用throws声明异常
 * @createDate 2018/12/24
 */
public class ExceptionDemo3 {

    public static void main(String[] args) throws IOException {
        readMyFile();
    }

    public static void readMyFile() throws IOException {

        FileReader reader = null;
        reader = new FileReader("C:\\Users\\kevin\\Desktop\\Test02.java");
        System.out.println("step1");
        char read = (char) reader.read(); //只读取第一个字符
        System.out.println(read);
        if(reader != null){
            reader.close();
        }

    }
}
