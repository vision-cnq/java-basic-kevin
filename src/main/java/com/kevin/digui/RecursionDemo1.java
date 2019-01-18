package com.kevin.digui;

/**
 *
 * @author kevin
 * @version 1.0
 * @description
 *  一个整数，大于0，不用循环和本地变量，按照n，2n，4n，8n的顺序递增，当值大于5000时，把值按照指定顺序输出来。
 *   	例：n=1237
 *   	则输出为：
 *    	1237，
 *   	2474，
 *    	4948，
 *     	9896，
 *      9896，
 *   	4948，
 *    	2474，
 *    	1237，
 * @createDate 2018/12/25
 */
public class RecursionDemo1 {

    public static void main(String[] args) {
        doubleNum(1237);
    }

    public static void doubleNum(int n){
        System.out.println(n);
        if(n<=5000){
            doubleNum(n*2);
        }
        System.out.println(n);
    }
}
