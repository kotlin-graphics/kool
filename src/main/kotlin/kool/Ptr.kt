@file:Suppress("NOTHING_TO_INLINE")
package kool

import org.lwjgl.system.MemoryUtil

@JvmInline
value class Ptr<out T>(val address: Address = NULL.address) : Comparable<Ptr<@UnsafeVariance T>>{
    inline val adr: Adr
        get() = address
    inline val isValid: Boolean
        get() = adr != 0uL
    inline val isNotValid: Boolean
        get() = adr == 0uL

    inline fun <T> toPtr(): Ptr<T> = Ptr(adr)

    override fun compareTo(other: Ptr<@UnsafeVariance T>): Int = address.compareTo(other.address)
    companion object {
        val NULL: Ptr<Nothing>
            get() = Ptr(MemoryUtil.NULL.toULong())
    }
}

inline fun <T> Ptr(long: Long): Ptr<T> = Ptr(long.toULong())

typealias Pointer = ULong
typealias Adr = ULong
typealias Address = ULong

//inline operator fun Ptr<*>.plus(offset: Long): Ptr<*> = plus(offset.toULong())
//inline operator fun <T> Ptr<T>.plus(offset: ULong): Ptr<T> = Ptr(address + offset)