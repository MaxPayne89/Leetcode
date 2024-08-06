package org.practice.string

fun compress(chars: CharArray): Int {
    var i = 0
    var result = 0

    while (i < chars.size) {
        var groupLength = 1
        while (i + groupLength < chars.size && chars[i+groupLength] == chars[i]) {
            groupLength++
        }
        chars[result++] = chars[i]
        if (groupLength > 1) {
            for (char in groupLength.toString()) {
                chars[result++] = char
            }
        }
        i += groupLength
    }

    return result
}

fun main() {
    println(compress(charArrayOf('a','a','a','b','b','a','a')).toString()) // 6
//    println(compress(charArrayOf('a','b','b','b','b','b','b','b','b','b','b','b','b')).toString()) // 4
}