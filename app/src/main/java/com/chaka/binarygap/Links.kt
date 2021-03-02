package com.chaka.binarygap

class Links {

    var head: Node? = null
    var currentHead: Node? = null

    private fun Node.create(data: Int, next: Node?): Node? {
        this.data = data
        this.next = next
        return this
    }

    fun insert(data: Int) {
        currentHead = head
        val node = Node().create(data, null)

        if (head == null) {
            head = node
        } else {

            while (currentHead?.next != null) {
                currentHead = currentHead?.next
            }
            currentHead?.next = node

        }
        println(head.toString() + "\n")
    }

    fun show() {

        currentHead = head
        while (currentHead?.next != null) {
            println(currentHead?.data)
            currentHead = currentHead?.next
        }
        println(currentHead?.data)
    }

    fun insertAt(position: Int, data: Int) {

        var nodePosition = 0

        currentHead = head
        println(currentHead.toString())
        val node = Node().create(data, null)

        if (currentHead == null || position == 0) {
            node?.next = currentHead
            currentHead = node
            head = currentHead
        } else {
            while (currentHead?.data != null) {
                if (nodePosition == position-1) {
                    node?.next = currentHead?.next
                    currentHead?.next = node
                    break
                }
                currentHead = currentHead?.next
                nodePosition++
            }

        }

    }
}