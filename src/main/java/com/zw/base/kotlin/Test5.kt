package com.zw.base.kotlin

import kotlinx.coroutines.*
import kotlin.coroutines.coroutineContext

fun main() {

//    var scope = MainScope()
//    scope.launch {
//        println("hello MainScrop ......")
//    }

    var scope = CoroutineScope(Dispatchers.Default)
    scope.launch {
        println("CoroutineScope ......")
    }
    runBlocking {
        var one = async {
            do_1()
        }

        var two = async {
            do_2()
        }

        println(one.await() + two.await())
    }
}

suspend fun do_2(): Int {
    delay(1000)
    return 1
}

suspend fun do_1(): Int {
    delay(2000)
    println("my job is ${coroutineContext[Job]}")
    return 2
}
