package easy

import java.util.*

// Complete the easy.birthdayCakeCandles function below.
fun birthdayCakeCandles(ar: Array<Int>): Int {
    return quickSort(ar.toList()).dropWhile {
        ar.max()!! > it
    }.size
}

fun quickSort(array:List<Int>):List<Int>{
    if (array.size < 2)
        return array

    val pivot = array[array.size/2]
    val equal = array.filter { it == pivot }
    val greater = array.filter { it > pivot }
    return equal + quickSort(greater)
}


fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val arCount = scan.nextLine().trim().toInt()

    val ar = scan.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()

    val result = birthdayCakeCandles(ar)

    println(result)
}