package kool

import org.lwjgl.system.MemoryStack
import java.nio.*


fun ByteArray.toBuffer(): ByteBuffer {
    val buf = bufferBig(size)
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


fun ShortArray.toBuffer(): ByteBuffer {
    val buf = bufferBig(size * 2)
    for (i in indices)
        buf.putShort(i * 2, get(i))
    return buf
}

fun ShortArray.toShortBuffer(): ShortBuffer {
    val buf = shortBufferBig(size)
    for (i in indices)
        buf.put(i, get(i))
    return buf
}

fun IntArray.toBuffer(): ByteBuffer {
    val buf = bufferBig(size * 4)
    for (i in indices)
        buf.putInt(i * 4, get(i))
    return buf
}

fun IntArray.toIntBuffer(): IntBuffer {
    val buf = intBufferBig(size)
    for (i in indices)
        buf.put(i, get(i))
    return buf
}

fun LongArray.toBuffer(): ByteBuffer {
    val buf = bufferBig(size * 8)
    for (i in indices)
        buf.putLong(i * 8, get(i))
    return buf
}

fun LongArray.toLongBuffer(): LongBuffer {
    val buf = longBufferBig(size)
    for (i in indices)
        buf.put(i, get(i))
    return buf
}

fun FloatArray.toBuffer(): ByteBuffer {
    val buf = bufferBig(size * 4)
    for (i in indices)
        buf.putFloat(i * 4, get(i))
    return buf
}

fun FloatArray.toFloatBuffer(): FloatBuffer {
    val buf = floatBufferBig(size)
    for (i in indices)
        buf.put(i, get(i))
    return buf
}

fun DoubleArray.toBuffer(): ByteBuffer {
    val buf = bufferBig(size * 8)
    for (i in indices)
        buf.putDouble(i * 8, get(i))
    return buf
}

fun DoubleArray.toDoubleBuffer(): DoubleBuffer {
    val buf = doubleBufferBig(size)
    for (i in indices)
        buf.put(i, get(i))
    return buf
}



fun ByteArray.toBuffer(stack: MemoryStack): ByteBuffer {
    val buf = stack.malloc(size)
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

fun ShortArray.toShortBuffer(stack: MemoryStack): ShortBuffer {
    val buf = stack.callocShort(size)
    for (i in indices)
        buf.put(i, get(i))
    return buf
}

fun IntArray.toBuffer(stack: MemoryStack): ByteBuffer {
    val buf = stack.malloc(size * 4)
    for (i in indices)
        buf.putInt(i * 4, get(i))
    return buf
}

fun IntArray.toIntBuffer(stack: MemoryStack): IntBuffer {
    val buf = stack.callocInt(size)
    for (i in indices)
        buf.put(i, get(i))
    return buf
}

fun LongArray.toBuffer(stack: MemoryStack): ByteBuffer {
    val buf = stack.malloc(size * 8)
    for (i in indices)
        buf.putLong(i * 8, get(i))
    return buf
}

fun LongArray.toLongBuffer(stack: MemoryStack): LongBuffer {
    val buf = stack.callocLong(size)
    for (i in indices)
        buf.put(i, get(i))
    return buf
}

fun FloatArray.toBuffer(stack: MemoryStack): ByteBuffer {
    val buf = stack.malloc(size * 4)
    for (i in indices)
        buf.putFloat(i * 4, get(i))
    return buf
}

fun FloatArray.toFloatBuffer(stack: MemoryStack): FloatBuffer {
    val buf = stack.callocFloat(size)
    for (i in indices)
        buf.put(i, get(i))
    return buf
}

fun DoubleArray.toBuffer(stack: MemoryStack): ByteBuffer {
    val buf = stack.malloc(size * 8)
    for (i in indices)
        buf.putDouble(i * 8, get(i))
    return buf
}

fun DoubleArray.toDoubleBuffer(stack: MemoryStack): DoubleBuffer {
    val buf = stack.callocDouble(size)
    for (i in indices)
        buf.put(i, get(i))
    return buf
}