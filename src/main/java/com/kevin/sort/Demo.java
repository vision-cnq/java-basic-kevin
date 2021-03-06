package com.kevin.sort;

/**
 * @author caonanqing
 * @version 1.0
 * @description     八大排序法
 * @createDate 2019/6/6
 */
public class Demo {

    /**
     *
     *      常见的排序算法如下：
     *          1.插入排序：
     *              a)直接插入排序
     *              b)希尔排序
     *          2.选择排序
     *              a)简单选择排序
     *              b)堆排序
     *          3.交换排序
     *              a)冒泡排序
     *              b)快速排序
     *          4.归并排序
     *          5.基数排序
     *
     *      稳定与非稳定：如果一个排序算法能够保留数组中重复元素的相对位置可以称之为稳定的，反之称为不稳定。
     *
     *      1.直接插入排序
     *          思想：
     *              通常人们整理桥牌的方法是一张一张的来，将每一张牌插入到其他已经有序的牌中的适当位置。
     *              在计算机的实现中，为了要给插入的元素腾出空间，我们需要将其余所有元素在插入之前都向右移动一位。
     *          算法描述：
     *              1.从第一个元素开始，该元素可以认为已经被排序
     *              2.取出下一个元素，在已经排序的元素序列中从后向前扫描
     *              3.如果该元素（已排序）大于新元素，将该元素移到下一位置
     *              4.重复步骤3，直到找到已排序的元素小于或者等于新元素的位置
     *              5.将新元素插入到该位置后
     *              6.重复步骤2~5
     *          注意：如果比较操作的代价比交换操作大的话，可以采用二分查找法来减少比较操作的数目。该算法可以认为是插入排序的一个变种，称为二分查找插入排序。
     *
     *      2.希尔排序
     *          希尔排序也称递减增量排序算法，是插入排序的一种更高效的改进版本，希尔排序是非稳定排序算法。
     *          希尔排序是基于插入排序的以下两点性质而提出改进方法的：
     *              插入排序在对几乎已经排好序的数据操作时，效率高，即可以达到线性排序的效率
     *              但插入排序一般来说是低效的，因为插入排序每次只能将数据移动一
     *              希尔排序是先将整个待排序的记录序列分割成为若干子序列分别进行直接插入排序，待整个序列中的记录“基本有序”时，再对全体记录进行依次直接插入排序。
     *          思想：
     *              将待排序数组按照步长gap进行分组，然后将每组的元素利用直接插入排序的方法进行排序；每次再将gap折半减小，循环上述操作；
     *              当gap=1时，利用直接插入，完成排序。可以看到步长的选择是希尔排序的重要部分。只要最终步长为1任何步长序列都可以工作。
     *              一般来说最简单的步长取值是初次取数组长度的一半为增量，之后每次再减半，直到增量为1。更好的步长序列取值可以参考维基百科。
     *          算法描述：
     *              1.选择一个增量序列 t1，t2，……，tk，其中 ti > tj, tk = 1；
     *              2.按增量序列个数 k，对序列进行 k 趟排序；
     *              3.每趟排序，根据对应的增量 ti，将待排序列分割成若干长度为 m 的子序列，分别对各子表进行直接插入排序。仅增量因子为 1 时，整个序列作为一个表来处理，表长度即为整个序列的长度。
     *          总结：
     *              希尔排序更高效的原因是它权衡了子数组的规模和有序性。排序之初，各个子数组都很短，排序之后子数组都是部分有序的，这两种情况都很适合插入排序。
     *
     *      3.简单选择排序
     *          选择排序（Selection sort）是一种简单直观的排序算法。
     *          思想：
     *              首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，然后，再从剩余未排序元素中继续寻找最小（大）元素，
     *              然后放到已排序序列的末尾。以此类推，直到所有元素均排序完毕。选择排序的主要优点与数据移动有关。如果某个元素位于正确的最终位置上，
     *              则它不会被移动。选择排序每次交换一对元素，它们当中至少有一个将被移到其最终位置上，因此对 n个元素的表进行排序总共进行至多 n-1 次交换。
     *              在所有的完全依靠交换去移动元素的排序方法中，选择排序属于非常好的一种。
     *          算法描述：
     *              1.从未排序序列中，找到关键字最小的元素
     *              2.如果最小元素不是未排序序列的第一个元素，将其和未排序序列第一个元素互换
     *              3.重复1、2步，直到排序结束。
     *          总结：
     *              选择排序的简单和直观名副其实，这也造就了它”出了名的慢性子”，无论是哪种情况，哪怕原数组已排序完成，
     *              它也将花费将近n²/2次遍历来确认一遍。即便是这样，它的排序结果也还是不稳定的。 唯一值得高兴的是，它并不耗费额外的内存空间。
     *
     *      4.堆排序
     *          堆的定义如下：nn个元素的序列{k1,k2,..,kn}，当且仅当满足下关系时，称之为堆。
     *          把此序列对应的二维数组看成一个完全二叉树。那么堆的含义就是：完全二叉树中任何一个非叶子节点的值均不大于（或不小于）其左，
     *          右孩子节点的值。 由上述性质可知大顶堆的堆顶的关键字肯定是所有关键字中最大的，小顶堆的堆顶的关键字是所有关键字中最小的。
     *          因此我们可使用大顶堆进行升序排序, 使用小顶堆进行降序排序。
     *          思想：
     *              此处以大顶堆为例，堆排序的过程就是将待排序的序列构造成一个堆，选出堆中最大的移走，再把剩余的元素调整成堆，找出最大的再移走，重复直至有序。
     *          算法描述：
     *              1.先将初始序列K[1..n]K[1..n]建成一个大顶堆, 那么此时第一个元素K1K1最大, 此堆为初始的无序区.
     *              2.再将关键字最大的记录K1K1 (即堆顶, 第一个元素)和无序区的最后一个记录 KnKn 交换, 由此得到新的无序区K[1..n−1]K[1..n−1]和有序区K[n]K[n], 且满足K[1..n−1].keys⩽K[n].keyK[1..n−1].keys⩽K[n].key
     *              3.交换K1K1 和 KnKn 后, 堆顶可能违反堆性质, 因此需将K[1..n−1]K[1..n−1]调整为堆. 然后重复步骤2, 直到无序区只有一个元素时停止。
     *          总结：
     *              由于堆排序中初始化堆的过程比较次数较多, 因此它不太适用于小序列。 同时由于多次任意下标相互交换位置, 相同元素之间原本相对的顺序被破坏了, 因此, 它是不稳定的排序。
     *
     *      5.冒泡排序
     *          思想：
     *              冒泡排序（Bubble Sort）是一种简单的排序算法。它重复地走访过要排序的数列，一次比较两个元素，如果他们的顺序错误就把他们交换过来。
     *              走访数列的工作是重复地进行直到没有再需要交换，也就是说该数列已经排序完成。这个算法的名字由来是因为越小的元素会经由交换慢慢“浮”到数列的顶端。
     *          算法描述：
     *              1.比较相邻的元素。如果第一个比第二个大，就交换他们两个。
     *              2.对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。这步做完后，最后的元素会是最大的数。
     *              3.针对所有的元素重复以上的步骤，除了最后一个。
     *              4.持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
     *           总结：
     *              由于冒泡排序只在相邻元素大小不符合要求时才调换他们的位置, 它并不改变相同元素之间的相对顺序, 因此它是稳定的排序算法。
     *
     *      6.快速排序
     *          快速排序是由东尼·霍尔所发展的一种排序算法。在平均状况下，排序 n 个项目要 Ο(nlogn) 次比较。在最坏状况下则需要 Ο(n2) 次比较，
     *          但这种状况并不常见。事实上，快速排序通常明显比其他 Ο(nlogn) 算法更快，因为它的内部循环（inner loop）可以在大部分的架构上很有效率地被实现出来。
     *          思想：
     *              挖坑填数+分治法。
     *              快速排序使用分治法（Divide and conquer）策略来把一个串行（list）分为两个子串行（sub-lists）。
     *              快速排序又是一种分而治之思想在排序算法上的典型应用。本质上来看，快速排序应该算是在冒泡排序基础上的递归分治法。
     *              快速排序的名字起的是简单粗暴，因为一听到这个名字你就知道它存在的意义，就是快，而且效率高！它是处理大数据最快的排序算法之一了。
     *              虽然 Worst Case 的时间复杂度达到了 O(n²)，但是人家就是优秀，在大多数情况下都比平均时间复杂度为 O(n logn) 的排序算法表现要更好。
     *          算法描述：
     *              快速排序使用分治策略来把一个序列（list）分为两个子序列（sub-lists）。步骤为：
     *              1.从数列中挑出一个元素，称为"基准"（pivot）。
     *              2.重新排序数列，所有比基准值小的元素摆放在基准前面，所有比基准值大的元素摆在基准后面（相同的数可以到任一边）。在这个分区结束之后，该基准就处于数列的中间位置。这个称为分区（partition）操作。
     *              3.递归地（recursively）把小于基准值元素的子数列和大于基准值元素的子数列排序。
     *              递归到最底部时，数列的大小是零或一，也就是已经排序好了。这个算法一定会结束，因为在每次的迭代（iteration）中，它至少会把一个元素摆到它最后的位置去。
     *
     *      7.归并排序
     *          归并排序是建立在归并操作上的一种有效的排序算法，该算法是使用分治法的一个经典应用，且各层分治递归可以同时进行。
     *          思想：
     *              归并排序算法是将两个（或两个以上）有序合并成一个新的有序表，即把待排序列分为若干个子序列，每个子序列是有序的，然后再把有序子序列合并为整体有序序列。
     *          算法描述：
     *              归并排序可通过两种方式实现:
     *                  1.自上而下的递归
     *                  2.自下而上的迭代
     *              1.递归法（假设序列共有n个元素）：
     *                  将序列每相邻两个数字进行归并操作，形成 floor(n/2)个序列，排序后每个序列包含两个元素；
     *                  将上述序列再次归并，形成 floor(n/4)个序列，每个序列包含四个元素；
     *                  重复步骤2，直到所有元素排序完毕。
     *              2.迭代法：
     *                  申请空间，使其大小为两个已经排序序列之和，该空间用来存放合并后的序列
     *                  设定两个指针，最初位置分别为两个已经排序序列的起始位置
     *                  比较两个指针所指向的元素，选择相对小的元素放入到合并空间，并移动指针到下一位置
     *                  重复步骤3直到某一指针到达序列尾
     *                  将另一序列剩下的所有元素直接复制到合并序列尾
     *          总结：
     *              归并排序最吸引人的性质是它能够保证将任意长度为N的数组排序所需时间和NlogN成正比，它的主要缺点则是他所需的额外空间和N成正比。
     *
     *       8.基数排序
     *          基数排序（Radix sort）是一种非比较型整数排序算法，其原理是将整数按位数切割成不同的数字，然后按每个位数分别比较。
     *          由于整数也可以表达字符串（比如名字或日期）和特定格式的浮点数，所以基数排序也不是只能使用于整数。
     *          思想：
     *              将所有待比较数值（正整数）统一为同样的数位长度，数位较短的数前面补零。然后，从最低位开始，依次进行一次排序。
     *              这样从最低位排序一直到最高位排序完成以后，数列就变成一个有序序列。
     *              基数排序按照优先从高位或低位来排序有两种实现方案：
     *                  1.MSD（Most significant digital） 从最左侧高位开始进行排序。先按k1排序分组, 同一组中记录, 关键码k1相等,
     *                      再对各组按k2排序分成子组, 之后, 对后面的关键码继续这样的排序分组, 直到按最次位关键码kd对各子组排序后.
     *                      再将各组连接起来, 便得到一个有序序列。MSD方式适用于位数多的序列。
     *                  2.LSD （Least significant digital）从最右侧低位开始进行排序。先从kd开始排序，再对kd-1进行排序，依次重复，
     *                      直到对k1排序后便得到一个有序序列。LSD方式适用于位数少的序列。
     *          算法描述：
     *              以LSD为例，从最低位开始，具体算法描述如下：
     *              取得数组中的最大数，并取得位数；
     *              arr为原始数组，从最低位开始取每个位组成radix数组；
     *              对radix进行计数排序（利用计数排序适用于小范围数的特点）；
     *          总结：
     *              基数排序更适合用于对时间, 字符串等这些 整体权值未知的数据 进行排序。
     *              基数排序不改变相同元素之间的相对顺序，因此它是稳定的排序算法。
     *
     *              基数排序 vs 计数排序 vs 桶排序
     *
     *              这三种排序算法都利用了桶的概念，但对桶的使用方法上有明显差异：
     *                  1.基数排序：根据键值的每位数字来分配桶
     *                  2.计数排序：每个桶只存储单一键值
     *                  3.桶排序：每个桶存储一定范围的数值
     *
     *      八大排序算法总结
     * 			各种排序性能对比如下:
     * 			    排序类型	  平均情况	      最好情况	      最坏情况	      辅助空间	       稳定性
     * 			    冒泡排序	    O(n²)	        O(n)	        O(n²)	        O(1)	        稳定
     * 			    选择排序	    O(n²)	        O(n²)	        O(n²)	        O(1)	        不稳定
     * 			    直接插入排序	O(n²)	        O(n)	        O(n²)	        O(1)	        稳定
     * 			    折半插入排序	O(n²)	        O(n)	        O(n²)	        O(1)	        稳定
     * 			    希尔排序	    O(n^1.3)	    O(nlogn)	    O(n²)	        O(1)	        不稳定
     * 			    归并排序	    O(nlog₂n)	    O(nlog₂n)	    O(nlog₂n)	    O(n)	        稳定
     * 			    快速排序	    O(nlog₂n)	    O(nlog₂n)	    O(n²)	        O(nlog₂n)	    不稳定
     * 			    堆排序	        O(nlog₂n)	    O(nlog₂n)	    O(nlog₂n)	    O(1)	        不稳定
     * 			    计数排序	    O(n+k)	        O(n+k)	        O(n+k)	        O(k)	        稳定
     * 			    桶排序	        O(n+k)	        O(n+k)	        O(n²)	        O(n+k)	        (不)稳定
     * 			    基数排序	    O(d(n+k))	    O(d(n+k))	    O(d(n+kd))	    O(n+kd)	        稳定
     *
     * 			从时间复杂度来说：
     * 			    平方阶O(n²)排序：各类简单排序：直接插入、直接选择和冒泡排序
     * 			    线性对数阶O(nlog₂n)排序：快速排序、堆排序和归并排序
     * 			    O(n1+§))排序，§是介于0和1之间的常数：希尔排序
     * 			    线性阶O(n)排序：基数排序，此外还有桶、箱排序
     *
     * 			论是否有序的影响：
     * 			    当原表有序或基本有序时，直接插入排序和冒泡排序将大大减少比较次数和移动记录的次数，时间复杂度可降至O（n）；
     * 			    而快速排序则相反，当原表基本有序时，将蜕化为冒泡排序，时间复杂度提高为O（n2）；
     * 			    原表是否有序，对简单选择排序、堆排序、归并排序和基数排序的时间复杂度影响不大
     *
     *
     */

}
