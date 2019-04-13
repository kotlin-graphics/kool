package kool

import org.lwjgl.*
import org.lwjgl.system.MemoryStack
import org.lwjgl.system.MemoryUtil
import org.lwjgl.system.Pointer
import java.nio.*

fun Buffer(size: Int): ByteBuffer = MemoryUtil.memCalloc(size)

inline fun Buffer(size: Int, init: (Int) -> Byte): ByteBuffer {
    val res = Buffer(size)
    for (i in 0 until size)
        res.put(i, init(i))
    return res
}

fun ByteBuffer(size: Int): ByteBuffer = MemoryUtil.memCalloc(size)

inline fun ByteBuffer(size: Int, init: (Int) -> Byte): ByteBuffer {
    val res = ByteBuffer(size)
    for (i in 0 until size)
        res.put(i, init(i))
    return res
}

fun ByteBuffer(bytes: ByteArray): ByteBuffer {
    val res = ByteBuffer(bytes.size)
    res.put(bytes)
    res.pos = 0
    return res
}

fun ShortBuffer(size: Int): ShortBuffer = MemoryUtil.memCallocShort(size)

inline fun ShortBuffer(size: Int, init: (Int) -> Short): ShortBuffer {
    val res = ShortBuffer(size)
    for (i in 0 until size)
        res.put(i, init(i))
    return res
}

fun ShortBuffer(shorts: ShortArray): ShortBuffer {
    val res = ShortBuffer(shorts.size)
    res.put(shorts)
    res.pos = 0
    return res
}

fun IntBuffer(size: Int): IntBuffer = MemoryUtil.memCallocInt(size)

inline fun IntBuffer(size: Int, init: (Int) -> Int): IntBuffer {
    val res = IntBuffer(size)
    for (i in 0 until size)
        res.put(i, init(i))
    return res
}

fun IntBuffer(ints: IntArray): IntBuffer {
    val res = IntBuffer(ints.size)
    res.put(ints)
    res.pos = 0
    return res
}

fun FloatBuffer(size: Int): FloatBuffer = MemoryUtil.memCallocFloat(size)

inline fun FloatBuffer(size: Int, init: (Int) -> Float): FloatBuffer {
    val res = FloatBuffer(size)
    for (i in 0 until size)
        res.put(i, init(i))
    return res
}

fun FloatBuffer(floats: FloatArray): FloatBuffer {
    val res = FloatBuffer(floats.size)
    res.put(floats)
    res.pos = 0
    return res
}

fun DoubleBuffer(size: Int): DoubleBuffer = MemoryUtil.memCallocDouble(size)

inline fun DoubleBuffer(size: Int, init: (Int) -> Double): DoubleBuffer {
    val res = DoubleBuffer(size)
    for (i in 0 until size)
        res.put(i, init(i))
    return res
}

fun DoubleBuffer(doubles: DoubleArray): DoubleBuffer {
    val res = DoubleBuffer(doubles.size)
    res.put(doubles)
    res.pos = 0
    return res
}

fun PointerBuffer(size: Int): PointerBuffer = MemoryUtil.memCallocPointer(size)

inline fun PointerBuffer(size: Int, init: (Int) -> Pointer): PointerBuffer {
    val res = PointerBuffer(size)
    for (i in 0 until size)
        res.put(i, init(i))
    return res
}

fun LongBuffer(size: Int): LongBuffer = MemoryUtil.memCallocLong(size)

inline fun LongBuffer(size: Int, init: (Int) -> Long): LongBuffer {
    val res = LongBuffer(size)
    for (i in 0 until size)
        res.put(i, init(i))
    return res
}

fun LongBuffer(longs: LongArray): LongBuffer {
    val res = LongBuffer(longs.size)
    res.put(longs)
    res.pos = 0
    return res
}


fun MemoryStack.Buffer(size: Int): ByteBuffer = MemoryUtil.memCalloc(size)

inline fun MemoryStack.Buffer(size: Int, init: (Int) -> Byte): ByteBuffer {
    val res = Buffer(size)
    for (i in 0 until size)
        res.put(i, init(i))
    return res
}

fun MemoryStack.ShortBuffer(size: Int): ShortBuffer = MemoryUtil.memCallocShort(size)

inline fun MemoryStack.ShortBuffer(size: Int, init: (Int) -> Short): ShortBuffer {
    val res = ShortBuffer(size)
    for (i in 0 until size)
        res.put(i, init(i))
    return res
}

fun MemoryStack.IntBuffer(size: Int): IntBuffer = MemoryUtil.memCallocInt(size)

inline fun MemoryStack.IntBuffer(size: Int, init: (Int) -> Int): IntBuffer {
    val res = IntBuffer(size)
    for (i in 0 until size)
        res.put(i, init(i))
    return res
}

fun MemoryStack.FloatBuffer(size: Int): FloatBuffer = MemoryUtil.memCallocFloat(size)

inline fun MemoryStack.FloatBuffer(size: Int, init: (Int) -> Float): FloatBuffer {
    val res = FloatBuffer(size)
    for (i in 0 until size)
        res.put(i, init(i))
    return res
}

fun MemoryStack.DoubleBuffer(size: Int): DoubleBuffer = MemoryUtil.memCallocDouble(size)

inline fun MemoryStack.DoubleBuffer(size: Int, init: (Int) -> Double): DoubleBuffer {
    val res = DoubleBuffer(size)
    for (i in 0 until size)
        res.put(i, init(i))
    return res
}

fun MemoryStack.PointerBuffer(size: Int): PointerBuffer = MemoryUtil.memCallocPointer(size)

inline fun MemoryStack.PointerBuffer(size: Int, init: (Int) -> Pointer): PointerBuffer {
    val res = PointerBuffer(size)
    for (i in 0 until size)
        res.put(i, init(i))
    return res
}

fun MemoryStack.LongBuffer(size: Int): LongBuffer = mallocLong(size)

inline fun MemoryStack.LongBuffer(size: Int, init: (Int) -> Long): LongBuffer {
    val res = LongBuffer(size)
    for (i in 0 until size)
        res.put(i, init(i))
    return res
}