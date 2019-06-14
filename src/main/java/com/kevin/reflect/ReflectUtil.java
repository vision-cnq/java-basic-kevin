package com.kevin.reflect;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author caonanqing
 * @version 1.0
 * @description     反射的工具类
 *      这种反射实现的主要功能是可配置和低耦合。
 *          只需要类名和方法名，而不需要一个类对象就可以执行一个方法，如果我们把全类名和方法名放在一个配置文件中，
 *          便可以根据配置文件的类名和方法名来调用方法。
 *
 * @createDate 2019/6/12
 */
public class ReflectUtil {

    // 设置调用方法
    @Test
    public void testInvoke() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {

        Object obj = new Person();
        // 把类对象和类方法名作为参数，执行方法
        invoke(obj, "setName", "kevin");//对象名，方法名，方法参数

        // 全类名和方法名作为参数，执行方法
        invoke("com.kevin.reflect.Person", "setName", "kevin"); //对象名，方法名，方法参数

        // 把对象和方法名作为参数，执行方法（包括私有类）
        invoke2(obj, "testMethod", "kevin");
    }

    // 测试获取字段的值和设置字段的值，包括私有和父类的字段
    @Test
    public void testClassField() throws Exception{

        //字段名    可能为私有, 可能在其父类中.
        String fieldName = "age";
        // 字段值
        Object val = 20;

        Object obj = null;
        //1.创建className 对应类的对象
        Class clazz = Class.forName("com.kevin.reflect.Person");
        //2.创建fieldName 对象字段的对象
        Field field = getField(clazz, fieldName);
        //3.为此对象赋值
        obj = clazz.newInstance();
        setFieldValue(obj, field, val);
        //4.获取此对象的值
        Object value = getFieldValue(obj,field);
        System.out.println(value);
    }



    /**
     *      把类对象和类方法名作为参数，执行方法
     * @param obj   方法执行的对象
     * @param methodName    类的一个方法的方法名，该方法也可能是私有方法
     * @param args      调用该方法需要传入的参数
     * @return      调用方法后的返回值
     */
    public Object invoke(Object obj, String methodName, Object ... args) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {

        // 获取Method对象
        // 因为getMethod的参数为Class列表类型，所以要把参数args转化为对应的Class类型
        Class[] parameterType = new Class[args.length];
        for (int i = 0; i < args.length; i++) {
            parameterType[i] = args[i].getClass();
            System.out.println(parameterType);
        }

        // 如果使用getDeclaredMethod，就不能获取父类方法，如果使用getMethod，就不能获取私有方法
        Method method = obj.getClass().getDeclaredMethod(methodName, parameterType);
        return method.invoke(obj,args);
    }

    /**
     *      把全类名和方法名作为参数，执行方法
     * @param className     某个类的全类名
     * @param methodName    类的一个方法的方法名，该方法也可能是私有方法
     * @param args      调用该方法需要传入的参数
     * @return  调用方法后的返回值
     */
    public Object invoke(String className, String methodName, Object ... args) {

        Object obj = null;
        try {
            obj = Class.forName(className).newInstance();
            // 调用上一个方法
            return invoke(obj, methodName, args);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     *  把对象和方法名作为参数，执行方法（包括私有类）
     * @param obj       某个类的一个对象
     * @param methodName    类的一个方法名，该方法名可能是私有类，也可能是父类的私有类
     * @param args     调用方法时传入的参数
     * @return      调用方法后的返回值
     */
    public Object invoke2(Object obj, String methodName, Object ... args) {
        MethodTest m = new MethodTest();

        // 获取 Method 对象
        Class [] parameterTypes = new Class[args.length];
        for(int i = 0; i < args.length; i++){
            parameterTypes[i] = args[i].getClass();
        }
        try {
            Method method = m.getPrivateMethod(obj.getClass(), methodName, parameterTypes);
            method.setAccessible(true);
            // 执行 Method 方法并返回方法的返回值
            return method.invoke(obj, args);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取字段的值
     * @param obj   对象
     * @param field     字段
     * @return
     * @throws IllegalAccessException
     */
    public Object getFieldValue(Object obj, Field field) throws IllegalAccessException {

        field.setAccessible(true);
        return field.get(obj);
    }

    /**
     *  设置字段的值
     * @param obj   对象
     * @param field     字段
     * @param val   需要设置的字段值
     * @throws IllegalAccessException
     */
    public void setFieldValue(Object obj, Field field, Object val) throws IllegalAccessException {

        field.setAccessible(true);
        field.set(obj,val);
    }

    /**
     *  获取字段，包括父类
     * @param clazz     实例
     * @param fieldName     需要获取的字段名
     * @return
     * @throws NoSuchFieldException
     */
    public Field getField(Class clazz, String fieldName) throws NoSuchFieldException {

        Field field = null;
        for (Class clazz2 = clazz; clazz2 != Object.class; clazz2 = clazz2.getSuperclass()) {
            field = clazz2.getDeclaredField(fieldName);
        }
        return field;
    }


}
