package easy

import java.util.*
import kotlin.collections.HashMap


/**
 * John works at a clothing store. He has a large pile of socks that he must pair by color for sale. Given an array of
 * integers representing the color of each sock, determine how many pairs of socks with matching colors there are.
    For example, there are n=7 socks with colors ar = [1,2,1,2,1,3,2]. There is one pair of color 1 and one of color 2.
    There are three odd socks left, one of each color. The number of pairs is 2.

    Output Format:
    Return the total number of matching pairs of socks that John can sell.

    Sample Input:
    9
    10 20 20 10 10 30 50 10 20

    Sample Output:
    3
 **/

// Complete the sockMerchant function below.
fun sockMerchant(n: Int, ar: Array<Int>): Int {
    var sockPair = 0
    val map = HashMap<Int, Int>()
    ar.forEach {
        if (map.containsKey(it)) {
            map[it] = map[it]!! + 1
            if (map[it]?.rem(2) == 0) sockPair +=1
        } else {
            map[it] = 1
        }
    }
    print(map.toString())
    return sockPair
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()

    val ar = scan.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()

    val result = sockMerchant(n, ar)

    println(result)
}