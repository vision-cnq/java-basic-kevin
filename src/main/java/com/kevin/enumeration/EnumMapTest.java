package com.kevin.enumeration;

import java.util.EnumMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author caonanqing
 * @version 1.0
 * @description     EnumMap的使用
 *
 *      EnumMap中的 key是enum类型，而value则可以是任意类型
 * @createDate 2019/6/3
 */
public class EnumMapTest {

    public static void main(String[] args) {

        // EnumMap的使用
        EnumMap<EnumMethod, String> weekMap = new EnumMap(EnumMethod.class);
        weekMap.put(EnumMethod.MON, "星期一");
        weekMap.put(EnumMethod.TUE, "星期二");

        // 遍历
        for (Iterator<Map.Entry<EnumMethod, String>> iter = weekMap.entrySet().iterator(); iter.hasNext();) {
            Map.Entry<EnumMethod, String> entry = iter.next();
            System.out.println(entry.getKey().name() + ":" + entry.getValue());
        }
    }
}
