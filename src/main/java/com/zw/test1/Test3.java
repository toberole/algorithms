package com.zw.test1;

import org.jetbrains.annotations.NotNull;
import sun.awt.image.ImageWatched;

import java.util.concurrent.*;

public class Test3 {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                1, 1, 1, TimeUnit.MINUTES, new LinkedBlockingQueue<>(), new ThreadFactory() {
            @Override
            public Thread newThread(@NotNull Runnable r) {
                Thread t = new Thread("test");
                return t;
            }
        }, new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {

            }
        }
        );
    }
}
