package com.kevin.exception;

/**
 * @author kevin
 * @version 1.0
 * @description     运行时异常的处理
 * @createDate 2018/12/24
 */
public class ExceptionDemo1 {

    public static void main(String[] args) {

        int a = 0;
        int b = 1;
        if(a == 0){
            System.out.println(b/a);
        }

        String  str = null;
        if(str == null){
            System.out.println(str.length());
        }

        int[] arr = new int[5];
        int a2 = 5;
        if (a2 > arr.length) {
            System.out.println(arr[a2]);
        }

    }
}
