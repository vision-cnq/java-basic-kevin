package com.kevin.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author caonanqing
 * @version 1.0
 * @description     通过反射获取方法
 * @createDate 2019/6/11
 */
public class MethodTest {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException {

        // 获取对象
        Class clazz = Class.forName("com.kevin.reflect.Person");
        // 方法名
        String methodName = "testMethod";   //testMethod ，setName

        MethodTest test = new MethodTest();
        test.thisMethod(clazz);                                     // 获取本类所有方法（私有除外），包括继承父类的方法
        test.thisAndSupperMethod(clazz);                            // 只能获取本类所有的方法，包括私有
        test.assignMethod(clazz,methodName,String.class);           // 获取指定方法
        test.getPrivateMethod(clazz, methodName, String.class);     // 获取所有方法，包括私有共有，包括父类私有
    }

    // 获取方法，方式一：获取对应类的所有方法，不包括private方法，也能获取到父类继承来的所有方法
    public void thisMethod(Class clazz) {

        // 获取对应类的所有方法，不包括private方法，也能获取到父类继承来的所有方法
        Method[] methods = clazz.getMethods();
        // 遍历所有方法
        for (Method method : methods) {
            System.out.println(method.getName()); // 获取名称
        }

    }

    // 获取方法，方式二：获取对应类的所有方法，包括private方法，只能获取当前类的方法
    public void thisAndSupperMethod(Class clazz) {

        // 获取对应类的所有方法，包括private方法，只能获取当前类的方法
        Method[] methods = clazz.getDeclaredMethods();
        // 遍历所有方法
        for (Method method : methods) {
            System.out.println(method.getName()); // 获取名称
        }

    }

    // 获取方法，方式三：获取指定的方法，需要参数名称和参数列表，无参则不需要写
    public void assignMethod(Class clazz, String methodName, Class ... parameterTypes) throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {

        // 创建无参构造器
        Object obj = clazz.newInstance();

        // 获取指定的方法，需要参数名称和参数列表，无参则不需要写
        Method method = clazz.getDeclaredMethod(methodName, parameterTypes);
        System.out.println(method);

        // 执行方法，invoke第一个参数表示执行哪个对象的方法，剩下的参数是执行方法时需要传入的参数
        // method.setAccessible(true);  // 如果是私有方法，需要打破封装
        method.invoke(obj,"kevin");

        System.out.println(obj.toString());
    }

    // 获取方法，方式四：获取父类定义的private方法和本类定义的private方法，当然也可以获取共有方法
    public Method getPrivateMethod(Class clazz, String methodName, Class ... parameterTypes) {

        // 获取 clazz 的 methodName 方法. 该方法可能是私有方法, 还可能在父类中(私有方法)
        // 如果在该类中找不到此方法，就向他的父类找，一直到Object类为止
        // 这个方法的作用是根据一个类名，一个方法名，追踪到并获取此方法
        for (; clazz != Object.class; clazz = clazz.getSuperclass()) {
            Method method = null;
            try {
                method = clazz.getDeclaredMethod(methodName, parameterTypes);
                System.out.println(method);
                return method;
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
        return null;
    }



}
