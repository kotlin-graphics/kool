@file:OptIn(ExperimentalUnsignedTypes::class)

package kool

@JvmInline
value class PointerArray<T>(val array: ULongArray) {
    /**
     * Creates a new array of the specified [size], where each element is calculated by calling the specified
     * [init] function.
     *
     * The function [init] is called for each array element sequentially starting from the first one.
     * It should return the value for an array element given its index.
     */
    constructor(size: Int, init: (Int) -> Ptr<T>) : this(ULongArray(size) { init(it).adr })
    constructor(size: Int) : this(ULongArray(size))

    /**
     * Returns the array element at the given [index].  This method can be called using the index operator.
     *
     * If the [index] is out of bounds of this array, throws an [IndexOutOfBoundsException] except in Kotlin/JS
     * where the behavior is unspecified.
     */
    operator fun get(index: Int): Ptr<T> = array[index].toPtr()

    /**
     * Sets the element at the given [index] to the given [value]. This method can be called using the index operator.
     *
     * If the [index] is out of bounds of this array, throws an [IndexOutOfBoundsException] except in Kotlin/JS
     * where the behavior is unspecified.
     */
    operator fun set(index: Int, value: Ptr<T>) = array.set(index, value.adr)

    /** Returns the number of elements in the array. */
    val size: Int
        get() = array.size

    /** Creates an iterator over the elements of the array. */
    operator fun iterator(): Iterator<Ptr<T>> = Ptr2Iterator(array)

    /** Returns a list of all elements sorted according to the specified [comparator]. */
//    fun sortedWith(comparator: Comparator<in Ptr<T>>): List<ULong> = array.sortedWith(comparator)

    /** Returns a list with elements in reversed order. */
    fun reversed(): List<Ptr<T>> = array.reversed().map { it.toPtr() }

    /** Returns the range of valid indices for the array. */
    val indices: IntRange
        get() = array.indices

    /** Returns the last valid index for the array. */
    val lastIndex: Int
        get() = array.lastIndex

    class Ptr2Iterator<T> (val array: ULongArray) : Iterator<Ptr<T>> {
        override fun hasNext(): Boolean = array.iterator().hasNext()
        override fun next(): Ptr<T> = array.iterator().next().toPtr()
    }
}