package com.kevin.sort;

import java.util.Arrays;

/**
 * @author caonanqing
 * @version 1.0
 * @description         基数排序
 *      基数排序：通过序列中各个元素的值，对排序的N个元素进行若干趟的“分配”与“收集”来实现排序。
 *          分配：我们将L[i]中的元素取出，首先确定其个位上的数字，根据该数字分配到与之序号相同的桶中
 *          收集：当序列中所有的元素都分配到对应的桶中，再按照顺序依次将桶中的元素收集形成新的一个待排序列L[]。
 *                对新形成的序列L[]重复执行分配和收集元素中的十位、百位...直到分配完该序列中的最高位，则排序结束
 * @createDate 2019/6/15
 */
public class BaseSort {

    public static void main(String[] args) {

        int[] a = new int[]{1,18,5,35,23,30,10};
        sort(a);
    }

    /**
     * 基数排序
     * @param arr
     */
    public static void sort(int[] arr) {

        if(arr.length <= 1){
            return ;
        }

        // 取得数组中的最大数，并取得位数
        int max = 0;
        for(int i = 0; i < arr.length; i++) {
            if(max < arr[i]) {
                max = arr[i];
            }
        }

        int maxDigit = 1;
        while (max / 10 > 0) {
            maxDigit++;
            max = max / 10;
        }
        // 申请一个桶空间
        int[][] buckets = new int[10][arr.length];
        int base = 10;

        // 从低位到高位，对每一个位遍历，将所有元素分配到桶中
        for(int i = 0; i < maxDigit; i++) {
            int[] bktLen = new int[10];     // 存储各个桶中元素的数量

            // 分配：将所有元素分配到桶中
            for(int j = 0; j < arr.length; j++) {
                int whichBucket = (arr[j] % base) / (base / 10);
                buckets[whichBucket][bktLen[whichBucket]] = arr[j];
                bktLen[whichBucket]++;
            }

            // 收集：将不同桶里数据挨个捞出来，为下一轮高位排序做准备，由于靠近桶底的元素排名靠前，因此从桶底先捞
            int k = 0;
            for(int b = 0; b < buckets.length; b++) {
                for(int p = 0; p < bktLen[b]; p++) {
                    arr[k++] = buckets[b][p];
                }
            }
            System.out.println("Sorting: " + Arrays.toString(arr));
            base *= 10;
        }
        SortUtil.printResult(arr, arr.length);      // 打印最终结果
    }
}
