package com.kevin.sort;

/**
 * @author caonanqing
 * @version 1.0
 * @description     冒泡排序
 *      比较相邻的元素。如果第一个比第二个大，就交换他们两个。
 *      对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。这步做完后，最后的元素会是最大的数。
 *      针对所有的元素重复以上的步骤，除了最后一个。
 *      持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
 * @createDate 2019/6/14
 */
public class BubbleSort {

    public static void main(String[] args) {

        int[] a = new int[]{1,18,5,35,23,30,10};
        sort(a);

    }

    /**
     * 冒泡排序
     * @param a
     */
    public static void sort(int[] a) {

        // 外层循环控制比较的次数
        for (int i = 0; i < a.length; i++) {
            // 内层循环控制到达位置
            for (int j = 0; j < a.length-i-1; j++) {
                // 前面的元素比后面大就交换
                if(a[j] > a[j+1]) {
                    int temp = a[j];    // 将前面的元素赋值到一个临时变量temp
                    a[j] = a[j+1];      // 将后面的元素赋值给前面的元素
                    a[j+1] = temp;      // 将临时变量temp的数据赋值给后面的元素
                }
            }
            SortUtil.print(a,a.length,i);       // 打印排序的每次循环的结果
        }
        SortUtil.printResult(a,a.length);       // 打印最终结果

    }
}
