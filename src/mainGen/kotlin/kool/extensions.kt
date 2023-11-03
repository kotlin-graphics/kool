@file:Suppress("NOTHING_TO_INLINE")
package kool
import java.nio.ByteBuffer
import org.lwjgl.PointerBuffer
import java.nio.LongBuffer
import java.nio.ShortBuffer
import org.lwjgl.system.MemoryUtil
import java.nio.DoubleBuffer
import java.nio.Buffer
import java.nio.FloatBuffer
import java.nio.IntBuffer
import java.nio.CharBuffer

/**
 * Creates a new byte buffer whose content is a shared subsequence of this buffer's content.
 * The content of the new buffer will start at [offset]. Changes to this buffer's content will be visible in the
 * new buffer, and vice versa; the two buffers' position, limit, and mark values will be independent.
 * The new buffer's position will be zero, its capacity and its limit will be [size], and its mark will be undefined. 
 * The new buffer will be direct if, and only if, this buffer is direct, and it will be read-only if, and only if, this buffer is read-only.
 * @return The new byte buffer
 */
fun CharBuffer.sliceAs(offset: Int, size: Int = lim - offset): CharBuffer {
    val backupPos = pos
    val backupLim = lim
    pos = offset
    lim = offset + size
    val res = slice()
    pos = backupPos
    lim = backupLim
    return res
}
/**
 * The standard C free function.
 * A block of memory previously allocated by a call to `memAlloc`, `memCalloc` or `memRealloc` is deallocated, making it available again for further allocations.
 */
inline fun CharBuffer.free() = MemoryUtil.memFree(this)
/**
 * Returns the memory address at the current position of the buffer. This is effectively a pointer value that can be used in native function calls.
 * @return the memory address
 */
inline val CharBuffer.adr: Adr
    get() = MemoryUtil.memAddress(this).toULong()
/**
 * This buffer's position.
 * When assigning it, if the mark is defined and larger than the new position then it is discarded.
 */
inline var CharBuffer.pos: Int
    get() = position()
    set(value) { position(value) }
/** Returns this buffer's capacity. */
inline val CharBuffer.cap: Int
    get() = capacity()
/**
 * Returns the number of elements between the current position and the limit.
 * @return The number of elements remaining in this buffer
 */
inline val CharBuffer.rem: Int
    get() = remaining()
/** Returns the total size in Bytes between the current position and the limit. */
inline val CharBuffer.remByte: Int
    get() = rem * Char.BYTES
/**
 * This buffer's limit.
 * When assigning it, if the position is larger than the new limit then it is set to the new limit. 
 * If the mark is defined and larger than the new limit then it is discarded.
 */
inline var CharBuffer.lim: Int
    get() = limit()
    set(value) { limit(value) }
/**
 * Absolute put method  (optional operation).
 * Writes the given uint into this buffer at the given index.
 * @param index The index at which the uint will be written
 * @param char The uint value to be written
 * @return This buffer
 * @throws IndexOutOfBoundsException If index is negative or not smaller than the buffer's limit
 * @throws ReadOnlyBufferException If this buffer is read-only
 */
operator fun CharBuffer.set(index: Int, char: Char): CharBuffer = put(index, char)
/**
 * Creates a new byte buffer whose content is a shared subsequence of this buffer's content.
 * The content of the new buffer will start at [offset]. Changes to this buffer's content will be visible in the
 * new buffer, and vice versa; the two buffers' position, limit, and mark values will be independent.
 * The new buffer's position will be zero, its capacity and its limit will be [size], and its mark will be undefined. 
 * The new buffer will be direct if, and only if, this buffer is direct, and it will be read-only if, and only if, this buffer is read-only.
 * @return The new byte buffer
 */
fun ByteBuffer.sliceAs(offset: Int, size: Int = lim - offset): ByteBuffer {
    val backupPos = pos
    val backupLim = lim
    pos = offset
    lim = offset + size
    val res = slice()
    pos = backupPos
    lim = backupLim
    return res
}
/**
 * The standard C free function.
 * A block of memory previously allocated by a call to `memAlloc`, `memCalloc` or `memRealloc` is deallocated, making it available again for further allocations.
 */
inline fun ByteBuffer.free() = MemoryUtil.memFree(this)
/**
 * Returns the memory address at the current position of the buffer. This is effectively a pointer value that can be used in native function calls.
 * @return the memory address
 */
inline val ByteBuffer.adr: Adr
    get() = MemoryUtil.memAddress(this).toULong()
/**
 * This buffer's position.
 * When assigning it, if the mark is defined and larger than the new position then it is discarded.
 */
inline var ByteBuffer.pos: Int
    get() = position()
    set(value) { position(value) }
/** Returns this buffer's capacity. */
inline val ByteBuffer.cap: Int
    get() = capacity()
/**
 * Returns the number of elements between the current position and the limit.
 * @return The number of elements remaining in this buffer
 */
inline val ByteBuffer.rem: Int
    get() = remaining()
/** Returns the total size in Bytes between the current position and the limit. */
inline val ByteBuffer.remByte: Int
    get() = rem * Byte.BYTES
/**
 * This buffer's limit.
 * When assigning it, if the position is larger than the new limit then it is set to the new limit. 
 * If the mark is defined and larger than the new limit then it is discarded.
 */
inline var ByteBuffer.lim: Int
    get() = limit()
    set(value) { limit(value) }
/**
 * Absolute put method  (optional operation).
 * Writes the given uint into this buffer at the given index.
 * @param index The index at which the uint will be written
 * @param byte The uint value to be written
 * @return This buffer
 * @throws IndexOutOfBoundsException If index is negative or not smaller than the buffer's limit
 * @throws ReadOnlyBufferException If this buffer is read-only
 */
operator fun ByteBuffer.set(index: Int, byte: Byte): ByteBuffer = put(index, byte)
/**
 * Creates a new byte buffer whose content is a shared subsequence of this buffer's content.
 * The content of the new buffer will start at [offset]. Changes to this buffer's content will be visible in the
 * new buffer, and vice versa; the two buffers' position, limit, and mark values will be independent.
 * The new buffer's position will be zero, its capacity and its limit will be [size], and its mark will be undefined. 
 * The new buffer will be direct if, and only if, this buffer is direct, and it will be read-only if, and only if, this buffer is read-only.
 * @return The new byte buffer
 */
fun ShortBuffer.sliceAs(offset: Int, size: Int = lim - offset): ShortBuffer {
    val backupPos = pos
    val backupLim = lim
    pos = offset
    lim = offset + size
    val res = slice()
    pos = backupPos
    lim = backupLim
    return res
}
/**
 * The standard C free function.
 * A block of memory previously allocated by a call to `memAlloc`, `memCalloc` or `memRealloc` is deallocated, making it available again for further allocations.
 */
inline fun ShortBuffer.free() = MemoryUtil.memFree(this)
/**
 * Returns the memory address at the current position of the buffer. This is effectively a pointer value that can be used in native function calls.
 * @return the memory address
 */
inline val ShortBuffer.adr: Adr
    get() = MemoryUtil.memAddress(this).toULong()
/**
 * This buffer's position.
 * When assigning it, if the mark is defined and larger than the new position then it is discarded.
 */
inline var ShortBuffer.pos: Int
    get() = position()
    set(value) { position(value) }
/** Returns this buffer's capacity. */
inline val ShortBuffer.cap: Int
    get() = capacity()
/**
 * Returns the number of elements between the current position and the limit.
 * @return The number of elements remaining in this buffer
 */
inline val ShortBuffer.rem: Int
    get() = remaining()
/** Returns the total size in Bytes between the current position and the limit. */
inline val ShortBuffer.remByte: Int
    get() = rem * Short.BYTES
/**
 * This buffer's limit.
 * When assigning it, if the position is larger than the new limit then it is set to the new limit. 
 * If the mark is defined and larger than the new limit then it is discarded.
 */
inline var ShortBuffer.lim: Int
    get() = limit()
    set(value) { limit(value) }
/**
 * Absolute put method  (optional operation).
 * Writes the given uint into this buffer at the given index.
 * @param index The index at which the uint will be written
 * @param short The uint value to be written
 * @return This buffer
 * @throws IndexOutOfBoundsException If index is negative or not smaller than the buffer's limit
 * @throws ReadOnlyBufferException If this buffer is read-only
 */
operator fun ShortBuffer.set(index: Int, short: Short): ShortBuffer = put(index, short)
/**
 * Creates a new byte buffer whose content is a shared subsequence of this buffer's content.
 * The content of the new buffer will start at [offset]. Changes to this buffer's content will be visible in the
 * new buffer, and vice versa; the two buffers' position, limit, and mark values will be independent.
 * The new buffer's position will be zero, its capacity and its limit will be [size], and its mark will be undefined. 
 * The new buffer will be direct if, and only if, this buffer is direct, and it will be read-only if, and only if, this buffer is read-only.
 * @return The new byte buffer
 */
fun IntBuffer.sliceAs(offset: Int, size: Int = lim - offset): IntBuffer {
    val backupPos = pos
    val backupLim = lim
    pos = offset
    lim = offset + size
    val res = slice()
    pos = backupPos
    lim = backupLim
    return res
}
/**
 * The standard C free function.
 * A block of memory previously allocated by a call to `memAlloc`, `memCalloc` or `memRealloc` is deallocated, making it available again for further allocations.
 */
inline fun IntBuffer.free() = MemoryUtil.memFree(this)
/**
 * Returns the memory address at the current position of the buffer. This is effectively a pointer value that can be used in native function calls.
 * @return the memory address
 */
inline val IntBuffer.adr: Adr
    get() = MemoryUtil.memAddress(this).toULong()
/**
 * This buffer's position.
 * When assigning it, if the mark is defined and larger than the new position then it is discarded.
 */
inline var IntBuffer.pos: Int
    get() = position()
    set(value) { position(value) }
/** Returns this buffer's capacity. */
inline val IntBuffer.cap: Int
    get() = capacity()
/**
 * Returns the number of elements between the current position and the limit.
 * @return The number of elements remaining in this buffer
 */
inline val IntBuffer.rem: Int
    get() = remaining()
/** Returns the total size in Bytes between the current position and the limit. */
inline val IntBuffer.remByte: Int
    get() = rem * Int.BYTES
/**
 * This buffer's limit.
 * When assigning it, if the position is larger than the new limit then it is set to the new limit. 
 * If the mark is defined and larger than the new limit then it is discarded.
 */
inline var IntBuffer.lim: Int
    get() = limit()
    set(value) { limit(value) }
/**
 * Absolute put method  (optional operation).
 * Writes the given uint into this buffer at the given index.
 * @param index The index at which the uint will be written
 * @param int The uint value to be written
 * @return This buffer
 * @throws IndexOutOfBoundsException If index is negative or not smaller than the buffer's limit
 * @throws ReadOnlyBufferException If this buffer is read-only
 */
operator fun IntBuffer.set(index: Int, int: Int): IntBuffer = put(index, int)
/**
 * Creates a new byte buffer whose content is a shared subsequence of this buffer's content.
 * The content of the new buffer will start at [offset]. Changes to this buffer's content will be visible in the
 * new buffer, and vice versa; the two buffers' position, limit, and mark values will be independent.
 * The new buffer's position will be zero, its capacity and its limit will be [size], and its mark will be undefined. 
 * The new buffer will be direct if, and only if, this buffer is direct, and it will be read-only if, and only if, this buffer is read-only.
 * @return The new byte buffer
 */
fun LongBuffer.sliceAs(offset: Int, size: Int = lim - offset): LongBuffer {
    val backupPos = pos
    val backupLim = lim
    pos = offset
    lim = offset + size
    val res = slice()
    pos = backupPos
    lim = backupLim
    return res
}
/**
 * The standard C free function.
 * A block of memory previously allocated by a call to `memAlloc`, `memCalloc` or `memRealloc` is deallocated, making it available again for further allocations.
 */
inline fun LongBuffer.free() = MemoryUtil.memFree(this)
/**
 * Returns the memory address at the current position of the buffer. This is effectively a pointer value that can be used in native function calls.
 * @return the memory address
 */
inline val LongBuffer.adr: Adr
    get() = MemoryUtil.memAddress(this).toULong()
/**
 * This buffer's position.
 * When assigning it, if the mark is defined and larger than the new position then it is discarded.
 */
inline var LongBuffer.pos: Int
    get() = position()
    set(value) { position(value) }
/** Returns this buffer's capacity. */
inline val LongBuffer.cap: Int
    get() = capacity()
/**
 * Returns the number of elements between the current position and the limit.
 * @return The number of elements remaining in this buffer
 */
inline val LongBuffer.rem: Int
    get() = remaining()
/** Returns the total size in Bytes between the current position and the limit. */
inline val LongBuffer.remByte: Int
    get() = rem * Long.BYTES
/**
 * This buffer's limit.
 * When assigning it, if the position is larger than the new limit then it is set to the new limit. 
 * If the mark is defined and larger than the new limit then it is discarded.
 */
inline var LongBuffer.lim: Int
    get() = limit()
    set(value) { limit(value) }
/**
 * Absolute put method  (optional operation).
 * Writes the given uint into this buffer at the given index.
 * @param index The index at which the uint will be written
 * @param long The uint value to be written
 * @return This buffer
 * @throws IndexOutOfBoundsException If index is negative or not smaller than the buffer's limit
 * @throws ReadOnlyBufferException If this buffer is read-only
 */
operator fun LongBuffer.set(index: Int, long: Long): LongBuffer = put(index, long)
/**
 * Creates a new byte buffer whose content is a shared subsequence of this buffer's content.
 * The content of the new buffer will start at [offset]. Changes to this buffer's content will be visible in the
 * new buffer, and vice versa; the two buffers' position, limit, and mark values will be independent.
 * The new buffer's position will be zero, its capacity and its limit will be [size], and its mark will be undefined. 
 * The new buffer will be direct if, and only if, this buffer is direct, and it will be read-only if, and only if, this buffer is read-only.
 * @return The new byte buffer
 */
fun FloatBuffer.sliceAs(offset: Int, size: Int = lim - offset): FloatBuffer {
    val backupPos = pos
    val backupLim = lim
    pos = offset
    lim = offset + size
    val res = slice()
    pos = backupPos
    lim = backupLim
    return res
}
/**
 * The standard C free function.
 * A block of memory previously allocated by a call to `memAlloc`, `memCalloc` or `memRealloc` is deallocated, making it available again for further allocations.
 */
inline fun FloatBuffer.free() = MemoryUtil.memFree(this)
/**
 * Returns the memory address at the current position of the buffer. This is effectively a pointer value that can be used in native function calls.
 * @return the memory address
 */
inline val FloatBuffer.adr: Adr
    get() = MemoryUtil.memAddress(this).toULong()
/**
 * This buffer's position.
 * When assigning it, if the mark is defined and larger than the new position then it is discarded.
 */
inline var FloatBuffer.pos: Int
    get() = position()
    set(value) { position(value) }
/** Returns this buffer's capacity. */
inline val FloatBuffer.cap: Int
    get() = capacity()
/**
 * Returns the number of elements between the current position and the limit.
 * @return The number of elements remaining in this buffer
 */
inline val FloatBuffer.rem: Int
    get() = remaining()
/** Returns the total size in Bytes between the current position and the limit. */
inline val FloatBuffer.remByte: Int
    get() = rem * Float.BYTES
/**
 * This buffer's limit.
 * When assigning it, if the position is larger than the new limit then it is set to the new limit. 
 * If the mark is defined and larger than the new limit then it is discarded.
 */
inline var FloatBuffer.lim: Int
    get() = limit()
    set(value) { limit(value) }
/**
 * Absolute put method  (optional operation).
 * Writes the given uint into this buffer at the given index.
 * @param index The index at which the uint will be written
 * @param float The uint value to be written
 * @return This buffer
 * @throws IndexOutOfBoundsException If index is negative or not smaller than the buffer's limit
 * @throws ReadOnlyBufferException If this buffer is read-only
 */
operator fun FloatBuffer.set(index: Int, float: Float): FloatBuffer = put(index, float)
/**
 * Creates a new byte buffer whose content is a shared subsequence of this buffer's content.
 * The content of the new buffer will start at [offset]. Changes to this buffer's content will be visible in the
 * new buffer, and vice versa; the two buffers' position, limit, and mark values will be independent.
 * The new buffer's position will be zero, its capacity and its limit will be [size], and its mark will be undefined. 
 * The new buffer will be direct if, and only if, this buffer is direct, and it will be read-only if, and only if, this buffer is read-only.
 * @return The new byte buffer
 */
fun DoubleBuffer.sliceAs(offset: Int, size: Int = lim - offset): DoubleBuffer {
    val backupPos = pos
    val backupLim = lim
    pos = offset
    lim = offset + size
    val res = slice()
    pos = backupPos
    lim = backupLim
    return res
}
/**
 * The standard C free function.
 * A block of memory previously allocated by a call to `memAlloc`, `memCalloc` or `memRealloc` is deallocated, making it available again for further allocations.
 */
inline fun DoubleBuffer.free() = MemoryUtil.memFree(this)
/**
 * Returns the memory address at the current position of the buffer. This is effectively a pointer value that can be used in native function calls.
 * @return the memory address
 */
inline val DoubleBuffer.adr: Adr
    get() = MemoryUtil.memAddress(this).toULong()
/**
 * This buffer's position.
 * When assigning it, if the mark is defined and larger than the new position then it is discarded.
 */
inline var DoubleBuffer.pos: Int
    get() = position()
    set(value) { position(value) }
/** Returns this buffer's capacity. */
inline val DoubleBuffer.cap: Int
    get() = capacity()
/**
 * Returns the number of elements between the current position and the limit.
 * @return The number of elements remaining in this buffer
 */
inline val DoubleBuffer.rem: Int
    get() = remaining()
/** Returns the total size in Bytes between the current position and the limit. */
inline val DoubleBuffer.remByte: Int
    get() = rem * Double.BYTES
/**
 * This buffer's limit.
 * When assigning it, if the position is larger than the new limit then it is set to the new limit. 
 * If the mark is defined and larger than the new limit then it is discarded.
 */
inline var DoubleBuffer.lim: Int
    get() = limit()
    set(value) { limit(value) }
/**
 * Absolute put method  (optional operation).
 * Writes the given uint into this buffer at the given index.
 * @param index The index at which the uint will be written
 * @param double The uint value to be written
 * @return This buffer
 * @throws IndexOutOfBoundsException If index is negative or not smaller than the buffer's limit
 * @throws ReadOnlyBufferException If this buffer is read-only
 */
operator fun DoubleBuffer.set(index: Int, double: Double): DoubleBuffer = put(index, double)
/**
 * Creates a new byte buffer whose content is a shared subsequence of this buffer's content.
 * The content of the new buffer will start at [offset]. Changes to this buffer's content will be visible in the
 * new buffer, and vice versa; the two buffers' position, limit, and mark values will be independent.
 * The new buffer's position will be zero, its capacity and its limit will be [size], and its mark will be undefined. 
 * The new buffer will be direct if, and only if, this buffer is direct, and it will be read-only if, and only if, this buffer is read-only.
 * @return The new byte buffer
 */
fun PointerBuffer.sliceAs(offset: Int, size: Int = lim - offset): PointerBuffer {
    val backupPos = pos
    val backupLim = lim
    pos = offset
    lim = offset + size
    val res = slice()
    pos = backupPos
    lim = backupLim
    return res
}
/**
 * The standard C free function.
 * A block of memory previously allocated by a call to `memAlloc`, `memCalloc` or `memRealloc` is deallocated, making it available again for further allocations.
 */
/**
 * Returns the memory address at the current position of the buffer. This is effectively a pointer value that can be used in native function calls.
 * @return the memory address
 */
inline val PointerBuffer.adr: Adr
    get() = MemoryUtil.memAddress(this).toULong()
/**
 * This buffer's position.
 * When assigning it, if the mark is defined and larger than the new position then it is discarded.
 */
inline var PointerBuffer.pos: Int
    get() = position()
    set(value) { position(value) }
/** Returns this buffer's capacity. */
inline val PointerBuffer.cap: Int
    get() = capacity()
/**
 * Returns the number of elements between the current position and the limit.
 * @return The number of elements remaining in this buffer
 */
inline val PointerBuffer.rem: Int
    get() = remaining()
/** Returns the total size in Bytes between the current position and the limit. */
inline val PointerBuffer.remByte: Int
    get() = rem * org.lwjgl.system.Pointer.POINTER_SIZE
/**
 * This buffer's limit.
 * When assigning it, if the position is larger than the new limit then it is set to the new limit. 
 * If the mark is defined and larger than the new limit then it is discarded.
 */
inline var PointerBuffer.lim: Int
    get() = limit()
    set(value) { limit(value) }
/**
 * Absolute put method  (optional operation).
 * Writes the given uint into this buffer at the given index.
 * @param index The index at which the uint will be written
 * @param pointer The uint value to be written
 * @return This buffer
 * @throws IndexOutOfBoundsException If index is negative or not smaller than the buffer's limit
 * @throws ReadOnlyBufferException If this buffer is read-only
 */
/**
 * Absolute put method  (optional operation).
 * Writes the given uint into this buffer at the given index.
 * @param index The index at which the uint will be written
 * @param pointer The uint value to be written
 * @return This buffer
 * @throws IndexOutOfBoundsException If index is negative or not smaller than the buffer's limit
 * @throws ReadOnlyBufferException If this buffer is read-only
 */
operator fun PointerBuffer.set(index: Int, pointer: org.lwjgl.system.Pointer): PointerBuffer = put(index, pointer)
/**
 * Absolute put method  (optional operation).
 * Writes the given uint into this buffer at the given index.
 * @param index The index at which the uint will be written
 * @param pointer The uint value to be written
 * @return This buffer
 * @throws IndexOutOfBoundsException If index is negative or not smaller than the buffer's limit
 * @throws ReadOnlyBufferException If this buffer is read-only
 */
operator fun PointerBuffer.set(index: Int, pointer: Pointer): PointerBuffer = put(index, pointer.toLong())
/**
 * Absolute put method  (optional operation).
 * Writes the given uint into this buffer at the given index.
 * @param index The index at which the uint will be written
 * @param pointer The uint value to be written
 * @return This buffer
 * @throws IndexOutOfBoundsException If index is negative or not smaller than the buffer's limit
 * @throws ReadOnlyBufferException If this buffer is read-only
 */
operator fun PointerBuffer.set(index: Int, buffer: Buffer): PointerBuffer = put(index, buffer.adr.toLong())
/**
 * Absolute put method  (optional operation).
 * Writes the given uint into this buffer at the given index.
 * @param index The index at which the uint will be written
 * @param pointer The uint value to be written
 * @return This buffer
 * @throws IndexOutOfBoundsException If index is negative or not smaller than the buffer's limit
 * @throws ReadOnlyBufferException If this buffer is read-only
 */
operator fun PointerBuffer.set(index: Int, pointer: Long): PointerBuffer = put(index, pointer)
