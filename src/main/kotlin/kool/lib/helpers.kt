package kool.lib

import kool.cap
import kool.lim
import java.nio.*

operator fun ByteBuffer.iterator() = ByteBufferIterator(this)
operator fun ShortBuffer.iterator() = ShortBufferIterator(this)
operator fun IntBuffer.iterator() = IntBufferIterator(this)
operator fun LongBuffer.iterator() = LongBufferIterator(this)
operator fun FloatBuffer.iterator() = FloatBufferIterator(this)
operator fun DoubleBuffer.iterator() = DoubleBufferIterator(this)
operator fun CharBuffer.iterator() = CharBufferIterator(this)

class ByteBufferIterator(private val byteBuffer: ByteBuffer) : Iterator<Byte> {

    private var position = byteBuffer.position()

    override fun next() = byteBuffer[position++]
    override fun hasNext() = position < byteBuffer.lim
}

class ShortBufferIterator(private val shortBuffer: ShortBuffer) : Iterator<Short> {

    private var position = shortBuffer.position()

    override fun next() = shortBuffer[position++]
    override fun hasNext() = position < shortBuffer.lim
}

class IntBufferIterator(private val intBuffer: IntBuffer) : Iterator<Int> {

    private var position = intBuffer.position()

    override fun next() = intBuffer[position++]
    override fun hasNext() = position < intBuffer.lim
}

class LongBufferIterator(private val longBuffer: LongBuffer) : Iterator<Long> {

    private var position = longBuffer.position()

    override fun next() = longBuffer[position++]
    override fun hasNext() = position < longBuffer.lim
}

class FloatBufferIterator(private val floatBuffer: FloatBuffer) : Iterator<Float> {

    private var position = floatBuffer.position()

    override fun next() = floatBuffer[position++]
    override fun hasNext() = position < floatBuffer.lim
}

class DoubleBufferIterator(private val doubleBuffer: DoubleBuffer) : Iterator<Double> {

    private var position = doubleBuffer.position()

    override fun next() = doubleBuffer[position++]
    override fun hasNext() = position < doubleBuffer.lim
}

class CharBufferIterator(private val charBuffer: CharBuffer) : Iterator<Char> {

    private var position = charBuffer.position()

    override fun next() = charBuffer[position++]
    override fun hasNext() = position < charBuffer.lim
}



object maps {
    private const val INT_MAX_POWER_OF_TWO: Int = Int.MAX_VALUE / 2 + 1
    fun mapCapacity(expectedSize: Int) = when {
        expectedSize < 3 -> expectedSize + 1
        expectedSize < INT_MAX_POWER_OF_TWO -> expectedSize + expectedSize / 3
        else -> Int.MAX_VALUE // any large value
    }
}
