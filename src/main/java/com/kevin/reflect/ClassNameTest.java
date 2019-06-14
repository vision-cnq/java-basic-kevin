package com.kevin.reflect;


/**
 * @author caonanqing
 * @version 1.0
 * @description     测试
 *      为什么需要反射？
 *          1.该对象可能是别人传过来的。
 *          2.没有对象，只有一个全类名。
 *      通过反射，可以得到这个类里面的信息
 *
 *      获得Class对象的三种方式
 *          1.通过类名获取    类名.class
 *          2.通过对象名获取    对象名.getClass()
 *          3.通过全类名获取   Class.forName(全类名)
 * @createDate 2019/6/6
 */
public class ClassNameTest {

    public static void main(String[] args) throws ClassNotFoundException {

        ClassNameTest test = new ClassNameTest();
        test.className();
        test.objectName();
        test.allClassName();
        System.out.println();
    }

    // 1.通过类名获取Class对象    类名.class
    public void className(){

        // 通过Class类获取类对象
        Class clazz = Person.class;
        // 返回所有字段的数组
        // Field[] fields = clazz.getDeclaredFields();

    }

    // 2.通过对象名获取Class对象    对象名.getClass()   这种方式是用在传进来一个对象，却不知道对象类型的时候使用
    public void objectName(){

        // 通过对象名获取Class对象
        Person person = new Person();
        Class clazz = person.getClass();
        //上面这个例子的意义不大，因为已经知道person类型是Person类，再这样写就没有必要了

        //如果传进来是一个Object类，这种做法就是应该的
        Person objPerson = new Person();
        Class objClazz = objPerson.getClass();

    }

    // 3.通过全类名获取Class对象   Class.forName(全类名)    一般框架开发中这种用的比较多，因为配置文件中一般配的都是全类名，通过这种方式可以得到Class实例
    public void allClassName() throws ClassNotFoundException {

        // 通过全类名获取Class对象
        Class clazz = Class.forName("com.kevin.reflect.Person");

    }
}
