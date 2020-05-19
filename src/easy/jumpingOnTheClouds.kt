package easy

import java.util.*

/**
 * https://www.hackerrank.com/challenges/jumping-on-the-clouds/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=warmup
 *  Emma is playing a new mobile game that starts with consecutively numbered clouds.
 *  Some of the clouds are thunderheads and others are cumulus.
 *  She can jump on any cumulus cloud having a number that is equal to the number of the current cloud plus 1 or 2.
 *  She must avoid the thunderheads. Determine the minimum number of jumps it will take Emma to jump from her starting postion to the last cloud. It is always possible to win the game.
 *
 *  For each game, Emma will get an array of clouds numbered 0 if they are safe or 1 if they must be avoided.
 *  For example, c= [0,1,0,0,0,1,0]  indexed from 0..6. The number on each cloud is its index in the list so she must avoid the clouds at indexes 1 and 5.
 *  She could follow the following two paths:  0 -> 2 -> 4 -> 6 or 0 -> 2 -> 3 -> 4 -> 6. The first path takes 3 jumps while the second takes 4.
 *
 *  Output Format:
 *  Print the minimum number of jumps needed to win the game.
 *
 *  Sample Input:
 *  7
 *  0 0 1 0 0 1 0
 *
 *  Sample Output:
 *  4
 * **/

// Complete the jumpingOnClouds function below.
fun jumpingOnClouds(c: Array<Int>): Int {
    var jump = 0
    var i = 0
    while (i < c.size) {
        if (i + 2 < c.size && c[i + 2] == 0) {
            jump += 1
            i += 2
        }else if (i + 1 < c.size && c[i + 1] == 0) {
            jump += 1
            i += 1
        } else {
            return jump
        }
    }
    return jump
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()

    val c = scan.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()

    val result = jumpingOnClouds(c)

    println(result)
}
