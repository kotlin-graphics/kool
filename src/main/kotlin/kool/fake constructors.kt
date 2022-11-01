package kool

import org.lwjgl.PointerBuffer
import org.lwjgl.system.MemoryStack
import org.lwjgl.system.MemoryUtil
import org.lwjgl.system.Pointer
import java.nio.*

// MemoryStack version


//fun MemoryStack.ByteBuffer(size: Int): ByteBuffer = calloc(size)
//inline fun MemoryStack.ByteBuffer(size: Int, init: (Int) -> Byte) = ByteBuffer(size).also { for (i in 0 until size) it[i] = init(i) }
//
//fun MemoryStack.ShortBuffer(size: Int): ShortBuffer = callocShort(size)
//inline fun MemoryStack.ShortBuffer(size: Int, init: (Int) -> Short) = ShortBuffer(size).also { for (i in 0 until size) it[i] = init(i) }
//
//fun MemoryStack.IntBuffer(size: Int): IntBuffer = callocInt(size)
//inline fun MemoryStack.IntBuffer(size: Int, init: (Int) -> Int)= IntBuffer(size).also { for (i in 0 until size) it[i] = init(i) }
//
//fun MemoryStack.LongBuffer(size: Int): LongBuffer = mallocLong(size)
//inline fun MemoryStack.LongBuffer(size: Int, init: (Int) -> Long)= LongBuffer(size).also { for (i in 0 until size) it[i] = init(i) }
//
//fun MemoryStack.FloatBuffer(size: Int): FloatBuffer = callocFloat(size)
//inline fun MemoryStack.FloatBuffer(size: Int, init: (Int) -> Float) = FloatBuffer(size).also { for (i in 0 until size) it[i] = init(i) }
//
//fun MemoryStack.DoubleBuffer(size: Int): DoubleBuffer = callocDouble(size)
//inline fun MemoryStack.DoubleBuffer(size: Int, init: (Int) -> Double)= DoubleBuffer(size).also { for (i in 0 until size) it[i] = init(i) }
//
//fun MemoryStack.CharBuffer(size: Int): CharBuffer = calloc(size * Char.BYTES).asCharBuffer()
//inline fun MemoryStack.CharBuffer(size: Int, init: (Int) -> Char) = CharBuffer(size).also { for (i in 0 until size) it[i] = init(i) }
//
//fun MemoryStack.PointerBuffer(size: Int): PointerBuffer = callocPointer(size)
//inline fun MemoryStack.PointerBuffer(size: Int, init: (Int) -> Adr)= PointerBuffer(size).also { for (i in 0 until size) it[i] = init(i) }
//inline fun MemoryStack.PointerBufferP(size: Int, init: (Int) -> Pointer)= PointerBuffer(size).also { for (i in 0 until size) it[i] = init(i) }
//inline fun MemoryStack.PointerBufferB(size: Int, init: (Int) -> Buffer)= PointerBuffer(size).also { for (i in 0 until size) it[i] = init(i) }

@JvmName("PointerBufferSafe")
fun MemoryStack.PointerBuffer(strings: Collection<String>?): PointerBuffer? =
        strings?.let { PointerBuffer(it) }

fun MemoryStack.PointerBuffer(strings: Collection<String>): PointerBuffer =
        PointerBuffer(strings.size) { i ->
            val string = strings.elementAt(i)
            val length = MemoryUtil.memLengthUTF8(string, true)
            nmalloc(1, length).also { encodeUTF8(string, true, it) }
        }

@JvmName("PointerAdrSafe")
fun MemoryStack.PointerAdr(strings: Collection<String>?): Adr = strings?.let { PointerAdr(it) } ?: MemoryUtil.NULL

fun MemoryStack.PointerAdr(strings: Collection<String>): Adr =
        PointerAdr(strings.size) { i ->
            val string = strings.elementAt(i)
            val length = MemoryUtil.memLengthUTF8(string, true)
            nmalloc(1, length).also { encodeUTF8(string, true, it) }
        }

inline fun MemoryStack.PointerAdr(size: Int, init: (Int) -> Adr): Adr {
    val bytes = size * Pointer.POINTER_SIZE
    val address = nmalloc(Pointer.POINTER_SIZE, bytes)
    MemoryUtil.memSet(address, 0, bytes.toLong())
    for (i in 0 until size)
        MemoryUtil.memPutAddress(address + i * Pointer.POINTER_SIZE, init(i))
    return address
}

// empty versions

//fun emptyBuffer(): ByteBuffer = MemoryUtil.memCalloc(0)

//fun emptyByteBuffer(): ByteBuffer = MemoryUtil.memCalloc(0)
//
//fun emptyShortBuffer(): ShortBuffer = MemoryUtil.memCallocShort(0)
//
//fun emptyIntBuffer(): IntBuffer = MemoryUtil.memCallocInt(0)
//
//fun emptyLongBuffer(): LongBuffer = MemoryUtil.memCallocLong(0)
//
//fun emptyFloatBuffer(): FloatBuffer = MemoryUtil.memCallocFloat(0)
//
//fun emptyDoubleBuffer(): DoubleBuffer = MemoryUtil.memCallocDouble(0)
//
//fun emptyCharBuffer(): CharBuffer = MemoryUtil.memCalloc(0).asCharBuffer()
//
//fun emptyPointerBuffer(): PointerBuffer = MemoryUtil.memCallocPointer(0)