package com.kevin.enumeration;

/**
 * @author caonanqing
 * @version 1.0
 * @description     四：覆盖枚举的方法
 * @createDate 2019/6/3
 */
public enum EnumMethodOv {

    RED("红色",1),GREEN("绿色",2),BLANK("白色",3),YELLO("黄色",4);

    // 成员变量
    private String name;
    private int index;

    // 构造方法
    private EnumMethodOv(String name, int index) {
        this.name = name;
        this.index = index;
    }

    // 覆盖方法
    @Override
    public String toString(){
        return this.index + "_" + this.name;
    }

}

// 测试类
class EnumMethodOvTest{

    public static void main(String[] args) {

        EnumMethodOv enumMethodOv = EnumMethodOv.RED;
        System.out.println(enumMethodOv.toString());

    }
}
