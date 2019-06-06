package com.kevin.genericity;

/**
 * @author caonanqing
 * @version 1.0
 * @description     泛型
 * @createDate 2019/6/3
 */
public class Demo {

    /**
     *  1.概念：
     *      泛型：参数化类型。就是将类型由原来的具体的类型参数化，类似于方法中的变量参数，
     *          此时类型也定义成参数形式（可以称之为类型形参），然后在使用/调用时传入具体的类型（类型实参）。
     *
     *  2.特性：
     *      泛型类型在逻辑上看以看成是多个不同的类型，实际上都是相同的基本类型。
     *
     *  3.泛型的使用：
     *      泛型分为：泛型接口，泛型类，泛型方法。
     *      在泛型接口、泛型类和泛型方法的定义过程中，我们常见的如T、E、K、V等形式的参数常用于表示泛型形参，
     *            由于接收来自外部使用时候传入的类型实参。成功编译过后的class文件中是不包含任何泛型信息的。泛型信息不会进入到运行时阶段。
     *      泛型的类型参数只能是类类型（包括自定义类），不能是简单类型
     *
     *      泛型接口：例如 public interface GenericityInter<T> { }
     *      泛型类：例如：public class Box<T> { }
     *      泛型方法：例如：
     *          参数类型：public Box(T data) {this.data = data;}
     *          返回值类型：public T getData(){return data;}或者public <T> T showKeyName(Generic<T> container){}
     *          泛型方法与可变参数：public <T> void printMsg( T... args){ for(T t : args){ }}
     *          静态方法与泛型：public static <T> void show(T t){ }
     *          静态方法有一种情况需要注意一下，那就是在类中的静态方法使用泛型：静态方法无法访问类上定义的泛型；如果静态方法操作的引用数据类型不确定的时候，必须要将泛型定义在方法上。
     *              即：如果静态方法要使用泛型的话，必须将静态方法也定义成泛型方法。
     *
     *      泛型方法能使方法独立于类而产生变化，以下是一个基本的指导原则：
     *          无论何时，如果你能做到，你就该尽量使用泛型方法。也就是说，如果使用泛型方法将整个类泛型化，
     *              那么就应该使用泛型方法。另外对于一个static的方法而已，无法访问泛型类型的参数。所以如果static方法要使用泛型能力，就必须使其成为泛型方法。
     *
     *      类型通配符：类型通配符一般是使用 ? 代替具体的类型实参。注意了，此处是类型实参，而不是类型形参！
     *          例如：public static void getDataWildcard(Box<?> data) {System.out.println("data: " + data.getData());}
     *
     *      泛型的上限和下限添加，必须与泛型的声明在一起：
     *      类型通配符上限通过形如Box<? extends Number>形式定义：只能使用上限类及其子类
     *          例如：public static void getUpperNumberDataWildcard(Box<? extends Number> data) {System.out.println("data: " + data.getData());}
     *      类型通配符下限为Box<? super Number>形式定义：只能使用下限类及其父类
     *          例如：public static void getUpperNumberDataWildcard(Box<? super Interger> data) {System.out.println("data: " + data.getData());}
     *
     *      泛型数组：不能创建一个确切的泛型类型的数组。
     *          错误例子：List<String>[] ls = new ArrayList<String>[10];
     *          正常创建例子：List<String>[] ls = new ArrayList[10];
     *          使用通配符创建泛型数组：List<?>[] ls = new ArrayList<?>[10];
     *      数组的类型不可以是类型变量，除非是采用通配符的方式，因为对于通配符的方式，最后取出数据是要做显式的类型转换的。
     *
     */
}
