package com.github.gustavoflor.hc

import java.io.*
import java.math.*
import java.text.*
import java.util.*
import java.util.regex.*

/*
 * Complete the getMoneySpent function below.
 */
fun getMoneySpent(keyboards: Array<Int>, drives: Array<Int>, budget: Int): Int {
    val cheapestKeyboard = keyboards.min()!!
    val cheapestDrive = drives.min()!!
    if (cheapestKeyboard + cheapestDrive > budget) {
        return -1
    }
    val combinations = ArrayList<Int>()
    for (keyboard in keyboards) {
        for (drive in drives) {
            combinations.add(keyboard + drive)
        }
    }
    return combinations.stream().max(Comparator.naturalOrder()).get()
}

fun main() {
    val scan = Scanner(System.`in`)
    val bnm = scan.nextLine().split(" ")
    val b = bnm[0].trim().toInt()
    val n = bnm[1].trim().toInt()
    val m = bnm[2].trim().toInt()
    val keyboards = scan.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()
    val drives = scan.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()
    val moneySpent = getMoneySpent(keyboards, drives, b)
    println(moneySpent)
}
