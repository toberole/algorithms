package com.zw.test1;

public class Test4 {
    private volatile static int i = 0;

    private static Object lock = new Object();

    private volatile static int k1 = 5;
    private volatile static int k2 = 5;

    private static void p() {
        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        while (k1 != 0) {
                            synchronized (lock) {
                                while (i == 1) {
                                    try {
                                        lock.wait();
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                                k1--;
                                i = 1;
                                System.out.println("p ......");
                                lock.notifyAll();
                            }
                        }
                    }
                }
        ).start();
    }

    private static void c() {
        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        while (k2 != 0) {
                            synchronized (lock) {
                                while (i == 0) {
                                    try {
                                        lock.wait();
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                                k2--;
                                i = 0;
                                System.out.println("c ......");
                                lock.notifyAll();
                            }
                        }
                    }
                }
        ).start();
    }

    public static void main(String[] args) {
        c();
        p();

        try {
            Thread.sleep(1000 * 10);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
