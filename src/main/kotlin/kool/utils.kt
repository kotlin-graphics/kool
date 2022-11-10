@file:Suppress("NOTHING_TO_INLINE")

package kool

import org.lwjgl.PointerBuffer
import org.lwjgl.system.MathUtil
import org.lwjgl.system.MemoryUtil
import org.lwjgl.system.Pointer
import java.nio.*
import kotlin.reflect.*

inline val Pointer.adr: Adr
    get() = address().toULong()

val Pointer.isInvalid: Boolean
    get() = adr == MemoryUtil.NULL.toULong()
val Pointer.isValid: Boolean
    get() = adr != MemoryUtil.NULL.toULong()


val a: Ptr<Byte> = Ptr.NULL
//inline operator fun Ptr<Int>.set(index: Int, value: Byte) {
//
//}

inline fun <T> Long.toPtr(): Ptr<T> = Ptr(this.toULong())
inline fun <T> ULong.toPtr(): Ptr<T> = Ptr(this)


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

fun encodeUTF8(text: CharSequence, nullTerminated: Boolean, target: Ptr<Byte>): Int {
    var p = 0
    var i = 0
    val len = text.length

    while (i < len) {
        val c = text[i++]
        val code = c.code
        if (code < 0x80)
            target[p++] = code.toByte()
        else {
            var cp = code
            if (code < 0x800)
                target[p++] = (0xC0 or (cp shr 6)).toByte()
            else {
                if (!c.isHighSurrogate())
                    target[p++] = (0xE0 or (cp shr 12)).toByte()
                else {
                    cp = Character.toCodePoint(c, text[i++])

                    target[p++] = (0xF0 or (cp shr 18)).toByte()
                    target[p++] = (0x80 or ((cp shr 12) and 0x3F)).toByte()
                }
                target[p++] = (0x80 or ((cp shr 6) and 0x3F)).toByte()
            }
            target[p++] = (0x80 or (cp and 0x3F)).toByte()
        }
    }

    if (nullTerminated)
        target[p++] = 0

    return p
}


fun strlen64NT1(address: Long, maxLength: Int): Int {
    var i = 0
    if (8 <= maxLength) {
        val misalignment = address.toInt() and 7
        if (misalignment != 0) {
            // Align to 8 bytes
            val len = 8 - misalignment
            while (i < len) {
                if (unsafe.getByte(null, address + i).toInt() == 0)
                    return i
                i++
            }
        }
        // Aligned longs for performance
        while (i <= maxLength - 8) {
            if (MathUtil.mathHasZeroByte(unsafe.getLong(null, address + i)))
                break
            i += 8
        }
    }
    // Tail
    while (i < maxLength) {
        if (unsafe.getByte(null, address + i).toInt() == 0)
            break
        i++
    }
    return i
}


// Unfortunately JetBrains went its own way: https://youtrack.jetbrains.com/issue/KT-8247 , let's keep it coherent with Java
inline val Byte.Companion.BYTES: Int
    get() = java.lang.Byte.BYTES
inline val UByte.Companion.BYTES: Int
    get() = Byte.BYTES
inline val Float.Companion.BYTES: Int
    get() = java.lang.Float.BYTES
inline val Double.Companion.BYTES: Int
    get() = java.lang.Double.BYTES
inline val Int.Companion.BYTES: Int
    get() = Integer.BYTES
inline val UInt.Companion.BYTES: Int
    get() = Int.BYTES
inline val Long.Companion.BYTES: Int
    get() = java.lang.Long.BYTES
inline val ULong.Companion.BYTES: Int
    get() = Long.BYTES
inline val Short.Companion.BYTES: Int
    get() = java.lang.Short.BYTES
inline val UShort.Companion.BYTES: Int
    get() = Short.BYTES
inline val Char.Companion.BYTES: Int
    get() = Character.BYTES
