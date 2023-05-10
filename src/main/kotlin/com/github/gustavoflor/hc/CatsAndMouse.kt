package com.github.gustavoflor.hc

import java.util.*
import kotlin.io.*
import kotlin.math.abs
import kotlin.text.*

fun catAndMouse(x: Int, y: Int, z: Int): String {
    val diffA = abs(x - z)
    val diffB = abs(y - z)
    if (diffA == diffB) {
        return "Mouse C"
    }
    return if (diffA < diffB) "Cat A" else "Cat B"
}

fun main() {
    val scan = Scanner(System.`in`)
    val q = scan.nextLine().trim().toInt()
    for (qItr in 1..q) {
        val xyz = scan.nextLine().split(" ")
        val x = xyz[0].trim().toInt()
        val y = xyz[1].trim().toInt()
        val z = xyz[2].trim().toInt()
        val result = catAndMouse(x, y, z)
        println(result)
    }
}
