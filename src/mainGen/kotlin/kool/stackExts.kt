@file:OptIn(kotlin.ExperimentalUnsignedTypes::class)
package kool
import kool.ubuffers.UByteBuffer
import java.nio.LongBuffer
import kool.ubuffers.UShortBuffer
import java.nio.Buffer
import org.lwjgl.system.MemoryStack
import kool.ubuffers.ULongBuffer
import java.nio.IntBuffer
import org.lwjgl.system.Pointer
import java.nio.ByteBuffer
import org.lwjgl.PointerBuffer
import java.nio.ShortBuffer
import org.lwjgl.system.MemoryUtil
import java.nio.DoubleBuffer
import java.nio.FloatBuffer
import kool.ubuffers.UIntBuffer

fun MemoryStack.ptrOf(b1: Byte): Ptr<Byte> {
	val ptr = PtrByte(1)
	ptr[0] = b1
	return ptr
}
fun MemoryStack.bufferOf(b1: Byte): ByteBuffer {
	val buf = ByteBuffer(1)
	buf[0] = b1
	return buf
}
fun MemoryStack.ptrOf(b1: Byte, b2: Byte): Ptr<Byte> {
	val ptr = PtrByte(2)
	ptr[0] = b1
	ptr[1] = b2
	return ptr
}
fun MemoryStack.bufferOf(b1: Byte, b2: Byte): ByteBuffer {
	val buf = ByteBuffer(2)
	buf[0] = b1
	buf[1] = b2
	return buf
}
fun MemoryStack.ptrOf(b1: Byte, b2: Byte, b3: Byte): Ptr<Byte> {
	val ptr = PtrByte(3)
	ptr[0] = b1
	ptr[1] = b2
	ptr[2] = b3
	return ptr
}
fun MemoryStack.bufferOf(b1: Byte, b2: Byte, b3: Byte): ByteBuffer {
	val buf = ByteBuffer(3)
	buf[0] = b1
	buf[1] = b2
	buf[2] = b3
	return buf
}
fun MemoryStack.ptrOf(b1: Byte, b2: Byte, b3: Byte, b4: Byte): Ptr<Byte> {
	val ptr = PtrByte(4)
	ptr[0] = b1
	ptr[1] = b2
	ptr[2] = b3
	ptr[3] = b4
	return ptr
}
fun MemoryStack.bufferOf(b1: Byte, b2: Byte, b3: Byte, b4: Byte): ByteBuffer {
	val buf = ByteBuffer(4)
	buf[0] = b1
	buf[1] = b2
	buf[2] = b3
	buf[3] = b4
	return buf
}
fun MemoryStack.ptrOf(b1: Byte, b2: Byte, b3: Byte, b4: Byte, b5: Byte): Ptr<Byte> {
	val ptr = PtrByte(5)
	ptr[0] = b1
	ptr[1] = b2
	ptr[2] = b3
	ptr[3] = b4
	ptr[4] = b5
	return ptr
}
fun MemoryStack.bufferOf(b1: Byte, b2: Byte, b3: Byte, b4: Byte, b5: Byte): ByteBuffer {
	val buf = ByteBuffer(5)
	buf[0] = b1
	buf[1] = b2
	buf[2] = b3
	buf[3] = b4
	buf[4] = b5
	return buf
}
fun MemoryStack.ptrOf(vararg bytes: Byte): Ptr<Byte> {
    val ptr = PtrByte(bytes.size)
    for (i in bytes.indices) 
        ptr[i] = bytes[i]
    return ptr
}
fun MemoryStack.ptrOf(b1: Short): Ptr<Short> {
	val ptr = PtrShort(1)
	ptr[0] = b1
	return ptr
}
fun MemoryStack.bufferOf(b1: Short): ShortBuffer {
	val buf = ShortBuffer(1)
	buf[0] = b1
	return buf
}
fun MemoryStack.ptrOf(b1: Short, b2: Short): Ptr<Short> {
	val ptr = PtrShort(2)
	ptr[0] = b1
	ptr[1] = b2
	return ptr
}
fun MemoryStack.bufferOf(b1: Short, b2: Short): ShortBuffer {
	val buf = ShortBuffer(2)
	buf[0] = b1
	buf[1] = b2
	return buf
}
fun MemoryStack.ptrOf(b1: Short, b2: Short, b3: Short): Ptr<Short> {
	val ptr = PtrShort(3)
	ptr[0] = b1
	ptr[1] = b2
	ptr[2] = b3
	return ptr
}
fun MemoryStack.bufferOf(b1: Short, b2: Short, b3: Short): ShortBuffer {
	val buf = ShortBuffer(3)
	buf[0] = b1
	buf[1] = b2
	buf[2] = b3
	return buf
}
fun MemoryStack.ptrOf(b1: Short, b2: Short, b3: Short, b4: Short): Ptr<Short> {
	val ptr = PtrShort(4)
	ptr[0] = b1
	ptr[1] = b2
	ptr[2] = b3
	ptr[3] = b4
	return ptr
}
fun MemoryStack.bufferOf(b1: Short, b2: Short, b3: Short, b4: Short): ShortBuffer {
	val buf = ShortBuffer(4)
	buf[0] = b1
	buf[1] = b2
	buf[2] = b3
	buf[3] = b4
	return buf
}
fun MemoryStack.ptrOf(b1: Short, b2: Short, b3: Short, b4: Short, b5: Short): Ptr<Short> {
	val ptr = PtrShort(5)
	ptr[0] = b1
	ptr[1] = b2
	ptr[2] = b3
	ptr[3] = b4
	ptr[4] = b5
	return ptr
}
fun MemoryStack.bufferOf(b1: Short, b2: Short, b3: Short, b4: Short, b5: Short): ShortBuffer {
	val buf = ShortBuffer(5)
	buf[0] = b1
	buf[1] = b2
	buf[2] = b3
	buf[3] = b4
	buf[4] = b5
	return buf
}
fun MemoryStack.ptrOf(vararg shorts: Short): Ptr<Short> {
    val ptr = PtrShort(shorts.size)
    for (i in shorts.indices) 
        ptr[i] = shorts[i]
    return ptr
}
fun MemoryStack.ptrOf(b1: Int): Ptr<Int> {
	val ptr = PtrInt(1)
	ptr[0] = b1
	return ptr
}
fun MemoryStack.bufferOf(b1: Int): IntBuffer {
	val buf = IntBuffer(1)
	buf[0] = b1
	return buf
}
fun MemoryStack.ptrOf(b1: Int, b2: Int): Ptr<Int> {
	val ptr = PtrInt(2)
	ptr[0] = b1
	ptr[1] = b2
	return ptr
}
fun MemoryStack.bufferOf(b1: Int, b2: Int): IntBuffer {
	val buf = IntBuffer(2)
	buf[0] = b1
	buf[1] = b2
	return buf
}
fun MemoryStack.ptrOf(b1: Int, b2: Int, b3: Int): Ptr<Int> {
	val ptr = PtrInt(3)
	ptr[0] = b1
	ptr[1] = b2
	ptr[2] = b3
	return ptr
}
fun MemoryStack.bufferOf(b1: Int, b2: Int, b3: Int): IntBuffer {
	val buf = IntBuffer(3)
	buf[0] = b1
	buf[1] = b2
	buf[2] = b3
	return buf
}
fun MemoryStack.ptrOf(b1: Int, b2: Int, b3: Int, b4: Int): Ptr<Int> {
	val ptr = PtrInt(4)
	ptr[0] = b1
	ptr[1] = b2
	ptr[2] = b3
	ptr[3] = b4
	return ptr
}
fun MemoryStack.bufferOf(b1: Int, b2: Int, b3: Int, b4: Int): IntBuffer {
	val buf = IntBuffer(4)
	buf[0] = b1
	buf[1] = b2
	buf[2] = b3
	buf[3] = b4
	return buf
}
fun MemoryStack.ptrOf(b1: Int, b2: Int, b3: Int, b4: Int, b5: Int): Ptr<Int> {
	val ptr = PtrInt(5)
	ptr[0] = b1
	ptr[1] = b2
	ptr[2] = b3
	ptr[3] = b4
	ptr[4] = b5
	return ptr
}
fun MemoryStack.bufferOf(b1: Int, b2: Int, b3: Int, b4: Int, b5: Int): IntBuffer {
	val buf = IntBuffer(5)
	buf[0] = b1
	buf[1] = b2
	buf[2] = b3
	buf[3] = b4
	buf[4] = b5
	return buf
}
fun MemoryStack.ptrOf(vararg ints: Int): Ptr<Int> {
    val ptr = PtrInt(ints.size)
    for (i in ints.indices) 
        ptr[i] = ints[i]
    return ptr
}
fun MemoryStack.ptrOf(b1: Long): Ptr<Long> {
	val ptr = PtrLong(1)
	ptr[0] = b1
	return ptr
}
fun MemoryStack.bufferOf(b1: Long): LongBuffer {
	val buf = LongBuffer(1)
	buf[0] = b1
	return buf
}
fun MemoryStack.ptrOf(b1: Long, b2: Long): Ptr<Long> {
	val ptr = PtrLong(2)
	ptr[0] = b1
	ptr[1] = b2
	return ptr
}
fun MemoryStack.bufferOf(b1: Long, b2: Long): LongBuffer {
	val buf = LongBuffer(2)
	buf[0] = b1
	buf[1] = b2
	return buf
}
fun MemoryStack.ptrOf(b1: Long, b2: Long, b3: Long): Ptr<Long> {
	val ptr = PtrLong(3)
	ptr[0] = b1
	ptr[1] = b2
	ptr[2] = b3
	return ptr
}
fun MemoryStack.bufferOf(b1: Long, b2: Long, b3: Long): LongBuffer {
	val buf = LongBuffer(3)
	buf[0] = b1
	buf[1] = b2
	buf[2] = b3
	return buf
}
fun MemoryStack.ptrOf(b1: Long, b2: Long, b3: Long, b4: Long): Ptr<Long> {
	val ptr = PtrLong(4)
	ptr[0] = b1
	ptr[1] = b2
	ptr[2] = b3
	ptr[3] = b4
	return ptr
}
fun MemoryStack.bufferOf(b1: Long, b2: Long, b3: Long, b4: Long): LongBuffer {
	val buf = LongBuffer(4)
	buf[0] = b1
	buf[1] = b2
	buf[2] = b3
	buf[3] = b4
	return buf
}
fun MemoryStack.ptrOf(b1: Long, b2: Long, b3: Long, b4: Long, b5: Long): Ptr<Long> {
	val ptr = PtrLong(5)
	ptr[0] = b1
	ptr[1] = b2
	ptr[2] = b3
	ptr[3] = b4
	ptr[4] = b5
	return ptr
}
fun MemoryStack.bufferOf(b1: Long, b2: Long, b3: Long, b4: Long, b5: Long): LongBuffer {
	val buf = LongBuffer(5)
	buf[0] = b1
	buf[1] = b2
	buf[2] = b3
	buf[3] = b4
	buf[4] = b5
	return buf
}
fun MemoryStack.ptrOf(vararg longs: Long): Ptr<Long> {
    val ptr = PtrLong(longs.size)
    for (i in longs.indices) 
        ptr[i] = longs[i]
    return ptr
}
fun MemoryStack.ptrOf(b1: UByte): Ptr<UByte> {
	val ptr = PtrUByte(1)
	ptr[0] = b1
	return ptr
}
fun MemoryStack.bufferOf(b1: UByte): UByteBuffer {
	val buf = UByteBuffer(1)
	buf[0] = b1
	return buf
}
fun MemoryStack.ptrOf(b1: UByte, b2: UByte): Ptr<UByte> {
	val ptr = PtrUByte(2)
	ptr[0] = b1
	ptr[1] = b2
	return ptr
}
fun MemoryStack.bufferOf(b1: UByte, b2: UByte): UByteBuffer {
	val buf = UByteBuffer(2)
	buf[0] = b1
	buf[1] = b2
	return buf
}
fun MemoryStack.ptrOf(b1: UByte, b2: UByte, b3: UByte): Ptr<UByte> {
	val ptr = PtrUByte(3)
	ptr[0] = b1
	ptr[1] = b2
	ptr[2] = b3
	return ptr
}
fun MemoryStack.bufferOf(b1: UByte, b2: UByte, b3: UByte): UByteBuffer {
	val buf = UByteBuffer(3)
	buf[0] = b1
	buf[1] = b2
	buf[2] = b3
	return buf
}
fun MemoryStack.ptrOf(b1: UByte, b2: UByte, b3: UByte, b4: UByte): Ptr<UByte> {
	val ptr = PtrUByte(4)
	ptr[0] = b1
	ptr[1] = b2
	ptr[2] = b3
	ptr[3] = b4
	return ptr
}
fun MemoryStack.bufferOf(b1: UByte, b2: UByte, b3: UByte, b4: UByte): UByteBuffer {
	val buf = UByteBuffer(4)
	buf[0] = b1
	buf[1] = b2
	buf[2] = b3
	buf[3] = b4
	return buf
}
fun MemoryStack.ptrOf(b1: UByte, b2: UByte, b3: UByte, b4: UByte, b5: UByte): Ptr<UByte> {
	val ptr = PtrUByte(5)
	ptr[0] = b1
	ptr[1] = b2
	ptr[2] = b3
	ptr[3] = b4
	ptr[4] = b5
	return ptr
}
fun MemoryStack.bufferOf(b1: UByte, b2: UByte, b3: UByte, b4: UByte, b5: UByte): UByteBuffer {
	val buf = UByteBuffer(5)
	buf[0] = b1
	buf[1] = b2
	buf[2] = b3
	buf[3] = b4
	buf[4] = b5
	return buf
}
fun MemoryStack.ptrOf(vararg ubytes: UByte): Ptr<UByte> {
    val ptr = PtrUByte(ubytes.size)
    for (i in ubytes.indices) 
        ptr[i] = ubytes[i]
    return ptr
}
fun MemoryStack.ptrOf(b1: UShort): Ptr<UShort> {
	val ptr = PtrUShort(1)
	ptr[0] = b1
	return ptr
}
fun MemoryStack.bufferOf(b1: UShort): UShortBuffer {
	val buf = UShortBuffer(1)
	buf[0] = b1
	return buf
}
fun MemoryStack.ptrOf(b1: UShort, b2: UShort): Ptr<UShort> {
	val ptr = PtrUShort(2)
	ptr[0] = b1
	ptr[1] = b2
	return ptr
}
fun MemoryStack.bufferOf(b1: UShort, b2: UShort): UShortBuffer {
	val buf = UShortBuffer(2)
	buf[0] = b1
	buf[1] = b2
	return buf
}
fun MemoryStack.ptrOf(b1: UShort, b2: UShort, b3: UShort): Ptr<UShort> {
	val ptr = PtrUShort(3)
	ptr[0] = b1
	ptr[1] = b2
	ptr[2] = b3
	return ptr
}
fun MemoryStack.bufferOf(b1: UShort, b2: UShort, b3: UShort): UShortBuffer {
	val buf = UShortBuffer(3)
	buf[0] = b1
	buf[1] = b2
	buf[2] = b3
	return buf
}
fun MemoryStack.ptrOf(b1: UShort, b2: UShort, b3: UShort, b4: UShort): Ptr<UShort> {
	val ptr = PtrUShort(4)
	ptr[0] = b1
	ptr[1] = b2
	ptr[2] = b3
	ptr[3] = b4
	return ptr
}
fun MemoryStack.bufferOf(b1: UShort, b2: UShort, b3: UShort, b4: UShort): UShortBuffer {
	val buf = UShortBuffer(4)
	buf[0] = b1
	buf[1] = b2
	buf[2] = b3
	buf[3] = b4
	return buf
}
fun MemoryStack.ptrOf(b1: UShort, b2: UShort, b3: UShort, b4: UShort, b5: UShort): Ptr<UShort> {
	val ptr = PtrUShort(5)
	ptr[0] = b1
	ptr[1] = b2
	ptr[2] = b3
	ptr[3] = b4
	ptr[4] = b5
	return ptr
}
fun MemoryStack.bufferOf(b1: UShort, b2: UShort, b3: UShort, b4: UShort, b5: UShort): UShortBuffer {
	val buf = UShortBuffer(5)
	buf[0] = b1
	buf[1] = b2
	buf[2] = b3
	buf[3] = b4
	buf[4] = b5
	return buf
}
fun MemoryStack.ptrOf(vararg ushorts: UShort): Ptr<UShort> {
    val ptr = PtrUShort(ushorts.size)
    for (i in ushorts.indices) 
        ptr[i] = ushorts[i]
    return ptr
}
fun MemoryStack.ptrOf(b1: UInt): Ptr<UInt> {
	val ptr = PtrUInt(1)
	ptr[0] = b1
	return ptr
}
fun MemoryStack.bufferOf(b1: UInt): UIntBuffer {
	val buf = UIntBuffer(1)
	buf[0] = b1
	return buf
}
fun MemoryStack.ptrOf(b1: UInt, b2: UInt): Ptr<UInt> {
	val ptr = PtrUInt(2)
	ptr[0] = b1
	ptr[1] = b2
	return ptr
}
fun MemoryStack.bufferOf(b1: UInt, b2: UInt): UIntBuffer {
	val buf = UIntBuffer(2)
	buf[0] = b1
	buf[1] = b2
	return buf
}
fun MemoryStack.ptrOf(b1: UInt, b2: UInt, b3: UInt): Ptr<UInt> {
	val ptr = PtrUInt(3)
	ptr[0] = b1
	ptr[1] = b2
	ptr[2] = b3
	return ptr
}
fun MemoryStack.bufferOf(b1: UInt, b2: UInt, b3: UInt): UIntBuffer {
	val buf = UIntBuffer(3)
	buf[0] = b1
	buf[1] = b2
	buf[2] = b3
	return buf
}
fun MemoryStack.ptrOf(b1: UInt, b2: UInt, b3: UInt, b4: UInt): Ptr<UInt> {
	val ptr = PtrUInt(4)
	ptr[0] = b1
	ptr[1] = b2
	ptr[2] = b3
	ptr[3] = b4
	return ptr
}
fun MemoryStack.bufferOf(b1: UInt, b2: UInt, b3: UInt, b4: UInt): UIntBuffer {
	val buf = UIntBuffer(4)
	buf[0] = b1
	buf[1] = b2
	buf[2] = b3
	buf[3] = b4
	return buf
}
fun MemoryStack.ptrOf(b1: UInt, b2: UInt, b3: UInt, b4: UInt, b5: UInt): Ptr<UInt> {
	val ptr = PtrUInt(5)
	ptr[0] = b1
	ptr[1] = b2
	ptr[2] = b3
	ptr[3] = b4
	ptr[4] = b5
	return ptr
}
fun MemoryStack.bufferOf(b1: UInt, b2: UInt, b3: UInt, b4: UInt, b5: UInt): UIntBuffer {
	val buf = UIntBuffer(5)
	buf[0] = b1
	buf[1] = b2
	buf[2] = b3
	buf[3] = b4
	buf[4] = b5
	return buf
}
fun MemoryStack.ptrOf(vararg uints: UInt): Ptr<UInt> {
    val ptr = PtrUInt(uints.size)
    for (i in uints.indices) 
        ptr[i] = uints[i]
    return ptr
}
fun MemoryStack.ptrOf(b1: ULong): Ptr<ULong> {
	val ptr = PtrULong(1)
	ptr[0] = b1
	return ptr
}
fun MemoryStack.bufferOf(b1: ULong): ULongBuffer {
	val buf = ULongBuffer(1)
	buf[0] = b1
	return buf
}
fun MemoryStack.ptrOf(b1: ULong, b2: ULong): Ptr<ULong> {
	val ptr = PtrULong(2)
	ptr[0] = b1
	ptr[1] = b2
	return ptr
}
fun MemoryStack.bufferOf(b1: ULong, b2: ULong): ULongBuffer {
	val buf = ULongBuffer(2)
	buf[0] = b1
	buf[1] = b2
	return buf
}
fun MemoryStack.ptrOf(b1: ULong, b2: ULong, b3: ULong): Ptr<ULong> {
	val ptr = PtrULong(3)
	ptr[0] = b1
	ptr[1] = b2
	ptr[2] = b3
	return ptr
}
fun MemoryStack.bufferOf(b1: ULong, b2: ULong, b3: ULong): ULongBuffer {
	val buf = ULongBuffer(3)
	buf[0] = b1
	buf[1] = b2
	buf[2] = b3
	return buf
}
fun MemoryStack.ptrOf(b1: ULong, b2: ULong, b3: ULong, b4: ULong): Ptr<ULong> {
	val ptr = PtrULong(4)
	ptr[0] = b1
	ptr[1] = b2
	ptr[2] = b3
	ptr[3] = b4
	return ptr
}
fun MemoryStack.bufferOf(b1: ULong, b2: ULong, b3: ULong, b4: ULong): ULongBuffer {
	val buf = ULongBuffer(4)
	buf[0] = b1
	buf[1] = b2
	buf[2] = b3
	buf[3] = b4
	return buf
}
fun MemoryStack.ptrOf(b1: ULong, b2: ULong, b3: ULong, b4: ULong, b5: ULong): Ptr<ULong> {
	val ptr = PtrULong(5)
	ptr[0] = b1
	ptr[1] = b2
	ptr[2] = b3
	ptr[3] = b4
	ptr[4] = b5
	return ptr
}
fun MemoryStack.bufferOf(b1: ULong, b2: ULong, b3: ULong, b4: ULong, b5: ULong): ULongBuffer {
	val buf = ULongBuffer(5)
	buf[0] = b1
	buf[1] = b2
	buf[2] = b3
	buf[3] = b4
	buf[4] = b5
	return buf
}
fun MemoryStack.ptrOf(vararg ulongs: ULong): Ptr<ULong> {
    val ptr = PtrULong(ulongs.size)
    for (i in ulongs.indices) 
        ptr[i] = ulongs[i]
    return ptr
}
fun MemoryStack.ptrOf(b1: Float): Ptr<Float> {
	val ptr = PtrFloat(1)
	ptr[0] = b1
	return ptr
}
fun MemoryStack.bufferOf(b1: Float): FloatBuffer {
	val buf = FloatBuffer(1)
	buf[0] = b1
	return buf
}
fun MemoryStack.ptrOf(b1: Float, b2: Float): Ptr<Float> {
	val ptr = PtrFloat(2)
	ptr[0] = b1
	ptr[1] = b2
	return ptr
}
fun MemoryStack.bufferOf(b1: Float, b2: Float): FloatBuffer {
	val buf = FloatBuffer(2)
	buf[0] = b1
	buf[1] = b2
	return buf
}
fun MemoryStack.ptrOf(b1: Float, b2: Float, b3: Float): Ptr<Float> {
	val ptr = PtrFloat(3)
	ptr[0] = b1
	ptr[1] = b2
	ptr[2] = b3
	return ptr
}
fun MemoryStack.bufferOf(b1: Float, b2: Float, b3: Float): FloatBuffer {
	val buf = FloatBuffer(3)
	buf[0] = b1
	buf[1] = b2
	buf[2] = b3
	return buf
}
fun MemoryStack.ptrOf(b1: Float, b2: Float, b3: Float, b4: Float): Ptr<Float> {
	val ptr = PtrFloat(4)
	ptr[0] = b1
	ptr[1] = b2
	ptr[2] = b3
	ptr[3] = b4
	return ptr
}
fun MemoryStack.bufferOf(b1: Float, b2: Float, b3: Float, b4: Float): FloatBuffer {
	val buf = FloatBuffer(4)
	buf[0] = b1
	buf[1] = b2
	buf[2] = b3
	buf[3] = b4
	return buf
}
fun MemoryStack.ptrOf(b1: Float, b2: Float, b3: Float, b4: Float, b5: Float): Ptr<Float> {
	val ptr = PtrFloat(5)
	ptr[0] = b1
	ptr[1] = b2
	ptr[2] = b3
	ptr[3] = b4
	ptr[4] = b5
	return ptr
}
fun MemoryStack.bufferOf(b1: Float, b2: Float, b3: Float, b4: Float, b5: Float): FloatBuffer {
	val buf = FloatBuffer(5)
	buf[0] = b1
	buf[1] = b2
	buf[2] = b3
	buf[3] = b4
	buf[4] = b5
	return buf
}
fun MemoryStack.ptrOf(vararg floats: Float): Ptr<Float> {
    val ptr = PtrFloat(floats.size)
    for (i in floats.indices) 
        ptr[i] = floats[i]
    return ptr
}
fun MemoryStack.ptrOf(b1: Double): Ptr<Double> {
	val ptr = PtrDouble(1)
	ptr[0] = b1
	return ptr
}
fun MemoryStack.bufferOf(b1: Double): DoubleBuffer {
	val buf = DoubleBuffer(1)
	buf[0] = b1
	return buf
}
fun MemoryStack.ptrOf(b1: Double, b2: Double): Ptr<Double> {
	val ptr = PtrDouble(2)
	ptr[0] = b1
	ptr[1] = b2
	return ptr
}
fun MemoryStack.bufferOf(b1: Double, b2: Double): DoubleBuffer {
	val buf = DoubleBuffer(2)
	buf[0] = b1
	buf[1] = b2
	return buf
}
fun MemoryStack.ptrOf(b1: Double, b2: Double, b3: Double): Ptr<Double> {
	val ptr = PtrDouble(3)
	ptr[0] = b1
	ptr[1] = b2
	ptr[2] = b3
	return ptr
}
fun MemoryStack.bufferOf(b1: Double, b2: Double, b3: Double): DoubleBuffer {
	val buf = DoubleBuffer(3)
	buf[0] = b1
	buf[1] = b2
	buf[2] = b3
	return buf
}
fun MemoryStack.ptrOf(b1: Double, b2: Double, b3: Double, b4: Double): Ptr<Double> {
	val ptr = PtrDouble(4)
	ptr[0] = b1
	ptr[1] = b2
	ptr[2] = b3
	ptr[3] = b4
	return ptr
}
fun MemoryStack.bufferOf(b1: Double, b2: Double, b3: Double, b4: Double): DoubleBuffer {
	val buf = DoubleBuffer(4)
	buf[0] = b1
	buf[1] = b2
	buf[2] = b3
	buf[3] = b4
	return buf
}
fun MemoryStack.ptrOf(b1: Double, b2: Double, b3: Double, b4: Double, b5: Double): Ptr<Double> {
	val ptr = PtrDouble(5)
	ptr[0] = b1
	ptr[1] = b2
	ptr[2] = b3
	ptr[3] = b4
	ptr[4] = b5
	return ptr
}
fun MemoryStack.bufferOf(b1: Double, b2: Double, b3: Double, b4: Double, b5: Double): DoubleBuffer {
	val buf = DoubleBuffer(5)
	buf[0] = b1
	buf[1] = b2
	buf[2] = b3
	buf[3] = b4
	buf[4] = b5
	return buf
}
fun MemoryStack.ptrOf(vararg doubles: Double): Ptr<Double> {
    val ptr = PtrDouble(doubles.size)
    for (i in doubles.indices) 
        ptr[i] = doubles[i]
    return ptr
}
// --------------------------------------------- getters ---------------------------------------------
inline fun <R, reified T> MemoryStack.read(block: (Adr) -> R): T = when (T::class.java) {
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
inline fun <R> MemoryStack.readByteFromAdr(block: (Adr) -> R): Byte = Ptr<Byte>().apply { block(adr) }.invoke()
inline fun <R> MemoryStack.readByteFromBuf(block: (ByteBuffer) -> R): Byte = ByteBuffer(1).also { block(it) }[0]
inline fun <R> MemoryStack.readShortFromAdr(block: (Adr) -> R): Short = Ptr<Short>().apply { block(adr) }.invoke()
inline fun <R> MemoryStack.readShortFromBuf(block: (ShortBuffer) -> R): Short = ShortBuffer(1).also { block(it) }[0]
inline fun <R> MemoryStack.readIntFromAdr(block: (Adr) -> R): Int = Ptr<Int>().apply { block(adr) }.invoke()
inline fun <R> MemoryStack.readIntFromBuf(block: (IntBuffer) -> R): Int = IntBuffer(1).also { block(it) }[0]
inline fun <R> MemoryStack.readLongFromAdr(block: (Adr) -> R): Long = Ptr<Long>().apply { block(adr) }.invoke()
inline fun <R> MemoryStack.readLongFromBuf(block: (LongBuffer) -> R): Long = LongBuffer(1).also { block(it) }[0]
inline fun <R> MemoryStack.readUByteFromAdr(block: (Adr) -> R): UByte = Ptr<UByte>().apply { block(adr) }.invoke()
inline fun <R> MemoryStack.readUByteFromBuf(block: (UByteBuffer) -> R): UByte = UByteBuffer(1).also { block(it) }[0]
inline fun <R> MemoryStack.readUShortFromAdr(block: (Adr) -> R): UShort = Ptr<UShort>().apply { block(adr) }.invoke()
inline fun <R> MemoryStack.readUShortFromBuf(block: (UShortBuffer) -> R): UShort = UShortBuffer(1).also { block(it) }[0]
inline fun <R> MemoryStack.readUIntFromAdr(block: (Adr) -> R): UInt = Ptr<UInt>().apply { block(adr) }.invoke()
inline fun <R> MemoryStack.readUIntFromBuf(block: (UIntBuffer) -> R): UInt = UIntBuffer(1).also { block(it) }[0]
inline fun <R> MemoryStack.readULongFromAdr(block: (Adr) -> R): ULong = Ptr<ULong>().apply { block(adr) }.invoke()
inline fun <R> MemoryStack.readULongFromBuf(block: (ULongBuffer) -> R): ULong = ULongBuffer(1).also { block(it) }[0]
inline fun <R> MemoryStack.readFloatFromAdr(block: (Adr) -> R): Float = Ptr<Float>().apply { block(adr) }.invoke()
inline fun <R> MemoryStack.readFloatFromBuf(block: (FloatBuffer) -> R): Float = FloatBuffer(1).also { block(it) }[0]
inline fun <R> MemoryStack.readDoubleFromAdr(block: (Adr) -> R): Double = Ptr<Double>().apply { block(adr) }.invoke()
inline fun <R> MemoryStack.readDoubleFromBuf(block: (DoubleBuffer) -> R): Double = DoubleBuffer(1).also { block(it) }[0]
/*inline fun <R> MemoryStack.pointerAdr(block: (Adr) -> R): Ptr {
    val ptr = PointerPtr()
    block(ptr.adr)
    return ptr()
}*/
inline fun <R> MemoryStack.pointerBuffer(block: (PointerBuffer) -> R): Long {
    val buf = mallocPointer(1)
    block(buf)
    return buf[0]
}
/** It mallocs, passes the address and reads the null terminated string */
inline fun <R> MemoryStack.readAsciiFromAdr(maxSize: Int, block: (Adr) -> R): String {
    val adr = nmalloc(1, maxSize)
    block(adr.toULong())
    return MemoryUtil.memASCII(adr, strlen64NT1(adr, maxSize))
}

/** It mallocs the buffer, passes it and reads the null terminated string */
inline fun <R> MemoryStack.readAsciiFromBuf(maxSize: Int, block: (ByteBuffer) -> R): String {
    val buf = malloc(1, maxSize)
    block(buf)
    return MemoryUtil.memASCII(buf.adr.toLong(), maxSize)
}
/** It mallocs, passes the address and reads the null terminated string */
inline fun <R> MemoryStack.readUtf8FromAdr(maxSize: Int, block: (Adr) -> R): String {
    val adr = nmalloc(1, maxSize)
    block(adr.toULong())
    return MemoryUtil.memUTF8(adr, strlen64NT1(adr, maxSize))
}

/** It mallocs the buffer, passes it and reads the null terminated string */
inline fun <R> MemoryStack.readUtf8FromBuf(maxSize: Int, block: (ByteBuffer) -> R): String {
    val buf = malloc(1, maxSize)
    block(buf)
    return MemoryUtil.memUTF8(buf.adr.toLong(), maxSize)
}
/** It mallocs, passes the address and reads the null terminated string */
inline fun <R> MemoryStack.readUtf16FromAdr(maxSize: Int, block: (Adr) -> R): String {
    val adr = nmalloc(1, maxSize)
    block(adr.toULong())
    return MemoryUtil.memUTF16(adr, strlen64NT1(adr, maxSize))
}

/** It mallocs the buffer, passes it and reads the null terminated string */
inline fun <R> MemoryStack.readUtf16FromBuf(maxSize: Int, block: (ByteBuffer) -> R): String {
    val buf = malloc(1, maxSize)
    block(buf)
    return MemoryUtil.memUTF16(buf.adr.toLong(), maxSize)
}
// --------------------------------------------- setters ---------------------------------------------
fun MemoryStack.writeAsciiToAdr(chars: CharSequence, nullTerminated: Boolean = true): Adr = nASCII(chars, nullTerminated).let { pointerAddress }.toULong()
fun MemoryStack.writeAsciiToBuffer(chars: CharSequence, nullTerminated: Boolean = true): ByteBuffer = ASCII(chars, nullTerminated)
fun MemoryStack.writeUtf8ToAdr(chars: CharSequence, nullTerminated: Boolean = true): Adr = nUTF8(chars, nullTerminated).let { pointerAddress }.toULong()
fun MemoryStack.writeUtf8ToBuffer(chars: CharSequence, nullTerminated: Boolean = true): ByteBuffer = UTF8(chars, nullTerminated)
fun MemoryStack.writeUtf16ToAdr(chars: CharSequence, nullTerminated: Boolean = true): Adr = nUTF16(chars, nullTerminated).let { pointerAddress }.toULong()
fun MemoryStack.writeUtf16ToBuffer(chars: CharSequence, nullTerminated: Boolean = true): ByteBuffer = UTF16(chars, nullTerminated)
