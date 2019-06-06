package com.kevin.genericity.demo;

/**
 * @author caonanqing
 * @version 1.0
 * @description     测试泛型
 * @createDate 2019/6/6
 */
public class Test {

    public static void main(String[] args) {

        // 测试泛型类
        Student<String> student = new Student<>();
        student.setData("类型为String");
        System.out.println(student.getData());

        // 测试泛型方法
        Test test = new Test();
        Student<String> stu = test.show_1(new Student<>("测试泛型方法"));
        System.out.println(stu.toString());

        // 测试静态泛型方法
        Test.show_2(new Student<>("测试静态泛型方法"));

        // 测试泛型实现泛型接口
        Major major = new Major();
        System.out.println(major.show("测试泛型类实现泛型接口"));

    }

    // 非泛型类的泛型方法，<T>：泛型声明，T：实际的泛型类
    private <T> T show_1(T data){
        return data;
    }

    // 非泛型类的静态泛型方法，<T>：泛型声明
    public static <T> void show_2(T data){
        System.out.println(data.toString());
    }


}
