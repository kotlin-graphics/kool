package kool

import org.lwjgl.system.MemoryStack
import org.lwjgl.system.MemoryUtil
import org.lwjgl.system.Pointer
import sun.misc.Unsafe
import java.nio.Buffer

/*
Different runtimes use different names for the Unsafe singleton,
so we cannot use .getDeclaredField and we scan instead. For example:

Oracle: theUnsafe
PERC : m_unsafe_instance
Android: THE_ONE
*/
val UNSAFE: Unsafe by lazy {
    Unsafe::class.java.declaredFields
            .find {
                it.type == Unsafe::class.java &&
                        java.lang.reflect.Modifier.isStatic(it.modifiers)
                        && java.lang.reflect.Modifier.isFinal(it.modifiers)
            }?.run {
                isAccessible = true
                get(null) as Unsafe
            } ?: throw UnsupportedOperationException("LWJGL requires sun.misc.Unsafe to be available.")
}

inline class BytePtr(val adr: Adr) {

    inline operator fun get(index: Int): Byte = UNSAFE.getByte(null, adr + index * Byte.BYTES)
    inline operator fun set(index: Int, byte: Byte) = UNSAFE.putByte(null, adr + index * Byte.BYTES, byte)
    inline operator fun invoke(): Byte = UNSAFE.getByte(null, adr)

    inline operator fun plus(offset: Int): BytePtr = BytePtr(adr + offset * Byte.BYTES)
//    inline operator fun plus(pByte: BytePtr): BytePtr = BytePtr(adr + pByte.adr)

    companion object {
        val NULL get() = BytePtr(MemoryUtil.NULL)
    }
}

inline fun BytePtr(intPtr: IntPtr) = BytePtr(intPtr.adr)
inline fun BytePtr(shortPtr: ShortPtr) = BytePtr(shortPtr.adr)
inline fun BytePtr(longPtr: LongPtr) = BytePtr(longPtr.adr)
inline fun BytePtr(floatPtr: FloatPtr) = BytePtr(floatPtr.adr)
inline fun BytePtr(doublePtr: DoublePtr) = BytePtr(doublePtr.adr)

inline fun BytePtr(size: Int, init: (Int) -> Byte): BytePtr {
    val adr = MemoryUtil.nmemAlloc(size.toLong() * Byte.BYTES)
    for (i in 0 until size) MemoryUtil.memPutByte(adr + i * Byte.BYTES, init(i))
    return BytePtr(adr)
}

inline fun MemoryStack.BytePtr(size: Int, init: (Int) -> Byte): BytePtr {
    val adr = nmalloc(1, size * Byte.BYTES)
    for (i in 0 until size) MemoryUtil.memPutByte(adr + i * Byte.BYTES, init(i))
    return BytePtr(adr)
}

inline class ShortPtr(val adr: Adr) {

    inline operator fun get(index: Int): Short = UNSAFE.getShort(null, adr + index * Short.BYTES)
    inline operator fun set(index: Int, short: Short) = UNSAFE.putShort(null, adr + index * Short.BYTES, short)
    inline operator fun invoke(): Short = UNSAFE.getShort(null, adr)

    inline operator fun plus(offset: Int): ShortPtr = ShortPtr(adr + offset * Short.BYTES)

    companion object {
        val NULL get() = ShortPtr(MemoryUtil.NULL)
    }
}

inline fun ShortPtr(bytePtr: BytePtr) = ShortPtr(bytePtr.adr)

inline fun ShortPtr(size: Int, init: (Int) -> Short): ShortPtr {
    val adr = MemoryUtil.nmemAlloc(size.toLong()  * Short.BYTES)
    for (i in 0 until size) MemoryUtil.memPutShort(adr + i * Short.BYTES, init(i))
    return ShortPtr(adr)
}

inline fun MemoryStack.ShortPtr(size: Int, init: (Int) -> Short): ShortPtr {
    val adr = nmalloc(size  * Short.BYTES)
    for (i in 0 until size) MemoryUtil.memPutShort(adr + i * Short.BYTES, init(i))
    return ShortPtr(adr)
}

inline class IntPtr(val adr: Adr) {
    inline operator fun get(index: Int): Int = UNSAFE.getInt(null, adr + index * Int.BYTES)
    inline operator fun set(index: Int, int: Int) = UNSAFE.putInt(null, adr + index * Int.BYTES, int)
    inline operator fun invoke(): Int = UNSAFE.getInt(null, adr)

    inline operator fun plus(offset: Int): IntPtr = IntPtr(adr + offset * Int.BYTES)

    companion object {
        val NULL get() = IntPtr(MemoryUtil.NULL)
    }
}

inline fun IntPtr(bytePtr: BytePtr) = IntPtr(bytePtr.adr)

inline fun IntPtr(size: Int, init: (Int) -> Int): IntPtr {
    val adr = MemoryUtil.nmemAlloc(size.toLong() * Int.BYTES)
    for (i in 0 until size) MemoryUtil.memPutInt(adr + i * Int.BYTES, init(i))
    return IntPtr(adr)
}

inline fun MemoryStack.IntPtr(size: Int, init: (Int) -> Int): IntPtr {
    val adr = nmalloc(size * Int.BYTES)
    for (i in 0 until size) MemoryUtil.memPutInt(adr + i * Int.BYTES, init(i))
    return IntPtr(adr)
}

inline class LongPtr(val adr: Adr) {

    inline operator fun get(index: Int): Long = UNSAFE.getLong(null, adr + index * Long.BYTES)
    inline operator fun set(index: Int, long: Long) = UNSAFE.putLong(null, adr + index * Long.BYTES, long)
    inline operator fun invoke(): Long = UNSAFE.getLong(null, adr)

    inline operator fun plus(offset: Int): LongPtr = LongPtr(adr + offset * Long.BYTES)

    companion object {
        val NULL get() = LongPtr(MemoryUtil.NULL)
    }
}

inline fun LongPtr(bytePtr: BytePtr) = LongPtr(bytePtr.adr)

inline fun LongPtr(size: Int, init: (Int) -> Long): LongPtr {
    val adr = MemoryUtil.nmemAlloc(size.toLong() * Long.BYTES)
    for (i in 0 until size) MemoryUtil.memPutLong(adr + i * Long.BYTES, init(i))
    return LongPtr(adr)
}

inline fun MemoryStack.LongPtr(size: Int, init: (Int) -> Long): LongPtr {
    val adr = nmalloc(size * Long.BYTES)
    for (i in 0 until size) MemoryUtil.memPutLong(adr + i * Long.BYTES, init(i))
    return LongPtr(adr)
}

inline class FloatPtr(val adr: Adr) {

    inline operator fun get(index: Int): Float = UNSAFE.getFloat(null, adr + index * Float.BYTES)
    inline operator fun set(index: Int, float: Float) = UNSAFE.putFloat(null, adr + index * Float.BYTES, float)
    inline operator fun invoke(): Float = UNSAFE.getFloat(null, adr)

    inline operator fun plus(offset: Int): FloatPtr = FloatPtr(adr + offset * Float.BYTES)

    companion object {
        val NULL get() = FloatPtr(MemoryUtil.NULL)
    }
}

inline fun FloatPtr(bytePtr: BytePtr) = FloatPtr(bytePtr.adr)

inline fun FloatPtr(size: Int, init: (Int) -> Float): FloatPtr {
    val adr = MemoryUtil.nmemAlloc(size.toLong() * Float.BYTES)
    for (i in 0 until size) MemoryUtil.memPutFloat(adr + i * Float.BYTES, init(i))
    return FloatPtr(adr)
}

inline fun MemoryStack.FloatPtr(size: Int, init: (Int) -> Float): FloatPtr {
    val adr = nmalloc(size * Float.BYTES)
    for (i in 0 until size) MemoryUtil.memPutFloat(adr + i * Float.BYTES, init(i))
    return FloatPtr(adr)
}

inline class DoublePtr(val adr: Adr) {

    inline operator fun get(index: Int): Double = UNSAFE.getDouble(null, adr + index * Double.BYTES)
    inline operator fun set(index: Int, double: Double) = UNSAFE.putDouble(null, adr + index * Double.BYTES, double)
    inline operator fun invoke(): Double = UNSAFE.getDouble(null, adr)

    inline operator fun plus(offset: Int): DoublePtr = DoublePtr(adr + offset * Double.BYTES)

    companion object {
        val NULL get() = DoublePtr(MemoryUtil.NULL)
    }
}

inline fun DoublePtr(bytePtr: BytePtr) = DoublePtr(bytePtr.adr)

inline fun DoublePtr(size: Int, init: (Int) -> Double): DoublePtr {
    val adr = MemoryUtil.nmemAlloc(size.toLong() * Double.BYTES)
    for (i in 0 until size) MemoryUtil.memPutDouble(adr + i * Double.BYTES, init(i))
    return DoublePtr(adr)
}

inline fun MemoryStack.DoublePtr(size: Int, init: (Int) -> Double): DoublePtr {
    val adr = nmalloc(size * Double.BYTES)
    for (i in 0 until size) MemoryUtil.memPutDouble(adr + i * Double.BYTES, init(i))
    return DoublePtr(adr)
}

inline class PointerPtr(val adr: Adr) {

    inline operator fun get(index: Int): Ptr = UNSAFE.getLong(null, adr + index * Long.BYTES)
    inline operator fun set(index: Int, ptr: Ptr) = UNSAFE.putLong(null, adr + index * Long.BYTES, ptr)
    inline operator fun set(index: Int, pointer: Pointer) = UNSAFE.putLong(null, adr + index * Long.BYTES, pointer.adr)
    inline operator fun set(index: Int, buffer: Buffer) = UNSAFE.putLong(null, adr + index * Long.BYTES, buffer.adr)
    inline operator fun invoke(): Ptr = UNSAFE.getLong(null, adr)

    inline operator fun plus(offset: Int): PointerPtr = PointerPtr(adr + offset * Long.BYTES)

    companion object {
        val NULL get() = PointerPtr(MemoryUtil.NULL)
    }
}

inline fun PointerPtr(bytePtr: BytePtr) = PointerPtr(bytePtr.adr)

inline fun PointerPtr(size: Int, init: (Int) -> Ptr): PointerPtr {
    val adr = MemoryUtil.nmemAlloc(size.toLong() * Long.BYTES)
    for (i in 0 until size) MemoryUtil.memPutLong(adr + i * Long.BYTES, init(i))
    return PointerPtr(adr)
}

inline fun MemoryStack.PointerPtr(size: Int, init: (Int) -> Ptr): PointerPtr {
    val adr = nmalloc(size * Long.BYTES)
    for (i in 0 until size) MemoryUtil.memPutLong(adr + i * Long.BYTES, init(i))
    return PointerPtr(adr)
}