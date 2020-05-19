import java.util.*
import kotlin.math.ceil
import kotlin.math.round
import kotlin.math.sqrt

/**
 * For example, the sentence;
 * s= if man was meant to stay on the ground god would have given us roots.
 *  after removing spaces is  characters 54 long.  sqrt(54) is between 7 and 8, so it is written in the form of a grid with 7 rows and 8 columns.
 *
 *  Output:
 *
 *  ifmanwas
    meanttos
    tayonthe
    groundgo
    dwouldha
    vegivenu
    sroots

    Function Description;
    Complete the encryption function in the editor below. It should return a single string composed as described.
    encryption has the following parameter(s):

    s: a string to encrypt

    Input Format:
    One line of text, the string s

    Constraints
    1<=s<=81
    s is comprised only of characters in the range ascii[a-z].

    Output Format:
    Print the encoded message on one line as described.

    Sample Input:
    haveaniceday

    Sample Output 0:
    hae and via ecy

    Explanation 0:
    L = 12, sqrt(12) btw 3 and 4
    Rewritten with 3 rows and 4 columns:
    have
    anic
    eday
 */
// Complete the encryption function below.
fun encryption(s: String): String {
    val resultArray = StringBuilder()
    val editedStr = s.trim().filter { it.isLetterOrDigit() }
    var column = ceil(sqrt(editedStr.length.toFloat())).toInt()
    var row = round(sqrt(editedStr.length.toFloat())).toInt()

    column = if(row >= sqrt(editedStr.length.toFloat()))
        row else row + 1

    for (i in 0 until column) {
        var j = i
        while (j < editedStr.length) {
            resultArray.append(editedStr.toCharArray()[j])
            j += column
        }
        resultArray.append(" ")
    }

    return resultArray.toString()
}


fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val s = scan.nextLine()

    val result = encryption(s)

    println(result)
}