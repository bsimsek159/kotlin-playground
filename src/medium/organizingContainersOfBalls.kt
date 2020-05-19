package medium

import java.util.*

/*
David wants to perform some number of swap operations such that:

Each container contains only balls of the same type.
No two balls of the same type are located in different containers.
 */

fun organizingContainers(container: Array<Array<Int>>): String {
    val totalType = IntArray(size = container.size) // totalQuan
    val totalBox = IntArray(size = container.size) //size
    var contains = false

    for (c in container.indices) {
        for (t in container[c].indices) {
            totalBox[c] += container[c][t]
            totalType[t] += container[c][t]
        }
    }

    for (i in totalType.indices) {
        for (j in totalType.indices) {
            if (totalBox[i] == totalType[j]) contains = true
        }
        if (!contains) return "Impossible"
        contains = false
    }

    return "Possible"
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val q = scan.nextLine().trim().toInt()

    for (qItr in 1..q) {
        val n = scan.nextLine().trim().toInt()

        val container = Array<Array<Int>>(n, { Array<Int>(n, { 0 }) })

        for (i in 0 until n) {
            container[i] = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()
        }

        val result = organizingContainers(container)

        println(result)
    }
}