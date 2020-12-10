package com.zw.base.java.test;

public class B extends A {
    // 注意子类重写父类的static方法
    // 不具有多态的作用
    public static void t() {
        System.out.println("B#t ......");
    }
}
