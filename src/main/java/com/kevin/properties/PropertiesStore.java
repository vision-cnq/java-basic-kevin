package com.kevin.properties;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author caonanqing
 * @version 1.0
 * @description        将数据写入配置文件
 *
 *
 * Properties类补充其属于Hashtable的子类
 *
 * 1.Java中的properties文件是一种配置文件，主要用于表达配置信息，文件类型为*.properties，格式为文本文件，文件中的格式是“键=值”的格式，在properties文件中可以用#来注释。
 * 2.Properties中的重要方法
 * （1）getProperty(String key),用于指定的键在此列属性表中搜索属性，也就是通过该参数key,得到对应的value值
 * （2）load(inputStream inStream)从输入流中读取属性列表（键和元素对），通过对指定的文件进行装载来获取该文件中的所有键值对，以供getProperty(String key)方法来搜索
 * （3）setProperty(String key,String value)调用Hashtable的方法put方法，他通过调用基类的put方法来设置键值对
 * （4）store（OutputStream out,String comments）以适合使用load方法加载到Properties表中的格式，将此Properties表中的属性列表（键值元素对）写入输入流，与load方法相反,该方法将键值对写入到指定文件中去
 * （5）clear(),清除所有转载的键值对，该方法是在基类中提供
 * @createDate 2019/5/24
 */
public class PropertiesStore {

    public static void main(String[] args) {
        File file = new File("F:" + File.separator + "myinfo.properties");
        setProperties(file);
    }

    /**
     * 将数据写入配置文件
     * @param file
     */
    private static void setProperties(File file) {

        Properties pro = new Properties();  // 设置配置文件属性
        pro.setProperty("mode","OPEN");
        pro.setProperty("isVIP","no");
        pro.setProperty("upDateTime","20190524");

        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file);   // 输出字节流
            pro.store(fos,"this is my default information");    // 将配置文件属性写出
            System.out.println("写入配置文件成功");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();    // 关闭流
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


}
