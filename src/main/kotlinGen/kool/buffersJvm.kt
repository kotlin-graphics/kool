@file:Suppress("NOTHING_TO_INLINE")
@file:OptIn(kotlin.experimental.ExperimentalTypeInference::class, kotlin.ExperimentalUnsignedTypes::class)
package kool

import kool.ubuffers.UByteBuffer
import java.nio.LongBuffer
import kool.ubuffers.UShortBuffer
import kool.ubuffers.ULongBuffer
import kool.lib.mapCapacity
import kool.set
import java.nio.IntBuffer
import java.nio.ByteBuffer
import kool.rem
import org.lwjgl.PointerBuffer
import kool.iterator
import java.nio.ShortBuffer
import java.nio.DoubleBuffer
import java.nio.FloatBuffer
import java.nio.CharBuffer
import kool.lib.collectionSizeOrDefault
import kool.ubuffers.UIntBuffer

/**
 * Returns 1st *element* from the buffer.
 * 
 * If the size of this array is less than 1, throws an [IndexOutOfBoundsException]
 */
inline operator fun CharBuffer.component1(): Char = get(0)
/**
 * Returns 2nd *element* from the buffer.
 * 
 * If the size of this array is less than 2, throws an [IndexOutOfBoundsException]
 */
inline operator fun CharBuffer.component2(): Char = get(1)
/**
 * Returns 3rd *element* from the buffer.
 * 
 * If the size of this array is less than 3, throws an [IndexOutOfBoundsException]
 */
inline operator fun CharBuffer.component3(): Char = get(2)
/**
 * Returns 4th *element* from the buffer.
 * 
 * If the size of this array is less than 4, throws an [IndexOutOfBoundsException]
 */
inline operator fun CharBuffer.component4(): Char = get(3)
/**
 * Returns 5th *element* from the buffer.
 * 
 * If the size of this array is less than 5, throws an [IndexOutOfBoundsException]
 */
inline operator fun CharBuffer.component5(): Char = get(4)
/** Returns `true` if [element] is found in the array. */
operator fun CharBuffer.contains(element: Char): Boolean = indexOf(element) >= 0
/** Returns an element at the given [index] or throws an [IndexOutOfBoundsException] if the [index] is out of bounds of this array. */
inline fun <T> CharBuffer.elementAt(index: Int): Char = get(index)
/** Returns an element at the given [index] or the result of calling the [defaultValue] function if the [index] is out of bounds of this array. */
inline fun CharBuffer.elementAtOrElse(index: Int, defaultValue: (Int) -> Char): Char = if (index >= 0 && index <= lastIndex) get(index) else defaultValue(index)
/** Returns an element at the given [index] or `null` if the [index] is out of bounds of this array. */
inline fun CharBuffer.elementAtOrNull(index: Int): Char? = this.getOrNull(index)
/** Returns the first element matching the given [predicate], or `null` if no such element was found. */
inline fun CharBuffer.find(predicate: (Char) -> Boolean): Char? = firstOrNull(predicate)
/** Returns the last element matching the given [predicate], or `null` if no such element was found. */
inline fun CharBuffer.findLast(predicate: (Char) -> Boolean): Char? = lastOrNull(predicate)
/**
 * Returns the first element.
 * 
 * @throws NoSuchElementException if the array is empty.
 */
fun CharBuffer.first(): Char {
    if (isEmpty())
        throw NoSuchElementException("Array is empty.")
    return this[0]
}
/**
 * Returns the first element matching the given [predicate].
 * @throws [NoSuchElementException] if no such element is found.
 */
inline fun CharBuffer.first(predicate: (Char) -> Boolean): Char {
    for (element in this) if (predicate(element)) return element
    throw NoSuchElementException("Array contains no element matching the predicate.")
}
/** Returns the first element, or `null` if the array is empty. */
fun CharBuffer.firstOrNull(): Char? = if (isEmpty()) null else this[0]
/** Returns the first element matching the given [predicate], or `null` if element was not found. */
inline fun CharBuffer.firstOrNull(predicate: (Char) -> Boolean): Char? {
    for (element in this) if (predicate(element)) return element
    return null
}
/** Returns an element at the given [index] or the result of calling the [defaultValue] function if the [index] is out of bounds of this array. */
inline fun CharBuffer.getOrElse(index: Int, defaultValue: (Int) -> Char): Char = if (index >= 0 && index <= lastIndex) get(index) else defaultValue(index)
/** Returns an element at the given [index] or `null` if the [index] is out of bounds of this array. */
fun CharBuffer.getOrNull(index: Int): Char? = if (index >= 0 && index <= lastIndex) get(index) else null
/** Returns first index of [element], or -1 if the array does not contain element. */
fun CharBuffer.indexOf(element: Char): Int {
    for (index in indices)
        if (element == this[index])
            return index
    return -1
}
/** Returns index of the first element matching the given [predicate], or -1 if the array does not contain such element. */
inline fun CharBuffer.indexOfFirst(predicate: (Char) -> Boolean): Int {
    for (index in indices)
        if (predicate(this[index]))
            return index
    return -1
}
/** Returns index of the last element matching the given [predicate], or -1 if the array does not contain such element. */
inline fun CharBuffer.indexOfLast(predicate: (Char) -> Boolean): Int {
    for (index in indices.reversed())
        if (predicate(this[index]))
            return index
    return -1
}
/**
 * Returns the last element.
 * 
 * @throws NoSuchElementException if the array is empty.
 */
fun CharBuffer.last(): Char {
    if (isEmpty())
        throw NoSuchElementException("Array is empty.")
    return this[lastIndex]
}
/**
 * Returns the last element matching the given [predicate].
 * 
 * @throws NoSuchElementException if no such element is found.
 */
inline fun CharBuffer.last(predicate: (Char) -> Boolean): Char {
    for (index in this.indices.reversed()) {
        val element = this[index]
        if (predicate(element)) return element
    }
    throw NoSuchElementException("Array contains no element matching the predicate.")
}
/** Returns last index of [element], or -1 if the array does not contain element. */
fun CharBuffer.lastIndexOf(element: Char): Int {
    for (index in indices.reversed())
        if (element == this[index])
            return index
    return -1
}
/** Returns the last element, or `null` if the array is empty. */
fun CharBuffer.lastOrNull(): Char? = if (isEmpty()) null else this[rem - 1]
/** Returns the last element matching the given [predicate], or `null` if no such element was found. */
inline fun CharBuffer.lastOrNull(predicate: (Char) -> Boolean): Char? {
    for (index in this.indices.reversed()) {
        val element = this[index]
        if (predicate(element)) return element
    }
    return null
}
/** Returns the single element, or throws an exception if the array is empty or has more than one element. */
fun CharBuffer.single(): Char = when (rem) {
    0 -> throw NoSuchElementException("Array is empty.")
    1 -> this[0]
    else -> throw IllegalArgumentException("Array has more than one element.")
}
/** Returns the single element matching the given [predicate], or throws exception if there is no or more than one matching element. */
inline fun CharBuffer.single(predicate: (Char) -> Boolean): Char {
    var single: Char? = null
    var found = false
    for (element in this)
        if (predicate(element)) {
            if (found) throw IllegalArgumentException("Array contains more than one matching element.")
            single = element
            found = true
        }
    if (!found) throw NoSuchElementException("Array contains no element matching the predicate.")
    @Suppress("UNCHECKED_CAST")
    return single as Char
}
/** Returns single element, or `null` if the array is empty or has more than one element. */
fun CharBuffer.singleOrNull(): Char? = if (rem == 1) this[0] else null
/** Returns the single element matching the given [predicate], or `null` if element was not found or more than one element was found. */
inline fun CharBuffer.singleOrNull(predicate: (Char) -> Boolean): Char? {
    var single: Char? = null
    var found = false
    for (element in this)
        if (predicate(element)) {
            if (found) return null
            single = element
            found = true
        }
    if (!found) return null
    return single
}
/** Returns a list containing only elements matching the given [predicate]. */
inline fun CharBuffer.filter(predicate: (Char) -> Boolean): List<Char> = filterTo(ArrayList<Char>(), predicate)
/**
 * Returns a list containing only elements matching the given [predicate].
 * @param [predicate] function that takes the index of an element and the element itself and returns the result of predicate evaluation on the element.
 */
inline fun CharBuffer.filterIndexed(predicate: (index: Int, Char) -> Boolean): List<Char> = filterIndexedTo(ArrayList<Char>(), predicate)
/**
 * Appends all elements matching the given [predicate] to the given [destination].
 * @param [predicate] function that takes the index of an element and the element itself and returns the result of predicate evaluation on the element.
 */
inline fun <C : MutableCollection<in Char>> CharBuffer.filterIndexedTo(destination: C, predicate: (index: Int, Char) -> Boolean): C {
    forEachIndexed { index, element ->
        if (predicate(index, element)) destination.add(element)
    }
    return destination
}
/** Returns a list containing all elements not matching the given [predicate]. */
inline fun CharBuffer.filterNot(predicate: (Char) -> Boolean): List<Char> = filterNotTo(ArrayList<Char>(), predicate)
/** Appends all elements not matching the given [predicate] to the given [destination]. */
inline fun <C : MutableCollection<in Char>> CharBuffer.filterNotTo(destination: C, predicate: (Char) -> Boolean): C {
     for (element in this) if (!predicate(element)) destination.add(element)
     return destination
}
/** Appends all elements matching the given [predicate] to the given [destination]. */
inline fun <C : MutableCollection<in Char>> CharBuffer.filterTo(destination: C, predicate: (Char) -> Boolean): C {
     for (element in this) if (predicate(element)) destination.add(element)
     return destination
}
/** Returns a list containing elements at specified [indices]. */
fun CharBuffer.slice(indices: Iterable<Int>): List<Char> {
    val size = indices.collectionSizeOrDefault(10)
    if (size == 0) return emptyList()
    val list = ArrayList<Char>(size)
    for (index in indices)
        list.add(get(index))
    return list
}
/** Returns an array containing elements of this array at specified [indices]. */
fun CharBuffer.sliceArray(indices: Collection<Int>): CharArray {
    val result = CharArray(indices.size)
    var targetIndex = 0
    for (sourceIndex in indices)
        result[targetIndex++] = this[sourceIndex]
    return result
}
/** Sorts elements in the array in-place descending according to their natural sort order. */
fun CharBuffer.sortDescending() {
    if (rem > 1) {
        val array = toCharArray().apply{ sortDescending() }
        for (i in 0 until rem)
            this[pos + i] = array[i]
    }
}
/** Returns a list of all elements sorted according to their natural sort order. */
fun CharBuffer.sorted(): List<Char> = toTypedArray().apply { sort() }.asList()
/** Returns an array with all elements of this array sorted according to their natural sort order. */
fun CharBuffer.sortedArray(): CharArray = toCharArray().apply { sort() }
/** Returns an array with all elements of this array sorted descending according to their natural sort order. */
fun CharBuffer.sortedArrayDescending(): CharArray = toCharArray().apply { sortDescending() }
/** Returns a list of all elements sorted according to natural sort order of the value returned by specified [selector] function. */
inline fun <R : Comparable<R>> CharBuffer.sortedBy(crossinline selector: (Char) -> R?): List<Char> = toCharArray().sortedWith(compareBy(selector))
/** Returns a list of all elements sorted descending according to natural sort order of the value returned by specified [selector] function. */
inline fun <R : Comparable<R>> CharBuffer.sortedByDescending(crossinline selector: (Char) -> R?): List<Char> = toCharArray().sortedWith(compareByDescending(selector))
/** Returns a list of all elements sorted descending according to their natural sort order. */
fun CharBuffer.sortedDescending(): List<Char> = toCharArray().apply { sort() }.reversed()
/** Returns a list of all elements sorted according to the specified [comparator]. */
fun CharBuffer.sortedWith(comparator: Comparator<in Char>): List<Char> = toTypedArray().apply { sortWith(comparator) }.asList()
/** Sorts the array in-place. */
fun CharBuffer.sort() {
    if (rem > 1) {
        val array = toCharArray().apply{ sort() }
        for (i in 0 until rem)
            this[pos + i] = array[i]
    }
}
/** Returns a string representation of the contents of the specified array as if it is [List]. */
fun CharBuffer.contentToString(): String {
    val iMax = lim - 1
    if (iMax == -1) return "[]"
    val b = StringBuilder()
    b.append('[')
    var i = 0
    while (true) {
        b.append(get(i))
        if (i == iMax) return b.append(']').toString()
        b.append(", ")
        i++
    }
}
/**
 * Fills this array or its subrange with the specified [element] value.
 * 
 * @param fromIndex the start of the range (inclusive) to fill, 0 by default.
 * @param toIndex the end of the range (exclusive) to fill, size of this array by default.
 * 
 * @throws IndexOutOfBoundsException if [fromIndex] is less than zero or [toIndex] is greater than the size of this array.
 * @throws IllegalArgumentException if [fromIndex] is greater than [toIndex].
 */
fun CharBuffer.fill(element: Char, fromIndex: Int = pos, toIndex: Int = rem) {
    for (i in fromIndex until toIndex)
        this[i] = element
}
/** Returns the range of valid indices for the array. */
val CharBuffer.indices: IntRange
    get() = IntRange(0, lastIndex)
/** Returns `true` if the array is empty. */
inline fun CharBuffer.isEmpty(): Boolean = rem == 0
/** Returns `true` if the array is not empty. */
inline fun CharBuffer.isNotEmpty(): Boolean = !isEmpty()
/** Returns the last valid index for the array. */
val CharBuffer.lastIndex: Int
    get() = rem - 1
/** Returns an array of Byte containing all of the elements of this generic array. */
fun CharBuffer.toCharArray(): CharArray = CharArray(rem) { index -> this[index] }
/** Returns a *typed* object array containing all of the elements of this primitive array. */
fun CharBuffer.toTypedArray(): Array<Char> = Array(rem) { index -> this[index] }
/**
 * Returns a [Map] containing key-value pairs provided by [transform] function applied to elements of the given array.
 * 
 * If any of two pairs would have the same key the last one gets added to the map.
 * 
 * The returned map preserves the entry iteration order of the original array.
 */
inline fun <K, V> CharBuffer.associate(transform: (Char) -> Pair<K, V>): Map<K, V> {
    val capacity = mapCapacity(rem).coerceAtLeast(16)
    return associateTo(LinkedHashMap<K, V>(capacity), transform)
}
/**
 * Returns a [Map] containing the elements from the given array indexed by the key returned from [keySelector] function applied to each element.
 * 
 * If any two elements would have the same key returned by [keySelector] the last one gets added to the map.
 * 
 * The returned map preserves the entry iteration order of the original array.
 */
inline fun <K> CharBuffer.associateBy(keySelector: (Char) -> K): Map<K, Char> {
    val capacity = mapCapacity(rem).coerceAtLeast(16)
    return associateByTo(LinkedHashMap<K, Char>(capacity), keySelector)
}
/**
 * Returns a [Map] containing the values provided by [valueTransform] and indexed by [keySelector] functions applied to elements of the given array.
 * 
 * If any two elements would have the same key returned by [keySelector] the last one gets added to the map.
 * 
 * The returned map preserves the entry iteration order of the original array.
 */
inline fun <K, V> CharBuffer.associateBy(keySelector: (Char) -> K, valueTransform: (Char) -> V): Map<K, V> {
    val capacity = mapCapacity(rem).coerceAtLeast(16)
    return associateByTo(LinkedHashMap<K, V>(capacity), keySelector, valueTransform)
}
/**
 * Populates and returns the [destination] mutable map with key-value pairs, where key is provided by
 * the [keySelector] function applied to each element of the given array and value is the element itself.
 * 
 * If any two elements would have the same key returned by [keySelector] the last one gets added to the map.
 */
inline fun <K, M : MutableMap<in K, in Char>> CharBuffer.associateByTo(destination: M, keySelector: (Char) -> K): M {
    for (element in this)
        destination.put(keySelector(element), element)
    return destination
}
/**
 * Populates and returns the [destination] mutable map with key-value pairs, where key is provided by the [keySelector]
 * function and and value is provided by the [valueTransform] function applied to elements of the given array.
 * 
 * If any two elements would have the same key returned by [keySelector] the last one gets added to the map.
 */
inline fun <K, V, M : MutableMap<in K, in V>> CharBuffer.associateByTo(destination: M, keySelector: (Char) -> K, valueTransform: (Char) -> V): M {
    for (element in this)
        destination.put(keySelector(element), valueTransform(element))
    return destination
}
/**
 * Populates and returns the [destination] mutable map with key-value pairs provided by [transform] function
 * applied to each element of the given array.
 * 
 * If any of two pairs would have the same key the last one gets added to the map.
 */
inline fun <K, V, M : MutableMap<in K, in V>> CharBuffer.associateTo(destination: M, transform: (Char) -> Pair<K, V>): M {
    for (element in this)
        destination += transform(element)
    return destination
}
/**
 * Returns a [Map] where keys are elements from the given array and values are produced by the [valueSelector] function applied to each element.
 * 
 * If any two elements are equal, the last one gets added to the map.
 * 
 * The returned map preserves the entry iteration order of the original array.
 */
inline fun <V> CharBuffer.associateWith(valueSelector: (Char) -> V): Map<Char, V> {
    val result = LinkedHashMap<Char, V>(mapCapacity(rem).coerceAtLeast(16))
    return associateWithTo(result, valueSelector)
}
/**
 * Populates and returns the [destination] mutable map with key-value pairs for each element of the given array,
 * where key is the element itself and value is provided by the [valueSelector] function applied to that key.
 * 
 * If any two elements are equal, the last one overwrites the former value in the map.
 */
inline fun <V, M : MutableMap<in Char, in V>> CharBuffer.associateWithTo(destination: M, valueSelector: (Char) -> V): M {
    for (element in this)
        destination.put(element, valueSelector(element))
    return destination
}
/** Appends all elements to the given [destination] collection. */
fun <C : MutableCollection<in Char>> CharBuffer.toCollection(destination: C): C {
    for (item in this)
        destination.add(item)
    return destination
}
/** Returns a single list of all elements yielded from results of [transform] function being invoked on each element of original array. */
inline fun <R> CharBuffer.flatMap(transform: (Char) -> Iterable<R>): List<R> = flatMapTo(ArrayList<R>(), transform)
/** Appends all elements yielded from results of [transform] function being invoked on each element of original array, to the given [destination]. */
inline fun <R, C : MutableCollection<in R>> CharBuffer.flatMapTo(destination: C, transform: (Char) -> Iterable<R>): C {
    for (element in this) {
        val list = transform(element)
        destination.addAll(list)
    }
    return destination
}
/**
 * Groups elements of the original array by the key returned by the given [keySelector] function applied to
 * each element and returns a map where each group key is associated with a list of corresponding elements.
 * 
 * The returned map preserves the entry iteration order of the keys produced from the original array.
 */
inline fun <K> CharBuffer.groupBy(keySelector: (Char) -> K): Map<K, List<Char>> = groupByTo(LinkedHashMap<K, MutableList<Char>>(), keySelector)
/**
 * Groups values returned by the [valueTransform] function applied to each element of the original array
 * by the key returned by the given [keySelector] function applied to the element
 * and returns a map where each group key is associated with a list of corresponding values.
 * 
 * The returned map preserves the entry iteration order of the keys produced from the original array.
 */
inline fun <K, V> CharBuffer.groupBy(keySelector: (Char) -> K, valueTransform: (Char) -> V): Map<K, List<V>> = groupByTo(LinkedHashMap<K, MutableList<V>>(), keySelector, valueTransform)
/**
 * Groups elements of the original array by the key returned by the given [keySelector] function applied to each
 * element and puts to the [destination] map each group key associated with a list of corresponding elements.
 * 
 * @return The [destination] map.
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
 */
inline fun <K, V, M : MutableMap<in K, MutableList<V>>> CharBuffer.groupByTo(destination: M, keySelector: (Char) -> K, valueTransform: (Char) -> V): M {
    for (element in this) {
        val key = keySelector(element)
        val list = destination.getOrPut(key) { ArrayList<V>() }
        list.add(valueTransform(element))
    }
    return destination
}
/**
 * Returns a list containing only distinct elements from the given array.
 * 
 * The elements in the resulting list are in the same order as they were in the source array.
 */
fun CharBuffer.distinct(): List<Char> = this.toMutableSet().toList()
/**
 * Returns a list containing only elements from the given array having distinct keys returned by the given [selector] function.
 * 
 * The elements in the resulting list are in the same order as they were in the source array.
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
 * Returns a new [MutableSet] containing all distinct elements from the given array.
 * 
 * The returned set preserves the element iteration order of the original array.
 */
fun CharBuffer.toMutableSet(): MutableSet<Char> = toCollection(LinkedHashSet<Char>(mapCapacity(rem)))
/** Returns a list containing the results of applying the given [transform] function to each element in the original array. */
inline fun <R> CharBuffer.map(transform: (Char) -> R): List<R> = mapTo(ArrayList<R>(rem), transform)
/**
 * Returns a list containing the results of applying the given [transform] function to each element and its index in the original array.
 * @param [transform] function that takes the index of an element and the element itself and returns the result of the transform applied to the element.
 */
inline fun <R> CharBuffer.mapIndexed(transform: (index: Int, Char) -> R): List<R> = mapIndexedTo(ArrayList<R>(rem), transform)
/**
 * Applies the given [transform] function to each element and its index in the original array and appends the results to the given [destination].
 * @param [transform] function that takes the index of an element and the element itself and returns the result of the transform applied to the element.
 */
inline fun <R, C : MutableCollection<in R>> CharBuffer.mapIndexedTo(destination: C, transform: (index: Int, Char) -> R): C {
    var index = 0
    for (item in this)
        destination.add(transform(index++, item))
    return destination
}
/** Applies the given [transform] function to each element of the original array and appends the results to the given [destination]. */
inline fun <R, C : MutableCollection<in R>> CharBuffer.mapTo(destination: C, transform: (Char) -> R): C {
    for (item in this)
        destination.add(transform(item))
    return destination
}
/** Returns `true` if all elements match the given [predicate]. */
inline fun CharBuffer.all(predicate: (Char) -> Boolean): Boolean {
    for (element in this) if (!predicate(element)) return false
    return true
}
/** Returns `true` if array has at least one element. */
fun CharBuffer.any(): Boolean = !isEmpty()
/** Returns `true` if at least one element matches the given [predicate]. */
inline fun CharBuffer.any(predicate: (Char) -> Boolean): Boolean {
    for (element in this) if (predicate(element)) return true
    return false
}
/** Returns the number of elements in this array. */
inline fun CharBuffer.count(): Int = rem
/** Returns the number of elements matching the given [predicate]. */
inline fun CharBuffer.count(predicate: (Char) -> Boolean): Int {
    var count = 0
    for (element in this) if (predicate(element)) ++count
    return count
}
/** Performs the given [action] on each element. */
inline fun CharBuffer.forEach(action: (Char) -> Unit) { for (element in this) action(element) }
/**
 * Performs the given [action] on each element, providing sequential index with the element.
 * @param [action] function that takes the index of an element and the element itself and performs the action on the element.
 */
inline fun CharBuffer.forEachIndexed(action: (index: Int, Char) -> Unit): Unit {
    var index = 0
    for (item in this) action(index++, item)
}
/**
 * Returns the largest element.
 * 
 * @throws NoSuchElementException if the array is empty.
 */
fun CharBuffer.max(): Char {
    if (isEmpty()) throw NoSuchElementException()
    var max = this[0]
    for (i in 1..lastIndex) {
        val e = this[i]
        if (max < e) max = e
    }
    return max
}
/**
 * Returns the first element yielding the largest value of the given function.
 * 
 * @throws NoSuchElementException if the array is empty.
 */
inline fun <R : Comparable<R>> CharBuffer.maxBy(selector: (Char) -> R): Char {
    if (isEmpty()) throw NoSuchElementException()
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
/** Returns the first element yielding the largest value of the given function or `null` if there are no elements. */
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
/**
 * Returns the first element having the largest value according to the provided [comparator].
 * 
 * @throws NoSuchElementException if the array is empty.
 */
fun CharBuffer.maxWith(comparator: Comparator<in Char>): Char {
    if (isEmpty()) throw NoSuchElementException()
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
/**
 * Returns the smallest element.
 * 
 * @throws NoSuchElementException if the array is empty.
 */
fun CharBuffer.min(): Char {
    if (isEmpty()) throw NoSuchElementException()
    var min = this[0]
    for (i in 1..lastIndex) {
        val e = this[i]
        if (min > e) min = e
    }
    return min
}
/**
 * Returns the first element yielding the smallest value of the given function.
 * 
 * @throws NoSuchElementException if the array is empty.
 */
inline fun <R : Comparable<R>> CharBuffer.minBy(selector: (Char) -> R): Char {
    if (isEmpty()) throw NoSuchElementException()
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
 * Returns the first element yielding the smallest value of the given function or `null` if there are no elements.
 * 
 * @sample samples.collections.Collections.Aggregates.minByOrNull
 */
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
 * Returns the smallest value among all values produced by [selector] function applied to each element in the array.
 * 
 * If any of values produced by [selector] function is `NaN`, the returned result is `NaN`.
 * 
 * @throws NoSuchElementException if the array is empty.
 */
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
 * Returns the smallest value among all values produced by [selector] function applied to each element in the array.
 * 
 * If any of values produced by [selector] function is `NaN`, the returned result is `NaN`.
 * 
 * @throws NoSuchElementException if the array is empty.
 */
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
 * Returns the smallest value among all values produced by [selector] function applied to each element in the array.
 * 
 * @throws NoSuchElementException if the array is empty.
 */
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
/**
 * Returns the smallest value among all values produced by [selector] function applied to each element in the array or `null` if there are no elements.
 * 
 * If any of values produced by [selector] function is `NaN`, the returned result is `NaN`.
 */
inline fun CharBuffer.minOfOrNull(selector: (Char) -> Double): Double? {
    if (isEmpty()) return null
    var minValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        minValue = minOf(minValue, v)
    }
    return minValue
}
/**
 * Returns the smallest value among all values produced by [selector] function applied to each element in the array or `null` if there are no elements.
 * 
 * If any of values produced by [selector] function is `NaN`, the returned result is `NaN`.
 */
inline fun CharBuffer.minOfOrNull(selector: (Char) -> Float): Float? {
    if (isEmpty()) return null
    var minValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        minValue = minOf(minValue, v)
    }
    return minValue
}
/** Returns the smallest value among all values produced by [selector] function applied to each element in the array or `null` if there are no elements. */
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
/**
 * Returns the smallest value according to the provided [comparator] among all values produced by [selector] function applied to each element in the array.
 * 
 * @throws NoSuchElementException if the array is empty.
 */
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
/**
 * Returns the smallest value according to the provided [comparator] among all values produced by [selector]
 * function applied to each element in the array or `null` if there are no elements.
 */
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
fun CharBuffer.minOrNull(): Char? {
     if (isEmpty()) return null
     var min = this[0]
     for (i in 1..lastIndex) {
         val e = this[i]
         if (min > e) min = e
     }
     return min
 }
/**
 * Returns the first element having the smallest value according to the provided [comparator].
 * 
 * @throws NoSuchElementException if the array is empty.
 */
fun CharBuffer.minWith(comparator: Comparator<in Char>): Char {
    if (isEmpty()) throw NoSuchElementException()
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
/** Returns `true` if the array has no elements. */
fun CharBuffer.none(): Boolean = isEmpty()
/** Returns `true` if no elements match the given [predicate]. */
inline fun CharBuffer.none(predicate: (Char) -> Boolean): Boolean {
    for (element in this) if (predicate(element)) return false
    return true
}
/** Performs the given [action] on each element and returns the array itself afterwards. */
inline fun CharBuffer.onEach(action: (Char) -> Unit): CharBuffer = apply { for (element in this) action(element) }
/**
 * Performs the given [action] on each element, providing sequential index with the element, and returns the array itself afterwards.
 * @param [action] function that takes the index of an element and the element itself and performs the action on the element.
 */
inline fun CharBuffer.onEachIndexed(action: (index: Int, Char) -> Unit): CharBuffer = apply { forEachIndexed(action) }
/**
 * Accumulates value starting with the first element and applying [operation] from left to right to current accumulator value and each element.
 * 
 * Throws an exception if this array is empty. If the array can be empty in an expected way,
 * please use [reduceOrNull] instead. It returns `null` when its receiver is empty.
 * 
 * @param [operation] function that takes current accumulator value and an element, and calculates the next accumulator value.
 */
inline fun CharBuffer.reduce(operation: (acc: Char, Char) -> Char): Char {
    if (isEmpty())
        throw UnsupportedOperationException("Empty array can't be reduced.")
    var accumulator = this[0]
    for (index in 1..lastIndex)
        accumulator = operation(accumulator, this[index])
    return accumulator
}
/**
 * Accumulates value starting with the first element and applying [operation] from left to right
 * to current accumulator value and each element with its index in the original array.
 * 
 * Throws an exception if this array is empty. If the array can be empty in an expected way,
 * please use [reduceIndexedOrNull] instead. It returns `null` when its receiver is empty.
 * 
 * @param [operation] function that takes the index of an element, current accumulator value and the element itself,
 * and calculates the next accumulator value.
 */
inline fun CharBuffer.reduceIndexed(operation: (index: Int, acc: Char, Char) -> Char): Char {
    if (isEmpty())
        throw UnsupportedOperationException("Empty array can't be reduced.")
    var accumulator = this[0]
    for (index in 1..lastIndex)
        accumulator = operation(index, accumulator, this[index])
    return accumulator
}
/**
 * Accumulates value starting with the first element and applying [operation] from left to right
 * to current accumulator value and each element with its index in the original array.
 * 
 * Returns `null` if the array is empty.
 * 
 * @param [operation] function that takes the index of an element, current accumulator value and the element itself,
 * and calculates the next accumulator value.
 */
inline fun CharBuffer.reduceIndexedOrNull(operation: (index: Int, acc: Char, Char) -> Char): Char? {
    if (isEmpty())
        return null
    var accumulator = this[0]
    for (index in 1..lastIndex)
        accumulator = operation(index, accumulator, this[index])
    return accumulator
}
/**
 * Accumulates value starting with the first element and applying [operation] from left to right to current accumulator value and each element.
 * 
 * Returns `null` if the array is empty.
 * 
 * @param [operation] function that takes current accumulator value and an element, and calculates the next accumulator value.
 */
inline fun CharBuffer.reduceOrNull(operation: (acc: Char, Char) -> Char): Char? {
    if (isEmpty())
        return null
    var accumulator = this[0]
    for (index in 1..lastIndex)
        accumulator = operation(accumulator, this[index])
     return accumulator
}
/**
 * Accumulates value starting with the last element and applying [operation] from right to left to each element and current accumulator value.
 * 
 * Throws an exception if this array is empty. If the array can be empty in an expected way,
 * please use [reduceRightOrNull] instead. It returns `null` when its receiver is empty.
 * 
 * @param [operation] function that takes an element and current accumulator value, and calculates the next accumulator value.
 */
inline fun CharBuffer.reduceRight(operation: (Char, acc: Char) -> Char): Char {
    var index = lastIndex
    if (index < 0) throw UnsupportedOperationException("Empty array can't be reduced.")
    var accumulator = get(index--)
    while (index >= 0)
        accumulator = operation(get(index--), accumulator)
    return accumulator
}
/**
 * Accumulates value starting with the last element and applying [operation] from right to left
 * to each element with its index in the original array and current accumulator value.
 * 
 * Throws an exception if this array is empty. If the array can be empty in an expected way,
 * please use [reduceRightIndexedOrNull] instead. It returns `null` when its receiver is empty.
 * 
 * @param [operation] function that takes the index of an element, the element itself and current accumulator value,
 * and calculates the next accumulator value.
 */
inline fun CharBuffer.reduceRightIndexed(operation: (index: Int, Char, acc: Char) -> Char): Char {
    var index = lastIndex
    if (index < 0) throw UnsupportedOperationException("Empty array can't be reduced.")
    var accumulator = get(index--)
    while (index >= 0) {
        accumulator = operation(index, get(index), accumulator)
        --index
    }
    return accumulator
}
/**
 * Accumulates value starting with the last element and applying [operation] from right to left
 * to each element with its index in the original array and current accumulator value.
 * 
 * Returns `null` if the array is empty.
 * 
 * @param [operation] function that takes the index of an element, the element itself and current accumulator value,
 * and calculates the next accumulator value.
 */
inline fun CharBuffer.reduceRightIndexedOrNull(operation: (index: Int, Char, acc: Char) -> Char): Char? {
    var index = lastIndex
    if (index < 0) return null
    var accumulator = get(index--)
    while (index >= 0) {
        accumulator = operation(index, get(index), accumulator)
        --index
    }
    return accumulator
}
/**
 * Accumulates value starting with the last element and applying [operation] from right to left to each element and current accumulator value.
 * 
 * Returns `null` if the array is empty.
 * 
 * @param [operation] function that takes an element and current accumulator value, and calculates the next accumulator value.
 */
inline fun CharBuffer.reduceRightOrNull(operation: (Char, acc: Char) -> Char): Char? {
    var index = lastIndex
    if (index < 0) return null
    var accumulator = get(index--)
    while (index >= 0)
         accumulator = operation(get(index--), accumulator)
    return accumulator
}
/**
 * Splits the original array into pair of lists, where *first* list contains elements for which [predicate] 
 * yielded `true`, while *second* list contains elements for which [predicate] yielded `false`.
 */
inline fun CharBuffer.partition(predicate: (Char) -> Boolean): Pair<List<Char>, List<Char>> {
    val first = ArrayList<Char>()
    val second = ArrayList<Char>()
    for (element in this)
        if (predicate(element))
            first.add(element)
        else
            second.add(element)
    return Pair(first, second)
}
/**
 * Returns a list of pairs built from the elements of `this` array and the [other] array with the same index.
 * The returned list has length of the shortest collection.
 */
infix fun <R> CharBuffer.zip(other: Array<out R>): List<Pair<Char, R>> = zip(other) { t1, t2 -> t1 to t2 }
/**
 * Returns a list of values built from the elements of `this` array and the [other] array with the same index
 * using the provided [transform] function applied to each pair of elements.
 * The returned list has length of the shortest collection.
 */
inline fun <R, V> CharBuffer.zip(other: Array<out R>, transform: (a: Char, b: R) -> V): List<V> {
    val size = minOf(rem, other.size)
    val list = ArrayList<V>(size)
    for (i in 0 until size)
        list.add(transform(this[i], other[i]))
    return list
}
/**
 * Returns a list of pairs built from the elements of `this` collection and [other] array with the same index.
 * The returned list has length of the shortest collection.
 */
infix fun <R> CharBuffer.zip(other: Iterable<R>): List<Pair<Char, R>> = zip(other) { t1, t2 -> t1 to t2 }
/**
 * Returns a list of values built from the elements of `this` array and the [other] collection with the same index
 * using the provided [transform] function applied to each pair of elements.
 * The returned list has length of the shortest collection.
 */
inline fun <R, V> CharBuffer.zip(other: Iterable<R>, transform: (a: Char, b: R) -> V): List<V> {
    val arraySize = rem
    val list = ArrayList<V>(minOf(other.collectionSizeOrDefault(10), arraySize))
    var i = 0
    for (element in other) {
        if (i >= arraySize) break
        list.add(transform(this[i++], element))
    }
    return list
}
/**
 * Returns a list of pairs built from the elements of `this` array and the [other] array with the same index.
 * The returned list has length of the shortest collection.
 */
infix fun CharBuffer.zip(other: CharArray): List<Pair<Char, Char>> = zip(other) { t1, t2 -> t1 to t2 }
/**
 * Returns a list of values built from the elements of `this` array and the [other] array with the same index
 * using the provided [transform] function applied to each pair of elements.
 * The returned list has length of the shortest array.
 */
inline fun <V> CharBuffer.zip(other: CharArray, transform: (a: Char, b: Char) -> V): List<V> {
    val size = minOf(rem, other.size)
    val list = ArrayList<V>(size)
    for (i in 0 until size)
        list.add(transform(this[i], other[i]))
    return list
}
/**
 * Appends the string from all the elements separated using [separator] and using the given [prefix] and [postfix] if supplied.
 * 
 * If the collection could be huge, you can specify a non-negative value of [limit], in which case only the first [limit]
 * elements will be appended, followed by the [truncated] string (which defaults to "...").
 */
fun <A : Appendable> CharBuffer.joinTo(buffer: A, separator: CharSequence = ", ", prefix: CharSequence = "", postfix: CharSequence = "", limit: Int = -1, truncated: CharSequence = "...", transform: ((Char) -> CharSequence)? = null): A {
    buffer.append(prefix)
    var count = 0
    for (element in this) {
        if (++count > 1) buffer.append(separator)
        if (limit < 0 || count <= limit)
            if (transform != null)
                buffer.append(transform(element))
            else
                buffer.append(element.toString())
        else break
    }
    if (limit >= 0 && count > limit) buffer.append(truncated)
    buffer.append(postfix)
    return buffer
}
/**
 * Creates a string from all the elements separated using [separator] and using the given [prefix] and [postfix] if supplied.
 * 
 * If the collection could be huge, you can specify a non-negative value of [limit], in which case only the first [limit]
 * elements will be appended, followed by the [truncated] string (which defaults to "...").
 */
fun CharBuffer.joinToString(separator: CharSequence = ", ", prefix: CharSequence = "", postfix: CharSequence = "", limit: Int = -1, truncated: CharSequence = "...", transform: ((Char) -> CharSequence)? = null): String =
    joinTo(StringBuilder(), separator, prefix, postfix, limit, truncated, transform).toString()
/**
 * Returns 1st *element* from the buffer.
 * 
 * If the size of this array is less than 1, throws an [IndexOutOfBoundsException]
 */
inline operator fun ByteBuffer.component1(): Byte = get(0)
/**
 * Returns 2nd *element* from the buffer.
 * 
 * If the size of this array is less than 2, throws an [IndexOutOfBoundsException]
 */
inline operator fun ByteBuffer.component2(): Byte = get(1)
/**
 * Returns 3rd *element* from the buffer.
 * 
 * If the size of this array is less than 3, throws an [IndexOutOfBoundsException]
 */
inline operator fun ByteBuffer.component3(): Byte = get(2)
/**
 * Returns 4th *element* from the buffer.
 * 
 * If the size of this array is less than 4, throws an [IndexOutOfBoundsException]
 */
inline operator fun ByteBuffer.component4(): Byte = get(3)
/**
 * Returns 5th *element* from the buffer.
 * 
 * If the size of this array is less than 5, throws an [IndexOutOfBoundsException]
 */
inline operator fun ByteBuffer.component5(): Byte = get(4)
/** Returns `true` if [element] is found in the array. */
operator fun ByteBuffer.contains(element: Byte): Boolean = indexOf(element) >= 0
/** Returns an element at the given [index] or throws an [IndexOutOfBoundsException] if the [index] is out of bounds of this array. */
inline fun <T> ByteBuffer.elementAt(index: Int): Byte = get(index)
/** Returns an element at the given [index] or the result of calling the [defaultValue] function if the [index] is out of bounds of this array. */
inline fun ByteBuffer.elementAtOrElse(index: Int, defaultValue: (Int) -> Byte): Byte = if (index >= 0 && index <= lastIndex) get(index) else defaultValue(index)
/** Returns an element at the given [index] or `null` if the [index] is out of bounds of this array. */
inline fun ByteBuffer.elementAtOrNull(index: Int): Byte? = this.getOrNull(index)
/** Returns the first element matching the given [predicate], or `null` if no such element was found. */
inline fun ByteBuffer.find(predicate: (Byte) -> Boolean): Byte? = firstOrNull(predicate)
/** Returns the last element matching the given [predicate], or `null` if no such element was found. */
inline fun ByteBuffer.findLast(predicate: (Byte) -> Boolean): Byte? = lastOrNull(predicate)
/**
 * Returns the first element.
 * 
 * @throws NoSuchElementException if the array is empty.
 */
fun ByteBuffer.first(): Byte {
    if (isEmpty())
        throw NoSuchElementException("Array is empty.")
    return this[0]
}
/**
 * Returns the first element matching the given [predicate].
 * @throws [NoSuchElementException] if no such element is found.
 */
inline fun ByteBuffer.first(predicate: (Byte) -> Boolean): Byte {
    for (element in this) if (predicate(element)) return element
    throw NoSuchElementException("Array contains no element matching the predicate.")
}
/** Returns the first element, or `null` if the array is empty. */
fun ByteBuffer.firstOrNull(): Byte? = if (isEmpty()) null else this[0]
/** Returns the first element matching the given [predicate], or `null` if element was not found. */
inline fun ByteBuffer.firstOrNull(predicate: (Byte) -> Boolean): Byte? {
    for (element in this) if (predicate(element)) return element
    return null
}
/** Returns an element at the given [index] or the result of calling the [defaultValue] function if the [index] is out of bounds of this array. */
inline fun ByteBuffer.getOrElse(index: Int, defaultValue: (Int) -> Byte): Byte = if (index >= 0 && index <= lastIndex) get(index) else defaultValue(index)
/** Returns an element at the given [index] or `null` if the [index] is out of bounds of this array. */
fun ByteBuffer.getOrNull(index: Int): Byte? = if (index >= 0 && index <= lastIndex) get(index) else null
/** Returns first index of [element], or -1 if the array does not contain element. */
fun ByteBuffer.indexOf(element: Byte): Int {
    for (index in indices)
        if (element == this[index])
            return index
    return -1
}
/** Returns index of the first element matching the given [predicate], or -1 if the array does not contain such element. */
inline fun ByteBuffer.indexOfFirst(predicate: (Byte) -> Boolean): Int {
    for (index in indices)
        if (predicate(this[index]))
            return index
    return -1
}
/** Returns index of the last element matching the given [predicate], or -1 if the array does not contain such element. */
inline fun ByteBuffer.indexOfLast(predicate: (Byte) -> Boolean): Int {
    for (index in indices.reversed())
        if (predicate(this[index]))
            return index
    return -1
}
/**
 * Returns the last element.
 * 
 * @throws NoSuchElementException if the array is empty.
 */
fun ByteBuffer.last(): Byte {
    if (isEmpty())
        throw NoSuchElementException("Array is empty.")
    return this[lastIndex]
}
/**
 * Returns the last element matching the given [predicate].
 * 
 * @throws NoSuchElementException if no such element is found.
 */
inline fun ByteBuffer.last(predicate: (Byte) -> Boolean): Byte {
    for (index in this.indices.reversed()) {
        val element = this[index]
        if (predicate(element)) return element
    }
    throw NoSuchElementException("Array contains no element matching the predicate.")
}
/** Returns last index of [element], or -1 if the array does not contain element. */
fun ByteBuffer.lastIndexOf(element: Byte): Int {
    for (index in indices.reversed())
        if (element == this[index])
            return index
    return -1
}
/** Returns the last element, or `null` if the array is empty. */
fun ByteBuffer.lastOrNull(): Byte? = if (isEmpty()) null else this[rem - 1]
/** Returns the last element matching the given [predicate], or `null` if no such element was found. */
inline fun ByteBuffer.lastOrNull(predicate: (Byte) -> Boolean): Byte? {
    for (index in this.indices.reversed()) {
        val element = this[index]
        if (predicate(element)) return element
    }
    return null
}
/** Returns the single element, or throws an exception if the array is empty or has more than one element. */
fun ByteBuffer.single(): Byte = when (rem) {
    0 -> throw NoSuchElementException("Array is empty.")
    1 -> this[0]
    else -> throw IllegalArgumentException("Array has more than one element.")
}
/** Returns the single element matching the given [predicate], or throws exception if there is no or more than one matching element. */
inline fun ByteBuffer.single(predicate: (Byte) -> Boolean): Byte {
    var single: Byte? = null
    var found = false
    for (element in this)
        if (predicate(element)) {
            if (found) throw IllegalArgumentException("Array contains more than one matching element.")
            single = element
            found = true
        }
    if (!found) throw NoSuchElementException("Array contains no element matching the predicate.")
    @Suppress("UNCHECKED_CAST")
    return single as Byte
}
/** Returns single element, or `null` if the array is empty or has more than one element. */
fun ByteBuffer.singleOrNull(): Byte? = if (rem == 1) this[0] else null
/** Returns the single element matching the given [predicate], or `null` if element was not found or more than one element was found. */
inline fun ByteBuffer.singleOrNull(predicate: (Byte) -> Boolean): Byte? {
    var single: Byte? = null
    var found = false
    for (element in this)
        if (predicate(element)) {
            if (found) return null
            single = element
            found = true
        }
    if (!found) return null
    return single
}
/** Returns a list containing only elements matching the given [predicate]. */
inline fun ByteBuffer.filter(predicate: (Byte) -> Boolean): List<Byte> = filterTo(ArrayList<Byte>(), predicate)
/**
 * Returns a list containing only elements matching the given [predicate].
 * @param [predicate] function that takes the index of an element and the element itself and returns the result of predicate evaluation on the element.
 */
inline fun ByteBuffer.filterIndexed(predicate: (index: Int, Byte) -> Boolean): List<Byte> = filterIndexedTo(ArrayList<Byte>(), predicate)
/**
 * Appends all elements matching the given [predicate] to the given [destination].
 * @param [predicate] function that takes the index of an element and the element itself and returns the result of predicate evaluation on the element.
 */
inline fun <C : MutableCollection<in Byte>> ByteBuffer.filterIndexedTo(destination: C, predicate: (index: Int, Byte) -> Boolean): C {
    forEachIndexed { index, element ->
        if (predicate(index, element)) destination.add(element)
    }
    return destination
}
/** Returns a list containing all elements not matching the given [predicate]. */
inline fun ByteBuffer.filterNot(predicate: (Byte) -> Boolean): List<Byte> = filterNotTo(ArrayList<Byte>(), predicate)
/** Appends all elements not matching the given [predicate] to the given [destination]. */
inline fun <C : MutableCollection<in Byte>> ByteBuffer.filterNotTo(destination: C, predicate: (Byte) -> Boolean): C {
     for (element in this) if (!predicate(element)) destination.add(element)
     return destination
}
/** Appends all elements matching the given [predicate] to the given [destination]. */
inline fun <C : MutableCollection<in Byte>> ByteBuffer.filterTo(destination: C, predicate: (Byte) -> Boolean): C {
     for (element in this) if (predicate(element)) destination.add(element)
     return destination
}
/** Returns a list containing elements at specified [indices]. */
fun ByteBuffer.slice(indices: Iterable<Int>): List<Byte> {
    val size = indices.collectionSizeOrDefault(10)
    if (size == 0) return emptyList()
    val list = ArrayList<Byte>(size)
    for (index in indices)
        list.add(get(index))
    return list
}
/** Returns an array containing elements of this array at specified [indices]. */
fun ByteBuffer.sliceArray(indices: Collection<Int>): ByteArray {
    val result = ByteArray(indices.size)
    var targetIndex = 0
    for (sourceIndex in indices)
        result[targetIndex++] = this[sourceIndex]
    return result
}
/** Sorts elements in the array in-place descending according to their natural sort order. */
fun ByteBuffer.sortDescending() {
    if (rem > 1) {
        val array = toByteArray().apply{ sortDescending() }
        for (i in 0 until rem)
            this[pos + i] = array[i]
    }
}
/** Returns a list of all elements sorted according to their natural sort order. */
fun ByteBuffer.sorted(): List<Byte> = toTypedArray().apply { sort() }.asList()
/** Returns an array with all elements of this array sorted according to their natural sort order. */
fun ByteBuffer.sortedArray(): ByteArray = toByteArray().apply { sort() }
/** Returns an array with all elements of this array sorted descending according to their natural sort order. */
fun ByteBuffer.sortedArrayDescending(): ByteArray = toByteArray().apply { sortDescending() }
/** Returns a list of all elements sorted according to natural sort order of the value returned by specified [selector] function. */
inline fun <R : Comparable<R>> ByteBuffer.sortedBy(crossinline selector: (Byte) -> R?): List<Byte> = toByteArray().sortedWith(compareBy(selector))
/** Returns a list of all elements sorted descending according to natural sort order of the value returned by specified [selector] function. */
inline fun <R : Comparable<R>> ByteBuffer.sortedByDescending(crossinline selector: (Byte) -> R?): List<Byte> = toByteArray().sortedWith(compareByDescending(selector))
/** Returns a list of all elements sorted descending according to their natural sort order. */
fun ByteBuffer.sortedDescending(): List<Byte> = toByteArray().apply { sort() }.reversed()
/** Returns a list of all elements sorted according to the specified [comparator]. */
fun ByteBuffer.sortedWith(comparator: Comparator<in Byte>): List<Byte> = toTypedArray().apply { sortWith(comparator) }.asList()
/** Sorts the array in-place. */
fun ByteBuffer.sort() {
    if (rem > 1) {
        val array = toByteArray().apply{ sort() }
        for (i in 0 until rem)
            this[pos + i] = array[i]
    }
}
/** Returns a string representation of the contents of the specified array as if it is [List]. */
fun ByteBuffer.contentToString(): String {
    val iMax = lim - 1
    if (iMax == -1) return "[]"
    val b = StringBuilder()
    b.append('[')
    var i = 0
    while (true) {
        b.append(get(i))
        if (i == iMax) return b.append(']').toString()
        b.append(", ")
        i++
    }
}
/**
 * Fills this array or its subrange with the specified [element] value.
 * 
 * @param fromIndex the start of the range (inclusive) to fill, 0 by default.
 * @param toIndex the end of the range (exclusive) to fill, size of this array by default.
 * 
 * @throws IndexOutOfBoundsException if [fromIndex] is less than zero or [toIndex] is greater than the size of this array.
 * @throws IllegalArgumentException if [fromIndex] is greater than [toIndex].
 */
fun ByteBuffer.fill(element: Byte, fromIndex: Int = pos, toIndex: Int = rem) {
    for (i in fromIndex until toIndex)
        this[i] = element
}
/** Returns the range of valid indices for the array. */
val ByteBuffer.indices: IntRange
    get() = IntRange(0, lastIndex)
/** Returns `true` if the array is empty. */
inline fun ByteBuffer.isEmpty(): Boolean = rem == 0
/** Returns `true` if the array is not empty. */
inline fun ByteBuffer.isNotEmpty(): Boolean = !isEmpty()
/** Returns the last valid index for the array. */
val ByteBuffer.lastIndex: Int
    get() = rem - 1
/** Returns an array of Byte containing all of the elements of this generic array. */
fun ByteBuffer.toByteArray(): ByteArray = ByteArray(rem) { index -> this[index] }
/** Returns a *typed* object array containing all of the elements of this primitive array. */
fun ByteBuffer.toTypedArray(): Array<Byte> = Array(rem) { index -> this[index] }
/**
 * Returns a [Map] containing key-value pairs provided by [transform] function applied to elements of the given array.
 * 
 * If any of two pairs would have the same key the last one gets added to the map.
 * 
 * The returned map preserves the entry iteration order of the original array.
 */
inline fun <K, V> ByteBuffer.associate(transform: (Byte) -> Pair<K, V>): Map<K, V> {
    val capacity = mapCapacity(rem).coerceAtLeast(16)
    return associateTo(LinkedHashMap<K, V>(capacity), transform)
}
/**
 * Returns a [Map] containing the elements from the given array indexed by the key returned from [keySelector] function applied to each element.
 * 
 * If any two elements would have the same key returned by [keySelector] the last one gets added to the map.
 * 
 * The returned map preserves the entry iteration order of the original array.
 */
inline fun <K> ByteBuffer.associateBy(keySelector: (Byte) -> K): Map<K, Byte> {
    val capacity = mapCapacity(rem).coerceAtLeast(16)
    return associateByTo(LinkedHashMap<K, Byte>(capacity), keySelector)
}
/**
 * Returns a [Map] containing the values provided by [valueTransform] and indexed by [keySelector] functions applied to elements of the given array.
 * 
 * If any two elements would have the same key returned by [keySelector] the last one gets added to the map.
 * 
 * The returned map preserves the entry iteration order of the original array.
 */
inline fun <K, V> ByteBuffer.associateBy(keySelector: (Byte) -> K, valueTransform: (Byte) -> V): Map<K, V> {
    val capacity = mapCapacity(rem).coerceAtLeast(16)
    return associateByTo(LinkedHashMap<K, V>(capacity), keySelector, valueTransform)
}
/**
 * Populates and returns the [destination] mutable map with key-value pairs, where key is provided by
 * the [keySelector] function applied to each element of the given array and value is the element itself.
 * 
 * If any two elements would have the same key returned by [keySelector] the last one gets added to the map.
 */
inline fun <K, M : MutableMap<in K, in Byte>> ByteBuffer.associateByTo(destination: M, keySelector: (Byte) -> K): M {
    for (element in this)
        destination.put(keySelector(element), element)
    return destination
}
/**
 * Populates and returns the [destination] mutable map with key-value pairs, where key is provided by the [keySelector]
 * function and and value is provided by the [valueTransform] function applied to elements of the given array.
 * 
 * If any two elements would have the same key returned by [keySelector] the last one gets added to the map.
 */
inline fun <K, V, M : MutableMap<in K, in V>> ByteBuffer.associateByTo(destination: M, keySelector: (Byte) -> K, valueTransform: (Byte) -> V): M {
    for (element in this)
        destination.put(keySelector(element), valueTransform(element))
    return destination
}
/**
 * Populates and returns the [destination] mutable map with key-value pairs provided by [transform] function
 * applied to each element of the given array.
 * 
 * If any of two pairs would have the same key the last one gets added to the map.
 */
inline fun <K, V, M : MutableMap<in K, in V>> ByteBuffer.associateTo(destination: M, transform: (Byte) -> Pair<K, V>): M {
    for (element in this)
        destination += transform(element)
    return destination
}
/**
 * Returns a [Map] where keys are elements from the given array and values are produced by the [valueSelector] function applied to each element.
 * 
 * If any two elements are equal, the last one gets added to the map.
 * 
 * The returned map preserves the entry iteration order of the original array.
 */
inline fun <V> ByteBuffer.associateWith(valueSelector: (Byte) -> V): Map<Byte, V> {
    val result = LinkedHashMap<Byte, V>(mapCapacity(rem).coerceAtLeast(16))
    return associateWithTo(result, valueSelector)
}
/**
 * Populates and returns the [destination] mutable map with key-value pairs for each element of the given array,
 * where key is the element itself and value is provided by the [valueSelector] function applied to that key.
 * 
 * If any two elements are equal, the last one overwrites the former value in the map.
 */
inline fun <V, M : MutableMap<in Byte, in V>> ByteBuffer.associateWithTo(destination: M, valueSelector: (Byte) -> V): M {
    for (element in this)
        destination.put(element, valueSelector(element))
    return destination
}
/** Appends all elements to the given [destination] collection. */
fun <C : MutableCollection<in Byte>> ByteBuffer.toCollection(destination: C): C {
    for (item in this)
        destination.add(item)
    return destination
}
/** Returns a single list of all elements yielded from results of [transform] function being invoked on each element of original array. */
inline fun <R> ByteBuffer.flatMap(transform: (Byte) -> Iterable<R>): List<R> = flatMapTo(ArrayList<R>(), transform)
/** Appends all elements yielded from results of [transform] function being invoked on each element of original array, to the given [destination]. */
inline fun <R, C : MutableCollection<in R>> ByteBuffer.flatMapTo(destination: C, transform: (Byte) -> Iterable<R>): C {
    for (element in this) {
        val list = transform(element)
        destination.addAll(list)
    }
    return destination
}
/**
 * Groups elements of the original array by the key returned by the given [keySelector] function applied to
 * each element and returns a map where each group key is associated with a list of corresponding elements.
 * 
 * The returned map preserves the entry iteration order of the keys produced from the original array.
 */
inline fun <K> ByteBuffer.groupBy(keySelector: (Byte) -> K): Map<K, List<Byte>> = groupByTo(LinkedHashMap<K, MutableList<Byte>>(), keySelector)
/**
 * Groups values returned by the [valueTransform] function applied to each element of the original array
 * by the key returned by the given [keySelector] function applied to the element
 * and returns a map where each group key is associated with a list of corresponding values.
 * 
 * The returned map preserves the entry iteration order of the keys produced from the original array.
 */
inline fun <K, V> ByteBuffer.groupBy(keySelector: (Byte) -> K, valueTransform: (Byte) -> V): Map<K, List<V>> = groupByTo(LinkedHashMap<K, MutableList<V>>(), keySelector, valueTransform)
/**
 * Groups elements of the original array by the key returned by the given [keySelector] function applied to each
 * element and puts to the [destination] map each group key associated with a list of corresponding elements.
 * 
 * @return The [destination] map.
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
 * Groups values returned by the [valueTransform] function applied to each element of the original array
 * by the key returned by the given [keySelector] function applied to the element
 * and puts to the [destination] map each group key associated with a list of corresponding values.
 * 
 * @return The [destination] map.
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
 * Returns a list containing only distinct elements from the given array.
 * 
 * The elements in the resulting list are in the same order as they were in the source array.
 */
fun ByteBuffer.distinct(): List<Byte> = this.toMutableSet().toList()
/**
 * Returns a list containing only elements from the given array having distinct keys returned by the given [selector] function.
 * 
 * The elements in the resulting list are in the same order as they were in the source array.
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
 * Returns a new [MutableSet] containing all distinct elements from the given array.
 * 
 * The returned set preserves the element iteration order of the original array.
 */
fun ByteBuffer.toMutableSet(): MutableSet<Byte> = toCollection(LinkedHashSet<Byte>(mapCapacity(rem)))
/** Returns a list containing the results of applying the given [transform] function to each element in the original array. */
inline fun <R> ByteBuffer.map(transform: (Byte) -> R): List<R> = mapTo(ArrayList<R>(rem), transform)
/**
 * Returns a list containing the results of applying the given [transform] function to each element and its index in the original array.
 * @param [transform] function that takes the index of an element and the element itself and returns the result of the transform applied to the element.
 */
inline fun <R> ByteBuffer.mapIndexed(transform: (index: Int, Byte) -> R): List<R> = mapIndexedTo(ArrayList<R>(rem), transform)
/**
 * Applies the given [transform] function to each element and its index in the original array and appends the results to the given [destination].
 * @param [transform] function that takes the index of an element and the element itself and returns the result of the transform applied to the element.
 */
inline fun <R, C : MutableCollection<in R>> ByteBuffer.mapIndexedTo(destination: C, transform: (index: Int, Byte) -> R): C {
    var index = 0
    for (item in this)
        destination.add(transform(index++, item))
    return destination
}
/** Applies the given [transform] function to each element of the original array and appends the results to the given [destination]. */
inline fun <R, C : MutableCollection<in R>> ByteBuffer.mapTo(destination: C, transform: (Byte) -> R): C {
    for (item in this)
        destination.add(transform(item))
    return destination
}
/** Returns `true` if all elements match the given [predicate]. */
inline fun ByteBuffer.all(predicate: (Byte) -> Boolean): Boolean {
    for (element in this) if (!predicate(element)) return false
    return true
}
/** Returns `true` if array has at least one element. */
fun ByteBuffer.any(): Boolean = !isEmpty()
/** Returns `true` if at least one element matches the given [predicate]. */
inline fun ByteBuffer.any(predicate: (Byte) -> Boolean): Boolean {
    for (element in this) if (predicate(element)) return true
    return false
}
/** Returns the number of elements in this array. */
inline fun ByteBuffer.count(): Int = rem
/** Returns the number of elements matching the given [predicate]. */
inline fun ByteBuffer.count(predicate: (Byte) -> Boolean): Int {
    var count = 0
    for (element in this) if (predicate(element)) ++count
    return count
}
/** Performs the given [action] on each element. */
inline fun ByteBuffer.forEach(action: (Byte) -> Unit) { for (element in this) action(element) }
/**
 * Performs the given [action] on each element, providing sequential index with the element.
 * @param [action] function that takes the index of an element and the element itself and performs the action on the element.
 */
inline fun ByteBuffer.forEachIndexed(action: (index: Int, Byte) -> Unit): Unit {
    var index = 0
    for (item in this) action(index++, item)
}
/**
 * Returns the largest element.
 * 
 * @throws NoSuchElementException if the array is empty.
 */
fun ByteBuffer.max(): Byte {
    if (isEmpty()) throw NoSuchElementException()
    var max = this[0]
    for (i in 1..lastIndex) {
        val e = this[i]
        if (max < e) max = e
    }
    return max
}
/**
 * Returns the first element yielding the largest value of the given function.
 * 
 * @throws NoSuchElementException if the array is empty.
 */
inline fun <R : Comparable<R>> ByteBuffer.maxBy(selector: (Byte) -> R): Byte {
    if (isEmpty()) throw NoSuchElementException()
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
/** Returns the first element yielding the largest value of the given function or `null` if there are no elements. */
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
/**
 * Returns the first element having the largest value according to the provided [comparator].
 * 
 * @throws NoSuchElementException if the array is empty.
 */
fun ByteBuffer.maxWith(comparator: Comparator<in Byte>): Byte {
    if (isEmpty()) throw NoSuchElementException()
    var max = this[0]
    for (i in 1..lastIndex) {
        val e = this[i]
        if (comparator.compare(max, e) < 0) max = e
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
/**
 * Returns the smallest element.
 * 
 * @throws NoSuchElementException if the array is empty.
 */
fun ByteBuffer.min(): Byte {
    if (isEmpty()) throw NoSuchElementException()
    var min = this[0]
    for (i in 1..lastIndex) {
        val e = this[i]
        if (min > e) min = e
    }
    return min
}
/**
 * Returns the first element yielding the smallest value of the given function.
 * 
 * @throws NoSuchElementException if the array is empty.
 */
inline fun <R : Comparable<R>> ByteBuffer.minBy(selector: (Byte) -> R): Byte {
    if (isEmpty()) throw NoSuchElementException()
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
 * Returns the first element yielding the smallest value of the given function or `null` if there are no elements.
 * 
 * @sample samples.collections.Collections.Aggregates.minByOrNull
 */
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
/**
 * Returns the smallest value among all values produced by [selector] function applied to each element in the array.
 * 
 * If any of values produced by [selector] function is `NaN`, the returned result is `NaN`.
 * 
 * @throws NoSuchElementException if the array is empty.
 */
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
 * Returns the smallest value among all values produced by [selector] function applied to each element in the array.
 * 
 * If any of values produced by [selector] function is `NaN`, the returned result is `NaN`.
 * 
 * @throws NoSuchElementException if the array is empty.
 */
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
 * Returns the smallest value among all values produced by [selector] function applied to each element in the array.
 * 
 * @throws NoSuchElementException if the array is empty.
 */
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
 * Returns the smallest value among all values produced by [selector] function applied to each element in the array or `null` if there are no elements.
 * 
 * If any of values produced by [selector] function is `NaN`, the returned result is `NaN`.
 */
inline fun ByteBuffer.minOfOrNull(selector: (Byte) -> Double): Double? {
    if (isEmpty()) return null
    var minValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        minValue = minOf(minValue, v)
    }
    return minValue
}
/**
 * Returns the smallest value among all values produced by [selector] function applied to each element in the array or `null` if there are no elements.
 * 
 * If any of values produced by [selector] function is `NaN`, the returned result is `NaN`.
 */
inline fun ByteBuffer.minOfOrNull(selector: (Byte) -> Float): Float? {
    if (isEmpty()) return null
    var minValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        minValue = minOf(minValue, v)
    }
    return minValue
}
/** Returns the smallest value among all values produced by [selector] function applied to each element in the array or `null` if there are no elements. */
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
/**
 * Returns the smallest value according to the provided [comparator] among all values produced by [selector] function applied to each element in the array.
 * 
 * @throws NoSuchElementException if the array is empty.
 */
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
/**
 * Returns the smallest value according to the provided [comparator] among all values produced by [selector]
 * function applied to each element in the array or `null` if there are no elements.
 */
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
/** Returns the smallest element or `null` if there are no elements. */
fun ByteBuffer.minOrNull(): Byte? {
     if (isEmpty()) return null
     var min = this[0]
     for (i in 1..lastIndex) {
         val e = this[i]
         if (min > e) min = e
     }
     return min
 }
/**
 * Returns the first element having the smallest value according to the provided [comparator].
 * 
 * @throws NoSuchElementException if the array is empty.
 */
fun ByteBuffer.minWith(comparator: Comparator<in Byte>): Byte {
    if (isEmpty()) throw NoSuchElementException()
    var min = this[0]
    for (i in 1..lastIndex) {
        val e = this[i]
        if (comparator.compare(min, e) > 0) min = e
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
/** Returns `true` if the array has no elements. */
fun ByteBuffer.none(): Boolean = isEmpty()
/** Returns `true` if no elements match the given [predicate]. */
inline fun ByteBuffer.none(predicate: (Byte) -> Boolean): Boolean {
    for (element in this) if (predicate(element)) return false
    return true
}
/** Performs the given [action] on each element and returns the array itself afterwards. */
inline fun ByteBuffer.onEach(action: (Byte) -> Unit): ByteBuffer = apply { for (element in this) action(element) }
/**
 * Performs the given [action] on each element, providing sequential index with the element, and returns the array itself afterwards.
 * @param [action] function that takes the index of an element and the element itself and performs the action on the element.
 */
inline fun ByteBuffer.onEachIndexed(action: (index: Int, Byte) -> Unit): ByteBuffer = apply { forEachIndexed(action) }
/**
 * Accumulates value starting with the first element and applying [operation] from left to right to current accumulator value and each element.
 * 
 * Throws an exception if this array is empty. If the array can be empty in an expected way,
 * please use [reduceOrNull] instead. It returns `null` when its receiver is empty.
 * 
 * @param [operation] function that takes current accumulator value and an element, and calculates the next accumulator value.
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
 * to current accumulator value and each element with its index in the original array.
 * 
 * Throws an exception if this array is empty. If the array can be empty in an expected way,
 * please use [reduceIndexedOrNull] instead. It returns `null` when its receiver is empty.
 * 
 * @param [operation] function that takes the index of an element, current accumulator value and the element itself,
 * and calculates the next accumulator value.
 */
inline fun ByteBuffer.reduceIndexed(operation: (index: Int, acc: Byte, Byte) -> Byte): Byte {
    if (isEmpty())
        throw UnsupportedOperationException("Empty array can't be reduced.")
    var accumulator = this[0]
    for (index in 1..lastIndex)
        accumulator = operation(index, accumulator, this[index])
    return accumulator
}
/**
 * Accumulates value starting with the first element and applying [operation] from left to right
 * to current accumulator value and each element with its index in the original array.
 * 
 * Returns `null` if the array is empty.
 * 
 * @param [operation] function that takes the index of an element, current accumulator value and the element itself,
 * and calculates the next accumulator value.
 */
inline fun ByteBuffer.reduceIndexedOrNull(operation: (index: Int, acc: Byte, Byte) -> Byte): Byte? {
    if (isEmpty())
        return null
    var accumulator = this[0]
    for (index in 1..lastIndex)
        accumulator = operation(index, accumulator, this[index])
    return accumulator
}
/**
 * Accumulates value starting with the first element and applying [operation] from left to right to current accumulator value and each element.
 * 
 * Returns `null` if the array is empty.
 * 
 * @param [operation] function that takes current accumulator value and an element, and calculates the next accumulator value.
 */
inline fun ByteBuffer.reduceOrNull(operation: (acc: Byte, Byte) -> Byte): Byte? {
    if (isEmpty())
        return null
    var accumulator = this[0]
    for (index in 1..lastIndex)
        accumulator = operation(accumulator, this[index])
     return accumulator
}
/**
 * Accumulates value starting with the last element and applying [operation] from right to left to each element and current accumulator value.
 * 
 * Throws an exception if this array is empty. If the array can be empty in an expected way,
 * please use [reduceRightOrNull] instead. It returns `null` when its receiver is empty.
 * 
 * @param [operation] function that takes an element and current accumulator value, and calculates the next accumulator value.
 */
inline fun ByteBuffer.reduceRight(operation: (Byte, acc: Byte) -> Byte): Byte {
    var index = lastIndex
    if (index < 0) throw UnsupportedOperationException("Empty array can't be reduced.")
    var accumulator = get(index--)
    while (index >= 0)
        accumulator = operation(get(index--), accumulator)
    return accumulator
}
/**
 * Accumulates value starting with the last element and applying [operation] from right to left
 * to each element with its index in the original array and current accumulator value.
 * 
 * Throws an exception if this array is empty. If the array can be empty in an expected way,
 * please use [reduceRightIndexedOrNull] instead. It returns `null` when its receiver is empty.
 * 
 * @param [operation] function that takes the index of an element, the element itself and current accumulator value,
 * and calculates the next accumulator value.
 */
inline fun ByteBuffer.reduceRightIndexed(operation: (index: Int, Byte, acc: Byte) -> Byte): Byte {
    var index = lastIndex
    if (index < 0) throw UnsupportedOperationException("Empty array can't be reduced.")
    var accumulator = get(index--)
    while (index >= 0) {
        accumulator = operation(index, get(index), accumulator)
        --index
    }
    return accumulator
}
/**
 * Accumulates value starting with the last element and applying [operation] from right to left
 * to each element with its index in the original array and current accumulator value.
 * 
 * Returns `null` if the array is empty.
 * 
 * @param [operation] function that takes the index of an element, the element itself and current accumulator value,
 * and calculates the next accumulator value.
 */
inline fun ByteBuffer.reduceRightIndexedOrNull(operation: (index: Int, Byte, acc: Byte) -> Byte): Byte? {
    var index = lastIndex
    if (index < 0) return null
    var accumulator = get(index--)
    while (index >= 0) {
        accumulator = operation(index, get(index), accumulator)
        --index
    }
    return accumulator
}
/**
 * Accumulates value starting with the last element and applying [operation] from right to left to each element and current accumulator value.
 * 
 * Returns `null` if the array is empty.
 * 
 * @param [operation] function that takes an element and current accumulator value, and calculates the next accumulator value.
 */
inline fun ByteBuffer.reduceRightOrNull(operation: (Byte, acc: Byte) -> Byte): Byte? {
    var index = lastIndex
    if (index < 0) return null
    var accumulator = get(index--)
    while (index >= 0)
         accumulator = operation(get(index--), accumulator)
    return accumulator
}
/**
 * Splits the original array into pair of lists, where *first* list contains elements for which [predicate] 
 * yielded `true`, while *second* list contains elements for which [predicate] yielded `false`.
 */
inline fun ByteBuffer.partition(predicate: (Byte) -> Boolean): Pair<List<Byte>, List<Byte>> {
    val first = ArrayList<Byte>()
    val second = ArrayList<Byte>()
    for (element in this)
        if (predicate(element))
            first.add(element)
        else
            second.add(element)
    return Pair(first, second)
}
/**
 * Returns a list of pairs built from the elements of `this` array and the [other] array with the same index.
 * The returned list has length of the shortest collection.
 */
infix fun <R> ByteBuffer.zip(other: Array<out R>): List<Pair<Byte, R>> = zip(other) { t1, t2 -> t1 to t2 }
/**
 * Returns a list of values built from the elements of `this` array and the [other] array with the same index
 * using the provided [transform] function applied to each pair of elements.
 * The returned list has length of the shortest collection.
 */
inline fun <R, V> ByteBuffer.zip(other: Array<out R>, transform: (a: Byte, b: R) -> V): List<V> {
    val size = minOf(rem, other.size)
    val list = ArrayList<V>(size)
    for (i in 0 until size)
        list.add(transform(this[i], other[i]))
    return list
}
/**
 * Returns a list of pairs built from the elements of `this` collection and [other] array with the same index.
 * The returned list has length of the shortest collection.
 */
infix fun <R> ByteBuffer.zip(other: Iterable<R>): List<Pair<Byte, R>> = zip(other) { t1, t2 -> t1 to t2 }
/**
 * Returns a list of values built from the elements of `this` array and the [other] collection with the same index
 * using the provided [transform] function applied to each pair of elements.
 * The returned list has length of the shortest collection.
 */
inline fun <R, V> ByteBuffer.zip(other: Iterable<R>, transform: (a: Byte, b: R) -> V): List<V> {
    val arraySize = rem
    val list = ArrayList<V>(minOf(other.collectionSizeOrDefault(10), arraySize))
    var i = 0
    for (element in other) {
        if (i >= arraySize) break
        list.add(transform(this[i++], element))
    }
    return list
}
/**
 * Returns a list of pairs built from the elements of `this` array and the [other] array with the same index.
 * The returned list has length of the shortest collection.
 */
infix fun ByteBuffer.zip(other: ByteArray): List<Pair<Byte, Byte>> = zip(other) { t1, t2 -> t1 to t2 }
/**
 * Returns a list of values built from the elements of `this` array and the [other] array with the same index
 * using the provided [transform] function applied to each pair of elements.
 * The returned list has length of the shortest array.
 */
inline fun <V> ByteBuffer.zip(other: ByteArray, transform: (a: Byte, b: Byte) -> V): List<V> {
    val size = minOf(rem, other.size)
    val list = ArrayList<V>(size)
    for (i in 0 until size)
        list.add(transform(this[i], other[i]))
    return list
}
/**
 * Appends the string from all the elements separated using [separator] and using the given [prefix] and [postfix] if supplied.
 * 
 * If the collection could be huge, you can specify a non-negative value of [limit], in which case only the first [limit]
 * elements will be appended, followed by the [truncated] string (which defaults to "...").
 */
fun <A : Appendable> ByteBuffer.joinTo(buffer: A, separator: CharSequence = ", ", prefix: CharSequence = "", postfix: CharSequence = "", limit: Int = -1, truncated: CharSequence = "...", transform: ((Byte) -> CharSequence)? = null): A {
    buffer.append(prefix)
    var count = 0
    for (element in this) {
        if (++count > 1) buffer.append(separator)
        if (limit < 0 || count <= limit)
            if (transform != null)
                buffer.append(transform(element))
            else
                buffer.append(element.toString())
        else break
    }
    if (limit >= 0 && count > limit) buffer.append(truncated)
    buffer.append(postfix)
    return buffer
}
/**
 * Creates a string from all the elements separated using [separator] and using the given [prefix] and [postfix] if supplied.
 * 
 * If the collection could be huge, you can specify a non-negative value of [limit], in which case only the first [limit]
 * elements will be appended, followed by the [truncated] string (which defaults to "...").
 */
fun ByteBuffer.joinToString(separator: CharSequence = ", ", prefix: CharSequence = "", postfix: CharSequence = "", limit: Int = -1, truncated: CharSequence = "...", transform: ((Byte) -> CharSequence)? = null): String =
    joinTo(StringBuilder(), separator, prefix, postfix, limit, truncated, transform).toString()
/**
 * Returns 1st *element* from the buffer.
 * 
 * If the size of this array is less than 1, throws an [IndexOutOfBoundsException]
 */
inline operator fun ShortBuffer.component1(): Short = get(0)
/**
 * Returns 2nd *element* from the buffer.
 * 
 * If the size of this array is less than 2, throws an [IndexOutOfBoundsException]
 */
inline operator fun ShortBuffer.component2(): Short = get(1)
/**
 * Returns 3rd *element* from the buffer.
 * 
 * If the size of this array is less than 3, throws an [IndexOutOfBoundsException]
 */
inline operator fun ShortBuffer.component3(): Short = get(2)
/**
 * Returns 4th *element* from the buffer.
 * 
 * If the size of this array is less than 4, throws an [IndexOutOfBoundsException]
 */
inline operator fun ShortBuffer.component4(): Short = get(3)
/**
 * Returns 5th *element* from the buffer.
 * 
 * If the size of this array is less than 5, throws an [IndexOutOfBoundsException]
 */
inline operator fun ShortBuffer.component5(): Short = get(4)
/** Returns `true` if [element] is found in the array. */
operator fun ShortBuffer.contains(element: Short): Boolean = indexOf(element) >= 0
/** Returns an element at the given [index] or throws an [IndexOutOfBoundsException] if the [index] is out of bounds of this array. */
inline fun <T> ShortBuffer.elementAt(index: Int): Short = get(index)
/** Returns an element at the given [index] or the result of calling the [defaultValue] function if the [index] is out of bounds of this array. */
inline fun ShortBuffer.elementAtOrElse(index: Int, defaultValue: (Int) -> Short): Short = if (index >= 0 && index <= lastIndex) get(index) else defaultValue(index)
/** Returns an element at the given [index] or `null` if the [index] is out of bounds of this array. */
inline fun ShortBuffer.elementAtOrNull(index: Int): Short? = this.getOrNull(index)
/** Returns the first element matching the given [predicate], or `null` if no such element was found. */
inline fun ShortBuffer.find(predicate: (Short) -> Boolean): Short? = firstOrNull(predicate)
/** Returns the last element matching the given [predicate], or `null` if no such element was found. */
inline fun ShortBuffer.findLast(predicate: (Short) -> Boolean): Short? = lastOrNull(predicate)
/**
 * Returns the first element.
 * 
 * @throws NoSuchElementException if the array is empty.
 */
fun ShortBuffer.first(): Short {
    if (isEmpty())
        throw NoSuchElementException("Array is empty.")
    return this[0]
}
/**
 * Returns the first element matching the given [predicate].
 * @throws [NoSuchElementException] if no such element is found.
 */
inline fun ShortBuffer.first(predicate: (Short) -> Boolean): Short {
    for (element in this) if (predicate(element)) return element
    throw NoSuchElementException("Array contains no element matching the predicate.")
}
/** Returns the first element, or `null` if the array is empty. */
fun ShortBuffer.firstOrNull(): Short? = if (isEmpty()) null else this[0]
/** Returns the first element matching the given [predicate], or `null` if element was not found. */
inline fun ShortBuffer.firstOrNull(predicate: (Short) -> Boolean): Short? {
    for (element in this) if (predicate(element)) return element
    return null
}
/** Returns an element at the given [index] or the result of calling the [defaultValue] function if the [index] is out of bounds of this array. */
inline fun ShortBuffer.getOrElse(index: Int, defaultValue: (Int) -> Short): Short = if (index >= 0 && index <= lastIndex) get(index) else defaultValue(index)
/** Returns an element at the given [index] or `null` if the [index] is out of bounds of this array. */
fun ShortBuffer.getOrNull(index: Int): Short? = if (index >= 0 && index <= lastIndex) get(index) else null
/** Returns first index of [element], or -1 if the array does not contain element. */
fun ShortBuffer.indexOf(element: Short): Int {
    for (index in indices)
        if (element == this[index])
            return index
    return -1
}
/** Returns index of the first element matching the given [predicate], or -1 if the array does not contain such element. */
inline fun ShortBuffer.indexOfFirst(predicate: (Short) -> Boolean): Int {
    for (index in indices)
        if (predicate(this[index]))
            return index
    return -1
}
/** Returns index of the last element matching the given [predicate], or -1 if the array does not contain such element. */
inline fun ShortBuffer.indexOfLast(predicate: (Short) -> Boolean): Int {
    for (index in indices.reversed())
        if (predicate(this[index]))
            return index
    return -1
}
/**
 * Returns the last element.
 * 
 * @throws NoSuchElementException if the array is empty.
 */
fun ShortBuffer.last(): Short {
    if (isEmpty())
        throw NoSuchElementException("Array is empty.")
    return this[lastIndex]
}
/**
 * Returns the last element matching the given [predicate].
 * 
 * @throws NoSuchElementException if no such element is found.
 */
inline fun ShortBuffer.last(predicate: (Short) -> Boolean): Short {
    for (index in this.indices.reversed()) {
        val element = this[index]
        if (predicate(element)) return element
    }
    throw NoSuchElementException("Array contains no element matching the predicate.")
}
/** Returns last index of [element], or -1 if the array does not contain element. */
fun ShortBuffer.lastIndexOf(element: Short): Int {
    for (index in indices.reversed())
        if (element == this[index])
            return index
    return -1
}
/** Returns the last element, or `null` if the array is empty. */
fun ShortBuffer.lastOrNull(): Short? = if (isEmpty()) null else this[rem - 1]
/** Returns the last element matching the given [predicate], or `null` if no such element was found. */
inline fun ShortBuffer.lastOrNull(predicate: (Short) -> Boolean): Short? {
    for (index in this.indices.reversed()) {
        val element = this[index]
        if (predicate(element)) return element
    }
    return null
}
/** Returns the single element, or throws an exception if the array is empty or has more than one element. */
fun ShortBuffer.single(): Short = when (rem) {
    0 -> throw NoSuchElementException("Array is empty.")
    1 -> this[0]
    else -> throw IllegalArgumentException("Array has more than one element.")
}
/** Returns the single element matching the given [predicate], or throws exception if there is no or more than one matching element. */
inline fun ShortBuffer.single(predicate: (Short) -> Boolean): Short {
    var single: Short? = null
    var found = false
    for (element in this)
        if (predicate(element)) {
            if (found) throw IllegalArgumentException("Array contains more than one matching element.")
            single = element
            found = true
        }
    if (!found) throw NoSuchElementException("Array contains no element matching the predicate.")
    @Suppress("UNCHECKED_CAST")
    return single as Short
}
/** Returns single element, or `null` if the array is empty or has more than one element. */
fun ShortBuffer.singleOrNull(): Short? = if (rem == 1) this[0] else null
/** Returns the single element matching the given [predicate], or `null` if element was not found or more than one element was found. */
inline fun ShortBuffer.singleOrNull(predicate: (Short) -> Boolean): Short? {
    var single: Short? = null
    var found = false
    for (element in this)
        if (predicate(element)) {
            if (found) return null
            single = element
            found = true
        }
    if (!found) return null
    return single
}
/** Returns a list containing only elements matching the given [predicate]. */
inline fun ShortBuffer.filter(predicate: (Short) -> Boolean): List<Short> = filterTo(ArrayList<Short>(), predicate)
/**
 * Returns a list containing only elements matching the given [predicate].
 * @param [predicate] function that takes the index of an element and the element itself and returns the result of predicate evaluation on the element.
 */
inline fun ShortBuffer.filterIndexed(predicate: (index: Int, Short) -> Boolean): List<Short> = filterIndexedTo(ArrayList<Short>(), predicate)
/**
 * Appends all elements matching the given [predicate] to the given [destination].
 * @param [predicate] function that takes the index of an element and the element itself and returns the result of predicate evaluation on the element.
 */
inline fun <C : MutableCollection<in Short>> ShortBuffer.filterIndexedTo(destination: C, predicate: (index: Int, Short) -> Boolean): C {
    forEachIndexed { index, element ->
        if (predicate(index, element)) destination.add(element)
    }
    return destination
}
/** Returns a list containing all elements not matching the given [predicate]. */
inline fun ShortBuffer.filterNot(predicate: (Short) -> Boolean): List<Short> = filterNotTo(ArrayList<Short>(), predicate)
/** Appends all elements not matching the given [predicate] to the given [destination]. */
inline fun <C : MutableCollection<in Short>> ShortBuffer.filterNotTo(destination: C, predicate: (Short) -> Boolean): C {
     for (element in this) if (!predicate(element)) destination.add(element)
     return destination
}
/** Appends all elements matching the given [predicate] to the given [destination]. */
inline fun <C : MutableCollection<in Short>> ShortBuffer.filterTo(destination: C, predicate: (Short) -> Boolean): C {
     for (element in this) if (predicate(element)) destination.add(element)
     return destination
}
/** Returns a list containing elements at specified [indices]. */
fun ShortBuffer.slice(indices: Iterable<Int>): List<Short> {
    val size = indices.collectionSizeOrDefault(10)
    if (size == 0) return emptyList()
    val list = ArrayList<Short>(size)
    for (index in indices)
        list.add(get(index))
    return list
}
/** Returns an array containing elements of this array at specified [indices]. */
fun ShortBuffer.sliceArray(indices: Collection<Int>): ShortArray {
    val result = ShortArray(indices.size)
    var targetIndex = 0
    for (sourceIndex in indices)
        result[targetIndex++] = this[sourceIndex]
    return result
}
/** Sorts elements in the array in-place descending according to their natural sort order. */
fun ShortBuffer.sortDescending() {
    if (rem > 1) {
        val array = toShortArray().apply{ sortDescending() }
        for (i in 0 until rem)
            this[pos + i] = array[i]
    }
}
/** Returns a list of all elements sorted according to their natural sort order. */
fun ShortBuffer.sorted(): List<Short> = toTypedArray().apply { sort() }.asList()
/** Returns an array with all elements of this array sorted according to their natural sort order. */
fun ShortBuffer.sortedArray(): ShortArray = toShortArray().apply { sort() }
/** Returns an array with all elements of this array sorted descending according to their natural sort order. */
fun ShortBuffer.sortedArrayDescending(): ShortArray = toShortArray().apply { sortDescending() }
/** Returns a list of all elements sorted according to natural sort order of the value returned by specified [selector] function. */
inline fun <R : Comparable<R>> ShortBuffer.sortedBy(crossinline selector: (Short) -> R?): List<Short> = toShortArray().sortedWith(compareBy(selector))
/** Returns a list of all elements sorted descending according to natural sort order of the value returned by specified [selector] function. */
inline fun <R : Comparable<R>> ShortBuffer.sortedByDescending(crossinline selector: (Short) -> R?): List<Short> = toShortArray().sortedWith(compareByDescending(selector))
/** Returns a list of all elements sorted descending according to their natural sort order. */
fun ShortBuffer.sortedDescending(): List<Short> = toShortArray().apply { sort() }.reversed()
/** Returns a list of all elements sorted according to the specified [comparator]. */
fun ShortBuffer.sortedWith(comparator: Comparator<in Short>): List<Short> = toTypedArray().apply { sortWith(comparator) }.asList()
/** Sorts the array in-place. */
fun ShortBuffer.sort() {
    if (rem > 1) {
        val array = toShortArray().apply{ sort() }
        for (i in 0 until rem)
            this[pos + i] = array[i]
    }
}
/** Returns a string representation of the contents of the specified array as if it is [List]. */
fun ShortBuffer.contentToString(): String {
    val iMax = lim - 1
    if (iMax == -1) return "[]"
    val b = StringBuilder()
    b.append('[')
    var i = 0
    while (true) {
        b.append(get(i))
        if (i == iMax) return b.append(']').toString()
        b.append(", ")
        i++
    }
}
/**
 * Fills this array or its subrange with the specified [element] value.
 * 
 * @param fromIndex the start of the range (inclusive) to fill, 0 by default.
 * @param toIndex the end of the range (exclusive) to fill, size of this array by default.
 * 
 * @throws IndexOutOfBoundsException if [fromIndex] is less than zero or [toIndex] is greater than the size of this array.
 * @throws IllegalArgumentException if [fromIndex] is greater than [toIndex].
 */
fun ShortBuffer.fill(element: Short, fromIndex: Int = pos, toIndex: Int = rem) {
    for (i in fromIndex until toIndex)
        this[i] = element
}
/** Returns the range of valid indices for the array. */
val ShortBuffer.indices: IntRange
    get() = IntRange(0, lastIndex)
/** Returns `true` if the array is empty. */
inline fun ShortBuffer.isEmpty(): Boolean = rem == 0
/** Returns `true` if the array is not empty. */
inline fun ShortBuffer.isNotEmpty(): Boolean = !isEmpty()
/** Returns the last valid index for the array. */
val ShortBuffer.lastIndex: Int
    get() = rem - 1
/** Returns an array of Byte containing all of the elements of this generic array. */
fun ShortBuffer.toShortArray(): ShortArray = ShortArray(rem) { index -> this[index] }
/** Returns a *typed* object array containing all of the elements of this primitive array. */
fun ShortBuffer.toTypedArray(): Array<Short> = Array(rem) { index -> this[index] }
/**
 * Returns a [Map] containing key-value pairs provided by [transform] function applied to elements of the given array.
 * 
 * If any of two pairs would have the same key the last one gets added to the map.
 * 
 * The returned map preserves the entry iteration order of the original array.
 */
inline fun <K, V> ShortBuffer.associate(transform: (Short) -> Pair<K, V>): Map<K, V> {
    val capacity = mapCapacity(rem).coerceAtLeast(16)
    return associateTo(LinkedHashMap<K, V>(capacity), transform)
}
/**
 * Returns a [Map] containing the elements from the given array indexed by the key returned from [keySelector] function applied to each element.
 * 
 * If any two elements would have the same key returned by [keySelector] the last one gets added to the map.
 * 
 * The returned map preserves the entry iteration order of the original array.
 */
inline fun <K> ShortBuffer.associateBy(keySelector: (Short) -> K): Map<K, Short> {
    val capacity = mapCapacity(rem).coerceAtLeast(16)
    return associateByTo(LinkedHashMap<K, Short>(capacity), keySelector)
}
/**
 * Returns a [Map] containing the values provided by [valueTransform] and indexed by [keySelector] functions applied to elements of the given array.
 * 
 * If any two elements would have the same key returned by [keySelector] the last one gets added to the map.
 * 
 * The returned map preserves the entry iteration order of the original array.
 */
inline fun <K, V> ShortBuffer.associateBy(keySelector: (Short) -> K, valueTransform: (Short) -> V): Map<K, V> {
    val capacity = mapCapacity(rem).coerceAtLeast(16)
    return associateByTo(LinkedHashMap<K, V>(capacity), keySelector, valueTransform)
}
/**
 * Populates and returns the [destination] mutable map with key-value pairs, where key is provided by
 * the [keySelector] function applied to each element of the given array and value is the element itself.
 * 
 * If any two elements would have the same key returned by [keySelector] the last one gets added to the map.
 */
inline fun <K, M : MutableMap<in K, in Short>> ShortBuffer.associateByTo(destination: M, keySelector: (Short) -> K): M {
    for (element in this)
        destination.put(keySelector(element), element)
    return destination
}
/**
 * Populates and returns the [destination] mutable map with key-value pairs, where key is provided by the [keySelector]
 * function and and value is provided by the [valueTransform] function applied to elements of the given array.
 * 
 * If any two elements would have the same key returned by [keySelector] the last one gets added to the map.
 */
inline fun <K, V, M : MutableMap<in K, in V>> ShortBuffer.associateByTo(destination: M, keySelector: (Short) -> K, valueTransform: (Short) -> V): M {
    for (element in this)
        destination.put(keySelector(element), valueTransform(element))
    return destination
}
/**
 * Populates and returns the [destination] mutable map with key-value pairs provided by [transform] function
 * applied to each element of the given array.
 * 
 * If any of two pairs would have the same key the last one gets added to the map.
 */
inline fun <K, V, M : MutableMap<in K, in V>> ShortBuffer.associateTo(destination: M, transform: (Short) -> Pair<K, V>): M {
    for (element in this)
        destination += transform(element)
    return destination
}
/**
 * Returns a [Map] where keys are elements from the given array and values are produced by the [valueSelector] function applied to each element.
 * 
 * If any two elements are equal, the last one gets added to the map.
 * 
 * The returned map preserves the entry iteration order of the original array.
 */
inline fun <V> ShortBuffer.associateWith(valueSelector: (Short) -> V): Map<Short, V> {
    val result = LinkedHashMap<Short, V>(mapCapacity(rem).coerceAtLeast(16))
    return associateWithTo(result, valueSelector)
}
/**
 * Populates and returns the [destination] mutable map with key-value pairs for each element of the given array,
 * where key is the element itself and value is provided by the [valueSelector] function applied to that key.
 * 
 * If any two elements are equal, the last one overwrites the former value in the map.
 */
inline fun <V, M : MutableMap<in Short, in V>> ShortBuffer.associateWithTo(destination: M, valueSelector: (Short) -> V): M {
    for (element in this)
        destination.put(element, valueSelector(element))
    return destination
}
/** Appends all elements to the given [destination] collection. */
fun <C : MutableCollection<in Short>> ShortBuffer.toCollection(destination: C): C {
    for (item in this)
        destination.add(item)
    return destination
}
/** Returns a single list of all elements yielded from results of [transform] function being invoked on each element of original array. */
inline fun <R> ShortBuffer.flatMap(transform: (Short) -> Iterable<R>): List<R> = flatMapTo(ArrayList<R>(), transform)
/** Appends all elements yielded from results of [transform] function being invoked on each element of original array, to the given [destination]. */
inline fun <R, C : MutableCollection<in R>> ShortBuffer.flatMapTo(destination: C, transform: (Short) -> Iterable<R>): C {
    for (element in this) {
        val list = transform(element)
        destination.addAll(list)
    }
    return destination
}
/**
 * Groups elements of the original array by the key returned by the given [keySelector] function applied to
 * each element and returns a map where each group key is associated with a list of corresponding elements.
 * 
 * The returned map preserves the entry iteration order of the keys produced from the original array.
 */
inline fun <K> ShortBuffer.groupBy(keySelector: (Short) -> K): Map<K, List<Short>> = groupByTo(LinkedHashMap<K, MutableList<Short>>(), keySelector)
/**
 * Groups values returned by the [valueTransform] function applied to each element of the original array
 * by the key returned by the given [keySelector] function applied to the element
 * and returns a map where each group key is associated with a list of corresponding values.
 * 
 * The returned map preserves the entry iteration order of the keys produced from the original array.
 */
inline fun <K, V> ShortBuffer.groupBy(keySelector: (Short) -> K, valueTransform: (Short) -> V): Map<K, List<V>> = groupByTo(LinkedHashMap<K, MutableList<V>>(), keySelector, valueTransform)
/**
 * Groups elements of the original array by the key returned by the given [keySelector] function applied to each
 * element and puts to the [destination] map each group key associated with a list of corresponding elements.
 * 
 * @return The [destination] map.
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
 * Groups values returned by the [valueTransform] function applied to each element of the original array
 * by the key returned by the given [keySelector] function applied to the element
 * and puts to the [destination] map each group key associated with a list of corresponding values.
 * 
 * @return The [destination] map.
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
 * Returns a list containing only distinct elements from the given array.
 * 
 * The elements in the resulting list are in the same order as they were in the source array.
 */
fun ShortBuffer.distinct(): List<Short> = this.toMutableSet().toList()
/**
 * Returns a list containing only elements from the given array having distinct keys returned by the given [selector] function.
 * 
 * The elements in the resulting list are in the same order as they were in the source array.
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
 * Returns a new [MutableSet] containing all distinct elements from the given array.
 * 
 * The returned set preserves the element iteration order of the original array.
 */
fun ShortBuffer.toMutableSet(): MutableSet<Short> = toCollection(LinkedHashSet<Short>(mapCapacity(rem)))
/** Returns a list containing the results of applying the given [transform] function to each element in the original array. */
inline fun <R> ShortBuffer.map(transform: (Short) -> R): List<R> = mapTo(ArrayList<R>(rem), transform)
/**
 * Returns a list containing the results of applying the given [transform] function to each element and its index in the original array.
 * @param [transform] function that takes the index of an element and the element itself and returns the result of the transform applied to the element.
 */
inline fun <R> ShortBuffer.mapIndexed(transform: (index: Int, Short) -> R): List<R> = mapIndexedTo(ArrayList<R>(rem), transform)
/**
 * Applies the given [transform] function to each element and its index in the original array and appends the results to the given [destination].
 * @param [transform] function that takes the index of an element and the element itself and returns the result of the transform applied to the element.
 */
inline fun <R, C : MutableCollection<in R>> ShortBuffer.mapIndexedTo(destination: C, transform: (index: Int, Short) -> R): C {
    var index = 0
    for (item in this)
        destination.add(transform(index++, item))
    return destination
}
/** Applies the given [transform] function to each element of the original array and appends the results to the given [destination]. */
inline fun <R, C : MutableCollection<in R>> ShortBuffer.mapTo(destination: C, transform: (Short) -> R): C {
    for (item in this)
        destination.add(transform(item))
    return destination
}
/** Returns `true` if all elements match the given [predicate]. */
inline fun ShortBuffer.all(predicate: (Short) -> Boolean): Boolean {
    for (element in this) if (!predicate(element)) return false
    return true
}
/** Returns `true` if array has at least one element. */
fun ShortBuffer.any(): Boolean = !isEmpty()
/** Returns `true` if at least one element matches the given [predicate]. */
inline fun ShortBuffer.any(predicate: (Short) -> Boolean): Boolean {
    for (element in this) if (predicate(element)) return true
    return false
}
/** Returns the number of elements in this array. */
inline fun ShortBuffer.count(): Int = rem
/** Returns the number of elements matching the given [predicate]. */
inline fun ShortBuffer.count(predicate: (Short) -> Boolean): Int {
    var count = 0
    for (element in this) if (predicate(element)) ++count
    return count
}
/** Performs the given [action] on each element. */
inline fun ShortBuffer.forEach(action: (Short) -> Unit) { for (element in this) action(element) }
/**
 * Performs the given [action] on each element, providing sequential index with the element.
 * @param [action] function that takes the index of an element and the element itself and performs the action on the element.
 */
inline fun ShortBuffer.forEachIndexed(action: (index: Int, Short) -> Unit): Unit {
    var index = 0
    for (item in this) action(index++, item)
}
/**
 * Returns the largest element.
 * 
 * @throws NoSuchElementException if the array is empty.
 */
fun ShortBuffer.max(): Short {
    if (isEmpty()) throw NoSuchElementException()
    var max = this[0]
    for (i in 1..lastIndex) {
        val e = this[i]
        if (max < e) max = e
    }
    return max
}
/**
 * Returns the first element yielding the largest value of the given function.
 * 
 * @throws NoSuchElementException if the array is empty.
 */
inline fun <R : Comparable<R>> ShortBuffer.maxBy(selector: (Short) -> R): Short {
    if (isEmpty()) throw NoSuchElementException()
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
/** Returns the first element yielding the largest value of the given function or `null` if there are no elements. */
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
/**
 * Returns the first element having the largest value according to the provided [comparator].
 * 
 * @throws NoSuchElementException if the array is empty.
 */
fun ShortBuffer.maxWith(comparator: Comparator<in Short>): Short {
    if (isEmpty()) throw NoSuchElementException()
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
/**
 * Returns the smallest element.
 * 
 * @throws NoSuchElementException if the array is empty.
 */
fun ShortBuffer.min(): Short {
    if (isEmpty()) throw NoSuchElementException()
    var min = this[0]
    for (i in 1..lastIndex) {
        val e = this[i]
        if (min > e) min = e
    }
    return min
}
/**
 * Returns the first element yielding the smallest value of the given function.
 * 
 * @throws NoSuchElementException if the array is empty.
 */
inline fun <R : Comparable<R>> ShortBuffer.minBy(selector: (Short) -> R): Short {
    if (isEmpty()) throw NoSuchElementException()
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
 * Returns the first element yielding the smallest value of the given function or `null` if there are no elements.
 * 
 * @sample samples.collections.Collections.Aggregates.minByOrNull
 */
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
/**
 * Returns the smallest value among all values produced by [selector] function applied to each element in the array.
 * 
 * If any of values produced by [selector] function is `NaN`, the returned result is `NaN`.
 * 
 * @throws NoSuchElementException if the array is empty.
 */
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
 * Returns the smallest value among all values produced by [selector] function applied to each element in the array.
 * 
 * If any of values produced by [selector] function is `NaN`, the returned result is `NaN`.
 * 
 * @throws NoSuchElementException if the array is empty.
 */
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
 * Returns the smallest value among all values produced by [selector] function applied to each element in the array.
 * 
 * @throws NoSuchElementException if the array is empty.
 */
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
 * Returns the smallest value among all values produced by [selector] function applied to each element in the array or `null` if there are no elements.
 * 
 * If any of values produced by [selector] function is `NaN`, the returned result is `NaN`.
 */
inline fun ShortBuffer.minOfOrNull(selector: (Short) -> Double): Double? {
    if (isEmpty()) return null
    var minValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        minValue = minOf(minValue, v)
    }
    return minValue
}
/**
 * Returns the smallest value among all values produced by [selector] function applied to each element in the array or `null` if there are no elements.
 * 
 * If any of values produced by [selector] function is `NaN`, the returned result is `NaN`.
 */
inline fun ShortBuffer.minOfOrNull(selector: (Short) -> Float): Float? {
    if (isEmpty()) return null
    var minValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        minValue = minOf(minValue, v)
    }
    return minValue
}
/** Returns the smallest value among all values produced by [selector] function applied to each element in the array or `null` if there are no elements. */
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
/**
 * Returns the smallest value according to the provided [comparator] among all values produced by [selector] function applied to each element in the array.
 * 
 * @throws NoSuchElementException if the array is empty.
 */
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
/**
 * Returns the smallest value according to the provided [comparator] among all values produced by [selector]
 * function applied to each element in the array or `null` if there are no elements.
 */
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
/** Returns the smallest element or `null` if there are no elements. */
fun ShortBuffer.minOrNull(): Short? {
     if (isEmpty()) return null
     var min = this[0]
     for (i in 1..lastIndex) {
         val e = this[i]
         if (min > e) min = e
     }
     return min
 }
/**
 * Returns the first element having the smallest value according to the provided [comparator].
 * 
 * @throws NoSuchElementException if the array is empty.
 */
fun ShortBuffer.minWith(comparator: Comparator<in Short>): Short {
    if (isEmpty()) throw NoSuchElementException()
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
/** Returns `true` if the array has no elements. */
fun ShortBuffer.none(): Boolean = isEmpty()
/** Returns `true` if no elements match the given [predicate]. */
inline fun ShortBuffer.none(predicate: (Short) -> Boolean): Boolean {
    for (element in this) if (predicate(element)) return false
    return true
}
/** Performs the given [action] on each element and returns the array itself afterwards. */
inline fun ShortBuffer.onEach(action: (Short) -> Unit): ShortBuffer = apply { for (element in this) action(element) }
/**
 * Performs the given [action] on each element, providing sequential index with the element, and returns the array itself afterwards.
 * @param [action] function that takes the index of an element and the element itself and performs the action on the element.
 */
inline fun ShortBuffer.onEachIndexed(action: (index: Int, Short) -> Unit): ShortBuffer = apply { forEachIndexed(action) }
/**
 * Accumulates value starting with the first element and applying [operation] from left to right to current accumulator value and each element.
 * 
 * Throws an exception if this array is empty. If the array can be empty in an expected way,
 * please use [reduceOrNull] instead. It returns `null` when its receiver is empty.
 * 
 * @param [operation] function that takes current accumulator value and an element, and calculates the next accumulator value.
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
 * to current accumulator value and each element with its index in the original array.
 * 
 * Throws an exception if this array is empty. If the array can be empty in an expected way,
 * please use [reduceIndexedOrNull] instead. It returns `null` when its receiver is empty.
 * 
 * @param [operation] function that takes the index of an element, current accumulator value and the element itself,
 * and calculates the next accumulator value.
 */
inline fun ShortBuffer.reduceIndexed(operation: (index: Int, acc: Short, Short) -> Short): Short {
    if (isEmpty())
        throw UnsupportedOperationException("Empty array can't be reduced.")
    var accumulator = this[0]
    for (index in 1..lastIndex)
        accumulator = operation(index, accumulator, this[index])
    return accumulator
}
/**
 * Accumulates value starting with the first element and applying [operation] from left to right
 * to current accumulator value and each element with its index in the original array.
 * 
 * Returns `null` if the array is empty.
 * 
 * @param [operation] function that takes the index of an element, current accumulator value and the element itself,
 * and calculates the next accumulator value.
 */
inline fun ShortBuffer.reduceIndexedOrNull(operation: (index: Int, acc: Short, Short) -> Short): Short? {
    if (isEmpty())
        return null
    var accumulator = this[0]
    for (index in 1..lastIndex)
        accumulator = operation(index, accumulator, this[index])
    return accumulator
}
/**
 * Accumulates value starting with the first element and applying [operation] from left to right to current accumulator value and each element.
 * 
 * Returns `null` if the array is empty.
 * 
 * @param [operation] function that takes current accumulator value and an element, and calculates the next accumulator value.
 */
inline fun ShortBuffer.reduceOrNull(operation: (acc: Short, Short) -> Short): Short? {
    if (isEmpty())
        return null
    var accumulator = this[0]
    for (index in 1..lastIndex)
        accumulator = operation(accumulator, this[index])
     return accumulator
}
/**
 * Accumulates value starting with the last element and applying [operation] from right to left to each element and current accumulator value.
 * 
 * Throws an exception if this array is empty. If the array can be empty in an expected way,
 * please use [reduceRightOrNull] instead. It returns `null` when its receiver is empty.
 * 
 * @param [operation] function that takes an element and current accumulator value, and calculates the next accumulator value.
 */
inline fun ShortBuffer.reduceRight(operation: (Short, acc: Short) -> Short): Short {
    var index = lastIndex
    if (index < 0) throw UnsupportedOperationException("Empty array can't be reduced.")
    var accumulator = get(index--)
    while (index >= 0)
        accumulator = operation(get(index--), accumulator)
    return accumulator
}
/**
 * Accumulates value starting with the last element and applying [operation] from right to left
 * to each element with its index in the original array and current accumulator value.
 * 
 * Throws an exception if this array is empty. If the array can be empty in an expected way,
 * please use [reduceRightIndexedOrNull] instead. It returns `null` when its receiver is empty.
 * 
 * @param [operation] function that takes the index of an element, the element itself and current accumulator value,
 * and calculates the next accumulator value.
 */
inline fun ShortBuffer.reduceRightIndexed(operation: (index: Int, Short, acc: Short) -> Short): Short {
    var index = lastIndex
    if (index < 0) throw UnsupportedOperationException("Empty array can't be reduced.")
    var accumulator = get(index--)
    while (index >= 0) {
        accumulator = operation(index, get(index), accumulator)
        --index
    }
    return accumulator
}
/**
 * Accumulates value starting with the last element and applying [operation] from right to left
 * to each element with its index in the original array and current accumulator value.
 * 
 * Returns `null` if the array is empty.
 * 
 * @param [operation] function that takes the index of an element, the element itself and current accumulator value,
 * and calculates the next accumulator value.
 */
inline fun ShortBuffer.reduceRightIndexedOrNull(operation: (index: Int, Short, acc: Short) -> Short): Short? {
    var index = lastIndex
    if (index < 0) return null
    var accumulator = get(index--)
    while (index >= 0) {
        accumulator = operation(index, get(index), accumulator)
        --index
    }
    return accumulator
}
/**
 * Accumulates value starting with the last element and applying [operation] from right to left to each element and current accumulator value.
 * 
 * Returns `null` if the array is empty.
 * 
 * @param [operation] function that takes an element and current accumulator value, and calculates the next accumulator value.
 */
inline fun ShortBuffer.reduceRightOrNull(operation: (Short, acc: Short) -> Short): Short? {
    var index = lastIndex
    if (index < 0) return null
    var accumulator = get(index--)
    while (index >= 0)
         accumulator = operation(get(index--), accumulator)
    return accumulator
}
/**
 * Splits the original array into pair of lists, where *first* list contains elements for which [predicate] 
 * yielded `true`, while *second* list contains elements for which [predicate] yielded `false`.
 */
inline fun ShortBuffer.partition(predicate: (Short) -> Boolean): Pair<List<Short>, List<Short>> {
    val first = ArrayList<Short>()
    val second = ArrayList<Short>()
    for (element in this)
        if (predicate(element))
            first.add(element)
        else
            second.add(element)
    return Pair(first, second)
}
/**
 * Returns a list of pairs built from the elements of `this` array and the [other] array with the same index.
 * The returned list has length of the shortest collection.
 */
infix fun <R> ShortBuffer.zip(other: Array<out R>): List<Pair<Short, R>> = zip(other) { t1, t2 -> t1 to t2 }
/**
 * Returns a list of values built from the elements of `this` array and the [other] array with the same index
 * using the provided [transform] function applied to each pair of elements.
 * The returned list has length of the shortest collection.
 */
inline fun <R, V> ShortBuffer.zip(other: Array<out R>, transform: (a: Short, b: R) -> V): List<V> {
    val size = minOf(rem, other.size)
    val list = ArrayList<V>(size)
    for (i in 0 until size)
        list.add(transform(this[i], other[i]))
    return list
}
/**
 * Returns a list of pairs built from the elements of `this` collection and [other] array with the same index.
 * The returned list has length of the shortest collection.
 */
infix fun <R> ShortBuffer.zip(other: Iterable<R>): List<Pair<Short, R>> = zip(other) { t1, t2 -> t1 to t2 }
/**
 * Returns a list of values built from the elements of `this` array and the [other] collection with the same index
 * using the provided [transform] function applied to each pair of elements.
 * The returned list has length of the shortest collection.
 */
inline fun <R, V> ShortBuffer.zip(other: Iterable<R>, transform: (a: Short, b: R) -> V): List<V> {
    val arraySize = rem
    val list = ArrayList<V>(minOf(other.collectionSizeOrDefault(10), arraySize))
    var i = 0
    for (element in other) {
        if (i >= arraySize) break
        list.add(transform(this[i++], element))
    }
    return list
}
/**
 * Returns a list of pairs built from the elements of `this` array and the [other] array with the same index.
 * The returned list has length of the shortest collection.
 */
infix fun ShortBuffer.zip(other: ShortArray): List<Pair<Short, Short>> = zip(other) { t1, t2 -> t1 to t2 }
/**
 * Returns a list of values built from the elements of `this` array and the [other] array with the same index
 * using the provided [transform] function applied to each pair of elements.
 * The returned list has length of the shortest array.
 */
inline fun <V> ShortBuffer.zip(other: ShortArray, transform: (a: Short, b: Short) -> V): List<V> {
    val size = minOf(rem, other.size)
    val list = ArrayList<V>(size)
    for (i in 0 until size)
        list.add(transform(this[i], other[i]))
    return list
}
/**
 * Appends the string from all the elements separated using [separator] and using the given [prefix] and [postfix] if supplied.
 * 
 * If the collection could be huge, you can specify a non-negative value of [limit], in which case only the first [limit]
 * elements will be appended, followed by the [truncated] string (which defaults to "...").
 */
fun <A : Appendable> ShortBuffer.joinTo(buffer: A, separator: CharSequence = ", ", prefix: CharSequence = "", postfix: CharSequence = "", limit: Int = -1, truncated: CharSequence = "...", transform: ((Short) -> CharSequence)? = null): A {
    buffer.append(prefix)
    var count = 0
    for (element in this) {
        if (++count > 1) buffer.append(separator)
        if (limit < 0 || count <= limit)
            if (transform != null)
                buffer.append(transform(element))
            else
                buffer.append(element.toString())
        else break
    }
    if (limit >= 0 && count > limit) buffer.append(truncated)
    buffer.append(postfix)
    return buffer
}
/**
 * Creates a string from all the elements separated using [separator] and using the given [prefix] and [postfix] if supplied.
 * 
 * If the collection could be huge, you can specify a non-negative value of [limit], in which case only the first [limit]
 * elements will be appended, followed by the [truncated] string (which defaults to "...").
 */
fun ShortBuffer.joinToString(separator: CharSequence = ", ", prefix: CharSequence = "", postfix: CharSequence = "", limit: Int = -1, truncated: CharSequence = "...", transform: ((Short) -> CharSequence)? = null): String =
    joinTo(StringBuilder(), separator, prefix, postfix, limit, truncated, transform).toString()
/**
 * Returns 1st *element* from the buffer.
 * 
 * If the size of this array is less than 1, throws an [IndexOutOfBoundsException]
 */
inline operator fun IntBuffer.component1(): Int = get(0)
/**
 * Returns 2nd *element* from the buffer.
 * 
 * If the size of this array is less than 2, throws an [IndexOutOfBoundsException]
 */
inline operator fun IntBuffer.component2(): Int = get(1)
/**
 * Returns 3rd *element* from the buffer.
 * 
 * If the size of this array is less than 3, throws an [IndexOutOfBoundsException]
 */
inline operator fun IntBuffer.component3(): Int = get(2)
/**
 * Returns 4th *element* from the buffer.
 * 
 * If the size of this array is less than 4, throws an [IndexOutOfBoundsException]
 */
inline operator fun IntBuffer.component4(): Int = get(3)
/**
 * Returns 5th *element* from the buffer.
 * 
 * If the size of this array is less than 5, throws an [IndexOutOfBoundsException]
 */
inline operator fun IntBuffer.component5(): Int = get(4)
/** Returns `true` if [element] is found in the array. */
operator fun IntBuffer.contains(element: Int): Boolean = indexOf(element) >= 0
/** Returns an element at the given [index] or throws an [IndexOutOfBoundsException] if the [index] is out of bounds of this array. */
inline fun <T> IntBuffer.elementAt(index: Int): Int = get(index)
/** Returns an element at the given [index] or the result of calling the [defaultValue] function if the [index] is out of bounds of this array. */
inline fun IntBuffer.elementAtOrElse(index: Int, defaultValue: (Int) -> Int): Int = if (index >= 0 && index <= lastIndex) get(index) else defaultValue(index)
/** Returns an element at the given [index] or `null` if the [index] is out of bounds of this array. */
inline fun IntBuffer.elementAtOrNull(index: Int): Int? = this.getOrNull(index)
/** Returns the first element matching the given [predicate], or `null` if no such element was found. */
inline fun IntBuffer.find(predicate: (Int) -> Boolean): Int? = firstOrNull(predicate)
/** Returns the last element matching the given [predicate], or `null` if no such element was found. */
inline fun IntBuffer.findLast(predicate: (Int) -> Boolean): Int? = lastOrNull(predicate)
/**
 * Returns the first element.
 * 
 * @throws NoSuchElementException if the array is empty.
 */
fun IntBuffer.first(): Int {
    if (isEmpty())
        throw NoSuchElementException("Array is empty.")
    return this[0]
}
/**
 * Returns the first element matching the given [predicate].
 * @throws [NoSuchElementException] if no such element is found.
 */
inline fun IntBuffer.first(predicate: (Int) -> Boolean): Int {
    for (element in this) if (predicate(element)) return element
    throw NoSuchElementException("Array contains no element matching the predicate.")
}
/** Returns the first element, or `null` if the array is empty. */
fun IntBuffer.firstOrNull(): Int? = if (isEmpty()) null else this[0]
/** Returns the first element matching the given [predicate], or `null` if element was not found. */
inline fun IntBuffer.firstOrNull(predicate: (Int) -> Boolean): Int? {
    for (element in this) if (predicate(element)) return element
    return null
}
/** Returns an element at the given [index] or the result of calling the [defaultValue] function if the [index] is out of bounds of this array. */
inline fun IntBuffer.getOrElse(index: Int, defaultValue: (Int) -> Int): Int = if (index >= 0 && index <= lastIndex) get(index) else defaultValue(index)
/** Returns an element at the given [index] or `null` if the [index] is out of bounds of this array. */
fun IntBuffer.getOrNull(index: Int): Int? = if (index >= 0 && index <= lastIndex) get(index) else null
/** Returns first index of [element], or -1 if the array does not contain element. */
fun IntBuffer.indexOf(element: Int): Int {
    for (index in indices)
        if (element == this[index])
            return index
    return -1
}
/** Returns index of the first element matching the given [predicate], or -1 if the array does not contain such element. */
inline fun IntBuffer.indexOfFirst(predicate: (Int) -> Boolean): Int {
    for (index in indices)
        if (predicate(this[index]))
            return index
    return -1
}
/** Returns index of the last element matching the given [predicate], or -1 if the array does not contain such element. */
inline fun IntBuffer.indexOfLast(predicate: (Int) -> Boolean): Int {
    for (index in indices.reversed())
        if (predicate(this[index]))
            return index
    return -1
}
/**
 * Returns the last element.
 * 
 * @throws NoSuchElementException if the array is empty.
 */
fun IntBuffer.last(): Int {
    if (isEmpty())
        throw NoSuchElementException("Array is empty.")
    return this[lastIndex]
}
/**
 * Returns the last element matching the given [predicate].
 * 
 * @throws NoSuchElementException if no such element is found.
 */
inline fun IntBuffer.last(predicate: (Int) -> Boolean): Int {
    for (index in this.indices.reversed()) {
        val element = this[index]
        if (predicate(element)) return element
    }
    throw NoSuchElementException("Array contains no element matching the predicate.")
}
/** Returns last index of [element], or -1 if the array does not contain element. */
fun IntBuffer.lastIndexOf(element: Int): Int {
    for (index in indices.reversed())
        if (element == this[index])
            return index
    return -1
}
/** Returns the last element, or `null` if the array is empty. */
fun IntBuffer.lastOrNull(): Int? = if (isEmpty()) null else this[rem - 1]
/** Returns the last element matching the given [predicate], or `null` if no such element was found. */
inline fun IntBuffer.lastOrNull(predicate: (Int) -> Boolean): Int? {
    for (index in this.indices.reversed()) {
        val element = this[index]
        if (predicate(element)) return element
    }
    return null
}
/** Returns the single element, or throws an exception if the array is empty or has more than one element. */
fun IntBuffer.single(): Int = when (rem) {
    0 -> throw NoSuchElementException("Array is empty.")
    1 -> this[0]
    else -> throw IllegalArgumentException("Array has more than one element.")
}
/** Returns the single element matching the given [predicate], or throws exception if there is no or more than one matching element. */
inline fun IntBuffer.single(predicate: (Int) -> Boolean): Int {
    var single: Int? = null
    var found = false
    for (element in this)
        if (predicate(element)) {
            if (found) throw IllegalArgumentException("Array contains more than one matching element.")
            single = element
            found = true
        }
    if (!found) throw NoSuchElementException("Array contains no element matching the predicate.")
    @Suppress("UNCHECKED_CAST")
    return single as Int
}
/** Returns single element, or `null` if the array is empty or has more than one element. */
fun IntBuffer.singleOrNull(): Int? = if (rem == 1) this[0] else null
/** Returns the single element matching the given [predicate], or `null` if element was not found or more than one element was found. */
inline fun IntBuffer.singleOrNull(predicate: (Int) -> Boolean): Int? {
    var single: Int? = null
    var found = false
    for (element in this)
        if (predicate(element)) {
            if (found) return null
            single = element
            found = true
        }
    if (!found) return null
    return single
}
/** Returns a list containing only elements matching the given [predicate]. */
inline fun IntBuffer.filter(predicate: (Int) -> Boolean): List<Int> = filterTo(ArrayList<Int>(), predicate)
/**
 * Returns a list containing only elements matching the given [predicate].
 * @param [predicate] function that takes the index of an element and the element itself and returns the result of predicate evaluation on the element.
 */
inline fun IntBuffer.filterIndexed(predicate: (index: Int, Int) -> Boolean): List<Int> = filterIndexedTo(ArrayList<Int>(), predicate)
/**
 * Appends all elements matching the given [predicate] to the given [destination].
 * @param [predicate] function that takes the index of an element and the element itself and returns the result of predicate evaluation on the element.
 */
inline fun <C : MutableCollection<in Int>> IntBuffer.filterIndexedTo(destination: C, predicate: (index: Int, Int) -> Boolean): C {
    forEachIndexed { index, element ->
        if (predicate(index, element)) destination.add(element)
    }
    return destination
}
/** Returns a list containing all elements not matching the given [predicate]. */
inline fun IntBuffer.filterNot(predicate: (Int) -> Boolean): List<Int> = filterNotTo(ArrayList<Int>(), predicate)
/** Appends all elements not matching the given [predicate] to the given [destination]. */
inline fun <C : MutableCollection<in Int>> IntBuffer.filterNotTo(destination: C, predicate: (Int) -> Boolean): C {
     for (element in this) if (!predicate(element)) destination.add(element)
     return destination
}
/** Appends all elements matching the given [predicate] to the given [destination]. */
inline fun <C : MutableCollection<in Int>> IntBuffer.filterTo(destination: C, predicate: (Int) -> Boolean): C {
     for (element in this) if (predicate(element)) destination.add(element)
     return destination
}
/** Returns a list containing elements at specified [indices]. */
fun IntBuffer.slice(indices: Iterable<Int>): List<Int> {
    val size = indices.collectionSizeOrDefault(10)
    if (size == 0) return emptyList()
    val list = ArrayList<Int>(size)
    for (index in indices)
        list.add(get(index))
    return list
}
/** Returns an array containing elements of this array at specified [indices]. */
fun IntBuffer.sliceArray(indices: Collection<Int>): IntArray {
    val result = IntArray(indices.size)
    var targetIndex = 0
    for (sourceIndex in indices)
        result[targetIndex++] = this[sourceIndex]
    return result
}
/** Sorts elements in the array in-place descending according to their natural sort order. */
fun IntBuffer.sortDescending() {
    if (rem > 1) {
        val array = toIntArray().apply{ sortDescending() }
        for (i in 0 until rem)
            this[pos + i] = array[i]
    }
}
/** Returns a list of all elements sorted according to their natural sort order. */
fun IntBuffer.sorted(): List<Int> = toTypedArray().apply { sort() }.asList()
/** Returns an array with all elements of this array sorted according to their natural sort order. */
fun IntBuffer.sortedArray(): IntArray = toIntArray().apply { sort() }
/** Returns an array with all elements of this array sorted descending according to their natural sort order. */
fun IntBuffer.sortedArrayDescending(): IntArray = toIntArray().apply { sortDescending() }
/** Returns a list of all elements sorted according to natural sort order of the value returned by specified [selector] function. */
inline fun <R : Comparable<R>> IntBuffer.sortedBy(crossinline selector: (Int) -> R?): List<Int> = toIntArray().sortedWith(compareBy(selector))
/** Returns a list of all elements sorted descending according to natural sort order of the value returned by specified [selector] function. */
inline fun <R : Comparable<R>> IntBuffer.sortedByDescending(crossinline selector: (Int) -> R?): List<Int> = toIntArray().sortedWith(compareByDescending(selector))
/** Returns a list of all elements sorted descending according to their natural sort order. */
fun IntBuffer.sortedDescending(): List<Int> = toIntArray().apply { sort() }.reversed()
/** Returns a list of all elements sorted according to the specified [comparator]. */
fun IntBuffer.sortedWith(comparator: Comparator<in Int>): List<Int> = toTypedArray().apply { sortWith(comparator) }.asList()
/** Sorts the array in-place. */
fun IntBuffer.sort() {
    if (rem > 1) {
        val array = toIntArray().apply{ sort() }
        for (i in 0 until rem)
            this[pos + i] = array[i]
    }
}
/** Returns a string representation of the contents of the specified array as if it is [List]. */
fun IntBuffer.contentToString(): String {
    val iMax = lim - 1
    if (iMax == -1) return "[]"
    val b = StringBuilder()
    b.append('[')
    var i = 0
    while (true) {
        b.append(get(i))
        if (i == iMax) return b.append(']').toString()
        b.append(", ")
        i++
    }
}
/**
 * Fills this array or its subrange with the specified [element] value.
 * 
 * @param fromIndex the start of the range (inclusive) to fill, 0 by default.
 * @param toIndex the end of the range (exclusive) to fill, size of this array by default.
 * 
 * @throws IndexOutOfBoundsException if [fromIndex] is less than zero or [toIndex] is greater than the size of this array.
 * @throws IllegalArgumentException if [fromIndex] is greater than [toIndex].
 */
fun IntBuffer.fill(element: Int, fromIndex: Int = pos, toIndex: Int = rem) {
    for (i in fromIndex until toIndex)
        this[i] = element
}
/** Returns the range of valid indices for the array. */
val IntBuffer.indices: IntRange
    get() = IntRange(0, lastIndex)
/** Returns `true` if the array is empty. */
inline fun IntBuffer.isEmpty(): Boolean = rem == 0
/** Returns `true` if the array is not empty. */
inline fun IntBuffer.isNotEmpty(): Boolean = !isEmpty()
/** Returns the last valid index for the array. */
val IntBuffer.lastIndex: Int
    get() = rem - 1
/** Returns an array of Byte containing all of the elements of this generic array. */
fun IntBuffer.toIntArray(): IntArray = IntArray(rem) { index -> this[index] }
/** Returns a *typed* object array containing all of the elements of this primitive array. */
fun IntBuffer.toTypedArray(): Array<Int> = Array(rem) { index -> this[index] }
/**
 * Returns a [Map] containing key-value pairs provided by [transform] function applied to elements of the given array.
 * 
 * If any of two pairs would have the same key the last one gets added to the map.
 * 
 * The returned map preserves the entry iteration order of the original array.
 */
inline fun <K, V> IntBuffer.associate(transform: (Int) -> Pair<K, V>): Map<K, V> {
    val capacity = mapCapacity(rem).coerceAtLeast(16)
    return associateTo(LinkedHashMap<K, V>(capacity), transform)
}
/**
 * Returns a [Map] containing the elements from the given array indexed by the key returned from [keySelector] function applied to each element.
 * 
 * If any two elements would have the same key returned by [keySelector] the last one gets added to the map.
 * 
 * The returned map preserves the entry iteration order of the original array.
 */
inline fun <K> IntBuffer.associateBy(keySelector: (Int) -> K): Map<K, Int> {
    val capacity = mapCapacity(rem).coerceAtLeast(16)
    return associateByTo(LinkedHashMap<K, Int>(capacity), keySelector)
}
/**
 * Returns a [Map] containing the values provided by [valueTransform] and indexed by [keySelector] functions applied to elements of the given array.
 * 
 * If any two elements would have the same key returned by [keySelector] the last one gets added to the map.
 * 
 * The returned map preserves the entry iteration order of the original array.
 */
inline fun <K, V> IntBuffer.associateBy(keySelector: (Int) -> K, valueTransform: (Int) -> V): Map<K, V> {
    val capacity = mapCapacity(rem).coerceAtLeast(16)
    return associateByTo(LinkedHashMap<K, V>(capacity), keySelector, valueTransform)
}
/**
 * Populates and returns the [destination] mutable map with key-value pairs, where key is provided by
 * the [keySelector] function applied to each element of the given array and value is the element itself.
 * 
 * If any two elements would have the same key returned by [keySelector] the last one gets added to the map.
 */
inline fun <K, M : MutableMap<in K, in Int>> IntBuffer.associateByTo(destination: M, keySelector: (Int) -> K): M {
    for (element in this)
        destination.put(keySelector(element), element)
    return destination
}
/**
 * Populates and returns the [destination] mutable map with key-value pairs, where key is provided by the [keySelector]
 * function and and value is provided by the [valueTransform] function applied to elements of the given array.
 * 
 * If any two elements would have the same key returned by [keySelector] the last one gets added to the map.
 */
inline fun <K, V, M : MutableMap<in K, in V>> IntBuffer.associateByTo(destination: M, keySelector: (Int) -> K, valueTransform: (Int) -> V): M {
    for (element in this)
        destination.put(keySelector(element), valueTransform(element))
    return destination
}
/**
 * Populates and returns the [destination] mutable map with key-value pairs provided by [transform] function
 * applied to each element of the given array.
 * 
 * If any of two pairs would have the same key the last one gets added to the map.
 */
inline fun <K, V, M : MutableMap<in K, in V>> IntBuffer.associateTo(destination: M, transform: (Int) -> Pair<K, V>): M {
    for (element in this)
        destination += transform(element)
    return destination
}
/**
 * Returns a [Map] where keys are elements from the given array and values are produced by the [valueSelector] function applied to each element.
 * 
 * If any two elements are equal, the last one gets added to the map.
 * 
 * The returned map preserves the entry iteration order of the original array.
 */
inline fun <V> IntBuffer.associateWith(valueSelector: (Int) -> V): Map<Int, V> {
    val result = LinkedHashMap<Int, V>(mapCapacity(rem).coerceAtLeast(16))
    return associateWithTo(result, valueSelector)
}
/**
 * Populates and returns the [destination] mutable map with key-value pairs for each element of the given array,
 * where key is the element itself and value is provided by the [valueSelector] function applied to that key.
 * 
 * If any two elements are equal, the last one overwrites the former value in the map.
 */
inline fun <V, M : MutableMap<in Int, in V>> IntBuffer.associateWithTo(destination: M, valueSelector: (Int) -> V): M {
    for (element in this)
        destination.put(element, valueSelector(element))
    return destination
}
/** Appends all elements to the given [destination] collection. */
fun <C : MutableCollection<in Int>> IntBuffer.toCollection(destination: C): C {
    for (item in this)
        destination.add(item)
    return destination
}
/** Returns a single list of all elements yielded from results of [transform] function being invoked on each element of original array. */
inline fun <R> IntBuffer.flatMap(transform: (Int) -> Iterable<R>): List<R> = flatMapTo(ArrayList<R>(), transform)
/** Appends all elements yielded from results of [transform] function being invoked on each element of original array, to the given [destination]. */
inline fun <R, C : MutableCollection<in R>> IntBuffer.flatMapTo(destination: C, transform: (Int) -> Iterable<R>): C {
    for (element in this) {
        val list = transform(element)
        destination.addAll(list)
    }
    return destination
}
/**
 * Groups elements of the original array by the key returned by the given [keySelector] function applied to
 * each element and returns a map where each group key is associated with a list of corresponding elements.
 * 
 * The returned map preserves the entry iteration order of the keys produced from the original array.
 */
inline fun <K> IntBuffer.groupBy(keySelector: (Int) -> K): Map<K, List<Int>> = groupByTo(LinkedHashMap<K, MutableList<Int>>(), keySelector)
/**
 * Groups values returned by the [valueTransform] function applied to each element of the original array
 * by the key returned by the given [keySelector] function applied to the element
 * and returns a map where each group key is associated with a list of corresponding values.
 * 
 * The returned map preserves the entry iteration order of the keys produced from the original array.
 */
inline fun <K, V> IntBuffer.groupBy(keySelector: (Int) -> K, valueTransform: (Int) -> V): Map<K, List<V>> = groupByTo(LinkedHashMap<K, MutableList<V>>(), keySelector, valueTransform)
/**
 * Groups elements of the original array by the key returned by the given [keySelector] function applied to each
 * element and puts to the [destination] map each group key associated with a list of corresponding elements.
 * 
 * @return The [destination] map.
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
 * Groups values returned by the [valueTransform] function applied to each element of the original array
 * by the key returned by the given [keySelector] function applied to the element
 * and puts to the [destination] map each group key associated with a list of corresponding values.
 * 
 * @return The [destination] map.
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
 * Returns a list containing only distinct elements from the given array.
 * 
 * The elements in the resulting list are in the same order as they were in the source array.
 */
fun IntBuffer.distinct(): List<Int> = this.toMutableSet().toList()
/**
 * Returns a list containing only elements from the given array having distinct keys returned by the given [selector] function.
 * 
 * The elements in the resulting list are in the same order as they were in the source array.
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
 * Returns a new [MutableSet] containing all distinct elements from the given array.
 * 
 * The returned set preserves the element iteration order of the original array.
 */
fun IntBuffer.toMutableSet(): MutableSet<Int> = toCollection(LinkedHashSet<Int>(mapCapacity(rem)))
/** Returns a list containing the results of applying the given [transform] function to each element in the original array. */
inline fun <R> IntBuffer.map(transform: (Int) -> R): List<R> = mapTo(ArrayList<R>(rem), transform)
/**
 * Returns a list containing the results of applying the given [transform] function to each element and its index in the original array.
 * @param [transform] function that takes the index of an element and the element itself and returns the result of the transform applied to the element.
 */
inline fun <R> IntBuffer.mapIndexed(transform: (index: Int, Int) -> R): List<R> = mapIndexedTo(ArrayList<R>(rem), transform)
/**
 * Applies the given [transform] function to each element and its index in the original array and appends the results to the given [destination].
 * @param [transform] function that takes the index of an element and the element itself and returns the result of the transform applied to the element.
 */
inline fun <R, C : MutableCollection<in R>> IntBuffer.mapIndexedTo(destination: C, transform: (index: Int, Int) -> R): C {
    var index = 0
    for (item in this)
        destination.add(transform(index++, item))
    return destination
}
/** Applies the given [transform] function to each element of the original array and appends the results to the given [destination]. */
inline fun <R, C : MutableCollection<in R>> IntBuffer.mapTo(destination: C, transform: (Int) -> R): C {
    for (item in this)
        destination.add(transform(item))
    return destination
}
/** Returns `true` if all elements match the given [predicate]. */
inline fun IntBuffer.all(predicate: (Int) -> Boolean): Boolean {
    for (element in this) if (!predicate(element)) return false
    return true
}
/** Returns `true` if array has at least one element. */
fun IntBuffer.any(): Boolean = !isEmpty()
/** Returns `true` if at least one element matches the given [predicate]. */
inline fun IntBuffer.any(predicate: (Int) -> Boolean): Boolean {
    for (element in this) if (predicate(element)) return true
    return false
}
/** Returns the number of elements in this array. */
inline fun IntBuffer.count(): Int = rem
/** Returns the number of elements matching the given [predicate]. */
inline fun IntBuffer.count(predicate: (Int) -> Boolean): Int {
    var count = 0
    for (element in this) if (predicate(element)) ++count
    return count
}
/** Performs the given [action] on each element. */
inline fun IntBuffer.forEach(action: (Int) -> Unit) { for (element in this) action(element) }
/**
 * Performs the given [action] on each element, providing sequential index with the element.
 * @param [action] function that takes the index of an element and the element itself and performs the action on the element.
 */
inline fun IntBuffer.forEachIndexed(action: (index: Int, Int) -> Unit): Unit {
    var index = 0
    for (item in this) action(index++, item)
}
/**
 * Returns the largest element.
 * 
 * @throws NoSuchElementException if the array is empty.
 */
fun IntBuffer.max(): Int {
    if (isEmpty()) throw NoSuchElementException()
    var max = this[0]
    for (i in 1..lastIndex) {
        val e = this[i]
        if (max < e) max = e
    }
    return max
}
/**
 * Returns the first element yielding the largest value of the given function.
 * 
 * @throws NoSuchElementException if the array is empty.
 */
inline fun <R : Comparable<R>> IntBuffer.maxBy(selector: (Int) -> R): Int {
    if (isEmpty()) throw NoSuchElementException()
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
/** Returns the first element yielding the largest value of the given function or `null` if there are no elements. */
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
/**
 * Returns the first element having the largest value according to the provided [comparator].
 * 
 * @throws NoSuchElementException if the array is empty.
 */
fun IntBuffer.maxWith(comparator: Comparator<in Int>): Int {
    if (isEmpty()) throw NoSuchElementException()
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
/**
 * Returns the smallest element.
 * 
 * @throws NoSuchElementException if the array is empty.
 */
fun IntBuffer.min(): Int {
    if (isEmpty()) throw NoSuchElementException()
    var min = this[0]
    for (i in 1..lastIndex) {
        val e = this[i]
        if (min > e) min = e
    }
    return min
}
/**
 * Returns the first element yielding the smallest value of the given function.
 * 
 * @throws NoSuchElementException if the array is empty.
 */
inline fun <R : Comparable<R>> IntBuffer.minBy(selector: (Int) -> R): Int {
    if (isEmpty()) throw NoSuchElementException()
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
 * Returns the first element yielding the smallest value of the given function or `null` if there are no elements.
 * 
 * @sample samples.collections.Collections.Aggregates.minByOrNull
 */
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
/**
 * Returns the smallest value among all values produced by [selector] function applied to each element in the array.
 * 
 * If any of values produced by [selector] function is `NaN`, the returned result is `NaN`.
 * 
 * @throws NoSuchElementException if the array is empty.
 */
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
 * Returns the smallest value among all values produced by [selector] function applied to each element in the array.
 * 
 * If any of values produced by [selector] function is `NaN`, the returned result is `NaN`.
 * 
 * @throws NoSuchElementException if the array is empty.
 */
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
 * Returns the smallest value among all values produced by [selector] function applied to each element in the array.
 * 
 * @throws NoSuchElementException if the array is empty.
 */
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
 * Returns the smallest value among all values produced by [selector] function applied to each element in the array or `null` if there are no elements.
 * 
 * If any of values produced by [selector] function is `NaN`, the returned result is `NaN`.
 */
inline fun IntBuffer.minOfOrNull(selector: (Int) -> Double): Double? {
    if (isEmpty()) return null
    var minValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        minValue = minOf(minValue, v)
    }
    return minValue
}
/**
 * Returns the smallest value among all values produced by [selector] function applied to each element in the array or `null` if there are no elements.
 * 
 * If any of values produced by [selector] function is `NaN`, the returned result is `NaN`.
 */
inline fun IntBuffer.minOfOrNull(selector: (Int) -> Float): Float? {
    if (isEmpty()) return null
    var minValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        minValue = minOf(minValue, v)
    }
    return minValue
}
/** Returns the smallest value among all values produced by [selector] function applied to each element in the array or `null` if there are no elements. */
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
/**
 * Returns the smallest value according to the provided [comparator] among all values produced by [selector] function applied to each element in the array.
 * 
 * @throws NoSuchElementException if the array is empty.
 */
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
/**
 * Returns the smallest value according to the provided [comparator] among all values produced by [selector]
 * function applied to each element in the array or `null` if there are no elements.
 */
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
/** Returns the smallest element or `null` if there are no elements. */
fun IntBuffer.minOrNull(): Int? {
     if (isEmpty()) return null
     var min = this[0]
     for (i in 1..lastIndex) {
         val e = this[i]
         if (min > e) min = e
     }
     return min
 }
/**
 * Returns the first element having the smallest value according to the provided [comparator].
 * 
 * @throws NoSuchElementException if the array is empty.
 */
fun IntBuffer.minWith(comparator: Comparator<in Int>): Int {
    if (isEmpty()) throw NoSuchElementException()
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
/** Returns `true` if the array has no elements. */
fun IntBuffer.none(): Boolean = isEmpty()
/** Returns `true` if no elements match the given [predicate]. */
inline fun IntBuffer.none(predicate: (Int) -> Boolean): Boolean {
    for (element in this) if (predicate(element)) return false
    return true
}
/** Performs the given [action] on each element and returns the array itself afterwards. */
inline fun IntBuffer.onEach(action: (Int) -> Unit): IntBuffer = apply { for (element in this) action(element) }
/**
 * Performs the given [action] on each element, providing sequential index with the element, and returns the array itself afterwards.
 * @param [action] function that takes the index of an element and the element itself and performs the action on the element.
 */
inline fun IntBuffer.onEachIndexed(action: (index: Int, Int) -> Unit): IntBuffer = apply { forEachIndexed(action) }
/**
 * Accumulates value starting with the first element and applying [operation] from left to right to current accumulator value and each element.
 * 
 * Throws an exception if this array is empty. If the array can be empty in an expected way,
 * please use [reduceOrNull] instead. It returns `null` when its receiver is empty.
 * 
 * @param [operation] function that takes current accumulator value and an element, and calculates the next accumulator value.
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
 * to current accumulator value and each element with its index in the original array.
 * 
 * Throws an exception if this array is empty. If the array can be empty in an expected way,
 * please use [reduceIndexedOrNull] instead. It returns `null` when its receiver is empty.
 * 
 * @param [operation] function that takes the index of an element, current accumulator value and the element itself,
 * and calculates the next accumulator value.
 */
inline fun IntBuffer.reduceIndexed(operation: (index: Int, acc: Int, Int) -> Int): Int {
    if (isEmpty())
        throw UnsupportedOperationException("Empty array can't be reduced.")
    var accumulator = this[0]
    for (index in 1..lastIndex)
        accumulator = operation(index, accumulator, this[index])
    return accumulator
}
/**
 * Accumulates value starting with the first element and applying [operation] from left to right
 * to current accumulator value and each element with its index in the original array.
 * 
 * Returns `null` if the array is empty.
 * 
 * @param [operation] function that takes the index of an element, current accumulator value and the element itself,
 * and calculates the next accumulator value.
 */
inline fun IntBuffer.reduceIndexedOrNull(operation: (index: Int, acc: Int, Int) -> Int): Int? {
    if (isEmpty())
        return null
    var accumulator = this[0]
    for (index in 1..lastIndex)
        accumulator = operation(index, accumulator, this[index])
    return accumulator
}
/**
 * Accumulates value starting with the first element and applying [operation] from left to right to current accumulator value and each element.
 * 
 * Returns `null` if the array is empty.
 * 
 * @param [operation] function that takes current accumulator value and an element, and calculates the next accumulator value.
 */
inline fun IntBuffer.reduceOrNull(operation: (acc: Int, Int) -> Int): Int? {
    if (isEmpty())
        return null
    var accumulator = this[0]
    for (index in 1..lastIndex)
        accumulator = operation(accumulator, this[index])
     return accumulator
}
/**
 * Accumulates value starting with the last element and applying [operation] from right to left to each element and current accumulator value.
 * 
 * Throws an exception if this array is empty. If the array can be empty in an expected way,
 * please use [reduceRightOrNull] instead. It returns `null` when its receiver is empty.
 * 
 * @param [operation] function that takes an element and current accumulator value, and calculates the next accumulator value.
 */
inline fun IntBuffer.reduceRight(operation: (Int, acc: Int) -> Int): Int {
    var index = lastIndex
    if (index < 0) throw UnsupportedOperationException("Empty array can't be reduced.")
    var accumulator = get(index--)
    while (index >= 0)
        accumulator = operation(get(index--), accumulator)
    return accumulator
}
/**
 * Accumulates value starting with the last element and applying [operation] from right to left
 * to each element with its index in the original array and current accumulator value.
 * 
 * Throws an exception if this array is empty. If the array can be empty in an expected way,
 * please use [reduceRightIndexedOrNull] instead. It returns `null` when its receiver is empty.
 * 
 * @param [operation] function that takes the index of an element, the element itself and current accumulator value,
 * and calculates the next accumulator value.
 */
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
/**
 * Accumulates value starting with the last element and applying [operation] from right to left
 * to each element with its index in the original array and current accumulator value.
 * 
 * Returns `null` if the array is empty.
 * 
 * @param [operation] function that takes the index of an element, the element itself and current accumulator value,
 * and calculates the next accumulator value.
 */
inline fun IntBuffer.reduceRightIndexedOrNull(operation: (index: Int, Int, acc: Int) -> Int): Int? {
    var index = lastIndex
    if (index < 0) return null
    var accumulator = get(index--)
    while (index >= 0) {
        accumulator = operation(index, get(index), accumulator)
        --index
    }
    return accumulator
}
/**
 * Accumulates value starting with the last element and applying [operation] from right to left to each element and current accumulator value.
 * 
 * Returns `null` if the array is empty.
 * 
 * @param [operation] function that takes an element and current accumulator value, and calculates the next accumulator value.
 */
inline fun IntBuffer.reduceRightOrNull(operation: (Int, acc: Int) -> Int): Int? {
    var index = lastIndex
    if (index < 0) return null
    var accumulator = get(index--)
    while (index >= 0)
         accumulator = operation(get(index--), accumulator)
    return accumulator
}
/**
 * Splits the original array into pair of lists, where *first* list contains elements for which [predicate] 
 * yielded `true`, while *second* list contains elements for which [predicate] yielded `false`.
 */
inline fun IntBuffer.partition(predicate: (Int) -> Boolean): Pair<List<Int>, List<Int>> {
    val first = ArrayList<Int>()
    val second = ArrayList<Int>()
    for (element in this)
        if (predicate(element))
            first.add(element)
        else
            second.add(element)
    return Pair(first, second)
}
/**
 * Returns a list of pairs built from the elements of `this` array and the [other] array with the same index.
 * The returned list has length of the shortest collection.
 */
infix fun <R> IntBuffer.zip(other: Array<out R>): List<Pair<Int, R>> = zip(other) { t1, t2 -> t1 to t2 }
/**
 * Returns a list of values built from the elements of `this` array and the [other] array with the same index
 * using the provided [transform] function applied to each pair of elements.
 * The returned list has length of the shortest collection.
 */
inline fun <R, V> IntBuffer.zip(other: Array<out R>, transform: (a: Int, b: R) -> V): List<V> {
    val size = minOf(rem, other.size)
    val list = ArrayList<V>(size)
    for (i in 0 until size)
        list.add(transform(this[i], other[i]))
    return list
}
/**
 * Returns a list of pairs built from the elements of `this` collection and [other] array with the same index.
 * The returned list has length of the shortest collection.
 */
infix fun <R> IntBuffer.zip(other: Iterable<R>): List<Pair<Int, R>> = zip(other) { t1, t2 -> t1 to t2 }
/**
 * Returns a list of values built from the elements of `this` array and the [other] collection with the same index
 * using the provided [transform] function applied to each pair of elements.
 * The returned list has length of the shortest collection.
 */
inline fun <R, V> IntBuffer.zip(other: Iterable<R>, transform: (a: Int, b: R) -> V): List<V> {
    val arraySize = rem
    val list = ArrayList<V>(minOf(other.collectionSizeOrDefault(10), arraySize))
    var i = 0
    for (element in other) {
        if (i >= arraySize) break
        list.add(transform(this[i++], element))
    }
    return list
}
/**
 * Returns a list of pairs built from the elements of `this` array and the [other] array with the same index.
 * The returned list has length of the shortest collection.
 */
infix fun IntBuffer.zip(other: IntArray): List<Pair<Int, Int>> = zip(other) { t1, t2 -> t1 to t2 }
/**
 * Returns a list of values built from the elements of `this` array and the [other] array with the same index
 * using the provided [transform] function applied to each pair of elements.
 * The returned list has length of the shortest array.
 */
inline fun <V> IntBuffer.zip(other: IntArray, transform: (a: Int, b: Int) -> V): List<V> {
    val size = minOf(rem, other.size)
    val list = ArrayList<V>(size)
    for (i in 0 until size)
        list.add(transform(this[i], other[i]))
    return list
}
/**
 * Appends the string from all the elements separated using [separator] and using the given [prefix] and [postfix] if supplied.
 * 
 * If the collection could be huge, you can specify a non-negative value of [limit], in which case only the first [limit]
 * elements will be appended, followed by the [truncated] string (which defaults to "...").
 */
fun <A : Appendable> IntBuffer.joinTo(buffer: A, separator: CharSequence = ", ", prefix: CharSequence = "", postfix: CharSequence = "", limit: Int = -1, truncated: CharSequence = "...", transform: ((Int) -> CharSequence)? = null): A {
    buffer.append(prefix)
    var count = 0
    for (element in this) {
        if (++count > 1) buffer.append(separator)
        if (limit < 0 || count <= limit)
            if (transform != null)
                buffer.append(transform(element))
            else
                buffer.append(element.toString())
        else break
    }
    if (limit >= 0 && count > limit) buffer.append(truncated)
    buffer.append(postfix)
    return buffer
}
/**
 * Creates a string from all the elements separated using [separator] and using the given [prefix] and [postfix] if supplied.
 * 
 * If the collection could be huge, you can specify a non-negative value of [limit], in which case only the first [limit]
 * elements will be appended, followed by the [truncated] string (which defaults to "...").
 */
fun IntBuffer.joinToString(separator: CharSequence = ", ", prefix: CharSequence = "", postfix: CharSequence = "", limit: Int = -1, truncated: CharSequence = "...", transform: ((Int) -> CharSequence)? = null): String =
    joinTo(StringBuilder(), separator, prefix, postfix, limit, truncated, transform).toString()
/**
 * Returns 1st *element* from the buffer.
 * 
 * If the size of this array is less than 1, throws an [IndexOutOfBoundsException]
 */
inline operator fun LongBuffer.component1(): Long = get(0)
/**
 * Returns 2nd *element* from the buffer.
 * 
 * If the size of this array is less than 2, throws an [IndexOutOfBoundsException]
 */
inline operator fun LongBuffer.component2(): Long = get(1)
/**
 * Returns 3rd *element* from the buffer.
 * 
 * If the size of this array is less than 3, throws an [IndexOutOfBoundsException]
 */
inline operator fun LongBuffer.component3(): Long = get(2)
/**
 * Returns 4th *element* from the buffer.
 * 
 * If the size of this array is less than 4, throws an [IndexOutOfBoundsException]
 */
inline operator fun LongBuffer.component4(): Long = get(3)
/**
 * Returns 5th *element* from the buffer.
 * 
 * If the size of this array is less than 5, throws an [IndexOutOfBoundsException]
 */
inline operator fun LongBuffer.component5(): Long = get(4)
/** Returns `true` if [element] is found in the array. */
operator fun LongBuffer.contains(element: Long): Boolean = indexOf(element) >= 0
/** Returns an element at the given [index] or throws an [IndexOutOfBoundsException] if the [index] is out of bounds of this array. */
inline fun <T> LongBuffer.elementAt(index: Int): Long = get(index)
/** Returns an element at the given [index] or the result of calling the [defaultValue] function if the [index] is out of bounds of this array. */
inline fun LongBuffer.elementAtOrElse(index: Int, defaultValue: (Int) -> Long): Long = if (index >= 0 && index <= lastIndex) get(index) else defaultValue(index)
/** Returns an element at the given [index] or `null` if the [index] is out of bounds of this array. */
inline fun LongBuffer.elementAtOrNull(index: Int): Long? = this.getOrNull(index)
/** Returns the first element matching the given [predicate], or `null` if no such element was found. */
inline fun LongBuffer.find(predicate: (Long) -> Boolean): Long? = firstOrNull(predicate)
/** Returns the last element matching the given [predicate], or `null` if no such element was found. */
inline fun LongBuffer.findLast(predicate: (Long) -> Boolean): Long? = lastOrNull(predicate)
/**
 * Returns the first element.
 * 
 * @throws NoSuchElementException if the array is empty.
 */
fun LongBuffer.first(): Long {
    if (isEmpty())
        throw NoSuchElementException("Array is empty.")
    return this[0]
}
/**
 * Returns the first element matching the given [predicate].
 * @throws [NoSuchElementException] if no such element is found.
 */
inline fun LongBuffer.first(predicate: (Long) -> Boolean): Long {
    for (element in this) if (predicate(element)) return element
    throw NoSuchElementException("Array contains no element matching the predicate.")
}
/** Returns the first element, or `null` if the array is empty. */
fun LongBuffer.firstOrNull(): Long? = if (isEmpty()) null else this[0]
/** Returns the first element matching the given [predicate], or `null` if element was not found. */
inline fun LongBuffer.firstOrNull(predicate: (Long) -> Boolean): Long? {
    for (element in this) if (predicate(element)) return element
    return null
}
/** Returns an element at the given [index] or the result of calling the [defaultValue] function if the [index] is out of bounds of this array. */
inline fun LongBuffer.getOrElse(index: Int, defaultValue: (Int) -> Long): Long = if (index >= 0 && index <= lastIndex) get(index) else defaultValue(index)
/** Returns an element at the given [index] or `null` if the [index] is out of bounds of this array. */
fun LongBuffer.getOrNull(index: Int): Long? = if (index >= 0 && index <= lastIndex) get(index) else null
/** Returns first index of [element], or -1 if the array does not contain element. */
fun LongBuffer.indexOf(element: Long): Int {
    for (index in indices)
        if (element == this[index])
            return index
    return -1
}
/** Returns index of the first element matching the given [predicate], or -1 if the array does not contain such element. */
inline fun LongBuffer.indexOfFirst(predicate: (Long) -> Boolean): Int {
    for (index in indices)
        if (predicate(this[index]))
            return index
    return -1
}
/** Returns index of the last element matching the given [predicate], or -1 if the array does not contain such element. */
inline fun LongBuffer.indexOfLast(predicate: (Long) -> Boolean): Int {
    for (index in indices.reversed())
        if (predicate(this[index]))
            return index
    return -1
}
/**
 * Returns the last element.
 * 
 * @throws NoSuchElementException if the array is empty.
 */
fun LongBuffer.last(): Long {
    if (isEmpty())
        throw NoSuchElementException("Array is empty.")
    return this[lastIndex]
}
/**
 * Returns the last element matching the given [predicate].
 * 
 * @throws NoSuchElementException if no such element is found.
 */
inline fun LongBuffer.last(predicate: (Long) -> Boolean): Long {
    for (index in this.indices.reversed()) {
        val element = this[index]
        if (predicate(element)) return element
    }
    throw NoSuchElementException("Array contains no element matching the predicate.")
}
/** Returns last index of [element], or -1 if the array does not contain element. */
fun LongBuffer.lastIndexOf(element: Long): Int {
    for (index in indices.reversed())
        if (element == this[index])
            return index
    return -1
}
/** Returns the last element, or `null` if the array is empty. */
fun LongBuffer.lastOrNull(): Long? = if (isEmpty()) null else this[rem - 1]
/** Returns the last element matching the given [predicate], or `null` if no such element was found. */
inline fun LongBuffer.lastOrNull(predicate: (Long) -> Boolean): Long? {
    for (index in this.indices.reversed()) {
        val element = this[index]
        if (predicate(element)) return element
    }
    return null
}
/** Returns the single element, or throws an exception if the array is empty or has more than one element. */
fun LongBuffer.single(): Long = when (rem) {
    0 -> throw NoSuchElementException("Array is empty.")
    1 -> this[0]
    else -> throw IllegalArgumentException("Array has more than one element.")
}
/** Returns the single element matching the given [predicate], or throws exception if there is no or more than one matching element. */
inline fun LongBuffer.single(predicate: (Long) -> Boolean): Long {
    var single: Long? = null
    var found = false
    for (element in this)
        if (predicate(element)) {
            if (found) throw IllegalArgumentException("Array contains more than one matching element.")
            single = element
            found = true
        }
    if (!found) throw NoSuchElementException("Array contains no element matching the predicate.")
    @Suppress("UNCHECKED_CAST")
    return single as Long
}
/** Returns single element, or `null` if the array is empty or has more than one element. */
fun LongBuffer.singleOrNull(): Long? = if (rem == 1) this[0] else null
/** Returns the single element matching the given [predicate], or `null` if element was not found or more than one element was found. */
inline fun LongBuffer.singleOrNull(predicate: (Long) -> Boolean): Long? {
    var single: Long? = null
    var found = false
    for (element in this)
        if (predicate(element)) {
            if (found) return null
            single = element
            found = true
        }
    if (!found) return null
    return single
}
/** Returns a list containing only elements matching the given [predicate]. */
inline fun LongBuffer.filter(predicate: (Long) -> Boolean): List<Long> = filterTo(ArrayList<Long>(), predicate)
/**
 * Returns a list containing only elements matching the given [predicate].
 * @param [predicate] function that takes the index of an element and the element itself and returns the result of predicate evaluation on the element.
 */
inline fun LongBuffer.filterIndexed(predicate: (index: Int, Long) -> Boolean): List<Long> = filterIndexedTo(ArrayList<Long>(), predicate)
/**
 * Appends all elements matching the given [predicate] to the given [destination].
 * @param [predicate] function that takes the index of an element and the element itself and returns the result of predicate evaluation on the element.
 */
inline fun <C : MutableCollection<in Long>> LongBuffer.filterIndexedTo(destination: C, predicate: (index: Int, Long) -> Boolean): C {
    forEachIndexed { index, element ->
        if (predicate(index, element)) destination.add(element)
    }
    return destination
}
/** Returns a list containing all elements not matching the given [predicate]. */
inline fun LongBuffer.filterNot(predicate: (Long) -> Boolean): List<Long> = filterNotTo(ArrayList<Long>(), predicate)
/** Appends all elements not matching the given [predicate] to the given [destination]. */
inline fun <C : MutableCollection<in Long>> LongBuffer.filterNotTo(destination: C, predicate: (Long) -> Boolean): C {
     for (element in this) if (!predicate(element)) destination.add(element)
     return destination
}
/** Appends all elements matching the given [predicate] to the given [destination]. */
inline fun <C : MutableCollection<in Long>> LongBuffer.filterTo(destination: C, predicate: (Long) -> Boolean): C {
     for (element in this) if (predicate(element)) destination.add(element)
     return destination
}
/** Returns a list containing elements at specified [indices]. */
fun LongBuffer.slice(indices: Iterable<Int>): List<Long> {
    val size = indices.collectionSizeOrDefault(10)
    if (size == 0) return emptyList()
    val list = ArrayList<Long>(size)
    for (index in indices)
        list.add(get(index))
    return list
}
/** Returns an array containing elements of this array at specified [indices]. */
fun LongBuffer.sliceArray(indices: Collection<Int>): LongArray {
    val result = LongArray(indices.size)
    var targetIndex = 0
    for (sourceIndex in indices)
        result[targetIndex++] = this[sourceIndex]
    return result
}
/** Sorts elements in the array in-place descending according to their natural sort order. */
fun LongBuffer.sortDescending() {
    if (rem > 1) {
        val array = toLongArray().apply{ sortDescending() }
        for (i in 0 until rem)
            this[pos + i] = array[i]
    }
}
/** Returns a list of all elements sorted according to their natural sort order. */
fun LongBuffer.sorted(): List<Long> = toTypedArray().apply { sort() }.asList()
/** Returns an array with all elements of this array sorted according to their natural sort order. */
fun LongBuffer.sortedArray(): LongArray = toLongArray().apply { sort() }
/** Returns an array with all elements of this array sorted descending according to their natural sort order. */
fun LongBuffer.sortedArrayDescending(): LongArray = toLongArray().apply { sortDescending() }
/** Returns a list of all elements sorted according to natural sort order of the value returned by specified [selector] function. */
inline fun <R : Comparable<R>> LongBuffer.sortedBy(crossinline selector: (Long) -> R?): List<Long> = toLongArray().sortedWith(compareBy(selector))
/** Returns a list of all elements sorted descending according to natural sort order of the value returned by specified [selector] function. */
inline fun <R : Comparable<R>> LongBuffer.sortedByDescending(crossinline selector: (Long) -> R?): List<Long> = toLongArray().sortedWith(compareByDescending(selector))
/** Returns a list of all elements sorted descending according to their natural sort order. */
fun LongBuffer.sortedDescending(): List<Long> = toLongArray().apply { sort() }.reversed()
/** Returns a list of all elements sorted according to the specified [comparator]. */
fun LongBuffer.sortedWith(comparator: Comparator<in Long>): List<Long> = toTypedArray().apply { sortWith(comparator) }.asList()
/** Sorts the array in-place. */
fun LongBuffer.sort() {
    if (rem > 1) {
        val array = toLongArray().apply{ sort() }
        for (i in 0 until rem)
            this[pos + i] = array[i]
    }
}
/** Returns a string representation of the contents of the specified array as if it is [List]. */
fun LongBuffer.contentToString(): String {
    val iMax = lim - 1
    if (iMax == -1) return "[]"
    val b = StringBuilder()
    b.append('[')
    var i = 0
    while (true) {
        b.append(get(i))
        if (i == iMax) return b.append(']').toString()
        b.append(", ")
        i++
    }
}
/**
 * Fills this array or its subrange with the specified [element] value.
 * 
 * @param fromIndex the start of the range (inclusive) to fill, 0 by default.
 * @param toIndex the end of the range (exclusive) to fill, size of this array by default.
 * 
 * @throws IndexOutOfBoundsException if [fromIndex] is less than zero or [toIndex] is greater than the size of this array.
 * @throws IllegalArgumentException if [fromIndex] is greater than [toIndex].
 */
fun LongBuffer.fill(element: Long, fromIndex: Int = pos, toIndex: Int = rem) {
    for (i in fromIndex until toIndex)
        this[i] = element
}
/** Returns the range of valid indices for the array. */
val LongBuffer.indices: IntRange
    get() = IntRange(0, lastIndex)
/** Returns `true` if the array is empty. */
inline fun LongBuffer.isEmpty(): Boolean = rem == 0
/** Returns `true` if the array is not empty. */
inline fun LongBuffer.isNotEmpty(): Boolean = !isEmpty()
/** Returns the last valid index for the array. */
val LongBuffer.lastIndex: Int
    get() = rem - 1
/** Returns an array of Byte containing all of the elements of this generic array. */
fun LongBuffer.toLongArray(): LongArray = LongArray(rem) { index -> this[index] }
/** Returns a *typed* object array containing all of the elements of this primitive array. */
fun LongBuffer.toTypedArray(): Array<Long> = Array(rem) { index -> this[index] }
/**
 * Returns a [Map] containing key-value pairs provided by [transform] function applied to elements of the given array.
 * 
 * If any of two pairs would have the same key the last one gets added to the map.
 * 
 * The returned map preserves the entry iteration order of the original array.
 */
inline fun <K, V> LongBuffer.associate(transform: (Long) -> Pair<K, V>): Map<K, V> {
    val capacity = mapCapacity(rem).coerceAtLeast(16)
    return associateTo(LinkedHashMap<K, V>(capacity), transform)
}
/**
 * Returns a [Map] containing the elements from the given array indexed by the key returned from [keySelector] function applied to each element.
 * 
 * If any two elements would have the same key returned by [keySelector] the last one gets added to the map.
 * 
 * The returned map preserves the entry iteration order of the original array.
 */
inline fun <K> LongBuffer.associateBy(keySelector: (Long) -> K): Map<K, Long> {
    val capacity = mapCapacity(rem).coerceAtLeast(16)
    return associateByTo(LinkedHashMap<K, Long>(capacity), keySelector)
}
/**
 * Returns a [Map] containing the values provided by [valueTransform] and indexed by [keySelector] functions applied to elements of the given array.
 * 
 * If any two elements would have the same key returned by [keySelector] the last one gets added to the map.
 * 
 * The returned map preserves the entry iteration order of the original array.
 */
inline fun <K, V> LongBuffer.associateBy(keySelector: (Long) -> K, valueTransform: (Long) -> V): Map<K, V> {
    val capacity = mapCapacity(rem).coerceAtLeast(16)
    return associateByTo(LinkedHashMap<K, V>(capacity), keySelector, valueTransform)
}
/**
 * Populates and returns the [destination] mutable map with key-value pairs, where key is provided by
 * the [keySelector] function applied to each element of the given array and value is the element itself.
 * 
 * If any two elements would have the same key returned by [keySelector] the last one gets added to the map.
 */
inline fun <K, M : MutableMap<in K, in Long>> LongBuffer.associateByTo(destination: M, keySelector: (Long) -> K): M {
    for (element in this)
        destination.put(keySelector(element), element)
    return destination
}
/**
 * Populates and returns the [destination] mutable map with key-value pairs, where key is provided by the [keySelector]
 * function and and value is provided by the [valueTransform] function applied to elements of the given array.
 * 
 * If any two elements would have the same key returned by [keySelector] the last one gets added to the map.
 */
inline fun <K, V, M : MutableMap<in K, in V>> LongBuffer.associateByTo(destination: M, keySelector: (Long) -> K, valueTransform: (Long) -> V): M {
    for (element in this)
        destination.put(keySelector(element), valueTransform(element))
    return destination
}
/**
 * Populates and returns the [destination] mutable map with key-value pairs provided by [transform] function
 * applied to each element of the given array.
 * 
 * If any of two pairs would have the same key the last one gets added to the map.
 */
inline fun <K, V, M : MutableMap<in K, in V>> LongBuffer.associateTo(destination: M, transform: (Long) -> Pair<K, V>): M {
    for (element in this)
        destination += transform(element)
    return destination
}
/**
 * Returns a [Map] where keys are elements from the given array and values are produced by the [valueSelector] function applied to each element.
 * 
 * If any two elements are equal, the last one gets added to the map.
 * 
 * The returned map preserves the entry iteration order of the original array.
 */
inline fun <V> LongBuffer.associateWith(valueSelector: (Long) -> V): Map<Long, V> {
    val result = LinkedHashMap<Long, V>(mapCapacity(rem).coerceAtLeast(16))
    return associateWithTo(result, valueSelector)
}
/**
 * Populates and returns the [destination] mutable map with key-value pairs for each element of the given array,
 * where key is the element itself and value is provided by the [valueSelector] function applied to that key.
 * 
 * If any two elements are equal, the last one overwrites the former value in the map.
 */
inline fun <V, M : MutableMap<in Long, in V>> LongBuffer.associateWithTo(destination: M, valueSelector: (Long) -> V): M {
    for (element in this)
        destination.put(element, valueSelector(element))
    return destination
}
/** Appends all elements to the given [destination] collection. */
fun <C : MutableCollection<in Long>> LongBuffer.toCollection(destination: C): C {
    for (item in this)
        destination.add(item)
    return destination
}
/** Returns a single list of all elements yielded from results of [transform] function being invoked on each element of original array. */
inline fun <R> LongBuffer.flatMap(transform: (Long) -> Iterable<R>): List<R> = flatMapTo(ArrayList<R>(), transform)
/** Appends all elements yielded from results of [transform] function being invoked on each element of original array, to the given [destination]. */
inline fun <R, C : MutableCollection<in R>> LongBuffer.flatMapTo(destination: C, transform: (Long) -> Iterable<R>): C {
    for (element in this) {
        val list = transform(element)
        destination.addAll(list)
    }
    return destination
}
/**
 * Groups elements of the original array by the key returned by the given [keySelector] function applied to
 * each element and returns a map where each group key is associated with a list of corresponding elements.
 * 
 * The returned map preserves the entry iteration order of the keys produced from the original array.
 */
inline fun <K> LongBuffer.groupBy(keySelector: (Long) -> K): Map<K, List<Long>> = groupByTo(LinkedHashMap<K, MutableList<Long>>(), keySelector)
/**
 * Groups values returned by the [valueTransform] function applied to each element of the original array
 * by the key returned by the given [keySelector] function applied to the element
 * and returns a map where each group key is associated with a list of corresponding values.
 * 
 * The returned map preserves the entry iteration order of the keys produced from the original array.
 */
inline fun <K, V> LongBuffer.groupBy(keySelector: (Long) -> K, valueTransform: (Long) -> V): Map<K, List<V>> = groupByTo(LinkedHashMap<K, MutableList<V>>(), keySelector, valueTransform)
/**
 * Groups elements of the original array by the key returned by the given [keySelector] function applied to each
 * element and puts to the [destination] map each group key associated with a list of corresponding elements.
 * 
 * @return The [destination] map.
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
 * Groups values returned by the [valueTransform] function applied to each element of the original array
 * by the key returned by the given [keySelector] function applied to the element
 * and puts to the [destination] map each group key associated with a list of corresponding values.
 * 
 * @return The [destination] map.
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
 * Returns a list containing only distinct elements from the given array.
 * 
 * The elements in the resulting list are in the same order as they were in the source array.
 */
fun LongBuffer.distinct(): List<Long> = this.toMutableSet().toList()
/**
 * Returns a list containing only elements from the given array having distinct keys returned by the given [selector] function.
 * 
 * The elements in the resulting list are in the same order as they were in the source array.
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
 * Returns a new [MutableSet] containing all distinct elements from the given array.
 * 
 * The returned set preserves the element iteration order of the original array.
 */
fun LongBuffer.toMutableSet(): MutableSet<Long> = toCollection(LinkedHashSet<Long>(mapCapacity(rem)))
/** Returns a list containing the results of applying the given [transform] function to each element in the original array. */
inline fun <R> LongBuffer.map(transform: (Long) -> R): List<R> = mapTo(ArrayList<R>(rem), transform)
/**
 * Returns a list containing the results of applying the given [transform] function to each element and its index in the original array.
 * @param [transform] function that takes the index of an element and the element itself and returns the result of the transform applied to the element.
 */
inline fun <R> LongBuffer.mapIndexed(transform: (index: Int, Long) -> R): List<R> = mapIndexedTo(ArrayList<R>(rem), transform)
/**
 * Applies the given [transform] function to each element and its index in the original array and appends the results to the given [destination].
 * @param [transform] function that takes the index of an element and the element itself and returns the result of the transform applied to the element.
 */
inline fun <R, C : MutableCollection<in R>> LongBuffer.mapIndexedTo(destination: C, transform: (index: Int, Long) -> R): C {
    var index = 0
    for (item in this)
        destination.add(transform(index++, item))
    return destination
}
/** Applies the given [transform] function to each element of the original array and appends the results to the given [destination]. */
inline fun <R, C : MutableCollection<in R>> LongBuffer.mapTo(destination: C, transform: (Long) -> R): C {
    for (item in this)
        destination.add(transform(item))
    return destination
}
/** Returns `true` if all elements match the given [predicate]. */
inline fun LongBuffer.all(predicate: (Long) -> Boolean): Boolean {
    for (element in this) if (!predicate(element)) return false
    return true
}
/** Returns `true` if array has at least one element. */
fun LongBuffer.any(): Boolean = !isEmpty()
/** Returns `true` if at least one element matches the given [predicate]. */
inline fun LongBuffer.any(predicate: (Long) -> Boolean): Boolean {
    for (element in this) if (predicate(element)) return true
    return false
}
/** Returns the number of elements in this array. */
inline fun LongBuffer.count(): Int = rem
/** Returns the number of elements matching the given [predicate]. */
inline fun LongBuffer.count(predicate: (Long) -> Boolean): Int {
    var count = 0
    for (element in this) if (predicate(element)) ++count
    return count
}
/** Performs the given [action] on each element. */
inline fun LongBuffer.forEach(action: (Long) -> Unit) { for (element in this) action(element) }
/**
 * Performs the given [action] on each element, providing sequential index with the element.
 * @param [action] function that takes the index of an element and the element itself and performs the action on the element.
 */
inline fun LongBuffer.forEachIndexed(action: (index: Int, Long) -> Unit): Unit {
    var index = 0
    for (item in this) action(index++, item)
}
/**
 * Returns the largest element.
 * 
 * @throws NoSuchElementException if the array is empty.
 */
fun LongBuffer.max(): Long {
    if (isEmpty()) throw NoSuchElementException()
    var max = this[0]
    for (i in 1..lastIndex) {
        val e = this[i]
        if (max < e) max = e
    }
    return max
}
/**
 * Returns the first element yielding the largest value of the given function.
 * 
 * @throws NoSuchElementException if the array is empty.
 */
inline fun <R : Comparable<R>> LongBuffer.maxBy(selector: (Long) -> R): Long {
    if (isEmpty()) throw NoSuchElementException()
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
/** Returns the first element yielding the largest value of the given function or `null` if there are no elements. */
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
 * Returns the first element having the largest value according to the provided [comparator].
 * 
 * @throws NoSuchElementException if the array is empty.
 */
fun LongBuffer.maxWith(comparator: Comparator<in Long>): Long {
    if (isEmpty()) throw NoSuchElementException()
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
/**
 * Returns the smallest element.
 * 
 * @throws NoSuchElementException if the array is empty.
 */
fun LongBuffer.min(): Long {
    if (isEmpty()) throw NoSuchElementException()
    var min = this[0]
    for (i in 1..lastIndex) {
        val e = this[i]
        if (min > e) min = e
    }
    return min
}
/**
 * Returns the first element yielding the smallest value of the given function.
 * 
 * @throws NoSuchElementException if the array is empty.
 */
inline fun <R : Comparable<R>> LongBuffer.minBy(selector: (Long) -> R): Long {
    if (isEmpty()) throw NoSuchElementException()
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
 * Returns the first element yielding the smallest value of the given function or `null` if there are no elements.
 * 
 * @sample samples.collections.Collections.Aggregates.minByOrNull
 */
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
/**
 * Returns the smallest value among all values produced by [selector] function applied to each element in the array.
 * 
 * If any of values produced by [selector] function is `NaN`, the returned result is `NaN`.
 * 
 * @throws NoSuchElementException if the array is empty.
 */
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
 * Returns the smallest value among all values produced by [selector] function applied to each element in the array.
 * 
 * If any of values produced by [selector] function is `NaN`, the returned result is `NaN`.
 * 
 * @throws NoSuchElementException if the array is empty.
 */
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
 * Returns the smallest value among all values produced by [selector] function applied to each element in the array.
 * 
 * @throws NoSuchElementException if the array is empty.
 */
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
 * Returns the smallest value among all values produced by [selector] function applied to each element in the array or `null` if there are no elements.
 * 
 * If any of values produced by [selector] function is `NaN`, the returned result is `NaN`.
 */
inline fun LongBuffer.minOfOrNull(selector: (Long) -> Double): Double? {
    if (isEmpty()) return null
    var minValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        minValue = minOf(minValue, v)
    }
    return minValue
}
/**
 * Returns the smallest value among all values produced by [selector] function applied to each element in the array or `null` if there are no elements.
 * 
 * If any of values produced by [selector] function is `NaN`, the returned result is `NaN`.
 */
inline fun LongBuffer.minOfOrNull(selector: (Long) -> Float): Float? {
    if (isEmpty()) return null
    var minValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        minValue = minOf(minValue, v)
    }
    return minValue
}
/** Returns the smallest value among all values produced by [selector] function applied to each element in the array or `null` if there are no elements. */
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
/**
 * Returns the smallest value according to the provided [comparator] among all values produced by [selector] function applied to each element in the array.
 * 
 * @throws NoSuchElementException if the array is empty.
 */
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
/**
 * Returns the smallest value according to the provided [comparator] among all values produced by [selector]
 * function applied to each element in the array or `null` if there are no elements.
 */
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
/** Returns the smallest element or `null` if there are no elements. */
fun LongBuffer.minOrNull(): Long? {
     if (isEmpty()) return null
     var min = this[0]
     for (i in 1..lastIndex) {
         val e = this[i]
         if (min > e) min = e
     }
     return min
 }
/**
 * Returns the first element having the smallest value according to the provided [comparator].
 * 
 * @throws NoSuchElementException if the array is empty.
 */
fun LongBuffer.minWith(comparator: Comparator<in Long>): Long {
    if (isEmpty()) throw NoSuchElementException()
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
/** Returns `true` if the array has no elements. */
fun LongBuffer.none(): Boolean = isEmpty()
/** Returns `true` if no elements match the given [predicate]. */
inline fun LongBuffer.none(predicate: (Long) -> Boolean): Boolean {
    for (element in this) if (predicate(element)) return false
    return true
}
/** Performs the given [action] on each element and returns the array itself afterwards. */
inline fun LongBuffer.onEach(action: (Long) -> Unit): LongBuffer = apply { for (element in this) action(element) }
/**
 * Performs the given [action] on each element, providing sequential index with the element, and returns the array itself afterwards.
 * @param [action] function that takes the index of an element and the element itself and performs the action on the element.
 */
inline fun LongBuffer.onEachIndexed(action: (index: Int, Long) -> Unit): LongBuffer = apply { forEachIndexed(action) }
/**
 * Accumulates value starting with the first element and applying [operation] from left to right to current accumulator value and each element.
 * 
 * Throws an exception if this array is empty. If the array can be empty in an expected way,
 * please use [reduceOrNull] instead. It returns `null` when its receiver is empty.
 * 
 * @param [operation] function that takes current accumulator value and an element, and calculates the next accumulator value.
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
 * to current accumulator value and each element with its index in the original array.
 * 
 * Throws an exception if this array is empty. If the array can be empty in an expected way,
 * please use [reduceIndexedOrNull] instead. It returns `null` when its receiver is empty.
 * 
 * @param [operation] function that takes the index of an element, current accumulator value and the element itself,
 * and calculates the next accumulator value.
 */
inline fun LongBuffer.reduceIndexed(operation: (index: Int, acc: Long, Long) -> Long): Long {
    if (isEmpty())
        throw UnsupportedOperationException("Empty array can't be reduced.")
    var accumulator = this[0]
    for (index in 1..lastIndex)
        accumulator = operation(index, accumulator, this[index])
    return accumulator
}
/**
 * Accumulates value starting with the first element and applying [operation] from left to right
 * to current accumulator value and each element with its index in the original array.
 * 
 * Returns `null` if the array is empty.
 * 
 * @param [operation] function that takes the index of an element, current accumulator value and the element itself,
 * and calculates the next accumulator value.
 */
inline fun LongBuffer.reduceIndexedOrNull(operation: (index: Int, acc: Long, Long) -> Long): Long? {
    if (isEmpty())
        return null
    var accumulator = this[0]
    for (index in 1..lastIndex)
        accumulator = operation(index, accumulator, this[index])
    return accumulator
}
/**
 * Accumulates value starting with the first element and applying [operation] from left to right to current accumulator value and each element.
 * 
 * Returns `null` if the array is empty.
 * 
 * @param [operation] function that takes current accumulator value and an element, and calculates the next accumulator value.
 */
inline fun LongBuffer.reduceOrNull(operation: (acc: Long, Long) -> Long): Long? {
    if (isEmpty())
        return null
    var accumulator = this[0]
    for (index in 1..lastIndex)
        accumulator = operation(accumulator, this[index])
     return accumulator
}
/**
 * Accumulates value starting with the last element and applying [operation] from right to left to each element and current accumulator value.
 * 
 * Throws an exception if this array is empty. If the array can be empty in an expected way,
 * please use [reduceRightOrNull] instead. It returns `null` when its receiver is empty.
 * 
 * @param [operation] function that takes an element and current accumulator value, and calculates the next accumulator value.
 */
inline fun LongBuffer.reduceRight(operation: (Long, acc: Long) -> Long): Long {
    var index = lastIndex
    if (index < 0) throw UnsupportedOperationException("Empty array can't be reduced.")
    var accumulator = get(index--)
    while (index >= 0)
        accumulator = operation(get(index--), accumulator)
    return accumulator
}
/**
 * Accumulates value starting with the last element and applying [operation] from right to left
 * to each element with its index in the original array and current accumulator value.
 * 
 * Throws an exception if this array is empty. If the array can be empty in an expected way,
 * please use [reduceRightIndexedOrNull] instead. It returns `null` when its receiver is empty.
 * 
 * @param [operation] function that takes the index of an element, the element itself and current accumulator value,
 * and calculates the next accumulator value.
 */
inline fun LongBuffer.reduceRightIndexed(operation: (index: Int, Long, acc: Long) -> Long): Long {
    var index = lastIndex
    if (index < 0) throw UnsupportedOperationException("Empty array can't be reduced.")
    var accumulator = get(index--)
    while (index >= 0) {
        accumulator = operation(index, get(index), accumulator)
        --index
    }
    return accumulator
}
/**
 * Accumulates value starting with the last element and applying [operation] from right to left
 * to each element with its index in the original array and current accumulator value.
 * 
 * Returns `null` if the array is empty.
 * 
 * @param [operation] function that takes the index of an element, the element itself and current accumulator value,
 * and calculates the next accumulator value.
 */
inline fun LongBuffer.reduceRightIndexedOrNull(operation: (index: Int, Long, acc: Long) -> Long): Long? {
    var index = lastIndex
    if (index < 0) return null
    var accumulator = get(index--)
    while (index >= 0) {
        accumulator = operation(index, get(index), accumulator)
        --index
    }
    return accumulator
}
/**
 * Accumulates value starting with the last element and applying [operation] from right to left to each element and current accumulator value.
 * 
 * Returns `null` if the array is empty.
 * 
 * @param [operation] function that takes an element and current accumulator value, and calculates the next accumulator value.
 */
inline fun LongBuffer.reduceRightOrNull(operation: (Long, acc: Long) -> Long): Long? {
    var index = lastIndex
    if (index < 0) return null
    var accumulator = get(index--)
    while (index >= 0)
         accumulator = operation(get(index--), accumulator)
    return accumulator
}
/**
 * Splits the original array into pair of lists, where *first* list contains elements for which [predicate] 
 * yielded `true`, while *second* list contains elements for which [predicate] yielded `false`.
 */
inline fun LongBuffer.partition(predicate: (Long) -> Boolean): Pair<List<Long>, List<Long>> {
    val first = ArrayList<Long>()
    val second = ArrayList<Long>()
    for (element in this)
        if (predicate(element))
            first.add(element)
        else
            second.add(element)
    return Pair(first, second)
}
/**
 * Returns a list of pairs built from the elements of `this` array and the [other] array with the same index.
 * The returned list has length of the shortest collection.
 */
infix fun <R> LongBuffer.zip(other: Array<out R>): List<Pair<Long, R>> = zip(other) { t1, t2 -> t1 to t2 }
/**
 * Returns a list of values built from the elements of `this` array and the [other] array with the same index
 * using the provided [transform] function applied to each pair of elements.
 * The returned list has length of the shortest collection.
 */
inline fun <R, V> LongBuffer.zip(other: Array<out R>, transform: (a: Long, b: R) -> V): List<V> {
    val size = minOf(rem, other.size)
    val list = ArrayList<V>(size)
    for (i in 0 until size)
        list.add(transform(this[i], other[i]))
    return list
}
/**
 * Returns a list of pairs built from the elements of `this` collection and [other] array with the same index.
 * The returned list has length of the shortest collection.
 */
infix fun <R> LongBuffer.zip(other: Iterable<R>): List<Pair<Long, R>> = zip(other) { t1, t2 -> t1 to t2 }
/**
 * Returns a list of values built from the elements of `this` array and the [other] collection with the same index
 * using the provided [transform] function applied to each pair of elements.
 * The returned list has length of the shortest collection.
 */
inline fun <R, V> LongBuffer.zip(other: Iterable<R>, transform: (a: Long, b: R) -> V): List<V> {
    val arraySize = rem
    val list = ArrayList<V>(minOf(other.collectionSizeOrDefault(10), arraySize))
    var i = 0
    for (element in other) {
        if (i >= arraySize) break
        list.add(transform(this[i++], element))
    }
    return list
}
/**
 * Returns a list of pairs built from the elements of `this` array and the [other] array with the same index.
 * The returned list has length of the shortest collection.
 */
infix fun LongBuffer.zip(other: LongArray): List<Pair<Long, Long>> = zip(other) { t1, t2 -> t1 to t2 }
/**
 * Returns a list of values built from the elements of `this` array and the [other] array with the same index
 * using the provided [transform] function applied to each pair of elements.
 * The returned list has length of the shortest array.
 */
inline fun <V> LongBuffer.zip(other: LongArray, transform: (a: Long, b: Long) -> V): List<V> {
    val size = minOf(rem, other.size)
    val list = ArrayList<V>(size)
    for (i in 0 until size)
        list.add(transform(this[i], other[i]))
    return list
}
/**
 * Appends the string from all the elements separated using [separator] and using the given [prefix] and [postfix] if supplied.
 * 
 * If the collection could be huge, you can specify a non-negative value of [limit], in which case only the first [limit]
 * elements will be appended, followed by the [truncated] string (which defaults to "...").
 */
fun <A : Appendable> LongBuffer.joinTo(buffer: A, separator: CharSequence = ", ", prefix: CharSequence = "", postfix: CharSequence = "", limit: Int = -1, truncated: CharSequence = "...", transform: ((Long) -> CharSequence)? = null): A {
    buffer.append(prefix)
    var count = 0
    for (element in this) {
        if (++count > 1) buffer.append(separator)
        if (limit < 0 || count <= limit)
            if (transform != null)
                buffer.append(transform(element))
            else
                buffer.append(element.toString())
        else break
    }
    if (limit >= 0 && count > limit) buffer.append(truncated)
    buffer.append(postfix)
    return buffer
}
/**
 * Creates a string from all the elements separated using [separator] and using the given [prefix] and [postfix] if supplied.
 * 
 * If the collection could be huge, you can specify a non-negative value of [limit], in which case only the first [limit]
 * elements will be appended, followed by the [truncated] string (which defaults to "...").
 */
fun LongBuffer.joinToString(separator: CharSequence = ", ", prefix: CharSequence = "", postfix: CharSequence = "", limit: Int = -1, truncated: CharSequence = "...", transform: ((Long) -> CharSequence)? = null): String =
    joinTo(StringBuilder(), separator, prefix, postfix, limit, truncated, transform).toString()
/**
 * Returns 1st *element* from the buffer.
 * 
 * If the size of this array is less than 1, throws an [IndexOutOfBoundsException]
 */
inline operator fun UByteBuffer.component1(): UByte = get(0)
/**
 * Returns 2nd *element* from the buffer.
 * 
 * If the size of this array is less than 2, throws an [IndexOutOfBoundsException]
 */
inline operator fun UByteBuffer.component2(): UByte = get(1)
/**
 * Returns 3rd *element* from the buffer.
 * 
 * If the size of this array is less than 3, throws an [IndexOutOfBoundsException]
 */
inline operator fun UByteBuffer.component3(): UByte = get(2)
/**
 * Returns 4th *element* from the buffer.
 * 
 * If the size of this array is less than 4, throws an [IndexOutOfBoundsException]
 */
inline operator fun UByteBuffer.component4(): UByte = get(3)
/**
 * Returns 5th *element* from the buffer.
 * 
 * If the size of this array is less than 5, throws an [IndexOutOfBoundsException]
 */
inline operator fun UByteBuffer.component5(): UByte = get(4)
/** Returns `true` if [element] is found in the array. */
operator fun UByteBuffer.contains(element: UByte): Boolean = indexOf(element) >= 0
/** Returns an element at the given [index] or throws an [IndexOutOfBoundsException] if the [index] is out of bounds of this array. */
inline fun <T> UByteBuffer.elementAt(index: Int): UByte = get(index)
/** Returns an element at the given [index] or the result of calling the [defaultValue] function if the [index] is out of bounds of this array. */
inline fun UByteBuffer.elementAtOrElse(index: Int, defaultValue: (Int) -> UByte): UByte = if (index >= 0 && index <= lastIndex) get(index) else defaultValue(index)
/** Returns an element at the given [index] or `null` if the [index] is out of bounds of this array. */
inline fun UByteBuffer.elementAtOrNull(index: Int): UByte? = this.getOrNull(index)
/** Returns the first element matching the given [predicate], or `null` if no such element was found. */
inline fun UByteBuffer.find(predicate: (UByte) -> Boolean): UByte? = firstOrNull(predicate)
/** Returns the last element matching the given [predicate], or `null` if no such element was found. */
inline fun UByteBuffer.findLast(predicate: (UByte) -> Boolean): UByte? = lastOrNull(predicate)
/**
 * Returns the first element.
 * 
 * @throws NoSuchElementException if the array is empty.
 */
fun UByteBuffer.first(): UByte {
    if (isEmpty())
        throw NoSuchElementException("Array is empty.")
    return this[0]
}
/**
 * Returns the first element matching the given [predicate].
 * @throws [NoSuchElementException] if no such element is found.
 */
inline fun UByteBuffer.first(predicate: (UByte) -> Boolean): UByte {
    for (element in this) if (predicate(element)) return element
    throw NoSuchElementException("Array contains no element matching the predicate.")
}
/** Returns the first element, or `null` if the array is empty. */
fun UByteBuffer.firstOrNull(): UByte? = if (isEmpty()) null else this[0]
/** Returns the first element matching the given [predicate], or `null` if element was not found. */
inline fun UByteBuffer.firstOrNull(predicate: (UByte) -> Boolean): UByte? {
    for (element in this) if (predicate(element)) return element
    return null
}
/** Returns an element at the given [index] or the result of calling the [defaultValue] function if the [index] is out of bounds of this array. */
inline fun UByteBuffer.getOrElse(index: Int, defaultValue: (Int) -> UByte): UByte = if (index >= 0 && index <= lastIndex) get(index) else defaultValue(index)
/** Returns an element at the given [index] or `null` if the [index] is out of bounds of this array. */
fun UByteBuffer.getOrNull(index: Int): UByte? = if (index >= 0 && index <= lastIndex) get(index) else null
/** Returns first index of [element], or -1 if the array does not contain element. */
fun UByteBuffer.indexOf(element: UByte): Int {
    for (index in indices)
        if (element == this[index])
            return index
    return -1
}
/** Returns index of the first element matching the given [predicate], or -1 if the array does not contain such element. */
inline fun UByteBuffer.indexOfFirst(predicate: (UByte) -> Boolean): Int {
    for (index in indices)
        if (predicate(this[index]))
            return index
    return -1
}
/** Returns index of the last element matching the given [predicate], or -1 if the array does not contain such element. */
inline fun UByteBuffer.indexOfLast(predicate: (UByte) -> Boolean): Int {
    for (index in indices.reversed())
        if (predicate(this[index]))
            return index
    return -1
}
/**
 * Returns the last element.
 * 
 * @throws NoSuchElementException if the array is empty.
 */
fun UByteBuffer.last(): UByte {
    if (isEmpty())
        throw NoSuchElementException("Array is empty.")
    return this[lastIndex]
}
/**
 * Returns the last element matching the given [predicate].
 * 
 * @throws NoSuchElementException if no such element is found.
 */
inline fun UByteBuffer.last(predicate: (UByte) -> Boolean): UByte {
    for (index in this.indices.reversed()) {
        val element = this[index]
        if (predicate(element)) return element
    }
    throw NoSuchElementException("Array contains no element matching the predicate.")
}
/** Returns last index of [element], or -1 if the array does not contain element. */
fun UByteBuffer.lastIndexOf(element: UByte): Int {
    for (index in indices.reversed())
        if (element == this[index])
            return index
    return -1
}
/** Returns the last element, or `null` if the array is empty. */
fun UByteBuffer.lastOrNull(): UByte? = if (isEmpty()) null else this[rem - 1]
/** Returns the last element matching the given [predicate], or `null` if no such element was found. */
inline fun UByteBuffer.lastOrNull(predicate: (UByte) -> Boolean): UByte? {
    for (index in this.indices.reversed()) {
        val element = this[index]
        if (predicate(element)) return element
    }
    return null
}
/** Returns the single element, or throws an exception if the array is empty or has more than one element. */
fun UByteBuffer.single(): UByte = when (rem) {
    0 -> throw NoSuchElementException("Array is empty.")
    1 -> this[0]
    else -> throw IllegalArgumentException("Array has more than one element.")
}
/** Returns the single element matching the given [predicate], or throws exception if there is no or more than one matching element. */
inline fun UByteBuffer.single(predicate: (UByte) -> Boolean): UByte {
    var single: UByte? = null
    var found = false
    for (element in this)
        if (predicate(element)) {
            if (found) throw IllegalArgumentException("Array contains more than one matching element.")
            single = element
            found = true
        }
    if (!found) throw NoSuchElementException("Array contains no element matching the predicate.")
    @Suppress("UNCHECKED_CAST")
    return single as UByte
}
/** Returns single element, or `null` if the array is empty or has more than one element. */
fun UByteBuffer.singleOrNull(): UByte? = if (rem == 1) this[0] else null
/** Returns the single element matching the given [predicate], or `null` if element was not found or more than one element was found. */
inline fun UByteBuffer.singleOrNull(predicate: (UByte) -> Boolean): UByte? {
    var single: UByte? = null
    var found = false
    for (element in this)
        if (predicate(element)) {
            if (found) return null
            single = element
            found = true
        }
    if (!found) return null
    return single
}
/** Returns a list containing only elements matching the given [predicate]. */
inline fun UByteBuffer.filter(predicate: (UByte) -> Boolean): List<UByte> = filterTo(ArrayList<UByte>(), predicate)
/**
 * Returns a list containing only elements matching the given [predicate].
 * @param [predicate] function that takes the index of an element and the element itself and returns the result of predicate evaluation on the element.
 */
inline fun UByteBuffer.filterIndexed(predicate: (index: Int, UByte) -> Boolean): List<UByte> = filterIndexedTo(ArrayList<UByte>(), predicate)
/**
 * Appends all elements matching the given [predicate] to the given [destination].
 * @param [predicate] function that takes the index of an element and the element itself and returns the result of predicate evaluation on the element.
 */
inline fun <C : MutableCollection<in UByte>> UByteBuffer.filterIndexedTo(destination: C, predicate: (index: Int, UByte) -> Boolean): C {
    forEachIndexed { index, element ->
        if (predicate(index, element)) destination.add(element)
    }
    return destination
}
/** Returns a list containing all elements not matching the given [predicate]. */
inline fun UByteBuffer.filterNot(predicate: (UByte) -> Boolean): List<UByte> = filterNotTo(ArrayList<UByte>(), predicate)
/** Appends all elements not matching the given [predicate] to the given [destination]. */
inline fun <C : MutableCollection<in UByte>> UByteBuffer.filterNotTo(destination: C, predicate: (UByte) -> Boolean): C {
     for (element in this) if (!predicate(element)) destination.add(element)
     return destination
}
/** Appends all elements matching the given [predicate] to the given [destination]. */
inline fun <C : MutableCollection<in UByte>> UByteBuffer.filterTo(destination: C, predicate: (UByte) -> Boolean): C {
     for (element in this) if (predicate(element)) destination.add(element)
     return destination
}
/** Returns a list containing elements at specified [indices]. */
fun UByteBuffer.slice(indices: Iterable<Int>): List<UByte> {
    val size = indices.collectionSizeOrDefault(10)
    if (size == 0) return emptyList()
    val list = ArrayList<UByte>(size)
    for (index in indices)
        list.add(get(index))
    return list
}
/** Returns an array containing elements of this array at specified [indices]. */
fun UByteBuffer.sliceArray(indices: Collection<Int>): UByteArray {
    val result = UByteArray(indices.size)
    var targetIndex = 0
    for (sourceIndex in indices)
        result[targetIndex++] = this[sourceIndex]
    return result
}
/** Sorts elements in the array in-place descending according to their natural sort order. */
fun UByteBuffer.sortDescending() {
    if (rem > 1) {
        val array = toUByteArray().apply{ sortDescending() }
        for (i in 0 until rem)
            this[pos + i] = array[i]
    }
}
/** Returns a list of all elements sorted according to their natural sort order. */
fun UByteBuffer.sorted(): List<UByte> = toTypedArray().apply { sort() }.asList()
/** Returns an array with all elements of this array sorted according to their natural sort order. */
fun UByteBuffer.sortedArray(): UByteArray = toUByteArray().apply { sort() }
/** Returns an array with all elements of this array sorted descending according to their natural sort order. */
fun UByteBuffer.sortedArrayDescending(): UByteArray = toUByteArray().apply { sortDescending() }
/** Returns a list of all elements sorted according to natural sort order of the value returned by specified [selector] function. */
inline fun <R : Comparable<R>> UByteBuffer.sortedBy(crossinline selector: (UByte) -> R?): List<UByte> = toUByteArray().sortedWith(compareBy(selector))
/** Returns a list of all elements sorted descending according to natural sort order of the value returned by specified [selector] function. */
inline fun <R : Comparable<R>> UByteBuffer.sortedByDescending(crossinline selector: (UByte) -> R?): List<UByte> = toUByteArray().sortedWith(compareByDescending(selector))
/** Returns a list of all elements sorted descending according to their natural sort order. */
fun UByteBuffer.sortedDescending(): List<UByte> = toUByteArray().apply { sort() }.reversed()
/** Returns a list of all elements sorted according to the specified [comparator]. */
fun UByteBuffer.sortedWith(comparator: Comparator<in UByte>): List<UByte> = toTypedArray().apply { sortWith(comparator) }.asList()
/** Sorts the array in-place. */
fun UByteBuffer.sort() {
    if (rem > 1) {
        val array = toUByteArray().apply{ sort() }
        for (i in 0 until rem)
            this[pos + i] = array[i]
    }
}
/** Returns a string representation of the contents of the specified array as if it is [List]. */
fun UByteBuffer.contentToString(): String {
    val iMax = lim - 1
    if (iMax == -1) return "[]"
    val b = StringBuilder()
    b.append('[')
    var i = 0
    while (true) {
        b.append(get(i))
        if (i == iMax) return b.append(']').toString()
        b.append(", ")
        i++
    }
}
/**
 * Fills this array or its subrange with the specified [element] value.
 * 
 * @param fromIndex the start of the range (inclusive) to fill, 0 by default.
 * @param toIndex the end of the range (exclusive) to fill, size of this array by default.
 * 
 * @throws IndexOutOfBoundsException if [fromIndex] is less than zero or [toIndex] is greater than the size of this array.
 * @throws IllegalArgumentException if [fromIndex] is greater than [toIndex].
 */
fun UByteBuffer.fill(element: UByte, fromIndex: Int = pos, toIndex: Int = rem) {
    for (i in fromIndex until toIndex)
        this[i] = element
}
/** Returns the range of valid indices for the array. */
val UByteBuffer.indices: IntRange
    get() = IntRange(0, lastIndex)
/** Returns `true` if the array is empty. */
inline fun UByteBuffer.isEmpty(): Boolean = rem == 0
/** Returns `true` if the array is not empty. */
inline fun UByteBuffer.isNotEmpty(): Boolean = !isEmpty()
/** Returns the last valid index for the array. */
val UByteBuffer.lastIndex: Int
    get() = rem - 1
/** Returns an array of Byte containing all of the elements of this generic array. */
fun UByteBuffer.toUByteArray(): UByteArray = UByteArray(rem) { index -> this[index] }
/** Returns a *typed* object array containing all of the elements of this primitive array. */
fun UByteBuffer.toTypedArray(): Array<UByte> = Array(rem) { index -> this[index] }
/**
 * Returns a [Map] containing key-value pairs provided by [transform] function applied to elements of the given array.
 * 
 * If any of two pairs would have the same key the last one gets added to the map.
 * 
 * The returned map preserves the entry iteration order of the original array.
 */
inline fun <K, V> UByteBuffer.associate(transform: (UByte) -> Pair<K, V>): Map<K, V> {
    val capacity = mapCapacity(rem).coerceAtLeast(16)
    return associateTo(LinkedHashMap<K, V>(capacity), transform)
}
/**
 * Returns a [Map] containing the elements from the given array indexed by the key returned from [keySelector] function applied to each element.
 * 
 * If any two elements would have the same key returned by [keySelector] the last one gets added to the map.
 * 
 * The returned map preserves the entry iteration order of the original array.
 */
inline fun <K> UByteBuffer.associateBy(keySelector: (UByte) -> K): Map<K, UByte> {
    val capacity = mapCapacity(rem).coerceAtLeast(16)
    return associateByTo(LinkedHashMap<K, UByte>(capacity), keySelector)
}
/**
 * Returns a [Map] containing the values provided by [valueTransform] and indexed by [keySelector] functions applied to elements of the given array.
 * 
 * If any two elements would have the same key returned by [keySelector] the last one gets added to the map.
 * 
 * The returned map preserves the entry iteration order of the original array.
 */
inline fun <K, V> UByteBuffer.associateBy(keySelector: (UByte) -> K, valueTransform: (UByte) -> V): Map<K, V> {
    val capacity = mapCapacity(rem).coerceAtLeast(16)
    return associateByTo(LinkedHashMap<K, V>(capacity), keySelector, valueTransform)
}
/**
 * Populates and returns the [destination] mutable map with key-value pairs, where key is provided by
 * the [keySelector] function applied to each element of the given array and value is the element itself.
 * 
 * If any two elements would have the same key returned by [keySelector] the last one gets added to the map.
 */
inline fun <K, M : MutableMap<in K, in UByte>> UByteBuffer.associateByTo(destination: M, keySelector: (UByte) -> K): M {
    for (element in this)
        destination.put(keySelector(element), element)
    return destination
}
/**
 * Populates and returns the [destination] mutable map with key-value pairs, where key is provided by the [keySelector]
 * function and and value is provided by the [valueTransform] function applied to elements of the given array.
 * 
 * If any two elements would have the same key returned by [keySelector] the last one gets added to the map.
 */
inline fun <K, V, M : MutableMap<in K, in V>> UByteBuffer.associateByTo(destination: M, keySelector: (UByte) -> K, valueTransform: (UByte) -> V): M {
    for (element in this)
        destination.put(keySelector(element), valueTransform(element))
    return destination
}
/**
 * Populates and returns the [destination] mutable map with key-value pairs provided by [transform] function
 * applied to each element of the given array.
 * 
 * If any of two pairs would have the same key the last one gets added to the map.
 */
inline fun <K, V, M : MutableMap<in K, in V>> UByteBuffer.associateTo(destination: M, transform: (UByte) -> Pair<K, V>): M {
    for (element in this)
        destination += transform(element)
    return destination
}
/**
 * Returns a [Map] where keys are elements from the given array and values are produced by the [valueSelector] function applied to each element.
 * 
 * If any two elements are equal, the last one gets added to the map.
 * 
 * The returned map preserves the entry iteration order of the original array.
 */
inline fun <V> UByteBuffer.associateWith(valueSelector: (UByte) -> V): Map<UByte, V> {
    val result = LinkedHashMap<UByte, V>(mapCapacity(rem).coerceAtLeast(16))
    return associateWithTo(result, valueSelector)
}
/**
 * Populates and returns the [destination] mutable map with key-value pairs for each element of the given array,
 * where key is the element itself and value is provided by the [valueSelector] function applied to that key.
 * 
 * If any two elements are equal, the last one overwrites the former value in the map.
 */
inline fun <V, M : MutableMap<in UByte, in V>> UByteBuffer.associateWithTo(destination: M, valueSelector: (UByte) -> V): M {
    for (element in this)
        destination.put(element, valueSelector(element))
    return destination
}
/** Appends all elements to the given [destination] collection. */
fun <C : MutableCollection<in UByte>> UByteBuffer.toCollection(destination: C): C {
    for (item in this)
        destination.add(item)
    return destination
}
/** Returns a single list of all elements yielded from results of [transform] function being invoked on each element of original array. */
inline fun <R> UByteBuffer.flatMap(transform: (UByte) -> Iterable<R>): List<R> = flatMapTo(ArrayList<R>(), transform)
/** Appends all elements yielded from results of [transform] function being invoked on each element of original array, to the given [destination]. */
inline fun <R, C : MutableCollection<in R>> UByteBuffer.flatMapTo(destination: C, transform: (UByte) -> Iterable<R>): C {
    for (element in this) {
        val list = transform(element)
        destination.addAll(list)
    }
    return destination
}
/**
 * Groups elements of the original array by the key returned by the given [keySelector] function applied to
 * each element and returns a map where each group key is associated with a list of corresponding elements.
 * 
 * The returned map preserves the entry iteration order of the keys produced from the original array.
 */
inline fun <K> UByteBuffer.groupBy(keySelector: (UByte) -> K): Map<K, List<UByte>> = groupByTo(LinkedHashMap<K, MutableList<UByte>>(), keySelector)
/**
 * Groups values returned by the [valueTransform] function applied to each element of the original array
 * by the key returned by the given [keySelector] function applied to the element
 * and returns a map where each group key is associated with a list of corresponding values.
 * 
 * The returned map preserves the entry iteration order of the keys produced from the original array.
 */
inline fun <K, V> UByteBuffer.groupBy(keySelector: (UByte) -> K, valueTransform: (UByte) -> V): Map<K, List<V>> = groupByTo(LinkedHashMap<K, MutableList<V>>(), keySelector, valueTransform)
/**
 * Groups elements of the original array by the key returned by the given [keySelector] function applied to each
 * element and puts to the [destination] map each group key associated with a list of corresponding elements.
 * 
 * @return The [destination] map.
 */
inline fun <K, M : MutableMap<in K, MutableList<UByte>>> UByteBuffer.groupByTo(destination: M, keySelector: (UByte) -> K): M {
    for (element in this) {
        val key = keySelector(element)
        val list = destination.getOrPut(key) { ArrayList<UByte>() }
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
 */
inline fun <K, V, M : MutableMap<in K, MutableList<V>>> UByteBuffer.groupByTo(destination: M, keySelector: (UByte) -> K, valueTransform: (UByte) -> V): M {
    for (element in this) {
        val key = keySelector(element)
        val list = destination.getOrPut(key) { ArrayList<V>() }
        list.add(valueTransform(element))
    }
    return destination
}
/**
 * Returns a list containing only distinct elements from the given array.
 * 
 * The elements in the resulting list are in the same order as they were in the source array.
 */
fun UByteBuffer.distinct(): List<UByte> = this.toMutableSet().toList()
/**
 * Returns a list containing only elements from the given array having distinct keys returned by the given [selector] function.
 * 
 * The elements in the resulting list are in the same order as they were in the source array.
 */
inline fun <K> UByteBuffer.distinctBy(selector: (UByte) -> K): List<UByte> {
    val set = HashSet<K>()
    val list = ArrayList<UByte>()
    for (e in this) {
        val key = selector(e)
        if (set.add(key))
            list.add(e)
    }
    return list
}
/**
 * Returns a new [MutableSet] containing all distinct elements from the given array.
 * 
 * The returned set preserves the element iteration order of the original array.
 */
fun UByteBuffer.toMutableSet(): MutableSet<UByte> = toCollection(LinkedHashSet<UByte>(mapCapacity(rem)))
/** Returns a list containing the results of applying the given [transform] function to each element in the original array. */
inline fun <R> UByteBuffer.map(transform: (UByte) -> R): List<R> = mapTo(ArrayList<R>(rem), transform)
/**
 * Returns a list containing the results of applying the given [transform] function to each element and its index in the original array.
 * @param [transform] function that takes the index of an element and the element itself and returns the result of the transform applied to the element.
 */
inline fun <R> UByteBuffer.mapIndexed(transform: (index: Int, UByte) -> R): List<R> = mapIndexedTo(ArrayList<R>(rem), transform)
/**
 * Applies the given [transform] function to each element and its index in the original array and appends the results to the given [destination].
 * @param [transform] function that takes the index of an element and the element itself and returns the result of the transform applied to the element.
 */
inline fun <R, C : MutableCollection<in R>> UByteBuffer.mapIndexedTo(destination: C, transform: (index: Int, UByte) -> R): C {
    var index = 0
    for (item in this)
        destination.add(transform(index++, item))
    return destination
}
/** Applies the given [transform] function to each element of the original array and appends the results to the given [destination]. */
inline fun <R, C : MutableCollection<in R>> UByteBuffer.mapTo(destination: C, transform: (UByte) -> R): C {
    for (item in this)
        destination.add(transform(item))
    return destination
}
/** Returns `true` if all elements match the given [predicate]. */
inline fun UByteBuffer.all(predicate: (UByte) -> Boolean): Boolean {
    for (element in this) if (!predicate(element)) return false
    return true
}
/** Returns `true` if array has at least one element. */
fun UByteBuffer.any(): Boolean = !isEmpty()
/** Returns `true` if at least one element matches the given [predicate]. */
inline fun UByteBuffer.any(predicate: (UByte) -> Boolean): Boolean {
    for (element in this) if (predicate(element)) return true
    return false
}
/** Returns the number of elements in this array. */
inline fun UByteBuffer.count(): Int = rem
/** Returns the number of elements matching the given [predicate]. */
inline fun UByteBuffer.count(predicate: (UByte) -> Boolean): Int {
    var count = 0
    for (element in this) if (predicate(element)) ++count
    return count
}
/** Performs the given [action] on each element. */
inline fun UByteBuffer.forEach(action: (UByte) -> Unit) { for (element in this) action(element) }
/**
 * Performs the given [action] on each element, providing sequential index with the element.
 * @param [action] function that takes the index of an element and the element itself and performs the action on the element.
 */
inline fun UByteBuffer.forEachIndexed(action: (index: Int, UByte) -> Unit): Unit {
    var index = 0
    for (item in this) action(index++, item)
}
/**
 * Returns the largest element.
 * 
 * @throws NoSuchElementException if the array is empty.
 */
fun UByteBuffer.max(): UByte {
    if (isEmpty()) throw NoSuchElementException()
    var max = this[0]
    for (i in 1..lastIndex) {
        val e = this[i]
        if (max < e) max = e
    }
    return max
}
/**
 * Returns the first element yielding the largest value of the given function.
 * 
 * @throws NoSuchElementException if the array is empty.
 */
inline fun <R : Comparable<R>> UByteBuffer.maxBy(selector: (UByte) -> R): UByte {
    if (isEmpty()) throw NoSuchElementException()
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
/** Returns the first element yielding the largest value of the given function or `null` if there are no elements. */
inline fun <R : Comparable<R>> UByteBuffer.maxByOrNull(selector: (UByte) -> R): UByte? {
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
/** Returns the largest element or `null` if there are no elements. */
fun UByteBuffer.maxOrNull(): UByte? {
    if (isEmpty()) return null
    var max = this[0]
    for (i in 1..lastIndex) {
        val e = this[i]
        if (max < e) max = e
    }
    return max
}
/**
 * Returns the first element having the largest value according to the provided [comparator].
 * 
 * @throws NoSuchElementException if the array is empty.
 */
fun UByteBuffer.maxWith(comparator: Comparator<in UByte>): UByte {
    if (isEmpty()) throw NoSuchElementException()
    var max = this[0]
    for (i in 1..lastIndex) {
        val e = this[i]
        if (comparator.compare(max, e) < 0) max = e
    }
    return max
}
/** Returns the first element having the largest value according to the provided [comparator] or `null` if there are no elements. */
fun UByteBuffer.maxWithOrNull(comparator: Comparator<in UByte>): UByte? {
    if (isEmpty()) return null
    var max = this[0]
    for (i in 1..lastIndex) {
        val e = this[i]
        if (comparator.compare(max, e) < 0) max = e
    }
    return max
}
/**
 * Returns the smallest element.
 * 
 * @throws NoSuchElementException if the array is empty.
 */
fun UByteBuffer.min(): UByte {
    if (isEmpty()) throw NoSuchElementException()
    var min = this[0]
    for (i in 1..lastIndex) {
        val e = this[i]
        if (min > e) min = e
    }
    return min
}
/**
 * Returns the first element yielding the smallest value of the given function.
 * 
 * @throws NoSuchElementException if the array is empty.
 */
inline fun <R : Comparable<R>> UByteBuffer.minBy(selector: (UByte) -> R): UByte {
    if (isEmpty()) throw NoSuchElementException()
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
 * Returns the first element yielding the smallest value of the given function or `null` if there are no elements.
 * 
 * @sample samples.collections.Collections.Aggregates.minByOrNull
 */
inline fun <R : Comparable<R>> UByteBuffer.minByOrNull(selector: (UByte) -> R): UByte? {
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
 * Returns the smallest value among all values produced by [selector] function applied to each element in the array.
 * 
 * If any of values produced by [selector] function is `NaN`, the returned result is `NaN`.
 * 
 * @throws NoSuchElementException if the array is empty.
 */
inline fun UByteBuffer.minOf(selector: (UByte) -> Double): Double {
    if (isEmpty()) throw NoSuchElementException()
    var minValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        minValue = minOf(minValue, v)
    }
    return minValue
}
/**
 * Returns the smallest value among all values produced by [selector] function applied to each element in the array.
 * 
 * If any of values produced by [selector] function is `NaN`, the returned result is `NaN`.
 * 
 * @throws NoSuchElementException if the array is empty.
 */
inline fun UByteBuffer.minOf(selector: (UByte) -> Float): Float {
    if (isEmpty()) throw NoSuchElementException()
    var minValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        minValue = minOf(minValue, v)
    }
    return minValue
}
/**
 * Returns the smallest value among all values produced by [selector] function applied to each element in the array.
 * 
 * @throws NoSuchElementException if the array is empty.
 */
inline fun <R : Comparable<R>> UByteBuffer.minOf(selector: (UByte) -> R): R {
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
 * Returns the smallest value among all values produced by [selector] function applied to each element in the array or `null` if there are no elements.
 * 
 * If any of values produced by [selector] function is `NaN`, the returned result is `NaN`.
 */
inline fun UByteBuffer.minOfOrNull(selector: (UByte) -> Double): Double? {
    if (isEmpty()) return null
    var minValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        minValue = minOf(minValue, v)
    }
    return minValue
}
/**
 * Returns the smallest value among all values produced by [selector] function applied to each element in the array or `null` if there are no elements.
 * 
 * If any of values produced by [selector] function is `NaN`, the returned result is `NaN`.
 */
inline fun UByteBuffer.minOfOrNull(selector: (UByte) -> Float): Float? {
    if (isEmpty()) return null
    var minValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        minValue = minOf(minValue, v)
    }
    return minValue
}
/** Returns the smallest value among all values produced by [selector] function applied to each element in the array or `null` if there are no elements. */
inline fun <R : Comparable<R>> UByteBuffer.minOfOrNull(selector: (UByte) -> R): R? {
    if (isEmpty()) return null
    var minValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        if (minValue > v)
            minValue = v
    }
    return minValue
}
/**
 * Returns the smallest value according to the provided [comparator] among all values produced by [selector] function applied to each element in the array.
 * 
 * @throws NoSuchElementException if the array is empty.
 */
inline fun <R> UByteBuffer.minOfWith(comparator: Comparator<in R>, selector: (UByte) -> R): R {
    if (isEmpty()) throw NoSuchElementException()
    var minValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        if (comparator.compare(minValue, v) > 0)
            minValue = v
    }
    return minValue
}
/**
 * Returns the smallest value according to the provided [comparator] among all values produced by [selector]
 * function applied to each element in the array or `null` if there are no elements.
 */
inline fun <R> UByteBuffer.minOfWithOrNull(comparator: Comparator<in R>, selector: (UByte) -> R): R? {
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
fun UByteBuffer.minOrNull(): UByte? {
     if (isEmpty()) return null
     var min = this[0]
     for (i in 1..lastIndex) {
         val e = this[i]
         if (min > e) min = e
     }
     return min
 }
/**
 * Returns the first element having the smallest value according to the provided [comparator].
 * 
 * @throws NoSuchElementException if the array is empty.
 */
fun UByteBuffer.minWith(comparator: Comparator<in UByte>): UByte {
    if (isEmpty()) throw NoSuchElementException()
    var min = this[0]
    for (i in 1..lastIndex) {
        val e = this[i]
        if (comparator.compare(min, e) > 0) min = e
    }
    return min
}
/** Returns the first element having the smallest value according to the provided [comparator] or `null` if there are no elements. */
fun UByteBuffer.minWithOrNull(comparator: Comparator<in UByte>): UByte? {
    if (isEmpty()) return null
    var min = this[0]
    for (i in 1..lastIndex) {
        val e = this[i]
        if (comparator.compare(min, e) > 0) min = e
    }
    return min
}
/** Returns `true` if the array has no elements. */
fun UByteBuffer.none(): Boolean = isEmpty()
/** Returns `true` if no elements match the given [predicate]. */
inline fun UByteBuffer.none(predicate: (UByte) -> Boolean): Boolean {
    for (element in this) if (predicate(element)) return false
    return true
}
/** Performs the given [action] on each element and returns the array itself afterwards. */
inline fun UByteBuffer.onEach(action: (UByte) -> Unit): UByteBuffer = apply { for (element in this) action(element) }
/**
 * Performs the given [action] on each element, providing sequential index with the element, and returns the array itself afterwards.
 * @param [action] function that takes the index of an element and the element itself and performs the action on the element.
 */
inline fun UByteBuffer.onEachIndexed(action: (index: Int, UByte) -> Unit): UByteBuffer = apply { forEachIndexed(action) }
/**
 * Accumulates value starting with the first element and applying [operation] from left to right to current accumulator value and each element.
 * 
 * Throws an exception if this array is empty. If the array can be empty in an expected way,
 * please use [reduceOrNull] instead. It returns `null` when its receiver is empty.
 * 
 * @param [operation] function that takes current accumulator value and an element, and calculates the next accumulator value.
 */
inline fun UByteBuffer.reduce(operation: (acc: UByte, UByte) -> UByte): UByte {
    if (isEmpty())
        throw UnsupportedOperationException("Empty array can't be reduced.")
    var accumulator = this[0]
    for (index in 1..lastIndex)
        accumulator = operation(accumulator, this[index])
    return accumulator
}
/**
 * Accumulates value starting with the first element and applying [operation] from left to right
 * to current accumulator value and each element with its index in the original array.
 * 
 * Throws an exception if this array is empty. If the array can be empty in an expected way,
 * please use [reduceIndexedOrNull] instead. It returns `null` when its receiver is empty.
 * 
 * @param [operation] function that takes the index of an element, current accumulator value and the element itself,
 * and calculates the next accumulator value.
 */
inline fun UByteBuffer.reduceIndexed(operation: (index: Int, acc: UByte, UByte) -> UByte): UByte {
    if (isEmpty())
        throw UnsupportedOperationException("Empty array can't be reduced.")
    var accumulator = this[0]
    for (index in 1..lastIndex)
        accumulator = operation(index, accumulator, this[index])
    return accumulator
}
/**
 * Accumulates value starting with the first element and applying [operation] from left to right
 * to current accumulator value and each element with its index in the original array.
 * 
 * Returns `null` if the array is empty.
 * 
 * @param [operation] function that takes the index of an element, current accumulator value and the element itself,
 * and calculates the next accumulator value.
 */
inline fun UByteBuffer.reduceIndexedOrNull(operation: (index: Int, acc: UByte, UByte) -> UByte): UByte? {
    if (isEmpty())
        return null
    var accumulator = this[0]
    for (index in 1..lastIndex)
        accumulator = operation(index, accumulator, this[index])
    return accumulator
}
/**
 * Accumulates value starting with the first element and applying [operation] from left to right to current accumulator value and each element.
 * 
 * Returns `null` if the array is empty.
 * 
 * @param [operation] function that takes current accumulator value and an element, and calculates the next accumulator value.
 */
inline fun UByteBuffer.reduceOrNull(operation: (acc: UByte, UByte) -> UByte): UByte? {
    if (isEmpty())
        return null
    var accumulator = this[0]
    for (index in 1..lastIndex)
        accumulator = operation(accumulator, this[index])
     return accumulator
}
/**
 * Accumulates value starting with the last element and applying [operation] from right to left to each element and current accumulator value.
 * 
 * Throws an exception if this array is empty. If the array can be empty in an expected way,
 * please use [reduceRightOrNull] instead. It returns `null` when its receiver is empty.
 * 
 * @param [operation] function that takes an element and current accumulator value, and calculates the next accumulator value.
 */
inline fun UByteBuffer.reduceRight(operation: (UByte, acc: UByte) -> UByte): UByte {
    var index = lastIndex
    if (index < 0) throw UnsupportedOperationException("Empty array can't be reduced.")
    var accumulator = get(index--)
    while (index >= 0)
        accumulator = operation(get(index--), accumulator)
    return accumulator
}
/**
 * Accumulates value starting with the last element and applying [operation] from right to left
 * to each element with its index in the original array and current accumulator value.
 * 
 * Throws an exception if this array is empty. If the array can be empty in an expected way,
 * please use [reduceRightIndexedOrNull] instead. It returns `null` when its receiver is empty.
 * 
 * @param [operation] function that takes the index of an element, the element itself and current accumulator value,
 * and calculates the next accumulator value.
 */
inline fun UByteBuffer.reduceRightIndexed(operation: (index: Int, UByte, acc: UByte) -> UByte): UByte {
    var index = lastIndex
    if (index < 0) throw UnsupportedOperationException("Empty array can't be reduced.")
    var accumulator = get(index--)
    while (index >= 0) {
        accumulator = operation(index, get(index), accumulator)
        --index
    }
    return accumulator
}
/**
 * Accumulates value starting with the last element and applying [operation] from right to left
 * to each element with its index in the original array and current accumulator value.
 * 
 * Returns `null` if the array is empty.
 * 
 * @param [operation] function that takes the index of an element, the element itself and current accumulator value,
 * and calculates the next accumulator value.
 */
inline fun UByteBuffer.reduceRightIndexedOrNull(operation: (index: Int, UByte, acc: UByte) -> UByte): UByte? {
    var index = lastIndex
    if (index < 0) return null
    var accumulator = get(index--)
    while (index >= 0) {
        accumulator = operation(index, get(index), accumulator)
        --index
    }
    return accumulator
}
/**
 * Accumulates value starting with the last element and applying [operation] from right to left to each element and current accumulator value.
 * 
 * Returns `null` if the array is empty.
 * 
 * @param [operation] function that takes an element and current accumulator value, and calculates the next accumulator value.
 */
inline fun UByteBuffer.reduceRightOrNull(operation: (UByte, acc: UByte) -> UByte): UByte? {
    var index = lastIndex
    if (index < 0) return null
    var accumulator = get(index--)
    while (index >= 0)
         accumulator = operation(get(index--), accumulator)
    return accumulator
}
/**
 * Splits the original array into pair of lists, where *first* list contains elements for which [predicate] 
 * yielded `true`, while *second* list contains elements for which [predicate] yielded `false`.
 */
inline fun UByteBuffer.partition(predicate: (UByte) -> Boolean): Pair<List<UByte>, List<UByte>> {
    val first = ArrayList<UByte>()
    val second = ArrayList<UByte>()
    for (element in this)
        if (predicate(element))
            first.add(element)
        else
            second.add(element)
    return Pair(first, second)
}
/**
 * Returns a list of pairs built from the elements of `this` array and the [other] array with the same index.
 * The returned list has length of the shortest collection.
 */
infix fun <R> UByteBuffer.zip(other: Array<out R>): List<Pair<UByte, R>> = zip(other) { t1, t2 -> t1 to t2 }
/**
 * Returns a list of values built from the elements of `this` array and the [other] array with the same index
 * using the provided [transform] function applied to each pair of elements.
 * The returned list has length of the shortest collection.
 */
inline fun <R, V> UByteBuffer.zip(other: Array<out R>, transform: (a: UByte, b: R) -> V): List<V> {
    val size = minOf(rem, other.size)
    val list = ArrayList<V>(size)
    for (i in 0 until size)
        list.add(transform(this[i], other[i]))
    return list
}
/**
 * Returns a list of pairs built from the elements of `this` collection and [other] array with the same index.
 * The returned list has length of the shortest collection.
 */
infix fun <R> UByteBuffer.zip(other: Iterable<R>): List<Pair<UByte, R>> = zip(other) { t1, t2 -> t1 to t2 }
/**
 * Returns a list of values built from the elements of `this` array and the [other] collection with the same index
 * using the provided [transform] function applied to each pair of elements.
 * The returned list has length of the shortest collection.
 */
inline fun <R, V> UByteBuffer.zip(other: Iterable<R>, transform: (a: UByte, b: R) -> V): List<V> {
    val arraySize = rem
    val list = ArrayList<V>(minOf(other.collectionSizeOrDefault(10), arraySize))
    var i = 0
    for (element in other) {
        if (i >= arraySize) break
        list.add(transform(this[i++], element))
    }
    return list
}
/**
 * Returns a list of pairs built from the elements of `this` array and the [other] array with the same index.
 * The returned list has length of the shortest collection.
 */
infix fun UByteBuffer.zip(other: UByteArray): List<Pair<UByte, UByte>> = zip(other) { t1, t2 -> t1 to t2 }
/**
 * Returns a list of values built from the elements of `this` array and the [other] array with the same index
 * using the provided [transform] function applied to each pair of elements.
 * The returned list has length of the shortest array.
 */
inline fun <V> UByteBuffer.zip(other: UByteArray, transform: (a: UByte, b: UByte) -> V): List<V> {
    val size = minOf(rem, other.size)
    val list = ArrayList<V>(size)
    for (i in 0 until size)
        list.add(transform(this[i], other[i]))
    return list
}
/**
 * Appends the string from all the elements separated using [separator] and using the given [prefix] and [postfix] if supplied.
 * 
 * If the collection could be huge, you can specify a non-negative value of [limit], in which case only the first [limit]
 * elements will be appended, followed by the [truncated] string (which defaults to "...").
 */
fun <A : Appendable> UByteBuffer.joinTo(buffer: A, separator: CharSequence = ", ", prefix: CharSequence = "", postfix: CharSequence = "", limit: Int = -1, truncated: CharSequence = "...", transform: ((UByte) -> CharSequence)? = null): A {
    buffer.append(prefix)
    var count = 0
    for (element in this) {
        if (++count > 1) buffer.append(separator)
        if (limit < 0 || count <= limit)
            if (transform != null)
                buffer.append(transform(element))
            else
                buffer.append(element.toString())
        else break
    }
    if (limit >= 0 && count > limit) buffer.append(truncated)
    buffer.append(postfix)
    return buffer
}
/**
 * Creates a string from all the elements separated using [separator] and using the given [prefix] and [postfix] if supplied.
 * 
 * If the collection could be huge, you can specify a non-negative value of [limit], in which case only the first [limit]
 * elements will be appended, followed by the [truncated] string (which defaults to "...").
 */
fun UByteBuffer.joinToString(separator: CharSequence = ", ", prefix: CharSequence = "", postfix: CharSequence = "", limit: Int = -1, truncated: CharSequence = "...", transform: ((UByte) -> CharSequence)? = null): String =
    joinTo(StringBuilder(), separator, prefix, postfix, limit, truncated, transform).toString()
/**
 * Returns 1st *element* from the buffer.
 * 
 * If the size of this array is less than 1, throws an [IndexOutOfBoundsException]
 */
inline operator fun UShortBuffer.component1(): UShort = get(0)
/**
 * Returns 2nd *element* from the buffer.
 * 
 * If the size of this array is less than 2, throws an [IndexOutOfBoundsException]
 */
inline operator fun UShortBuffer.component2(): UShort = get(1)
/**
 * Returns 3rd *element* from the buffer.
 * 
 * If the size of this array is less than 3, throws an [IndexOutOfBoundsException]
 */
inline operator fun UShortBuffer.component3(): UShort = get(2)
/**
 * Returns 4th *element* from the buffer.
 * 
 * If the size of this array is less than 4, throws an [IndexOutOfBoundsException]
 */
inline operator fun UShortBuffer.component4(): UShort = get(3)
/**
 * Returns 5th *element* from the buffer.
 * 
 * If the size of this array is less than 5, throws an [IndexOutOfBoundsException]
 */
inline operator fun UShortBuffer.component5(): UShort = get(4)
/** Returns `true` if [element] is found in the array. */
operator fun UShortBuffer.contains(element: UShort): Boolean = indexOf(element) >= 0
/** Returns an element at the given [index] or throws an [IndexOutOfBoundsException] if the [index] is out of bounds of this array. */
inline fun <T> UShortBuffer.elementAt(index: Int): UShort = get(index)
/** Returns an element at the given [index] or the result of calling the [defaultValue] function if the [index] is out of bounds of this array. */
inline fun UShortBuffer.elementAtOrElse(index: Int, defaultValue: (Int) -> UShort): UShort = if (index >= 0 && index <= lastIndex) get(index) else defaultValue(index)
/** Returns an element at the given [index] or `null` if the [index] is out of bounds of this array. */
inline fun UShortBuffer.elementAtOrNull(index: Int): UShort? = this.getOrNull(index)
/** Returns the first element matching the given [predicate], or `null` if no such element was found. */
inline fun UShortBuffer.find(predicate: (UShort) -> Boolean): UShort? = firstOrNull(predicate)
/** Returns the last element matching the given [predicate], or `null` if no such element was found. */
inline fun UShortBuffer.findLast(predicate: (UShort) -> Boolean): UShort? = lastOrNull(predicate)
/**
 * Returns the first element.
 * 
 * @throws NoSuchElementException if the array is empty.
 */
fun UShortBuffer.first(): UShort {
    if (isEmpty())
        throw NoSuchElementException("Array is empty.")
    return this[0]
}
/**
 * Returns the first element matching the given [predicate].
 * @throws [NoSuchElementException] if no such element is found.
 */
inline fun UShortBuffer.first(predicate: (UShort) -> Boolean): UShort {
    for (element in this) if (predicate(element)) return element
    throw NoSuchElementException("Array contains no element matching the predicate.")
}
/** Returns the first element, or `null` if the array is empty. */
fun UShortBuffer.firstOrNull(): UShort? = if (isEmpty()) null else this[0]
/** Returns the first element matching the given [predicate], or `null` if element was not found. */
inline fun UShortBuffer.firstOrNull(predicate: (UShort) -> Boolean): UShort? {
    for (element in this) if (predicate(element)) return element
    return null
}
/** Returns an element at the given [index] or the result of calling the [defaultValue] function if the [index] is out of bounds of this array. */
inline fun UShortBuffer.getOrElse(index: Int, defaultValue: (Int) -> UShort): UShort = if (index >= 0 && index <= lastIndex) get(index) else defaultValue(index)
/** Returns an element at the given [index] or `null` if the [index] is out of bounds of this array. */
fun UShortBuffer.getOrNull(index: Int): UShort? = if (index >= 0 && index <= lastIndex) get(index) else null
/** Returns first index of [element], or -1 if the array does not contain element. */
fun UShortBuffer.indexOf(element: UShort): Int {
    for (index in indices)
        if (element == this[index])
            return index
    return -1
}
/** Returns index of the first element matching the given [predicate], or -1 if the array does not contain such element. */
inline fun UShortBuffer.indexOfFirst(predicate: (UShort) -> Boolean): Int {
    for (index in indices)
        if (predicate(this[index]))
            return index
    return -1
}
/** Returns index of the last element matching the given [predicate], or -1 if the array does not contain such element. */
inline fun UShortBuffer.indexOfLast(predicate: (UShort) -> Boolean): Int {
    for (index in indices.reversed())
        if (predicate(this[index]))
            return index
    return -1
}
/**
 * Returns the last element.
 * 
 * @throws NoSuchElementException if the array is empty.
 */
fun UShortBuffer.last(): UShort {
    if (isEmpty())
        throw NoSuchElementException("Array is empty.")
    return this[lastIndex]
}
/**
 * Returns the last element matching the given [predicate].
 * 
 * @throws NoSuchElementException if no such element is found.
 */
inline fun UShortBuffer.last(predicate: (UShort) -> Boolean): UShort {
    for (index in this.indices.reversed()) {
        val element = this[index]
        if (predicate(element)) return element
    }
    throw NoSuchElementException("Array contains no element matching the predicate.")
}
/** Returns last index of [element], or -1 if the array does not contain element. */
fun UShortBuffer.lastIndexOf(element: UShort): Int {
    for (index in indices.reversed())
        if (element == this[index])
            return index
    return -1
}
/** Returns the last element, or `null` if the array is empty. */
fun UShortBuffer.lastOrNull(): UShort? = if (isEmpty()) null else this[rem - 1]
/** Returns the last element matching the given [predicate], or `null` if no such element was found. */
inline fun UShortBuffer.lastOrNull(predicate: (UShort) -> Boolean): UShort? {
    for (index in this.indices.reversed()) {
        val element = this[index]
        if (predicate(element)) return element
    }
    return null
}
/** Returns the single element, or throws an exception if the array is empty or has more than one element. */
fun UShortBuffer.single(): UShort = when (rem) {
    0 -> throw NoSuchElementException("Array is empty.")
    1 -> this[0]
    else -> throw IllegalArgumentException("Array has more than one element.")
}
/** Returns the single element matching the given [predicate], or throws exception if there is no or more than one matching element. */
inline fun UShortBuffer.single(predicate: (UShort) -> Boolean): UShort {
    var single: UShort? = null
    var found = false
    for (element in this)
        if (predicate(element)) {
            if (found) throw IllegalArgumentException("Array contains more than one matching element.")
            single = element
            found = true
        }
    if (!found) throw NoSuchElementException("Array contains no element matching the predicate.")
    @Suppress("UNCHECKED_CAST")
    return single as UShort
}
/** Returns single element, or `null` if the array is empty or has more than one element. */
fun UShortBuffer.singleOrNull(): UShort? = if (rem == 1) this[0] else null
/** Returns the single element matching the given [predicate], or `null` if element was not found or more than one element was found. */
inline fun UShortBuffer.singleOrNull(predicate: (UShort) -> Boolean): UShort? {
    var single: UShort? = null
    var found = false
    for (element in this)
        if (predicate(element)) {
            if (found) return null
            single = element
            found = true
        }
    if (!found) return null
    return single
}
/** Returns a list containing only elements matching the given [predicate]. */
inline fun UShortBuffer.filter(predicate: (UShort) -> Boolean): List<UShort> = filterTo(ArrayList<UShort>(), predicate)
/**
 * Returns a list containing only elements matching the given [predicate].
 * @param [predicate] function that takes the index of an element and the element itself and returns the result of predicate evaluation on the element.
 */
inline fun UShortBuffer.filterIndexed(predicate: (index: Int, UShort) -> Boolean): List<UShort> = filterIndexedTo(ArrayList<UShort>(), predicate)
/**
 * Appends all elements matching the given [predicate] to the given [destination].
 * @param [predicate] function that takes the index of an element and the element itself and returns the result of predicate evaluation on the element.
 */
inline fun <C : MutableCollection<in UShort>> UShortBuffer.filterIndexedTo(destination: C, predicate: (index: Int, UShort) -> Boolean): C {
    forEachIndexed { index, element ->
        if (predicate(index, element)) destination.add(element)
    }
    return destination
}
/** Returns a list containing all elements not matching the given [predicate]. */
inline fun UShortBuffer.filterNot(predicate: (UShort) -> Boolean): List<UShort> = filterNotTo(ArrayList<UShort>(), predicate)
/** Appends all elements not matching the given [predicate] to the given [destination]. */
inline fun <C : MutableCollection<in UShort>> UShortBuffer.filterNotTo(destination: C, predicate: (UShort) -> Boolean): C {
     for (element in this) if (!predicate(element)) destination.add(element)
     return destination
}
/** Appends all elements matching the given [predicate] to the given [destination]. */
inline fun <C : MutableCollection<in UShort>> UShortBuffer.filterTo(destination: C, predicate: (UShort) -> Boolean): C {
     for (element in this) if (predicate(element)) destination.add(element)
     return destination
}
/** Returns a list containing elements at specified [indices]. */
fun UShortBuffer.slice(indices: Iterable<Int>): List<UShort> {
    val size = indices.collectionSizeOrDefault(10)
    if (size == 0) return emptyList()
    val list = ArrayList<UShort>(size)
    for (index in indices)
        list.add(get(index))
    return list
}
/** Returns an array containing elements of this array at specified [indices]. */
fun UShortBuffer.sliceArray(indices: Collection<Int>): UShortArray {
    val result = UShortArray(indices.size)
    var targetIndex = 0
    for (sourceIndex in indices)
        result[targetIndex++] = this[sourceIndex]
    return result
}
/** Sorts elements in the array in-place descending according to their natural sort order. */
fun UShortBuffer.sortDescending() {
    if (rem > 1) {
        val array = toUShortArray().apply{ sortDescending() }
        for (i in 0 until rem)
            this[pos + i] = array[i]
    }
}
/** Returns a list of all elements sorted according to their natural sort order. */
fun UShortBuffer.sorted(): List<UShort> = toTypedArray().apply { sort() }.asList()
/** Returns an array with all elements of this array sorted according to their natural sort order. */
fun UShortBuffer.sortedArray(): UShortArray = toUShortArray().apply { sort() }
/** Returns an array with all elements of this array sorted descending according to their natural sort order. */
fun UShortBuffer.sortedArrayDescending(): UShortArray = toUShortArray().apply { sortDescending() }
/** Returns a list of all elements sorted according to natural sort order of the value returned by specified [selector] function. */
inline fun <R : Comparable<R>> UShortBuffer.sortedBy(crossinline selector: (UShort) -> R?): List<UShort> = toUShortArray().sortedWith(compareBy(selector))
/** Returns a list of all elements sorted descending according to natural sort order of the value returned by specified [selector] function. */
inline fun <R : Comparable<R>> UShortBuffer.sortedByDescending(crossinline selector: (UShort) -> R?): List<UShort> = toUShortArray().sortedWith(compareByDescending(selector))
/** Returns a list of all elements sorted descending according to their natural sort order. */
fun UShortBuffer.sortedDescending(): List<UShort> = toUShortArray().apply { sort() }.reversed()
/** Returns a list of all elements sorted according to the specified [comparator]. */
fun UShortBuffer.sortedWith(comparator: Comparator<in UShort>): List<UShort> = toTypedArray().apply { sortWith(comparator) }.asList()
/** Sorts the array in-place. */
fun UShortBuffer.sort() {
    if (rem > 1) {
        val array = toUShortArray().apply{ sort() }
        for (i in 0 until rem)
            this[pos + i] = array[i]
    }
}
/** Returns a string representation of the contents of the specified array as if it is [List]. */
fun UShortBuffer.contentToString(): String {
    val iMax = lim - 1
    if (iMax == -1) return "[]"
    val b = StringBuilder()
    b.append('[')
    var i = 0
    while (true) {
        b.append(get(i))
        if (i == iMax) return b.append(']').toString()
        b.append(", ")
        i++
    }
}
/**
 * Fills this array or its subrange with the specified [element] value.
 * 
 * @param fromIndex the start of the range (inclusive) to fill, 0 by default.
 * @param toIndex the end of the range (exclusive) to fill, size of this array by default.
 * 
 * @throws IndexOutOfBoundsException if [fromIndex] is less than zero or [toIndex] is greater than the size of this array.
 * @throws IllegalArgumentException if [fromIndex] is greater than [toIndex].
 */
fun UShortBuffer.fill(element: UShort, fromIndex: Int = pos, toIndex: Int = rem) {
    for (i in fromIndex until toIndex)
        this[i] = element
}
/** Returns the range of valid indices for the array. */
val UShortBuffer.indices: IntRange
    get() = IntRange(0, lastIndex)
/** Returns `true` if the array is empty. */
inline fun UShortBuffer.isEmpty(): Boolean = rem == 0
/** Returns `true` if the array is not empty. */
inline fun UShortBuffer.isNotEmpty(): Boolean = !isEmpty()
/** Returns the last valid index for the array. */
val UShortBuffer.lastIndex: Int
    get() = rem - 1
/** Returns an array of Byte containing all of the elements of this generic array. */
fun UShortBuffer.toUShortArray(): UShortArray = UShortArray(rem) { index -> this[index] }
/** Returns a *typed* object array containing all of the elements of this primitive array. */
fun UShortBuffer.toTypedArray(): Array<UShort> = Array(rem) { index -> this[index] }
/**
 * Returns a [Map] containing key-value pairs provided by [transform] function applied to elements of the given array.
 * 
 * If any of two pairs would have the same key the last one gets added to the map.
 * 
 * The returned map preserves the entry iteration order of the original array.
 */
inline fun <K, V> UShortBuffer.associate(transform: (UShort) -> Pair<K, V>): Map<K, V> {
    val capacity = mapCapacity(rem).coerceAtLeast(16)
    return associateTo(LinkedHashMap<K, V>(capacity), transform)
}
/**
 * Returns a [Map] containing the elements from the given array indexed by the key returned from [keySelector] function applied to each element.
 * 
 * If any two elements would have the same key returned by [keySelector] the last one gets added to the map.
 * 
 * The returned map preserves the entry iteration order of the original array.
 */
inline fun <K> UShortBuffer.associateBy(keySelector: (UShort) -> K): Map<K, UShort> {
    val capacity = mapCapacity(rem).coerceAtLeast(16)
    return associateByTo(LinkedHashMap<K, UShort>(capacity), keySelector)
}
/**
 * Returns a [Map] containing the values provided by [valueTransform] and indexed by [keySelector] functions applied to elements of the given array.
 * 
 * If any two elements would have the same key returned by [keySelector] the last one gets added to the map.
 * 
 * The returned map preserves the entry iteration order of the original array.
 */
inline fun <K, V> UShortBuffer.associateBy(keySelector: (UShort) -> K, valueTransform: (UShort) -> V): Map<K, V> {
    val capacity = mapCapacity(rem).coerceAtLeast(16)
    return associateByTo(LinkedHashMap<K, V>(capacity), keySelector, valueTransform)
}
/**
 * Populates and returns the [destination] mutable map with key-value pairs, where key is provided by
 * the [keySelector] function applied to each element of the given array and value is the element itself.
 * 
 * If any two elements would have the same key returned by [keySelector] the last one gets added to the map.
 */
inline fun <K, M : MutableMap<in K, in UShort>> UShortBuffer.associateByTo(destination: M, keySelector: (UShort) -> K): M {
    for (element in this)
        destination.put(keySelector(element), element)
    return destination
}
/**
 * Populates and returns the [destination] mutable map with key-value pairs, where key is provided by the [keySelector]
 * function and and value is provided by the [valueTransform] function applied to elements of the given array.
 * 
 * If any two elements would have the same key returned by [keySelector] the last one gets added to the map.
 */
inline fun <K, V, M : MutableMap<in K, in V>> UShortBuffer.associateByTo(destination: M, keySelector: (UShort) -> K, valueTransform: (UShort) -> V): M {
    for (element in this)
        destination.put(keySelector(element), valueTransform(element))
    return destination
}
/**
 * Populates and returns the [destination] mutable map with key-value pairs provided by [transform] function
 * applied to each element of the given array.
 * 
 * If any of two pairs would have the same key the last one gets added to the map.
 */
inline fun <K, V, M : MutableMap<in K, in V>> UShortBuffer.associateTo(destination: M, transform: (UShort) -> Pair<K, V>): M {
    for (element in this)
        destination += transform(element)
    return destination
}
/**
 * Returns a [Map] where keys are elements from the given array and values are produced by the [valueSelector] function applied to each element.
 * 
 * If any two elements are equal, the last one gets added to the map.
 * 
 * The returned map preserves the entry iteration order of the original array.
 */
inline fun <V> UShortBuffer.associateWith(valueSelector: (UShort) -> V): Map<UShort, V> {
    val result = LinkedHashMap<UShort, V>(mapCapacity(rem).coerceAtLeast(16))
    return associateWithTo(result, valueSelector)
}
/**
 * Populates and returns the [destination] mutable map with key-value pairs for each element of the given array,
 * where key is the element itself and value is provided by the [valueSelector] function applied to that key.
 * 
 * If any two elements are equal, the last one overwrites the former value in the map.
 */
inline fun <V, M : MutableMap<in UShort, in V>> UShortBuffer.associateWithTo(destination: M, valueSelector: (UShort) -> V): M {
    for (element in this)
        destination.put(element, valueSelector(element))
    return destination
}
/** Appends all elements to the given [destination] collection. */
fun <C : MutableCollection<in UShort>> UShortBuffer.toCollection(destination: C): C {
    for (item in this)
        destination.add(item)
    return destination
}
/** Returns a single list of all elements yielded from results of [transform] function being invoked on each element of original array. */
inline fun <R> UShortBuffer.flatMap(transform: (UShort) -> Iterable<R>): List<R> = flatMapTo(ArrayList<R>(), transform)
/** Appends all elements yielded from results of [transform] function being invoked on each element of original array, to the given [destination]. */
inline fun <R, C : MutableCollection<in R>> UShortBuffer.flatMapTo(destination: C, transform: (UShort) -> Iterable<R>): C {
    for (element in this) {
        val list = transform(element)
        destination.addAll(list)
    }
    return destination
}
/**
 * Groups elements of the original array by the key returned by the given [keySelector] function applied to
 * each element and returns a map where each group key is associated with a list of corresponding elements.
 * 
 * The returned map preserves the entry iteration order of the keys produced from the original array.
 */
inline fun <K> UShortBuffer.groupBy(keySelector: (UShort) -> K): Map<K, List<UShort>> = groupByTo(LinkedHashMap<K, MutableList<UShort>>(), keySelector)
/**
 * Groups values returned by the [valueTransform] function applied to each element of the original array
 * by the key returned by the given [keySelector] function applied to the element
 * and returns a map where each group key is associated with a list of corresponding values.
 * 
 * The returned map preserves the entry iteration order of the keys produced from the original array.
 */
inline fun <K, V> UShortBuffer.groupBy(keySelector: (UShort) -> K, valueTransform: (UShort) -> V): Map<K, List<V>> = groupByTo(LinkedHashMap<K, MutableList<V>>(), keySelector, valueTransform)
/**
 * Groups elements of the original array by the key returned by the given [keySelector] function applied to each
 * element and puts to the [destination] map each group key associated with a list of corresponding elements.
 * 
 * @return The [destination] map.
 */
inline fun <K, M : MutableMap<in K, MutableList<UShort>>> UShortBuffer.groupByTo(destination: M, keySelector: (UShort) -> K): M {
    for (element in this) {
        val key = keySelector(element)
        val list = destination.getOrPut(key) { ArrayList<UShort>() }
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
 */
inline fun <K, V, M : MutableMap<in K, MutableList<V>>> UShortBuffer.groupByTo(destination: M, keySelector: (UShort) -> K, valueTransform: (UShort) -> V): M {
    for (element in this) {
        val key = keySelector(element)
        val list = destination.getOrPut(key) { ArrayList<V>() }
        list.add(valueTransform(element))
    }
    return destination
}
/**
 * Returns a list containing only distinct elements from the given array.
 * 
 * The elements in the resulting list are in the same order as they were in the source array.
 */
fun UShortBuffer.distinct(): List<UShort> = this.toMutableSet().toList()
/**
 * Returns a list containing only elements from the given array having distinct keys returned by the given [selector] function.
 * 
 * The elements in the resulting list are in the same order as they were in the source array.
 */
inline fun <K> UShortBuffer.distinctBy(selector: (UShort) -> K): List<UShort> {
    val set = HashSet<K>()
    val list = ArrayList<UShort>()
    for (e in this) {
        val key = selector(e)
        if (set.add(key))
            list.add(e)
    }
    return list
}
/**
 * Returns a new [MutableSet] containing all distinct elements from the given array.
 * 
 * The returned set preserves the element iteration order of the original array.
 */
fun UShortBuffer.toMutableSet(): MutableSet<UShort> = toCollection(LinkedHashSet<UShort>(mapCapacity(rem)))
/** Returns a list containing the results of applying the given [transform] function to each element in the original array. */
inline fun <R> UShortBuffer.map(transform: (UShort) -> R): List<R> = mapTo(ArrayList<R>(rem), transform)
/**
 * Returns a list containing the results of applying the given [transform] function to each element and its index in the original array.
 * @param [transform] function that takes the index of an element and the element itself and returns the result of the transform applied to the element.
 */
inline fun <R> UShortBuffer.mapIndexed(transform: (index: Int, UShort) -> R): List<R> = mapIndexedTo(ArrayList<R>(rem), transform)
/**
 * Applies the given [transform] function to each element and its index in the original array and appends the results to the given [destination].
 * @param [transform] function that takes the index of an element and the element itself and returns the result of the transform applied to the element.
 */
inline fun <R, C : MutableCollection<in R>> UShortBuffer.mapIndexedTo(destination: C, transform: (index: Int, UShort) -> R): C {
    var index = 0
    for (item in this)
        destination.add(transform(index++, item))
    return destination
}
/** Applies the given [transform] function to each element of the original array and appends the results to the given [destination]. */
inline fun <R, C : MutableCollection<in R>> UShortBuffer.mapTo(destination: C, transform: (UShort) -> R): C {
    for (item in this)
        destination.add(transform(item))
    return destination
}
/** Returns `true` if all elements match the given [predicate]. */
inline fun UShortBuffer.all(predicate: (UShort) -> Boolean): Boolean {
    for (element in this) if (!predicate(element)) return false
    return true
}
/** Returns `true` if array has at least one element. */
fun UShortBuffer.any(): Boolean = !isEmpty()
/** Returns `true` if at least one element matches the given [predicate]. */
inline fun UShortBuffer.any(predicate: (UShort) -> Boolean): Boolean {
    for (element in this) if (predicate(element)) return true
    return false
}
/** Returns the number of elements in this array. */
inline fun UShortBuffer.count(): Int = rem
/** Returns the number of elements matching the given [predicate]. */
inline fun UShortBuffer.count(predicate: (UShort) -> Boolean): Int {
    var count = 0
    for (element in this) if (predicate(element)) ++count
    return count
}
/** Performs the given [action] on each element. */
inline fun UShortBuffer.forEach(action: (UShort) -> Unit) { for (element in this) action(element) }
/**
 * Performs the given [action] on each element, providing sequential index with the element.
 * @param [action] function that takes the index of an element and the element itself and performs the action on the element.
 */
inline fun UShortBuffer.forEachIndexed(action: (index: Int, UShort) -> Unit): Unit {
    var index = 0
    for (item in this) action(index++, item)
}
/**
 * Returns the largest element.
 * 
 * @throws NoSuchElementException if the array is empty.
 */
fun UShortBuffer.max(): UShort {
    if (isEmpty()) throw NoSuchElementException()
    var max = this[0]
    for (i in 1..lastIndex) {
        val e = this[i]
        if (max < e) max = e
    }
    return max
}
/**
 * Returns the first element yielding the largest value of the given function.
 * 
 * @throws NoSuchElementException if the array is empty.
 */
inline fun <R : Comparable<R>> UShortBuffer.maxBy(selector: (UShort) -> R): UShort {
    if (isEmpty()) throw NoSuchElementException()
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
/** Returns the first element yielding the largest value of the given function or `null` if there are no elements. */
inline fun <R : Comparable<R>> UShortBuffer.maxByOrNull(selector: (UShort) -> R): UShort? {
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
/** Returns the largest element or `null` if there are no elements. */
fun UShortBuffer.maxOrNull(): UShort? {
    if (isEmpty()) return null
    var max = this[0]
    for (i in 1..lastIndex) {
        val e = this[i]
        if (max < e) max = e
    }
    return max
}
/**
 * Returns the first element having the largest value according to the provided [comparator].
 * 
 * @throws NoSuchElementException if the array is empty.
 */
fun UShortBuffer.maxWith(comparator: Comparator<in UShort>): UShort {
    if (isEmpty()) throw NoSuchElementException()
    var max = this[0]
    for (i in 1..lastIndex) {
        val e = this[i]
        if (comparator.compare(max, e) < 0) max = e
    }
    return max
}
/** Returns the first element having the largest value according to the provided [comparator] or `null` if there are no elements. */
fun UShortBuffer.maxWithOrNull(comparator: Comparator<in UShort>): UShort? {
    if (isEmpty()) return null
    var max = this[0]
    for (i in 1..lastIndex) {
        val e = this[i]
        if (comparator.compare(max, e) < 0) max = e
    }
    return max
}
/**
 * Returns the smallest element.
 * 
 * @throws NoSuchElementException if the array is empty.
 */
fun UShortBuffer.min(): UShort {
    if (isEmpty()) throw NoSuchElementException()
    var min = this[0]
    for (i in 1..lastIndex) {
        val e = this[i]
        if (min > e) min = e
    }
    return min
}
/**
 * Returns the first element yielding the smallest value of the given function.
 * 
 * @throws NoSuchElementException if the array is empty.
 */
inline fun <R : Comparable<R>> UShortBuffer.minBy(selector: (UShort) -> R): UShort {
    if (isEmpty()) throw NoSuchElementException()
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
 * Returns the first element yielding the smallest value of the given function or `null` if there are no elements.
 * 
 * @sample samples.collections.Collections.Aggregates.minByOrNull
 */
inline fun <R : Comparable<R>> UShortBuffer.minByOrNull(selector: (UShort) -> R): UShort? {
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
 * Returns the smallest value among all values produced by [selector] function applied to each element in the array.
 * 
 * If any of values produced by [selector] function is `NaN`, the returned result is `NaN`.
 * 
 * @throws NoSuchElementException if the array is empty.
 */
inline fun UShortBuffer.minOf(selector: (UShort) -> Double): Double {
    if (isEmpty()) throw NoSuchElementException()
    var minValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        minValue = minOf(minValue, v)
    }
    return minValue
}
/**
 * Returns the smallest value among all values produced by [selector] function applied to each element in the array.
 * 
 * If any of values produced by [selector] function is `NaN`, the returned result is `NaN`.
 * 
 * @throws NoSuchElementException if the array is empty.
 */
inline fun UShortBuffer.minOf(selector: (UShort) -> Float): Float {
    if (isEmpty()) throw NoSuchElementException()
    var minValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        minValue = minOf(minValue, v)
    }
    return minValue
}
/**
 * Returns the smallest value among all values produced by [selector] function applied to each element in the array.
 * 
 * @throws NoSuchElementException if the array is empty.
 */
inline fun <R : Comparable<R>> UShortBuffer.minOf(selector: (UShort) -> R): R {
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
 * Returns the smallest value among all values produced by [selector] function applied to each element in the array or `null` if there are no elements.
 * 
 * If any of values produced by [selector] function is `NaN`, the returned result is `NaN`.
 */
inline fun UShortBuffer.minOfOrNull(selector: (UShort) -> Double): Double? {
    if (isEmpty()) return null
    var minValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        minValue = minOf(minValue, v)
    }
    return minValue
}
/**
 * Returns the smallest value among all values produced by [selector] function applied to each element in the array or `null` if there are no elements.
 * 
 * If any of values produced by [selector] function is `NaN`, the returned result is `NaN`.
 */
inline fun UShortBuffer.minOfOrNull(selector: (UShort) -> Float): Float? {
    if (isEmpty()) return null
    var minValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        minValue = minOf(minValue, v)
    }
    return minValue
}
/** Returns the smallest value among all values produced by [selector] function applied to each element in the array or `null` if there are no elements. */
inline fun <R : Comparable<R>> UShortBuffer.minOfOrNull(selector: (UShort) -> R): R? {
    if (isEmpty()) return null
    var minValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        if (minValue > v)
            minValue = v
    }
    return minValue
}
/**
 * Returns the smallest value according to the provided [comparator] among all values produced by [selector] function applied to each element in the array.
 * 
 * @throws NoSuchElementException if the array is empty.
 */
inline fun <R> UShortBuffer.minOfWith(comparator: Comparator<in R>, selector: (UShort) -> R): R {
    if (isEmpty()) throw NoSuchElementException()
    var minValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        if (comparator.compare(minValue, v) > 0)
            minValue = v
    }
    return minValue
}
/**
 * Returns the smallest value according to the provided [comparator] among all values produced by [selector]
 * function applied to each element in the array or `null` if there are no elements.
 */
inline fun <R> UShortBuffer.minOfWithOrNull(comparator: Comparator<in R>, selector: (UShort) -> R): R? {
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
fun UShortBuffer.minOrNull(): UShort? {
     if (isEmpty()) return null
     var min = this[0]
     for (i in 1..lastIndex) {
         val e = this[i]
         if (min > e) min = e
     }
     return min
 }
/**
 * Returns the first element having the smallest value according to the provided [comparator].
 * 
 * @throws NoSuchElementException if the array is empty.
 */
fun UShortBuffer.minWith(comparator: Comparator<in UShort>): UShort {
    if (isEmpty()) throw NoSuchElementException()
    var min = this[0]
    for (i in 1..lastIndex) {
        val e = this[i]
        if (comparator.compare(min, e) > 0) min = e
    }
    return min
}
/** Returns the first element having the smallest value according to the provided [comparator] or `null` if there are no elements. */
fun UShortBuffer.minWithOrNull(comparator: Comparator<in UShort>): UShort? {
    if (isEmpty()) return null
    var min = this[0]
    for (i in 1..lastIndex) {
        val e = this[i]
        if (comparator.compare(min, e) > 0) min = e
    }
    return min
}
/** Returns `true` if the array has no elements. */
fun UShortBuffer.none(): Boolean = isEmpty()
/** Returns `true` if no elements match the given [predicate]. */
inline fun UShortBuffer.none(predicate: (UShort) -> Boolean): Boolean {
    for (element in this) if (predicate(element)) return false
    return true
}
/** Performs the given [action] on each element and returns the array itself afterwards. */
inline fun UShortBuffer.onEach(action: (UShort) -> Unit): UShortBuffer = apply { for (element in this) action(element) }
/**
 * Performs the given [action] on each element, providing sequential index with the element, and returns the array itself afterwards.
 * @param [action] function that takes the index of an element and the element itself and performs the action on the element.
 */
inline fun UShortBuffer.onEachIndexed(action: (index: Int, UShort) -> Unit): UShortBuffer = apply { forEachIndexed(action) }
/**
 * Accumulates value starting with the first element and applying [operation] from left to right to current accumulator value and each element.
 * 
 * Throws an exception if this array is empty. If the array can be empty in an expected way,
 * please use [reduceOrNull] instead. It returns `null` when its receiver is empty.
 * 
 * @param [operation] function that takes current accumulator value and an element, and calculates the next accumulator value.
 */
inline fun UShortBuffer.reduce(operation: (acc: UShort, UShort) -> UShort): UShort {
    if (isEmpty())
        throw UnsupportedOperationException("Empty array can't be reduced.")
    var accumulator = this[0]
    for (index in 1..lastIndex)
        accumulator = operation(accumulator, this[index])
    return accumulator
}
/**
 * Accumulates value starting with the first element and applying [operation] from left to right
 * to current accumulator value and each element with its index in the original array.
 * 
 * Throws an exception if this array is empty. If the array can be empty in an expected way,
 * please use [reduceIndexedOrNull] instead. It returns `null` when its receiver is empty.
 * 
 * @param [operation] function that takes the index of an element, current accumulator value and the element itself,
 * and calculates the next accumulator value.
 */
inline fun UShortBuffer.reduceIndexed(operation: (index: Int, acc: UShort, UShort) -> UShort): UShort {
    if (isEmpty())
        throw UnsupportedOperationException("Empty array can't be reduced.")
    var accumulator = this[0]
    for (index in 1..lastIndex)
        accumulator = operation(index, accumulator, this[index])
    return accumulator
}
/**
 * Accumulates value starting with the first element and applying [operation] from left to right
 * to current accumulator value and each element with its index in the original array.
 * 
 * Returns `null` if the array is empty.
 * 
 * @param [operation] function that takes the index of an element, current accumulator value and the element itself,
 * and calculates the next accumulator value.
 */
inline fun UShortBuffer.reduceIndexedOrNull(operation: (index: Int, acc: UShort, UShort) -> UShort): UShort? {
    if (isEmpty())
        return null
    var accumulator = this[0]
    for (index in 1..lastIndex)
        accumulator = operation(index, accumulator, this[index])
    return accumulator
}
/**
 * Accumulates value starting with the first element and applying [operation] from left to right to current accumulator value and each element.
 * 
 * Returns `null` if the array is empty.
 * 
 * @param [operation] function that takes current accumulator value and an element, and calculates the next accumulator value.
 */
inline fun UShortBuffer.reduceOrNull(operation: (acc: UShort, UShort) -> UShort): UShort? {
    if (isEmpty())
        return null
    var accumulator = this[0]
    for (index in 1..lastIndex)
        accumulator = operation(accumulator, this[index])
     return accumulator
}
/**
 * Accumulates value starting with the last element and applying [operation] from right to left to each element and current accumulator value.
 * 
 * Throws an exception if this array is empty. If the array can be empty in an expected way,
 * please use [reduceRightOrNull] instead. It returns `null` when its receiver is empty.
 * 
 * @param [operation] function that takes an element and current accumulator value, and calculates the next accumulator value.
 */
inline fun UShortBuffer.reduceRight(operation: (UShort, acc: UShort) -> UShort): UShort {
    var index = lastIndex
    if (index < 0) throw UnsupportedOperationException("Empty array can't be reduced.")
    var accumulator = get(index--)
    while (index >= 0)
        accumulator = operation(get(index--), accumulator)
    return accumulator
}
/**
 * Accumulates value starting with the last element and applying [operation] from right to left
 * to each element with its index in the original array and current accumulator value.
 * 
 * Throws an exception if this array is empty. If the array can be empty in an expected way,
 * please use [reduceRightIndexedOrNull] instead. It returns `null` when its receiver is empty.
 * 
 * @param [operation] function that takes the index of an element, the element itself and current accumulator value,
 * and calculates the next accumulator value.
 */
inline fun UShortBuffer.reduceRightIndexed(operation: (index: Int, UShort, acc: UShort) -> UShort): UShort {
    var index = lastIndex
    if (index < 0) throw UnsupportedOperationException("Empty array can't be reduced.")
    var accumulator = get(index--)
    while (index >= 0) {
        accumulator = operation(index, get(index), accumulator)
        --index
    }
    return accumulator
}
/**
 * Accumulates value starting with the last element and applying [operation] from right to left
 * to each element with its index in the original array and current accumulator value.
 * 
 * Returns `null` if the array is empty.
 * 
 * @param [operation] function that takes the index of an element, the element itself and current accumulator value,
 * and calculates the next accumulator value.
 */
inline fun UShortBuffer.reduceRightIndexedOrNull(operation: (index: Int, UShort, acc: UShort) -> UShort): UShort? {
    var index = lastIndex
    if (index < 0) return null
    var accumulator = get(index--)
    while (index >= 0) {
        accumulator = operation(index, get(index), accumulator)
        --index
    }
    return accumulator
}
/**
 * Accumulates value starting with the last element and applying [operation] from right to left to each element and current accumulator value.
 * 
 * Returns `null` if the array is empty.
 * 
 * @param [operation] function that takes an element and current accumulator value, and calculates the next accumulator value.
 */
inline fun UShortBuffer.reduceRightOrNull(operation: (UShort, acc: UShort) -> UShort): UShort? {
    var index = lastIndex
    if (index < 0) return null
    var accumulator = get(index--)
    while (index >= 0)
         accumulator = operation(get(index--), accumulator)
    return accumulator
}
/**
 * Splits the original array into pair of lists, where *first* list contains elements for which [predicate] 
 * yielded `true`, while *second* list contains elements for which [predicate] yielded `false`.
 */
inline fun UShortBuffer.partition(predicate: (UShort) -> Boolean): Pair<List<UShort>, List<UShort>> {
    val first = ArrayList<UShort>()
    val second = ArrayList<UShort>()
    for (element in this)
        if (predicate(element))
            first.add(element)
        else
            second.add(element)
    return Pair(first, second)
}
/**
 * Returns a list of pairs built from the elements of `this` array and the [other] array with the same index.
 * The returned list has length of the shortest collection.
 */
infix fun <R> UShortBuffer.zip(other: Array<out R>): List<Pair<UShort, R>> = zip(other) { t1, t2 -> t1 to t2 }
/**
 * Returns a list of values built from the elements of `this` array and the [other] array with the same index
 * using the provided [transform] function applied to each pair of elements.
 * The returned list has length of the shortest collection.
 */
inline fun <R, V> UShortBuffer.zip(other: Array<out R>, transform: (a: UShort, b: R) -> V): List<V> {
    val size = minOf(rem, other.size)
    val list = ArrayList<V>(size)
    for (i in 0 until size)
        list.add(transform(this[i], other[i]))
    return list
}
/**
 * Returns a list of pairs built from the elements of `this` collection and [other] array with the same index.
 * The returned list has length of the shortest collection.
 */
infix fun <R> UShortBuffer.zip(other: Iterable<R>): List<Pair<UShort, R>> = zip(other) { t1, t2 -> t1 to t2 }
/**
 * Returns a list of values built from the elements of `this` array and the [other] collection with the same index
 * using the provided [transform] function applied to each pair of elements.
 * The returned list has length of the shortest collection.
 */
inline fun <R, V> UShortBuffer.zip(other: Iterable<R>, transform: (a: UShort, b: R) -> V): List<V> {
    val arraySize = rem
    val list = ArrayList<V>(minOf(other.collectionSizeOrDefault(10), arraySize))
    var i = 0
    for (element in other) {
        if (i >= arraySize) break
        list.add(transform(this[i++], element))
    }
    return list
}
/**
 * Returns a list of pairs built from the elements of `this` array and the [other] array with the same index.
 * The returned list has length of the shortest collection.
 */
infix fun UShortBuffer.zip(other: UShortArray): List<Pair<UShort, UShort>> = zip(other) { t1, t2 -> t1 to t2 }
/**
 * Returns a list of values built from the elements of `this` array and the [other] array with the same index
 * using the provided [transform] function applied to each pair of elements.
 * The returned list has length of the shortest array.
 */
inline fun <V> UShortBuffer.zip(other: UShortArray, transform: (a: UShort, b: UShort) -> V): List<V> {
    val size = minOf(rem, other.size)
    val list = ArrayList<V>(size)
    for (i in 0 until size)
        list.add(transform(this[i], other[i]))
    return list
}
/**
 * Appends the string from all the elements separated using [separator] and using the given [prefix] and [postfix] if supplied.
 * 
 * If the collection could be huge, you can specify a non-negative value of [limit], in which case only the first [limit]
 * elements will be appended, followed by the [truncated] string (which defaults to "...").
 */
fun <A : Appendable> UShortBuffer.joinTo(buffer: A, separator: CharSequence = ", ", prefix: CharSequence = "", postfix: CharSequence = "", limit: Int = -1, truncated: CharSequence = "...", transform: ((UShort) -> CharSequence)? = null): A {
    buffer.append(prefix)
    var count = 0
    for (element in this) {
        if (++count > 1) buffer.append(separator)
        if (limit < 0 || count <= limit)
            if (transform != null)
                buffer.append(transform(element))
            else
                buffer.append(element.toString())
        else break
    }
    if (limit >= 0 && count > limit) buffer.append(truncated)
    buffer.append(postfix)
    return buffer
}
/**
 * Creates a string from all the elements separated using [separator] and using the given [prefix] and [postfix] if supplied.
 * 
 * If the collection could be huge, you can specify a non-negative value of [limit], in which case only the first [limit]
 * elements will be appended, followed by the [truncated] string (which defaults to "...").
 */
fun UShortBuffer.joinToString(separator: CharSequence = ", ", prefix: CharSequence = "", postfix: CharSequence = "", limit: Int = -1, truncated: CharSequence = "...", transform: ((UShort) -> CharSequence)? = null): String =
    joinTo(StringBuilder(), separator, prefix, postfix, limit, truncated, transform).toString()
/**
 * Returns 1st *element* from the buffer.
 * 
 * If the size of this array is less than 1, throws an [IndexOutOfBoundsException]
 */
inline operator fun UIntBuffer.component1(): UInt = get(0)
/**
 * Returns 2nd *element* from the buffer.
 * 
 * If the size of this array is less than 2, throws an [IndexOutOfBoundsException]
 */
inline operator fun UIntBuffer.component2(): UInt = get(1)
/**
 * Returns 3rd *element* from the buffer.
 * 
 * If the size of this array is less than 3, throws an [IndexOutOfBoundsException]
 */
inline operator fun UIntBuffer.component3(): UInt = get(2)
/**
 * Returns 4th *element* from the buffer.
 * 
 * If the size of this array is less than 4, throws an [IndexOutOfBoundsException]
 */
inline operator fun UIntBuffer.component4(): UInt = get(3)
/**
 * Returns 5th *element* from the buffer.
 * 
 * If the size of this array is less than 5, throws an [IndexOutOfBoundsException]
 */
inline operator fun UIntBuffer.component5(): UInt = get(4)
/** Returns `true` if [element] is found in the array. */
operator fun UIntBuffer.contains(element: UInt): Boolean = indexOf(element) >= 0
/** Returns an element at the given [index] or throws an [IndexOutOfBoundsException] if the [index] is out of bounds of this array. */
inline fun <T> UIntBuffer.elementAt(index: Int): UInt = get(index)
/** Returns an element at the given [index] or the result of calling the [defaultValue] function if the [index] is out of bounds of this array. */
inline fun UIntBuffer.elementAtOrElse(index: Int, defaultValue: (Int) -> UInt): UInt = if (index >= 0 && index <= lastIndex) get(index) else defaultValue(index)
/** Returns an element at the given [index] or `null` if the [index] is out of bounds of this array. */
inline fun UIntBuffer.elementAtOrNull(index: Int): UInt? = this.getOrNull(index)
/** Returns the first element matching the given [predicate], or `null` if no such element was found. */
inline fun UIntBuffer.find(predicate: (UInt) -> Boolean): UInt? = firstOrNull(predicate)
/** Returns the last element matching the given [predicate], or `null` if no such element was found. */
inline fun UIntBuffer.findLast(predicate: (UInt) -> Boolean): UInt? = lastOrNull(predicate)
/**
 * Returns the first element.
 * 
 * @throws NoSuchElementException if the array is empty.
 */
fun UIntBuffer.first(): UInt {
    if (isEmpty())
        throw NoSuchElementException("Array is empty.")
    return this[0]
}
/**
 * Returns the first element matching the given [predicate].
 * @throws [NoSuchElementException] if no such element is found.
 */
inline fun UIntBuffer.first(predicate: (UInt) -> Boolean): UInt {
    for (element in this) if (predicate(element)) return element
    throw NoSuchElementException("Array contains no element matching the predicate.")
}
/** Returns the first element, or `null` if the array is empty. */
fun UIntBuffer.firstOrNull(): UInt? = if (isEmpty()) null else this[0]
/** Returns the first element matching the given [predicate], or `null` if element was not found. */
inline fun UIntBuffer.firstOrNull(predicate: (UInt) -> Boolean): UInt? {
    for (element in this) if (predicate(element)) return element
    return null
}
/** Returns an element at the given [index] or the result of calling the [defaultValue] function if the [index] is out of bounds of this array. */
inline fun UIntBuffer.getOrElse(index: Int, defaultValue: (Int) -> UInt): UInt = if (index >= 0 && index <= lastIndex) get(index) else defaultValue(index)
/** Returns an element at the given [index] or `null` if the [index] is out of bounds of this array. */
fun UIntBuffer.getOrNull(index: Int): UInt? = if (index >= 0 && index <= lastIndex) get(index) else null
/** Returns first index of [element], or -1 if the array does not contain element. */
fun UIntBuffer.indexOf(element: UInt): Int {
    for (index in indices)
        if (element == this[index])
            return index
    return -1
}
/** Returns index of the first element matching the given [predicate], or -1 if the array does not contain such element. */
inline fun UIntBuffer.indexOfFirst(predicate: (UInt) -> Boolean): Int {
    for (index in indices)
        if (predicate(this[index]))
            return index
    return -1
}
/** Returns index of the last element matching the given [predicate], or -1 if the array does not contain such element. */
inline fun UIntBuffer.indexOfLast(predicate: (UInt) -> Boolean): Int {
    for (index in indices.reversed())
        if (predicate(this[index]))
            return index
    return -1
}
/**
 * Returns the last element.
 * 
 * @throws NoSuchElementException if the array is empty.
 */
fun UIntBuffer.last(): UInt {
    if (isEmpty())
        throw NoSuchElementException("Array is empty.")
    return this[lastIndex]
}
/**
 * Returns the last element matching the given [predicate].
 * 
 * @throws NoSuchElementException if no such element is found.
 */
inline fun UIntBuffer.last(predicate: (UInt) -> Boolean): UInt {
    for (index in this.indices.reversed()) {
        val element = this[index]
        if (predicate(element)) return element
    }
    throw NoSuchElementException("Array contains no element matching the predicate.")
}
/** Returns last index of [element], or -1 if the array does not contain element. */
fun UIntBuffer.lastIndexOf(element: UInt): Int {
    for (index in indices.reversed())
        if (element == this[index])
            return index
    return -1
}
/** Returns the last element, or `null` if the array is empty. */
fun UIntBuffer.lastOrNull(): UInt? = if (isEmpty()) null else this[rem - 1]
/** Returns the last element matching the given [predicate], or `null` if no such element was found. */
inline fun UIntBuffer.lastOrNull(predicate: (UInt) -> Boolean): UInt? {
    for (index in this.indices.reversed()) {
        val element = this[index]
        if (predicate(element)) return element
    }
    return null
}
/** Returns the single element, or throws an exception if the array is empty or has more than one element. */
fun UIntBuffer.single(): UInt = when (rem) {
    0 -> throw NoSuchElementException("Array is empty.")
    1 -> this[0]
    else -> throw IllegalArgumentException("Array has more than one element.")
}
/** Returns the single element matching the given [predicate], or throws exception if there is no or more than one matching element. */
inline fun UIntBuffer.single(predicate: (UInt) -> Boolean): UInt {
    var single: UInt? = null
    var found = false
    for (element in this)
        if (predicate(element)) {
            if (found) throw IllegalArgumentException("Array contains more than one matching element.")
            single = element
            found = true
        }
    if (!found) throw NoSuchElementException("Array contains no element matching the predicate.")
    @Suppress("UNCHECKED_CAST")
    return single as UInt
}
/** Returns single element, or `null` if the array is empty or has more than one element. */
fun UIntBuffer.singleOrNull(): UInt? = if (rem == 1) this[0] else null
/** Returns the single element matching the given [predicate], or `null` if element was not found or more than one element was found. */
inline fun UIntBuffer.singleOrNull(predicate: (UInt) -> Boolean): UInt? {
    var single: UInt? = null
    var found = false
    for (element in this)
        if (predicate(element)) {
            if (found) return null
            single = element
            found = true
        }
    if (!found) return null
    return single
}
/** Returns a list containing only elements matching the given [predicate]. */
inline fun UIntBuffer.filter(predicate: (UInt) -> Boolean): List<UInt> = filterTo(ArrayList<UInt>(), predicate)
/**
 * Returns a list containing only elements matching the given [predicate].
 * @param [predicate] function that takes the index of an element and the element itself and returns the result of predicate evaluation on the element.
 */
inline fun UIntBuffer.filterIndexed(predicate: (index: Int, UInt) -> Boolean): List<UInt> = filterIndexedTo(ArrayList<UInt>(), predicate)
/**
 * Appends all elements matching the given [predicate] to the given [destination].
 * @param [predicate] function that takes the index of an element and the element itself and returns the result of predicate evaluation on the element.
 */
inline fun <C : MutableCollection<in UInt>> UIntBuffer.filterIndexedTo(destination: C, predicate: (index: Int, UInt) -> Boolean): C {
    forEachIndexed { index, element ->
        if (predicate(index, element)) destination.add(element)
    }
    return destination
}
/** Returns a list containing all elements not matching the given [predicate]. */
inline fun UIntBuffer.filterNot(predicate: (UInt) -> Boolean): List<UInt> = filterNotTo(ArrayList<UInt>(), predicate)
/** Appends all elements not matching the given [predicate] to the given [destination]. */
inline fun <C : MutableCollection<in UInt>> UIntBuffer.filterNotTo(destination: C, predicate: (UInt) -> Boolean): C {
     for (element in this) if (!predicate(element)) destination.add(element)
     return destination
}
/** Appends all elements matching the given [predicate] to the given [destination]. */
inline fun <C : MutableCollection<in UInt>> UIntBuffer.filterTo(destination: C, predicate: (UInt) -> Boolean): C {
     for (element in this) if (predicate(element)) destination.add(element)
     return destination
}
/** Returns a list containing elements at specified [indices]. */
fun UIntBuffer.slice(indices: Iterable<Int>): List<UInt> {
    val size = indices.collectionSizeOrDefault(10)
    if (size == 0) return emptyList()
    val list = ArrayList<UInt>(size)
    for (index in indices)
        list.add(get(index))
    return list
}
/** Returns an array containing elements of this array at specified [indices]. */
fun UIntBuffer.sliceArray(indices: Collection<Int>): UIntArray {
    val result = UIntArray(indices.size)
    var targetIndex = 0
    for (sourceIndex in indices)
        result[targetIndex++] = this[sourceIndex]
    return result
}
/** Sorts elements in the array in-place descending according to their natural sort order. */
fun UIntBuffer.sortDescending() {
    if (rem > 1) {
        val array = toUIntArray().apply{ sortDescending() }
        for (i in 0 until rem)
            this[pos + i] = array[i]
    }
}
/** Returns a list of all elements sorted according to their natural sort order. */
fun UIntBuffer.sorted(): List<UInt> = toTypedArray().apply { sort() }.asList()
/** Returns an array with all elements of this array sorted according to their natural sort order. */
fun UIntBuffer.sortedArray(): UIntArray = toUIntArray().apply { sort() }
/** Returns an array with all elements of this array sorted descending according to their natural sort order. */
fun UIntBuffer.sortedArrayDescending(): UIntArray = toUIntArray().apply { sortDescending() }
/** Returns a list of all elements sorted according to natural sort order of the value returned by specified [selector] function. */
inline fun <R : Comparable<R>> UIntBuffer.sortedBy(crossinline selector: (UInt) -> R?): List<UInt> = toUIntArray().sortedWith(compareBy(selector))
/** Returns a list of all elements sorted descending according to natural sort order of the value returned by specified [selector] function. */
inline fun <R : Comparable<R>> UIntBuffer.sortedByDescending(crossinline selector: (UInt) -> R?): List<UInt> = toUIntArray().sortedWith(compareByDescending(selector))
/** Returns a list of all elements sorted descending according to their natural sort order. */
fun UIntBuffer.sortedDescending(): List<UInt> = toUIntArray().apply { sort() }.reversed()
/** Returns a list of all elements sorted according to the specified [comparator]. */
fun UIntBuffer.sortedWith(comparator: Comparator<in UInt>): List<UInt> = toTypedArray().apply { sortWith(comparator) }.asList()
/** Sorts the array in-place. */
fun UIntBuffer.sort() {
    if (rem > 1) {
        val array = toUIntArray().apply{ sort() }
        for (i in 0 until rem)
            this[pos + i] = array[i]
    }
}
/** Returns a string representation of the contents of the specified array as if it is [List]. */
fun UIntBuffer.contentToString(): String {
    val iMax = lim - 1
    if (iMax == -1) return "[]"
    val b = StringBuilder()
    b.append('[')
    var i = 0
    while (true) {
        b.append(get(i))
        if (i == iMax) return b.append(']').toString()
        b.append(", ")
        i++
    }
}
/**
 * Fills this array or its subrange with the specified [element] value.
 * 
 * @param fromIndex the start of the range (inclusive) to fill, 0 by default.
 * @param toIndex the end of the range (exclusive) to fill, size of this array by default.
 * 
 * @throws IndexOutOfBoundsException if [fromIndex] is less than zero or [toIndex] is greater than the size of this array.
 * @throws IllegalArgumentException if [fromIndex] is greater than [toIndex].
 */
fun UIntBuffer.fill(element: UInt, fromIndex: Int = pos, toIndex: Int = rem) {
    for (i in fromIndex until toIndex)
        this[i] = element
}
/** Returns the range of valid indices for the array. */
val UIntBuffer.indices: IntRange
    get() = IntRange(0, lastIndex)
/** Returns `true` if the array is empty. */
inline fun UIntBuffer.isEmpty(): Boolean = rem == 0
/** Returns `true` if the array is not empty. */
inline fun UIntBuffer.isNotEmpty(): Boolean = !isEmpty()
/** Returns the last valid index for the array. */
val UIntBuffer.lastIndex: Int
    get() = rem - 1
/** Returns an array of Byte containing all of the elements of this generic array. */
fun UIntBuffer.toUIntArray(): UIntArray = UIntArray(rem) { index -> this[index] }
/** Returns a *typed* object array containing all of the elements of this primitive array. */
fun UIntBuffer.toTypedArray(): Array<UInt> = Array(rem) { index -> this[index] }
/**
 * Returns a [Map] containing key-value pairs provided by [transform] function applied to elements of the given array.
 * 
 * If any of two pairs would have the same key the last one gets added to the map.
 * 
 * The returned map preserves the entry iteration order of the original array.
 */
inline fun <K, V> UIntBuffer.associate(transform: (UInt) -> Pair<K, V>): Map<K, V> {
    val capacity = mapCapacity(rem).coerceAtLeast(16)
    return associateTo(LinkedHashMap<K, V>(capacity), transform)
}
/**
 * Returns a [Map] containing the elements from the given array indexed by the key returned from [keySelector] function applied to each element.
 * 
 * If any two elements would have the same key returned by [keySelector] the last one gets added to the map.
 * 
 * The returned map preserves the entry iteration order of the original array.
 */
inline fun <K> UIntBuffer.associateBy(keySelector: (UInt) -> K): Map<K, UInt> {
    val capacity = mapCapacity(rem).coerceAtLeast(16)
    return associateByTo(LinkedHashMap<K, UInt>(capacity), keySelector)
}
/**
 * Returns a [Map] containing the values provided by [valueTransform] and indexed by [keySelector] functions applied to elements of the given array.
 * 
 * If any two elements would have the same key returned by [keySelector] the last one gets added to the map.
 * 
 * The returned map preserves the entry iteration order of the original array.
 */
inline fun <K, V> UIntBuffer.associateBy(keySelector: (UInt) -> K, valueTransform: (UInt) -> V): Map<K, V> {
    val capacity = mapCapacity(rem).coerceAtLeast(16)
    return associateByTo(LinkedHashMap<K, V>(capacity), keySelector, valueTransform)
}
/**
 * Populates and returns the [destination] mutable map with key-value pairs, where key is provided by
 * the [keySelector] function applied to each element of the given array and value is the element itself.
 * 
 * If any two elements would have the same key returned by [keySelector] the last one gets added to the map.
 */
inline fun <K, M : MutableMap<in K, in UInt>> UIntBuffer.associateByTo(destination: M, keySelector: (UInt) -> K): M {
    for (element in this)
        destination.put(keySelector(element), element)
    return destination
}
/**
 * Populates and returns the [destination] mutable map with key-value pairs, where key is provided by the [keySelector]
 * function and and value is provided by the [valueTransform] function applied to elements of the given array.
 * 
 * If any two elements would have the same key returned by [keySelector] the last one gets added to the map.
 */
inline fun <K, V, M : MutableMap<in K, in V>> UIntBuffer.associateByTo(destination: M, keySelector: (UInt) -> K, valueTransform: (UInt) -> V): M {
    for (element in this)
        destination.put(keySelector(element), valueTransform(element))
    return destination
}
/**
 * Populates and returns the [destination] mutable map with key-value pairs provided by [transform] function
 * applied to each element of the given array.
 * 
 * If any of two pairs would have the same key the last one gets added to the map.
 */
inline fun <K, V, M : MutableMap<in K, in V>> UIntBuffer.associateTo(destination: M, transform: (UInt) -> Pair<K, V>): M {
    for (element in this)
        destination += transform(element)
    return destination
}
/**
 * Returns a [Map] where keys are elements from the given array and values are produced by the [valueSelector] function applied to each element.
 * 
 * If any two elements are equal, the last one gets added to the map.
 * 
 * The returned map preserves the entry iteration order of the original array.
 */
inline fun <V> UIntBuffer.associateWith(valueSelector: (UInt) -> V): Map<UInt, V> {
    val result = LinkedHashMap<UInt, V>(mapCapacity(rem).coerceAtLeast(16))
    return associateWithTo(result, valueSelector)
}
/**
 * Populates and returns the [destination] mutable map with key-value pairs for each element of the given array,
 * where key is the element itself and value is provided by the [valueSelector] function applied to that key.
 * 
 * If any two elements are equal, the last one overwrites the former value in the map.
 */
inline fun <V, M : MutableMap<in UInt, in V>> UIntBuffer.associateWithTo(destination: M, valueSelector: (UInt) -> V): M {
    for (element in this)
        destination.put(element, valueSelector(element))
    return destination
}
/** Appends all elements to the given [destination] collection. */
fun <C : MutableCollection<in UInt>> UIntBuffer.toCollection(destination: C): C {
    for (item in this)
        destination.add(item)
    return destination
}
/** Returns a single list of all elements yielded from results of [transform] function being invoked on each element of original array. */
inline fun <R> UIntBuffer.flatMap(transform: (UInt) -> Iterable<R>): List<R> = flatMapTo(ArrayList<R>(), transform)
/** Appends all elements yielded from results of [transform] function being invoked on each element of original array, to the given [destination]. */
inline fun <R, C : MutableCollection<in R>> UIntBuffer.flatMapTo(destination: C, transform: (UInt) -> Iterable<R>): C {
    for (element in this) {
        val list = transform(element)
        destination.addAll(list)
    }
    return destination
}
/**
 * Groups elements of the original array by the key returned by the given [keySelector] function applied to
 * each element and returns a map where each group key is associated with a list of corresponding elements.
 * 
 * The returned map preserves the entry iteration order of the keys produced from the original array.
 */
inline fun <K> UIntBuffer.groupBy(keySelector: (UInt) -> K): Map<K, List<UInt>> = groupByTo(LinkedHashMap<K, MutableList<UInt>>(), keySelector)
/**
 * Groups values returned by the [valueTransform] function applied to each element of the original array
 * by the key returned by the given [keySelector] function applied to the element
 * and returns a map where each group key is associated with a list of corresponding values.
 * 
 * The returned map preserves the entry iteration order of the keys produced from the original array.
 */
inline fun <K, V> UIntBuffer.groupBy(keySelector: (UInt) -> K, valueTransform: (UInt) -> V): Map<K, List<V>> = groupByTo(LinkedHashMap<K, MutableList<V>>(), keySelector, valueTransform)
/**
 * Groups elements of the original array by the key returned by the given [keySelector] function applied to each
 * element and puts to the [destination] map each group key associated with a list of corresponding elements.
 * 
 * @return The [destination] map.
 */
inline fun <K, M : MutableMap<in K, MutableList<UInt>>> UIntBuffer.groupByTo(destination: M, keySelector: (UInt) -> K): M {
    for (element in this) {
        val key = keySelector(element)
        val list = destination.getOrPut(key) { ArrayList<UInt>() }
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
 */
inline fun <K, V, M : MutableMap<in K, MutableList<V>>> UIntBuffer.groupByTo(destination: M, keySelector: (UInt) -> K, valueTransform: (UInt) -> V): M {
    for (element in this) {
        val key = keySelector(element)
        val list = destination.getOrPut(key) { ArrayList<V>() }
        list.add(valueTransform(element))
    }
    return destination
}
/**
 * Returns a list containing only distinct elements from the given array.
 * 
 * The elements in the resulting list are in the same order as they were in the source array.
 */
fun UIntBuffer.distinct(): List<UInt> = this.toMutableSet().toList()
/**
 * Returns a list containing only elements from the given array having distinct keys returned by the given [selector] function.
 * 
 * The elements in the resulting list are in the same order as they were in the source array.
 */
inline fun <K> UIntBuffer.distinctBy(selector: (UInt) -> K): List<UInt> {
    val set = HashSet<K>()
    val list = ArrayList<UInt>()
    for (e in this) {
        val key = selector(e)
        if (set.add(key))
            list.add(e)
    }
    return list
}
/**
 * Returns a new [MutableSet] containing all distinct elements from the given array.
 * 
 * The returned set preserves the element iteration order of the original array.
 */
fun UIntBuffer.toMutableSet(): MutableSet<UInt> = toCollection(LinkedHashSet<UInt>(mapCapacity(rem)))
/** Returns a list containing the results of applying the given [transform] function to each element in the original array. */
inline fun <R> UIntBuffer.map(transform: (UInt) -> R): List<R> = mapTo(ArrayList<R>(rem), transform)
/**
 * Returns a list containing the results of applying the given [transform] function to each element and its index in the original array.
 * @param [transform] function that takes the index of an element and the element itself and returns the result of the transform applied to the element.
 */
inline fun <R> UIntBuffer.mapIndexed(transform: (index: Int, UInt) -> R): List<R> = mapIndexedTo(ArrayList<R>(rem), transform)
/**
 * Applies the given [transform] function to each element and its index in the original array and appends the results to the given [destination].
 * @param [transform] function that takes the index of an element and the element itself and returns the result of the transform applied to the element.
 */
inline fun <R, C : MutableCollection<in R>> UIntBuffer.mapIndexedTo(destination: C, transform: (index: Int, UInt) -> R): C {
    var index = 0
    for (item in this)
        destination.add(transform(index++, item))
    return destination
}
/** Applies the given [transform] function to each element of the original array and appends the results to the given [destination]. */
inline fun <R, C : MutableCollection<in R>> UIntBuffer.mapTo(destination: C, transform: (UInt) -> R): C {
    for (item in this)
        destination.add(transform(item))
    return destination
}
/** Returns `true` if all elements match the given [predicate]. */
inline fun UIntBuffer.all(predicate: (UInt) -> Boolean): Boolean {
    for (element in this) if (!predicate(element)) return false
    return true
}
/** Returns `true` if array has at least one element. */
fun UIntBuffer.any(): Boolean = !isEmpty()
/** Returns `true` if at least one element matches the given [predicate]. */
inline fun UIntBuffer.any(predicate: (UInt) -> Boolean): Boolean {
    for (element in this) if (predicate(element)) return true
    return false
}
/** Returns the number of elements in this array. */
inline fun UIntBuffer.count(): Int = rem
/** Returns the number of elements matching the given [predicate]. */
inline fun UIntBuffer.count(predicate: (UInt) -> Boolean): Int {
    var count = 0
    for (element in this) if (predicate(element)) ++count
    return count
}
/** Performs the given [action] on each element. */
inline fun UIntBuffer.forEach(action: (UInt) -> Unit) { for (element in this) action(element) }
/**
 * Performs the given [action] on each element, providing sequential index with the element.
 * @param [action] function that takes the index of an element and the element itself and performs the action on the element.
 */
inline fun UIntBuffer.forEachIndexed(action: (index: Int, UInt) -> Unit): Unit {
    var index = 0
    for (item in this) action(index++, item)
}
/**
 * Returns the largest element.
 * 
 * @throws NoSuchElementException if the array is empty.
 */
fun UIntBuffer.max(): UInt {
    if (isEmpty()) throw NoSuchElementException()
    var max = this[0]
    for (i in 1..lastIndex) {
        val e = this[i]
        if (max < e) max = e
    }
    return max
}
/**
 * Returns the first element yielding the largest value of the given function.
 * 
 * @throws NoSuchElementException if the array is empty.
 */
inline fun <R : Comparable<R>> UIntBuffer.maxBy(selector: (UInt) -> R): UInt {
    if (isEmpty()) throw NoSuchElementException()
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
/** Returns the first element yielding the largest value of the given function or `null` if there are no elements. */
inline fun <R : Comparable<R>> UIntBuffer.maxByOrNull(selector: (UInt) -> R): UInt? {
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
/** Returns the largest element or `null` if there are no elements. */
fun UIntBuffer.maxOrNull(): UInt? {
    if (isEmpty()) return null
    var max = this[0]
    for (i in 1..lastIndex) {
        val e = this[i]
        if (max < e) max = e
    }
    return max
}
/**
 * Returns the first element having the largest value according to the provided [comparator].
 * 
 * @throws NoSuchElementException if the array is empty.
 */
fun UIntBuffer.maxWith(comparator: Comparator<in UInt>): UInt {
    if (isEmpty()) throw NoSuchElementException()
    var max = this[0]
    for (i in 1..lastIndex) {
        val e = this[i]
        if (comparator.compare(max, e) < 0) max = e
    }
    return max
}
/** Returns the first element having the largest value according to the provided [comparator] or `null` if there are no elements. */
fun UIntBuffer.maxWithOrNull(comparator: Comparator<in UInt>): UInt? {
    if (isEmpty()) return null
    var max = this[0]
    for (i in 1..lastIndex) {
        val e = this[i]
        if (comparator.compare(max, e) < 0) max = e
    }
    return max
}
/**
 * Returns the smallest element.
 * 
 * @throws NoSuchElementException if the array is empty.
 */
fun UIntBuffer.min(): UInt {
    if (isEmpty()) throw NoSuchElementException()
    var min = this[0]
    for (i in 1..lastIndex) {
        val e = this[i]
        if (min > e) min = e
    }
    return min
}
/**
 * Returns the first element yielding the smallest value of the given function.
 * 
 * @throws NoSuchElementException if the array is empty.
 */
inline fun <R : Comparable<R>> UIntBuffer.minBy(selector: (UInt) -> R): UInt {
    if (isEmpty()) throw NoSuchElementException()
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
 * Returns the first element yielding the smallest value of the given function or `null` if there are no elements.
 * 
 * @sample samples.collections.Collections.Aggregates.minByOrNull
 */
inline fun <R : Comparable<R>> UIntBuffer.minByOrNull(selector: (UInt) -> R): UInt? {
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
 * Returns the smallest value among all values produced by [selector] function applied to each element in the array.
 * 
 * If any of values produced by [selector] function is `NaN`, the returned result is `NaN`.
 * 
 * @throws NoSuchElementException if the array is empty.
 */
inline fun UIntBuffer.minOf(selector: (UInt) -> Double): Double {
    if (isEmpty()) throw NoSuchElementException()
    var minValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        minValue = minOf(minValue, v)
    }
    return minValue
}
/**
 * Returns the smallest value among all values produced by [selector] function applied to each element in the array.
 * 
 * If any of values produced by [selector] function is `NaN`, the returned result is `NaN`.
 * 
 * @throws NoSuchElementException if the array is empty.
 */
inline fun UIntBuffer.minOf(selector: (UInt) -> Float): Float {
    if (isEmpty()) throw NoSuchElementException()
    var minValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        minValue = minOf(minValue, v)
    }
    return minValue
}
/**
 * Returns the smallest value among all values produced by [selector] function applied to each element in the array.
 * 
 * @throws NoSuchElementException if the array is empty.
 */
inline fun <R : Comparable<R>> UIntBuffer.minOf(selector: (UInt) -> R): R {
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
 * Returns the smallest value among all values produced by [selector] function applied to each element in the array or `null` if there are no elements.
 * 
 * If any of values produced by [selector] function is `NaN`, the returned result is `NaN`.
 */
inline fun UIntBuffer.minOfOrNull(selector: (UInt) -> Double): Double? {
    if (isEmpty()) return null
    var minValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        minValue = minOf(minValue, v)
    }
    return minValue
}
/**
 * Returns the smallest value among all values produced by [selector] function applied to each element in the array or `null` if there are no elements.
 * 
 * If any of values produced by [selector] function is `NaN`, the returned result is `NaN`.
 */
inline fun UIntBuffer.minOfOrNull(selector: (UInt) -> Float): Float? {
    if (isEmpty()) return null
    var minValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        minValue = minOf(minValue, v)
    }
    return minValue
}
/** Returns the smallest value among all values produced by [selector] function applied to each element in the array or `null` if there are no elements. */
inline fun <R : Comparable<R>> UIntBuffer.minOfOrNull(selector: (UInt) -> R): R? {
    if (isEmpty()) return null
    var minValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        if (minValue > v)
            minValue = v
    }
    return minValue
}
/**
 * Returns the smallest value according to the provided [comparator] among all values produced by [selector] function applied to each element in the array.
 * 
 * @throws NoSuchElementException if the array is empty.
 */
inline fun <R> UIntBuffer.minOfWith(comparator: Comparator<in R>, selector: (UInt) -> R): R {
    if (isEmpty()) throw NoSuchElementException()
    var minValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        if (comparator.compare(minValue, v) > 0)
            minValue = v
    }
    return minValue
}
/**
 * Returns the smallest value according to the provided [comparator] among all values produced by [selector]
 * function applied to each element in the array or `null` if there are no elements.
 */
inline fun <R> UIntBuffer.minOfWithOrNull(comparator: Comparator<in R>, selector: (UInt) -> R): R? {
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
fun UIntBuffer.minOrNull(): UInt? {
     if (isEmpty()) return null
     var min = this[0]
     for (i in 1..lastIndex) {
         val e = this[i]
         if (min > e) min = e
     }
     return min
 }
/**
 * Returns the first element having the smallest value according to the provided [comparator].
 * 
 * @throws NoSuchElementException if the array is empty.
 */
fun UIntBuffer.minWith(comparator: Comparator<in UInt>): UInt {
    if (isEmpty()) throw NoSuchElementException()
    var min = this[0]
    for (i in 1..lastIndex) {
        val e = this[i]
        if (comparator.compare(min, e) > 0) min = e
    }
    return min
}
/** Returns the first element having the smallest value according to the provided [comparator] or `null` if there are no elements. */
fun UIntBuffer.minWithOrNull(comparator: Comparator<in UInt>): UInt? {
    if (isEmpty()) return null
    var min = this[0]
    for (i in 1..lastIndex) {
        val e = this[i]
        if (comparator.compare(min, e) > 0) min = e
    }
    return min
}
/** Returns `true` if the array has no elements. */
fun UIntBuffer.none(): Boolean = isEmpty()
/** Returns `true` if no elements match the given [predicate]. */
inline fun UIntBuffer.none(predicate: (UInt) -> Boolean): Boolean {
    for (element in this) if (predicate(element)) return false
    return true
}
/** Performs the given [action] on each element and returns the array itself afterwards. */
inline fun UIntBuffer.onEach(action: (UInt) -> Unit): UIntBuffer = apply { for (element in this) action(element) }
/**
 * Performs the given [action] on each element, providing sequential index with the element, and returns the array itself afterwards.
 * @param [action] function that takes the index of an element and the element itself and performs the action on the element.
 */
inline fun UIntBuffer.onEachIndexed(action: (index: Int, UInt) -> Unit): UIntBuffer = apply { forEachIndexed(action) }
/**
 * Accumulates value starting with the first element and applying [operation] from left to right to current accumulator value and each element.
 * 
 * Throws an exception if this array is empty. If the array can be empty in an expected way,
 * please use [reduceOrNull] instead. It returns `null` when its receiver is empty.
 * 
 * @param [operation] function that takes current accumulator value and an element, and calculates the next accumulator value.
 */
inline fun UIntBuffer.reduce(operation: (acc: UInt, UInt) -> UInt): UInt {
    if (isEmpty())
        throw UnsupportedOperationException("Empty array can't be reduced.")
    var accumulator = this[0]
    for (index in 1..lastIndex)
        accumulator = operation(accumulator, this[index])
    return accumulator
}
/**
 * Accumulates value starting with the first element and applying [operation] from left to right
 * to current accumulator value and each element with its index in the original array.
 * 
 * Throws an exception if this array is empty. If the array can be empty in an expected way,
 * please use [reduceIndexedOrNull] instead. It returns `null` when its receiver is empty.
 * 
 * @param [operation] function that takes the index of an element, current accumulator value and the element itself,
 * and calculates the next accumulator value.
 */
inline fun UIntBuffer.reduceIndexed(operation: (index: Int, acc: UInt, UInt) -> UInt): UInt {
    if (isEmpty())
        throw UnsupportedOperationException("Empty array can't be reduced.")
    var accumulator = this[0]
    for (index in 1..lastIndex)
        accumulator = operation(index, accumulator, this[index])
    return accumulator
}
/**
 * Accumulates value starting with the first element and applying [operation] from left to right
 * to current accumulator value and each element with its index in the original array.
 * 
 * Returns `null` if the array is empty.
 * 
 * @param [operation] function that takes the index of an element, current accumulator value and the element itself,
 * and calculates the next accumulator value.
 */
inline fun UIntBuffer.reduceIndexedOrNull(operation: (index: Int, acc: UInt, UInt) -> UInt): UInt? {
    if (isEmpty())
        return null
    var accumulator = this[0]
    for (index in 1..lastIndex)
        accumulator = operation(index, accumulator, this[index])
    return accumulator
}
/**
 * Accumulates value starting with the first element and applying [operation] from left to right to current accumulator value and each element.
 * 
 * Returns `null` if the array is empty.
 * 
 * @param [operation] function that takes current accumulator value and an element, and calculates the next accumulator value.
 */
inline fun UIntBuffer.reduceOrNull(operation: (acc: UInt, UInt) -> UInt): UInt? {
    if (isEmpty())
        return null
    var accumulator = this[0]
    for (index in 1..lastIndex)
        accumulator = operation(accumulator, this[index])
     return accumulator
}
/**
 * Accumulates value starting with the last element and applying [operation] from right to left to each element and current accumulator value.
 * 
 * Throws an exception if this array is empty. If the array can be empty in an expected way,
 * please use [reduceRightOrNull] instead. It returns `null` when its receiver is empty.
 * 
 * @param [operation] function that takes an element and current accumulator value, and calculates the next accumulator value.
 */
inline fun UIntBuffer.reduceRight(operation: (UInt, acc: UInt) -> UInt): UInt {
    var index = lastIndex
    if (index < 0) throw UnsupportedOperationException("Empty array can't be reduced.")
    var accumulator = get(index--)
    while (index >= 0)
        accumulator = operation(get(index--), accumulator)
    return accumulator
}
/**
 * Accumulates value starting with the last element and applying [operation] from right to left
 * to each element with its index in the original array and current accumulator value.
 * 
 * Throws an exception if this array is empty. If the array can be empty in an expected way,
 * please use [reduceRightIndexedOrNull] instead. It returns `null` when its receiver is empty.
 * 
 * @param [operation] function that takes the index of an element, the element itself and current accumulator value,
 * and calculates the next accumulator value.
 */
inline fun UIntBuffer.reduceRightIndexed(operation: (index: Int, UInt, acc: UInt) -> UInt): UInt {
    var index = lastIndex
    if (index < 0) throw UnsupportedOperationException("Empty array can't be reduced.")
    var accumulator = get(index--)
    while (index >= 0) {
        accumulator = operation(index, get(index), accumulator)
        --index
    }
    return accumulator
}
/**
 * Accumulates value starting with the last element and applying [operation] from right to left
 * to each element with its index in the original array and current accumulator value.
 * 
 * Returns `null` if the array is empty.
 * 
 * @param [operation] function that takes the index of an element, the element itself and current accumulator value,
 * and calculates the next accumulator value.
 */
inline fun UIntBuffer.reduceRightIndexedOrNull(operation: (index: Int, UInt, acc: UInt) -> UInt): UInt? {
    var index = lastIndex
    if (index < 0) return null
    var accumulator = get(index--)
    while (index >= 0) {
        accumulator = operation(index, get(index), accumulator)
        --index
    }
    return accumulator
}
/**
 * Accumulates value starting with the last element and applying [operation] from right to left to each element and current accumulator value.
 * 
 * Returns `null` if the array is empty.
 * 
 * @param [operation] function that takes an element and current accumulator value, and calculates the next accumulator value.
 */
inline fun UIntBuffer.reduceRightOrNull(operation: (UInt, acc: UInt) -> UInt): UInt? {
    var index = lastIndex
    if (index < 0) return null
    var accumulator = get(index--)
    while (index >= 0)
         accumulator = operation(get(index--), accumulator)
    return accumulator
}
/**
 * Splits the original array into pair of lists, where *first* list contains elements for which [predicate] 
 * yielded `true`, while *second* list contains elements for which [predicate] yielded `false`.
 */
inline fun UIntBuffer.partition(predicate: (UInt) -> Boolean): Pair<List<UInt>, List<UInt>> {
    val first = ArrayList<UInt>()
    val second = ArrayList<UInt>()
    for (element in this)
        if (predicate(element))
            first.add(element)
        else
            second.add(element)
    return Pair(first, second)
}
/**
 * Returns a list of pairs built from the elements of `this` array and the [other] array with the same index.
 * The returned list has length of the shortest collection.
 */
infix fun <R> UIntBuffer.zip(other: Array<out R>): List<Pair<UInt, R>> = zip(other) { t1, t2 -> t1 to t2 }
/**
 * Returns a list of values built from the elements of `this` array and the [other] array with the same index
 * using the provided [transform] function applied to each pair of elements.
 * The returned list has length of the shortest collection.
 */
inline fun <R, V> UIntBuffer.zip(other: Array<out R>, transform: (a: UInt, b: R) -> V): List<V> {
    val size = minOf(rem, other.size)
    val list = ArrayList<V>(size)
    for (i in 0 until size)
        list.add(transform(this[i], other[i]))
    return list
}
/**
 * Returns a list of pairs built from the elements of `this` collection and [other] array with the same index.
 * The returned list has length of the shortest collection.
 */
infix fun <R> UIntBuffer.zip(other: Iterable<R>): List<Pair<UInt, R>> = zip(other) { t1, t2 -> t1 to t2 }
/**
 * Returns a list of values built from the elements of `this` array and the [other] collection with the same index
 * using the provided [transform] function applied to each pair of elements.
 * The returned list has length of the shortest collection.
 */
inline fun <R, V> UIntBuffer.zip(other: Iterable<R>, transform: (a: UInt, b: R) -> V): List<V> {
    val arraySize = rem
    val list = ArrayList<V>(minOf(other.collectionSizeOrDefault(10), arraySize))
    var i = 0
    for (element in other) {
        if (i >= arraySize) break
        list.add(transform(this[i++], element))
    }
    return list
}
/**
 * Returns a list of pairs built from the elements of `this` array and the [other] array with the same index.
 * The returned list has length of the shortest collection.
 */
infix fun UIntBuffer.zip(other: UIntArray): List<Pair<UInt, UInt>> = zip(other) { t1, t2 -> t1 to t2 }
/**
 * Returns a list of values built from the elements of `this` array and the [other] array with the same index
 * using the provided [transform] function applied to each pair of elements.
 * The returned list has length of the shortest array.
 */
inline fun <V> UIntBuffer.zip(other: UIntArray, transform: (a: UInt, b: UInt) -> V): List<V> {
    val size = minOf(rem, other.size)
    val list = ArrayList<V>(size)
    for (i in 0 until size)
        list.add(transform(this[i], other[i]))
    return list
}
/**
 * Appends the string from all the elements separated using [separator] and using the given [prefix] and [postfix] if supplied.
 * 
 * If the collection could be huge, you can specify a non-negative value of [limit], in which case only the first [limit]
 * elements will be appended, followed by the [truncated] string (which defaults to "...").
 */
fun <A : Appendable> UIntBuffer.joinTo(buffer: A, separator: CharSequence = ", ", prefix: CharSequence = "", postfix: CharSequence = "", limit: Int = -1, truncated: CharSequence = "...", transform: ((UInt) -> CharSequence)? = null): A {
    buffer.append(prefix)
    var count = 0
    for (element in this) {
        if (++count > 1) buffer.append(separator)
        if (limit < 0 || count <= limit)
            if (transform != null)
                buffer.append(transform(element))
            else
                buffer.append(element.toString())
        else break
    }
    if (limit >= 0 && count > limit) buffer.append(truncated)
    buffer.append(postfix)
    return buffer
}
/**
 * Creates a string from all the elements separated using [separator] and using the given [prefix] and [postfix] if supplied.
 * 
 * If the collection could be huge, you can specify a non-negative value of [limit], in which case only the first [limit]
 * elements will be appended, followed by the [truncated] string (which defaults to "...").
 */
fun UIntBuffer.joinToString(separator: CharSequence = ", ", prefix: CharSequence = "", postfix: CharSequence = "", limit: Int = -1, truncated: CharSequence = "...", transform: ((UInt) -> CharSequence)? = null): String =
    joinTo(StringBuilder(), separator, prefix, postfix, limit, truncated, transform).toString()
/**
 * Returns 1st *element* from the buffer.
 * 
 * If the size of this array is less than 1, throws an [IndexOutOfBoundsException]
 */
inline operator fun ULongBuffer.component1(): ULong = get(0)
/**
 * Returns 2nd *element* from the buffer.
 * 
 * If the size of this array is less than 2, throws an [IndexOutOfBoundsException]
 */
inline operator fun ULongBuffer.component2(): ULong = get(1)
/**
 * Returns 3rd *element* from the buffer.
 * 
 * If the size of this array is less than 3, throws an [IndexOutOfBoundsException]
 */
inline operator fun ULongBuffer.component3(): ULong = get(2)
/**
 * Returns 4th *element* from the buffer.
 * 
 * If the size of this array is less than 4, throws an [IndexOutOfBoundsException]
 */
inline operator fun ULongBuffer.component4(): ULong = get(3)
/**
 * Returns 5th *element* from the buffer.
 * 
 * If the size of this array is less than 5, throws an [IndexOutOfBoundsException]
 */
inline operator fun ULongBuffer.component5(): ULong = get(4)
/** Returns `true` if [element] is found in the array. */
operator fun ULongBuffer.contains(element: ULong): Boolean = indexOf(element) >= 0
/** Returns an element at the given [index] or throws an [IndexOutOfBoundsException] if the [index] is out of bounds of this array. */
inline fun <T> ULongBuffer.elementAt(index: Int): ULong = get(index)
/** Returns an element at the given [index] or the result of calling the [defaultValue] function if the [index] is out of bounds of this array. */
inline fun ULongBuffer.elementAtOrElse(index: Int, defaultValue: (Int) -> ULong): ULong = if (index >= 0 && index <= lastIndex) get(index) else defaultValue(index)
/** Returns an element at the given [index] or `null` if the [index] is out of bounds of this array. */
inline fun ULongBuffer.elementAtOrNull(index: Int): ULong? = this.getOrNull(index)
/** Returns the first element matching the given [predicate], or `null` if no such element was found. */
inline fun ULongBuffer.find(predicate: (ULong) -> Boolean): ULong? = firstOrNull(predicate)
/** Returns the last element matching the given [predicate], or `null` if no such element was found. */
inline fun ULongBuffer.findLast(predicate: (ULong) -> Boolean): ULong? = lastOrNull(predicate)
/**
 * Returns the first element.
 * 
 * @throws NoSuchElementException if the array is empty.
 */
fun ULongBuffer.first(): ULong {
    if (isEmpty())
        throw NoSuchElementException("Array is empty.")
    return this[0]
}
/**
 * Returns the first element matching the given [predicate].
 * @throws [NoSuchElementException] if no such element is found.
 */
inline fun ULongBuffer.first(predicate: (ULong) -> Boolean): ULong {
    for (element in this) if (predicate(element)) return element
    throw NoSuchElementException("Array contains no element matching the predicate.")
}
/** Returns the first element, or `null` if the array is empty. */
fun ULongBuffer.firstOrNull(): ULong? = if (isEmpty()) null else this[0]
/** Returns the first element matching the given [predicate], or `null` if element was not found. */
inline fun ULongBuffer.firstOrNull(predicate: (ULong) -> Boolean): ULong? {
    for (element in this) if (predicate(element)) return element
    return null
}
/** Returns an element at the given [index] or the result of calling the [defaultValue] function if the [index] is out of bounds of this array. */
inline fun ULongBuffer.getOrElse(index: Int, defaultValue: (Int) -> ULong): ULong = if (index >= 0 && index <= lastIndex) get(index) else defaultValue(index)
/** Returns an element at the given [index] or `null` if the [index] is out of bounds of this array. */
fun ULongBuffer.getOrNull(index: Int): ULong? = if (index >= 0 && index <= lastIndex) get(index) else null
/** Returns first index of [element], or -1 if the array does not contain element. */
fun ULongBuffer.indexOf(element: ULong): Int {
    for (index in indices)
        if (element == this[index])
            return index
    return -1
}
/** Returns index of the first element matching the given [predicate], or -1 if the array does not contain such element. */
inline fun ULongBuffer.indexOfFirst(predicate: (ULong) -> Boolean): Int {
    for (index in indices)
        if (predicate(this[index]))
            return index
    return -1
}
/** Returns index of the last element matching the given [predicate], or -1 if the array does not contain such element. */
inline fun ULongBuffer.indexOfLast(predicate: (ULong) -> Boolean): Int {
    for (index in indices.reversed())
        if (predicate(this[index]))
            return index
    return -1
}
/**
 * Returns the last element.
 * 
 * @throws NoSuchElementException if the array is empty.
 */
fun ULongBuffer.last(): ULong {
    if (isEmpty())
        throw NoSuchElementException("Array is empty.")
    return this[lastIndex]
}
/**
 * Returns the last element matching the given [predicate].
 * 
 * @throws NoSuchElementException if no such element is found.
 */
inline fun ULongBuffer.last(predicate: (ULong) -> Boolean): ULong {
    for (index in this.indices.reversed()) {
        val element = this[index]
        if (predicate(element)) return element
    }
    throw NoSuchElementException("Array contains no element matching the predicate.")
}
/** Returns last index of [element], or -1 if the array does not contain element. */
fun ULongBuffer.lastIndexOf(element: ULong): Int {
    for (index in indices.reversed())
        if (element == this[index])
            return index
    return -1
}
/** Returns the last element, or `null` if the array is empty. */
fun ULongBuffer.lastOrNull(): ULong? = if (isEmpty()) null else this[rem - 1]
/** Returns the last element matching the given [predicate], or `null` if no such element was found. */
inline fun ULongBuffer.lastOrNull(predicate: (ULong) -> Boolean): ULong? {
    for (index in this.indices.reversed()) {
        val element = this[index]
        if (predicate(element)) return element
    }
    return null
}
/** Returns the single element, or throws an exception if the array is empty or has more than one element. */
fun ULongBuffer.single(): ULong = when (rem) {
    0 -> throw NoSuchElementException("Array is empty.")
    1 -> this[0]
    else -> throw IllegalArgumentException("Array has more than one element.")
}
/** Returns the single element matching the given [predicate], or throws exception if there is no or more than one matching element. */
inline fun ULongBuffer.single(predicate: (ULong) -> Boolean): ULong {
    var single: ULong? = null
    var found = false
    for (element in this)
        if (predicate(element)) {
            if (found) throw IllegalArgumentException("Array contains more than one matching element.")
            single = element
            found = true
        }
    if (!found) throw NoSuchElementException("Array contains no element matching the predicate.")
    @Suppress("UNCHECKED_CAST")
    return single as ULong
}
/** Returns single element, or `null` if the array is empty or has more than one element. */
fun ULongBuffer.singleOrNull(): ULong? = if (rem == 1) this[0] else null
/** Returns the single element matching the given [predicate], or `null` if element was not found or more than one element was found. */
inline fun ULongBuffer.singleOrNull(predicate: (ULong) -> Boolean): ULong? {
    var single: ULong? = null
    var found = false
    for (element in this)
        if (predicate(element)) {
            if (found) return null
            single = element
            found = true
        }
    if (!found) return null
    return single
}
/** Returns a list containing only elements matching the given [predicate]. */
inline fun ULongBuffer.filter(predicate: (ULong) -> Boolean): List<ULong> = filterTo(ArrayList<ULong>(), predicate)
/**
 * Returns a list containing only elements matching the given [predicate].
 * @param [predicate] function that takes the index of an element and the element itself and returns the result of predicate evaluation on the element.
 */
inline fun ULongBuffer.filterIndexed(predicate: (index: Int, ULong) -> Boolean): List<ULong> = filterIndexedTo(ArrayList<ULong>(), predicate)
/**
 * Appends all elements matching the given [predicate] to the given [destination].
 * @param [predicate] function that takes the index of an element and the element itself and returns the result of predicate evaluation on the element.
 */
inline fun <C : MutableCollection<in ULong>> ULongBuffer.filterIndexedTo(destination: C, predicate: (index: Int, ULong) -> Boolean): C {
    forEachIndexed { index, element ->
        if (predicate(index, element)) destination.add(element)
    }
    return destination
}
/** Returns a list containing all elements not matching the given [predicate]. */
inline fun ULongBuffer.filterNot(predicate: (ULong) -> Boolean): List<ULong> = filterNotTo(ArrayList<ULong>(), predicate)
/** Appends all elements not matching the given [predicate] to the given [destination]. */
inline fun <C : MutableCollection<in ULong>> ULongBuffer.filterNotTo(destination: C, predicate: (ULong) -> Boolean): C {
     for (element in this) if (!predicate(element)) destination.add(element)
     return destination
}
/** Appends all elements matching the given [predicate] to the given [destination]. */
inline fun <C : MutableCollection<in ULong>> ULongBuffer.filterTo(destination: C, predicate: (ULong) -> Boolean): C {
     for (element in this) if (predicate(element)) destination.add(element)
     return destination
}
/** Returns a list containing elements at specified [indices]. */
fun ULongBuffer.slice(indices: Iterable<Int>): List<ULong> {
    val size = indices.collectionSizeOrDefault(10)
    if (size == 0) return emptyList()
    val list = ArrayList<ULong>(size)
    for (index in indices)
        list.add(get(index))
    return list
}
/** Returns an array containing elements of this array at specified [indices]. */
fun ULongBuffer.sliceArray(indices: Collection<Int>): ULongArray {
    val result = ULongArray(indices.size)
    var targetIndex = 0
    for (sourceIndex in indices)
        result[targetIndex++] = this[sourceIndex]
    return result
}
/** Sorts elements in the array in-place descending according to their natural sort order. */
fun ULongBuffer.sortDescending() {
    if (rem > 1) {
        val array = toULongArray().apply{ sortDescending() }
        for (i in 0 until rem)
            this[pos + i] = array[i]
    }
}
/** Returns a list of all elements sorted according to their natural sort order. */
fun ULongBuffer.sorted(): List<ULong> = toTypedArray().apply { sort() }.asList()
/** Returns an array with all elements of this array sorted according to their natural sort order. */
fun ULongBuffer.sortedArray(): ULongArray = toULongArray().apply { sort() }
/** Returns an array with all elements of this array sorted descending according to their natural sort order. */
fun ULongBuffer.sortedArrayDescending(): ULongArray = toULongArray().apply { sortDescending() }
/** Returns a list of all elements sorted according to natural sort order of the value returned by specified [selector] function. */
inline fun <R : Comparable<R>> ULongBuffer.sortedBy(crossinline selector: (ULong) -> R?): List<ULong> = toULongArray().sortedWith(compareBy(selector))
/** Returns a list of all elements sorted descending according to natural sort order of the value returned by specified [selector] function. */
inline fun <R : Comparable<R>> ULongBuffer.sortedByDescending(crossinline selector: (ULong) -> R?): List<ULong> = toULongArray().sortedWith(compareByDescending(selector))
/** Returns a list of all elements sorted descending according to their natural sort order. */
fun ULongBuffer.sortedDescending(): List<ULong> = toULongArray().apply { sort() }.reversed()
/** Returns a list of all elements sorted according to the specified [comparator]. */
fun ULongBuffer.sortedWith(comparator: Comparator<in ULong>): List<ULong> = toTypedArray().apply { sortWith(comparator) }.asList()
/** Sorts the array in-place. */
fun ULongBuffer.sort() {
    if (rem > 1) {
        val array = toULongArray().apply{ sort() }
        for (i in 0 until rem)
            this[pos + i] = array[i]
    }
}
/** Returns a string representation of the contents of the specified array as if it is [List]. */
fun ULongBuffer.contentToString(): String {
    val iMax = lim - 1
    if (iMax == -1) return "[]"
    val b = StringBuilder()
    b.append('[')
    var i = 0
    while (true) {
        b.append(get(i))
        if (i == iMax) return b.append(']').toString()
        b.append(", ")
        i++
    }
}
/**
 * Fills this array or its subrange with the specified [element] value.
 * 
 * @param fromIndex the start of the range (inclusive) to fill, 0 by default.
 * @param toIndex the end of the range (exclusive) to fill, size of this array by default.
 * 
 * @throws IndexOutOfBoundsException if [fromIndex] is less than zero or [toIndex] is greater than the size of this array.
 * @throws IllegalArgumentException if [fromIndex] is greater than [toIndex].
 */
fun ULongBuffer.fill(element: ULong, fromIndex: Int = pos, toIndex: Int = rem) {
    for (i in fromIndex until toIndex)
        this[i] = element
}
/** Returns the range of valid indices for the array. */
val ULongBuffer.indices: IntRange
    get() = IntRange(0, lastIndex)
/** Returns `true` if the array is empty. */
inline fun ULongBuffer.isEmpty(): Boolean = rem == 0
/** Returns `true` if the array is not empty. */
inline fun ULongBuffer.isNotEmpty(): Boolean = !isEmpty()
/** Returns the last valid index for the array. */
val ULongBuffer.lastIndex: Int
    get() = rem - 1
/** Returns an array of Byte containing all of the elements of this generic array. */
fun ULongBuffer.toULongArray(): ULongArray = ULongArray(rem) { index -> this[index] }
/** Returns a *typed* object array containing all of the elements of this primitive array. */
fun ULongBuffer.toTypedArray(): Array<ULong> = Array(rem) { index -> this[index] }
/**
 * Returns a [Map] containing key-value pairs provided by [transform] function applied to elements of the given array.
 * 
 * If any of two pairs would have the same key the last one gets added to the map.
 * 
 * The returned map preserves the entry iteration order of the original array.
 */
inline fun <K, V> ULongBuffer.associate(transform: (ULong) -> Pair<K, V>): Map<K, V> {
    val capacity = mapCapacity(rem).coerceAtLeast(16)
    return associateTo(LinkedHashMap<K, V>(capacity), transform)
}
/**
 * Returns a [Map] containing the elements from the given array indexed by the key returned from [keySelector] function applied to each element.
 * 
 * If any two elements would have the same key returned by [keySelector] the last one gets added to the map.
 * 
 * The returned map preserves the entry iteration order of the original array.
 */
inline fun <K> ULongBuffer.associateBy(keySelector: (ULong) -> K): Map<K, ULong> {
    val capacity = mapCapacity(rem).coerceAtLeast(16)
    return associateByTo(LinkedHashMap<K, ULong>(capacity), keySelector)
}
/**
 * Returns a [Map] containing the values provided by [valueTransform] and indexed by [keySelector] functions applied to elements of the given array.
 * 
 * If any two elements would have the same key returned by [keySelector] the last one gets added to the map.
 * 
 * The returned map preserves the entry iteration order of the original array.
 */
inline fun <K, V> ULongBuffer.associateBy(keySelector: (ULong) -> K, valueTransform: (ULong) -> V): Map<K, V> {
    val capacity = mapCapacity(rem).coerceAtLeast(16)
    return associateByTo(LinkedHashMap<K, V>(capacity), keySelector, valueTransform)
}
/**
 * Populates and returns the [destination] mutable map with key-value pairs, where key is provided by
 * the [keySelector] function applied to each element of the given array and value is the element itself.
 * 
 * If any two elements would have the same key returned by [keySelector] the last one gets added to the map.
 */
inline fun <K, M : MutableMap<in K, in ULong>> ULongBuffer.associateByTo(destination: M, keySelector: (ULong) -> K): M {
    for (element in this)
        destination.put(keySelector(element), element)
    return destination
}
/**
 * Populates and returns the [destination] mutable map with key-value pairs, where key is provided by the [keySelector]
 * function and and value is provided by the [valueTransform] function applied to elements of the given array.
 * 
 * If any two elements would have the same key returned by [keySelector] the last one gets added to the map.
 */
inline fun <K, V, M : MutableMap<in K, in V>> ULongBuffer.associateByTo(destination: M, keySelector: (ULong) -> K, valueTransform: (ULong) -> V): M {
    for (element in this)
        destination.put(keySelector(element), valueTransform(element))
    return destination
}
/**
 * Populates and returns the [destination] mutable map with key-value pairs provided by [transform] function
 * applied to each element of the given array.
 * 
 * If any of two pairs would have the same key the last one gets added to the map.
 */
inline fun <K, V, M : MutableMap<in K, in V>> ULongBuffer.associateTo(destination: M, transform: (ULong) -> Pair<K, V>): M {
    for (element in this)
        destination += transform(element)
    return destination
}
/**
 * Returns a [Map] where keys are elements from the given array and values are produced by the [valueSelector] function applied to each element.
 * 
 * If any two elements are equal, the last one gets added to the map.
 * 
 * The returned map preserves the entry iteration order of the original array.
 */
inline fun <V> ULongBuffer.associateWith(valueSelector: (ULong) -> V): Map<ULong, V> {
    val result = LinkedHashMap<ULong, V>(mapCapacity(rem).coerceAtLeast(16))
    return associateWithTo(result, valueSelector)
}
/**
 * Populates and returns the [destination] mutable map with key-value pairs for each element of the given array,
 * where key is the element itself and value is provided by the [valueSelector] function applied to that key.
 * 
 * If any two elements are equal, the last one overwrites the former value in the map.
 */
inline fun <V, M : MutableMap<in ULong, in V>> ULongBuffer.associateWithTo(destination: M, valueSelector: (ULong) -> V): M {
    for (element in this)
        destination.put(element, valueSelector(element))
    return destination
}
/** Appends all elements to the given [destination] collection. */
fun <C : MutableCollection<in ULong>> ULongBuffer.toCollection(destination: C): C {
    for (item in this)
        destination.add(item)
    return destination
}
/** Returns a single list of all elements yielded from results of [transform] function being invoked on each element of original array. */
inline fun <R> ULongBuffer.flatMap(transform: (ULong) -> Iterable<R>): List<R> = flatMapTo(ArrayList<R>(), transform)
/** Appends all elements yielded from results of [transform] function being invoked on each element of original array, to the given [destination]. */
inline fun <R, C : MutableCollection<in R>> ULongBuffer.flatMapTo(destination: C, transform: (ULong) -> Iterable<R>): C {
    for (element in this) {
        val list = transform(element)
        destination.addAll(list)
    }
    return destination
}
/**
 * Groups elements of the original array by the key returned by the given [keySelector] function applied to
 * each element and returns a map where each group key is associated with a list of corresponding elements.
 * 
 * The returned map preserves the entry iteration order of the keys produced from the original array.
 */
inline fun <K> ULongBuffer.groupBy(keySelector: (ULong) -> K): Map<K, List<ULong>> = groupByTo(LinkedHashMap<K, MutableList<ULong>>(), keySelector)
/**
 * Groups values returned by the [valueTransform] function applied to each element of the original array
 * by the key returned by the given [keySelector] function applied to the element
 * and returns a map where each group key is associated with a list of corresponding values.
 * 
 * The returned map preserves the entry iteration order of the keys produced from the original array.
 */
inline fun <K, V> ULongBuffer.groupBy(keySelector: (ULong) -> K, valueTransform: (ULong) -> V): Map<K, List<V>> = groupByTo(LinkedHashMap<K, MutableList<V>>(), keySelector, valueTransform)
/**
 * Groups elements of the original array by the key returned by the given [keySelector] function applied to each
 * element and puts to the [destination] map each group key associated with a list of corresponding elements.
 * 
 * @return The [destination] map.
 */
inline fun <K, M : MutableMap<in K, MutableList<ULong>>> ULongBuffer.groupByTo(destination: M, keySelector: (ULong) -> K): M {
    for (element in this) {
        val key = keySelector(element)
        val list = destination.getOrPut(key) { ArrayList<ULong>() }
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
 */
inline fun <K, V, M : MutableMap<in K, MutableList<V>>> ULongBuffer.groupByTo(destination: M, keySelector: (ULong) -> K, valueTransform: (ULong) -> V): M {
    for (element in this) {
        val key = keySelector(element)
        val list = destination.getOrPut(key) { ArrayList<V>() }
        list.add(valueTransform(element))
    }
    return destination
}
/**
 * Returns a list containing only distinct elements from the given array.
 * 
 * The elements in the resulting list are in the same order as they were in the source array.
 */
fun ULongBuffer.distinct(): List<ULong> = this.toMutableSet().toList()
/**
 * Returns a list containing only elements from the given array having distinct keys returned by the given [selector] function.
 * 
 * The elements in the resulting list are in the same order as they were in the source array.
 */
inline fun <K> ULongBuffer.distinctBy(selector: (ULong) -> K): List<ULong> {
    val set = HashSet<K>()
    val list = ArrayList<ULong>()
    for (e in this) {
        val key = selector(e)
        if (set.add(key))
            list.add(e)
    }
    return list
}
/**
 * Returns a new [MutableSet] containing all distinct elements from the given array.
 * 
 * The returned set preserves the element iteration order of the original array.
 */
fun ULongBuffer.toMutableSet(): MutableSet<ULong> = toCollection(LinkedHashSet<ULong>(mapCapacity(rem)))
/** Returns a list containing the results of applying the given [transform] function to each element in the original array. */
inline fun <R> ULongBuffer.map(transform: (ULong) -> R): List<R> = mapTo(ArrayList<R>(rem), transform)
/**
 * Returns a list containing the results of applying the given [transform] function to each element and its index in the original array.
 * @param [transform] function that takes the index of an element and the element itself and returns the result of the transform applied to the element.
 */
inline fun <R> ULongBuffer.mapIndexed(transform: (index: Int, ULong) -> R): List<R> = mapIndexedTo(ArrayList<R>(rem), transform)
/**
 * Applies the given [transform] function to each element and its index in the original array and appends the results to the given [destination].
 * @param [transform] function that takes the index of an element and the element itself and returns the result of the transform applied to the element.
 */
inline fun <R, C : MutableCollection<in R>> ULongBuffer.mapIndexedTo(destination: C, transform: (index: Int, ULong) -> R): C {
    var index = 0
    for (item in this)
        destination.add(transform(index++, item))
    return destination
}
/** Applies the given [transform] function to each element of the original array and appends the results to the given [destination]. */
inline fun <R, C : MutableCollection<in R>> ULongBuffer.mapTo(destination: C, transform: (ULong) -> R): C {
    for (item in this)
        destination.add(transform(item))
    return destination
}
/** Returns `true` if all elements match the given [predicate]. */
inline fun ULongBuffer.all(predicate: (ULong) -> Boolean): Boolean {
    for (element in this) if (!predicate(element)) return false
    return true
}
/** Returns `true` if array has at least one element. */
fun ULongBuffer.any(): Boolean = !isEmpty()
/** Returns `true` if at least one element matches the given [predicate]. */
inline fun ULongBuffer.any(predicate: (ULong) -> Boolean): Boolean {
    for (element in this) if (predicate(element)) return true
    return false
}
/** Returns the number of elements in this array. */
inline fun ULongBuffer.count(): Int = rem
/** Returns the number of elements matching the given [predicate]. */
inline fun ULongBuffer.count(predicate: (ULong) -> Boolean): Int {
    var count = 0
    for (element in this) if (predicate(element)) ++count
    return count
}
/** Performs the given [action] on each element. */
inline fun ULongBuffer.forEach(action: (ULong) -> Unit) { for (element in this) action(element) }
/**
 * Performs the given [action] on each element, providing sequential index with the element.
 * @param [action] function that takes the index of an element and the element itself and performs the action on the element.
 */
inline fun ULongBuffer.forEachIndexed(action: (index: Int, ULong) -> Unit): Unit {
    var index = 0
    for (item in this) action(index++, item)
}
/**
 * Returns the largest element.
 * 
 * @throws NoSuchElementException if the array is empty.
 */
fun ULongBuffer.max(): ULong {
    if (isEmpty()) throw NoSuchElementException()
    var max = this[0]
    for (i in 1..lastIndex) {
        val e = this[i]
        if (max < e) max = e
    }
    return max
}
/**
 * Returns the first element yielding the largest value of the given function.
 * 
 * @throws NoSuchElementException if the array is empty.
 */
inline fun <R : Comparable<R>> ULongBuffer.maxBy(selector: (ULong) -> R): ULong {
    if (isEmpty()) throw NoSuchElementException()
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
/** Returns the first element yielding the largest value of the given function or `null` if there are no elements. */
inline fun <R : Comparable<R>> ULongBuffer.maxByOrNull(selector: (ULong) -> R): ULong? {
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
/** Returns the largest element or `null` if there are no elements. */
fun ULongBuffer.maxOrNull(): ULong? {
    if (isEmpty()) return null
    var max = this[0]
    for (i in 1..lastIndex) {
        val e = this[i]
        if (max < e) max = e
    }
    return max
}
/**
 * Returns the first element having the largest value according to the provided [comparator].
 * 
 * @throws NoSuchElementException if the array is empty.
 */
fun ULongBuffer.maxWith(comparator: Comparator<in ULong>): ULong {
    if (isEmpty()) throw NoSuchElementException()
    var max = this[0]
    for (i in 1..lastIndex) {
        val e = this[i]
        if (comparator.compare(max, e) < 0) max = e
    }
    return max
}
/** Returns the first element having the largest value according to the provided [comparator] or `null` if there are no elements. */
fun ULongBuffer.maxWithOrNull(comparator: Comparator<in ULong>): ULong? {
    if (isEmpty()) return null
    var max = this[0]
    for (i in 1..lastIndex) {
        val e = this[i]
        if (comparator.compare(max, e) < 0) max = e
    }
    return max
}
/**
 * Returns the smallest element.
 * 
 * @throws NoSuchElementException if the array is empty.
 */
fun ULongBuffer.min(): ULong {
    if (isEmpty()) throw NoSuchElementException()
    var min = this[0]
    for (i in 1..lastIndex) {
        val e = this[i]
        if (min > e) min = e
    }
    return min
}
/**
 * Returns the first element yielding the smallest value of the given function.
 * 
 * @throws NoSuchElementException if the array is empty.
 */
inline fun <R : Comparable<R>> ULongBuffer.minBy(selector: (ULong) -> R): ULong {
    if (isEmpty()) throw NoSuchElementException()
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
 * Returns the first element yielding the smallest value of the given function or `null` if there are no elements.
 * 
 * @sample samples.collections.Collections.Aggregates.minByOrNull
 */
inline fun <R : Comparable<R>> ULongBuffer.minByOrNull(selector: (ULong) -> R): ULong? {
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
 * Returns the smallest value among all values produced by [selector] function applied to each element in the array.
 * 
 * If any of values produced by [selector] function is `NaN`, the returned result is `NaN`.
 * 
 * @throws NoSuchElementException if the array is empty.
 */
inline fun ULongBuffer.minOf(selector: (ULong) -> Double): Double {
    if (isEmpty()) throw NoSuchElementException()
    var minValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        minValue = minOf(minValue, v)
    }
    return minValue
}
/**
 * Returns the smallest value among all values produced by [selector] function applied to each element in the array.
 * 
 * If any of values produced by [selector] function is `NaN`, the returned result is `NaN`.
 * 
 * @throws NoSuchElementException if the array is empty.
 */
inline fun ULongBuffer.minOf(selector: (ULong) -> Float): Float {
    if (isEmpty()) throw NoSuchElementException()
    var minValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        minValue = minOf(minValue, v)
    }
    return minValue
}
/**
 * Returns the smallest value among all values produced by [selector] function applied to each element in the array.
 * 
 * @throws NoSuchElementException if the array is empty.
 */
inline fun <R : Comparable<R>> ULongBuffer.minOf(selector: (ULong) -> R): R {
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
 * Returns the smallest value among all values produced by [selector] function applied to each element in the array or `null` if there are no elements.
 * 
 * If any of values produced by [selector] function is `NaN`, the returned result is `NaN`.
 */
inline fun ULongBuffer.minOfOrNull(selector: (ULong) -> Double): Double? {
    if (isEmpty()) return null
    var minValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        minValue = minOf(minValue, v)
    }
    return minValue
}
/**
 * Returns the smallest value among all values produced by [selector] function applied to each element in the array or `null` if there are no elements.
 * 
 * If any of values produced by [selector] function is `NaN`, the returned result is `NaN`.
 */
inline fun ULongBuffer.minOfOrNull(selector: (ULong) -> Float): Float? {
    if (isEmpty()) return null
    var minValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        minValue = minOf(minValue, v)
    }
    return minValue
}
/** Returns the smallest value among all values produced by [selector] function applied to each element in the array or `null` if there are no elements. */
inline fun <R : Comparable<R>> ULongBuffer.minOfOrNull(selector: (ULong) -> R): R? {
    if (isEmpty()) return null
    var minValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        if (minValue > v)
            minValue = v
    }
    return minValue
}
/**
 * Returns the smallest value according to the provided [comparator] among all values produced by [selector] function applied to each element in the array.
 * 
 * @throws NoSuchElementException if the array is empty.
 */
inline fun <R> ULongBuffer.minOfWith(comparator: Comparator<in R>, selector: (ULong) -> R): R {
    if (isEmpty()) throw NoSuchElementException()
    var minValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        if (comparator.compare(minValue, v) > 0)
            minValue = v
    }
    return minValue
}
/**
 * Returns the smallest value according to the provided [comparator] among all values produced by [selector]
 * function applied to each element in the array or `null` if there are no elements.
 */
inline fun <R> ULongBuffer.minOfWithOrNull(comparator: Comparator<in R>, selector: (ULong) -> R): R? {
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
fun ULongBuffer.minOrNull(): ULong? {
     if (isEmpty()) return null
     var min = this[0]
     for (i in 1..lastIndex) {
         val e = this[i]
         if (min > e) min = e
     }
     return min
 }
/**
 * Returns the first element having the smallest value according to the provided [comparator].
 * 
 * @throws NoSuchElementException if the array is empty.
 */
fun ULongBuffer.minWith(comparator: Comparator<in ULong>): ULong {
    if (isEmpty()) throw NoSuchElementException()
    var min = this[0]
    for (i in 1..lastIndex) {
        val e = this[i]
        if (comparator.compare(min, e) > 0) min = e
    }
    return min
}
/** Returns the first element having the smallest value according to the provided [comparator] or `null` if there are no elements. */
fun ULongBuffer.minWithOrNull(comparator: Comparator<in ULong>): ULong? {
    if (isEmpty()) return null
    var min = this[0]
    for (i in 1..lastIndex) {
        val e = this[i]
        if (comparator.compare(min, e) > 0) min = e
    }
    return min
}
/** Returns `true` if the array has no elements. */
fun ULongBuffer.none(): Boolean = isEmpty()
/** Returns `true` if no elements match the given [predicate]. */
inline fun ULongBuffer.none(predicate: (ULong) -> Boolean): Boolean {
    for (element in this) if (predicate(element)) return false
    return true
}
/** Performs the given [action] on each element and returns the array itself afterwards. */
inline fun ULongBuffer.onEach(action: (ULong) -> Unit): ULongBuffer = apply { for (element in this) action(element) }
/**
 * Performs the given [action] on each element, providing sequential index with the element, and returns the array itself afterwards.
 * @param [action] function that takes the index of an element and the element itself and performs the action on the element.
 */
inline fun ULongBuffer.onEachIndexed(action: (index: Int, ULong) -> Unit): ULongBuffer = apply { forEachIndexed(action) }
/**
 * Accumulates value starting with the first element and applying [operation] from left to right to current accumulator value and each element.
 * 
 * Throws an exception if this array is empty. If the array can be empty in an expected way,
 * please use [reduceOrNull] instead. It returns `null` when its receiver is empty.
 * 
 * @param [operation] function that takes current accumulator value and an element, and calculates the next accumulator value.
 */
inline fun ULongBuffer.reduce(operation: (acc: ULong, ULong) -> ULong): ULong {
    if (isEmpty())
        throw UnsupportedOperationException("Empty array can't be reduced.")
    var accumulator = this[0]
    for (index in 1..lastIndex)
        accumulator = operation(accumulator, this[index])
    return accumulator
}
/**
 * Accumulates value starting with the first element and applying [operation] from left to right
 * to current accumulator value and each element with its index in the original array.
 * 
 * Throws an exception if this array is empty. If the array can be empty in an expected way,
 * please use [reduceIndexedOrNull] instead. It returns `null` when its receiver is empty.
 * 
 * @param [operation] function that takes the index of an element, current accumulator value and the element itself,
 * and calculates the next accumulator value.
 */
inline fun ULongBuffer.reduceIndexed(operation: (index: Int, acc: ULong, ULong) -> ULong): ULong {
    if (isEmpty())
        throw UnsupportedOperationException("Empty array can't be reduced.")
    var accumulator = this[0]
    for (index in 1..lastIndex)
        accumulator = operation(index, accumulator, this[index])
    return accumulator
}
/**
 * Accumulates value starting with the first element and applying [operation] from left to right
 * to current accumulator value and each element with its index in the original array.
 * 
 * Returns `null` if the array is empty.
 * 
 * @param [operation] function that takes the index of an element, current accumulator value and the element itself,
 * and calculates the next accumulator value.
 */
inline fun ULongBuffer.reduceIndexedOrNull(operation: (index: Int, acc: ULong, ULong) -> ULong): ULong? {
    if (isEmpty())
        return null
    var accumulator = this[0]
    for (index in 1..lastIndex)
        accumulator = operation(index, accumulator, this[index])
    return accumulator
}
/**
 * Accumulates value starting with the first element and applying [operation] from left to right to current accumulator value and each element.
 * 
 * Returns `null` if the array is empty.
 * 
 * @param [operation] function that takes current accumulator value and an element, and calculates the next accumulator value.
 */
inline fun ULongBuffer.reduceOrNull(operation: (acc: ULong, ULong) -> ULong): ULong? {
    if (isEmpty())
        return null
    var accumulator = this[0]
    for (index in 1..lastIndex)
        accumulator = operation(accumulator, this[index])
     return accumulator
}
/**
 * Accumulates value starting with the last element and applying [operation] from right to left to each element and current accumulator value.
 * 
 * Throws an exception if this array is empty. If the array can be empty in an expected way,
 * please use [reduceRightOrNull] instead. It returns `null` when its receiver is empty.
 * 
 * @param [operation] function that takes an element and current accumulator value, and calculates the next accumulator value.
 */
inline fun ULongBuffer.reduceRight(operation: (ULong, acc: ULong) -> ULong): ULong {
    var index = lastIndex
    if (index < 0) throw UnsupportedOperationException("Empty array can't be reduced.")
    var accumulator = get(index--)
    while (index >= 0)
        accumulator = operation(get(index--), accumulator)
    return accumulator
}
/**
 * Accumulates value starting with the last element and applying [operation] from right to left
 * to each element with its index in the original array and current accumulator value.
 * 
 * Throws an exception if this array is empty. If the array can be empty in an expected way,
 * please use [reduceRightIndexedOrNull] instead. It returns `null` when its receiver is empty.
 * 
 * @param [operation] function that takes the index of an element, the element itself and current accumulator value,
 * and calculates the next accumulator value.
 */
inline fun ULongBuffer.reduceRightIndexed(operation: (index: Int, ULong, acc: ULong) -> ULong): ULong {
    var index = lastIndex
    if (index < 0) throw UnsupportedOperationException("Empty array can't be reduced.")
    var accumulator = get(index--)
    while (index >= 0) {
        accumulator = operation(index, get(index), accumulator)
        --index
    }
    return accumulator
}
/**
 * Accumulates value starting with the last element and applying [operation] from right to left
 * to each element with its index in the original array and current accumulator value.
 * 
 * Returns `null` if the array is empty.
 * 
 * @param [operation] function that takes the index of an element, the element itself and current accumulator value,
 * and calculates the next accumulator value.
 */
inline fun ULongBuffer.reduceRightIndexedOrNull(operation: (index: Int, ULong, acc: ULong) -> ULong): ULong? {
    var index = lastIndex
    if (index < 0) return null
    var accumulator = get(index--)
    while (index >= 0) {
        accumulator = operation(index, get(index), accumulator)
        --index
    }
    return accumulator
}
/**
 * Accumulates value starting with the last element and applying [operation] from right to left to each element and current accumulator value.
 * 
 * Returns `null` if the array is empty.
 * 
 * @param [operation] function that takes an element and current accumulator value, and calculates the next accumulator value.
 */
inline fun ULongBuffer.reduceRightOrNull(operation: (ULong, acc: ULong) -> ULong): ULong? {
    var index = lastIndex
    if (index < 0) return null
    var accumulator = get(index--)
    while (index >= 0)
         accumulator = operation(get(index--), accumulator)
    return accumulator
}
/**
 * Splits the original array into pair of lists, where *first* list contains elements for which [predicate] 
 * yielded `true`, while *second* list contains elements for which [predicate] yielded `false`.
 */
inline fun ULongBuffer.partition(predicate: (ULong) -> Boolean): Pair<List<ULong>, List<ULong>> {
    val first = ArrayList<ULong>()
    val second = ArrayList<ULong>()
    for (element in this)
        if (predicate(element))
            first.add(element)
        else
            second.add(element)
    return Pair(first, second)
}
/**
 * Returns a list of pairs built from the elements of `this` array and the [other] array with the same index.
 * The returned list has length of the shortest collection.
 */
infix fun <R> ULongBuffer.zip(other: Array<out R>): List<Pair<ULong, R>> = zip(other) { t1, t2 -> t1 to t2 }
/**
 * Returns a list of values built from the elements of `this` array and the [other] array with the same index
 * using the provided [transform] function applied to each pair of elements.
 * The returned list has length of the shortest collection.
 */
inline fun <R, V> ULongBuffer.zip(other: Array<out R>, transform: (a: ULong, b: R) -> V): List<V> {
    val size = minOf(rem, other.size)
    val list = ArrayList<V>(size)
    for (i in 0 until size)
        list.add(transform(this[i], other[i]))
    return list
}
/**
 * Returns a list of pairs built from the elements of `this` collection and [other] array with the same index.
 * The returned list has length of the shortest collection.
 */
infix fun <R> ULongBuffer.zip(other: Iterable<R>): List<Pair<ULong, R>> = zip(other) { t1, t2 -> t1 to t2 }
/**
 * Returns a list of values built from the elements of `this` array and the [other] collection with the same index
 * using the provided [transform] function applied to each pair of elements.
 * The returned list has length of the shortest collection.
 */
inline fun <R, V> ULongBuffer.zip(other: Iterable<R>, transform: (a: ULong, b: R) -> V): List<V> {
    val arraySize = rem
    val list = ArrayList<V>(minOf(other.collectionSizeOrDefault(10), arraySize))
    var i = 0
    for (element in other) {
        if (i >= arraySize) break
        list.add(transform(this[i++], element))
    }
    return list
}
/**
 * Returns a list of pairs built from the elements of `this` array and the [other] array with the same index.
 * The returned list has length of the shortest collection.
 */
infix fun ULongBuffer.zip(other: ULongArray): List<Pair<ULong, ULong>> = zip(other) { t1, t2 -> t1 to t2 }
/**
 * Returns a list of values built from the elements of `this` array and the [other] array with the same index
 * using the provided [transform] function applied to each pair of elements.
 * The returned list has length of the shortest array.
 */
inline fun <V> ULongBuffer.zip(other: ULongArray, transform: (a: ULong, b: ULong) -> V): List<V> {
    val size = minOf(rem, other.size)
    val list = ArrayList<V>(size)
    for (i in 0 until size)
        list.add(transform(this[i], other[i]))
    return list
}
/**
 * Appends the string from all the elements separated using [separator] and using the given [prefix] and [postfix] if supplied.
 * 
 * If the collection could be huge, you can specify a non-negative value of [limit], in which case only the first [limit]
 * elements will be appended, followed by the [truncated] string (which defaults to "...").
 */
fun <A : Appendable> ULongBuffer.joinTo(buffer: A, separator: CharSequence = ", ", prefix: CharSequence = "", postfix: CharSequence = "", limit: Int = -1, truncated: CharSequence = "...", transform: ((ULong) -> CharSequence)? = null): A {
    buffer.append(prefix)
    var count = 0
    for (element in this) {
        if (++count > 1) buffer.append(separator)
        if (limit < 0 || count <= limit)
            if (transform != null)
                buffer.append(transform(element))
            else
                buffer.append(element.toString())
        else break
    }
    if (limit >= 0 && count > limit) buffer.append(truncated)
    buffer.append(postfix)
    return buffer
}
/**
 * Creates a string from all the elements separated using [separator] and using the given [prefix] and [postfix] if supplied.
 * 
 * If the collection could be huge, you can specify a non-negative value of [limit], in which case only the first [limit]
 * elements will be appended, followed by the [truncated] string (which defaults to "...").
 */
fun ULongBuffer.joinToString(separator: CharSequence = ", ", prefix: CharSequence = "", postfix: CharSequence = "", limit: Int = -1, truncated: CharSequence = "...", transform: ((ULong) -> CharSequence)? = null): String =
    joinTo(StringBuilder(), separator, prefix, postfix, limit, truncated, transform).toString()
/**
 * Returns 1st *element* from the buffer.
 * 
 * If the size of this array is less than 1, throws an [IndexOutOfBoundsException]
 */
inline operator fun FloatBuffer.component1(): Float = get(0)
/**
 * Returns 2nd *element* from the buffer.
 * 
 * If the size of this array is less than 2, throws an [IndexOutOfBoundsException]
 */
inline operator fun FloatBuffer.component2(): Float = get(1)
/**
 * Returns 3rd *element* from the buffer.
 * 
 * If the size of this array is less than 3, throws an [IndexOutOfBoundsException]
 */
inline operator fun FloatBuffer.component3(): Float = get(2)
/**
 * Returns 4th *element* from the buffer.
 * 
 * If the size of this array is less than 4, throws an [IndexOutOfBoundsException]
 */
inline operator fun FloatBuffer.component4(): Float = get(3)
/**
 * Returns 5th *element* from the buffer.
 * 
 * If the size of this array is less than 5, throws an [IndexOutOfBoundsException]
 */
inline operator fun FloatBuffer.component5(): Float = get(4)
/** Returns `true` if [element] is found in the array. */
operator fun FloatBuffer.contains(element: Float): Boolean = indexOf(element) >= 0
/** Returns an element at the given [index] or throws an [IndexOutOfBoundsException] if the [index] is out of bounds of this array. */
inline fun <T> FloatBuffer.elementAt(index: Int): Float = get(index)
/** Returns an element at the given [index] or the result of calling the [defaultValue] function if the [index] is out of bounds of this array. */
inline fun FloatBuffer.elementAtOrElse(index: Int, defaultValue: (Int) -> Float): Float = if (index >= 0 && index <= lastIndex) get(index) else defaultValue(index)
/** Returns an element at the given [index] or `null` if the [index] is out of bounds of this array. */
inline fun FloatBuffer.elementAtOrNull(index: Int): Float? = this.getOrNull(index)
/** Returns the first element matching the given [predicate], or `null` if no such element was found. */
inline fun FloatBuffer.find(predicate: (Float) -> Boolean): Float? = firstOrNull(predicate)
/** Returns the last element matching the given [predicate], or `null` if no such element was found. */
inline fun FloatBuffer.findLast(predicate: (Float) -> Boolean): Float? = lastOrNull(predicate)
/**
 * Returns the first element.
 * 
 * @throws NoSuchElementException if the array is empty.
 */
fun FloatBuffer.first(): Float {
    if (isEmpty())
        throw NoSuchElementException("Array is empty.")
    return this[0]
}
/**
 * Returns the first element matching the given [predicate].
 * @throws [NoSuchElementException] if no such element is found.
 */
inline fun FloatBuffer.first(predicate: (Float) -> Boolean): Float {
    for (element in this) if (predicate(element)) return element
    throw NoSuchElementException("Array contains no element matching the predicate.")
}
/** Returns the first element, or `null` if the array is empty. */
fun FloatBuffer.firstOrNull(): Float? = if (isEmpty()) null else this[0]
/** Returns the first element matching the given [predicate], or `null` if element was not found. */
inline fun FloatBuffer.firstOrNull(predicate: (Float) -> Boolean): Float? {
    for (element in this) if (predicate(element)) return element
    return null
}
/** Returns an element at the given [index] or the result of calling the [defaultValue] function if the [index] is out of bounds of this array. */
inline fun FloatBuffer.getOrElse(index: Int, defaultValue: (Int) -> Float): Float = if (index >= 0 && index <= lastIndex) get(index) else defaultValue(index)
/** Returns an element at the given [index] or `null` if the [index] is out of bounds of this array. */
fun FloatBuffer.getOrNull(index: Int): Float? = if (index >= 0 && index <= lastIndex) get(index) else null
/** Returns first index of [element], or -1 if the array does not contain element. */
fun FloatBuffer.indexOf(element: Float): Int {
    for (index in indices)
        if (element == this[index])
            return index
    return -1
}
/** Returns index of the first element matching the given [predicate], or -1 if the array does not contain such element. */
inline fun FloatBuffer.indexOfFirst(predicate: (Float) -> Boolean): Int {
    for (index in indices)
        if (predicate(this[index]))
            return index
    return -1
}
/** Returns index of the last element matching the given [predicate], or -1 if the array does not contain such element. */
inline fun FloatBuffer.indexOfLast(predicate: (Float) -> Boolean): Int {
    for (index in indices.reversed())
        if (predicate(this[index]))
            return index
    return -1
}
/**
 * Returns the last element.
 * 
 * @throws NoSuchElementException if the array is empty.
 */
fun FloatBuffer.last(): Float {
    if (isEmpty())
        throw NoSuchElementException("Array is empty.")
    return this[lastIndex]
}
/**
 * Returns the last element matching the given [predicate].
 * 
 * @throws NoSuchElementException if no such element is found.
 */
inline fun FloatBuffer.last(predicate: (Float) -> Boolean): Float {
    for (index in this.indices.reversed()) {
        val element = this[index]
        if (predicate(element)) return element
    }
    throw NoSuchElementException("Array contains no element matching the predicate.")
}
/** Returns last index of [element], or -1 if the array does not contain element. */
fun FloatBuffer.lastIndexOf(element: Float): Int {
    for (index in indices.reversed())
        if (element == this[index])
            return index
    return -1
}
/** Returns the last element, or `null` if the array is empty. */
fun FloatBuffer.lastOrNull(): Float? = if (isEmpty()) null else this[rem - 1]
/** Returns the last element matching the given [predicate], or `null` if no such element was found. */
inline fun FloatBuffer.lastOrNull(predicate: (Float) -> Boolean): Float? {
    for (index in this.indices.reversed()) {
        val element = this[index]
        if (predicate(element)) return element
    }
    return null
}
/** Returns the single element, or throws an exception if the array is empty or has more than one element. */
fun FloatBuffer.single(): Float = when (rem) {
    0 -> throw NoSuchElementException("Array is empty.")
    1 -> this[0]
    else -> throw IllegalArgumentException("Array has more than one element.")
}
/** Returns the single element matching the given [predicate], or throws exception if there is no or more than one matching element. */
inline fun FloatBuffer.single(predicate: (Float) -> Boolean): Float {
    var single: Float? = null
    var found = false
    for (element in this)
        if (predicate(element)) {
            if (found) throw IllegalArgumentException("Array contains more than one matching element.")
            single = element
            found = true
        }
    if (!found) throw NoSuchElementException("Array contains no element matching the predicate.")
    @Suppress("UNCHECKED_CAST")
    return single as Float
}
/** Returns single element, or `null` if the array is empty or has more than one element. */
fun FloatBuffer.singleOrNull(): Float? = if (rem == 1) this[0] else null
/** Returns the single element matching the given [predicate], or `null` if element was not found or more than one element was found. */
inline fun FloatBuffer.singleOrNull(predicate: (Float) -> Boolean): Float? {
    var single: Float? = null
    var found = false
    for (element in this)
        if (predicate(element)) {
            if (found) return null
            single = element
            found = true
        }
    if (!found) return null
    return single
}
/** Returns a list containing only elements matching the given [predicate]. */
inline fun FloatBuffer.filter(predicate: (Float) -> Boolean): List<Float> = filterTo(ArrayList<Float>(), predicate)
/**
 * Returns a list containing only elements matching the given [predicate].
 * @param [predicate] function that takes the index of an element and the element itself and returns the result of predicate evaluation on the element.
 */
inline fun FloatBuffer.filterIndexed(predicate: (index: Int, Float) -> Boolean): List<Float> = filterIndexedTo(ArrayList<Float>(), predicate)
/**
 * Appends all elements matching the given [predicate] to the given [destination].
 * @param [predicate] function that takes the index of an element and the element itself and returns the result of predicate evaluation on the element.
 */
inline fun <C : MutableCollection<in Float>> FloatBuffer.filterIndexedTo(destination: C, predicate: (index: Int, Float) -> Boolean): C {
    forEachIndexed { index, element ->
        if (predicate(index, element)) destination.add(element)
    }
    return destination
}
/** Returns a list containing all elements not matching the given [predicate]. */
inline fun FloatBuffer.filterNot(predicate: (Float) -> Boolean): List<Float> = filterNotTo(ArrayList<Float>(), predicate)
/** Appends all elements not matching the given [predicate] to the given [destination]. */
inline fun <C : MutableCollection<in Float>> FloatBuffer.filterNotTo(destination: C, predicate: (Float) -> Boolean): C {
     for (element in this) if (!predicate(element)) destination.add(element)
     return destination
}
/** Appends all elements matching the given [predicate] to the given [destination]. */
inline fun <C : MutableCollection<in Float>> FloatBuffer.filterTo(destination: C, predicate: (Float) -> Boolean): C {
     for (element in this) if (predicate(element)) destination.add(element)
     return destination
}
/** Returns a list containing elements at specified [indices]. */
fun FloatBuffer.slice(indices: Iterable<Int>): List<Float> {
    val size = indices.collectionSizeOrDefault(10)
    if (size == 0) return emptyList()
    val list = ArrayList<Float>(size)
    for (index in indices)
        list.add(get(index))
    return list
}
/** Returns an array containing elements of this array at specified [indices]. */
fun FloatBuffer.sliceArray(indices: Collection<Int>): FloatArray {
    val result = FloatArray(indices.size)
    var targetIndex = 0
    for (sourceIndex in indices)
        result[targetIndex++] = this[sourceIndex]
    return result
}
/** Sorts elements in the array in-place descending according to their natural sort order. */
fun FloatBuffer.sortDescending() {
    if (rem > 1) {
        val array = toFloatArray().apply{ sortDescending() }
        for (i in 0 until rem)
            this[pos + i] = array[i]
    }
}
/** Returns a list of all elements sorted according to their natural sort order. */
fun FloatBuffer.sorted(): List<Float> = toTypedArray().apply { sort() }.asList()
/** Returns an array with all elements of this array sorted according to their natural sort order. */
fun FloatBuffer.sortedArray(): FloatArray = toFloatArray().apply { sort() }
/** Returns an array with all elements of this array sorted descending according to their natural sort order. */
fun FloatBuffer.sortedArrayDescending(): FloatArray = toFloatArray().apply { sortDescending() }
/** Returns a list of all elements sorted according to natural sort order of the value returned by specified [selector] function. */
inline fun <R : Comparable<R>> FloatBuffer.sortedBy(crossinline selector: (Float) -> R?): List<Float> = toFloatArray().sortedWith(compareBy(selector))
/** Returns a list of all elements sorted descending according to natural sort order of the value returned by specified [selector] function. */
inline fun <R : Comparable<R>> FloatBuffer.sortedByDescending(crossinline selector: (Float) -> R?): List<Float> = toFloatArray().sortedWith(compareByDescending(selector))
/** Returns a list of all elements sorted descending according to their natural sort order. */
fun FloatBuffer.sortedDescending(): List<Float> = toFloatArray().apply { sort() }.reversed()
/** Returns a list of all elements sorted according to the specified [comparator]. */
fun FloatBuffer.sortedWith(comparator: Comparator<in Float>): List<Float> = toTypedArray().apply { sortWith(comparator) }.asList()
/** Sorts the array in-place. */
fun FloatBuffer.sort() {
    if (rem > 1) {
        val array = toFloatArray().apply{ sort() }
        for (i in 0 until rem)
            this[pos + i] = array[i]
    }
}
/** Returns a string representation of the contents of the specified array as if it is [List]. */
fun FloatBuffer.contentToString(): String {
    val iMax = lim - 1
    if (iMax == -1) return "[]"
    val b = StringBuilder()
    b.append('[')
    var i = 0
    while (true) {
        b.append(get(i))
        if (i == iMax) return b.append(']').toString()
        b.append(", ")
        i++
    }
}
/**
 * Fills this array or its subrange with the specified [element] value.
 * 
 * @param fromIndex the start of the range (inclusive) to fill, 0 by default.
 * @param toIndex the end of the range (exclusive) to fill, size of this array by default.
 * 
 * @throws IndexOutOfBoundsException if [fromIndex] is less than zero or [toIndex] is greater than the size of this array.
 * @throws IllegalArgumentException if [fromIndex] is greater than [toIndex].
 */
fun FloatBuffer.fill(element: Float, fromIndex: Int = pos, toIndex: Int = rem) {
    for (i in fromIndex until toIndex)
        this[i] = element
}
/** Returns the range of valid indices for the array. */
val FloatBuffer.indices: IntRange
    get() = IntRange(0, lastIndex)
/** Returns `true` if the array is empty. */
inline fun FloatBuffer.isEmpty(): Boolean = rem == 0
/** Returns `true` if the array is not empty. */
inline fun FloatBuffer.isNotEmpty(): Boolean = !isEmpty()
/** Returns the last valid index for the array. */
val FloatBuffer.lastIndex: Int
    get() = rem - 1
/** Returns an array of Byte containing all of the elements of this generic array. */
fun FloatBuffer.toFloatArray(): FloatArray = FloatArray(rem) { index -> this[index] }
/** Returns a *typed* object array containing all of the elements of this primitive array. */
fun FloatBuffer.toTypedArray(): Array<Float> = Array(rem) { index -> this[index] }
/**
 * Returns a [Map] containing key-value pairs provided by [transform] function applied to elements of the given array.
 * 
 * If any of two pairs would have the same key the last one gets added to the map.
 * 
 * The returned map preserves the entry iteration order of the original array.
 */
inline fun <K, V> FloatBuffer.associate(transform: (Float) -> Pair<K, V>): Map<K, V> {
    val capacity = mapCapacity(rem).coerceAtLeast(16)
    return associateTo(LinkedHashMap<K, V>(capacity), transform)
}
/**
 * Returns a [Map] containing the elements from the given array indexed by the key returned from [keySelector] function applied to each element.
 * 
 * If any two elements would have the same key returned by [keySelector] the last one gets added to the map.
 * 
 * The returned map preserves the entry iteration order of the original array.
 */
inline fun <K> FloatBuffer.associateBy(keySelector: (Float) -> K): Map<K, Float> {
    val capacity = mapCapacity(rem).coerceAtLeast(16)
    return associateByTo(LinkedHashMap<K, Float>(capacity), keySelector)
}
/**
 * Returns a [Map] containing the values provided by [valueTransform] and indexed by [keySelector] functions applied to elements of the given array.
 * 
 * If any two elements would have the same key returned by [keySelector] the last one gets added to the map.
 * 
 * The returned map preserves the entry iteration order of the original array.
 */
inline fun <K, V> FloatBuffer.associateBy(keySelector: (Float) -> K, valueTransform: (Float) -> V): Map<K, V> {
    val capacity = mapCapacity(rem).coerceAtLeast(16)
    return associateByTo(LinkedHashMap<K, V>(capacity), keySelector, valueTransform)
}
/**
 * Populates and returns the [destination] mutable map with key-value pairs, where key is provided by
 * the [keySelector] function applied to each element of the given array and value is the element itself.
 * 
 * If any two elements would have the same key returned by [keySelector] the last one gets added to the map.
 */
inline fun <K, M : MutableMap<in K, in Float>> FloatBuffer.associateByTo(destination: M, keySelector: (Float) -> K): M {
    for (element in this)
        destination.put(keySelector(element), element)
    return destination
}
/**
 * Populates and returns the [destination] mutable map with key-value pairs, where key is provided by the [keySelector]
 * function and and value is provided by the [valueTransform] function applied to elements of the given array.
 * 
 * If any two elements would have the same key returned by [keySelector] the last one gets added to the map.
 */
inline fun <K, V, M : MutableMap<in K, in V>> FloatBuffer.associateByTo(destination: M, keySelector: (Float) -> K, valueTransform: (Float) -> V): M {
    for (element in this)
        destination.put(keySelector(element), valueTransform(element))
    return destination
}
/**
 * Populates and returns the [destination] mutable map with key-value pairs provided by [transform] function
 * applied to each element of the given array.
 * 
 * If any of two pairs would have the same key the last one gets added to the map.
 */
inline fun <K, V, M : MutableMap<in K, in V>> FloatBuffer.associateTo(destination: M, transform: (Float) -> Pair<K, V>): M {
    for (element in this)
        destination += transform(element)
    return destination
}
/**
 * Returns a [Map] where keys are elements from the given array and values are produced by the [valueSelector] function applied to each element.
 * 
 * If any two elements are equal, the last one gets added to the map.
 * 
 * The returned map preserves the entry iteration order of the original array.
 */
inline fun <V> FloatBuffer.associateWith(valueSelector: (Float) -> V): Map<Float, V> {
    val result = LinkedHashMap<Float, V>(mapCapacity(rem).coerceAtLeast(16))
    return associateWithTo(result, valueSelector)
}
/**
 * Populates and returns the [destination] mutable map with key-value pairs for each element of the given array,
 * where key is the element itself and value is provided by the [valueSelector] function applied to that key.
 * 
 * If any two elements are equal, the last one overwrites the former value in the map.
 */
inline fun <V, M : MutableMap<in Float, in V>> FloatBuffer.associateWithTo(destination: M, valueSelector: (Float) -> V): M {
    for (element in this)
        destination.put(element, valueSelector(element))
    return destination
}
/** Appends all elements to the given [destination] collection. */
fun <C : MutableCollection<in Float>> FloatBuffer.toCollection(destination: C): C {
    for (item in this)
        destination.add(item)
    return destination
}
/** Returns a single list of all elements yielded from results of [transform] function being invoked on each element of original array. */
inline fun <R> FloatBuffer.flatMap(transform: (Float) -> Iterable<R>): List<R> = flatMapTo(ArrayList<R>(), transform)
/** Appends all elements yielded from results of [transform] function being invoked on each element of original array, to the given [destination]. */
inline fun <R, C : MutableCollection<in R>> FloatBuffer.flatMapTo(destination: C, transform: (Float) -> Iterable<R>): C {
    for (element in this) {
        val list = transform(element)
        destination.addAll(list)
    }
    return destination
}
/**
 * Groups elements of the original array by the key returned by the given [keySelector] function applied to
 * each element and returns a map where each group key is associated with a list of corresponding elements.
 * 
 * The returned map preserves the entry iteration order of the keys produced from the original array.
 */
inline fun <K> FloatBuffer.groupBy(keySelector: (Float) -> K): Map<K, List<Float>> = groupByTo(LinkedHashMap<K, MutableList<Float>>(), keySelector)
/**
 * Groups values returned by the [valueTransform] function applied to each element of the original array
 * by the key returned by the given [keySelector] function applied to the element
 * and returns a map where each group key is associated with a list of corresponding values.
 * 
 * The returned map preserves the entry iteration order of the keys produced from the original array.
 */
inline fun <K, V> FloatBuffer.groupBy(keySelector: (Float) -> K, valueTransform: (Float) -> V): Map<K, List<V>> = groupByTo(LinkedHashMap<K, MutableList<V>>(), keySelector, valueTransform)
/**
 * Groups elements of the original array by the key returned by the given [keySelector] function applied to each
 * element and puts to the [destination] map each group key associated with a list of corresponding elements.
 * 
 * @return The [destination] map.
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
 * Groups values returned by the [valueTransform] function applied to each element of the original array
 * by the key returned by the given [keySelector] function applied to the element
 * and puts to the [destination] map each group key associated with a list of corresponding values.
 * 
 * @return The [destination] map.
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
 * Returns a list containing only distinct elements from the given array.
 * 
 * The elements in the resulting list are in the same order as they were in the source array.
 */
fun FloatBuffer.distinct(): List<Float> = this.toMutableSet().toList()
/**
 * Returns a list containing only elements from the given array having distinct keys returned by the given [selector] function.
 * 
 * The elements in the resulting list are in the same order as they were in the source array.
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
 * Returns a new [MutableSet] containing all distinct elements from the given array.
 * 
 * The returned set preserves the element iteration order of the original array.
 */
fun FloatBuffer.toMutableSet(): MutableSet<Float> = toCollection(LinkedHashSet<Float>(mapCapacity(rem)))
/** Returns a list containing the results of applying the given [transform] function to each element in the original array. */
inline fun <R> FloatBuffer.map(transform: (Float) -> R): List<R> = mapTo(ArrayList<R>(rem), transform)
/**
 * Returns a list containing the results of applying the given [transform] function to each element and its index in the original array.
 * @param [transform] function that takes the index of an element and the element itself and returns the result of the transform applied to the element.
 */
inline fun <R> FloatBuffer.mapIndexed(transform: (index: Int, Float) -> R): List<R> = mapIndexedTo(ArrayList<R>(rem), transform)
/**
 * Applies the given [transform] function to each element and its index in the original array and appends the results to the given [destination].
 * @param [transform] function that takes the index of an element and the element itself and returns the result of the transform applied to the element.
 */
inline fun <R, C : MutableCollection<in R>> FloatBuffer.mapIndexedTo(destination: C, transform: (index: Int, Float) -> R): C {
    var index = 0
    for (item in this)
        destination.add(transform(index++, item))
    return destination
}
/** Applies the given [transform] function to each element of the original array and appends the results to the given [destination]. */
inline fun <R, C : MutableCollection<in R>> FloatBuffer.mapTo(destination: C, transform: (Float) -> R): C {
    for (item in this)
        destination.add(transform(item))
    return destination
}
/** Returns `true` if all elements match the given [predicate]. */
inline fun FloatBuffer.all(predicate: (Float) -> Boolean): Boolean {
    for (element in this) if (!predicate(element)) return false
    return true
}
/** Returns `true` if array has at least one element. */
fun FloatBuffer.any(): Boolean = !isEmpty()
/** Returns `true` if at least one element matches the given [predicate]. */
inline fun FloatBuffer.any(predicate: (Float) -> Boolean): Boolean {
    for (element in this) if (predicate(element)) return true
    return false
}
/** Returns the number of elements in this array. */
inline fun FloatBuffer.count(): Int = rem
/** Returns the number of elements matching the given [predicate]. */
inline fun FloatBuffer.count(predicate: (Float) -> Boolean): Int {
    var count = 0
    for (element in this) if (predicate(element)) ++count
    return count
}
/** Performs the given [action] on each element. */
inline fun FloatBuffer.forEach(action: (Float) -> Unit) { for (element in this) action(element) }
/**
 * Performs the given [action] on each element, providing sequential index with the element.
 * @param [action] function that takes the index of an element and the element itself and performs the action on the element.
 */
inline fun FloatBuffer.forEachIndexed(action: (index: Int, Float) -> Unit): Unit {
    var index = 0
    for (item in this) action(index++, item)
}
/**
 * Returns the largest element.
 * 
 * @throws NoSuchElementException if the array is empty.
 */
fun FloatBuffer.max(): Float {
    if (isEmpty()) throw NoSuchElementException()
    var max = this[0]
    for (i in 1..lastIndex) {
        val e = this[i]
        if (max < e) max = e
    }
    return max
}
/**
 * Returns the first element yielding the largest value of the given function.
 * 
 * @throws NoSuchElementException if the array is empty.
 */
inline fun <R : Comparable<R>> FloatBuffer.maxBy(selector: (Float) -> R): Float {
    if (isEmpty()) throw NoSuchElementException()
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
/** Returns the first element yielding the largest value of the given function or `null` if there are no elements. */
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
/** Returns the largest element or `null` if there are no elements. */
fun FloatBuffer.maxOrNull(): Float? {
    if (isEmpty()) return null
    var max = this[0]
    for (i in 1..lastIndex) {
        val e = this[i]
        if (max < e) max = e
    }
    return max
}
/**
 * Returns the first element having the largest value according to the provided [comparator].
 * 
 * @throws NoSuchElementException if the array is empty.
 */
fun FloatBuffer.maxWith(comparator: Comparator<in Float>): Float {
    if (isEmpty()) throw NoSuchElementException()
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
/**
 * Returns the smallest element.
 * 
 * @throws NoSuchElementException if the array is empty.
 */
fun FloatBuffer.min(): Float {
    if (isEmpty()) throw NoSuchElementException()
    var min = this[0]
    for (i in 1..lastIndex) {
        val e = this[i]
        if (min > e) min = e
    }
    return min
}
/**
 * Returns the first element yielding the smallest value of the given function.
 * 
 * @throws NoSuchElementException if the array is empty.
 */
inline fun <R : Comparable<R>> FloatBuffer.minBy(selector: (Float) -> R): Float {
    if (isEmpty()) throw NoSuchElementException()
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
 * Returns the first element yielding the smallest value of the given function or `null` if there are no elements.
 * 
 * @sample samples.collections.Collections.Aggregates.minByOrNull
 */
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
/**
 * Returns the smallest value among all values produced by [selector] function applied to each element in the array.
 * 
 * If any of values produced by [selector] function is `NaN`, the returned result is `NaN`.
 * 
 * @throws NoSuchElementException if the array is empty.
 */
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
 * Returns the smallest value among all values produced by [selector] function applied to each element in the array.
 * 
 * If any of values produced by [selector] function is `NaN`, the returned result is `NaN`.
 * 
 * @throws NoSuchElementException if the array is empty.
 */
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
 * Returns the smallest value among all values produced by [selector] function applied to each element in the array.
 * 
 * @throws NoSuchElementException if the array is empty.
 */
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
 * Returns the smallest value among all values produced by [selector] function applied to each element in the array or `null` if there are no elements.
 * 
 * If any of values produced by [selector] function is `NaN`, the returned result is `NaN`.
 */
inline fun FloatBuffer.minOfOrNull(selector: (Float) -> Double): Double? {
    if (isEmpty()) return null
    var minValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        minValue = minOf(minValue, v)
    }
    return minValue
}
/**
 * Returns the smallest value among all values produced by [selector] function applied to each element in the array or `null` if there are no elements.
 * 
 * If any of values produced by [selector] function is `NaN`, the returned result is `NaN`.
 */
inline fun FloatBuffer.minOfOrNull(selector: (Float) -> Float): Float? {
    if (isEmpty()) return null
    var minValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        minValue = minOf(minValue, v)
    }
    return minValue
}
/** Returns the smallest value among all values produced by [selector] function applied to each element in the array or `null` if there are no elements. */
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
/**
 * Returns the smallest value according to the provided [comparator] among all values produced by [selector] function applied to each element in the array.
 * 
 * @throws NoSuchElementException if the array is empty.
 */
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
/**
 * Returns the smallest value according to the provided [comparator] among all values produced by [selector]
 * function applied to each element in the array or `null` if there are no elements.
 */
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
/** Returns the smallest element or `null` if there are no elements. */
fun FloatBuffer.minOrNull(): Float? {
     if (isEmpty()) return null
     var min = this[0]
     for (i in 1..lastIndex) {
         val e = this[i]
         if (min > e) min = e
     }
     return min
 }
/**
 * Returns the first element having the smallest value according to the provided [comparator].
 * 
 * @throws NoSuchElementException if the array is empty.
 */
fun FloatBuffer.minWith(comparator: Comparator<in Float>): Float {
    if (isEmpty()) throw NoSuchElementException()
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
/** Returns `true` if the array has no elements. */
fun FloatBuffer.none(): Boolean = isEmpty()
/** Returns `true` if no elements match the given [predicate]. */
inline fun FloatBuffer.none(predicate: (Float) -> Boolean): Boolean {
    for (element in this) if (predicate(element)) return false
    return true
}
/** Performs the given [action] on each element and returns the array itself afterwards. */
inline fun FloatBuffer.onEach(action: (Float) -> Unit): FloatBuffer = apply { for (element in this) action(element) }
/**
 * Performs the given [action] on each element, providing sequential index with the element, and returns the array itself afterwards.
 * @param [action] function that takes the index of an element and the element itself and performs the action on the element.
 */
inline fun FloatBuffer.onEachIndexed(action: (index: Int, Float) -> Unit): FloatBuffer = apply { forEachIndexed(action) }
/**
 * Accumulates value starting with the first element and applying [operation] from left to right to current accumulator value and each element.
 * 
 * Throws an exception if this array is empty. If the array can be empty in an expected way,
 * please use [reduceOrNull] instead. It returns `null` when its receiver is empty.
 * 
 * @param [operation] function that takes current accumulator value and an element, and calculates the next accumulator value.
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
 * to current accumulator value and each element with its index in the original array.
 * 
 * Throws an exception if this array is empty. If the array can be empty in an expected way,
 * please use [reduceIndexedOrNull] instead. It returns `null` when its receiver is empty.
 * 
 * @param [operation] function that takes the index of an element, current accumulator value and the element itself,
 * and calculates the next accumulator value.
 */
inline fun FloatBuffer.reduceIndexed(operation: (index: Int, acc: Float, Float) -> Float): Float {
    if (isEmpty())
        throw UnsupportedOperationException("Empty array can't be reduced.")
    var accumulator = this[0]
    for (index in 1..lastIndex)
        accumulator = operation(index, accumulator, this[index])
    return accumulator
}
/**
 * Accumulates value starting with the first element and applying [operation] from left to right
 * to current accumulator value and each element with its index in the original array.
 * 
 * Returns `null` if the array is empty.
 * 
 * @param [operation] function that takes the index of an element, current accumulator value and the element itself,
 * and calculates the next accumulator value.
 */
inline fun FloatBuffer.reduceIndexedOrNull(operation: (index: Int, acc: Float, Float) -> Float): Float? {
    if (isEmpty())
        return null
    var accumulator = this[0]
    for (index in 1..lastIndex)
        accumulator = operation(index, accumulator, this[index])
    return accumulator
}
/**
 * Accumulates value starting with the first element and applying [operation] from left to right to current accumulator value and each element.
 * 
 * Returns `null` if the array is empty.
 * 
 * @param [operation] function that takes current accumulator value and an element, and calculates the next accumulator value.
 */
inline fun FloatBuffer.reduceOrNull(operation: (acc: Float, Float) -> Float): Float? {
    if (isEmpty())
        return null
    var accumulator = this[0]
    for (index in 1..lastIndex)
        accumulator = operation(accumulator, this[index])
     return accumulator
}
/**
 * Accumulates value starting with the last element and applying [operation] from right to left to each element and current accumulator value.
 * 
 * Throws an exception if this array is empty. If the array can be empty in an expected way,
 * please use [reduceRightOrNull] instead. It returns `null` when its receiver is empty.
 * 
 * @param [operation] function that takes an element and current accumulator value, and calculates the next accumulator value.
 */
inline fun FloatBuffer.reduceRight(operation: (Float, acc: Float) -> Float): Float {
    var index = lastIndex
    if (index < 0) throw UnsupportedOperationException("Empty array can't be reduced.")
    var accumulator = get(index--)
    while (index >= 0)
        accumulator = operation(get(index--), accumulator)
    return accumulator
}
/**
 * Accumulates value starting with the last element and applying [operation] from right to left
 * to each element with its index in the original array and current accumulator value.
 * 
 * Throws an exception if this array is empty. If the array can be empty in an expected way,
 * please use [reduceRightIndexedOrNull] instead. It returns `null` when its receiver is empty.
 * 
 * @param [operation] function that takes the index of an element, the element itself and current accumulator value,
 * and calculates the next accumulator value.
 */
inline fun FloatBuffer.reduceRightIndexed(operation: (index: Int, Float, acc: Float) -> Float): Float {
    var index = lastIndex
    if (index < 0) throw UnsupportedOperationException("Empty array can't be reduced.")
    var accumulator = get(index--)
    while (index >= 0) {
        accumulator = operation(index, get(index), accumulator)
        --index
    }
    return accumulator
}
/**
 * Accumulates value starting with the last element and applying [operation] from right to left
 * to each element with its index in the original array and current accumulator value.
 * 
 * Returns `null` if the array is empty.
 * 
 * @param [operation] function that takes the index of an element, the element itself and current accumulator value,
 * and calculates the next accumulator value.
 */
inline fun FloatBuffer.reduceRightIndexedOrNull(operation: (index: Int, Float, acc: Float) -> Float): Float? {
    var index = lastIndex
    if (index < 0) return null
    var accumulator = get(index--)
    while (index >= 0) {
        accumulator = operation(index, get(index), accumulator)
        --index
    }
    return accumulator
}
/**
 * Accumulates value starting with the last element and applying [operation] from right to left to each element and current accumulator value.
 * 
 * Returns `null` if the array is empty.
 * 
 * @param [operation] function that takes an element and current accumulator value, and calculates the next accumulator value.
 */
inline fun FloatBuffer.reduceRightOrNull(operation: (Float, acc: Float) -> Float): Float? {
    var index = lastIndex
    if (index < 0) return null
    var accumulator = get(index--)
    while (index >= 0)
         accumulator = operation(get(index--), accumulator)
    return accumulator
}
/**
 * Splits the original array into pair of lists, where *first* list contains elements for which [predicate] 
 * yielded `true`, while *second* list contains elements for which [predicate] yielded `false`.
 */
inline fun FloatBuffer.partition(predicate: (Float) -> Boolean): Pair<List<Float>, List<Float>> {
    val first = ArrayList<Float>()
    val second = ArrayList<Float>()
    for (element in this)
        if (predicate(element))
            first.add(element)
        else
            second.add(element)
    return Pair(first, second)
}
/**
 * Returns a list of pairs built from the elements of `this` array and the [other] array with the same index.
 * The returned list has length of the shortest collection.
 */
infix fun <R> FloatBuffer.zip(other: Array<out R>): List<Pair<Float, R>> = zip(other) { t1, t2 -> t1 to t2 }
/**
 * Returns a list of values built from the elements of `this` array and the [other] array with the same index
 * using the provided [transform] function applied to each pair of elements.
 * The returned list has length of the shortest collection.
 */
inline fun <R, V> FloatBuffer.zip(other: Array<out R>, transform: (a: Float, b: R) -> V): List<V> {
    val size = minOf(rem, other.size)
    val list = ArrayList<V>(size)
    for (i in 0 until size)
        list.add(transform(this[i], other[i]))
    return list
}
/**
 * Returns a list of pairs built from the elements of `this` collection and [other] array with the same index.
 * The returned list has length of the shortest collection.
 */
infix fun <R> FloatBuffer.zip(other: Iterable<R>): List<Pair<Float, R>> = zip(other) { t1, t2 -> t1 to t2 }
/**
 * Returns a list of values built from the elements of `this` array and the [other] collection with the same index
 * using the provided [transform] function applied to each pair of elements.
 * The returned list has length of the shortest collection.
 */
inline fun <R, V> FloatBuffer.zip(other: Iterable<R>, transform: (a: Float, b: R) -> V): List<V> {
    val arraySize = rem
    val list = ArrayList<V>(minOf(other.collectionSizeOrDefault(10), arraySize))
    var i = 0
    for (element in other) {
        if (i >= arraySize) break
        list.add(transform(this[i++], element))
    }
    return list
}
/**
 * Returns a list of pairs built from the elements of `this` array and the [other] array with the same index.
 * The returned list has length of the shortest collection.
 */
infix fun FloatBuffer.zip(other: FloatArray): List<Pair<Float, Float>> = zip(other) { t1, t2 -> t1 to t2 }
/**
 * Returns a list of values built from the elements of `this` array and the [other] array with the same index
 * using the provided [transform] function applied to each pair of elements.
 * The returned list has length of the shortest array.
 */
inline fun <V> FloatBuffer.zip(other: FloatArray, transform: (a: Float, b: Float) -> V): List<V> {
    val size = minOf(rem, other.size)
    val list = ArrayList<V>(size)
    for (i in 0 until size)
        list.add(transform(this[i], other[i]))
    return list
}
/**
 * Appends the string from all the elements separated using [separator] and using the given [prefix] and [postfix] if supplied.
 * 
 * If the collection could be huge, you can specify a non-negative value of [limit], in which case only the first [limit]
 * elements will be appended, followed by the [truncated] string (which defaults to "...").
 */
fun <A : Appendable> FloatBuffer.joinTo(buffer: A, separator: CharSequence = ", ", prefix: CharSequence = "", postfix: CharSequence = "", limit: Int = -1, truncated: CharSequence = "...", transform: ((Float) -> CharSequence)? = null): A {
    buffer.append(prefix)
    var count = 0
    for (element in this) {
        if (++count > 1) buffer.append(separator)
        if (limit < 0 || count <= limit)
            if (transform != null)
                buffer.append(transform(element))
            else
                buffer.append(element.toString())
        else break
    }
    if (limit >= 0 && count > limit) buffer.append(truncated)
    buffer.append(postfix)
    return buffer
}
/**
 * Creates a string from all the elements separated using [separator] and using the given [prefix] and [postfix] if supplied.
 * 
 * If the collection could be huge, you can specify a non-negative value of [limit], in which case only the first [limit]
 * elements will be appended, followed by the [truncated] string (which defaults to "...").
 */
fun FloatBuffer.joinToString(separator: CharSequence = ", ", prefix: CharSequence = "", postfix: CharSequence = "", limit: Int = -1, truncated: CharSequence = "...", transform: ((Float) -> CharSequence)? = null): String =
    joinTo(StringBuilder(), separator, prefix, postfix, limit, truncated, transform).toString()
/**
 * Returns 1st *element* from the buffer.
 * 
 * If the size of this array is less than 1, throws an [IndexOutOfBoundsException]
 */
inline operator fun DoubleBuffer.component1(): Double = get(0)
/**
 * Returns 2nd *element* from the buffer.
 * 
 * If the size of this array is less than 2, throws an [IndexOutOfBoundsException]
 */
inline operator fun DoubleBuffer.component2(): Double = get(1)
/**
 * Returns 3rd *element* from the buffer.
 * 
 * If the size of this array is less than 3, throws an [IndexOutOfBoundsException]
 */
inline operator fun DoubleBuffer.component3(): Double = get(2)
/**
 * Returns 4th *element* from the buffer.
 * 
 * If the size of this array is less than 4, throws an [IndexOutOfBoundsException]
 */
inline operator fun DoubleBuffer.component4(): Double = get(3)
/**
 * Returns 5th *element* from the buffer.
 * 
 * If the size of this array is less than 5, throws an [IndexOutOfBoundsException]
 */
inline operator fun DoubleBuffer.component5(): Double = get(4)
/** Returns `true` if [element] is found in the array. */
operator fun DoubleBuffer.contains(element: Double): Boolean = indexOf(element) >= 0
/** Returns an element at the given [index] or throws an [IndexOutOfBoundsException] if the [index] is out of bounds of this array. */
inline fun <T> DoubleBuffer.elementAt(index: Int): Double = get(index)
/** Returns an element at the given [index] or the result of calling the [defaultValue] function if the [index] is out of bounds of this array. */
inline fun DoubleBuffer.elementAtOrElse(index: Int, defaultValue: (Int) -> Double): Double = if (index >= 0 && index <= lastIndex) get(index) else defaultValue(index)
/** Returns an element at the given [index] or `null` if the [index] is out of bounds of this array. */
inline fun DoubleBuffer.elementAtOrNull(index: Int): Double? = this.getOrNull(index)
/** Returns the first element matching the given [predicate], or `null` if no such element was found. */
inline fun DoubleBuffer.find(predicate: (Double) -> Boolean): Double? = firstOrNull(predicate)
/** Returns the last element matching the given [predicate], or `null` if no such element was found. */
inline fun DoubleBuffer.findLast(predicate: (Double) -> Boolean): Double? = lastOrNull(predicate)
/**
 * Returns the first element.
 * 
 * @throws NoSuchElementException if the array is empty.
 */
fun DoubleBuffer.first(): Double {
    if (isEmpty())
        throw NoSuchElementException("Array is empty.")
    return this[0]
}
/**
 * Returns the first element matching the given [predicate].
 * @throws [NoSuchElementException] if no such element is found.
 */
inline fun DoubleBuffer.first(predicate: (Double) -> Boolean): Double {
    for (element in this) if (predicate(element)) return element
    throw NoSuchElementException("Array contains no element matching the predicate.")
}
/** Returns the first element, or `null` if the array is empty. */
fun DoubleBuffer.firstOrNull(): Double? = if (isEmpty()) null else this[0]
/** Returns the first element matching the given [predicate], or `null` if element was not found. */
inline fun DoubleBuffer.firstOrNull(predicate: (Double) -> Boolean): Double? {
    for (element in this) if (predicate(element)) return element
    return null
}
/** Returns an element at the given [index] or the result of calling the [defaultValue] function if the [index] is out of bounds of this array. */
inline fun DoubleBuffer.getOrElse(index: Int, defaultValue: (Int) -> Double): Double = if (index >= 0 && index <= lastIndex) get(index) else defaultValue(index)
/** Returns an element at the given [index] or `null` if the [index] is out of bounds of this array. */
fun DoubleBuffer.getOrNull(index: Int): Double? = if (index >= 0 && index <= lastIndex) get(index) else null
/** Returns first index of [element], or -1 if the array does not contain element. */
fun DoubleBuffer.indexOf(element: Double): Int {
    for (index in indices)
        if (element == this[index])
            return index
    return -1
}
/** Returns index of the first element matching the given [predicate], or -1 if the array does not contain such element. */
inline fun DoubleBuffer.indexOfFirst(predicate: (Double) -> Boolean): Int {
    for (index in indices)
        if (predicate(this[index]))
            return index
    return -1
}
/** Returns index of the last element matching the given [predicate], or -1 if the array does not contain such element. */
inline fun DoubleBuffer.indexOfLast(predicate: (Double) -> Boolean): Int {
    for (index in indices.reversed())
        if (predicate(this[index]))
            return index
    return -1
}
/**
 * Returns the last element.
 * 
 * @throws NoSuchElementException if the array is empty.
 */
fun DoubleBuffer.last(): Double {
    if (isEmpty())
        throw NoSuchElementException("Array is empty.")
    return this[lastIndex]
}
/**
 * Returns the last element matching the given [predicate].
 * 
 * @throws NoSuchElementException if no such element is found.
 */
inline fun DoubleBuffer.last(predicate: (Double) -> Boolean): Double {
    for (index in this.indices.reversed()) {
        val element = this[index]
        if (predicate(element)) return element
    }
    throw NoSuchElementException("Array contains no element matching the predicate.")
}
/** Returns last index of [element], or -1 if the array does not contain element. */
fun DoubleBuffer.lastIndexOf(element: Double): Int {
    for (index in indices.reversed())
        if (element == this[index])
            return index
    return -1
}
/** Returns the last element, or `null` if the array is empty. */
fun DoubleBuffer.lastOrNull(): Double? = if (isEmpty()) null else this[rem - 1]
/** Returns the last element matching the given [predicate], or `null` if no such element was found. */
inline fun DoubleBuffer.lastOrNull(predicate: (Double) -> Boolean): Double? {
    for (index in this.indices.reversed()) {
        val element = this[index]
        if (predicate(element)) return element
    }
    return null
}
/** Returns the single element, or throws an exception if the array is empty or has more than one element. */
fun DoubleBuffer.single(): Double = when (rem) {
    0 -> throw NoSuchElementException("Array is empty.")
    1 -> this[0]
    else -> throw IllegalArgumentException("Array has more than one element.")
}
/** Returns the single element matching the given [predicate], or throws exception if there is no or more than one matching element. */
inline fun DoubleBuffer.single(predicate: (Double) -> Boolean): Double {
    var single: Double? = null
    var found = false
    for (element in this)
        if (predicate(element)) {
            if (found) throw IllegalArgumentException("Array contains more than one matching element.")
            single = element
            found = true
        }
    if (!found) throw NoSuchElementException("Array contains no element matching the predicate.")
    @Suppress("UNCHECKED_CAST")
    return single as Double
}
/** Returns single element, or `null` if the array is empty or has more than one element. */
fun DoubleBuffer.singleOrNull(): Double? = if (rem == 1) this[0] else null
/** Returns the single element matching the given [predicate], or `null` if element was not found or more than one element was found. */
inline fun DoubleBuffer.singleOrNull(predicate: (Double) -> Boolean): Double? {
    var single: Double? = null
    var found = false
    for (element in this)
        if (predicate(element)) {
            if (found) return null
            single = element
            found = true
        }
    if (!found) return null
    return single
}
/** Returns a list containing only elements matching the given [predicate]. */
inline fun DoubleBuffer.filter(predicate: (Double) -> Boolean): List<Double> = filterTo(ArrayList<Double>(), predicate)
/**
 * Returns a list containing only elements matching the given [predicate].
 * @param [predicate] function that takes the index of an element and the element itself and returns the result of predicate evaluation on the element.
 */
inline fun DoubleBuffer.filterIndexed(predicate: (index: Int, Double) -> Boolean): List<Double> = filterIndexedTo(ArrayList<Double>(), predicate)
/**
 * Appends all elements matching the given [predicate] to the given [destination].
 * @param [predicate] function that takes the index of an element and the element itself and returns the result of predicate evaluation on the element.
 */
inline fun <C : MutableCollection<in Double>> DoubleBuffer.filterIndexedTo(destination: C, predicate: (index: Int, Double) -> Boolean): C {
    forEachIndexed { index, element ->
        if (predicate(index, element)) destination.add(element)
    }
    return destination
}
/** Returns a list containing all elements not matching the given [predicate]. */
inline fun DoubleBuffer.filterNot(predicate: (Double) -> Boolean): List<Double> = filterNotTo(ArrayList<Double>(), predicate)
/** Appends all elements not matching the given [predicate] to the given [destination]. */
inline fun <C : MutableCollection<in Double>> DoubleBuffer.filterNotTo(destination: C, predicate: (Double) -> Boolean): C {
     for (element in this) if (!predicate(element)) destination.add(element)
     return destination
}
/** Appends all elements matching the given [predicate] to the given [destination]. */
inline fun <C : MutableCollection<in Double>> DoubleBuffer.filterTo(destination: C, predicate: (Double) -> Boolean): C {
     for (element in this) if (predicate(element)) destination.add(element)
     return destination
}
/** Returns a list containing elements at specified [indices]. */
fun DoubleBuffer.slice(indices: Iterable<Int>): List<Double> {
    val size = indices.collectionSizeOrDefault(10)
    if (size == 0) return emptyList()
    val list = ArrayList<Double>(size)
    for (index in indices)
        list.add(get(index))
    return list
}
/** Returns an array containing elements of this array at specified [indices]. */
fun DoubleBuffer.sliceArray(indices: Collection<Int>): DoubleArray {
    val result = DoubleArray(indices.size)
    var targetIndex = 0
    for (sourceIndex in indices)
        result[targetIndex++] = this[sourceIndex]
    return result
}
/** Sorts elements in the array in-place descending according to their natural sort order. */
fun DoubleBuffer.sortDescending() {
    if (rem > 1) {
        val array = toDoubleArray().apply{ sortDescending() }
        for (i in 0 until rem)
            this[pos + i] = array[i]
    }
}
/** Returns a list of all elements sorted according to their natural sort order. */
fun DoubleBuffer.sorted(): List<Double> = toTypedArray().apply { sort() }.asList()
/** Returns an array with all elements of this array sorted according to their natural sort order. */
fun DoubleBuffer.sortedArray(): DoubleArray = toDoubleArray().apply { sort() }
/** Returns an array with all elements of this array sorted descending according to their natural sort order. */
fun DoubleBuffer.sortedArrayDescending(): DoubleArray = toDoubleArray().apply { sortDescending() }
/** Returns a list of all elements sorted according to natural sort order of the value returned by specified [selector] function. */
inline fun <R : Comparable<R>> DoubleBuffer.sortedBy(crossinline selector: (Double) -> R?): List<Double> = toDoubleArray().sortedWith(compareBy(selector))
/** Returns a list of all elements sorted descending according to natural sort order of the value returned by specified [selector] function. */
inline fun <R : Comparable<R>> DoubleBuffer.sortedByDescending(crossinline selector: (Double) -> R?): List<Double> = toDoubleArray().sortedWith(compareByDescending(selector))
/** Returns a list of all elements sorted descending according to their natural sort order. */
fun DoubleBuffer.sortedDescending(): List<Double> = toDoubleArray().apply { sort() }.reversed()
/** Returns a list of all elements sorted according to the specified [comparator]. */
fun DoubleBuffer.sortedWith(comparator: Comparator<in Double>): List<Double> = toTypedArray().apply { sortWith(comparator) }.asList()
/** Sorts the array in-place. */
fun DoubleBuffer.sort() {
    if (rem > 1) {
        val array = toDoubleArray().apply{ sort() }
        for (i in 0 until rem)
            this[pos + i] = array[i]
    }
}
/** Returns a string representation of the contents of the specified array as if it is [List]. */
fun DoubleBuffer.contentToString(): String {
    val iMax = lim - 1
    if (iMax == -1) return "[]"
    val b = StringBuilder()
    b.append('[')
    var i = 0
    while (true) {
        b.append(get(i))
        if (i == iMax) return b.append(']').toString()
        b.append(", ")
        i++
    }
}
/**
 * Fills this array or its subrange with the specified [element] value.
 * 
 * @param fromIndex the start of the range (inclusive) to fill, 0 by default.
 * @param toIndex the end of the range (exclusive) to fill, size of this array by default.
 * 
 * @throws IndexOutOfBoundsException if [fromIndex] is less than zero or [toIndex] is greater than the size of this array.
 * @throws IllegalArgumentException if [fromIndex] is greater than [toIndex].
 */
fun DoubleBuffer.fill(element: Double, fromIndex: Int = pos, toIndex: Int = rem) {
    for (i in fromIndex until toIndex)
        this[i] = element
}
/** Returns the range of valid indices for the array. */
val DoubleBuffer.indices: IntRange
    get() = IntRange(0, lastIndex)
/** Returns `true` if the array is empty. */
inline fun DoubleBuffer.isEmpty(): Boolean = rem == 0
/** Returns `true` if the array is not empty. */
inline fun DoubleBuffer.isNotEmpty(): Boolean = !isEmpty()
/** Returns the last valid index for the array. */
val DoubleBuffer.lastIndex: Int
    get() = rem - 1
/** Returns an array of Byte containing all of the elements of this generic array. */
fun DoubleBuffer.toDoubleArray(): DoubleArray = DoubleArray(rem) { index -> this[index] }
/** Returns a *typed* object array containing all of the elements of this primitive array. */
fun DoubleBuffer.toTypedArray(): Array<Double> = Array(rem) { index -> this[index] }
/**
 * Returns a [Map] containing key-value pairs provided by [transform] function applied to elements of the given array.
 * 
 * If any of two pairs would have the same key the last one gets added to the map.
 * 
 * The returned map preserves the entry iteration order of the original array.
 */
inline fun <K, V> DoubleBuffer.associate(transform: (Double) -> Pair<K, V>): Map<K, V> {
    val capacity = mapCapacity(rem).coerceAtLeast(16)
    return associateTo(LinkedHashMap<K, V>(capacity), transform)
}
/**
 * Returns a [Map] containing the elements from the given array indexed by the key returned from [keySelector] function applied to each element.
 * 
 * If any two elements would have the same key returned by [keySelector] the last one gets added to the map.
 * 
 * The returned map preserves the entry iteration order of the original array.
 */
inline fun <K> DoubleBuffer.associateBy(keySelector: (Double) -> K): Map<K, Double> {
    val capacity = mapCapacity(rem).coerceAtLeast(16)
    return associateByTo(LinkedHashMap<K, Double>(capacity), keySelector)
}
/**
 * Returns a [Map] containing the values provided by [valueTransform] and indexed by [keySelector] functions applied to elements of the given array.
 * 
 * If any two elements would have the same key returned by [keySelector] the last one gets added to the map.
 * 
 * The returned map preserves the entry iteration order of the original array.
 */
inline fun <K, V> DoubleBuffer.associateBy(keySelector: (Double) -> K, valueTransform: (Double) -> V): Map<K, V> {
    val capacity = mapCapacity(rem).coerceAtLeast(16)
    return associateByTo(LinkedHashMap<K, V>(capacity), keySelector, valueTransform)
}
/**
 * Populates and returns the [destination] mutable map with key-value pairs, where key is provided by
 * the [keySelector] function applied to each element of the given array and value is the element itself.
 * 
 * If any two elements would have the same key returned by [keySelector] the last one gets added to the map.
 */
inline fun <K, M : MutableMap<in K, in Double>> DoubleBuffer.associateByTo(destination: M, keySelector: (Double) -> K): M {
    for (element in this)
        destination.put(keySelector(element), element)
    return destination
}
/**
 * Populates and returns the [destination] mutable map with key-value pairs, where key is provided by the [keySelector]
 * function and and value is provided by the [valueTransform] function applied to elements of the given array.
 * 
 * If any two elements would have the same key returned by [keySelector] the last one gets added to the map.
 */
inline fun <K, V, M : MutableMap<in K, in V>> DoubleBuffer.associateByTo(destination: M, keySelector: (Double) -> K, valueTransform: (Double) -> V): M {
    for (element in this)
        destination.put(keySelector(element), valueTransform(element))
    return destination
}
/**
 * Populates and returns the [destination] mutable map with key-value pairs provided by [transform] function
 * applied to each element of the given array.
 * 
 * If any of two pairs would have the same key the last one gets added to the map.
 */
inline fun <K, V, M : MutableMap<in K, in V>> DoubleBuffer.associateTo(destination: M, transform: (Double) -> Pair<K, V>): M {
    for (element in this)
        destination += transform(element)
    return destination
}
/**
 * Returns a [Map] where keys are elements from the given array and values are produced by the [valueSelector] function applied to each element.
 * 
 * If any two elements are equal, the last one gets added to the map.
 * 
 * The returned map preserves the entry iteration order of the original array.
 */
inline fun <V> DoubleBuffer.associateWith(valueSelector: (Double) -> V): Map<Double, V> {
    val result = LinkedHashMap<Double, V>(mapCapacity(rem).coerceAtLeast(16))
    return associateWithTo(result, valueSelector)
}
/**
 * Populates and returns the [destination] mutable map with key-value pairs for each element of the given array,
 * where key is the element itself and value is provided by the [valueSelector] function applied to that key.
 * 
 * If any two elements are equal, the last one overwrites the former value in the map.
 */
inline fun <V, M : MutableMap<in Double, in V>> DoubleBuffer.associateWithTo(destination: M, valueSelector: (Double) -> V): M {
    for (element in this)
        destination.put(element, valueSelector(element))
    return destination
}
/** Appends all elements to the given [destination] collection. */
fun <C : MutableCollection<in Double>> DoubleBuffer.toCollection(destination: C): C {
    for (item in this)
        destination.add(item)
    return destination
}
/** Returns a single list of all elements yielded from results of [transform] function being invoked on each element of original array. */
inline fun <R> DoubleBuffer.flatMap(transform: (Double) -> Iterable<R>): List<R> = flatMapTo(ArrayList<R>(), transform)
/** Appends all elements yielded from results of [transform] function being invoked on each element of original array, to the given [destination]. */
inline fun <R, C : MutableCollection<in R>> DoubleBuffer.flatMapTo(destination: C, transform: (Double) -> Iterable<R>): C {
    for (element in this) {
        val list = transform(element)
        destination.addAll(list)
    }
    return destination
}
/**
 * Groups elements of the original array by the key returned by the given [keySelector] function applied to
 * each element and returns a map where each group key is associated with a list of corresponding elements.
 * 
 * The returned map preserves the entry iteration order of the keys produced from the original array.
 */
inline fun <K> DoubleBuffer.groupBy(keySelector: (Double) -> K): Map<K, List<Double>> = groupByTo(LinkedHashMap<K, MutableList<Double>>(), keySelector)
/**
 * Groups values returned by the [valueTransform] function applied to each element of the original array
 * by the key returned by the given [keySelector] function applied to the element
 * and returns a map where each group key is associated with a list of corresponding values.
 * 
 * The returned map preserves the entry iteration order of the keys produced from the original array.
 */
inline fun <K, V> DoubleBuffer.groupBy(keySelector: (Double) -> K, valueTransform: (Double) -> V): Map<K, List<V>> = groupByTo(LinkedHashMap<K, MutableList<V>>(), keySelector, valueTransform)
/**
 * Groups elements of the original array by the key returned by the given [keySelector] function applied to each
 * element and puts to the [destination] map each group key associated with a list of corresponding elements.
 * 
 * @return The [destination] map.
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
 * Groups values returned by the [valueTransform] function applied to each element of the original array
 * by the key returned by the given [keySelector] function applied to the element
 * and puts to the [destination] map each group key associated with a list of corresponding values.
 * 
 * @return The [destination] map.
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
 * Returns a list containing only distinct elements from the given array.
 * 
 * The elements in the resulting list are in the same order as they were in the source array.
 */
fun DoubleBuffer.distinct(): List<Double> = this.toMutableSet().toList()
/**
 * Returns a list containing only elements from the given array having distinct keys returned by the given [selector] function.
 * 
 * The elements in the resulting list are in the same order as they were in the source array.
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
 * Returns a new [MutableSet] containing all distinct elements from the given array.
 * 
 * The returned set preserves the element iteration order of the original array.
 */
fun DoubleBuffer.toMutableSet(): MutableSet<Double> = toCollection(LinkedHashSet<Double>(mapCapacity(rem)))
/** Returns a list containing the results of applying the given [transform] function to each element in the original array. */
inline fun <R> DoubleBuffer.map(transform: (Double) -> R): List<R> = mapTo(ArrayList<R>(rem), transform)
/**
 * Returns a list containing the results of applying the given [transform] function to each element and its index in the original array.
 * @param [transform] function that takes the index of an element and the element itself and returns the result of the transform applied to the element.
 */
inline fun <R> DoubleBuffer.mapIndexed(transform: (index: Int, Double) -> R): List<R> = mapIndexedTo(ArrayList<R>(rem), transform)
/**
 * Applies the given [transform] function to each element and its index in the original array and appends the results to the given [destination].
 * @param [transform] function that takes the index of an element and the element itself and returns the result of the transform applied to the element.
 */
inline fun <R, C : MutableCollection<in R>> DoubleBuffer.mapIndexedTo(destination: C, transform: (index: Int, Double) -> R): C {
    var index = 0
    for (item in this)
        destination.add(transform(index++, item))
    return destination
}
/** Applies the given [transform] function to each element of the original array and appends the results to the given [destination]. */
inline fun <R, C : MutableCollection<in R>> DoubleBuffer.mapTo(destination: C, transform: (Double) -> R): C {
    for (item in this)
        destination.add(transform(item))
    return destination
}
/** Returns `true` if all elements match the given [predicate]. */
inline fun DoubleBuffer.all(predicate: (Double) -> Boolean): Boolean {
    for (element in this) if (!predicate(element)) return false
    return true
}
/** Returns `true` if array has at least one element. */
fun DoubleBuffer.any(): Boolean = !isEmpty()
/** Returns `true` if at least one element matches the given [predicate]. */
inline fun DoubleBuffer.any(predicate: (Double) -> Boolean): Boolean {
    for (element in this) if (predicate(element)) return true
    return false
}
/** Returns the number of elements in this array. */
inline fun DoubleBuffer.count(): Int = rem
/** Returns the number of elements matching the given [predicate]. */
inline fun DoubleBuffer.count(predicate: (Double) -> Boolean): Int {
    var count = 0
    for (element in this) if (predicate(element)) ++count
    return count
}
/** Performs the given [action] on each element. */
inline fun DoubleBuffer.forEach(action: (Double) -> Unit) { for (element in this) action(element) }
/**
 * Performs the given [action] on each element, providing sequential index with the element.
 * @param [action] function that takes the index of an element and the element itself and performs the action on the element.
 */
inline fun DoubleBuffer.forEachIndexed(action: (index: Int, Double) -> Unit): Unit {
    var index = 0
    for (item in this) action(index++, item)
}
/**
 * Returns the largest element.
 * 
 * @throws NoSuchElementException if the array is empty.
 */
fun DoubleBuffer.max(): Double {
    if (isEmpty()) throw NoSuchElementException()
    var max = this[0]
    for (i in 1..lastIndex) {
        val e = this[i]
        if (max < e) max = e
    }
    return max
}
/**
 * Returns the first element yielding the largest value of the given function.
 * 
 * @throws NoSuchElementException if the array is empty.
 */
inline fun <R : Comparable<R>> DoubleBuffer.maxBy(selector: (Double) -> R): Double {
    if (isEmpty()) throw NoSuchElementException()
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
/** Returns the first element yielding the largest value of the given function or `null` if there are no elements. */
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
/** Returns the largest element or `null` if there are no elements. */
fun DoubleBuffer.maxOrNull(): Double? {
    if (isEmpty()) return null
    var max = this[0]
    for (i in 1..lastIndex) {
        val e = this[i]
        if (max < e) max = e
    }
    return max
}
/**
 * Returns the first element having the largest value according to the provided [comparator].
 * 
 * @throws NoSuchElementException if the array is empty.
 */
fun DoubleBuffer.maxWith(comparator: Comparator<in Double>): Double {
    if (isEmpty()) throw NoSuchElementException()
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
/**
 * Returns the smallest element.
 * 
 * @throws NoSuchElementException if the array is empty.
 */
fun DoubleBuffer.min(): Double {
    if (isEmpty()) throw NoSuchElementException()
    var min = this[0]
    for (i in 1..lastIndex) {
        val e = this[i]
        if (min > e) min = e
    }
    return min
}
/**
 * Returns the first element yielding the smallest value of the given function.
 * 
 * @throws NoSuchElementException if the array is empty.
 */
inline fun <R : Comparable<R>> DoubleBuffer.minBy(selector: (Double) -> R): Double {
    if (isEmpty()) throw NoSuchElementException()
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
 * Returns the first element yielding the smallest value of the given function or `null` if there are no elements.
 * 
 * @sample samples.collections.Collections.Aggregates.minByOrNull
 */
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
/**
 * Returns the smallest value among all values produced by [selector] function applied to each element in the array.
 * 
 * If any of values produced by [selector] function is `NaN`, the returned result is `NaN`.
 * 
 * @throws NoSuchElementException if the array is empty.
 */
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
 * Returns the smallest value among all values produced by [selector] function applied to each element in the array.
 * 
 * If any of values produced by [selector] function is `NaN`, the returned result is `NaN`.
 * 
 * @throws NoSuchElementException if the array is empty.
 */
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
 * Returns the smallest value among all values produced by [selector] function applied to each element in the array.
 * 
 * @throws NoSuchElementException if the array is empty.
 */
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
 * Returns the smallest value among all values produced by [selector] function applied to each element in the array or `null` if there are no elements.
 * 
 * If any of values produced by [selector] function is `NaN`, the returned result is `NaN`.
 */
inline fun DoubleBuffer.minOfOrNull(selector: (Double) -> Double): Double? {
    if (isEmpty()) return null
    var minValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        minValue = minOf(minValue, v)
    }
    return minValue
}
/**
 * Returns the smallest value among all values produced by [selector] function applied to each element in the array or `null` if there are no elements.
 * 
 * If any of values produced by [selector] function is `NaN`, the returned result is `NaN`.
 */
inline fun DoubleBuffer.minOfOrNull(selector: (Double) -> Float): Float? {
    if (isEmpty()) return null
    var minValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        minValue = minOf(minValue, v)
    }
    return minValue
}
/** Returns the smallest value among all values produced by [selector] function applied to each element in the array or `null` if there are no elements. */
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
/**
 * Returns the smallest value according to the provided [comparator] among all values produced by [selector] function applied to each element in the array.
 * 
 * @throws NoSuchElementException if the array is empty.
 */
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
/**
 * Returns the smallest value according to the provided [comparator] among all values produced by [selector]
 * function applied to each element in the array or `null` if there are no elements.
 */
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
/** Returns the smallest element or `null` if there are no elements. */
fun DoubleBuffer.minOrNull(): Double? {
     if (isEmpty()) return null
     var min = this[0]
     for (i in 1..lastIndex) {
         val e = this[i]
         if (min > e) min = e
     }
     return min
 }
/**
 * Returns the first element having the smallest value according to the provided [comparator].
 * 
 * @throws NoSuchElementException if the array is empty.
 */
fun DoubleBuffer.minWith(comparator: Comparator<in Double>): Double {
    if (isEmpty()) throw NoSuchElementException()
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
/** Returns `true` if the array has no elements. */
fun DoubleBuffer.none(): Boolean = isEmpty()
/** Returns `true` if no elements match the given [predicate]. */
inline fun DoubleBuffer.none(predicate: (Double) -> Boolean): Boolean {
    for (element in this) if (predicate(element)) return false
    return true
}
/** Performs the given [action] on each element and returns the array itself afterwards. */
inline fun DoubleBuffer.onEach(action: (Double) -> Unit): DoubleBuffer = apply { for (element in this) action(element) }
/**
 * Performs the given [action] on each element, providing sequential index with the element, and returns the array itself afterwards.
 * @param [action] function that takes the index of an element and the element itself and performs the action on the element.
 */
inline fun DoubleBuffer.onEachIndexed(action: (index: Int, Double) -> Unit): DoubleBuffer = apply { forEachIndexed(action) }
/**
 * Accumulates value starting with the first element and applying [operation] from left to right to current accumulator value and each element.
 * 
 * Throws an exception if this array is empty. If the array can be empty in an expected way,
 * please use [reduceOrNull] instead. It returns `null` when its receiver is empty.
 * 
 * @param [operation] function that takes current accumulator value and an element, and calculates the next accumulator value.
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
 * to current accumulator value and each element with its index in the original array.
 * 
 * Throws an exception if this array is empty. If the array can be empty in an expected way,
 * please use [reduceIndexedOrNull] instead. It returns `null` when its receiver is empty.
 * 
 * @param [operation] function that takes the index of an element, current accumulator value and the element itself,
 * and calculates the next accumulator value.
 */
inline fun DoubleBuffer.reduceIndexed(operation: (index: Int, acc: Double, Double) -> Double): Double {
    if (isEmpty())
        throw UnsupportedOperationException("Empty array can't be reduced.")
    var accumulator = this[0]
    for (index in 1..lastIndex)
        accumulator = operation(index, accumulator, this[index])
    return accumulator
}
/**
 * Accumulates value starting with the first element and applying [operation] from left to right
 * to current accumulator value and each element with its index in the original array.
 * 
 * Returns `null` if the array is empty.
 * 
 * @param [operation] function that takes the index of an element, current accumulator value and the element itself,
 * and calculates the next accumulator value.
 */
inline fun DoubleBuffer.reduceIndexedOrNull(operation: (index: Int, acc: Double, Double) -> Double): Double? {
    if (isEmpty())
        return null
    var accumulator = this[0]
    for (index in 1..lastIndex)
        accumulator = operation(index, accumulator, this[index])
    return accumulator
}
/**
 * Accumulates value starting with the first element and applying [operation] from left to right to current accumulator value and each element.
 * 
 * Returns `null` if the array is empty.
 * 
 * @param [operation] function that takes current accumulator value and an element, and calculates the next accumulator value.
 */
inline fun DoubleBuffer.reduceOrNull(operation: (acc: Double, Double) -> Double): Double? {
    if (isEmpty())
        return null
    var accumulator = this[0]
    for (index in 1..lastIndex)
        accumulator = operation(accumulator, this[index])
     return accumulator
}
/**
 * Accumulates value starting with the last element and applying [operation] from right to left to each element and current accumulator value.
 * 
 * Throws an exception if this array is empty. If the array can be empty in an expected way,
 * please use [reduceRightOrNull] instead. It returns `null` when its receiver is empty.
 * 
 * @param [operation] function that takes an element and current accumulator value, and calculates the next accumulator value.
 */
inline fun DoubleBuffer.reduceRight(operation: (Double, acc: Double) -> Double): Double {
    var index = lastIndex
    if (index < 0) throw UnsupportedOperationException("Empty array can't be reduced.")
    var accumulator = get(index--)
    while (index >= 0)
        accumulator = operation(get(index--), accumulator)
    return accumulator
}
/**
 * Accumulates value starting with the last element and applying [operation] from right to left
 * to each element with its index in the original array and current accumulator value.
 * 
 * Throws an exception if this array is empty. If the array can be empty in an expected way,
 * please use [reduceRightIndexedOrNull] instead. It returns `null` when its receiver is empty.
 * 
 * @param [operation] function that takes the index of an element, the element itself and current accumulator value,
 * and calculates the next accumulator value.
 */
inline fun DoubleBuffer.reduceRightIndexed(operation: (index: Int, Double, acc: Double) -> Double): Double {
    var index = lastIndex
    if (index < 0) throw UnsupportedOperationException("Empty array can't be reduced.")
    var accumulator = get(index--)
    while (index >= 0) {
        accumulator = operation(index, get(index), accumulator)
        --index
    }
    return accumulator
}
/**
 * Accumulates value starting with the last element and applying [operation] from right to left
 * to each element with its index in the original array and current accumulator value.
 * 
 * Returns `null` if the array is empty.
 * 
 * @param [operation] function that takes the index of an element, the element itself and current accumulator value,
 * and calculates the next accumulator value.
 */
inline fun DoubleBuffer.reduceRightIndexedOrNull(operation: (index: Int, Double, acc: Double) -> Double): Double? {
    var index = lastIndex
    if (index < 0) return null
    var accumulator = get(index--)
    while (index >= 0) {
        accumulator = operation(index, get(index), accumulator)
        --index
    }
    return accumulator
}
/**
 * Accumulates value starting with the last element and applying [operation] from right to left to each element and current accumulator value.
 * 
 * Returns `null` if the array is empty.
 * 
 * @param [operation] function that takes an element and current accumulator value, and calculates the next accumulator value.
 */
inline fun DoubleBuffer.reduceRightOrNull(operation: (Double, acc: Double) -> Double): Double? {
    var index = lastIndex
    if (index < 0) return null
    var accumulator = get(index--)
    while (index >= 0)
         accumulator = operation(get(index--), accumulator)
    return accumulator
}
/**
 * Splits the original array into pair of lists, where *first* list contains elements for which [predicate] 
 * yielded `true`, while *second* list contains elements for which [predicate] yielded `false`.
 */
inline fun DoubleBuffer.partition(predicate: (Double) -> Boolean): Pair<List<Double>, List<Double>> {
    val first = ArrayList<Double>()
    val second = ArrayList<Double>()
    for (element in this)
        if (predicate(element))
            first.add(element)
        else
            second.add(element)
    return Pair(first, second)
}
/**
 * Returns a list of pairs built from the elements of `this` array and the [other] array with the same index.
 * The returned list has length of the shortest collection.
 */
infix fun <R> DoubleBuffer.zip(other: Array<out R>): List<Pair<Double, R>> = zip(other) { t1, t2 -> t1 to t2 }
/**
 * Returns a list of values built from the elements of `this` array and the [other] array with the same index
 * using the provided [transform] function applied to each pair of elements.
 * The returned list has length of the shortest collection.
 */
inline fun <R, V> DoubleBuffer.zip(other: Array<out R>, transform: (a: Double, b: R) -> V): List<V> {
    val size = minOf(rem, other.size)
    val list = ArrayList<V>(size)
    for (i in 0 until size)
        list.add(transform(this[i], other[i]))
    return list
}
/**
 * Returns a list of pairs built from the elements of `this` collection and [other] array with the same index.
 * The returned list has length of the shortest collection.
 */
infix fun <R> DoubleBuffer.zip(other: Iterable<R>): List<Pair<Double, R>> = zip(other) { t1, t2 -> t1 to t2 }
/**
 * Returns a list of values built from the elements of `this` array and the [other] collection with the same index
 * using the provided [transform] function applied to each pair of elements.
 * The returned list has length of the shortest collection.
 */
inline fun <R, V> DoubleBuffer.zip(other: Iterable<R>, transform: (a: Double, b: R) -> V): List<V> {
    val arraySize = rem
    val list = ArrayList<V>(minOf(other.collectionSizeOrDefault(10), arraySize))
    var i = 0
    for (element in other) {
        if (i >= arraySize) break
        list.add(transform(this[i++], element))
    }
    return list
}
/**
 * Returns a list of pairs built from the elements of `this` array and the [other] array with the same index.
 * The returned list has length of the shortest collection.
 */
infix fun DoubleBuffer.zip(other: DoubleArray): List<Pair<Double, Double>> = zip(other) { t1, t2 -> t1 to t2 }
/**
 * Returns a list of values built from the elements of `this` array and the [other] array with the same index
 * using the provided [transform] function applied to each pair of elements.
 * The returned list has length of the shortest array.
 */
inline fun <V> DoubleBuffer.zip(other: DoubleArray, transform: (a: Double, b: Double) -> V): List<V> {
    val size = minOf(rem, other.size)
    val list = ArrayList<V>(size)
    for (i in 0 until size)
        list.add(transform(this[i], other[i]))
    return list
}
/**
 * Appends the string from all the elements separated using [separator] and using the given [prefix] and [postfix] if supplied.
 * 
 * If the collection could be huge, you can specify a non-negative value of [limit], in which case only the first [limit]
 * elements will be appended, followed by the [truncated] string (which defaults to "...").
 */
fun <A : Appendable> DoubleBuffer.joinTo(buffer: A, separator: CharSequence = ", ", prefix: CharSequence = "", postfix: CharSequence = "", limit: Int = -1, truncated: CharSequence = "...", transform: ((Double) -> CharSequence)? = null): A {
    buffer.append(prefix)
    var count = 0
    for (element in this) {
        if (++count > 1) buffer.append(separator)
        if (limit < 0 || count <= limit)
            if (transform != null)
                buffer.append(transform(element))
            else
                buffer.append(element.toString())
        else break
    }
    if (limit >= 0 && count > limit) buffer.append(truncated)
    buffer.append(postfix)
    return buffer
}
/**
 * Creates a string from all the elements separated using [separator] and using the given [prefix] and [postfix] if supplied.
 * 
 * If the collection could be huge, you can specify a non-negative value of [limit], in which case only the first [limit]
 * elements will be appended, followed by the [truncated] string (which defaults to "...").
 */
fun DoubleBuffer.joinToString(separator: CharSequence = ", ", prefix: CharSequence = "", postfix: CharSequence = "", limit: Int = -1, truncated: CharSequence = "...", transform: ((Double) -> CharSequence)? = null): String =
    joinTo(StringBuilder(), separator, prefix, postfix, limit, truncated, transform).toString()
/**
 * Returns 1st *element* from the buffer.
 * 
 * If the size of this array is less than 1, throws an [IndexOutOfBoundsException]
 */
inline operator fun PointerBuffer.component1(): Long = get(0)
/**
 * Returns 2nd *element* from the buffer.
 * 
 * If the size of this array is less than 2, throws an [IndexOutOfBoundsException]
 */
inline operator fun PointerBuffer.component2(): Long = get(1)
/**
 * Returns 3rd *element* from the buffer.
 * 
 * If the size of this array is less than 3, throws an [IndexOutOfBoundsException]
 */
inline operator fun PointerBuffer.component3(): Long = get(2)
/**
 * Returns 4th *element* from the buffer.
 * 
 * If the size of this array is less than 4, throws an [IndexOutOfBoundsException]
 */
inline operator fun PointerBuffer.component4(): Long = get(3)
/**
 * Returns 5th *element* from the buffer.
 * 
 * If the size of this array is less than 5, throws an [IndexOutOfBoundsException]
 */
inline operator fun PointerBuffer.component5(): Long = get(4)
/** Returns `true` if [element] is found in the array. */
operator fun PointerBuffer.contains(element: Long): Boolean = indexOf(element) >= 0
/** Returns an element at the given [index] or throws an [IndexOutOfBoundsException] if the [index] is out of bounds of this array. */
inline fun <T> PointerBuffer.elementAt(index: Int): Long = get(index)
/** Returns an element at the given [index] or the result of calling the [defaultValue] function if the [index] is out of bounds of this array. */
inline fun PointerBuffer.elementAtOrElse(index: Int, defaultValue: (Int) -> Long): Long = if (index >= 0 && index <= lastIndex) get(index) else defaultValue(index)
/** Returns an element at the given [index] or `null` if the [index] is out of bounds of this array. */
inline fun PointerBuffer.elementAtOrNull(index: Int): Long? = this.getOrNull(index)
/** Returns the first element matching the given [predicate], or `null` if no such element was found. */
inline fun PointerBuffer.find(predicate: (Long) -> Boolean): Long? = firstOrNull(predicate)
/** Returns the last element matching the given [predicate], or `null` if no such element was found. */
inline fun PointerBuffer.findLast(predicate: (Long) -> Boolean): Long? = lastOrNull(predicate)
/**
 * Returns the first element.
 * 
 * @throws NoSuchElementException if the array is empty.
 */
fun PointerBuffer.first(): Long {
    if (isEmpty())
        throw NoSuchElementException("Array is empty.")
    return this[0]
}
/**
 * Returns the first element matching the given [predicate].
 * @throws [NoSuchElementException] if no such element is found.
 */
inline fun PointerBuffer.first(predicate: (Long) -> Boolean): Long {
    for (element in this) if (predicate(element)) return element
    throw NoSuchElementException("Array contains no element matching the predicate.")
}
/** Returns the first element, or `null` if the array is empty. */
fun PointerBuffer.firstOrNull(): Long? = if (isEmpty()) null else this[0]
/** Returns the first element matching the given [predicate], or `null` if element was not found. */
inline fun PointerBuffer.firstOrNull(predicate: (Long) -> Boolean): Long? {
    for (element in this) if (predicate(element)) return element
    return null
}
/** Returns an element at the given [index] or the result of calling the [defaultValue] function if the [index] is out of bounds of this array. */
inline fun PointerBuffer.getOrElse(index: Int, defaultValue: (Int) -> Long): Long = if (index >= 0 && index <= lastIndex) get(index) else defaultValue(index)
/** Returns an element at the given [index] or `null` if the [index] is out of bounds of this array. */
fun PointerBuffer.getOrNull(index: Int): Long? = if (index >= 0 && index <= lastIndex) get(index) else null
/** Returns first index of [element], or -1 if the array does not contain element. */
fun PointerBuffer.indexOf(element: Long): Int {
    for (index in indices)
        if (element == this[index])
            return index
    return -1
}
/** Returns index of the first element matching the given [predicate], or -1 if the array does not contain such element. */
inline fun PointerBuffer.indexOfFirst(predicate: (Long) -> Boolean): Int {
    for (index in indices)
        if (predicate(this[index]))
            return index
    return -1
}
/** Returns index of the last element matching the given [predicate], or -1 if the array does not contain such element. */
inline fun PointerBuffer.indexOfLast(predicate: (Long) -> Boolean): Int {
    for (index in indices.reversed())
        if (predicate(this[index]))
            return index
    return -1
}
/**
 * Returns the last element.
 * 
 * @throws NoSuchElementException if the array is empty.
 */
fun PointerBuffer.last(): Long {
    if (isEmpty())
        throw NoSuchElementException("Array is empty.")
    return this[lastIndex]
}
/**
 * Returns the last element matching the given [predicate].
 * 
 * @throws NoSuchElementException if no such element is found.
 */
inline fun PointerBuffer.last(predicate: (Long) -> Boolean): Long {
    for (index in this.indices.reversed()) {
        val element = this[index]
        if (predicate(element)) return element
    }
    throw NoSuchElementException("Array contains no element matching the predicate.")
}
/** Returns last index of [element], or -1 if the array does not contain element. */
fun PointerBuffer.lastIndexOf(element: Long): Int {
    for (index in indices.reversed())
        if (element == this[index])
            return index
    return -1
}
/** Returns the last element, or `null` if the array is empty. */
fun PointerBuffer.lastOrNull(): Long? = if (isEmpty()) null else this[rem - 1]
/** Returns the last element matching the given [predicate], or `null` if no such element was found. */
inline fun PointerBuffer.lastOrNull(predicate: (Long) -> Boolean): Long? {
    for (index in this.indices.reversed()) {
        val element = this[index]
        if (predicate(element)) return element
    }
    return null
}
/** Returns the single element, or throws an exception if the array is empty or has more than one element. */
fun PointerBuffer.single(): Long = when (rem) {
    0 -> throw NoSuchElementException("Array is empty.")
    1 -> this[0]
    else -> throw IllegalArgumentException("Array has more than one element.")
}
/** Returns the single element matching the given [predicate], or throws exception if there is no or more than one matching element. */
inline fun PointerBuffer.single(predicate: (Long) -> Boolean): Long {
    var single: Long? = null
    var found = false
    for (element in this)
        if (predicate(element)) {
            if (found) throw IllegalArgumentException("Array contains more than one matching element.")
            single = element
            found = true
        }
    if (!found) throw NoSuchElementException("Array contains no element matching the predicate.")
    @Suppress("UNCHECKED_CAST")
    return single as Long
}
/** Returns single element, or `null` if the array is empty or has more than one element. */
fun PointerBuffer.singleOrNull(): Long? = if (rem == 1) this[0] else null
/** Returns the single element matching the given [predicate], or `null` if element was not found or more than one element was found. */
inline fun PointerBuffer.singleOrNull(predicate: (Long) -> Boolean): Long? {
    var single: Long? = null
    var found = false
    for (element in this)
        if (predicate(element)) {
            if (found) return null
            single = element
            found = true
        }
    if (!found) return null
    return single
}
/** Returns a list containing only elements matching the given [predicate]. */
inline fun PointerBuffer.filter(predicate: (Long) -> Boolean): List<Long> = filterTo(ArrayList<Long>(), predicate)
/**
 * Returns a list containing only elements matching the given [predicate].
 * @param [predicate] function that takes the index of an element and the element itself and returns the result of predicate evaluation on the element.
 */
inline fun PointerBuffer.filterIndexed(predicate: (index: Int, Long) -> Boolean): List<Long> = filterIndexedTo(ArrayList<Long>(), predicate)
/**
 * Appends all elements matching the given [predicate] to the given [destination].
 * @param [predicate] function that takes the index of an element and the element itself and returns the result of predicate evaluation on the element.
 */
inline fun <C : MutableCollection<in Long>> PointerBuffer.filterIndexedTo(destination: C, predicate: (index: Int, Long) -> Boolean): C {
    forEachIndexed { index, element ->
        if (predicate(index, element)) destination.add(element)
    }
    return destination
}
/** Returns a list containing all elements not matching the given [predicate]. */
inline fun PointerBuffer.filterNot(predicate: (Long) -> Boolean): List<Long> = filterNotTo(ArrayList<Long>(), predicate)
/** Appends all elements not matching the given [predicate] to the given [destination]. */
inline fun <C : MutableCollection<in Long>> PointerBuffer.filterNotTo(destination: C, predicate: (Long) -> Boolean): C {
     for (element in this) if (!predicate(element)) destination.add(element)
     return destination
}
/** Appends all elements matching the given [predicate] to the given [destination]. */
inline fun <C : MutableCollection<in Long>> PointerBuffer.filterTo(destination: C, predicate: (Long) -> Boolean): C {
     for (element in this) if (predicate(element)) destination.add(element)
     return destination
}
/** Returns a list containing elements at specified [indices]. */
fun PointerBuffer.slice(indices: Iterable<Int>): List<Long> {
    val size = indices.collectionSizeOrDefault(10)
    if (size == 0) return emptyList()
    val list = ArrayList<Long>(size)
    for (index in indices)
        list.add(get(index))
    return list
}
/** Returns a list of all elements sorted according to their natural sort order. */
fun PointerBuffer.sorted(): List<Long> = toTypedArray().apply { sort() }.asList()
/** Returns a list of all elements sorted according to the specified [comparator]. */
fun PointerBuffer.sortedWith(comparator: Comparator<in Long>): List<Long> = toTypedArray().apply { sortWith(comparator) }.asList()
/** Returns a string representation of the contents of the specified array as if it is [List]. */
fun PointerBuffer.contentToString(): String {
    val iMax = lim - 1
    if (iMax == -1) return "[]"
    val b = StringBuilder()
    b.append('[')
    var i = 0
    while (true) {
        b.append(get(i))
        if (i == iMax) return b.append(']').toString()
        b.append(", ")
        i++
    }
}
/**
 * Fills this array or its subrange with the specified [element] value.
 * 
 * @param fromIndex the start of the range (inclusive) to fill, 0 by default.
 * @param toIndex the end of the range (exclusive) to fill, size of this array by default.
 * 
 * @throws IndexOutOfBoundsException if [fromIndex] is less than zero or [toIndex] is greater than the size of this array.
 * @throws IllegalArgumentException if [fromIndex] is greater than [toIndex].
 */
fun PointerBuffer.fill(element: Long, fromIndex: Int = pos, toIndex: Int = rem) {
    for (i in fromIndex until toIndex)
        this[i] = element
}
/** Returns the range of valid indices for the array. */
val PointerBuffer.indices: IntRange
    get() = IntRange(0, lastIndex)
/** Returns `true` if the array is empty. */
inline fun PointerBuffer.isEmpty(): Boolean = rem == 0
/** Returns `true` if the array is not empty. */
inline fun PointerBuffer.isNotEmpty(): Boolean = !isEmpty()
/** Returns the last valid index for the array. */
val PointerBuffer.lastIndex: Int
    get() = rem - 1
/** Returns a *typed* object array containing all of the elements of this primitive array. */
fun PointerBuffer.toTypedArray(): Array<Long> = Array(rem) { index -> this[index] }
/**
 * Returns a [Map] containing key-value pairs provided by [transform] function applied to elements of the given array.
 * 
 * If any of two pairs would have the same key the last one gets added to the map.
 * 
 * The returned map preserves the entry iteration order of the original array.
 */
inline fun <K, V> PointerBuffer.associate(transform: (Long) -> Pair<K, V>): Map<K, V> {
    val capacity = mapCapacity(rem).coerceAtLeast(16)
    return associateTo(LinkedHashMap<K, V>(capacity), transform)
}
/**
 * Returns a [Map] containing the elements from the given array indexed by the key returned from [keySelector] function applied to each element.
 * 
 * If any two elements would have the same key returned by [keySelector] the last one gets added to the map.
 * 
 * The returned map preserves the entry iteration order of the original array.
 */
inline fun <K> PointerBuffer.associateBy(keySelector: (Long) -> K): Map<K, Long> {
    val capacity = mapCapacity(rem).coerceAtLeast(16)
    return associateByTo(LinkedHashMap<K, Long>(capacity), keySelector)
}
/**
 * Returns a [Map] containing the values provided by [valueTransform] and indexed by [keySelector] functions applied to elements of the given array.
 * 
 * If any two elements would have the same key returned by [keySelector] the last one gets added to the map.
 * 
 * The returned map preserves the entry iteration order of the original array.
 */
inline fun <K, V> PointerBuffer.associateBy(keySelector: (Long) -> K, valueTransform: (Long) -> V): Map<K, V> {
    val capacity = mapCapacity(rem).coerceAtLeast(16)
    return associateByTo(LinkedHashMap<K, V>(capacity), keySelector, valueTransform)
}
/**
 * Populates and returns the [destination] mutable map with key-value pairs, where key is provided by
 * the [keySelector] function applied to each element of the given array and value is the element itself.
 * 
 * If any two elements would have the same key returned by [keySelector] the last one gets added to the map.
 */
inline fun <K, M : MutableMap<in K, in Long>> PointerBuffer.associateByTo(destination: M, keySelector: (Long) -> K): M {
    for (element in this)
        destination.put(keySelector(element), element)
    return destination
}
/**
 * Populates and returns the [destination] mutable map with key-value pairs, where key is provided by the [keySelector]
 * function and and value is provided by the [valueTransform] function applied to elements of the given array.
 * 
 * If any two elements would have the same key returned by [keySelector] the last one gets added to the map.
 */
inline fun <K, V, M : MutableMap<in K, in V>> PointerBuffer.associateByTo(destination: M, keySelector: (Long) -> K, valueTransform: (Long) -> V): M {
    for (element in this)
        destination.put(keySelector(element), valueTransform(element))
    return destination
}
/**
 * Populates and returns the [destination] mutable map with key-value pairs provided by [transform] function
 * applied to each element of the given array.
 * 
 * If any of two pairs would have the same key the last one gets added to the map.
 */
inline fun <K, V, M : MutableMap<in K, in V>> PointerBuffer.associateTo(destination: M, transform: (Long) -> Pair<K, V>): M {
    for (element in this)
        destination += transform(element)
    return destination
}
/**
 * Returns a [Map] where keys are elements from the given array and values are produced by the [valueSelector] function applied to each element.
 * 
 * If any two elements are equal, the last one gets added to the map.
 * 
 * The returned map preserves the entry iteration order of the original array.
 */
inline fun <V> PointerBuffer.associateWith(valueSelector: (Long) -> V): Map<Long, V> {
    val result = LinkedHashMap<Long, V>(mapCapacity(rem).coerceAtLeast(16))
    return associateWithTo(result, valueSelector)
}
/**
 * Populates and returns the [destination] mutable map with key-value pairs for each element of the given array,
 * where key is the element itself and value is provided by the [valueSelector] function applied to that key.
 * 
 * If any two elements are equal, the last one overwrites the former value in the map.
 */
inline fun <V, M : MutableMap<in Long, in V>> PointerBuffer.associateWithTo(destination: M, valueSelector: (Long) -> V): M {
    for (element in this)
        destination.put(element, valueSelector(element))
    return destination
}
/** Appends all elements to the given [destination] collection. */
fun <C : MutableCollection<in Long>> PointerBuffer.toCollection(destination: C): C {
    for (item in this)
        destination.add(item)
    return destination
}
/** Returns a single list of all elements yielded from results of [transform] function being invoked on each element of original array. */
inline fun <R> PointerBuffer.flatMap(transform: (Long) -> Iterable<R>): List<R> = flatMapTo(ArrayList<R>(), transform)
/** Appends all elements yielded from results of [transform] function being invoked on each element of original array, to the given [destination]. */
inline fun <R, C : MutableCollection<in R>> PointerBuffer.flatMapTo(destination: C, transform: (Long) -> Iterable<R>): C {
    for (element in this) {
        val list = transform(element)
        destination.addAll(list)
    }
    return destination
}
/**
 * Groups elements of the original array by the key returned by the given [keySelector] function applied to
 * each element and returns a map where each group key is associated with a list of corresponding elements.
 * 
 * The returned map preserves the entry iteration order of the keys produced from the original array.
 */
inline fun <K> PointerBuffer.groupBy(keySelector: (Long) -> K): Map<K, List<Long>> = groupByTo(LinkedHashMap<K, MutableList<Long>>(), keySelector)
/**
 * Groups values returned by the [valueTransform] function applied to each element of the original array
 * by the key returned by the given [keySelector] function applied to the element
 * and returns a map where each group key is associated with a list of corresponding values.
 * 
 * The returned map preserves the entry iteration order of the keys produced from the original array.
 */
inline fun <K, V> PointerBuffer.groupBy(keySelector: (Long) -> K, valueTransform: (Long) -> V): Map<K, List<V>> = groupByTo(LinkedHashMap<K, MutableList<V>>(), keySelector, valueTransform)
/**
 * Groups elements of the original array by the key returned by the given [keySelector] function applied to each
 * element and puts to the [destination] map each group key associated with a list of corresponding elements.
 * 
 * @return The [destination] map.
 */
inline fun <K, M : MutableMap<in K, MutableList<Long>>> PointerBuffer.groupByTo(destination: M, keySelector: (Long) -> K): M {
    for (element in this) {
        val key = keySelector(element)
        val list = destination.getOrPut(key) { ArrayList<Long>() }
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
 */
inline fun <K, V, M : MutableMap<in K, MutableList<V>>> PointerBuffer.groupByTo(destination: M, keySelector: (Long) -> K, valueTransform: (Long) -> V): M {
    for (element in this) {
        val key = keySelector(element)
        val list = destination.getOrPut(key) { ArrayList<V>() }
        list.add(valueTransform(element))
    }
    return destination
}
/**
 * Returns a list containing only distinct elements from the given array.
 * 
 * The elements in the resulting list are in the same order as they were in the source array.
 */
fun PointerBuffer.distinct(): List<Long> = this.toMutableSet().toList()
/**
 * Returns a list containing only elements from the given array having distinct keys returned by the given [selector] function.
 * 
 * The elements in the resulting list are in the same order as they were in the source array.
 */
inline fun <K> PointerBuffer.distinctBy(selector: (Long) -> K): List<Long> {
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
 * Returns a new [MutableSet] containing all distinct elements from the given array.
 * 
 * The returned set preserves the element iteration order of the original array.
 */
fun PointerBuffer.toMutableSet(): MutableSet<Long> = toCollection(LinkedHashSet<Long>(mapCapacity(rem)))
/** Returns a list containing the results of applying the given [transform] function to each element in the original array. */
inline fun <R> PointerBuffer.map(transform: (Long) -> R): List<R> = mapTo(ArrayList<R>(rem), transform)
/**
 * Returns a list containing the results of applying the given [transform] function to each element and its index in the original array.
 * @param [transform] function that takes the index of an element and the element itself and returns the result of the transform applied to the element.
 */
inline fun <R> PointerBuffer.mapIndexed(transform: (index: Int, Long) -> R): List<R> = mapIndexedTo(ArrayList<R>(rem), transform)
/**
 * Applies the given [transform] function to each element and its index in the original array and appends the results to the given [destination].
 * @param [transform] function that takes the index of an element and the element itself and returns the result of the transform applied to the element.
 */
inline fun <R, C : MutableCollection<in R>> PointerBuffer.mapIndexedTo(destination: C, transform: (index: Int, Long) -> R): C {
    var index = 0
    for (item in this)
        destination.add(transform(index++, item))
    return destination
}
/** Applies the given [transform] function to each element of the original array and appends the results to the given [destination]. */
inline fun <R, C : MutableCollection<in R>> PointerBuffer.mapTo(destination: C, transform: (Long) -> R): C {
    for (item in this)
        destination.add(transform(item))
    return destination
}
/** Returns `true` if all elements match the given [predicate]. */
inline fun PointerBuffer.all(predicate: (Long) -> Boolean): Boolean {
    for (element in this) if (!predicate(element)) return false
    return true
}
/** Returns `true` if array has at least one element. */
fun PointerBuffer.any(): Boolean = !isEmpty()
/** Returns `true` if at least one element matches the given [predicate]. */
inline fun PointerBuffer.any(predicate: (Long) -> Boolean): Boolean {
    for (element in this) if (predicate(element)) return true
    return false
}
/** Returns the number of elements in this array. */
inline fun PointerBuffer.count(): Int = rem
/** Returns the number of elements matching the given [predicate]. */
inline fun PointerBuffer.count(predicate: (Long) -> Boolean): Int {
    var count = 0
    for (element in this) if (predicate(element)) ++count
    return count
}
/** Performs the given [action] on each element. */
inline fun PointerBuffer.forEach(action: (Long) -> Unit) { for (element in this) action(element) }
/**
 * Performs the given [action] on each element, providing sequential index with the element.
 * @param [action] function that takes the index of an element and the element itself and performs the action on the element.
 */
inline fun PointerBuffer.forEachIndexed(action: (index: Int, Long) -> Unit): Unit {
    var index = 0
    for (item in this) action(index++, item)
}
/**
 * Returns the largest element.
 * 
 * @throws NoSuchElementException if the array is empty.
 */
fun PointerBuffer.max(): Long {
    if (isEmpty()) throw NoSuchElementException()
    var max = this[0]
    for (i in 1..lastIndex) {
        val e = this[i]
        if (max < e) max = e
    }
    return max
}
/**
 * Returns the first element yielding the largest value of the given function.
 * 
 * @throws NoSuchElementException if the array is empty.
 */
inline fun <R : Comparable<R>> PointerBuffer.maxBy(selector: (Long) -> R): Long {
    if (isEmpty()) throw NoSuchElementException()
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
/** Returns the first element yielding the largest value of the given function or `null` if there are no elements. */
inline fun <R : Comparable<R>> PointerBuffer.maxByOrNull(selector: (Long) -> R): Long? {
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
/** Returns the largest element or `null` if there are no elements. */
fun PointerBuffer.maxOrNull(): Long? {
    if (isEmpty()) return null
    var max = this[0]
    for (i in 1..lastIndex) {
        val e = this[i]
        if (max < e) max = e
    }
    return max
}
/**
 * Returns the first element having the largest value according to the provided [comparator].
 * 
 * @throws NoSuchElementException if the array is empty.
 */
fun PointerBuffer.maxWith(comparator: Comparator<in Long>): Long {
    if (isEmpty()) throw NoSuchElementException()
    var max = this[0]
    for (i in 1..lastIndex) {
        val e = this[i]
        if (comparator.compare(max, e) < 0) max = e
    }
    return max
}
/** Returns the first element having the largest value according to the provided [comparator] or `null` if there are no elements. */
fun PointerBuffer.maxWithOrNull(comparator: Comparator<in Long>): Long? {
    if (isEmpty()) return null
    var max = this[0]
    for (i in 1..lastIndex) {
        val e = this[i]
        if (comparator.compare(max, e) < 0) max = e
    }
    return max
}
/**
 * Returns the smallest element.
 * 
 * @throws NoSuchElementException if the array is empty.
 */
fun PointerBuffer.min(): Long {
    if (isEmpty()) throw NoSuchElementException()
    var min = this[0]
    for (i in 1..lastIndex) {
        val e = this[i]
        if (min > e) min = e
    }
    return min
}
/**
 * Returns the first element yielding the smallest value of the given function.
 * 
 * @throws NoSuchElementException if the array is empty.
 */
inline fun <R : Comparable<R>> PointerBuffer.minBy(selector: (Long) -> R): Long {
    if (isEmpty()) throw NoSuchElementException()
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
 * Returns the first element yielding the smallest value of the given function or `null` if there are no elements.
 * 
 * @sample samples.collections.Collections.Aggregates.minByOrNull
 */
inline fun <R : Comparable<R>> PointerBuffer.minByOrNull(selector: (Long) -> R): Long? {
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
 * Returns the smallest value among all values produced by [selector] function applied to each element in the array.
 * 
 * If any of values produced by [selector] function is `NaN`, the returned result is `NaN`.
 * 
 * @throws NoSuchElementException if the array is empty.
 */
inline fun PointerBuffer.minOf(selector: (Long) -> Double): Double {
    if (isEmpty()) throw NoSuchElementException()
    var minValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        minValue = minOf(minValue, v)
    }
    return minValue
}
/**
 * Returns the smallest value among all values produced by [selector] function applied to each element in the array.
 * 
 * If any of values produced by [selector] function is `NaN`, the returned result is `NaN`.
 * 
 * @throws NoSuchElementException if the array is empty.
 */
inline fun PointerBuffer.minOf(selector: (Long) -> Float): Float {
    if (isEmpty()) throw NoSuchElementException()
    var minValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        minValue = minOf(minValue, v)
    }
    return minValue
}
/**
 * Returns the smallest value among all values produced by [selector] function applied to each element in the array.
 * 
 * @throws NoSuchElementException if the array is empty.
 */
inline fun <R : Comparable<R>> PointerBuffer.minOf(selector: (Long) -> R): R {
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
 * Returns the smallest value among all values produced by [selector] function applied to each element in the array or `null` if there are no elements.
 * 
 * If any of values produced by [selector] function is `NaN`, the returned result is `NaN`.
 */
inline fun PointerBuffer.minOfOrNull(selector: (Long) -> Double): Double? {
    if (isEmpty()) return null
    var minValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        minValue = minOf(minValue, v)
    }
    return minValue
}
/**
 * Returns the smallest value among all values produced by [selector] function applied to each element in the array or `null` if there are no elements.
 * 
 * If any of values produced by [selector] function is `NaN`, the returned result is `NaN`.
 */
inline fun PointerBuffer.minOfOrNull(selector: (Long) -> Float): Float? {
    if (isEmpty()) return null
    var minValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        minValue = minOf(minValue, v)
    }
    return minValue
}
/** Returns the smallest value among all values produced by [selector] function applied to each element in the array or `null` if there are no elements. */
inline fun <R : Comparable<R>> PointerBuffer.minOfOrNull(selector: (Long) -> R): R? {
    if (isEmpty()) return null
    var minValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        if (minValue > v)
            minValue = v
    }
    return minValue
}
/**
 * Returns the smallest value according to the provided [comparator] among all values produced by [selector] function applied to each element in the array.
 * 
 * @throws NoSuchElementException if the array is empty.
 */
inline fun <R> PointerBuffer.minOfWith(comparator: Comparator<in R>, selector: (Long) -> R): R {
    if (isEmpty()) throw NoSuchElementException()
    var minValue = selector(this[0])
    for (i in 1..lastIndex) {
        val v = selector(this[i])
        if (comparator.compare(minValue, v) > 0)
            minValue = v
    }
    return minValue
}
/**
 * Returns the smallest value according to the provided [comparator] among all values produced by [selector]
 * function applied to each element in the array or `null` if there are no elements.
 */
inline fun <R> PointerBuffer.minOfWithOrNull(comparator: Comparator<in R>, selector: (Long) -> R): R? {
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
fun PointerBuffer.minOrNull(): Long? {
     if (isEmpty()) return null
     var min = this[0]
     for (i in 1..lastIndex) {
         val e = this[i]
         if (min > e) min = e
     }
     return min
 }
/**
 * Returns the first element having the smallest value according to the provided [comparator].
 * 
 * @throws NoSuchElementException if the array is empty.
 */
fun PointerBuffer.minWith(comparator: Comparator<in Long>): Long {
    if (isEmpty()) throw NoSuchElementException()
    var min = this[0]
    for (i in 1..lastIndex) {
        val e = this[i]
        if (comparator.compare(min, e) > 0) min = e
    }
    return min
}
/** Returns the first element having the smallest value according to the provided [comparator] or `null` if there are no elements. */
fun PointerBuffer.minWithOrNull(comparator: Comparator<in Long>): Long? {
    if (isEmpty()) return null
    var min = this[0]
    for (i in 1..lastIndex) {
        val e = this[i]
        if (comparator.compare(min, e) > 0) min = e
    }
    return min
}
/** Returns `true` if the array has no elements. */
fun PointerBuffer.none(): Boolean = isEmpty()
/** Returns `true` if no elements match the given [predicate]. */
inline fun PointerBuffer.none(predicate: (Long) -> Boolean): Boolean {
    for (element in this) if (predicate(element)) return false
    return true
}
/** Performs the given [action] on each element and returns the array itself afterwards. */
inline fun PointerBuffer.onEach(action: (Long) -> Unit): PointerBuffer = apply { for (element in this) action(element) }
/**
 * Performs the given [action] on each element, providing sequential index with the element, and returns the array itself afterwards.
 * @param [action] function that takes the index of an element and the element itself and performs the action on the element.
 */
inline fun PointerBuffer.onEachIndexed(action: (index: Int, Long) -> Unit): PointerBuffer = apply { forEachIndexed(action) }
/**
 * Accumulates value starting with the first element and applying [operation] from left to right to current accumulator value and each element.
 * 
 * Throws an exception if this array is empty. If the array can be empty in an expected way,
 * please use [reduceOrNull] instead. It returns `null` when its receiver is empty.
 * 
 * @param [operation] function that takes current accumulator value and an element, and calculates the next accumulator value.
 */
inline fun PointerBuffer.reduce(operation: (acc: Long, Long) -> Long): Long {
    if (isEmpty())
        throw UnsupportedOperationException("Empty array can't be reduced.")
    var accumulator = this[0]
    for (index in 1..lastIndex)
        accumulator = operation(accumulator, this[index])
    return accumulator
}
/**
 * Accumulates value starting with the first element and applying [operation] from left to right
 * to current accumulator value and each element with its index in the original array.
 * 
 * Throws an exception if this array is empty. If the array can be empty in an expected way,
 * please use [reduceIndexedOrNull] instead. It returns `null` when its receiver is empty.
 * 
 * @param [operation] function that takes the index of an element, current accumulator value and the element itself,
 * and calculates the next accumulator value.
 */
inline fun PointerBuffer.reduceIndexed(operation: (index: Int, acc: Long, Long) -> Long): Long {
    if (isEmpty())
        throw UnsupportedOperationException("Empty array can't be reduced.")
    var accumulator = this[0]
    for (index in 1..lastIndex)
        accumulator = operation(index, accumulator, this[index])
    return accumulator
}
/**
 * Accumulates value starting with the first element and applying [operation] from left to right
 * to current accumulator value and each element with its index in the original array.
 * 
 * Returns `null` if the array is empty.
 * 
 * @param [operation] function that takes the index of an element, current accumulator value and the element itself,
 * and calculates the next accumulator value.
 */
inline fun PointerBuffer.reduceIndexedOrNull(operation: (index: Int, acc: Long, Long) -> Long): Long? {
    if (isEmpty())
        return null
    var accumulator = this[0]
    for (index in 1..lastIndex)
        accumulator = operation(index, accumulator, this[index])
    return accumulator
}
/**
 * Accumulates value starting with the first element and applying [operation] from left to right to current accumulator value and each element.
 * 
 * Returns `null` if the array is empty.
 * 
 * @param [operation] function that takes current accumulator value and an element, and calculates the next accumulator value.
 */
inline fun PointerBuffer.reduceOrNull(operation: (acc: Long, Long) -> Long): Long? {
    if (isEmpty())
        return null
    var accumulator = this[0]
    for (index in 1..lastIndex)
        accumulator = operation(accumulator, this[index])
     return accumulator
}
/**
 * Accumulates value starting with the last element and applying [operation] from right to left to each element and current accumulator value.
 * 
 * Throws an exception if this array is empty. If the array can be empty in an expected way,
 * please use [reduceRightOrNull] instead. It returns `null` when its receiver is empty.
 * 
 * @param [operation] function that takes an element and current accumulator value, and calculates the next accumulator value.
 */
inline fun PointerBuffer.reduceRight(operation: (Long, acc: Long) -> Long): Long {
    var index = lastIndex
    if (index < 0) throw UnsupportedOperationException("Empty array can't be reduced.")
    var accumulator = get(index--)
    while (index >= 0)
        accumulator = operation(get(index--), accumulator)
    return accumulator
}
/**
 * Accumulates value starting with the last element and applying [operation] from right to left
 * to each element with its index in the original array and current accumulator value.
 * 
 * Throws an exception if this array is empty. If the array can be empty in an expected way,
 * please use [reduceRightIndexedOrNull] instead. It returns `null` when its receiver is empty.
 * 
 * @param [operation] function that takes the index of an element, the element itself and current accumulator value,
 * and calculates the next accumulator value.
 */
inline fun PointerBuffer.reduceRightIndexed(operation: (index: Int, Long, acc: Long) -> Long): Long {
    var index = lastIndex
    if (index < 0) throw UnsupportedOperationException("Empty array can't be reduced.")
    var accumulator = get(index--)
    while (index >= 0) {
        accumulator = operation(index, get(index), accumulator)
        --index
    }
    return accumulator
}
/**
 * Accumulates value starting with the last element and applying [operation] from right to left
 * to each element with its index in the original array and current accumulator value.
 * 
 * Returns `null` if the array is empty.
 * 
 * @param [operation] function that takes the index of an element, the element itself and current accumulator value,
 * and calculates the next accumulator value.
 */
inline fun PointerBuffer.reduceRightIndexedOrNull(operation: (index: Int, Long, acc: Long) -> Long): Long? {
    var index = lastIndex
    if (index < 0) return null
    var accumulator = get(index--)
    while (index >= 0) {
        accumulator = operation(index, get(index), accumulator)
        --index
    }
    return accumulator
}
/**
 * Accumulates value starting with the last element and applying [operation] from right to left to each element and current accumulator value.
 * 
 * Returns `null` if the array is empty.
 * 
 * @param [operation] function that takes an element and current accumulator value, and calculates the next accumulator value.
 */
inline fun PointerBuffer.reduceRightOrNull(operation: (Long, acc: Long) -> Long): Long? {
    var index = lastIndex
    if (index < 0) return null
    var accumulator = get(index--)
    while (index >= 0)
         accumulator = operation(get(index--), accumulator)
    return accumulator
}
/**
 * Splits the original array into pair of lists, where *first* list contains elements for which [predicate] 
 * yielded `true`, while *second* list contains elements for which [predicate] yielded `false`.
 */
inline fun PointerBuffer.partition(predicate: (Long) -> Boolean): Pair<List<Long>, List<Long>> {
    val first = ArrayList<Long>()
    val second = ArrayList<Long>()
    for (element in this)
        if (predicate(element))
            first.add(element)
        else
            second.add(element)
    return Pair(first, second)
}
/**
 * Returns a list of pairs built from the elements of `this` array and the [other] array with the same index.
 * The returned list has length of the shortest collection.
 */
infix fun <R> PointerBuffer.zip(other: Array<out R>): List<Pair<Long, R>> = zip(other) { t1, t2 -> t1 to t2 }
/**
 * Returns a list of values built from the elements of `this` array and the [other] array with the same index
 * using the provided [transform] function applied to each pair of elements.
 * The returned list has length of the shortest collection.
 */
inline fun <R, V> PointerBuffer.zip(other: Array<out R>, transform: (a: Long, b: R) -> V): List<V> {
    val size = minOf(rem, other.size)
    val list = ArrayList<V>(size)
    for (i in 0 until size)
        list.add(transform(this[i], other[i]))
    return list
}
/**
 * Returns a list of pairs built from the elements of `this` collection and [other] array with the same index.
 * The returned list has length of the shortest collection.
 */
infix fun <R> PointerBuffer.zip(other: Iterable<R>): List<Pair<Long, R>> = zip(other) { t1, t2 -> t1 to t2 }
/**
 * Returns a list of values built from the elements of `this` array and the [other] collection with the same index
 * using the provided [transform] function applied to each pair of elements.
 * The returned list has length of the shortest collection.
 */
inline fun <R, V> PointerBuffer.zip(other: Iterable<R>, transform: (a: Long, b: R) -> V): List<V> {
    val arraySize = rem
    val list = ArrayList<V>(minOf(other.collectionSizeOrDefault(10), arraySize))
    var i = 0
    for (element in other) {
        if (i >= arraySize) break
        list.add(transform(this[i++], element))
    }
    return list
}
/**
 * Appends the string from all the elements separated using [separator] and using the given [prefix] and [postfix] if supplied.
 * 
 * If the collection could be huge, you can specify a non-negative value of [limit], in which case only the first [limit]
 * elements will be appended, followed by the [truncated] string (which defaults to "...").
 */
fun <A : Appendable> PointerBuffer.joinTo(buffer: A, separator: CharSequence = ", ", prefix: CharSequence = "", postfix: CharSequence = "", limit: Int = -1, truncated: CharSequence = "...", transform: ((Long) -> CharSequence)? = null): A {
    buffer.append(prefix)
    var count = 0
    for (element in this) {
        if (++count > 1) buffer.append(separator)
        if (limit < 0 || count <= limit)
            if (transform != null)
                buffer.append(transform(element))
            else
                buffer.append(element.toString())
        else break
    }
    if (limit >= 0 && count > limit) buffer.append(truncated)
    buffer.append(postfix)
    return buffer
}
/**
 * Creates a string from all the elements separated using [separator] and using the given [prefix] and [postfix] if supplied.
 * 
 * If the collection could be huge, you can specify a non-negative value of [limit], in which case only the first [limit]
 * elements will be appended, followed by the [truncated] string (which defaults to "...").
 */
fun PointerBuffer.joinToString(separator: CharSequence = ", ", prefix: CharSequence = "", postfix: CharSequence = "", limit: Int = -1, truncated: CharSequence = "...", transform: ((Long) -> CharSequence)? = null): String =
    joinTo(StringBuilder(), separator, prefix, postfix, limit, truncated, transform).toString()
