package com.zw.base.test;

import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        // test1();

        test2();

        ObjectOutputStream objectOutputStream;
        List<String> ls;
        ArrayList<String> arrayList;
    }


    /**
     * 使用迭代器
     * 边遍历 边从List中删除元素
     */
    public static void test2() {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() % 2 == 1) {
                it.remove();
            }
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    /**
     * 边遍历 边从List中删除元素
     * 注意从后往前遍历
     */
    public static void test1() {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        for (int i = list.size() - 1; i >= 0; i--) {
            int n = list.get(i);
            if (n % 2 == 0) {
                list.remove(i);
            }
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
