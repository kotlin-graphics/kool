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
 * Accumulates value starting with the first element and applying [operation] from left to right
 * to current accumulator value and each element with its index in the original array.
 *
 * Throws an exception if this array is empty. If the array can be empty in an expected way,
 * please use [reduceIndexedOrNull] instead. It returns `null` when its receiver is empty.
 *
 * @param [operation] function that takes the index of an element, current accumulator value and the element itself,
 * and calculates the next accumulator value.
 *
 * @sample kool.buffers.Collections.Aggregates.reduce
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
 * Throws an exception if this array is empty. If the array can be empty in an expected way,
 * please use [reduceIndexedOrNull] instead. It returns `null` when its receiver is empty.
 *
 * @param [operation] function that takes the index of an element, current accumulator value and the element itself,
 * and calculates the next accumulator value.
 *
 * @sample kool.buffers.Collections.Aggregates.reduce
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
 * Throws an exception if this array is empty. If the array can be empty in an expected way,
 * please use [reduceIndexedOrNull] instead. It returns `null` when its receiver is empty.
 *
 * @param [operation] function that takes the index of an element, current accumulator value and the element itself,
 * and calculates the next accumulator value.
 *
 * @sample kool.buffers.Collections.Aggregates.reduce
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
 * Throws an exception if this array is empty. If the array can be empty in an expected way,
 * please use [reduceIndexedOrNull] instead. It returns `null` when its receiver is empty.
 *
 * @param [operation] function that takes the index of an element, current accumulator value and the element itself,
 * and calculates the next accumulator value.
 *
 * @sample kool.buffers.Collections.Aggregates.reduce
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
 * Throws an exception if this array is empty. If the array can be empty in an expected way,
 * please use [reduceIndexedOrNull] instead. It returns `null` when its receiver is empty.
 *
 * @param [operation] function that takes the index of an element, current accumulator value and the element itself,
 * and calculates the next accumulator value.
 *
 * @sample kool.buffers.Collections.Aggregates.reduce
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
 * Throws an exception if this array is empty. If the array can be empty in an expected way,
 * please use [reduceIndexedOrNull] instead. It returns `null` when its receiver is empty.
 *
 * @param [operation] function that takes the index of an element, current accumulator value and the element itself,
 * and calculates the next accumulator value.
 *
 * @sample kool.buffers.Collections.Aggregates.reduce
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
 * Throws an exception if this array is empty. If the array can be empty in an expected way,
 * please use [reduceIndexedOrNull] instead. It returns `null` when its receiver is empty.
 *
 * @param [operation] function that takes the index of an element, current accumulator value and the element itself,
 * and calculates the next accumulator value.
 *
 * @sample kool.buffers.Collections.Aggregates.reduce
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
 *
 * @sample kool.buffers.Collections.Aggregates.reduceOrNull
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
 * Accumulates value starting with the first element and applying [operation] from left to right
 * to current accumulator value and each element with its index in the original array.
 *
 * Returns `null` if the array is empty.
 *
 * @param [operation] function that takes the index of an element, current accumulator value and the element itself,
 * and calculates the next accumulator value.
 *
 * @sample kool.buffers.Collections.Aggregates.reduceOrNull
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
 * Accumulates value starting with the first element and applying [operation] from left to right
 * to current accumulator value and each element with its index in the original array.
 *
 * Returns `null` if the array is empty.
 *
 * @param [operation] function that takes the index of an element, current accumulator value and the element itself,
 * and calculates the next accumulator value.
 *
 * @sample kool.buffers.Collections.Aggregates.reduceOrNull
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
 * Accumulates value starting with the first element and applying [operation] from left to right
 * to current accumulator value and each element with its index in the original array.
 *
 * Returns `null` if the array is empty.
 *
 * @param [operation] function that takes the index of an element, current accumulator value and the element itself,
 * and calculates the next accumulator value.
 *
 * @sample kool.buffers.Collections.Aggregates.reduceOrNull
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
 * Accumulates value starting with the first element and applying [operation] from left to right
 * to current accumulator value and each element with its index in the original array.
 *
 * Returns `null` if the array is empty.
 *
 * @param [operation] function that takes the index of an element, current accumulator value and the element itself,
 * and calculates the next accumulator value.
 *
 * @sample kool.buffers.Collections.Aggregates.reduceOrNull
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
 * Accumulates value starting with the first element and applying [operation] from left to right
 * to current accumulator value and each element with its index in the original array.
 *
 * Returns `null` if the array is empty.
 *
 * @param [operation] function that takes the index of an element, current accumulator value and the element itself,
 * and calculates the next accumulator value.
 *
 * @sample kool.buffers.Collections.Aggregates.reduceOrNull
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
 * Accumulates value starting with the first element and applying [operation] from left to right
 * to current accumulator value and each element with its index in the original array.
 *
 * Returns `null` if the array is empty.
 *
 * @param [operation] function that takes the index of an element, current accumulator value and the element itself,
 * and calculates the next accumulator value.
 *
 * @sample kool.buffers.Collections.Aggregates.reduceOrNull
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
 * Accumulates value starting with the first element and applying [operation] from left to right
 * to current accumulator value and each element.
 *
 * Returns `null` if the array is empty.
 *
 * @param [operation] function that takes current accumulator value and an element,
 * and calculates the next accumulator value.
 *
 * @sample kool.buffers.Collections.Aggregates.reduceOrNull
 */
inline fun ByteBuffer.reduceOrNull(operation: (acc: Byte, Byte) -> Byte): Byte? {
    if (isEmpty()) return null
    var accumulator = this[0]
    for (index in 1..lastIndex)
        accumulator = operation(accumulator, this[index])
    return accumulator
}

/**
 * Accumulates value starting with the first element and applying [operation] from left to right
 * to current accumulator value and each element.
 *
 * Returns `null` if the array is empty.
 *
 * @param [operation] function that takes current accumulator value and an element,
 * and calculates the next accumulator value.
 *
 * @sample kool.buffers.Collections.Aggregates.reduceOrNull
 */
inline fun ShortBuffer.reduceOrNull(operation: (acc: Short, Short) -> Short): Short? {
    if (isEmpty()) return null
    var accumulator = this[0]
    for (index in 1..lastIndex)
        accumulator = operation(accumulator, this[index])
    return accumulator
}

/**
 * Accumulates value starting with the first element and applying [operation] from left to right
 * to current accumulator value and each element.
 *
 * Returns `null` if the array is empty.
 *
 * @param [operation] function that takes current accumulator value and an element,
 * and calculates the next accumulator value.
 *
 * @sample kool.buffers.Collections.Aggregates.reduceOrNull
 */
inline fun IntBuffer.reduceOrNull(operation: (acc: Int, Int) -> Int): Int? {
    if (isEmpty()) return null
    var accumulator = this[0]
    for (index in 1..lastIndex)
        accumulator = operation(accumulator, this[index])
    return accumulator
}

/**
 * Accumulates value starting with the first element and applying [operation] from left to right
 * to current accumulator value and each element.
 *
 * Returns `null` if the array is empty.
 *
 * @param [operation] function that takes current accumulator value and an element,
 * and calculates the next accumulator value.
 *
 * @sample kool.buffers.Collections.Aggregates.reduceOrNull
 */
inline fun LongBuffer.reduceOrNull(operation: (acc: Long, Long) -> Long): Long? {
    if (isEmpty()) return null
    var accumulator = this[0]
    for (index in 1..lastIndex)
        accumulator = operation(accumulator, this[index])
    return accumulator
}

/**
 * Accumulates value starting with the first element and applying [operation] from left to right
 * to current accumulator value and each element.
 *
 * Returns `null` if the array is empty.
 *
 * @param [operation] function that takes current accumulator value and an element,
 * and calculates the next accumulator value.
 *
 * @sample kool.buffers.Collections.Aggregates.reduceOrNull
 */
inline fun FloatBuffer.reduceOrNull(operation: (acc: Float, Float) -> Float): Float? {
    if (isEmpty()) return null
    var accumulator = this[0]
    for (index in 1..lastIndex)
        accumulator = operation(accumulator, this[index])
    return accumulator
}

/**
 * Accumulates value starting with the first element and applying [operation] from left to right
 * to current accumulator value and each element.
 *
 * Returns `null` if the array is empty.
 *
 * @param [operation] function that takes current accumulator value and an element,
 * and calculates the next accumulator value.
 *
 * @sample kool.buffers.Collections.Aggregates.reduceOrNull
 */
inline fun DoubleBuffer.reduceOrNull(operation: (acc: Double, Double) -> Double): Double? {
    if (isEmpty()) return null
    var accumulator = this[0]
    for (index in 1..lastIndex)
        accumulator = operation(accumulator, this[index])
    return accumulator
}

/**
 * Accumulates value starting with the first element and applying [operation] from left to right
 * to current accumulator value and each element.
 *
 * Returns `null` if the array is empty.
 *
 * @param [operation] function that takes current accumulator value and an element,
 * and calculates the next accumulator value.
 *
 * @sample kool.buffers.Collections.Aggregates.reduceOrNull
 */
inline fun CharBuffer.reduceOrNull(operation: (acc: Char, Char) -> Char): Char? {
    if (isEmpty()) return null
    var accumulator = this[0]
    for (index in 1..lastIndex)
        accumulator = operation(accumulator, this[index])
    return accumulator
}


/**
 * Accumulates value starting with the last element and applying [operation] from right to left
 * to each element and current accumulator value.
 *
 * Throws an exception if this array is empty. If the array can be empty in an expected way,
 * please use [reduceRightOrNull] instead. It returns `null` when its receiver is empty.
 *
 * @param [operation] function that takes an element and current accumulator value,
 * and calculates the next accumulator value.
 *
 * @sample kool.buffers.Collections.Aggregates.reduceRight
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
 * to each element and current accumulator value.
 *
 * Throws an exception if this array is empty. If the array can be empty in an expected way,
 * please use [reduceRightOrNull] instead. It returns `null` when its receiver is empty.
 *
 * @param [operation] function that takes an element and current accumulator value,
 * and calculates the next accumulator value.
 *
 * @sample kool.buffers.Collections.Aggregates.reduceRight
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
 * to each element and current accumulator value.
 *
 * Throws an exception if this array is empty. If the array can be empty in an expected way,
 * please use [reduceRightOrNull] instead. It returns `null` when its receiver is empty.
 *
 * @param [operation] function that takes an element and current accumulator value,
 * and calculates the next accumulator value.
 *
 * @sample kool.buffers.Collections.Aggregates.reduceRight
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
 * to each element and current accumulator value.
 *
 * Throws an exception if this array is empty. If the array can be empty in an expected way,
 * please use [reduceRightOrNull] instead. It returns `null` when its receiver is empty.
 *
 * @param [operation] function that takes an element and current accumulator value,
 * and calculates the next accumulator value.
 *
 * @sample kool.buffers.Collections.Aggregates.reduceRight
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
 * to each element and current accumulator value.
 *
 * Throws an exception if this array is empty. If the array can be empty in an expected way,
 * please use [reduceRightOrNull] instead. It returns `null` when its receiver is empty.
 *
 * @param [operation] function that takes an element and current accumulator value,
 * and calculates the next accumulator value.
 *
 * @sample kool.buffers.Collections.Aggregates.reduceRight
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
 * to each element and current accumulator value.
 *
 * Throws an exception if this array is empty. If the array can be empty in an expected way,
 * please use [reduceRightOrNull] instead. It returns `null` when its receiver is empty.
 *
 * @param [operation] function that takes an element and current accumulator value,
 * and calculates the next accumulator value.
 *
 * @sample kool.buffers.Collections.Aggregates.reduceRight
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
 * to each element and current accumulator value.
 *
 * Throws an exception if this array is empty. If the array can be empty in an expected way,
 * please use [reduceRightOrNull] instead. It returns `null` when its receiver is empty.
 *
 * @param [operation] function that takes an element and current accumulator value,
 * and calculates the next accumulator value.
 *
 * @sample kool.buffers.Collections.Aggregates.reduceRight
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
 *
 * @sample kool.buffers.Collections.Aggregates.reduceRight
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
 * Throws an exception if this array is empty. If the array can be empty in an expected way,
 * please use [reduceRightIndexedOrNull] instead. It returns `null` when its receiver is empty.
 *
 * @param [operation] function that takes the index of an element, the element itself and current accumulator value,
 * and calculates the next accumulator value.
 *
 * @sample kool.buffers.Collections.Aggregates.reduceRight
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
 * Throws an exception if this array is empty. If the array can be empty in an expected way,
 * please use [reduceRightIndexedOrNull] instead. It returns `null` when its receiver is empty.
 *
 * @param [operation] function that takes the index of an element, the element itself and current accumulator value,
 * and calculates the next accumulator value.
 *
 * @sample kool.buffers.Collections.Aggregates.reduceRight
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
 * Throws an exception if this array is empty. If the array can be empty in an expected way,
 * please use [reduceRightIndexedOrNull] instead. It returns `null` when its receiver is empty.
 *
 * @param [operation] function that takes the index of an element, the element itself and current accumulator value,
 * and calculates the next accumulator value.
 *
 * @sample kool.buffers.Collections.Aggregates.reduceRight
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
 * Throws an exception if this array is empty. If the array can be empty in an expected way,
 * please use [reduceRightIndexedOrNull] instead. It returns `null` when its receiver is empty.
 *
 * @param [operation] function that takes the index of an element, the element itself and current accumulator value,
 * and calculates the next accumulator value.
 *
 * @sample kool.buffers.Collections.Aggregates.reduceRight
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
 * Throws an exception if this array is empty. If the array can be empty in an expected way,
 * please use [reduceRightIndexedOrNull] instead. It returns `null` when its receiver is empty.
 *
 * @param [operation] function that takes the index of an element, the element itself and current accumulator value,
 * and calculates the next accumulator value.
 *
 * @sample kool.buffers.Collections.Aggregates.reduceRight
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
 * Throws an exception if this array is empty. If the array can be empty in an expected way,
 * please use [reduceRightIndexedOrNull] instead. It returns `null` when its receiver is empty.
 *
 * @param [operation] function that takes the index of an element, the element itself and current accumulator value,
 * and calculates the next accumulator value.
 *
 * @sample kool.buffers.Collections.Aggregates.reduceRight
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
 *
 * @sample kool.buffers.Collections.Aggregates.reduceRightOrNull
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
 * Accumulates value starting with the last element and applying [operation] from right to left
 * to each element with its index in the original array and current accumulator value.
 *
 * Returns `null` if the array is empty.
 *
 * @param [operation] function that takes the index of an element, the element itself and current accumulator value,
 * and calculates the next accumulator value.
 *
 * @sample kool.buffers.Collections.Aggregates.reduceRightOrNull
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
 * Accumulates value starting with the last element and applying [operation] from right to left
 * to each element with its index in the original array and current accumulator value.
 *
 * Returns `null` if the array is empty.
 *
 * @param [operation] function that takes the index of an element, the element itself and current accumulator value,
 * and calculates the next accumulator value.
 *
 * @sample kool.buffers.Collections.Aggregates.reduceRightOrNull
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
 * Accumulates value starting with the last element and applying [operation] from right to left
 * to each element with its index in the original array and current accumulator value.
 *
 * Returns `null` if the array is empty.
 *
 * @param [operation] function that takes the index of an element, the element itself and current accumulator value,
 * and calculates the next accumulator value.
 *
 * @sample kool.buffers.Collections.Aggregates.reduceRightOrNull
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
 * Accumulates value starting with the last element and applying [operation] from right to left
 * to each element with its index in the original array and current accumulator value.
 *
 * Returns `null` if the array is empty.
 *
 * @param [operation] function that takes the index of an element, the element itself and current accumulator value,
 * and calculates the next accumulator value.
 *
 * @sample kool.buffers.Collections.Aggregates.reduceRightOrNull
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
 * Accumulates value starting with the last element and applying [operation] from right to left
 * to each element with its index in the original array and current accumulator value.
 *
 * Returns `null` if the array is empty.
 *
 * @param [operation] function that takes the index of an element, the element itself and current accumulator value,
 * and calculates the next accumulator value.
 *
 * @sample kool.buffers.Collections.Aggregates.reduceRightOrNull
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
 * Accumulates value starting with the last element and applying [operation] from right to left
 * to each element with its index in the original array and current accumulator value.
 *
 * Returns `null` if the array is empty.
 *
 * @param [operation] function that takes the index of an element, the element itself and current accumulator value,
 * and calculates the next accumulator value.
 *
 * @sample kool.buffers.Collections.Aggregates.reduceRightOrNull
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
 * Accumulates value starting with the last element and applying [operation] from right to left
 * to each element and current accumulator value.
 *
 * Returns `null` if the array is empty.
 *
 * @param [operation] function that takes an element and current accumulator value,
 * and calculates the next accumulator value.
 *
 * @sample kool.buffers.Collections.Aggregates.reduceRightOrNull
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
 * Accumulates value starting with the last element and applying [operation] from right to left
 * to each element and current accumulator value.
 *
 * Returns `null` if the array is empty.
 *
 * @param [operation] function that takes an element and current accumulator value,
 * and calculates the next accumulator value.
 *
 * @sample kool.buffers.Collections.Aggregates.reduceRightOrNull
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
 * Accumulates value starting with the last element and applying [operation] from right to left
 * to each element and current accumulator value.
 *
 * Returns `null` if the array is empty.
 *
 * @param [operation] function that takes an element and current accumulator value,
 * and calculates the next accumulator value.
 *
 * @sample kool.buffers.Collections.Aggregates.reduceRightOrNull
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
 * Accumulates value starting with the last element and applying [operation] from right to left
 * to each element and current accumulator value.
 *
 * Returns `null` if the array is empty.
 *
 * @param [operation] function that takes an element and current accumulator value,
 * and calculates the next accumulator value.
 *
 * @sample kool.buffers.Collections.Aggregates.reduceRightOrNull
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
 * Accumulates value starting with the last element and applying [operation] from right to left
 * to each element and current accumulator value.
 *
 * Returns `null` if the array is empty.
 *
 * @param [operation] function that takes an element and current accumulator value,
 * and calculates the next accumulator value.
 *
 * @sample kool.buffers.Collections.Aggregates.reduceRightOrNull
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
 * Accumulates value starting with the last element and applying [operation] from right to left
 * to each element and current accumulator value.
 *
 * Returns `null` if the array is empty.
 *
 * @param [operation] function that takes an element and current accumulator value,
 * and calculates the next accumulator value.
 *
 * @sample kool.buffers.Collections.Aggregates.reduceRightOrNull
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
 * Accumulates value starting with the last element and applying [operation] from right to left
 * to each element and current accumulator value.
 *
 * Returns `null` if the array is empty.
 *
 * @param [operation] function that takes an element and current accumulator value,
 * and calculates the next accumulator value.
 *
 * @sample kool.buffers.Collections.Aggregates.reduceRightOrNull
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
 * Returns a list containing successive accumulation values generated by applying [operation] from left to right
 * to each element and current accumulator value that starts with [initial] value.
 *
 * Note that `acc` value passed to [operation] function should not be mutated;
 * otherwise it would affect the previous value in resulting list.
 *
 * @param [operation] function that takes current accumulator value and an element, and calculates the next accumulator value.
 *
 * @sample kool.buffers.Collections.Aggregates.runningFold
 */
inline fun <R> ByteBuffer.runningFold(initial: R, operation: (acc: R, Byte) -> R): List<R> {
    if (isEmpty()) return listOf(initial)
    val result = ArrayList<R>(lim + 1).apply { add(initial) }
    var accumulator = initial
    for (element in this) {
        accumulator = operation(accumulator, element)
        result.add(accumulator)
    }
    return result
}

/**
 * Returns a list containing successive accumulation values generated by applying [operation] from left to right
 * to each element and current accumulator value that starts with [initial] value.
 *
 * Note that `acc` value passed to [operation] function should not be mutated;
 * otherwise it would affect the previous value in resulting list.
 *
 * @param [operation] function that takes current accumulator value and an element, and calculates the next accumulator value.
 *
 * @sample kool.buffers.Collections.Aggregates.runningFold
 */
inline fun <R> ShortBuffer.runningFold(initial: R, operation: (acc: R, Short) -> R): List<R> {
    if (isEmpty()) return listOf(initial)
    val result = ArrayList<R>(lim + 1).apply { add(initial) }
    var accumulator = initial
    for (element in this) {
        accumulator = operation(accumulator, element)
        result.add(accumulator)
    }
    return result
}

/**
 * Returns a list containing successive accumulation values generated by applying [operation] from left to right
 * to each element and current accumulator value that starts with [initial] value.
 *
 * Note that `acc` value passed to [operation] function should not be mutated;
 * otherwise it would affect the previous value in resulting list.
 *
 * @param [operation] function that takes current accumulator value and an element, and calculates the next accumulator value.
 *
 * @sample kool.buffers.Collections.Aggregates.runningFold
 */
inline fun <R> IntBuffer.runningFold(initial: R, operation: (acc: R, Int) -> R): List<R> {
    if (isEmpty()) return listOf(initial)
    val result = ArrayList<R>(lim + 1).apply { add(initial) }
    var accumulator = initial
    for (element in this) {
        accumulator = operation(accumulator, element)
        result.add(accumulator)
    }
    return result
}

/**
 * Returns a list containing successive accumulation values generated by applying [operation] from left to right
 * to each element and current accumulator value that starts with [initial] value.
 *
 * Note that `acc` value passed to [operation] function should not be mutated;
 * otherwise it would affect the previous value in resulting list.
 *
 * @param [operation] function that takes current accumulator value and an element, and calculates the next accumulator value.
 *
 * @sample kool.buffers.Collections.Aggregates.runningFold
 */
inline fun <R> LongBuffer.runningFold(initial: R, operation: (acc: R, Long) -> R): List<R> {
    if (isEmpty()) return listOf(initial)
    val result = ArrayList<R>(lim + 1).apply { add(initial) }
    var accumulator = initial
    for (element in this) {
        accumulator = operation(accumulator, element)
        result.add(accumulator)
    }
    return result
}

/**
 * Returns a list containing successive accumulation values generated by applying [operation] from left to right
 * to each element and current accumulator value that starts with [initial] value.
 *
 * Note that `acc` value passed to [operation] function should not be mutated;
 * otherwise it would affect the previous value in resulting list.
 *
 * @param [operation] function that takes current accumulator value and an element, and calculates the next accumulator value.
 *
 * @sample kool.buffers.Collections.Aggregates.runningFold
 */
inline fun <R> FloatBuffer.runningFold(initial: R, operation: (acc: R, Float) -> R): List<R> {
    if (isEmpty()) return listOf(initial)
    val result = ArrayList<R>(lim + 1).apply { add(initial) }
    var accumulator = initial
    for (element in this) {
        accumulator = operation(accumulator, element)
        result.add(accumulator)
    }
    return result
}

/**
 * Returns a list containing successive accumulation values generated by applying [operation] from left to right
 * to each element and current accumulator value that starts with [initial] value.
 *
 * Note that `acc` value passed to [operation] function should not be mutated;
 * otherwise it would affect the previous value in resulting list.
 *
 * @param [operation] function that takes current accumulator value and an element, and calculates the next accumulator value.
 *
 * @sample kool.buffers.Collections.Aggregates.runningFold
 */
inline fun <R> DoubleBuffer.runningFold(initial: R, operation: (acc: R, Double) -> R): List<R> {
    if (isEmpty()) return listOf(initial)
    val result = ArrayList<R>(lim + 1).apply { add(initial) }
    var accumulator = initial
    for (element in this) {
        accumulator = operation(accumulator, element)
        result.add(accumulator)
    }
    return result
}

/**
 * Returns a list containing successive accumulation values generated by applying [operation] from left to right
 * to each element and current accumulator value that starts with [initial] value.
 *
 * Note that `acc` value passed to [operation] function should not be mutated;
 * otherwise it would affect the previous value in resulting list.
 *
 * @param [operation] function that takes current accumulator value and an element, and calculates the next accumulator value.
 *
 * @sample kool.buffers.Collections.Aggregates.runningFold
 */
inline fun <R> CharBuffer.runningFold(initial: R, operation: (acc: R, Char) -> R): List<R> {
    if (isEmpty()) return listOf(initial)
    val result = ArrayList<R>(lim + 1).apply { add(initial) }
    var accumulator = initial
    for (element in this) {
        accumulator = operation(accumulator, element)
        result.add(accumulator)
    }
    return result
}


/**
 * Returns a list containing successive accumulation values generated by applying [operation] from left to right
 * to each element, its index in the original array and current accumulator value that starts with [initial] value.
 *
 * Note that `acc` value passed to [operation] function should not be mutated;
 * otherwise it would affect the previous value in resulting list.
 *
 * @param [operation] function that takes the index of an element, current accumulator value
 * and the element itself, and calculates the next accumulator value.
 *
 * @sample kool.buffers.Collections.Aggregates.runningFold
 */
inline fun <R> ByteBuffer.runningFoldIndexed(initial: R, operation: (index: Int, acc: R, Byte) -> R): List<R> {
    if (isEmpty()) return listOf(initial)
    val result = ArrayList<R>(lim + 1).apply { add(initial) }
    var accumulator = initial
    for (index in indices) {
        accumulator = operation(index, accumulator, this[index])
        result.add(accumulator)
    }
    return result
}

/**
 * Returns a list containing successive accumulation values generated by applying [operation] from left to right
 * to each element, its index in the original array and current accumulator value that starts with [initial] value.
 *
 * Note that `acc` value passed to [operation] function should not be mutated;
 * otherwise it would affect the previous value in resulting list.
 *
 * @param [operation] function that takes the index of an element, current accumulator value
 * and the element itself, and calculates the next accumulator value.
 *
 * @sample kool.buffers.Collections.Aggregates.runningFold
 */
inline fun <R> ShortBuffer.runningFoldIndexed(initial: R, operation: (index: Int, acc: R, Short) -> R): List<R> {
    if (isEmpty()) return listOf(initial)
    val result = ArrayList<R>(lim + 1).apply { add(initial) }
    var accumulator = initial
    for (index in indices) {
        accumulator = operation(index, accumulator, this[index])
        result.add(accumulator)
    }
    return result
}

/**
 * Returns a list containing successive accumulation values generated by applying [operation] from left to right
 * to each element, its index in the original array and current accumulator value that starts with [initial] value.
 *
 * Note that `acc` value passed to [operation] function should not be mutated;
 * otherwise it would affect the previous value in resulting list.
 *
 * @param [operation] function that takes the index of an element, current accumulator value
 * and the element itself, and calculates the next accumulator value.
 *
 * @sample kool.buffers.Collections.Aggregates.runningFold
 */
inline fun <R> IntBuffer.runningFoldIndexed(initial: R, operation: (index: Int, acc: R, Int) -> R): List<R> {
    if (isEmpty()) return listOf(initial)
    val result = ArrayList<R>(lim + 1).apply { add(initial) }
    var accumulator = initial
    for (index in indices) {
        accumulator = operation(index, accumulator, this[index])
        result.add(accumulator)
    }
    return result
}

/**
 * Returns a list containing successive accumulation values generated by applying [operation] from left to right
 * to each element, its index in the original array and current accumulator value that starts with [initial] value.
 *
 * Note that `acc` value passed to [operation] function should not be mutated;
 * otherwise it would affect the previous value in resulting list.
 *
 * @param [operation] function that takes the index of an element, current accumulator value
 * and the element itself, and calculates the next accumulator value.
 *
 * @sample kool.buffers.Collections.Aggregates.runningFold
 */
inline fun <R> LongBuffer.runningFoldIndexed(initial: R, operation: (index: Int, acc: R, Long) -> R): List<R> {
    if (isEmpty()) return listOf(initial)
    val result = ArrayList<R>(lim + 1).apply { add(initial) }
    var accumulator = initial
    for (index in indices) {
        accumulator = operation(index, accumulator, this[index])
        result.add(accumulator)
    }
    return result
}

/**
 * Returns a list containing successive accumulation values generated by applying [operation] from left to right
 * to each element, its index in the original array and current accumulator value that starts with [initial] value.
 *
 * Note that `acc` value passed to [operation] function should not be mutated;
 * otherwise it would affect the previous value in resulting list.
 *
 * @param [operation] function that takes the index of an element, current accumulator value
 * and the element itself, and calculates the next accumulator value.
 *
 * @sample kool.buffers.Collections.Aggregates.runningFold
 */
inline fun <R> FloatBuffer.runningFoldIndexed(initial: R, operation: (index: Int, acc: R, Float) -> R): List<R> {
    if (isEmpty()) return listOf(initial)
    val result = ArrayList<R>(lim + 1).apply { add(initial) }
    var accumulator = initial
    for (index in indices) {
        accumulator = operation(index, accumulator, this[index])
        result.add(accumulator)
    }
    return result
}

/**
 * Returns a list containing successive accumulation values generated by applying [operation] from left to right
 * to each element, its index in the original array and current accumulator value that starts with [initial] value.
 *
 * Note that `acc` value passed to [operation] function should not be mutated;
 * otherwise it would affect the previous value in resulting list.
 *
 * @param [operation] function that takes the index of an element, current accumulator value
 * and the element itself, and calculates the next accumulator value.
 *
 * @sample kool.buffers.Collections.Aggregates.runningFold
 */
inline fun <R> DoubleBuffer.runningFoldIndexed(initial: R, operation: (index: Int, acc: R, Double) -> R): List<R> {
    if (isEmpty()) return listOf(initial)
    val result = ArrayList<R>(lim + 1).apply { add(initial) }
    var accumulator = initial
    for (index in indices) {
        accumulator = operation(index, accumulator, this[index])
        result.add(accumulator)
    }
    return result
}

/**
 * Returns a list containing successive accumulation values generated by applying [operation] from left to right
 * to each element, its index in the original array and current accumulator value that starts with [initial] value.
 *
 * Note that `acc` value passed to [operation] function should not be mutated;
 * otherwise it would affect the previous value in resulting list.
 *
 * @param [operation] function that takes the index of an element, current accumulator value
 * and the element itself, and calculates the next accumulator value.
 *
 * @sample kool.buffers.Collections.Aggregates.runningFold
 */
inline fun <R> CharBuffer.runningFoldIndexed(initial: R, operation: (index: Int, acc: R, Char) -> R): List<R> {
    if (isEmpty()) return listOf(initial)
    val result = ArrayList<R>(lim + 1).apply { add(initial) }
    var accumulator = initial
    for (index in indices) {
        accumulator = operation(index, accumulator, this[index])
        result.add(accumulator)
    }
    return result
}


/**
 * Returns a list containing successive accumulation values generated by applying [operation] from left to right
 * to each element and current accumulator value that starts with the first element of this array.
 *
 * @param [operation] function that takes current accumulator value and an element, and calculates the next accumulator value.
 *
 * @sample kool.buffers.Collections.Aggregates.runningReduce
 */
inline fun ByteBuffer.runningReduce(operation: (acc: Byte, Byte) -> Byte): List<Byte> {
    if (isEmpty()) return emptyList()
    var accumulator = this[0]
    val result = ArrayList<Byte>(lim).apply { add(accumulator) }
    for (index in 1 until lim) {
        accumulator = operation(accumulator, this[index])
        result.add(accumulator)
    }
    return result
}

/**
 * Returns a list containing successive accumulation values generated by applying [operation] from left to right
 * to each element and current accumulator value that starts with the first element of this array.
 *
 * @param [operation] function that takes current accumulator value and an element, and calculates the next accumulator value.
 *
 * @sample kool.buffers.Collections.Aggregates.runningReduce
 */
inline fun ShortBuffer.runningReduce(operation: (acc: Short, Short) -> Short): List<Short> {
    if (isEmpty()) return emptyList()
    var accumulator = this[0]
    val result = ArrayList<Short>(lim).apply { add(accumulator) }
    for (index in 1 until lim) {
        accumulator = operation(accumulator, this[index])
        result.add(accumulator)
    }
    return result
}

/**
 * Returns a list containing successive accumulation values generated by applying [operation] from left to right
 * to each element and current accumulator value that starts with the first element of this array.
 *
 * @param [operation] function that takes current accumulator value and an element, and calculates the next accumulator value.
 *
 * @sample kool.buffers.Collections.Aggregates.runningReduce
 */
inline fun IntBuffer.runningReduce(operation: (acc: Int, Int) -> Int): List<Int> {
    if (isEmpty()) return emptyList()
    var accumulator = this[0]
    val result = ArrayList<Int>(lim).apply { add(accumulator) }
    for (index in 1 until lim) {
        accumulator = operation(accumulator, this[index])
        result.add(accumulator)
    }
    return result
}

/**
 * Returns a list containing successive accumulation values generated by applying [operation] from left to right
 * to each element and current accumulator value that starts with the first element of this array.
 *
 * @param [operation] function that takes current accumulator value and an element, and calculates the next accumulator value.
 *
 * @sample kool.buffers.Collections.Aggregates.runningReduce
 */
inline fun LongBuffer.runningReduce(operation: (acc: Long, Long) -> Long): List<Long> {
    if (isEmpty()) return emptyList()
    var accumulator = this[0]
    val result = ArrayList<Long>(lim).apply { add(accumulator) }
    for (index in 1 until lim) {
        accumulator = operation(accumulator, this[index])
        result.add(accumulator)
    }
    return result
}

/**
 * Returns a list containing successive accumulation values generated by applying [operation] from left to right
 * to each element and current accumulator value that starts with the first element of this array.
 *
 * @param [operation] function that takes current accumulator value and an element, and calculates the next accumulator value.
 *
 * @sample kool.buffers.Collections.Aggregates.runningReduce
 */
inline fun FloatBuffer.runningReduce(operation: (acc: Float, Float) -> Float): List<Float> {
    if (isEmpty()) return emptyList()
    var accumulator = this[0]
    val result = ArrayList<Float>(lim).apply { add(accumulator) }
    for (index in 1 until lim) {
        accumulator = operation(accumulator, this[index])
        result.add(accumulator)
    }
    return result
}

/**
 * Returns a list containing successive accumulation values generated by applying [operation] from left to right
 * to each element and current accumulator value that starts with the first element of this array.
 *
 * @param [operation] function that takes current accumulator value and an element, and calculates the next accumulator value.
 *
 * @sample kool.buffers.Collections.Aggregates.runningReduce
 */
inline fun DoubleBuffer.runningReduce(operation: (acc: Double, Double) -> Double): List<Double> {
    if (isEmpty()) return emptyList()
    var accumulator = this[0]
    val result = ArrayList<Double>(lim).apply { add(accumulator) }
    for (index in 1 until lim) {
        accumulator = operation(accumulator, this[index])
        result.add(accumulator)
    }
    return result
}

/**
 * Returns a list containing successive accumulation values generated by applying [operation] from left to right
 * to each element and current accumulator value that starts with the first element of this array.
 *
 * @param [operation] function that takes current accumulator value and an element, and calculates the next accumulator value.
 *
 * @sample kool.buffers.Collections.Aggregates.runningReduce
 */
inline fun CharBuffer.runningReduce(operation: (acc: Char, Char) -> Char): List<Char> {
    if (isEmpty()) return emptyList()
    var accumulator = this[0]
    val result = ArrayList<Char>(lim).apply { add(accumulator) }
    for (index in 1 until lim) {
        accumulator = operation(accumulator, this[index])
        result.add(accumulator)
    }
    return result
}


/**
 * Returns a list containing successive accumulation values generated by applying [operation] from left to right
 * to each element, its index in the original array and current accumulator value that starts with the first element of this array.
 *
 * @param [operation] function that takes the index of an element, current accumulator value
 * and the element itself, and calculates the next accumulator value.
 *
 * @sample kool.buffers.Collections.Aggregates.runningReduce
 */
inline fun ByteBuffer.runningReduceIndexed(operation: (index: Int, acc: Byte, Byte) -> Byte): List<Byte> {
    if (isEmpty()) return emptyList()
    var accumulator = this[0]
    val result = ArrayList<Byte>(lim).apply { add(accumulator) }
    for (index in 1 until lim) {
        accumulator = operation(index, accumulator, this[index])
        result.add(accumulator)
    }
    return result
}

/**
 * Returns a list containing successive accumulation values generated by applying [operation] from left to right
 * to each element, its index in the original array and current accumulator value that starts with the first element of this array.
 *
 * @param [operation] function that takes the index of an element, current accumulator value
 * and the element itself, and calculates the next accumulator value.
 *
 * @sample kool.buffers.Collections.Aggregates.runningReduce
 */
inline fun ShortBuffer.runningReduceIndexed(operation: (index: Int, acc: Short, Short) -> Short): List<Short> {
    if (isEmpty()) return emptyList()
    var accumulator = this[0]
    val result = ArrayList<Short>(lim).apply { add(accumulator) }
    for (index in 1 until lim) {
        accumulator = operation(index, accumulator, this[index])
        result.add(accumulator)
    }
    return result
}

/**
 * Returns a list containing successive accumulation values generated by applying [operation] from left to right
 * to each element, its index in the original array and current accumulator value that starts with the first element of this array.
 *
 * @param [operation] function that takes the index of an element, current accumulator value
 * and the element itself, and calculates the next accumulator value.
 *
 * @sample kool.buffers.Collections.Aggregates.runningReduce
 */
inline fun IntBuffer.runningReduceIndexed(operation: (index: Int, acc: Int, Int) -> Int): List<Int> {
    if (isEmpty()) return emptyList()
    var accumulator = this[0]
    val result = ArrayList<Int>(lim).apply { add(accumulator) }
    for (index in 1 until lim) {
        accumulator = operation(index, accumulator, this[index])
        result.add(accumulator)
    }
    return result
}

/**
 * Returns a list containing successive accumulation values generated by applying [operation] from left to right
 * to each element, its index in the original array and current accumulator value that starts with the first element of this array.
 *
 * @param [operation] function that takes the index of an element, current accumulator value
 * and the element itself, and calculates the next accumulator value.
 *
 * @sample kool.buffers.Collections.Aggregates.runningReduce
 */
inline fun LongBuffer.runningReduceIndexed(operation: (index: Int, acc: Long, Long) -> Long): List<Long> {
    if (isEmpty()) return emptyList()
    var accumulator = this[0]
    val result = ArrayList<Long>(lim).apply { add(accumulator) }
    for (index in 1 until lim) {
        accumulator = operation(index, accumulator, this[index])
        result.add(accumulator)
    }
    return result
}

/**
 * Returns a list containing successive accumulation values generated by applying [operation] from left to right
 * to each element, its index in the original array and current accumulator value that starts with the first element of this array.
 *
 * @param [operation] function that takes the index of an element, current accumulator value
 * and the element itself, and calculates the next accumulator value.
 *
 * @sample kool.buffers.Collections.Aggregates.runningReduce
 */
inline fun FloatBuffer.runningReduceIndexed(operation: (index: Int, acc: Float, Float) -> Float): List<Float> {
    if (isEmpty()) return emptyList()
    var accumulator = this[0]
    val result = ArrayList<Float>(lim).apply { add(accumulator) }
    for (index in 1 until lim) {
        accumulator = operation(index, accumulator, this[index])
        result.add(accumulator)
    }
    return result
}

/**
 * Returns a list containing successive accumulation values generated by applying [operation] from left to right
 * to each element, its index in the original array and current accumulator value that starts with the first element of this array.
 *
 * @param [operation] function that takes the index of an element, current accumulator value
 * and the element itself, and calculates the next accumulator value.
 *
 * @sample kool.buffers.Collections.Aggregates.runningReduce
 */
inline fun DoubleBuffer.runningReduceIndexed(operation: (index: Int, acc: Double, Double) -> Double): List<Double> {
    if (isEmpty()) return emptyList()
    var accumulator = this[0]
    val result = ArrayList<Double>(lim).apply { add(accumulator) }
    for (index in 1 until lim) {
        accumulator = operation(index, accumulator, this[index])
        result.add(accumulator)
    }
    return result
}

/**
 * Returns a list containing successive accumulation values generated by applying [operation] from left to right
 * to each element, its index in the original array and current accumulator value that starts with the first element of this array.
 *
 * @param [operation] function that takes the index of an element, current accumulator value
 * and the element itself, and calculates the next accumulator value.
 *
 * @sample kool.buffers.Collections.Aggregates.runningReduce
 */
inline fun CharBuffer.runningReduceIndexed(operation: (index: Int, acc: Char, Char) -> Char): List<Char> {
    if (isEmpty()) return emptyList()
    var accumulator = this[0]
    val result = ArrayList<Char>(lim).apply { add(accumulator) }
    for (index in 1 until lim) {
        accumulator = operation(index, accumulator, this[index])
        result.add(accumulator)
    }
    return result
}


/**
 * Returns a list containing successive accumulation values generated by applying [operation] from left to right
 * to each element and current accumulator value that starts with [initial] value.
 *
 * Note that `acc` value passed to [operation] function should not be mutated;
 * otherwise it would affect the previous value in resulting list.
 *
 * @param [operation] function that takes current accumulator value and an element, and calculates the next accumulator value.
 *
 * @sample kool.buffers.Collections.Aggregates.scan
 */
inline fun <R> ByteBuffer.scan(initial: R, operation: (acc: R, Byte) -> R): List<R> = runningFold(initial, operation)

/**
 * Returns a list containing successive accumulation values generated by applying [operation] from left to right
 * to each element and current accumulator value that starts with [initial] value.
 *
 * Note that `acc` value passed to [operation] function should not be mutated;
 * otherwise it would affect the previous value in resulting list.
 *
 * @param [operation] function that takes current accumulator value and an element, and calculates the next accumulator value.
 *
 * @sample kool.buffers.Collections.Aggregates.scan
 */
inline fun <R> ShortBuffer.scan(initial: R, operation: (acc: R, Short) -> R): List<R> = runningFold(initial, operation)

/**
 * Returns a list containing successive accumulation values generated by applying [operation] from left to right
 * to each element and current accumulator value that starts with [initial] value.
 *
 * Note that `acc` value passed to [operation] function should not be mutated;
 * otherwise it would affect the previous value in resulting list.
 *
 * @param [operation] function that takes current accumulator value and an element, and calculates the next accumulator value.
 *
 * @sample kool.buffers.Collections.Aggregates.scan
 */
inline fun <R> IntBuffer.scan(initial: R, operation: (acc: R, Int) -> R): List<R> = runningFold(initial, operation)

/**
 * Returns a list containing successive accumulation values generated by applying [operation] from left to right
 * to each element and current accumulator value that starts with [initial] value.
 *
 * Note that `acc` value passed to [operation] function should not be mutated;
 * otherwise it would affect the previous value in resulting list.
 *
 * @param [operation] function that takes current accumulator value and an element, and calculates the next accumulator value.
 *
 * @sample kool.buffers.Collections.Aggregates.scan
 */
inline fun <R> LongBuffer.scan(initial: R, operation: (acc: R, Long) -> R): List<R> = runningFold(initial, operation)

/**
 * Returns a list containing successive accumulation values generated by applying [operation] from left to right
 * to each element and current accumulator value that starts with [initial] value.
 *
 * Note that `acc` value passed to [operation] function should not be mutated;
 * otherwise it would affect the previous value in resulting list.
 *
 * @param [operation] function that takes current accumulator value and an element, and calculates the next accumulator value.
 *
 * @sample kool.buffers.Collections.Aggregates.scan
 */
inline fun <R> FloatBuffer.scan(initial: R, operation: (acc: R, Float) -> R): List<R> = runningFold(initial, operation)

/**
 * Returns a list containing successive accumulation values generated by applying [operation] from left to right
 * to each element and current accumulator value that starts with [initial] value.
 *
 * Note that `acc` value passed to [operation] function should not be mutated;
 * otherwise it would affect the previous value in resulting list.
 *
 * @param [operation] function that takes current accumulator value and an element, and calculates the next accumulator value.
 *
 * @sample kool.buffers.Collections.Aggregates.scan
 */
inline fun <R> DoubleBuffer.scan(initial: R, operation: (acc: R, Double) -> R): List<R> = runningFold(initial, operation)

/**
 * Returns a list containing successive accumulation values generated by applying [operation] from left to right
 * to each element and current accumulator value that starts with [initial] value.
 *
 * Note that `acc` value passed to [operation] function should not be mutated;
 * otherwise it would affect the previous value in resulting list.
 *
 * @param [operation] function that takes current accumulator value and an element, and calculates the next accumulator value.
 *
 * @sample kool.buffers.Collections.Aggregates.scan
 */
inline fun <R> CharBuffer.scan(initial: R, operation: (acc: R, Char) -> R): List<R> = runningFold(initial, operation)


/**
 * Returns a list containing successive accumulation values generated by applying [operation] from left to right
 * to each element, its index in the original array and current accumulator value that starts with [initial] value.
 *
 * Note that `acc` value passed to [operation] function should not be mutated;
 * otherwise it would affect the previous value in resulting list.
 *
 * @param [operation] function that takes the index of an element, current accumulator value
 * and the element itself, and calculates the next accumulator value.
 *
 * @sample kool.buffers.Collections.Aggregates.scan
 */
inline fun <R> ByteBuffer.scanIndexed(initial: R, operation: (index: Int, acc: R, Byte) -> R): List<R> = runningFoldIndexed(initial, operation)

/**
 * Returns a list containing successive accumulation values generated by applying [operation] from left to right
 * to each element, its index in the original array and current accumulator value that starts with [initial] value.
 *
 * Note that `acc` value passed to [operation] function should not be mutated;
 * otherwise it would affect the previous value in resulting list.
 *
 * @param [operation] function that takes the index of an element, current accumulator value
 * and the element itself, and calculates the next accumulator value.
 *
 * @sample kool.buffers.Collections.Aggregates.scan
 */
inline fun <R> ShortBuffer.scanIndexed(initial: R, operation: (index: Int, acc: R, Short) -> R): List<R> = runningFoldIndexed(initial, operation)

/**
 * Returns a list containing successive accumulation values generated by applying [operation] from left to right
 * to each element, its index in the original array and current accumulator value that starts with [initial] value.
 *
 * Note that `acc` value passed to [operation] function should not be mutated;
 * otherwise it would affect the previous value in resulting list.
 *
 * @param [operation] function that takes the index of an element, current accumulator value
 * and the element itself, and calculates the next accumulator value.
 *
 * @sample kool.buffers.Collections.Aggregates.scan
 */
inline fun <R> IntBuffer.scanIndexed(initial: R, operation: (index: Int, acc: R, Int) -> R): List<R> = runningFoldIndexed(initial, operation)

/**
 * Returns a list containing successive accumulation values generated by applying [operation] from left to right
 * to each element, its index in the original array and current accumulator value that starts with [initial] value.
 *
 * Note that `acc` value passed to [operation] function should not be mutated;
 * otherwise it would affect the previous value in resulting list.
 *
 * @param [operation] function that takes the index of an element, current accumulator value
 * and the element itself, and calculates the next accumulator value.
 *
 * @sample kool.buffers.Collections.Aggregates.scan
 */
inline fun <R> LongBuffer.scanIndexed(initial: R, operation: (index: Int, acc: R, Long) -> R): List<R> = runningFoldIndexed(initial, operation)

/**
 * Returns a list containing successive accumulation values generated by applying [operation] from left to right
 * to each element, its index in the original array and current accumulator value that starts with [initial] value.
 *
 * Note that `acc` value passed to [operation] function should not be mutated;
 * otherwise it would affect the previous value in resulting list.
 *
 * @param [operation] function that takes the index of an element, current accumulator value
 * and the element itself, and calculates the next accumulator value.
 *
 * @sample kool.buffers.Collections.Aggregates.scan
 */
inline fun <R> FloatBuffer.scanIndexed(initial: R, operation: (index: Int, acc: R, Float) -> R): List<R> = runningFoldIndexed(initial, operation)

/**
 * Returns a list containing successive accumulation values generated by applying [operation] from left to right
 * to each element, its index in the original array and current accumulator value that starts with [initial] value.
 *
 * Note that `acc` value passed to [operation] function should not be mutated;
 * otherwise it would affect the previous value in resulting list.
 *
 * @param [operation] function that takes the index of an element, current accumulator value
 * and the element itself, and calculates the next accumulator value.
 *
 * @sample kool.buffers.Collections.Aggregates.scan
 */
inline fun <R> DoubleBuffer.scanIndexed(initial: R, operation: (index: Int, acc: R, Double) -> R): List<R> = runningFoldIndexed(initial, operation)

/**
 * Returns a list containing successive accumulation values generated by applying [operation] from left to right
 * to each element, its index in the original array and current accumulator value that starts with [initial] value.
 *
 * Note that `acc` value passed to [operation] function should not be mutated;
 * otherwise it would affect the previous value in resulting list.
 *
 * @param [operation] function that takes the index of an element, current accumulator value
 * and the element itself, and calculates the next accumulator value.
 *
 * @sample kool.buffers.Collections.Aggregates.scan
 */
inline fun <R> CharBuffer.scanIndexed(initial: R, operation: (index: Int, acc: R, Char) -> R): List<R> = runningFoldIndexed(initial, operation)

/** Returns the sum of all values produced by [selector] function applied to each element in the buffer. */
inline fun ByteBuffer.sumBy(selector: (Byte) -> Int): Int {
    var sum = 0
    for (element in this) sum += selector(element)
    return sum
}

/** Returns the sum of all values produced by [selector] function applied to each element in the buffer. */
inline fun ShortBuffer.sumBy(selector: (Short) -> Int): Int {
    var sum = 0
    for (element in this) sum += selector(element)
    return sum
}

/** Returns the sum of all values produced by [selector] function applied to each element in the buffer. */
inline fun IntBuffer.sumBy(selector: (Int) -> Int): Int {
    var sum = 0
    for (element in this) sum += selector(element)
    return sum
}

/** Returns the sum of all values produced by [selector] function applied to each element in the buffer. */
inline fun LongBuffer.sumBy(selector: (Long) -> Int): Int {
    var sum = 0
    for (element in this) sum += selector(element)
    return sum
}

/** Returns the sum of all values produced by [selector] function applied to each element in the buffer. */
inline fun FloatBuffer.sumBy(selector: (Float) -> Int): Int {
    var sum = 0
    for (element in this) sum += selector(element)
    return sum
}

/** Returns the sum of all values produced by [selector] function applied to each element in the buffer. */
inline fun DoubleBuffer.sumBy(selector: (Double) -> Int): Int {
    var sum = 0
    for (element in this) sum += selector(element)
    return sum
}

/** Returns the sum of all values produced by [selector] function applied to each element in the buffer. */
inline fun CharBuffer.sumBy(selector: (Char) -> Int): Int {
    var sum = 0
    for (element in this) sum += selector(element)
    return sum
}


/** Returns the sum of all values produced by [selector] function applied to each element in the array. */
inline fun ByteBuffer.sumByDouble(selector: (Byte) -> Double): Double {
    var sum: Double = 0.0
    for (element in this)
        sum += selector(element)
    return sum
}

/** Returns the sum of all values produced by [selector] function applied to each element in the array. */
inline fun ShortBuffer.sumByDouble(selector: (Short) -> Double): Double {
    var sum: Double = 0.0
    for (element in this)
        sum += selector(element)
    return sum
}

/** Returns the sum of all values produced by [selector] function applied to each element in the array. */
inline fun IntBuffer.sumByDouble(selector: (Int) -> Double): Double {
    var sum: Double = 0.0
    for (element in this)
        sum += selector(element)
    return sum
}

/** Returns the sum of all values produced by [selector] function applied to each element in the array. */
inline fun LongBuffer.sumByDouble(selector: (Long) -> Double): Double {
    var sum: Double = 0.0
    for (element in this)
        sum += selector(element)
    return sum
}

/** Returns the sum of all values produced by [selector] function applied to each element in the array. */
inline fun FloatBuffer.sumByDouble(selector: (Float) -> Double): Double {
    var sum: Double = 0.0
    for (element in this)
        sum += selector(element)
    return sum
}

/** Returns the sum of all values produced by [selector] function applied to each element in the array. */
inline fun DoubleBuffer.sumByDouble(selector: (Double) -> Double): Double {
    var sum: Double = 0.0
    for (element in this)
        sum += selector(element)
    return sum
}

/** Returns the sum of all values produced by [selector] function applied to each element in the array. */
inline fun CharBuffer.sumByDouble(selector: (Char) -> Double): Double {
    var sum: Double = 0.0
    for (element in this)
        sum += selector(element)
    return sum
}


/** Returns the sum of all values produced by [selector] function applied to each element in the array. */
@OptIn(ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
@kotlin.jvm.JvmName("sumOfDouble")
inline fun ByteBuffer.sumOf(selector: (Byte) -> Double): Double {
    var sum: Double = 0.toDouble()
    for (element in this)
        sum += selector(element)
    return sum
}

/** Returns the sum of all values produced by [selector] function applied to each element in the array. */
@OptIn(ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
@kotlin.jvm.JvmName("sumOfDouble")
inline fun ShortBuffer.sumOf(selector: (Short) -> Double): Double {
    var sum: Double = 0.toDouble()
    for (element in this)
        sum += selector(element)
    return sum
}

/** Returns the sum of all values produced by [selector] function applied to each element in the array. */
@OptIn(ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
@kotlin.jvm.JvmName("sumOfDouble")
inline fun IntBuffer.sumOf(selector: (Int) -> Double): Double {
    var sum: Double = 0.toDouble()
    for (element in this)
        sum += selector(element)
    return sum
}

/** Returns the sum of all values produced by [selector] function applied to each element in the array. */
@OptIn(ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
@kotlin.jvm.JvmName("sumOfDouble")
inline fun LongBuffer.sumOf(selector: (Long) -> Double): Double {
    var sum: Double = 0.toDouble()
    for (element in this)
        sum += selector(element)
    return sum
}

/** Returns the sum of all values produced by [selector] function applied to each element in the array. */
@OptIn(ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
@kotlin.jvm.JvmName("sumOfDouble")
inline fun FloatBuffer.sumOf(selector: (Float) -> Double): Double {
    var sum: Double = 0.toDouble()
    for (element in this)
        sum += selector(element)
    return sum
}

/** Returns the sum of all values produced by [selector] function applied to each element in the array. */
@OptIn(ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
@kotlin.jvm.JvmName("sumOfDouble")
inline fun DoubleBuffer.sumOf(selector: (Double) -> Double): Double {
    var sum: Double = 0.toDouble()
    for (element in this)
        sum += selector(element)
    return sum
}

/** Returns the sum of all values produced by [selector] function applied to each element in the array. */
@OptIn(ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
@kotlin.jvm.JvmName("sumOfDouble")
inline fun CharBuffer.sumOf(selector: (Char) -> Double): Double {
    var sum: Double = 0.toDouble()
    for (element in this)
        sum += selector(element)
    return sum
}


/** Returns the sum of all values produced by [selector] function applied to each element in the array. */
@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
@kotlin.jvm.JvmName("sumOfInt")
inline fun ByteBuffer.sumOf(selector: (Byte) -> Int): Int {
    var sum: Int = 0.toInt()
    for (element in this)
        sum += selector(element)
    return sum
}

/** Returns the sum of all values produced by [selector] function applied to each element in the array. */
@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
@kotlin.jvm.JvmName("sumOfInt")
inline fun ShortBuffer.sumOf(selector: (Short) -> Int): Int {
    var sum: Int = 0.toInt()
    for (element in this)
        sum += selector(element)
    return sum
}

/** Returns the sum of all values produced by [selector] function applied to each element in the array. */
@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
@kotlin.jvm.JvmName("sumOfInt")
inline fun IntBuffer.sumOf(selector: (Int) -> Int): Int {
    var sum: Int = 0.toInt()
    for (element in this)
        sum += selector(element)
    return sum
}

/** Returns the sum of all values produced by [selector] function applied to each element in the array. */
@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
@kotlin.jvm.JvmName("sumOfInt")
inline fun LongBuffer.sumOf(selector: (Long) -> Int): Int {
    var sum: Int = 0.toInt()
    for (element in this)
        sum += selector(element)
    return sum
}

/** Returns the sum of all values produced by [selector] function applied to each element in the array. */
@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
@kotlin.jvm.JvmName("sumOfInt")
inline fun FloatBuffer.sumOf(selector: (Float) -> Int): Int {
    var sum: Int = 0.toInt()
    for (element in this)
        sum += selector(element)
    return sum
}

/** Returns the sum of all values produced by [selector] function applied to each element in the array. */
@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
@kotlin.jvm.JvmName("sumOfInt")
inline fun DoubleBuffer.sumOf(selector: (Double) -> Int): Int {
    var sum: Int = 0.toInt()
    for (element in this)
        sum += selector(element)
    return sum
}

/** Returns the sum of all values produced by [selector] function applied to each element in the array. */
@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
@kotlin.jvm.JvmName("sumOfInt")
inline fun CharBuffer.sumOf(selector: (Char) -> Int): Int {
    var sum: Int = 0.toInt()
    for (element in this)
        sum += selector(element)
    return sum
}


/** Returns the sum of all values produced by [selector] function applied to each element in the array. */
@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
@kotlin.jvm.JvmName("sumOfLong")
inline fun ByteBuffer.sumOf(selector: (Byte) -> Long): Long {
    var sum: Long = 0.toLong()
    for (element in this)
        sum += selector(element)
    return sum
}

/** Returns the sum of all values produced by [selector] function applied to each element in the array. */
@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
@kotlin.jvm.JvmName("sumOfLong")
inline fun ShortBuffer.sumOf(selector: (Short) -> Long): Long {
    var sum: Long = 0.toLong()
    for (element in this)
        sum += selector(element)
    return sum
}

/** Returns the sum of all values produced by [selector] function applied to each element in the array. */
@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
@kotlin.jvm.JvmName("sumOfLong")
inline fun IntBuffer.sumOf(selector: (Int) -> Long): Long {
    var sum: Long = 0.toLong()
    for (element in this)
        sum += selector(element)
    return sum
}

/** Returns the sum of all values produced by [selector] function applied to each element in the array. */
@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
@kotlin.jvm.JvmName("sumOfLong")
inline fun LongBuffer.sumOf(selector: (Long) -> Long): Long {
    var sum: Long = 0.toLong()
    for (element in this)
        sum += selector(element)
    return sum
}

/** Returns the sum of all values produced by [selector] function applied to each element in the array. */
@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
@kotlin.jvm.JvmName("sumOfLong")
inline fun FloatBuffer.sumOf(selector: (Float) -> Long): Long {
    var sum: Long = 0.toLong()
    for (element in this)
        sum += selector(element)
    return sum
}

/** Returns the sum of all values produced by [selector] function applied to each element in the array. */
@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
@kotlin.jvm.JvmName("sumOfLong")
inline fun DoubleBuffer.sumOf(selector: (Double) -> Long): Long {
    var sum: Long = 0.toLong()
    for (element in this)
        sum += selector(element)
    return sum
}

/** Returns the sum of all values produced by [selector] function applied to each element in the array. */
@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
@kotlin.jvm.JvmName("sumOfLong")
inline fun CharBuffer.sumOf(selector: (Char) -> Long): Long {
    var sum: Long = 0.toLong()
    for (element in this)
        sum += selector(element)
    return sum
}


/** Returns the sum of all values produced by [selector] function applied to each element in the array. */
@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
@kotlin.jvm.JvmName("sumOfUInt")
@ExperimentalUnsignedTypes
inline fun ByteBuffer.sumOf(selector: (Byte) -> UInt): UInt {
    var sum: UInt = 0.toUInt()
    for (element in this)
        sum += selector(element)
    return sum
}

/** Returns the sum of all values produced by [selector] function applied to each element in the array. */
@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
@kotlin.jvm.JvmName("sumOfUInt")
@ExperimentalUnsignedTypes
inline fun ShortBuffer.sumOf(selector: (Short) -> UInt): UInt {
    var sum: UInt = 0.toUInt()
    for (element in this)
        sum += selector(element)
    return sum
}

/** Returns the sum of all values produced by [selector] function applied to each element in the array. */
@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
@kotlin.jvm.JvmName("sumOfUInt")
@ExperimentalUnsignedTypes
inline fun IntBuffer.sumOf(selector: (Int) -> UInt): UInt {
    var sum: UInt = 0.toUInt()
    for (element in this)
        sum += selector(element)
    return sum
}

/** Returns the sum of all values produced by [selector] function applied to each element in the array. */
@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
@kotlin.jvm.JvmName("sumOfUInt")
@ExperimentalUnsignedTypes
inline fun LongBuffer.sumOf(selector: (Long) -> UInt): UInt {
    var sum: UInt = 0.toUInt()
    for (element in this)
        sum += selector(element)
    return sum
}

/** Returns the sum of all values produced by [selector] function applied to each element in the array. */
@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
@kotlin.jvm.JvmName("sumOfUInt")
@ExperimentalUnsignedTypes
inline fun FloatBuffer.sumOf(selector: (Float) -> UInt): UInt {
    var sum: UInt = 0.toUInt()
    for (element in this)
        sum += selector(element)
    return sum
}

/** Returns the sum of all values produced by [selector] function applied to each element in the array. */
@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
@kotlin.jvm.JvmName("sumOfUInt")
@ExperimentalUnsignedTypes
inline fun DoubleBuffer.sumOf(selector: (Double) -> UInt): UInt {
    var sum: UInt = 0.toUInt()
    for (element in this)
        sum += selector(element)
    return sum
}

/** Returns the sum of all values produced by [selector] function applied to each element in the array. */
@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
@kotlin.jvm.JvmName("sumOfUInt")
@ExperimentalUnsignedTypes
inline fun CharBuffer.sumOf(selector: (Char) -> UInt): UInt {
    var sum: UInt = 0.toUInt()
    for (element in this)
        sum += selector(element)
    return sum
}


/** Returns the sum of all values produced by [selector] function applied to each element in the array. */
@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
@kotlin.jvm.JvmName("sumOfULong")
@ExperimentalUnsignedTypes
inline fun ByteBuffer.sumOf(selector: (Byte) -> ULong): ULong {
    var sum: ULong = 0.toULong()
    for (element in this)
        sum += selector(element)
    return sum
}

/** Returns the sum of all values produced by [selector] function applied to each element in the array. */
@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
@kotlin.jvm.JvmName("sumOfULong")
@ExperimentalUnsignedTypes
inline fun ShortBuffer.sumOf(selector: (Short) -> ULong): ULong {
    var sum: ULong = 0.toULong()
    for (element in this)
        sum += selector(element)
    return sum
}

/** Returns the sum of all values produced by [selector] function applied to each element in the array. */
@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
@kotlin.jvm.JvmName("sumOfULong")
@ExperimentalUnsignedTypes
inline fun IntBuffer.sumOf(selector: (Int) -> ULong): ULong {
    var sum: ULong = 0.toULong()
    for (element in this)
        sum += selector(element)
    return sum
}

/** Returns the sum of all values produced by [selector] function applied to each element in the array. */
@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
@kotlin.jvm.JvmName("sumOfULong")
@ExperimentalUnsignedTypes
inline fun LongBuffer.sumOf(selector: (Long) -> ULong): ULong {
    var sum: ULong = 0.toULong()
    for (element in this)
        sum += selector(element)
    return sum
}

/** Returns the sum of all values produced by [selector] function applied to each element in the array. */
@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
@kotlin.jvm.JvmName("sumOfULong")
@ExperimentalUnsignedTypes
inline fun FloatBuffer.sumOf(selector: (Float) -> ULong): ULong {
    var sum: ULong = 0.toULong()
    for (element in this)
        sum += selector(element)
    return sum
}

/** Returns the sum of all values produced by [selector] function applied to each element in the array. */
@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
@kotlin.jvm.JvmName("sumOfULong")
@ExperimentalUnsignedTypes
inline fun DoubleBuffer.sumOf(selector: (Double) -> ULong): ULong {
    var sum: ULong = 0.toULong()
    for (element in this)
        sum += selector(element)
    return sum
}

/** Returns the sum of all values produced by [selector] function applied to each element in the array. */
@OptIn(kotlin.experimental.ExperimentalTypeInference::class)
@OverloadResolutionByLambdaReturnType
@kotlin.jvm.JvmName("sumOfULong")
@ExperimentalUnsignedTypes
inline fun CharBuffer.sumOf(selector: (Char) -> ULong): ULong {
    var sum: ULong = 0.toULong()
    for (element in this)
        sum += selector(element)
    return sum
}


/**
 * Splits the original array into pair of lists,
 * where *first* list contains elements for which [predicate] yielded `true`,
 * while *second* list contains elements for which [predicate] yielded `false`.
 *
 * @sample kool.buffers.Arrays.Transformations.partitionArrayOfPrimitives
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
 * Splits the original array into pair of lists,
 * where *first* list contains elements for which [predicate] yielded `true`,
 * while *second* list contains elements for which [predicate] yielded `false`.
 *
 * @sample kool.buffers.Arrays.Transformations.partitionArrayOfPrimitives
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
 * Splits the original array into pair of lists,
 * where *first* list contains elements for which [predicate] yielded `true`,
 * while *second* list contains elements for which [predicate] yielded `false`.
 *
 * @sample kool.buffers.Arrays.Transformations.partitionArrayOfPrimitives
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
 * Splits the original array into pair of lists,
 * where *first* list contains elements for which [predicate] yielded `true`,
 * while *second* list contains elements for which [predicate] yielded `false`.
 *
 * @sample kool.buffers.Arrays.Transformations.partitionArrayOfPrimitives
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
 * Splits the original array into pair of lists,
 * where *first* list contains elements for which [predicate] yielded `true`,
 * while *second* list contains elements for which [predicate] yielded `false`.
 *
 * @sample kool.buffers.Arrays.Transformations.partitionArrayOfPrimitives
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
 * Splits the original array into pair of lists,
 * where *first* list contains elements for which [predicate] yielded `true`,
 * while *second* list contains elements for which [predicate] yielded `false`.
 *
 * @sample kool.buffers.Arrays.Transformations.partitionArrayOfPrimitives
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
 * Splits the original array into pair of lists,
 * where *first* list contains elements for which [predicate] yielded `true`,
 * while *second* list contains elements for which [predicate] yielded `false`.
 *
 * @sample kool.buffers.Arrays.Transformations.partitionArrayOfPrimitives
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




/** Returns a list of pairs built from the elements of `this` array and the [other] array with the same index.
 *  The returned list has length of the shortest collection.
 *  @sample kool.buffers.Iterables.Operations.zipIterable */
infix fun <R> ByteBuffer.zip(other: Array<out R>): List<Pair<Byte, R>> = zip(other) { t1, t2 -> t1 to t2 }

/** Returns a list of pairs built from the elements of `this` array and the [other] array with the same index.
 *  The returned list has length of the shortest collection.
 *  @sample kool.buffers.Iterables.Operations.zipIterable */
infix fun <R> ShortBuffer.zip(other: Array<out R>): List<Pair<Short, R>> = zip(other) { t1, t2 -> t1 to t2 }

/** Returns a list of pairs built from the elements of `this` array and the [other] array with the same index.
 *  The returned list has length of the shortest collection.
 *  @sample kool.buffers.Iterables.Operations.zipIterable */
infix fun <R> IntBuffer.zip(other: Array<out R>): List<Pair<Int, R>> = zip(other) { t1, t2 -> t1 to t2 }

/** Returns a list of pairs built from the elements of `this` array and the [other] array with the same index.
 *  The returned list has length of the shortest collection.
 *  @sample kool.buffers.Iterables.Operations.zipIterable */
infix fun <R> LongBuffer.zip(other: Array<out R>): List<Pair<Long, R>> = zip(other) { t1, t2 -> t1 to t2 }

/** Returns a list of pairs built from the elements of `this` array and the [other] array with the same index.
 *  The returned list has length of the shortest collection.
 *  @sample kool.buffers.Iterables.Operations.zipIterable */
infix fun <R> FloatBuffer.zip(other: Array<out R>): List<Pair<Float, R>> = zip(other) { t1, t2 -> t1 to t2 }

/** Returns a list of pairs built from the elements of `this` array and the [other] array with the same index.
 *  The returned list has length of the shortest collection.
 *  @sample kool.buffers.Iterables.Operations.zipIterable */
infix fun <R> DoubleBuffer.zip(other: Array<out R>): List<Pair<Double, R>> = zip(other) { t1, t2 -> t1 to t2 }

/** Returns a list of pairs built from the elements of `this` array and the [other] array with the same index.
 *  The returned list has length of the shortest collection.
 *  @sample kool.buffers.Iterables.Operations.zipIterable */
infix fun <R> CharBuffer.zip(other: Array<out R>): List<Pair<Char, R>> = zip(other) { t1, t2 -> t1 to t2 }


/**
 * Returns a list of values built from the elements of `this` array and the [other] array with the same index
 * using the provided [transform] function applied to each pair of elements.
 * The returned list has length of the shortest collection.
 *
 * @sample kool.buffers.Iterables.Operations.zipIterableWithTransform
 */
inline fun <R, V> ByteBuffer.zip(other: Array<out R>, transform: (a: Byte, b: R) -> V): List<V> {
    val size = minOf(lim, other.size)
    val list = ArrayList<V>(size)
    for (i in 0 until size) {
        list.add(transform(this[i], other[i]))
    }
    return list
}

/**
 * Returns a list of values built from the elements of `this` array and the [other] array with the same index
 * using the provided [transform] function applied to each pair of elements.
 * The returned list has length of the shortest collection.
 *
 * @sample kool.buffers.Iterables.Operations.zipIterableWithTransform
 */
inline fun <R, V> ShortBuffer.zip(other: Array<out R>, transform: (a: Short, b: R) -> V): List<V> {
    val size = minOf(lim, other.size)
    val list = ArrayList<V>(size)
    for (i in 0 until size) {
        list.add(transform(this[i], other[i]))
    }
    return list
}

/**
 * Returns a list of values built from the elements of `this` array and the [other] array with the same index
 * using the provided [transform] function applied to each pair of elements.
 * The returned list has length of the shortest collection.
 *
 * @sample kool.buffers.Iterables.Operations.zipIterableWithTransform
 */
inline fun <R, V> IntBuffer.zip(other: Array<out R>, transform: (a: Int, b: R) -> V): List<V> {
    val size = minOf(lim, other.size)
    val list = ArrayList<V>(size)
    for (i in 0 until size) {
        list.add(transform(this[i], other[i]))
    }
    return list
}

/**
 * Returns a list of values built from the elements of `this` array and the [other] array with the same index
 * using the provided [transform] function applied to each pair of elements.
 * The returned list has length of the shortest collection.
 *
 * @sample kool.buffers.Iterables.Operations.zipIterableWithTransform
 */
inline fun <R, V> LongBuffer.zip(other: Array<out R>, transform: (a: Long, b: R) -> V): List<V> {
    val size = minOf(lim, other.size)
    val list = ArrayList<V>(size)
    for (i in 0 until size) {
        list.add(transform(this[i], other[i]))
    }
    return list
}

/**
 * Returns a list of values built from the elements of `this` array and the [other] array with the same index
 * using the provided [transform] function applied to each pair of elements.
 * The returned list has length of the shortest collection.
 *
 * @sample kool.buffers.Iterables.Operations.zipIterableWithTransform
 */
inline fun <R, V> FloatBuffer.zip(other: Array<out R>, transform: (a: Float, b: R) -> V): List<V> {
    val size = minOf(lim, other.size)
    val list = ArrayList<V>(size)
    for (i in 0 until size) {
        list.add(transform(this[i], other[i]))
    }
    return list
}

/**
 * Returns a list of values built from the elements of `this` array and the [other] array with the same index
 * using the provided [transform] function applied to each pair of elements.
 * The returned list has length of the shortest collection.
 *
 * @sample kool.buffers.Iterables.Operations.zipIterableWithTransform
 */
inline fun <R, V> DoubleBuffer.zip(other: Array<out R>, transform: (a: Double, b: R) -> V): List<V> {
    val size = minOf(lim, other.size)
    val list = ArrayList<V>(size)
    for (i in 0 until size) {
        list.add(transform(this[i], other[i]))
    }
    return list
}

/**
 * Returns a list of values built from the elements of `this` array and the [other] array with the same index
 * using the provided [transform] function applied to each pair of elements.
 * The returned list has length of the shortest collection.
 *
 * @sample kool.buffers.Iterables.Operations.zipIterableWithTransform
 */
inline fun <R, V> CharBuffer.zip(other: Array<out R>, transform: (a: Char, b: R) -> V): List<V> {
    val size = minOf(lim, other.size)
    val list = ArrayList<V>(size)
    for (i in 0 until size) {
        list.add(transform(this[i], other[i]))
    }
    return list
}


/**
 * Returns a list of pairs built from the elements of `this` collection and [other] array with the same index.
 * The returned list has length of the shortest collection.
 *
 * @sample kool.buffers.Iterables.Operations.zipIterable
 */
infix fun <R> ByteBuffer.zip(other: Iterable<R>): List<Pair<Byte, R>> = zip(other) { t1, t2 -> t1 to t2 }

/**
 * Returns a list of pairs built from the elements of `this` collection and [other] array with the same index.
 * The returned list has length of the shortest collection.
 *
 * @sample kool.buffers.Iterables.Operations.zipIterable
 */
infix fun <R> ShortBuffer.zip(other: Iterable<R>): List<Pair<Short, R>> = zip(other) { t1, t2 -> t1 to t2 }

/**
 * Returns a list of pairs built from the elements of `this` collection and [other] array with the same index.
 * The returned list has length of the shortest collection.
 *
 * @sample kool.buffers.Iterables.Operations.zipIterable
 */
infix fun <R> IntBuffer.zip(other: Iterable<R>): List<Pair<Int, R>> = zip(other) { t1, t2 -> t1 to t2 }

/**
 * Returns a list of pairs built from the elements of `this` collection and [other] array with the same index.
 * The returned list has length of the shortest collection.
 *
 * @sample kool.buffers.Iterables.Operations.zipIterable
 */
infix fun <R> LongBuffer.zip(other: Iterable<R>): List<Pair<Long, R>> = zip(other) { t1, t2 -> t1 to t2 }

/**
 * Returns a list of pairs built from the elements of `this` collection and [other] array with the same index.
 * The returned list has length of the shortest collection.
 *
 * @sample kool.buffers.Iterables.Operations.zipIterable
 */
infix fun <R> FloatBuffer.zip(other: Iterable<R>): List<Pair<Float, R>> = zip(other) { t1, t2 -> t1 to t2 }

/**
 * Returns a list of pairs built from the elements of `this` collection and [other] array with the same index.
 * The returned list has length of the shortest collection.
 *
 * @sample kool.buffers.Iterables.Operations.zipIterable
 */
infix fun <R> DoubleBuffer.zip(other: Iterable<R>): List<Pair<Double, R>> = zip(other) { t1, t2 -> t1 to t2 }

/**
 * Returns a list of pairs built from the elements of `this` collection and [other] array with the same index.
 * The returned list has length of the shortest collection.
 *
 * @sample kool.buffers.Iterables.Operations.zipIterable
 */
infix fun <R> CharBuffer.zip(other: Iterable<R>): List<Pair<Char, R>> = zip(other) { t1, t2 -> t1 to t2 }


/**
 * Returns a list of values built from the elements of `this` array and the [other] collection with the same index
 * using the provided [transform] function applied to each pair of elements.
 * The returned list has length of the shortest collection.
 *
 * @sample kool.buffers.Iterables.Operations.zipIterableWithTransform
 */
inline fun <R, V> ByteBuffer.zip(other: Iterable<R>, transform: (a: Byte, b: R) -> V): List<V> {
    val arraySize = lim
    val list = ArrayList<V>(minOf(other.collectionSizeOrDefault(10), arraySize))
    var i = 0
    for (element in other) {
        if (i >= arraySize) break
        list.add(transform(this[i++], element))
    }
    return list
}

/**
 * Returns a list of values built from the elements of `this` array and the [other] collection with the same index
 * using the provided [transform] function applied to each pair of elements.
 * The returned list has length of the shortest collection.
 *
 * @sample kool.buffers.Iterables.Operations.zipIterableWithTransform
 */
inline fun <R, V> ShortBuffer.zip(other: Iterable<R>, transform: (a: Short, b: R) -> V): List<V> {
    val arraySize = lim
    val list = ArrayList<V>(minOf(other.collectionSizeOrDefault(10), arraySize))
    var i = 0
    for (element in other) {
        if (i >= arraySize) break
        list.add(transform(this[i++], element))
    }
    return list
}

/**
 * Returns a list of values built from the elements of `this` array and the [other] collection with the same index
 * using the provided [transform] function applied to each pair of elements.
 * The returned list has length of the shortest collection.
 *
 * @sample kool.buffers.Iterables.Operations.zipIterableWithTransform
 */
inline fun <R, V> IntBuffer.zip(other: Iterable<R>, transform: (a: Int, b: R) -> V): List<V> {
    val arraySize = lim
    val list = ArrayList<V>(minOf(other.collectionSizeOrDefault(10), arraySize))
    var i = 0
    for (element in other) {
        if (i >= arraySize) break
        list.add(transform(this[i++], element))
    }
    return list
}

/**
 * Returns a list of values built from the elements of `this` array and the [other] collection with the same index
 * using the provided [transform] function applied to each pair of elements.
 * The returned list has length of the shortest collection.
 *
 * @sample kool.buffers.Iterables.Operations.zipIterableWithTransform
 */
inline fun <R, V> LongBuffer.zip(other: Iterable<R>, transform: (a: Long, b: R) -> V): List<V> {
    val arraySize = lim
    val list = ArrayList<V>(minOf(other.collectionSizeOrDefault(10), arraySize))
    var i = 0
    for (element in other) {
        if (i >= arraySize) break
        list.add(transform(this[i++], element))
    }
    return list
}

/**
 * Returns a list of values built from the elements of `this` array and the [other] collection with the same index
 * using the provided [transform] function applied to each pair of elements.
 * The returned list has length of the shortest collection.
 *
 * @sample kool.buffers.Iterables.Operations.zipIterableWithTransform
 */
inline fun <R, V> FloatBuffer.zip(other: Iterable<R>, transform: (a: Float, b: R) -> V): List<V> {
    val arraySize = lim
    val list = ArrayList<V>(minOf(other.collectionSizeOrDefault(10), arraySize))
    var i = 0
    for (element in other) {
        if (i >= arraySize) break
        list.add(transform(this[i++], element))
    }
    return list
}

/**
 * Returns a list of values built from the elements of `this` array and the [other] collection with the same index
 * using the provided [transform] function applied to each pair of elements.
 * The returned list has length of the shortest collection.
 *
 * @sample kool.buffers.Iterables.Operations.zipIterableWithTransform
 */
inline fun <R, V> DoubleBuffer.zip(other: Iterable<R>, transform: (a: Double, b: R) -> V): List<V> {
    val arraySize = lim
    val list = ArrayList<V>(minOf(other.collectionSizeOrDefault(10), arraySize))
    var i = 0
    for (element in other) {
        if (i >= arraySize) break
        list.add(transform(this[i++], element))
    }
    return list
}

/**
 * Returns a list of values built from the elements of `this` array and the [other] collection with the same index
 * using the provided [transform] function applied to each pair of elements.
 * The returned list has length of the shortest collection.
 *
 * @sample kool.buffers.Iterables.Operations.zipIterableWithTransform
 */
inline fun <R, V> CharBuffer.zip(other: Iterable<R>, transform: (a: Char, b: R) -> V): List<V> {
    val arraySize = lim
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
 *
 * @sample kool.buffers.Iterables.Operations.zipIterable
 */
infix fun ByteBuffer.zip(other: ByteArray): List<Pair<Byte, Byte>> = zip(other) { t1, t2 -> t1 to t2 }

/**
 * Returns a list of pairs built from the elements of `this` array and the [other] array with the same index.
 * The returned list has length of the shortest collection.
 *
 * @sample kool.buffers.Iterables.Operations.zipIterable
 */
infix fun ShortBuffer.zip(other: ShortArray): List<Pair<Short, Short>> = zip(other) { t1, t2 -> t1 to t2 }

/**
 * Returns a list of pairs built from the elements of `this` array and the [other] array with the same index.
 * The returned list has length of the shortest collection.
 *
 * @sample kool.buffers.Iterables.Operations.zipIterable
 */
infix fun IntBuffer.zip(other: IntArray): List<Pair<Int, Int>> = zip(other) { t1, t2 -> t1 to t2 }

/**
 * Returns a list of pairs built from the elements of `this` array and the [other] array with the same index.
 * The returned list has length of the shortest collection.
 *
 * @sample kool.buffers.Iterables.Operations.zipIterable
 */
infix fun LongBuffer.zip(other: LongArray): List<Pair<Long, Long>> = zip(other) { t1, t2 -> t1 to t2 }

/**
 * Returns a list of pairs built from the elements of `this` array and the [other] array with the same index.
 * The returned list has length of the shortest collection.
 *
 * @sample kool.buffers.Iterables.Operations.zipIterable
 */
infix fun FloatBuffer.zip(other: FloatArray): List<Pair<Float, Float>> = zip(other) { t1, t2 -> t1 to t2 }

/**
 * Returns a list of pairs built from the elements of `this` array and the [other] array with the same index.
 * The returned list has length of the shortest collection.
 *
 * @sample kool.buffers.Iterables.Operations.zipIterable
 */
infix fun DoubleBuffer.zip(other: DoubleArray): List<Pair<Double, Double>> = zip(other) { t1, t2 -> t1 to t2 }

/**
 * Returns a list of pairs built from the elements of `this` array and the [other] array with the same index.
 * The returned list has length of the shortest collection.
 *
 * @sample kool.buffers.Iterables.Operations.zipIterable
 */
infix fun CharBuffer.zip(other: CharArray): List<Pair<Char, Char>> = zip(other) { t1, t2 -> t1 to t2 }


/**
 * Returns a list of values built from the elements of `this` array and the [other] array with the same index
 * using the provided [transform] function applied to each pair of elements.
 * The returned list has length of the shortest array.
 *
 * @sample kool.buffers.Iterables.Operations.zipIterableWithTransform
 */
inline fun <V> ByteBuffer.zip(other: ByteArray, transform: (a: Byte, b: Byte) -> V): List<V> {
    val size = minOf(lim, other.size)
    val list = ArrayList<V>(size)
    for (i in 0 until size)
        list.add(transform(this[i], other[i]))
    return list
}

/**
 * Returns a list of values built from the elements of `this` array and the [other] array with the same index
 * using the provided [transform] function applied to each pair of elements.
 * The returned list has length of the shortest array.
 *
 * @sample kool.buffers.Iterables.Operations.zipIterableWithTransform
 */
inline fun <V> ShortBuffer.zip(other: ShortArray, transform: (a: Short, b: Short) -> V): List<V> {
    val size = minOf(lim, other.size)
    val list = ArrayList<V>(size)
    for (i in 0 until size)
        list.add(transform(this[i], other[i]))
    return list
}

/**
 * Returns a list of values built from the elements of `this` array and the [other] array with the same index
 * using the provided [transform] function applied to each pair of elements.
 * The returned list has length of the shortest array.
 *
 * @sample kool.buffers.Iterables.Operations.zipIterableWithTransform
 */
inline fun <V> IntBuffer.zip(other: IntArray, transform: (a: Int, b: Int) -> V): List<V> {
    val size = minOf(lim, other.size)
    val list = ArrayList<V>(size)
    for (i in 0 until size)
        list.add(transform(this[i], other[i]))
    return list
}

/**
 * Returns a list of values built from the elements of `this` array and the [other] array with the same index
 * using the provided [transform] function applied to each pair of elements.
 * The returned list has length of the shortest array.
 *
 * @sample kool.buffers.Iterables.Operations.zipIterableWithTransform
 */
inline fun <V> LongBuffer.zip(other: LongArray, transform: (a: Long, b: Long) -> V): List<V> {
    val size = minOf(lim, other.size)
    val list = ArrayList<V>(size)
    for (i in 0 until size)
        list.add(transform(this[i], other[i]))
    return list
}

/**
 * Returns a list of values built from the elements of `this` array and the [other] array with the same index
 * using the provided [transform] function applied to each pair of elements.
 * The returned list has length of the shortest array.
 *
 * @sample kool.buffers.Iterables.Operations.zipIterableWithTransform
 */
inline fun <V> FloatBuffer.zip(other: FloatArray, transform: (a: Float, b: Float) -> V): List<V> {
    val size = minOf(lim, other.size)
    val list = ArrayList<V>(size)
    for (i in 0 until size)
        list.add(transform(this[i], other[i]))
    return list
}

/**
 * Returns a list of values built from the elements of `this` array and the [other] array with the same index
 * using the provided [transform] function applied to each pair of elements.
 * The returned list has length of the shortest array.
 *
 * @sample kool.buffers.Iterables.Operations.zipIterableWithTransform
 */
inline fun <V> DoubleBuffer.zip(other: DoubleArray, transform: (a: Double, b: Double) -> V): List<V> {
    val size = minOf(lim, other.size)
    val list = ArrayList<V>(size)
    for (i in 0 until size)
        list.add(transform(this[i], other[i]))
    return list
}

/**
 * Returns a list of values built from the elements of `this` array and the [other] array with the same index
 * using the provided [transform] function applied to each pair of elements.
 * The returned list has length of the shortest array.
 *
 * @sample kool.buffers.Iterables.Operations.zipIterableWithTransform
 */
inline fun <V> CharBuffer.zip(other: CharArray, transform: (a: Char, b: Char) -> V): List<V> {
    val size = minOf(lim, other.size)
    val list = ArrayList<V>(size)
    for (i in 0 until size)
        list.add(transform(this[i], other[i]))
    return list
}


/**
 * Returns a list of pairs built from the elements of `this` array and the [other] array with the same index.
 * The returned list has length of the shortest collection.
 *
 * @sample kool.buffers.Iterables.Operations.zipIterable
 */
infix fun ByteBuffer.zip(other: ByteBuffer): List<Pair<Byte, Byte>> = zip(other) { t1, t2 -> t1 to t2 }

/**
 * Returns a list of pairs built from the elements of `this` array and the [other] array with the same index.
 * The returned list has length of the shortest collection.
 *
 * @sample kool.buffers.Iterables.Operations.zipIterable
 */
infix fun ShortBuffer.zip(other: ShortBuffer): List<Pair<Short, Short>> = zip(other) { t1, t2 -> t1 to t2 }

/**
 * Returns a list of pairs built from the elements of `this` array and the [other] array with the same index.
 * The returned list has length of the shortest collection.
 *
 * @sample kool.buffers.Iterables.Operations.zipIterable
 */
infix fun IntBuffer.zip(other: IntBuffer): List<Pair<Int, Int>> = zip(other) { t1, t2 -> t1 to t2 }

/**
 * Returns a list of pairs built from the elements of `this` array and the [other] array with the same index.
 * The returned list has length of the shortest collection.
 *
 * @sample kool.buffers.Iterables.Operations.zipIterable
 */
infix fun LongBuffer.zip(other: LongBuffer): List<Pair<Long, Long>> = zip(other) { t1, t2 -> t1 to t2 }

/**
 * Returns a list of pairs built from the elements of `this` array and the [other] array with the same index.
 * The returned list has length of the shortest collection.
 *
 * @sample kool.buffers.Iterables.Operations.zipIterable
 */
infix fun FloatBuffer.zip(other: FloatBuffer): List<Pair<Float, Float>> = zip(other) { t1, t2 -> t1 to t2 }

/**
 * Returns a list of pairs built from the elements of `this` array and the [other] array with the same index.
 * The returned list has length of the shortest collection.
 *
 * @sample kool.buffers.Iterables.Operations.zipIterable
 */
infix fun DoubleBuffer.zip(other: DoubleBuffer): List<Pair<Double, Double>> = zip(other) { t1, t2 -> t1 to t2 }

/**
 * Returns a list of pairs built from the elements of `this` array and the [other] array with the same index.
 * The returned list has length of the shortest collection.
 *
 * @sample kool.buffers.Iterables.Operations.zipIterable
 */
infix fun CharBuffer.zip(other: CharBuffer): List<Pair<Char, Char>> = zip(other) { t1, t2 -> t1 to t2 }


/**
 * Returns a list of values built from the elements of `this` array and the [other] array with the same index
 * using the provided [transform] function applied to each pair of elements.
 * The returned list has length of the shortest array.
 *
 * @sample kool.buffers.Iterables.Operations.zipIterableWithTransform
 */
inline fun <V> ByteBuffer.zip(other: ByteBuffer, transform: (a: Byte, b: Byte) -> V): List<V> {
    val size = minOf(lim, other.lim)
    val list = ArrayList<V>(size)
    for (i in 0 until size)
        list.add(transform(this[i], other[i]))
    return list
}

/**
 * Returns a list of values built from the elements of `this` array and the [other] array with the same index
 * using the provided [transform] function applied to each pair of elements.
 * The returned list has length of the shortest array.
 *
 * @sample kool.buffers.Iterables.Operations.zipIterableWithTransform
 */
inline fun <V> ShortBuffer.zip(other: ShortBuffer, transform: (a: Short, b: Short) -> V): List<V> {
    val size = minOf(lim, other.lim)
    val list = ArrayList<V>(size)
    for (i in 0 until size)
        list.add(transform(this[i], other[i]))
    return list
}

/**
 * Returns a list of values built from the elements of `this` array and the [other] array with the same index
 * using the provided [transform] function applied to each pair of elements.
 * The returned list has length of the shortest array.
 *
 * @sample kool.buffers.Iterables.Operations.zipIterableWithTransform
 */
inline fun <V> IntBuffer.zip(other: IntBuffer, transform: (a: Int, b: Int) -> V): List<V> {
    val size = minOf(lim, other.lim)
    val list = ArrayList<V>(size)
    for (i in 0 until size)
        list.add(transform(this[i], other[i]))
    return list
}

/**
 * Returns a list of values built from the elements of `this` array and the [other] array with the same index
 * using the provided [transform] function applied to each pair of elements.
 * The returned list has length of the shortest array.
 *
 * @sample kool.buffers.Iterables.Operations.zipIterableWithTransform
 */
inline fun <V> LongBuffer.zip(other: LongBuffer, transform: (a: Long, b: Long) -> V): List<V> {
    val size = minOf(lim, other.lim)
    val list = ArrayList<V>(size)
    for (i in 0 until size)
        list.add(transform(this[i], other[i]))
    return list
}

/**
 * Returns a list of values built from the elements of `this` array and the [other] array with the same index
 * using the provided [transform] function applied to each pair of elements.
 * The returned list has length of the shortest array.
 *
 * @sample kool.buffers.Iterables.Operations.zipIterableWithTransform
 */
inline fun <V> FloatBuffer.zip(other: FloatBuffer, transform: (a: Float, b: Float) -> V): List<V> {
    val size = minOf(lim, other.lim)
    val list = ArrayList<V>(size)
    for (i in 0 until size)
        list.add(transform(this[i], other[i]))
    return list
}

/**
 * Returns a list of values built from the elements of `this` array and the [other] array with the same index
 * using the provided [transform] function applied to each pair of elements.
 * The returned list has length of the shortest array.
 *
 * @sample kool.buffers.Iterables.Operations.zipIterableWithTransform
 */
inline fun <V> DoubleBuffer.zip(other: DoubleBuffer, transform: (a: Double, b: Double) -> V): List<V> {
    val size = minOf(lim, other.lim)
    val list = ArrayList<V>(size)
    for (i in 0 until size)
        list.add(transform(this[i], other[i]))
    return list
}

/**
 * Returns a list of values built from the elements of `this` array and the [other] array with the same index
 * using the provided [transform] function applied to each pair of elements.
 * The returned list has length of the shortest array.
 *
 * @sample kool.buffers.Iterables.Operations.zipIterableWithTransform
 */
inline fun <V> CharBuffer.zip(other: CharBuffer, transform: (a: Char, b: Char) -> V): List<V> {
    val size = minOf(lim, other.lim)
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
 *
 * @sample kool.buffers.Collections.Transformations.joinTo
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
    if (limit in 0 until count) buffer.append(truncated)
    buffer.append(postfix)
    return buffer
}

/**
 * Appends the string from all the elements separated using [separator] and using the given [prefix] and [postfix] if supplied.
 *
 * If the collection could be huge, you can specify a non-negative value of [limit], in which case only the first [limit]
 * elements will be appended, followed by the [truncated] string (which defaults to "...").
 *
 * @sample kool.buffers.Collections.Transformations.joinTo
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
    if (limit in 0 until count) buffer.append(truncated)
    buffer.append(postfix)
    return buffer
}

/**
 * Appends the string from all the elements separated using [separator] and using the given [prefix] and [postfix] if supplied.
 *
 * If the collection could be huge, you can specify a non-negative value of [limit], in which case only the first [limit]
 * elements will be appended, followed by the [truncated] string (which defaults to "...").
 *
 * @sample kool.buffers.Collections.Transformations.joinTo
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
    if (limit in 0 until count) buffer.append(truncated)
    buffer.append(postfix)
    return buffer
}

/**
 * Appends the string from all the elements separated using [separator] and using the given [prefix] and [postfix] if supplied.
 *
 * If the collection could be huge, you can specify a non-negative value of [limit], in which case only the first [limit]
 * elements will be appended, followed by the [truncated] string (which defaults to "...").
 *
 * @sample kool.buffers.Collections.Transformations.joinTo
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
    if (limit in 0 until count) buffer.append(truncated)
    buffer.append(postfix)
    return buffer
}

/**
 * Appends the string from all the elements separated using [separator] and using the given [prefix] and [postfix] if supplied.
 *
 * If the collection could be huge, you can specify a non-negative value of [limit], in which case only the first [limit]
 * elements will be appended, followed by the [truncated] string (which defaults to "...").
 *
 * @sample kool.buffers.Collections.Transformations.joinTo
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
    if (limit in 0 until count) buffer.append(truncated)
    buffer.append(postfix)
    return buffer
}

/**
 * Appends the string from all the elements separated using [separator] and using the given [prefix] and [postfix] if supplied.
 *
 * If the collection could be huge, you can specify a non-negative value of [limit], in which case only the first [limit]
 * elements will be appended, followed by the [truncated] string (which defaults to "...").
 *
 * @sample kool.buffers.Collections.Transformations.joinTo
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
    if (limit in 0 until count) buffer.append(truncated)
    buffer.append(postfix)
    return buffer
}

/**
 * Appends the string from all the elements separated using [separator] and using the given [prefix] and [postfix] if supplied.
 *
 * If the collection could be huge, you can specify a non-negative value of [limit], in which case only the first [limit]
 * elements will be appended, followed by the [truncated] string (which defaults to "...").
 *
 * @sample kool.buffers.Collections.Transformations.joinTo
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
                buffer.append(element)
        else break
    }
    if (limit in 0 until count) buffer.append(truncated)
    buffer.append(postfix)
    return buffer
}


/**
 * Creates a string from all the elements separated using [separator] and using the given [prefix] and [postfix] if supplied.
 *
 * If the collection could be huge, you can specify a non-negative value of [limit], in which case only the first [limit]
 * elements will be appended, followed by the [truncated] string (which defaults to "...").
 *
 * @sample kool.buffers.Collections.Transformations.joinToString
 */
fun ByteBuffer.joinToString(separator: CharSequence = ", ", prefix: CharSequence = "", postfix: CharSequence = "", limit: Int = -1, truncated: CharSequence = "...", transform: ((Byte) -> CharSequence)? = null): String =
        joinTo(StringBuilder(), separator, prefix, postfix, limit, truncated, transform).toString()

/**
 * Creates a string from all the elements separated using [separator] and using the given [prefix] and [postfix] if supplied.
 *
 * If the collection could be huge, you can specify a non-negative value of [limit], in which case only the first [limit]
 * elements will be appended, followed by the [truncated] string (which defaults to "...").
 *
 * @sample kool.buffers.Collections.Transformations.joinToString
 */
fun ShortBuffer.joinToString(separator: CharSequence = ", ", prefix: CharSequence = "", postfix: CharSequence = "", limit: Int = -1, truncated: CharSequence = "...", transform: ((Short) -> CharSequence)? = null): String =
        joinTo(StringBuilder(), separator, prefix, postfix, limit, truncated, transform).toString()

/**
 * Creates a string from all the elements separated using [separator] and using the given [prefix] and [postfix] if supplied.
 *
 * If the collection could be huge, you can specify a non-negative value of [limit], in which case only the first [limit]
 * elements will be appended, followed by the [truncated] string (which defaults to "...").
 *
 * @sample kool.buffers.Collections.Transformations.joinToString
 */
fun IntBuffer.joinToString(separator: CharSequence = ", ", prefix: CharSequence = "", postfix: CharSequence = "", limit: Int = -1, truncated: CharSequence = "...", transform: ((Int) -> CharSequence)? = null): String =
        joinTo(StringBuilder(), separator, prefix, postfix, limit, truncated, transform).toString()

/**
 * Creates a string from all the elements separated using [separator] and using the given [prefix] and [postfix] if supplied.
 *
 * If the collection could be huge, you can specify a non-negative value of [limit], in which case only the first [limit]
 * elements will be appended, followed by the [truncated] string (which defaults to "...").
 *
 * @sample kool.buffers.Collections.Transformations.joinToString
 */
fun LongBuffer.joinToString(separator: CharSequence = ", ", prefix: CharSequence = "", postfix: CharSequence = "", limit: Int = -1, truncated: CharSequence = "...", transform: ((Long) -> CharSequence)? = null): String =
        joinTo(StringBuilder(), separator, prefix, postfix, limit, truncated, transform).toString()

/**
 * Creates a string from all the elements separated using [separator] and using the given [prefix] and [postfix] if supplied.
 *
 * If the collection could be huge, you can specify a non-negative value of [limit], in which case only the first [limit]
 * elements will be appended, followed by the [truncated] string (which defaults to "...").
 *
 * @sample kool.buffers.Collections.Transformations.joinToString
 */
fun FloatBuffer.joinToString(separator: CharSequence = ", ", prefix: CharSequence = "", postfix: CharSequence = "", limit: Int = -1, truncated: CharSequence = "...", transform: ((Float) -> CharSequence)? = null): String =
        joinTo(StringBuilder(), separator, prefix, postfix, limit, truncated, transform).toString()

/**
 * Creates a string from all the elements separated using [separator] and using the given [prefix] and [postfix] if supplied.
 *
 * If the collection could be huge, you can specify a non-negative value of [limit], in which case only the first [limit]
 * elements will be appended, followed by the [truncated] string (which defaults to "...").
 *
 * @sample kool.buffers.Collections.Transformations.joinToString
 */
fun DoubleBuffer.joinToString(separator: CharSequence = ", ", prefix: CharSequence = "", postfix: CharSequence = "", limit: Int = -1, truncated: CharSequence = "...", transform: ((Double) -> CharSequence)? = null): String =
        joinTo(StringBuilder(), separator, prefix, postfix, limit, truncated, transform).toString()

/**
 * Creates a string from all the elements separated using [separator] and using the given [prefix] and [postfix] if supplied.
 *
 * If the collection could be huge, you can specify a non-negative value of [limit], in which case only the first [limit]
 * elements will be appended, followed by the [truncated] string (which defaults to "...").
 *
 * @sample kool.buffers.Collections.Transformations.joinToString
 */
fun CharBuffer.joinToString(separator: CharSequence = ", ", prefix: CharSequence = "", postfix: CharSequence = "", limit: Int = -1, truncated: CharSequence = "...", transform: ((Char) -> CharSequence)? = null): String =
        joinTo(StringBuilder(), separator, prefix, postfix, limit, truncated, transform).toString()



/** Creates an [Iterable] instance that wraps the original buffer returning its elements when being iterated. */
fun ByteBuffer.asIterable(): Iterable<Byte> {
    if (isEmpty()) return emptyList()
    return Iterable { iterator() }
}

/** Creates an [Iterable] instance that wraps the original buffer returning its elements when being iterated. */
fun ShortBuffer.asIterable(): Iterable<Short> {
    if (isEmpty()) return emptyList()
    return Iterable { iterator() }
}

/** Creates an [Iterable] instance that wraps the original buffer returning its elements when being iterated. */
fun IntBuffer.asIterable(): Iterable<Int> {
    if (isEmpty()) return emptyList()
    return Iterable { iterator() }
}

/** Creates an [Iterable] instance that wraps the original buffer returning its elements when being iterated. */
fun LongBuffer.asIterable(): Iterable<Long> {
    if (isEmpty()) return emptyList()
    return Iterable { iterator() }
}

/** Creates an [Iterable] instance that wraps the original buffer returning its elements when being iterated. */
fun FloatBuffer.asIterable(): Iterable<Float> {
    if (isEmpty()) return emptyList()
    return Iterable { iterator() }
}

/** Creates an [Iterable] instance that wraps the original buffer returning its elements when being iterated. */
fun DoubleBuffer.asIterable(): Iterable<Double> {
    if (isEmpty()) return emptyList()
    return Iterable { iterator() }
}

/** Creates an [Iterable] instance that wraps the original buffer returning its elements when being iterated. */
fun CharBuffer.asIterable(): Iterable<Char> {
    if (isEmpty()) return emptyList()
    return Iterable { iterator() }
}


/** Creates a [Sequence] instance that wraps the original buffer returning its elements when being iterated.
 *  @sample kool.buffers.Sequences.Building.sequenceFromArray */
fun ByteBuffer.asSequence(): Sequence<Byte> {
    if (isEmpty()) return emptySequence()
    return Sequence { iterator() }
}

/** Creates a [Sequence] instance that wraps the original buffer returning its elements when being iterated.
 *  @sample kool.buffers.Sequences.Building.sequenceFromArray */
fun ShortBuffer.asSequence(): Sequence<Short> {
    if (isEmpty()) return emptySequence()
    return Sequence { iterator() }
}

/** Creates a [Sequence] instance that wraps the original buffer returning its elements when being iterated.
 *  @sample kool.buffers.Sequences.Building.sequenceFromArray */
fun IntBuffer.asSequence(): Sequence<Int> {
    if (isEmpty()) return emptySequence()
    return Sequence { iterator() }
}

/** Creates a [Sequence] instance that wraps the original buffer returning its elements when being iterated.
 *  @sample kool.buffers.Sequences.Building.sequenceFromArray */
fun LongBuffer.asSequence(): Sequence<Long> {
    if (isEmpty()) return emptySequence()
    return Sequence { iterator() }
}

/** Creates a [Sequence] instance that wraps the original buffer returning its elements when being iterated.
 *  @sample kool.buffers.Sequences.Building.sequenceFromArray */
fun FloatBuffer.asSequence(): Sequence<Float> {
    if (isEmpty()) return emptySequence()
    return Sequence { iterator() }
}

/** Creates a [Sequence] instance that wraps the original buffer returning its elements when being iterated.
 *  @sample kool.buffers.Sequences.Building.sequenceFromArray */
fun DoubleBuffer.asSequence(): Sequence<Double> {
    if (isEmpty()) return emptySequence()
    return Sequence { iterator() }
}

/** Creates a [Sequence] instance that wraps the original buffer returning its elements when being iterated.
 *  @sample kool.buffers.Sequences.Building.sequenceFromArray */
fun CharBuffer.asSequence(): Sequence<Char> {
    if (isEmpty()) return emptySequence()
    return Sequence { iterator() }
}


/** Returns an average value of elements in the buffer. */
fun ByteBuffer.average(): Double {
    var sum = 0.0
    var count = 0
    for (element in this) {
        sum += element
        count += 1
    }
    return if (count == 0) Double.NaN else sum / count
}

/** Returns an average value of elements in the buffer. */
fun ShortBuffer.average(): Double {
    var sum = 0.0
    var count = 0
    for (element in this) {
        sum += element
        count += 1
    }
    return if (count == 0) Double.NaN else sum / count
}

/** Returns an average value of elements in the buffer. */
fun IntBuffer.average(): Double {
    var sum = 0.0
    var count = 0
    for (element in this) {
        sum += element
        count += 1
    }
    return if (count == 0) Double.NaN else sum / count
}

/** Returns an average value of elements in the buffer. */
fun LongBuffer.average(): Double {
    var sum = 0.0
    var count = 0
    for (element in this) {
        sum += element
        count += 1
    }
    return if (count == 0) Double.NaN else sum / count
}

/** Returns an average value of elements in the buffer. */
fun FloatBuffer.average(): Double {
    var sum = 0.0
    var count = 0
    for (element in this) {
        sum += element
        count += 1
    }
    return if (count == 0) Double.NaN else sum / count
}

/** Returns an average value of elements in the buffer. */
fun DoubleBuffer.average(): Double {
    var sum = 0.0
    var count = 0
    for (element in this) {
        sum += element
        count += 1
    }
    return if (count == 0) Double.NaN else sum / count
}

/** Returns the sum of all elements in the buffer. */
fun ByteBuffer.sum(): Int {
    var sum = 0
    for (element in this) sum += element
    return sum
}

/** Returns the sum of all elements in the buffer. */
fun ShortBuffer.sum(): Int {
    var sum = 0
    for (element in this) sum += element
    return sum
}

/** Returns the sum of all elements in the buffer. */
fun IntBuffer.sum(): Int {
    var sum = 0
    for (element in this) sum += element
    return sum
}

/** Returns the sum of all elements in the buffer. */
fun LongBuffer.sum(): Long {
    var sum = 0L
    for (element in this) sum += element
    return sum
}

/** Returns the sum of all elements in the buffer. */
fun FloatBuffer.sum(): Float {
    var sum = 0f
    for (element in this) sum += element
    return sum
}

/** Returns the sum of all elements in the buffer. */
fun DoubleBuffer.sum(): Double {
    var sum = 0.0
    for (element in this) sum += element
    return sum
}