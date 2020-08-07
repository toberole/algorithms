package com.zw.base;

import java.io.Serializable;

public class Person implements Serializable, Cloneable {
    public Car car;

    public int age;
    public String name;

    @Override
    public Person clone() throws CloneNotSupportedException {
        System.out.println("Person#clone ......");
        return (Person) Person.super.clone();
    }

    @Override
    public String toString() {
        return "Person{" +
                "car=" + car +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
