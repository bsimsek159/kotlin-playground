package easy

import java.util.*

/**
 *
 * https://www.hackerrank.com/challenges/ctci-array-left-rotation/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays&h_r=next-challenge&h_v=zen
 *
 * Sample input:
 * 5 4
 * 1 2 3 4 5
 *
 * Sample output:
 * 5 1 2 3 4
 *
 * Explanation:
 * When we perform d=4 left rotations, the array undergoes the following sequence of changes:
 *
 * [1,2,3,4,5] -> [2,3,4,5,1] -> [3,4,5,1,2] -> [4,5,1,2,3] -> [5,1,2,3,4]
 **/

fun rotLeft(a: Array<Int>, d: Int): Array<Int?> {
    val list = a.toList()
    val result: Array<Int?> = arrayOfNulls(list.size)
    Collections.rotate(list, -d)
    list.forEachIndexed { index, i ->
        result[index] = Integer.valueOf(i)
    }
    return result
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val nd = scan.nextLine().split(" ")

    val n = nd[0].trim().toInt()

    val d = nd[1].trim().toInt()

    val a = scan.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()

    val result = rotLeft(a, d)

    println(result.joinToString(" "))
}