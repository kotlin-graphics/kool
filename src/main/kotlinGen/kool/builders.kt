@file:OptIn(kotlin.experimental.ExperimentalTypeInference::class)
package kool

import kool.ubuffers.asUByteBuffer
import kool.ubuffers.UByteBuffer
import java.nio.LongBuffer
import kool.ubuffers.UShortBuffer
import java.nio.Buffer
import org.lwjgl.system.MemoryStack
import kool.ubuffers.asULongBuffer
import kool.ubuffers.ULongBuffer
import java.nio.IntBuffer
import org.lwjgl.system.Pointer
import java.nio.ByteBuffer
import org.lwjgl.PointerBuffer
import java.nio.ShortBuffer
import org.lwjgl.system.MemoryUtil
import kool.ubuffers.asUIntBuffer
import kool.ubuffers.asUShortBuffer
import java.nio.DoubleBuffer
import java.nio.FloatBuffer
import java.nio.CharBuffer
import kool.ubuffers.UIntBuffer
import kool.adr

/** Creates a new empty buffer. */
fun emptyCharBuffer(): CharBuffer = MemoryUtil.memCalloc(0).asCharBuffer()
/** Creates a new buffer of the specified [size], with all elements initialized to zero. */
fun CharBuffer(size: Int): CharBuffer = MemoryUtil.memCalloc(size * Char.BYTES).asCharBuffer()
/** Creates a new buffer of the specified [size], with all elements initialized to zero. */
fun MemoryStack.CharBuffer(size: Int): CharBuffer = malloc(size * Char.BYTES).asCharBuffer()
/**
 * Creates a new array of the specified [size], where each element is calculated by calling 
 * the specified [init] function.
 * 
 * The function [init] is called for each array element sequentially starting from the first one.
 * It should return the value for an array element given its index.
 */
inline fun CharBuffer(size: Int, init: (Int) -> Char): CharBuffer {
    val buffer = MemoryUtil.memAlloc(size * Char.BYTES).asCharBuffer()
    for (i in 0 until size)
        buffer[i] = init(i)
    return buffer
}
/**
 * Creates a new array of the specified [size], where each element is calculated by calling 
 * the specified [init] function.
 * 
 * The function [init] is called for each array element sequentially starting from the first one.
 * It should return the value for an array element given its index.
 */
inline fun MemoryStack.CharBuffer(size: Int, init: (Int) -> Char): CharBuffer {
    val buffer = malloc(size * Char.BYTES).asCharBuffer()
    for (i in 0 until size)
        buffer[i] = init(i)
    return buffer
}
/** Creates a new empty buffer. */
fun emptyBuffer(): ByteBuffer = MemoryUtil.memAlloc(0)
/** Creates a new buffer of the specified [size], with all elements initialized to zero. */
fun Buffer(size: Int): ByteBuffer = MemoryUtil.memCalloc(size)
/** Creates a new buffer of the specified [size], with all elements initialized to zero. */
fun MemoryStack.Buffer(size: Int): ByteBuffer = calloc(size)
/**
 * Creates a new array of the specified [size], where each element is calculated by calling 
 * the specified [init] function.
 * 
 * The function [init] is called for each array element sequentially starting from the first one.
 * It should return the value for an array element given its index.
 */
inline fun Buffer(size: Int, init: (Int) -> Byte): ByteBuffer {
    val buffer = MemoryUtil.memAlloc(size)
    for (i in 0 until size)
        buffer[i] = init(i)
    return buffer
}
/**
 * Creates a new array of the specified [size], where each element is calculated by calling 
 * the specified [init] function.
 * 
 * The function [init] is called for each array element sequentially starting from the first one.
 * It should return the value for an array element given its index.
 */
inline fun MemoryStack.Buffer(size: Int, init: (Int) -> Byte): ByteBuffer {
    val buffer = malloc(size)
    for (i in 0 until size)
        buffer[i] = init(i)
    return buffer
}
/** Creates a new empty buffer. */
fun emptyByteBuffer(): ByteBuffer = MemoryUtil.memCalloc(0)
/** Creates a new buffer of the specified [size], with all elements initialized to zero. */
fun ByteBuffer(size: Int): ByteBuffer = MemoryUtil.memCalloc(size)
/** Creates a new buffer of the specified [size], with all elements initialized to zero. */
fun MemoryStack.ByteBuffer(size: Int): ByteBuffer = malloc(size)
/**
 * Creates a new array of the specified [size], where each element is calculated by calling 
 * the specified [init] function.
 * 
 * The function [init] is called for each array element sequentially starting from the first one.
 * It should return the value for an array element given its index.
 */
inline fun ByteBuffer(size: Int, init: (Int) -> Byte): ByteBuffer {
    val buffer = MemoryUtil.memAlloc(size)
    for (i in 0 until size)
        buffer[i] = init(i)
    return buffer
}
/**
 * Creates a new array of the specified [size], where each element is calculated by calling 
 * the specified [init] function.
 * 
 * The function [init] is called for each array element sequentially starting from the first one.
 * It should return the value for an array element given its index.
 */
inline fun MemoryStack.ByteBuffer(size: Int, init: (Int) -> Byte): ByteBuffer {
    val buffer = malloc(size)
    for (i in 0 until size)
        buffer[i] = init(i)
    return buffer
}
/** Creates a new empty buffer. */
fun emptyShortBuffer(): ShortBuffer = MemoryUtil.memCallocShort(0)
/** Creates a new buffer of the specified [size], with all elements initialized to zero. */
fun ShortBuffer(size: Int): ShortBuffer = MemoryUtil.memCallocShort(size)
/** Creates a new buffer of the specified [size], with all elements initialized to zero. */
fun MemoryStack.ShortBuffer(size: Int): ShortBuffer = mallocShort(size)
/**
 * Creates a new array of the specified [size], where each element is calculated by calling 
 * the specified [init] function.
 * 
 * The function [init] is called for each array element sequentially starting from the first one.
 * It should return the value for an array element given its index.
 */
inline fun ShortBuffer(size: Int, init: (Int) -> Short): ShortBuffer {
    val buffer = MemoryUtil.memAllocShort(size)
    for (i in 0 until size)
        buffer[i] = init(i)
    return buffer
}
/**
 * Creates a new array of the specified [size], where each element is calculated by calling 
 * the specified [init] function.
 * 
 * The function [init] is called for each array element sequentially starting from the first one.
 * It should return the value for an array element given its index.
 */
inline fun MemoryStack.ShortBuffer(size: Int, init: (Int) -> Short): ShortBuffer {
    val buffer = mallocShort(size)
    for (i in 0 until size)
        buffer[i] = init(i)
    return buffer
}
/** Creates a new empty buffer. */
fun emptyIntBuffer(): IntBuffer = MemoryUtil.memCallocInt(0)
/** Creates a new buffer of the specified [size], with all elements initialized to zero. */
fun IntBuffer(size: Int): IntBuffer = MemoryUtil.memCallocInt(size)
/** Creates a new buffer of the specified [size], with all elements initialized to zero. */
fun MemoryStack.IntBuffer(size: Int): IntBuffer = mallocInt(size)
/**
 * Creates a new array of the specified [size], where each element is calculated by calling 
 * the specified [init] function.
 * 
 * The function [init] is called for each array element sequentially starting from the first one.
 * It should return the value for an array element given its index.
 */
inline fun IntBuffer(size: Int, init: (Int) -> Int): IntBuffer {
    val buffer = MemoryUtil.memAllocInt(size)
    for (i in 0 until size)
        buffer[i] = init(i)
    return buffer
}
/**
 * Creates a new array of the specified [size], where each element is calculated by calling 
 * the specified [init] function.
 * 
 * The function [init] is called for each array element sequentially starting from the first one.
 * It should return the value for an array element given its index.
 */
inline fun MemoryStack.IntBuffer(size: Int, init: (Int) -> Int): IntBuffer {
    val buffer = mallocInt(size)
    for (i in 0 until size)
        buffer[i] = init(i)
    return buffer
}
/** Creates a new empty buffer. */
fun emptyLongBuffer(): LongBuffer = MemoryUtil.memCallocLong(0)
/** Creates a new buffer of the specified [size], with all elements initialized to zero. */
fun LongBuffer(size: Int): LongBuffer = MemoryUtil.memCallocLong(size)
/** Creates a new buffer of the specified [size], with all elements initialized to zero. */
fun MemoryStack.LongBuffer(size: Int): LongBuffer = mallocLong(size)
/**
 * Creates a new array of the specified [size], where each element is calculated by calling 
 * the specified [init] function.
 * 
 * The function [init] is called for each array element sequentially starting from the first one.
 * It should return the value for an array element given its index.
 */
inline fun LongBuffer(size: Int, init: (Int) -> Long): LongBuffer {
    val buffer = MemoryUtil.memAllocLong(size)
    for (i in 0 until size)
        buffer[i] = init(i)
    return buffer
}
/**
 * Creates a new array of the specified [size], where each element is calculated by calling 
 * the specified [init] function.
 * 
 * The function [init] is called for each array element sequentially starting from the first one.
 * It should return the value for an array element given its index.
 */
inline fun MemoryStack.LongBuffer(size: Int, init: (Int) -> Long): LongBuffer {
    val buffer = mallocLong(size)
    for (i in 0 until size)
        buffer[i] = init(i)
    return buffer
}
/** Creates a new empty buffer. */
fun emptyUBuffer(): UByteBuffer = MemoryUtil.memAlloc(0).asUByteBuffer()
/** Creates a new buffer of the specified [size], with all elements initialized to zero. */
fun UBuffer(size: Int): UByteBuffer = MemoryUtil.memCalloc(size).asUByteBuffer()
/** Creates a new buffer of the specified [size], with all elements initialized to zero. */
fun MemoryStack.UBuffer(size: Int): UByteBuffer = calloc(size).asUByteBuffer()
/**
 * Creates a new array of the specified [size], where each element is calculated by calling 
 * the specified [init] function.
 * 
 * The function [init] is called for each array element sequentially starting from the first one.
 * It should return the value for an array element given its index.
 */
inline fun UBuffer(size: Int, init: (Int) -> UByte): UByteBuffer {
    val buffer = MemoryUtil.memAlloc(size).asUByteBuffer()
    for (i in 0 until size)
        buffer[i] = init(i)
    return buffer
}
/**
 * Creates a new array of the specified [size], where each element is calculated by calling 
 * the specified [init] function.
 * 
 * The function [init] is called for each array element sequentially starting from the first one.
 * It should return the value for an array element given its index.
 */
inline fun MemoryStack.UBuffer(size: Int, init: (Int) -> UByte): UByteBuffer {
    val buffer = malloc(size).asUByteBuffer()
    for (i in 0 until size)
        buffer[i] = init(i)
    return buffer
}
/** Creates a new empty buffer. */
fun emptyUByteBuffer(): UByteBuffer = MemoryUtil.memCalloc(0).asUByteBuffer()
/** Creates a new buffer of the specified [size], with all elements initialized to zero. */
fun UByteBuffer(size: Int): UByteBuffer = MemoryUtil.memCalloc(size).asUByteBuffer()
/** Creates a new buffer of the specified [size], with all elements initialized to zero. */
fun MemoryStack.UByteBuffer(size: Int): UByteBuffer = malloc(size).asUByteBuffer()
/**
 * Creates a new array of the specified [size], where each element is calculated by calling 
 * the specified [init] function.
 * 
 * The function [init] is called for each array element sequentially starting from the first one.
 * It should return the value for an array element given its index.
 */
inline fun UByteBuffer(size: Int, init: (Int) -> UByte): UByteBuffer {
    val buffer = MemoryUtil.memAlloc(size).asUByteBuffer()
    for (i in 0 until size)
        buffer[i] = init(i)
    return buffer
}
/**
 * Creates a new array of the specified [size], where each element is calculated by calling 
 * the specified [init] function.
 * 
 * The function [init] is called for each array element sequentially starting from the first one.
 * It should return the value for an array element given its index.
 */
inline fun MemoryStack.UByteBuffer(size: Int, init: (Int) -> UByte): UByteBuffer {
    val buffer = malloc(size).asUByteBuffer()
    for (i in 0 until size)
        buffer[i] = init(i)
    return buffer
}
/** Creates a new empty buffer. */
fun emptyUShortBuffer(): UShortBuffer = MemoryUtil.memCallocShort(0).asUShortBuffer()
/** Creates a new buffer of the specified [size], with all elements initialized to zero. */
fun UShortBuffer(size: Int): UShortBuffer = MemoryUtil.memCallocShort(size).asUShortBuffer()
/** Creates a new buffer of the specified [size], with all elements initialized to zero. */
fun MemoryStack.UShortBuffer(size: Int): UShortBuffer = mallocShort(size).asUShortBuffer()
/**
 * Creates a new array of the specified [size], where each element is calculated by calling 
 * the specified [init] function.
 * 
 * The function [init] is called for each array element sequentially starting from the first one.
 * It should return the value for an array element given its index.
 */
inline fun UShortBuffer(size: Int, init: (Int) -> UShort): UShortBuffer {
    val buffer = MemoryUtil.memAllocShort(size).asUShortBuffer()
    for (i in 0 until size)
        buffer[i] = init(i)
    return buffer
}
/**
 * Creates a new array of the specified [size], where each element is calculated by calling 
 * the specified [init] function.
 * 
 * The function [init] is called for each array element sequentially starting from the first one.
 * It should return the value for an array element given its index.
 */
inline fun MemoryStack.UShortBuffer(size: Int, init: (Int) -> UShort): UShortBuffer {
    val buffer = mallocShort(size).asUShortBuffer()
    for (i in 0 until size)
        buffer[i] = init(i)
    return buffer
}
/** Creates a new empty buffer. */
fun emptyUIntBuffer(): UIntBuffer = MemoryUtil.memCallocInt(0).asUIntBuffer()
/** Creates a new buffer of the specified [size], with all elements initialized to zero. */
fun UIntBuffer(size: Int): UIntBuffer = MemoryUtil.memCallocInt(size).asUIntBuffer()
/** Creates a new buffer of the specified [size], with all elements initialized to zero. */
fun MemoryStack.UIntBuffer(size: Int): UIntBuffer = mallocInt(size).asUIntBuffer()
/**
 * Creates a new array of the specified [size], where each element is calculated by calling 
 * the specified [init] function.
 * 
 * The function [init] is called for each array element sequentially starting from the first one.
 * It should return the value for an array element given its index.
 */
inline fun UIntBuffer(size: Int, init: (Int) -> UInt): UIntBuffer {
    val buffer = MemoryUtil.memAllocInt(size).asUIntBuffer()
    for (i in 0 until size)
        buffer[i] = init(i)
    return buffer
}
/**
 * Creates a new array of the specified [size], where each element is calculated by calling 
 * the specified [init] function.
 * 
 * The function [init] is called for each array element sequentially starting from the first one.
 * It should return the value for an array element given its index.
 */
inline fun MemoryStack.UIntBuffer(size: Int, init: (Int) -> UInt): UIntBuffer {
    val buffer = mallocInt(size).asUIntBuffer()
    for (i in 0 until size)
        buffer[i] = init(i)
    return buffer
}
/** Creates a new empty buffer. */
fun emptyULongBuffer(): ULongBuffer = MemoryUtil.memCallocLong(0).asULongBuffer()
/** Creates a new buffer of the specified [size], with all elements initialized to zero. */
fun ULongBuffer(size: Int): ULongBuffer = MemoryUtil.memCallocLong(size).asULongBuffer()
/** Creates a new buffer of the specified [size], with all elements initialized to zero. */
fun MemoryStack.ULongBuffer(size: Int): ULongBuffer = mallocLong(size).asULongBuffer()
/**
 * Creates a new array of the specified [size], where each element is calculated by calling 
 * the specified [init] function.
 * 
 * The function [init] is called for each array element sequentially starting from the first one.
 * It should return the value for an array element given its index.
 */
inline fun ULongBuffer(size: Int, init: (Int) -> ULong): ULongBuffer {
    val buffer = MemoryUtil.memAllocLong(size).asULongBuffer()
    for (i in 0 until size)
        buffer[i] = init(i)
    return buffer
}
/**
 * Creates a new array of the specified [size], where each element is calculated by calling 
 * the specified [init] function.
 * 
 * The function [init] is called for each array element sequentially starting from the first one.
 * It should return the value for an array element given its index.
 */
inline fun MemoryStack.ULongBuffer(size: Int, init: (Int) -> ULong): ULongBuffer {
    val buffer = mallocLong(size).asULongBuffer()
    for (i in 0 until size)
        buffer[i] = init(i)
    return buffer
}
/** Creates a new empty buffer. */
fun emptyFloatBuffer(): FloatBuffer = MemoryUtil.memCallocFloat(0)
/** Creates a new buffer of the specified [size], with all elements initialized to zero. */
fun FloatBuffer(size: Int): FloatBuffer = MemoryUtil.memCallocFloat(size)
/** Creates a new buffer of the specified [size], with all elements initialized to zero. */
fun MemoryStack.FloatBuffer(size: Int): FloatBuffer = mallocFloat(size)
/**
 * Creates a new array of the specified [size], where each element is calculated by calling 
 * the specified [init] function.
 * 
 * The function [init] is called for each array element sequentially starting from the first one.
 * It should return the value for an array element given its index.
 */
inline fun FloatBuffer(size: Int, init: (Int) -> Float): FloatBuffer {
    val buffer = MemoryUtil.memAllocFloat(size)
    for (i in 0 until size)
        buffer[i] = init(i)
    return buffer
}
/**
 * Creates a new array of the specified [size], where each element is calculated by calling 
 * the specified [init] function.
 * 
 * The function [init] is called for each array element sequentially starting from the first one.
 * It should return the value for an array element given its index.
 */
inline fun MemoryStack.FloatBuffer(size: Int, init: (Int) -> Float): FloatBuffer {
    val buffer = mallocFloat(size)
    for (i in 0 until size)
        buffer[i] = init(i)
    return buffer
}
/** Creates a new empty buffer. */
fun emptyDoubleBuffer(): DoubleBuffer = MemoryUtil.memCallocDouble(0)
/** Creates a new buffer of the specified [size], with all elements initialized to zero. */
fun DoubleBuffer(size: Int): DoubleBuffer = MemoryUtil.memCallocDouble(size)
/** Creates a new buffer of the specified [size], with all elements initialized to zero. */
fun MemoryStack.DoubleBuffer(size: Int): DoubleBuffer = mallocDouble(size)
/**
 * Creates a new array of the specified [size], where each element is calculated by calling 
 * the specified [init] function.
 * 
 * The function [init] is called for each array element sequentially starting from the first one.
 * It should return the value for an array element given its index.
 */
inline fun DoubleBuffer(size: Int, init: (Int) -> Double): DoubleBuffer {
    val buffer = MemoryUtil.memAllocDouble(size)
    for (i in 0 until size)
        buffer[i] = init(i)
    return buffer
}
/**
 * Creates a new array of the specified [size], where each element is calculated by calling 
 * the specified [init] function.
 * 
 * The function [init] is called for each array element sequentially starting from the first one.
 * It should return the value for an array element given its index.
 */
inline fun MemoryStack.DoubleBuffer(size: Int, init: (Int) -> Double): DoubleBuffer {
    val buffer = mallocDouble(size)
    for (i in 0 until size)
        buffer[i] = init(i)
    return buffer
}
/** Creates a new empty buffer. */
fun emptyPointerBuffer(): PointerBuffer = MemoryUtil.memCallocPointer(0)
/** Creates a new buffer of the specified [size], with all elements initialized to zero. */
fun PointerBuffer(size: Int): PointerBuffer = MemoryUtil.memCallocPointer(size)
/** Creates a new buffer of the specified [size], with all elements initialized to zero. */
fun MemoryStack.PointerBuffer(size: Int): PointerBuffer = mallocPointer(size)
/**
 * Creates a new array of the specified [size], where each element is calculated by calling 
 * the specified [init] function.
 * 
 * The function [init] is called for each array element sequentially starting from the first one.
 * It should return the value for an array element given its index.
 */
@OverloadResolutionByLambdaReturnType
@kotlin.jvm.JvmName("PointerBufferLong")
inline fun PointerBuffer(size: Int, init: (Int) -> Long): PointerBuffer {
    val buffer = MemoryUtil.memAllocPointer(size)
    for (i in 0 until size)
        buffer[i] = init(i)
    return buffer
}
/**
 * Creates a new array of the specified [size], where each element is calculated by calling 
 * the specified [init] function.
 * 
 * The function [init] is called for each array element sequentially starting from the first one.
 * It should return the value for an array element given its index.
 */
@OverloadResolutionByLambdaReturnType
@kotlin.jvm.JvmName("PointerBufferLong")
inline fun MemoryStack.PointerBuffer(size: Int, init: (Int) -> Long): PointerBuffer {
    val buffer = mallocPointer(size)
    for (i in 0 until size)
        buffer[i] = init(i)
    return buffer
}
/**
 * Creates a new array of the specified [size], where each element is calculated by calling 
 * the specified [init] function.
 * 
 * The function [init] is called for each array element sequentially starting from the first one.
 * It should return the value for an array element given its index.
 */
@OverloadResolutionByLambdaReturnType
@kotlin.jvm.JvmName("PointerBufferPointer")
inline fun PointerBuffer(size: Int, init: (Int) -> Pointer): PointerBuffer {
    val buffer = MemoryUtil.memAllocPointer(size)
    for (i in 0 until size)
        buffer[i] = init(i)
    return buffer
}
/**
 * Creates a new array of the specified [size], where each element is calculated by calling 
 * the specified [init] function.
 * 
 * The function [init] is called for each array element sequentially starting from the first one.
 * It should return the value for an array element given its index.
 */
@OverloadResolutionByLambdaReturnType
@kotlin.jvm.JvmName("PointerBufferPointer")
inline fun MemoryStack.PointerBuffer(size: Int, init: (Int) -> Pointer): PointerBuffer {
    val buffer = mallocPointer(size)
    for (i in 0 until size)
        buffer[i] = init(i)
    return buffer
}
/**
 * Creates a new array of the specified [size], where each element is calculated by calling 
 * the specified [init] function.
 * 
 * The function [init] is called for each array element sequentially starting from the first one.
 * It should return the value for an array element given its index.
 */
@OverloadResolutionByLambdaReturnType
@kotlin.jvm.JvmName("PointerBufferBuffer")
inline fun PointerBuffer(size: Int, init: (Int) -> Buffer): PointerBuffer {
    val buffer = MemoryUtil.memAllocPointer(size)
    for (i in 0 until size)
        buffer[i] = init(i).adr
    return buffer
}
/**
 * Creates a new array of the specified [size], where each element is calculated by calling 
 * the specified [init] function.
 * 
 * The function [init] is called for each array element sequentially starting from the first one.
 * It should return the value for an array element given its index.
 */
@OverloadResolutionByLambdaReturnType
@kotlin.jvm.JvmName("PointerBufferBuffer")
inline fun MemoryStack.PointerBuffer(size: Int, init: (Int) -> Buffer): PointerBuffer {
    val buffer = mallocPointer(size)
    for (i in 0 until size)
        buffer[i] = init(i).adr
    return buffer
}
