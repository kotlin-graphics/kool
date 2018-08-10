package kool_

import java.nio.*
import java.util.concurrent.atomic.AtomicLong

fun ByteArray.toBuffer(): ByteBuffer {
    val buf = kool.buffer(size)
    for(i in indices)
        buf.put(i, get(i))
    return buf
}

//fun ByteArray.toShortBuffer(): ShortBuffer {
//    val buf = kool.shortBuffer(size)
//    for(i in indices)
//        buf.put(i, get(i))
//    return buf
//}


fun ShortArray.toBuffer(): ByteBuffer {
    val buf = kool.buffer(size * 2)
    for(i in indices)
        buf.putShort(i * 2, get(i))
    return buf
}

fun ShortArray.toShortBuffer(): ShortBuffer {
    val buf = kool.shortBuffer(size)
    for(i in indices)
        buf.put(i, get(i))
    return buf
}

fun IntArray.toBuffer(): ByteBuffer {
    val buf = kool.buffer(size * 4)
    for(i in indices)
        buf.putInt(i * 4, get(i))
    return buf
}

fun IntArray.toIntBuffer(): IntBuffer {
    val buf = kool.intBuffer(size)
    for(i in indices)
        buf.put(i, get(i))
    return buf
}

fun LongArray.toBuffer(): ByteBuffer {
    val buf = kool.buffer(size * 8)
    for(i in indices)
        buf.putLong(i * 8, get(i))
    return buf
}

fun LongArray.toLongBuffer(): LongBuffer {
    val buf = kool.longBuffer(size)
    for(i in indices)
        buf.put(i, get(i))
    return buf
}

fun FloatArray.toBuffer(): ByteBuffer {
    val buf = kool.buffer(size * 4)
    for(i in indices)
        buf.putFloat(i * 4, get(i))
    return buf
}

fun FloatArray.toFloatBuffer(): FloatBuffer {
    val buf = kool.floatBuffer(size)
    for(i in indices)
        buf.put(i, get(i))
    return buf
}

fun DoubleArray.toBuffer(): ByteBuffer {
    val buf = kool.buffer(size * 8)
    for(i in indices)
        buf.putDouble(i * 8, get(i))
    return buf
}

fun DoubleArray.toDoubleBuffer(): DoubleBuffer {
    val buf = kool.doubleBuffer(size)
    for(i in indices)
        buf.put(i, get(i))
    return buf
}


infix fun AtomicLong.advance(int: Int) = getAndAdd(int.toLong())