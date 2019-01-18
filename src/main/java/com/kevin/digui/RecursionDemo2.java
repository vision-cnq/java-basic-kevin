package com.kevin.digui;

/**
 * @author kevin
 * @version 1.0
 * @description
 * @createDate 2018/12/25
 */
public class RecursionDemo2 {

    public static void main(String[] args) {
        System.out.println(computeAge(8));

    }

    public static int computeAge(int n){

        if(n == 1){
            return 10;
        }

        return computeAge(n-1)+2;
    }
}
