package kool

import org.lwjgl.PointerBuffer
import org.lwjgl.system.Pointer
import java.nio.*

operator fun IntBuffer.get(e: Enum<*>) = get(e.ordinal)
operator fun IntBuffer.set(e: Enum<*>, value: Int): IntBuffer = put(e.ordinal, value)
operator fun IntArray.get(e: Enum<*>) = get(e.ordinal)
operator fun IntArray.set(e: Enum<*>, int: Int) = set(e.ordinal, int)
inline fun <reified T : Enum<T>> IntArray() = IntArray(enumValues<T>().size)

/** for opengl  */
inline fun <reified E : Enum<E>> IntBuffer() = IntBuffer(enumValues<E>().size)

/** glGenTextures(textureName[Tex.Color]) */
operator fun <E : Enum<E>, T> Array<T>.get(enum: Enum<E>): T = get(enum.ordinal)

operator fun ByteBuffer.set(index: Int, byte: Byte): ByteBuffer = put(index, byte)
operator fun ByteBuffer.set(index: Int, int: Int): ByteBuffer = put(index, int.toByte())
operator fun ByteBuffer.set(index: Int, short: Short): ByteBuffer = put(index, short.toByte())
operator fun ByteBuffer.set(index: Int, long: Long): ByteBuffer = put(index, long.toByte())
operator fun ByteBuffer.set(index: Int, float: Float): ByteBuffer = put(index, float.toByte())
operator fun ByteBuffer.set(index: Int, long: Double): ByteBuffer = put(index, long.toByte())

operator fun ShortBuffer.set(index: Int, byte: Byte): ShortBuffer = put(index, byte.toShort())
operator fun ShortBuffer.set(index: Int, short: Short): ShortBuffer = put(index, short)
operator fun ShortBuffer.set(index: Int, int: Int): ShortBuffer = put(index, int.toShort())
operator fun ShortBuffer.set(index: Int, long: Long): ShortBuffer = put(index, long.toShort())

operator fun IntBuffer.set(index: Int, byte: Byte): IntBuffer = put(index, byte.toInt())
operator fun IntBuffer.set(index: Int, short: Short): IntBuffer = put(index, short.toInt())
operator fun IntBuffer.set(index: Int, int: Int): IntBuffer = put(index, int)
operator fun IntBuffer.set(index: Int, long: Long): IntBuffer = put(index, long.toInt())

operator fun LongBuffer.set(index: Int, byte: Byte): LongBuffer = put(index, byte.toLong())
operator fun LongBuffer.set(index: Int, short: Short): LongBuffer = put(index, short.toLong())
operator fun LongBuffer.set(index: Int, int: Int): LongBuffer = put(index, int.toLong())
operator fun LongBuffer.set(index: Int, long: Long): LongBuffer = put(index, long)

operator fun FloatBuffer.set(index: Int, float: Float): FloatBuffer = put(index, float)
operator fun FloatBuffer.set(index: Int, double: Double): FloatBuffer = put(index, double.toFloat())
operator fun DoubleBuffer.set(index: Int, float: Float): DoubleBuffer = put(index, float.toDouble())
operator fun DoubleBuffer.set(index: Int, double: Double): DoubleBuffer = put(index, double)

operator fun CharBuffer.set(index: Int, char: Char): CharBuffer = put(index, char)
operator fun CharBuffer.set(index: Int, int: Int): CharBuffer = put(index, int.toChar())

operator fun PointerBuffer.set(index: Int, long: Long): PointerBuffer = put(index, long)
operator fun PointerBuffer.set(index: Int, pointer: Pointer): PointerBuffer = put(index, pointer)
operator fun PointerBuffer.set(index: Int, buffer: Buffer): PointerBuffer = put(index, buffer.adr)


operator fun ByteBuffer.invoke(index: Int, byte: Byte): ByteBuffer = put(index, byte)
operator fun ByteBuffer.invoke(index: Int, short: Short): ByteBuffer = putShort(index, short)
operator fun ByteBuffer.invoke(index: Int, int: Int): ByteBuffer = putInt(index, int)
operator fun ByteBuffer.invoke(index: Int, long: Long): ByteBuffer = putLong(index, long)
operator fun ByteBuffer.invoke(index: Int, float: Float): ByteBuffer = putFloat(index, float)
operator fun ByteBuffer.invoke(index: Int, double: Double): ByteBuffer = putDouble(index, double)

//operator fun ShortBuffer.invoke(index: Int, short: Short): ShortBuffer = put(index, short)
//operator fun ShortBuffer.invoke(index: Int, int: Int): ShortBuffer = put(index, int)
//
//operator fun IntBuffer.invoke(index: Int, int: Int): IntBuffer = put(index, int)
//
//operator fun LongBuffer.invoke(index: Int, long: Long): LongBuffer = put(index, long)
//operator fun LongBuffer.invoke(index: Int, int: Int): LongBuffer = put(index, int.L)
//
//operator fun FloatBuffer.invoke(index: Int, float: Float): FloatBuffer = put(index, float)
//operator fun DoubleBuffer.invoke(index: Int, double: Double): DoubleBuffer = put(index, double)
//
//operator fun CharBuffer.invoke(index: Int, char: Char): CharBuffer = put(index, char)
//operator fun CharBuffer.invoke(index: Int, int: Int): CharBuffer = put(index, int.c)