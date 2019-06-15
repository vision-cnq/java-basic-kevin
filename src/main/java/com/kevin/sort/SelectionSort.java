package com.kevin.sort;

/**
 * @author caonanqing
 * @version 1.0
 * @description     简单选择排序
 *       1.从未排序序列中，找到关键字最小的元素
 *       2.如果最小元素不是未排序序列的第一个元素，将其和未排序序列第一个元素互换
 *       3.重复1、2步，直到排序结束。
 * @createDate 2019/6/14
 */
public class SelectionSort {

    public static void main(String[] args) {

        int[] a = new int[]{1,18,5,35,23,30,10};
        sort(a);

    }

    /**
     * 简单选择排序
     * @param a
     */
    public static void sort(int[] a) {

        for (int i = 0; i < a.length; i++) {
            int min = i;
            // 选出之后待排序中最小的位置
            for(int j = i+1; j < a.length; j++) {
                if(a[j] < a[min]) {
                    min = j;
                }
            }
            // 最小值不等于当前值时进行交换
            if(min != i) {
                int temp = a[i];
                a[i] = a[min];
                a[min] = temp;
            }
        }
        SortUtil.printResult(a,a.length);   // 打印最终结果
    }

}
