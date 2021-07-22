package com.zw.base.java.test1;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class Test9 {
    private static BlockingDeque<String> stringBlockingDeque = new LinkedBlockingDeque<>();

    private static volatile int k1 = 100;
    private static volatile int k2 = 100;

    private static void p() {
        new Thread(() -> {
            while (k1 > 0) {
                synchronized (Test9.class) {
                    try {
                        stringBlockingDeque.put("hello " + System.currentTimeMillis());
                        k1--;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    private static void c() {
        new Thread(() -> {
            while (k2 > 0) {
                synchronized (Test9.class) {
                    try {
                        String s = stringBlockingDeque.take();
                        System.out.println(s);
                        k2--;
                    } catch (Exception e) {
                        e.printStackTrace();
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
