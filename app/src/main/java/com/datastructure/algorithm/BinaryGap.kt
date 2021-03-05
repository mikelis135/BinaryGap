package com.datastructure.algorithm

class BinaryGap {

    val searchOne = mutableListOf<Int>()

    fun start() {

        print("\nPlease enter a number : ")

        readLine()?.let { number ->

            val gap = processGap(number)

            showResult(number, gap)

            start()

        } ?: print("Oops, Cannot read input, please retry")

    }

    private fun processGap(number: String): Int? {

        var gaps = 0
        var i = 0

        number.toIntOrNull()?.let {

            if (it < 0) return null

            val binary = Integer.toBinaryString(it)

            println(binary)

            val values = indexAllOnes(binary)

            while (i < values.size - 1) {

                val nextValue = values[i + 1]
                val value = values[i]

                if (gaps < nextValue - value) gaps = nextValue - value - 1

                ++i
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
                "$number has $it ${if (it == 1) "gap" else {
                    "gaps"
                }} \n"
            )
        }
    }

    private fun indexAllOnes(number: String): List<Int> {

        searchOne.clear()

        number.split("").forEachIndexed { index, it ->
            if (it == "1") searchOne.add(index)
        }

        return searchOne
    }

}

