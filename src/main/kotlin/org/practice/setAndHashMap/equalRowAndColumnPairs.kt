package org.practice.setAndHashMap

fun equalPairs(grid: Array<IntArray>): Int {
    val rowMap = mutableMapOf<List<Int>, Int>()
    grid.forEach{ ints ->
        val rowList = ints.toList()
        rowMap[rowList] = rowMap.getOrDefault(rowList,0) + 1
    }

    var pairs = 0
    for (i in grid.indices) {
        val colList = getColumn(grid,i)
        pairs += rowMap.getOrDefault(colList,0)
    }
    return pairs
}

private fun getColumn(matrix: Array<IntArray>, column: Int): List<Int> {
    val columnArr = mutableListOf<Int>()
    for (i in matrix.indices) {
        columnArr.add(matrix[i][column])
    }
    return columnArr
}

fun main() {
    val grid = arrayOf(intArrayOf(3,2,1), intArrayOf(1,7,6), intArrayOf(2,7,7))
//    val grid = arrayOf(intArrayOf(2,1), intArrayOf(3,32))
    val result = equalPairs(grid)
    println(result)
}