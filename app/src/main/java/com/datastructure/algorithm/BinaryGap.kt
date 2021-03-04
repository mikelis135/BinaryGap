package com.datastructure.algorithm

class BinaryGap {

    fun start() {

        print("\nPlease enter a number : ")

        readLine()?.let { number ->

            val gap = solution(number)

            showResult(number, gap)

            print("Press ENTER to restart Binary Gap, any other thing to close ")

            readLine()?.let { if (it == "") start() }

        } ?: print("Oops, Cannot read input, please retry")

    }

    private fun solution(number: String): Int? {

        number.toIntOrNull()?.let {

            if (it < 0) return null

            val binary = Integer.toBinaryString(it).split("").toTypedArray()

            var tempOne = 0
            var binaryGap = 0

            binary.forEachIndexed { index, element ->

                val position = index + 1

                if (element == "1") {

                    val numberOfZeros = position - (tempOne + 1)

                    tempOne = position

                    if (binaryGap < numberOfZeros) binaryGap = numberOfZeros

                }

            }

            return binaryGap
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

}

