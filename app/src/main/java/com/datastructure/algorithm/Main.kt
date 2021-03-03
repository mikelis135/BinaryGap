package com.datastructure.algorithm

fun main() {
//    BinaryGap().start()
    val links = Links()

//    links.show()
//    print("\n")

    links.insert(15)
    links.insert(13)
    links.insertAt(2, 1)
    links.insertAt(0, 3)
//    links.insertAt(1, 4)
//    links.insertAt(2, 5)
//    links.insertAt(3, 7)
//    links.insertAt(4, 2)
    links.deleteAt(1)
    links.show()
}
