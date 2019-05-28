package com.kevin.io.file;

import java.io.File;
import java.io.IOException;

/**
 * @author caonanqing
 * @version 1.0
 * @description
 * @createDate 2019/5/24
 */
public class FileMedthDemo {

    public static void main(String[] args) {
        File f = new File("F:" + File.separator + "test01");
        if(f.exists()) {
            f.delete();
            System.out.println("文件已删除");
        } else {
            try {
                f.createNewFile();
                System.out.println("文件已创建成功");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
