package com.kevin.math;

/**
 * @author kevin
 * @version 1.0
 * @description Java 的 Math 包含了用于执行基本数学运算的属性和方法，如初等指数、对数、平方根和三角函数。
                 Math 的方法都被定义为 static 形式，通过 Math 类可以在主函数中直接调用。
 * @createDate 2018/12/19
 */
public class MathDemo1 {

    public static void main(String[] args) {
        System.out.println("90 度的正弦值：" + Math.sin(Math.PI/2));
        System.out.println("0度的余弦值：" + Math.cos(0));
        System.out.println("60度的正切值：" + Math.tan(Math.PI/3));
        System.out.println("1的反正切值： " + Math.atan(1));
        System.out.println("π/2的角度值：" + Math.toDegrees(Math.PI/2));
        System.out.println(Math.PI);
    }
}
