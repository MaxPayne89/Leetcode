package org.practice

fun isValid(s: String): Boolean {
    val stack = ArrayDeque<Char>()

    s.forEach { char ->
        if (char ==  '(' || char == '{' || char == '[' ) {
            stack.addLast(char)
        } else {
            when (char) {
                ')' -> {
                    if (stack.isEmpty()) return false
                    if (stack.last() == '(') stack.removeLast() else return false
                }
                '}' -> {
                    if (stack.isEmpty()) return false
                    if (stack.last() == '{') stack.removeLast() else return false
                }
                ']' -> {
                    if (stack.isEmpty()) return false
                    if (stack.last() == '[') stack.removeLast() else return false
                }
            }
        }
    }
    return stack.isEmpty()
}

fun main() {
    val input0 = "([)]"
    val input1 = "()[]{}"
    val input3 = "(])"
    val a = isValid(input0)
    val b = isValid(input1)
    val c = isValid(input3)
    println(a)
    println(b)
    println(c)
}