@file:Suppress("NOTHING_TO_INLINE")
package kool

import org.lwjgl.system.MemoryStack
import java.nio.*


//inline fun ByteArray.toBuffer(): ByteBuffer = Buffer(size) { get(it) }
//inline fun ByteArray.toByteBuffer(): ByteBuffer = toBuffer()
////inline fun ByteArray.toShortBuffer(): ShortBuffer { TODO?
//
//inline fun ShortArray.toBuffer(): ByteBuffer = Buffer(size * 2).also { for (i in indices) it.putShort(i * 2, get(i)) }
//inline fun ShortArray.toByteBuffer(): ByteBuffer = toBuffer()
//inline fun ShortArray.toShortBuffer(): ShortBuffer = ShortBuffer(size) { get(it) }
//
//inline fun IntArray.toBuffer(): ByteBuffer = Buffer(size * 4).also { for (i in indices) it.putInt(i * 4, get(i)) }
//inline fun IntArray.toByteBuffer(): ByteBuffer = toBuffer()
//inline fun IntArray.toIntBuffer(): IntBuffer = IntBuffer(size) { get(it) }
//
//inline fun LongArray.toBuffer(): ByteBuffer = Buffer(size * 8).also { for (i in indices) it.putLong(i * 8, get(i)) }
//inline fun LongArray.toByteBuffer(): ByteBuffer = toBuffer()
//inline fun LongArray.toLongBuffer(): LongBuffer = LongBuffer(size) { get(it) }
//
//inline fun FloatArray.toBuffer(): ByteBuffer = Buffer(size * 4).also { for (i in indices) it.putFloat(i * 4, get(i)) }
//inline fun FloatArray.toByteBuffer(): ByteBuffer = toBuffer()
//inline fun FloatArray.toFloatBuffer(): FloatBuffer = FloatBuffer(size) { get(it) }
//
//inline fun DoubleArray.toBuffer(): ByteBuffer = Buffer(size * 8).also { for (i in indices) it.putDouble(i * 8, get(i)) }
//inline fun DoubleArray.toByteBuffer(): ByteBuffer = toBuffer()
//inline fun DoubleArray.toDoubleBuffer(): DoubleBuffer = DoubleBuffer(size) { get(it) }


//inline fun ByteArray.toBuffer(stack: MemoryStack): ByteBuffer = stack.Buffer(size) { get(it) }
//inline fun ByteArray.toByteBuffer(stack: MemoryStack): ByteBuffer = toBuffer(stack)
////inline fun ByteArray.toShortBuffer(stack: MemoryStack): ShortBuffer { TODO?
//
//inline fun ShortArray.toBuffer(stack: MemoryStack): ByteBuffer = stack.Buffer(size * 2).also { for (i in indices) it.putShort(i * 2, get(i)) }
//inline fun ShortArray.toByteBuffer(stack: MemoryStack): ByteBuffer = toBuffer(stack)
//inline fun ShortArray.toShortBuffer(stack: MemoryStack): ShortBuffer = stack.ShortBuffer(size) { get(it) }
//
//inline fun IntArray.toBuffer(stack: MemoryStack): ByteBuffer = stack.Buffer(size * 4).also { for (i in indices) it.putInt(i * 4, get(i)) }
//inline fun IntArray.toByteBuffer(stack: MemoryStack): ByteBuffer = toBuffer(stack)
//inline fun IntArray.toIntBuffer(stack: MemoryStack): IntBuffer = stack.IntBuffer(size) { get(it) }
//
//inline fun LongArray.toBuffer(stack: MemoryStack): ByteBuffer = stack.Buffer(size * 8).also { for (i in indices) it.putLong(i * 8, get(i)) }
//inline fun LongArray.toByteBuffer(stack: MemoryStack): ByteBuffer = toBuffer(stack)
//inline fun LongArray.toLongBuffer(stack: MemoryStack): LongBuffer = stack.LongBuffer(size) { get(it) }
//
//inline fun FloatArray.toBuffer(stack: MemoryStack): ByteBuffer = stack.Buffer(size * 4).also { for (i in indices) it.putFloat(i * 4, get(i)) }
//inline fun FloatArray.toByteBuffer(stack: MemoryStack): ByteBuffer = toBuffer(stack)
//inline fun FloatArray.toFloatBuffer(stack: MemoryStack): FloatBuffer = stack.FloatBuffer(size) { get(it) }
//
//inline fun DoubleArray.toBuffer(stack: MemoryStack): ByteBuffer = stack.Buffer(size * 8).also { for (i in indices) it.putDouble(i * 8, get(i)) }
//inline fun DoubleArray.toByteBuffer(stack: MemoryStack): ByteBuffer = toBuffer(stack)
//inline fun DoubleArray.toDoubleBuffer(stack: MemoryStack): DoubleBuffer = stack.DoubleBuffer(size) { get(it) }

// Address version

//inline fun ByteArray.toAdr(): BytePtr = BytePtr(size) { get(it) }
//inline fun ByteArray.toByteAdr(): BytePtr = toAdr()
//
//inline fun ShortArray.toAdr(): ShortPtr = ShortPtr(size) { get(it) }
////inline fun ShortArray.toByteAdr(): BytePtr = BytePtr(toAdr())
//inline fun ShortArray.toShortAdr(): ShortPtr = toAdr()
//
//inline fun IntArray.toAdr(): IntPtr = IntPtr(size) { get(it) }
////inline fun IntArray.toByteAdr(): BytePtr = BytePtr(toAdr())
//inline fun IntArray.toIntAdr(): IntPtr = toAdr()
//
//inline fun LongArray.toAdr(): LongPtr = LongPtr(size) { get(it) }
////inline fun LongArray.toByteAdr(): BytePtr = BytePtr(toAdr())
//inline fun LongArray.toLongAdr(): LongPtr = toAdr()
//
//inline fun FloatArray.toAdr(): FloatPtr = FloatPtr(size) { get(it) }
////inline fun FloatArray.toByteAdr(): BytePtr = BytePtr(toAdr())
//inline fun FloatArray.toFloatAdr(): FloatPtr = toAdr()
//
//inline fun DoubleArray.toAdr(): DoublePtr = DoublePtr(size) { get(it) }
////inline fun DoubleArray.toByteAdr(): BytePtr = BytePtr(toAdr())
//inline fun DoubleArray.toDoubleAdr(): DoublePtr = toAdr()
//
//
//inline fun ByteArray.toAdr(stack: MemoryStack): BytePtr = stack.BytePtr(size) { get(it) }
//inline fun ByteArray.toByteAdr(stack: MemoryStack): BytePtr = toAdr(stack)
////inline fun ByteArray.toShortBuffer(stack: MemoryStack): ShortBuffer { TODO?
//
//inline fun ShortArray.toAdr(stack: MemoryStack): ShortPtr = stack.ShortPtr(size) { get(it) }
////inline fun ShortArray.toByteAdr(stack: MemoryStack): BytePtr = BytePtr(toAdr(stack))
//inline fun ShortArray.toShortAdr(stack: MemoryStack): ShortPtr = toAdr(stack)
//
//inline fun IntArray.toAdr(stack: MemoryStack): IntPtr = stack.IntPtr(size) { get(it) }
////inline fun IntArray.toByteAdr(stack: MemoryStack): BytePtr = BytePtr(toAdr(stack))
//inline fun IntArray.toIntAdr(stack: MemoryStack): IntPtr = toAdr(stack)
//
//inline fun LongArray.toAdr(stack: MemoryStack): LongPtr = stack.LongPtr(size) { get(it) }
////inline fun LongArray.toByteAdr(stack: MemoryStack): BytePtr = BytePtr(toAdr(stack))
//inline fun LongArray.toLongAdr(stack: MemoryStack): LongPtr = toAdr(stack)
//
//inline fun FloatArray.toAdr(stack: MemoryStack): FloatPtr = stack.FloatPtr(size) { get(it) }
////inline fun FloatArray.toByteAdr(stack: MemoryStack): BytePtr = BytePtr(toAdr(stack))
//inline fun FloatArray.toFloatAdr(stack: MemoryStack): FloatPtr = toAdr(stack)
//
//inline fun DoubleArray.toAdr(stack: MemoryStack): DoublePtr = stack.DoublePtr(size) { get(it) }
////inline fun DoubleArray.toByteAdr(stack: MemoryStack): BytePtr = BytePtr(toAdr(stack))
//inline fun DoubleArray.toDoubleAdr(stack: MemoryStack): DoublePtr = toAdr(stack)