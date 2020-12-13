package com.zw.base.kotlin

class Test13 {
    var age: Int = 0
        set(value) {
            field = value
        }
        get() {
            return field
        }
}

fun main() {
    var t = Test13()
    t.age = 11;
    println(t.age)
}