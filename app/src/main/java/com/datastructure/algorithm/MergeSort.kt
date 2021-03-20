package com.datastructure.algorithm

//https://youtu.be/7LN9z140U90

class MergeSort {

    private lateinit var numberArray: Array<Int>

    /**
     * get the array to sort to a variable array
     * mergeSort array
     */


    fun sort(numbers: Array<Int>) {
        numberArray = numbers
        mergeSort(numberArray, 0, numberArray.size - 1)
        numberArray.forEach {
            println(it)
        }
    }

    /**
     * If low < high Get the middle
     * MergeSort array from low to middle (left)
     * MergeSort array from middle+1 to high (right)
     * merge array
     */

    private fun mergeSort(numberArray: Array<Int>, low: Int, high: Int) {

        if (low < high) {
            val middle = low + (high - low) / 2
            mergeSort(numberArray, low, middle)
            mergeSort(numberArray, middle + 1, high)
            merge(numberArray, low, middle, high)
        }

    }

    /**
     * Set a temp array, copy all array to the temp array
     * get variables, i,j,k, i from middle to high
     * while i <= middle j<= high, if value in temp array is less, set the lesser value to the real array
     * while
     */

    private fun merge(numberArray: Array<Int>, low: Int, middle: Int, high: Int) {
        val tempArray = Array(numberArray.size) { 0 }

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