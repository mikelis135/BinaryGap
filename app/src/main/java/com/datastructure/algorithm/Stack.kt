package com.datastructure.algorithm

class Stack {

    //https://youtu.be/fwULtO8WPpw

    private var stack = arrayOfNulls<Int>(1)
    private var temp = arrayOfNulls<Int>(1)
    private var top = -1

    /**
     * Add to stack
     */

    fun push(data: Int) {
        top++
        val stack = getStack(top)
        stack[top] = data
    }

    /**
     * Delete from stack LIFO (last in, first out)
     */

    fun pop() {
        if (top < 0) throw IndexOutOfBoundsException() else stack[top] = null
    }

    /**
     * Show the stack
     */

    fun show() {
        for (item in stack) println(item)
    }

    /**
     * Check if stack is full then copy it into a larger stack an increased size of 2
     */

    private fun getStack(currentSize: Int): Array<Int?> {

        return if (currentSize >= stack.size) {
            temp = arrayOfNulls(top * 2)
            stack = copyArray(temp, stack)
            stack
        } else {
            stack
        }

    }

    /**
     * Copy array
     */

    private fun copyArray(temp: Array<Int?>, stack: Array<Int?>): Array<Int?> {
        for (i in stack.indices) temp[i] = stack[i]
        return temp
    }
}