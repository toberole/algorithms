package com.zw.base.kotlin

class HTML {
    fun body() {
        println("body ......")
    }

    fun body1(i: Int) {
        println("body1 i = $i")
    }
}

// 带有接受者的函数字面值
fun html(init: HTML.() -> Unit): HTML {
    // 创建接收者对象
    val h = HTML()

    // 将该接收者对象传给该 lambda
    // 在lambal中就隐式的使用对象h
    h.init()

    return h
}

fun main() {
    html {       // 带接收者的 lambda 由此开始
        body()   // 调用该接收者对象的一个方法
        body1(1)
    }
}