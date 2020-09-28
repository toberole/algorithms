package com.zw.base.domain;

// import com.zw.base.test.Bean;

import java.io.Serializable;
import java.util.Objects;

public class Person implements Serializable, Cloneable {
    public Car car;
    //   public Bean bean;

    public int age;
    public String name;

    @Override
    public Person clone() throws CloneNotSupportedException {
        System.out.println("Person#clone ......");
        return (Person) Person.super.clone();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(car, person.car) &&
                Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(car, age, name);
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
