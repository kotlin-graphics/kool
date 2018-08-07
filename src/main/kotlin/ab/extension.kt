package ab

import java.nio.*

fun ByteArray.toBuffer(): ByteBuffer {
    val buf = appBuffer.buffer(size)
    for(i in indices)
        buf.put(i, get(i))
    return buf
}

//fun ByteArray.toShortBuffer(): ShortBuffer {
//    val buf = appBuffer.shortBuffer(size)
//    for(i in indices)
//        buf.put(i, get(i))
//    return buf
//}


fun ShortArray.toBuffer(): ByteBuffer {
    val buf = appBuffer.buffer(size * 2)
    for(i in indices)
        buf.putShort(i * 2, get(i))
    return buf
}

fun ShortArray.toShortBuffer(): ShortBuffer {
    val buf = appBuffer.shortBuffer(size)
    for(i in indices)
        buf.put(i, get(i))
    return buf
}

fun IntArray.toBuffer(): ByteBuffer {
    val buf = appBuffer.buffer(size * 4)
    for(i in indices)
        buf.putInt(i * 4, get(i))
    return buf
}

fun IntArray.toIntBuffer(): IntBuffer {
    val buf = appBuffer.intBuffer(size)
    for(i in indices)
        buf.put(i, get(i))
    return buf
}

fun LongArray.toBuffer(): ByteBuffer {
    val buf = appBuffer.buffer(size * 8)
    for(i in indices)
        buf.putLong(i * 8, get(i))
    return buf
}

fun LongArray.toLongBuffer(): LongBuffer {
    val buf = appBuffer.longBuffer(size)
    for(i in indices)
        buf.put(i, get(i))
    return buf
}

fun FloatArray.toBuffer(): ByteBuffer {
    val buf = appBuffer.buffer(size * 4)
    for(i in indices)
        buf.putFloat(i * 4, get(i))
    return buf
}

fun FloatArray.toFloatBuffer(): FloatBuffer {
    val buf = appBuffer.floatBuffer(size)
    for(i in indices)
        buf.put(i, get(i))
    return buf
}

fun DoubleArray.toBuffer(): ByteBuffer {
    val buf = appBuffer.buffer(size * 8)
    for(i in indices)
        buf.putDouble(i * 8, get(i))
    return buf
}

fun DoubleArray.toDoubleBuffer(): DoubleBuffer {
    val buf = appBuffer.doubleBuffer(size)
    for(i in indices)
        buf.put(i, get(i))
    return buf
}