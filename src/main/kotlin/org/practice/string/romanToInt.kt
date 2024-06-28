package org.practice.string

val romanNumeralsMap = mapOf(
    "I" to 1,
    "V" to 5,
    "X" to 10,
    "L" to 50,
    "C" to  100,
    "D" to 500,
    "M" to 1000,
    "IV" to 4,
    "IX" to 9,
    "XL" to 40,
    "XC" to 90,
    "CD" to 400,
    "CM" to 900
)

fun romanToInt(s: String): Int {
    var i = 0
    var sum = 0
    val cArr = s.toCharArray()
    while (i < cArr.size) {
        if (i +1 > cArr.lastIndex) {
            sum += romanNumeralsMap[cArr[i].toString()]!!
            break
        }
        val sub = cArr[i].toString() + cArr[i+1].toString()
        if (romanNumeralsMap[sub] != null) {
            sum += romanNumeralsMap[sub]!!
             i += 2
        } else {
            sum += romanNumeralsMap[cArr[i].toString()]!!
            i += 1
        }
    }
    return sum
}

fun romanToIntOptimized(s: String): Int {
    var sum = 0
    var prev = 0
    for (ch in s.toCharArray()) {
        when (ch) {
            'I' -> {
                sum += 1
                prev = 1
            }
            'V' -> {
                sum += if (prev == 1) 3 else 5
                prev = 5
            }
            'X' -> {
                sum += if (prev == 1) 8 else 10
                prev = 10
            }
            'L' -> {
                sum += if (prev == 10) 30 else 50
                prev = 50
            }
            'C' -> {
                sum += if (prev == 10) 80 else 100
                prev = 100
            }
            'D' -> {
                sum += if (prev == 100) 300 else 500
                prev = 500
            }
            'M' -> {
                sum += if (prev == 100) 800 else 1000
                prev = 1000
            }
        }
    }
    return sum
}

fun main() {
    val a = romanToInt("III")
    val a1 = romanToIntOptimized("III")
    val b = romanToInt("LVIII")
    val b1 = romanToIntOptimized("LVIII")
    val c = romanToInt("MCMXCIV")
    val c1 = romanToIntOptimized("MCMXCIV")
    println(a)
    println(a1)
    println(b)
    println(b1)
    println(c)
    println(c1)
}