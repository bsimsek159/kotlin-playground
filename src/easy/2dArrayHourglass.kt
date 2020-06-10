package easy

import java.util.*
import kotlin.collections.ArrayList

/**
 *
 * https://www.hackerrank.com/challenges/2d-array/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays
 *
 * Sample input:
 *
    -9 -9 -9 1 1 1
    0 -9 0 4 3 2
    -9 -9 -9 1 2 3
    0 0 8 6 6 0
    0 0 0 -2 0 0
    0 0 1 2 4 0
 *
 */

// Complete the hourglassSum function below.
fun hourglassSum(arr: Array<Array<Int>>): Int {
    val sumOfHourglasses: ArrayList<Int> = arrayListOf()

    arr.forEachIndexed { rowIndex, rows ->
        val topRow = arr[rowIndex]
        val bottomRow =  if(rowIndex + 2 < arr.size) arr[rowIndex + 2] else null
        rows.forEachIndexed { columnIndex, _ ->
            val hourGlass: Array<Int>
            if (columnIndex + 2 < rows.size && bottomRow != null) {
                val middlePoint = arr[rowIndex + 1][columnIndex + 1]
                hourGlass = arrayOf(
                    topRow[columnIndex], topRow[columnIndex + 1], topRow[columnIndex + 2],
                    middlePoint,
                    bottomRow[columnIndex], bottomRow[columnIndex + 1], bottomRow[columnIndex + 2])
                sumOfHourglasses.add(hourGlass.sum())
            }
        }
    }
    return sumOfHourglasses.max() ?: 0
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val arr = Array<Array<Int>>(6, { Array<Int>(6, { 0 }) })

    for (i in 0 until 6) {
        arr[i] = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()
    }

    val result = hourglassSum(arr)

    println(result)
}