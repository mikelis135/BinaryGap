package com.datastructure.algorithm

class MergeSort {

    private lateinit var numberArray: Array<Int>

    fun sort(numbers: Array<Int>) {
        numberArray = numbers
        mergeSort(numberArray, 0, numberArray.size - 1)
        numberArray.forEach {
            println(it)
        }
    }

    private fun mergeSort(numberArray: Array<Int>, low: Int, high: Int) {

        if (low < high) {
            val middle = low + (high - low) / 2
            mergeSort(numberArray, low, middle)
            mergeSort(numberArray, middle + 1, high)
            merge(numberArray, low, middle, high)
        }

    }

    private fun merge(numberArray: Array<Int>, low: Int, middle: Int, high: Int) {
        val tempArray = Array(numberArray.size) {0}

        for (i in numberArray.indices) tempArray[i] = numberArray[i]

        var i = low
        var j = middle + 1
        var k = low

        while (i <= middle && j <= high) {

            if (tempArray[i] <= tempArray[j]) {
                numberArray[k] = tempArray[i]
                i++
            } else {
                numberArray[k] = tempArray[j]
                j++
            }
            k++
        }

        while (i <= middle) {
            numberArray[k] = tempArray[i]
            k++
            i++
        }

    }

}