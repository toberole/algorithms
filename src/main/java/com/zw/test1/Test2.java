package com.zw.test1;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.*;

public class Test2 {
    private static volatile int i = 0;

    private static void add_i() {
        i++;
    }

    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 1, TimeUnit.MINUTES, new SynchronousQueue());
        threadPoolExecutor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello World!");
            }
        });
    }

    public static void main1(String[] args) {
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

    private void test1() {
        try {
            FutureTask<String> futureTask = new FutureTask<String>(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    return null;
                }
            }) {
                @Override
                protected void done() {
                    super.done();
                }
            };

            new Thread(futureTask).start();

            System.out.println(futureTask.get());


            futureTask = new FutureTask<String>(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    return null;
                }
            });

            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                    1, 1, 1,
                    TimeUnit.MINUTES, new LinkedBlockingQueue<>(),
                    new ThreadFactory() {
                        @Override
                        public Thread newThread(@NotNull Runnable r) {
                            return null;
                        }
                    }, new RejectedExecutionHandler() {
                @Override
                public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {

                }
            });

            threadPoolExecutor.allowCoreThreadTimeOut(true);
            threadPoolExecutor.execute(new Runnable() {
                @Override
                public void run() {

                }
            });

            Future<String> f = threadPoolExecutor.submit(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    return null;
                }
            });

            String s = f.get();

            threadPoolExecutor.execute(futureTask);

            ExecutorService executorService = Executors.newFixedThreadPool(1);
            executorService = Executors.newCachedThreadPool();
            executorService = Executors.newSingleThreadExecutor();
            executorService = Executors.newScheduledThreadPool(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
