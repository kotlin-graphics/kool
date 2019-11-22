package kool

import org.lwjgl.PointerBuffer
import org.lwjgl.system.Configuration
import org.lwjgl.system.MemoryStack
import org.lwjgl.system.MemoryUtil
import org.lwjgl.system.Pointer
import java.nio.*
import kotlin.reflect.*

inline val Pointer.adr: Adr
    get() = address()

val Pointer.isInvalid: Boolean
    get() = adr == MemoryUtil.NULL
val Pointer.isValid: Boolean
    get() = adr != MemoryUtil.NULL


// cant inline class for java compatibility
typealias Ptr = Long
typealias Adr = Long


fun <R> ByteBuffer.use(block: (ByteBuffer) -> R) = block(this).also { free() }
fun <R> ShortBuffer.use(block: (ShortBuffer) -> R) = block(this).also { free() }
fun <R> IntBuffer.use(block: (IntBuffer) -> R) = block(this).also { free() }
fun <R> LongBuffer.use(block: (LongBuffer) -> R) = block(this).also { free() }
fun <R> FloatBuffer.use(block: (FloatBuffer) -> R) = block(this).also { free() }
fun <R> DoubleBuffer.use(block: (DoubleBuffer) -> R) = block(this).also { free() }
fun <R> CharBuffer.use(block: (CharBuffer) -> R) = block(this).also { free() }
fun <R> PointerBuffer.use(block: (PointerBuffer) -> R) = block(this).also { free() }



operator fun <R> KMutableProperty0<R>.getValue(host: Any?, property: KProperty<*>): R = get()
operator fun <R> KMutableProperty0<R>.setValue(host: Any?, property: KProperty<*>, value: R) = set(value)

operator fun <R> KProperty0<R>.getValue(host: Any?, metadata: KProperty<*>): R = get()

operator fun <T, R> KMutableProperty1<T, R>.getValue(host: T, metadata: KProperty<*>): R = get(host)
operator fun <T, R> KMutableProperty1<T, R>.setValue(host: T, metadata: KProperty<*>, value: R) = set(host, value)

operator fun <T, R> KProperty1<T, R>.getValue(host: T, metadata: KProperty<*>): R = get(host)

fun encodeUTF8(text: CharSequence, nullTerminated: Boolean, target: Ptr): Int {
    var i = 0
    val len = text.length
    var p = 0

    var c = text[i]

    // ASCII fast path
    while (i < len && c.toInt() < 0x80) {
        UNSAFE.putByte(target + p++, c.toByte())
        if (++i < len)
            c = text[i]
        else break
    }

    // Slow path
    while (i < len) {
        c = text[i++]
        if (c.toInt() < 0x80)
            UNSAFE.putByte(target + p++, c.toByte())
        else {
            var cp = c.toInt()
            if (c.toInt() < 0x800) {
                UNSAFE.putByte(target + p++, (0xC0 or (cp shr 6)).toByte())
            } else {
                if (!c.isHighSurrogate())
                    UNSAFE.putByte(target + p++, (0xE0 or (cp shr 12)).toByte())
                else {
                    cp = Character.toCodePoint(c, text[i++])

                    UNSAFE.putByte(target + p++, (0xF0 or (cp shr 18)).toByte())
                    UNSAFE.putByte(target + p++, (0x80 or (cp shr 12 and 0x3F)).toByte())
                }
                UNSAFE.putByte(target + p++, (0x80 or (cp shr 6 and 0x3F)).toByte())
            }
            UNSAFE.putByte(target + p++, (0x80 or (cp and 0x3F)).toByte())
        }
    }

    if (nullTerminated)
        UNSAFE.putByte(target + p++, 0.toByte()) // TODO: did we have a bug here?

    return p
}

fun encodeASCII(text: CharSequence, nullTerminated: Boolean, target: Ptr): Int {
    var len = text.length
    for (p in 0 until len)
        UNSAFE.putByte(target + p, text[p].toByte())
    if (nullTerminated)
        UNSAFE.putByte(target + len++, 0.toByte())
    return len
}