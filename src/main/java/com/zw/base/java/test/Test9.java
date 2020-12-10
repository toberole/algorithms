package com.zw.base.java.test;

public class Test9 {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (Thread.currentThread().isInterrupted()) {
                    System.out.println("Test9 ******");
                }

                if (!Thread.currentThread().isInterrupted()) {
                    System.out.println("Test9 ...... is not Interrupted");
                } else {
                    System.out.println("Test9 ++++++ isInterrupted");
                }
            }
        });

        /**
         * 判断是否中断同时清除中断标记
         *
         * public static boolean interrupted() {
         *      return currentThread().isInterrupted(true);
         * }
         */
        Thread.interrupted();

        thread.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                thread.interrupt();
            }
        }).start();


        while (Thread.activeCount() > 1) {
            Thread.yield();
        }

        System.out.println("main end ......");
    }
}
