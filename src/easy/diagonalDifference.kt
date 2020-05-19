package easy

import kotlin.math.absoluteValue

fun diagonalDifference(arr: Array<Array<Int>>): Int {
    var sumOfPrimaryDiagonal = 0
    var sumOfSecondaryDiagonal = 0
    for(i in arr.indices){
        for (j in arr.indices) {
            if(i == j) sumOfPrimaryDiagonal += arr[i][j]
            if((i + j) == (arr.size - 1)) sumOfSecondaryDiagonal += arr[i][j]
        }
    }

    return (sumOfPrimaryDiagonal - sumOfSecondaryDiagonal).absoluteValue
}


fun main() {
    val n = readLine()!!.trim().toInt()

    val arr = Array(n) { Array(n) { 0 } }

    for (i in 0 until n) {
        arr[i] = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()
    }

    val result = diagonalDifference(arr)

    println(result)
}