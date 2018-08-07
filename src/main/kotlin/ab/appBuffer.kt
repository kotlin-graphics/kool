package ab

import org.lwjgl.PointerBuffer
import org.lwjgl.system.MemoryUtil
import org.lwjgl.system.Pointer
import java.nio.*
import java.util.concurrent.atomic.AtomicLong

object appBuffer {

    var SIZE = 2 shl 16  // 65536

    var buffer = bufferBig(SIZE)
    var address = MemoryUtil.memAddress(buffer)

    val ptr = AtomicLong(address)

    // one-slot buffers

    inline val byteBuffer: ByteBuffer
        get() = MemoryUtil.memByteBuffer(ptr advance 1, 1)

    inline val shortBuffer: ShortBuffer
        get() = MemoryUtil.memShortBuffer(ptr advance 2, 1)

    inline val intBuffer: IntBuffer
        get() = MemoryUtil.memIntBuffer(ptr advance 4, 1)

    inline val longBuffer: LongBuffer
        get() = MemoryUtil.memLongBuffer(ptr advance 8, 1)

    inline val floatBuffer: FloatBuffer
        get() = MemoryUtil.memFloatBuffer(ptr advance 4, 1)

    inline val doubleBuffer: DoubleBuffer
        get() = MemoryUtil.memDoubleBuffer(ptr advance 8, 1)

    inline val pointerBuffer: PointerBuffer
        get() = MemoryUtil.memPointerBuffer(ptr advance Pointer.POINTER_SIZE, 1)

    inline val byte get() = ptr advance 1
    inline val short get() = ptr advance 2
    inline val int get() = ptr advance 4
    inline val long get() = ptr advance 8
    inline val float get() = ptr advance 4
    inline val double get() = ptr advance 8
    inline val pointer get() = ptr advance Pointer.POINTER_SIZE

    inline fun byteArray(size: Int) = ptr.advance(size)
    inline fun shortArray(size: Int) = ptr.advance(2 * size)
    inline fun intArray(size: Int) = ptr.advance(4 * size)
    inline fun longArray(size: Int) = ptr.advance(8 * size)
    inline fun floatArray(size: Int) = ptr.advance(4 * size)
    inline fun doubleArray(size: Int) = ptr.advance(8 * size)
    inline fun pointerArray(size: Int) = ptr.advance(Pointer.POINTER_SIZE * size)


    inline infix fun pointerBuffer(capacity: Int): PointerBuffer {
        val size = Pointer.POINTER_SIZE * capacity
        return MemoryUtil.memPointerBuffer(ptr advance size, capacity)
    }

    inline infix fun pointerBufferOf(pointer: Pointer): PointerBuffer {
        return pointerBuffer(1).put(0, pointer)
    }

    inline fun pointerBufferOf(pointer0: Pointer, pointer1: Pointer): PointerBuffer {
        return pointerBuffer(1).put(0, pointer0).put(1, pointer1)
    }

    inline fun pointerBufferOf(pointer0: Pointer, pointer1: Pointer, pointer2: Pointer): PointerBuffer {
        return pointerBuffer(1).put(0, pointer0).put(1, pointer1).put(2, pointer2)
    }

    inline fun pointerBufferOf(pointer0: Pointer, pointer1: Pointer, pointer2: Pointer, pointer3: Pointer): PointerBuffer {
        return pointerBuffer(1).put(0, pointer0).put(1, pointer1).put(2, pointer2).put(3, pointer3)
    }

    inline fun pointerBufferOf(pointer0: Pointer, pointer1: Pointer, pointer2: Pointer, pointer3: Pointer, pointer4: Pointer): PointerBuffer {
        return pointerBuffer(1).put(0, pointer0).put(1, pointer1).put(2, pointer2).put(3, pointer3).put(4, pointer4)
    }

    inline fun pointerBufferOf(pointers: Collection<Pointer>): PointerBuffer {
        val res = pointerBuffer(pointers.size)
        for (i in pointers.indices)
            res.put(i, pointers.elementAt(i))
        return res
    }

    inline infix fun pointerBufferOf(long: Long): PointerBuffer {
        return pointerBuffer(1).put(0, long)
    }

    inline fun pointerBufferOf(long0: Long, long1: Long): PointerBuffer {
        return pointerBuffer(2).put(0, long0).put(1, long1)
    }

    inline fun pointerBufferOf(long0: Long, long1: Long, long2: Long): PointerBuffer {
        return pointerBuffer(3).put(0, long0).put(1, long1).put(2, long2)
    }

    inline fun pointerBufferOf(long0: Long, long1: Long, long2: Long, long3: Long): PointerBuffer {
        return pointerBuffer(1).put(0, long0).put(1, long1).put(2, long2).put(3, long3)
    }

    inline fun pointerBufferOf(long0: Long, long1: Long, long2: Long, long3: Long, long4: Long): PointerBuffer {
        return pointerBuffer(1).put(0, long0).put(1, long1).put(2, long2).put(3, long3).put(4, long4)
    }

    inline fun pointerBufferOf_(pointers: Collection<Long>): PointerBuffer {
        val res = pointerBuffer(pointers.size)
        for (i in pointers.indices)
            res.put(i, pointers.elementAt(i))
        return res
    }

    // TODO other bytes(other number types)?

    inline fun bytes(byte: Byte): Long {
        val res = ptr advance 1
        MemoryUtil.memPutByte(res, byte)
        return res
    }

    inline fun bytes(byte0: Byte, byte1: Byte): Long {
        val res = ptr advance 2
        MemoryUtil.memPutByte(res, byte0)
        MemoryUtil.memPutByte(res + 1, byte1)
        return res
    }

    inline fun bytes(byte0: Byte, byte1: Byte, byte2: Byte): Long {
        val res = ptr advance 3
        MemoryUtil.memPutByte(res, byte0)
        MemoryUtil.memPutByte(res + 1, byte1)
        MemoryUtil.memPutByte(res + 2, byte2)
        return res
    }

    inline fun bytes(byte0: Byte, byte1: Byte, byte2: Byte, byte3: Byte): Long {
        val res = ptr advance 4
        MemoryUtil.memPutByte(res, byte0)
        MemoryUtil.memPutByte(res + 1, byte1)
        MemoryUtil.memPutByte(res + 2, byte2)
        MemoryUtil.memPutByte(res + 3, byte3)
        return res
    }

    inline fun bytes(byte0: Byte, byte1: Byte, byte2: Byte, byte3: Byte, byte4: Byte): Long {
        val res = ptr advance 5
        MemoryUtil.memPutByte(res, byte0)
        MemoryUtil.memPutByte(res + 1, byte1)
        MemoryUtil.memPutByte(res + 2, byte2)
        MemoryUtil.memPutByte(res + 3, byte3)
        MemoryUtil.memPutByte(res + 4, byte4)
        return res
    }

    inline fun shorts(short: Short): Long {
        val res = ptr advance 2
        MemoryUtil.memPutShort(res, short)
        return res
    }

    inline fun shorts(short0: Short, short1: Short): Long {
        val res = ptr advance (2 * 2)
        MemoryUtil.memPutShort(res, short0)
        MemoryUtil.memPutShort(res + 2, short1)
        return res
    }

    inline fun shorts(short0: Short, short1: Short, short2: Short): Long {
        val res = ptr advance (2 * 3)
        MemoryUtil.memPutShort(res, short0)
        MemoryUtil.memPutShort(res + 2, short1)
        MemoryUtil.memPutShort(res + 4, short2)
        return res
    }

    inline fun shorts(short0: Short, short1: Short, short2: Short, short3: Short): Long {
        val res = ptr advance (2 * 4)
        MemoryUtil.memPutShort(res, short0)
        MemoryUtil.memPutShort(res + 2, short1)
        MemoryUtil.memPutShort(res + 4, short2)
        MemoryUtil.memPutShort(res + 6, short3)
        return res
    }

    inline fun shorts(short0: Short, short1: Short, short2: Short, short3: Short, short4: Short): Long {
        val res = ptr advance (2 * 5)
        MemoryUtil.memPutShort(res, short0)
        MemoryUtil.memPutShort(res + 2, short1)
        MemoryUtil.memPutShort(res + 4, short2)
        MemoryUtil.memPutShort(res + 6, short3)
        MemoryUtil.memPutShort(res + 8, short4)
        return res
    }

    inline fun ints(int: Int): Long {
        val res = ptr advance 4
        MemoryUtil.memPutInt(res, int)
        return res
    }

    inline fun ints(int0: Int, int1: Int): Long {
        val res = ptr advance (4 * 2)
        MemoryUtil.memPutInt(res, int0)
        MemoryUtil.memPutInt(res + 4, int1)
        return res
    }

    inline fun ints(int0: Int, int1: Int, int2: Int): Long {
        val res = ptr advance (4 * 3)
        MemoryUtil.memPutInt(res, int0)
        MemoryUtil.memPutInt(res + 4, int1)
        MemoryUtil.memPutInt(res + 8, int2)
        return res
    }

    inline fun ints(int0: Int, int1: Int, int2: Int, int3: Int): Long {
        val res = ptr advance (4 * 4)
        MemoryUtil.memPutInt(res, int0)
        MemoryUtil.memPutInt(res + 4, int1)
        MemoryUtil.memPutInt(res + 8, int2)
        MemoryUtil.memPutInt(res + 12, int3)
        return res
    }

    inline fun ints(int0: Int, int1: Int, int2: Int, int3: Int, int4: Int): Long {
        val res = ptr advance (4 * 5)
        MemoryUtil.memPutInt(res, int0)
        MemoryUtil.memPutInt(res + 4, int1)
        MemoryUtil.memPutInt(res + 8, int2)
        MemoryUtil.memPutInt(res + 12, int3)
        MemoryUtil.memPutInt(res + 16, int4)
        return res
    }

    inline fun longs(long: Long): Long {
        val res = ptr advance 8
        MemoryUtil.memPutLong(res, long)
        return res
    }

    inline fun longs(long0: Long, long1: Long): Long {
        val res = ptr advance (8 * 2)
        MemoryUtil.memPutLong(res, long0)
        MemoryUtil.memPutLong(res + 4, long1)
        return res
    }

    inline fun longs(long0: Long, long1: Long, long2: Long): Long {
        val res = ptr advance (8 * 3)
        MemoryUtil.memPutLong(res, long0)
        MemoryUtil.memPutLong(res + 4, long1)
        MemoryUtil.memPutLong(res + 8, long2)
        return res
    }

    inline fun longs(long0: Long, long1: Long, long2: Long, long3: Long): Long {
        val res = ptr advance (8 * 4)
        MemoryUtil.memPutLong(res, long0)
        MemoryUtil.memPutLong(res + 4, long1)
        MemoryUtil.memPutLong(res + 8, long2)
        MemoryUtil.memPutLong(res + 12, long3)
        return res
    }

    inline fun longs(long0: Long, long1: Long, long2: Long, long3: Long, long4: Long): Long {
        val res = ptr advance (8 * 5)
        MemoryUtil.memPutLong(res, long0)
        MemoryUtil.memPutLong(res + 4, long1)
        MemoryUtil.memPutLong(res + 8, long2)
        MemoryUtil.memPutLong(res + 12, long3)
        MemoryUtil.memPutLong(res + 16, long4)
        return res
    }

    inline fun floats(float: Float): Long {
        val res = ptr advance 4
        MemoryUtil.memPutFloat(res, float)
        return res
    }

    inline fun floats(float0: Float, float1: Float): Long {
        val res = ptr advance (4 * 2)
        MemoryUtil.memPutFloat(res, float0)
        MemoryUtil.memPutFloat(res + 4, float1)
        return res
    }

    inline fun floats(float0: Float, float1: Float, float2: Float): Long {
        val res = ptr advance (4 * 3)
        MemoryUtil.memPutFloat(res, float0)
        MemoryUtil.memPutFloat(res + 4, float1)
        MemoryUtil.memPutFloat(res + 8, float2)
        return res
    }

    inline fun floats(float0: Float, float1: Float, float2: Float, float3: Float): Long {
        val res = ptr advance (4 * 4)
        MemoryUtil.memPutFloat(res, float0)
        MemoryUtil.memPutFloat(res + 4, float1)
        MemoryUtil.memPutFloat(res + 8, float2)
        MemoryUtil.memPutFloat(res + 12, float3)
        return res
    }

    inline fun floats(float0: Float, float1: Float, float2: Float, float3: Float, float4: Float): Long {
        val res = ptr advance (4 * 5)
        MemoryUtil.memPutFloat(res, float0)
        MemoryUtil.memPutFloat(res + 4, float1)
        MemoryUtil.memPutFloat(res + 8, float2)
        MemoryUtil.memPutFloat(res + 12, float3)
        MemoryUtil.memPutFloat(res + 16, float4)
        return res
    }

    inline fun doubles(double: Double): Long {
        val res = ptr advance 8
        MemoryUtil.memPutDouble(res, double)
        return res
    }

    inline fun doubles(double0: Double, double1: Double): Long {
        val res = ptr advance (8 * 2)
        MemoryUtil.memPutDouble(res, double0)
        MemoryUtil.memPutDouble(res + 4, double1)
        return res
    }

    inline fun doubles(double0: Double, double1: Double, double2: Double): Long {
        val res = ptr advance (8 * 3)
        MemoryUtil.memPutDouble(res, double0)
        MemoryUtil.memPutDouble(res + 4, double1)
        MemoryUtil.memPutDouble(res + 8, double2)
        return res
    }

    inline fun doubles(double0: Double, double1: Double, double2: Double, double3: Double): Long {
        val res = ptr advance (8 * 4)
        MemoryUtil.memPutDouble(res, double0)
        MemoryUtil.memPutDouble(res + 4, double1)
        MemoryUtil.memPutDouble(res + 8, double2)
        MemoryUtil.memPutDouble(res + 12, double3)
        return res
    }

    inline fun doubles(double0: Double, double1: Double, double2: Double, double3: Double, double4: Double): Long {
        val res = ptr advance (8 * 5)
        MemoryUtil.memPutDouble(res, double0)
        MemoryUtil.memPutDouble(res + 8, double1)
        MemoryUtil.memPutDouble(res + 16, double2)
        MemoryUtil.memPutDouble(res + 24, double3)
        MemoryUtil.memPutDouble(res + 30, double4)
        return res
    }


    inline fun buffer(size: Int): ByteBuffer = MemoryUtil.memByteBuffer(ptr.advance(size), size)

    inline infix fun byteBufferOf(byte: Byte): ByteBuffer {
        return buffer(1).put(0, byte)
    }

    inline fun bufferOf(byte0: Byte, byte1: Byte): ByteBuffer {
        return buffer(1).put(0, byte0).put(1, byte1)
    }

    inline fun bufferOf(byte0: Byte, byte1: Byte, byte2: Byte): ByteBuffer {
        return buffer(1).put(0, byte0).put(1, byte1).put(2, byte2)
    }

    inline fun bufferOf(byte0: Byte, byte1: Byte, byte2: Byte, byte3: Byte): ByteBuffer {
        return buffer(1).put(0, byte0).put(1, byte1).put(2, byte2).put(3, byte3)
    }

    inline fun bufferOf(byte0: Byte, byte1: Byte, byte2: Byte, byte3: Byte, byte4: Byte): ByteBuffer {
        return buffer(1).put(0, byte0).put(1, byte1).put(2, byte2).put(3, byte3).put(4, byte4)
    }

    inline fun bufferOf(vararg bytes: Byte): ByteBuffer {
        val res = buffer(bytes.size)
        for (i in bytes.indices)
            res.put(i, bytes[i])
        return res
    }

    inline fun bufferOf(bytes: Collection<Byte>): ByteBuffer {
        val res = buffer(bytes.size)
        for (i in bytes.indices)
            res.put(i, bytes.elementAt(i))
        return res
    }


    inline infix fun shortBufferOf(short: Short): ShortBuffer {
        return shortBuffer(1).put(0, short)
    }

    inline fun shortBufferOf(short0: Short, short1: Short): ShortBuffer {
        return shortBuffer(1).put(0, short0).put(1, short1)
    }

    inline fun shortBufferOf(short0: Short, short1: Short, short2: Short): ShortBuffer {
        return shortBuffer(1).put(0, short0).put(1, short1).put(2, short2)
    }

    inline fun shortBufferOf(short0: Short, short1: Short, short2: Short, short3: Short): ShortBuffer {
        return shortBuffer(1).put(0, short0).put(1, short1).put(2, short2).put(3, short3)
    }

    inline fun shortBufferOf(short0: Short, short1: Short, short2: Short, short3: Short, short4: Short): ShortBuffer {
        return shortBuffer(1).put(0, short0).put(1, short1).put(2, short2).put(3, short3).put(4, short4)
    }

    inline fun shortBufferOf(vararg shorts: Short): ShortBuffer {
        val res = shortBuffer(shorts.size)
        for (i in shorts.indices)
            res.put(i, shorts[i])
        return res
    }

    inline fun shortBufferOf(shorts: Collection<Short>): ShortBuffer {
        val res = shortBuffer(shorts.size)
        for (i in shorts.indices)
            res.put(i, shorts.elementAt(i))
        return res
    }


    inline infix fun intBufferOf(int: Int): IntBuffer {
        return intBuffer(1).put(0, int)
    }

    inline fun intBufferOf(int0: Int, int1: Int): IntBuffer {
        return intBuffer(1).put(0, int0).put(1, int1)
    }

    inline fun intBufferOf(int0: Int, int1: Int, int2: Int): IntBuffer {
        return intBuffer(1).put(0, int0).put(1, int1).put(2, int2)
    }

    inline fun intBufferOf(int0: Int, int1: Int, int2: Int, int3: Int): IntBuffer {
        return intBuffer(1).put(0, int0).put(1, int1).put(2, int2).put(3, int3)
    }

    inline fun intBufferOf(int0: Int, int1: Int, int2: Int, int3: Int, int4: Int): IntBuffer {
        return intBuffer(1).put(0, int0).put(1, int1).put(2, int2).put(3, int3).put(4, int4)
    }

    inline fun intBufferOf(vararg ints: Int): IntBuffer {
        val res = intBuffer(ints.size)
        for (i in ints.indices)
            res.put(i, ints[i])
        return res
    }

    inline fun intBufferOf(ints: Collection<Int>): IntBuffer {
        val res = intBuffer(ints.size)
        for (i in ints.indices)
            res.put(i, ints.elementAt(i))
        return res
    }


    inline infix fun longBufferOf(long: Long): LongBuffer {
        return longBuffer(1).put(0, long)
    }

    inline fun longBufferOf(long0: Long, long1: Long): LongBuffer {
        return longBuffer(1).put(0, long0).put(1, long1)
    }

    inline fun longBufferOf(long0: Long, long1: Long, long2: Long): LongBuffer {
        return longBuffer(1).put(0, long0).put(1, long1).put(2, long2)
    }

    inline fun longBufferOf(long0: Long, long1: Long, long2: Long, long3: Long): LongBuffer {
        return longBuffer(1).put(0, long0).put(1, long1).put(2, long2).put(3, long3)
    }

    inline fun longBufferOf(long0: Long, long1: Long, long2: Long, long3: Long, long4: Long): LongBuffer {
        return longBuffer(1).put(0, long0).put(1, long1).put(2, long2).put(3, long3).put(4, long4)
    }

    inline fun longBufferOf(vararg longs: Long): LongBuffer {
        val res = longBuffer(longs.size)
        for (i in longs.indices)
            res.put(i, longs[i])
        return res
    }

    inline fun longBufferOf(longs: Collection<Long>): LongBuffer {
        val res = longBuffer(longs.size)
        for (i in longs.indices)
            res.put(i, longs.elementAt(i))
        return res
    }


    inline infix fun floatBufferOf(float: Float): FloatBuffer {
        return floatBuffer(1).put(0, float)
    }

    inline fun floatBufferOf(float0: Float, float1: Float): FloatBuffer {
        return floatBuffer(2).put(0, float0).put(1, float1)
    }

    inline fun floatBufferOf(float0: Float, float1: Float, float2: Float): FloatBuffer {
        return floatBuffer(2).put(0, float0).put(1, float1).put(2, float2)
    }

    inline fun floatBufferOf(float0: Float, float1: Float, float2: Float, float3: Float): FloatBuffer {
        return floatBuffer(2).put(0, float0).put(1, float1).put(2, float2).put(3, float3)
    }

    inline fun floatBufferOf(float0: Float, float1: Float, float2: Float, float3: Float, float4: Float): FloatBuffer {
        return floatBuffer(2).put(0, float0).put(1, float1).put(2, float2).put(3, float3).put(4, float4)
    }

    inline fun floatBufferOf(vararg floats: Float): FloatBuffer {
        val res = floatBuffer(floats.size)
        for (i in floats.indices)
            res.put(i, floats[i])
        return res
    }


    inline infix fun doubleBufferOf(double: Double): DoubleBuffer {
        return doubleBuffer(1).put(0, double)
    }

    inline fun doubleBufferOf(double0: Double, double1: Double): DoubleBuffer {
        return doubleBuffer(2).put(0, double0).put(1, double1)
    }

    inline fun doubleBufferOf(double0: Double, double1: Double, double2: Double): DoubleBuffer {
        return doubleBuffer(2).put(0, double0).put(1, double1).put(2, double2)
    }

    inline fun doubleBufferOf(double0: Double, double1: Double, double2: Double, double3: Double): DoubleBuffer {
        return doubleBuffer(2).put(0, double0).put(1, double1).put(2, double2).put(3, double3)
    }

    inline fun doubleBufferOf(double0: Double, double1: Double, double2: Double, double3: Double, double4: Double): DoubleBuffer {
        return doubleBuffer(2).put(0, double0).put(1, double1).put(2, double2).put(3, double3).put(4, double4)
    }

    inline fun doubleBufferOf(vararg doubles: Double): DoubleBuffer {
        val res = doubleBuffer(doubles.size)
        for (i in doubles.indices)
            res.put(i, doubles[i])
        return res
    }

    inline fun bufferOfAscii(string: String, nullTerminated: Boolean = true): ByteBuffer {
        val bytes = this.buffer(string.length + if (nullTerminated) 1 else 0)
        for (i in string.indices)
            bytes.put(i, string[i].toByte())
        if (nullTerminated)
            bytes.put(string.length, 0)
        return bytes
    }

    inline fun bufferOfUtf8(string: String, nullTerminated: Boolean = true): ByteBuffer {
        val bytes = this.buffer(MemoryUtil.memLengthUTF8(string, nullTerminated))
        MemoryUtil.memUTF8(string, nullTerminated, bytes)
        return bytes
    }


    inline fun intBuffer(size: Int): IntBuffer = MemoryUtil.memIntBuffer(ptr.advance(4 * size), size)
    inline fun intBuffer(size: Int, block: (Int) -> Int): IntBuffer {
        val res = intBuffer(size)
        for (i in 0 until res.remaining())
            res.put(i, block(i))
        return res
    }

    inline fun shortBuffer(size: Int): ShortBuffer = MemoryUtil.memShortBuffer(ptr.advance(2 * size), size)
    inline fun shortBuffer(size: Int, block: (Int) -> Int): ShortBuffer {
        val res = shortBuffer(size)
        for (i in 0 until res.remaining())
            res.put(i, block(i).toShort())
        return res
    }

    inline fun floatBuffer(size: Int): FloatBuffer = MemoryUtil.memFloatBuffer(ptr.advance(4 * size), size)
    inline fun doubleBuffer(size: Int): DoubleBuffer = MemoryUtil.memDoubleBuffer(ptr.advance(8 * size), size)
    inline fun longBuffer(size: Int): LongBuffer = MemoryUtil.memLongBuffer(ptr.advance(8 * size), size)

    fun reset() {
        ptr.set(address)
        MemoryUtil.memSet(address, 0, SIZE.toLong())
    }


    // TODO others

    // getters

    inline fun withIntPtr(block: (Long) -> Unit): Int {
        val intPtr = int
        block(intPtr)
        return MemoryUtil.memGetInt(intPtr)
    }

    inline fun withIntBuffer(block: (IntBuffer) -> Unit): Int {
        val int = intBuffer
        block(int)
        return int[0]
    }

    // setters

    inline fun withIntPtr(int: Int, block: (Long) -> Unit) {
        val intPtr = this.int
        MemoryUtil.memPutInt(intPtr, int)
        block(intPtr)
    }

    inline fun withIntBuffer(int_: Int, block: (IntBuffer) -> Unit) {
        val int = intBuffer
        int.put(0, int_)
        block(int)
    }


    fun next() = MemoryUtil.memGetByte(ptr.get())
    fun printNext() = println("@${ptr.get() - address}: ${next()}")
    val remaining get() = SIZE - consumed
    val consumed get() = ptr.get() - address

    val VERSION = "0.4"
}

inline infix fun AtomicLong.advance(int: Int) = getAndAdd(int.toLong())
