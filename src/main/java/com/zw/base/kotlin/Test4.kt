package com.zw.base.kotlin

open class TT4 constructor(val t: Int) {
    fun sys() {
        println(t)
    }

    fun sys1(hello: (name: String) -> Unit) {

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