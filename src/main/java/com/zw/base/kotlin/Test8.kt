package com.zw.base.kotlin

class Test8 {
    var name: String
        get() {
            return "hello"
        }
        set(value) {
            name = value
        }

    fun sys1(i: Int, block: (i: Int) -> Unit) {
        block(i)
    }
}

fun main() {
    var t = Test8()
    t.sys1(8, { i ->
        println(i)
    })
    println("Hello Main ......")
}