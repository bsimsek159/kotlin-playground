package easy

import java.util.*

// Complete the easy.plusMinus function below.
fun plusMinus(arr: Array<Int>): Unit {
    var positiveCount = 0
    var negativeCount = 0
    var zeroCount = 0

    arr.forEach {
        when {
            it == 0 -> zeroCount += 1
            it > 0 -> positiveCount += 1
            it < 0 -> negativeCount += 1
        }
    }

    print(
        "${"%.6f".format(positiveCount.toDouble().div(arr.size))} \n" +
         "${"%.6f".format(negativeCount.toDouble().div(arr.size))} \n" +
         "${"%.6f".format(zeroCount.toDouble().div(arr.size))}"
    )
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()

    val arr = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

    plusMinus(arr)
}