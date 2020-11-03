package com.zw.base.kotlin

/**
 * run, with, let, also and apply
 */
fun main() {
    var name: String = "hello"
    var i = name?.let {
        it.length
    }

    println(i)

    var i1 = name.run {
        length
    }
    println(i1)

    name.also {

    }

}