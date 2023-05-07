package com.github.gustavoflor.hc

import kotlin.collections.*
import kotlin.io.*
import kotlin.text.*

/*
 * Complete the 'countApplesAndOranges' function below.
 *
 * The function accepts following parameters:
 *  1. INTEGER s
 *  2. INTEGER t
 *  3. INTEGER a
 *  4. INTEGER b
 *  5. INTEGER_ARRAY apples
 *  6. INTEGER_ARRAY oranges
 */

fun countApplesAndOranges(
    houseEntrypoint: Int,
    houseEndpoint: Int,
    appleTreePoint: Int,
    orangeTreePoint: Int,
    apples: Array<Int>,
    oranges: Array<Int>
) {
    var applesLandInHouse = 0
    for (distance in apples) {
        if (isNegativeOrZero(distance)) {
            continue
        }
        val landsIn = appleTreePoint + distance
        if (landsIn in houseEntrypoint..houseEndpoint) {
            applesLandInHouse++
        }
    }

    var orangesLandInHouse = 0
    for (distance in oranges) {
        if (isPositiveOrZero(distance)) {
            continue
        }
        val landsIn = orangeTreePoint + distance
        if (landsIn in houseEntrypoint..houseEndpoint) {
            orangesLandInHouse++
        }
    }

    println(applesLandInHouse)
    println(orangesLandInHouse)
}

fun isNegativeOrZero(int: Int): Boolean {
    return int <= 0
}

fun isPositiveOrZero(int: Int): Boolean {
    return int >= 0
}

fun main() {
    val firstMultipleInput = readln().trimEnd().split(" ")

    val s = firstMultipleInput[0].toInt()

    val t = firstMultipleInput[1].toInt()

    val secondMultipleInput = readln().trimEnd().split(" ")

    val a = secondMultipleInput[0].toInt()

    val b = secondMultipleInput[1].toInt()

    val thirdMultipleInput = readln().trimEnd().split(" ")

    val m = thirdMultipleInput[0].toInt()

    val n = thirdMultipleInput[1].toInt()

    val apples = readln().trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

    val oranges = readln().trimEnd().split(" ").map{ it.toInt() }.toTypedArray()

    countApplesAndOranges(s, t, a, b, apples, oranges)
}
