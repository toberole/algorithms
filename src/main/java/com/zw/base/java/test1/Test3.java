package com.zw.base.java.test1;

import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test3 {
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void before() {
        lock.lock();
        try {
            System.out.println("before");
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void after() {
        lock.lock();
        try {
            condition.await();
            System.out.println("after");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Test3 example = new Test3();
        executorService.execute(() -> example.after());
        executorService.execute(() -> example.before());

        CountDownLatch countDownLatch = new CountDownLatch(3);

        final int totalThread = 10;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(totalThread);
        for (int i = 0; i < totalThread; i++) {
            executorService.execute(() -> {
                System.out.println("before..");
                try {
                    cyclicBarrier.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("after..");
            });
        }

        System.out.println("**********************");


        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        cyclicBarrier.reset();
        for (int i = 0; i < totalThread; i++) {
            executorService.execute(() -> {
                System.out.println("before..");
                try {
                    cyclicBarrier.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("after..");
            });
        }

        try {
            ForkJoinExample forkJoinExample = new ForkJoinExample(1, 10000);
            ForkJoinPool forkJoinPool = new ForkJoinPool();
            Future result = forkJoinPool.submit(forkJoinExample);

            System.out.println(result.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
