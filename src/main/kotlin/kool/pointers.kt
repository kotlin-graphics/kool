package kool

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

    inline operator fun get(index: Int): Byte = UNSAFE.getByte(null, adr + index * Byte.SIZE_BYTES)
    inline operator fun set(index: Int, byte: Byte) = UNSAFE.putByte(null, adr + index * Byte.SIZE_BYTES, byte)
    inline operator fun invoke(): Byte = UNSAFE.getByte(null, adr)
}

inline class IntPtr(val adr: Adr) {

    inline operator fun get(index: Int): Int = UNSAFE.getInt(null, adr + index * Int.SIZE_BYTES)
    inline operator fun set(index: Int, int: Int) = UNSAFE.putInt(null, adr + index * Int.SIZE_BYTES, int)
    inline operator fun invoke(): Int = UNSAFE.getInt(null, adr)
}

inline class ShortPtr(val adr: Adr) {

    inline operator fun get(index: Int): Short = UNSAFE.getShort(null, adr + index * Short.SIZE_BYTES)
    inline operator fun set(index: Int, short: Short) = UNSAFE.putShort(null, adr + index * Short.SIZE_BYTES, short)
    inline operator fun invoke(): Short = UNSAFE.getShort(null, adr)
}

inline class LongPtr(val adr: Adr) {

    inline operator fun get(index: Int): Long = UNSAFE.getLong(null, adr + index * Long.SIZE_BYTES)
    inline operator fun set(index: Int, long: Long) = UNSAFE.putLong(null, adr + index * Long.SIZE_BYTES, long)
    inline operator fun invoke(): Long = UNSAFE.getLong(null, adr)
}

inline class FloatPtr(val adr: Adr) {

    inline operator fun get(index: Int): Float = UNSAFE.getFloat(null, adr + index * java.lang.Float.BYTES)
    inline operator fun set(index: Int, float: Float) = UNSAFE.putFloat(null, adr + index * java.lang.Float.BYTES, float)
    inline operator fun invoke(): Float = UNSAFE.getFloat(null, adr)
}

inline class DoublePtr(val adr: Adr) {

    inline operator fun get(index: Int): Double = UNSAFE.getDouble(null, adr + index * java.lang.Double.BYTES)
    inline operator fun set(index: Int, double: Double) = UNSAFE.putDouble(null, adr + index * java.lang.Double.BYTES, double)
    inline operator fun invoke(): Double = UNSAFE.getDouble(null, adr)
}

inline class PointerPtr(val adr: Adr) {

    inline operator fun get(index: Int): Ptr = UNSAFE.getLong(null, adr + index * Long.SIZE_BYTES)
    inline operator fun set(index: Int, ptr: Ptr) = UNSAFE.putLong(null, adr + index * Long.SIZE_BYTES, ptr)
    inline operator fun set(index: Int, pointer: Pointer) = UNSAFE.putLong(null, adr + index * Long.SIZE_BYTES, pointer.adr)
    inline operator fun set(index: Int, buffer: Buffer) = UNSAFE.putLong(null, adr + index * Long.SIZE_BYTES, buffer.adr)
    inline operator fun invoke(): Ptr = UNSAFE.getLong(null, adr)
}

