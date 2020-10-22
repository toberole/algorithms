package com.zw.base.kotlin

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


fun main() {
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

}