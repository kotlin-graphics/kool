package kool.lib

import kool.BYTES
import kool.lim
import kool.set
import org.lwjgl.system.MemoryUtil.*
import java.nio.IntBuffer


fun IntBuffer.maxWith(comparator: Comparator<in Int>): Int? {
    if (isEmpty()) return null
    var max = this[0]
    for (i in 1..lastIndex) {
        val e = this[i]
        if (comparator.compare(max, e) < 0) max = e
    }
    return max
}


fun IntBuffer.minWith(comparator: Comparator<in Int>): Int? {
    if (isEmpty()) return null
    var min = this[0]
    for (i in 1..lastIndex) {
        val e = this[i]
        if (comparator.compare(min, e) > 0) min = e
    }
    return min
}



// no requireNoNulls
inline fun IntBuffer.partition(predicate: (Int) -> Boolean): Pair<List<Int>, List<Int>> {
    val first = ArrayList<Int>()
    val second = ArrayList<Int>()
    for (element in this)
        if (predicate(element)) first += element
        else second += element
    return Pair(first, second)
}

infix fun <R> IntBuffer.zip(other: Iterable<R>): List<Pair<Int, R>> = zip(other) { t1, t2 -> t1 to t2 }
inline fun <R, V> IntBuffer.zip(other: Iterable<R>, transform: (a: Int, b: R) -> V): List<V> {
    val arraySize = lim
    val list = ArrayList<V>(minOf(other.collectionSizeOrDefault(10), arraySize))
    var i = 0
    for (element in other) {
        if (i >= arraySize) break
        list += transform(this[i++], element)
    }
    return list
}

infix fun IntBuffer.zip(other: IntBuffer): List<Pair<Int, Int>> = zip(other) { t1, t2 -> t1 to t2 }
inline fun <V> IntBuffer.zip(other: IntBuffer, transform: (a: Int, b: Int) -> V): List<V> {
    val size = minOf(lim, other.lim)
    val list = ArrayList<V>(size)
    for (i in 0 until size)
        list += transform(this[i], other[i])
    return list
}

fun <A : Appendable> IntBuffer.joinTo(buffer: A, separator: CharSequence = ", ", prefix: CharSequence = "", postfix: CharSequence = "", limit: Int = -1,
                                      truncated: CharSequence = "...", transform: ((Int) -> CharSequence)? = null): A {
    TODO()
//    buffer += prefix
//    var count = 0
//    for (element in this) {
//        if (++count > 1) buffer += separator
//        if (limit < 0 || count <= limit) {
//            if (transform != null) buffer += transform(element)
//            else buffer += element.toString()
//        } else break
//    }
//    if (limit in 0 until count) buffer += truncated
//    buffer += postfix
//    return buffer
}

fun IntBuffer.joinToString(separator: CharSequence = ", ", prefix: CharSequence = "", postfix: CharSequence = "", limit: Int = -1,
                           truncated: CharSequence = "...", transform: ((Int) -> CharSequence)? = null) =
        joinTo(StringBuilder(), separator, prefix, postfix, limit, truncated, transform).toString()



//operator fun IntBuffer.plus(element: Int): IntBuffer {
//    val dst = memRealloc(this, capacity + 1)!!
//    dst[capacity] = element
//    return dst
//}

//operator fun IntBuffer.plus(elements: Collection<Int>): IntBuffer {
//    val dst = memRealloc(this, capacity + elements.size)!!
//    for (i in 0 until elements.size) dst[capacity + i] = elements.elementAt(i)
//    return dst
//}

//operator fun IntBuffer.plus(elements: IntBuffer): IntBuffer {
//    val dst = memRealloc(this, capacity + elements.capacity)!!
//    for (i in 0 until elements.size) dst[capacity + i] = elements.elementAt(i)
//    return dst
//}


/** Iterables   */
fun <T> Iterable<T>.collectionSizeOrDefault(default: Int) = if (this is Collection<*>) this.size else default
