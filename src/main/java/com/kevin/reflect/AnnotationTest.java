package com.kevin.reflect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author caonanqing
 * @version 1.0
 * @description     通过反射获取注解
 *  　　如果在程序中要获取注解，然后获取注解的值进而判断我们赋值是否合法，那么类对象的创建和方法的创建必须是通过反射而来的
 * @createDate 2019/6/14
 */
public class AnnotationTest {

    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        // 获取实例
        Class clazz = Class.forName("com.kevin.reflect.Person");
        String methodName = "setAge";
        Integer val = 21;

        AnnotationTest test = new AnnotationTest();
        test.testAnnotation(clazz, methodName, val);

        // 直接给对象赋值的时候，是感觉不到注解的存在
        Person person = new Person();
        person.setAge(10);

    }

    /**
     *      测试自定义的注解，在setAge方法上限制age的范围
     * @param clazz     实例
     * @param methodName    方法名
     * @param val   参数值
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     */
    public void testAnnotation(Class clazz, String methodName, Integer val) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

        // 创建构造器
        Object obj = clazz.newInstance();

        // 获取方法
        Method method = clazz.getDeclaredMethod(methodName, Integer.class);

        // 获取指定名称的注解
        AgeValidator annotation = method.getAnnotation(AgeValidator.class);
        if(annotation != null) {
            if(annotation instanceof AgeValidator) {    //
                AgeValidator ageValidator = (AgeValidator)annotation;
                if(val < ageValidator.min() || val > ageValidator.max()) {
                    throw  new RuntimeException("Age is illegal");
                }
            }
        }
        method.invoke(obj,val);
        System.out.println(obj);
    }

}


// 定义一个注解
@Retention(RetentionPolicy.RUNTIME)
@Target(value = {ElementType.METHOD})   // 限制该注解只能在方法上使用
@interface AgeValidator {
    public int min();
    public int max();
}
