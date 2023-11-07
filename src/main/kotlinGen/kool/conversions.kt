@file:OptIn(kotlin.ExperimentalUnsignedTypes::class)
package kool

import kool.ubuffers.UByteBuffer
import java.nio.LongBuffer
import kool.ubuffers.UShortBuffer
import kool.ubuffers.asULongBuffer
import kool.sliceAs
import org.lwjgl.PointerBuffer
import kool.free
import org.lwjgl.system.MemoryUtil
import kool.ubuffers.asUIntBuffer
import java.nio.DoubleBuffer
import java.nio.CharBuffer
import kool.adr
import kool.ubuffers.asUByteBuffer
import org.lwjgl.system.MemoryStack
import java.nio.Buffer
import kool.ubuffers.ULongBuffer
import java.nio.IntBuffer
import org.lwjgl.system.Pointer
import kool.rem
import java.nio.ByteBuffer
import java.nio.ShortBuffer
import kool.ubuffers.asUShortBuffer
import kool.cap
import java.nio.FloatBuffer
import kool.pos
import kool.ubuffers.UIntBuffer
import kool.Adr

/**
 * Allocates a block of memory for the array and copy the data from the array to the new allocated memory.
 * @param: size the number of elements to allocate.
 * @return on success, the buffer representing the memory block allocated by the function
 * @throws `OutOfMemoryError` if the function failed to allocate the requested block of memory
 */
fun CharArray.toBuffer(): ByteBuffer {
    val res = MemoryUtil.memAlloc(size * Char.BYTES)
    for (i in indices) 
        res.putChar(i * Char.BYTES, get(i))
    return res
}
infix fun CharArray.toBuffer(stack: MemoryStack): ByteBuffer {
    val res = stack.malloc(size * Char.BYTES)
    for (i in indices) 
        res.putChar(i * Char.BYTES, get(i))
    return res
}
/**
 * Allocates a block of memory for the array and copy the data from the array to the new allocated memory.
 * @param: size the number of elements to allocate.
 * @return on success, the buffer representing the memory block allocated by the function
 * @throws `OutOfMemoryError` if the function failed to allocate the requested block of memory
 */
fun CharArray.toByteBuffer(): ByteBuffer = toBuffer()
infix fun CharArray.toByteBuffer(stack: MemoryStack): ByteBuffer = toBuffer(stack)
/**
 * Allocates a block of memory for the array and copy the data from the array to the new allocated memory.
 * @param: size the number of elements to allocate.
 * @return on success, the buffer representing the memory block allocated by the function
 * @throws `OutOfMemoryError` if the function failed to allocate the requested block of memory
 */
fun CharArray.toCharBuffer(): CharBuffer = CharBuffer(size) { get(it) }
infix fun CharArray.toCharBuffer(stack: MemoryStack): CharBuffer = stack.CharBuffer(size) { get(it) }
@JvmName("CharToBuffer")
fun ArrayList<Char>.toBuffer(): ByteBuffer {
    val res = MemoryUtil.memAlloc(size * Char.BYTES)
    for (i in indices) 
        res.putChar(i * Char.BYTES, get(i))
    return res
}
@JvmName("CharToBuffer")
infix fun ArrayList<Char>.toBuffer(stack: MemoryStack): ByteBuffer {
    val res = stack.malloc(size * Char.BYTES)
    for (i in indices) 
        res.putChar(i * Char.BYTES, get(i))
    return res
}
/**
 * Allocates a block of memory for the array and copy the data from the array to the new allocated memory.
 * @param: size the number of elements to allocate.
 * @return on success, the buffer representing the memory block allocated by the function
 * @throws `OutOfMemoryError` if the function failed to allocate the requested block of memory
 */
@JvmName("CharToByteBuffer")
fun ArrayList<Char>.toByteBuffer(): ByteBuffer = toBuffer()
@JvmName("CharToByteBuffer")
infix fun ArrayList<Char>.toByteBuffer(stack: MemoryStack): ByteBuffer = toBuffer(stack)
/**
 * Allocates a block of memory for the array and copy the data from the array to the new allocated memory.
 * @param: size the number of elements to allocate.
 * @return on success, the buffer representing the memory block allocated by the function
 * @throws `OutOfMemoryError` if the function failed to allocate the requested block of memory
 */
fun ArrayList<Char>.toCharBuffer(): CharBuffer = CharBuffer(size) { get(it) }
infix fun ArrayList<Char>.toCharBuffer(stack: MemoryStack): CharBuffer = stack.CharBuffer(size) { get(it) }
/**
 * Allocates a block of memory for the array and copy the data from the array to the new allocated memory.
 * @param: size the number of elements to allocate.
 * @return on success, the buffer representing the memory block allocated by the function
 * @throws `OutOfMemoryError` if the function failed to allocate the requested block of memory
 */
fun ByteArray.toBuffer(): ByteBuffer {
    val res = MemoryUtil.memAlloc(size)
    for (i in indices) 
        res.put(i, get(i))
    return res
}
infix fun ByteArray.toBuffer(stack: MemoryStack): ByteBuffer {
    val res = stack.malloc(size)
    for (i in indices) 
        res.put(i, get(i))
    return res
}
/**
 * Allocates a block of memory for the array and copy the data from the array to the new allocated memory.
 * @param: size the number of elements to allocate.
 * @return on success, the buffer representing the memory block allocated by the function
 * @throws `OutOfMemoryError` if the function failed to allocate the requested block of memory
 */
fun ByteArray.toByteBuffer(): ByteBuffer = toBuffer()
infix fun ByteArray.toByteBuffer(stack: MemoryStack): ByteBuffer = toBuffer(stack)
@JvmName("ByteToBuffer")
fun ArrayList<Byte>.toBuffer(): ByteBuffer {
    val res = MemoryUtil.memAlloc(size)
    for (i in indices) 
        res.put(i, get(i))
    return res
}
@JvmName("ByteToBuffer")
infix fun ArrayList<Byte>.toBuffer(stack: MemoryStack): ByteBuffer {
    val res = stack.malloc(size)
    for (i in indices) 
        res.put(i, get(i))
    return res
}
/**
 * Allocates a block of memory for the array and copy the data from the array to the new allocated memory.
 * @param: size the number of elements to allocate.
 * @return on success, the buffer representing the memory block allocated by the function
 * @throws `OutOfMemoryError` if the function failed to allocate the requested block of memory
 */
@JvmName("ByteToByteBuffer")
fun ArrayList<Byte>.toByteBuffer(): ByteBuffer = toBuffer()
@JvmName("ByteToByteBuffer")
infix fun ArrayList<Byte>.toByteBuffer(stack: MemoryStack): ByteBuffer = toBuffer(stack)
/**
 * Allocates a block of memory for the array and copy the data from the array to the new allocated memory.
 * @param: size the number of elements to allocate.
 * @return on success, the buffer representing the memory block allocated by the function
 * @throws `OutOfMemoryError` if the function failed to allocate the requested block of memory
 */
fun ShortArray.toBuffer(): ByteBuffer {
    val res = MemoryUtil.memAlloc(size * Short.BYTES)
    for (i in indices) 
        res.putShort(i * Short.BYTES, get(i))
    return res
}
infix fun ShortArray.toBuffer(stack: MemoryStack): ByteBuffer {
    val res = stack.malloc(size * Short.BYTES)
    for (i in indices) 
        res.putShort(i * Short.BYTES, get(i))
    return res
}
/**
 * Allocates a block of memory for the array and copy the data from the array to the new allocated memory.
 * @param: size the number of elements to allocate.
 * @return on success, the buffer representing the memory block allocated by the function
 * @throws `OutOfMemoryError` if the function failed to allocate the requested block of memory
 */
fun ShortArray.toByteBuffer(): ByteBuffer = toBuffer()
infix fun ShortArray.toByteBuffer(stack: MemoryStack): ByteBuffer = toBuffer(stack)
/**
 * Allocates a block of memory for the array and copy the data from the array to the new allocated memory.
 * @param: size the number of elements to allocate.
 * @return on success, the buffer representing the memory block allocated by the function
 * @throws `OutOfMemoryError` if the function failed to allocate the requested block of memory
 */
fun ShortArray.toShortBuffer(): ShortBuffer = ShortBuffer(size) { get(it) }
infix fun ShortArray.toShortBuffer(stack: MemoryStack): ShortBuffer = stack.ShortBuffer(size) { get(it) }
@JvmName("ShortToBuffer")
fun ArrayList<Short>.toBuffer(): ByteBuffer {
    val res = MemoryUtil.memAlloc(size * Short.BYTES)
    for (i in indices) 
        res.putShort(i * Short.BYTES, get(i))
    return res
}
@JvmName("ShortToBuffer")
infix fun ArrayList<Short>.toBuffer(stack: MemoryStack): ByteBuffer {
    val res = stack.malloc(size * Short.BYTES)
    for (i in indices) 
        res.putShort(i * Short.BYTES, get(i))
    return res
}
/**
 * Allocates a block of memory for the array and copy the data from the array to the new allocated memory.
 * @param: size the number of elements to allocate.
 * @return on success, the buffer representing the memory block allocated by the function
 * @throws `OutOfMemoryError` if the function failed to allocate the requested block of memory
 */
@JvmName("ShortToByteBuffer")
fun ArrayList<Short>.toByteBuffer(): ByteBuffer = toBuffer()
@JvmName("ShortToByteBuffer")
infix fun ArrayList<Short>.toByteBuffer(stack: MemoryStack): ByteBuffer = toBuffer(stack)
/**
 * Allocates a block of memory for the array and copy the data from the array to the new allocated memory.
 * @param: size the number of elements to allocate.
 * @return on success, the buffer representing the memory block allocated by the function
 * @throws `OutOfMemoryError` if the function failed to allocate the requested block of memory
 */
fun ArrayList<Short>.toShortBuffer(): ShortBuffer = ShortBuffer(size) { get(it) }
infix fun ArrayList<Short>.toShortBuffer(stack: MemoryStack): ShortBuffer = stack.ShortBuffer(size) { get(it) }
/**
 * Allocates a block of memory for the array and copy the data from the array to the new allocated memory.
 * @param: size the number of elements to allocate.
 * @return on success, the buffer representing the memory block allocated by the function
 * @throws `OutOfMemoryError` if the function failed to allocate the requested block of memory
 */
fun IntArray.toBuffer(): ByteBuffer {
    val res = MemoryUtil.memAlloc(size * Int.BYTES)
    for (i in indices) 
        res.putInt(i * Int.BYTES, get(i))
    return res
}
infix fun IntArray.toBuffer(stack: MemoryStack): ByteBuffer {
    val res = stack.malloc(size * Int.BYTES)
    for (i in indices) 
        res.putInt(i * Int.BYTES, get(i))
    return res
}
/**
 * Allocates a block of memory for the array and copy the data from the array to the new allocated memory.
 * @param: size the number of elements to allocate.
 * @return on success, the buffer representing the memory block allocated by the function
 * @throws `OutOfMemoryError` if the function failed to allocate the requested block of memory
 */
fun IntArray.toByteBuffer(): ByteBuffer = toBuffer()
infix fun IntArray.toByteBuffer(stack: MemoryStack): ByteBuffer = toBuffer(stack)
/**
 * Allocates a block of memory for the array and copy the data from the array to the new allocated memory.
 * @param: size the number of elements to allocate.
 * @return on success, the buffer representing the memory block allocated by the function
 * @throws `OutOfMemoryError` if the function failed to allocate the requested block of memory
 */
fun IntArray.toIntBuffer(): IntBuffer = IntBuffer(size) { get(it) }
infix fun IntArray.toIntBuffer(stack: MemoryStack): IntBuffer = stack.IntBuffer(size) { get(it) }
@JvmName("IntToBuffer")
fun ArrayList<Int>.toBuffer(): ByteBuffer {
    val res = MemoryUtil.memAlloc(size * Int.BYTES)
    for (i in indices) 
        res.putInt(i * Int.BYTES, get(i))
    return res
}
@JvmName("IntToBuffer")
infix fun ArrayList<Int>.toBuffer(stack: MemoryStack): ByteBuffer {
    val res = stack.malloc(size * Int.BYTES)
    for (i in indices) 
        res.putInt(i * Int.BYTES, get(i))
    return res
}
/**
 * Allocates a block of memory for the array and copy the data from the array to the new allocated memory.
 * @param: size the number of elements to allocate.
 * @return on success, the buffer representing the memory block allocated by the function
 * @throws `OutOfMemoryError` if the function failed to allocate the requested block of memory
 */
@JvmName("IntToByteBuffer")
fun ArrayList<Int>.toByteBuffer(): ByteBuffer = toBuffer()
@JvmName("IntToByteBuffer")
infix fun ArrayList<Int>.toByteBuffer(stack: MemoryStack): ByteBuffer = toBuffer(stack)
/**
 * Allocates a block of memory for the array and copy the data from the array to the new allocated memory.
 * @param: size the number of elements to allocate.
 * @return on success, the buffer representing the memory block allocated by the function
 * @throws `OutOfMemoryError` if the function failed to allocate the requested block of memory
 */
fun ArrayList<Int>.toIntBuffer(): IntBuffer = IntBuffer(size) { get(it) }
infix fun ArrayList<Int>.toIntBuffer(stack: MemoryStack): IntBuffer = stack.IntBuffer(size) { get(it) }
/**
 * Allocates a block of memory for the array and copy the data from the array to the new allocated memory.
 * @param: size the number of elements to allocate.
 * @return on success, the buffer representing the memory block allocated by the function
 * @throws `OutOfMemoryError` if the function failed to allocate the requested block of memory
 */
fun LongArray.toBuffer(): ByteBuffer {
    val res = MemoryUtil.memAlloc(size * Long.BYTES)
    for (i in indices) 
        res.putLong(i * Long.BYTES, get(i))
    return res
}
infix fun LongArray.toBuffer(stack: MemoryStack): ByteBuffer {
    val res = stack.malloc(size * Long.BYTES)
    for (i in indices) 
        res.putLong(i * Long.BYTES, get(i))
    return res
}
/**
 * Allocates a block of memory for the array and copy the data from the array to the new allocated memory.
 * @param: size the number of elements to allocate.
 * @return on success, the buffer representing the memory block allocated by the function
 * @throws `OutOfMemoryError` if the function failed to allocate the requested block of memory
 */
fun LongArray.toByteBuffer(): ByteBuffer = toBuffer()
infix fun LongArray.toByteBuffer(stack: MemoryStack): ByteBuffer = toBuffer(stack)
/**
 * Allocates a block of memory for the array and copy the data from the array to the new allocated memory.
 * @param: size the number of elements to allocate.
 * @return on success, the buffer representing the memory block allocated by the function
 * @throws `OutOfMemoryError` if the function failed to allocate the requested block of memory
 */
fun LongArray.toLongBuffer(): LongBuffer = LongBuffer(size) { get(it) }
infix fun LongArray.toLongBuffer(stack: MemoryStack): LongBuffer = stack.LongBuffer(size) { get(it) }
@JvmName("LongToBuffer")
fun ArrayList<Long>.toBuffer(): ByteBuffer {
    val res = MemoryUtil.memAlloc(size * Long.BYTES)
    for (i in indices) 
        res.putLong(i * Long.BYTES, get(i))
    return res
}
@JvmName("LongToBuffer")
infix fun ArrayList<Long>.toBuffer(stack: MemoryStack): ByteBuffer {
    val res = stack.malloc(size * Long.BYTES)
    for (i in indices) 
        res.putLong(i * Long.BYTES, get(i))
    return res
}
/**
 * Allocates a block of memory for the array and copy the data from the array to the new allocated memory.
 * @param: size the number of elements to allocate.
 * @return on success, the buffer representing the memory block allocated by the function
 * @throws `OutOfMemoryError` if the function failed to allocate the requested block of memory
 */
@JvmName("LongToByteBuffer")
fun ArrayList<Long>.toByteBuffer(): ByteBuffer = toBuffer()
@JvmName("LongToByteBuffer")
infix fun ArrayList<Long>.toByteBuffer(stack: MemoryStack): ByteBuffer = toBuffer(stack)
/**
 * Allocates a block of memory for the array and copy the data from the array to the new allocated memory.
 * @param: size the number of elements to allocate.
 * @return on success, the buffer representing the memory block allocated by the function
 * @throws `OutOfMemoryError` if the function failed to allocate the requested block of memory
 */
fun ArrayList<Long>.toLongBuffer(): LongBuffer = LongBuffer(size) { get(it) }
infix fun ArrayList<Long>.toLongBuffer(stack: MemoryStack): LongBuffer = stack.LongBuffer(size) { get(it) }
/**
 * Allocates a block of memory for the array and copy the data from the array to the new allocated memory.
 * @param: size the number of elements to allocate.
 * @return on success, the buffer representing the memory block allocated by the function
 * @throws `OutOfMemoryError` if the function failed to allocate the requested block of memory
 */
fun UByteArray.toBuffer(): UByteBuffer {
    val res = MemoryUtil.memAlloc(size).asUByteBuffer()
    for (i in indices) 
        res.put(i, get(i))
    return res
}
infix fun UByteArray.toBuffer(stack: MemoryStack): UByteBuffer {
    val res = stack.malloc(size).asUByteBuffer()
    for (i in indices) 
        res.put(i, get(i))
    return res
}
/**
 * Allocates a block of memory for the array and copy the data from the array to the new allocated memory.
 * @param: size the number of elements to allocate.
 * @return on success, the buffer representing the memory block allocated by the function
 * @throws `OutOfMemoryError` if the function failed to allocate the requested block of memory
 */
fun UByteArray.toByteBuffer(): UByteBuffer = toBuffer()
infix fun UByteArray.toByteBuffer(stack: MemoryStack): UByteBuffer = toBuffer(stack)
@JvmName("UByteToBuffer")
fun ArrayList<UByte>.toBuffer(): UByteBuffer {
    val res = MemoryUtil.memAlloc(size).asUByteBuffer()
    for (i in indices) 
        res.put(i, get(i))
    return res
}
@JvmName("UByteToBuffer")
infix fun ArrayList<UByte>.toBuffer(stack: MemoryStack): UByteBuffer {
    val res = stack.malloc(size).asUByteBuffer()
    for (i in indices) 
        res.put(i, get(i))
    return res
}
/**
 * Allocates a block of memory for the array and copy the data from the array to the new allocated memory.
 * @param: size the number of elements to allocate.
 * @return on success, the buffer representing the memory block allocated by the function
 * @throws `OutOfMemoryError` if the function failed to allocate the requested block of memory
 */
@JvmName("UByteToByteBuffer")
fun ArrayList<UByte>.toByteBuffer(): UByteBuffer = toBuffer()
@JvmName("UByteToByteBuffer")
infix fun ArrayList<UByte>.toByteBuffer(stack: MemoryStack): UByteBuffer = toBuffer(stack)
/**
 * Allocates a block of memory for the array and copy the data from the array to the new allocated memory.
 * @param: size the number of elements to allocate.
 * @return on success, the buffer representing the memory block allocated by the function
 * @throws `OutOfMemoryError` if the function failed to allocate the requested block of memory
 */
fun UShortArray.toUBuffer(): UByteBuffer {
    val res = MemoryUtil.memAlloc(size * UShort.BYTES).asUByteBuffer()
    for (i in indices) 
        res.putUShort(i * UShort.BYTES, get(i))
    return res
}
infix fun UShortArray.toUBuffer(stack: MemoryStack): UByteBuffer {
    val res = stack.malloc(size * UShort.BYTES).asUByteBuffer()
    for (i in indices) 
        res.putUShort(i * UShort.BYTES, get(i))
    return res
}
/**
 * Allocates a block of memory for the array and copy the data from the array to the new allocated memory.
 * @param: size the number of elements to allocate.
 * @return on success, the buffer representing the memory block allocated by the function
 * @throws `OutOfMemoryError` if the function failed to allocate the requested block of memory
 */
fun UShortArray.toUByteBuffer(): UByteBuffer = toUBuffer()
infix fun UShortArray.toUByteBuffer(stack: MemoryStack): UByteBuffer = toUBuffer(stack)
/**
 * Allocates a block of memory for the array and copy the data from the array to the new allocated memory.
 * @param: size the number of elements to allocate.
 * @return on success, the buffer representing the memory block allocated by the function
 * @throws `OutOfMemoryError` if the function failed to allocate the requested block of memory
 */
fun UShortArray.toUShortBuffer(): UShortBuffer = UShortBuffer(size) { get(it) }
infix fun UShortArray.toUShortBuffer(stack: MemoryStack): UShortBuffer = stack.UShortBuffer(size) { get(it) }
@JvmName("UShortToBuffer")
fun ArrayList<UShort>.toUBuffer(): UByteBuffer {
    val res = MemoryUtil.memAlloc(size * UShort.BYTES).asUByteBuffer()
    for (i in indices) 
        res.putUShort(i * UShort.BYTES, get(i))
    return res
}
@JvmName("UShortToBuffer")
infix fun ArrayList<UShort>.toUBuffer(stack: MemoryStack): UByteBuffer {
    val res = stack.malloc(size * UShort.BYTES).asUByteBuffer()
    for (i in indices) 
        res.putUShort(i * UShort.BYTES, get(i))
    return res
}
/**
 * Allocates a block of memory for the array and copy the data from the array to the new allocated memory.
 * @param: size the number of elements to allocate.
 * @return on success, the buffer representing the memory block allocated by the function
 * @throws `OutOfMemoryError` if the function failed to allocate the requested block of memory
 */
@JvmName("UShortToByteBuffer")
fun ArrayList<UShort>.toUByteBuffer(): UByteBuffer = toUBuffer()
@JvmName("UShortToByteBuffer")
infix fun ArrayList<UShort>.toUByteBuffer(stack: MemoryStack): UByteBuffer = toUBuffer(stack)
/**
 * Allocates a block of memory for the array and copy the data from the array to the new allocated memory.
 * @param: size the number of elements to allocate.
 * @return on success, the buffer representing the memory block allocated by the function
 * @throws `OutOfMemoryError` if the function failed to allocate the requested block of memory
 */
fun ArrayList<UShort>.toUShortBuffer(): UShortBuffer = UShortBuffer(size) { get(it) }
infix fun ArrayList<UShort>.toUShortBuffer(stack: MemoryStack): UShortBuffer = stack.UShortBuffer(size) { get(it) }
/**
 * Allocates a block of memory for the array and copy the data from the array to the new allocated memory.
 * @param: size the number of elements to allocate.
 * @return on success, the buffer representing the memory block allocated by the function
 * @throws `OutOfMemoryError` if the function failed to allocate the requested block of memory
 */
fun UIntArray.toUBuffer(): UByteBuffer {
    val res = MemoryUtil.memAlloc(size * UInt.BYTES).asUByteBuffer()
    for (i in indices) 
        res.putUInt(i * UInt.BYTES, get(i))
    return res
}
infix fun UIntArray.toUBuffer(stack: MemoryStack): UByteBuffer {
    val res = stack.malloc(size * UInt.BYTES).asUByteBuffer()
    for (i in indices) 
        res.putUInt(i * UInt.BYTES, get(i))
    return res
}
/**
 * Allocates a block of memory for the array and copy the data from the array to the new allocated memory.
 * @param: size the number of elements to allocate.
 * @return on success, the buffer representing the memory block allocated by the function
 * @throws `OutOfMemoryError` if the function failed to allocate the requested block of memory
 */
fun UIntArray.toUByteBuffer(): UByteBuffer = toUBuffer()
infix fun UIntArray.toUByteBuffer(stack: MemoryStack): UByteBuffer = toUBuffer(stack)
/**
 * Allocates a block of memory for the array and copy the data from the array to the new allocated memory.
 * @param: size the number of elements to allocate.
 * @return on success, the buffer representing the memory block allocated by the function
 * @throws `OutOfMemoryError` if the function failed to allocate the requested block of memory
 */
fun UIntArray.toUIntBuffer(): UIntBuffer = UIntBuffer(size) { get(it) }
infix fun UIntArray.toUIntBuffer(stack: MemoryStack): UIntBuffer = stack.UIntBuffer(size) { get(it) }
@JvmName("UIntToBuffer")
fun ArrayList<UInt>.toUBuffer(): UByteBuffer {
    val res = MemoryUtil.memAlloc(size * UInt.BYTES).asUByteBuffer()
    for (i in indices) 
        res.putUInt(i * UInt.BYTES, get(i))
    return res
}
@JvmName("UIntToBuffer")
infix fun ArrayList<UInt>.toUBuffer(stack: MemoryStack): UByteBuffer {
    val res = stack.malloc(size * UInt.BYTES).asUByteBuffer()
    for (i in indices) 
        res.putUInt(i * UInt.BYTES, get(i))
    return res
}
/**
 * Allocates a block of memory for the array and copy the data from the array to the new allocated memory.
 * @param: size the number of elements to allocate.
 * @return on success, the buffer representing the memory block allocated by the function
 * @throws `OutOfMemoryError` if the function failed to allocate the requested block of memory
 */
@JvmName("UIntToByteBuffer")
fun ArrayList<UInt>.toUByteBuffer(): UByteBuffer = toUBuffer()
@JvmName("UIntToByteBuffer")
infix fun ArrayList<UInt>.toUByteBuffer(stack: MemoryStack): UByteBuffer = toUBuffer(stack)
/**
 * Allocates a block of memory for the array and copy the data from the array to the new allocated memory.
 * @param: size the number of elements to allocate.
 * @return on success, the buffer representing the memory block allocated by the function
 * @throws `OutOfMemoryError` if the function failed to allocate the requested block of memory
 */
fun ArrayList<UInt>.toUIntBuffer(): UIntBuffer = UIntBuffer(size) { get(it) }
infix fun ArrayList<UInt>.toUIntBuffer(stack: MemoryStack): UIntBuffer = stack.UIntBuffer(size) { get(it) }
/**
 * Allocates a block of memory for the array and copy the data from the array to the new allocated memory.
 * @param: size the number of elements to allocate.
 * @return on success, the buffer representing the memory block allocated by the function
 * @throws `OutOfMemoryError` if the function failed to allocate the requested block of memory
 */
fun ULongArray.toUBuffer(): UByteBuffer {
    val res = MemoryUtil.memAlloc(size * ULong.BYTES).asUByteBuffer()
    for (i in indices) 
        res.putULong(i * ULong.BYTES, get(i))
    return res
}
infix fun ULongArray.toUBuffer(stack: MemoryStack): UByteBuffer {
    val res = stack.malloc(size * ULong.BYTES).asUByteBuffer()
    for (i in indices) 
        res.putULong(i * ULong.BYTES, get(i))
    return res
}
/**
 * Allocates a block of memory for the array and copy the data from the array to the new allocated memory.
 * @param: size the number of elements to allocate.
 * @return on success, the buffer representing the memory block allocated by the function
 * @throws `OutOfMemoryError` if the function failed to allocate the requested block of memory
 */
fun ULongArray.toUByteBuffer(): UByteBuffer = toUBuffer()
infix fun ULongArray.toUByteBuffer(stack: MemoryStack): UByteBuffer = toUBuffer(stack)
/**
 * Allocates a block of memory for the array and copy the data from the array to the new allocated memory.
 * @param: size the number of elements to allocate.
 * @return on success, the buffer representing the memory block allocated by the function
 * @throws `OutOfMemoryError` if the function failed to allocate the requested block of memory
 */
fun ULongArray.toULongBuffer(): ULongBuffer = ULongBuffer(size) { get(it) }
infix fun ULongArray.toULongBuffer(stack: MemoryStack): ULongBuffer = stack.ULongBuffer(size) { get(it) }
@JvmName("ULongToBuffer")
fun ArrayList<ULong>.toUBuffer(): UByteBuffer {
    val res = MemoryUtil.memAlloc(size * ULong.BYTES).asUByteBuffer()
    for (i in indices) 
        res.putULong(i * ULong.BYTES, get(i))
    return res
}
@JvmName("ULongToBuffer")
infix fun ArrayList<ULong>.toUBuffer(stack: MemoryStack): UByteBuffer {
    val res = stack.malloc(size * ULong.BYTES).asUByteBuffer()
    for (i in indices) 
        res.putULong(i * ULong.BYTES, get(i))
    return res
}
/**
 * Allocates a block of memory for the array and copy the data from the array to the new allocated memory.
 * @param: size the number of elements to allocate.
 * @return on success, the buffer representing the memory block allocated by the function
 * @throws `OutOfMemoryError` if the function failed to allocate the requested block of memory
 */
@JvmName("ULongToByteBuffer")
fun ArrayList<ULong>.toUByteBuffer(): UByteBuffer = toUBuffer()
@JvmName("ULongToByteBuffer")
infix fun ArrayList<ULong>.toUByteBuffer(stack: MemoryStack): UByteBuffer = toUBuffer(stack)
/**
 * Allocates a block of memory for the array and copy the data from the array to the new allocated memory.
 * @param: size the number of elements to allocate.
 * @return on success, the buffer representing the memory block allocated by the function
 * @throws `OutOfMemoryError` if the function failed to allocate the requested block of memory
 */
fun ArrayList<ULong>.toULongBuffer(): ULongBuffer = ULongBuffer(size) { get(it) }
infix fun ArrayList<ULong>.toULongBuffer(stack: MemoryStack): ULongBuffer = stack.ULongBuffer(size) { get(it) }
/**
 * Allocates a block of memory for the array and copy the data from the array to the new allocated memory.
 * @param: size the number of elements to allocate.
 * @return on success, the buffer representing the memory block allocated by the function
 * @throws `OutOfMemoryError` if the function failed to allocate the requested block of memory
 */
fun FloatArray.toBuffer(): ByteBuffer {
    val res = MemoryUtil.memAlloc(size * Float.BYTES)
    for (i in indices) 
        res.putFloat(i * Float.BYTES, get(i))
    return res
}
infix fun FloatArray.toBuffer(stack: MemoryStack): ByteBuffer {
    val res = stack.malloc(size * Float.BYTES)
    for (i in indices) 
        res.putFloat(i * Float.BYTES, get(i))
    return res
}
/**
 * Allocates a block of memory for the array and copy the data from the array to the new allocated memory.
 * @param: size the number of elements to allocate.
 * @return on success, the buffer representing the memory block allocated by the function
 * @throws `OutOfMemoryError` if the function failed to allocate the requested block of memory
 */
fun FloatArray.toByteBuffer(): ByteBuffer = toBuffer()
infix fun FloatArray.toByteBuffer(stack: MemoryStack): ByteBuffer = toBuffer(stack)
/**
 * Allocates a block of memory for the array and copy the data from the array to the new allocated memory.
 * @param: size the number of elements to allocate.
 * @return on success, the buffer representing the memory block allocated by the function
 * @throws `OutOfMemoryError` if the function failed to allocate the requested block of memory
 */
fun FloatArray.toFloatBuffer(): FloatBuffer = FloatBuffer(size) { get(it) }
infix fun FloatArray.toFloatBuffer(stack: MemoryStack): FloatBuffer = stack.FloatBuffer(size) { get(it) }
@JvmName("FloatToBuffer")
fun ArrayList<Float>.toBuffer(): ByteBuffer {
    val res = MemoryUtil.memAlloc(size * Float.BYTES)
    for (i in indices) 
        res.putFloat(i * Float.BYTES, get(i))
    return res
}
@JvmName("FloatToBuffer")
infix fun ArrayList<Float>.toBuffer(stack: MemoryStack): ByteBuffer {
    val res = stack.malloc(size * Float.BYTES)
    for (i in indices) 
        res.putFloat(i * Float.BYTES, get(i))
    return res
}
/**
 * Allocates a block of memory for the array and copy the data from the array to the new allocated memory.
 * @param: size the number of elements to allocate.
 * @return on success, the buffer representing the memory block allocated by the function
 * @throws `OutOfMemoryError` if the function failed to allocate the requested block of memory
 */
@JvmName("FloatToByteBuffer")
fun ArrayList<Float>.toByteBuffer(): ByteBuffer = toBuffer()
@JvmName("FloatToByteBuffer")
infix fun ArrayList<Float>.toByteBuffer(stack: MemoryStack): ByteBuffer = toBuffer(stack)
/**
 * Allocates a block of memory for the array and copy the data from the array to the new allocated memory.
 * @param: size the number of elements to allocate.
 * @return on success, the buffer representing the memory block allocated by the function
 * @throws `OutOfMemoryError` if the function failed to allocate the requested block of memory
 */
fun ArrayList<Float>.toFloatBuffer(): FloatBuffer = FloatBuffer(size) { get(it) }
infix fun ArrayList<Float>.toFloatBuffer(stack: MemoryStack): FloatBuffer = stack.FloatBuffer(size) { get(it) }
/**
 * Allocates a block of memory for the array and copy the data from the array to the new allocated memory.
 * @param: size the number of elements to allocate.
 * @return on success, the buffer representing the memory block allocated by the function
 * @throws `OutOfMemoryError` if the function failed to allocate the requested block of memory
 */
fun DoubleArray.toBuffer(): ByteBuffer {
    val res = MemoryUtil.memAlloc(size * Double.BYTES)
    for (i in indices) 
        res.putDouble(i * Double.BYTES, get(i))
    return res
}
infix fun DoubleArray.toBuffer(stack: MemoryStack): ByteBuffer {
    val res = stack.malloc(size * Double.BYTES)
    for (i in indices) 
        res.putDouble(i * Double.BYTES, get(i))
    return res
}
/**
 * Allocates a block of memory for the array and copy the data from the array to the new allocated memory.
 * @param: size the number of elements to allocate.
 * @return on success, the buffer representing the memory block allocated by the function
 * @throws `OutOfMemoryError` if the function failed to allocate the requested block of memory
 */
fun DoubleArray.toByteBuffer(): ByteBuffer = toBuffer()
infix fun DoubleArray.toByteBuffer(stack: MemoryStack): ByteBuffer = toBuffer(stack)
/**
 * Allocates a block of memory for the array and copy the data from the array to the new allocated memory.
 * @param: size the number of elements to allocate.
 * @return on success, the buffer representing the memory block allocated by the function
 * @throws `OutOfMemoryError` if the function failed to allocate the requested block of memory
 */
fun DoubleArray.toDoubleBuffer(): DoubleBuffer = DoubleBuffer(size) { get(it) }
infix fun DoubleArray.toDoubleBuffer(stack: MemoryStack): DoubleBuffer = stack.DoubleBuffer(size) { get(it) }
@JvmName("DoubleToBuffer")
fun ArrayList<Double>.toBuffer(): ByteBuffer {
    val res = MemoryUtil.memAlloc(size * Double.BYTES)
    for (i in indices) 
        res.putDouble(i * Double.BYTES, get(i))
    return res
}
@JvmName("DoubleToBuffer")
infix fun ArrayList<Double>.toBuffer(stack: MemoryStack): ByteBuffer {
    val res = stack.malloc(size * Double.BYTES)
    for (i in indices) 
        res.putDouble(i * Double.BYTES, get(i))
    return res
}
/**
 * Allocates a block of memory for the array and copy the data from the array to the new allocated memory.
 * @param: size the number of elements to allocate.
 * @return on success, the buffer representing the memory block allocated by the function
 * @throws `OutOfMemoryError` if the function failed to allocate the requested block of memory
 */
@JvmName("DoubleToByteBuffer")
fun ArrayList<Double>.toByteBuffer(): ByteBuffer = toBuffer()
@JvmName("DoubleToByteBuffer")
infix fun ArrayList<Double>.toByteBuffer(stack: MemoryStack): ByteBuffer = toBuffer(stack)
/**
 * Allocates a block of memory for the array and copy the data from the array to the new allocated memory.
 * @param: size the number of elements to allocate.
 * @return on success, the buffer representing the memory block allocated by the function
 * @throws `OutOfMemoryError` if the function failed to allocate the requested block of memory
 */
fun ArrayList<Double>.toDoubleBuffer(): DoubleBuffer = DoubleBuffer(size) { get(it) }
infix fun ArrayList<Double>.toDoubleBuffer(stack: MemoryStack): DoubleBuffer = stack.DoubleBuffer(size) { get(it) }
fun <T> ByteArray.toPtr(): Ptr<T> {
    val res = MemoryUtil.nmemAlloc(size.toLong()).toPtr<Byte>()
    for (i in indices) 
        res[i] = get(i)
    return res.toPtr()
}
fun <T> ByteArray.toPtr(stack: MemoryStack): Ptr<T> {
    val res = stack.nmalloc(size).toPtr<Byte>()
    for (i in indices) 
        res[i] = get(i)
    return res.toPtr()
}
fun <T> ShortArray.toPtr(): Ptr<T> {
    val res = MemoryUtil.nmemAlloc(size.toLong()).toPtr<Short>()
    for (i in indices) 
        res[i] = get(i)
    return res.toPtr()
}
fun <T> ShortArray.toPtr(stack: MemoryStack): Ptr<T> {
    val res = stack.nmalloc(size).toPtr<Short>()
    for (i in indices) 
        res[i] = get(i)
    return res.toPtr()
}
fun <T> IntArray.toPtr(): Ptr<T> {
    val res = MemoryUtil.nmemAlloc(size.toLong()).toPtr<Int>()
    for (i in indices) 
        res[i] = get(i)
    return res.toPtr()
}
fun <T> IntArray.toPtr(stack: MemoryStack): Ptr<T> {
    val res = stack.nmalloc(size).toPtr<Int>()
    for (i in indices) 
        res[i] = get(i)
    return res.toPtr()
}
fun <T> LongArray.toPtr(): Ptr<T> {
    val res = MemoryUtil.nmemAlloc(size.toLong()).toPtr<Long>()
    for (i in indices) 
        res[i] = get(i)
    return res.toPtr()
}
fun <T> LongArray.toPtr(stack: MemoryStack): Ptr<T> {
    val res = stack.nmalloc(size).toPtr<Long>()
    for (i in indices) 
        res[i] = get(i)
    return res.toPtr()
}
fun <T> UByteArray.toPtr(): Ptr<T> {
    val res = MemoryUtil.nmemAlloc(size.toLong()).toPtr<UByte>()
    for (i in indices) 
        res[i] = get(i)
    return res.toPtr()
}
fun <T> UByteArray.toPtr(stack: MemoryStack): Ptr<T> {
    val res = stack.nmalloc(size).toPtr<UByte>()
    for (i in indices) 
        res[i] = get(i)
    return res.toPtr()
}
fun <T> UShortArray.toPtr(): Ptr<T> {
    val res = MemoryUtil.nmemAlloc(size.toLong()).toPtr<UShort>()
    for (i in indices) 
        res[i] = get(i)
    return res.toPtr()
}
fun <T> UShortArray.toPtr(stack: MemoryStack): Ptr<T> {
    val res = stack.nmalloc(size).toPtr<UShort>()
    for (i in indices) 
        res[i] = get(i)
    return res.toPtr()
}
fun <T> UIntArray.toPtr(): Ptr<T> {
    val res = MemoryUtil.nmemAlloc(size.toLong()).toPtr<UInt>()
    for (i in indices) 
        res[i] = get(i)
    return res.toPtr()
}
fun <T> UIntArray.toPtr(stack: MemoryStack): Ptr<T> {
    val res = stack.nmalloc(size).toPtr<UInt>()
    for (i in indices) 
        res[i] = get(i)
    return res.toPtr()
}
fun <T> ULongArray.toPtr(): Ptr<T> {
    val res = MemoryUtil.nmemAlloc(size.toLong()).toPtr<ULong>()
    for (i in indices) 
        res[i] = get(i)
    return res.toPtr()
}
fun <T> ULongArray.toPtr(stack: MemoryStack): Ptr<T> {
    val res = stack.nmalloc(size).toPtr<ULong>()
    for (i in indices) 
        res[i] = get(i)
    return res.toPtr()
}
fun <T> FloatArray.toPtr(): Ptr<T> {
    val res = MemoryUtil.nmemAlloc(size.toLong()).toPtr<Float>()
    for (i in indices) 
        res[i] = get(i)
    return res.toPtr()
}
fun <T> FloatArray.toPtr(stack: MemoryStack): Ptr<T> {
    val res = stack.nmalloc(size).toPtr<Float>()
    for (i in indices) 
        res[i] = get(i)
    return res.toPtr()
}
fun <T> DoubleArray.toPtr(): Ptr<T> {
    val res = MemoryUtil.nmemAlloc(size.toLong()).toPtr<Double>()
    for (i in indices) 
        res[i] = get(i)
    return res.toPtr()
}
fun <T> DoubleArray.toPtr(stack: MemoryStack): Ptr<T> {
    val res = stack.nmalloc(size).toPtr<Double>()
    for (i in indices) 
        res[i] = get(i)
    return res.toPtr()
}
