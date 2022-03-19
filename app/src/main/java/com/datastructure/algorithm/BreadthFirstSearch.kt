package com.datastructure.algorithm

import java.util.LinkedList
import java.util.Queue

class BreadthFirstSearch {

    val queue: Queue<BFSNode> = LinkedList<BFSNode>()
    var reverse = ""

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
        val i = BFSNode(3)

        a.left = b
        a.right = c

        b.left = d
        b.right = e

        c.right = f

        e.right = g
        d.right = i

        g.left = h

        // breadth first search, layers of algorithms
        //a/      4
        //bc/    7    9
        //def/ 10   2    6
        //ig/    3         6
        //h/              2

        return a
    }

    fun start() {
        val tree = createTree()
        traverse(tree)
    }

    /**
     * Use a queue system
     * Add the root node, print, remove
     * iterate while the queue is not empty, add the left child and add the right child to the queue
     */

    fun traverse(bfsNode: BFSNode?) {

        if (bfsNode == null) return

        queue.add(bfsNode)

        while (queue.isNotEmpty()) {

            queue.remove().also {

                print("${it?.data} ")
                reverse = "${it?.data} " + reverse

                if (it?.left != null) {
                    queue.add(it.left)
                }

                if (it?.right != null) {
                    queue.add(it.right)
                }

            }

        }
        println()
        print(reverse)

    }

}