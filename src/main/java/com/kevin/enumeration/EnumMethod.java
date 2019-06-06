package com.kevin.enumeration;

/**
 * @author caonanqing
 * @version 1.0
 * @description    向枚举中添加新的方法     给 enum 自定义属性和方法
 *
 *      给 enum 对象加一下 value 的属性和 getValue() 的方法
 * @createDate 2019/6/3
 */
public enum EnumMethod {

    MON(1),TUE(2),WED(3),THU(4),FRI(5),SAT(6){
        public boolean isRest() {
            return true;
        }
    },SUN(0) {
        public boolean isRest() {
          return true;
        }
    };

    private int value;

    // 构造方法
    private EnumMethod(int value) {
        this.value = value;
    }

    // get方法
    public int getValue(){
        return value;
    }

    // 普通方法
    public boolean isRest(){
        return true;
    }
}
