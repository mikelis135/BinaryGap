package com.datastructure.algorithm

class BinaryGap {

    private val searchOne = mutableListOf<Int>()

    /**
     * Read the number from the console, process the gap and print
     */

    fun start() {

        print("\nPlease enter a number : ")

        readLine()?.let { number ->

            val gap = processGap(number)

            showResult(number, gap)

            start()

        } ?: print("Oops, Cannot read input, please retry")

    }

    /**
     * converts the number to binary form, get the list of indexed 1
     * compare the difference of the next value and the previous value the save the greater one
     */

    fun toBinary(number: Int): String {

        var bitString = ""
        var digit = number
        do {
            val division = digit / 2
            bitString = (digit % 2).toString() + bitString
            digit = division
        } while (digit > 0)

        return bitString

    }

    private fun processGap(number: String): Int? {

        var gaps = 0
        var i = 0

        number.toIntOrNull()?.let {

            if (it < 0) return null

            val binary = toBinary(it)

            println(binary)

            binary.toList().map { it.toInt() }.let {

                do {
                    val nextValue = it[i + 1]
                    val value = it[i]
                    if (gaps < nextValue - value) gaps++
                    i++
                } while (i < it.size - 1)

            }

            return gaps

        } ?: kotlin.run {
            print("Oops, please enter a valid number\n\n")
            return null
        }

    }

    private fun showResult(number: String, gap: Int?) {
        gap?.let {
            print(
                "$number has $it ${
                    if (it == 1) "gap" else {
                        "gaps"
                    }
                } \n"
            )
        }
    }

}

