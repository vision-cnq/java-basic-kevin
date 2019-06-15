package com.kevin.sort;

/**
 * @author caonanqing
 * @version 1.0
 * @description     直接插入排序
 *      1.从第一个元素开始，该元素可以认为已经被排序
 *      2.取出下一个元素，在已经排序的元素序列中从后向前扫描
 *      3.如果该元素（已排序）大于新元素，将该元素移到下一位置
 *      4.重复步骤3，直到找到已排序的元素小于或者等于新元素的位置
 *      5.将新元素插入到该位置后
 *      6.重复步骤2~5
 * @createDate 2019/6/14
 */
public class InsertionSort {

    public static void main(String[] args) {

        int[] a = new int[]{1,18,5,35,23,30,10};
        sort(a);
        sort2(a);

    }

    /**
     * 通过交换进行插入排序，借鉴冒泡排序
     * @param a
     */
    public static void sort(int[] a) {

        for(int i = 0; i < a.length - 1; i++) { // 遍历数组
            for (int j = i+1; j > 0; j--) {     // 遍历当前元素与之前的元素相比较
                if(a[j] < a[j-1]) {     // 判断当前元素比前一个元素小，则往前移
                    int temp = a[j];    // 临时存放当前元素
                    a[j] = a[j-1];      // 将上一个元素赋值给当前元素
                    a[j-1] = temp;      // 将临时元素赋值给上一个元素
                }
            }
            //SortUtil.print(a,a.length,i);   // 打印排序的每次循环的结果
        }
        SortUtil.printResult(a,a.length);       // 打印最终结果
    }

    /**
     *  通过将较大的元素都向右移动而不总是交换两个元素
     * @param a
     */
    public static void sort2(int[] a) {

        for (int i = 1; i < a.length; i++) {
            int num = a[i]; // 临时存放当前元素
            int j;
            for(j = i; j > 0 && num < a[j-1]; j--) {    // 遍历当前元素与上一个元素相比较，如果当前元素比上一个的小，则右移，j--
                a[j] = a[j-1];  // 将上一个元素赋值给当前元素
            }
            a[j] = num;     // 如果没有执行遍历，则只是将当前的元素赋值给当前的元素，如果执行遍历，将当前元素赋值给上一个元素
            //SortUtil.print(a,a.length,i-1);   // 打印排序的每次循环的结果
        }
        SortUtil.printResult(a,a.length);   // 打印最终结果

    }


}
