package kool

import org.lwjgl.PointerBuffer
import org.lwjgl.system.CustomBuffer
import org.lwjgl.system.MemoryStack
import org.lwjgl.system.MemoryUtil.*
import org.lwjgl.system.Pointer
import java.nio.*

inline val Pointer.adr: Adr
    get() = address()

inline var Buffer.lim: Int
    get() = limit()
    set(value) {
        limit(value)
    }


inline val <SELF : CustomBuffer<SELF>>CustomBuffer<SELF>.adr
    get() = address()

inline val <SELF : CustomBuffer<SELF>>CustomBuffer<SELF>.cap
    get() = capacity()

inline var <SELF : CustomBuffer<SELF>>CustomBuffer<SELF>.lim
    get() = limit()
    set(value) {
        limit(value)
    }

inline val <SELF : CustomBuffer<SELF>>CustomBuffer<SELF>.rem
    get() = remaining()

inline val <SELF : CustomBuffer<SELF>>CustomBuffer<SELF>.indices: IntRange
    get() = IntRange(0, lastIndex)

inline val <SELF : CustomBuffer<SELF>>CustomBuffer<SELF>.lastIndex: Int
    get() = cap - 1



fun ByteBuffer(size: Int): ByteBuffer = memCalloc(size)

inline fun ByteBuffer(size: Int, init: (Int) -> Byte): ByteBuffer {
    val res = ByteBuffer(size)
    for (i in 0 until size)
        res.put(i, init(i))
    return res
}

fun ShortBuffer(size: Int): ShortBuffer = memCallocShort(size)

inline fun ShortBuffer(size: Int, init: (Int) -> Short): ShortBuffer {
    val res = ShortBuffer(size)
    for (i in 0 until size)
        res.put(i, init(i))
    return res
}

fun IntBuffer(size: Int): IntBuffer = memCallocInt(size)

inline fun IntBuffer(size: Int, init: (Int) -> Int): IntBuffer {
    val res = IntBuffer(size)
    for (i in 0 until size)
        res.put(i, init(i))
    return res
}

fun FloatBuffer(size: Int): FloatBuffer = memCallocFloat(size)

inline fun FloatBuffer(size: Int, init: (Int) -> Float): FloatBuffer {
    val res = FloatBuffer(size)
    for (i in 0 until size)
        res.put(i, init(i))
    return res
}

fun DoubleBuffer(size: Int): DoubleBuffer = memCallocDouble(size)

inline fun DoubleBuffer(size: Int, init: (Int) -> Double): DoubleBuffer {
    val res = DoubleBuffer(size)
    for (i in 0 until size)
        res.put(i, init(i))
    return res
}

fun PointerBuffer(size: Int): PointerBuffer = memCallocPointer(size)

inline fun PointerBuffer(size: Int, init: (Int) -> Pointer): PointerBuffer {
    val res = PointerBuffer(size)
    for (i in 0 until size)
        res.put(i, init(i))
    return res
}

fun LongBuffer(size: Int): LongBuffer = memCallocLong(size)

inline fun LongBuffer(size: Int, init: (Int) -> Long): LongBuffer {
    val res = LongBuffer(size)
    for (i in 0 until size)
        res.put(i, init(i))
    return res
}


fun MemoryStack.ByteBuffer(size: Int): ByteBuffer = memCalloc(size)

inline fun MemoryStack.ByteBuffer(size: Int, init: (Int) -> Byte): ByteBuffer {
    val res = ByteBuffer(size)
    for (i in 0 until size)
        res.put(i, init(i))
    return res
}

fun MemoryStack.ShortBuffer(size: Int): ShortBuffer = memCallocShort(size)

inline fun MemoryStack.ShortBuffer(size: Int, init: (Int) -> Short): ShortBuffer {
    val res = ShortBuffer(size)
    for (i in 0 until size)
        res.put(i, init(i))
    return res
}

fun MemoryStack.IntBuffer(size: Int): IntBuffer = memCallocInt(size)

inline fun MemoryStack.IntBuffer(size: Int, init: (Int) -> Int): IntBuffer {
    val res = IntBuffer(size)
    for (i in 0 until size)
        res.put(i, init(i))
    return res
}

fun MemoryStack.FloatBuffer(size: Int): FloatBuffer = memCallocFloat(size)

inline fun MemoryStack.FloatBuffer(size: Int, init: (Int) -> Float): FloatBuffer {
    val res = FloatBuffer(size)
    for (i in 0 until size)
        res.put(i, init(i))
    return res
}

fun MemoryStack.DoubleBuffer(size: Int): DoubleBuffer = memCallocDouble(size)

inline fun MemoryStack.DoubleBuffer(size: Int, init: (Int) -> Double): DoubleBuffer {
    val res = DoubleBuffer(size)
    for (i in 0 until size)
        res.put(i, init(i))
    return res
}

fun MemoryStack.PointerBuffer(size: Int): PointerBuffer = memCallocPointer(size)

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