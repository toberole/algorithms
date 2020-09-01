package com.zw.base.test;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Test6 {
    public static void main(String[] args) {
        System.out.println("Hello SO ......");
    }

    private static void test() {
        System.loadLibrary("jni_test");
        native_test();

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 1, TimeUnit.SECONDS, new LinkedBlockingDeque<>());
        threadPoolExecutor.execute(null);
    }

    private static native void native_test();
}
