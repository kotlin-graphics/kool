@file:Suppress("NOTHING_TO_INLINE")
package kool

import sun.misc.Unsafe

/**
 * Different runtimes use different names for the Unsafe singleton, so we cannot use `.getDeclaredField` and
 * we scan instead. For example:
 * Oracle: theUnsafe
 * PERC : m_unsafe_instance
 * Android: THE_ONE
 */
val unsafe: Unsafe by lazy {
    Unsafe::class.java.declaredFields
            .find {
                it.type == Unsafe::class.java &&
                        java.lang.reflect.Modifier.isStatic(it.modifiers)
                        && java.lang.reflect.Modifier.isFinal(it.modifiers)
            }?.run {
                isAccessible = true
                get(null) as Unsafe
            } ?: throw UnsupportedOperationException("Kool requires sun.misc.Unsafe to be available.")
}
inline operator fun Unsafe.get(offset: ULong): Byte = getByte(offset.toLong())
inline operator fun Unsafe.get(offset: Long): Byte = getByte(offset)
inline operator fun <reified T> Unsafe.get(offset: ULong): T = get<T>(offset.toLong())
inline operator fun <reified T> Unsafe.get(offset: Long): T = when (T::class.java) {
    Byte::class.java -> getByte(offset)
    Short::class.java -> getShort(offset)
    Int::class.java -> getInt(offset)
    Long::class.java -> getLong(offset)
    UByte::class.java -> getUByte(offset)
    UShort::class.java -> getUShort(offset)
    UInt::class.java -> getUInt(offset)
    ULong::class.java -> getULong(offset)
    Float::class.java -> getFloat(offset)
    Double::class.java -> getDouble(offset)
    else -> error("type ${T::class} unsupported")
} as T
inline fun Unsafe.getChar(offset: Int): Char = getChar(offset.toULong())
inline fun Unsafe.getChar(offset: UInt): Char = getChar(offset.toULong())
inline fun Unsafe.getChar(offset: ULong): Char = getChar(offset.toLong())
inline fun Unsafe.set(offset: Int, char: Char) = set(offset.toULong(), char)
inline fun Unsafe.set(offset: UInt, char: Char) = set(offset.toULong(), char)
inline fun Unsafe.set(offset: ULong, char: Char) = putChar(null, offset.toLong(), char)
inline fun Unsafe.getByte(offset: Int): Byte = getByte(offset.toULong())
inline fun Unsafe.getByte(offset: UInt): Byte = getByte(offset.toULong())
inline fun Unsafe.getByte(offset: ULong): Byte = getByte(offset.toLong())
inline fun Unsafe.set(offset: Int, byte: Byte) = set(offset.toULong(), byte)
inline fun Unsafe.set(offset: UInt, byte: Byte) = set(offset.toULong(), byte)
inline fun Unsafe.set(offset: ULong, byte: Byte) = putByte(null, offset.toLong(), byte)
inline fun Unsafe.getShort(offset: Int): Short = getShort(offset.toULong())
inline fun Unsafe.getShort(offset: UInt): Short = getShort(offset.toULong())
inline fun Unsafe.getShort(offset: ULong): Short = getShort(offset.toLong())
inline fun Unsafe.set(offset: Int, short: Short) = set(offset.toULong(), short)
inline fun Unsafe.set(offset: UInt, short: Short) = set(offset.toULong(), short)
inline fun Unsafe.set(offset: ULong, short: Short) = putShort(null, offset.toLong(), short)
inline fun Unsafe.getInt(offset: Int): Int = getInt(offset.toULong())
inline fun Unsafe.getInt(offset: UInt): Int = getInt(offset.toULong())
inline fun Unsafe.getInt(offset: ULong): Int = getInt(offset.toLong())
inline fun Unsafe.set(offset: Int, int: Int) = set(offset.toULong(), int)
inline fun Unsafe.set(offset: UInt, int: Int) = set(offset.toULong(), int)
inline fun Unsafe.set(offset: ULong, int: Int) = putInt(null, offset.toLong(), int)
inline fun Unsafe.getLong(offset: Int): Long = getLong(offset.toULong())
inline fun Unsafe.getLong(offset: UInt): Long = getLong(offset.toULong())
inline fun Unsafe.getLong(offset: ULong): Long = getLong(offset.toLong())
inline fun Unsafe.set(offset: Int, long: Long) = set(offset.toULong(), long)
inline fun Unsafe.set(offset: UInt, long: Long) = set(offset.toULong(), long)
inline fun Unsafe.set(offset: ULong, long: Long) = putLong(null, offset.toLong(), long)
inline fun Unsafe.getUByte(offset: Int): UByte = getUByte(offset.toULong())
inline fun Unsafe.getUByte(offset: UInt): UByte = getUByte(offset.toULong())
inline fun Unsafe.getUByte(offset: Long): UByte = getUByte(offset.toULong())
inline fun Unsafe.getUByte(offset: ULong): UByte = getByte(offset.toLong()).toUByte()
inline fun Unsafe.set(offset: Int, ubyte: UByte) = set(offset.toULong(), ubyte)
inline fun Unsafe.set(offset: Long, ubyte: UByte) = set(offset.toULong(), ubyte)
inline fun Unsafe.set(offset: ULong, ubyte: UByte) = putByte(null, offset.toLong(), ubyte.toByte())
inline fun Unsafe.getUShort(offset: Int): UShort = getUShort(offset.toULong())
inline fun Unsafe.getUShort(offset: UInt): UShort = getUShort(offset.toULong())
inline fun Unsafe.getUShort(offset: Long): UShort = getUShort(offset.toULong())
inline fun Unsafe.getUShort(offset: ULong): UShort = getShort(offset.toLong()).toUShort()
inline fun Unsafe.set(offset: Int, ushort: UShort) = set(offset.toULong(), ushort)
inline fun Unsafe.set(offset: Long, ushort: UShort) = set(offset.toULong(), ushort)
inline fun Unsafe.set(offset: ULong, ushort: UShort) = putShort(null, offset.toLong(), ushort.toShort())
inline fun Unsafe.getUInt(offset: Int): UInt = getUInt(offset.toULong())
inline fun Unsafe.getUInt(offset: UInt): UInt = getUInt(offset.toULong())
inline fun Unsafe.getUInt(offset: Long): UInt = getUInt(offset.toULong())
inline fun Unsafe.getUInt(offset: ULong): UInt = getInt(offset.toLong()).toUInt()
inline fun Unsafe.set(offset: Int, uint: UInt) = set(offset.toULong(), uint)
inline fun Unsafe.set(offset: Long, uint: UInt) = set(offset.toULong(), uint)
inline fun Unsafe.set(offset: ULong, uint: UInt) = putInt(null, offset.toLong(), uint.toInt())
inline fun Unsafe.getULong(offset: Int): ULong = getULong(offset.toULong())
inline fun Unsafe.getULong(offset: UInt): ULong = getULong(offset.toULong())
inline fun Unsafe.getULong(offset: Long): ULong = getULong(offset.toULong())
inline fun Unsafe.getULong(offset: ULong): ULong = getLong(offset.toLong()).toULong()
inline fun Unsafe.set(offset: Int, ulong: ULong) = set(offset.toULong(), ulong)
inline fun Unsafe.set(offset: Long, ulong: ULong) = set(offset.toULong(), ulong)
inline fun Unsafe.set(offset: ULong, ulong: ULong) = putLong(null, offset.toLong(), ulong.toLong())
inline fun Unsafe.getFloat(offset: Int): Float = getFloat(offset.toULong())
inline fun Unsafe.getFloat(offset: UInt): Float = getFloat(offset.toULong())
inline fun Unsafe.getFloat(offset: ULong): Float = getFloat(offset.toLong())
inline fun Unsafe.set(offset: Int, float: Float) = set(offset.toULong(), float)
inline fun Unsafe.set(offset: UInt, float: Float) = set(offset.toULong(), float)
inline fun Unsafe.set(offset: ULong, float: Float) = putFloat(null, offset.toLong(), float)
inline fun Unsafe.getDouble(offset: Int): Double = getDouble(offset.toULong())
inline fun Unsafe.getDouble(offset: UInt): Double = getDouble(offset.toULong())
inline fun Unsafe.getDouble(offset: ULong): Double = getDouble(offset.toLong())
inline fun Unsafe.set(offset: Int, double: Double) = set(offset.toULong(), double)
inline fun Unsafe.set(offset: UInt, double: Double) = set(offset.toULong(), double)
inline fun Unsafe.set(offset: ULong, double: Double) = putDouble(null, offset.toLong(), double)
