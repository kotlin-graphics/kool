@file:Suppress("NOTHING_TO_INLINE")
package kool

import org.lwjgl.system.MemoryUtil

@JvmInline
value class Ptr<out T>  constructor(val address: Address = NULL.address) {
    inline val adr: Adr
        get() = address

    inline operator fun plus(offset: Int): Ptr<T> = plus(offset.toULong())
    inline operator fun plus(offset: Long): Ptr<T> = plus(offset.toULong())
    inline operator fun plus(offset: ULong): Ptr<T> = Ptr(address + offset)

    inline fun <T> toPtr(): Ptr<T> = Ptr(adr)
    companion object {
        val NULL: Ptr<Nothing>
            get() = Ptr(MemoryUtil.NULL.toULong())
    }
}

inline fun <T> Ptr(long: Long): Ptr<T> = Ptr(long.toULong())

typealias Pointer = ULong
typealias Adr = ULong
typealias Address = ULong