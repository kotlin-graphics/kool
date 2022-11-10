package kool

//import org.lwjgl.BufferUtils
//import org.lwjgl.system.*
//import java.nio.*
//
//open class PointerBuffer <T> protected constructor(address: Long, container: ByteBuffer?, mark: Int, position: Int, limit: Int, capacity: Int) :
//    CustomBuffer<PointerBuffer<T>>(address, container, mark, position, limit, capacity), Comparable<PointerBuffer<T>> {
//    override fun self(): PointerBuffer<T> = this
//
//    override fun sizeof(): Int = POINTER_SIZE
//
//    val adr = Ptr<T>(address)
//
//    /**
//     * Relative *get* method. Reads the pointer at this buffer's current position, and then increments the position.
//     *
//     * @return the pointer at the buffer's current position
//     *
//     * @throws BufferUnderflowException If the buffer's current position is not smaller than its limit
//     */
////    fun get(): Ptr<T> = MemoryUtil.memGetAddress(address + Integer.toUnsignedLong(nextGetIndex()) * POINTER_SIZE).toPtr()
//    fun get(): Ptr<T> = MemoryUtil.memGetAddress(address + Integer.toUnsignedLong(nextGetIndex()) * POINTER_SIZE).toPtr()
//
//    /**
//     * Relative *put* method&nbsp;&nbsp;*(optional operation)*.
//     *
//     *
//     * Writes the specified pointer into this buffer at the current position, and then increments the position.
//     *
//     * @param p the pointer to be written
//     *
//     * @return This buffer
//     *
//     * @throws BufferOverflowException If this buffer's current position is not smaller than its limit
//     */
//    fun put(p: Long): PointerBuffer<T> {
//        MemoryUtil.memPutAddress(address + Integer.toUnsignedLong(nextPutIndex()) * POINTER_SIZE, p)
//        return this
//    }
//
//    /**
//     * Absolute *get* method. Reads the pointer at the specified `index`.
//     *
//     * @param index the index from which the pointer will be read
//     *
//     * @return the pointer at the specified `index`
//     *
//     * @throws IndexOutOfBoundsException If `index` is negative or not smaller than the buffer's limit
//     */
//    operator fun get(index: Int): Long {
//        return MemoryUtil.memGetAddress(address + Checks.check(index, limit) * POINTER_SIZE)
//    }
//
//    /**
//     * Absolute *put* method&nbsp;&nbsp;*(optional operation)*.
//     *
//     *
//     * Writes the specified pointer into this buffer at the specified `index`.
//     *
//     * @param index the index at which the pointer will be written
//     * @param p     the pointer value to be written
//     *
//     * @return This buffer
//     *
//     * @throws IndexOutOfBoundsException If `index` is negative or not smaller than the buffer's limit
//     */
//    fun put(index: Int, p: Long): PointerBuffer<T> {
//        MemoryUtil.memPutAddress(address + Checks.check(index, limit) * POINTER_SIZE, p)
//        return this
//    }
//    // -- PointerWrapper operations --
//    /** Puts the pointer value of the specified [Pointer] at the current position and then increments the position.  */
//    fun put(pointer: Pointer): PointerBuffer<T> {
//        put(pointer.address())
//        return this
//    }
//
//    /** Puts the pointer value of the specified [Pointer] at the specified `index`.  */
//    fun put(index: Int, pointer: Pointer): PointerBuffer<T> {
//        put(index, pointer.address())
//        return this
//    }
//    // -- Buffer address operations --
//    /**
//     *
//     * Writes the address of the specified `buffer` into this buffer at the current position, and then increments the position.
//     *
//     * @param buffer the pointer to be written
//     *
//     * @return this buffer
//     *
//     * @throws BufferOverflowException If this buffer's current position is not smaller than its limit
//     */
//    fun put(buffer: ByteBuffer?): PointerBuffer<T> {
//        put(MemoryUtil.memAddress(buffer!!))
//        return this
//    }
//
//    /**
//     *
//     * Writes the address of the specified `buffer` into this buffer at the current position, and then increments the position.
//     *
//     * @param buffer the pointer to be written
//     *
//     * @return this buffer
//     *
//     * @throws BufferOverflowException If this buffer's current position is not smaller than its limit
//     */
//    fun put(buffer: ShortBuffer?): PointerBuffer<T> {
//        put(MemoryUtil.memAddress(buffer!!))
//        return this
//    }
//
//    /**
//     *
//     * Writes the address of the specified `buffer` into this buffer at the current position, and then increments the position.
//     *
//     * @param buffer the pointer to be written
//     *
//     * @return this buffer
//     *
//     * @throws BufferOverflowException If this buffer's current position is not smaller than its limit
//     */
//    fun put(buffer: IntBuffer?): PointerBuffer<T> {
//        put(MemoryUtil.memAddress(buffer!!))
//        return this
//    }
//
//    /**
//     *
//     * Writes the address of the specified `buffer` into this buffer at the current position, and then increments the position.
//     *
//     * @param buffer the pointer to be written
//     *
//     * @return this buffer
//     *
//     * @throws BufferOverflowException If this buffer's current position is not smaller than its limit
//     */
//    fun put(buffer: LongBuffer?): PointerBuffer<T> {
//        put(MemoryUtil.memAddress(buffer!!))
//        return this
//    }
//
//    /**
//     *
//     * Writes the address of the specified `buffer` into this buffer at the current position, and then increments the position.
//     *
//     * @param buffer the pointer to be written
//     *
//     * @return this buffer
//     *
//     * @throws BufferOverflowException If this buffer's current position is not smaller than its limit
//     */
//    fun put(buffer: FloatBuffer?): PointerBuffer<T> {
//        put(MemoryUtil.memAddress(buffer!!))
//        return this
//    }
//
//    /**
//     *
//     * Writes the address of the specified `buffer` into this buffer at the current position, and then increments the position.
//     *
//     * @param buffer the pointer to be written
//     *
//     * @return this buffer
//     *
//     * @throws BufferOverflowException If this buffer's current position is not smaller than its limit
//     */
//    fun put(buffer: DoubleBuffer?): PointerBuffer<T> {
//        put(MemoryUtil.memAddress(buffer!!))
//        return this
//    }
//
//    /**
//     *
//     * Writes the address of the specified `buffer` into this buffer at the current position, and then increments the position.
//     *
//     * @param buffer the pointer to be written
//     *
//     * @return this buffer
//     *
//     * @throws BufferOverflowException If this buffer's current position is not smaller than its limit
//     */
//    fun putAddressOf(buffer: CustomBuffer<*>?): PointerBuffer<T> {
//        put(MemoryUtil.memAddress(buffer!!))
//        return this
//    }
//    // ---
//    /** Puts the address of the specified `buffer` at the specified `index`.  */
//    fun put(index: Int, buffer: ByteBuffer?): PointerBuffer<T> {
//        put(index, MemoryUtil.memAddress(buffer!!))
//        return this
//    }
//
//    /** Puts the address of the specified `buffer` at the specified `index`.  */
//    fun put(index: Int, buffer: ShortBuffer?): PointerBuffer<T> {
//        put(index, MemoryUtil.memAddress(buffer!!))
//        return this
//    }
//
//    /** Puts the address of the specified `buffer` at the specified `index`.  */
//    fun put(index: Int, buffer: IntBuffer?): PointerBuffer<T> {
//        put(index, MemoryUtil.memAddress(buffer!!))
//        return this
//    }
//
//    /** Puts the address of the specified `buffer` at the specified `index`.  */
//    fun put(index: Int, buffer: LongBuffer?): PointerBuffer<T> {
//        put(index, MemoryUtil.memAddress(buffer!!))
//        return this
//    }
//
//    /** Puts the address of the specified `buffer` at the specified `index`.  */
//    fun put(index: Int, buffer: FloatBuffer?): PointerBuffer<T> {
//        put(index, MemoryUtil.memAddress(buffer!!))
//        return this
//    }
//
//    /** Puts the address of the specified `buffer` at the specified `index`.  */
//    fun put(index: Int, buffer: DoubleBuffer?): PointerBuffer<T> {
//        put(index, MemoryUtil.memAddress(buffer!!))
//        return this
//    }
//
//    /** Puts the address of the specified `buffer` at the specified `index`.  */
//    fun putAddressOf(index: Int, buffer: CustomBuffer<*>?): PointerBuffer<T> {
//        put(index, MemoryUtil.memAddress(buffer!!))
//        return this
//    }
//    // ---
//    /**
//     * Reads the pointer at this buffer's current position, and then increments the position. The pointer is returned as a [ByteBuffer] instance that
//     * starts at the pointer address and has capacity equal to the specified `size`.
//     *
//     * @throws BufferUnderflowException If the buffer's current position is not smaller than its limit
//     */
//    fun getByteBuffer(size: Int): ByteBuffer {
//        return MemoryUtil.memByteBuffer(get(), size)
//    }
//
//    /**
//     * Reads the pointer at this buffer's current position, and then increments the position. The pointer is returned as a [ShortBuffer] instance that
//     * starts at the pointer address and has capacity equal to the specified `size`.
//     *
//     * @throws BufferUnderflowException If the buffer's current position is not smaller than its limit
//     */
//    fun getShortBuffer(size: Int): ShortBuffer {
//        return MemoryUtil.memShortBuffer(get(), size)
//    }
//
//    /**
//     * Reads the pointer at this buffer's current position, and then increments the position. The pointer is returned as a [IntBuffer] instance that
//     * starts at the pointer address and has capacity equal to the specified `size`.
//     *
//     * @throws BufferUnderflowException If the buffer's current position is not smaller than its limit
//     */
//    fun getIntBuffer(size: Int): IntBuffer {
//        return MemoryUtil.memIntBuffer(get(), size)
//    }
//
//    /**
//     * Reads the pointer at this buffer's current position, and then increments the position. The pointer is returned as a [LongBuffer] instance that
//     * starts at the pointer address and has capacity equal to the specified `size`.
//     *
//     * @throws BufferUnderflowException If the buffer's current position is not smaller than its limit
//     */
//    fun getLongBuffer(size: Int): LongBuffer {
//        return MemoryUtil.memLongBuffer(get(), size)
//    }
//
//    /**
//     * Reads the pointer at this buffer's current position, and then increments the position. The pointer is returned as a [FloatBuffer] instance that
//     * starts at the pointer address and has capacity equal to the specified `size`.
//     *
//     * @throws BufferUnderflowException If the buffer's current position is not smaller than its limit
//     */
//    fun getFloatBuffer(size: Int): FloatBuffer {
//        return MemoryUtil.memFloatBuffer(get(), size)
//    }
//
//    /**
//     * Reads the pointer at this buffer's current position, and then increments the position. The pointer is returned as a [DoubleBuffer] instance that
//     * starts at the pointer address and has capacity equal to the specified `size`.
//     *
//     * @throws BufferUnderflowException If the buffer's current position is not smaller than its limit
//     */
//    fun getDoubleBuffer(size: Int): DoubleBuffer {
//        return MemoryUtil.memDoubleBuffer(get(), size)
//    }
//
//    /**
//     * Reads the pointer at this buffer's current position, and then increments the position. The pointer is returned as a `PointerBuffer` instance that
//     * starts at the pointer address and has capacity equal to the specified `size`.
//     *
//     * @throws BufferUnderflowException If the buffer's current position is not smaller than its limit
//     */
//    fun getPointerBuffer(size: Int): PointerBuffer<T> {
//        return MemoryUtil.memPointerBuffer(get(), size)
//    }
//
//    val stringASCII: String
//        /**
//         * Reads the pointer at this buffer's current position, and then increments the position. The pointer is evaluated as a null-terminated ASCII string, which
//         * is decoded and returned as a [String] instance.
//         *
//         * @throws BufferUnderflowException If the buffer's current position is not smaller than its limit
//         */
//        get() = MemoryUtil.memASCII(get().adr)
//    val stringUTF8: String
//        /**
//         * Reads the pointer at this buffer's current position, and then increments the position. The pointer is evaluated as a null-terminated UTF-8 string, which
//         * is decoded and returned as a [String] instance.
//         *
//         * @throws BufferUnderflowException If the buffer's current position is not smaller than its limit
//         */
//        get() = MemoryUtil.memUTF8(get())
//    val stringUTF16: String
//        /**
//         * Reads the pointer at this buffer's current position, and then increments the position. The pointer is evaluated as a null-terminated UTF-16 string,
//         * which is decoded and returned as a [String] instance.
//         *
//         * @throws BufferUnderflowException If the buffer's current position is not smaller than its limit
//         */
//        get() = MemoryUtil.memUTF16(get())
//    // ---
//    /** Returns a [ByteBuffer] instance that starts at the address found at the specified `index` and has capacity equal to the specified size.  */
//    fun getByteBuffer(index: Int, size: Int): ByteBuffer {
//        return MemoryUtil.memByteBuffer(get(index), size)
//    }
//
//    /** Returns a [ShortBuffer] instance that starts at the address found at the specified `index` and has capacity equal to the specified size.  */
//    fun getShortBuffer(index: Int, size: Int): ShortBuffer {
//        return MemoryUtil.memShortBuffer(get(index), size)
//    }
//
//    /** Returns a [IntBuffer] instance that starts at the address found at the specified `index` and has capacity equal to the specified size.  */
//    fun getIntBuffer(index: Int, size: Int): IntBuffer {
//        return MemoryUtil.memIntBuffer(get(index), size)
//    }
//
//    /** Returns a [LongBuffer] instance that starts at the address found at the specified `index` and has capacity equal to the specified size.  */
//    fun getLongBuffer(index: Int, size: Int): LongBuffer {
//        return MemoryUtil.memLongBuffer(get(index), size)
//    }
//
//    /** Returns a [FloatBuffer] instance that starts at the address found at the specified `index` and has capacity equal to the specified size.  */
//    fun getFloatBuffer(index: Int, size: Int): FloatBuffer {
//        return MemoryUtil.memFloatBuffer(get(index), size)
//    }
//
//    /** Returns a [DoubleBuffer] instance that starts at the address found at the specified `index` and has capacity equal to the specified size.  */
//    fun getDoubleBuffer(index: Int, size: Int): DoubleBuffer {
//        return MemoryUtil.memDoubleBuffer(get(index), size)
//    }
//
//    /** Returns a `PointerBuffer` instance that starts at the address found at the specified `index` and has capacity equal to the specified size.  */
//    fun getPointerBuffer(index: Int, size: Int): PointerBuffer {
//        return MemoryUtil.memPointerBuffer(get(index), size)
//    }
//
//    /** Decodes the ASCII string that starts at the address found at the specified `index`.  */
//    fun getStringASCII(index: Int): String {
//        return MemoryUtil.memASCII(get(index))
//    }
//
//    /** Decodes the UTF-8 string that starts at the address found at the specified `index`.  */
//    fun getStringUTF8(index: Int): String {
//        return MemoryUtil.memUTF8(get(index))
//    }
//
//    /** Decodes the UTF-16 string that starts at the address found at the specified `index`.  */
//    fun getStringUTF16(index: Int): String {
//        return MemoryUtil.memUTF16(get(index))
//    }
//    /**
//     * Relative bulk *get* method.
//     *
//     *
//     * This method transfers pointers from this buffer into the specified destination array. If there are fewer pointers remaining in the buffer than are
//     * required to satisfy the request, that is, if `length`&nbsp;`&gt;`&nbsp;`remaining()`, then no pointers are transferred and a
//     * [BufferUnderflowException] is thrown.
//     *
//     *
//     * Otherwise, this method copies `length` pointers from this buffer into the specified array, starting at the current position of this buffer and
//     * at the specified offset in the array. The position of this buffer is then incremented by `length`.
//     *
//     *
//     * In other words, an invocation of this method of the form `src.get(dst,&nbsp;off,&nbsp;len)` has exactly the same effect as the loop
//     *
//     * <pre>
//     * for (int i = off; i &lt; off + len; i++)
//     * dst[i] = src.get(); </pre>
//     *
//     *
//     * except that it first checks that there are sufficient pointers in this buffer and it is potentially much more efficient.
//     *
//     * @param dst    the array into which pointers are to be written
//     * @param offset the offset within the array of the first pointer to be written; must be non-negative and no larger than `dst.length`
//     * @param length the maximum number of pointers to be written to the specified array; must be non-negative and no larger than `dst.length - offset`
//     *
//     * @return This buffer
//     *
//     * @throws BufferUnderflowException  If there are fewer than `length` pointers remaining in this buffer
//     * @throws IndexOutOfBoundsException If the preconditions on the `offset` and `length` parameters do not hold
//     */
//    // -- Bulk get operations --
//    /**
//     * Relative bulk *get* method.
//     *
//     *
//     * This method transfers pointers from this buffer into the specified destination array. An invocation of this method of the form `src.get(a)`
//     * behaves in exactly the same way as the invocation
//     *
//     * <pre>
//     * src.get(a, 0, a.length) </pre>
//     *
//     * @return This buffer
//     *
//     * @throws BufferUnderflowException If there are fewer than `length` pointers remaining in this buffer
//     */
//    @JvmOverloads operator fun get(dst: LongArray, offset: Int = 0, length: Int = dst.length): PointerBuffer {
//        if (BITS64) {
//            MemoryUtil.memLongBuffer(address(), remaining())[dst, offset, length]
//            position(position() + length)
//        } else {
//            get32(dst, offset, length)
//        }
//        return this
//    }
//
//    private fun get32(dst: LongArray, offset: Int, length: Int) {
//        CheckIntrinsics.checkFromIndexSize(offset, length, dst.size)
//        if (remaining() < length) {
//            throw BufferUnderflowException()
//        }
//        var i = offset
//        val end = offset + length
//        while (i < end) {
//            dst[i] = get()
//            i++
//        }
//    }
//    /**
//     * Relative bulk *put* method&nbsp;&nbsp;*(optional operation)*.
//     *
//     *
//     * This method transfers pointers into this buffer from the specified source array. If there are more pointers to be copied from the array than remain
//     * in this buffer, that is, if `length`&nbsp;`&gt;`&nbsp;`remaining()`, then no pointers are transferred and a
//     * [BufferOverflowException] is thrown.
//     *
//     *
//     * Otherwise, this method copies `length` pointers from the specified array into this buffer, starting at the specified offset in the array and
//     * at the current position of this buffer. The position of this buffer is then incremented by `length`.
//     *
//     *
//     * In other words, an invocation of this method of the form `dst.put(src,&nbsp;off,&nbsp;len)` has exactly the same effect as the loop
//     *
//     * <pre>
//     * for (int i = off; i &lt; off + len; i++)
//     * dst.put(a[i]); </pre>
//     *
//     *
//     * except that it first checks that there is sufficient space in this buffer and it is potentially much more efficient.
//     *
//     * @param src    the array from which pointers are to be read
//     * @param offset the offset within the array of the first pointer to be read; must be non-negative and no larger than `array.length`
//     * @param length the number of pointers to be read from the specified array; must be non-negative and no larger than `array.length - offset`
//     *
//     * @return This buffer
//     *
//     * @throws BufferOverflowException   If there is insufficient space in this buffer
//     * @throws IndexOutOfBoundsException If the preconditions on the `offset` and `length` parameters do not hold
//     */
//    /**
//     * Relative bulk *put* method&nbsp;&nbsp;*(optional operation)*.
//     *
//     *
//     * This method transfers the entire content of the specified source pointer array into this buffer. An invocation of this method of the form
//     * `dst.put(a)` behaves in exactly the same way as the invocation
//     *
//     * <pre>
//     * dst.put(a, 0, a.length) </pre>
//     *
//     * @return This buffer
//     *
//     * @throws BufferOverflowException If there is insufficient space in this buffer
//     */
//    @JvmOverloads fun put(src: LongArray, offset: Int = 0, length: Int = src.length): PointerBuffer {
//        if (BITS64) {
//            MemoryUtil.memLongBuffer(address(), remaining()).put(src, offset, length)
//            position(position() + length)
//        } else {
//            put32(src, offset, length)
//        }
//        return this
//    }
//
//    private fun put32(src: LongArray, offset: Int, length: Int) {
//        CheckIntrinsics.checkFromIndexSize(offset, length, src.size)
//        if (remaining() < length) {
//            throw BufferOverflowException()
//        }
//        val end = offset + length
//        for (i in offset until end) {
//            put(src[i])
//        }
//    }
//
//    /**
//     * Returns the current hash code of this buffer.
//     *
//     *
//     * The hash code of a pointer buffer depends only upon its remaining elements; that is, upon the elements from `position()` up to, and including,
//     * the element at `limit()`&nbsp;-&nbsp;`1`.
//     *
//     *
//     * Because buffer hash codes are content-dependent, it is inadvisable to use buffers as keys in hash maps or similar data structures unless it is known
//     * that their contents will not change.
//     *
//     * @return the current hash code of this buffer
//     */
//    override fun hashCode(): Int {
//        var h = 1
//        val p = position()
//        for (i in limit() - 1 downTo p) {
//            h = 31 * h + get(i).toInt()
//        }
//        return h
//    }
//
//    /**
//     * Tells whether or not this buffer is equal to another object.
//     *
//     *
//     * Two pointer buffers are equal if, and only if,
//     *
//     *
//     *  1. They have the same element type,
//     *  1. They have the same number of remaining elements, and
//     *  1. The two sequences of remaining elements, considered
//     * independently of their starting positions, are pointwise equal.
//     *
//     *
//     *
//     * A pointer buffer is not equal to any other type of object.
//     *
//     * @param ob the object to which this buffer is to be compared
//     *
//     * @return `true` if, and only if, this buffer is equal to the
//     * given object
//     */
//    override fun equals(ob: Any?): Boolean {
//        if (ob !is PointerBuffer) {
//            return false
//        }
//        val that = ob
//        if (remaining() != that.remaining()) {
//            return false
//        }
//        val p = this.position()
//        var i = this.limit() - 1
//        var j = that.limit() - 1
//        while (i >= p) {
//            val v1 = this[i]
//            val v2 = that[j]
//            if (v1 != v2) {
//                return false
//            }
//            i--
//            j--
//        }
//        return true
//    }
//
//    /**
//     * Compares this buffer to another.
//     *
//     *
//     * Two pointer buffers are compared by comparing their sequences of remaining elements lexicographically, without regard to the starting position of
//     * each sequence within its corresponding buffer.
//     *
//     *
//     * A pointer buffer is not comparable to any other type of object.
//     *
//     * @return A negative integer, zero, or a positive integer as this buffer is less than, equal to, or greater than the specified buffer
//     */
//    override operator fun compareTo(that: PointerBuffer): Int {
//        val n = this.position() + Math.min(remaining(), that.remaining())
//        var i = this.position()
//        var j = that.position()
//        while (i < n) {
//            val v1 = this[i]
//            val v2 = that[j]
//            if (v1 == v2) {
//                i++
//                j++
//                continue
//            }
//            return if (v1 < v2) {
//                -1
//            } else +1
//            i++
//            j++
//        }
//        return remaining() - that.remaining()
//    }
//
//    companion object {
//        /**
//         * Allocates a new pointer buffer.
//         *
//         *
//         * The new buffer's position will be zero, its limit will be its capacity, and its mark will be undefined.
//         *
//         * @param capacity the new buffer's capacity, in pointers
//         *
//         * @return the new pointer buffer
//         *
//         * @throws IllegalArgumentException If the `capacity` is a negative integer
//         */
//        fun allocateDirect(capacity: Int): PointerBuffer {
//            val source = BufferUtils.createByteBuffer(BufferUtils.getAllocationSize(capacity, POINTER_SHIFT))
//            return wrap(PointerBuffer::class.java, MemoryUtil.memAddress(source), capacity, source)
//        }
//
//        /**
//         * Creates a new PointerBuffer that starts at the specified memory address and has the specified capacity.
//         *
//         * @param address  the starting memory address
//         * @param capacity the buffer capacity, in number of pointers
//         */
//        fun create(address: Long, capacity: Int): PointerBuffer {
//            return wrap(PointerBuffer::class.java, address, capacity)
//        }
//
//        /**
//         * Creates a new PointerBuffer using the specified ByteBuffer as its pointer data source.
//         *
//         * @param source the source buffer
//         */
//        fun create(source: ByteBuffer): PointerBuffer {
//            val capacity = source.remaining() shr POINTER_SHIFT
//            return wrap(PointerBuffer::class.java, MemoryUtil.memAddress(source), capacity, source)
//        }
//
//        /**
//         * Convenience relative get from a source ByteBuffer.
//         *
//         * @param source the source ByteBuffer
//         */
//        operator fun get(source: ByteBuffer): Long {
//            if (source.remaining() < POINTER_SIZE) {
//                throw BufferUnderflowException()
//            }
//            return try {
//                MemoryUtil.memGetAddress(MemoryUtil.memAddress(source))
//            } finally {
//                source.position(source.position() + POINTER_SIZE)
//            }
//        }
//
//        /**
//         * Convenience relative put on a target ByteBuffer.
//         *
//         * @param target the target ByteBuffer
//         * @param p      the pointer value to be written
//         */
//        fun put(target: ByteBuffer, p: Long) {
//            if (target.remaining() < POINTER_SIZE) {
//                throw BufferOverflowException()
//            }
//            try {
//                MemoryUtil.memPutAddress(MemoryUtil.memAddress(target), p)
//            } finally {
//                target.position(target.position() + POINTER_SIZE)
//            }
//        }
//
//        /**
//         * Convenience absolute get from a source ByteBuffer.
//         *
//         * @param source the source ByteBuffer
//         * @param index  the index at which the pointer will be read
//         */
//        operator fun get(source: ByteBuffer, index: Int): Long {
//            CheckIntrinsics.checkFromIndexSize(index, POINTER_SIZE, source.limit())
//            return MemoryUtil.memGetAddress(MemoryUtil.memAddress0(source) + index)
//        }
//
//        /**
//         * Convenience absolute put on a target ByteBuffer.
//         *
//         * @param target the target ByteBuffer
//         * @param index  the index at which the pointer will be written
//         * @param p      the pointer value to be written
//         */
//        fun put(target: ByteBuffer, index: Int, p: Long) {
//            CheckIntrinsics.checkFromIndexSize(index, POINTER_SIZE, target.limit())
//            MemoryUtil.memPutAddress(MemoryUtil.memAddress0(target) + index, p)
//        }
//    }
//}