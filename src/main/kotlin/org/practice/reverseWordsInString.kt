package org.practice

fun reverseWords(s: String): String {
    val t = s.trim()
    val string = StringBuilder()
    val word = StringBuilder()
    for (i in t.toCharArray().lastIndex downTo 0) {
        if (t[i].isLetterOrDigit()) {
            word.append(t[i])
        } else {
            string.append(word.reverse())
            word.setLength(0)
            if (t[i -1 ].isWhitespace()) {
                continue
            } else {
                string.append(t[i])
            }
        }
    }
    string.append(word.reverse())
    return string.toString()
}

fun main() {
    val a = reverseWords("EPY2giL")
    println(a)
}