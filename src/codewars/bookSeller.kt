package codewars

import kotlin.test.assertEquals

/**
 *
 * https://www.codewars.com/kata/54dc6f5a224c26032800005c/train/kotlin
 * **/

object StockList {
    fun stockSummary(lstOfArt: Array<String>, lstOfCat: Array<String>): String {
        val splitedList = arrayListOf<Pair<Char, Int>>()
        val result = arrayListOf<String>()

        lstOfArt.map { it.split(" ") }.forEach {
            splitedList.add(Pair(it[0].first(), it[1].toInt()))
        }

        lstOfCat.forEach { cat ->
            if (splitedList.any { it.first.toString() == cat }) {
                var count = 0
                count += splitedList.filter {
                    it.first.toString() == cat
                }.sumBy { it.second }
                result.add("($cat : $count)")
            } else {
                result.add("($cat : 0)")
            }
        }

        return result.joinToString(" - ")
    }
}

fun main() {
    var b = arrayOf("ABAR 200", "CDXE 500", "BKWR 250", "BTSQ 890", "DRTY 600")
    var c = arrayOf("A", "B")
    var res = "(A : 200) - (B : 1140)"
    testing(b, c, res)
}

private fun testing(lstOfArt: Array<String>, lstOfCat: Array<String>, expect: String) {
    val actual: String = StockList.stockSummary(lstOfArt, lstOfCat)
    assertEquals(expect, actual)
}