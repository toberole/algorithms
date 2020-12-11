package com.zw.base.java.test1;

public class Singleton2 {
    private Singleton2() {
    }

    public static Singleton2 getInstance() {
        return Singleton2Holder.singleton2;
    }

    private static class Singleton2Holder {
        public static Singleton2 singleton2 = new Singleton2();
    }
}
