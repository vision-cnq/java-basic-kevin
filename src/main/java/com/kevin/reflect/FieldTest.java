package com.kevin.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * @author caonanqing
 * @version 1.0
 * @description     通过反射获取字段
 * @createDate 2019/6/14
 */
public class FieldTest {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {

        // 获取对象
        Class clazz = Class.forName("com.kevin.reflect.Person");

        // 字段名称
        String fieldName = "name";

        FieldTest test = new FieldTest();
        //test.testFields(clazz);                           // 获取所有字段
        //test.testField(clazz,fieldName);                    // 获取指定字段
        test.testGetAndSetField(clazz,fieldName);           // 测试获取字段的值和设置字段的值


    }

    /**
     * 获取字段，方式一：获取所有字段
     * @param clazz
     */
    public void testFields(Class clazz) {

        // 可以获取公用和私有的所有字段，但不能获取父类字段
        Field[] fields = clazz.getDeclaredFields();
        for (Field f : fields) {
            System.out.println(f.getName());
        }
    }

    /**
     * 获取字段，方式二：获取指定字段
     * @param clazz     对象名
     * @param fieldName     需要获取的字段名
     */
    public void testField(Class clazz, String fieldName) throws NoSuchFieldException {

        // 获取指定字段
        Field field = clazz.getDeclaredField(fieldName);
        System.out.println(field.getName());

    }

    /**
     *  测试，获取字段的值与设置字段的值
     * @param clazz
     * @param fieldName
     * @throws NoSuchFieldException
     * @throws NoSuchMethodException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     * @throws InstantiationException
     */
    public void testGetAndSetField(Class clazz, String fieldName) throws NoSuchFieldException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        // 获取指定字段
        Field field = clazz.getDeclaredField(fieldName);
        System.out.println(field.getName());

        // 创建构造器
        Object obj = clazz.newInstance();

        // 设置指定对象的指定字段的值
        field.set(obj,"cao");
        System.out.println(obj);

        // 获取指定对象的指定字段的值
        Object o = field.get(obj);
        System.out.println(field.getName() + " : " + o);

        // 但如果字段是私有，则需要先调用setAccessible（true）
        field = clazz.getDeclaredField("age");
        field.setAccessible(true);
        field.set(obj,23);
        Object o1 = field.get(obj);
        System.out.println(field.getName() + " : " + o1);
    }

}
