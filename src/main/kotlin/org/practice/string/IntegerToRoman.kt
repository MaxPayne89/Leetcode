package org.practice.string

fun intToRoman(num: Int): String {
    var number = num
    val r = StringBuilder("")
    while (number > 0) {
        val num = number.toString().toCharArray().first()
        number = if (num == '4' || num == '9'){
            add(number, r)
        } else {
            subtract(number, r)
        }
    }
    return r.toString()
}

val values = arrayOf(1000, 900 , 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1)
val symbols = arrayOf("M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I")

fun intToRomanO(num: Int): String {
    val sb = StringBuilder("")
    var number = num
    var i = 0

    while (i < values.size && number > 0) {
        while (values[i] <= number) {
            sb.append(symbols[i])
            number -= values[i]
        }
        i++
    }
    return sb.toString()
}

private fun subtract(number: Int, r: StringBuilder): Int {
    var number1 = number
    when {
        number1 >= 1000 -> {
            r.append("M")
            number1 -= 1000
        }

        number1 >= 500 -> {
            r.append("D")
            number1 -= 500
        }

        number1 >= 100 -> {
            r.append("C")
            number1 -= 100
        }

        number1 >= 50 -> {
            r.append("L")
            number1 -= 50
        }

        number1 >= 10 -> {
            r.append("X")
            number1 -= 10
        }

        number1 >= 5 -> {
            r.append("V")
            number1 -= 5
        }

        else -> {
            r.append("I")
            number1 -= 1
        }
    }
    return number1
}

private fun add(number: Int, r: StringBuilder): Int {
    var number1 = number
    when {
        number1 >= 900 -> {
            r.append("CM")
            number1 -= 900
        }

        number1 >= 400 -> {
            r.append("CD")
            number1 -= 400
        }

        number1 >= 90 -> {
            r.append("XC")
            number1 -= 90
        }

        number1 >= 40 -> {
            r.append("XL")
            number1 -= 40
        }

        number1 >= 9 -> {
            r.append("IX")
            number1 -= 9
        }

        else -> {
            r.append("IV")
            number1 -= 4
        }
    }
    return number1
}

fun main() {
    val input = 3749
    val a = intToRomanO(input)
    println(a)
}