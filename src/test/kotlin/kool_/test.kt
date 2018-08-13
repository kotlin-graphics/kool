package kool_

import org.lwjgl.system.MemoryStack
import kotlin.system.measureNanoTime

val times = 10_000

val warmup = times

fun main(args: Array<String>) {

    println("$times allocations of 1 integer, warmup = $warmup")
    println("koolUnsafe: ${measure(::koolUnsafe)}")
    println("stackUnsafeMultiple: ${measure(::stackUnsafeMultiple)}")
    println("stackUnsafeSingle: ${measure(::stackUnsafeSingle)}")
    println("koolSafe: ${measure(::koolSafe)}")
    println("stackSafeMultiple: ${measure(::stackSafeMultiple)}")
    println("stackSafeSingle: ${measure(::stackSafeSingle)}")
}

inline fun measure(block: () -> Unit): Long {
    for(i in 0 until warmup) block()

    return measureNanoTime {
        for(i in 0 until times) block()
    } / times
}

fun koolUnsafe() {
    for (i in 0 until times)
        kool.int
}

fun stackUnsafeMultiple() {
    for (i in 0 until times) {
        val a: MemoryStack = MemoryStack.stackGet()
        a.push()
        a.ncalloc(1, 1, 4)
        a.pop()
    }
}

fun stackUnsafeSingle() {
    val a: MemoryStack = MemoryStack.stackGet()
    for (i in 0 until times) {
        a.push()
        a.ncalloc(1, 1, 4)
        a.pop()
    }
}

fun koolSafe() {
    for (i in 0 until times)
        kool.intBuffer
}

fun stackSafeMultiple() {
    for (i in 0 until times) {
        val a: MemoryStack = MemoryStack.stackGet()
        a.push()
        a.callocInt(1)
        a.pop()
    }
}

fun stackSafeSingle() {
    val a: MemoryStack = MemoryStack.stackGet()
    for (i in 0 until times) {
        a.push()
        a.callocInt(1)
        a.pop()
    }
}