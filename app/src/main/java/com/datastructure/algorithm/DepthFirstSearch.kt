package com.datastructure.algorithm

import java.util.LinkedList
import java.util.Queue

class DepthFirstSearch {

    val queue: Queue<BFSNode> = LinkedList<BFSNode>()
    var nodeMap = mutableMapOf<Int, MutableList<Int>>()

    var sumCount = 0
    var count = 0

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
        sumTraverse(tree, 0)
        println(nodeMap)
        println(nodeMap.keys)
        println(nodeMap.values)
        nodeMap.values.forEach {
            println(it.sum())
        }

    }

    /**
     * Use a queue system
     * Add the root node, print, remove
     * iterate while the queue is not empty
     */

    fun traverse(bfsNode: BFSNode?) {

        if (bfsNode == null) return

        queue.add(bfsNode)

        print("${bfsNode.data} ")

        queue.remove()

        traverse(bfsNode.left)
        sumCount += bfsNode.left?.data ?: 0
        count++

        traverse(bfsNode.right)
        sumCount += bfsNode.right?.data ?: 0
        count++

    }

    fun sumTraverse(bfsNode: BFSNode?, height: Int) {

        if (bfsNode == null) return

        if (height == nodeMap.size) {
            nodeMap[height] = mutableListOf()
            sumCount = 0
        }

        sumCount += bfsNode.data
        nodeMap[height]?.add(bfsNode.data)

        sumTraverse(bfsNode.left, height + 1)

        sumTraverse(bfsNode.right, height + 1)

    }

}