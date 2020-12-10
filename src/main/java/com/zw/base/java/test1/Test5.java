package com.zw.base.java.test1;

public class Test5 {
    public volatile int inc = 0;

    public void increase() {
        inc++;
    }

    public static void main(String[] args) {
        final Test5 test = new Test5();
        for (int i = 0; i < 10; i++) {
            new Thread() {
                public void run() {
                    for (int j = 0; j < 1000; j++)
                        test.increase();
                }
            }.start();
        }

        try {
            Thread.sleep(1000 * 5);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(test.inc);
    }
}
