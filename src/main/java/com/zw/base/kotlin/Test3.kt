package com.zw.base.kotlin

import kotlinx.coroutines.*
import java.time.LocalDateTime
import java.util.*

/*
启动一个新的协程, 常用的主要有以下几种方式:
launch
async
runBlocking

关于scope目前有两个关键知识点:
1、我们开启一个协程的时候, 总是在一个CoroutineScope里.
2、Scope用来管理不同协程之间的父子关系和结构.

协程的父子关系有以下两个特性:
1、父协程被取消时, 所有的子协程都被取消.
2、父协程永远会等待所有的子协程结束.


值得注意的是, 也可以不启动协程就创建一个新的scope.
创建scope可以用工厂方法: MainScope()或CoroutineScope()

注意coroutineScope()方法也可以创建scope. 当我们需要以结构化的方式在suspend函数内部启动新的协程,
我们创建的新的scope, 自动成为suspend函数被调用的外部scope的child.

 */
fun main() {
    test()
    Thread.sleep(2000)
    System.out.println("end ......")
}

fun test() {
    // scope的主要作用就是记录所有的协程, 并且可以取消它们.
    // 创建一个协程作用域
    var c = CoroutineScope(Dispatchers.IO)
    c.launch {
        delay(1000)
        System.out.println("1 ......")
        c.cancel()
    }

    c.launch {
        delay(3000)
        System.out.println("1 ......")
    }
}

fun test1() {
    GlobalScope.launch(Dispatchers.IO) {
        System.out.println("hello coroutines ......")
    }

    // 异常处理 handler
    val handler = CoroutineExceptionHandler { _, exception ->
        System.out.println("Caught $exception")
    }

    GlobalScope.launch(handler) {
        throw RuntimeException("aaaaaaaaa ......")
    }

    Thread.sleep(1000)

    var calender = Calendar.getInstance()
    var hour = calender.get(Calendar.HOUR)
    var second = calender.get(Calendar.SECOND)
    System.out.println("hour: $hour,second: $second")

    var l = LocalDateTime.now()
    System.out.println("hour: ${l.hour},second: ${l.second}")

    GlobalScope.launch {
        async { test() }
    }


}