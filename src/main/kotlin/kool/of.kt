package kool

import org.lwjgl.system.MemoryUtil
import java.nio.*

fun floatBufferOf(vararg floats: Float): FloatBuffer {
    val res = MemoryUtil.memAllocFloat(floats.size)
    for (i in 0 until floats.size) res.put(i, floats[i])
    return res
}

fun floatBufferOf(vararg numbers: Number): FloatBuffer {
    val res = MemoryUtil.memAllocFloat(numbers.size)
    for (i in 0 until numbers.size) res.put(i, numbers[i].toFloat())
    return res
}

fun doubleBufferOf(vararg doubles: Double): DoubleBuffer {
    val res = MemoryUtil.memAllocDouble(doubles.size)
    for (i in 0 until doubles.size) res.put(i, doubles[i])
    return res
}

fun doubleBufferOf(vararg numbers: Number): DoubleBuffer {
    val res = MemoryUtil.memAllocDouble(numbers.size)
    for (i in 0 until numbers.size) res.put(i, numbers[i].toDouble())
    return res
}

fun bufferOf(vararg bytes: Byte): ByteBuffer {
    val res = MemoryUtil.memAlloc(bytes.size)
    for (i in 0 until bytes.size) res.put(i, bytes[i])
    return res
}

fun bufferOf(vararg bytes: Number): ByteBuffer {
    val res = MemoryUtil.memAlloc(bytes.size)
    for (i in 0 until bytes.size) res.put(i, bytes[i].toByte())
    return res
}

fun bufferOf(vararg floats: Float): ByteBuffer {
    val res = MemoryUtil.memAlloc(floats.size * 4)
    for (i in 0 until floats.size) res.putFloat(i * 4, floats[i])
    return res
}

fun shortBufferOf(vararg shorts: Short): ShortBuffer {
    val res = MemoryUtil.memAllocShort(shorts.size)
    for (i in 0 until shorts.size) res.put(i, shorts[i])
    return res
}

fun shortBufferOf(vararg numbers: Number): ShortBuffer {
    val res = MemoryUtil.memAllocShort(numbers.size)
    for (i in 0 until numbers.size) res.put(i, numbers[i].toShort())
    return res
}

fun intBufferOf(vararg ints: Int): IntBuffer {
    val res = MemoryUtil.memAllocInt(ints.size)
    for (i in 0 until ints.size) res.put(i, ints[i])
    return res
}

fun intBufferOf(vararg numbers: Number): IntBuffer {
    val res = MemoryUtil.memAllocInt(numbers.size)
    for (i in 0 until numbers.size) res.put(i, numbers[i].toInt())
    return res
}

fun longBufferOf(vararg longs: Long): LongBuffer {
    val res = MemoryUtil.memAllocLong(longs.size)
    for (i in 0 until longs.size) res.put(i, longs[i])
    return res
}

fun longBufferOf(vararg numbers: Number): LongBuffer {
    val res = MemoryUtil.memAllocLong(numbers.size)
    for (i in 0 until numbers.size) res.put(i, numbers[i].toLong())
    return res
}