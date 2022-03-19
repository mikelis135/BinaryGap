package com.datastructure.algorithm

import java.util.LinkedList
import java.util.Queue

class DepthFirstSearch {

    val queue: Queue<BFSNode> = LinkedList<BFSNode>()
    var nodeMap = mutableMapOf<Int, MutableList<Int>>()
    var nodeMap2 = mutableMapOf<Int, Int>()

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
        val e = BFSNode(9)

        a.left = b
        a.right = c

        b.left = d
        b.right = e

        // depth first search
        //a/      5
        //bc/   10  15
        //de/ 5   9

        return a
    }


    fun start() {
        val tree = createTree()

        traverse(tree)

        sumTraverse(tree, 0)
        
        println(nodeMap)
        println(nodeMap.keys)
        println(nodeMap.values)
        nodeMap.values.forEach {
            println(it.sum())
        }

    }

    /**
     * Use a queue system, if the node is null return
     * Add the node, print the data, remove node
     * traverse left node, traverse right node
     */

    fun traverse(bfsNode: BFSNode?) {

        if (bfsNode == null) return

        queue.add(bfsNode)

        print("${bfsNode.data} ")

        queue.remove()

        traverse(bfsNode.left)

        traverse(bfsNode.right)

    }


    /**
     * Use a hashMap
     * if height is map size, that is if node in a level is filled, add another list
     * add data of node to the map list
     */


    /**
     * 5 0[5]
     *  10      15  1[10, 15]
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

}