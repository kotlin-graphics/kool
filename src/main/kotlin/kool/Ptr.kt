@file:Suppress("NOTHING_TO_INLINE")

package kool

import org.lwjgl.system.MemoryUtil
import kotlin.random.Random

@JvmInline
value class Ptr<out T>(val address: Address = NULL.address) : Comparable<Ptr<@UnsafeVariance T>> {
    inline val adr: Adr
        get() = address
    inline val isValid: Boolean
        get() = adr != 0uL
    inline val isNotValid: Boolean
        get() = adr == 0uL

    inline fun <T> toPtr(): Ptr<T> = Ptr(adr)

    val speakable: String
        get() = formatUidDigit(adr)

    private fun formatUidDigit(n: ULong, level: Int = 0): String = when {
        n != 0uL -> {
            infix fun Int.has(other: Int): Boolean = and(other) != 0
            val letters = if (level has 1) oddLetters else evenLetters
            val base = letters.length.toULong()
            val s = formatUidDigit(n / base, level + 1)
            s + letters[(n % base).toInt()]
        }

        else -> ""
    }

    override fun compareTo(other: Ptr<@UnsafeVariance T>): Int = address.compareTo(other.address)

    override fun toString(): String = "0x%08X".format(address.toLong()) + ", " + speakable

    companion object {
        val NULL: Ptr<Nothing>
            get() = Ptr(MemoryUtil.NULL.toULong())

        private const val evenLetters = "bcdfghlmnprstwx"
        private const val oddLetters = "aeiou"
    }
}

inline fun <T> Ptr(long: Long): Ptr<T> = Ptr(long.toULong())

typealias Pointer = ULong
typealias Adr = ULong
typealias Address = ULong


fun main() {

    for (i in 0..99) {
        val k = Random.nextLong(1000000, 2000000).toPtr<Nothing>()
        println(k)
    }
}
