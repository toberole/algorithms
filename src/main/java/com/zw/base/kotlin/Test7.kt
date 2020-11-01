package com.zw.base.kotlin

import kotlinx.coroutines.*

fun main() = runBlocking {
    val job = GlobalScope.launch() {
        launch {
            try {
                delay(100) // 当另一个同级的协程因 IOException  失败时，它将被取消
                throw ArithmeticException("hello ArithmeticException ......") // 第二个异常
            } catch (e: Exception) {
                println("Exception ......${e.message}")
            }
        }
    }
    job.join()
    println("Hello end ......")
}

//fun main() = runBlocking {
//    val handler = CoroutineExceptionHandler { _, exception ->
//        println("CoroutineExceptionHandler got $exception with suppressed ${exception.suppressed.contentToString()}")
//    }
//    val job = GlobalScope.launch(handler) {
//        launch {
//            try {
//                delay(Long.MAX_VALUE) // 当另一个同级的协程因 IOException  失败时，它将被取消
//            } finally {
//                throw ArithmeticException() // 第二个异常
//            }
//        }
//        launch {
//            delay(100)
//            throw IOException() // 首个异常
//        }
//        delay(Long.MAX_VALUE)
//    }
//    job.join()
//}