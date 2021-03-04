package com.datastructure.algorithm

//https://youtu.be/SMIq13-FZSE

class LinkedList {

    var head: Node? = null

    /**
     * Create a node off of the data and next node parameter
     */
    private fun Node.create(data: Int, next: Node?): Node? {
        this.data = data
        this.next = next
        return this
    }

    /**
     * If Node has no next item, it can traverse
     */
    private fun Node?.canTraverse(): Boolean = this?.next != null

    /**
     * If Node has data
     */
    private fun Node?.hasData(): Boolean = this?.data != null

    /**
     * Get the head
     * Create a node
     * Check if head is empty (no item, head is null), set the node to the head
     * If head is not empty (item exists), traverse through nodes to find last node
     * (where next is null) and set the node
     */

    fun insert(data: Int) {

        var currentHead = head

        val node = Node().create(data, null)

        head?.let {

            while (currentHead.canTraverse()) currentHead = currentHead?.next
            currentHead?.next = node

        } ?: kotlin.run {
            head = node
        }

    }


    /**
     * set default node position to 1 and Get head
     * Create node
     * if head is empty (no item, head is null) and position is 0, set node
     * if head is not empty (item exists) and position is 0, set current head to the end of the node
     * if head is not empty (item exists) and position is not 0, traverse the node with data, detect the position,
     * set all items in current head (currentHead.next) to the end of the node and set the currentHead
     * Uses a detach and attach approach
     */

    fun insertAt(position: Int, data: Int) {

        var nodePosition = 1
        var currentHead = head

        val node = Node().create(data, null)

        currentHead?.let {

            if (position == 0) {
                node?.next = currentHead
                head = node
            } else {
                while (currentHead.hasData()) {
                    if (nodePosition == position) {
                        node?.next = currentHead?.next
                        currentHead?.next = node
                        break
                    }
                    currentHead = currentHead?.next
                    nodePosition++
                }
                if (currentHead == null) println("Cannot set node $position because node ${nodePosition - 1} is empty \n")
            }
        } ?: kotlin.run {
            if (position == 0) head =
                node else println("Cannot set node $position on an empty list")
        }

    }


    /**
     * Get the head
     * Traverse the node and set the data of the last item to null to delete it
     */

    fun delete() {

        var currentHead = head

        head?.let {

            while (currentHead.canTraverse()) currentHead = currentHead?.next
            currentHead?.data = null

        } ?: kotlin.run {
            println("List is already empty")
        }

    }


    /**
     * set default node position to 1 and Get head
     * if head is empty (no item, head is null) and position is 0, list is empty
     * if head is not empty (item exists) and position is 0, set next item of the head to the head
     * if head is not empty (item exists) and position is not 0, traverse the node with data, detect the position,
     * set all items in next 2 node (currentHead.next.data) as the next node and set the currentHead to null
     * Uses a detach and attach approach
     */

    fun deleteAt(position: Int) {

        var nodePosition = 1
        var currentHead = head

        currentHead?.let {

            if (position == 0) {
                head = currentHead?.next
            } else {
                while (currentHead.hasData()) {
                    if (nodePosition == position) {
                        currentHead?.next?.data = null
                        currentHead?.next = currentHead?.next?.next
                        break
                    }
                    currentHead = currentHead?.next
                    nodePosition++
                }
                if (currentHead == null) println("Cannot delete node $position because node ${nodePosition - 1} is empty \n")
            }
        } ?: kotlin.run {
            if (position == 0) println("Cannot delete node $position on an empty list")
        }

    }


    /**
     * Get the head
     * Traverse through the nodes and show data value
     */

    fun show() {

        var currentHead = head

        while (currentHead.hasData()) {
            print(currentHead?.data.toString() + "->")
            currentHead = currentHead?.next
        }
    }
}