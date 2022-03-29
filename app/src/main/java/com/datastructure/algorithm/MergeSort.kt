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
            print("$it,")
        }
    }

    /**
     * If low < high Get the middle
     * MergeSort array from low to middle (left)
     * MergeSort array from middle+1 to high (right)
     * merge array
     */

    // 0,4

            //0, 2
                    //0, 1
            //3, 4
                    //3, 4


    //0, 7
            //0,  3
                // left    //0, 1
                 //right  //2, 3
            //4, 7
                 //left  //4, 5
                //right  //6, 7

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

        //temporary array

        for (i in numberArray.indices) tempArray[i] = numberArray[i]

        var i = low
        var j = middle + 1
        var k = low

        // get all the lower values by comparing one to many, left part to right part

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

        // copy the rest of the array

        while (i <= middle) {
            numberArray[k] = tempArray[i]
            k++
            i++

            println(numberArray.joinToString(","))
        }

    }

}