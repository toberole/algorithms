package com.zw.base.kotlin

/**
 * Kotlin
 *      "==" 调用的是equals
 *      "===" 比较的是引用地址
 */
class Student {
    init {
        println("init ......")
    }

    private var name: String

    constructor(name: String) {
        this.name = name
    }

    override fun equals(other: Any?): Boolean {
        return when (other) {
            !is Student -> false
            else -> this === other || this.name.equals(other.name)
        }
    }
}

fun main() {
    println("main ......")

    var student1 = Student("hello1")
    var student2 = Student("hello1")

    if (student1 == student2) {
        println("student1 == student2")
    }


    if (student1 === student2) {
        println("student1 === student2")
    }

}