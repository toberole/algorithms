package com.zw.base.domain;

import java.io.Serializable;

public class Car implements Serializable {
    public String name;
    public int price;

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
