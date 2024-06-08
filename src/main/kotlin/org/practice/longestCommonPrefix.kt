package org.practice

fun longestCommonPrefix(strs: Array<String>): String {
    if (strs.size == 1) {
        return  strs[0]
    }
    val map = mutableMapOf<String, Int>()
    val first = strs.first()
    for (i in 1..first.length) {
        map[first.substring(0, i)] = i
    }
    var longestSeq = 0
    strs.forEachIndexed { index, word ->
        if (index == 0) {
            Unit
        } else {
            if (word.isEmpty()) return  ""
           for (i in word.length downTo 1) {
                val subby = word.substring(0, i)
                val longest = map[subby]
                if (longest != null) {
                    longestSeq = if (index == 1) longest else if (longest < longestSeq) longest else longestSeq
                    break
                }
                if (i == 1) {
                    longestSeq = 0
                }
            }
        }
    }
    return first.substring(0, longestSeq)
}

fun longestCommonPrefixOptimized(strs: Array<String>): String {
    if (strs.isEmpty()) return ""
    var prefix = strs[0]
    for (i in 1 until strs.size) {
        while (strs[i].indexOf(prefix) != 0) {
            prefix = prefix.substring(0, prefix.length - 1)
        }
    }
    return prefix
}

fun main() {
    val input = arrayOf("flower","flow","flight")
//    val input2 = arrayOf("a","a","b")
    val input3 = arrayOf("abab","aba","")
//    val a = longestCommonPrefixOptimized(input)
//    val b = longestCommonPrefix(input2)
    val c = longestCommonPrefixOptimized(input3)
//    println(a)
//    println(b)
    println(c)
}
