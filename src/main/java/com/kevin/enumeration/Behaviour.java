package com.kevin.enumeration;

/**
 * @author caonanqing
 * @version 1.0
 * @description     五：实现接口
 *      所有的枚举都继承自java.lang.Enum类。由于Java 不支持多继承，所以枚举对象不能再继承其他类。
 * @createDate 2019/6/3
 */
public interface Behaviour {

    void print();
    String getInfo();
}

enum ColorB implements Behaviour {
    RED("红色", 1), GREEN("绿色", 2), BLANK("白色", 3), YELLO("黄色", 4);

    // 成员变量
    private String name;
    private int index;

    // 构造方法
    private ColorB(String name, int index) {
        this.name = name;
        this.index = index;
    }

    // 接口方法
    @Override
    public void print() {
        System.out.println(this.index + " : " + this.name);
    }

    // 接口方法
    @Override
    public String getInfo() {
        return this.name;
    }
}

// 测试
class ColorBTest{

    public static void main(String[] args) {

        ColorB red = ColorB.RED;
        red.print();
        System.out.println(red.getInfo());
    }

}
