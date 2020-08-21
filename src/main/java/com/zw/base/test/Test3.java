package com.zw.base.test;

import java.util.Hashtable;
import java.util.Vector;

public class Test3 {
    public static void main(String[] args) {
        System.out.println("Test3 ......");
    }

    public void test() {
        Vector<String> vector = new Vector<>();
        vector.add("hello");
        vector.add("world");

        Hashtable<String, String> hashtable = new Hashtable<>();
        hashtable.put("hello", "world");
    }
}
