package easy

import java.util.*

fun staircase(n: Int): Unit {
    for (x in 0 until n) {
        if (x < n) {
            for (y in 0 until n) {
                if (x + y < n - 1) {
                    print(" ")
                } else {
                    print("#")
                }
                if (y == n - 1) {
                    print("\n")
                }
            }
        }
    }
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()

    staircase(n)
}