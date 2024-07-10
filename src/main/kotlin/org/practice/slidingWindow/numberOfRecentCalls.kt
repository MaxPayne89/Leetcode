package org.practice.slidingWindow

import java.util.LinkedList

class RecentCounter {

    private val list = mutableListOf<Int>()

    fun ping(t: Int): Int {
        list.add(t)
        val range = (t-3000)..t
        var i = list.lastIndex
        while (i >=0 && list[i] in range) {
            i--
        }
        return list.lastIndex - i
    }

    private val slidingWindow = LinkedList<Int>()

    fun pingO(t: Int): Int {
        slidingWindow.addLast(t)

        while (slidingWindow.first() < t - 3000) {
            slidingWindow.removeFirst()
        }

        return slidingWindow.size
    }

}

fun main() {
    val obj = RecentCounter()
    obj.ping(1)
    obj.ping(100)
    obj.ping(3001)
    val result = obj.ping(3002)
    println(result)
}