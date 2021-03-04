package com.datastructure.algorithm

class Queue {

    //https://youtu.be/PvDoT79oHTs

    private var queue = arrayOfNulls<Int>(1)
    private var temp = arrayOfNulls<Int>(1)
    private var index = 0
    private var top = 0

    /**
     * Add to queue
     */

    fun enqueue(value: Int) {
        index = top
        val queue = getQueue(index)
        queue[index] = value
        top++
    }

    /**
     * Delete from queue LIFO (first in, first out)
     */

    fun dequeue() {
        temp = arrayOfNulls(index)
        queue = copyArray(temp, queue, 1)
        index--
    }

    /**
     * is queue empty
     */

    fun isEmpty() = queue.isEmpty()

    /**
     * is queue empty
     */

    fun size() {
        println(queue.size)
    }

    /**
     * Show the queue
     */

    fun show() {
        for (item in queue) println(item)
    }

    /**
     * Check if queue is full then copy it into a larger queue an increased size of 2
     */

    private fun getQueue(currentSize: Int): Array<Int?> {

        return if (currentSize >= queue.size) {
            temp = arrayOfNulls(index + 1)
            queue = copyArray(temp, queue)
            queue
        } else {
            queue
        }

    }

    /**
     * Copy array
     */

    private fun copyArray(temp: Array<Int?>, queue: Array<Int?>, dequeue: Int = 0): Array<Int?> {
        for (i in 0..queue.size - 1-dequeue) temp[i] = queue[i+dequeue]
        return temp
    }
}