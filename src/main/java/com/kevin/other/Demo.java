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
        /*第1期 ,全部本金: 10002.0 ,全部利息: 170.88 ,每月需还: 1837.88 ,当月利息: 170.88 ,当月本金: 1667.0
        第2期 ,全部本金: 10002.0 ,全部利息: 313.29 ,每月需还: 1809.4 ,当月利息: 142.4 ,当月本金: 1667.0
        第3期 ,全部本金: 10002.0 ,全部利息: 427.21 ,每月需还: 1780.92 ,当月利息: 113.92 ,当月本金: 1667.0
        第4期 ,全部本金: 10002.0 ,全部利息: 512.65 ,每月需还: 1752.44 ,当月利息: 85.44 ,当月本金: 1667.0
        第5期 ,全部本金: 10002.0 ,全部利息: 569.61 ,每月需还: 1723.96 ,当月利息: 56.96 ,当月本金: 1667.0
        第6期 ,全部本金: 10002.0 ,全部利息: 598.09 ,每月需还: 1695.48 ,当月利息: 28.48 ,当月本金: 1667.0*/
        double je = 3000;    // 本金
        double lx = 0.001;    //利息，等于年化综合费率24%
        int fq = 6;     // 分期数
        double zk = 1;    // 利息折扣
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
