package com.datastructure.algorithm

class BinaryNode {

    private var left: BinaryNode? = null
    private var right: BinaryNode? = null
    private var data: Int? = null


    /**
     * Create a node and return the value
     */
    private fun binaryNode(data: Int): BinaryNode {
        val node = BinaryNode()
        node.data = data
        return node
    }


    /**
     * Check if data is not null, if value to insert is less or equal, check if left node null, then create a node there, else insert there
     * else if value to insert is more check if left node null, then create a node there, else insert there
     */

    fun insert(value: Int) {

        if (data != null && value <= data!!) {

            if (left == null) {
                left = binaryNode(value)
            } else {
                left?.insert(value)
            }

        } else {

            if (right == null) {
                right = binaryNode(value)
            } else {
                right?.insert(value)
            }

        }
    }

    /**
     * If you find the value return true
     * If the data to search against is not null or less, if left of it is null return false else keep searching
     * If the data to search against is not null or more, if right of it is null return false else keep searching
     */

    fun contains(value: Int): Boolean {
        return if (value == data) true
        else if (data != null && value < data!!) {
            if (left == null) false else left!!.contains(value)
        } else {
            if (right == null) false else right!!.contains(value)
        }
    }

    fun contains(value: Int, node: BinaryNode): Boolean {
        return if (value == node.data) true
        else if (node.data != null && value < node.data!!) {
            if (node.left == null) false else node.left!!.contains(value)
        } else {
            if (node.right == null) false else node.right!!.contains(value)
        }
    }

    /**
     * if left is not null, recurse
     * print data not null
     * if right is not null, recurse
     */

    fun showNode() {
        if (left != null) left?.showNode()
        data?.let { print("$it->") }
        if (right != null) right?.showNode()
    }
}