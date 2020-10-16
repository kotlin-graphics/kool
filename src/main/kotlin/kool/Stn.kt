package kool

class Stn {
}

fun main() {
//    val pr = "\uD83C\uDDF5\uD83C\uDDF7"
    val pr = "😂😍🎉👍"
    println(pr)
    println(pr.length)
    println(pr.codePoints().count())
    println("chars")
    for (c in pr)
        println(c.toInt())
}