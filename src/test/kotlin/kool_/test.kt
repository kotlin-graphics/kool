package kool_

import org.lwjgl.system.MemoryStack
import org.lwjgl.system.MemoryUtil
import kotlin.system.measureNanoTime

const val times = 10_000
const val iterations = 100_000

const val warmup = times

fun main(args: Array<String>) {

    for (i in 0 until times)
        System.nanoTime()

    println("$times allocations of 1 integer, warmup = $warmup")
    println("koolUnsafe: ${measure(::koolUnsafe)}")
    println("stackUnsafeMultiple: ${measure(::stackUnsafeMultiple)}")
    println("stackUnsafeSingle: ${measure(::stackUnsafeSingle)}")
    println("koolSafe: ${measure(::koolSafe)}")
    println("stackSafeMultiple: ${measure(::stackSafeMultiple)}")
    println("stackSafeSingle: ${measure(::stackSafeSingle)}")
}

fun measure(block: () -> Unit): Double {
    block()
    var total = 0.0
    for (i in 0 until iterations) {
        stak.reset()
        total += measureNanoTime { block() }
    }
    return total / iterations / times
}

fun koolUnsafe() {
    for (i in 0 until times)
        MemoryUtil.memPutInt(stak.int, 1)
}

fun stackUnsafeMultiple() {
    for (i in 0 until times) {
        val a: MemoryStack = MemoryStack.stackGet()
        a.push()
        val ptr = a.ncalloc(4, 1, 4)
        MemoryUtil.memPutInt(ptr, 1)
        a.pop()
    }
}

fun stackUnsafeSingle() {
    val a: MemoryStack = MemoryStack.stackGet()
    for (i in 0 until times) {
        a.push()
        val ptr = a.ncalloc(4, 1, 4)
        MemoryUtil.memPutInt(ptr, 1)
        a.pop()
    }
}

fun koolSafe() {
    for (i in 0 until times)
        stak.intBuffer.put(0, 1)
}

fun stackSafeMultiple() {
    for (i in 0 until times) {
        val a: MemoryStack = MemoryStack.stackGet()
        a.push()
        a.callocInt(1).put(0, 1)
        a.pop()
    }
}

fun stackSafeSingle() {
    val a: MemoryStack = MemoryStack.stackGet()
    for (i in 0 until times) {
        a.push()
        a.callocInt(1).put(0, 1)
        a.pop()
    }
}