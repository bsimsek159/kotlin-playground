package codewars

/**
 * Given two arrays of strings a1 and a2 return a sorted array r in lexicographical order of the strings of a1 which are substrings of strings of a2.
 *
 * #Example 1: a1 = ["arp", "live", "strong"]
 *
 * a2 = ["lively", "alive", "harp", "sharp", "armstrong"]
 *
 * returns ["arp", "live", "strong"]
 *
 * #Example 2: a1 = ["tarp", "mice", "bull"]
 *
 * a2 = ["lively", "alive", "harp", "sharp", "armstrong"]
 *
 * returns []
 *
 * Notes:
 * Arrays are written in "general" notation. See "Your Test Cases" for examples in your language.
 *
 * In Shell bash a1 and a2 are strings. The return is a string where words are separated by commas.
 *
 * Beware: r must be without duplicates.
 * Don't mutate the inputs.
 *
 * **/

fun inArray(array1: Array<String>, array2: Array<String>): Array<String> {
    return array1.filter{e->array2.any{it.contains(e)}}.distinct().sorted().toTypedArray()
}

fun main(args: Array<String>) {
    val a2 = arrayOf("lively", "alive", "harp", "sharp", "armstrong")
    val a1 = arrayOf("arp", "live", "strong")

    val result = inArray(a1, a2)

    print(result.joinToString())
}