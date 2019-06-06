package com.kevin.genericity;

/**
 * @author caonanqing
 * @version 1.0
 * @description     测试最简单的泛型类和泛型方法的定义
 * @createDate 2019/6/6
 */
public class GenericityDemo1 {

    public static void main(String[] args) {

        Box<String> box = new Box<>("kevin");
        System.out.println("name: " + box.getData());

        // 那么对于不同传入的类型实参，生成的相应对象实例的类型是不是一样的呢？
        Box<String> str = new Box<>("kevin");
        Box<Integer> inte = new Box<>(23);
        System.out.println("str: " + str.getData());
        System.out.println("inte: " + inte.getData());
        System.out.println("对象实例类型是否一致: " + (str.getClass() == inte.getClass()));
        // 成功编译过后的class文件中是不包含任何泛型信息的。泛型信息不会进入到运行时阶段。
    }
}