package com.kevin.sort;

import java.util.Stack;

/**
 * @author caonanqing
 * @version 1.0
 * @description     快速排序
 *      快速排序使用分治策略来把一个序列（list）分为两个子序列（sub-lists）。步骤为：
 *      1.从数列中挑出一个元素，称为"基准"（pivot）。
 *      2.重新排序数列，所有比基准值小的元素摆放在基准前面，所有比基准值大的元素摆在基准后面（相同的数可以到任一边）。在这个分区结束之后，该基准就处于数列的中间位置。这个称为分区（partition）操作。
 *      3.递归地（recursively）把小于基准值元素的子数列和大于基准值元素的子数列排序。
 *      递归到最底部时，数列的大小是零或一，也就是已经排序好了。这个算法一定会结束，因为在每次的迭代（iteration）中，它至少会把一个元素摆到它最后的位置去。
 *
 * @createDate 2019/6/14
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] a = new int[]{1,18,5,35,23,30,10};
        int low = 0;
        int high = a.length-1;
        sort(a,low,high);
        sortByStack(a);
        sortThreeWay(a,low,high);
    }

    /**
     *  快速排序，分治递归法
     *      通过把基准插入到合适的位置来实现分治，并递归地对分治后的两个划分继续快排
     * @param a
     */
    public static void sort(int[] a, int low, int high) {

        // 已经排完
        if(low >= high) {
            return ;
        }
        int left = low;
        int right = high;

        // 保存基准值
        int pivot = a[left];

        while (left < right) {
            // 从后向前找到比基准小的元素
            while(left < right && a[right] >= pivot) {
                right--;
            }
            a[left] = a[right];
            // 从前往后找到比基准大的元素
            while (left < right && a[left] <= pivot) {
                left++;
            }
            a[right] = a[left];
        }
        // 防止基准值，准备分治递归快排
        a[left] = pivot;
        sort(a,low,left-1);
        sort(a,left+1,high);
        SortUtil.printResult(a, a.length);      // 打印最终结果
    }


    /**
     *  快速排序，非递归法
     *      因为 递归的本质是栈 ，所以我们非递归实现的过程中，可以借助栈来保存中间变量就可以实现非递归了。
     *      在这里中间变量也就是通过Pritation函数划分区间之后分成左右两部分的首尾指针，只需要保存这两部分的首尾指针即可。
     * @param a
     */
    public static void sortByStack(int[] a) {

        Stack<Integer> stack = new Stack<>();

        // 初始状态的左右指针入栈
        stack.push(0);
        stack.push(a.length - 1);
        while (!stack.isEmpty()) {
            // 出栈进行划分
            int high = stack.pop();
            int low = stack.pop();

            int pivotIndex = partition(a, low, high);

            // 保存中间变量
            if(pivotIndex > low) {
                stack.push(low);
                stack.push(pivotIndex - 1);
            }
            if(pivotIndex < high && pivotIndex >= 0) {
                stack.push(pivotIndex + 1);
                stack.push(high);
            }

        }
        SortUtil.printResult(a,a.length);   // 打印最终结果
    }

    public static int partition(int[] a, int low, int high) {
        if(low >= high)
            return -1;
        int left = low;
        int right = high;

        // 保存基准的值
        int pivot = a[left];
        while (left < right) {
            // 从后向前找到比基准小的元素，插入到基准位置中
            while (left < right && a[right] >= pivot) {
                right--;
            }
            a[left] = a[right];
            // 从前往后找到比基准大的元素
            while (left < right && a[left] <= pivot) {
                left++;
            }
            a[right] = a[left];
        }
        // 放置基准值，准备分支递归快排
        a[left] = pivot;
        return left;
    }

    /**
     *  算法改进
     *      1.切换到插入排序
     *          和大多数递归排序算法一样，改进快速排序性能的一个简单方法基于以下两点：
     *              对于小数组，快速排序比插入排序慢
     *              因为递归，快速排序的sort()方法在小数组中叶会调用自己
     *          因此，在排序小数组时应该切换到插入排序。
     *
     *      2.三者取中法：
     *          快速排序是通常被认为在同数量级（O(nlog2n)）的排序方法中平均性能最好的。但若初始序列按关键码有序或基本有序时，
     *          快排序反而蜕化为冒泡排序。为改进之，通常以“三者取中法”来选取基准记录，即将排序区间的两个端点与中点三个记录关键码居中的调整为支点记录。
     *
     *      3.三向快速排序
     *          实际应用中经常会出现含有大量重复元素的数组。例如，一个元素全部重复的子数组就不需要继续排序了，
     *          但我们的算法还会继续将它切分为更小的数组。在有大量重复元素的情况下，快速排序的递归性会使元素全部重复的子数组经常出现，
     *          这就有很大的改进潜力，经当前实现的线性对数级的性能提高到线性级别。
     *
     *      算法：  在lt之前的(lo~lt-1)都小于中间值
     *              在gt之前的(gt+1~hi)都大于中间值
     *              在lt~i-1的都等于中间值
     *              在i~gt的都还不确定（最终i会大于gt，即不确定的将不复存在）
     * @param a
     * @param lo
     * @param hi
     */
    public static void sortThreeWay(int[] a, int lo, int hi) {

        if(lo >= hi){
            return ;
        }

        int v = a[lo];
        int lt = lo;
        int i = lo + 1;
        int gt = hi;

        while (i <= gt) {
            if(a[i] < v){
                swap(a, i++, lt++);
            } else if(a[i] > v){
                swap(a, i, gt--);
            } else {
                i++;
            }
        }
        sortThreeWay(a, lo, lt-1);
        sortThreeWay(a, gt + 1, hi);
        SortUtil.printResult(a, a.length);  // 打印最终结果
    }

    public static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

}
