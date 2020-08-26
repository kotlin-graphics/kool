package kool


import org.lwjgl.system.MemoryUtil
import java.nio.*

/**
 * Created by elect on 05/03/17.
 */

inline fun Buffer.free() = MemoryUtil.memFree(this)

inline val Buffer.adr: Adr
    get() = MemoryUtil.memAddress(this)

inline var Buffer.pos: Int
    get() = position()
    set(value) {
        position(value)
    }

inline val Buffer.cap: Int
    get() = capacity()

inline val Buffer.rem: Int
    get() = remaining()

inline val Buffer.remSize: Int
    get() = rem * when (this) {
        is ByteBuffer -> 1
        is ShortBuffer, is CharBuffer -> 2
        is IntBuffer, is FloatBuffer -> 4
        is LongBuffer, is DoubleBuffer -> 8
        else -> throw Error("Invalid buffer type")
    }

fun main() {
    val a: ByteArray
    a.rev
}

inline var Buffer.lim: Int
    get() = limit()
    set(value) {
        limit(value)
    }


// sliceAt

fun ByteBuffer.sliceAs(offset: Int, size: Int = lim - offset): ByteBuffer {
    val backupPos = pos
    val backupLim = lim
    pos = offset
    lim = offset + size
    val res = slice()
    pos = backupPos
    lim = backupLim
    return res
}

fun ShortBuffer.sliceAs(offset: Int, size: Int = lim - offset): ShortBuffer {
    val backupPos = pos
    val backupLim = lim
    pos = offset
    lim = offset + size
    val res = slice()
    pos = backupPos
    lim = backupLim
    return res
}

fun IntBuffer.sliceAs(offset: Int, size: Int = lim - offset): IntBuffer {
    val backupPos = pos
    val backupLim = lim
    pos = offset
    lim = offset + size
    val res = slice()
    pos = backupPos
    lim = backupLim
    return res
}

fun LongBuffer.sliceAs(offset: Int, size: Int = lim - offset): LongBuffer {
    val backupPos = pos
    val backupLim = lim
    pos = offset
    lim = offset + size
    val res = slice()
    pos = backupPos
    lim = backupLim
    return res
}

fun FloatBuffer.sliceAs(offset: Int, size: Int = lim - offset): FloatBuffer {
    val backupPos = pos
    val backupLim = lim
    pos = offset
    lim = offset + size
    val res = slice()
    pos = backupPos
    lim = backupLim
    return res
}

fun DoubleBuffer.sliceAs(offset: Int, size: Int = lim - offset): DoubleBuffer {
    val backupPos = pos
    val backupLim = lim
    pos = offset
    lim = offset + size
    val res = slice()
    pos = backupPos
    lim = backupLim
    return res
}

fun CharBuffer.sliceAs(offset: Int, size: Int = lim - offset): CharBuffer {
    val backupPos = pos
    val backupLim = lim
    pos = offset
    lim = offset + size
    val res = slice()
    pos = backupPos
    lim = backupLim
    return res
}