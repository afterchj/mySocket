package com.tpadsz.mysocket.utils;

/**
 * Created by hongjian.chen on 2018/3/6.
 */
public class PathUtil {
    public static void main(String[] args) {
        System.out.println(PathUtil.class.getResource(""));
        System.out.println(PathUtil.class.getResource("/").getPath());
        System.out.println(Thread.currentThread().getContextClassLoader().getResource(""));
        System.out.println(PathUtil.class.getClassLoader().getResource(""));
    }
}
