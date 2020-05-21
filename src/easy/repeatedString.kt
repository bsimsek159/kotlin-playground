package easy

import java.util.*
import kotlin.math.floor

/**
 * https://www.hackerrank.com/challenges/repeated-string/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=warmup&h_r=next-challenge&h_v=zen
 *
 * Lilah has a string, s, of lowercase English letters that she repeated infinitely many times.
 * Given an integer, n, find and print the number of letter a's in the first n letters of Lilah's infinite string.
 * For example, if the string  s= 'abcac' and n = 10, the substring we consider is abcacabcac,
 * the first 10 characters of her infinite string. There are 4 occurrences of a in the substring.
 *
 * Function Description
 * Complete the repeatedString function in the editor below. It should return an integer representing the number of occurrences of a in the prefix of length  in the infinitely repeating string.
 *
 * repeatedString has the following parameter(s):
 * s: a string to repeat
 * n: the number of characters to consider
 *
 * Input Format:
 *  The first line contains a single string, s.
 *  The second line contains an integer, n.
 *
 *  Output Format:
 *  Print a single integer denoting the number of letter a's in the first n letters of the infinite string created by repeating s infinitely many times.
 *
 *  Sample Input:
 *  aba
 *  10
 *
 *  Sample Output:
 *  7
 * **/

// Complete the repeatedString function below.
fun repeatedString(s: String, n: Long): Long {
    return when {
        s.contains("a").not() -> 0
        s.length == 1 && s == "a"-> n
        s.length in 2..n -> {
            val repeatCount = floor(n / s.length.toDouble()).toLong()
            val occurrence = s.count { it == 'a' } * repeatCount

            val lastPartLength = n.rem((s.length.toLong() * repeatCount)).toInt()
            val lastAddedStr = s.subSequence(0,lastPartLength)
            val lastPartOccurrence = lastAddedStr.count { it == 'a' }

            occurrence + lastPartOccurrence
        }
        s.length > n -> {
            s.subSequence(0,n.toInt()).count { it == 'a' }.toLong()
        }
        else -> 0
    }
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val s = scan.nextLine()

    val n = scan.nextLine().trim().toLong()

    val result = repeatedString(s, n)

    println(result)
}