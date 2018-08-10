package kool_

import org.lwjgl.PointerBuffer
import org.lwjgl.system.MemoryUtil
import org.lwjgl.system.Pointer
import java.nio.*
import java.util.concurrent.atomic.AtomicLong


object kool {

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

    inline val byte: Ptr get() = ptr advance 1
    inline val short: Ptr get() = ptr advance 2
    inline val int: Ptr get() = ptr advance 4
    inline val long: Ptr get() = ptr advance 8
    inline val float: Ptr get() = ptr advance 4
    inline val double: Ptr get() = ptr advance 8
    inline val pointer: Ptr get() = ptr advance Pointer.POINTER_SIZE

    fun byteArray(size: Int): Ptr = ptr.advance(size)
    fun shortArray(size: Int): Ptr = ptr.advance(2 * size)
    fun intArray(size: Int): Ptr = ptr.advance(4 * size)
    fun longArray(size: Int): Ptr = ptr.advance(8 * size)
    fun floatArray(size: Int): Ptr = ptr.advance(4 * size)
    fun doubleArray(size: Int): Ptr = ptr.advance(8 * size)
    fun pointerArray(size: Int): Ptr = ptr.advance(Pointer.POINTER_SIZE * size)


    infix fun pointerBuffer(capacity: Int): PointerBuffer {
        val size = Pointer.POINTER_SIZE * capacity
        return MemoryUtil.memPointerBuffer(ptr advance size, capacity)
    }

    infix fun pointerBufferOf(pointer: Pointer): PointerBuffer {
        return pointerBuffer(1).put(0, pointer)
    }

    fun pointerBufferOf(pointer0: Pointer, pointer1: Pointer): PointerBuffer {
        return pointerBuffer(2).put(0, pointer0).put(1, pointer1)
    }

    fun pointerBufferOf(pointer0: Pointer, pointer1: Pointer, pointer2: Pointer): PointerBuffer {
        return pointerBuffer(3).put(0, pointer0).put(1, pointer1).put(2, pointer2)
    }

    fun pointerBufferOf(pointer0: Pointer, pointer1: Pointer, pointer2: Pointer, pointer3: Pointer): PointerBuffer {
        return pointerBuffer(4).put(0, pointer0).put(1, pointer1).put(2, pointer2).put(3, pointer3)
    }

    fun pointerBufferOf(pointer0: Pointer, pointer1: Pointer, pointer2: Pointer, pointer3: Pointer, pointer4: Pointer): PointerBuffer {
        return pointerBuffer(5).put(0, pointer0).put(1, pointer1).put(2, pointer2).put(3, pointer3).put(4, pointer4)
    }

    fun pointerBufferOf(pointers: Collection<Pointer>): PointerBuffer {
        val res = pointerBuffer(pointers.size)
        for (i in pointers.indices)
            res.put(i, pointers.elementAt(i))
        return res
    }


    infix fun pointerBufferOf(long: Ptr): PointerBuffer {
        return pointerBuffer(1).put(0, long)
    }

    fun pointerBufferOf(long0: Ptr, long1: Ptr): PointerBuffer {
        return pointerBuffer(2).put(0, long0).put(1, long1)
    }

    fun pointerBufferOf(long0: Ptr, long1: Ptr, long2: Ptr): PointerBuffer {
        return pointerBuffer(3).put(0, long0).put(1, long1).put(2, long2)
    }

    fun pointerBufferOf(long0: Ptr, long1: Ptr, long2: Ptr, long3: Ptr): PointerBuffer {
        return pointerBuffer(4).put(0, long0).put(1, long1).put(2, long2).put(3, long3)
    }

    fun pointerBufferOf(long0: Ptr, long1: Ptr, long2: Ptr, long3: Ptr, long4: Ptr): PointerBuffer {
        return pointerBuffer(5).put(0, long0).put(1, long1).put(2, long2).put(3, long3).put(4, long4)
    }

    fun pointerBufferOf_(pointers: Collection<Ptr>): PointerBuffer {
        val res = pointerBuffer(pointers.size)
        for (i in pointers.indices)
            res.put(i, pointers.elementAt(i))
        return res
    }

    // TODO other bytes(other number types)?

    fun bytes(byte: Byte): Ptr {
        val res = ptr advance 1
        MemoryUtil.memPutByte(res, byte)
        return res
    }

    fun bytes(byte0: Byte, byte1: Byte): Ptr {
        val res = ptr advance 2
        MemoryUtil.memPutByte(res, byte0)
        MemoryUtil.memPutByte(res + 1, byte1)
        return res
    }

    fun bytes(byte0: Byte, byte1: Byte, byte2: Byte): Ptr {
        val res = ptr advance 3
        MemoryUtil.memPutByte(res, byte0)
        MemoryUtil.memPutByte(res + 1, byte1)
        MemoryUtil.memPutByte(res + 2, byte2)
        return res
    }

    fun bytes(byte0: Byte, byte1: Byte, byte2: Byte, byte3: Byte): Ptr {
        val res = ptr advance 4
        MemoryUtil.memPutByte(res, byte0)
        MemoryUtil.memPutByte(res + 1, byte1)
        MemoryUtil.memPutByte(res + 2, byte2)
        MemoryUtil.memPutByte(res + 3, byte3)
        return res
    }

    fun bytes(byte0: Byte, byte1: Byte, byte2: Byte, byte3: Byte, byte4: Byte): Ptr {
        val res = ptr advance 5
        MemoryUtil.memPutByte(res, byte0)
        MemoryUtil.memPutByte(res + 1, byte1)
        MemoryUtil.memPutByte(res + 2, byte2)
        MemoryUtil.memPutByte(res + 3, byte3)
        MemoryUtil.memPutByte(res + 4, byte4)
        return res
    }

    fun shorts(short: Short): Ptr {
        val res = ptr advance 2
        MemoryUtil.memPutShort(res, short)
        return res
    }

    fun shorts(short0: Short, short1: Short): Ptr {
        val res = ptr advance (2 * 2)
        MemoryUtil.memPutShort(res, short0)
        MemoryUtil.memPutShort(res + 2, short1)
        return res
    }

    fun shorts(short0: Short, short1: Short, short2: Short): Ptr {
        val res = ptr advance (2 * 3)
        MemoryUtil.memPutShort(res, short0)
        MemoryUtil.memPutShort(res + 2, short1)
        MemoryUtil.memPutShort(res + 4, short2)
        return res
    }

    fun shorts(short0: Short, short1: Short, short2: Short, short3: Short): Ptr {
        val res = ptr advance (2 * 4)
        MemoryUtil.memPutShort(res, short0)
        MemoryUtil.memPutShort(res + 2, short1)
        MemoryUtil.memPutShort(res + 4, short2)
        MemoryUtil.memPutShort(res + 6, short3)
        return res
    }

    fun shorts(short0: Short, short1: Short, short2: Short, short3: Short, short4: Short): Ptr {
        val res = ptr advance (2 * 5)
        MemoryUtil.memPutShort(res, short0)
        MemoryUtil.memPutShort(res + 2, short1)
        MemoryUtil.memPutShort(res + 4, short2)
        MemoryUtil.memPutShort(res + 6, short3)
        MemoryUtil.memPutShort(res + 8, short4)
        return res
    }

    fun ints(int: Int): Ptr {
        val res = ptr advance 4
        MemoryUtil.memPutInt(res, int)
        return res
    }

    fun ints(int0: Int, int1: Int): Ptr {
        val res = ptr advance (4 * 2)
        MemoryUtil.memPutInt(res, int0)
        MemoryUtil.memPutInt(res + 4, int1)
        return res
    }

    fun ints(int0: Int, int1: Int, int2: Int): Ptr {
        val res = ptr advance (4 * 3)
        MemoryUtil.memPutInt(res, int0)
        MemoryUtil.memPutInt(res + 4, int1)
        MemoryUtil.memPutInt(res + 8, int2)
        return res
    }

    fun ints(int0: Int, int1: Int, int2: Int, int3: Int): Ptr {
        val res = ptr advance (4 * 4)
        MemoryUtil.memPutInt(res, int0)
        MemoryUtil.memPutInt(res + 4, int1)
        MemoryUtil.memPutInt(res + 8, int2)
        MemoryUtil.memPutInt(res + 12, int3)
        return res
    }

    fun ints(int0: Int, int1: Int, int2: Int, int3: Int, int4: Int): Ptr {
        val res = ptr advance (4 * 5)
        MemoryUtil.memPutInt(res, int0)
        MemoryUtil.memPutInt(res + 4, int1)
        MemoryUtil.memPutInt(res + 8, int2)
        MemoryUtil.memPutInt(res + 12, int3)
        MemoryUtil.memPutInt(res + 16, int4)
        return res
    }

    fun longs(long: Long): Ptr {
        val res = ptr advance 8
        MemoryUtil.memPutLong(res, long)
        return res
    }

    fun longs(long0: Long, long1: Long): Ptr {
        val res = ptr advance (8 * 2)
        MemoryUtil.memPutLong(res, long0)
        MemoryUtil.memPutLong(res + 4, long1)
        return res
    }

    fun longs(long0: Long, long1: Long, long2: Long): Ptr {
        val res = ptr advance (8 * 3)
        MemoryUtil.memPutLong(res, long0)
        MemoryUtil.memPutLong(res + 4, long1)
        MemoryUtil.memPutLong(res + 8, long2)
        return res
    }

    fun longs(long0: Long, long1: Long, long2: Long, long3: Long): Ptr {
        val res = ptr advance (8 * 4)
        MemoryUtil.memPutLong(res, long0)
        MemoryUtil.memPutLong(res + 4, long1)
        MemoryUtil.memPutLong(res + 8, long2)
        MemoryUtil.memPutLong(res + 12, long3)
        return res
    }

    fun longs(long0: Long, long1: Long, long2: Long, long3: Long, long4: Long): Ptr {
        val res = ptr advance (8 * 5)
        MemoryUtil.memPutLong(res, long0)
        MemoryUtil.memPutLong(res + 4, long1)
        MemoryUtil.memPutLong(res + 8, long2)
        MemoryUtil.memPutLong(res + 12, long3)
        MemoryUtil.memPutLong(res + 16, long4)
        return res
    }

    fun floats(float: Float): Ptr {
        val res = ptr advance 4
        MemoryUtil.memPutFloat(res, float)
        return res
    }

    fun floats(float0: Float, float1: Float): Ptr {
        val res = ptr advance (4 * 2)
        MemoryUtil.memPutFloat(res, float0)
        MemoryUtil.memPutFloat(res + 4, float1)
        return res
    }

    fun floats(float0: Float, float1: Float, float2: Float): Ptr {
        val res = ptr advance (4 * 3)
        MemoryUtil.memPutFloat(res, float0)
        MemoryUtil.memPutFloat(res + 4, float1)
        MemoryUtil.memPutFloat(res + 8, float2)
        return res
    }

    fun floats(float0: Float, float1: Float, float2: Float, float3: Float): Ptr {
        val res = ptr advance (4 * 4)
        MemoryUtil.memPutFloat(res, float0)
        MemoryUtil.memPutFloat(res + 4, float1)
        MemoryUtil.memPutFloat(res + 8, float2)
        MemoryUtil.memPutFloat(res + 12, float3)
        return res
    }

    fun floats(float0: Float, float1: Float, float2: Float, float3: Float, float4: Float): Ptr {
        val res = ptr advance (4 * 5)
        MemoryUtil.memPutFloat(res, float0)
        MemoryUtil.memPutFloat(res + 4, float1)
        MemoryUtil.memPutFloat(res + 8, float2)
        MemoryUtil.memPutFloat(res + 12, float3)
        MemoryUtil.memPutFloat(res + 16, float4)
        return res
    }

    fun doubles(double: Double): Ptr {
        val res = ptr advance 8
        MemoryUtil.memPutDouble(res, double)
        return res
    }

    fun doubles(double0: Double, double1: Double): Ptr {
        val res = ptr advance (8 * 2)
        MemoryUtil.memPutDouble(res, double0)
        MemoryUtil.memPutDouble(res + 4, double1)
        return res
    }

    fun doubles(double0: Double, double1: Double, double2: Double): Ptr {
        val res = ptr advance (8 * 3)
        MemoryUtil.memPutDouble(res, double0)
        MemoryUtil.memPutDouble(res + 4, double1)
        MemoryUtil.memPutDouble(res + 8, double2)
        return res
    }

    fun doubles(double0: Double, double1: Double, double2: Double, double3: Double): Ptr {
        val res = ptr advance (8 * 4)
        MemoryUtil.memPutDouble(res, double0)
        MemoryUtil.memPutDouble(res + 4, double1)
        MemoryUtil.memPutDouble(res + 8, double2)
        MemoryUtil.memPutDouble(res + 12, double3)
        return res
    }

    fun doubles(double0: Double, double1: Double, double2: Double, double3: Double, double4: Double): Ptr {
        val res = ptr advance (8 * 5)
        MemoryUtil.memPutDouble(res, double0)
        MemoryUtil.memPutDouble(res + 8, double1)
        MemoryUtil.memPutDouble(res + 16, double2)
        MemoryUtil.memPutDouble(res + 24, double3)
        MemoryUtil.memPutDouble(res + 30, double4)
        return res
    }


    infix fun byteBufferOf(byte: Byte): ByteBuffer {
        return buffer(1).put(0, byte)
    }

    fun bufferOf(byte0: Byte, byte1: Byte): ByteBuffer {
        return buffer(2).put(0, byte0).put(1, byte1)
    }

    fun bufferOf(byte0: Byte, byte1: Byte, byte2: Byte): ByteBuffer {
        return buffer(3).put(0, byte0).put(1, byte1).put(2, byte2)
    }

    fun bufferOf(byte0: Byte, byte1: Byte, byte2: Byte, byte3: Byte): ByteBuffer {
        return buffer(4).put(0, byte0).put(1, byte1).put(2, byte2).put(3, byte3)
    }

    fun bufferOf(byte0: Byte, byte1: Byte, byte2: Byte, byte3: Byte, byte4: Byte): ByteBuffer {
        return buffer(5).put(0, byte0).put(1, byte1).put(2, byte2).put(3, byte3).put(4, byte4)
    }

    fun bufferOf(vararg bytes: Byte): ByteBuffer {
        val res = buffer(bytes.size)
        for (i in bytes.indices)
            res.put(i, bytes[i])
        return res
    }

    fun bufferOf(bytes: Collection<Byte>): ByteBuffer {
        val res = buffer(bytes.size)
        for (i in bytes.indices)
            res.put(i, bytes.elementAt(i))
        return res
    }


    infix fun shortBufferOf(short: Short): ShortBuffer {
        return shortBuffer(1).put(0, short)
    }

    fun shortBufferOf(short0: Short, short1: Short): ShortBuffer {
        return shortBuffer(2).put(0, short0).put(1, short1)
    }

    fun shortBufferOf(short0: Short, short1: Short, short2: Short): ShortBuffer {
        return shortBuffer(3).put(0, short0).put(1, short1).put(2, short2)
    }

    fun shortBufferOf(short0: Short, short1: Short, short2: Short, short3: Short): ShortBuffer {
        return shortBuffer(4).put(0, short0).put(1, short1).put(2, short2).put(3, short3)
    }

    fun shortBufferOf(short0: Short, short1: Short, short2: Short, short3: Short, short4: Short): ShortBuffer {
        return shortBuffer(5).put(0, short0).put(1, short1).put(2, short2).put(3, short3).put(4, short4)
    }

    fun shortBufferOf(vararg shorts: Short): ShortBuffer {
        val res = shortBuffer(shorts.size)
        for (i in shorts.indices)
            res.put(i, shorts[i])
        return res
    }

    fun shortBufferOf(shorts: Collection<Short>): ShortBuffer {
        val res = shortBuffer(shorts.size)
        for (i in shorts.indices)
            res.put(i, shorts.elementAt(i))
        return res
    }


    infix fun intBufferOf(int: Int): IntBuffer {
        return intBuffer(1).put(0, int)
    }

    fun intBufferOf(int0: Int, int1: Int): IntBuffer {
        return intBuffer(2).put(0, int0).put(1, int1)
    }

    fun intBufferOf(int0: Int, int1: Int, int2: Int): IntBuffer {
        return intBuffer(3).put(0, int0).put(1, int1).put(2, int2)
    }

    fun intBufferOf(int0: Int, int1: Int, int2: Int, int3: Int): IntBuffer {
        return intBuffer(4).put(0, int0).put(1, int1).put(2, int2).put(3, int3)
    }

    fun intBufferOf(int0: Int, int1: Int, int2: Int, int3: Int, int4: Int): IntBuffer {
        return intBuffer(5).put(0, int0).put(1, int1).put(2, int2).put(3, int3).put(4, int4)
    }

    fun intBufferOf(vararg ints: Int): IntBuffer {
        val res = intBuffer(ints.size)
        for (i in ints.indices)
            res.put(i, ints[i])
        return res
    }

    fun intBufferOf(ints: Collection<Int>): IntBuffer {
        val res = intBuffer(ints.size)
        for (i in ints.indices)
            res.put(i, ints.elementAt(i))
        return res
    }


    infix fun longBufferOf(long: Long): LongBuffer {
        return longBuffer(1).put(0, long)
    }

    fun longBufferOf(long0: Long, long1: Long): LongBuffer {
        return longBuffer(2).put(0, long0).put(1, long1)
    }

    fun longBufferOf(long0: Long, long1: Long, long2: Long): LongBuffer {
        return longBuffer(3).put(0, long0).put(1, long1).put(2, long2)
    }

    fun longBufferOf(long0: Long, long1: Long, long2: Long, long3: Long): LongBuffer {
        return longBuffer(4).put(0, long0).put(1, long1).put(2, long2).put(3, long3)
    }

    fun longBufferOf(long0: Long, long1: Long, long2: Long, long3: Long, long4: Long): LongBuffer {
        return longBuffer(5).put(0, long0).put(1, long1).put(2, long2).put(3, long3).put(4, long4)
    }

    fun longBufferOf(vararg longs: Long): LongBuffer {
        val res = longBuffer(longs.size)
        for (i in longs.indices)
            res.put(i, longs[i])
        return res
    }

    fun longBufferOf(longs: Collection<Long>): LongBuffer {
        val res = longBuffer(longs.size)
        for (i in longs.indices)
            res.put(i, longs.elementAt(i))
        return res
    }


    infix fun floatBufferOf(float: Float): FloatBuffer {
        return floatBuffer(1).put(0, float)
    }

    fun floatBufferOf(float0: Float, float1: Float): FloatBuffer {
        return floatBuffer(2).put(0, float0).put(1, float1)
    }

    fun floatBufferOf(float0: Float, float1: Float, float2: Float): FloatBuffer {
        return floatBuffer(3).put(0, float0).put(1, float1).put(2, float2)
    }

    fun floatBufferOf(float0: Float, float1: Float, float2: Float, float3: Float): FloatBuffer {
        return floatBuffer(4).put(0, float0).put(1, float1).put(2, float2).put(3, float3)
    }

    fun floatBufferOf(float0: Float, float1: Float, float2: Float, float3: Float, float4: Float): FloatBuffer {
        return floatBuffer(5).put(0, float0).put(1, float1).put(2, float2).put(3, float3).put(4, float4)
    }

    fun floatBufferOf(vararg floats: Float): FloatBuffer {
        val res = floatBuffer(floats.size)
        for (i in floats.indices)
            res.put(i, floats[i])
        return res
    }


    infix fun doubleBufferOf(double: Double): DoubleBuffer {
        return doubleBuffer(1).put(0, double)
    }

    fun doubleBufferOf(double0: Double, double1: Double): DoubleBuffer {
        return doubleBuffer(2).put(0, double0).put(1, double1)
    }

    fun doubleBufferOf(double0: Double, double1: Double, double2: Double): DoubleBuffer {
        return doubleBuffer(3).put(0, double0).put(1, double1).put(2, double2)
    }

    fun doubleBufferOf(double0: Double, double1: Double, double2: Double, double3: Double): DoubleBuffer {
        return doubleBuffer(4).put(0, double0).put(1, double1).put(2, double2).put(3, double3)
    }

    fun doubleBufferOf(double0: Double, double1: Double, double2: Double, double3: Double, double4: Double): DoubleBuffer {
        return doubleBuffer(5).put(0, double0).put(1, double1).put(2, double2).put(3, double3).put(4, double4)
    }

    fun doubleBufferOf(vararg doubles: Double): DoubleBuffer {
        val res = doubleBuffer(doubles.size)
        for (i in doubles.indices)
            res.put(i, doubles[i])
        return res
    }


    fun pointerOfAscii(string: String, nullTerminated: Boolean = true): Ptr {
        val bytes = byteArray(string.length + if (nullTerminated) 1 else 0)
        for (i in string.indices)
            MemoryUtil.memPutByte(bytes + i, string[i].toByte())
        if (nullTerminated)
            MemoryUtil.memPutByte(bytes + string.length, 0)
        return bytes
    }

    fun bufferOfAscii(string: String, nullTerminated: Boolean = true): ByteBuffer {
        val bytes = buffer(string.length + if (nullTerminated) 1 else 0)
        for (i in string.indices)
            bytes.put(i, string[i].toByte())
        if (nullTerminated)
            bytes.put(string.length, 0)
        return bytes
    }


//    fun pointerOfUtf8(string: String, nullTerminated: Boolean = true): Ptr { TODO
//        val bytes = byteArray(MemoryUtil.memLengthUTF8(string, nullTerminated))
//        MemoryUtil.memUTF8(string, nullTerminated, bytes)
//        return bytes
//    }

    fun bufferOfUtf8(string: String, nullTerminated: Boolean = true): ByteBuffer {
        val bytes = buffer(MemoryUtil.memLengthUTF8(string, nullTerminated))
        MemoryUtil.memUTF8(string, nullTerminated, bytes)
        return bytes
    }


    fun buffer(size: Int): ByteBuffer = MemoryUtil.memByteBuffer(ptr.advance(size), size)
    inline fun buffer(size: Int, block: (Int) -> Byte): ByteBuffer {
        val res = buffer(size)
        for (i in 0 until res.remaining())
            res.put(i, block(i))
        return res
    }

    fun shortBuffer(size: Int): ShortBuffer = MemoryUtil.memShortBuffer(ptr.advance(2 * size), size)
    inline fun shortBuffer(size: Int, block: (Int) -> Short): ShortBuffer {
        val res = shortBuffer(size)
        for (i in 0 until res.remaining())
            res.put(i, block(i))
        return res
    }

    fun intBuffer(size: Int): IntBuffer = MemoryUtil.memIntBuffer(ptr.advance(4 * size), size)
    inline fun intBuffer(size: Int, block: (Int) -> Int): IntBuffer {
        val res = intBuffer(size)
        for (i in 0 until res.remaining())
            res.put(i, block(i))
        return res
    }

    fun longBuffer(size: Int): LongBuffer = MemoryUtil.memLongBuffer(ptr.advance(8 * size), size)
    inline fun longBuffer(size: Int, block: (Int) -> Long): LongBuffer {
        val res = longBuffer(size)
        for (i in 0 until res.remaining())
            res.put(i, block(i))
        return res
    }

    fun floatBuffer(size: Int): FloatBuffer = MemoryUtil.memFloatBuffer(ptr.advance(4 * size), size)
    inline fun floatBuffer(size: Int, block: (Int) -> Float): FloatBuffer {
        val res = floatBuffer(size)
        for (i in 0 until res.remaining())
            res.put(i, block(i))
        return res
    }

    fun doubleBuffer(size: Int): DoubleBuffer = MemoryUtil.memDoubleBuffer(ptr.advance(8 * size), size)
    inline fun doubleBuffer(size: Int, block: (Int) -> Double): DoubleBuffer {
        val res = doubleBuffer(size)
        for (i in 0 until res.remaining())
            res.put(i, block(i))
        return res
    }

    fun reset() {
        ptr.set(address)
        MemoryUtil.memSet(address, 0, SIZE.toLong())
    }


    // getters

    inline fun withBytePtr(block: (Ptr) -> Unit): Byte {
        val ptr = byte
        block(ptr)
        return MemoryUtil.memGetByte(ptr)
    }

    inline fun withByteBuffer(block: (ByteBuffer) -> Unit): Byte {
        val buf = byteBuffer
        block(buf)
        return buf[0]
    }

    inline fun withShortPtr(block: (Ptr) -> Unit): Short {
        val ptr = short
        block(ptr)
        return MemoryUtil.memGetShort(ptr)
    }

    inline fun withShortBuffer(block: (ShortBuffer) -> Unit): Short {
        val buf = shortBuffer
        block(buf)
        return buf[0]
    }

    inline fun withIntPtr(block: (Ptr) -> Unit): Int {
        val ptr = int
        block(ptr)
        return MemoryUtil.memGetInt(ptr)
    }

    inline fun withIntBuffer(block: (IntBuffer) -> Unit): Int {
        val buf = intBuffer
        block(buf)
        return buf[0]
    }

    inline fun withLongPtr(block: (Ptr) -> Unit): Long {
        val ptr = long
        block(ptr)
        return MemoryUtil.memGetLong(ptr)
    }

    inline fun withLongBuffer(block: (LongBuffer) -> Unit): Long {
        val buf = longBuffer
        block(buf)
        return buf[0]
    }

    inline fun withFloatPtr(block: (Ptr) -> Unit): Float {
        val ptr = float
        block(ptr)
        return MemoryUtil.memGetFloat(ptr)
    }

    inline fun withFloatBuffer(block: (FloatBuffer) -> Unit): Float {
        val buf = floatBuffer
        block(buf)
        return buf[0]
    }

    inline fun withDoublePtr(block: (Ptr) -> Unit): Double {
        val ptr = double
        block(ptr)
        return MemoryUtil.memGetDouble(ptr)
    }

    inline fun withFloatBuffer(block: (DoubleBuffer) -> Unit): Double {
        val buf = doubleBuffer
        block(buf)
        return buf[0]
    }

    // setters

    inline fun withBytePtr(byte: Byte, block: (Ptr) -> Unit) {
        val ptr = this.byte
        MemoryUtil.memPutByte(ptr, byte)
        block(ptr)
    }

    inline fun withByteBuffer(byte: Byte, block: (ByteBuffer) -> Unit) {
        val buf = byteBuffer
        buf.put(0, byte)
        block(buf)
    }

    inline fun withShortPtr(short: Short, block: (Ptr) -> Unit) {
        val ptr = this.short
        MemoryUtil.memPutShort(ptr, short)
        block(ptr)
    }

    inline fun withShortBuffer(short: Short, block: (ShortBuffer) -> Unit) {
        val buf = shortBuffer
        buf.put(0, short)
        block(buf)
    }

    inline fun withIntPtr(int: Int, block: (Ptr) -> Unit) {
        val ptr = this.int
        MemoryUtil.memPutInt(ptr, int)
        block(ptr)
    }

    inline fun withIntBuffer(int: Int, block: (IntBuffer) -> Unit) {
        val buf = intBuffer
        buf.put(0, int)
        block(buf)
    }

    inline fun withLongPtr(long: Long, block: (Ptr) -> Unit) {
        val ptr = this.long
        MemoryUtil.memPutLong(ptr, long)
        block(ptr)
    }

    inline fun withLongBuffer(long: Long, block: (LongBuffer) -> Unit) {
        val buf = longBuffer
        buf.put(0, long)
        block(buf)
    }

    inline fun withFloatPtr(float: Float, block: (Ptr) -> Unit) {
        val ptr = this.float
        MemoryUtil.memPutFloat(ptr, float)
        block(ptr)
    }

    inline fun withFloatBuffer(float: Float, block: (FloatBuffer) -> Unit) {
        val buf = floatBuffer
        buf.put(0, float)
        block(buf)
    }

    inline fun withDoublePtr(double: Double, block: (Ptr) -> Unit) {
        val ptr = this.double
        MemoryUtil.memPutDouble(ptr, double)
        block(ptr)
    }

    inline fun withDoubleBuffer(double: Double, block: (DoubleBuffer) -> Unit) {
        val buf = doubleBuffer
        buf.put(0, double)
        block(buf)
    }


    fun next() = MemoryUtil.memGetByte(ptr.get())
    fun printNext() = println("@${ptr.get() - address}: ${next()}")
    val remaining get() = SIZE - consumed
    val consumed get() = ptr.get() - address

    val VERSION = "0.4"
}