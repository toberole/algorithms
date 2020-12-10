package com.zw.base.java.test1;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class Test1 {
    public static void main(String[] args) {
        Integer i1 = Integer.valueOf(123);
        Integer i2 = Integer.valueOf(123);
        System.out.println(i1 == i2);

        i1 = new Integer(123);
        i2 = new Integer(123);
        System.out.println(i1 == i2);

        String hello = "Hello Test";

        short s1 = 1;
        s1 = (short) (s1 + 1);

        Object o = new Object();

        Integer x = new Integer(1);
        Integer y = new Integer(1);
        System.out.println(x.equals(y)); // true
        System.out.println(x == y);// false
        System.out.println("---------------------");
        try {
            CloneExample cloneExample = new CloneExample();
            cloneExample.a = 1;
            CloneExample cloneExample1 = cloneExample.clone();
            System.out.println(cloneExample == cloneExample1);
            System.out.println(cloneExample1.a);

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        List<String> list = new ArrayList<>();
        list.add("Hello");

        Vector<String> vector = new Vector<>();
        vector.add("Hello");

        /**
         * modCount 用来记录 ArrayList 结构发生变化的次数。结构发生变化是指添加或者删除至少一个元素的所有操作
         * ，或者是调整内部数组的大小，仅仅只是设置元素的值不算结构发生变化。
         *
         * 在进行序列化或者迭代等操作时，需要比较操作前后 modCount 是否改变
         * ，如果改变了需要抛出 ConcurrentModificationException。代码参考上节序列化中的 writeObject() 方法。
         */
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Hello");

        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.addLast("hello");
        linkedList.getFirst();
        PriorityQueue<String> priorityQueue = new PriorityQueue<>();
        priorityQueue.add("hello");
        priorityQueue.poll();
        priorityQueue.peek();

        List<String> list1 = Collections.synchronizedList(arrayList);

        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        copyOnWriteArrayList.add("");
        copyOnWriteArrayList.remove("");
        copyOnWriteArrayList.get(0);

        HashMap<String, String> map = new HashMap<>();
        map.put("Hello", "world");

        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("Hello");

        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("Hello", "World");

        WeakHashMap<String, String> weakHashMap = new WeakHashMap<>();
        weakHashMap.put("Hello", "World");
        weakHashMap.get("Hello");
    }
}
