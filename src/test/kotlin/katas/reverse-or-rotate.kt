package katas

import kotlin.test.Test
import kotlin.test.assertEquals

// https://www.codewars.com/kata/56b5afb4ed1f6d5fb0000991/train/kotlin

class ReverseOrRotate {
    private fun revRot(nums: String, sz: Int): String {
        return ""
    }

    @Test
    fun test() {
        assertEquals(revRot("733049910872815764", 5), "330479108928157")
        assertEquals(revRot("73304991087281576455176044327690580265896", 8), "1994033775182780067155464327690480265895")
        assertEquals(revRot("73304991087281576455176044327690580265896896028", 8), "1994033775182780067155464327690480265895")
    }
}