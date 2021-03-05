package kool

import org.lwjgl.PointerBuffer
import org.lwjgl.system.MemoryStack
import org.lwjgl.system.MemoryUtil
import org.lwjgl.system.MemoryUtil.memASCII
import org.lwjgl.system.Pointer
import java.nio.*
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract


object Stack {

    // one-slot buffers

//    inline val byteBuffer: ByteBuffer
//        get() = memByteBuffer(ptr advance 1, 1)
//
//    inline val shortBuffer: ShortBuffer
//        get() = memShortBuffer(ptr advance 2, 1)
//
//    inline val intBuffer: IntBuffer
//        get() = memIntBuffer(ptr advance 4, 1)
//
//    inline val longBuffer: LongBuffer
//        get() = memLongBuffer(ptr advance 8, 1)
//
//    inline val floatBuffer: FloatBuffer
//        get() = memFloatBuffer(ptr advance 4, 1)
//
//    inline val doubleBuffer: DoubleBuffer
//        get() = memDoubleBuffer(ptr advance 8, 1)
//
//    inline val pointerBuffer: PointerBuffer
//        get() = memPointerBuffer(ptr advance Pointer.POINTER_SIZE, 1)
//
//    inline val byte: Ptr get() = ptr advance 1
//    inline val short: Ptr get() = ptr advance 2
//    inline val int: Ptr get() = ptr advance 4
//    inline val long: Ptr get() = ptr advance 8
//    inline val float: Ptr get() = ptr advance 4
//    inline val double: Ptr get() = ptr advance 8
//    inline val pointer: Ptr get() = ptr advance Pointer.POINTER_SIZE

//    fun byteArray(size: Int): Ptr = ptr.advance(size)
//    fun shortArray(size: Int): Ptr = ptr.advance(2 * size)
//    fun intArray(size: Int): Ptr = ptr.advance(4 * size)
//    fun longArray(size: Int): Ptr = ptr.advance(8 * size)
//    fun floatArray(size: Int): Ptr = ptr.advance(4 * size)
//    fun doubleArray(size: Int): Ptr = ptr.advance(8 * size)
//    fun pointerArray(size: Int): Ptr = ptr.advance(Pointer.POINTER_SIZE * size)
//
//
//    infix fun pointerBuffer(capacity: Int): PointerBuffer {
//        var vbo: Int
//        val size = Pointer.POINTER_SIZE * capacity
//        return memPointerBuffer(ptr advance size, capacity)
//    }
//
//    infix fun pointerBufferOf(pointer: Pointer): PointerBuffer {
//        return pointerBuffer(1).put(0, pointer)
//    }
//
//    fun pointerBufferOf(pointer0: Pointer, pointer1: Pointer): PointerBuffer {
//        return pointerBuffer(2).put(0, pointer0).put(1, pointer1)
//    }
//
//    fun pointerBufferOf(pointer0: Pointer, pointer1: Pointer, pointer2: Pointer): PointerBuffer {
//        return pointerBuffer(3).put(0, pointer0).put(1, pointer1).put(2, pointer2)
//    }
//
//    fun pointerBufferOf(pointer0: Pointer, pointer1: Pointer, pointer2: Pointer, pointer3: Pointer): PointerBuffer {
//        return pointerBuffer(4).put(0, pointer0).put(1, pointer1).put(2, pointer2).put(3, pointer3)
//    }
//
//    fun pointerBufferOf(pointer0: Pointer, pointer1: Pointer, pointer2: Pointer, pointer3: Pointer, pointer4: Pointer): PointerBuffer {
//        return pointerBuffer(5).put(0, pointer0).put(1, pointer1).put(2, pointer2).put(3, pointer3).put(4, pointer4)
//    }
//
//    fun pointerBufferOf(pointers: Collection<Pointer>): PointerBuffer {
//        val res = pointerBuffer(pointers.size)
//        for (i in pointers.indices)
//            res.put(i, pointers.elementAt(i))
//        return res
//    }
//
//
//    infix fun pointerBufferOf(long: Ptr): PointerBuffer {
//        return pointerBuffer(1).put(0, long)
//    }
//
//    fun pointerBufferOf(long0: Ptr, long1: Ptr): PointerBuffer {
//        return pointerBuffer(2).put(0, long0).put(1, long1)
//    }
//
//    fun pointerBufferOf(long0: Ptr, long1: Ptr, long2: Ptr): PointerBuffer {
//        return pointerBuffer(3).put(0, long0).put(1, long1).put(2, long2)
//    }
//
//    fun pointerBufferOf(long0: Ptr, long1: Ptr, long2: Ptr, long3: Ptr): PointerBuffer {
//        return pointerBuffer(4).put(0, long0).put(1, long1).put(2, long2).put(3, long3)
//    }
//
//    fun pointerBufferOf(long0: Ptr, long1: Ptr, long2: Ptr, long3: Ptr, long4: Ptr): PointerBuffer {
//        return pointerBuffer(5).put(0, long0).put(1, long1).put(2, long2).put(3, long3).put(4, long4)
//    }
//
//    fun pointerBufferOf_(pointers: Collection<Ptr>): PointerBuffer {
//        val res = pointerBuffer(pointers.size)
//        for (i in pointers.indices)
//            res.put(i, pointers.elementAt(i))
//        return res
//    }
//
//    // TODO other bytes(other number types)?
//
//    fun bytes(byte: Byte): Ptr {
//        val res = ptr advance 1
//        memPutByte(res, byte)
//        return res
//    }
//
//    fun bytes(byte0: Byte, byte1: Byte): Ptr {
//        val res = ptr advance 2
//        memPutByte(res, byte0)
//        memPutByte(res + 1, byte1)
//        return res
//    }
//
//    fun bytes(byte0: Byte, byte1: Byte, byte2: Byte): Ptr {
//        val res = ptr advance 3
//        memPutByte(res, byte0)
//        memPutByte(res + 1, byte1)
//        memPutByte(res + 2, byte2)
//        return res
//    }
//
//    fun bytes(byte0: Byte, byte1: Byte, byte2: Byte, byte3: Byte): Ptr {
//        val res = ptr advance 4
//        memPutByte(res, byte0)
//        memPutByte(res + 1, byte1)
//        memPutByte(res + 2, byte2)
//        memPutByte(res + 3, byte3)
//        return res
//    }
//
//    fun bytes(byte0: Byte, byte1: Byte, byte2: Byte, byte3: Byte, byte4: Byte): Ptr {
//        val res = ptr advance 5
//        memPutByte(res, byte0)
//        memPutByte(res + 1, byte1)
//        memPutByte(res + 2, byte2)
//        memPutByte(res + 3, byte3)
//        memPutByte(res + 4, byte4)
//        return res
//    }
//
//    fun shorts(short: Short): Ptr {
//        val res = ptr advance 2
//        memPutShort(res, short)
//        return res
//    }
//
//    fun shorts(short0: Short, short1: Short): Ptr {
//        val res = ptr advance (2 * 2)
//        memPutShort(res, short0)
//        memPutShort(res + 2, short1)
//        return res
//    }
//
//    fun shorts(short0: Short, short1: Short, short2: Short): Ptr {
//        val res = ptr advance (2 * 3)
//        memPutShort(res, short0)
//        memPutShort(res + 2, short1)
//        memPutShort(res + 4, short2)
//        return res
//    }
//
//    fun shorts(short0: Short, short1: Short, short2: Short, short3: Short): Ptr {
//        val res = ptr advance (2 * 4)
//        memPutShort(res, short0)
//        memPutShort(res + 2, short1)
//        memPutShort(res + 4, short2)
//        memPutShort(res + 6, short3)
//        return res
//    }
//
//    fun shorts(short0: Short, short1: Short, short2: Short, short3: Short, short4: Short): Ptr {
//        val res = ptr advance (2 * 5)
//        memPutShort(res, short0)
//        memPutShort(res + 2, short1)
//        memPutShort(res + 4, short2)
//        memPutShort(res + 6, short3)
//        memPutShort(res + 8, short4)
//        return res
//    }
//
//    fun ints(int: Int): Ptr {
//        val res = ptr advance 4
//        memPutInt(res, int)
//        return res
//    }
//
//    fun ints(int0: Int, int1: Int): Ptr {
//        val res = ptr advance (4 * 2)
//        memPutInt(res, int0)
//        memPutInt(res + 4, int1)
//        return res
//    }
//
//    fun ints(int0: Int, int1: Int, int2: Int): Ptr {
//        val res = ptr advance (4 * 3)
//        memPutInt(res, int0)
//        memPutInt(res + 4, int1)
//        memPutInt(res + 8, int2)
//        return res
//    }
//
//    fun ints(int0: Int, int1: Int, int2: Int, int3: Int): Ptr {
//        val res = ptr advance (4 * 4)
//        memPutInt(res, int0)
//        memPutInt(res + 4, int1)
//        memPutInt(res + 8, int2)
//        memPutInt(res + 12, int3)
//        return res
//    }
//
//    fun ints(int0: Int, int1: Int, int2: Int, int3: Int, int4: Int): Ptr {
//        val res = ptr advance (4 * 5)
//        memPutInt(res, int0)
//        memPutInt(res + 4, int1)
//        memPutInt(res + 8, int2)
//        memPutInt(res + 12, int3)
//        memPutInt(res + 16, int4)
//        return res
//    }
//
//    fun longs(long: Long): Ptr {
//        val res = ptr advance 8
//        memPutLong(res, long)
//        return res
//    }
//
//    fun longs(long0: Long, long1: Long): Ptr {
//        val res = ptr advance (8 * 2)
//        memPutLong(res, long0)
//        memPutLong(res + 4, long1)
//        return res
//    }
//
//    fun longs(long0: Long, long1: Long, long2: Long): Ptr {
//        val res = ptr advance (8 * 3)
//        memPutLong(res, long0)
//        memPutLong(res + 4, long1)
//        memPutLong(res + 8, long2)
//        return res
//    }
//
//    fun longs(long0: Long, long1: Long, long2: Long, long3: Long): Ptr {
//        val res = ptr advance (8 * 4)
//        memPutLong(res, long0)
//        memPutLong(res + 4, long1)
//        memPutLong(res + 8, long2)
//        memPutLong(res + 12, long3)
//        return res
//    }
//
//    fun longs(long0: Long, long1: Long, long2: Long, long3: Long, long4: Long): Ptr {
//        val res = ptr advance (8 * 5)
//        memPutLong(res, long0)
//        memPutLong(res + 4, long1)
//        memPutLong(res + 8, long2)
//        memPutLong(res + 12, long3)
//        memPutLong(res + 16, long4)
//        return res
//    }
//
//    fun floats(float: Float): Ptr {
//        val res = ptr advance 4
//        memPutFloat(res, float)
//        return res
//    }
//
//    fun floats(float0: Float, float1: Float): Ptr {
//        val res = ptr advance (4 * 2)
//        memPutFloat(res, float0)
//        memPutFloat(res + 4, float1)
//        return res
//    }
//
//    fun floats(float0: Float, float1: Float, float2: Float): Ptr {
//        val res = ptr advance (4 * 3)
//        memPutFloat(res, float0)
//        memPutFloat(res + 4, float1)
//        memPutFloat(res + 8, float2)
//        return res
//    }
//
//    fun floats(float0: Float, float1: Float, float2: Float, float3: Float): Ptr {
//        val res = ptr advance (4 * 4)
//        memPutFloat(res, float0)
//        memPutFloat(res + 4, float1)
//        memPutFloat(res + 8, float2)
//        memPutFloat(res + 12, float3)
//        return res
//    }
//
//    fun floats(float0: Float, float1: Float, float2: Float, float3: Float, float4: Float): Ptr {
//        val res = ptr advance (4 * 5)
//        memPutFloat(res, float0)
//        memPutFloat(res + 4, float1)
//        memPutFloat(res + 8, float2)
//        memPutFloat(res + 12, float3)
//        memPutFloat(res + 16, float4)
//        return res
//    }
//
//    fun doubles(double: Double): Ptr {
//        val res = ptr advance 8
//        memPutDouble(res, double)
//        return res
//    }
//
//    fun doubles(double0: Double, double1: Double): Ptr {
//        val res = ptr advance (8 * 2)
//        memPutDouble(res, double0)
//        memPutDouble(res + 4, double1)
//        return res
//    }
//
//    fun doubles(double0: Double, double1: Double, double2: Double): Ptr {
//        val res = ptr advance (8 * 3)
//        memPutDouble(res, double0)
//        memPutDouble(res + 4, double1)
//        memPutDouble(res + 8, double2)
//        return res
//    }
//
//    fun doubles(double0: Double, double1: Double, double2: Double, double3: Double): Ptr {
//        val res = ptr advance (8 * 4)
//        memPutDouble(res, double0)
//        memPutDouble(res + 4, double1)
//        memPutDouble(res + 8, double2)
//        memPutDouble(res + 12, double3)
//        return res
//    }
//
//    fun doubles(double0: Double, double1: Double, double2: Double, double3: Double, double4: Double): Ptr {
//        val res = ptr advance (8 * 5)
//        memPutDouble(res, double0)
//        memPutDouble(res + 8, double1)
//        memPutDouble(res + 16, double2)
//        memPutDouble(res + 24, double3)
//        memPutDouble(res + 30, double4)
//        return res
//    }
//
//
//    infix fun byteBufferOf(byte: Byte): ByteBuffer {
//        return buffer(1).put(0, byte)
//    }
//
//    fun bufferOf(byte0: Byte, byte1: Byte): ByteBuffer {
//        return buffer(2).put(0, byte0).put(1, byte1)
//    }
//
//    fun bufferOf(byte0: Byte, byte1: Byte, byte2: Byte): ByteBuffer {
//        return buffer(3).put(0, byte0).put(1, byte1).put(2, byte2)
//    }
//
//    fun bufferOf(byte0: Byte, byte1: Byte, byte2: Byte, byte3: Byte): ByteBuffer {
//        return buffer(4).put(0, byte0).put(1, byte1).put(2, byte2).put(3, byte3)
//    }
//
//    fun bufferOf(byte0: Byte, byte1: Byte, byte2: Byte, byte3: Byte, byte4: Byte): ByteBuffer {
//        return buffer(5).put(0, byte0).put(1, byte1).put(2, byte2).put(3, byte3).put(4, byte4)
//    }
//
//    fun bufferOf(vararg bytes: Byte): ByteBuffer {
//        val res = buffer(bytes.size)
//        for (i in bytes.indices)
//            res.put(i, bytes[i])
//        return res
//    }
//
//    fun bufferOf(bytes: Collection<Byte>): ByteBuffer {
//        val res = buffer(bytes.size)
//        for (i in bytes.indices)
//            res.put(i, bytes.elementAt(i))
//        return res
//    }
//
//
//    infix fun shortBufferOf(short: Short): ShortBuffer {
//        return shortBuffer(1).put(0, short)
//    }
//
//    fun shortBufferOf(short0: Short, short1: Short): ShortBuffer {
//        return shortBuffer(2).put(0, short0).put(1, short1)
//    }
//
//    fun shortBufferOf(short0: Short, short1: Short, short2: Short): ShortBuffer {
//        return shortBuffer(3).put(0, short0).put(1, short1).put(2, short2)
//    }
//
//    fun shortBufferOf(short0: Short, short1: Short, short2: Short, short3: Short): ShortBuffer {
//        return shortBuffer(4).put(0, short0).put(1, short1).put(2, short2).put(3, short3)
//    }
//
//    fun shortBufferOf(short0: Short, short1: Short, short2: Short, short3: Short, short4: Short): ShortBuffer {
//        return shortBuffer(5).put(0, short0).put(1, short1).put(2, short2).put(3, short3).put(4, short4)
//    }
//
//    fun shortBufferOf(vararg shorts: Short): ShortBuffer {
//        val res = shortBuffer(shorts.size)
//        for (i in shorts.indices)
//            res.put(i, shorts[i])
//        return res
//    }
//
//    fun shortBufferOf(shorts: Collection<Short>): ShortBuffer {
//        val res = shortBuffer(shorts.size)
//        for (i in shorts.indices)
//            res.put(i, shorts.elementAt(i))
//        return res
//    }
//
//
//    infix fun intBufferOf(int: Int): IntBuffer {
//        return intBuffer(1).put(0, int)
//    }
//
//    fun intBufferOf(int0: Int, int1: Int): IntBuffer {
//        return intBuffer(2).put(0, int0).put(1, int1)
//    }
//
//    fun intBufferOf(int0: Int, int1: Int, int2: Int): IntBuffer {
//        return intBuffer(3).put(0, int0).put(1, int1).put(2, int2)
//    }
//
//    fun intBufferOf(int0: Int, int1: Int, int2: Int, int3: Int): IntBuffer {
//        return intBuffer(4).put(0, int0).put(1, int1).put(2, int2).put(3, int3)
//    }
//
//    fun intBufferOf(int0: Int, int1: Int, int2: Int, int3: Int, int4: Int): IntBuffer {
//        return intBuffer(5).put(0, int0).put(1, int1).put(2, int2).put(3, int3).put(4, int4)
//    }
//
//    fun intBufferOf(vararg ints: Int): IntBuffer {
//        val res = intBuffer(ints.size)
//        for (i in ints.indices)
//            res.put(i, ints[i])
//        return res
//    }
//
//    fun intBufferOf(ints: Collection<Int>): IntBuffer {
//        val res = intBuffer(ints.size)
//        for (i in ints.indices)
//            res.put(i, ints.elementAt(i))
//        return res
//    }
//
//
//    infix fun longBufferOf(long: Long): LongBuffer {
//        return longBuffer(1).put(0, long)
//    }
//
//    fun longBufferOf(long0: Long, long1: Long): LongBuffer {
//        return longBuffer(2).put(0, long0).put(1, long1)
//    }
//
//    fun longBufferOf(long0: Long, long1: Long, long2: Long): LongBuffer {
//        return longBuffer(3).put(0, long0).put(1, long1).put(2, long2)
//    }
//
//    fun longBufferOf(long0: Long, long1: Long, long2: Long, long3: Long): LongBuffer {
//        return longBuffer(4).put(0, long0).put(1, long1).put(2, long2).put(3, long3)
//    }
//
//    fun longBufferOf(long0: Long, long1: Long, long2: Long, long3: Long, long4: Long): LongBuffer {
//        return longBuffer(5).put(0, long0).put(1, long1).put(2, long2).put(3, long3).put(4, long4)
//    }
//
//    fun longBufferOf(vararg longs: Long): LongBuffer {
//        val res = longBuffer(longs.size)
//        for (i in longs.indices)
//            res.put(i, longs[i])
//        return res
//    }
//
//    fun longBufferOf(longs: Collection<Long>): LongBuffer {
//        val res = longBuffer(longs.size)
//        for (i in longs.indices)
//            res.put(i, longs.elementAt(i))
//        return res
//    }
//
//
//    infix fun floatBufferOf(float: Float): FloatBuffer {
//        return floatBuffer(1).put(0, float)
//    }
//
//    fun floatBufferOf(float0: Float, float1: Float): FloatBuffer {
//        return floatBuffer(2).put(0, float0).put(1, float1)
//    }
//
//    fun floatBufferOf(float0: Float, float1: Float, float2: Float): FloatBuffer {
//        return floatBuffer(3).put(0, float0).put(1, float1).put(2, float2)
//    }
//
//    fun floatBufferOf(float0: Float, float1: Float, float2: Float, float3: Float): FloatBuffer {
//        return floatBuffer(4).put(0, float0).put(1, float1).put(2, float2).put(3, float3)
//    }
//
//    fun floatBufferOf(float0: Float, float1: Float, float2: Float, float3: Float, float4: Float): FloatBuffer {
//        return floatBuffer(5).put(0, float0).put(1, float1).put(2, float2).put(3, float3).put(4, float4)
//    }
//
//    fun floatBufferOf(vararg floats: Float): FloatBuffer {
//        val res = floatBuffer(floats.size)
//        for (i in floats.indices)
//            res.put(i, floats[i])
//        return res
//    }
//
//
//    infix fun doubleBufferOf(double: Double): DoubleBuffer {
//        return doubleBuffer(1).put(0, double)
//    }
//
//    fun doubleBufferOf(double0: Double, double1: Double): DoubleBuffer {
//        return doubleBuffer(2).put(0, double0).put(1, double1)
//    }
//
//    fun doubleBufferOf(double0: Double, double1: Double, double2: Double): DoubleBuffer {
//        return doubleBuffer(3).put(0, double0).put(1, double1).put(2, double2)
//    }
//
//    fun doubleBufferOf(double0: Double, double1: Double, double2: Double, double3: Double): DoubleBuffer {
//        return doubleBuffer(4).put(0, double0).put(1, double1).put(2, double2).put(3, double3)
//    }
//
//    fun doubleBufferOf(double0: Double, double1: Double, double2: Double, double3: Double, double4: Double): DoubleBuffer {
//        return doubleBuffer(5).put(0, double0).put(1, double1).put(2, double2).put(3, double3).put(4, double4)
//    }
//
//    fun doubleBufferOf(vararg doubles: Double): DoubleBuffer {
//        val res = doubleBuffer(doubles.size)
//        for (i in doubles.indices)
//            res.put(i, doubles[i])
//        return res
//    }
//
//
//    fun pointerOfAscii(string: String, nullTerminated: Boolean = true): Ptr {
//        val bytes = byteArray(string.length + if (nullTerminated) 1 else 0)
//        for (i in string.indices)
//            memPutByte(bytes + i, string[i].toByte())
//        if (nullTerminated)
//            memPutByte(bytes + string.length, 0)
//        return bytes
//    }
//
//    fun bufferOfAscii(string: String, nullTerminated: Boolean = true): ByteBuffer {
//        val bytes = buffer(string.length + if (nullTerminated) 1 else 0)
//        for (i in string.indices)
//            bytes.put(i, string[i].toByte())
//        if (nullTerminated)
//            bytes.put(string.length, 0)
//        return bytes
//    }
//
//
////    fun pointerOfUtf8(string: String, nullTerminated: Boolean = true): Ptr { TODO
////        val bytes = byteArray(memLengthUTF8(string, nullTerminated))
////        memUTF8(string, nullTerminated, bytes)
////        return bytes
////    }
//
//    fun bufferOfUtf8(string: String, nullTerminated: Boolean = true): ByteBuffer {
//        val bytes = buffer(memLengthUTF8(string, nullTerminated))
//        memUTF8(string, nullTerminated, bytes)
//        return bytes
//    }
//
//
//    fun buffer(size: Int): ByteBuffer = memByteBuffer(ptr.advance(size), size)
//    inline fun buffer(size: Int, block: (Int) -> Byte): ByteBuffer {
//        val res = buffer(size)
//        for (i in 0 until res.remaining())
//            res.put(i, block(i))
//        return res
//    }
//
//    fun shortBuffer(size: Int): ShortBuffer = memShortBuffer(ptr.advance(2 * size), size)
//    inline fun shortBuffer(size: Int, block: (Int) -> Short): ShortBuffer {
//        val res = shortBuffer(size)
//        for (i in 0 until res.remaining())
//            res.put(i, block(i))
//        return res
//    }
//
//    fun intBuffer(size: Int): IntBuffer = memIntBuffer(ptr.advance(4 * size), size)
//    inline fun intBuffer(size: Int, block: (Int) -> Int): IntBuffer {
//        val res = intBuffer(size)
//        for (i in 0 until res.remaining())
//            res.put(i, block(i))
//        return res
//    }
//
//    fun longBuffer(size: Int): LongBuffer = memLongBuffer(ptr.advance(8 * size), size)
//    inline fun longBuffer(size: Int, block: (Int) -> Long): LongBuffer {
//        val res = longBuffer(size)
//        for (i in 0 until res.remaining())
//            res.put(i, block(i))
//        return res
//    }
//
//    fun floatBuffer(size: Int): FloatBuffer = memFloatBuffer(ptr.advance(4 * size), size)
//    inline fun floatBuffer(size: Int, block: (Int) -> Float): FloatBuffer {
//        val res = floatBuffer(size)
//        for (i in 0 until res.remaining())
//            res.put(i, block(i))
//        return res
//    }
//
//    fun doubleBuffer(size: Int): DoubleBuffer = memDoubleBuffer(ptr.advance(8 * size), size)
//    inline fun doubleBuffer(size: Int, block: (Int) -> Double): DoubleBuffer {
//        val res = doubleBuffer(size)
//        for (i in 0 until res.remaining())
//            res.put(i, block(i))
//        return res
//    }
//
//    fun reset() {
//        ptr.set(address)
//        memSet(address, 0, SIZE.toLong())
//    }


    // --------------------------------------------- getters ---------------------------------------------

    inline fun <R> byteAdr(block: (Adr) -> R): Byte = with {
        val pByte = it.mByte()
        block(pByte.adr)
        pByte()
    }

    inline fun <R> byteBuffer(block: (ByteBuffer) -> R): Byte = with {
        val buf = it.malloc(1)
        block(buf)
        buf[0]
    }

    inline fun <R> shortAdr(block: (Adr) -> R): Short = with {
        val pShort = it.mShort()
        block(pShort.adr)
        pShort()
    }

    inline fun <R> shortBuffer(block: (ShortBuffer) -> R): Short = with {
        val buf = it.mallocShort(1)
        block(buf)
        buf[0]
    }

    inline fun <R> intAdr(block: (Adr) -> R): Int = with {
        val pInt = it.mInt()
        block(pInt.adr)
        pInt()
    }

    inline fun <R> intBuffer(block: (IntBuffer) -> R): Int = with {
        val buf = it.mallocInt(1)
        block(buf)
        buf[0]
    }

    inline fun <R> longAdr(block: (Adr) -> R): Long = with {
        val pLong = it.mLong()
        block(pLong.adr)
        pLong()
    }

    inline fun <R> longBuffer(block: (LongBuffer) -> R): Long = with {
        val buf = it.mallocLong(1)
        block(buf)
        buf[0]
    }

    inline fun <R> floatAdr(block: (Adr) -> R): Float = with {
        val pFloat = it.mFloat()
        block(pFloat.adr)
        pFloat()
    }

    inline fun <R> floatBuffer(block: (FloatBuffer) -> R): Float = with {
        val buf = it.mallocFloat(1)
        block(buf)
        buf[0]
    }

    inline fun <R> doubleAdr(block: (Adr) -> R): Double = with {
        val pDouble = it.mDouble()
        block(pDouble.adr)
        pDouble()
    }

    inline fun <R> doubleBuffer(block: (DoubleBuffer) -> R): Double = with {
        val buf = it.mallocDouble(1)
        block(buf)
        buf[0]
    }

    inline fun <R> pointerAdr(block: (Adr) -> R): Ptr = with {
        val pointer = it.mPointer()
        block(pointer.adr)
        pointer()
    }

    inline fun <R> pointerBuffer(block: (PointerBuffer) -> R): Ptr = with {
        val buf = it.mallocPointer(1)
        block(buf)
        buf[0]
    }

    /** It mallocs, passes the address and reads the null terminated string */
    inline fun <R> asciiAdr(maxSize: Int, block: (Adr) -> R): String = with {
        val adr = it.nmalloc(1, maxSize)
        block(adr)
        memASCII(adr, strlen64NT1(adr, maxSize))
    }

    /** It malloc the buffer, passes it and reads the null terminated string */
    inline fun <R> asciiBuffer(maxSize: Int, block: (ByteBuffer) -> R): String = with {
        val buf = it.malloc(1, maxSize)
        block(buf)
        memASCII(buf.adr, maxSize)
    }


    // --------------------------------------------- setters ---------------------------------------------

    inline fun <R> asciiAdr(chars: CharSequence, nullTerminated: Boolean = true, block: (Adr) -> R): R = with {
        it.nASCII(chars, nullTerminated)
        block(it.pointerAddress)
    }

    inline fun <R> asciiBuffer(chars: CharSequence, nullTerminated: Boolean = true, block: (ByteBuffer) -> R): R =
            with { block(it.ASCII(chars, nullTerminated)) }

    inline fun <R> byteAdr(byte: Byte, block: (Adr) -> R): R =
            with { block(it.ptrOf(byte).adr) }

    inline fun <R> byteBuffer(byte: Byte, block: (ByteBuffer) -> R): R =
            with { block(it.bytes(byte)) }

    inline fun <R> shortAdr(short: Short, block: (Adr) -> R): R =
            with { block(it.ptrOf(short).adr) }

    inline fun <R> shortBuffer(short: Short, block: (ShortBuffer) -> R): R =
            with { block(it.shorts(short)) }

    inline fun <R> intAdr(int: Int, block: (Adr) -> R): R =
            with { block(it.ptrOf(int).adr) }

    inline fun <R> intBuffer(int: Int, block: (IntBuffer) -> R): R =
            with { block(it.ints(int)) }

    inline fun <R> longAdr(long: Long, block: (Adr) -> R): R =
            with { block(it.ptrOf(long).adr) }

    inline fun <R> longBuffer(long: Long, block: (LongBuffer) -> R): R =
            with { block(it.longs(long)) }

    inline fun <R> floatAdr(float: Float, block: (Adr) -> R): R =
            with { block(it.ptrOf(float).adr) }

    inline fun <R> floatBuffer(float: Float, block: (FloatBuffer) -> R): R =
            with { block(it.floats(float)) }

    inline fun <R> doubleAdr(double: Double, block: (Adr) -> R): R =
            with { block(it.ptrOf(double).adr) }

    inline fun <R> doubleBuffer(double: Double, block: (DoubleBuffer) -> R): R =
            with { block(it.doubles(double)) }

    inline fun <R> pointerAdr(pointer: Pointer, block: (Adr) -> R): R =
            with { block(it.ptrOf(pointer).adr) }

    inline fun <R> pointerBuffer(pointer: Pointer, block: (PointerBuffer) -> R): R =
            with { block(it.pointers(pointer)) }

    inline fun <R> utf8Adr(chars: CharSequence, nullTerminated: Boolean = true, block: (Adr) -> R): R = with {
        val adr = it.nmalloc(1, MemoryUtil.memLengthASCII(chars, nullTerminated))
        encodeUTF8(chars, nullTerminated, adr)
        block(adr)
    }

    inline fun <R> utf8Buffer(chars: CharSequence, block: (ByteBuffer) -> R): R =
            with { block(it.UTF8(chars, true)) }

    val VERSION = "0.9.0"

    inline operator fun <R> invoke(block: (MemoryStack) -> R): R = with(block)
}

/**
 * same as [Stack.invoke] but with a callsInPlace contract
 */

@OptIn(ExperimentalContracts::class)
inline fun <R> Stack.with(block: (MemoryStack) -> R): R {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    val stack = MemoryStack.stackGet()
    val ptr = stack.pointer
    return block(stack).also {
        stack.pointer = ptr
    }
}