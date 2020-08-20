package com.zw.base.test;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class Test5_Thread {
    public static void main(String[] args) {
        // test1();
        // test2();
        test3();
    }

    /**
     * public void interrupt()	试图中断调用线程，设置中断标志位为 false
     * public boolean isInterrupted()	返回调用线程是否被中断
     * public static boolean interrupted()	返回当前线程是否被中断的状态值，同时将中断标志位复位（设为 false）
     */
    private static void test3() {
        try {
            Thread thread = new MyTread1();
            thread.start();
            Thread.sleep(2000);
            thread.interrupt();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void test2() {
        try {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(2000);
                        System.out.println("run 1 ......");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            thread.start();

            Thread thread1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000);
                        System.out.println("run 2 ......");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            thread1.start();

            thread.join();
            thread1.join();

            System.out.println("****** ......" + thread.isAlive());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void test1() {
        try {
            MyThread myThread = new MyThread();
            myThread.start();

            Thread thread = new Thread(new MyRunnable());
            thread.start();

            MyCallback callback = new MyCallback();
            FutureTask<String> futureTask = new FutureTask<>(callback);
            Thread thread1 = new Thread(futureTask);
            thread1.start();
            String s = futureTask.get();
            System.out.println(s);

            Thread.sleep(2000);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class MyTread1 extends Thread {
        @Override
        public void run() {
            /**
             * isInterrupted() 在刚创建时默认为 false 不用多说；
             * 线程有许多方法可以响应中断（比如 Thread.sleep()，Thread.wait()），
             * 这些方法在收到中断请求、抛出 InterruptedException 之前，
             * JVM 会先把该线程的中断标志位复位，这时调用 isInterrupted 将会返回 false；
             * 线程结束后，线程的中断标志位也会复位为 false。
             */
            while (!interrupted()) {
                try {
                    //Thread.sleep(500);
                    System.out.println("MyThread1 ......");
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("MyTread1 在 sleep 时被中断了，此时中断标志位为：" + isInterrupted());
                }
            }

            System.out.println("MyTread1 interrupted true ......");
        }
    }

    private static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("MyThread ......");
        }
    }

    private static class MyRunnable implements Runnable {

        @Override
        public void run() {
            System.out.println("MyRunnable ......");
        }
    }

    private static class MyCallback implements Callable<String> {

        @Override
        public String call() throws Exception {
            return "Hello World!";
        }
    }
}
