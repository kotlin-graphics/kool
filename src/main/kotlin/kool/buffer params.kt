package kool


import org.lwjgl.system.MemoryUtil
import java.nio.*

/**
 * Created by elect on 05/03/17.
 */
@Suppress("NOTHING_TO_INLINE")
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

inline val Buffer.remByte: Int
    get() = rem * when (this) {
        is ByteBuffer -> 1
        is ShortBuffer, is CharBuffer -> 2
        is IntBuffer, is FloatBuffer -> 4
        is LongBuffer, is DoubleBuffer -> 8
        else -> throw Error("Invalid buffer type")
    }

inline var Buffer.lim: Int
    get() = limit()
    set(value) {
        limit(value)
    }