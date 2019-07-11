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


typealias Ptr = Long // TODO inline class?
typealias Adr = Long // TODO inline class?


fun <R> ByteBuffer.use(block: (ByteBuffer) -> R) = block(this).also { free() }
fun <R> ShortBuffer.use(block: (ShortBuffer) -> R) = block(this).also { free() }
fun <R> IntBuffer.use(block: (IntBuffer) -> R) = block(this).also { free() }
fun <R> LongBuffer.use(block: (LongBuffer) -> R) = block(this).also { free() }
fun <R> FloatBuffer.use(block: (FloatBuffer) -> R) = block(this).also { free() }
fun <R> DoubleBuffer.use(block: (DoubleBuffer) -> R) = block(this).also { free() }
fun <R> CharBuffer.use(block: (CharBuffer) -> R) = block(this).also { free() }
fun <R> PointerBuffer.use(block: (PointerBuffer) -> R) = block(this).also { free() }

fun MemoryStack.reset() {
    pointer = Configuration.STACK_SIZE.get(64) * 1024
}

operator fun <R> KMutableProperty0<R>.getValue(host: Any?, property: KProperty<*>): R = get()
operator fun <R> KMutableProperty0<R>.setValue(host: Any?, property: KProperty<*>, value: R) = set(value)

operator fun <R> KProperty0<R>.getValue(host: Any?, metadata: KProperty<*>): R = get()

operator fun <T, R> KMutableProperty1<T, R>.getValue(host: T, metadata: KProperty<*>): R = get(host)
operator fun <T, R> KMutableProperty1<T, R>.setValue(host: T, metadata: KProperty<*>, value: R) = set(host, value)

operator fun <T, R> KProperty1<T, R>.getValue(host: T, metadata: KProperty<*>): R = get(host)