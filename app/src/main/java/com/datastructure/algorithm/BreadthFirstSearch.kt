package com.datastructure.algorithm

import java.util.LinkedList
import java.util.Queue

class BreadthFirstSearch {

    val queue: Queue<BFSNode> = LinkedList<BFSNode>()
    val sumList = mutableListOf<Int?>()

    data class BFSNode(
        var data: Int,
        var left: BFSNode? = null,
        var right: BFSNode? = null
    )

    fun createTree(): BFSNode {
        val a = BFSNode(4)
        val b = BFSNode(7)
        val c = BFSNode(9)
        val d = BFSNode(10)
        val e = BFSNode(2)
        val f = BFSNode(6)
        val g = BFSNode(6)
        val h = BFSNode(2)

        a.left = b
        a.right = c

        b.left = d
        b.right = e

        c.right = f

        e.right = g

        g.left = h

        return a
    }

    fun start() {
        val tree = createTree()
        sumLevel(tree)

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

    fun sumLevel(bfsNode: BFSNode?) {

        var traversalCount = 0
        var level = 1

        queue.add(bfsNode)

        sumList.add(bfsNode?.data)

        while (queue.isNotEmpty()) {

            queue.remove().also {

                var sumCount = 0
                var numCount = 0

                print("${it?.data} ")

                if (it?.left == null && it?.right == null) {
                    traversalCount += Math.pow(2.toDouble(), (level - 2).toDouble()).toInt()
                }

                if (it?.left != null) {
                    queue.add(it.left)
                    sumCount += it.left?.data ?: 0
                    numCount++
                    traversalCount++
                }else if (it.right != null){
                    traversalCount++
                }

                if (it?.right != null) {
                    queue.add(it.right)
                    sumCount += it.right?.data ?: 0
                    numCount++
                    traversalCount++
                }else if (it.right != null){
                    traversalCount++
                }

                if (numCount != 0) sumList.add(sumCount / numCount)
            }

            if (traversalCount.toDouble() == Math.pow(2.0, level.toDouble())) {
                println(" count $traversalCount level $level ")
                level++
                traversalCount = 0
            }

        }

    }

}