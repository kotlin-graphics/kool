@file:Suppress("NOTHING_TO_INLINE")
package kool

import org.lwjgl.PointerBuffer
import org.lwjgl.system.Configuration
import org.lwjgl.system.MemoryStack
import org.lwjgl.system.MemoryUtil
import org.lwjgl.system.Pointer
import java.nio.*


inline fun MemoryStack.mByte(count: Int = 1) = BytePtr(nmalloc(Byte.BYTES, Byte.BYTES * count))
inline fun MemoryStack.mShort(count: Int = 1) = ShortPtr(nmalloc(Short.BYTES, Short.BYTES * count))
inline fun MemoryStack.mInt(count: Int = 1) = IntPtr(nmalloc(Int.BYTES, Int.BYTES * count))
inline fun MemoryStack.mLong(count: Int = 1) = LongPtr(nmalloc(Long.BYTES, Long.BYTES * count))
inline fun MemoryStack.mFloat(count: Int = 1) = FloatPtr(nmalloc(Float.BYTES, Float.BYTES * count))
inline fun MemoryStack.mDouble(count: Int = 1) = DoublePtr(nmalloc(Double.BYTES, Double.BYTES * count))
inline fun MemoryStack.mPointer(count: Int = 1) = PointerPtr(nmalloc(Long.BYTES, Long.BYTES * count))

inline fun MemoryStack.cByte(count: Int = 1) = BytePtr(ncalloc(Byte.BYTES, count, Byte.BYTES))
inline fun MemoryStack.cShort(count: Int = 1) = ShortPtr(ncalloc(Short.BYTES, count, Short.BYTES))
inline fun MemoryStack.cInt(count: Int = 1) = IntPtr(ncalloc(Int.BYTES, count, Int.BYTES))
inline fun MemoryStack.cLong(count: Int = 1) = LongPtr(ncalloc(Long.BYTES, count, Long.BYTES))
inline fun MemoryStack.cFloat(count: Int = 1) = FloatPtr(ncalloc(Float.BYTES, count, Float.BYTES))
inline fun MemoryStack.cDouble(count: Int = 1) = DoublePtr(ncalloc(Double.BYTES, count, Double.BYTES))
inline fun MemoryStack.cPointer(count: Int = 1) = PointerPtr(ncalloc(Long.BYTES, count, Long.BYTES))

fun MemoryStack.reset() {
    pointer = Configuration.STACK_SIZE.get(64) * 1024
}

fun MemoryStack.ptrOf(b: Byte): BytePtr = mByte(1).also { it[0] = b }
fun MemoryStack.ptrOf(b0: Byte, b1: Byte): BytePtr = mByte(2).also { it[0] = b0; it[1] = b1 }
fun MemoryStack.ptrOf(b0: Byte, b1: Byte, b2: Byte): BytePtr = mByte(3).also { it[0] = b0; it[1] = b1; it[2] = b2 }
fun MemoryStack.ptrOf(b0: Byte, b1: Byte, b2: Byte, b3: Byte): BytePtr = mByte(4).also { it[0] = b0; it[1] = b1; it[2] = b2; it[3] = b3 }
fun MemoryStack.ptrOf(vararg bytes: Byte): BytePtr = mByte(bytes.size).also { for (i in bytes.indices) it[i] = bytes[i] }

fun MemoryStack.ptrOf(s: Short): ShortPtr = mShort(1).also { it[0] = s }
fun MemoryStack.ptrOf(s0: Short, s1: Short): ShortPtr = mShort(2).also { it[0] = s0; it[1] = s1 }
fun MemoryStack.ptrOf(s0: Short, s1: Short, s2: Short): ShortPtr = mShort(3).also { it[0] = s0; it[1] = s1; it[2] = s2 }
fun MemoryStack.ptrOf(s0: Short, s1: Short, s2: Short, s3: Short): ShortPtr = mShort(4).also { it[0] = s0; it[1] = s1; it[2] = s2; it[3] = s3 }
fun MemoryStack.ptrOf(vararg shorts: Short): ShortPtr = mShort(shorts.size).also { for (i in shorts.indices) it[i] = shorts[i] }

fun MemoryStack.ptrOf(i: Int): IntPtr = mInt(1).also { it[0] = i }
fun MemoryStack.ptrOf(i0: Int, i1: Int): IntPtr = mInt(2).also { it[0] = i0; it[1] = i1 }
fun MemoryStack.ptrOf(i0: Int, i1: Int, i2: Int): IntPtr = mInt(3).also { it[0] = i0; it[1] = i1; it[2] = i2 }
fun MemoryStack.ptrOf(i0: Int, i1: Int, i2: Int, i3: Int): IntPtr = mInt(4).also { it[0] = i0; it[1] = i1; it[2] = i2; it[3] = i3 }
fun MemoryStack.ptrOf(vararg ints: Int): IntPtr = mInt(ints.size).also { for (i in ints.indices) it[i] = ints[i] }

fun MemoryStack.ptrOf(L: Long): LongPtr = mLong(1).also { it[0] = L }
fun MemoryStack.ptrOf(L0: Long, L1: Long): LongPtr = mLong(2).also { it[0] = L0; it[1] = L1 }
fun MemoryStack.ptrOf(L0: Long, L1: Long, L2: Long): LongPtr = mLong(3).also { it[0] = L0; it[1] = L1; it[2] = L2 }
fun MemoryStack.ptrOf(L0: Long, L1: Long, L2: Long, L3: Long): LongPtr = mLong(4).also { it[0] = L0; it[1] = L1; it[2] = L2; it[3] = L3 }
fun MemoryStack.ptrOf(vararg longs: Long): LongPtr = mLong(longs.size).also { for (i in longs.indices) it[i] = longs[i] }

fun MemoryStack.ptrOf(f: Float): FloatPtr = mFloat(1).also { it[0] = f }
fun MemoryStack.ptrOf(f0: Float, f1: Float): FloatPtr = mFloat(2).also { it[0] = f0; it[1] = f1 }
fun MemoryStack.ptrOf(f0: Float, f1: Float, f2: Float): FloatPtr = mFloat(3).also { it[0] = f0; it[1] = f1; it[2] = f2 }
fun MemoryStack.ptrOf(f0: Float, f1: Float, f2: Float, f3: Float): FloatPtr = mFloat(4).also { it[0] = f0; it[1] = f1; it[2] = f2; it[3] = f3 }
fun MemoryStack.ptrOf(vararg floats: Float): FloatPtr = mFloat(floats.size).also { for (i in floats.indices) it[i] = floats[i] }

fun MemoryStack.ptrOf(d: Double): DoublePtr = mDouble(1).also { it[0] = d }
fun MemoryStack.ptrOf(d0: Double, d1: Double): DoublePtr = mDouble(2).also { it[0] = d0; it[1] = d1 }
fun MemoryStack.ptrOf(d0: Double, d1: Double, d2: Double): DoublePtr = mDouble(3).also { it[0] = d0; it[1] = d1; it[2] = d2 }
fun MemoryStack.ptrOf(d0: Double, d1: Double, d2: Double, d3: Double): DoublePtr = mDouble(4).also { it[0] = d0; it[1] = d1; it[2] = d2; it[3] = d3 }
fun MemoryStack.ptrOf(vararg doubles: Double): DoublePtr = mDouble(doubles.size).also { for (i in doubles.indices) it[i] = doubles[i] }

fun MemoryStack.ptrOf(p: Pointer): PointerPtr = mPointer(1).also { it[0] = p }
//fun MemoryStack.ptrOf(d0: Double, d1: Double): DoublePtr = mDouble(2).also { it[0] = d0; it[1] = d1 }
//fun MemoryStack.ptrOf(d0: Double, d1: Double, d2: Double): DoublePtr = mDouble(3).also { it[0] = d0; it[1] = d1; it[2] = d2 }
//fun MemoryStack.ptrOf(d0: Double, d1: Double, d2: Double, d3: Double): DoublePtr = mDouble(4).also { it[0] = d0; it[1] = d1; it[2] = d2; it[3] = d3 }
//fun MemoryStack.ptrOf(vararg doubles: Double): DoublePtr = mDouble(doubles.size).also { for(i in doubles.indices) it[i] = doubles[i] }


// --------------------------------------------- getters ---------------------------------------------

inline fun <R> MemoryStack.byteAdr(block: (Adr) -> R): Byte {
    val pByte = mByte()
    block(pByte.adr)
    return pByte()
}

inline fun <R> MemoryStack.byteBuffer(block: (ByteBuffer) -> R): Byte {
    val buf = malloc(1)
    block(buf)
    return buf[0]
}

inline fun <R> MemoryStack.shortAdr(block: (Adr) -> R): Short {
    val pShort = mShort()
    block(pShort.adr)
    return pShort()
}

inline fun <R> MemoryStack.shortBuffer(block: (ShortBuffer) -> R): Short {
    val buf = mallocShort(1)
    block(buf)
    return buf[0]
}

inline fun <R> MemoryStack.intAdr(block: (Adr) -> R): Int {
    val pInt = mInt()
    block(pInt.adr)
    return pInt()
}

inline fun <R> MemoryStack.intBuffer(block: (IntBuffer) -> R): Int {
    val buf = mallocInt(1)
    block(buf)
    return buf[0]
}

inline fun <R> MemoryStack.longAdr(block: (Adr) -> R): Long {
    val pLong = mLong()
    block(pLong.adr)
    return pLong()
}

inline fun <R> MemoryStack.longBuffer(block: (LongBuffer) -> R): Long {
    val buf = mallocLong(1)
    block(buf)
    return buf[0]
}

inline fun <R> MemoryStack.floatAdr(block: (Adr) -> R): Float {
    val pFloat = mFloat()
    block(pFloat.adr)
    return pFloat()
}

inline fun <R> MemoryStack.floatBuffer(block: (FloatBuffer) -> R): Float {
    val buf = mallocFloat(1)
    block(buf)
    return buf[0]
}

inline fun <R> MemoryStack.doubleAdr(block: (Adr) -> R): Double {
    val pDouble = mDouble()
    block(pDouble.adr)
    return pDouble()
}

inline fun <R> MemoryStack.doubleBuffer(block: (DoubleBuffer) -> R): Double {
    val buf = mallocDouble(1)
    block(buf)
    return buf[0]
}

inline fun <R> MemoryStack.pointerAdr(block: (Adr) -> R): Ptr {
    val pointer = mPointer()
    block(pointer.adr)
    return pointer()
}

inline fun <R> MemoryStack.pointerBuffer(block: (PointerBuffer) -> R): Ptr {
    val buf = mallocPointer(1)
    block(buf)
    return buf[0]
}

/** It mallocs, passes the address and reads the null terminated string */
inline fun <R> MemoryStack.asciiAdr(maxSize: Int, block: (Adr) -> R): String {
    val adr = nmalloc(1, maxSize)
    block(adr)
    return MemoryUtil.memASCII(adr, strlen64NT1(adr, maxSize))
}

/** It malloc the buffer, passes it and reads the null terminated string */
inline fun <R> MemoryStack.asciiBuffer(maxSize: Int, block: (ByteBuffer) -> R): String {
    val buf = malloc(1, maxSize)
    block(buf)
    return MemoryUtil.memASCII(buf.adr, maxSize)
}

// --------------------------------------------- setters ---------------------------------------------
// mainly for syntax consistence
inline fun MemoryStack.asciiAdr(chars: CharSequence, nullTerminated: Boolean = true): Adr = nASCII(chars, nullTerminated).let { pointerAddress }
inline fun MemoryStack.asciiBuffer(chars: CharSequence, nullTerminated: Boolean = true): ByteBuffer = ASCII(chars, nullTerminated)

//@JvmName("asciiAdrSafe")
//inline fun MemoryStack.asciiAdr(chars: CharSequence?, nullTerminated: Boolean = true): Adr = chars?.let { asciiAdr(it, nullTerminated) } ?: NULL

inline fun MemoryStack.byteAdr(byte: Byte)= ptrOf(byte).adr
inline fun MemoryStack.byteBuffer(byte: Byte)= bytes(byte)

inline fun MemoryStack.shortAdr(short: Short)= ptrOf(short).adr
inline fun MemoryStack.shortBuffer(short: Short)= shorts(short)

inline fun MemoryStack.intAdr(int: Int)= ptrOf(int).adr
inline fun MemoryStack.intBuffer(int: Int)= ints(int)

inline fun MemoryStack.longAdr(long: Long)= ptrOf(long).adr
inline fun MemoryStack.longBuffer(long: Long)= longs(long)

inline fun MemoryStack.floatAdr(float: Float)= ptrOf(float).adr
inline fun MemoryStack.floatBuffer(float: Float)= floats(float)

inline fun MemoryStack.doubleAdr(double: Double)= ptrOf(double).adr
inline fun MemoryStack.doubleBuffer(double: Double)= doubles(double)

inline fun MemoryStack.pointerAdr(pointer: Pointer)= ptrOf(pointer).adr
inline fun MemoryStack.pointerBuffer(pointer: Pointer)= pointers(pointer)

inline fun MemoryStack.utf8Adr(chars: CharSequence, nullTerminated: Boolean = true): Adr = nmalloc(1, MemoryUtil.memLengthASCII(chars, nullTerminated)).also { encodeUTF8(chars, nullTerminated, it) }
inline fun MemoryStack.utf8Buffer(chars: CharSequence, nullTerminated: Boolean = true): ByteBuffer = UTF8(chars, true)

//@JvmName("utf8AdrSafe")
//inline fun MemoryStack.utf8Adr(chars: CharSequence?, nullTerminated: Boolean = true): Adr = chars?.let { utf8Adr(it, nullTerminated) } ?: NULL
