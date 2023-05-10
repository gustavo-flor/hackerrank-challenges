package com.github.gustavoflor.hc

import kotlin.io.*

fun renameFile(newName: String, oldName: String): Int {
    // Write your code here
    return 0
}

fun main() {
    val newName = readln()
    val oldName = readln()
    val result = renameFile(newName, oldName)
    println(result)
}
