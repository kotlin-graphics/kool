package kool

import java.nio.CharBuffer

@JvmInline
value class PointerArray(val array: LongArray) {
    /**
     * Creates a new array of the specified [size], where each element is calculated by calling the specified
     * [init] function.
     *
     * The function [init] is called for each array element sequentially starting from the first one.
     * It should return the value for an array element given its index.
     */
    constructor(size: Int, init: (Int) -> Ptr) : this(LongArray(size, init))
    constructor(size: Int) : this(LongArray(size))

    /**
     * Returns the array element at the given [index].  This method can be called using the index operator.
     *
     * If the [index] is out of bounds of this array, throws an [IndexOutOfBoundsException] except in Kotlin/JS
     * where the behavior is unspecified.
     */
    operator fun get(index: Int): Ptr = array[index]

    /**
     * Sets the element at the given [index] to the given [value]. This method can be called using the index operator.
     *
     * If the [index] is out of bounds of this array, throws an [IndexOutOfBoundsException] except in Kotlin/JS
     * where the behavior is unspecified.
     */
    operator fun set(index: Int, value: Ptr) = array.set(index, value)

    /** Returns the number of elements in the array. */
    val size: Int
        get() = array.size

    /** Creates an iterator over the elements of the array. */
    operator fun iterator(): Iterator<Ptr> = array.iterator()

    /** Returns a list of all elements sorted according to the specified [comparator]. */
    fun sortedWith(comparator: Comparator<in Ptr>): List<Ptr> = array.sortedWith(comparator)

    /** Returns a list with elements in reversed order. */
    fun reversed(): List<Ptr> = array.reversed()

    /** Returns the range of valid indices for the array. */
    val indices: IntRange
        get() = array.indices

    /** Returns the last valid index for the array. */
    val lastIndex: Int
        get() = array.lastIndex
}