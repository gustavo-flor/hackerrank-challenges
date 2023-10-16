package com.github.gustavoflor.hc

import java.util.*
import kotlin.collections.*
import kotlin.io.*
import kotlin.text.*

fun jumpingOnClouds(c: Array<Int>, k: Int): Int {
    var e = 100
    val n = c.size
    var i = 0
    var ended = false

    while (!ended) {
        val ni = (i + k) % n
        val v = c[ni]
        e--
        if (v == 1) {
            e = e - 2
        }
        i = ni
        if (i == 0) {
            ended = true
        }
    }

    return e
}

fun main() {
    val scan = Scanner(System.`in`)

    val nk = scan.nextLine().split(" ")

    val n = nk[0].trim().toInt()

    val k = nk[1].trim().toInt()

    val c = scan.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()

    val result = jumpingOnClouds(c, k)

    println(result)
}
