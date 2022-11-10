package kool.lib

// from kotlin.collections.AbstractList.kt

internal fun checkRangeIndexes(fromIndex: Int, toIndex: Int, size: Int) {
    if (fromIndex < 0 || toIndex > size)
        throw IndexOutOfBoundsException("fromIndex: $fromIndex, toIndex: $toIndex, size: $size")
    if (fromIndex > toIndex)
        throw IllegalArgumentException("fromIndex: $fromIndex > toIndex: $toIndex")
}


// from kotlin.collections.MapsJVM.kt

/**
 * Calculate the initial capacity of a map, based on Guava's
 * [com.google.common.collect.Maps.capacity](https://github.com/google/guava/blob/v28.2/guava/src/com/google/common/collect/Maps.java#L325)
 * approach.
 */
fun mapCapacity(expectedSize: Int): Int = when {
    // We are not coercing the value to a valid one and not throwing an exception. It is up to the caller to
    // properly handle negative values.
    expectedSize < 0 -> expectedSize
    expectedSize < 3 -> expectedSize + 1
    expectedSize < INT_MAX_POWER_OF_TWO -> ((expectedSize / 0.75f) + 1f).toInt()
    // any large value
    else -> Int.MAX_VALUE
}

private const val INT_MAX_POWER_OF_TWO: Int = 1 shl (Int.SIZE_BITS - 2)


// from kotlin.collections.Iterables.kt

/**
 * A wrapper over another [Iterable] (or any other object that can produce an [Iterator]) that returns
 * an indexing iterator.
 */
internal class IndexingIterable<out T>(private val iteratorFactory: () -> Iterator<T>) : Iterable<IndexedValue<T>> {
    override fun iterator(): Iterator<IndexedValue<T>> = IndexingIterator(iteratorFactory())
}

/**
 * Returns the size of this iterable if it is known, or the specified [default] value otherwise.
 */
public fun <T> Iterable<T>.collectionSizeOrDefault(default: Int): Int = if (this is Collection<*>) this.size else default


// from kotlin.collections.Iterators.kt

/**
 * Iterator transforming original `iterator` into iterator of [IndexedValue], counting index from zero.
 */
internal class IndexingIterator<out T>(private val iterator: Iterator<T>) : Iterator<IndexedValue<T>> {
    private var index = 0
    override fun hasNext(): Boolean = iterator.hasNext()
    override fun next(): IndexedValue<T> = IndexedValue(checkIndexOverflow(index++), iterator.next())
}

// from kotlin.collections.Collections.kt

internal fun throwIndexOverflow(): Nothing = throw ArithmeticException("Index overflow has happened.")

// from kotlin.collections.CollectionsJVM.kt
@Suppress("NOTHING_TO_INLINE")
internal inline fun checkIndexOverflow(index: Int): Int {
    if (index < 0) {
        if (apiVersionIsAtLeast(1, 3, 0))
            throwIndexOverflow()
        else
            throw ArithmeticException("Index overflow has happened.")
    }
    return index
}

// from kotlin.internal.PlatformImplementations.kt

/**
 * Constant check of api version used during compilation
 *
 * This function is evaluated at compile time to a constant value,
 * so there should be no references to it in other modules.
 *
 * The function usages are validated to have literal argument values.
 */
internal fun apiVersionIsAtLeast(major: Int, minor: Int, patch: Int) = KotlinVersion.CURRENT.isAtLeast(major, minor, patch)