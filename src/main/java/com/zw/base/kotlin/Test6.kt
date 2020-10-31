package com.zw.base.kotlin

class Test6 constructor(name: String) {
    private var name: String

    init {
        this.name = name
        println("name: $name")
    }

    fun sys() {
        println("my name is ${this.name}")
    }

    class E_Test6 {
        fun sys() {
            println("Hello E_Test ......")
        }
    }

    inner class I_Test6 {
        fun sys() {
            println("I_Test $name")
        }
    }
}

fun main() {
    var t = Test6("hello")
    t.sys()
    var t2 = Test6.E_Test6()
    t2.sys()

    var t3 = t.I_Test6()
    t3.sys()
    println("end ......")
}