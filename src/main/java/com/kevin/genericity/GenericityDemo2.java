package com.kevin.genericity;

/**
 * @author caonanqing
 * @version 1.0
 * @description         类型通配符
 *      Box<number>和Box<Integer>实际上都是Box类型，现在需要继续探讨一个问题，那么在逻辑上，
 *      类似于Box<Number>和Box<Integer>是否可以看成具有父子关系的泛型类型呢？
 * @createDate 2019/6/6
 */
public class GenericityDemo2 {

    public static void main(String[] args) {

        Box<Number> num = new Box<>(88);
        Box<Integer> inte = new Box<>(800);
        Box<String> str = new Box<>("kevin");

        getData(num);
        // getData(inte);  // 没有使用泛型通配符，错误提示，Box<Number>，不能视为Box<Integer>的父类

        // 使用通配符任何类型都可以传递使用
        getDataWildcard(num);
        getDataWildcard(num);
        getDataWildcard(inte);
        getDataWildcard(str);

        // 使用通配符上限，设置只能是Number和Number的子类
        getUpperNumberDataWildcard(num);
        getUpperNumberDataWildcard(inte);
        // getUpperNumberDataWildcard(str);    //  错误提示：String类型不是Number的子类


    }

    // 没有使用泛型通配符
    public static void getData(Box<Number> data) {
        System.out.println("data: " + data.getData());
    }

    // 使用泛型通配符
    public static void getDataWildcard(Box<?> data) {
        System.out.println("data: " + data.getData());
    }

    // 使用泛型通配符上限
    public static void getUpperNumberDataWildcard(Box<? extends Number> data) {
        System.out.println("data: " + data.getData());
    }

    //在泛型方法中添加上下边界限制的时候，必须在权限声明与返回值之间的<T>上添加上下边界，即在泛型声明的时候添加
    //public <T> T showKeyName(Generic<T extends Number> container)，编译器会报错："Unexpected bound"
    public <T extends Number> T showKeyName(Generic<T> container){
        System.out.println("container key :" + container.getKey());
        T test = container.getKey();
        return test;
    }

}
