package com.kevin.reflect;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author caonanqing
 * @version 1.0
 * @description     测试获取类加载器
 * @createDate 2019/6/11
 */
public class ClassLoaderTest {

    public static void main(String[] args) throws ClassNotFoundException {

        ClassLoaderTest classLoader = new ClassLoaderTest();
        classLoader.testClassLoader();
        classLoader.testGetResourceAsStream();
    }

    // 测试类加载器
    public void testClassLoader() throws ClassNotFoundException {

        // 1.获取一个系统的类加载器（可以获取，当前这个类PeflectionTest2就是它加载的）
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        System.out.println(classLoader);

        // 2.获取系统类加载器的父类加载器（扩展类加载器，可以获取）
        classLoader = classLoader.getParent();
        System.out.println(classLoader);

        // 3.获取扩展类加载器的父类加载器（引导类加载器，不可获取）
        classLoader = classLoader.getParent();
        System.out.println(classLoader);

        // 4.测试当前类由哪个类加载器进行加载（系统加载器）
        classLoader = Class.forName("com.kevin.reflect.ClassNameTest").getClassLoader();
        System.out.println(classLoader);

        // 5.测试JDK提供的Object类由哪个类加载器负责加载（引导类）
        classLoader = Class.forName("java.lang.Object").getClassLoader();
        System.out.println(classLoader);

    }

    /**
     * 使用类加载器获取当前类目录下的文件
     * 首先，系统类加载器可以加载当前项目src目录下面的所有类，如果文件也放在src下面，也可以用类加载器来加载
     * 调用 getResourceAsStream 获取类路径下的文件对应的输入流.
     */
    public void testGetResourceAsStream() {

        // src目录下，直接加载
        InputStream test = this.getClass().getClassLoader().getResourceAsStream("test.txt");

        // 放在内部文件夹，要写全路径
        InputStream readme = this.getClass().getClassLoader().getResourceAsStream("E:\\Java-project\\JavaBase\\README.md");

    }

}
