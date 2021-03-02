package com.chaka.binarygap

fun main() {
//    BinaryGap().start()
    val links = Links()
    links.insert(11)
    links.insert(14)
    links.insert(16)
//    links.insert(18)


    links.show()
    print("\n")

    links.insertAt(4, 15)
    links.show()
}
