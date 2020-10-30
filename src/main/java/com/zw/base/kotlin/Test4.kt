package com.zw.base.kotlin

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.supervisorScope

open class TT4 constructor(val t: Int) {
    fun sys() {
        println(t)
    }

    suspend fun sys1(hello: (name: String) -> Unit) {
        /**
         * coroutineScope和supervisorScope的区别在于：
         *      coroutineScope会在任意一个协程发生异常后取消所有的子协程的运行，
         *      而supervisorScope并不会取消其他的子协程。
         */
        coroutineScope {
            launch {
                println("1 ......")
            }

            launch {
                println("2 ......")
            }
        }

        supervisorScope {
            launch {
                println("3 ......")
            }

            launch {
                println("4 ......")
            }
        }
    }


}

fun main() {
    var arr: IntArray = intArrayOf(1, 2, 3)
    for (item in arr) {
        println(item)
    }

    arr = IntArray(10)
    arr[0] = 10
    arr[1] = 11
    arr[2] = 12
    arr[3] = 13
    arr[4] = 14
    for (item in arr) {
        println(item)
    }

    listOf<Int>(1, 2, 3).forEach {

    }

    println(arr.size)

    var tt = TT4(1)
    tt.sys()

}