package com.tpadsz.mysocket.chapter10;

import java.lang.reflect.*;

public class ArrayTester1 {
    public static void main(String args[]) throws Exception {
        Class classType = Class.forName("java.lang.String");
        //创建一个长度为10的字符串数组
        Object array = Array.newInstance(classType, 10);
        String[] arrs = (String[]) array;
        System.out.println(arrs.length);
        //把索引位置为5的元素设为"hello"
        Array.set(array, 9, "hello");
        //获得索引位置为5的元素的值
        String s = (String) Array.get(array, 9);
        System.out.println(s);
    }
}