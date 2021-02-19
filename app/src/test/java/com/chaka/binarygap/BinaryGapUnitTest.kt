package com.chaka.binarygap

import org.junit.Assert.assertEquals
import org.junit.Test

class BinaryGapUnitTest {

    private val binaryGap = BinaryGap()

    @Test
    fun assertCorrectInput_ValidOutput() {
        val number = "10"
        val gap = binaryGap.processGap(number)
        assertEquals(gap, 1)
    }

    @Test
    fun assertInCorrectInput_ValidOutput() {
        val number = "incorrect number"
        val gap = binaryGap.processGap(number)
        assertEquals(gap, null)
    }

    @Test
    fun assertNegativeInput_ValidOutput() {
        val number = "-9"
        val gap = binaryGap.processGap(number)
        assertEquals(gap, null)
    }

}