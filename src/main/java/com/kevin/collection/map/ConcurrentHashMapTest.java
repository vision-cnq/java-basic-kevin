package com.kevin.collection.map;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author caonanqing
 * @version 1.0
 * @description     测试ConcurrentHasMap性能，以及并发下的安全性
 * @createDate 2020/1/9
 */
public class ConcurrentHashMapTest {

    static Map<Integer,Integer> hashMap = new HashMap<>();
    static Map<Integer,Integer> hashTable = new Hashtable<>();
    static Map<Integer,Integer> concurrenHashMap = new ConcurrentHashMap<>();


    public static void main(String[] args) {

    }

}
