package com.softgroup.app.javaTask4;


import java.util.*;


/**
 * Created by inna on 05.03.17.
 */
public class JavaTask4 {

    public static void main(String[] args) {

        CacheMap<Integer, String> cacheMap = new CacheMapImpl<>(5);

        cacheMap.put(1,"one");
        cacheMap.put(2,"two");
        cacheMap.put(3,"three");
        cacheMap.put(4,"four");
        cacheMap.put(5,"five");
        System.out.println(cacheMap.entrySet());

        cacheMap.put(6,"six");
        cacheMap.put(7,"seven");
        System.out.println(cacheMap.entrySet() + " (added 6,7 and deleted 1,2)");

        cacheMap.put(0,"zero");
        cacheMap.put(111,"one one one");
        cacheMap.put(6,"no six"); //rewrite with key = 1
        System.out.println(cacheMap.entrySet() + " (added 0,111 and deleted 3,4. rewrote value with key=6)");
    }

}
