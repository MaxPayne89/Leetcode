package org.practice.graph

import java.util.Stack

fun canVisitAllRooms(rooms: List<List<Int>>): Boolean {
    val seen = MutableList(rooms.size) { false }
    seen[0] = true
    val stacky = Stack<Int>()
    stacky.push(0)

    while (stacky.isNotEmpty()) {
        val node = stacky.pop()
        for (key in rooms[node]) {
            if (!seen[key]) {
                seen[key] = true
                stacky.push(key)
            }
        }
    }

    return !seen.any { !it }
}

fun main() {
    println(canVisitAllRooms(listOf(listOf(1), listOf(2), listOf(3), listOf()))) // true
    println(canVisitAllRooms(listOf(listOf(1, 3), listOf(3, 0, 1), listOf(2), listOf(0)))) // false
}