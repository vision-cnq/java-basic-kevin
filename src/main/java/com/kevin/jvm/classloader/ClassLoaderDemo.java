package com.kevin.jvm.classloader;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author caonanqing
 * @version 1.0
 * @description     测试自定义类加载器
 *      1.定义一个类，继承ClassLoader
 *      2.重写loadClass方法
 *      3.实例化Class对象
 * @createDate 2019/8/2
 */
public class ClassLoaderDemo {

    public static void main(String[] args) throws Exception {

        // 自定义类加载器
        ClassLoader mycl = new ClassLoader() {

            /**
             *  加载当前包下的所有类，其他的类委派父类加载器
             * @param name  类的全限定名
             * @return
             * @throws ClassNotFoundException   找不到类的时候会抛出这个异常
             */
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                // com.kevin.jvm.classloader.ClassLoaderDemo
                String filename = name.substring(name.lastIndexOf(".") + 1) + ".class";
                InputStream ins = getClass().getResourceAsStream(filename); // 加载
                if(ins == null) {   // 没有找到，让父类加载器来加载
                    return super.loadClass(name);
                }
                try {
                    byte[] buff = new byte[ins.available()];
                    ins.read(buff);
                    return defineClass(name,buff,0,buff.length);
                } catch (IOException e) {
                    throw new ClassNotFoundException();
                }
            }
        };
        // 有main方法的类，被会应用程序加载器加载一次，加上我们自定义的加载器，所以会被加载两次
        Object c = mycl.loadClass("com.kevin.jvm.classloader.ClassLoaderDemo").newInstance();
        System.out.println(c.getClass());
        // 其实c是被应用程序加载类所加载的，所以他们并不是被同一个类加载器加载的、
        System.out.println(c instanceof ClassLoaderDemo);

    }
}
