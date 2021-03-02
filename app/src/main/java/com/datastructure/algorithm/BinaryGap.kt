package com.datastructure.algorithm

class BinaryGap {

    private val gaps = mutableListOf<Int>()

    fun start() {

        print("\nPlease enter a number : ")

        readLine()?.let { number ->

            val gap = processGap(number)

            showResult(number, gap)

            print("Press ENTER to restart Binary Gap, any other thing to close ")

            readLine()?.let { if (it == "") start() }

        } ?: print("Oops, Cannot read input, please retry")

    }

    fun processGap(number: String): Int? {

        gaps.clear()

        number.toIntOrNull()?.let {

            if (it < 0) return null

            val binary = Integer.toBinaryString(it)
            val values = "1".toRegex().findAll(binary).toList()

            values.forEach {

            }
            var i = 0
            while (i < values.size - 1) {

                val nextValue = values[i + 1].getValue()
                val value = values[i].getValue()
                gaps.add(nextValue - value - 1)

                ++i
            }

            return gaps.max() ?: 0

        } ?: kotlin.run {
            print("Oops, please enter a valid number\n\n")
            return null
        }

    }

    private fun showResult(number: String, gap: Int?) {
        gap?.let {
            print(
                "$number has $it ${if (it == 1) "gap" else {
                    "gaps"
                }} \n\n"
            )
        }
    }

    fun MatchResult.getValue() = this.range.min().toString().toInt()

}

