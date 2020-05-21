/**
 *
 * #Find the missing letter
 *
 * Write a method that takes an array of consecutive (increasing) letters as input and that returns the missing letter in the array.
 *
 * You will always get an valid array. And it will be always exactly one letter be missing. The length of the array will always be at least 2.
 * The array will always contain letters in only one case.
 *
 * Example:
 * **/


fun findMissingLetter(array: CharArray): Char {
    val asciiList = array.map { it.toInt() }
    var missingChar = ' '
    asciiList.forEachIndexed { index, i ->
        if (index + 1 < asciiList.size && asciiList[index + 1] - i != 1) {
            missingChar = (asciiList[index] + 1).toChar()
        }
    }
    return missingChar
}

fun main() {
    print(findMissingLetter(charArrayOf('a','b','c','d','f')))
}