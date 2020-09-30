package com.zw.base.test;

import org.jetbrains.annotations.NotNull;
import sun.misc.Unsafe;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.HttpURLConnection;
import java.util.concurrent.*;
import java.util.concurrent.locks.LockSupport;

/**
 * LockSupport 与Object[wait/notify]区别：
 * LockSupport是面向Thread的
 * Object的方式是面向Object阻塞监视器
 */
public class Test_ThreadPoolExecutor {
    public static final String blocker = "Hello Blocker";

    public static void main(String[] args) {
//        test2();
        test3();

        while (Thread.activeCount() > 1) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void test4() {
        Unsafe.getUnsafe().addressSize();
    }

    private static void test3() {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                // 挂起当前线程
                LockSupport.park(blocker);
                System.out.println("thread1 LockSupport.park");
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    System.out.println("thread2 LockSupport.unpark blocker: " + LockSupport.getBlocker(thread1));
                    // 唤醒thread1线程
                    LockSupport.unpark(thread1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        try {
            thread1.start();
            Thread.sleep(100);// 确保thread1先运行起来
            thread2.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    /**
     * 配置线程池ThreadPoolExecutor需要考虑哪些因素
     * 从任务的优先级，任务的执行时间长短，任务的性质（CPU密集/ IO密集），任务的依赖关系这四个角度来分析。
     * 并且尽可能地使用有界的工作队列。
     * <p>
     * 性质不同的任务可用使用不同规模的线程池分开处理：
     * - CPU密集型：尽可能少的线程，Ncpu+1
     * - IO密集型：尽可能多的线程, Ncpu*2，比如数据库连接池
     * - 混合型：CPU密集型的任务与IO密集型任务的执行时间差别较小，拆分为两个线程池；否则没有必要拆分。
     * <p>
     * ctl 代表线程池当前状态和线程数量. 32位,前三位代表状态,后29位为线程最大的线程数量
     * private static int runStateOf(int c)     { return c & ~CAPACITY; } //获取当前线程池的状态
     * private static int workerCountOf(int c)  { return c & CAPACITY; } //获取当前线程池中线程数量
     * private static int ctlOf(int rs, int wc) { return rs | wc; } //构造ctl值
     * private final HashSet<Worker> workers = new HashSet<Worker>(); //线程池线程
     * private final ReentrantLock mainLock = new ReentrantLock(); //在add to workes的时候用的全局锁
     */
    private static void test2() {
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(
                1, 1,
                1, TimeUnit.MINUTES,
                new LinkedBlockingDeque<>(), new ThreadFactory() {
            @Override
            public Thread newThread(@NotNull Runnable r) {
                return new Thread(r);
            }
        }, new RejectedExecutionHandler() {// RejectedExecutionHandler 饱和策略
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {

            }
        });

        FutureTask<String> futureTask = new FutureTask<>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(1000);
                return "****** hello futureTask ******";
            }
        });

        poolExecutor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello world");
            }
        });

        poolExecutor.submit(futureTask);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String s1 = futureTask.get(500, TimeUnit.MILLISECONDS);
                    System.out.println("111111: " + s1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String s1 = futureTask.get();
                    System.out.println("222222: " + s1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String s = futureTask.get();
                    System.out.println("333333: " + s);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();


        //  LockSupport.park();

    }

    private static void test1() {
        try {

            final String s = "hello world";
            int len = s.length();
            int arr[] = new int[10];
            int n = arr.length;
            System.out.println(1);

            Error error = new Error();
            error.setStackTrace(new StackTraceElement[0]);

            ObjectInputStream objectInputStream;
            ObjectOutputStream objectOutputStream;

            return;
        } catch (Exception e) {
            System.out.println(2);
        } finally {
            System.out.println(3);
        }
    }

    private void test() {
        HttpURLConnection httpURLConnection = null;
        httpURLConnection.getContentLengthLong();
    }
}
