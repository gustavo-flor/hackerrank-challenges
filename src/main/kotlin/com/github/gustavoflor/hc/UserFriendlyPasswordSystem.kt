package com.github.gustavoflor.hc

import kotlin.collections.*
import kotlin.io.*
import kotlin.math.pow
import kotlin.ranges.*
import kotlin.text.*

fun authEvents(events: Array<Array<String>>): Array<Int> {
    val validPasswords = ArrayList<String>()
    val authorizations = ArrayList<Int>()
    for (event in events) {
        val action = event[0]
        val input = event[1]
        if (action == "setPassword") {
            validPasswords.clear()
            validPasswords.add(hash(input))
            for (i in 33..126) {
                validPasswords.add(hash(input + i.toChar()))
            }
            continue
        }
        if (action == "authorize") {
            if (validPasswords.contains(input)) {
                authorizations.add(1)
            } else {
                authorizations.add(0)
            }
            continue
        }
    }
    return authorizations.toTypedArray()
}

fun hash(input: String): String {
    var result = 0L
    for ((index, char) in input.chars().toArray().withIndex()) {
        result += if (index < input.length - 1) {
            (char * (131.toDouble().pow((input.length - 1 - index).toDouble()))).toLong()
        } else {
            char.toLong()
        }
    }
    return (result % (10.toDouble().pow(9.toDouble()) + 7)).toLong().toString()
}

fun main() {
    val eventsRows = readln().trim().toInt()
    val eventsColumns = readln().trim().toInt()
    val events = Array(eventsRows) { Array(eventsColumns) { "" } }
    for (i in 0 until eventsRows) {
        events[i] = readln().trimEnd().split(" ").toTypedArray()
    }
    val result = authEvents(events)
    println(result.joinToString("\n"))
}
