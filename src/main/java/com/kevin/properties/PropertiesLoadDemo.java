package com.kevin.properties;

import java.io.*;
import java.util.Properties;

/**
 * @author caonanqing
 * @version 1.0
 * @description     读取配置文件中的数据
 * @createDate 2019/5/24
 */
public class PropertiesLoadDemo {

    public static void main(String[] args) {
        File file = new File("F:" + File.separator + "myinfo.properties");
        loadProperties(file);
    }

    /**
     * 读取配置文件中的数据
     * @param file
     */
    private static void loadProperties(File file) {

        Properties pro = new Properties();
        InputStream fis = null;
        try {
            fis = new FileInputStream(file);    // 使用字节流读取文件
            pro.load(fis);      // 从字节流中读取数据加载到Properties
            String isVIP = pro.getProperty("isVIP");
            String upDateTime = pro.getProperty("upDateTime");
            String mode = pro.getProperty("mode");
            System.out.println("isVIP: "+isVIP+", upDateTime: "+upDateTime+", mode: "+mode);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();    // 关闭输入流
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
