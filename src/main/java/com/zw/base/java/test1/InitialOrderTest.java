package com.zw.base.java.test1;

/**
 * 存在继承的情况下，初始化顺序为：
 *
 * 父类（静态变量、静态语句块）
 * 子类（静态变量、静态语句块）
 * 父类（实例变量、普通语句块）
 * 父类（构造函数）
 * 子类（实例变量、普通语句块）
 * 子类（构造函数）
 */
public class InitialOrderTest {
    public static String staticField = "静态变量";

    static {
        System.out.println("静态语句块");
    }

    public String field = "实例变量";

    {
        System.out.println("普通语句块");
    }

    public InitialOrderTest() {
        System.out.println("构造函数");
    }
}
