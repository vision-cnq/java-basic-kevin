package com.kevin.enumeration;

/**
 * @author caonanqing
 * @version 1.0
 * @description     二：遍历、switch等常用操作
 *      enum 对象的常用方法介绍
 *      int compareTo(E o)
 *           比较此枚举与指定对象的顺序。
 *      Class<E> getDeclaringClass()
 *           返回与此枚举常量的枚举类型相对应的 Class 对象。
 *       String name()
 *           返回此枚举常量的名称，在其枚举声明中对其进行声明。
 *      int ordinal()
 *           返回枚举常量的序数（它在枚举声明中的位置，其中初始常量序数为零）。
 *      String toString()
 *          返回枚举常量的名称，它包含在声明中。
 *      static <T extends Enum<T>> T valueOf(Class<T> enumType, String name)
 *           返回带指定名称的指定枚举类型的枚举常量。
 *
 * @createDate 2019/6/3
 */
public class EnumWeekTest {

    public static void main(String[] args) {

        // 遍历Enum
        for (EnumWeek e : EnumWeek.values()) {
            System.out.println(e.toString());
        }

        System.out.println("------------------");

        // switch
        EnumWeek week = EnumWeek.TUE;
        switch (week) {
            case MON:
                System.out.println("星期一");
                break;
            case TUE:
                System.out.println("星期二");
                break;
            case WED:
                System.out.println("星期三");
                break;
            case THU:
                System.out.println("星期四");
                break;
            case FRI:
                System.out.println("星期五");
                break;
            case SAT:
                System.out.println("星期六");
                break;
            case SUN:
                System.out.println("星期日");
                break;
            default:
                System.out.println(week);
                break;
        }


    }

    // 测试一些枚举类的方法
    private void testMethod(){

        EnumWeek week = EnumWeek.TUE;

        System.out.println("------------------");
        // switch
        switch (week.compareTo(EnumWeek.MON)) {
            case -1:
                System.out.println("TUE 在 MON 之前");
                break;
            case 1:
                System.out.println("TUE 在 MON 之后");
                break;
            default:
                System.out.println("TUE 与 MON 在同一位置");
                break;
        }

        System.out.println("getDeclaringClass(): " + week.getDeclaringClass().getName());
        System.out.println("name(): " + week.name());
        System.out.println("toString(): " + week.toString());
        System.out.println("ordinal(): "+week.ordinal());
    }
}
