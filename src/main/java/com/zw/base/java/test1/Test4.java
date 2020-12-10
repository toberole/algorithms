package com.zw.base.java.test1;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Exchanger;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;
import java.util.concurrent.locks.LockSupport;

public class Test4 {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> unmodifiableMap = Collections.unmodifiableMap(map);
        // java.lang.UnsupportedOperationException
        // unmodifiableMap.put("a", 1);

        AtomicInteger atomicInteger = new AtomicInteger(1);
        System.out.println(atomicInteger.getAndIncrement());
        System.out.println(atomicInteger.getAndIncrement());
        atomicInteger.incrementAndGet();

        AtomicStampedReference<String> atomicStampedReference = new AtomicStampedReference<>("Hello", 1);
        System.out.println(atomicStampedReference.getStamp());
        AtomicReference<String> atomicReference = new AtomicReference<>();
        atomicReference.set("Hello");

        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        threadLocal.set("Hello");
        threadLocal.set("World");
        threadLocal.get();
        threadLocal.remove();

        InheritableThreadLocal<String> inheritableThreadLocal = new InheritableThreadLocal<>();
        inheritableThreadLocal.set("Hello");

        LockSupport.park();


        Exchanger exchanger = new Exchanger();


    }
}
