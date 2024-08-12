package org.practice.array

import java.util.Stack
import kotlin.math.abs

fun asteroidCollision(asteroids: IntArray): IntArray {
    if (asteroids.size < 2) {
        return asteroids
    }
    val stack = Stack<Int>()

    for (asteroid in asteroids) {
        var flag = true
        while (stack.isNotEmpty() && stack.peek() > 0 && asteroid < 0) {
            if (abs(asteroid) > abs(stack.peek())) {
                stack.pop()
                continue
            } else if (abs(asteroid) == abs(stack.peek())) {
                stack.pop()
            }
            flag = false
            break
        }
        if (flag) {
            stack.push(asteroid);
        }
    }

    return stack.toIntArray()
}

fun main() {
    val result0 = asteroidCollision(intArrayOf(5,10,-5))
    val result1 = asteroidCollision(intArrayOf(8,-8))
    val result2 = asteroidCollision(intArrayOf(-2,-2,1,-2))
    println(result0.contentToString())
    println(result1.contentToString())
    println(result2.contentToString())
}