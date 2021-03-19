package com.datastructure.algorithm

import java.util.LinkedList
import java.util.Queue

class DepthFirstSearch {

    val queue: Queue<BFSNode> = LinkedList<BFSNode>()
    var nodeMap = mutableMapOf<Int, MutableList<Int>>()
    var nodeMap2 = mutableMapOf<Int, Int>()

    var count = 0
    var sumCount = 0

    data class BFSNode(
        var data: Int,
        var left: BFSNode? = null,
        var right: BFSNode? = null
    )

    fun createTree(): BFSNode {
        val a = BFSNode(5)
        val b = BFSNode(10)
        val c = BFSNode(15)
        val d = BFSNode(5)
        val e = BFSNode(10)

        a.left = b
        a.right = c

        b.left = d
        b.right = e

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
        count++

        traverse(bfsNode.right)
        count++

    }


    /**
     * Use a hashMap
     * if height is map size, that is if node in a level is filled, add another list
     * add data of node to the map list
     */


    /**
     * 5 0[5]
     *  10      15 1[10, 15]
     *  5    10
     *
     * Depth First style for breadth first output
     */

    fun sumTraverse(bfsNode: BFSNode?, height: Int) {

        if (bfsNode == null) return

        if (height == nodeMap.size) {
            nodeMap[height] = mutableListOf()
        }

        nodeMap[height]?.add(bfsNode.data)

        sumTraverse(bfsNode.left, height + 1)

        sumTraverse(bfsNode.right, height + 1)

    }

    fun sumTraverse2(bfsNode: BFSNode?, height: Int) {

        if (bfsNode == null) return

        if (height == nodeMap2.size) {
            nodeMap2[height] = 0
            sumCount= 0
        }

        sumCount += bfsNode.data
        nodeMap2[height] = sumCount

        sumTraverse2(bfsNode.left, height + 1)

        sumTraverse2(bfsNode.right, height + 1)

    }

}