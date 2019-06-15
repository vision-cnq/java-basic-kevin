package com.kevin.sort;

/**
 * @author caonanqing
 * @version 1.0
 * @description     堆排序
 *
 *      从算法描述来看，堆排序需要两个过程，一是建立堆，二是堆顶与堆的最后一个元素交换位置。所以堆排序有两个函数组成。
 *      一是建堆函数，二是反复调用建堆函数以选择出剩余未排元素中最大的数来实现排序的函数。
 *
 *      总结起来就是定义了以下几种操作：
 *          最大堆调整（Max_Heapify）：将堆的末端子节点作调整，使得子节点永远小于父节点
 *          创建最大堆（Build_Max_Heap）：将堆所有数据重新排序
 *          堆排序（HeapSort）：移除位在第一个数据的根节点，并做最大堆调整的递归运算
 *
 *      对于堆节点的访问：
 *          父节点i的左子节点在位置：(2*i+1);
 *          父节点i的右子节点在位置：(2*i+2);
 *          子节点i的父节点在位置：floor((i-1)/2);
 *
 *      1.先将初始序列K[1..n]K[1..n]建成一个大顶堆, 那么此时第一个元素K1K1最大, 此堆为初始的无序区.
 *      2.再将关键字最大的记录K1K1 (即堆顶, 第一个元素)和无序区的最后一个记录 KnKn 交换, 由此得到新的无序区K[1..n−1]K[1..n−1]和有序区K[n]K[n], 且满足K[1..n−1].keys⩽K[n].keyK[1..n−1].keys⩽K[n].key
 *      3.交换K1K1 和 KnKn 后, 堆顶可能违反堆性质, 因此需将K[1..n−1]K[1..n−1]调整为堆. 然后重复步骤2, 直到无序区只有一个元素时停止。
 * @createDate 2019/6/14
 */
public class HeapSort {

    public static void main(String[] args) {

        int[] a = new int[]{1,18,5,35,23,30,10};
        sort(a);
    }

    /**
     * 堆排序
     * @param a
     */
    public static void sort(int[] a) {

        for (int i = a.length; i > 0; i++) {
            max_heapify(a,i);
            // 堆顶元素（第一个元素）与Kn交换
            int temp = a[0];
            a[0] = a[i];
            a[i] = temp;

        }
    }


    /**
     * 将数组堆化
     *      i = 第一个非叶子节点
     *      从第一个非叶子节点开始即可，无需从最后一个叶子节点开始。
     *      叶子节点可以看做已符合堆要求的节点，根节点就是它自己且自己以下最大值
     * @param a
     * @param n
     */
    public static void max_heapify(int[] a,int n){

        int child;
        for(int i = (n-1) / 2; i >= 0; i--) {
            // 左子节点位置
            child = 2 * i + 1;
            // 右子节点存在且大于左子节点，child变成右子节点
            if(child != n && a[child] < a[child + 1]) {
                child++;
            }

            // 交换父节点与左右子节点中的最大值
            if(a[i] < a[child]) {
                int temp = a[i];
                a[i] = a[child];
                a[child] = temp;
            }
        }
    }
}
