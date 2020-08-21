package com.zw.base.test;

import java.util.concurrent.*;

/**
 * 如果正在运行的线程数 < coreSize，马上创建线程执行该task，不排队等待；
 * 如果正在运行的线程数 >= coreSize，把该task放入阻塞队列；
 * 如果队列已满 && 正在运行的线程数 < maximumPoolSize，创建新的线程执行该task；
 * 如果队列已满 && 正在运行的线程数 >= maximumPoolSize，线程池调用handler的reject方法拒绝本次提交。
 */
public class TestThreadPool {
    public static ThreadPoolExecutor executor;

    // public static BlockingQueue<Runnable> workQueue = new LinkedBlockingDeque<>();
    public static BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(2);

    public static ThreadFactory threadFactory = new ThreadFactory() {
        @Override
        public Thread newThread(Runnable r) {
            System.out.println("newThread ...... " + r);
            return new Thread(r);
        }
    };

    public static RejectedExecutionHandler handler = new RejectedExecutionHandler() {

        @Override
        /**
         * 可以记录日志或者是任务持久化
         */
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            System.out.println("rejectedExecution ...... before");
            r.run();
            System.out.println("rejectedExecution ...... after");
        }
    };

    static {
        initExecutor();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            executor.execute(new MyRunnable(i));
        }

        try {
            Thread.sleep(1000 * 5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 线程数的选择：
     * 1、如果任务是IO密集型，一般线程数需要设置2倍CPU数以上，以此来尽量利用CPU资源。
     * 2、如果任务是CPU密集型，一般线程数量只需要设置CPU数加1即可，更多的线程数也只能增加上下文切换，
     * 不能增加CPU利用率。
     * <p>
     * 如果真的需要精确的控制，还是需要上线以后观察线程池中线程数量跟队列的情况来定。
     */
    private static void initExecutor() {
        /**
         *
         * Executors.newCachedThreadPool();
         * Executors.newSingleThreadExecutor();
         * Executors.newFixedThreadPool(1);
         *      newCachedThreadPool、newSingleThreadExecutor、newFixedThreadPool底层都是使用的ThreadPoolExecutor
         */

        /**
         * 周期性的执行任务 其中一个任务执行时间过长
         * 都会导致后续的任务阻塞
         */
        ScheduledExecutorService executors = Executors.newScheduledThreadPool(1);
        executors.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println(System.currentTimeMillis());
            }
        }, 0, 100, TimeUnit.MILLISECONDS);

        executor = new ThreadPoolExecutor(1, 1,
                10, TimeUnit.SECONDS, workQueue, threadFactory, handler);
        executor.allowCoreThreadTimeOut(true);
    }

    private static class MyRunnable implements Runnable {
        private int tag;

        public MyRunnable(int tag) {
            this.tag = tag;
        }

        @Override
        public void run() {
            System.out.println("tag: " + tag);
        }

        @Override
        public String toString() {
            return "MyRunnable{" +
                    "tag=" + tag +
                    '}';
        }
    }
}
