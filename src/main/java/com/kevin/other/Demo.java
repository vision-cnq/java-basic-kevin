package com.kevin.other;

import java.text.DecimalFormat;

/**
 * @author kevin
 * @version 1.0
 * @description
 * @createDate 2019/1/20
 */
public class Demo {

    public static void main(String[] args) {

        double je = 5000;    // 本金
        double lx = 0.00066;    //利息
        int fq = 6;     // 分期数
        double zk = 0.8;    // 利息折扣
        double allxl = 0.0;
        double mqbj = je/fq;    // 每月金额
        int fqs = 0;    // 每月递减的分期数
        for (int i = 0; i < fq; i++) {
            fqs = fq-i;
            double v = mqbj * lx * 30 * fqs * zk; // 每月利息
            double v1 = v + mqbj;   // 每月需还
            allxl += v;
            System.out.println("第"+(i+1)+"期 ,全部本金: "+je+" ,全部利息: "+m2(allxl)+" ,每月需还: "+ m2(v1)+" ,当月利息: " + m2(v)+ " ,当月本金: "+m2(mqbj));
        }
    }

    public static Double m2(Double f) {
        DecimalFormat df = new DecimalFormat("#.00");
        return Double.parseDouble(df.format(f));
    }

}
