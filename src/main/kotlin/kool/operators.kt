package kool

import org.lwjgl.PointerBuffer
import org.lwjgl.system.Pointer
import java.nio.*

operator fun IntBuffer.get(e: Enum<*>) = get(e.ordinal)
operator fun IntBuffer.set(e: Enum<*>, value: Int): IntBuffer = put(e.ordinal, value)
operator fun IntArray.get(e: Enum<*>) = get(e.ordinal)
operator fun IntArray.set(e: Enum<*>, int: Int) = set(e.ordinal, int)
inline fun <reified T : Enum<T>> IntArray() = IntArray(enumValues<T>().size)

/** for opengl  */
inline fun <reified E : Enum<E>> IntBuffer() = IntBuffer(enumValues<E>().size)
/** glGenTextures(textureName[Tex.Color]) */
operator fun <E : Enum<E>, T> Array<T>.get(enum: Enum<E>): T = get(enum.ordinal)

operator fun ByteBuffer.set(index: Int, byte: Byte){
    put(index, byte)
}

operator fun ShortBuffer.set(index: Int, short: Short){
    put(index, short)
}

operator fun CharBuffer.set(index: Int, char: Char){
    put(index, char)
}

operator fun IntBuffer.set(index: Int, int: Int){
    put(index, int)
}

operator fun LongBuffer.set(index: Int, long: Long){
    put(index, long)
}

operator fun FloatBuffer.set(index: Int, float: Float){
    put(index, float)
}

operator fun DoubleBuffer.set(index: Int, double: Double){
    put(index, double)
}

operator fun PointerBuffer.set(index: Int, long: Long) {
    put(index, long)
}

operator fun PointerBuffer.set(index: Int, pointer: Pointer) {
    put(index, pointer)
}

operator fun PointerBuffer.set(index: Int, buffer: Buffer) {
    put(index, buffer.adr)
}
