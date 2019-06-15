package com.kevin.sort;

/**
 * @author caonanqing
 * @version 1.0
 * @description        排序工具类
 * @createDate 2019/6/14
 */
public class SortUtil {


    /**
     * 打印排序的最终结果
     * @param a
     * @param n
     */
    public static void printResult(int[] a, int n) {
        System.out.print("最终结果: ");
        for (int i = 0; i < n; i++) {
            System.out.print(" " + a[i]);
        }
        System.out.println();
    }

    /**
     *      打印排序的每次循环的结果
     * @param a
     * @param n
     * @param i
     */
    public static void print(int[] a, int n, int i){
        System.out.print("第" + (i+1) + "次: ");
        for (int j = 0; j < n; j++) {
            System.out.print(" " + a[j]);
        }
        System.out.println();
    }


}
