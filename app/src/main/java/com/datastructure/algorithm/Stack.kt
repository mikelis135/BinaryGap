package com.datastructure.algorithm

class Stack {

    //https://youtu.be/fwULtO8WPpw

    private var stack = arrayOfNulls<Int>(1)
    private var temp = arrayOfNulls<Int>(1)
    private var index = 0
    private var top = 0

    /**
     * Add to stack
     */

    fun push(value: Int) {
        index = top
        val stack = getStack(index)
        stack[index] = value
        top++
    }

    /**
     * Delete from stack LIFO (last in, first out)
     */

    fun pop() {
        temp = arrayOfNulls(index)
        stack = copyArray(temp, stack, 1)
        top--
    }

    /**
     * Show top item
     */

    fun peek() {
        if (top > 0) println(stack[top - 1]) else {
            stack = arrayOfNulls(top + 1)
            println(stack[top])
        }
    }


    /**
     * is stack empty
     */

    fun isEmpty() = stack.isEmpty()

    /**
     * is stack empty
     */

    fun size() {
        println(stack.size)
    }

    /**
     * Show the stack
     */

    fun show() {
        for (item in stack.size-1 downTo 0 step -1) println("${stack[item]} ->")
    }

    /**
     * Check if stack is full then copy it into a larger stack an increased size of 2
     */

    private fun getStack(currentSize: Int): Array<Int?> {

        return if (currentSize >= stack.size) {
            temp = arrayOfNulls(index + 1)
            stack = copyArray(temp, stack)
            stack
        } else {
            stack
        }

    }

    /**
     * Copy array
     */

    private fun copyArray(temp: Array<Int?>, stack: Array<Int?>, pop: Int = 0): Array<Int?> {
        for (i in 0..stack.size - 1 - pop) temp[i] = stack[i]
        return temp
    }
}