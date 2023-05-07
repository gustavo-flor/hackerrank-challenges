package com.github.gustavoflor.hc

import java.lang.IllegalArgumentException

fun chiefHopper(arr: Array<Int>): Int {
    var minBotEnergy = 0.0
    for (i in arr.size - 1 downTo 0) {
        val height = arr[i]
        val delta = minBotEnergy + height
        val newBotEnergy = Math.ceil(delta / 2)
        minBotEnergy = newBotEnergy
    }
    return minBotEnergy.toInt()
}

fun main() {
    val n = readln().trim().toInt()

    val arr = readln().trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

    if (arr.size == n) {
        throw IllegalArgumentException()
    }

    val result = chiefHopper(arr)

    println(result)
}