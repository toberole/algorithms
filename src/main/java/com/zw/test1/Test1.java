package com.zw.test1;

import java.util.concurrent.*;

public class Test1 {
    private static ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(10, 10, 10, TimeUnit.SECONDS, new LinkedBlockingDeque<>());

    public static void main(String[] args) {
//        test1();
        test2();
    }

    private static void test2() {
        try {
            poolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    int i  = 1/0;
                    System.out.println(i);
                }
            });
        }catch (Exception e){
            System.out.println("test2 ****** 1");
            e.printStackTrace();
            System.out.println("test2 ****** 2");
        }

        System.out.println("test2 end ......");
    }

    private static void test1() {
        FutureTask<String> futureTask = new FutureTask<>(new Runnable() {
            @Override
            public void run() {
                System.out.println("FutureTask#Runnable#run ......");
            }
        }, "Hello FutureTask");

        Future<String> future = (Future<String>) poolExecutor.submit(futureTask);

        try {
            System.out.println(future.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
