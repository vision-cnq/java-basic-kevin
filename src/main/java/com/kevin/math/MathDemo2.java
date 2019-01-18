package com.kevin.math;

/**
 * @author kevin
 * @version 1.0
 * @description     Math 的 floor,round 和 ceil 方法实例比较
 * @createDate 2018/12/19
 */
public class MathDemo2 {

    public static void main(String[] args) {
        double[] nums = { 1.4, 1.5, 1.6, -1.4, -1.5, -1.6 };
        for (double num : nums) {
            test(num);
        }
    }

    private static void test(double num) {
        System.out.println("Math.floor(" + num + ")=" + Math.floor(num));
        System.out.println("Math.round(" + num + ")=" + Math.round(num));
        System.out.println("Math.ceil(" + num + ")=" + Math.ceil(num));

    }
}
