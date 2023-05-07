package com.github.gustavoflor.hc

import kotlin.collections.*
import kotlin.io.*
import kotlin.math.abs
import kotlin.text.*

/*
 * Complete the 'getTotalX' function below.
 *
 * The function is expected to return an INTEGER.
 * The function accepts following parameters:
 *  1. INTEGER_ARRAY a
 *  2. INTEGER_ARRAY b
 */

fun getTotalX(a: Array<Int>, b: Array<Int>): Int {
    a.sort()
    b.sort()
    var lcm = a[0]
    for (int in a) {
        lcm = getLCM(lcm, int)
    }
    var gcd = b[0]
    for (int in b) {
        gcd = getGCD(gcd, int)
    }
    var result = 0
    var multiple = 0;
    while (multiple <= gcd) {
        multiple += lcm
        if (gcd % multiple == 0) {
            result++
        }
    }
    return result
}

fun getGCD(a: Int, b: Int): Int {
    if (b == 0) {
        return a
    }
    return getGCD(b, a % b)
}

fun getLCM(a: Int, b: Int): Int {
    if (a == 0 || b == 0) {
        return 0
    }
    val gcd = getGCD(a, b)
    return abs(a * b) / gcd
}

fun main() {
    val firstMultipleInput = readln().trimEnd().split(" ")

    val n = firstMultipleInput[0].toInt()

    val m = firstMultipleInput[1].toInt()

    val arr = readln().trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

    val brr = readln().trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

    val total = getTotalX(arr, brr)

    println(total)
}
