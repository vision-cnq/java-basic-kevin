package com.kevin.enumeration;

/**
 * @author caonanqing
 * @version 1.0
 * @description     枚举类
 * @createDate 2019/6/3
 */
public enum Demo {

    /**
     *
     *  枚举类是一个被命名的整型常数的集合，用于声明一组带标识符的常数
     *      枚举在日常生活中很常见，例如一个人的性别只能是“男”或者“女”，
     *      一周的星期只能是 7 天中的一个等。类似这种当一个变量有几种固定可能的取值时，就可以将它定义为枚举类型。
     *
     *  任意两个枚举成员不能具有相同的名称，且它的常数值必须在该枚举的基础类型的范围之内，多个枚举成员之间使用逗号分隔。
     *
     *  注：如果没有显式地声明基础类型的枚举，那么意味它所对应的的基础类型是int
     *
     *  枚举类型符合通用模式 Class Enum<E extends Enum<E>>，而 E 表示枚举类型的名称。
     *  枚举类型的每一个值都将映射到 protected Enum(String name, int ordinal) 构造函数中，
     *  在这里，每个值的名称都被转换成一个字符串，并且序数设置表示了此设置被创建的顺序。
     *
     *  实际上 enum 就是一个 class，只不过 java 编译器帮我们做了语法的解析和编译而已。
     *
     * 可以把 enum 看成是一个普通的 class，它们都可以定义一些属性和方法，不同之处是：enum 不能使用 extends 关键字继承其他类，
     * 因为 enum 已经继承了 java.lang.Enum（java是单一继承）。
     *
     */

}
