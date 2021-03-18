package com.datastructure.algorithm

import java.util.LinkedList
import java.util.Queue

class BreadthFirstSearch {

    val queue: Queue<BFSNode> = LinkedList<BFSNode>()
    val sumList = mutableListOf<Int>()

    data class BFSNode(
        var data: Int,
        var left: BFSNode? = null,
        var right: BFSNode? = null
    )

    fun createTree(): BFSNode {
        val a = BFSNode(5)
        val b = BFSNode(10)
        val c = BFSNode(15)
        val d = BFSNode(20)

        a.left = b
        a.right = c

        b.left = d
        b.right = d

        return a
    }

    fun start() {
        val tree = createTree()
        traverse(tree)

        print(sumList)
    }

    /**
     * Use a queue system
     * Add the root noe, print, remove
     * iterate while the queue is not empty
     */

    fun traverse(bfsNode: BFSNode?) {

        if (bfsNode == null) return

        queue.add(bfsNode)

        sumList.add(bfsNode.data)

        while (queue.isNotEmpty()) {

            queue.remove().also {

                var sumCount = 0
                var numCount = 0

                print("${it?.data} ")

                if (it?.left != null) {
                    queue.add(it.left)
                    sumCount += it.left?.data ?: 0
                    numCount++
                }

                if (it?.right != null) {
                    queue.add(it.right)
                    sumCount += it.right?.data ?: 0
                    numCount++
                }

                if (numCount != 0) sumList.add(sumCount / numCount)

            }

        }

    }

}