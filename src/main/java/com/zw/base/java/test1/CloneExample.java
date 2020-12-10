package com.zw.base.java.test1;

public class CloneExample implements Cloneable {
    public int a;

    @Override
    protected CloneExample clone() throws CloneNotSupportedException {
        return (CloneExample) super.clone();
    }
}
