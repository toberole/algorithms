package com.zw.base.java.test1;

import java.util.concurrent.*;

/*
Executor 的中断操作
    调用 Executor 的 shutdown() 方法会等待线程都执行完毕之后再关闭，
    但是如果调用的是 shutdownNow() 方法，
    则相当于调用每个线程的 interrupt() 方法。
 */
public class Test2 {
    public static void main(String[] args) {
        try {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("1 ...... Runnable");
                }
            }) {
                @Override
                public void run() {
                    super.run();
                    System.out.println("1 ......");
                }
            };
            thread.start();

            Thread thread1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("2 ......");
                }
            });
            thread1.start();

//            thread.interrupt();
//            thread.interrupted();
//            thread.isInterrupted();

            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10,
                    10,
                    30,
                    TimeUnit.SECONDS,
                    new LinkedBlockingDeque<>());
            threadPoolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("3 ......");
                }
            });

            FutureTask<String> futureTask = new FutureTask<String>(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    return "Hello World";
                }
            });
            Thread thread2 = new Thread(futureTask);
            thread2.start();
            futureTask.cancel(true);
            System.out.println(futureTask.get());


            Future<String> future = threadPoolExecutor.submit(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    return "hello";
                }
            });
            System.out.println(future.get());

            ExecutorService executorService = Executors.newCachedThreadPool();
            for (int i = 0; i < 5; i++) {
                executorService.execute(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println(Thread.currentThread().getId() + ",4 ......");
                    }
                });
            }
            executorService.shutdown();
            executorService.shutdownNow();


            Thread.sleep(500);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
