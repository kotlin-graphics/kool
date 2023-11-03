@file:Suppress("NOTHING_TO_INLINE")
@file:OptIn(kotlin.experimental.ExperimentalTypeInference::class, kotlin.ExperimentalUnsignedTypes::class)
package kool.ubuffers
import kool.ubuffers.UByteBuffer
import kool.isEmpty
import kool.sliceAs
import kool.BYTES
import java.nio.ByteOrder
import kool.lastIndex
import kool.rem
import java.nio.ByteBuffer
import kool.free
import kool.iterator
import kool.cap
import kool.pos
import kool.forEachIndexed
import kool.adr
import kool.Adr

@JvmInline
value class UByteBuffer(val buffer: ByteBuffer) {
	/**
	 * Relative get method. Reads the ubyte at this buffer's current position, and then increments the position.
	 * @return The ubyte at the buffer's current position
	 * @throws `BufferUnderflowException` If the buffer's current position is not smaller than its limit
	 */
	fun get(): UByte = buffer.get().toUByte()
	/**
	 * Absolute get method. Reads the ubyte at the given index.
	 * @param index The index from which the ubyte will be read
	 * @return The ubyte at the given index
	 * @throws `IndexOutOfBoundsException` If index is negative or not smaller than the buffer's limit
	 */
	infix operator fun get(index: Int): UByte = buffer[index].toUByte()
	/**
	 * Relative bulk get method.
	 * This method transfers ubytes from this buffer into the given destination array. An invocation of this method 
	 * of the form `src.get(a)` behaves in exactly the same way as the invocation
	 *     `src.get(a, 0, a.length)`
	 * @param dst The destination array
	 * @return This buffer
	 * @throws `BufferUnderflowException` If there are fewer than length ubytes remaining in this buffer
	 */
	infix operator fun get(array: UByteArray): UByteBuffer = UByteBuffer(buffer[array.asByteArray()])
	/**
	 * Relative bulk get method.
	 * This method transfers ubytes from this buffer into the given destination array. If there are fewer ubytes
	 * remaining in the buffer than are required to satisfy the request, that is, if `length > remaining`, then no
	 * ubytes are transferred and a `BufferUnderflowException` is thrown.
	 * Otherwise, this method copies length ubytes from this buffer into the given array, starting at the current
	 * position of this buffer and at the given offset in the array.
	 * The position of this buffer is then incremented by length.
	 * In other words, an invocation of this method of the form `src.get(dst, off, len)` has exactly the same 
	 * effect as the loop
	 * ```
	 * for (i in off until off + len)
	 *     dst[i] = src.get()
	 * ```
	 * except that it first checks that there are sufficient ubytes in this buffer and it is potentially much more efficient.
	 * @param dst The array into which ubytes are to be written
	 * @param offset The offset within the array of the first ubyte to be written; must be non-negative and no larger than `dst.length`
	 * @param length The maximum number of ubytes to be written to the given array; must be non-negative and no larger than `dst.length - offset`
	 * @return This buffer
	 * @throws `BufferUnderflowException` If there are fewer than length ubytes remaining in this buffer
	 * @throws `IndexOutOfBoundsException` If the preconditions on the offset and length parameters do not hold
	 */
	operator fun get(dst: UByteArray, offset: Int, length: Int): UByteBuffer = UByteBuffer(buffer[dst.toByteArray(), offset, length])
	/**
	 * Absolute get method for reading a char value.
	 * Reads two bytes at the given index, composing them into a char value according to the current byte order.
	 * @param index The index from which the bytes will be read
	 * @return The char value at the given index
	 * @throws `IndexOutOfBoundsException` If index is negative or not smaller than the buffer's limit, minus one
	 */
	infix fun getChar(index: Int): Char = buffer.getChar(index)
	/**
	 * Relative get method for reading/writing a char value.
	 * Reads the next two bytes at this buffer's current position, composing them into a char value according to the
	 * current byte order, and then increments the position by two.
	 * Returns: The char value at the buffer's current position
	 * Throws: `BufferUnderflowException` If there are fewer than two bytes remaining in this buffer
	 * 
	 * Writes two bytes containing the given char value, in the current byte order, into this buffer at the current position, 
	 * and then increments the position by two.
	 * Parameters:
	 *  - value, The char value to be written
	 * Returns: This buffer
	 * Throws:
	 *     `BufferOverflowException` If there are fewer than two bytes remaining in this buffer
	 *     `ReadOnlyBufferException` If this buffer is read-only
	 */
	var char: Char
		get() = buffer.char
		set(value) { buffer.putChar(value) }
	/**
	 * Absolute put method for writing a char value  (optional operation).
	 * Writes two bytes containing the given char value, in the current byte order, into this buffer at the given index.
	 * @param index The index at which the bytes will be written
	 * @param value The char value to be written
	 * @return This buffer
	 * @throws `IndexOutOfBoundsException` If index is negative or not smaller than the buffer's limit, minus one
	 * @throws `ReadOnlyBufferException` - If this buffer is read-only
	 */
	fun putChar(index: Int, value: Char): UByteBuffer = buffer.putChar(index, value).asUByteBuffer()
	/**
	 * Absolute get method for reading a short value.
	 * Reads two bytes at the given index, composing them into a short value according to the current byte order.
	 * @param index The index from which the bytes will be read
	 * @return The short value at the given index
	 * @throws `IndexOutOfBoundsException` If index is negative or not smaller than the buffer's limit, minus one
	 */
	infix fun getShort(index: Int): Short = buffer.getShort(index)
	/**
	 * Absolute get method for reading an ushort value.
	 * Reads two bytes at the given index, composing them into an ushort value according to the current byte order.
	 * @param index The index from which the bytes will be read
	 * @return The ushort value at the given index
	 * @throws `IndexOutOfBoundsException` If index is negative or not smaller than the buffer's limit, minus one
	 */
	infix fun getUShort(index: Int): UShort = buffer.getShort(index).toUShort()
	/**
	 * Relative get method for reading/writing a short value.
	 * Reads the next two bytes at this buffer's current position, composing them into a short value according to the
	 * current byte order, and then increments the position by two.
	 * Returns: The short value at the buffer's current position
	 * Throws: `BufferUnderflowException` If there are fewer than two bytes remaining in this buffer
	 * 
	 * Writes two bytes containing the given short value, in the current byte order, into this buffer at the current position, 
	 * and then increments the position by two.
	 * Parameters:
	 *  - value, The short value to be written
	 * Returns: This buffer
	 * Throws:
	 *     `BufferOverflowException` If there are fewer than two bytes remaining in this buffer
	 *     `ReadOnlyBufferException` If this buffer is read-only
	 */
	var short: Short
		get() = buffer.short
		set(value) { buffer.putShort(value) }
	/**
	 * Relative get method for reading an ushort value.
	 * Reads the next two bytes at this buffer's current position, composing them into an ushort value according to the
	 * current byte order, and then increments the position by two.
	 * Returns: The short value at the buffer's current position
	 * Throws: `BufferUnderflowException` If there are fewer than two bytes remaining in this buffer
	 * 
	 * Writes two bytes containing the given ushort value, in the current byte order, into this buffer at the current position, 
	 * and then increments the position by two.
	 * Parameters:
	 *  - value, The ushort value to be written
	 * Returns: This buffer
	 * Throws:
	 *     `BufferOverflowException` If there are fewer than two bytes remaining in this buffer
	 *     `ReadOnlyBufferException` If this buffer is read-only
	 */
	var ushort: UShort
		get() = buffer.short.toUShort()
		set(value) { buffer.putShort(value.toShort()) }
	/**
	 * Absolute put method for writing a short value  (optional operation).
	 * Writes two bytes containing the given short value, in the current byte order, into this buffer at the given index.
	 * @param index The index at which the bytes will be written
	 * @param value The short value to be written
	 * @return This buffer
	 * @throws `IndexOutOfBoundsException` If index is negative or not smaller than the buffer's limit, minus one
	 * @throws `ReadOnlyBufferException` - If this buffer is read-only
	 */
	fun putShort(index: Int, value: Short): UByteBuffer = buffer.putShort(index, value).asUByteBuffer()
	/**
	 * Absolute put method for writing an ushort value  (optional operation).
	 * Writes two bytes containing the given ushort value, in the current byte order, into this buffer at the given index.
	 * @param index The index at which the bytes will be written
	 * @param value The ushort value to be written
	 * @return This buffer
	 * @throws `IndexOutOfBoundsException` If index is negative or not smaller than the buffer's limit, minus one
	 * @throws `ReadOnlyBufferException` - If this buffer is read-only
	 */
	fun putUShort(index: Int, value: UShort): UByteBuffer = buffer.putShort(index, value.toShort()).asUByteBuffer()
	/**
	 * Absolute get method for reading an int value.
	 * Reads four bytes at the given index, composing them into an int value according to the current byte order.
	 * @param index The index from which the bytes will be read
	 * @return The int value at the given index
	 * @throws `IndexOutOfBoundsException` If index is negative or not smaller than the buffer's limit, minus one
	 */
	infix fun getInt(index: Int): Int = buffer.getInt(index)
	/**
	 * Absolute get method for reading an uint value.
	 * Reads four bytes at the given index, composing them into an uint value according to the current byte order.
	 * @param index The index from which the bytes will be read
	 * @return The uint value at the given index
	 * @throws `IndexOutOfBoundsException` If index is negative or not smaller than the buffer's limit, minus one
	 */
	infix fun getUInt(index: Int): UInt = buffer.getInt(index).toUInt()
	/**
	 * Relative get method for reading/writing an int value.
	 * Reads the next four bytes at this buffer's current position, composing them into an int value according to the
	 * current byte order, and then increments the position by four.
	 * Returns: The int value at the buffer's current position
	 * Throws: `BufferUnderflowException` If there are fewer than four bytes remaining in this buffer
	 * 
	 * Writes four bytes containing the given int value, in the current byte order, into this buffer at the current position, 
	 * and then increments the position by four.
	 * Parameters:
	 *  - value, The int value to be written
	 * Returns: This buffer
	 * Throws:
	 *     `BufferOverflowException` If there are fewer than four bytes remaining in this buffer
	 *     `ReadOnlyBufferException` If this buffer is read-only
	 */
	var int: Int
		get() = buffer.int
		set(value) { buffer.putInt(value) }
	/**
	 * Relative get method for reading an uint value.
	 * Reads the next four bytes at this buffer's current position, composing them into an uint value according to the
	 * current byte order, and then increments the position by four.
	 * Returns: The int value at the buffer's current position
	 * Throws: `BufferUnderflowException` If there are fewer than four bytes remaining in this buffer
	 * 
	 * Writes four bytes containing the given uint value, in the current byte order, into this buffer at the current position, 
	 * and then increments the position by four.
	 * Parameters:
	 *  - value, The uint value to be written
	 * Returns: This buffer
	 * Throws:
	 *     `BufferOverflowException` If there are fewer than four bytes remaining in this buffer
	 *     `ReadOnlyBufferException` If this buffer is read-only
	 */
	var uint: UInt
		get() = buffer.int.toUInt()
		set(value) { buffer.putInt(value.toInt()) }
	/**
	 * Absolute put method for writing an int value  (optional operation).
	 * Writes four bytes containing the given int value, in the current byte order, into this buffer at the given index.
	 * @param index The index at which the bytes will be written
	 * @param value The int value to be written
	 * @return This buffer
	 * @throws `IndexOutOfBoundsException` If index is negative or not smaller than the buffer's limit, minus one
	 * @throws `ReadOnlyBufferException` - If this buffer is read-only
	 */
	fun putInt(index: Int, value: Int): UByteBuffer = buffer.putInt(index, value).asUByteBuffer()
	/**
	 * Absolute put method for writing an uint value  (optional operation).
	 * Writes four bytes containing the given uint value, in the current byte order, into this buffer at the given index.
	 * @param index The index at which the bytes will be written
	 * @param value The uint value to be written
	 * @return This buffer
	 * @throws `IndexOutOfBoundsException` If index is negative or not smaller than the buffer's limit, minus one
	 * @throws `ReadOnlyBufferException` - If this buffer is read-only
	 */
	fun putUInt(index: Int, value: UInt): UByteBuffer = buffer.putInt(index, value.toInt()).asUByteBuffer()
	/**
	 * Absolute get method for reading a long value.
	 * Reads eight bytes at the given index, composing them into a long value according to the current byte order.
	 * @param index The index from which the bytes will be read
	 * @return The long value at the given index
	 * @throws `IndexOutOfBoundsException` If index is negative or not smaller than the buffer's limit, minus one
	 */
	infix fun getLong(index: Int): Long = buffer.getLong(index)
	/**
	 * Absolute get method for reading an ulong value.
	 * Reads eight bytes at the given index, composing them into an ulong value according to the current byte order.
	 * @param index The index from which the bytes will be read
	 * @return The ulong value at the given index
	 * @throws `IndexOutOfBoundsException` If index is negative or not smaller than the buffer's limit, minus one
	 */
	infix fun getULong(index: Int): ULong = buffer.getLong(index).toULong()
	/**
	 * Relative get method for reading/writing a long value.
	 * Reads the next eight bytes at this buffer's current position, composing them into a long value according to the
	 * current byte order, and then increments the position by eight.
	 * Returns: The long value at the buffer's current position
	 * Throws: `BufferUnderflowException` If there are fewer than eight bytes remaining in this buffer
	 * 
	 * Writes eight bytes containing the given long value, in the current byte order, into this buffer at the current position, 
	 * and then increments the position by eight.
	 * Parameters:
	 *  - value, The long value to be written
	 * Returns: This buffer
	 * Throws:
	 *     `BufferOverflowException` If there are fewer than eight bytes remaining in this buffer
	 *     `ReadOnlyBufferException` If this buffer is read-only
	 */
	var long: Long
		get() = buffer.long
		set(value) { buffer.putLong(value) }
	/**
	 * Relative get method for reading an ulong value.
	 * Reads the next eight bytes at this buffer's current position, composing them into an ulong value according to the
	 * current byte order, and then increments the position by eight.
	 * Returns: The long value at the buffer's current position
	 * Throws: `BufferUnderflowException` If there are fewer than eight bytes remaining in this buffer
	 * 
	 * Writes eight bytes containing the given ulong value, in the current byte order, into this buffer at the current position, 
	 * and then increments the position by eight.
	 * Parameters:
	 *  - value, The ulong value to be written
	 * Returns: This buffer
	 * Throws:
	 *     `BufferOverflowException` If there are fewer than eight bytes remaining in this buffer
	 *     `ReadOnlyBufferException` If this buffer is read-only
	 */
	var ulong: ULong
		get() = buffer.long.toULong()
		set(value) { buffer.putLong(value.toLong()) }
	/**
	 * Absolute put method for writing a long value  (optional operation).
	 * Writes eight bytes containing the given long value, in the current byte order, into this buffer at the given index.
	 * @param index The index at which the bytes will be written
	 * @param value The long value to be written
	 * @return This buffer
	 * @throws `IndexOutOfBoundsException` If index is negative or not smaller than the buffer's limit, minus one
	 * @throws `ReadOnlyBufferException` - If this buffer is read-only
	 */
	fun putLong(index: Int, value: Long): UByteBuffer = buffer.putLong(index, value).asUByteBuffer()
	/**
	 * Absolute put method for writing an ulong value  (optional operation).
	 * Writes eight bytes containing the given ulong value, in the current byte order, into this buffer at the given index.
	 * @param index The index at which the bytes will be written
	 * @param value The ulong value to be written
	 * @return This buffer
	 * @throws `IndexOutOfBoundsException` If index is negative or not smaller than the buffer's limit, minus one
	 * @throws `ReadOnlyBufferException` - If this buffer is read-only
	 */
	fun putULong(index: Int, value: ULong): UByteBuffer = buffer.putLong(index, value.toLong()).asUByteBuffer()
	/**
	 * Absolute get method for reading a float value.
	 * Reads four bytes at the given index, composing them into a float value according to the current byte order.
	 * @param index The index from which the bytes will be read
	 * @return The float value at the given index
	 * @throws `IndexOutOfBoundsException` If index is negative or not smaller than the buffer's limit, minus one
	 */
	infix fun getFloat(index: Int): Float = buffer.getFloat(index)
	/**
	 * Relative get method for reading/writing a float value.
	 * Reads the next four bytes at this buffer's current position, composing them into a float value according to the
	 * current byte order, and then increments the position by four.
	 * Returns: The float value at the buffer's current position
	 * Throws: `BufferUnderflowException` If there are fewer than four bytes remaining in this buffer
	 * 
	 * Writes four bytes containing the given float value, in the current byte order, into this buffer at the current position, 
	 * and then increments the position by four.
	 * Parameters:
	 *  - value, The float value to be written
	 * Returns: This buffer
	 * Throws:
	 *     `BufferOverflowException` If there are fewer than four bytes remaining in this buffer
	 *     `ReadOnlyBufferException` If this buffer is read-only
	 */
	var float: Float
		get() = buffer.float
		set(value) { buffer.putFloat(value) }
	/**
	 * Absolute put method for writing a float value  (optional operation).
	 * Writes four bytes containing the given float value, in the current byte order, into this buffer at the given index.
	 * @param index The index at which the bytes will be written
	 * @param value The float value to be written
	 * @return This buffer
	 * @throws `IndexOutOfBoundsException` If index is negative or not smaller than the buffer's limit, minus one
	 * @throws `ReadOnlyBufferException` - If this buffer is read-only
	 */
	fun putFloat(index: Int, value: Float): UByteBuffer = buffer.putFloat(index, value).asUByteBuffer()
	/**
	 * Absolute get method for reading a double value.
	 * Reads eight bytes at the given index, composing them into a double value according to the current byte order.
	 * @param index The index from which the bytes will be read
	 * @return The double value at the given index
	 * @throws `IndexOutOfBoundsException` If index is negative or not smaller than the buffer's limit, minus one
	 */
	infix fun getDouble(index: Int): Double = buffer.getDouble(index)
	/**
	 * Relative get method for reading/writing a double value.
	 * Reads the next eight bytes at this buffer's current position, composing them into a double value according to the
	 * current byte order, and then increments the position by eight.
	 * Returns: The double value at the buffer's current position
	 * Throws: `BufferUnderflowException` If there are fewer than eight bytes remaining in this buffer
	 * 
	 * Writes eight bytes containing the given double value, in the current byte order, into this buffer at the current position, 
	 * and then increments the position by eight.
	 * Parameters:
	 *  - value, The double value to be written
	 * Returns: This buffer
	 * Throws:
	 *     `BufferOverflowException` If there are fewer than eight bytes remaining in this buffer
	 *     `ReadOnlyBufferException` If this buffer is read-only
	 */
	var double: Double
		get() = buffer.double
		set(value) { buffer.putDouble(value) }
	/**
	 * Absolute put method for writing a double value  (optional operation).
	 * Writes eight bytes containing the given double value, in the current byte order, into this buffer at the given index.
	 * @param index The index at which the bytes will be written
	 * @param value The double value to be written
	 * @return This buffer
	 * @throws `IndexOutOfBoundsException` If index is negative or not smaller than the buffer's limit, minus one
	 * @throws `ReadOnlyBufferException` - If this buffer is read-only
	 */
	fun putDouble(index: Int, value: Double): UByteBuffer = buffer.putDouble(index, value).asUByteBuffer()
	/**
	 * Compacts this buffer  (optional operation).
	 * The ubytes between the buffer's current position and its limit, if any, are copied to the beginning of the buffer.
	 * That is, the ubyte at index `p = position` is copied to index zero, the ubyte at index `p + 1` is copied to index
	 * one, and so forth until the ubyte at index `limit - 1` is copied to index `n = limit - 1 - p`.
	 * The buffer's position is then set to `n+1` and its limit is set to its capacity. The mark, if defined, is discarded.
	 * The buffer's position is set to the number of ubytes copied, rather than to zero, so that an invocation of this
	 * method can be followed immediately by an invocation of another relative put method.
	 * @return This buffer
	 * @throws `ReadOnlyBufferException` If this buffer is read-only
	 */
	fun compact(): UByteBuffer = UByteBuffer(buffer.compact())
	/**
	 * Creates a new ubyte buffer that shares this buffer's content.
	 * The content of the new buffer will be that of this buffer. Changes to this buffer's content will be visible in
	 * the new buffer, and vice versa; the two buffers' position, limit, and mark values will be independent.
	 * The new buffer's capacity, limit, position, and mark values will be identical to those of this buffer.
	 * The new buffer will be direct if, and only if, this buffer is direct, and it will be read-only if, and only if,
	 * this buffer is read-only.
	 * @return The new ubyte buffer
	 */
	fun duplicate(): UByteBuffer = UByteBuffer(buffer.duplicate())
	/**
	 * Retrieves this buffer's byte order.
	 * The byte order of an ubyte buffer created by allocation or by wrapping an existing ubyte array is the native order
	 * of the underlying hardware. The byte order of an ubyte buffer created as a view of an ubyte buffer is that of the
	 * ubyte buffer at the moment that the view is created.
	 * @return This buffer's byte order
	 */
	val order: ByteOrder
		get() = buffer.order()
	/**
	 * Relative put method  (optional operation).
	 * Writes the given ubyte into this buffer at the current position, and then increments the position.
	 * @param uByte The ubyte to be written
	 * @return This buffer
	 * @throws `BufferOverflowException` If this buffer's current position is not smaller than its limit
	 * @throws `ReadOnlyBufferException` If this buffer is read-only
	 */
	infix fun put(uByte: UByte): UByteBuffer = UByteBuffer(buffer.put(uByte.toByte()))
	/**
	 * Absolute put method  (optional operation).
	 * Writes the given ubyte into this buffer at the given index.
	 * @param index The index at which the ubyte will be written
	 * @param uByte The ubyte value to be written
	 * @return This buffer
	 * @throws `IndexOutOfBoundsException` If index is negative or not smaller than the buffer's limit
	 * @throws `ReadOnlyBufferException` If this buffer is read-only
	 */
	fun put(index: Int, uByte: UByte): UByteBuffer = UByteBuffer(buffer.put(index, uByte.toByte()))
	/**
	 * Relative bulk put method  (optional operation).
	 * This method transfers the entire content of the given source ubyte array into this buffer. An invocation of this
	 * method of the form `dst.put(a)` behaves in exactly the same way as the invocation
	 *      `dst.put(a, 0, a.length)`
	 * @param src The source array
	 * @return This buffer
	 * @throws `BufferOverflowException` If there is insufficient space in this buffer
	 * @throws `ReadOnlyBufferException` If this buffer is read-only
	 */
	infix fun put(src: UByteArray): UByteBuffer = UByteBuffer(buffer.put(src.toByteArray()))
	/**
	 * Relative bulk put method  (optional operation).
	 * This method transfers the ubytes remaining in the given source buffer into this buffer. If there are more ubytes
	 * remaining in the source buffer than in this buffer, that is, if `src.remaining > remaining`, then no ubytes are
	 * transferred and a `BufferOverflowException` is thrown.
	 * Otherwise, this method copies `n = src.remaining` ubytes from the given buffer into this buffer, starting at each
	 * buffer's current position. The positions of both buffers are then incremented by `n`.
	 * In other words, an invocation of this method of the form `dst.put(src)` has exactly the same effect as the loop
	 * ```
	 *      while (src.hasRemaining)
	 *          dst.put(src.get());
	 * ```
	 * except that it first checks that there is sufficient space in this buffer and it is potentially much more efficient.
	 * @param src The source buffer from which ubytes are to be read; must not be this buffer
	 * @return This buffer
	 * @throws `BufferOverflowException` If there is insufficient space in this buffer for the remaining ubytes in the source buffer
	 * @throws `IllegalArgumentException` If the source buffer is this buffer
	 * @throws `ReadOnlyBufferException` If this buffer is read-only
	 */
	infix fun put(src: UByteBuffer): UByteBuffer = UByteBuffer(buffer.put(src.buffer))
	/**
	 * Relative bulk put method  (optional operation).
	 * This method transfers ubytes into this buffer from the given source array. If there are more ubytes to be copied
	 * from the array than remain in this buffer, that is, if `length > remaining`, then no ubytes are transferred and
	 * a `BufferOverflowException` is thrown.
	 * Otherwise, this method copies length ubytes from the given array into this buffer, starting at the given offset in
	 * the array and at the current position of this buffer. The position of this buffer is then incremented by length.
	 * In other words, an invocation of this method of the form `dst.put(src, off, len)` has exactly the same effect as
	 * the loop
	 * ```
	 *      for (i in off until off + len)
	 *          dst.put(a[i])
	 * ``
	 * except that it first checks that there is sufficient space in this buffer and it is potentially much more efficient.
	 * @param src The array from which ubytes are to be read
	 * @param offset The offset within the array of the first ubyte to be read; must be non-negative and no larger than `array.length`
	 * @param length The number of ubytes to be read from the given array; must be non-negative and no larger than `array.length - offset`
	 * @return This buffer
	 * @throws `BufferOverflowException` If there is insufficient space in this buffer
	 * @throws `IndexOutOfBoundsException` If the preconditions on the offset and length parameters do not hold
	 * @throws `ReadOnlyBufferException` If this buffer is read-only
	 */
	fun put(src: UByteArray, offset: Int, length: Int): UByteBuffer = UByteBuffer(buffer.put(src.toByteArray(), offset, length))
	/**
	 * Creates a new, read-only ubyte buffer that shares this buffer's content.
	 * The content of the new buffer will be that of this buffer. Changes to this buffer's content will be visible in
	 * the new buffer; the new buffer itself, however, will be read-only and will not allow the shared content to be
	 * modified. The two buffers' position, limit, and mark values will be independent.
	 * The new buffer's capacity, limit, position, and mark values will be identical to those of this buffer.
	 * If this buffer is itself read-only then this method behaves in exactly the same way as the duplicate method.
	 * @return The new, read-only ubyte buffer
	 */
	fun asReadOnlyBuffer(): UByteBuffer = UByteBuffer(buffer.asReadOnlyBuffer())
	/**
	 * Creates a new ubyte buffer whose content is a shared subsequence of this buffer's content.
	 * The content of the new buffer will start at this buffer's current position. Changes to this buffer's content will
	 * be visible in the new buffer, and vice versa; the two buffers' position, limit, and mark values will be independent.
	 * The new buffer's position will be zero, its capacity and its limit will be the number of ubytes remaining in this
	 * buffer, and its mark will be undefined. The new buffer will be direct if, and only if, this buffer is direct,
	 * and it will be read-only if, and only if, this buffer is read-only.
	 * @return The new ubyte buffer
	 */
	fun slice(): UByteBuffer = UByteBuffer(buffer.slice())
	/**
	 * Tells whether or not this buffer is read-only.
	 * @return `true` if, and only if, this buffer is read-only
	 */
	fun isReadOnly(): Boolean = buffer.isReadOnly()
	/**
	 * Tells whether or not this buffer is backed by an accessible byte array.
	 * If this method returns true then the array and arrayOffset methods may safely be invoked.
	 * Specified by:
	 *     `hasArray` in class `Buffer`
	 * @return `true` if, and only if, this buffer is backed by an array and is not read-only
	 */
	fun hasArray(): Boolean = buffer.hasArray()
	/**
	 * Returns the byte array that backs this buffer  (optional operation).
	 * Modifications to this buffer's content will cause the returned array's content to be modified, and vice versa.
	 * Invoke the hasArray method before invoking this method in order to ensure that this buffer has an accessible backing array.
	 * Specified by:
	 *     `array` in class `Buffer`
	 * @return The array that backs this buffer
	 * @throws `ReadOnlyBufferException` If this buffer is backed by an array but is read-only
	 * @throws `UnsupportedOperationException` If this buffer is not backed by an accessible array
	 */
	fun array(): Any = buffer.array()
	/**
	 * Returns the offset within this buffer's backing array of the first element of the buffer  (optional operation).
	 * If this buffer is backed by an array then buffer position p corresponds to array index p + arrayOffset().
	 * Invoke the hasArray method before invoking this method in order to ensure that this buffer has an accessible backing array.
	 * Specified by:
	 *     `arrayOffset` in class `Buffer`
	 * @return The offset within this buffer's array of the first element of the buffer
	 * @throws `ReadOnlyBufferException` If this buffer is backed by an array but is read-only
	 * @throws `UnsupportedOperationException` If this buffer is not backed by an accessible array
	 */
	fun arrayOffset(): Int = buffer.arrayOffset()
	/**
	 * Tells whether or not this byte buffer is direct.
	 * Specified by:
	 *     `isDirect` in class `Buffer`
	 * @return `true` if, and only if, this buffer is direct
	 */
	fun isDirect(): Boolean = buffer.isDirect()
	/**
	 * Creates a new byte buffer whose content is a shared subsequence of this buffer's content.
	 * The content of the new buffer will start at [offset]. Changes to this buffer's content will be visible in the
	 * new buffer, and vice versa; the two buffers' position, limit, and mark values will be independent.
	 * The new buffer's position will be zero, its capacity and its limit will be [size], and its mark will be undefined. 
	 * The new buffer will be direct if, and only if, this buffer is direct, and it will be read-only if, and only if, this buffer is read-only.
	 * @return The new byte buffer
	 */
	fun sliceAs(offset: Int, size: Int = lim - offset): UByteBuffer = UByteBuffer(buffer.sliceAs(offset, size))
	/**
	 * The standard C free function.
	 * A block of memory previously allocated by a call to `memAlloc`, `memCalloc` or `memRealloc` is deallocated, making it available again for further allocations.
	 */
	inline fun free() = buffer.free()
	/**
	 * Returns the memory address at the current position of the buffer. This is effectively a pointer value that can be used in native function calls.
	 * @return the memory address
	 */
	inline val adr: Adr
	    get() = buffer.adr
	/**
	 * This buffer's position.
	 * When assigning it, if the mark is defined and larger than the new position then it is discarded.
	 */
	inline var pos: Int
	    get() = buffer.pos
	    set(value) { buffer.pos = value }
	/** Returns this buffer's capacity. */
	inline val cap: Int
	    get() = buffer.cap
	/**
	 * Returns the number of elements between the current position and the limit.
	 * @return The number of elements remaining in this buffer
	 */
	inline val rem: Int
	    get() = buffer.rem
	/** Returns the total size in Bytes between the current position and the limit. */
	inline val remByte: Int
	    get() = rem * UByte.BYTES
	/**
	 * This buffer's limit.
	 * When assigning it, if the position is larger than the new limit then it is set to the new limit. 
	 * If the mark is defined and larger than the new limit then it is discarded.
	 */
	inline var lim: Int
	    get() = buffer.limit()
	    set(value) { buffer.limit(value) }
	/**
	 * Absolute put method  (optional operation).
	 * Writes the given uint into this buffer at the given index.
	 * @param index The index at which the uint will be written
	 * @param uByte The uint value to be written
	 * @return This buffer
	 * @throws IndexOutOfBoundsException If index is negative or not smaller than the buffer's limit
	 * @throws ReadOnlyBufferException If this buffer is read-only
	 */
	operator fun set(index: Int, uByte: UByte): UByteBuffer = put(index, uByte)
	/** Returns a single list of all elements yielded from results of [transform] function being invoked on each element and its index in the original array. */
	inline fun <R> flatMapIndexed(transform: (index: Int, UByte) -> Iterable<R>): List<R> = flatMapIndexedTo(ArrayList<R>(), transform)
	/** Appends all elements yielded from results of [transform] function being invoked on each element and its index in the original array, to the given [destination]. */
	inline fun <R, C : MutableCollection<in R>> flatMapIndexedTo(destination: C, transform: (index: Int, UByte) -> Iterable<R>): C {
	    var index = 0
	    for (element in this) {
	        val list = transform(index++, element)
	        destination.addAll(list)
	    }
	    return destination
	}
	/**
	 * Returns the largest value among all values produced by [selector] function applied to each element in the array.
	 * 
	 * If any of values produced by [selector] function is `NaN`, the returned result is `NaN`.
	 * 
	 * @throws NoSuchElementException if the array is empty.
	 */
	inline fun maxOf(selector: (UByte) -> Double): Double {
	    if (isEmpty()) throw NoSuchElementException()
	    var maxValue = selector(this[0])
	    for (i in 1..lastIndex) {
	        val v = selector(this[i])
	        maxValue = maxOf(maxValue, v)
	    }
	    return maxValue
	}
	/**
	 * Returns the largest value among all values produced by [selector] function applied to each element in the array.
	 * 
	 * If any of values produced by [selector] function is `NaN`, the returned result is `NaN`.
	 * 
	 * @throws NoSuchElementException if the array is empty.
	 */
	inline fun maxOf(selector: (UByte) -> Float): Float {
	    if (isEmpty()) throw NoSuchElementException()
	    var maxValue = selector(this[0])
	    for (i in 1..lastIndex) {
	        val v = selector(this[i])
	        maxValue = maxOf(maxValue, v)
	    }
	    return maxValue
	}
	/**
	 * Returns the largest value among all values produced by [selector] function applied to each element in the array.
	 * 
	 * @throws NoSuchElementException if the array is empty.
	 */
	inline fun <R : Comparable<R>> maxOf(selector: (UByte) -> R): R {
	    if (isEmpty()) throw NoSuchElementException()
	    var maxValue = selector(this[0])
	    for (i in 1..lastIndex) {
	        val v = selector(this[i])
	        if (maxValue < v)
	            maxValue = v
	    }
	    return maxValue
	}
	/**
	 * Returns the largest value among all values produced by [selector] function applied to each element in the array or `null` if there are no elements.
	 * 
	 * If any of values produced by [selector] function is `NaN`, the returned result is `NaN`.
	 */
	inline fun maxOfOrNull(selector: (UByte) -> Double): Double? {
	    if (isEmpty()) return null
	    var maxValue = selector(this[0])
	    for (i in 1..lastIndex) {
	        val v = selector(this[i])
	        maxValue = maxOf(maxValue, v)
	    }
	    return maxValue
	}
	/** Returns the largest value among all values produced by [selector] function applied to each element in the array or `null` if there are no elements. */
	inline fun <R : Comparable<R>> maxOfOrNull(selector: (UByte) -> R): R? {
	    if (isEmpty()) return null
	    var maxValue = selector(this[0])
	    for (i in 1..lastIndex) {
	        val v = selector(this[i])
	        if (maxValue < v)
	            maxValue = v
	    }
	    return maxValue
	}
	/**
	 * Returns the largest value according to the provided [comparator] among all values produced by [selector] function applied to each element in the array.
	 * 
	 * @throws NoSuchElementException if the array is empty.
	 */
	inline fun <R> maxOfWith(comparator: Comparator<in R>, selector: (UByte) -> R): R {
	    if (isEmpty()) throw NoSuchElementException()
	    var maxValue = selector(this[0])
	    for (i in 1..lastIndex) {
	        val v = selector(this[i])
	        if (comparator.compare(maxValue, v) < 0)
	            maxValue = v
	    }
	    return maxValue
	}
	/**
	 * Returns the largest value according to the provided [comparator] among all values produced by [selector]
	 * function applied to each element in the array or `null` if there are no elements.
	 */
	inline fun <R> maxOfWithOrNull(comparator: Comparator<in R>, selector: (UByte) -> R): R? {
	    if (isEmpty()) return null
	    var maxValue = selector(this[0])
	    for (i in 1..lastIndex) {
	        val v = selector(this[i])
	        if (comparator.compare(maxValue, v) < 0)
	            maxValue = v
	    }
	    return maxValue
	}
	/** Returns the sum of all values produced by [selector] function applied to each element in the array. */
	inline fun sumOf(selector: (UByte) -> Double): Double {
	    var sum: Double = 0.toDouble()
	    for (element in this)
	        sum += selector(element)
	    return sum
	}
	/** Returns the sum of all values produced by [selector] function applied to each element in the array. */
	inline fun sumOf(selector: (UByte) -> Int): Int {
	    var sum: Int = 0.toInt()
	    for (element in this)
	        sum += selector(element)
	    return sum
	}
	/** Returns the sum of all values produced by [selector] function applied to each element in the array. */
	inline fun sumOf(selector: (UByte) -> Long): Long {
	    var sum: Long = 0.toLong()
	    for (element in this)
	        sum += selector(element)
	    return sum
	}
	/** Returns the sum of all values produced by [selector] function applied to each element in the array. */
	inline fun sumOf(selector: (UByte) -> UInt): UInt {
	    var sum: UInt = 0.toUInt()
	    for (element in this)
	        sum += selector(element)
	    return sum
	}
	/** Returns the sum of all values produced by [selector] function applied to each element in the array. */
	inline fun sumOf(selector: (UByte) -> ULong): ULong {
	    var sum: ULong = 0.toULong()
	    for (element in this)
	        sum += selector(element)
	    return sum
	}
}
/**
 * Creates a view of this byte buffer as a ubyte buffer.
 * The content of the new buffer will start at this buffer's current position. Changes to this buffer's content 
 * will be visible in the new buffer, and vice versa; the two buffers' position, limit, and mark values will be
 * independent.
 * The new buffer's position will be zero, its capacity and its limit will be the number of bytes remaining in this
 * buffer divided by eight, and its mark will be undefined. The new buffer will be direct if, and only if, this buffer
 * is direct, and it will be read-only if, and only if, this buffer is read-only.
 * @return A new ubyte buffer
 */
fun ByteBuffer.asUByteBuffer(): UByteBuffer = UByteBuffer(this)
