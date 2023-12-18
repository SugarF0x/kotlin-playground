package katas

import kotlin.test.assertEquals
import kotlin.test.Test

// https://www.codewars.com/kata/5506b230a11c0aeab3000c1f/train/kotlin

class Evaporator {
    private fun evaporator(content: Double, dailyEvaporation: Double, threshold: Double): Int {
        val minContent = content * (threshold * 0.01)

        var days = 0
        var remainingContent = content

        while (remainingContent >= minContent) {
            remainingContent *= 1 - dailyEvaporation * 0.01
            days++
        }

        return days
    }

    @Test
    fun test() {
        assertEquals(22, evaporator(10.0,10.0,10.0))
        assertEquals(29, evaporator(10.0,10.0,5.0))
        assertEquals(59, evaporator(100.0,5.0,5.0))
    }
}