package com.zw.base.test;

import java.lang.reflect.Method;
import java.util.*;

public class Test2 {

    public static void main(String[] args) {
//        t1();

//        System.out.println(getNum1());
//        System.out.println("***********************");
//        System.out.println(getNum2());

        // Collections.synchronizedList()

//        t2();

        B b = new B();
        A a = b;
        a.t();
        b.t();

        Collection collection = null;

        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("hello", "world");
    }

    /**
     * 动态代理,代理类是由虚拟机动态生成的
     */
    public static void t2() {
        List<String> list = new ArrayList<>();
        System.out.println(list.hashCode());
        DynamicProxy dynamicProxy = new DynamicProxy();
        List<String> p = dynamicProxy.newProxyInstance(list, new DynamicProxy.DynamicProxyInvocationHandler() {
            @Override
            public void onPreExecute(Object proxy, Method method, Object[] args) {
                System.out.println("before ......");
            }

            @Override
            public void onAfterExecute(Object proxy, Method method, Object[] args) {
                System.out.println("after ......");
                System.out.println(proxy.getClass().getName());
            }
        });

        p.add("hello");
        p.add("world");

        System.out.println(p.getClass().getName());
    }

    /**
     * StringTokenizer 字符串切割工具
     */
    public static void t1() {
        StringTokenizer st = new StringTokenizer("Hello World");
        while (st.hasMoreTokens()) {
            System.out.println(st.nextToken());
        }
    }

    /**
     * 异常机制有这么一个原则如果在catch中遇到了
     * return或者异常等能使该函数终止的话那么用finally
     * 就必须先执行完finally代码块里面的代码然后再返回值。
     */
    public static int getNum1() {
        try {
            int a = 1 / 0;
            return 1;
        } catch (Exception e) {
            System.out.println("1 ......");
            return 2;
        } finally {
            System.out.println("2 ......");
            return 3;
        }
    }

    public static int getNum2() {
        try {
            int a = 1 / 0;
            return 1;
        } catch (Exception e) {
            System.out.println("1 ......");
            return 2;
        } finally {
            System.out.println("2 ......");
        }
    }
}
