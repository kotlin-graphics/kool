package kool

import org.lwjgl.PointerBuffer
import org.lwjgl.system.MemoryStack
import org.lwjgl.system.MemoryUtil
import org.lwjgl.system.Pointer
import java.nio.*

// typealias

fun Buffer(size: Int): ByteBuffer = MemoryUtil.memCalloc(size)
inline fun Buffer(size: Int, init: (Int) -> Byte) = Buffer(size).apply { for (i in 0 until size) this[i] = init(i) }

fun ByteBuffer(size: Int): ByteBuffer = MemoryUtil.memCalloc(size)
inline fun ByteBuffer(size: Int, init: (Int) -> Byte) = ByteBuffer(size).apply { for (i in 0 until size) this[i] = init(i) }

fun ShortBuffer(size: Int): ShortBuffer = MemoryUtil.memCallocShort(size)
inline fun ShortBuffer(size: Int, init: (Int) -> Short) = ShortBuffer(size).apply { for (i in 0 until size) this[i] = init(i) }

fun IntBuffer(size: Int): IntBuffer = MemoryUtil.memCallocInt(size)
inline fun IntBuffer(size: Int, init: (Int) -> Int) = IntBuffer(size).apply { for (i in 0 until size) this[i] = init(i) }

fun LongBuffer(size: Int): LongBuffer = MemoryUtil.memCallocLong(size)
inline fun LongBuffer(size: Int, init: (Int) -> Long) = LongBuffer(size).apply { for (i in 0 until size) this[i] = init(i) }

fun FloatBuffer(size: Int): FloatBuffer = MemoryUtil.memCallocFloat(size)
inline fun FloatBuffer(size: Int, init: (Int) -> Float) = FloatBuffer(size).apply { for (i in 0 until size) this[i] = init(i) }

fun DoubleBuffer(size: Int): DoubleBuffer = MemoryUtil.memCallocDouble(size)
inline fun DoubleBuffer(size: Int, init: (Int) -> Double) = DoubleBuffer(size).apply { for (i in 0 until size) this[i] = init(i) }

fun PointerBuffer(size: Int): PointerBuffer = MemoryUtil.memCallocPointer(size)
inline fun PointerBuffer(size: Int, init: (Int) -> Pointer)  = PointerBuffer(size).apply { for (i in 0 until size) this[i] = init(i) }

// MemoryStack version

fun MemoryStack.Buffer(size: Int): ByteBuffer = calloc(size)
inline fun MemoryStack.Buffer(size: Int, init: (Int) -> Byte) = Buffer(size).apply { for (i in 0 until size) this[i] = init(i) }

fun MemoryStack.ByteBuffer(size: Int): ByteBuffer = calloc(size)
inline fun MemoryStack.ByteBuffer(size: Int, init: (Int) -> Byte) = ByteBuffer(size).apply { for (i in 0 until size) this[i] = init(i) }

fun MemoryStack.ShortBuffer(size: Int): ShortBuffer = callocShort(size)
inline fun MemoryStack.ShortBuffer(size: Int, init: (Int) -> Short) = ShortBuffer(size).apply { for (i in 0 until size) this[i] = init(i) }

fun MemoryStack.IntBuffer(size: Int): IntBuffer = callocInt(size)
inline fun MemoryStack.IntBuffer(size: Int, init: (Int) -> Int)= IntBuffer(size).apply { for (i in 0 until size) this[i] = init(i) }

fun MemoryStack.LongBuffer(size: Int): LongBuffer = mallocLong(size)
inline fun MemoryStack.LongBuffer(size: Int, init: (Int) -> Long)= LongBuffer(size).apply { for (i in 0 until size) this[i] = init(i) }

fun MemoryStack.FloatBuffer(size: Int): FloatBuffer = callocFloat(size)
inline fun MemoryStack.FloatBuffer(size: Int, init: (Int) -> Float) = FloatBuffer(size).apply { for (i in 0 until size) this[i] = init(i) }

fun MemoryStack.DoubleBuffer(size: Int): DoubleBuffer = callocDouble(size)
inline fun MemoryStack.DoubleBuffer(size: Int, init: (Int) -> Double)= DoubleBuffer(size).apply { for (i in 0 until size) this[i] = init(i) }

fun MemoryStack.PointerBuffer(size: Int): PointerBuffer = callocPointer(size)
inline fun MemoryStack.PointerBuffer(size: Int, init: (Int) -> Pointer)= PointerBuffer(size).apply { for (i in 0 until size) this[i] = init(i) }

