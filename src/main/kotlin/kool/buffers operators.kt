package kool

import org.lwjgl.PointerBuffer
import org.lwjgl.system.Pointer
import org.lwjgl.system.Struct
import org.lwjgl.system.StructBuffer
import java.nio.*

operator fun IntBuffer.get(e: Enum<*>): Int = get(e.ordinal)
operator fun IntBuffer.set(e: Enum<*>, value: Int): IntBuffer = put(e.ordinal, value)
operator fun IntArray.get(e: Enum<*>): Int = get(e.ordinal)
operator fun IntArray.set(e: Enum<*>, int: Int) = set(e.ordinal, int)

/** for opengl  */
inline fun <reified E : Enum<E>> IntBuffer(): IntBuffer = IntBuffer(enumValues<E>().size)

//operator fun <E : Enum<E>, T> Array<T>.get(enum: Enum<E>): T = get(enum.ordinal)


operator fun <T : Struct, SELF : StructBuffer<T, SELF>> StructBuffer<T, SELF>.set(index: Int, value: T) {
    put(index, value)
}