package com.datastructure.algorithm

class Links {

    var head: Node? = null

    private fun Node.create(data: Int, next: Node?): Node? {
        this.data = data
        this.next = next
        return this
    }

    fun insert(data: Int) {

        var currentHead = head
        val node = Node().create(data, null)

        if (head == null) {
            head = node
        } else {

            while (currentHead?.next != null) {
                currentHead = currentHead.next
            }
            currentHead?.next = node

        }
    }

    fun show() {

        var currentHead = head

        while (currentHead?.next != null) {
            print(currentHead.data.toString() +"->")
            currentHead = currentHead.next
        }
        println(currentHead?.data)
    }

    fun insertAt(position: Int, data: Int) {

        var nodePosition = 0

        var currentHead = head

        val node = Node().create(data, null)

        if (currentHead == null || position == 0) {
            node?.next = currentHead
            head = currentHead
        } else {
            while (currentHead?.data != null) {
                if (nodePosition == position - 1) {
                    node?.next = currentHead.next
                    currentHead.next = node
                    break
                }
                currentHead = currentHead.next
                nodePosition++
            }

        }

    }
}