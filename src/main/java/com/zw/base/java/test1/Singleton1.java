package com.zw.base.java.test1;

public class Singleton1 {
    private volatile static Singleton1 instance;

    private Singleton1() {
    }

    public static Singleton1 getInstance() {
        if (null == instance) {
            synchronized (Singleton1.class) {
                if (null == instance) {

                    /**
                     * instance = new Singleton1();
                     * 三步操作：
                     *   1、为 instance 分配内存空间
                     *   2、初始化 instance
                     *   3、将 instance 指向分配的内存地址
                     *
                     */
                    instance = new Singleton1();
                }
            }
        }
        return instance;
    }
}
