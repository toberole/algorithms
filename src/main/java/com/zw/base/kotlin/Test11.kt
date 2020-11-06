package com.zw.base.kotlin

import java.text.SimpleDateFormat
import java.util.*

const val ONE_DATE = 24 * 60 * 60 * 1000

fun calTime(lastTime: Long): String {
    var nowTime = System.currentTimeMillis() + 2 * ONE_DATE
    var nowTimeDate = Date(nowTime)

    var lastTimeDate = Date(lastTime)

    var sf = SimpleDateFormat("yyyy-MM-dd")

    var s1 = sf.format(nowTimeDate)
    var s2 = sf.format(lastTime)

    if (s1 == s2) { // "同一天"
        return SimpleDateFormat("HH:mm").format(lastTimeDate)
    } else {
        var yesterdayMax = nowTime - nowTime % ONE_DATE
        var yesterdayMin = yesterdayMax - ONE_DATE

        if (lastTime > yesterdayMin && lastTime <= yesterdayMax) {
            return "昨天"
        } else {
            var diff_day = (nowTime - lastTime) / ONE_DATE

            println("diff_day: $diff_day")

            if (diff_day >= 7) {
                return SimpleDateFormat("yyyy/MM/dd").format(lastTimeDate)
            } else {
                var day = nowTimeDate.day
                var n = day - diff_day
                println("n: $n")
                if (n < 0) {// 上一周
                    return "星期${7 + n}"
                } else { // 本周
                    return SimpleDateFormat("E").format(lastTimeDate)
                }
            }
        }
    }
}

fun main() {
    var lastTime = System.currentTimeMillis() - (1.5f * ONE_DATE).toLong()

    println(calTime(lastTime))
}