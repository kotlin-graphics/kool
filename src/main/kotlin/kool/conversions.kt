package kool

import org.lwjgl.system.MemoryStack
import org.lwjgl.system.MemoryUtil
import org.lwjgl.system.MemoryUtil.*
import java.nio.*


fun ByteArray.toBuffer(): ByteBuffer = Buffer(size) { get(it) }
fun ByteArray.toByteBuffer() = ByteBuffer(size) { get(it) }
//fun ByteArray.toShortBuffer(): ShortBuffer { TODO?

fun ShortArray.toBuffer(): ByteBuffer = Buffer(size * 2).also { for (i in 0 until size) it.putShort(i * 2, get(i)) }
fun ShortArray.toByteBuffer() = ByteBuffer(size * 2).also { for (i in 0 until size) it.putShort(i * 2, get(i)) }
fun ShortArray.toShortBuffer() = ShortBuffer(size) { get(it) }

fun IntArray.toBuffer(): ByteBuffer = Buffer(size * 4).also { for (i in 0 until size) it.putInt(i * 4, get(i)) }
fun IntArray.toByteBuffer() = ByteBuffer(size * 4).also { for (i in 0 until size) it.putInt(i * 4, get(i)) }
fun IntArray.toIntBuffer() = IntBuffer(size) { get(it) }

fun LongArray.toBuffer(): ByteBuffer = Buffer(size * 8).also { for (i in 0 until size) it.putLong(i * 8, get(i)) }
fun LongArray.toByteBuffer() = ByteBuffer(size * 8).also { for (i in 0 until size) it.putLong(i * 8, get(i)) }
fun LongArray.toLongBuffer() = LongBuffer(size) { get(it) }

fun FloatArray.toBuffer(): ByteBuffer = Buffer(size * 4).also { for (i in 0 until size) it.putFloat(i * 4, get(i)) }
fun FloatArray.toByteBuffer() = ByteBuffer(size * 4).also { for (i in 0 until size) it.putFloat(i * 4, get(i)) }
fun FloatArray.toFloatBuffer() = FloatBuffer(size) { get(it) }

fun DoubleArray.toBuffer(): ByteBuffer = Buffer(size * 8).also { for (i in 0 until size) it.putDouble(i * 8, get(i)) }
fun DoubleArray.toByteBuffer() = ByteBuffer(size * 8).also { for (i in 0 until size) it.putDouble(i * 8, get(i)) }
fun DoubleArray.toDoubleBuffer() = DoubleBuffer(size) { get(it) }


fun ByteArray.toBuffer(stack: MemoryStack): ByteBuffer = stack.Buffer(size) { get(it) }
fun ByteArray.toByteBuffer(stack: MemoryStack) = stack.ByteBuffer(size) { get(it) }
//fun ByteArray.toShortBuffer(stack: MemoryStack): ShortBuffer { TODO?

fun ShortArray.toBuffer(stack: MemoryStack): ByteBuffer = stack.Buffer(size * 2).also { for (i in 0 until size) it.putShort(i * 2, get(i)) }
fun ShortArray.toByteBuffer(stack: MemoryStack) = stack.ByteBuffer(size * 2).also { for (i in 0 until size) it.putShort(i * 2, get(i)) }
fun ShortArray.toShortBuffer(stack: MemoryStack) = stack.ShortBuffer(size) { get(it) }

fun IntArray.toBuffer(stack: MemoryStack): ByteBuffer = stack.Buffer(size * 4).also { for (i in 0 until size) it.putInt(i * 4, get(i)) }
fun IntArray.toByteBuffer(stack: MemoryStack) = stack.ByteBuffer(size * 4).also { for (i in 0 until size) it.putInt(i * 4, get(i)) }
fun IntArray.toIntBuffer(stack: MemoryStack) = stack.IntBuffer(size) { get(it) }

fun LongArray.toBuffer(stack: MemoryStack): ByteBuffer = stack.Buffer(size * 8).also { for (i in 0 until size) it.putLong(i * 8, get(i)) }
fun LongArray.toByteBuffer(stack: MemoryStack) = stack.ByteBuffer(size * 8).also { for (i in 0 until size) it.putLong(i * 8, get(i)) }
fun LongArray.toLongBuffer(stack: MemoryStack) = stack.LongBuffer(size) { get(it) }

fun FloatArray.toBuffer(stack: MemoryStack): ByteBuffer = stack.Buffer(size * 4).also { for (i in 0 until size) it.putFloat(i * 4, get(i)) }
fun FloatArray.toByteBuffer(stack: MemoryStack) = stack.ByteBuffer(size * 4).also { for (i in 0 until size) it.putFloat(i * 4, get(i)) }
fun FloatArray.toFloatBuffer(stack: MemoryStack) = stack.FloatBuffer(size) { get(it) }

fun DoubleArray.toBuffer(stack: MemoryStack): ByteBuffer = stack.Buffer(size * 8).also { for (i in 0 until size) it.putDouble(i * 8, get(i)) }
fun DoubleArray.toByteBuffer(stack: MemoryStack) = stack.ByteBuffer(size * 8).also { for (i in 0 until size) it.putDouble(i * 8, get(i)) }
fun DoubleArray.toDoubleBuffer(stack: MemoryStack) = stack.DoubleBuffer(size) { get(it) }

// Address version

fun ByteArray.toAdr() = BytePtr(nmemCalloc(size.toLong(), Byte.SIZE_BYTES.toLong()).also { for(i in indices) memPutByte(it + i * Byte.SIZE_BYTES, get(i)) })
fun ByteArray.toByteAdr() = BytePtr(nmemCalloc(size.toLong(), Byte.SIZE_BYTES.toLong()).also { for(i in indices) memPutByte(it + i * Byte.SIZE_BYTES, get(i)) })

fun ShortArray.toAdr() = BytePtr(nmemCalloc(size.toLong(), Short.SIZE_BYTES.toLong()).also { for(i in indices) memPutShort(it + i * Short.SIZE_BYTES, get(i)) })
fun ShortArray.toByteAdr() = BytePtr(nmemCalloc(size.toLong(), Byte.SIZE_BYTES.toLong()).also { for(i in indices) memPutByte(it + i * Byte.SIZE_BYTES, get(i)) })
fun ShortArray.toShortAdr() = ShortBuffer(size) { get(it) }

fun IntArray.toBuffer(): ByteBuffer = Buffer(size * 4).also { for (i in 0 until size) it.putInt(i * 4, get(i)) }
fun IntArray.toByteBuffer() = ByteBuffer(size * 4).also { for (i in 0 until size) it.putInt(i * 4, get(i)) }
fun IntArray.toIntBuffer() = IntBuffer(size) { get(it) }

fun LongArray.toBuffer(): ByteBuffer = Buffer(size * 8).also { for (i in 0 until size) it.putLong(i * 8, get(i)) }
fun LongArray.toByteBuffer() = ByteBuffer(size * 8).also { for (i in 0 until size) it.putLong(i * 8, get(i)) }
fun LongArray.toLongBuffer() = LongBuffer(size) { get(it) }

fun FloatArray.toBuffer(): ByteBuffer = Buffer(size * 4).also { for (i in 0 until size) it.putFloat(i * 4, get(i)) }
fun FloatArray.toByteBuffer() = ByteBuffer(size * 4).also { for (i in 0 until size) it.putFloat(i * 4, get(i)) }
fun FloatArray.toFloatBuffer() = FloatBuffer(size) { get(it) }

fun DoubleArray.toBuffer(): ByteBuffer = Buffer(size * 8).also { for (i in 0 until size) it.putDouble(i * 8, get(i)) }
fun DoubleArray.toByteBuffer() = ByteBuffer(size * 8).also { for (i in 0 until size) it.putDouble(i * 8, get(i)) }
fun DoubleArray.toDoubleBuffer() = DoubleBuffer(size) { get(it) }


fun ByteArray.toBuffer(stack: MemoryStack): ByteBuffer = stack.Buffer(size) { get(it) }
fun ByteArray.toByteBuffer(stack: MemoryStack) = stack.ByteBuffer(size) { get(it) }
//fun ByteArray.toShortBuffer(stack: MemoryStack): ShortBuffer { TODO?

fun ShortArray.toBuffer(stack: MemoryStack): ByteBuffer = stack.Buffer(size * 2).also { for (i in 0 until size) it.putShort(i * 2, get(i)) }
fun ShortArray.toByteBuffer(stack: MemoryStack) = stack.ByteBuffer(size * 2).also { for (i in 0 until size) it.putShort(i * 2, get(i)) }
fun ShortArray.toShortBuffer(stack: MemoryStack) = stack.ShortBuffer(size) { get(it) }

fun IntArray.toBuffer(stack: MemoryStack): ByteBuffer = stack.Buffer(size * 4).also { for (i in 0 until size) it.putInt(i * 4, get(i)) }
fun IntArray.toByteBuffer(stack: MemoryStack) = stack.ByteBuffer(size * 4).also { for (i in 0 until size) it.putInt(i * 4, get(i)) }
fun IntArray.toIntBuffer(stack: MemoryStack) = stack.IntBuffer(size) { get(it) }

fun LongArray.toBuffer(stack: MemoryStack): ByteBuffer = stack.Buffer(size * 8).also { for (i in 0 until size) it.putLong(i * 8, get(i)) }
fun LongArray.toByteBuffer(stack: MemoryStack) = stack.ByteBuffer(size * 8).also { for (i in 0 until size) it.putLong(i * 8, get(i)) }
fun LongArray.toLongBuffer(stack: MemoryStack) = stack.LongBuffer(size) { get(it) }

fun FloatArray.toBuffer(stack: MemoryStack): ByteBuffer = stack.Buffer(size * 4).also { for (i in 0 until size) it.putFloat(i * 4, get(i)) }
fun FloatArray.toByteBuffer(stack: MemoryStack) = stack.ByteBuffer(size * 4).also { for (i in 0 until size) it.putFloat(i * 4, get(i)) }
fun FloatArray.toFloatBuffer(stack: MemoryStack) = stack.FloatBuffer(size) { get(it) }

fun DoubleArray.toBuffer(stack: MemoryStack): ByteBuffer = stack.Buffer(size * 8).also { for (i in 0 until size) it.putDouble(i * 8, get(i)) }
fun DoubleArray.toByteBuffer(stack: MemoryStack) = stack.ByteBuffer(size * 8).also { for (i in 0 until size) it.putDouble(i * 8, get(i)) }
fun DoubleArray.toDoubleBuffer(stack: MemoryStack) = stack.DoubleBuffer(size) { get(it) }



// TODO expand? others?
fun IntBuffer.toList() = List(rem) { get(it) }