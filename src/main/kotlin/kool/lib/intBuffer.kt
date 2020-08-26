package kool.lib

import kool.BYTES
import kool.lim
import kool.set
import org.lwjgl.system.MemoryUtil.*
import java.nio.IntBuffer


inline fun <R> IntBuffer.flatMap(transform: (Int) -> Iterable<R>) = flatMapTo(ArrayList(), transform)
inline fun <R, C : MutableCollection<in R>> IntBuffer.flatMapTo(destination: C, transform: (Int) -> Iterable<R>): C {
    for (element in this) {
        val list = transform(element)
        destination += list
    }
    return destination
}

inline fun <K> IntBuffer.groupBy(keySelector: (Int) -> K): Map<K, List<Int>> = groupByTo(LinkedHashMap(), keySelector)
inline fun <K, V> IntBuffer.groupBy(keySelector: (Int) -> K, valueTransform: (Int) -> V): Map<K, List<V>> =
        groupByTo(LinkedHashMap(), keySelector, valueTransform)

inline fun <K, M : MutableMap<in K, MutableList<Int>>> IntBuffer.groupByTo(destination: M, keySelector: (Int) -> K): M {
    for (element in this) {
        val key = keySelector(element)
        val list = destination.getOrPut(key) { ArrayList() }
        list += element
    }
    return destination
}

inline fun <K, V, M : MutableMap<in K, MutableList<V>>> IntBuffer.groupByTo(destination: M, keySelector: (Int) -> K, valueTransform: (Int) -> V): M {
    for (element in this) {
        val key = keySelector(element)
        val list = destination.getOrPut(key) { ArrayList() }
        list += valueTransform(element)
    }
    return destination
}

inline fun <R : Any> IntBuffer.mapIndexedNotNull(transform: (index: Int, Int) -> R?): List<R> = mapIndexedNotNullTo(ArrayList(), transform)
inline fun <R : Any, C : MutableCollection<in R>> IntBuffer.mapIndexedNotNullTo(destination: C, transform: (index: Int, Int) -> R?): C {
    forEachIndexed { index, element -> transform(index, element)?.let { destination += it } }
    return destination
}


inline fun <R : Any> IntBuffer.mapNotNull(transform: (Int) -> R?): List<R> = mapNotNullTo(ArrayList<R>(), transform)
inline fun <R : Any, C : MutableCollection<in R>> IntBuffer.mapNotNullTo(destination: C, transform: (Int) -> R?): C {
    forEach { element -> transform(element)?.let { destination.add(it) } }
    return destination
}


fun IntBuffer.withIndex(): Iterable<IndexedValue<Int>> = IndexingIterable { iterator() }
fun IntBuffer.distinct(): List<Int> = toMutableSet().toList()
inline fun <K> IntBuffer.distinctBy(selector: (Int) -> K): List<Int> {
    val set = HashSet<K>()
    val list = ArrayList<Int>()
    for (e in this) {
        val key = selector(e)
        if (set.add(key)) list += e
    }
    return list
}

infix fun IntBuffer.intersect(other: Iterable<Int>): Set<Int> {
    val set = toMutableSet()
    set.retainAll(other)
    return set
}

infix fun IntBuffer.subtract(other: Iterable<Int>): Set<Int> {
    val set = toMutableSet()
    set.removeAll(other)
    return set
}


infix fun IntBuffer.union(other: Iterable<Int>): Set<Int> {
    val set = toMutableSet()
    set += other
    return set
}


inline fun <R> IntBuffer.fold(initial: R, operation: (acc: R, Int) -> R): R {
    var accumulator = initial
    for (element in this) accumulator = operation(accumulator, element)
    return accumulator
}

inline fun <R> IntBuffer.foldIndexed(initial: R, operation: (index: Int, acc: R, Int) -> R): R {
    var index = 0
    var accumulator = initial
    for (element in this) accumulator = operation(index++, accumulator, element)
    return accumulator
}

inline fun <R> IntBuffer.foldRight(initial: R, operation: (Int, acc: R) -> R): R {
    var index = lastIndex
    var accumulator = initial
    while (index >= 0) accumulator = operation(get(index--), accumulator)
    return accumulator
}

inline fun <R> IntBuffer.foldRightIndexed(initial: R, operation: (index: Int, Int, acc: R) -> R): R {
    var index = lastIndex
    var accumulator = initial
    while (index >= 0) {
        accumulator = operation(index, get(index), accumulator)
        --index
    }
    return accumulator
}


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


inline fun IntBuffer.reduce(operation: (acc: Int, Int) -> Int): Int {
    if (isEmpty()) throw UnsupportedOperationException("Empty array can't be reduced.")
    var accumulator = this[0]
    for (index in 1..lastIndex) accumulator = operation(accumulator, this[index])
    return accumulator
}

inline fun IntBuffer.reduceIndexed(operation: (index: Int, acc: Int, Int) -> Int): Int {
    if (isEmpty()) throw UnsupportedOperationException("Empty array can't be reduced.")
    var accumulator = this[0]
    for (index in 1..lastIndex) accumulator = operation(index, accumulator, this[index])
    return accumulator
}

inline fun IntBuffer.reduceRight(operation: (Int, acc: Int) -> Int): Int {
    var index = lastIndex
    if (index < 0) throw UnsupportedOperationException("Empty array can't be reduced.")
    var accumulator = get(index--)
    while (index >= 0) accumulator = operation(get(index--), accumulator)
    return accumulator
}

inline fun IntBuffer.reduceRightIndexed(operation: (index: Int, Int, acc: Int) -> Int): Int {
    var index = lastIndex
    if (index < 0) throw UnsupportedOperationException("Empty array can't be reduced.")
    var accumulator = get(index--)
    while (index >= 0) {
        accumulator = operation(index, get(index), accumulator)
        --index
    }
    return accumulator
}

inline fun IntBuffer.sumByDouble(selector: (Int) -> Double): Double {
    var sum = 0.0
    for (element in this) sum += selector(element)
    return sum
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

class IndexingIterable<out T>(private val iteratorFactory: () -> Iterator<T>) : Iterable<IndexedValue<T>> {
    override fun iterator(): Iterator<IndexedValue<T>> = IndexingIterator(iteratorFactory())
}

/** Iterators   */
class IndexingIterator<out T>(private val iterator: Iterator<T>) : Iterator<IndexedValue<T>> {
    private var index = 0
    override fun hasNext(): Boolean = iterator.hasNext()
    override fun next(): IndexedValue<T> = IndexedValue(index++, iterator.next())
}

