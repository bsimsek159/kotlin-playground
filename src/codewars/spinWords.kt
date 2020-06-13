package codewars

import java.util.*

fun spinWords(sentence: String): String {
    return sentence.split(" ").map{ if(it.length >= 5) it.reversed() else it }.joinToString(" ")
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val word = scan.nextLine()

    val result = spinWords(word)

    println(result)
}