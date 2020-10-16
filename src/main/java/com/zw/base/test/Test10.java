package com.zw.base.test;

import java.util.ArrayList;
import java.util.List;

public class Test10 {
    public static void main(String[] args) {
        List<String> strs = new ArrayList<>();
        strs.add(0, "hello1");
        strs.add(1, "hello2");
        strs.add(1, "xxxxx");

        System.out.println("end ......");
    }
}
