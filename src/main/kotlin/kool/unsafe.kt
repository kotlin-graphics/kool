@file:Suppress("NOTHING_TO_INLINE")
package kool

//import sun.misc.Unsafe

/*
Different runtimes use different names for the Unsafe singleton,
so we cannot use .getDeclaredField and we scan instead. For example:

Oracle: theUnsafe
PERC : m_unsafe_instance
Android: THE_ONE
*/
//val unsafe: Unsafe by lazy {
//    Unsafe::class.java.declaredFields
//            .find {
//                it.type == Unsafe::class.java &&
//                        java.lang.reflect.Modifier.isStatic(it.modifiers)
//                        && java.lang.reflect.Modifier.isFinal(it.modifiers)
//            }?.run {
//                isAccessible = true
//                get(null) as Unsafe
//            } ?: throw UnsupportedOperationException("LWJGL requires sun.misc.Unsafe to be available.")
//}
//
//inline fun Unsafe.getByte(index: Int): Byte = getByte(null, index.toULong().toLong())
//inline fun Unsafe.getUByte(index: Int): UByte = getByte(index).toUByte()
//inline fun Unsafe.getShort(index: Int): Short = getShort(null, index.toULong().toLong())
//inline fun Unsafe.getUShort(index: Int): UShort = getShort(index).toUShort()
//inline fun Unsafe.getInt(index: Int): Int = getInt(null, index.toULong().toLong())
//inline fun Unsafe.getUInt(index: Int): UInt = getInt(index).toUInt()
//inline fun Unsafe.getLong(index: Int): Long = getLong(null, index.toULong().toLong())
//inline fun Unsafe.getULong(index: Int): ULong = getLong(index).toULong()
//inline fun Unsafe.getFloat(index: Int): Float = getFloat(null, index.toULong().toLong())
//inline fun Unsafe.getDouble(index: Int): Double = getDouble(null, index.toULong().toLong())
//
//inline fun Unsafe.getByte(index: Int): Byte = getByte(null, index.toULong().toLong())
//inline fun Unsafe.getUByte(index: Int): UByte = getByte(index).toUByte()
//inline fun Unsafe.getShort(index: Int): Short = getShort(null, index.toULong().toLong())
//inline fun Unsafe.getUShort(index: Int): UShort = getShort(index).toUShort()
//inline fun Unsafe.getInt(index: Int): Int = getInt(null, index.toULong().toLong())
//inline fun Unsafe.getUInt(index: Int): UInt = getInt(index).toUInt()
//inline fun Unsafe.getLong(index: Int): Long = getLong(null, index.toULong().toLong())
//inline fun Unsafe.getULong(index: Int): ULong = getLong(index).toULong()
//inline fun Unsafe.getFloat(index: Int): Float = getFloat(null, index.toULong().toLong())
//inline fun Unsafe.getDouble(index: Int): Double = getDouble(null, index.toULong().toLong())