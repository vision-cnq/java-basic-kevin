package com.kevin.enumeration;

/**
 * @author caonanqing
 * @version 1.0
 * @description     六：使用接口组织枚举
 * @createDate 2019/6/3
 */
public interface Food {

    enum Coffee implements Food {
        BLACK_COFFEE,DECAF_COFFEE,LATTE,CAPPUCCINO
    }

    enum Dessert implements Food {
        FRUIT, CAKE, GELATO
    }
}
