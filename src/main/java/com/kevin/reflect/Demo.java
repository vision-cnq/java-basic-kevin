package com.kevin.reflect;

/**
 * @author caonanqing
 * @version 1.0
 * @description     反射
 * @createDate 2019/6/6
 */
public class Demo {

    /**
     *
     *      反射：反射机制允许程序在执行期借助于Reflection API取得任何类的内部信息，并能直接操作任意对象的内部属性及方法。
     *          反射机制提供的功能：
     *              1.在运行时构造任意一个类的对象
     *              2.在运行时获取任意一个类所具有的成员变量和方法
     *              3.在运行时调用任意一个对象的方法（属性）
     *              4.生成动态代理
     *
     *      反射就是在运行时才知道要操作的类是什么，并且可以在运行时获取类的完整构造，并调用对应的方法。
     *
     *      一.理解Class类
     *          JRE 都为其保留一个不变的 Class 类型的对象。一个 Class 对象包含了特定某个类的有关信息。
     *          Class对象只能由系统建立对象
     *          一个类在JVM中只会有一个Class实例
     *          每个类的实例都会记得自己是由哪个Class实例所生成
     *              a.class是一个类，封装了当前对象所对应的类信息
     *              b.对于每个类而言，JRE都会其保留一个不变的Class类型的对象，一个Class对象包含了特定某个类的有关信息
     *              c.Class对象只能由系统建立对象，一个类在JVM只会有一个Class实例
     *          获得Class对象的三种方式
     *              1.通过类名获取    类名.class
     *              2.通过对象获取    对象名.getClass()
     *              3.通过全类名获取   Class.forName(全类名)
     *
     *      二.ClassLoader
     *          类装载器是用来把类class装载进JVM，JVM规范定义了两个类型的类装载器，
     *          启动类装载器（bootstrap）和用户自定义装载器（user-defined class loader）。
     *          JVM在运行时会产生3个类加载器组成的初始化加载器层次结构。
     *              按顺序尝试加载类：1.Bootstap Classloader，2.Extension Classloader。3.System Classloader
     *              按顺序检查类是否已装载：1.System Classloader，2.Extension Classloader。3.Bootstap Classloader
     *
     *       1. Class: 是一个类; 一个描述类的类.
     *          封装了描述方法的 Method,
     *          描述字段的 Filed,
     *          描述构造器的 Constructor 等属性.
     *       2. 如何得到 Class 对象:
     *   　　   2.1 Person.class
     *   　　   2.2 person.getClass()
     *   　　   2.3 Class.forName("com.atguigu.javase.Person")
     *       3. 关于 Method:
     *   　　   3.1 如何获取 Method:
     *   　　　　1). getDeclaredMethods: 得到 Method 的数组.
     *   　　　　2). getDeclaredMethod(String methondName, Class ... parameterTypes)
     *   　　   3.2 如何调用 Method
     *   　　　　1). 如果方法时 private 修饰的, 需要先调用 Method 的　setAccessible(true), 使其变为可访问
     *   　　　　2). method.invoke(obj, Object ... args);
     *       4. 关于 Field:
     *   　　   4.1 如何获取 Field: getField(String fieldName)
     *   　　   4.2 如何获取 Field 的值:
     *   　　　　1). setAccessible(true)
     *   　　　　2). field.get(Object obj)
     *   　　   4.3 如何设置 Field 的值:
     *   　　　　field.set(Obejct obj, Object val)
     *       5. 了解 Constructor 和 Annotation
     *
     */
}
