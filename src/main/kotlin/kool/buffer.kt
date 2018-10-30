package kool


import org.lwjgl.PointerBuffer
import org.lwjgl.system.MemoryUtil
import org.lwjgl.system.Pointer
import java.nio.*

/**
 * Created by elect on 05/03/17.
 */

fun floatBufferBig(capacity: Int): FloatBuffer = MemoryUtil.memCallocFloat(capacity)

fun doubleBufferBig(capacity: Int): DoubleBuffer = MemoryUtil.memCallocDouble(capacity)

fun bufferBig(capacity: Int): ByteBuffer = MemoryUtil.memCalloc(capacity)
fun shortBufferBig(capacity: Int): ShortBuffer = MemoryUtil.memCallocShort(capacity)
fun intBufferBig(capacity: Int): IntBuffer = MemoryUtil.memCallocInt(capacity)
fun longBufferBig(capacity: Int): LongBuffer = MemoryUtil.memCallocLong(capacity)

fun charBufferBig(capacity: Int): CharBuffer = TODO()

fun pointerBufferBig(capacity: Int): PointerBuffer = MemoryUtil.memCallocPointer(capacity)
fun pointerBufferBig(capacity: IntBuffer): PointerBuffer = MemoryUtil.memCallocPointer(capacity[0])
fun pointerBufferBig(capacity: IntArray): PointerBuffer = MemoryUtil.memCallocPointer(capacity[0])


fun Buffer.free() = MemoryUtil.memFree(this)

// TODO specific
inline val Buffer.adr: Ptr
    get() = MemoryUtil.memAddress0(this) + (pos shl when (this) {
        is ByteBuffer -> 0
        is ShortBuffer -> 1
        is CharBuffer -> 1
        is IntBuffer -> 2
        is LongBuffer -> 3
        is FloatBuffer -> 2
        is DoubleBuffer -> 3
        else -> throw Error("unsupported buffer type")
    })

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
    get() = rem * when(this) {
        is ByteBuffer -> 1
        is ShortBuffer -> 2
        is IntBuffer -> 4
        is LongBuffer -> 8
        is FloatBuffer -> 4
        is DoubleBuffer -> 8
//        is CharBuffer -> java.lang.Integer.BYTES
        else -> throw Error("unsupported buffer type")
    }

typealias Ptr = Long // TODO -> inline class
typealias Adr = Long // TODO -> inline class