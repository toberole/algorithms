package com.zw.test1;

public class Test2 {
    private static volatile int i = 0;

    private static void add_i() {
        i++;
    }

    public static void main(String[] args) {
        for (int j = 0; j < 100; j++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    for (int k = 0; k < 100; k++) {
                        add_i();
                    }
                }
            }).start();
        }

        try {
            Thread.sleep(1000 * 10);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(i);
    }
}
