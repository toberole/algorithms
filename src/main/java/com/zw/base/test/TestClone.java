package com.zw.base.test;

import com.zw.base.bean.Car;
import com.zw.base.bean.Person;

public class TestClone {
    public static void main(String[] args) {
        // test_clone();
        test_printClassLoader(TestClone.class.getClassLoader());
    }

    private static void test_clone() {
        try {
            Car car = new Car();
            car.name = "car1";
            car.price = 100;

            Person person = new Person();
            person.car = car;
            person.age = 11;
            person.name = "hello";

            Person p1 = person.clone();

            System.out.println(person);
            System.out.println(p1);

            System.out.println(person.car == p1.car);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void test_printClassLoader(ClassLoader cl) {
        if (cl == null) return;
        System.out.println(cl);
        test_printClassLoader(cl.getParent());
    }
}
