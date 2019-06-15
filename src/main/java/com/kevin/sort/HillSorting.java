package com.kevin.sort;

/**
 * @author caonanqing
 * @version 1.0
 * @description     希尔排序
 *      1.选择一个增量序列 t1，t2，……，tk，其中 ti > tj, tk = 1；
 *      2.按增量序列个数 k，对序列进行 k 趟排序；
 *      3.每趟排序，根据对应的增量 ti，将待排序列分割成若干长度为 m 的子序列，分别对各子表进行直接插入排序。
 *          仅增量因子为 1 时，整个序列作为一个表来处理，表长度即为整个序列的长度。
 * @createDate 2019/6/14
 */
public class HillSorting {

    public static void main(String[] args) {

        int[] a = new int[]{1,18,5,35,23,30,10};
        sort(a);
    }

    /**
     * 希尔排序
     * @param a
     */
    public static void sort(int[] a) {

        int length = a.length;
        int h = 1;
        while(h < length/3)
            h = 3*h+1;
        for (; h >= 1; h/=3) {
            for(int i = 0; i < a.length - h; i+=h ) {
                for(int j = i+h;j > 0; j -= h) {
                    if(a[j] < a[j-h]) {
                        int temp = a[j];
                        a[j] = a[j-h];
                        a[j-h] = temp;
                    }
                }
            }
        }
        SortUtil.printResult(a,a.length);   // 打印最终结果
    }

}
