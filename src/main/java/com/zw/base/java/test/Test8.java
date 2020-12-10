package com.zw.base.java.test;

public class Test8 {
    private static int i = 0;

    public static void main(String[] args) {
        Object object = new Object();
        System.out.println(object);

        for (int j = 0; j < 1000; j++) {
            new Thread(() -> {
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                i++;
            }).start();
        }

        while (Thread.activeCount() > 1) {
            Thread.yield();
        }

        System.out.println("end ...... i: " + i);
    }
}
