package katas

import kotlin.math.pow
import kotlin.test.Test
import kotlin.test.assertEquals

// https://www.codewars.com/kata/56b5afb4ed1f6d5fb0000991/train/kotlin

class ReverseOrRotate {
    private fun reverse(value: String): String {
        return value.toCharArray().reversedArray().joinToString("")
    }

    private fun rotate(value: String): String {
        val chars = value.toCharArray()
        val result = CharArray(chars.size)

        for (i in chars.indices) {
            val newIndex = (i + 1) % chars.size
            result[i] = chars[newIndex]
        }

        return result.joinToString("")
    }

    private fun isSumDivisible(value: String): Boolean = (
        value.fold(0) { acc, digit -> acc + digit.toString().toDouble().pow(3.0).toInt() } % 2 == 0
    )

    private fun revRot(value: String, size: Int): String {
        val chunks = value.chunked(size)
        var result = ""

        for (chunk in chunks) {
            if (chunk.length < size) break

            if (isSumDivisible(chunk)) result += reverse(chunk)
            else result += rotate(chunk)
        }

        return result
    }

    @Test
    fun test() {
        val sample = listOf(
            Triple("733049910872815764", 5, "330479108928157"),
            Triple("73304991087281576455176044327690580265896", 8, "1994033775182780067155464327690480265895"),
            Triple("73304991087281576455176044327690580265896896028", 8, "1994033775182780067155464327690480265895"),
            Triple("123456987654", 6, "234561876549"),
            Triple("123456987653", 6, "234561356789"),
            Triple("66443875", 4, "44668753"),
            Triple("66443875", 8, "64438756"),
            Triple("664438769", 8, "67834466"),
            Triple("123456779", 8, "23456771"),
            Triple("", 8, ""),
            Triple("123456779", 0, ""),
            Triple("563000655734469485", 4, "0365065073456944"),
        )

        for ((value, size, output) in sample) assertEquals(revRot(value, size), output)
    }

    @Test
    fun dummy() {
        println(reverse("12345"))
    }
}