package kool_

import org.lwjgl.system.MemoryStack
import kotlin.system.measureNanoTime

val times = 10_000

val warmup = times

fun main(args: Array<String>) {

    println("$times allocations of 1 integer, warmup = $warmup")
    println("koolUnsafe: ${measure(::koolUnsafe)}")
    println("stackUnsafe: ${measure(::stackUnsafe)}")
    println("koolSafe: ${measure(::koolSafe)}")
    println("stackSafe: ${measure(::stackSafe)}")
}

inline fun measure(block: () -> Unit): Long {
    for(i in 0 until warmup) block()

    return measureNanoTime {
        for(i in 0 until times) block()
    }
}

fun koolUnsafe() {
    for (i in 0 until times)
        kool.int
}

fun stackUnsafe() {
//    val a: MemoryStack = MemoryStack.stackGet()
//    a.push()
    for (i in 0 until times) {
        val a: MemoryStack = MemoryStack.stackGet()
        a.push()
        a.nmalloc(4)
        a.pop()
    }
//    a.pop()
}

fun koolSafe() {
    for (i in 0 until times)
        kool.intBuffer
}

fun stackSafe() {
//    val a: MemoryStack = MemoryStack.stackGet()
//    a.push()
    for (i in 0 until times) {
        val a: MemoryStack = MemoryStack.stackGet()
        a.push()
        a.callocInt(1)
        a.pop()
    }
//    a.pop()
}