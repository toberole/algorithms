package com.zw.base.java.test1;

public class Test8 {
    private volatile static int i = 0;

    private volatile static int k1 = 100;
    private volatile static int k2 = 100;

    private static Object o1 = new Object();

    public static void p() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (k1 > 0) {
                    synchronized (o1) {
                        while (i != 0) {
                            try {
                                o1.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        System.out.println("++++++ p k1: " + k1);
                        i = 1;
                        k1--;
                        o1.notify();
                    }
                }
            }
        }).start();
    }

    public static void c() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (k2 > 0) {
                    synchronized (o1) {
                        while (i == 0) {
                            try {
                                o1.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }

                        System.out.println("@@@@@@ c k2: " + k2);
                        i = 0;
                        k2--;
                        o1.notify();
                    }

                }
            }
        }).start();
    }

    public static void main(String[] args) {
        p();
        c();

        try {
            Thread.sleep(1000 * 10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
