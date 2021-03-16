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
     * Check if data is not null, if value to insert is less check if left node null, then create a node there, else insert there
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