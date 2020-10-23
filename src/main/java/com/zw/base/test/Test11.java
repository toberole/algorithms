package com.zw.base.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test11 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        List<String> list1 = new ArrayList<>();
        list1.add("2");
        list1.add("3");
        list.addAll(list1);
        System.out.println(Arrays.toString(list.toArray()));

        List<String> list2 = new ArrayList<>();
        list2.add("-1");
        list2.add("0");
        list.addAll(0,list2);
        System.out.println(Arrays.toString(list.toArray()));

    }
}
