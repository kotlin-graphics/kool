package kool

import org.lwjgl.system.MemoryUtil
import java.nio.*


fun bufferOf(vararg bytes: Byte) = Buffer(bytes.size) { bytes[it] }
//fun bufferOf(vararg bytes: Number): ByteBuffer TODO?

fun bufferOf(vararg shorts: Short) = Buffer(shorts.size * 2).apply { for (i in shorts.indices) putShort(i * 2, shorts[i]) }
fun bufferOf(vararg ints: Int) = Buffer(ints.size * 4).apply { for (i in ints.indices) putInt(i * 4, ints[i]) }
fun bufferOf(vararg longs: Long) = Buffer(longs.size * 8).apply { for (i in longs.indices) putLong(i * 8, longs[i]) }
fun bufferOf(vararg floats: Float) = Buffer(floats.size * 4).apply { for (i in floats.indices) putFloat(i * 4, floats[i]) }
fun bufferOf(vararg doubles: Double) = Buffer(doubles.size * 8).apply { for (i in doubles.indices) putDouble(i * 8, doubles[i]) }


fun byteBufferOf(vararg bytes: Byte) = ByteBuffer(bytes.size) { bytes[it] }
//fun bufferOf(vararg bytes: Number): ByteBuffer TODO?

fun byteBufferOf(vararg shorts: Short) = ByteBuffer(shorts.size * 2).apply { for (i in shorts.indices) putShort(i * 2, shorts[i]) }
fun byteBufferOf(vararg ints: Int) = ByteBuffer(ints.size * 4).apply { for (i in ints.indices) putInt(i * 4, ints[i]) }
fun byteBufferOf(vararg longs: Long) = ByteBuffer(longs.size * 8).apply { for (i in longs.indices) putLong(i * 8, longs[i]) }
fun byteBufferOf(vararg floats: Float) = ByteBuffer(floats.size * 4).apply { for (i in floats.indices) putFloat(i * 4, floats[i]) }
fun byteBufferOf(vararg doubles: Double) = ByteBuffer(doubles.size * 8).apply { for (i in doubles.indices) putDouble(i * 8, doubles[i]) }


fun shortBufferOf(vararg shorts: Short) = ShortBuffer(shorts.size) { shorts[it] }
//fun shortBufferOf(vararg numbers: Number): ShortBuffer TODO?

fun intBufferOf(vararg ints: Int) = IntBuffer(ints.size) { ints[it] }
fun intBufferOf(range: IntRange) = IntBuffer(range.count()) { range.elementAt(it) }
//fun intBufferOf(vararg numbers: Number): IntBuffer TODO?

fun longBufferOf(vararg longs: Long) = LongBuffer(longs.size) { longs[it] }
fun longBufferOf(range: LongRange) = LongBuffer(range.count()) { range.elementAt(it) }
//fun longBufferOf(vararg numbers: Number): LongBuffer TODO?

fun floatBufferOf(vararg floats: Float) = FloatBuffer(floats.size) { floats[it] }
//fun floatBufferOf(vararg numbers: Number): FloatBuffer TODO?

fun doubleBufferOf(vararg doubles: Double) = DoubleBuffer(doubles.size) { doubles[it] }
//fun doubleBufferOf(vararg numbers: Number): DoubleBuffer TODO?

fun charBufferOf(vararg chars: Char) = CharBuffer(chars.size) { chars[it] }
fun charBufferOf(range: CharRange) = CharBuffer(range.count()) { range.elementAt(it) }
//fun doubleBufferOf(vararg numbers: Number): DoubleBuffer TODO?