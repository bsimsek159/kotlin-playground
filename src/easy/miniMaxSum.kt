package easy

import java.util.*

// Complete the easy.miniMaxSum function below.
fun miniMaxSum(arr: Array<Int>): Unit {
    val minSum = arr.sortedArray().dropLast(1).sum().toUInt()
    val maxSum = arr.sortedDescending().dropLast(1).sum().toUInt()
    print("$minSum $maxSum")
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val arr = scan.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()

    miniMaxSum(arr)
}