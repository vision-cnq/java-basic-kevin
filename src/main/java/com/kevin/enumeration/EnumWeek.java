package com.kevin.enumeration;

/**
 * @author caonanqing
 * @version 1.0
 * @description     表示性别的枚举类型
 *
 *         可以通过枚举类型名直接引用常量，如：SexEnum.male
 * @createDate 2019/6/3
 */
public enum EnumWeek {

    MON,TUE,WED,THU,FRI,SAT,SUN;

}

/**

    实际上这段代码调用了七次Enum(String name, int ordinal):
    new Enum<EnumWeek>("MON",0);
    new Enum<EnumWeek>("TUE",1);
    new Enum<EnumWeek>("WED",2);
    new Enum<EnumWeek>("THU",3);
    new Enum<EnumWeek>("FRI",4);
    new Enum<EnumWeek>("SAT",5);
    new Enum<EnumWeek>("SUN",6);

     在没有使用枚举类的时候如下
     public interface EnumWeek {
         String MON = "Mon";
         String TUE = "Tue";
         String WED = "Wed";
         String THU = "Thu";
         String FRI = "Fri";
         String SAT = "Sat";
         String SUN = "Sun";
     }
 */
