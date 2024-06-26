package org.practice

import kotlin.random.Random

class RandomizedSet {

    private val arr = mutableListOf<Int>()
    private val map = mutableMapOf<Int, Int>()

    fun insert(`val`: Int): Boolean =
        if (map.contains(`val`)) {
            false
        } else {
            arr.add(`val`)
            map[`val`] = arr.lastIndex
            true
        }


    fun remove(`val`: Int): Boolean =
        if (map.contains(`val`)) {
            val index = map[`val`]!!
            val temp = arr.last()

            arr[index] = temp
            map[temp] = index

            arr.removeAt(arr.lastIndex)
            map.remove(`val`)
            true
        } else {
            false
        }

    fun getRandom(): Int {
        val start = 0
        val end = arr.size
        val rand = Random.nextInt(start, end)
        return arr[rand]
    }

}

fun main() {
    val obj = RandomizedSet()
    val param_1 = obj.insert(0)
    val param_2 = obj.insert(1)
    val param_3 = obj.remove(0)
    val param_4 = obj.insert(2)
    val p5 = obj.remove(1)
//    val p6 = obj.insert(0)
    val p7 = obj.getRandom()
    println("insert 1 : $param_1")
    println("remove 2: $param_2")
    println("insert 2: $param_3")
    println("get rand: $param_4")
    println("remove 1: $p5")
//    println("insert 2 : $p6")
    println("get rand: $p7")
}