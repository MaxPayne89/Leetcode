package org.practice.graph

fun findCircleNum(isConnected: Array<IntArray>): Int {
    var provinces = 0
    val visit = MutableList(isConnected.size) { false }

    for (row in isConnected.indices) {
        if (!visit[row]) {
            provinces++
            dfs(row, isConnected, visit)
        }
    }

    return provinces
}

private fun dfs(node: Int, isConnected: Array<IntArray>, visit: MutableList<Boolean>) {
    visit[node] = true
    for (i in 0..isConnected.lastIndex) {
        if (isConnected[node][i] == 1 && !visit[i]) {
            dfs(i, isConnected, visit)
        }
    }
}

fun main() {
    println(findCircleNum(arrayOf(intArrayOf(1, 1, 0), intArrayOf(1, 1, 0), intArrayOf(0, 0, 1)))) // 2
    println(findCircleNum(arrayOf(intArrayOf(1, 0, 0), intArrayOf(0, 1, 0), intArrayOf(0, 0, 1)))) // 3
}