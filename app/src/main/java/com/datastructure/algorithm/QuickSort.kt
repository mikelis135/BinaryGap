package com.datastructure.algorithm

class QuickSort {

    val arraySort = arrayOf(1, 3, 5, 0, 2, 5, 3)

    fun start() {
        QuickSort(arraySort, 0, 6)
        println(arraySort.joinToString(","))
    }

    private fun QuickSort(arraySort: Array<Int>, s: Int, e: Int) {

        if (s < e) {
            val p = partition(arraySort, s, e)
            QuickSort(arraySort, s, p - 1)
            QuickSort(arraySort, p + 1, e)
        }

    }

    private fun partition(arraySort: Array<Int>, s: Int, e: Int): Int {

        val pivot = arraySort[e]
        var pIndex = s

        for (i in s until e) {

            if (arraySort[i] <= pivot) {
                val temp = arraySort[i]
                arraySort[i] = arraySort[pIndex]
                arraySort[pIndex] = temp

                pIndex++
            }
        }

        val temp = arraySort[e]
        arraySort[e] = arraySort[pIndex]
        arraySort[pIndex] = temp

        return pIndex

    }

}