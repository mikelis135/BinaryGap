package com.datastructure.algorithm

class Dijkstra {

    /**
     * Shortest path algorithm 0(N^2) time complexity
     *
     * Application in finding shortest distance in maps, distance to send a request via nodes in a network request
     *
     * https://youtu.be/XB4MIexjvY0
     * https://youtu.be/SZXXnB7vSm4
     * https://www.geeksforgeeks.org/dijkstras-shortest-path-algorithm-greedy-algo-7/
     */

    /**
     * Create the 2-dimensional array of the graph and set the vertex source where the shortest path is specified
     */

    fun start() {

        val graph = arrayOf(
            arrayOf(1, 0, 3, 4),
            arrayOf(2, 0, 7, 0),
            arrayOf(3, 2, 0, 5),
            arrayOf(9, 2, 0, 5)
        )
        dijkstra(graph, 1)

    }

    /**
     * initialize array of int distance (value) and boolean visited
     * set the array of all values and visited to 0 and false
     * set the src value (distance) to 0
     * iterate through the graph index, get the min distance of graph array and check visited vertex, set visited as true
     * iterate through the graph index, check if value is not 0 and not infinite and value added with next value is less than next value and that it is not visited
     * set the lesser value to values
     */

    private fun dijkstra(graph: Array<Array<Int>>, src: Int) {

        val values = Array(graph.size) { 0 }
        val visited = Array(graph.size) { false }

        for (i in graph.indices) {
            values[i] = Integer.MAX_VALUE
            visited[i] = false
        }

        values[src] = 0

        for (i in graph.indices) {

            val u = minDistance(values, visited)

            visited[u] = true

            for (j in graph.indices) {
                if (!visited[j] && values[u] != Integer.MAX_VALUE && graph[u][j] != 0 && values[u] + graph[u][j] < values[j]) {
                    values[j] = values[u] + graph[u][j]
                }
            }

        }

        showMinPath(values)

    }

    /**
     * set min value to max integer and set index to -1
     * iterate through the value index, if not visited and value is less than min, set the value
     * and set index to current index to return the index of the lesser value
     */

    private fun minDistance(values: Array<Int>, visited: Array<Boolean>): Int {

        var min = Integer.MAX_VALUE

        var index = -1

        for (i in values.indices) {

            if (!visited[i] && values[i] <= min) {
                min = values[i]
                index = i
            }
        }

        return index
    }

    /**
     * iterate through the graph, show the value in distance of what it takes to reach the source
     */

    private fun showMinPath(value: Array<Int>) {

        for (i in value.indices) {
            println("$i ${value[i]}")
        }
    }
}