@file:OptIn(kotlin.contracts.ExperimentalContracts::class)
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
import java.nio.ByteBuffer
import java.nio.ShortBuffer
import org.lwjgl.system.MemoryUtil
import kool.ubuffers.asUIntBuffer
import kool.ubuffers.asUShortBuffer
import java.nio.DoubleBuffer
import java.nio.FloatBuffer
import kool.ubuffers.UIntBuffer

object stack {
	// --------------------------------------------- getters ---------------------------------------------
	
	inline fun <R, reified T> read(block: (Adr) -> R): T = when (T::class.java) {
	    Byte::class.java -> readByteFromAdr(block)
	    UByte::class.java -> readUByteFromAdr(block)
	    Short::class.java -> readShortFromAdr(block)
	    UShort::class.java -> readUShortFromAdr(block)
	    Int::class.java -> readIntFromAdr(block)
	    UInt::class.java -> readUIntFromAdr(block)
	    Long::class.java -> readLongFromAdr(block)
	    ULong::class.java -> readULongFromAdr(block)
	    Float::class.java -> readFloatFromAdr(block)
	    Double::class.java -> readDoubleFromAdr(block)
	    else -> error("")
	} as T
	/*inline fun <R, reified T> read(block: (ByteBuffer) -> R): T = when (T::class.java) {
	    Byte::class.java -> readByte(block)
	    UByte::class.java -> readUByte(block)
	    Short::class.java -> readShort(block)
	    UShort::class.java -> readUShort(block)
	    Int::class.java -> readInt(block)
	    UInt::class.java -> readUInt(block)
	    Long::class.java -> readLong(block)
	    ULong::class.java -> readULong(block)
	    Float::class.java -> readFloat(block)
	    Double::class.java -> readDouble(block)
	    else -> error("")
	} as T*/
	inline fun <R> readByteFromAdr(block: (Adr) -> R): Byte = with { PtrByte().apply { block(adr) }.invoke() }
	
	inline fun <R> readByteFromBuf(block: (ByteBuffer) -> R): Byte = with {
	    val buf = malloc(1)
	    block(buf)
	    buf[0]
	}
	inline fun <R> readShortFromAdr(block: (Adr) -> R): Short = with { PtrShort().apply { block(adr) }.invoke() }
	
	inline fun <R> readShortFromBuf(block: (ShortBuffer) -> R): Short = with {
	    val buf = mallocShort(1)
	    block(buf)
	    buf[0]
	}
	inline fun <R> readIntFromAdr(block: (Adr) -> R): Int = with { PtrInt().apply { block(adr) }.invoke() }
	
	inline fun <R> readIntFromBuf(block: (IntBuffer) -> R): Int = with {
	    val buf = mallocInt(1)
	    block(buf)
	    buf[0]
	}
	inline fun <R> readLongFromAdr(block: (Adr) -> R): Long = with { PtrLong().apply { block(adr) }.invoke() }
	
	inline fun <R> readLongFromBuf(block: (LongBuffer) -> R): Long = with {
	    val buf = mallocLong(1)
	    block(buf)
	    buf[0]
	}
	inline fun <R> readUByteFromAdr(block: (Adr) -> R): UByte = with { PtrUByte().apply { block(adr) }.invoke() }
	
	inline fun <R> readUByteFromBuf(block: (UByteBuffer) -> R): UByte = with {
	    val buf = malloc(1).asUByteBuffer()
	    block(buf)
	    buf[0]
	}
	inline fun <R> readUShortFromAdr(block: (Adr) -> R): UShort = with { PtrUShort().apply { block(adr) }.invoke() }
	
	inline fun <R> readUShortFromBuf(block: (UShortBuffer) -> R): UShort = with {
	    val buf = mallocShort(1).asUShortBuffer()
	    block(buf)
	    buf[0]
	}
	inline fun <R> readUIntFromAdr(block: (Adr) -> R): UInt = with { PtrUInt().apply { block(adr) }.invoke() }
	
	inline fun <R> readUIntFromBuf(block: (UIntBuffer) -> R): UInt = with {
	    val buf = mallocInt(1).asUIntBuffer()
	    block(buf)
	    buf[0]
	}
	inline fun <R> readULongFromAdr(block: (Adr) -> R): ULong = with { PtrULong().apply { block(adr) }.invoke() }
	
	inline fun <R> readULongFromBuf(block: (ULongBuffer) -> R): ULong = with {
	    val buf = mallocLong(1).asULongBuffer()
	    block(buf)
	    buf[0]
	}
	inline fun <R> readFloatFromAdr(block: (Adr) -> R): Float = with { PtrFloat().apply { block(adr) }.invoke() }
	
	inline fun <R> readFloatFromBuf(block: (FloatBuffer) -> R): Float = with {
	    val buf = mallocFloat(1)
	    block(buf)
	    buf[0]
	}
	inline fun <R> readDoubleFromAdr(block: (Adr) -> R): Double = with { PtrDouble().apply { block(adr) }.invoke() }
	
	inline fun <R> readDoubleFromBuf(block: (DoubleBuffer) -> R): Double = with {
	    val buf = mallocDouble(1)
	    block(buf)
	    buf[0]
	}
	/** It mallocs, passes the address and reads the null terminated string */
	inline fun <R> readAsciiFromAdr(maxSize: Int, block: (Adr) -> R): String = with {
	    val adr = nmalloc(1, maxSize)
	    block(adr.toULong())
	    return MemoryUtil.memASCII(adr, strlen64NT1(adr, maxSize))
	}
	
	/** It mallocs the buffer, passes it and reads the null terminated string */
	inline fun <R> readAsciiFromBuf(maxSize: Int, block: (ByteBuffer) -> R): String = with {
	    val buf = malloc(1, maxSize)
	    block(buf)
	    return MemoryUtil.memASCII(buf.adr.toLong(), maxSize)
	}
	/** It mallocs, passes the address and reads the null terminated string */
	inline fun <R> readUtf8FromAdr(maxSize: Int, block: (Adr) -> R): String = with {
	    val adr = nmalloc(1, maxSize)
	    block(adr.toULong())
	    return MemoryUtil.memUTF8(adr, strlen64NT1(adr, maxSize))
	}
	
	/** It mallocs the buffer, passes it and reads the null terminated string */
	inline fun <R> readUtf8FromBuf(maxSize: Int, block: (ByteBuffer) -> R): String = with {
	    val buf = malloc(1, maxSize)
	    block(buf)
	    return MemoryUtil.memUTF8(buf.adr.toLong(), maxSize)
	}
	/** It mallocs, passes the address and reads the null terminated string */
	inline fun <R> readUtf16FromAdr(maxSize: Int, block: (Adr) -> R): String = with {
	    val adr = nmalloc(1, maxSize)
	    block(adr.toULong())
	    return MemoryUtil.memUTF16(adr, strlen64NT1(adr, maxSize))
	}
	
	/** It mallocs the buffer, passes it and reads the null terminated string */
	inline fun <R> readUtf16FromBuf(maxSize: Int, block: (ByteBuffer) -> R): String = with {
	    val buf = malloc(1, maxSize)
	    block(buf)
	    return MemoryUtil.memUTF16(buf.adr.toLong(), maxSize)
	}
	// TODO, when limitation is lifted on contracts in members, implement it
	// @OptIn(ExperimentalContracts::class)
	inline operator fun <R> invoke(block: (MemoryStack) -> R): R = with(block)
	
	// --------------------------------------------- setters ---------------------------------------------
	inline fun <R> writeToAdr(byte: Byte, block: (Adr) -> R): R = with { block(ptrOf(byte).adr) }
	inline fun <R> writeToBuf(byte: Byte, block: (ByteBuffer) -> R): R = with { block(bufferOf(byte)) }
	inline fun <R> writeToAdr(short: Short, block: (Adr) -> R): R = with { block(ptrOf(short).adr) }
	inline fun <R> writeToBuf(short: Short, block: (ShortBuffer) -> R): R = with { block(bufferOf(short)) }
	inline fun <R> writeToAdr(int: Int, block: (Adr) -> R): R = with { block(ptrOf(int).adr) }
	inline fun <R> writeToBuf(int: Int, block: (IntBuffer) -> R): R = with { block(bufferOf(int)) }
	inline fun <R> writeToAdr(long: Long, block: (Adr) -> R): R = with { block(ptrOf(long).adr) }
	inline fun <R> writeToBuf(long: Long, block: (LongBuffer) -> R): R = with { block(bufferOf(long)) }
	inline fun <R> writeToAdr(ubyte: UByte, block: (Adr) -> R): R = with { block(ptrOf(ubyte).adr) }
	inline fun <R> writeToBuf(ubyte: UByte, block: (UByteBuffer) -> R): R = with { block(bufferOf(ubyte)) }
	inline fun <R> writeToAdr(ushort: UShort, block: (Adr) -> R): R = with { block(ptrOf(ushort).adr) }
	inline fun <R> writeToBuf(ushort: UShort, block: (UShortBuffer) -> R): R = with { block(bufferOf(ushort)) }
	inline fun <R> writeToAdr(uint: UInt, block: (Adr) -> R): R = with { block(ptrOf(uint).adr) }
	inline fun <R> writeToBuf(uint: UInt, block: (UIntBuffer) -> R): R = with { block(bufferOf(uint)) }
	inline fun <R> writeToAdr(ulong: ULong, block: (Adr) -> R): R = with { block(ptrOf(ulong).adr) }
	inline fun <R> writeToBuf(ulong: ULong, block: (ULongBuffer) -> R): R = with { block(bufferOf(ulong)) }
	inline fun <R> writeToAdr(float: Float, block: (Adr) -> R): R = with { block(ptrOf(float).adr) }
	inline fun <R> writeToBuf(float: Float, block: (FloatBuffer) -> R): R = with { block(bufferOf(float)) }
	inline fun <R> writeToAdr(double: Double, block: (Adr) -> R): R = with { block(ptrOf(double).adr) }
	inline fun <R> writeToBuf(double: Double, block: (DoubleBuffer) -> R): R = with { block(bufferOf(double)) }
	inline fun <R> writeAsciiToAdr(chars: CharSequence, nullTerminated: Boolean = true, block: (Adr) -> R): R = 
	    with {
	        nASCII(chars, nullTerminated)
	        block(pointerAddress.toULong()) 
	    }
	
	inline fun <R> writeAsciiToBuf(chars: CharSequence, nullTerminated: Boolean = true, block: (ByteBuffer) -> R): R =
	    with { block(ASCII(chars, nullTerminated)) }
	inline fun <R> writeUtf8ToAdr(chars: CharSequence, nullTerminated: Boolean = true, block: (Adr) -> R): R = 
	    with {
	        nUTF8(chars, nullTerminated)
	        block(pointerAddress.toULong()) 
	    }
	
	inline fun <R> writeUtf8ToBuf(chars: CharSequence, nullTerminated: Boolean = true, block: (ByteBuffer) -> R): R =
	    with { block(UTF8(chars, nullTerminated)) }
	inline fun <R> writeUtf16ToAdr(chars: CharSequence, nullTerminated: Boolean = true, block: (Adr) -> R): R = 
	    with {
	        nUTF16(chars, nullTerminated)
	        block(pointerAddress.toULong()) 
	    }
	
	inline fun <R> writeUtf16ToBuf(chars: CharSequence, nullTerminated: Boolean = true, block: (ByteBuffer) -> R): R =
	    with { block(UTF16(chars, nullTerminated)) }
}
inline fun <R> stack.with(block: MemoryStack.() -> R): R {
    kotlin.contracts.contract { callsInPlace(block, kotlin.contracts.InvocationKind.EXACTLY_ONCE) }
    val stack = MemoryStack.stackGet()
    val ptr = stack.pointer
    return block(stack).also {
        stack.pointer = ptr
    }
}
