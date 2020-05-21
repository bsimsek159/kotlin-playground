package easy

import java.util.*
import kotlin.collections.HashMap

/**
 * https://www.hackerrank.com/challenges/equality-in-a-array/problem?h_r=next-challenge&h_v=zen
 *  Karl has an array of integers. He wants to reduce the array until all remaining elements are equal. Determine the minimum number of elements to delete to reach his goal.
 *
 *  For example, if his array is arr = [1,2,2,3], we see that he can delete the 2 elements 1 and 3 leaving arr=[2,2].
 *  He could also delete both twos and either the 1 or the 3, but that would take 3 deletions. The minimum number of deletions is 2.
 *
 *  Function Description:
 *  Complete the equalizeArray function in the editor below. It must return an integer that denotes the minimum number of deletions required.
 *
 *  equalizeArray has the following parameter(s):
 *  arr: an array of integers
 *
 *  Output Format:
 *  Print a single integer that denotes the minimum number of elements Karl must delete for all elements in the array to be equal.
 *
 *  Sample Input:
 *  5
 *  3 3 2 1 3
 *
 *  Sample Output:
 *  2
 *
 * */

fun equalizeArray(arr: Array<Int>): Int {
    var minDeletions = 0
    val sortedArray = arr.sortedArray()

    if (sortedArray.distinct().size == 1) {
        minDeletions = 0
    } else {
        val map = HashMap<Int, Int>()
        sortedArray.forEach {
            if (map.containsKey(it)) {
                map[it] = map[it]!! + 1
            } else {
                map[it] = 1
            }
        }

        map.filter{ it != map.maxBy { it.value } }.forEach {
            minDeletions += it.value
        }
    }

    return minDeletions
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()

    val arr = scan.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()

    val result = equalizeArray(arr)

    println(result)
}