package kool.lib

import kool.lim
import java.nio.*
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashSet
import kotlin.collections.LinkedHashMap
import kotlin.collections.LinkedHashSet
import kotlin.experimental.ExperimentalTypeInference


/**
 * Returns a [Map] where keys are elements from the given array and values are
 * produced by the [valueSelector] function applied to each element.
 *
 * If any two elements are equal, the last one gets added to the map.
 *
 * The returned map preserves the entry iteration order of the original array.
 *
 * @sample kool.buffers.Collections.Transformations.associateWith
 */
inline fun <V> ByteBuffer.associateWith(valueSelector: (Byte) -> V): Map<Byte, V> {
    val result = LinkedHashMap<Byte, V>(mapCapacity(lim).coerceAtLeast(16))
    return associateWithTo(result, valueSelector)
}

/**
 * Returns a [Map] where keys are elements from the given array and values are
 * produced by the [valueSelector] function applied to each element.
 *
 * If any two elements are equal, the last one gets added to the map.
 *
 * The returned map preserves the entry iteration order of the original array.
 *
 * @sample kool.buffers.Collections.Transformations.associateWith
 */
inline fun <V> ShortBuffer.associateWith(valueSelector: (Short) -> V): Map<Short, V> {
    val result = LinkedHashMap<Short, V>(mapCapacity(lim).coerceAtLeast(16))
    return associateWithTo(result, valueSelector)
}

/**
 * Returns a [Map] where keys are elements from the given array and values are
 * produced by the [valueSelector] function applied to each element.
 *
 * If any two elements are equal, the last one gets added to the map.
 *
 * The returned map preserves the entry iteration order of the original array.
 *
 * @sample kool.buffers.Collections.Transformations.associateWith
 */
inline fun <V> IntBuffer.associateWith(valueSelector: (Int) -> V): Map<Int, V> {
    val result = LinkedHashMap<Int, V>(mapCapacity(lim).coerceAtLeast(16))
    return associateWithTo(result, valueSelector)
}

/**
 * Returns a [Map] where keys are elements from the given array and values are
 * produced by the [valueSelector] function applied to each element.
 *
 * If any two elements are equal, the last one gets added to the map.
 *
 * The returned map preserves the entry iteration order of the original array.
 *
 * @sample kool.buffers.Collections.Transformations.associateWith
 */
inline fun <V> LongBuffer.associateWith(valueSelector: (Long) -> V): Map<Long, V> {
    val result = LinkedHashMap<Long, V>(mapCapacity(lim).coerceAtLeast(16))
    return associateWithTo(result, valueSelector)
}

/**
 * Returns a [Map] where keys are elements from the given array and values are
 * produced by the [valueSelector] function applied to each element.
 *
 * If any two elements are equal, the last one gets added to the map.
 *
 * The returned map preserves the entry iteration order of the original array.
 *
 * @sample kool.buffers.Collections.Transformations.associateWith
 */
inline fun <V> FloatBuffer.associateWith(valueSelector: (Float) -> V): Map<Float, V> {
    val result = LinkedHashMap<Float, V>(mapCapacity(lim).coerceAtLeast(16))
    return associateWithTo(result, valueSelector)
}

/**
 * Returns a [Map] where keys are elements from the given array and values are
 * produced by the [valueSelector] function applied to each element.
 *
 * If any two elements are equal, the last one gets added to the map.
 *
 * The returned map preserves the entry iteration order of the original array.
 *
 * @sample kool.buffers.Collections.Transformations.associateWith
 */
inline fun <V> DoubleBuffer.associateWith(valueSelector: (Double) -> V): Map<Double, V> {
    val result = LinkedHashMap<Double, V>(mapCapacity(lim).coerceAtLeast(16))
    return associateWithTo(result, valueSelector)
}

/**
 * Returns a [Map] where keys are elements from the given array and values are
 * produced by the [valueSelector] function applied to each element.
 *
 * If any two elements are equal, the last one gets added to the map.
 *
 * The returned map preserves the entry iteration order of the original array.
 *
 * @sample kool.buffers.Collections.Transformations.associateWith
 */
inline fun <V> CharBuffer.associateWith(valueSelector: (Char) -> V): Map<Char, V> {
    val result = LinkedHashMap<Char, V>(mapCapacity(lim.coerceAtMost(128)).coerceAtLeast(16))
    return associateWithTo(result, valueSelector)
}


/**
 * Populates and returns the [destination] mutable map with key-value pairs for each element of the given array,
 * where key is the element itself and value is provided by the [valueSelector] function applied to that key.
 *
 * If any two elements are equal, the last one overwrites the former value in the map.
 *
 * @sample kool.buffers.Collections.Transformations.associateWithTo
 */
inline fun <V, M : MutableMap<in Byte, in V>> ByteBuffer.associateWithTo(destination: M, valueSelector: (Byte) -> V): M {
    for (element in this) destination.put(element, valueSelector(element))
    return destination
}

/**
 * Populates and returns the [destination] mutable map with key-value pairs for each element of the given array,
 * where key is the element itself and value is provided by the [valueSelector] function applied to that key.
 *
 * If any two elements are equal, the last one overwrites the former value in the map.
 *
 * @sample kool.buffers.Collections.Transformations.associateWithTo
 */
inline fun <V, M : MutableMap<in Short, in V>> ShortBuffer.associateWithTo(destination: M, valueSelector: (Short) -> V): M {
    for (element in this) destination.put(element, valueSelector(element))
    return destination
}

/**
 * Populates and returns the [destination] mutable map with key-value pairs for each element of the given array,
 * where key is the element itself and value is provided by the [valueSelector] function applied to that key.
 *
 * If any two elements are equal, the last one overwrites the former value in the map.
 *
 * @sample kool.buffers.Collections.Transformations.associateWithTo
 */
inline fun <V, M : MutableMap<in Int, in V>> IntBuffer.associateWithTo(destination: M, valueSelector: (Int) -> V): M {
    for (element in this) destination.put(element, valueSelector(element))
    return destination
}

/**
 * Populates and returns the [destination] mutable map with key-value pairs for each element of the given array,
 * where key is the element itself and value is provided by the [valueSelector] function applied to that key.
 *
 * If any two elements are equal, the last one overwrites the former value in the map.
 *
 * @sample kool.buffers.Collections.Transformations.associateWithTo
 */
inline fun <V, M : MutableMap<in Long, in V>> LongBuffer.associateWithTo(destination: M, valueSelector: (Long) -> V): M {
    for (element in this) destination.put(element, valueSelector(element))
    return destination
}

/**
 * Populates and returns the [destination] mutable map with key-value pairs for each element of the given array,
 * where key is the element itself and value is provided by the [valueSelector] function applied to that key.
 *
 * If any two elements are equal, the last one overwrites the former value in the map.
 *
 * @sample kool.buffers.Collections.Transformations.associateWithTo
 */
inline fun <V, M : MutableMap<in Float, in V>> FloatBuffer.associateWithTo(destination: M, valueSelector: (Float) -> V): M {
    for (element in this) destination.put(element, valueSelector(element))
    return destination
}

/**
 * Populates and returns the [destination] mutable map with key-value pairs for each element of the given array,
 * where key is the element itself and value is provided by the [valueSelector] function applied to that key.
 *
 * If any two elements are equal, the last one overwrites the former value in the map.
 *
 * @sample kool.buffers.Collections.Transformations.associateWithTo
 */
inline fun <V, M : MutableMap<in Double, in V>> DoubleBuffer.associateWithTo(destination: M, valueSelector: (Double) -> V): M {
    for (element in this) destination.put(element, valueSelector(element))
    return destination
}

/**
 * Populates and returns the [destination] mutable map with key-value pairs for eachBuffer of the given array,
 * where key is the element itself and value is provided by the [valueSelector] function  applied to that key.
 *
 * @sample kool.buffers.Collections.Transformations.associateWithTo
 */
inline fun <V, M : MutableMap<in Char, in V>> CharBuffer.associateWithTo(destination: M, valueSelector: (Char) -> V): M {
    for (element in this) destination.put(element, valueSelector(element))
    return destination
}


/** Appends all elements to the given [destination] collection. */
fun <C : MutableCollection<in Byte>> ByteBuffer.toCollection(destination: C): C {
    for (item in this) destination += item
    return destination
}

/** Appends all elements to the given [destination] collection. */
fun <C : MutableCollection<in Short>> ShortBuffer.toCollection(destination: C): C {
    for (item in this) destination += item
    return destination
}

/** Appends all elements to the given [destination] collection. */
fun <C : MutableCollection<in Int>> IntBuffer.toCollection(destination: C): C {
    for (item in this) destination += item
    return destination
}

/** Appends all elements to the given [destination] collection. */
fun <C : MutableCollection<in Long>> LongBuffer.toCollection(destination: C): C {
    for (item in this) destination += item
    return destination
}

/** Appends all elements to the given [destination] collection. */
fun <C : MutableCollection<in Float>> FloatBuffer.toCollection(destination: C): C {
    for (item in this) destination += item
    return destination
}

/** Appends all elements to the given [destination] collection. */
fun <C : MutableCollection<in Double>> DoubleBuffer.toCollection(destination: C): C {
    for (item in this) destination += item
    return destination
}

/** Appends all elements to the given [destination] collection. */
fun <C : MutableCollection<in Char>> CharBuffer.toCollection(destination: C): C {
    for (item in this) destination += item
    return destination
}


/** Returns a [HashSet] of all elements. */
fun ByteBuffer.toHashSet(): HashSet<Byte> = toCollection(HashSet(maps.mapCapacity(lim)))

/** Returns a [HashSet] of all elements. */
fun ShortBuffer.toHashSet(): HashSet<Short> = toCollection(HashSet(maps.mapCapacity(lim)))

/** Returns a [HashSet] of all elements. */
fun IntBuffer.toHashSet(): HashSet<Int> = toCollection(HashSet(maps.mapCapacity(lim)))

/** Returns a [HashSet] of all elements. */
fun LongBuffer.toHashSet(): HashSet<Long> = toCollection(HashSet(maps.mapCapacity(lim)))

/** Returns a [HashSet] of all elements. */
fun FloatBuffer.toHashSet(): HashSet<Float> = toCollection(HashSet(maps.mapCapacity(lim)))

/** Returns a [HashSet] of all elements. */
fun DoubleBuffer.toHashSet(): HashSet<Double> = toCollection(HashSet(maps.mapCapacity(lim)))

/** Returns a [HashSet] of all elements. */
fun CharBuffer.toHashSet(): HashSet<Char> = toCollection(HashSet(maps.mapCapacity(lim)))


/** Returns a [List] containing all elements. */
fun ByteBuffer.toList(): List<Byte> = when (lim) {
    0 -> emptyList()
    1 -> listOf(this[0])
    else -> toMutableList()
}

/** Returns a [List] containing all elements. */
fun ShortBuffer.toList(): List<Short> = when (lim) {
    0 -> emptyList()
    1 -> listOf(this[0])
    else -> toMutableList()
}

/** Returns a [List] containing all elements. */
fun IntBuffer.toList(): List<Int> = when (lim) {
    0 -> emptyList()
    1 -> listOf(this[0])
    else -> toMutableList()
}

/** Returns a [List] containing all elements. */
fun LongBuffer.toList(): List<Long> = when (lim) {
    0 -> emptyList()
    1 -> listOf(this[0])
    else -> toMutableList()
}

/** Returns a [List] containing all elements. */
fun FloatBuffer.toList(): List<Float> = when (lim) {
    0 -> emptyList()
    1 -> listOf(this[0])
    else -> toMutableList()
}

/** Returns a [List] containing all elements. */
fun DoubleBuffer.toList(): List<Double> = when (lim) {
    0 -> emptyList()
    1 -> listOf(this[0])
    else -> toMutableList()
}

/** Returns a [List] containing all elements. */
fun CharBuffer.toList(): List<Char> = when (lim) {
    0 -> emptyList()
    1 -> listOf(this[0])
    else -> toMutableList()
}


/** Returns a [MutableList] filled with all elements of this buffer. */
fun ByteBuffer.toMutableList(): MutableList<Byte> {
    val list = ArrayList<Byte>(lim)
    for (item in this) list += item
    return list
}

/** Returns a [MutableList] filled with all elements of this buffer. */
fun ShortBuffer.toMutableList(): MutableList<Short> {
    val list = ArrayList<Short>(lim)
    for (item in this) list += item
    return list
}

/** Returns a [MutableList] filled with all elements of this buffer. */
fun IntBuffer.toMutableList(): MutableList<Int> {
    val list = ArrayList<Int>(lim)
    for (item in this) list += item
    return list
}

/** Returns a [MutableList] filled with all elements of this buffer. */
fun LongBuffer.toMutableList(): MutableList<Long> {
    val list = ArrayList<Long>(lim)
    for (item in this) list += item
    return list
}

/** Returns a [MutableList] filled with all elements of this buffer. */
fun FloatBuffer.toMutableList(): MutableList<Float> {
    val list = ArrayList<Float>(lim)
    for (item in this) list += item
    return list
}

/** Returns a [MutableList] filled with all elements of this buffer. */
fun DoubleBuffer.toMutableList(): MutableList<Double> {
    val list = ArrayList<Double>(lim)
    for (item in this) list += item
    return list
}

/** Returns a [MutableList] filled with all elements of this buffer. */
fun CharBuffer.toMutableList(): MutableList<Char> {
    val list = ArrayList<Char>(lim)
    for (item in this) list += item
    return list
}


/** Returns a [Set] of all elements.
 *  The returned set preserves the element iteration order of the original buffer. */
fun ByteBuffer.toSet(): Set<Byte> = when (lim) {
    0 -> emptySet()
    1 -> setOf(this[0])
    else -> toCollection(LinkedHashSet(maps.mapCapacity(lim)))
}

/** Returns a [Set] of all elements.
 *  The returned set preserves the element iteration order of the original buffer. */
fun ShortBuffer.toSet(): Set<Short> = when (lim) {
    0 -> emptySet()
    1 -> setOf(this[0])
    else -> toCollection(LinkedHashSet(maps.mapCapacity(lim)))
}

/** Returns a [Set] of all elements.
 *  The returned set preserves the element iteration order of the original buffer. */
fun IntBuffer.toSet(): Set<Int> = when (lim) {
    0 -> emptySet()
    1 -> setOf(this[0])
    else -> toCollection(LinkedHashSet(maps.mapCapacity(lim)))
}

/** Returns a [Set] of all elements.
 *  The returned set preserves the element iteration order of the original buffer. */
fun LongBuffer.toSet(): Set<Long> = when (lim) {
    0 -> emptySet()
    1 -> setOf(this[0])
    else -> toCollection(LinkedHashSet(maps.mapCapacity(lim)))
}

/** Returns a [Set] of all elements.
 *  The returned set preserves the element iteration order of the original buffer. */
fun FloatBuffer.toSet(): Set<Float> = when (lim) {
    0 -> emptySet()
    1 -> setOf(this[0])
    else -> toCollection(LinkedHashSet(maps.mapCapacity(lim)))
}

/** Returns a [Set] of all elements.
 *  The returned set preserves the element iteration order of the original buffer. */
fun DoubleBuffer.toSet(): Set<Double> = when (lim) {
    0 -> emptySet()
    1 -> setOf(this[0])
    else -> toCollection(LinkedHashSet(maps.mapCapacity(lim)))
}

/** Returns a [Set] of all elements.
 *  The returned set preserves the element iteration order of the original buffer. */
fun CharBuffer.toSet(): Set<Char> = when (lim) {
    0 -> emptySet()
    1 -> setOf(this[0])
    else -> toCollection(LinkedHashSet(maps.mapCapacity(lim)))
}


// [Kool] custom

/** Returns a [SortedSet] of all elements. */
fun ByteBuffer.toSortedSet(): SortedSet<Byte> = toCollection(sortedSetOf())

/** Returns a [SortedSet] of all elements. */
fun ShortBuffer.toSortedSet(): SortedSet<Short> = toCollection(sortedSetOf())

/** Returns a [SortedSet] of all elements. */
fun IntBuffer.toSortedSet(): SortedSet<Int> = toCollection(sortedSetOf())

/** Returns a [SortedSet] of all elements. */
fun LongBuffer.toSortedSet(): SortedSet<Long> = toCollection(sortedSetOf())

/** Returns a [SortedSet] of all elements. */
fun FloatBuffer.toSortedSet(): SortedSet<Float> = toCollection(sortedSetOf())

/** Returns a [SortedSet] of all elements. */
fun DoubleBuffer.toSortedSet(): SortedSet<Double> = toCollection(sortedSetOf())

/** Returns a [SortedSet] of all elements. */
fun CharBuffer.toSortedSet(): SortedSet<Char> = toCollection(sortedSetOf())


/** Returns a single list of all elements yielded from results of [transform] function being invoked on each element of original array.
 *  @sample kool.buffers.Collections.Transformations.flatMap */
inline fun <R> ByteBuffer.flatMap(transform: (Byte) -> Iterable<R>): List<R> = flatMapTo(ArrayList<R>(), transform)

/** Returns a single list of all elements yielded from results of [transform] function being invoked on each element of original array.
 *  @sample kool.buffers.Collections.Transformations.flatMap */
inline fun <R> ShortBuffer.flatMap(transform: (Short) -> Iterable<R>): List<R> = flatMapTo(ArrayList<R>(), transform)

/** Returns a single list of all elements yielded from results of [transform] function being invoked on each element of original array.
 *  @sample kool.buffers.Collections.Transformations.flatMap */
inline fun <R> IntBuffer.flatMap(transform: (Int) -> Iterable<R>): List<R> = flatMapTo(ArrayList<R>(), transform)

/** Returns a single list of all elements yielded from results of [transform] function being invoked on each element of original array.
 *  @sample kool.buffers.Collections.Transformations.flatMap */
inline fun <R> LongBuffer.flatMap(transform: (Long) -> Iterable<R>): List<R> = flatMapTo(ArrayList<R>(), transform)

/** Returns a single list of all elements yielded from results of [transform] function being invoked on each element of original array.
 *  @sample kool.buffers.Collections.Transformations.flatMap */
inline fun <R> FloatBuffer.flatMap(transform: (Float) -> Iterable<R>): List<R> = flatMapTo(ArrayList<R>(), transform)

/** Returns a single list of all elements yielded from results of [transform] function being invoked on each element of original array.
 *  @sample kool.buffers.Collections.Transformations.flatMap */
inline fun <R> DoubleBuffer.flatMap(transform: (Double) -> Iterable<R>): List<R> = flatMapTo(ArrayList<R>(), transform)

/** Returns a single list of all elements yielded from results of [transform] function being invoked on each element of original array.
 *  @sample kool.buffers.Collections.Transformations.flatMap */
inline fun <R> CharBuffer.flatMap(transform: (Char) -> Iterable<R>): List<R> = flatMapTo(ArrayList<R>(), transform)


/** Returns a single list of all elements yielded from results of [transform] function being invoked on each element
 *  and its index in the original array.
 *  @sample kool.buffers.Collections.Transformations.flatMapIndexed */
@OptIn(ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
@kotlin.jvm.JvmName("flatMapIndexedIterable")
inline fun <R> ByteBuffer.flatMapIndexed(transform: (index: Int, Byte) -> Iterable<R>): List<R> = flatMapIndexedTo(ArrayList<R>(), transform)

/** Returns a single list of all elements yielded from results of [transform] function being invoked on each element
 *  and its index in the original array.
 *  @sample kool.buffers.Collections.Transformations.flatMapIndexed */
@OptIn(ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
@kotlin.jvm.JvmName("flatMapIndexedIterable")
inline fun <R> ShortBuffer.flatMapIndexed(transform: (index: Int, Short) -> Iterable<R>): List<R> = flatMapIndexedTo(ArrayList<R>(), transform)

/** Returns a single list of all elements yielded from results of [transform] function being invoked on each element
 *  and its index in the original array.
 *  @sample kool.buffers.Collections.Transformations.flatMapIndexed */
@OptIn(ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
@kotlin.jvm.JvmName("flatMapIndexedIterable")
inline fun <R> IntBuffer.flatMapIndexed(transform: (index: Int, Int) -> Iterable<R>): List<R> = flatMapIndexedTo(ArrayList<R>(), transform)

/** Returns a single list of all elements yielded from results of [transform] function being invoked on each element
 *  and its index in the original array.
 *  @sample kool.buffers.Collections.Transformations.flatMapIndexed */
@OptIn(ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
@kotlin.jvm.JvmName("flatMapIndexedIterable")
inline fun <R> LongBuffer.flatMapIndexed(transform: (index: Int, Long) -> Iterable<R>): List<R> = flatMapIndexedTo(ArrayList<R>(), transform)

/** Returns a single list of all elements yielded from results of [transform] function being invoked on each element
 *  and its index in the original array.
 *  @sample kool.buffers.Collections.Transformations.flatMapIndexed */
@OptIn(ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
@kotlin.jvm.JvmName("flatMapIndexedIterable")
inline fun <R> FloatBuffer.flatMapIndexed(transform: (index: Int, Float) -> Iterable<R>): List<R> = flatMapIndexedTo(ArrayList<R>(), transform)

/** Returns a single list of all elements yielded from results of [transform] function being invoked on each element
 *  and its index in the original array.
 *  @sample kool.buffers.Collections.Transformations.flatMapIndexed */
@OptIn(ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
@kotlin.jvm.JvmName("flatMapIndexedIterable")
inline fun <R> DoubleBuffer.flatMapIndexed(transform: (index: Int, Double) -> Iterable<R>): List<R> = flatMapIndexedTo(ArrayList<R>(), transform)

/** Returns a single list of all elements yielded from results of [transform] function being invoked on each element
 *  and its index in the original array.
 *  @sample kool.buffers.Collections.Transformations.flatMapIndexed */
@OptIn(ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
@kotlin.jvm.JvmName("flatMapIndexedIterable")
inline fun <R> CharBuffer.flatMapIndexed(transform: (index: Int, Char) -> Iterable<R>): List<R> = flatMapIndexedTo(ArrayList<R>(), transform)


/** Appends all elements yielded from results of [transform] function being invoked on each element
 *  and its index in the original array, to the given [destination]. */
@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
@kotlin.jvm.JvmName("flatMapIndexedIterableTo")
inline fun <R, C : MutableCollection<in R>> ByteBuffer.flatMapIndexedTo(destination: C, transform: (index: Int, Byte) -> Iterable<R>): C {
    var index = 0
    for (element in this) {
        val list = transform(index++, element)
        destination.addAll(list)
    }
    return destination
}

/** Appends all elements yielded from results of [transform] function being invoked on each element
 *  and its index in the original array, to the given [destination]. */
@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
@kotlin.jvm.JvmName("flatMapIndexedIterableTo")
inline fun <R, C : MutableCollection<in R>> ShortBuffer.flatMapIndexedTo(destination: C, transform: (index: Int, Short) -> Iterable<R>): C {
    var index = 0
    for (element in this) {
        val list = transform(index++, element)
        destination.addAll(list)
    }
    return destination
}

/** Appends all elements yielded from results of [transform] function being invoked on each element
 *  and its index in the original array, to the given [destination]. */
@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
@kotlin.jvm.JvmName("flatMapIndexedIterableTo")
inline fun <R, C : MutableCollection<in R>> IntBuffer.flatMapIndexedTo(destination: C, transform: (index: Int, Int) -> Iterable<R>): C {
    var index = 0
    for (element in this) {
        val list = transform(index++, element)
        destination.addAll(list)
    }
    return destination
}

/** Appends all elements yielded from results of [transform] function being invoked on each element
 *  and its index in the original array, to the given [destination]. */
@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
@kotlin.jvm.JvmName("flatMapIndexedIterableTo")
inline fun <R, C : MutableCollection<in R>> LongBuffer.flatMapIndexedTo(destination: C, transform: (index: Int, Long) -> Iterable<R>): C {
    var index = 0
    for (element in this) {
        val list = transform(index++, element)
        destination.addAll(list)
    }
    return destination
}

/** Appends all elements yielded from results of [transform] function being invoked on each element
 *  and its index in the original array, to the given [destination]. */
@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
@kotlin.jvm.JvmName("flatMapIndexedIterableTo")
inline fun <R, C : MutableCollection<in R>> FloatBuffer.flatMapIndexedTo(destination: C, transform: (index: Int, Float) -> Iterable<R>): C {
    var index = 0
    for (element in this) {
        val list = transform(index++, element)
        destination.addAll(list)
    }
    return destination
}

/** Appends all elements yielded from results of [transform] function being invoked on each element
 *  and its index in the original array, to the given [destination]. */
@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
@kotlin.jvm.JvmName("flatMapIndexedIterableTo")
inline fun <R, C : MutableCollection<in R>> DoubleBuffer.flatMapIndexedTo(destination: C, transform: (index: Int, Double) -> Iterable<R>): C {
    var index = 0
    for (element in this) {
        val list = transform(index++, element)
        destination.addAll(list)
    }
    return destination
}

/** Appends all elements yielded from results of [transform] function being invoked on each element
 *  and its index in the original array, to the given [destination]. */
@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
@kotlin.jvm.JvmName("flatMapIndexedIterableTo")
inline fun <R, C : MutableCollection<in R>> CharBuffer.flatMapIndexedTo(destination: C, transform: (index: Int, Char) -> Iterable<R>): C {
    var index = 0
    for (element in this) {
        val list = transform(index++, element)
        destination.addAll(list)
    }
    return destination
}


/** Appends all elements yielded from results of [transform] function being invoked on each element of original array, to the given [destination]. */
inline fun <R, C : MutableCollection<in R>> ByteBuffer.flatMapTo(destination: C, transform: (Byte) -> Iterable<R>): C {
    for (element in this) {
        val list = transform(element)
        destination.addAll(list)
    }
    return destination
}

/** Appends all elements yielded from results of [transform] function being invoked on each element of original array, to the given [destination]. */
inline fun <R, C : MutableCollection<in R>> ShortBuffer.flatMapTo(destination: C, transform: (Short) -> Iterable<R>): C {
    for (element in this) {
        val list = transform(element)
        destination.addAll(list)
    }
    return destination
}

/** Appends all elements yielded from results of [transform] function being invoked on each element of original array, to the given [destination]. */
inline fun <R, C : MutableCollection<in R>> IntBuffer.flatMapTo(destination: C, transform: (Int) -> Iterable<R>): C {
    for (element in this) {
        val list = transform(element)
        destination.addAll(list)
    }
    return destination
}

/** Appends all elements yielded from results of [transform] function being invoked on each element of original array, to the given [destination]. */
inline fun <R, C : MutableCollection<in R>> LongBuffer.flatMapTo(destination: C, transform: (Long) -> Iterable<R>): C {
    for (element in this) {
        val list = transform(element)
        destination.addAll(list)
    }
    return destination
}

/** Appends all elements yielded from results of [transform] function being invoked on each element of original array, to the given [destination]. */
inline fun <R, C : MutableCollection<in R>> FloatBuffer.flatMapTo(destination: C, transform: (Float) -> Iterable<R>): C {
    for (element in this) {
        val list = transform(element)
        destination.addAll(list)
    }
    return destination
}

/** Appends all elements yielded from results of [transform] function being invoked on each element of original array, to the given [destination]. */
inline fun <R, C : MutableCollection<in R>> DoubleBuffer.flatMapTo(destination: C, transform: (Double) -> Iterable<R>): C {
    for (element in this) {
        val list = transform(element)
        destination.addAll(list)
    }
    return destination
}

/** Appends all elements yielded from results of [transform] function being invoked on each element of original array, to the given [destination]. */
inline fun <R, C : MutableCollection<in R>> CharBuffer.flatMapTo(destination: C, transform: (Char) -> Iterable<R>): C {
    for (element in this) {
        val list = transform(element)
        destination.addAll(list)
    }
    return destination
}


/**
 * Groups elements of the original array by the key returned by the given [keySelector] function
 * applied to each element and returns a map where each group key is associated with a list of corresponding elements.
 *
 * The returned map preserves the entry iteration order of the keys produced from the original array.
 *
 * @sample kool.buffers.Collections.Transformations.groupBy
 */
inline fun <K> ByteBuffer.groupBy(keySelector: (Byte) -> K): Map<K, List<Byte>> = groupByTo(LinkedHashMap<K, MutableList<Byte>>(), keySelector)

/**
 * Groups elements of the original array by the key returned by the given [keySelector] function
 * applied to each element and returns a map where each group key is associated with a list of corresponding elements.
 *
 * The returned map preserves the entry iteration order of the keys produced from the original array.
 *
 * @sample kool.buffers.Collections.Transformations.groupBy
 */
inline fun <K> ShortBuffer.groupBy(keySelector: (Short) -> K): Map<K, List<Short>> = groupByTo(LinkedHashMap<K, MutableList<Short>>(), keySelector)

/**
 * Groups elements of the original array by the key returned by the given [keySelector] function
 * applied to each element and returns a map where each group key is associated with a list of corresponding elements.
 *
 * The returned map preserves the entry iteration order of the keys produced from the original array.
 *
 * @sample kool.buffers.Collections.Transformations.groupBy
 */
inline fun <K> IntBuffer.groupBy(keySelector: (Int) -> K): Map<K, List<Int>> = groupByTo(LinkedHashMap<K, MutableList<Int>>(), keySelector)

/**
 * Groups elements of the original array by the key returned by the given [keySelector] function
 * applied to each element and returns a map where each group key is associated with a list of corresponding elements.
 *
 * The returned map preserves the entry iteration order of the keys produced from the original array.
 *
 * @sample kool.buffers.Collections.Transformations.groupBy
 */
inline fun <K> LongBuffer.groupBy(keySelector: (Long) -> K): Map<K, List<Long>> = groupByTo(LinkedHashMap<K, MutableList<Long>>(), keySelector)

/**
 * Groups elements of the original array by the key returned by the given [keySelector] function
 * applied to each element and returns a map where each group key is associated with a list of corresponding elements.
 *
 * The returned map preserves the entry iteration order of the keys produced from the original array.
 *
 * @sample kool.buffers.Collections.Transformations.groupBy
 */
inline fun <K> FloatBuffer.groupBy(keySelector: (Float) -> K): Map<K, List<Float>> = groupByTo(LinkedHashMap<K, MutableList<Float>>(), keySelector)

/**
 * Groups elements of the original array by the key returned by the given [keySelector] function
 * applied to each element and returns a map where each group key is associated with a list of corresponding elements.
 *
 * The returned map preserves the entry iteration order of the keys produced from the original array.
 *
 * @sample kool.buffers.Collections.Transformations.groupBy
 */
inline fun <K> DoubleBuffer.groupBy(keySelector: (Double) -> K): Map<K, List<Double>> = groupByTo(LinkedHashMap<K, MutableList<Double>>(), keySelector)

/**
 * Groups elements of the original array by the key returned by the given [keySelector] function
 * applied to each element and returns a map where each group key is associated with a list of corresponding elements.
 *
 * The returned map preserves the entry iteration order of the keys produced from the original array.
 *
 * @sample kool.buffers.Collections.Transformations.groupBy
 */
inline fun <K> CharBuffer.groupBy(keySelector: (Char) -> K): Map<K, List<Char>> = groupByTo(LinkedHashMap<K, MutableList<Char>>(), keySelector)


/**
 * Groups values returned by the [valueTransform] function applied to each element of the original array
 * by the key returned by the given [keySelector] function applied to the element
 * and returns a map where each group key is associated with a list of corresponding values.
 *
 * The returned map preserves the entry iteration order of the keys produced from the original array.
 *
 * @sample kool.buffers.Collections.Transformations.groupByKeysAndValues
 */
inline fun <K, V> ByteBuffer.groupBy(keySelector: (Byte) -> K, valueTransform: (Byte) -> V): Map<K, List<V>> = groupByTo(LinkedHashMap<K, MutableList<V>>(), keySelector, valueTransform)

/**
 * Groups values returned by the [valueTransform] function applied to each element of the original array
 * by the key returned by the given [keySelector] function applied to the element
 * and returns a map where each group key is associated with a list of corresponding values.
 *
 * The returned map preserves the entry iteration order of the keys produced from the original array.
 *
 * @sample kool.buffers.Collections.Transformations.groupByKeysAndValues
 */
inline fun <K, V> ShortBuffer.groupBy(keySelector: (Short) -> K, valueTransform: (Short) -> V): Map<K, List<V>> = groupByTo(LinkedHashMap<K, MutableList<V>>(), keySelector, valueTransform)

/**
 * Groups values returned by the [valueTransform] function applied to each element of the original array
 * by the key returned by the given [keySelector] function applied to the element
 * and returns a map where each group key is associated with a list of corresponding values.
 *
 * The returned map preserves the entry iteration order of the keys produced from the original array.
 *
 * @sample kool.buffers.Collections.Transformations.groupByKeysAndValues
 */
inline fun <K, V> IntBuffer.groupBy(keySelector: (Int) -> K, valueTransform: (Int) -> V): Map<K, List<V>> = groupByTo(LinkedHashMap<K, MutableList<V>>(), keySelector, valueTransform)

/**
 * Groups values returned by the [valueTransform] function applied to each element of the original array
 * by the key returned by the given [keySelector] function applied to the element
 * and returns a map where each group key is associated with a list of corresponding values.
 *
 * The returned map preserves the entry iteration order of the keys produced from the original array.
 *
 * @sample kool.buffers.Collections.Transformations.groupByKeysAndValues
 */
inline fun <K, V> LongBuffer.groupBy(keySelector: (Long) -> K, valueTransform: (Long) -> V): Map<K, List<V>> = groupByTo(LinkedHashMap<K, MutableList<V>>(), keySelector, valueTransform)

/**
 * Groups values returned by the [valueTransform] function applied to each element of the original array
 * by the key returned by the given [keySelector] function applied to the element
 * and returns a map where each group key is associated with a list of corresponding values.
 *
 * The returned map preserves the entry iteration order of the keys produced from the original array.
 *
 * @sample kool.buffers.Collections.Transformations.groupByKeysAndValues
 */
inline fun <K, V> FloatBuffer.groupBy(keySelector: (Float) -> K, valueTransform: (Float) -> V): Map<K, List<V>> = groupByTo(LinkedHashMap<K, MutableList<V>>(), keySelector, valueTransform)

/**
 * Groups values returned by the [valueTransform] function applied to each element of the original array
 * by the key returned by the given [keySelector] function applied to the element
 * and returns a map where each group key is associated with a list of corresponding values.
 *
 * The returned map preserves the entry iteration order of the keys produced from the original array.
 *
 * @sample kool.buffers.Collections.Transformations.groupByKeysAndValues
 */
inline fun <K, V> DoubleBuffer.groupBy(keySelector: (Double) -> K, valueTransform: (Double) -> V): Map<K, List<V>> = groupByTo(LinkedHashMap<K, MutableList<V>>(), keySelector, valueTransform)

/**
 * Groups values returned by the [valueTransform] function applied to each element of the original array
 * by the key returned by the given [keySelector] function applied to the element
 * and returns a map where each group key is associated with a list of corresponding values.
 *
 * The returned map preserves the entry iteration order of the keys produced from the original array.
 *
 * @sample kool.buffers.Collections.Transformations.groupByKeysAndValues
 */
inline fun <K, V> CharBuffer.groupBy(keySelector: (Char) -> K, valueTransform: (Char) -> V): Map<K, List<V>> = groupByTo(LinkedHashMap<K, MutableList<V>>(), keySelector, valueTransform)


/**
 * Groups elements of the original array by the key returned by the given [keySelector] function
 * applied to each element and puts to the [destination] map each group key associated with a list of corresponding elements.
 *
 * @return The [destination] map.
 *
 * @sample kool.buffers.Collections.Transformations.groupBy
 */
inline fun <K, M : MutableMap<in K, MutableList<Byte>>> ByteBuffer.groupByTo(destination: M, keySelector: (Byte) -> K): M {
    for (element in this) {
        val key = keySelector(element)
        val list = destination.getOrPut(key) { ArrayList<Byte>() }
        list.add(element)
    }
    return destination
}

/**
 * Groups elements of the original array by the key returned by the given [keySelector] function
 * applied to each element and puts to the [destination] map each group key associated with a list of corresponding elements.
 *
 * @return The [destination] map.
 *
 * @sample kool.buffers.Collections.Transformations.groupBy
 */
inline fun <K, M : MutableMap<in K, MutableList<Short>>> ShortBuffer.groupByTo(destination: M, keySelector: (Short) -> K): M {
    for (element in this) {
        val key = keySelector(element)
        val list = destination.getOrPut(key) { ArrayList<Short>() }
        list.add(element)
    }
    return destination
}

/**
 * Groups elements of the original array by the key returned by the given [keySelector] function
 * applied to each element and puts to the [destination] map each group key associated with a list of corresponding elements.
 *
 * @return The [destination] map.
 *
 * @sample kool.buffers.Collections.Transformations.groupBy
 */
inline fun <K, M : MutableMap<in K, MutableList<Int>>> IntBuffer.groupByTo(destination: M, keySelector: (Int) -> K): M {
    for (element in this) {
        val key = keySelector(element)
        val list = destination.getOrPut(key) { ArrayList<Int>() }
        list.add(element)
    }
    return destination
}

/**
 * Groups elements of the original array by the key returned by the given [keySelector] function
 * applied to each element and puts to the [destination] map each group key associated with a list of corresponding elements.
 *
 * @return The [destination] map.
 *
 * @sample kool.buffers.Collections.Transformations.groupBy
 */
inline fun <K, M : MutableMap<in K, MutableList<Long>>> LongBuffer.groupByTo(destination: M, keySelector: (Long) -> K): M {
    for (element in this) {
        val key = keySelector(element)
        val list = destination.getOrPut(key) { ArrayList<Long>() }
        list.add(element)
    }
    return destination
}

/**
 * Groups elements of the original array by the key returned by the given [keySelector] function
 * applied to each element and puts to the [destination] map each group key associated with a list of corresponding elements.
 *
 * @return The [destination] map.
 *
 * @sample kool.buffers.Collections.Transformations.groupBy
 */
inline fun <K, M : MutableMap<in K, MutableList<Float>>> FloatBuffer.groupByTo(destination: M, keySelector: (Float) -> K): M {
    for (element in this) {
        val key = keySelector(element)
        val list = destination.getOrPut(key) { ArrayList<Float>() }
        list.add(element)
    }
    return destination
}

/**
 * Groups elements of the original array by the key returned by the given [keySelector] function
 * applied to each element and puts to the [destination] map each group key associated with a list of corresponding elements.
 *
 * @return The [destination] map.
 *
 * @sample kool.buffers.Collections.Transformations.groupBy
 */
inline fun <K, M : MutableMap<in K, MutableList<Double>>> DoubleBuffer.groupByTo(destination: M, keySelector: (Double) -> K): M {
    for (element in this) {
        val key = keySelector(element)
        val list = destination.getOrPut(key) { ArrayList<Double>() }
        list.add(element)
    }
    return destination
}

/**
 * Groups elements of the original array by the key returned by the given [keySelector] function
 * applied to each element and puts to the [destination] map each group key associated with a list of corresponding elements.
 *
 * @return The [destination] map.
 *
 * @sample kool.buffers.Collections.Transformations.groupBy
 */
inline fun <K, M : MutableMap<in K, MutableList<Char>>> CharBuffer.groupByTo(destination: M, keySelector: (Char) -> K): M {
    for (element in this) {
        val key = keySelector(element)
        val list = destination.getOrPut(key) { ArrayList<Char>() }
        list.add(element)
    }
    return destination
}


/**
 * Groups values returned by the [valueTransform] function applied to each element of the original array
 * by the key returned by the given [keySelector] function applied to the element
 * and puts to the [destination] map each group key associated with a list of corresponding values.
 *
 * @return The [destination] map.
 *
 * @sample kool.buffers.Collections.Transformations.groupByKeysAndValues
 */
inline fun <K, V, M : MutableMap<in K, MutableList<V>>> ByteBuffer.groupByTo(destination: M, keySelector: (Byte) -> K, valueTransform: (Byte) -> V): M {
    for (element in this) {
        val key = keySelector(element)
        val list = destination.getOrPut(key) { ArrayList<V>() }
        list.add(valueTransform(element))
    }
    return destination
}

/**
 * Groups values returned by the [valueTransform] function applied to each element of the original array
 * by the key returned by the given [keySelector] function applied to the element
 * and puts to the [destination] map each group key associated with a list of corresponding values.
 *
 * @return The [destination] map.
 *
 * @sample kool.buffers.Collections.Transformations.groupByKeysAndValues
 */
inline fun <K, V, M : MutableMap<in K, MutableList<V>>> ShortBuffer.groupByTo(destination: M, keySelector: (Short) -> K, valueTransform: (Short) -> V): M {
    for (element in this) {
        val key = keySelector(element)
        val list = destination.getOrPut(key) { ArrayList<V>() }
        list.add(valueTransform(element))
    }
    return destination
}

/**
 * Groups values returned by the [valueTransform] function applied to each element of the original array
 * by the key returned by the given [keySelector] function applied to the element
 * and puts to the [destination] map each group key associated with a list of corresponding values.
 *
 * @return The [destination] map.
 *
 * @sample kool.buffers.Collections.Transformations.groupByKeysAndValues
 */
inline fun <K, V, M : MutableMap<in K, MutableList<V>>> IntBuffer.groupByTo(destination: M, keySelector: (Int) -> K, valueTransform: (Int) -> V): M {
    for (element in this) {
        val key = keySelector(element)
        val list = destination.getOrPut(key) { ArrayList<V>() }
        list.add(valueTransform(element))
    }
    return destination
}

/**
 * Groups values returned by the [valueTransform] function applied to each element of the original array
 * by the key returned by the given [keySelector] function applied to the element
 * and puts to the [destination] map each group key associated with a list of corresponding values.
 *
 * @return The [destination] map.
 *
 * @sample kool.buffers.Collections.Transformations.groupByKeysAndValues
 */
inline fun <K, V, M : MutableMap<in K, MutableList<V>>> LongBuffer.groupByTo(destination: M, keySelector: (Long) -> K, valueTransform: (Long) -> V): M {
    for (element in this) {
        val key = keySelector(element)
        val list = destination.getOrPut(key) { ArrayList<V>() }
        list.add(valueTransform(element))
    }
    return destination
}

/**
 * Groups values returned by the [valueTransform] function applied to each element of the original array
 * by the key returned by the given [keySelector] function applied to the element
 * and puts to the [destination] map each group key associated with a list of corresponding values.
 *
 * @return The [destination] map.
 *
 * @sample kool.buffers.Collections.Transformations.groupByKeysAndValues
 */
inline fun <K, V, M : MutableMap<in K, MutableList<V>>> FloatBuffer.groupByTo(destination: M, keySelector: (Float) -> K, valueTransform: (Float) -> V): M {
    for (element in this) {
        val key = keySelector(element)
        val list = destination.getOrPut(key) { ArrayList<V>() }
        list.add(valueTransform(element))
    }
    return destination
}

/**
 * Groups values returned by the [valueTransform] function applied to each element of the original array
 * by the key returned by the given [keySelector] function applied to the element
 * and puts to the [destination] map each group key associated with a list of corresponding values.
 *
 * @return The [destination] map.
 *
 * @sample kool.buffers.Collections.Transformations.groupByKeysAndValues
 */
inline fun <K, V, M : MutableMap<in K, MutableList<V>>> DoubleBuffer.groupByTo(destination: M, keySelector: (Double) -> K, valueTransform: (Double) -> V): M {
    for (element in this) {
        val key = keySelector(element)
        val list = destination.getOrPut(key) { ArrayList<V>() }
        list.add(valueTransform(element))
    }
    return destination
}

/**
 * Groups values returned by the [valueTransform] function applied to each element of the original array
 * by the key returned by the given [keySelector] function applied to the element
 * and puts to the [destination] map each group key associated with a list of corresponding values.
 *
 * @return The [destination] map.
 *
 * @sample kool.buffers.Collections.Transformations.groupByKeysAndValues
 */
inline fun <K, V, M : MutableMap<in K, MutableList<V>>> CharBuffer.groupByTo(destination: M, keySelector: (Char) -> K, valueTransform: (Char) -> V): M {
    for (element in this) {
        val key = keySelector(element)
        val list = destination.getOrPut(key) { ArrayList<V>() }
        list.add(valueTransform(element))
    }
    return destination
}


/** Returns a list containing the results of applying the given [transform] function to each element in the original buffer. */
inline fun <R> ByteBuffer.map(transform: (Byte) -> R): List<R> = mapTo(ArrayList(lim), transform)

/** Returns a list containing the results of applying the given [transform] function to each element in the original buffer. */
inline fun <R> ShortBuffer.map(transform: (Short) -> R): List<R> = mapTo(ArrayList(lim), transform)

/** Returns a list containing the results of applying the given [transform] function to each element in the original buffer. */
inline fun <R> IntBuffer.map(transform: (Int) -> R): List<R> = mapTo(ArrayList(lim), transform)

/** Returns a list containing the results of applying the given [transform] function to each element in the original buffer. */
inline fun <R> LongBuffer.map(transform: (Long) -> R): List<R> = mapTo(ArrayList(lim), transform)

/** Returns a list containing the results of applying the given [transform] function to each element in the original buffer. */
inline fun <R> FloatBuffer.map(transform: (Float) -> R): List<R> = mapTo(ArrayList(lim), transform)

/** Returns a list containing the results of applying the given [transform] function to each element in the original buffer. */
inline fun <R> DoubleBuffer.map(transform: (Double) -> R): List<R> = mapTo(ArrayList(lim), transform)

/** Returns a list containing the results of applying the given [transform] function to each element in the original buffer. */
inline fun <R> CharBuffer.map(transform: (Char) -> R): List<R> = mapTo(ArrayList(lim), transform)


/** Returns a list containing the results of applying the given [transform] function to each element and its index in the original buffer.
 *  @param [transform] function that takes the index of an element and the element itself and returns the result of the transform applied to the element. */
inline fun <R> ByteBuffer.mapIndexed(transform: (index: Int, Byte) -> R): List<R> = mapIndexedTo(ArrayList<R>(lim), transform)

/** Returns a list containing the results of applying the given [transform] function to each element and its index in the original buffer.
 *  @param [transform] function that takes the index of an element and the element itself and returns the result of the transform applied to the element. */
inline fun <R> ShortBuffer.mapIndexed(transform: (index: Int, Short) -> R): List<R> = mapIndexedTo(ArrayList<R>(lim), transform)

/** Returns a list containing the results of applying the given [transform] function to each element and its index in the original buffer.
 *  @param [transform] function that takes the index of an element and the element itself and returns the result of the transform applied to the element. */
inline fun <R> IntBuffer.mapIndexed(transform: (index: Int, Int) -> R): List<R> = mapIndexedTo(ArrayList<R>(lim), transform)

/** Returns a list containing the results of applying the given [transform] function to each element and its index in the original buffer.
 *  @param [transform] function that takes the index of an element and the element itself and returns the result of the transform applied to the element. */
inline fun <R> LongBuffer.mapIndexed(transform: (index: Int, Long) -> R): List<R> = mapIndexedTo(ArrayList<R>(lim), transform)

/** Returns a list containing the results of applying the given [transform] function to each element and its index in the original buffer.
 *  @param [transform] function that takes the index of an element and the element itself and returns the result of the transform applied to the element. */
inline fun <R> FloatBuffer.mapIndexed(transform: (index: Int, Float) -> R): List<R> = mapIndexedTo(ArrayList<R>(lim), transform)

/** Returns a list containing the results of applying the given [transform] function to each element and its index in the original buffer.
 *  @param [transform] function that takes the index of an element and the element itself and returns the result of the transform applied to the element. */
inline fun <R> DoubleBuffer.mapIndexed(transform: (index: Int, Double) -> R): List<R> = mapIndexedTo(ArrayList<R>(lim), transform)

/** Returns a list containing the results of applying the given [transform] function to each element and its index in the original buffer.
 *  @param [transform] function that takes the index of an element and the element itself and returns the result of the transform applied to the element. */
inline fun <R> CharBuffer.mapIndexed(transform: (index: Int, Char) -> R): List<R> = mapIndexedTo(ArrayList<R>(lim), transform)


/** Applies the given [transform] function to each element and its index in the original buffer and appends the results to the given [destination].
 *  @param [transform] function that takes the index of an element and the element itself and returns the result of the transform applied to the element. */
inline fun <R, C : MutableCollection<in R>> ByteBuffer.mapIndexedTo(destination: C, transform: (index: Int, Byte) -> R): C {
    var index = 0
    for (item in this) destination += transform(index++, item)
    return destination
}

/** Applies the given [transform] function to each element and its index in the original buffer and appends the results to the given [destination].
 *  @param [transform] function that takes the index of an element and the element itself and returns the result of the transform applied to the element. */
inline fun <R, C : MutableCollection<in R>> ShortBuffer.mapIndexedTo(destination: C, transform: (index: Int, Short) -> R): C {
    var index = 0
    for (item in this) destination += transform(index++, item)
    return destination
}

/** Applies the given [transform] function to each element and its index in the original buffer and appends the results to the given [destination].
 *  @param [transform] function that takes the index of an element and the element itself and returns the result of the transform applied to the element. */
inline fun <R, C : MutableCollection<in R>> IntBuffer.mapIndexedTo(destination: C, transform: (index: Int, Int) -> R): C {
    var index = 0
    for (item in this) destination += transform(index++, item)
    return destination
}

/** Applies the given [transform] function to each element and its index in the original buffer and appends the results to the given [destination].
 *  @param [transform] function that takes the index of an element and the element itself and returns the result of the transform applied to the element. */
inline fun <R, C : MutableCollection<in R>> LongBuffer.mapIndexedTo(destination: C, transform: (index: Int, Long) -> R): C {
    var index = 0
    for (item in this) destination += transform(index++, item)
    return destination
}

/** Applies the given [transform] function to each element and its index in the original buffer and appends the results to the given [destination].
 *  @param [transform] function that takes the index of an element and the element itself and returns the result of the transform applied to the element. */
inline fun <R, C : MutableCollection<in R>> FloatBuffer.mapIndexedTo(destination: C, transform: (index: Int, Float) -> R): C {
    var index = 0
    for (item in this) destination += transform(index++, item)
    return destination
}

/** Applies the given [transform] function to each element and its index in the original buffer and appends the results to the given [destination].
 *  @param [transform] function that takes the index of an element and the element itself and returns the result of the transform applied to the element. */
inline fun <R, C : MutableCollection<in R>> DoubleBuffer.mapIndexedTo(destination: C, transform: (index: Int, Double) -> R): C {
    var index = 0
    for (item in this) destination += transform(index++, item)
    return destination
}

/** Applies the given [transform] function to each element and its index in the original buffer and appends the results to the given [destination].
 *  @param [transform] function that takes the index of an element and the element itself and returns the result of the transform applied to the element. */
inline fun <R, C : MutableCollection<in R>> CharBuffer.mapIndexedTo(destination: C, transform: (index: Int, Char) -> R): C {
    var index = 0
    for (item in this) destination += transform(index++, item)
    return destination
}


/** Applies the given [transform] function to each element of the original buffer and appends the results to the given [destination]. */
inline fun <R, C : MutableCollection<in R>> ByteBuffer.mapTo(destination: C, transform: (Byte) -> R): C {
    for (item in this) destination += transform(item)
    return destination
}

/** Applies the given [transform] function to each element of the original buffer and appends the results to the given [destination]. */
inline fun <R, C : MutableCollection<in R>> ShortBuffer.mapTo(destination: C, transform: (Short) -> R): C {
    for (item in this) destination += transform(item)
    return destination
}

/** Applies the given [transform] function to each element of the original buffer and appends the results to the given [destination]. */
inline fun <R, C : MutableCollection<in R>> IntBuffer.mapTo(destination: C, transform: (Int) -> R): C {
    for (item in this) destination += transform(item)
    return destination
}

/** Applies the given [transform] function to each element of the original buffer and appends the results to the given [destination]. */
inline fun <R, C : MutableCollection<in R>> LongBuffer.mapTo(destination: C, transform: (Long) -> R): C {
    for (item in this) destination += transform(item)
    return destination
}

/** Applies the given [transform] function to each element of the original buffer and appends the results to the given [destination]. */
inline fun <R, C : MutableCollection<in R>> FloatBuffer.mapTo(destination: C, transform: (Float) -> R): C {
    for (item in this) destination += transform(item)
    return destination
}

/** Applies the given [transform] function to each element of the original buffer and appends the results to the given [destination]. */
inline fun <R, C : MutableCollection<in R>> DoubleBuffer.mapTo(destination: C, transform: (Double) -> R): C {
    for (item in this) destination += transform(item)
    return destination
}

/** Applies the given [transform] function to each element of the original buffer and appends the results to the given [destination]. */
inline fun <R, C : MutableCollection<in R>> CharBuffer.mapTo(destination: C, transform: (Char) -> R): C {
    for (item in this) destination += transform(item)
    return destination
}

/** Returns a lazy [Iterable] that wraps each element of the original array
 *  into an [IndexedValue] containing the index of that element and the element itself. */
fun ByteBuffer.withIndex(): Iterable<IndexedValue<Byte>> = IndexingIterable { iterator() }

/** Returns a lazy [Iterable] that wraps each element of the original array
 *  into an [IndexedValue] containing the index of that element and the element itself. */
fun ShortBuffer.withIndex(): Iterable<IndexedValue<Short>> = IndexingIterable { iterator() }

/** Returns a lazy [Iterable] that wraps each element of the original array
 *  into an [IndexedValue] containing the index of that element and the element itself. */
fun IntBuffer.withIndex(): Iterable<IndexedValue<Int>> = IndexingIterable { iterator() }

/** Returns a lazy [Iterable] that wraps each element of the original array
 *  into an [IndexedValue] containing the index of that element and the element itself. */
fun LongBuffer.withIndex(): Iterable<IndexedValue<Long>> = IndexingIterable { iterator() }

/** Returns a lazy [Iterable] that wraps each element of the original array
 *  into an [IndexedValue] containing the index of that element and the element itself. */
fun FloatBuffer.withIndex(): Iterable<IndexedValue<Float>> = IndexingIterable { iterator() }

/** Returns a lazy [Iterable] that wraps each element of the original array
 *  into an [IndexedValue] containing the index of that element and the element itself. */
fun DoubleBuffer.withIndex(): Iterable<IndexedValue<Double>> = IndexingIterable { iterator() }

/** Returns a lazy [Iterable] that wraps each element of the original array
 *  into an [IndexedValue] containing the index of that element and the element itself. */
fun CharBuffer.withIndex(): Iterable<IndexedValue<Char>> = IndexingIterable { iterator() }


/**
 * Returns a list containing only distinct elements from the given array.
 *
 * The elements in the resulting list are in the same order as they were in the source array.
 *
 * @sample kool.buffers.Collections.Transformations.distinctAndDistinctBy
 */
fun ByteBuffer.distinct(): List<Byte> = toMutableSet().toList()

/**
 * Returns a list containing only distinct elements from the given array.
 *
 * The elements in the resulting list are in the same order as they were in the source array.
 *
 * @sample kool.buffers.Collections.Transformations.distinctAndDistinctBy
 */
fun ShortBuffer.distinct(): List<Short> = toMutableSet().toList()

/**
 * Returns a list containing only distinct elements from the given array.
 *
 * The elements in the resulting list are in the same order as they were in the source array.
 *
 * @sample kool.buffers.Collections.Transformations.distinctAndDistinctBy
 */
fun IntBuffer.distinct(): List<Int> = toMutableSet().toList()

/**
 * Returns a list containing only distinct elements from the given array.
 *
 * The elements in the resulting list are in the same order as they were in the source array.
 *
 * @sample kool.buffers.Collections.Transformations.distinctAndDistinctBy
 */
fun LongBuffer.distinct(): List<Long> = toMutableSet().toList()

/**
 * Returns a list containing only distinct elements from the given array.
 *
 * The elements in the resulting list are in the same order as they were in the source array.
 *
 * @sample kool.buffers.Collections.Transformations.distinctAndDistinctBy
 */
fun FloatBuffer.distinct(): List<Float> = toMutableSet().toList()

/**
 * Returns a list containing only distinct elements from the given array.
 *
 * The elements in the resulting list are in the same order as they were in the source array.
 *
 * @sample kool.buffers.Collections.Transformations.distinctAndDistinctBy
 */
fun DoubleBuffer.distinct(): List<Double> = toMutableSet().toList()

/**
 * Returns a list containing only distinct elements from the given array.
 *
 * The elements in the resulting list are in the same order as they were in the source array.
 *
 * @sample kool.buffers.Collections.Transformations.distinctAndDistinctBy
 */
fun CharBuffer.distinct(): List<Char> = toMutableSet().toList()


/**
 * Returns a list containing only elements from the given array
 * having distinct keys returned by the given [selector] function.
 *
 * The elements in the resulting list are in the same order as they were in the source array.
 *
 * @sample kool.buffers.Collections.Transformations.distinctAndDistinctBy
 */
inline fun <K> ByteBuffer.distinctBy(selector: (Byte) -> K): List<Byte> {
    val set = HashSet<K>()
    val list = ArrayList<Byte>()
    for (e in this) {
        val key = selector(e)
        if (set.add(key))
            list.add(e)
    }
    return list
}

/**
 * Returns a list containing only elements from the given array
 * having distinct keys returned by the given [selector] function.
 *
 * The elements in the resulting list are in the same order as they were in the source array.
 *
 * @sample kool.buffers.Collections.Transformations.distinctAndDistinctBy
 */
inline fun <K> ShortBuffer.distinctBy(selector: (Short) -> K): List<Short> {
    val set = HashSet<K>()
    val list = ArrayList<Short>()
    for (e in this) {
        val key = selector(e)
        if (set.add(key))
            list.add(e)
    }
    return list
}

/**
 * Returns a list containing only elements from the given array
 * having distinct keys returned by the given [selector] function.
 *
 * The elements in the resulting list are in the same order as they were in the source array.
 *
 * @sample kool.buffers.Collections.Transformations.distinctAndDistinctBy
 */
inline fun <K> IntBuffer.distinctBy(selector: (Int) -> K): List<Int> {
    val set = HashSet<K>()
    val list = ArrayList<Int>()
    for (e in this) {
        val key = selector(e)
        if (set.add(key))
            list.add(e)
    }
    return list
}

/**
 * Returns a list containing only elements from the given array
 * having distinct keys returned by the given [selector] function.
 *
 * The elements in the resulting list are in the same order as they were in the source array.
 *
 * @sample kool.buffers.Collections.Transformations.distinctAndDistinctBy
 */
inline fun <K> LongBuffer.distinctBy(selector: (Long) -> K): List<Long> {
    val set = HashSet<K>()
    val list = ArrayList<Long>()
    for (e in this) {
        val key = selector(e)
        if (set.add(key))
            list.add(e)
    }
    return list
}

/**
 * Returns a list containing only elements from the given array
 * having distinct keys returned by the given [selector] function.
 *
 * The elements in the resulting list are in the same order as they were in the source array.
 *
 * @sample kool.buffers.Collections.Transformations.distinctAndDistinctBy
 */
inline fun <K> FloatBuffer.distinctBy(selector: (Float) -> K): List<Float> {
    val set = HashSet<K>()
    val list = ArrayList<Float>()
    for (e in this) {
        val key = selector(e)
        if (set.add(key))
            list.add(e)
    }
    return list
}

/**
 * Returns a list containing only elements from the given array
 * having distinct keys returned by the given [selector] function.
 *
 * The elements in the resulting list are in the same order as they were in the source array.
 *
 * @sample kool.buffers.Collections.Transformations.distinctAndDistinctBy
 */
inline fun <K> DoubleBuffer.distinctBy(selector: (Double) -> K): List<Double> {
    val set = HashSet<K>()
    val list = ArrayList<Double>()
    for (e in this) {
        val key = selector(e)
        if (set.add(key))
            list.add(e)
    }
    return list
}

/**
 * Returns a list containing only elements from the given array
 * having distinct keys returned by the given [selector] function.
 *
 * The elements in the resulting list are in the same order as they were in the source array.
 *
 * @sample kool.buffers.Collections.Transformations.distinctAndDistinctBy
 */
inline fun <K> CharBuffer.distinctBy(selector: (Char) -> K): List<Char> {
    val set = HashSet<K>()
    val list = ArrayList<Char>()
    for (e in this) {
        val key = selector(e)
        if (set.add(key))
            list.add(e)
    }
    return list
}


/**
 * Returns a set containing all elements that are contained by both this array and the specified collection.
 *
 * The returned set preserves the element iteration order of the original array.
 *
 * To get a set containing all elements that are contained at least in one of these collections use [union].
 */
infix fun ByteBuffer.intersect(other: Iterable<Byte>): Set<Byte> = toMutableSet().apply { retainAll(other) }

/**
 * Returns a set containing all elements that are contained by both this array and the specified collection.
 *
 * The returned set preserves the element iteration order of the original array.
 *
 * To get a set containing all elements that are contained at least in one of these collections use [union].
 */
infix fun ShortBuffer.intersect(other: Iterable<Short>): Set<Short> = toMutableSet().apply { retainAll(other) }

/**
 * Returns a set containing all elements that are contained by both this array and the specified collection.
 *
 * The returned set preserves the element iteration order of the original array.
 *
 * To get a set containing all elements that are contained at least in one of these collections use [union].
 */
infix fun IntBuffer.intersect(other: Iterable<Int>): Set<Int> = toMutableSet().apply { retainAll(other) }

/**
 * Returns a set containing all elements that are contained by both this array and the specified collection.
 *
 * The returned set preserves the element iteration order of the original array.
 *
 * To get a set containing all elements that are contained at least in one of these collections use [union].
 */
infix fun LongBuffer.intersect(other: Iterable<Long>): Set<Long> = toMutableSet().apply { retainAll(other) }

/**
 * Returns a set containing all elements that are contained by both this array and the specified collection.
 *
 * The returned set preserves the element iteration order of the original array.
 *
 * To get a set containing all elements that are contained at least in one of these collections use [union].
 */
infix fun FloatBuffer.intersect(other: Iterable<Float>): Set<Float> = toMutableSet().apply { retainAll(other) }

/**
 * Returns a set containing all elements that are contained by both this array and the specified collection.
 *
 * The returned set preserves the element iteration order of the original array.
 *
 * To get a set containing all elements that are contained at least in one of these collections use [union].
 */
infix fun DoubleBuffer.intersect(other: Iterable<Double>): Set<Double> = toMutableSet().apply { retainAll(other) }

/**
 * Returns a set containing all elements that are contained by both this array and the specified collection.
 *
 * The returned set preserves the element iteration order of the original array.
 *
 * To get a set containing all elements that are contained at least in one of these collections use [union].
 */
infix fun CharBuffer.intersect(other: Iterable<Char>): Set<Char> = toMutableSet().apply { retainAll(other) }


/** Returns a set containing all elements that are contained by this array and not contained by the specified collection.
 *  The returned set preserves the element iteration order of the original array. */
infix fun ByteBuffer.subtract(other: Iterable<Byte>): Set<Byte> = toMutableSet().apply { removeAll(other) }

/** Returns a set containing all elements that are contained by this array and not contained by the specified collection.
 *  The returned set preserves the element iteration order of the original array. */
infix fun ShortBuffer.subtract(other: Iterable<Short>): Set<Short> = toMutableSet().apply { removeAll(other) }

/** Returns a set containing all elements that are contained by this array and not contained by the specified collection.
 *  The returned set preserves the element iteration order of the original array. */
infix fun IntBuffer.subtract(other: Iterable<Int>): Set<Int> = toMutableSet().apply { removeAll(other) }

/** Returns a set containing all elements that are contained by this array and not contained by the specified collection.
 *  The returned set preserves the element iteration order of the original array. */
infix fun LongBuffer.subtract(other: Iterable<Long>): Set<Long> = toMutableSet().apply { removeAll(other) }

/** Returns a set containing all elements that are contained by this array and not contained by the specified collection.
 *  The returned set preserves the element iteration order of the original array. */
infix fun FloatBuffer.subtract(other: Iterable<Float>): Set<Float> = toMutableSet().apply { removeAll(other) }

/** Returns a set containing all elements that are contained by this array and not contained by the specified collection.
 *  The returned set preserves the element iteration order of the original array. */
infix fun DoubleBuffer.subtract(other: Iterable<Double>): Set<Double> = toMutableSet().apply { removeAll(other) }

/** Returns a set containing all elements that are contained by this array and not contained by the specified collection.
 *  The returned set preserves the element iteration order of the original array. */
infix fun CharBuffer.subtract(other: Iterable<Char>): Set<Char> = toMutableSet().apply { removeAll(other) }


/** Returns a mutable set containing all distinct elements from the given buffer.
 *  The returned set preserves the element iteration order of the original buffer. */
fun ByteBuffer.toMutableSet(): MutableSet<Byte> {
    val set = LinkedHashSet<Byte>(maps.mapCapacity(lim))
    for (item in this) set += item
    return set
}

/** Returns a mutable set containing all distinct elements from the given buffer.
 *  The returned set preserves the element iteration order of the original buffer. */
fun ShortBuffer.toMutableSet(): MutableSet<Short> {
    val set = LinkedHashSet<Short>(maps.mapCapacity(lim))
    for (item in this) set += item
    return set
}

/** Returns a mutable set containing all distinct elements from the given buffer.
 *  The returned set preserves the element iteration order of the original buffer. */
fun IntBuffer.toMutableSet(): MutableSet<Int> {
    val set = LinkedHashSet<Int>(maps.mapCapacity(lim))
    for (item in this) set += item
    return set
}

/** Returns a mutable set containing all distinct elements from the given buffer.
 *  The returned set preserves the element iteration order of the original buffer. */
fun LongBuffer.toMutableSet(): MutableSet<Long> {
    val set = LinkedHashSet<Long>(maps.mapCapacity(lim))
    for (item in this) set += item
    return set
}

/** Returns a mutable set containing all distinct elements from the given buffer.
 *  The returned set preserves the element iteration order of the original buffer. */
fun FloatBuffer.toMutableSet(): MutableSet<Float> {
    val set = LinkedHashSet<Float>(maps.mapCapacity(lim))
    for (item in this) set += item
    return set
}

/** Returns a mutable set containing all distinct elements from the given buffer.
 *  The returned set preserves the element iteration order of the original buffer. */
fun DoubleBuffer.toMutableSet(): MutableSet<Double> {
    val set = LinkedHashSet<Double>(maps.mapCapacity(lim))
    for (item in this) set += item
    return set
}

/** Returns a mutable set containing all distinct elements from the given buffer.
 *  The returned set preserves the element iteration order of the original buffer. */
fun CharBuffer.toMutableSet(): MutableSet<Char> {
    val set = LinkedHashSet<Char>(maps.mapCapacity(lim))
    for (item in this) set += item
    return set
}


/**
 * Returns a set containing all distinct elements from both collections.
 *
 * The returned set preserves the element iteration order of the original array.
 * Those elements of the [other] collection that are unique are iterated in the end
 * in the order of the [other] collection.
 *
 * To get a set containing all elements that are contained in both collections use [intersect].
 */
infix fun ByteBuffer.union(other: Iterable<Byte>): Set<Byte> = toMutableSet().apply { addAll(other) }

/**
 * Returns a set containing all distinct elements from both collections.
 *
 * The returned set preserves the element iteration order of the original array.
 * Those elements of the [other] collection that are unique are iterated in the end
 * in the order of the [other] collection.
 *
 * To get a set containing all elements that are contained in both collections use [intersect].
 */
infix fun ShortBuffer.union(other: Iterable<Short>): Set<Short> = toMutableSet().apply { addAll(other) }

/**
 * Returns a set containing all distinct elements from both collections.
 *
 * The returned set preserves the element iteration order of the original array.
 * Those elements of the [other] collection that are unique are iterated in the end
 * in the order of the [other] collection.
 *
 * To get a set containing all elements that are contained in both collections use [intersect].
 */
infix fun IntBuffer.union(other: Iterable<Int>): Set<Int> = toMutableSet().apply { addAll(other) }

/**
 * Returns a set containing all distinct elements from both collections.
 *
 * The returned set preserves the element iteration order of the original array.
 * Those elements of the [other] collection that are unique are iterated in the end
 * in the order of the [other] collection.
 *
 * To get a set containing all elements that are contained in both collections use [intersect].
 */
infix fun LongBuffer.union(other: Iterable<Long>): Set<Long> = toMutableSet().apply { addAll(other) }

/**
 * Returns a set containing all distinct elements from both collections.
 *
 * The returned set preserves the element iteration order of the original array.
 * Those elements of the [other] collection that are unique are iterated in the end
 * in the order of the [other] collection.
 *
 * To get a set containing all elements that are contained in both collections use [intersect].
 */
infix fun FloatBuffer.union(other: Iterable<Float>): Set<Float> = toMutableSet().apply { addAll(other) }

/**
 * Returns a set containing all distinct elements from both collections.
 *
 * The returned set preserves the element iteration order of the original array.
 * Those elements of the [other] collection that are unique are iterated in the end
 * in the order of the [other] collection.
 *
 * To get a set containing all elements that are contained in both collections use [intersect].
 */
infix fun DoubleBuffer.union(other: Iterable<Double>): Set<Double> = toMutableSet().apply { addAll(other) }

/**
 * Returns a set containing all distinct elements from both collections.
 *
 * The returned set preserves the element iteration order of the original array.
 * Those elements of the [other] collection that are unique are iterated in the end
 * in the order of the [other] collection.
 *
 * To get a set containing all elements that are contained in both collections use [intersect].
 */
infix fun CharBuffer.union(other: Iterable<Char>): Set<Char> = toMutableSet().apply { addAll(other) }


/** Returns `true` if all elements match the given [predicate]. */
inline fun ByteBuffer.all(predicate: (Byte) -> Boolean): Boolean {
    for (element in this) if (!predicate(element)) return false
    return true
}

/** Returns `true` if all elements match the given [predicate]. */
inline fun ShortBuffer.all(predicate: (Short) -> Boolean): Boolean {
    for (element in this) if (!predicate(element)) return false
    return true
}

/** Returns `true` if all elements match the given [predicate]. */
inline fun IntBuffer.all(predicate: (Int) -> Boolean): Boolean {
    for (element in this) if (!predicate(element)) return false
    return true
}

/** Returns `true` if all elements match the given [predicate]. */
inline fun LongBuffer.all(predicate: (Long) -> Boolean): Boolean {
    for (element in this) if (!predicate(element)) return false
    return true
}

/** Returns `true` if all elements match the given [predicate]. */
inline fun FloatBuffer.all(predicate: (Float) -> Boolean): Boolean {
    for (element in this) if (!predicate(element)) return false
    return true
}

/** Returns `true` if all elements match the given [predicate]. */
inline fun DoubleBuffer.all(predicate: (Double) -> Boolean): Boolean {
    for (element in this) if (!predicate(element)) return false
    return true
}

/** Returns `true` if all elements match the given [predicate]. */
inline fun CharBuffer.all(predicate: (Char) -> Boolean): Boolean {
    for (element in this) if (!predicate(element)) return false
    return true
}


/** Returns `true` if buffer has at least one element. */
fun ByteBuffer.any() = !isEmpty()

/** Returns `true` if buffer has at least one element. */
fun ShortBuffer.any() = !isEmpty()

/** Returns `true` if buffer has at least one element. */
fun IntBuffer.any() = !isEmpty()

/** Returns `true` if buffer has at least one element. */
fun LongBuffer.any() = !isEmpty()

/** Returns `true` if buffer has at least one element. */
fun FloatBuffer.any() = !isEmpty()

/** Returns `true` if buffer has at least one element. */
fun DoubleBuffer.any() = !isEmpty()

/** Returns `true` if buffer has at least one element. */
fun CharBuffer.any(): Boolean = !isEmpty()


/** Returns `true` if at least one element matches the given [predicate]. */
inline fun ByteBuffer.any(predicate: (Byte) -> Boolean): Boolean {
    for (element in this) if (predicate(element)) return true
    return false
}

/** Returns `true` if at least one element matches the given [predicate]. */
inline fun ShortBuffer.any(predicate: (Short) -> Boolean): Boolean {
    for (element in this) if (predicate(element)) return true
    return false
}

/** Returns `true` if at least one element matches the given [predicate]. */
inline fun IntBuffer.any(predicate: (Int) -> Boolean): Boolean {
    for (element in this) if (predicate(element)) return true
    return false
}

/** Returns `true` if at least one element matches the given [predicate]. */
inline fun LongBuffer.any(predicate: (Long) -> Boolean): Boolean {
    for (element in this) if (predicate(element)) return true
    return false
}

/** Returns `true` if at least one element matches the given [predicate]. */
inline fun FloatBuffer.any(predicate: (Float) -> Boolean): Boolean {
    for (element in this) if (predicate(element)) return true
    return false
}

/** Returns `true` if at least one element matches the given [predicate]. */
inline fun DoubleBuffer.any(predicate: (Double) -> Boolean): Boolean {
    for (element in this) if (predicate(element)) return true
    return false
}

/** Returns `true` if at least one element matches the given [predicate]. */
inline fun CharBuffer.any(predicate: (Char) -> Boolean): Boolean {
    for (element in this) if (predicate(element)) return true
    return false
}


/** Returns the number of elements in this buffer. */
fun ByteBuffer.count(): Int = lim

/** Returns the number of elements in this buffer. */
fun ShortBuffer.count(): Int = lim

/** Returns the number of elements in this buffer. */
fun IntBuffer.count(): Int = lim

/** Returns the number of elements in this buffer. */
fun LongBuffer.count(): Int = lim

/** Returns the number of elements in this buffer. */
fun FloatBuffer.count(): Int = lim

/** Returns the number of elements in this buffer. */
fun DoubleBuffer.count(): Int = lim

/** Returns the number of elements in this buffer. */
fun CharBuffer.count(): Int = lim


/** Returns the number of elements matching the given [predicate]. */
inline fun ByteBuffer.count(predicate: (Byte) -> Boolean): Int {
    var count = 0
    for (element in this) if (predicate(element)) count++
    return count
}

/** Returns the number of elements matching the given [predicate]. */
inline fun ShortBuffer.count(predicate: (Short) -> Boolean): Int {
    var count = 0
    for (element in this) if (predicate(element)) count++
    return count
}

/** Returns the number of elements matching the given [predicate]. */
inline fun IntBuffer.count(predicate: (Int) -> Boolean): Int {
    var count = 0
    for (element in this) if (predicate(element)) count++
    return count
}

/** Returns the number of elements matching the given [predicate]. */
inline fun LongBuffer.count(predicate: (Long) -> Boolean): Int {
    var count = 0
    for (element in this) if (predicate(element)) count++
    return count
}

/** Returns the number of elements matching the given [predicate]. */
inline fun FloatBuffer.count(predicate: (Float) -> Boolean): Int {
    var count = 0
    for (element in this) if (predicate(element)) count++
    return count
}

/** Returns the number of elements matching the given [predicate]. */
inline fun DoubleBuffer.count(predicate: (Double) -> Boolean): Int {
    var count = 0
    for (element in this) if (predicate(element)) count++
    return count
}

/** Returns the number of elements matching the given [predicate]. */
inline fun CharBuffer.count(predicate: (Char) -> Boolean): Int {
    var count = 0
    for (element in this) if (predicate(element)) count++
    return count
}


/**
 * Accumulates value starting with [initial] value and applying [operation] from left to right
 * to current accumulator value and each element.
 *
 * Returns the specified [initial] value if the array is empty.
 *
 * @param [operation] function that takes current accumulator value and an element, and calculates the next accumulator value.
 */
inline fun <R> ByteBuffer.fold(initial: R, operation: (acc: R, Byte) -> R): R {
    var accumulator = initial
    for (element in this) accumulator = operation(accumulator, element)
    return accumulator
}

/**
 * Accumulates value starting with [initial] value and applying [operation] from left to right
 * to current accumulator value and each element.
 *
 * Returns the specified [initial] value if the array is empty.
 *
 * @param [operation] function that takes current accumulator value and an element, and calculates the next accumulator value.
 */
inline fun <R> ShortBuffer.fold(initial: R, operation: (acc: R, Short) -> R): R {
    var accumulator = initial
    for (element in this) accumulator = operation(accumulator, element)
    return accumulator
}

/**
 * Accumulates value starting with [initial] value and applying [operation] from left to right
 * to current accumulator value and each element.
 *
 * Returns the specified [initial] value if the array is empty.
 *
 * @param [operation] function that takes current accumulator value and an element, and calculates the next accumulator value.
 */
inline fun <R> IntBuffer.fold(initial: R, operation: (acc: R, Int) -> R): R {
    var accumulator = initial
    for (element in this) accumulator = operation(accumulator, element)
    return accumulator
}

/**
 * Accumulates value starting with [initial] value and applying [operation] from left to right
 * to current accumulator value and each element.
 *
 * Returns the specified [initial] value if the array is empty.
 *
 * @param [operation] function that takes current accumulator value and an element, and calculates the next accumulator value.
 */
inline fun <R> LongBuffer.fold(initial: R, operation: (acc: R, Long) -> R): R {
    var accumulator = initial
    for (element in this) accumulator = operation(accumulator, element)
    return accumulator
}

/**
 * Accumulates value starting with [initial] value and applying [operation] from left to right
 * to current accumulator value and each element.
 *
 * Returns the specified [initial] value if the array is empty.
 *
 * @param [operation] function that takes current accumulator value and an element, and calculates the next accumulator value.
 */
inline fun <R> FloatBuffer.fold(initial: R, operation: (acc: R, Float) -> R): R {
    var accumulator = initial
    for (element in this) accumulator = operation(accumulator, element)
    return accumulator
}

/**
 * Accumulates value starting with [initial] value and applying [operation] from left to right
 * to current accumulator value and each element.
 *
 * Returns the specified [initial] value if the array is empty.
 *
 * @param [operation] function that takes current accumulator value and an element, and calculates the next accumulator value.
 */
inline fun <R> DoubleBuffer.fold(initial: R, operation: (acc: R, Double) -> R): R {
    var accumulator = initial
    for (element in this) accumulator = operation(accumulator, element)
    return accumulator
}

/**
 * Accumulates value starting with [initial] value and applying [operation] from left to right
 * to current accumulator value and each element.
 *
 * Returns the specified [initial] value if the array is empty.
 *
 * @param [operation] function that takes current accumulator value and an element, and calculates the next accumulator value.
 */
inline fun <R> CharBuffer.fold(initial: R, operation: (acc: R, Char) -> R): R {
    var accumulator = initial
    for (element in this) accumulator = operation(accumulator, element)
    return accumulator
}


/**
 * Accumulates value starting with [initial] value and applying [operation] from left to right
 * to current accumulator value and each element with its index in the original array.
 *
 * Returns the specified [initial] value if the array is empty.
 *
 * @param [operation] function that takes the index of an element, current accumulator value
 * and the element itself, and calculates the next accumulator value.
 */
inline fun <R> ByteBuffer.foldIndexed(initial: R, operation: (index: Int, acc: R, Byte) -> R): R {
    var index = 0
    var accumulator = initial
    for (element in this) accumulator = operation(index++, accumulator, element)
    return accumulator
}

/**
 * Accumulates value starting with [initial] value and applying [operation] from left to right
 * to current accumulator value and each element with its index in the original array.
 *
 * Returns the specified [initial] value if the array is empty.
 *
 * @param [operation] function that takes the index of an element, current accumulator value
 * and the element itself, and calculates the next accumulator value.
 */
inline fun <R> ShortBuffer.foldIndexed(initial: R, operation: (index: Int, acc: R, Short) -> R): R {
    var index = 0
    var accumulator = initial
    for (element in this) accumulator = operation(index++, accumulator, element)
    return accumulator
}

/**
 * Accumulates value starting with [initial] value and applying [operation] from left to right
 * to current accumulator value and each element with its index in the original array.
 *
 * Returns the specified [initial] value if the array is empty.
 *
 * @param [operation] function that takes the index of an element, current accumulator value
 * and the element itself, and calculates the next accumulator value.
 */
inline fun <R> IntBuffer.foldIndexed(initial: R, operation: (index: Int, acc: R, Int) -> R): R {
    var index = 0
    var accumulator = initial
    for (element in this) accumulator = operation(index++, accumulator, element)
    return accumulator
}

/**
 * Accumulates value starting with [initial] value and applying [operation] from left to right
 * to current accumulator value and each element with its index in the original array.
 *
 * Returns the specified [initial] value if the array is empty.
 *
 * @param [operation] function that takes the index of an element, current accumulator value
 * and the element itself, and calculates the next accumulator value.
 */
inline fun <R> LongBuffer.foldIndexed(initial: R, operation: (index: Int, acc: R, Long) -> R): R {
    var index = 0
    var accumulator = initial
    for (element in this) accumulator = operation(index++, accumulator, element)
    return accumulator
}

/**
 * Accumulates value starting with [initial] value and applying [operation] from left to right
 * to current accumulator value and each element with its index in the original array.
 *
 * Returns the specified [initial] value if the array is empty.
 *
 * @param [operation] function that takes the index of an element, current accumulator value
 * and the element itself, and calculates the next accumulator value.
 */
inline fun <R> FloatBuffer.foldIndexed(initial: R, operation: (index: Int, acc: R, Float) -> R): R {
    var index = 0
    var accumulator = initial
    for (element in this) accumulator = operation(index++, accumulator, element)
    return accumulator
}

/**
 * Accumulates value starting with [initial] value and applying [operation] from left to right
 * to current accumulator value and each element with its index in the original array.
 *
 * Returns the specified [initial] value if the array is empty.
 *
 * @param [operation] function that takes the index of an element, current accumulator value
 * and the element itself, and calculates the next accumulator value.
 */
inline fun <R> DoubleBuffer.foldIndexed(initial: R, operation: (index: Int, acc: R, Double) -> R): R {
    var index = 0
    var accumulator = initial
    for (element in this) accumulator = operation(index++, accumulator, element)
    return accumulator
}

/**
 * Accumulates value starting with [initial] value and applying [operation] from left to right
 * to current accumulator value and each element with its index in the original array.
 *
 * Returns the specified [initial] value if the array is empty.
 *
 * @param [operation] function that takes the index of an element, current accumulator value
 * and the element itself, and calculates the next accumulator value.
 */
inline fun <R> CharBuffer.foldIndexed(initial: R, operation: (index: Int, acc: R, Char) -> R): R {
    var index = 0
    var accumulator = initial
    for (element in this) accumulator = operation(index++, accumulator, element)
    return accumulator
}


/**
 * Accumulates value starting with [initial] value and applying [operation] from right to left
 * to each element and current accumulator value.
 *
 * Returns the specified [initial] value if the array is empty.
 *
 * @param [operation] function that takes an element and current accumulator value, and calculates the next accumulator value.
 */
inline fun <R> ByteBuffer.foldRight(initial: R, operation: (Byte, acc: R) -> R): R {
    var index = lastIndex
    var accumulator = initial
    while (index >= 0)
        accumulator = operation(get(index--), accumulator)
    return accumulator
}

/**
 * Accumulates value starting with [initial] value and applying [operation] from right to left
 * to each element and current accumulator value.
 *
 * Returns the specified [initial] value if the array is empty.
 *
 * @param [operation] function that takes an element and current accumulator value, and calculates the next accumulator value.
 */
inline fun <R> ShortBuffer.foldRight(initial: R, operation: (Short, acc: R) -> R): R {
    var index = lastIndex
    var accumulator = initial
    while (index >= 0)
        accumulator = operation(get(index--), accumulator)
    return accumulator
}

/**
 * Accumulates value starting with [initial] value and applying [operation] from right to left
 * to each element and current accumulator value.
 *
 * Returns the specified [initial] value if the array is empty.
 *
 * @param [operation] function that takes an element and current accumulator value, and calculates the next accumulator value.
 */
inline fun <R> IntBuffer.foldRight(initial: R, operation: (Int, acc: R) -> R): R {
    var index = lastIndex
    var accumulator = initial
    while (index >= 0)
        accumulator = operation(get(index--), accumulator)
    return accumulator
}

/**
 * Accumulates value starting with [initial] value and applying [operation] from right to left
 * to each element and current accumulator value.
 *
 * Returns the specified [initial] value if the array is empty.
 *
 * @param [operation] function that takes an element and current accumulator value, and calculates the next accumulator value.
 */
inline fun <R> LongBuffer.foldRight(initial: R, operation: (Long, acc: R) -> R): R {
    var index = lastIndex
    var accumulator = initial
    while (index >= 0)
        accumulator = operation(get(index--), accumulator)
    return accumulator
}

/**
 * Accumulates value starting with [initial] value and applying [operation] from right to left
 * to each element and current accumulator value.
 *
 * Returns the specified [initial] value if the array is empty.
 *
 * @param [operation] function that takes an element and current accumulator value, and calculates the next accumulator value.
 */
inline fun <R> FloatBuffer.foldRight(initial: R, operation: (Float, acc: R) -> R): R {
    var index = lastIndex
    var accumulator = initial
    while (index >= 0)
        accumulator = operation(get(index--), accumulator)
    return accumulator
}

/**
 * Accumulates value starting with [initial] value and applying [operation] from right to left
 * to each element and current accumulator value.
 *
 * Returns the specified [initial] value if the array is empty.
 *
 * @param [operation] function that takes an element and current accumulator value, and calculates the next accumulator value.
 */
inline fun <R> DoubleBuffer.foldRight(initial: R, operation: (Double, acc: R) -> R): R {
    var index = lastIndex
    var accumulator = initial
    while (index >= 0)
        accumulator = operation(get(index--), accumulator)
    return accumulator
}

/**
 * Accumulates value starting with [initial] value and applying [operation] from right to left
 * to each element and current accumulator value.
 *
 * Returns the specified [initial] value if the array is empty.
 *
 * @param [operation] function that takes an element and current accumulator value, and calculates the next accumulator value.
 */
inline fun <R> CharBuffer.foldRight(initial: R, operation: (Char, acc: R) -> R): R {
    var index = lastIndex
    var accumulator = initial
    while (index >= 0)
        accumulator = operation(get(index--), accumulator)
    return accumulator
}


/**
 * Accumulates value starting with [initial] value and applying [operation] from right to left
 * to each element with its index in the original array and current accumulator value.
 *
 * Returns the specified [initial] value if the array is empty.
 *
 * @param [operation] function that takes the index of an element, the element itself
 * and current accumulator value, and calculates the next accumulator value.
 */
inline fun <R> ByteBuffer.foldRightIndexed(initial: R, operation: (index: Int, Byte, acc: R) -> R): R {
    var index = lastIndex
    var accumulator = initial
    while (index >= 0) {
        accumulator = operation(index, get(index), accumulator)
        --index
    }
    return accumulator
}

/**
 * Accumulates value starting with [initial] value and applying [operation] from right to left
 * to each element with its index in the original array and current accumulator value.
 *
 * Returns the specified [initial] value if the array is empty.
 *
 * @param [operation] function that takes the index of an element, the element itself
 * and current accumulator value, and calculates the next accumulator value.
 */
inline fun <R> ShortBuffer.foldRightIndexed(initial: R, operation: (index: Int, Short, acc: R) -> R): R {
    var index = lastIndex
    var accumulator = initial
    while (index >= 0) {
        accumulator = operation(index, get(index), accumulator)
        --index
    }
    return accumulator
}

/**
 * Accumulates value starting with [initial] value and applying [operation] from right to left
 * to each element with its index in the original array and current accumulator value.
 *
 * Returns the specified [initial] value if the array is empty.
 *
 * @param [operation] function that takes the index of an element, the element itself
 * and current accumulator value, and calculates the next accumulator value.
 */
inline fun <R> IntBuffer.foldRightIndexed(initial: R, operation: (index: Int, Int, acc: R) -> R): R {
    var index = lastIndex
    var accumulator = initial
    while (index >= 0) {
        accumulator = operation(index, get(index), accumulator)
        --index
    }
    return accumulator
}

/**
 * Accumulates value starting with [initial] value and applying [operation] from right to left
 * to each element with its index in the original array and current accumulator value.
 *
 * Returns the specified [initial] value if the array is empty.
 *
 * @param [operation] function that takes the index of an element, the element itself
 * and current accumulator value, and calculates the next accumulator value.
 */
inline fun <R> LongBuffer.foldRightIndexed(initial: R, operation: (index: Int, Long, acc: R) -> R): R {
    var index = lastIndex
    var accumulator = initial
    while (index >= 0) {
        accumulator = operation(index, get(index), accumulator)
        --index
    }
    return accumulator
}

/**
 * Accumulates value starting with [initial] value and applying [operation] from right to left
 * to each element with its index in the original array and current accumulator value.
 *
 * Returns the specified [initial] value if the array is empty.
 *
 * @param [operation] function that takes the index of an element, the element itself
 * and current accumulator value, and calculates the next accumulator value.
 */
inline fun <R> FloatBuffer.foldRightIndexed(initial: R, operation: (index: Int, Float, acc: R) -> R): R {
    var index = lastIndex
    var accumulator = initial
    while (index >= 0) {
        accumulator = operation(index, get(index), accumulator)
        --index
    }
    return accumulator
}

/**
 * Accumulates value starting with [initial] value and applying [operation] from right to left
 * to each element with its index in the original array and current accumulator value.
 *
 * Returns the specified [initial] value if the array is empty.
 *
 * @param [operation] function that takes the index of an element, the element itself
 * and current accumulator value, and calculates the next accumulator value.
 */
inline fun <R> DoubleBuffer.foldRightIndexed(initial: R, operation: (index: Int, Double, acc: R) -> R): R {
    var index = lastIndex
    var accumulator = initial
    while (index >= 0) {
        accumulator = operation(index, get(index), accumulator)
        --index
    }
    return accumulator
}

/**
 * Accumulates value starting with [initial] value and applying [operation] from right to left
 * to each element with its index in the original array and current accumulator value.
 *
 * Returns the specified [initial] value if the array is empty.
 *
 * @param [operation] function that takes the index of an element, the element itself
 * and current accumulator value, and calculates the next accumulator value.
 */
inline fun <R> CharBuffer.foldRightIndexed(initial: R, operation: (index: Int, Char, acc: R) -> R): R {
    var index = lastIndex
    var accumulator = initial
    while (index >= 0) {
        accumulator = operation(index, get(index), accumulator)
        --index
    }
    return accumulator
}


/** Performs the given [action] on each element. */
inline fun ByteBuffer.forEach(action: (Byte) -> Unit) {
    for (element in this) action(element)
}

/** Performs the given [action] on each element. */
inline fun ShortBuffer.forEach(action: (Short) -> Unit) {
    for (element in this) action(element)
}

/** Performs the given [action] on each element. */
inline fun IntBuffer.forEach(action: (Int) -> Unit) {
    for (element in this) action(element)
}

/** Performs the given [action] on each element. */
inline fun LongBuffer.forEach(action: (Long) -> Unit) {
    for (element in this) action(element)
}

/** Performs the given [action] on each element. */
inline fun FloatBuffer.forEach(action: (Float) -> Unit) {
    for (element in this) action(element)
}

/** Performs the given [action] on each element. */
inline fun DoubleBuffer.forEach(action: (Double) -> Unit) {
    for (element in this) action(element)
}

/** Performs the given [action] on each element. */
inline fun CharBuffer.forEach(action: (Char) -> Unit) {
    for (element in this) action(element)
}


/** Performs the given [action] on each element, providing sequential index with the element.
 *  @param [action] function that takes the index of an element and the element itself and performs the desired action on the element. */
inline fun ByteBuffer.forEachIndexed(action: (index: Int, Byte) -> Unit): Unit {
    var index = 0
    for (item in this) action(index++, item)
}

/** Performs the given [action] on each element, providing sequential index with the element.
 *  @param [action] function that takes the index of an element and the element itself and performs the desired action on the element. */
inline fun ShortBuffer.forEachIndexed(action: (index: Int, Short) -> Unit): Unit {
    var index = 0
    for (item in this) action(index++, item)
}

/** Performs the given [action] on each element, providing sequential index with the element.
 *  @param [action] function that takes the index of an element and the element itself and performs the desired action on the element. */
inline fun IntBuffer.forEachIndexed(action: (index: Int, Int) -> Unit): Unit {
    var index = 0
    for (item in this) action(index++, item)
}

/** Performs the given [action] on each element, providing sequential index with the element.
 *  @param [action] function that takes the index of an element and the element itself and performs the desired action on the element. */
inline fun LongBuffer.forEachIndexed(action: (index: Int, Long) -> Unit): Unit {
    var index = 0
    for (item in this) action(index++, item)
}

/** Performs the given [action] on each element, providing sequential index with the element.
 *  @param [action] function that takes the index of an element and the element itself and performs the desired action on the element. */
inline fun FloatBuffer.forEachIndexed(action: (index: Int, Float) -> Unit): Unit {
    var index = 0
    for (item in this) action(index++, item)
}

/** Performs the given [action] on each element, providing sequential index with the element.
 *  @param [action] function that takes the index of an element and the element itself and performs the desired action on the element. */
inline fun DoubleBuffer.forEachIndexed(action: (index: Int, Double) -> Unit): Unit {
    var index = 0
    for (item in this) action(index++, item)
}

/** Performs the given [action] on each element, providing sequential index with the element.
 *  @param [action] function that takes the index of an element and the element itself and performs the desired action on the element. */
inline fun CharBuffer.forEachIndexed(action: (index: Int, Char) -> Unit): Unit {
    var index = 0
    for (item in this) action(index++, item)
}


/** Returns the first element yielding the largest value of the given function or `null` if there are no elements.
 *  @sample kool.buffers.Collections.Aggregates.maxByOrNull */
inline fun <R : Comparable<R>> ByteBuffer.maxByOrNull(selector: (Byte) -> R): Byte? {
    if (isEmpty()) return null
    var maxElem = this[0]
    val lastIndex = this.lastIndex
    if (lastIndex == 0) return maxElem
    var maxValue = selector(maxElem)
    for (i in 1..lastIndex) {
        val e = this[i]
        val v = selector(e)
        if (maxValue < v) {
            maxElem = e
            maxValue = v
        }
    }
    return maxElem
}

/** Returns the first element yielding the largest value of the given function or `null` if there are no elements.
 *  @sample kool.buffers.Collections.Aggregates.maxByOrNull */
inline fun <R : Comparable<R>> ShortBuffer.maxByOrNull(selector: (Short) -> R): Short? {
    if (isEmpty()) return null
    var maxElem = this[0]
    val lastIndex = this.lastIndex
    if (lastIndex == 0) return maxElem
    var maxValue = selector(maxElem)
    for (i in 1..lastIndex) {
        val e = this[i]
        val v = selector(e)
        if (maxValue < v) {
            maxElem = e
            maxValue = v
        }
    }
    return maxElem
}

/** Returns the first element yielding the largest value of the given function or `null` if there are no elements.
 *  @sample kool.buffers.Collections.Aggregates.maxByOrNull */
inline fun <R : Comparable<R>> IntBuffer.maxByOrNull(selector: (Int) -> R): Int? {
    if (isEmpty()) return null
    var maxElem = this[0]
    val lastIndex = this.lastIndex
    if (lastIndex == 0) return maxElem
    var maxValue = selector(maxElem)
    for (i in 1..lastIndex) {
        val e = this[i]
        val v = selector(e)
        if (maxValue < v) {
            maxElem = e
            maxValue = v
        }
    }
    return maxElem
}

/** Returns the first element yielding the largest value of the given function or `null` if there are no elements.
 *  @sample kool.buffers.Collections.Aggregates.maxByOrNull */
inline fun <R : Comparable<R>> LongBuffer.maxByOrNull(selector: (Long) -> R): Long? {
    if (isEmpty()) return null
    var maxElem = this[0]
    val lastIndex = this.lastIndex
    if (lastIndex == 0) return maxElem
    var maxValue = selector(maxElem)
    for (i in 1..lastIndex) {
        val e = this[i]
        val v = selector(e)
        if (maxValue < v) {
            maxElem = e
            maxValue = v
        }
    }
    return maxElem
}

/** Returns the first element yielding the largest value of the given function or `null` if there are no elements.
 *  @sample kool.buffers.Collections.Aggregates.maxByOrNull */
inline fun <R : Comparable<R>> FloatBuffer.maxByOrNull(selector: (Float) -> R): Float? {
    if (isEmpty()) return null
    var maxElem = this[0]
    val lastIndex = this.lastIndex
    if (lastIndex == 0) return maxElem
    var maxValue = selector(maxElem)
    for (i in 1..lastIndex) {
        val e = this[i]
        val v = selector(e)
        if (maxValue < v) {
            maxElem = e
            maxValue = v
        }
    }
    return maxElem
}

/** Returns the first element yielding the largest value of the given function or `null` if there are no elements.
 *  @sample kool.buffers.Collections.Aggregates.maxByOrNull */
inline fun <R : Comparable<R>> DoubleBuffer.maxByOrNull(selector: (Double) -> R): Double? {
    if (isEmpty()) return null
    var maxElem = this[0]
    val lastIndex = this.lastIndex
    if (lastIndex == 0) return maxElem
    var maxValue = selector(maxElem)
    for (i in 1..lastIndex) {
        val e = this[i]
        val v = selector(e)
        if (maxValue < v) {
            maxElem = e
            maxValue = v
        }
    }
    return maxElem
}

/** Returns the first element yielding the largest value of the given function or `null` if there are no elements.
 *  @sample kool.buffers.Collections.Aggregates.maxByOrNull */
inline fun <R : Comparable<R>> CharBuffer.maxByOrNull(selector: (Char) -> R): Char? {
    if (isEmpty()) return null
    var maxElem = this[0]
    val lastIndex = this.lastIndex
    if (lastIndex == 0) return maxElem
    var maxValue = selector(maxElem)
    for (i in 1..lastIndex) {
        val e = this[i]
        val v = selector(e)
        if (maxValue < v) {
            maxElem = e
            maxValue = v
        }
    }
    return maxElem
}


/**
 * Returns the largest value among all values produced by [selector] function
 * applied to each element in the array.
 *
 * If any of values produced by [selector] function is `NaN`, the returned result is `NaN`.
 *
 * @throws NoSuchElementException if the array is empty.
 */
@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
inline fun ByteBuffer.maxOf(selector: (Byte) -> Double): Double {
    if (isEmpty()) throw NoSuchElementException()
    var maxValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        maxValue = maxOf(maxValue, v)
    }
    return maxValue
}

/**
 * Returns the largest value among all values produced by [selector] function
 * applied to each element in the array.
 *
 * If any of values produced by [selector] function is `NaN`, the returned result is `NaN`.
 *
 * @throws NoSuchElementException if the array is empty.
 */
@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
inline fun ShortBuffer.maxOf(selector: (Short) -> Double): Double {
    if (isEmpty()) throw NoSuchElementException()
    var maxValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        maxValue = maxOf(maxValue, v)
    }
    return maxValue
}

/**
 * Returns the largest value among all values produced by [selector] function
 * applied to each element in the array.
 *
 * If any of values produced by [selector] function is `NaN`, the returned result is `NaN`.
 *
 * @throws NoSuchElementException if the array is empty.
 */
@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
inline fun IntBuffer.maxOf(selector: (Int) -> Double): Double {
    if (isEmpty()) throw NoSuchElementException()
    var maxValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        maxValue = maxOf(maxValue, v)
    }
    return maxValue
}

/**
 * Returns the largest value among all values produced by [selector] function
 * applied to each element in the array.
 *
 * If any of values produced by [selector] function is `NaN`, the returned result is `NaN`.
 *
 * @throws NoSuchElementException if the array is empty.
 */
@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
inline fun LongBuffer.maxOf(selector: (Long) -> Double): Double {
    if (isEmpty()) throw NoSuchElementException()
    var maxValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        maxValue = maxOf(maxValue, v)
    }
    return maxValue
}

/**
 * Returns the largest value among all values produced by [selector] function
 * applied to each element in the array.
 *
 * If any of values produced by [selector] function is `NaN`, the returned result is `NaN`.
 *
 * @throws NoSuchElementException if the array is empty.
 */
@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
inline fun FloatBuffer.maxOf(selector: (Float) -> Double): Double {
    if (isEmpty()) throw NoSuchElementException()
    var maxValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        maxValue = maxOf(maxValue, v)
    }
    return maxValue
}

/**
 * Returns the largest value among all values produced by [selector] function
 * applied to each element in the array.
 *
 * If any of values produced by [selector] function is `NaN`, the returned result is `NaN`.
 *
 * @throws NoSuchElementException if the array is empty.
 */
@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
inline fun DoubleBuffer.maxOf(selector: (Double) -> Double): Double {
    if (isEmpty()) throw NoSuchElementException()
    var maxValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        maxValue = maxOf(maxValue, v)
    }
    return maxValue
}

/**
 * Returns the largest value among all values produced by [selector] function
 * applied to each element in the array.
 *
 * If any of values produced by [selector] function is `NaN`, the returned result is `NaN`.
 *
 * @throws NoSuchElementException if the array is empty.
 */
@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
inline fun CharBuffer.maxOf(selector: (Char) -> Double): Double {
    if (isEmpty()) throw NoSuchElementException()
    var maxValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        maxValue = maxOf(maxValue, v)
    }
    return maxValue
}


/** Returns the largest value among all values produced by [selector] function applied to each element in the array.
 *  @throws NoSuchElementException if the array is empty. */
@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
inline fun <R : Comparable<R>> ByteBuffer.maxOf(selector: (Byte) -> R): R {
    if (isEmpty()) throw NoSuchElementException()
    var maxValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        if (maxValue < v)
            maxValue = v
    }
    return maxValue
}

/** Returns the largest value among all values produced by [selector] function applied to each element in the array.
 *  @throws NoSuchElementException if the array is empty. */
@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
inline fun <R : Comparable<R>> ShortBuffer.maxOf(selector: (Short) -> R): R {
    if (isEmpty()) throw NoSuchElementException()
    var maxValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        if (maxValue < v)
            maxValue = v
    }
    return maxValue
}

/** Returns the largest value among all values produced by [selector] function applied to each element in the array.
 *  @throws NoSuchElementException if the array is empty. */
@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
inline fun <R : Comparable<R>> IntBuffer.maxOf(selector: (Int) -> R): R {
    if (isEmpty()) throw NoSuchElementException()
    var maxValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        if (maxValue < v)
            maxValue = v
    }
    return maxValue
}

/** Returns the largest value among all values produced by [selector] function applied to each element in the array.
 *  @throws NoSuchElementException if the array is empty. */
@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
inline fun <R : Comparable<R>> LongBuffer.maxOf(selector: (Long) -> R): R {
    if (isEmpty()) throw NoSuchElementException()
    var maxValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        if (maxValue < v)
            maxValue = v
    }
    return maxValue
}

/** Returns the largest value among all values produced by [selector] function applied to each element in the array.
 *  @throws NoSuchElementException if the array is empty. */
@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
inline fun <R : Comparable<R>> FloatBuffer.maxOf(selector: (Float) -> R): R {
    if (isEmpty()) throw NoSuchElementException()
    var maxValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        if (maxValue < v)
            maxValue = v
    }
    return maxValue
}

/** Returns the largest value among all values produced by [selector] function applied to each element in the array.
 *  @throws NoSuchElementException if the array is empty. */
@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
inline fun <R : Comparable<R>> DoubleBuffer.maxOf(selector: (Double) -> R): R {
    if (isEmpty()) throw NoSuchElementException()
    var maxValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        if (maxValue < v)
            maxValue = v
    }
    return maxValue
}

/** Returns the largest value among all values produced by [selector] function applied to each element in the array.
 *  @throws NoSuchElementException if the array is empty. */
@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
inline fun <R : Comparable<R>> CharBuffer.maxOf(selector: (Char) -> R): R {
    if (isEmpty()) throw NoSuchElementException()
    var maxValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        if (maxValue < v)
            maxValue = v
    }
    return maxValue
}


/** Returns the largest value among all values produced by [selector] function applied to each element in the array or
 *  `null` if there are no elements.
 *  If any of values produced by [selector] function is `NaN`, the returned result is `NaN`. */
@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
inline fun ByteBuffer.maxOfOrNull(selector: (Byte) -> Double): Double? {
    if (isEmpty()) return null
    var maxValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        maxValue = maxOf(maxValue, v)
    }
    return maxValue
}

/** Returns the largest value among all values produced by [selector] function applied to each element in the array or
 *  `null` if there are no elements.
 *  If any of values produced by [selector] function is `NaN`, the returned result is `NaN`. */
@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
inline fun ShortBuffer.maxOfOrNull(selector: (Short) -> Double): Double? {
    if (isEmpty()) return null
    var maxValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        maxValue = maxOf(maxValue, v)
    }
    return maxValue
}

/** Returns the largest value among all values produced by [selector] function applied to each element in the array or
 *  `null` if there are no elements.
 *  If any of values produced by [selector] function is `NaN`, the returned result is `NaN`. */
@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
inline fun IntBuffer.maxOfOrNull(selector: (Int) -> Double): Double? {
    if (isEmpty()) return null
    var maxValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        maxValue = maxOf(maxValue, v)
    }
    return maxValue
}

/** Returns the largest value among all values produced by [selector] function applied to each element in the array or
 *  `null` if there are no elements.
 *  If any of values produced by [selector] function is `NaN`, the returned result is `NaN`. */
@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
inline fun LongBuffer.maxOfOrNull(selector: (Long) -> Double): Double? {
    if (isEmpty()) return null
    var maxValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        maxValue = maxOf(maxValue, v)
    }
    return maxValue
}

/** Returns the largest value among all values produced by [selector] function applied to each element in the array or
 *  `null` if there are no elements.
 *  If any of values produced by [selector] function is `NaN`, the returned result is `NaN`. */
@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
inline fun FloatBuffer.maxOfOrNull(selector: (Float) -> Double): Double? {
    if (isEmpty()) return null
    var maxValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        maxValue = maxOf(maxValue, v)
    }
    return maxValue
}

/** Returns the largest value among all values produced by [selector] function applied to each element in the array or
 *  `null` if there are no elements.
 *  If any of values produced by [selector] function is `NaN`, the returned result is `NaN`. */
@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
inline fun DoubleBuffer.maxOfOrNull(selector: (Double) -> Double): Double? {
    if (isEmpty()) return null
    var maxValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        maxValue = maxOf(maxValue, v)
    }
    return maxValue
}

/** Returns the largest value among all values produced by [selector] function applied to each element in the array or
 *  `null` if there are no elements.
 *  If any of values produced by [selector] function is `NaN`, the returned result is `NaN`. */
@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
inline fun CharBuffer.maxOfOrNull(selector: (Char) -> Double): Double? {
    if (isEmpty()) return null
    var maxValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        maxValue = maxOf(maxValue, v)
    }
    return maxValue
}


/** Returns the largest value among all values produced by [selector] function applied to each element in the array or
 *  `null` if there are no elements.
 *  If any of values produced by [selector] function is `NaN`, the returned result is `NaN`. */
@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
inline fun ByteBuffer.maxOfOrNull(selector: (Byte) -> Float): Float? {
    if (isEmpty()) return null
    var maxValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        maxValue = maxOf(maxValue, v)
    }
    return maxValue
}

/** Returns the largest value among all values produced by [selector] function applied to each element in the array or
 *  `null` if there are no elements.
 *  If any of values produced by [selector] function is `NaN`, the returned result is `NaN`. */
@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
inline fun ShortBuffer.maxOfOrNull(selector: (Short) -> Float): Float? {
    if (isEmpty()) return null
    var maxValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        maxValue = maxOf(maxValue, v)
    }
    return maxValue
}

/** Returns the largest value among all values produced by [selector] function applied to each element in the array or
 *  `null` if there are no elements.
 *  If any of values produced by [selector] function is `NaN`, the returned result is `NaN`. */
@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
inline fun IntBuffer.maxOfOrNull(selector: (Int) -> Float): Float? {
    if (isEmpty()) return null
    var maxValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        maxValue = maxOf(maxValue, v)
    }
    return maxValue
}

/** Returns the largest value among all values produced by [selector] function applied to each element in the array or
 *  `null` if there are no elements.
 *  If any of values produced by [selector] function is `NaN`, the returned result is `NaN`. */
@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
inline fun LongBuffer.maxOfOrNull(selector: (Long) -> Float): Float? {
    if (isEmpty()) return null
    var maxValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        maxValue = maxOf(maxValue, v)
    }
    return maxValue
}

/** Returns the largest value among all values produced by [selector] function applied to each element in the array or
 *  `null` if there are no elements.
 *  If any of values produced by [selector] function is `NaN`, the returned result is `NaN`. */
@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
inline fun FloatBuffer.maxOfOrNull(selector: (Float) -> Float): Float? {
    if (isEmpty()) return null
    var maxValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        maxValue = maxOf(maxValue, v)
    }
    return maxValue
}

/** Returns the largest value among all values produced by [selector] function applied to each element in the array or
 *  `null` if there are no elements.
 *  If any of values produced by [selector] function is `NaN`, the returned result is `NaN`. */
@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
inline fun DoubleBuffer.maxOfOrNull(selector: (Double) -> Float): Float? {
    if (isEmpty()) return null
    var maxValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        maxValue = maxOf(maxValue, v)
    }
    return maxValue
}

/** Returns the largest value among all values produced by [selector] function applied to each element in the array or
 *  `null` if there are no elements.
 *  If any of values produced by [selector] function is `NaN`, the returned result is `NaN`. */
@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
inline fun CharBuffer.maxOfOrNull(selector: (Char) -> Float): Float? {
    if (isEmpty()) return null
    var maxValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        maxValue = maxOf(maxValue, v)
    }
    return maxValue
}


/** Returns the largest value among all values produced by [selector] function applied to each element in the array or
 *  `null` if there are no elements. */
@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
inline fun <R : Comparable<R>> ByteBuffer.maxOfOrNull(selector: (Byte) -> R): R? {
    if (isEmpty()) return null
    var maxValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        if (maxValue < v)
            maxValue = v
    }
    return maxValue
}

/** Returns the largest value among all values produced by [selector] function applied to each element in the array or
 *  `null` if there are no elements. */
@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
inline fun <R : Comparable<R>> ShortBuffer.maxOfOrNull(selector: (Short) -> R): R? {
    if (isEmpty()) return null
    var maxValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        if (maxValue < v)
            maxValue = v
    }
    return maxValue
}

/** Returns the largest value among all values produced by [selector] function applied to each element in the array or
 *  `null` if there are no elements. */
@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
inline fun <R : Comparable<R>> IntBuffer.maxOfOrNull(selector: (Int) -> R): R? {
    if (isEmpty()) return null
    var maxValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        if (maxValue < v)
            maxValue = v
    }
    return maxValue
}

/** Returns the largest value among all values produced by [selector] function applied to each element in the array or
 *  `null` if there are no elements. */
@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
inline fun <R : Comparable<R>> LongBuffer.maxOfOrNull(selector: (Long) -> R): R? {
    if (isEmpty()) return null
    var maxValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        if (maxValue < v)
            maxValue = v
    }
    return maxValue
}

/** Returns the largest value among all values produced by [selector] function applied to each element in the array or
 *  `null` if there are no elements. */
@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
inline fun <R : Comparable<R>> FloatBuffer.maxOfOrNull(selector: (Float) -> R): R? {
    if (isEmpty()) return null
    var maxValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        if (maxValue < v)
            maxValue = v
    }
    return maxValue
}

/** Returns the largest value among all values produced by [selector] function applied to each element in the array or
 *  `null` if there are no elements. */
@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
inline fun <R : Comparable<R>> DoubleBuffer.maxOfOrNull(selector: (Double) -> R): R? {
    if (isEmpty()) return null
    var maxValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        if (maxValue < v)
            maxValue = v
    }
    return maxValue
}

/** Returns the largest value among all values produced by [selector] function applied to each element in the array or
 *  `null` if there are no elements. */
@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
inline fun <R : Comparable<R>> CharBuffer.maxOfOrNull(selector: (Char) -> R): R? {
    if (isEmpty()) return null
    var maxValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        if (maxValue < v)
            maxValue = v
    }
    return maxValue
}


/** Returns the largest value according to the provided [comparator] among all values produced by [selector] function
 *  applied to each element in the array.
 *  @throws NoSuchElementException if the array is empty. */
@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
inline fun <R> ByteBuffer.maxOfWith(comparator: Comparator<in R>, selector: (Byte) -> R): R {
    if (isEmpty()) throw NoSuchElementException()
    var maxValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        if (comparator.compare(maxValue, v) < 0)
            maxValue = v
    }
    return maxValue
}

/** Returns the largest value according to the provided [comparator] among all values produced by [selector] function
 *  applied to each element in the array.
 *  @throws NoSuchElementException if the array is empty. */
@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
inline fun <R> ShortBuffer.maxOfWith(comparator: Comparator<in R>, selector: (Short) -> R): R {
    if (isEmpty()) throw NoSuchElementException()
    var maxValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        if (comparator.compare(maxValue, v) < 0)
            maxValue = v
    }
    return maxValue
}

/** Returns the largest value according to the provided [comparator] among all values produced by [selector] function
 *  applied to each element in the array.
 *  @throws NoSuchElementException if the array is empty. */
@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
inline fun <R> IntBuffer.maxOfWith(comparator: Comparator<in R>, selector: (Int) -> R): R {
    if (isEmpty()) throw NoSuchElementException()
    var maxValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        if (comparator.compare(maxValue, v) < 0)
            maxValue = v
    }
    return maxValue
}

/** Returns the largest value according to the provided [comparator] among all values produced by [selector] function
 *  applied to each element in the array.
 *  @throws NoSuchElementException if the array is empty. */
@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
inline fun <R> LongBuffer.maxOfWith(comparator: Comparator<in R>, selector: (Long) -> R): R {
    if (isEmpty()) throw NoSuchElementException()
    var maxValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        if (comparator.compare(maxValue, v) < 0)
            maxValue = v
    }
    return maxValue
}

/** Returns the largest value according to the provided [comparator] among all values produced by [selector] function
 *  applied to each element in the array.
 *  @throws NoSuchElementException if the array is empty. */
@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
inline fun <R> FloatBuffer.maxOfWith(comparator: Comparator<in R>, selector: (Float) -> R): R {
    if (isEmpty()) throw NoSuchElementException()
    var maxValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        if (comparator.compare(maxValue, v) < 0)
            maxValue = v
    }
    return maxValue
}

/** Returns the largest value according to the provided [comparator] among all values produced by [selector] function
 *  applied to each element in the array.
 *  @throws NoSuchElementException if the array is empty. */
@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
inline fun <R> DoubleBuffer.maxOfWith(comparator: Comparator<in R>, selector: (Double) -> R): R {
    if (isEmpty()) throw NoSuchElementException()
    var maxValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        if (comparator.compare(maxValue, v) < 0)
            maxValue = v
    }
    return maxValue
}

/** Returns the largest value according to the provided [comparator] among all values produced by [selector] function
 *  applied to each element in the array.
 *  @throws NoSuchElementException if the array is empty. */
@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
inline fun <R> CharBuffer.maxOfWith(comparator: Comparator<in R>, selector: (Char) -> R): R {
    if (isEmpty()) throw NoSuchElementException()
    var maxValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        if (comparator.compare(maxValue, v) < 0)
            maxValue = v
    }
    return maxValue
}


/** Returns the largest value according to the provided [comparator] among all values produced by [selector] function
 *  applied to each element in the array or `null` if there are no elements. */
@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
inline fun <R> ByteBuffer.maxOfWithOrNull(comparator: Comparator<in R>, selector: (Byte) -> R): R? {
    if (isEmpty()) return null
    var maxValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        if (comparator.compare(maxValue, v) < 0)
            maxValue = v
    }
    return maxValue
}

/** Returns the largest value according to the provided [comparator] among all values produced by [selector] function
 *  applied to each element in the array or `null` if there are no elements. */
@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
inline fun <R> ShortBuffer.maxOfWithOrNull(comparator: Comparator<in R>, selector: (Short) -> R): R? {
    if (isEmpty()) return null
    var maxValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        if (comparator.compare(maxValue, v) < 0)
            maxValue = v
    }
    return maxValue
}

/** Returns the largest value according to the provided [comparator] among all values produced by [selector] function
 *  applied to each element in the array or `null` if there are no elements. */
@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
inline fun <R> IntBuffer.maxOfWithOrNull(comparator: Comparator<in R>, selector: (Int) -> R): R? {
    if (isEmpty()) return null
    var maxValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        if (comparator.compare(maxValue, v) < 0)
            maxValue = v
    }
    return maxValue
}

/** Returns the largest value according to the provided [comparator] among all values produced by [selector] function
 *  applied to each element in the array or `null` if there are no elements. */
@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
inline fun <R> LongBuffer.maxOfWithOrNull(comparator: Comparator<in R>, selector: (Long) -> R): R? {
    if (isEmpty()) return null
    var maxValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        if (comparator.compare(maxValue, v) < 0)
            maxValue = v
    }
    return maxValue
}

/** Returns the largest value according to the provided [comparator] among all values produced by [selector] function
 *  applied to each element in the array or `null` if there are no elements. */
@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
inline fun <R> FloatBuffer.maxOfWithOrNull(comparator: Comparator<in R>, selector: (Float) -> R): R? {
    if (isEmpty()) return null
    var maxValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        if (comparator.compare(maxValue, v) < 0)
            maxValue = v
    }
    return maxValue
}

/** Returns the largest value according to the provided [comparator] among all values produced by [selector] function
 *  applied to each element in the array or `null` if there are no elements. */
@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
inline fun <R> DoubleBuffer.maxOfWithOrNull(comparator: Comparator<in R>, selector: (Double) -> R): R? {
    if (isEmpty()) return null
    var maxValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        if (comparator.compare(maxValue, v) < 0)
            maxValue = v
    }
    return maxValue
}

/** Returns the largest value according to the provided [comparator] among all values produced by [selector] function
 *  applied to each element in the array or `null` if there are no elements. */
@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
inline fun <R> CharBuffer.maxOfWithOrNull(comparator: Comparator<in R>, selector: (Char) -> R): R? {
    if (isEmpty()) return null
    var maxValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        if (comparator.compare(maxValue, v) < 0)
            maxValue = v
    }
    return maxValue
}


/** Returns the largest element or `null` if there are no elements. */
fun ByteBuffer.maxOrNull(): Byte? {
    if (isEmpty()) return null
    var max = this[0]
    for (i in 1..lastIndex) {
        val e = this[i]
        if (max < e) max = e
    }
    return max
}

/** Returns the largest element or `null` if there are no elements. */
fun ShortBuffer.maxOrNull(): Short? {
    if (isEmpty()) return null
    var max = this[0]
    for (i in 1..lastIndex) {
        val e = this[i]
        if (max < e) max = e
    }
    return max
}

/** Returns the largest element or `null` if there are no elements. */
fun IntBuffer.maxOrNull(): Int? {
    if (isEmpty()) return null
    var max = this[0]
    for (i in 1..lastIndex) {
        val e = this[i]
        if (max < e) max = e
    }
    return max
}

/** Returns the largest element or `null` if there are no elements. */
fun LongBuffer.maxOrNull(): Long? {
    if (isEmpty()) return null
    var max = this[0]
    for (i in 1..lastIndex) {
        val e = this[i]
        if (max < e) max = e
    }
    return max
}

/**
 * Returns the largest element or `null` if there are no elements.
 * If any of elements is `NaN` returns `NaN`. */
fun FloatBuffer.maxOrNull(): Float? {
    if (isEmpty()) return null
    var max = this[0]
    for (i in 1..lastIndex) {
        val e = this[i]
        max = maxOf(max, e)
    }
    return max
}

/**
 * Returns the largest element or `null` if there are no elements.
 * If any of elements is `NaN` returns `NaN`. */
fun DoubleBuffer.maxOrNull(): Double? {
    if (isEmpty()) return null
    var max = this[0]
    for (i in 1..lastIndex) {
        val e = this[i]
        max = maxOf(max, e)
    }
    return max
}

/** Returns the largest element or `null` if there are no elements. */
fun CharBuffer.maxOrNull(): Char? {
    if (isEmpty()) return null
    var max = this[0]
    for (i in 1..lastIndex) {
        val e = this[i]
        if (max < e) max = e
    }
    return max
}


/** Returns the first element having the largest value according to the provided [comparator] or `null` if there are no elements. */
fun ByteBuffer.maxWithOrNull(comparator: Comparator<in Byte>): Byte? {
    if (isEmpty()) return null
    var max = this[0]
    for (i in 1..lastIndex) {
        val e = this[i]
        if (comparator.compare(max, e) < 0) max = e
    }
    return max
}

/** Returns the first element having the largest value according to the provided [comparator] or `null` if there are no elements. */
fun ShortBuffer.maxWithOrNull(comparator: Comparator<in Short>): Short? {
    if (isEmpty()) return null
    var max = this[0]
    for (i in 1..lastIndex) {
        val e = this[i]
        if (comparator.compare(max, e) < 0) max = e
    }
    return max
}

/** Returns the first element having the largest value according to the provided [comparator] or `null` if there are no elements. */
fun IntBuffer.maxWithOrNull(comparator: Comparator<in Int>): Int? {
    if (isEmpty()) return null
    var max = this[0]
    for (i in 1..lastIndex) {
        val e = this[i]
        if (comparator.compare(max, e) < 0) max = e
    }
    return max
}

/** Returns the first element having the largest value according to the provided [comparator] or `null` if there are no elements. */
fun LongBuffer.maxWithOrNull(comparator: Comparator<in Long>): Long? {
    if (isEmpty()) return null
    var max = this[0]
    for (i in 1..lastIndex) {
        val e = this[i]
        if (comparator.compare(max, e) < 0) max = e
    }
    return max
}

/** Returns the first element having the largest value according to the provided [comparator] or `null` if there are no elements. */
fun FloatBuffer.maxWithOrNull(comparator: Comparator<in Float>): Float? {
    if (isEmpty()) return null
    var max = this[0]
    for (i in 1..lastIndex) {
        val e = this[i]
        if (comparator.compare(max, e) < 0) max = e
    }
    return max
}

/** Returns the first element having the largest value according to the provided [comparator] or `null` if there are no elements. */
fun DoubleBuffer.maxWithOrNull(comparator: Comparator<in Double>): Double? {
    if (isEmpty()) return null
    var max = this[0]
    for (i in 1..lastIndex) {
        val e = this[i]
        if (comparator.compare(max, e) < 0) max = e
    }
    return max
}

/** Returns the first element having the largest value according to the provided [comparator] or `null` if there are no elements. */
fun CharBuffer.maxWithOrNull(comparator: Comparator<in Char>): Char? {
    if (isEmpty()) return null
    var max = this[0]
    for (i in 1..lastIndex) {
        val e = this[i]
        if (comparator.compare(max, e) < 0) max = e
    }
    return max
}


/** Returns the first element yielding the smallest value of the given function or `null` if there are no elements.
 *  @sample kool.buffers.Collections.Aggregates.minByOrNull */
inline fun <R : Comparable<R>> ByteBuffer.minByOrNull(selector: (Byte) -> R): Byte? {
    if (isEmpty()) return null
    var minElem = this[0]
    val lastIndex = this.lastIndex
    if (lastIndex == 0) return minElem
    var minValue = selector(minElem)
    for (i in 1..lastIndex) {
        val e = this[i]
        val v = selector(e)
        if (minValue > v) {
            minElem = e
            minValue = v
        }
    }
    return minElem
}

/** Returns the first element yielding the smallest value of the given function or `null` if there are no elements.
 *  @sample kool.buffers.Collections.Aggregates.minByOrNull */
inline fun <R : Comparable<R>> ShortBuffer.minByOrNull(selector: (Short) -> R): Short? {
    if (isEmpty()) return null
    var minElem = this[0]
    val lastIndex = this.lastIndex
    if (lastIndex == 0) return minElem
    var minValue = selector(minElem)
    for (i in 1..lastIndex) {
        val e = this[i]
        val v = selector(e)
        if (minValue > v) {
            minElem = e
            minValue = v
        }
    }
    return minElem
}

/** Returns the first element yielding the smallest value of the given function or `null` if there are no elements.
 *  @sample kool.buffers.Collections.Aggregates.minByOrNull */
inline fun <R : Comparable<R>> IntBuffer.minByOrNull(selector: (Int) -> R): Int? {
    if (isEmpty()) return null
    var minElem = this[0]
    val lastIndex = this.lastIndex
    if (lastIndex == 0) return minElem
    var minValue = selector(minElem)
    for (i in 1..lastIndex) {
        val e = this[i]
        val v = selector(e)
        if (minValue > v) {
            minElem = e
            minValue = v
        }
    }
    return minElem
}

/** Returns the first element yielding the smallest value of the given function or `null` if there are no elements.
 *  @sample kool.buffers.Collections.Aggregates.minByOrNull */
inline fun <R : Comparable<R>> LongBuffer.minByOrNull(selector: (Long) -> R): Long? {
    if (isEmpty()) return null
    var minElem = this[0]
    val lastIndex = this.lastIndex
    if (lastIndex == 0) return minElem
    var minValue = selector(minElem)
    for (i in 1..lastIndex) {
        val e = this[i]
        val v = selector(e)
        if (minValue > v) {
            minElem = e
            minValue = v
        }
    }
    return minElem
}

/** Returns the first element yielding the smallest value of the given function or `null` if there are no elements.
 *  @sample kool.buffers.Collections.Aggregates.minByOrNull */
inline fun <R : Comparable<R>> FloatBuffer.minByOrNull(selector: (Float) -> R): Float? {
    if (isEmpty()) return null
    var minElem = this[0]
    val lastIndex = this.lastIndex
    if (lastIndex == 0) return minElem
    var minValue = selector(minElem)
    for (i in 1..lastIndex) {
        val e = this[i]
        val v = selector(e)
        if (minValue > v) {
            minElem = e
            minValue = v
        }
    }
    return minElem
}

/** Returns the first element yielding the smallest value of the given function or `null` if there are no elements.
 *  @sample kool.buffers.Collections.Aggregates.minByOrNull */
inline fun <R : Comparable<R>> DoubleBuffer.minByOrNull(selector: (Double) -> R): Double? {
    if (isEmpty()) return null
    var minElem = this[0]
    val lastIndex = this.lastIndex
    if (lastIndex == 0) return minElem
    var minValue = selector(minElem)
    for (i in 1..lastIndex) {
        val e = this[i]
        val v = selector(e)
        if (minValue > v) {
            minElem = e
            minValue = v
        }
    }
    return minElem
}

/** Returns the first element yielding the smallest value of the given function or `null` if there are no elements.
 *  @sample kool.buffers.Collections.Aggregates.minByOrNull */
inline fun <R : Comparable<R>> CharBuffer.minByOrNull(selector: (Char) -> R): Char? {
    if (isEmpty()) return null
    var minElem = this[0]
    val lastIndex = this.lastIndex
    if (lastIndex == 0) return minElem
    var minValue = selector(minElem)
    for (i in 1..lastIndex) {
        val e = this[i]
        val v = selector(e)
        if (minValue > v) {
            minElem = e
            minValue = v
        }
    }
    return minElem
}


/**
 * Returns the smallest value among all values produced by [selector] function
 * applied to each element in the array.
 *
 * If any of values produced by [selector] function is `NaN`, the returned result is `NaN`.
 *
 * @throws NoSuchElementException if the array is empty.
 */
@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
inline fun ByteBuffer.minOf(selector: (Byte) -> Double): Double {
    if (isEmpty()) throw NoSuchElementException()
    var minValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        minValue = minOf(minValue, v)
    }
    return minValue
}

/**
 * Returns the smallest value among all values produced by [selector] function
 * applied to each element in the array.
 *
 * If any of values produced by [selector] function is `NaN`, the returned result is `NaN`.
 *
 * @throws NoSuchElementException if the array is empty.
 */
@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
inline fun ShortBuffer.minOf(selector: (Short) -> Double): Double {
    if (isEmpty()) throw NoSuchElementException()
    var minValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        minValue = minOf(minValue, v)
    }
    return minValue
}

/**
 * Returns the smallest value among all values produced by [selector] function
 * applied to each element in the array.
 *
 * If any of values produced by [selector] function is `NaN`, the returned result is `NaN`.
 *
 * @throws NoSuchElementException if the array is empty.
 */
@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
inline fun IntBuffer.minOf(selector: (Int) -> Double): Double {
    if (isEmpty()) throw NoSuchElementException()
    var minValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        minValue = minOf(minValue, v)
    }
    return minValue
}

/**
 * Returns the smallest value among all values produced by [selector] function
 * applied to each element in the array.
 *
 * If any of values produced by [selector] function is `NaN`, the returned result is `NaN`.
 *
 * @throws NoSuchElementException if the array is empty.
 */
@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
inline fun LongBuffer.minOf(selector: (Long) -> Double): Double {
    if (isEmpty()) throw NoSuchElementException()
    var minValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        minValue = minOf(minValue, v)
    }
    return minValue
}

/**
 * Returns the smallest value among all values produced by [selector] function
 * applied to each element in the array.
 *
 * If any of values produced by [selector] function is `NaN`, the returned result is `NaN`.
 *
 * @throws NoSuchElementException if the array is empty.
 */
@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
inline fun FloatBuffer.minOf(selector: (Float) -> Double): Double {
    if (isEmpty()) throw NoSuchElementException()
    var minValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        minValue = minOf(minValue, v)
    }
    return minValue
}

/**
 * Returns the smallest value among all values produced by [selector] function
 * applied to each element in the array.
 *
 * If any of values produced by [selector] function is `NaN`, the returned result is `NaN`.
 *
 * @throws NoSuchElementException if the array is empty.
 */
@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
inline fun DoubleBuffer.minOf(selector: (Double) -> Double): Double {
    if (isEmpty()) throw NoSuchElementException()
    var minValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        minValue = minOf(minValue, v)
    }
    return minValue
}

/**
 * Returns the smallest value among all values produced by [selector] function
 * applied to each element in the array.
 *
 * If any of values produced by [selector] function is `NaN`, the returned result is `NaN`.
 *
 * @throws NoSuchElementException if the array is empty.
 */
@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
inline fun CharBuffer.minOf(selector: (Char) -> Double): Double {
    if (isEmpty()) throw NoSuchElementException()
    var minValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        minValue = minOf(minValue, v)
    }
    return minValue
}


/**
 * Returns the smallest value among all values produced by [selector] function
 * applied to each element in the array.
 *
 * If any of values produced by [selector] function is `NaN`, the returned result is `NaN`.
 *
 * @throws NoSuchElementException if the array is empty.
 */
@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
inline fun ByteBuffer.minOf(selector: (Byte) -> Float): Float {
    if (isEmpty()) throw NoSuchElementException()
    var minValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        minValue = minOf(minValue, v)
    }
    return minValue
}

/**
 * Returns the smallest value among all values produced by [selector] function
 * applied to each element in the array.
 *
 * If any of values produced by [selector] function is `NaN`, the returned result is `NaN`.
 *
 * @throws NoSuchElementException if the array is empty.
 */
@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
inline fun ShortBuffer.minOf(selector: (Short) -> Float): Float {
    if (isEmpty()) throw NoSuchElementException()
    var minValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        minValue = minOf(minValue, v)
    }
    return minValue
}

/**
 * Returns the smallest value among all values produced by [selector] function
 * applied to each element in the array.
 *
 * If any of values produced by [selector] function is `NaN`, the returned result is `NaN`.
 *
 * @throws NoSuchElementException if the array is empty.
 */
@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
inline fun IntBuffer.minOf(selector: (Int) -> Float): Float {
    if (isEmpty()) throw NoSuchElementException()
    var minValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        minValue = minOf(minValue, v)
    }
    return minValue
}

/**
 * Returns the smallest value among all values produced by [selector] function
 * applied to each element in the array.
 *
 * If any of values produced by [selector] function is `NaN`, the returned result is `NaN`.
 *
 * @throws NoSuchElementException if the array is empty.
 */
@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
inline fun LongBuffer.minOf(selector: (Long) -> Float): Float {
    if (isEmpty()) throw NoSuchElementException()
    var minValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        minValue = minOf(minValue, v)
    }
    return minValue
}

/**
 * Returns the smallest value among all values produced by [selector] function
 * applied to each element in the array.
 *
 * If any of values produced by [selector] function is `NaN`, the returned result is `NaN`.
 *
 * @throws NoSuchElementException if the array is empty.
 */
@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
inline fun FloatBuffer.minOf(selector: (Float) -> Float): Float {
    if (isEmpty()) throw NoSuchElementException()
    var minValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        minValue = minOf(minValue, v)
    }
    return minValue
}

/**
 * Returns the smallest value among all values produced by [selector] function
 * applied to each element in the array.
 *
 * If any of values produced by [selector] function is `NaN`, the returned result is `NaN`.
 *
 * @throws NoSuchElementException if the array is empty.
 */
@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
inline fun DoubleBuffer.minOf(selector: (Double) -> Float): Float {
    if (isEmpty()) throw NoSuchElementException()
    var minValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        minValue = minOf(minValue, v)
    }
    return minValue
}

/**
 * Returns the smallest value among all values produced by [selector] function
 * applied to each element in the array.
 *
 * If any of values produced by [selector] function is `NaN`, the returned result is `NaN`.
 *
 * @throws NoSuchElementException if the array is empty.
 */
@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
inline fun CharBuffer.minOf(selector: (Char) -> Float): Float {
    if (isEmpty()) throw NoSuchElementException()
    var minValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        minValue = minOf(minValue, v)
    }
    return minValue
}


/**
 * Returns the smallest value among all values produced by [selector] function
 * applied to each element in the array.
 *
 * @throws NoSuchElementException if the array is empty.
 */
@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
inline fun <R : Comparable<R>> ByteBuffer.minOf(selector: (Byte) -> R): R {
    if (isEmpty()) throw NoSuchElementException()
    var minValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        if (minValue > v)
            minValue = v
    }
    return minValue
}

/**
 * Returns the smallest value among all values produced by [selector] function
 * applied to each element in the array.
 *
 * @throws NoSuchElementException if the array is empty.
 */
@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
inline fun <R : Comparable<R>> ShortBuffer.minOf(selector: (Short) -> R): R {
    if (isEmpty()) throw NoSuchElementException()
    var minValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        if (minValue > v)
            minValue = v
    }
    return minValue
}

/**
 * Returns the smallest value among all values produced by [selector] function
 * applied to each element in the array.
 *
 * @throws NoSuchElementException if the array is empty.
 */
@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
inline fun <R : Comparable<R>> IntBuffer.minOf(selector: (Int) -> R): R {
    if (isEmpty()) throw NoSuchElementException()
    var minValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        if (minValue > v)
            minValue = v
    }
    return minValue
}

/**
 * Returns the smallest value among all values produced by [selector] function
 * applied to each element in the array.
 *
 * @throws NoSuchElementException if the array is empty.
 */
@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
inline fun <R : Comparable<R>> LongBuffer.minOf(selector: (Long) -> R): R {
    if (isEmpty()) throw NoSuchElementException()
    var minValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        if (minValue > v)
            minValue = v
    }
    return minValue
}

/**
 * Returns the smallest value among all values produced by [selector] function
 * applied to each element in the array.
 *
 * @throws NoSuchElementException if the array is empty.
 */
@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
inline fun <R : Comparable<R>> FloatBuffer.minOf(selector: (Float) -> R): R {
    if (isEmpty()) throw NoSuchElementException()
    var minValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        if (minValue > v)
            minValue = v
    }
    return minValue
}

/**
 * Returns the smallest value among all values produced by [selector] function
 * applied to each element in the array.
 *
 * @throws NoSuchElementException if the array is empty.
 */
@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
inline fun <R : Comparable<R>> DoubleBuffer.minOf(selector: (Double) -> R): R {
    if (isEmpty()) throw NoSuchElementException()
    var minValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        if (minValue > v)
            minValue = v
    }
    return minValue
}

/**
 * Returns the smallest value among all values produced by [selector] function
 * applied to each element in the array.
 *
 * @throws NoSuchElementException if the array is empty.
 */
@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
inline fun <R : Comparable<R>> CharBuffer.minOf(selector: (Char) -> R): R {
    if (isEmpty()) throw NoSuchElementException()
    var minValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        if (minValue > v)
            minValue = v
    }
    return minValue
}


/** Returns the smallest value among all values produced by [selector] function applied to each element in the array or
 *  `null` if there are no elements.
 *  If any of values produced by [selector] function is `NaN`, the returned result is `NaN`. */
@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
inline fun ByteBuffer.minOfOrNull(selector: (Byte) -> Double): Double? {
    if (isEmpty()) return null
    var minValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        minValue = minOf(minValue, v)
    }
    return minValue
}

/** Returns the smallest value among all values produced by [selector] function applied to each element in the array or
 *  `null` if there are no elements.
 *  If any of values produced by [selector] function is `NaN`, the returned result is `NaN`. */
@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
inline fun ShortBuffer.minOfOrNull(selector: (Short) -> Double): Double? {
    if (isEmpty()) return null
    var minValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        minValue = minOf(minValue, v)
    }
    return minValue
}

/** Returns the smallest value among all values produced by [selector] function applied to each element in the array or
 *  `null` if there are no elements.
 *  If any of values produced by [selector] function is `NaN`, the returned result is `NaN`. */
@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
inline fun IntBuffer.minOfOrNull(selector: (Int) -> Double): Double? {
    if (isEmpty()) return null
    var minValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        minValue = minOf(minValue, v)
    }
    return minValue
}

/** Returns the smallest value among all values produced by [selector] function applied to each element in the array or
 *  `null` if there are no elements.
 *  If any of values produced by [selector] function is `NaN`, the returned result is `NaN`. */
@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
inline fun LongBuffer.minOfOrNull(selector: (Long) -> Double): Double? {
    if (isEmpty()) return null
    var minValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        minValue = minOf(minValue, v)
    }
    return minValue
}

/** Returns the smallest value among all values produced by [selector] function applied to each element in the array or
 *  `null` if there are no elements.
 *  If any of values produced by [selector] function is `NaN`, the returned result is `NaN`. */
@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
inline fun FloatBuffer.minOfOrNull(selector: (Float) -> Double): Double? {
    if (isEmpty()) return null
    var minValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        minValue = minOf(minValue, v)
    }
    return minValue
}

/** Returns the smallest value among all values produced by [selector] function applied to each element in the array or
 *  `null` if there are no elements.
 *  If any of values produced by [selector] function is `NaN`, the returned result is `NaN`. */
@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
inline fun DoubleBuffer.minOfOrNull(selector: (Double) -> Double): Double? {
    if (isEmpty()) return null
    var minValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        minValue = minOf(minValue, v)
    }
    return minValue
}

/** Returns the smallest value among all values produced by [selector] function applied to each element in the array or
 *  `null` if there are no elements.
 *  If any of values produced by [selector] function is `NaN`, the returned result is `NaN`. */
@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
inline fun CharBuffer.minOfOrNull(selector: (Char) -> Double): Double? {
    if (isEmpty()) return null
    var minValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        minValue = minOf(minValue, v)
    }
    return minValue
}


/** Returns the smallest value among all values produced by [selector] function
 *  applied to each element in the array or `null` if there are no elements.
 *  If any of values produced by [selector] function is `NaN`, the returned result is `NaN`. */
@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
inline fun ByteBuffer.minOfOrNull(selector: (Byte) -> Float): Float? {
    if (isEmpty()) return null
    var minValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        minValue = minOf(minValue, v)
    }
    return minValue
}

/** Returns the smallest value among all values produced by [selector] function
 *  applied to each element in the array or `null` if there are no elements.
 *  If any of values produced by [selector] function is `NaN`, the returned result is `NaN`. */
@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
inline fun ShortBuffer.minOfOrNull(selector: (Short) -> Float): Float? {
    if (isEmpty()) return null
    var minValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        minValue = minOf(minValue, v)
    }
    return minValue
}

/** Returns the smallest value among all values produced by [selector] function
 *  applied to each element in the array or `null` if there are no elements.
 *  If any of values produced by [selector] function is `NaN`, the returned result is `NaN`. */
@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
inline fun IntBuffer.minOfOrNull(selector: (Int) -> Float): Float? {
    if (isEmpty()) return null
    var minValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        minValue = minOf(minValue, v)
    }
    return minValue
}

/** Returns the smallest value among all values produced by [selector] function
 *  applied to each element in the array or `null` if there are no elements.
 *  If any of values produced by [selector] function is `NaN`, the returned result is `NaN`. */
@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
inline fun LongBuffer.minOfOrNull(selector: (Long) -> Float): Float? {
    if (isEmpty()) return null
    var minValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        minValue = minOf(minValue, v)
    }
    return minValue
}

/** Returns the smallest value among all values produced by [selector] function
 *  applied to each element in the array or `null` if there are no elements.
 *  If any of values produced by [selector] function is `NaN`, the returned result is `NaN`. */
@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
inline fun FloatBuffer.minOfOrNull(selector: (Float) -> Float): Float? {
    if (isEmpty()) return null
    var minValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        minValue = minOf(minValue, v)
    }
    return minValue
}

/** Returns the smallest value among all values produced by [selector] function
 *  applied to each element in the array or `null` if there are no elements.
 *  If any of values produced by [selector] function is `NaN`, the returned result is `NaN`. */
@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
inline fun DoubleBuffer.minOfOrNull(selector: (Double) -> Float): Float? {
    if (isEmpty()) return null
    var minValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        minValue = minOf(minValue, v)
    }
    return minValue
}

/** Returns the smallest value among all values produced by [selector] function
 *  applied to each element in the array or `null` if there are no elements.
 *  If any of values produced by [selector] function is `NaN`, the returned result is `NaN`. */
@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
inline fun CharBuffer.minOfOrNull(selector: (Char) -> Float): Float? {
    if (isEmpty()) return null
    var minValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        minValue = minOf(minValue, v)
    }
    return minValue
}


/** Returns the smallest value among all values produced by [selector] function
 *  applied to each element in the array or `null` if there are no elements. */
@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
inline fun <R : Comparable<R>> ByteBuffer.minOfOrNull(selector: (Byte) -> R): R? {
    if (isEmpty()) return null
    var minValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        if (minValue > v)
            minValue = v
    }
    return minValue
}

/** Returns the smallest value among all values produced by [selector] function
 *  applied to each element in the array or `null` if there are no elements. */
@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
inline fun <R : Comparable<R>> ShortBuffer.minOfOrNull(selector: (Short) -> R): R? {
    if (isEmpty()) return null
    var minValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        if (minValue > v)
            minValue = v
    }
    return minValue
}

/** Returns the smallest value among all values produced by [selector] function
 *  applied to each element in the array or `null` if there are no elements. */
@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
inline fun <R : Comparable<R>> IntBuffer.minOfOrNull(selector: (Int) -> R): R? {
    if (isEmpty()) return null
    var minValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        if (minValue > v)
            minValue = v
    }
    return minValue
}

/** Returns the smallest value among all values produced by [selector] function
 *  applied to each element in the array or `null` if there are no elements. */
@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
inline fun <R : Comparable<R>> LongBuffer.minOfOrNull(selector: (Long) -> R): R? {
    if (isEmpty()) return null
    var minValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        if (minValue > v)
            minValue = v
    }
    return minValue
}

/** Returns the smallest value among all values produced by [selector] function
 *  applied to each element in the array or `null` if there are no elements. */
@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
inline fun <R : Comparable<R>> FloatBuffer.minOfOrNull(selector: (Float) -> R): R? {
    if (isEmpty()) return null
    var minValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        if (minValue > v)
            minValue = v
    }
    return minValue
}

/** Returns the smallest value among all values produced by [selector] function
 *  applied to each element in the array or `null` if there are no elements. */
@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
inline fun <R : Comparable<R>> DoubleBuffer.minOfOrNull(selector: (Double) -> R): R? {
    if (isEmpty()) return null
    var minValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        if (minValue > v)
            minValue = v
    }
    return minValue
}

/** Returns the smallest value among all values produced by [selector] function
 *  applied to each element in the array or `null` if there are no elements. */
@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
inline fun <R : Comparable<R>> CharBuffer.minOfOrNull(selector: (Char) -> R): R? {
    if (isEmpty()) return null
    var minValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        if (minValue > v)
            minValue = v
    }
    return minValue
}


/** Returns the smallest value according to the provided [comparator]
 *  among all values produced by [selector] function applied to each element in the array.
 *  @throws NoSuchElementException if the array is empty. */
@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
inline fun <R> ByteBuffer.minOfWith(comparator: Comparator<in R>, selector: (Byte) -> R): R {
    if (isEmpty()) throw NoSuchElementException()
    var minValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        if (comparator.compare(minValue, v) > 0)
            minValue = v
    }
    return minValue
}

/** Returns the smallest value according to the provided [comparator]
 *  among all values produced by [selector] function applied to each element in the array.
 *  @throws NoSuchElementException if the array is empty. */
@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
inline fun <R> ShortBuffer.minOfWith(comparator: Comparator<in R>, selector: (Short) -> R): R {
    if (isEmpty()) throw NoSuchElementException()
    var minValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        if (comparator.compare(minValue, v) > 0)
            minValue = v
    }
    return minValue
}

/** Returns the smallest value according to the provided [comparator]
 *  among all values produced by [selector] function applied to each element in the array.
 *  @throws NoSuchElementException if the array is empty. */
@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
inline fun <R> IntBuffer.minOfWith(comparator: Comparator<in R>, selector: (Int) -> R): R {
    if (isEmpty()) throw NoSuchElementException()
    var minValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        if (comparator.compare(minValue, v) > 0)
            minValue = v
    }
    return minValue
}

/** Returns the smallest value according to the provided [comparator]
 *  among all values produced by [selector] function applied to each element in the array.
 *  @throws NoSuchElementException if the array is empty. */
@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
inline fun <R> LongBuffer.minOfWith(comparator: Comparator<in R>, selector: (Long) -> R): R {
    if (isEmpty()) throw NoSuchElementException()
    var minValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        if (comparator.compare(minValue, v) > 0)
            minValue = v
    }
    return minValue
}

/** Returns the smallest value according to the provided [comparator]
 *  among all values produced by [selector] function applied to each element in the array.
 *  @throws NoSuchElementException if the array is empty. */
@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
inline fun <R> FloatBuffer.minOfWith(comparator: Comparator<in R>, selector: (Float) -> R): R {
    if (isEmpty()) throw NoSuchElementException()
    var minValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        if (comparator.compare(minValue, v) > 0)
            minValue = v
    }
    return minValue
}

/** Returns the smallest value according to the provided [comparator]
 *  among all values produced by [selector] function applied to each element in the array.
 *  @throws NoSuchElementException if the array is empty. */
@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
inline fun <R> DoubleBuffer.minOfWith(comparator: Comparator<in R>, selector: (Double) -> R): R {
    if (isEmpty()) throw NoSuchElementException()
    var minValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        if (comparator.compare(minValue, v) > 0)
            minValue = v
    }
    return minValue
}

/** Returns the smallest value according to the provided [comparator]
 *  among all values produced by [selector] function applied to each element in the array.
 *  @throws NoSuchElementException if the array is empty. */
@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
inline fun <R> CharBuffer.minOfWith(comparator: Comparator<in R>, selector: (Char) -> R): R {
    if (isEmpty()) throw NoSuchElementException()
    var minValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        if (comparator.compare(minValue, v) > 0)
            minValue = v
    }
    return minValue
}


/** Returns the smallest value according to the provided [comparator] among all values produced by [selector] function
 *  applied to each element in the array or `null` if there are no elements. */
@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
inline fun <R> ByteBuffer.minOfWithOrNull(comparator: Comparator<in R>, selector: (Byte) -> R): R? {
    if (isEmpty()) return null
    var minValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        if (comparator.compare(minValue, v) > 0)
            minValue = v
    }
    return minValue
}

/** Returns the smallest value according to the provided [comparator] among all values produced by [selector] function
 *  applied to each element in the array or `null` if there are no elements. */
@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
inline fun <R> ShortBuffer.minOfWithOrNull(comparator: Comparator<in R>, selector: (Short) -> R): R? {
    if (isEmpty()) return null
    var minValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        if (comparator.compare(minValue, v) > 0)
            minValue = v
    }
    return minValue
}

/** Returns the smallest value according to the provided [comparator] among all values produced by [selector] function
 *  applied to each element in the array or `null` if there are no elements. */
@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
inline fun <R> IntBuffer.minOfWithOrNull(comparator: Comparator<in R>, selector: (Int) -> R): R? {
    if (isEmpty()) return null
    var minValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        if (comparator.compare(minValue, v) > 0)
            minValue = v
    }
    return minValue
}

/** Returns the smallest value according to the provided [comparator] among all values produced by [selector] function
 *  applied to each element in the array or `null` if there are no elements. */
@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
inline fun <R> LongBuffer.minOfWithOrNull(comparator: Comparator<in R>, selector: (Long) -> R): R? {
    if (isEmpty()) return null
    var minValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        if (comparator.compare(minValue, v) > 0)
            minValue = v
    }
    return minValue
}

/** Returns the smallest value according to the provided [comparator] among all values produced by [selector] function
 *  applied to each element in the array or `null` if there are no elements. */
@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
inline fun <R> FloatBuffer.minOfWithOrNull(comparator: Comparator<in R>, selector: (Float) -> R): R? {
    if (isEmpty()) return null
    var minValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        if (comparator.compare(minValue, v) > 0)
            minValue = v
    }
    return minValue
}

/** Returns the smallest value according to the provided [comparator] among all values produced by [selector] function
 *  applied to each element in the array or `null` if there are no elements. */
@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
inline fun <R> DoubleBuffer.minOfWithOrNull(comparator: Comparator<in R>, selector: (Double) -> R): R? {
    if (isEmpty()) return null
    var minValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        if (comparator.compare(minValue, v) > 0)
            minValue = v
    }
    return minValue
}

/** Returns the smallest value according to the provided [comparator] among all values produced by [selector] function
 *  applied to each element in the array or `null` if there are no elements. */
@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
inline fun <R> CharBuffer.minOfWithOrNull(comparator: Comparator<in R>, selector: (Char) -> R): R? {
    if (isEmpty()) return null
    var minValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        if (comparator.compare(minValue, v) > 0)
            minValue = v
    }
    return minValue
}


/** Returns the smallest element or `null` if there are no elements. */
fun ByteArray.minOrNull(): Byte? {
    if (isEmpty()) return null
    var min = this[0]
    for (i in 1..lastIndex) {
        val e = this[i]
        if (min > e) min = e
    }
    return min
}

/** Returns the smallest element or `null` if there are no elements. */
fun ShortArray.minOrNull(): Short? {
    if (isEmpty()) return null
    var min = this[0]
    for (i in 1..lastIndex) {
        val e = this[i]
        if (min > e) min = e
    }
    return min
}

/** Returns the smallest element or `null` if there are no elements. */
fun IntArray.minOrNull(): Int? {
    if (isEmpty()) return null
    var min = this[0]
    for (i in 1..lastIndex) {
        val e = this[i]
        if (min > e) min = e
    }
    return min
}

/** Returns the smallest element or `null` if there are no elements. */
fun LongArray.minOrNull(): Long? {
    if (isEmpty()) return null
    var min = this[0]
    for (i in 1..lastIndex) {
        val e = this[i]
        if (min > e) min = e
    }
    return min
}

/**
 * Returns the smallest element or `null` if there are no elements.
 * If any of elements is `NaN` returns `NaN`. */
fun FloatArray.minOrNull(): Float? {
    if (isEmpty()) return null
    var min = this[0]
    for (i in 1..lastIndex) {
        val e = this[i]
        min = minOf(min, e)
    }
    return min
}

/**
 * Returns the smallest element or `null` if there are no elements.
 * If any of elements is `NaN` returns `NaN`. */
fun DoubleArray.minOrNull(): Double? {
    if (isEmpty()) return null
    var min = this[0]
    for (i in 1..lastIndex) {
        val e = this[i]
        min = minOf(min, e)
    }
    return min
}

/** Returns the smallest element or `null` if there are no elements. */
fun CharArray.minOrNull(): Char? {
    if (isEmpty()) return null
    var min = this[0]
    for (i in 1..lastIndex) {
        val e = this[i]
        if (min > e) min = e
    }
    return min
}


/** Returns the first element having the smallest value according to the provided [comparator] or `null` if there are no elements. */
fun ByteBuffer.minWithOrNull(comparator: Comparator<in Byte>): Byte? {
    if (isEmpty()) return null
    var min = this[0]
    for (i in 1..lastIndex) {
        val e = this[i]
        if (comparator.compare(min, e) > 0) min = e
    }
    return min
}

/** Returns the first element having the smallest value according to the provided [comparator] or `null` if there are no elements. */
fun ShortBuffer.minWithOrNull(comparator: Comparator<in Short>): Short? {
    if (isEmpty()) return null
    var min = this[0]
    for (i in 1..lastIndex) {
        val e = this[i]
        if (comparator.compare(min, e) > 0) min = e
    }
    return min
}

/** Returns the first element having the smallest value according to the provided [comparator] or `null` if there are no elements. */
fun IntBuffer.minWithOrNull(comparator: Comparator<in Int>): Int? {
    if (isEmpty()) return null
    var min = this[0]
    for (i in 1..lastIndex) {
        val e = this[i]
        if (comparator.compare(min, e) > 0) min = e
    }
    return min
}

/** Returns the first element having the smallest value according to the provided [comparator] or `null` if there are no elements. */
fun LongBuffer.minWithOrNull(comparator: Comparator<in Long>): Long? {
    if (isEmpty()) return null
    var min = this[0]
    for (i in 1..lastIndex) {
        val e = this[i]
        if (comparator.compare(min, e) > 0) min = e
    }
    return min
}

/** Returns the first element having the smallest value according to the provided [comparator] or `null` if there are no elements. */
fun FloatBuffer.minWithOrNull(comparator: Comparator<in Float>): Float? {
    if (isEmpty()) return null
    var min = this[0]
    for (i in 1..lastIndex) {
        val e = this[i]
        if (comparator.compare(min, e) > 0) min = e
    }
    return min
}

/** Returns the first element having the smallest value according to the provided [comparator] or `null` if there are no elements. */
fun DoubleBuffer.minWithOrNull(comparator: Comparator<in Double>): Double? {
    if (isEmpty()) return null
    var min = this[0]
    for (i in 1..lastIndex) {
        val e = this[i]
        if (comparator.compare(min, e) > 0) min = e
    }
    return min
}

/** Returns the first element having the smallest value according to the provided [comparator] or `null` if there are no elements. */
fun CharBuffer.minWithOrNull(comparator: Comparator<in Char>): Char? {
    if (isEmpty()) return null
    var min = this[0]
    for (i in 1..lastIndex) {
        val e = this[i]
        if (comparator.compare(min, e) > 0) min = e
    }
    return min
}

/** Returns `true` if the buffer has no elements. */
fun ByteBuffer.none(): Boolean = isEmpty()

/** Returns `true` if the buffer has no elements. */
fun ShortBuffer.none(): Boolean = isEmpty()

/** Returns `true` if the buffer has no elements. */
fun IntBuffer.none(): Boolean = isEmpty()

/** Returns `true` if the buffer has no elements. */
fun LongBuffer.none(): Boolean = isEmpty()

/** Returns `true` if the buffer has no elements. */
fun FloatBuffer.none(): Boolean = isEmpty()

/** Returns `true` if the buffer has no elements. */
fun DoubleBuffer.none(): Boolean = isEmpty()

/** Returns `true` if the buffer has no elements. */
fun CharBuffer.none(): Boolean = isEmpty()


/** Returns `true` if no elements match the given [predicate]. */
inline fun ByteBuffer.none(predicate: (Byte) -> Boolean): Boolean {
    for (element in this) if (predicate(element)) return false
    return true
}

/** Returns `true` if no elements match the given [predicate]. */
inline fun ShortBuffer.none(predicate: (Short) -> Boolean): Boolean {
    for (element in this) if (predicate(element)) return false
    return true
}

/** Returns `true` if no elements match the given [predicate]. */
inline fun IntBuffer.none(predicate: (Int) -> Boolean): Boolean {
    for (element in this) if (predicate(element)) return false
    return true
}

/** Returns `true` if no elements match the given [predicate]. */
inline fun LongBuffer.none(predicate: (Long) -> Boolean): Boolean {
    for (element in this) if (predicate(element)) return false
    return true
}

/** Returns `true` if no elements match the given [predicate]. */
inline fun FloatBuffer.none(predicate: (Float) -> Boolean): Boolean {
    for (element in this) if (predicate(element)) return false
    return true
}

/** Returns `true` if no elements match the given [predicate]. */
inline fun DoubleBuffer.none(predicate: (Double) -> Boolean): Boolean {
    for (element in this) if (predicate(element)) return false
    return true
}

/** Returns `true` if no elements match the given [predicate]. */
inline fun CharBuffer.none(predicate: (Char) -> Boolean): Boolean {
    for (element in this) if (predicate(element)) return false
    return true
}


/** Performs the given [action] on each element and returns the array itself afterwards. */
inline fun ByteBuffer.onEach(action: (Byte) -> Unit): ByteBuffer = apply { for (element in this) action(element) }

/** Performs the given [action] on each element and returns the array itself afterwards. */
inline fun ShortBuffer.onEach(action: (Short) -> Unit): ShortBuffer = apply { for (element in this) action(element) }

/** Performs the given [action] on each element and returns the array itself afterwards. */
inline fun IntBuffer.onEach(action: (Int) -> Unit): IntBuffer = apply { for (element in this) action(element) }

/** Performs the given [action] on each element and returns the array itself afterwards. */
inline fun LongBuffer.onEach(action: (Long) -> Unit): LongBuffer = apply { for (element in this) action(element) }

/** Performs the given [action] on each element and returns the array itself afterwards. */
inline fun FloatBuffer.onEach(action: (Float) -> Unit): FloatBuffer = apply { for (element in this) action(element) }

/** Performs the given [action] on each element and returns the array itself afterwards. */
inline fun DoubleBuffer.onEach(action: (Double) -> Unit): DoubleBuffer = apply { for (element in this) action(element) }

/** Performs the given [action] on each element and returns the array itself afterwards. */
inline fun CharBuffer.onEach(action: (Char) -> Unit): CharBuffer = apply { for (element in this) action(element) }


/** Performs the given [action] on each element, providing sequential index with the element,
 *  and returns the array itself afterwards.
 *  @param [action] function that takes the index of an element and the element itself
 *  and performs the action on the element. */
inline fun ByteBuffer.onEachIndexed(action: (index: Int, Byte) -> Unit): ByteBuffer = apply { forEachIndexed(action) }

/** Performs the given [action] on each element, providing sequential index with the element,
 *  and returns the array itself afterwards.
 *  @param [action] function that takes the index of an element and the element itself
 *  and performs the action on the element. */
inline fun ShortBuffer.onEachIndexed(action: (index: Int, Short) -> Unit): ShortBuffer = apply { forEachIndexed(action) }

/** Performs the given [action] on each element, providing sequential index with the element,
 *  and returns the array itself afterwards.
 *  @param [action] function that takes the index of an element and the element itself
 *  and performs the action on the element. */
inline fun IntBuffer.onEachIndexed(action: (index: Int, Int) -> Unit): IntBuffer = apply { forEachIndexed(action) }

/** Performs the given [action] on each element, providing sequential index with the element,
 *  and returns the array itself afterwards.
 *  @param [action] function that takes the index of an element and the element itself
 *  and performs the action on the element. */
inline fun LongBuffer.onEachIndexed(action: (index: Int, Long) -> Unit): LongBuffer = apply { forEachIndexed(action) }

/** Performs the given [action] on each element, providing sequential index with the element,
 *  and returns the array itself afterwards.
 *  @param [action] function that takes the index of an element and the element itself
 *  and performs the action on the element. */
inline fun FloatBuffer.onEachIndexed(action: (index: Int, Float) -> Unit): FloatBuffer = apply { forEachIndexed(action) }

/** Performs the given [action] on each element, providing sequential index with the element,
 *  and returns the array itself afterwards.
 *  @param [action] function that takes the index of an element and the element itself
 *  and performs the action on the element. */
inline fun DoubleBuffer.onEachIndexed(action: (index: Int, Double) -> Unit): DoubleBuffer = apply { forEachIndexed(action) }

/** Performs the given [action] on each element, providing sequential index with the element,
 *  and returns the array itself afterwards.
 *  @param [action] function that takes the index of an element and the element itself
 *  and performs the action on the element. */
inline fun CharBuffer.onEachIndexed(action: (index: Int, Char) -> Unit): CharBuffer = apply { forEachIndexed(action) }


/**
 * Accumulates value starting with the first element and applying [operation] from left to right
 * to current accumulator value and each element.
 *
 * Throws an exception if this array is empty. If the array can be empty in an expected way,
 * please use [reduceOrNull] instead. It returns `null` when its receiver is empty.
 *
 * @param [operation] function that takes current accumulator value and an element,
 * and calculates the next accumulator value.
 *
 * @sample kool.buffers.Collections.Aggregates.reduce
 */
inline fun ByteBuffer.reduce(operation: (acc: Byte, Byte) -> Byte): Byte {
    if (isEmpty())
        throw UnsupportedOperationException("Empty array can't be reduced.")
    var accumulator = this[0]
    for (index in 1..lastIndex)
        accumulator = operation(accumulator, this[index])
    return accumulator
}

/**
 * Accumulates value starting with the first element and applying [operation] from left to right
 * to current accumulator value and each element.
 *
 * Throws an exception if this array is empty. If the array can be empty in an expected way,
 * please use [reduceOrNull] instead. It returns `null` when its receiver is empty.
 *
 * @param [operation] function that takes current accumulator value and an element,
 * and calculates the next accumulator value.
 *
 * @sample kool.buffers.Collections.Aggregates.reduce
 */
inline fun ShortBuffer.reduce(operation: (acc: Short, Short) -> Short): Short {
    if (isEmpty())
        throw UnsupportedOperationException("Empty array can't be reduced.")
    var accumulator = this[0]
    for (index in 1..lastIndex)
        accumulator = operation(accumulator, this[index])
    return accumulator
}

/**
 * Accumulates value starting with the first element and applying [operation] from left to right
 * to current accumulator value and each element.
 *
 * Throws an exception if this array is empty. If the array can be empty in an expected way,
 * please use [reduceOrNull] instead. It returns `null` when its receiver is empty.
 *
 * @param [operation] function that takes current accumulator value and an element,
 * and calculates the next accumulator value.
 *
 * @sample kool.buffers.Collections.Aggregates.reduce
 */
inline fun IntBuffer.reduce(operation: (acc: Int, Int) -> Int): Int {
    if (isEmpty())
        throw UnsupportedOperationException("Empty array can't be reduced.")
    var accumulator = this[0]
    for (index in 1..lastIndex)
        accumulator = operation(accumulator, this[index])
    return accumulator
}

/**
 * Accumulates value starting with the first element and applying [operation] from left to right
 * to current accumulator value and each element.
 *
 * Throws an exception if this array is empty. If the array can be empty in an expected way,
 * please use [reduceOrNull] instead. It returns `null` when its receiver is empty.
 *
 * @param [operation] function that takes current accumulator value and an element,
 * and calculates the next accumulator value.
 *
 * @sample kool.buffers.Collections.Aggregates.reduce
 */
inline fun LongBuffer.reduce(operation: (acc: Long, Long) -> Long): Long {
    if (isEmpty())
        throw UnsupportedOperationException("Empty array can't be reduced.")
    var accumulator = this[0]
    for (index in 1..lastIndex)
        accumulator = operation(accumulator, this[index])
    return accumulator
}

/**
 * Accumulates value starting with the first element and applying [operation] from left to right
 * to current accumulator value and each element.
 *
 * Throws an exception if this array is empty. If the array can be empty in an expected way,
 * please use [reduceOrNull] instead. It returns `null` when its receiver is empty.
 *
 * @param [operation] function that takes current accumulator value and an element,
 * and calculates the next accumulator value.
 *
 * @sample kool.buffers.Collections.Aggregates.reduce
 */
inline fun FloatBuffer.reduce(operation: (acc: Float, Float) -> Float): Float {
    if (isEmpty())
        throw UnsupportedOperationException("Empty array can't be reduced.")
    var accumulator = this[0]
    for (index in 1..lastIndex)
        accumulator = operation(accumulator, this[index])
    return accumulator
}

/**
 * Accumulates value starting with the first element and applying [operation] from left to right
 * to current accumulator value and each element.
 *
 * Throws an exception if this array is empty. If the array can be empty in an expected way,
 * please use [reduceOrNull] instead. It returns `null` when its receiver is empty.
 *
 * @param [operation] function that takes current accumulator value and an element,
 * and calculates the next accumulator value.
 *
 * @sample kool.buffers.Collections.Aggregates.reduce
 */
inline fun DoubleBuffer.reduce(operation: (acc: Double, Double) -> Double): Double {
    if (isEmpty())
        throw UnsupportedOperationException("Empty array can't be reduced.")
    var accumulator = this[0]
    for (index in 1..lastIndex)
        accumulator = operation(accumulator, this[index])
    return accumulator
}

/**
 * Accumulates value starting with the first element and applying [operation] from left to right
 * to current accumulator value and each element.
 *
 * Throws an exception if this array is empty. If the array can be empty in an expected way,
 * please use [reduceOrNull] instead. It returns `null` when its receiver is empty.
 *
 * @param [operation] function that takes current accumulator value and an element,
 * and calculates the next accumulator value.
 *
 * @sample kool.buffers.Collections.Aggregates.reduce
 */
public inline fun CharArray.reduce(operation: (acc: Char, Char) -> Char): Char {
    if (isEmpty())
        throw UnsupportedOperationException("Empty array can't be reduced.")
    var accumulator = this[0]
    for (index in 1..lastIndex) {
        accumulator = operation(accumulator, this[index])
    }
    return accumulator
}