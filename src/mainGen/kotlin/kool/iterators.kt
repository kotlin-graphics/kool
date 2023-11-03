package kool
import kool.ubuffers.UByteBuffer
import java.nio.LongBuffer
import kool.ubuffers.UShortBuffer
import kool.ubuffers.ULongBuffer
import java.nio.IntBuffer
import java.nio.ByteBuffer
import org.lwjgl.PointerBuffer
import java.nio.ShortBuffer
import java.nio.DoubleBuffer
import java.nio.FloatBuffer
import java.nio.CharBuffer
import kool.pos
import kool.ubuffers.UIntBuffer

operator fun CharBuffer.iterator(): CharBufferIterator = CharBufferIterator(this)

class CharBufferIterator(private val buffer: CharBuffer) : Iterator<Char> {
    private var position: Int = buffer.pos
    override fun next(): Char = buffer[position++]
    override fun hasNext(): Boolean = position < buffer.lim
}
operator fun ByteBuffer.iterator(): ByteBufferIterator = ByteBufferIterator(this)

class ByteBufferIterator(private val buffer: ByteBuffer) : Iterator<Byte> {
    private var position: Int = buffer.pos
    override fun next(): Byte = buffer[position++]
    override fun hasNext(): Boolean = position < buffer.lim
}
operator fun ShortBuffer.iterator(): ShortBufferIterator = ShortBufferIterator(this)

class ShortBufferIterator(private val buffer: ShortBuffer) : Iterator<Short> {
    private var position: Int = buffer.pos
    override fun next(): Short = buffer[position++]
    override fun hasNext(): Boolean = position < buffer.lim
}
operator fun IntBuffer.iterator(): IntBufferIterator = IntBufferIterator(this)

class IntBufferIterator(private val buffer: IntBuffer) : Iterator<Int> {
    private var position: Int = buffer.pos
    override fun next(): Int = buffer[position++]
    override fun hasNext(): Boolean = position < buffer.lim
}
operator fun LongBuffer.iterator(): LongBufferIterator = LongBufferIterator(this)

class LongBufferIterator(private val buffer: LongBuffer) : Iterator<Long> {
    private var position: Int = buffer.pos
    override fun next(): Long = buffer[position++]
    override fun hasNext(): Boolean = position < buffer.lim
}
operator fun UByteBuffer.iterator(): UByteBufferIterator = UByteBufferIterator(this)

class UByteBufferIterator(private val buffer: UByteBuffer) : Iterator<UByte> {
    private var position: Int = buffer.pos
    override fun next(): UByte = buffer[position++]
    override fun hasNext(): Boolean = position < buffer.lim
}
operator fun UShortBuffer.iterator(): UShortBufferIterator = UShortBufferIterator(this)

class UShortBufferIterator(private val buffer: UShortBuffer) : Iterator<UShort> {
    private var position: Int = buffer.pos
    override fun next(): UShort = buffer[position++]
    override fun hasNext(): Boolean = position < buffer.lim
}
operator fun UIntBuffer.iterator(): UIntBufferIterator = UIntBufferIterator(this)

class UIntBufferIterator(private val buffer: UIntBuffer) : Iterator<UInt> {
    private var position: Int = buffer.pos
    override fun next(): UInt = buffer[position++]
    override fun hasNext(): Boolean = position < buffer.lim
}
operator fun ULongBuffer.iterator(): ULongBufferIterator = ULongBufferIterator(this)

class ULongBufferIterator(private val buffer: ULongBuffer) : Iterator<ULong> {
    private var position: Int = buffer.pos
    override fun next(): ULong = buffer[position++]
    override fun hasNext(): Boolean = position < buffer.lim
}
operator fun FloatBuffer.iterator(): FloatBufferIterator = FloatBufferIterator(this)

class FloatBufferIterator(private val buffer: FloatBuffer) : Iterator<Float> {
    private var position: Int = buffer.pos
    override fun next(): Float = buffer[position++]
    override fun hasNext(): Boolean = position < buffer.lim
}
operator fun DoubleBuffer.iterator(): DoubleBufferIterator = DoubleBufferIterator(this)

class DoubleBufferIterator(private val buffer: DoubleBuffer) : Iterator<Double> {
    private var position: Int = buffer.pos
    override fun next(): Double = buffer[position++]
    override fun hasNext(): Boolean = position < buffer.lim
}
operator fun PointerBuffer.iterator(): PointerBufferIterator = PointerBufferIterator(this)

class PointerBufferIterator(private val buffer: PointerBuffer) : Iterator<Long> {
    private var position: Int = buffer.pos
    override fun next(): Long = buffer[position++]
    override fun hasNext(): Boolean = position < buffer.lim
}
