package com.zw.base.test;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 生产者 消费者
 */
public class P_C {
    public static Object lock = new Object();

    public static ReentrantLock reentrantLock = new ReentrantLock();

    // Condition可以更加细粒度的控制线程之间的同步
    public static Condition read_condition = reentrantLock.newCondition();
    public static Condition write_condition = reentrantLock.newCondition();

    public static ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public static int n = 0;

    public static void main(String[] args) {
//        test();
        test1();

        try {
            Thread.sleep(10);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void test2() {
        try {
            readWriteLock.readLock().lock();
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    private static void test() {
        c();
        p();
    }

    private static void test1() {
        Thread p = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        reentrantLock.lock();
                        while (n != 0) {
                            try {
                                write_condition.await();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }

                        n = 1;
                        System.out.println("生产 ......");
                        read_condition.signal();
                    } finally {
                        reentrantLock.unlock();
                    }
                }
            }
        });

        Thread c = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        reentrantLock.lock();
                        while (n == 0) {
                            try {
                                read_condition.await();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }

                        n = 0;
                        System.out.println("消费 ......\n");
                        write_condition.signal();
                    } finally {
                        reentrantLock.unlock();
                    }
                }
            }
        });

        p.start();
        c.start();
    }

    public static void c() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    synchronized (lock) {
                        while (n == 0) {
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }

                        System.out.println("消费: " + n);
                        System.out.println();
                        n = 0;
                        lock.notifyAll();
                    }
                }
            }
        }).start();
    }

    public static void p() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    synchronized (lock) {
                        while (n != 0) {
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }

                        n = 1;
                        System.out.println("生产: " + n);
                        lock.notifyAll();
                    }
                }
            }
        }).start();
    }
}
