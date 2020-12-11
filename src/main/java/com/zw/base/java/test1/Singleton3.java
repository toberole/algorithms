package com.zw.base.java.test1;

public enum Singleton3 {
    INSTANCE;

    private String s = null;

    public void setS(String s) {
        this.s = s;
    }

    void test() {
        System.out.println("Hello Test");
    }

    public static void main(String[] args) {
        Singleton3.INSTANCE.test();

        System.out.println(Singleton3.INSTANCE.hashCode());
        System.out.println(Singleton3.INSTANCE.hashCode());
    }
}
