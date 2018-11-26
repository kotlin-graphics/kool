package kool

import org.lwjgl.system.MemoryStack
import java.nio.*


fun ByteArray.toBuffer(): ByteBuffer = Buffer(size) { get(it) }

//fun ByteArray.toShortBuffer(): ShortBuffer {
//    val buf = stak.shortBuffer(size)
//    for(i in indices)
//        buf.put(i, get(i))
//    return buf
//}


fun ShortArray.toBuffer(): ByteBuffer {
    val buf = Buffer(size * 2)
    for (i in indices)
        buf.putShort(i * 2, get(i))
    return buf
}

fun ShortArray.toShortBuffer(): ShortBuffer = ShortBuffer(size) { get(it) }

fun IntArray.toBuffer(): ByteBuffer {
    val buf = Buffer(size * 4)
    for (i in indices)
        buf.putInt(i * 4, get(i))
    return buf
}

fun IntArray.toIntBuffer(): IntBuffer = IntBuffer(size) { get(it) }

fun LongArray.toBuffer(): ByteBuffer {
    val buf = Buffer(size * 8)
    for (i in indices)
        buf.putLong(i * 8, get(i))
    return buf
}

fun LongArray.toLongBuffer(): LongBuffer = LongBuffer(size) { get(it) }

fun FloatArray.toBuffer(): ByteBuffer {
    val buf = Buffer(size * 4)
    for (i in indices)
        buf.putFloat(i * 4, get(i))
    return buf
}

fun FloatArray.toFloatBuffer(): FloatBuffer = FloatBuffer(size) { get(it) }

fun DoubleArray.toBuffer(): ByteBuffer {
    val buf = Buffer(size * 8)
    for (i in indices)
        buf.putDouble(i * 8, get(i))
    return buf
}

fun DoubleArray.toDoubleBuffer(): DoubleBuffer = DoubleBuffer(size) { get(it) }


fun ByteArray.toBuffer(stack: MemoryStack): ByteBuffer {
    val buf = stack.Buffer(size)
    for (i in indices)
        buf.put(i, get(i))
    return buf
}

//fun ByteArray.toShortBuffer(): ShortBuffer {
//    val buf = stak.shortBuffer(size)
//    for(i in indices)
//        buf.put(i, get(i))
//    return buf
//}


fun ShortArray.toBuffer(stack: MemoryStack): ByteBuffer {
    val buf = stack.malloc(size * 2)
    for (i in indices)
        buf.putShort(i * 2, get(i))
    return buf
}

fun ShortArray.toShortBuffer(stack: MemoryStack): ShortBuffer = stack.ShortBuffer(size) { get(it) }

fun IntArray.toBuffer(stack: MemoryStack): ByteBuffer {
    val buf = stack.malloc(size * 4)
    for (i in indices)
        buf.putInt(i * 4, get(i))
    return buf
}

fun IntArray.toIntBuffer(stack: MemoryStack): IntBuffer = stack.IntBuffer(size) { get(it) }

fun LongArray.toBuffer(stack: MemoryStack): ByteBuffer {
    val buf = stack.malloc(size * 8)
    for (i in indices)
        buf.putLong(i * 8, get(i))
    return buf
}

fun LongArray.toLongBuffer(stack: MemoryStack): LongBuffer = stack.LongBuffer(size) { get(it) }

fun FloatArray.toBuffer(stack: MemoryStack): ByteBuffer {
    val buf = stack.malloc(size * 4)
    for (i in indices)
        buf.putFloat(i * 4, get(i))
    return buf
}

fun FloatArray.toFloatBuffer(stack: MemoryStack): FloatBuffer = stack.FloatBuffer(size) { get(it) }

fun DoubleArray.toBuffer(stack: MemoryStack): ByteBuffer {
    val buf = stack.malloc(size * 8)
    for (i in indices)
        buf.putDouble(i * 8, get(i))
    return buf
}

fun DoubleArray.toDoubleBuffer(stack: MemoryStack): DoubleBuffer = stack.DoubleBuffer(size) { get(it) }