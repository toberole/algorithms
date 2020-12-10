package com.zw.base.java.test;

import com.zw.base.domain.Car;
import com.zw.base.domain.Person;
import com.zw.base.domain.Student;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class Test1 {
    public static void main(String[] args) {
//        t1();

//        t2();

//        t3();

        Car car1 = new Car();
        Car car2 = new Car();

        System.out.println(car1.hashCode());
        System.out.println(car2.hashCode());


    }

    private static void t3() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("1111111111 ......");
            }
        }) {
            @Override
            public void run() {
                // super.run();
                System.out.println("2222222222 ......");

            }
        }.start();

        Object object;
    }

    private static void t2() {
        List<Integer> list = new ArrayList<>();
        System.out.println(list.get(1));

        list = new LinkedList<>();
        list.add(1);

        Vector<Integer> vector = new Vector<>();
        Iterator<Integer> it = vector.iterator();
        vector.add(1);

        Hashtable<String, String> hashtable = new Hashtable<>();
        hashtable.put("hello", "world");

        Stack<String> stack = new Stack<>();
        stack.push("hello");


        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("hello", "world");

        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("hello");

        /**
         * COW 通俗的理解是当我们往一个容器添加元素的时候，不直接往当前容器添加，而是先将当前容器进行 Copy，
         * 复制出一个新的容器，然后新的容器里添加元素，添加完元素之后，再将原容器的引用指向新的容器。'
         * 对 CopyOnWrite 容器进行并发的读的时候，不需要加锁，因为当前容器不会添加任何元素。
         * 所以 CopyOnWrite 容器也是一种读写分离的思想，延时更新的策略是通过在写的时候针对的
         * 是不同的数据容器来实现的，放弃数据实时性达到数据的最终一致性。
         */
        CopyOnWriteArrayList<Integer> copyOnWriteArrayList = new CopyOnWriteArrayList();
        copyOnWriteArrayList.add(1);
        copyOnWriteArrayList.add(2);
        copyOnWriteArrayList.get(0);


        Exception exception;
        RuntimeException runtimeException;
        Error error;


    }

    public static void t1() {
        List<? super Student> pl = new ArrayList<>();
        pl.add(new Student());

        List<? extends Person> pl2 = new ArrayList<>();
        // error
        // pl2.add(new Student());

        int[] arr = {};
        System.out.println(arr.length);
    }
}
