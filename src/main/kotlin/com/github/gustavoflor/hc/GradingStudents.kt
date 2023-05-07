package com.github.gustavoflor.hc

import java.util.Arrays
import kotlin.collections.*
import kotlin.io.*
import kotlin.ranges.*
import kotlin.text.*

/*
 * Complete the 'gradingStudents' function below.
 *
 * The function is expected to return an INTEGER_ARRAY.
 * The function accepts INTEGER_ARRAY grades as parameter.
 */

fun gradingStudents(grades: Array<Int>): Array<Int> {
    return Arrays.stream(grades)
        .map { grade -> roundGrade(grade) }
        .toArray { size -> arrayOfNulls<Int>(size) }
}

fun shouldApplyRounding(grade: Int): Boolean {
    return grade >= 38 && grade % 5 >= 3
}

fun roundGrade(grade: Int): Int {
    if (shouldApplyRounding(grade)) {
        return grade + (5 - (grade % 5))
    }
    return grade
}

fun main() {
    val gradesCount = readln().trim().toInt()

    val grades = Array(gradesCount) { 0 }
    for (i in 0 until gradesCount) {
        val gradesItem = readln().trim().toInt()
        grades[i] = gradesItem
    }

    val result = gradingStudents(grades)

    println(result.joinToString("\n"))
}
