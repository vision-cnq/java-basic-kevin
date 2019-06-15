package com.kevin.sort;

/**
 * @author caonanqing
 * @version 1.0
 * @description     归并排序
 *      归并排序其实要做两件事：
 *          分解：将序列每次折半拆分
 *          合并：将划分后的序列段两两排序合并
 *      因此，归并排序实际上就是两个操作，拆分+合并
 * @createDate 2019/6/15
 */
public class MergeSort {

    // 归并所需的辅助数组
    private static int[] aux;

    public static void main(String[] args) {
        int[] a = new int[]{1,18,5,35,23,30,10};
        sort(a);
    }

    public static void sort(int[] a){
        // 一次性分配空间
        aux = new int[a.length];
        sort(a,0,a.length-1);
        SortUtil.printResult(a, a.length);
    }

    /**
     * 将数组每次折半拆分
     * @param a
     * @param low
     * @param high
     */
    public static void sort(int[] a, int low, int high) {

        if(low >= high) {
            return ;
        }

        int mid = (low + high)/2;
        // 将左半边排序
        sort(a,low,mid);
        // 将右半边排序
        sort(a, mid+1, high);
        merge(a, low, mid, high);
    }

    /**
     *  将划分后的数组两两排序合并
     *      该方法先将所有元素复制到aux[]中，然后在归并回a[]中，方法咋归并时（第二个for循环）
     *      进行了4个条件判断：
     *          1.左半边用尽（取右半边的元素）
     *          2.右半边用尽（取左半边的元素）
     *          3.右半边的当前元素小于左半边的当前元素（取右半边的元素）
     *          4.右半边的当前元素大于等于左半边的当前元素（取左半边的元素）
     * @param a
     * @param low
     * @param mid
     * @param high
     */
    public static void merge(int[] a, int low, int mid, int high) {

        // 将a[low..mid]和a[mid+1..high]归并
        int i = low;
        int j = mid+1;
        for (int k = low; k <= high; k++) {
            aux[k] = a[k];
        }

        for (int k = low; k <= high; k++) {
            if(i > mid) {
                a[k] = aux[j++];
            } else if(j > high) {
                a[k] = aux[i++];
            } else if(aux[j] < aux[i]) {
                a[k] =aux[j++];
            } else {
                a[k] = aux[i++];
            }
        }
    }

}
