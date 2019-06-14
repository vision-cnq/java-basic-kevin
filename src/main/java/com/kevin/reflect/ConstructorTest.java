package com.kevin.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author caonanqing
 * @version 1.0
 * @description     通过反射获取构造器
 * @createDate 2019/6/11
 */
public class ConstructorTest {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException {
        // 获取Class对象
        Class clazz = Class.forName("com.kevin.reflect.Person");
        // 参数值
        String name = "kevin";
        Integer age = 23;

        ConstructorTest test = new ConstructorTest();
        test.testNewInstance(clazz);                                    // 通过反射获取并创建构造器
        test.testConstructors(clazz);                                   // 获取所有构造器
        test.testConstructor(clazz, String.class, Integer.class);       // 获取指定构造器
        test.testNewConstructor(clazz, name, age);                      // 通过实例和参数值创建构造器

    }

    /**
     *  通过反射获取并创建构造器
     * @param clazz     实例
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     */
    public void testNewInstance(Class clazz) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

        // 创建无参构造器，利用Class对象的newInstance方法创建一个类的实例
        Object obj = clazz.newInstance();
        System.out.println(obj);

        // 获取有参构造器，调用getConstructor获取指定的有参构造器
        Constructor c = clazz.getConstructor(String.class, Integer.class);

        // 创建有参构造器
        Person person = (Person)c.newInstance("kevin", 23);
        System.out.println(person.toString());

    }


    /**
     *      获取所有的构造器
     * @param clazz     实例
     */
    public void testConstructors(Class clazz){

        // 获取所有构造器
        Constructor[] constructors = clazz.getConstructors();
        // 遍历构造器
        for (Constructor c : constructors) {
            System.out.println(c);
        }
    }

    /**
     *      获取指定构造器
     * @param clazz     实例
     * @param parameterTypes    参数类型
     */
    public void testConstructor(Class clazz, Class ... parameterTypes) throws NoSuchMethodException {

        Constructor constructor = clazz.getConstructor(parameterTypes);
        System.out.println(constructor);

    }

    /**
     *  通过实例和参数值创建构造器
     * @param clazz     实例
     * @param args      参数值
     * @throws NoSuchMethodException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     * @throws InstantiationException
     */
    public void testNewConstructor(Class clazz, Object ... args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        // 因为getMethod的参数为Class列表类型，所以要把参数args转化为对应的Class类型
        Class[] parameterType = new Class[args.length];
        for (int i = 0; i < args.length; i++) {
            parameterType[i] = args[i].getClass();  // 获取数据的类型
        }
        // 获取构造器
        Constructor constructor = clazz.getConstructor(parameterType);
        // 创建构造器
        Object o = constructor.newInstance(args);

        System.out.println(o);
    }


}
