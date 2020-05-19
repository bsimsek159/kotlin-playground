package easy

import java.text.SimpleDateFormat
import java.util.*


fun timeConversion(s: String): String {
    val inputFormat = SimpleDateFormat("hh:mm:ssa")
    val date24Format = SimpleDateFormat("HH:mm:ss")

    return date24Format.format(inputFormat.parse(s))
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val s = scan.nextLine()

    val result = timeConversion(s)

    println(result)
}