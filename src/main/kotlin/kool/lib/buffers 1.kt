package kool.lib

import kool.*
import org.lwjgl.system.MemoryUtil.*
import java.nio.*
import kotlin.random.Random

/** Returns 1st *element* from the collection. */
operator fun ByteBuffer.component1(): Byte = get(0)

/** Returns 1st *element* from the collection. */
operator fun ShortBuffer.component1(): Short = get(0)

/** Returns 1st *element* from the collection. */
operator fun IntBuffer.component1(): Int = get(0)

/** Returns 1st *element* from the collection. */
operator fun LongBuffer.component1(): Long = get(0)

/** Returns 1st *element* from the collection. */
operator fun FloatBuffer.component1(): Float = get(0)

/** Returns 1st *element* from the collection. */
operator fun DoubleBuffer.component1(): Double = get(0)

/** Returns 1st *element* from the collection. */
operator fun CharBuffer.component1(): Char = get(0)


/** Returns 2nd *element* from the collection. */
operator fun ByteBuffer.component2(): Byte = get(1)

/** Returns 2nd *element* from the collection. */
operator fun ShortBuffer.component2(): Short = get(1)

/** Returns 2nd *element* from the collection. */
operator fun IntBuffer.component2(): Int = get(1)

/** Returns 2nd *element* from the collection. */
operator fun LongBuffer.component2(): Long = get(1)

/** Returns 2nd *element* from the collection. */
operator fun FloatBuffer.component2(): Float = get(1)

/** Returns 2nd *element* from the collection. */
operator fun DoubleBuffer.component2(): Double = get(1)

/** Returns 2nd *element* from the collection. */
operator fun CharBuffer.component2(): Char = get(1)


/** Returns 3rd *element* from the collection. */
operator fun ByteBuffer.component3(): Byte = get(2)

/** Returns 3rd *element* from the collection. */
operator fun ShortBuffer.component3(): Short = get(2)

/** Returns 3rd *element* from the collection. */
operator fun IntBuffer.component3(): Int = get(2)

/** Returns 3rd *element* from the collection. */
operator fun LongBuffer.component3(): Long = get(2)

/** Returns 3rd *element* from the collection. */
operator fun FloatBuffer.component3(): Float = get(2)

/** Returns 3rd *element* from the collection. */
operator fun DoubleBuffer.component3(): Double = get(2)

/** Returns 3rd *element* from the collection. */
operator fun CharBuffer.component3(): Char = get(2)


/** Returns 4th *element* from the collection. */
operator fun ByteBuffer.component4(): Byte = get(3)

/** Returns 4th *element* from the collection. */
operator fun ShortBuffer.component4(): Short = get(3)

/** Returns 4th *element* from the collection. */
operator fun IntBuffer.component4(): Int = get(3)

/** Returns 4th *element* from the collection. */
operator fun LongBuffer.component4(): Long = get(3)

/** Returns 4th *element* from the collection. */
operator fun FloatBuffer.component4(): Float = get(3)

/** Returns 4th *element* from the collection. */
operator fun DoubleBuffer.component4(): Double = get(3)

/** Returns 4th *element* from the collection. */
operator fun CharBuffer.component4(): Char = get(3)


/** Returns 5th *element* from the collection. */
operator fun ByteBuffer.component5(): Byte = get(4)

/** Returns 5th *element* from the collection. */
operator fun ShortBuffer.component5(): Short = get(4)

/** Returns 5th *element* from the collection. */
operator fun IntBuffer.component5(): Int = get(4)

/** Returns 5th *element* from the collection. */
operator fun LongBuffer.component5(): Long = get(4)

/** Returns 5th *element* from the collection. */
operator fun FloatBuffer.component5(): Float = get(4)

/** Returns 5th *element* from the collection. */
operator fun DoubleBuffer.component5(): Double = get(4)

/** Returns 5th *element* from the collection. */
operator fun CharBuffer.component5(): Char = get(4)


/** Returns `true` if [element] is found in the buffer. */
operator fun ByteBuffer.contains(element: Byte): Boolean = indexOf(element) >= 0

/** Returns `true` if [element] is found in the buffer. */
operator fun ShortBuffer.contains(element: Short): Boolean = indexOf(element) >= 0

/** Returns `true` if [element] is found in the buffer. */
operator fun IntBuffer.contains(element: Int): Boolean = indexOf(element) >= 0

/** Returns `true` if [element] is found in the buffer. */
operator fun LongBuffer.contains(element: Long): Boolean = indexOf(element) >= 0

/** Returns `true` if [element] is found in the buffer. */
operator fun FloatBuffer.contains(element: Float): Boolean = indexOf(element) >= 0

/** Returns `true` if [element] is found in the buffer. */
operator fun DoubleBuffer.contains(element: Double): Boolean = indexOf(element) >= 0

/** Returns `true` if [element] is found in the buffer. */
operator fun CharBuffer.contains(element: Char): Boolean = indexOf(element) >= 0


/** Returns an element at the given [index] or throws an [IndexOutOfBoundsException] if the [index] is out of bounds of this buffer. */
fun ByteBuffer.elementAt(index: Int): Byte = get(index)

/** Returns an element at the given [index] or throws an [IndexOutOfBoundsException] if the [index] is out of bounds of this buffer. */
fun ShortBuffer.elementAt(index: Int): Short = get(index)

/** Returns an element at the given [index] or throws an [IndexOutOfBoundsException] if the [index] is out of bounds of this buffer. */
fun IntBuffer.elementAt(index: Int): Int = get(index)

/** Returns an element at the given [index] or throws an [IndexOutOfBoundsException] if the [index] is out of bounds of this buffer. */
fun LongBuffer.elementAt(index: Int): Long = get(index)

/** Returns an element at the given [index] or throws an [IndexOutOfBoundsException] if the [index] is out of bounds of this buffer. */
fun FloatBuffer.elementAt(index: Int): Float = get(index)

/** Returns an element at the given [index] or throws an [IndexOutOfBoundsException] if the [index] is out of bounds of this buffer. */
fun DoubleBuffer.elementAt(index: Int): Double = get(index)

/** Returns an element at the given [index] or throws an [IndexOutOfBoundsException] if the [index] is out of bounds of this buffer. */
fun CharBuffer.elementAt(index: Int): Char = get(index)


/** Returns an element at the given [index] or the result of calling the [defaultValue] function if the [index] is out of bounds of this buffer. */
inline fun ByteBuffer.elementAtOrElse(index: Int, defaultValue: (Int) -> Byte): Byte = if (index in 0..lastIndex) get(index) else defaultValue(index)

/** Returns an element at the given [index] or the result of calling the [defaultValue] function if the [index] is out of bounds of this buffer. */
inline fun ShortBuffer.elementAtOrElse(index: Int, defaultValue: (Int) -> Short): Short = if (index in 0..lastIndex) get(index) else defaultValue(index)

/** Returns an element at the given [index] or the result of calling the [defaultValue] function if the [index] is out of bounds of this buffer. */
inline fun IntBuffer.elementAtOrElse(index: Int, defaultValue: (Int) -> Int): Int = if (index in 0..lastIndex) get(index) else defaultValue(index)

/** Returns an element at the given [index] or the result of calling the [defaultValue] function if the [index] is out of bounds of this buffer. */
inline fun LongBuffer.elementAtOrElse(index: Int, defaultValue: (Int) -> Long): Long = if (index in 0..lastIndex) get(index) else defaultValue(index)

/** Returns an element at the given [index] or the result of calling the [defaultValue] function if the [index] is out of bounds of this buffer. */
inline fun FloatBuffer.elementAtOrElse(index: Int, defaultValue: (Int) -> Float): Float = if (index in 0..lastIndex) get(index) else defaultValue(index)

/** Returns an element at the given [index] or the result of calling the [defaultValue] function if the [index] is out of bounds of this buffer. */
inline fun DoubleBuffer.elementAtOrElse(index: Int, defaultValue: (Int) -> Double): Double = if (index in 0..lastIndex) get(index) else defaultValue(index)

/** Returns an element at the given [index] or the result of calling the [defaultValue] function if the [index] is out of bounds of this buffer. */
inline fun CharBuffer.elementAtOrElse(index: Int, defaultValue: (Int) -> Char): Char = if (index in 0..lastIndex) get(index) else defaultValue(index)


/** Returns an element at the given [index] or `null` if the [index] is out of bounds of this buffer. */
fun ByteBuffer.elementAtOrNull(index: Int): Byte? = getOrNull(index)

/** Returns an element at the given [index] or `null` if the [index] is out of bounds of this buffer. */
fun ShortBuffer.elementAtOrNull(index: Int): Short? = getOrNull(index)

/** Returns an element at the given [index] or `null` if the [index] is out of bounds of this buffer. */
fun IntBuffer.elementAtOrNull(index: Int): Int? = getOrNull(index)

/** Returns an element at the given [index] or `null` if the [index] is out of bounds of this buffer. */
fun LongBuffer.elementAtOrNull(index: Int): Long? = getOrNull(index)

/** Returns an element at the given [index] or `null` if the [index] is out of bounds of this buffer. */
fun FloatBuffer.elementAtOrNull(index: Int): Float? = getOrNull(index)

/** Returns an element at the given [index] or `null` if the [index] is out of bounds of this buffer. */
fun DoubleBuffer.elementAtOrNull(index: Int): Double? = getOrNull(index)

/** Returns an element at the given [index] or `null` if the [index] is out of bounds of this buffer. */
fun CharBuffer.elementAtOrNull(index: Int): Char? = getOrNull(index)


/** Returns the first element matching the given [predicate], or `null` if no such element was found. */
inline fun ByteBuffer.find(predicate: (Byte) -> Boolean): Byte? = firstOrNull(predicate)

/** Returns the first element matching the given [predicate], or `null` if no such element was found. */
inline fun ShortBuffer.find(predicate: (Short) -> Boolean): Short? = firstOrNull(predicate)

/** Returns the first element matching the given [predicate], or `null` if no such element was found. */
inline fun IntBuffer.find(predicate: (Int) -> Boolean): Int? = firstOrNull(predicate)

/** Returns the first element matching the given [predicate], or `null` if no such element was found. */
inline fun LongBuffer.find(predicate: (Long) -> Boolean): Long? = firstOrNull(predicate)

/** Returns the first element matching the given [predicate], or `null` if no such element was found. */
inline fun FloatBuffer.find(predicate: (Float) -> Boolean): Float? = firstOrNull(predicate)

/** Returns the first element matching the given [predicate], or `null` if no such element was found. */
inline fun DoubleBuffer.find(predicate: (Double) -> Boolean): Double? = firstOrNull(predicate)

/** Returns the first element matching the given [predicate], or `null` if no such element was found. */
inline fun CharBuffer.find(predicate: (Char) -> Boolean): Char? = firstOrNull(predicate)


/** Returns the last element matching the given [predicate], or `null` if no such element was found. */
inline fun ByteBuffer.findLast(predicate: (Byte) -> Boolean): Byte? = lastOrNull(predicate)

/** Returns the last element matching the given [predicate], or `null` if no such element was found. */
inline fun ShortBuffer.findLast(predicate: (Short) -> Boolean): Short? = lastOrNull(predicate)

/** Returns the last element matching the given [predicate], or `null` if no such element was found. */
inline fun IntBuffer.findLast(predicate: (Int) -> Boolean): Int? = lastOrNull(predicate)

/** Returns the last element matching the given [predicate], or `null` if no such element was found. */
inline fun LongBuffer.findLast(predicate: (Long) -> Boolean): Long? = lastOrNull(predicate)

/** Returns the last element matching the given [predicate], or `null` if no such element was found. */
inline fun FloatBuffer.findLast(predicate: (Float) -> Boolean): Float? = lastOrNull(predicate)

/** Returns the last element matching the given [predicate], or `null` if no such element was found. */
inline fun DoubleBuffer.findLast(predicate: (Double) -> Boolean): Double? = lastOrNull(predicate)

/** Returns the last element matching the given [predicate], or `null` if no such element was found. */
inline fun CharBuffer.findLast(predicate: (Char) -> Boolean): Char? = lastOrNull(predicate)


/** Returns first element.
 *  @throws [NoSuchElementException] if the buffer is empty. */
fun ByteBuffer.first(): Byte = if (isEmpty()) throw NoSuchElementException("Array is empty.") else this[0]

/** Returns first element.
 *  @throws [NoSuchElementException] if the buffer is empty. */
fun ShortBuffer.first(): Short = if (isEmpty()) throw NoSuchElementException("Array is empty.") else this[0]

/** Returns first element.
 *  @throws [NoSuchElementException] if the buffer is empty. */
fun IntBuffer.first(): Int = if (isEmpty()) throw NoSuchElementException("Array is empty.") else this[0]

/** Returns first element.
 *  @throws [NoSuchElementException] if the buffer is empty. */
fun LongBuffer.first(): Long = if (isEmpty()) throw NoSuchElementException("Array is empty.") else this[0]

/** Returns first element.
 *  @throws [NoSuchElementException] if the buffer is empty. */
fun FloatBuffer.first(): Float = if (isEmpty()) throw NoSuchElementException("Array is empty.") else this[0]

/** Returns first element.
 *  @throws [NoSuchElementException] if the buffer is empty. */
fun DoubleBuffer.first(): Double = if (isEmpty()) throw NoSuchElementException("Array is empty.") else this[0]

/** Returns first element.
 *  @throws [NoSuchElementException] if the buffer is empty. */
fun CharBuffer.first(): Char = if (isEmpty()) throw NoSuchElementException("Array is empty.") else this[0]


/** Returns the first element matching the given [predicate].
 *  @throws [NoSuchElementException] if no such element is found. */
inline fun ByteBuffer.first(predicate: (Byte) -> Boolean): Byte {
    for (element in this) if (predicate(element)) return element
    throw NoSuchElementException("Array contains no element matching the predicate.")
}

/** Returns the first element matching the given [predicate].
 *  @throws [NoSuchElementException] if no such element is found. */
inline fun ShortBuffer.first(predicate: (Short) -> Boolean): Short {
    for (element in this) if (predicate(element)) return element
    throw NoSuchElementException("Array contains no element matching the predicate.")
}

/** Returns the first element matching the given [predicate].
 *  @throws [NoSuchElementException] if no such element is found. */
inline fun IntBuffer.first(predicate: (Int) -> Boolean): Int {
    for (element in this) if (predicate(element)) return element
    throw NoSuchElementException("Array contains no element matching the predicate.")
}

/** Returns the first element matching the given [predicate].
 *  @throws [NoSuchElementException] if no such element is found. */
inline fun LongBuffer.first(predicate: (Long) -> Boolean): Long {
    for (element in this) if (predicate(element)) return element
    throw NoSuchElementException("Array contains no element matching the predicate.")
}

/** Returns the first element matching the given [predicate].
 *  @throws [NoSuchElementException] if no such element is found. */
inline fun FloatBuffer.first(predicate: (Float) -> Boolean): Float {
    for (element in this) if (predicate(element)) return element
    throw NoSuchElementException("Array contains no element matching the predicate.")
}

/** Returns the first element matching the given [predicate].
 *  @throws [NoSuchElementException] if no such element is found. */
inline fun DoubleBuffer.first(predicate: (Double) -> Boolean): Double {
    for (element in this) if (predicate(element)) return element
    throw NoSuchElementException("Array contains no element matching the predicate.")
}

/** Returns the first element matching the given [predicate].
 *  @throws [NoSuchElementException] if no such element is found. */
inline fun CharBuffer.first(predicate: (Char) -> Boolean): Char {
    for (element in this) if (predicate(element)) return element
    throw NoSuchElementException("Array contains no element matching the predicate.")
}


/** Returns the first element, or `null` if the buffer is empty. */
fun ByteBuffer.firstOrNull(): Byte? = if (isEmpty()) null else this[0]

/** Returns the first element, or `null` if the buffer is empty. */
fun ShortBuffer.firstOrNull(): Short? = if (isEmpty()) null else this[0]

/** Returns the first element, or `null` if the buffer is empty. */
fun IntBuffer.firstOrNull(): Int? = if (isEmpty()) null else this[0]

/** Returns the first element, or `null` if the buffer is empty. */
fun LongBuffer.firstOrNull(): Long? = if (isEmpty()) null else this[0]

/** Returns the first element, or `null` if the buffer is empty. */
fun FloatBuffer.firstOrNull(): Float? = if (isEmpty()) null else this[0]

/** Returns the first element, or `null` if the buffer is empty. */
fun DoubleBuffer.firstOrNull(): Double? = if (isEmpty()) null else this[0]

/** Returns the first element, or `null` if the buffer is empty. */
fun CharBuffer.firstOrNull(): Char? = if (isEmpty()) null else this[0]


/** Returns the first element matching the given [predicate], or `null` if element was not found. */
inline fun ByteBuffer.firstOrNull(predicate: (Byte) -> Boolean): Byte? {
    for (element in this) if (predicate(element)) return element
    return null
}

/** Returns the first element matching the given [predicate], or `null` if element was not found. */
inline fun ShortBuffer.firstOrNull(predicate: (Short) -> Boolean): Short? {
    for (element in this) if (predicate(element)) return element
    return null
}

/** Returns the first element matching the given [predicate], or `null` if element was not found. */
inline fun IntBuffer.firstOrNull(predicate: (Int) -> Boolean): Int? {
    for (element in this) if (predicate(element)) return element
    return null
}

/** Returns the first element matching the given [predicate], or `null` if element was not found. */
inline fun LongBuffer.firstOrNull(predicate: (Long) -> Boolean): Long? {
    for (element in this) if (predicate(element)) return element
    return null
}

/** Returns the first element matching the given [predicate], or `null` if element was not found. */
inline fun FloatBuffer.firstOrNull(predicate: (Float) -> Boolean): Float? {
    for (element in this) if (predicate(element)) return element
    return null
}

/** Returns the first element matching the given [predicate], or `null` if element was not found. */
inline fun DoubleBuffer.firstOrNull(predicate: (Double) -> Boolean): Double? {
    for (element in this) if (predicate(element)) return element
    return null
}

/** Returns the first element matching the given [predicate], or `null` if element was not found. */
inline fun CharBuffer.firstOrNull(predicate: (Char) -> Boolean): Char? {
    for (element in this) if (predicate(element)) return element
    return null
}


/** Returns an element at the given [index] or the result of calling the [defaultValue] function if the [index] is out of bounds of this buffer. */
inline fun ByteBuffer.getOrElse(index: Int, defaultValue: (Int) -> Byte): Byte = if (index in 0..lastIndex) get(index) else defaultValue(index)

/** Returns an element at the given [index] or the result of calling the [defaultValue] function if the [index] is out of bounds of this buffer. */
inline fun ShortBuffer.getOrElse(index: Int, defaultValue: (Int) -> Short): Short = if (index in 0..lastIndex) get(index) else defaultValue(index)

/** Returns an element at the given [index] or the result of calling the [defaultValue] function if the [index] is out of bounds of this buffer. */
inline fun IntBuffer.getOrElse(index: Int, defaultValue: (Int) -> Int): Int = if (index in 0..lastIndex) get(index) else defaultValue(index)

/** Returns an element at the given [index] or the result of calling the [defaultValue] function if the [index] is out of bounds of this buffer. */
inline fun LongBuffer.getOrElse(index: Int, defaultValue: (Int) -> Long): Long = if (index in 0..lastIndex) get(index) else defaultValue(index)

/** Returns an element at the given [index] or the result of calling the [defaultValue] function if the [index] is out of bounds of this buffer. */
inline fun FloatBuffer.getOrElse(index: Int, defaultValue: (Int) -> Float): Float = if (index in 0..lastIndex) get(index) else defaultValue(index)

/** Returns an element at the given [index] or the result of calling the [defaultValue] function if the [index] is out of bounds of this buffer. */
inline fun DoubleBuffer.getOrElse(index: Int, defaultValue: (Int) -> Double): Double = if (index in 0..lastIndex) get(index) else defaultValue(index)

/** Returns an element at the given [index] or the result of calling the [defaultValue] function if the [index] is out of bounds of this buffer. */
inline fun CharBuffer.getOrElse(index: Int, defaultValue: (Int) -> Char): Char = if (index in 0..lastIndex) get(index) else defaultValue(index)


/** Returns an element at the given [index] or `null` if the [index] is out of bounds of this buffer. */
fun ByteBuffer.getOrNull(index: Int): Byte? = if (index in 0..lastIndex) get(index) else null

/** Returns an element at the given [index] or `null` if the [index] is out of bounds of this buffer. */
fun ShortBuffer.getOrNull(index: Int): Short? = if (index in 0..lastIndex) get(index) else null

/** Returns an element at the given [index] or `null` if the [index] is out of bounds of this buffer. */
fun IntBuffer.getOrNull(index: Int): Int? = if (index in 0..lastIndex) get(index) else null

/** Returns an element at the given [index] or `null` if the [index] is out of bounds of this buffer. */
fun LongBuffer.getOrNull(index: Int): Long? = if (index in 0..lastIndex) get(index) else null

/** Returns an element at the given [index] or `null` if the [index] is out of bounds of this buffer. */
fun FloatBuffer.getOrNull(index: Int): Float? = if (index in 0..lastIndex) get(index) else null

/** Returns an element at the given [index] or `null` if the [index] is out of bounds of this buffer. */
fun DoubleBuffer.getOrNull(index: Int): Double? = if (index in 0..lastIndex) get(index) else null

/** Returns an element at the given [index] or `null` if the [index] is out of bounds of this buffer. */
fun CharBuffer.getOrNull(index: Int): Char? = if (index in 0..lastIndex) get(index) else null


/** Returns first index of [element], or -1 if the buffer does not contain element. */
fun ByteBuffer.indexOf(element: Byte): Int {
    for (index in indices)
        if (element == this[index])
            return index
    return -1
}

/** Returns first index of [element], or -1 if the buffer does not contain element. */
fun ShortBuffer.indexOf(element: Short): Int {
    for (index in indices)
        if (element == this[index])
            return index
    return -1
}

/** Returns first index of [element], or -1 if the buffer does not contain element. */
fun IntBuffer.indexOf(element: Int): Int {
    for (index in indices)
        if (element == this[index])
            return index
    return -1
}

/** Returns first index of [element], or -1 if the buffer does not contain element. */
fun LongBuffer.indexOf(element: Long): Int {
    for (index in indices)
        if (element == this[index])
            return index
    return -1
}

/** Returns first index of [element], or -1 if the buffer does not contain element. */
fun FloatBuffer.indexOf(element: Float): Int {
    for (index in indices)
        if (element == this[index])
            return index
    return -1
}

/** Returns first index of [element], or -1 if the buffer does not contain element. */
fun DoubleBuffer.indexOf(element: Double): Int {
    for (index in indices)
        if (element == this[index])
            return index
    return -1
}

/** Returns first index of [element], or -1 if the buffer does not contain element. */
fun CharBuffer.indexOf(element: Char): Int {
    for (index in indices)
        if (element == this[index])
            return index
    return -1
}


/** Returns index of the first element matching the given [predicate], or -1 if the buffer does not contain such element. */
inline fun ByteBuffer.indexOfFirst(predicate: (Byte) -> Boolean): Int {
    for (index in indices)
        if (predicate(this[index]))
            return index
    return -1
}

/** Returns index of the first element matching the given [predicate], or -1 if the buffer does not contain such element. */
inline fun ShortBuffer.indexOfFirst(predicate: (Short) -> Boolean): Int {
    for (index in indices)
        if (predicate(this[index]))
            return index
    return -1
}

/** Returns index of the first element matching the given [predicate], or -1 if the buffer does not contain such element. */
inline fun IntBuffer.indexOfFirst(predicate: (Int) -> Boolean): Int {
    for (index in indices)
        if (predicate(this[index]))
            return index
    return -1
}

/** Returns index of the first element matching the given [predicate], or -1 if the buffer does not contain such element. */
inline fun LongBuffer.indexOfFirst(predicate: (Long) -> Boolean): Int {
    for (index in indices)
        if (predicate(this[index]))
            return index
    return -1
}

/** Returns index of the first element matching the given [predicate], or -1 if the buffer does not contain such element. */
inline fun FloatBuffer.indexOfFirst(predicate: (Float) -> Boolean): Int {
    for (index in indices)
        if (predicate(this[index]))
            return index
    return -1
}

/** Returns index of the first element matching the given [predicate], or -1 if the buffer does not contain such element. */
inline fun DoubleBuffer.indexOfFirst(predicate: (Double) -> Boolean): Int {
    for (index in indices)
        if (predicate(this[index]))
            return index
    return -1
}

/** Returns index of the first element matching the given [predicate], or -1 if the buffer does not contain such element. */
inline fun CharBuffer.indexOfFirst(predicate: (Char) -> Boolean): Int {
    for (index in indices)
        if (predicate(this[index]))
            return index
    return -1
}


/** Returns index of the last element matching the given [predicate], or -1 if the buffer does not contain such element. */
inline fun ByteBuffer.indexOfLast(predicate: (Byte) -> Boolean): Int {
    for (index in indices.reversed())
        if (predicate(this[index]))
            return index
    return -1
}

/** Returns index of the last element matching the given [predicate], or -1 if the buffer does not contain such element. */
inline fun ShortBuffer.indexOfLast(predicate: (Short) -> Boolean): Int {
    for (index in indices.reversed())
        if (predicate(this[index]))
            return index
    return -1
}

/** Returns index of the last element matching the given [predicate], or -1 if the buffer does not contain such element. */
inline fun IntBuffer.indexOfLast(predicate: (Int) -> Boolean): Int {
    for (index in indices.reversed())
        if (predicate(this[index]))
            return index
    return -1
}

/** Returns index of the last element matching the given [predicate], or -1 if the buffer does not contain such element. */
inline fun LongBuffer.indexOfLast(predicate: (Long) -> Boolean): Int {
    for (index in indices.reversed())
        if (predicate(this[index]))
            return index
    return -1
}

/** Returns index of the last element matching the given [predicate], or -1 if the buffer does not contain such element. */
inline fun FloatBuffer.indexOfLast(predicate: (Float) -> Boolean): Int {
    for (index in indices.reversed())
        if (predicate(this[index]))
            return index
    return -1
}

/** Returns index of the last element matching the given [predicate], or -1 if the buffer does not contain such element. */
inline fun DoubleBuffer.indexOfLast(predicate: (Double) -> Boolean): Int {
    for (index in indices.reversed())
        if (predicate(this[index]))
            return index
    return -1
}

/** Returns index of the last element matching the given [predicate], or -1 if the buffer does not contain such element. */
inline fun CharBuffer.indexOfLast(predicate: (Char) -> Boolean): Int {
    for (index in indices.reversed())
        if (predicate(this[index]))
            return index
    return -1
}


/** Returns the last element.
 *  @throws [NoSuchElementException] if the buffer is empty. */
fun ByteBuffer.last(): Byte = if (isEmpty()) throw NoSuchElementException("Array is empty.") else this[lastIndex]

/** Returns the last element.
 *  @throws [NoSuchElementException] if the buffer is empty. */
fun ShortBuffer.last(): Short = if (isEmpty()) throw NoSuchElementException("Array is empty.") else this[lastIndex]

/** Returns the last element.
 *  @throws [NoSuchElementException] if the buffer is empty. */
fun IntBuffer.last(): Int = if (isEmpty()) throw NoSuchElementException("Array is empty.") else this[lastIndex]

/** Returns the last element.
 *  @throws [NoSuchElementException] if the buffer is empty. */
fun LongBuffer.last(): Long = if (isEmpty()) throw NoSuchElementException("Array is empty.") else this[lastIndex]

/** Returns the last element.
 *  @throws [NoSuchElementException] if the buffer is empty. */
fun FloatBuffer.last(): Float = if (isEmpty()) throw NoSuchElementException("Array is empty.") else this[lastIndex]

/** Returns the last element.
 *  @throws [NoSuchElementException] if the buffer is empty. */
fun DoubleBuffer.last(): Double = if (isEmpty()) throw NoSuchElementException("Array is empty.") else this[lastIndex]

/** Returns the last element.
 *  @throws [NoSuchElementException] if the buffer is empty. */
fun CharBuffer.last(): Char = if (isEmpty()) throw NoSuchElementException("Array is empty.") else this[lastIndex]


/** Returns the last element matching the given [predicate].
 *  @throws [NoSuchElementException] if no such element is found. */
inline fun ByteBuffer.last(predicate: (Byte) -> Boolean): Byte {
    for (index in this.indices.reversed()) {
        val element = this[index]
        if (predicate(element)) return element
    }
    throw NoSuchElementException("Array contains no element matching the predicate.")
}

/** Returns the last element matching the given [predicate].
 *  @throws [NoSuchElementException] if no such element is found. */
inline fun ShortBuffer.last(predicate: (Short) -> Boolean): Short {
    for (index in this.indices.reversed()) {
        val element = this[index]
        if (predicate(element)) return element
    }
    throw NoSuchElementException("Array contains no element matching the predicate.")
}

/** Returns the last element matching the given [predicate].
 *  @throws [NoSuchElementException] if no such element is found. */
inline fun IntBuffer.last(predicate: (Int) -> Boolean): Int {
    for (index in this.indices.reversed()) {
        val element = this[index]
        if (predicate(element)) return element
    }
    throw NoSuchElementException("Array contains no element matching the predicate.")
}

/** Returns the last element matching the given [predicate].
 *  @throws [NoSuchElementException] if no such element is found. */
inline fun LongBuffer.last(predicate: (Long) -> Boolean): Long {
    for (index in this.indices.reversed()) {
        val element = this[index]
        if (predicate(element)) return element
    }
    throw NoSuchElementException("Array contains no element matching the predicate.")
}

/** Returns the last element matching the given [predicate].
 *  @throws [NoSuchElementException] if no such element is found. */
inline fun FloatBuffer.last(predicate: (Float) -> Boolean): Float {
    for (index in this.indices.reversed()) {
        val element = this[index]
        if (predicate(element)) return element
    }
    throw NoSuchElementException("Array contains no element matching the predicate.")
}

/** Returns the last element matching the given [predicate].
 *  @throws [NoSuchElementException] if no such element is found. */
inline fun DoubleBuffer.last(predicate: (Double) -> Boolean): Double {
    for (index in this.indices.reversed()) {
        val element = this[index]
        if (predicate(element)) return element
    }
    throw NoSuchElementException("Array contains no element matching the predicate.")
}

/** Returns the last element matching the given [predicate].
 *  @throws [NoSuchElementException] if no such element is found. */
inline fun CharBuffer.last(predicate: (Char) -> Boolean): Char {
    for (index in this.indices.reversed()) {
        val element = this[index]
        if (predicate(element)) return element
    }
    throw NoSuchElementException("Array contains no element matching the predicate.")
}


/** Returns last index of [element], or -1 if the buffer does not contain element. */
fun ByteBuffer.lastIndexOf(element: Byte): Int {
    for (index in indices.reversed())
        if (element == this[index])
            return index
    return -1
}

/** Returns last index of [element], or -1 if the buffer does not contain element. */
fun ShortBuffer.lastIndexOf(element: Short): Int {
    for (index in indices.reversed())
        if (element == this[index])
            return index
    return -1
}

/** Returns last index of [element], or -1 if the buffer does not contain element. */
fun IntBuffer.lastIndexOf(element: Int): Int {
    for (index in indices.reversed())
        if (element == this[index])
            return index
    return -1
}

/** Returns last index of [element], or -1 if the buffer does not contain element. */
fun LongBuffer.lastIndexOf(element: Long): Int {
    for (index in indices.reversed())
        if (element == this[index])
            return index
    return -1
}

/** Returns last index of [element], or -1 if the buffer does not contain element. */
fun FloatBuffer.lastIndexOf(element: Float): Int {
    for (index in indices.reversed())
        if (element == this[index])
            return index
    return -1
}

/** Returns last index of [element], or -1 if the buffer does not contain element. */
fun DoubleBuffer.lastIndexOf(element: Double): Int {
    for (index in indices.reversed())
        if (element == this[index])
            return index
    return -1
}

/** Returns last index of [element], or -1 if the buffer does not contain element. */
fun CharBuffer.lastIndexOf(element: Char): Int {
    for (index in indices.reversed())
        if (element == this[index])
            return index
    return -1
}


/** Returns the last element, or `null` if the buffer is empty. */
fun ByteBuffer.lastOrNull(): Byte? = if (isEmpty()) null else this[lim - 1]

/** Returns the last element, or `null` if the buffer is empty. */
fun ShortBuffer.lastOrNull(): Short? = if (isEmpty()) null else this[lim - 1]

/** Returns the last element, or `null` if the buffer is empty. */
fun IntBuffer.lastOrNull(): Int? = if (isEmpty()) null else this[lim - 1]

/** Returns the last element, or `null` if the buffer is empty. */
fun LongBuffer.lastOrNull(): Long? = if (isEmpty()) null else this[lim - 1]

/** Returns the last element, or `null` if the buffer is empty. */
fun FloatBuffer.lastOrNull(): Float? = if (isEmpty()) null else this[lim - 1]

/** Returns the last element, or `null` if the buffer is empty. */
fun DoubleBuffer.lastOrNull(): Double? = if (isEmpty()) null else this[lim - 1]

/** Returns the last element, or `null` if the buffer is empty. */
fun CharBuffer.lastOrNull(): Char? = if (isEmpty()) null else this[lim - 1]


/** Returns the last element matching the given [predicate], or `null` if no such element was found. */
inline fun ByteBuffer.lastOrNull(predicate: (Byte) -> Boolean): Byte? {
    for (index in this.indices.reversed()) {
        val element = this[index]
        if (predicate(element)) return element
    }
    return null
}

/** Returns the last element matching the given [predicate], or `null` if no such element was found. */
inline fun ShortBuffer.lastOrNull(predicate: (Short) -> Boolean): Short? {
    for (index in this.indices.reversed()) {
        val element = this[index]
        if (predicate(element)) return element
    }
    return null
}

/** Returns the last element matching the given [predicate], or `null` if no such element was found. */
inline fun IntBuffer.lastOrNull(predicate: (Int) -> Boolean): Int? {
    for (index in this.indices.reversed()) {
        val element = this[index]
        if (predicate(element)) return element
    }
    return null
}

/** Returns the last element matching the given [predicate], or `null` if no such element was found. */
inline fun LongBuffer.lastOrNull(predicate: (Long) -> Boolean): Long? {
    for (index in this.indices.reversed()) {
        val element = this[index]
        if (predicate(element)) return element
    }
    return null
}

/** Returns the last element matching the given [predicate], or `null` if no such element was found. */
inline fun FloatBuffer.lastOrNull(predicate: (Float) -> Boolean): Float? {
    for (index in this.indices.reversed()) {
        val element = this[index]
        if (predicate(element)) return element
    }
    return null
}

/** Returns the last element matching the given [predicate], or `null` if no such element was found. */
inline fun DoubleBuffer.lastOrNull(predicate: (Double) -> Boolean): Double? {
    for (index in this.indices.reversed()) {
        val element = this[index]
        if (predicate(element)) return element
    }
    return null
}

/** Returns the last element matching the given [predicate], or `null` if no such element was found. */
inline fun CharBuffer.lastOrNull(predicate: (Char) -> Boolean): Char? {
    for (index in this.indices.reversed()) {
        val element = this[index]
        if (predicate(element)) return element
    }
    return null
}

/** Returns a random element from this array.
 *  @throws NoSuchElementException if this array is empty. */
inline fun ByteBuffer.random(): Byte = random(Random)

/** Returns a random element from this array.
 *  @throws NoSuchElementException if this array is empty. */
inline fun ShortBuffer.random(): Short = random(Random)

/** Returns a random element from this array.
 *  @throws NoSuchElementException if this array is empty. */
inline fun IntBuffer.random(): Int = random(Random)

/** Returns a random element from this array.
 *  @throws NoSuchElementException if this array is empty. */
inline fun LongBuffer.random(): Long = random(Random)

/** Returns a random element from this array.
 *  @throws NoSuchElementException if this array is empty. */
inline fun FloatBuffer.random(): Float = random(Random)

/** Returns a random element from this array.
 *  @throws NoSuchElementException if this array is empty. */
inline fun DoubleBuffer.random(): Double = random(Random)

/** Returns a random element from this array.
 *  @throws NoSuchElementException if this array is empty. */
inline fun CharBuffer.random(): Char = random(Random)


/** Returns a random element from this array using the specified source of randomness.
 *  @throws NoSuchElementException if this array is empty. */
fun ByteBuffer.random(random: Random): Byte = if (isEmpty()) throw NoSuchElementException("Array is empty.") else get(random.nextInt(size))

/** Returns a random element from this array using the specified source of randomness.
 *  @throws NoSuchElementException if this array is empty. */
fun ShortBuffer.random(random: Random): Short = if (isEmpty()) throw NoSuchElementException("Array is empty.") else get(random.nextInt(size))

/** Returns a random element from this array using the specified source of randomness.
 *  @throws NoSuchElementException if this array is empty. */
fun IntBuffer.random(random: Random): Int = if (isEmpty()) throw NoSuchElementException("Array is empty.") else get(random.nextInt(size))

/** Returns a random element from this array using the specified source of randomness.
 *  @throws NoSuchElementException if this array is empty. */
fun LongBuffer.random(random: Random): Long = if (isEmpty()) throw NoSuchElementException("Array is empty.") else get(random.nextInt(size))

/** Returns a random element from this array using the specified source of randomness.
 *  @throws NoSuchElementException if this array is empty. */
fun FloatBuffer.random(random: Random): Float = if (isEmpty()) throw NoSuchElementException("Array is empty.") else get(random.nextInt(size))

/** Returns a random element from this array using the specified source of randomness.
 *  @throws NoSuchElementException if this array is empty. */
fun DoubleBuffer.random(random: Random): Double = if (isEmpty()) throw NoSuchElementException("Array is empty.") else get(random.nextInt(size))

/** Returns a random element from this array using the specified source of randomness.
 *  @throws NoSuchElementException if this array is empty. */
fun CharBuffer.random(random: Random): Char = if (isEmpty()) throw NoSuchElementException("Array is empty.") else get(random.nextInt(size))

/** Returns a random element from this array, or `null` if this array is empty. */
inline fun ByteBuffer.randomOrNull(): Byte? = randomOrNull(Random)

/** Returns a random element from this array, or `null` if this array is empty. */
inline fun ShortBuffer.randomOrNull(): Short? = randomOrNull(Random)

/** Returns a random element from this array, or `null` if this array is empty. */
inline fun IntBuffer.randomOrNull(): Int? = randomOrNull(Random)

/** Returns a random element from this array, or `null` if this array is empty. */
inline fun LongBuffer.randomOrNull(): Long? = randomOrNull(Random)

/** Returns a random element from this array, or `null` if this array is empty. */
inline fun FloatBuffer.randomOrNull(): Float? = randomOrNull(Random)

/** Returns a random element from this array, or `null` if this array is empty. */
inline fun DoubleBuffer.randomOrNull(): Double? = randomOrNull(Random)

/** Returns a random element from this array, or `null` if this array is empty. */
inline fun CharBuffer.randomOrNull(): Char? = randomOrNull(Random)


/** Returns a random element from this array using the specified source of randomness, or `null` if this array is empty. */
fun ByteBuffer.randomOrNull(random: Random): Byte? = if (isEmpty()) null else get(random.nextInt(size))

/** Returns a random element from this array using the specified source of randomness, or `null` if this array is empty. */
fun ShortBuffer.randomOrNull(random: Random): Short? = if (isEmpty()) null else get(random.nextInt(size))

/** Returns a random element from this array using the specified source of randomness, or `null` if this array is empty. */
fun IntBuffer.randomOrNull(random: Random): Int? = if (isEmpty()) null else get(random.nextInt(size))

/** Returns a random element from this array using the specified source of randomness, or `null` if this array is empty. */
fun LongBuffer.randomOrNull(random: Random): Long? = if (isEmpty()) null else get(random.nextInt(size))

/** Returns a random element from this array using the specified source of randomness, or `null` if this array is empty. */
fun FloatBuffer.randomOrNull(random: Random): Float? = if (isEmpty()) null else get(random.nextInt(size))

/** Returns a random element from this array using the specified source of randomness, or `null` if this array is empty. */
fun DoubleBuffer.randomOrNull(random: Random): Double? = if (isEmpty()) null else get(random.nextInt(size))

/** Returns a random element from this array using the specified source of randomness, or `null` if this array is empty. */
fun CharBuffer.randomOrNull(random: Random): Char? = if (isEmpty()) null else get(random.nextInt(size))


/** Returns the single element, or throws an exception if the array is empty or has more than one element. */
fun ByteBuffer.single(): Byte = when (size) {
    0 -> throw NoSuchElementException("Array is empty.")
    1 -> this[0]
    else -> throw IllegalArgumentException("Array has more than one element.")
}

/** Returns the single element, or throws an exception if the array is empty or has more than one element. */
fun ShortBuffer.single(): Short = when (size) {
    0 -> throw NoSuchElementException("Array is empty.")
    1 -> this[0]
    else -> throw IllegalArgumentException("Array has more than one element.")
}

/** Returns the single element, or throws an exception if the array is empty or has more than one element. */
fun IntBuffer.single(): Int = when (size) {
    0 -> throw NoSuchElementException("Array is empty.")
    1 -> this[0]
    else -> throw IllegalArgumentException("Array has more than one element.")
}

/** Returns the single element, or throws an exception if the array is empty or has more than one element. */
fun LongBuffer.single(): Long = when (size) {
    0 -> throw NoSuchElementException("Array is empty.")
    1 -> this[0]
    else -> throw IllegalArgumentException("Array has more than one element.")
}

/** Returns the single element, or throws an exception if the array is empty or has more than one element. */
fun FloatBuffer.single(): Float = when (size) {
    0 -> throw NoSuchElementException("Array is empty.")
    1 -> this[0]
    else -> throw IllegalArgumentException("Array has more than one element.")
}

/** Returns the single element, or throws an exception if the array is empty or has more than one element. */
fun DoubleBuffer.single(): Double = when (size) {
    0 -> throw NoSuchElementException("Array is empty.")
    1 -> this[0]
    else -> throw IllegalArgumentException("Array has more than one element.")
}

/** Returns the single element, or throws an exception if the array is empty or has more than one element. */
fun CharBuffer.single(): Char = when (size) {
    0 -> throw NoSuchElementException("Array is empty.")
    1 -> this[0]
    else -> throw IllegalArgumentException("Array has more than one element.")
}


/** Returns the single element matching the given [predicate], or throws exception if there is no or more than one matching element. */
inline fun ByteBuffer.single(predicate: (Byte) -> Boolean): Byte {
    var single: Byte? = null
    var found = false
    for (element in this) {
        if (predicate(element)) {
            if (found) throw IllegalArgumentException("Array contains more than one matching element.")
            single = element
            found = true
        }
    }
    if (!found) throw NoSuchElementException("Array contains no element matching the predicate.")
    @Suppress("UNCHECKED_CAST")
    return single as Byte
}

/** Returns the single element matching the given [predicate], or throws exception if there is no or more than one matching element. */
inline fun ShortBuffer.single(predicate: (Short) -> Boolean): Short {
    var single: Short? = null
    var found = false
    for (element in this) {
        if (predicate(element)) {
            if (found) throw IllegalArgumentException("Array contains more than one matching element.")
            single = element
            found = true
        }
    }
    if (!found) throw NoSuchElementException("Array contains no element matching the predicate.")
    @Suppress("UNCHECKED_CAST")
    return single as Short
}

/** Returns the single element matching the given [predicate], or throws exception if there is no or more than one matching element. */
inline fun IntBuffer.single(predicate: (Int) -> Boolean): Int {
    var single: Int? = null
    var found = false
    for (element in this) {
        if (predicate(element)) {
            if (found) throw IllegalArgumentException("Array contains more than one matching element.")
            single = element
            found = true
        }
    }
    if (!found) throw NoSuchElementException("Array contains no element matching the predicate.")
    @Suppress("UNCHECKED_CAST")
    return single as Int
}

/** Returns the single element matching the given [predicate], or throws exception if there is no or more than one matching element. */
inline fun LongBuffer.single(predicate: (Long) -> Boolean): Long {
    var single: Long? = null
    var found = false
    for (element in this) {
        if (predicate(element)) {
            if (found) throw IllegalArgumentException("Array contains more than one matching element.")
            single = element
            found = true
        }
    }
    if (!found) throw NoSuchElementException("Array contains no element matching the predicate.")
    @Suppress("UNCHECKED_CAST")
    return single as Long
}

/** Returns the single element matching the given [predicate], or throws exception if there is no or more than one matching element. */
inline fun FloatBuffer.single(predicate: (Float) -> Boolean): Float {
    var single: Float? = null
    var found = false
    for (element in this) {
        if (predicate(element)) {
            if (found) throw IllegalArgumentException("Array contains more than one matching element.")
            single = element
            found = true
        }
    }
    if (!found) throw NoSuchElementException("Array contains no element matching the predicate.")
    @Suppress("UNCHECKED_CAST")
    return single as Float
}

/** Returns the single element matching the given [predicate], or throws exception if there is no or more than one matching element. */
inline fun DoubleBuffer.single(predicate: (Double) -> Boolean): Double {
    var single: Double? = null
    var found = false
    for (element in this) {
        if (predicate(element)) {
            if (found) throw IllegalArgumentException("Array contains more than one matching element.")
            single = element
            found = true
        }
    }
    if (!found) throw NoSuchElementException("Array contains no element matching the predicate.")
    @Suppress("UNCHECKED_CAST")
    return single as Double
}

/** Returns the single element matching the given [predicate], or throws exception if there is no or more than one matching element. */
inline fun CharBuffer.single(predicate: (Char) -> Boolean): Char {
    var single: Char? = null
    var found = false
    for (element in this) {
        if (predicate(element)) {
            if (found) throw IllegalArgumentException("Array contains more than one matching element.")
            single = element
            found = true
        }
    }
    if (!found) throw NoSuchElementException("Array contains no element matching the predicate.")
    @Suppress("UNCHECKED_CAST")
    return single as Char
}

/** Returns single element, or `null` if the array is empty or has more than one element. */
fun ByteBuffer.singleOrNull(): Byte? = if (size == 1) this[0] else null

/** Returns single element, or `null` if the array is empty or has more than one element. */
fun ShortBuffer.singleOrNull(): Short? = if (size == 1) this[0] else null

/** Returns single element, or `null` if the array is empty or has more than one element. */
fun IntBuffer.singleOrNull(): Int? = if (size == 1) this[0] else null

/** Returns single element, or `null` if the array is empty or has more than one element. */
fun LongBuffer.singleOrNull(): Long? = if (size == 1) this[0] else null

/** Returns single element, or `null` if the array is empty or has more than one element. */
fun FloatBuffer.singleOrNull(): Float? = if (size == 1) this[0] else null

/** Returns single element, or `null` if the array is empty or has more than one element. */
fun DoubleBuffer.singleOrNull(): Double? = if (size == 1) this[0] else null

/** Returns single element, or `null` if the array is empty or has more than one element. */
fun CharBuffer.singleOrNull(): Char? = if (size == 1) this[0] else null


/** Returns the single element matching the given [predicate], or `null` if element was not found or more than one element was found. */
inline fun ByteBuffer.singleOrNull(predicate: (Byte) -> Boolean): Byte? {
    var single: Byte? = null
    var found = false
    for (element in this) {
        if (predicate(element)) {
            if (found) return null
            single = element
            found = true
        }
    }
    if (!found) return null
    return single
}

/** Returns the single element matching the given [predicate], or `null` if element was not found or more than one element was found. */
inline fun ShortBuffer.singleOrNull(predicate: (Short) -> Boolean): Short? {
    var single: Short? = null
    var found = false
    for (element in this) {
        if (predicate(element)) {
            if (found) return null
            single = element
            found = true
        }
    }
    if (!found) return null
    return single
}

/** Returns the single element matching the given [predicate], or `null` if element was not found or more than one element was found. */
inline fun IntBuffer.singleOrNull(predicate: (Int) -> Boolean): Int? {
    var single: Int? = null
    var found = false
    for (element in this) {
        if (predicate(element)) {
            if (found) return null
            single = element
            found = true
        }
    }
    if (!found) return null
    return single
}

/** Returns the single element matching the given [predicate], or `null` if element was not found or more than one element was found. */
inline fun LongBuffer.singleOrNull(predicate: (Long) -> Boolean): Long? {
    var single: Long? = null
    var found = false
    for (element in this) {
        if (predicate(element)) {
            if (found) return null
            single = element
            found = true
        }
    }
    if (!found) return null
    return single
}

/** Returns the single element matching the given [predicate], or `null` if element was not found or more than one element was found. */
inline fun FloatBuffer.singleOrNull(predicate: (Float) -> Boolean): Float? {
    var single: Float? = null
    var found = false
    for (element in this) {
        if (predicate(element)) {
            if (found) return null
            single = element
            found = true
        }
    }
    if (!found) return null
    return single
}

/** Returns the single element matching the given [predicate], or `null` if element was not found or more than one element was found. */
inline fun DoubleBuffer.singleOrNull(predicate: (Double) -> Boolean): Double? {
    var single: Double? = null
    var found = false
    for (element in this) {
        if (predicate(element)) {
            if (found) return null
            single = element
            found = true
        }
    }
    if (!found) return null
    return single
}

/** Returns the single element matching the given [predicate], or `null` if element was not found or more than one element was found. */
inline fun CharBuffer.singleOrNull(predicate: (Char) -> Boolean): Char? {
    var single: Char? = null
    var found = false
    for (element in this) {
        if (predicate(element)) {
            if (found) return null
            single = element
            found = true
        }
    }
    if (!found) return null
    return single
}


/** Returns a list containing all elements except first [n] elements. */
fun ByteBuffer.drop(n: Int): List<Byte> {
    require(n >= 0) { "Requested element count $n is less than zero." }
    return takeLast((lim - n).coerceAtLeast(0))
}

/** Returns a list containing all elements except first [n] elements. */
fun ShortBuffer.drop(n: Int): List<Short> {
    require(n >= 0) { "Requested element count $n is less than zero." }
    return takeLast((lim - n).coerceAtLeast(0))
}

/** Returns a list containing all elements except first [n] elements. */
fun IntBuffer.drop(n: Int): List<Int> {
    require(n >= 0) { "Requested element count $n is less than zero." }
    return takeLast((lim - n).coerceAtLeast(0))
}

/** Returns a list containing all elements except first [n] elements. */
fun LongBuffer.drop(n: Int): List<Long> {
    require(n >= 0) { "Requested element count $n is less than zero." }
    return takeLast((lim - n).coerceAtLeast(0))
}

/** Returns a list containing all elements except first [n] elements. */
fun FloatBuffer.drop(n: Int): List<Float> {
    require(n >= 0) { "Requested element count $n is less than zero." }
    return takeLast((lim - n).coerceAtLeast(0))
}

/** Returns a list containing all elements except first [n] elements. */
fun DoubleBuffer.drop(n: Int): List<Double> {
    require(n >= 0) { "Requested element count $n is less than zero." }
    return takeLast((lim - n).coerceAtLeast(0))
}

/** Returns a list containing all elements except first [n] elements. */
fun CharBuffer.drop(n: Int): List<Char> {
    require(n >= 0) { "Requested element count $n is less than zero." }
    return takeLast((lim - n).coerceAtLeast(0))
}


/** Returns a list containing all elements except last [n] elements.
 *  @throws IllegalArgumentException if [n] is negative.
 *  @sample samples.collections.Collections.Transformations.drop */
fun ByteBuffer.dropLast(n: Int): List<Byte> {
    require(n >= 0) { "Requested element count $n is less than zero." }
    return take((size - n).coerceAtLeast(0))
}

/** Returns a list containing all elements except last [n] elements.
 *  @throws IllegalArgumentException if [n] is negative.
 *  @sample samples.collections.Collections.Transformations.drop */
fun ShortBuffer.dropLast(n: Int): List<Short> {
    require(n >= 0) { "Requested element count $n is less than zero." }
    return take((size - n).coerceAtLeast(0))
}

/** Returns a list containing all elements except last [n] elements.
 *  @throws IllegalArgumentException if [n] is negative.
 *  @sample samples.collections.Collections.Transformations.drop */
fun IntBuffer.dropLast(n: Int): List<Int> {
    require(n >= 0) { "Requested element count $n is less than zero." }
    return take((size - n).coerceAtLeast(0))
}

/** Returns a list containing all elements except last [n] elements.
 *  @throws IllegalArgumentException if [n] is negative.
 *  @sample samples.collections.Collections.Transformations.drop */
fun LongBuffer.dropLast(n: Int): List<Long> {
    require(n >= 0) { "Requested element count $n is less than zero." }
    return take((size - n).coerceAtLeast(0))
}

/** Returns a list containing all elements except last [n] elements.
 *  @throws IllegalArgumentException if [n] is negative.
 *  @sample samples.collections.Collections.Transformations.drop */
fun FloatBuffer.dropLast(n: Int): List<Float> {
    require(n >= 0) { "Requested element count $n is less than zero." }
    return take((size - n).coerceAtLeast(0))
}

/** Returns a list containing all elements except last [n] elements.
 *  @throws IllegalArgumentException if [n] is negative.
 *  @sample samples.collections.Collections.Transformations.drop */
fun DoubleBuffer.dropLast(n: Int): List<Double> {
    require(n >= 0) { "Requested element count $n is less than zero." }
    return take((size - n).coerceAtLeast(0))
}

/** Returns a list containing all elements except last [n] elements.
 *  @throws IllegalArgumentException if [n] is negative.
 *  @sample samples.collections.Collections.Transformations.drop */
fun CharBuffer.dropLast(n: Int): List<Char> {
    require(n >= 0) { "Requested element count $n is less than zero." }
    return take((size - n).coerceAtLeast(0))
}


/** Returns a list containing all elements except last elements that satisfy the given [predicate].
 *  @sample samples.collections.Collections.Transformations.drop */
inline fun ByteBuffer.dropLastWhile(predicate: (Byte) -> Boolean): List<Byte> {
    for (index in lastIndex downTo 0)
        if (!predicate(this[index]))
            return take(index + 1)
    return emptyList()
}

/** Returns a list containing all elements except last elements that satisfy the given [predicate].
 *  @sample samples.collections.Collections.Transformations.drop */
inline fun ShortBuffer.dropLastWhile(predicate: (Short) -> Boolean): List<Short> {
    for (index in lastIndex downTo 0)
        if (!predicate(this[index]))
            return take(index + 1)
    return emptyList()
}

/** Returns a list containing all elements except last elements that satisfy the given [predicate].
 *  @sample samples.collections.Collections.Transformations.drop */
inline fun IntBuffer.dropLastWhile(predicate: (Int) -> Boolean): List<Int> {
    for (index in lastIndex downTo 0)
        if (!predicate(this[index]))
            return take(index + 1)
    return emptyList()
}

/** Returns a list containing all elements except last elements that satisfy the given [predicate].
 *  @sample samples.collections.Collections.Transformations.drop */
inline fun LongBuffer.dropLastWhile(predicate: (Long) -> Boolean): List<Long> {
    for (index in lastIndex downTo 0)
        if (!predicate(this[index]))
            return take(index + 1)
    return emptyList()
}

/** Returns a list containing all elements except last elements that satisfy the given [predicate].
 *  @sample samples.collections.Collections.Transformations.drop */
inline fun FloatBuffer.dropLastWhile(predicate: (Float) -> Boolean): List<Float> {
    for (index in lastIndex downTo 0)
        if (!predicate(this[index]))
            return take(index + 1)
    return emptyList()
}

/** Returns a list containing all elements except last elements that satisfy the given [predicate].
 *  @sample samples.collections.Collections.Transformations.drop */
inline fun DoubleBuffer.dropLastWhile(predicate: (Double) -> Boolean): List<Double> {
    for (index in lastIndex downTo 0)
        if (!predicate(this[index]))
            return take(index + 1)
    return emptyList()
}

/** Returns a list containing all elements except last elements that satisfy the given [predicate].
 *  @sample samples.collections.Collections.Transformations.drop */
inline fun CharBuffer.dropLastWhile(predicate: (Char) -> Boolean): List<Char> {
    for (index in lastIndex downTo 0)
        if (!predicate(this[index]))
            return take(index + 1)
    return emptyList()
}


/** Returns a list containing all elements except first elements that satisfy the given [predicate].
 *  @sample samples.collections.Collections.Transformations.drop */
inline fun ByteBuffer.dropWhile(predicate: (Byte) -> Boolean): List<Byte> {
    var yielding = false
    val list = ArrayList<Byte>()
    for (item in this)
        if (yielding)
            list.add(item)
        else if (!predicate(item)) {
            list.add(item)
            yielding = true
        }
    return list
}

/** Returns a list containing all elements except first elements that satisfy the given [predicate].
 *  @sample samples.collections.Collections.Transformations.drop */
inline fun ShortBuffer.dropWhile(predicate: (Short) -> Boolean): List<Short> {
    var yielding = false
    val list = ArrayList<Short>()
    for (item in this)
        if (yielding)
            list.add(item)
        else if (!predicate(item)) {
            list.add(item)
            yielding = true
        }
    return list
}

/** Returns a list containing all elements except first elements that satisfy the given [predicate].
 *  @sample samples.collections.Collections.Transformations.drop */
inline fun IntBuffer.dropWhile(predicate: (Int) -> Boolean): List<Int> {
    var yielding = false
    val list = ArrayList<Int>()
    for (item in this)
        if (yielding)
            list.add(item)
        else if (!predicate(item)) {
            list.add(item)
            yielding = true
        }
    return list
}

/** Returns a list containing all elements except first elements that satisfy the given [predicate].
 *  @sample samples.collections.Collections.Transformations.drop */
inline fun LongBuffer.dropWhile(predicate: (Long) -> Boolean): List<Long> {
    var yielding = false
    val list = ArrayList<Long>()
    for (item in this)
        if (yielding)
            list.add(item)
        else if (!predicate(item)) {
            list.add(item)
            yielding = true
        }
    return list
}

/** Returns a list containing all elements except first elements that satisfy the given [predicate].
 *  @sample samples.collections.Collections.Transformations.drop */
inline fun FloatBuffer.dropWhile(predicate: (Float) -> Boolean): List<Float> {
    var yielding = false
    val list = ArrayList<Float>()
    for (item in this)
        if (yielding)
            list.add(item)
        else if (!predicate(item)) {
            list.add(item)
            yielding = true
        }
    return list
}

/** Returns a list containing all elements except first elements that satisfy the given [predicate].
 *  @sample samples.collections.Collections.Transformations.drop */
inline fun DoubleBuffer.dropWhile(predicate: (Double) -> Boolean): List<Double> {
    var yielding = false
    val list = ArrayList<Double>()
    for (item in this)
        if (yielding)
            list.add(item)
        else if (!predicate(item)) {
            list.add(item)
            yielding = true
        }
    return list
}

/** Returns a list containing all elements except first elements that satisfy the given [predicate].
 *  @sample samples.collections.Collections.Transformations.drop */
inline fun CharBuffer.dropWhile(predicate: (Char) -> Boolean): List<Char> {
    var yielding = false
    val list = ArrayList<Char>()
    for (item in this)
        if (yielding)
            list.add(item)
        else if (!predicate(item)) {
            list.add(item)
            yielding = true
        }
    return list
}


/** Returns a list containing only elements matching the given [predicate].
 *  @sample samples.collections.Collections.Filtering.filter */
inline fun ByteBuffer.filter(predicate: (Byte) -> Boolean): List<Byte> = filterTo(ArrayList<Byte>(), predicate)

/** Returns a list containing only elements matching the given [predicate].
 *  @sample samples.collections.Collections.Filtering.filter */
inline fun ShortBuffer.filter(predicate: (Short) -> Boolean): List<Short> = filterTo(ArrayList<Short>(), predicate)

/** Returns a list containing only elements matching the given [predicate].
 *  @sample samples.collections.Collections.Filtering.filter */
inline fun IntBuffer.filter(predicate: (Int) -> Boolean): List<Int> = filterTo(ArrayList<Int>(), predicate)

/** Returns a list containing only elements matching the given [predicate].
 *  @sample samples.collections.Collections.Filtering.filter */
inline fun LongBuffer.filter(predicate: (Long) -> Boolean): List<Long> = filterTo(ArrayList<Long>(), predicate)

/** Returns a list containing only elements matching the given [predicate].
 *  @sample samples.collections.Collections.Filtering.filter */
inline fun FloatBuffer.filter(predicate: (Float) -> Boolean): List<Float> = filterTo(ArrayList<Float>(), predicate)

/** Returns a list containing only elements matching the given [predicate].
 *  @sample samples.collections.Collections.Filtering.filter */
inline fun DoubleBuffer.filter(predicate: (Double) -> Boolean): List<Double> = filterTo(ArrayList<Double>(), predicate)

/** Returns a list containing only elements matching the given [predicate].
 *  @sample samples.collections.Collections.Filtering.filter */
inline fun CharBuffer.filter(predicate: (Char) -> Boolean): List<Char> = filterTo(ArrayList<Char>(), predicate)


/** Returns a list containing only elements matching the given [predicate].
 *  @param [predicate] function that takes the index of an element and the element itself
 *  and returns the result of predicate evaluation on the element.
 *  @sample samples.collections.Collections.Filtering.filterIndexed */
inline fun ByteBuffer.filterIndexed(predicate: (index: Int, Byte) -> Boolean): List<Byte> = filterIndexedTo(ArrayList<Byte>(), predicate)

/** Returns a list containing only elements matching the given [predicate].
 *  @param [predicate] function that takes the index of an element and the element itself
 *  and returns the result of predicate evaluation on the element.
 *  @sample samples.collections.Collections.Filtering.filterIndexed */
inline fun ShortBuffer.filterIndexed(predicate: (index: Int, Short) -> Boolean): List<Short> = filterIndexedTo(ArrayList<Short>(), predicate)

/** Returns a list containing only elements matching the given [predicate].
 *  @param [predicate] function that takes the index of an element and the element itself
 *  and returns the result of predicate evaluation on the element.
 *  @sample samples.collections.Collections.Filtering.filterIndexed */
inline fun IntBuffer.filterIndexed(predicate: (index: Int, Int) -> Boolean): List<Int> = filterIndexedTo(ArrayList<Int>(), predicate)

/** Returns a list containing only elements matching the given [predicate].
 *  @param [predicate] function that takes the index of an element and the element itself
 *  and returns the result of predicate evaluation on the element.
 *  @sample samples.collections.Collections.Filtering.filterIndexed */
inline fun LongBuffer.filterIndexed(predicate: (index: Int, Long) -> Boolean): List<Long> = filterIndexedTo(ArrayList<Long>(), predicate)

/** Returns a list containing only elements matching the given [predicate].
 *  @param [predicate] function that takes the index of an element and the element itself
 *  and returns the result of predicate evaluation on the element.
 *  @sample samples.collections.Collections.Filtering.filterIndexed */
inline fun FloatBuffer.filterIndexed(predicate: (index: Int, Float) -> Boolean): List<Float> = filterIndexedTo(ArrayList<Float>(), predicate)

/** Returns a list containing only elements matching the given [predicate].
 *  @param [predicate] function that takes the index of an element and the element itself
 *  and returns the result of predicate evaluation on the element.
 *  @sample samples.collections.Collections.Filtering.filterIndexed */
inline fun DoubleBuffer.filterIndexed(predicate: (index: Int, Double) -> Boolean): List<Double> = filterIndexedTo(ArrayList<Double>(), predicate)

/** Returns a list containing only elements matching the given [predicate].
 *  @param [predicate] function that takes the index of an element and the element itself
 *  and returns the result of predicate evaluation on the element.
 *  @sample samples.collections.Collections.Filtering.filterIndexed */
inline fun CharBuffer.filterIndexed(predicate: (index: Int, Char) -> Boolean): List<Char> = filterIndexedTo(ArrayList<Char>(), predicate)


/** Appends all elements matching the given [predicate] to the given [destination].
 *  @param [predicate] function that takes the index of an element and the element itself
 *  and returns the result of predicate evaluation on the element.
 *  @sample samples.collections.Collections.Filtering.filterIndexedTo */
inline fun <C : MutableCollection<in Byte>> ByteBuffer.filterIndexedTo(destination: C, predicate: (index: Int, Byte) -> Boolean): C {
    forEachIndexed { index, element -> if (predicate(index, element)) destination.add(element) }
    return destination
}

/** Appends all elements matching the given [predicate] to the given [destination].
 *  @param [predicate] function that takes the index of an element and the element itself
 *  and returns the result of predicate evaluation on the element.
 *  @sample samples.collections.Collections.Filtering.filterIndexedTo */
inline fun <C : MutableCollection<in Short>> ShortBuffer.filterIndexedTo(destination: C, predicate: (index: Int, Short) -> Boolean): C {
    forEachIndexed { index, element -> if (predicate(index, element)) destination.add(element) }
    return destination
}

/** Appends all elements matching the given [predicate] to the given [destination].
 *  @param [predicate] function that takes the index of an element and the element itself
 *  and returns the result of predicate evaluation on the element.
 *  @sample samples.collections.Collections.Filtering.filterIndexedTo */
inline fun <C : MutableCollection<in Int>> IntBuffer.filterIndexedTo(destination: C, predicate: (index: Int, Int) -> Boolean): C {
    forEachIndexed { index, element -> if (predicate(index, element)) destination.add(element) }
    return destination
}

/** Appends all elements matching the given [predicate] to the given [destination].
 *  @param [predicate] function that takes the index of an element and the element itself
 *  and returns the result of predicate evaluation on the element.
 *  @sample samples.collections.Collections.Filtering.filterIndexedTo */
inline fun <C : MutableCollection<in Long>> LongBuffer.filterIndexedTo(destination: C, predicate: (index: Int, Long) -> Boolean): C {
    forEachIndexed { index, element -> if (predicate(index, element)) destination.add(element) }
    return destination
}

/** Appends all elements matching the given [predicate] to the given [destination].
 *  @param [predicate] function that takes the index of an element and the element itself
 *  and returns the result of predicate evaluation on the element.
 *  @sample samples.collections.Collections.Filtering.filterIndexedTo */
inline fun <C : MutableCollection<in Float>> FloatBuffer.filterIndexedTo(destination: C, predicate: (index: Int, Float) -> Boolean): C {
    forEachIndexed { index, element -> if (predicate(index, element)) destination.add(element) }
    return destination
}

/** Appends all elements matching the given [predicate] to the given [destination].
 *  @param [predicate] function that takes the index of an element and the element itself
 *  and returns the result of predicate evaluation on the element.
 *  @sample samples.collections.Collections.Filtering.filterIndexedTo */
inline fun <C : MutableCollection<in Double>> DoubleBuffer.filterIndexedTo(destination: C, predicate: (index: Int, Double) -> Boolean): C {
    forEachIndexed { index, element -> if (predicate(index, element)) destination.add(element) }
    return destination
}

/** Appends all elements matching the given [predicate] to the given [destination].
 *  @param [predicate] function that takes the index of an element and the element itself
 *  and returns the result of predicate evaluation on the element.
 *  @sample samples.collections.Collections.Filtering.filterIndexedTo */
inline fun <C : MutableCollection<in Char>> CharBuffer.filterIndexedTo(destination: C, predicate: (index: Int, Char) -> Boolean): C {
    forEachIndexed { index, element -> if (predicate(index, element)) destination.add(element) }
    return destination
}


/** Returns a list containing all elements not matching the given [predicate].
 *  @sample samples.collections.Collections.Filtering.filter */
inline fun ByteBuffer.filterNot(predicate: (Byte) -> Boolean): List<Byte> = filterNotTo(ArrayList<Byte>(), predicate)

/** Returns a list containing all elements not matching the given [predicate].
 *  @sample samples.collections.Collections.Filtering.filter */
inline fun ShortBuffer.filterNot(predicate: (Short) -> Boolean): List<Short> = filterNotTo(ArrayList<Short>(), predicate)

/** Returns a list containing all elements not matching the given [predicate].
 *  @sample samples.collections.Collections.Filtering.filter */
inline fun IntBuffer.filterNot(predicate: (Int) -> Boolean): List<Int> = filterNotTo(ArrayList<Int>(), predicate)

/** Returns a list containing all elements not matching the given [predicate].
 *  @sample samples.collections.Collections.Filtering.filter */
inline fun LongBuffer.filterNot(predicate: (Long) -> Boolean): List<Long> = filterNotTo(ArrayList<Long>(), predicate)

/** Returns a list containing all elements not matching the given [predicate].
 *  @sample samples.collections.Collections.Filtering.filter */
inline fun FloatBuffer.filterNot(predicate: (Float) -> Boolean): List<Float> = filterNotTo(ArrayList<Float>(), predicate)

/** Returns a list containing all elements not matching the given [predicate].
 *  @sample samples.collections.Collections.Filtering.filter */
inline fun DoubleBuffer.filterNot(predicate: (Double) -> Boolean): List<Double> = filterNotTo(ArrayList<Double>(), predicate)

/** Returns a list containing all elements not matching the given [predicate].
 *  @sample samples.collections.Collections.Filtering.filter */
inline fun CharBuffer.filterNot(predicate: (Char) -> Boolean): List<Char> = filterNotTo(ArrayList<Char>(), predicate)


// [Kool] custom, it was filterNotNull

/** Returns a list containing all elements that are not zero (aka "null" for GL and VK)
 *  @sample samples.collections.Collections.Filtering.filterNotNull */
fun ByteBuffer.filterNotZero(): List<Byte> = filterNotZeroTo(ArrayList<Byte>())

/** Returns a list containing all elements that are not zero (aka "null" for GL and VK)
 *  @sample samples.collections.Collections.Filtering.filterNotNull */
fun ShortBuffer.filterNotZero(): List<Short> = filterNotZeroTo(ArrayList<Short>())

/** Returns a list containing all elements that are not zero (aka "null" for GL and VK)
 *  @sample samples.collections.Collections.Filtering.filterNotNull */
fun IntBuffer.filterNotZero(): List<Int> = filterNotZeroTo(ArrayList<Int>())

/** Returns a list containing all elements that are not zero (aka "null" for GL and VK)
 *  @sample samples.collections.Collections.Filtering.filterNotNull */
fun LongBuffer.filterNotZero(): List<Long> = filterNotZeroTo(ArrayList<Long>())

/** Returns a list containing all elements that are not zero (aka "null" for GL and VK)
 *  @sample samples.collections.Collections.Filtering.filterNotNull */
fun FloatBuffer.filterNotZero(): List<Float> = filterNotZeroTo(ArrayList<Float>())

/** Returns a list containing all elements that are not zero (aka "null" for GL and VK)
 *  @sample samples.collections.Collections.Filtering.filterNotNull */
fun DoubleBuffer.filterNotZero(): List<Double> = filterNotZeroTo(ArrayList<Double>())

/** Returns a list containing all elements that are not zero (aka "null" for GL and VK)
 *  @sample samples.collections.Collections.Filtering.filterNotNull */
fun CharBuffer.filterNotZero(): List<Char> = filterNotZeroTo(ArrayList<Char>())


/** Appends all elements that are not `null` to the given [destination].
 *  @sample samples.collections.Collections.Filtering.filterNotNullTo */
fun <C : MutableCollection<Byte>> ByteBuffer.filterNotZeroTo(destination: C): C {
    for (element in this) if (element != 0.toByte()) destination.add(element)
    return destination
}

/** Appends all elements that are not `null` to the given [destination].
 *  @sample samples.collections.Collections.Filtering.filterNotNullTo */
fun <C : MutableCollection<Short>> ShortBuffer.filterNotZeroTo(destination: C): C {
    for (element in this) if (element != 0.toShort()) destination.add(element)
    return destination
}

/** Appends all elements that are not `null` to the given [destination].
 *  @sample samples.collections.Collections.Filtering.filterNotNullTo */
fun <C : MutableCollection<Int>> IntBuffer.filterNotZeroTo(destination: C): C {
    for (element in this) if (element != 0) destination.add(element)
    return destination
}

/** Appends all elements that are not `null` to the given [destination].
 *  @sample samples.collections.Collections.Filtering.filterNotNullTo */
fun <C : MutableCollection<Long>> LongBuffer.filterNotZeroTo(destination: C): C {
    for (element in this) if (element != 0L) destination.add(element)
    return destination
}

/** Appends all elements that are not `null` to the given [destination].
 *  @sample samples.collections.Collections.Filtering.filterNotNullTo */
fun <C : MutableCollection<Float>> FloatBuffer.filterNotZeroTo(destination: C): C {
    for (element in this) if (element != 0f) destination.add(element)
    return destination
}

/** Appends all elements that are not `null` to the given [destination].
 *  @sample samples.collections.Collections.Filtering.filterNotNullTo */
fun <C : MutableCollection<Double>> DoubleBuffer.filterNotZeroTo(destination: C): C {
    for (element in this) if (element != 0.0) destination.add(element)
    return destination
}

/** Appends all elements that are not `null` to the given [destination].
 *  @sample samples.collections.Collections.Filtering.filterNotNullTo */
fun <C : MutableCollection<Char>> CharBuffer.filterNotZeroTo(destination: C): C {
    for (element in this) if (element != '\u0000') destination.add(element)
    return destination
}


/** Appends all elements not matching the given [predicate] to the given [destination].
 *  @sample samples.collections.Collections.Filtering.filterTo */
inline fun <C : MutableCollection<in Byte>> ByteBuffer.filterNotTo(destination: C, predicate: (Byte) -> Boolean): C {
    for (element in this) if (!predicate(element)) destination.add(element)
    return destination
}

/** Appends all elements not matching the given [predicate] to the given [destination].
 *  @sample samples.collections.Collections.Filtering.filterTo */
inline fun <C : MutableCollection<in Short>> ShortBuffer.filterNotTo(destination: C, predicate: (Short) -> Boolean): C {
    for (element in this) if (!predicate(element)) destination.add(element)
    return destination
}

/** Appends all elements not matching the given [predicate] to the given [destination].
 *  @sample samples.collections.Collections.Filtering.filterTo */
inline fun <C : MutableCollection<in Int>> IntBuffer.filterNotTo(destination: C, predicate: (Int) -> Boolean): C {
    for (element in this) if (!predicate(element)) destination.add(element)
    return destination
}

/** Appends all elements not matching the given [predicate] to the given [destination].
 *  @sample samples.collections.Collections.Filtering.filterTo */
inline fun <C : MutableCollection<in Long>> LongBuffer.filterNotTo(destination: C, predicate: (Long) -> Boolean): C {
    for (element in this) if (!predicate(element)) destination.add(element)
    return destination
}

/** Appends all elements not matching the given [predicate] to the given [destination].
 *  @sample samples.collections.Collections.Filtering.filterTo */
inline fun <C : MutableCollection<in Float>> FloatBuffer.filterNotTo(destination: C, predicate: (Float) -> Boolean): C {
    for (element in this) if (!predicate(element)) destination.add(element)
    return destination
}

/** Appends all elements not matching the given [predicate] to the given [destination].
 *  @sample samples.collections.Collections.Filtering.filterTo */
inline fun <C : MutableCollection<in Double>> DoubleBuffer.filterNotTo(destination: C, predicate: (Double) -> Boolean): C {
    for (element in this) if (!predicate(element)) destination.add(element)
    return destination
}

/** Appends all elements not matching the given [predicate] to the given [destination].
 *  @sample samples.collections.Collections.Filtering.filterTo */
inline fun <C : MutableCollection<in Char>> CharBuffer.filterNotTo(destination: C, predicate: (Char) -> Boolean): C {
    for (element in this) if (!predicate(element)) destination.add(element)
    return destination
}


/** Appends all elements matching the given [predicate] to the given [destination].
 *  @sample samples.collections.Collections.Filtering.filterTo */
inline fun <C : MutableCollection<in Byte>> ByteBuffer.filterTo(destination: C, predicate: (Byte) -> Boolean): C {
    for (element in this) if (predicate(element)) destination.add(element)
    return destination
}

/** Appends all elements matching the given [predicate] to the given [destination].
 *  @sample samples.collections.Collections.Filtering.filterTo */
inline fun <C : MutableCollection<in Short>> ShortBuffer.filterTo(destination: C, predicate: (Short) -> Boolean): C {
    for (element in this) if (predicate(element)) destination.add(element)
    return destination
}

/** Appends all elements matching the given [predicate] to the given [destination].
 *  @sample samples.collections.Collections.Filtering.filterTo */
inline fun <C : MutableCollection<in Int>> IntBuffer.filterTo(destination: C, predicate: (Int) -> Boolean): C {
    for (element in this) if (predicate(element)) destination.add(element)
    return destination
}

/** Appends all elements matching the given [predicate] to the given [destination].
 *  @sample samples.collections.Collections.Filtering.filterTo */
inline fun <C : MutableCollection<in Long>> LongBuffer.filterTo(destination: C, predicate: (Long) -> Boolean): C {
    for (element in this) if (predicate(element)) destination.add(element)
    return destination
}

/** Appends all elements matching the given [predicate] to the given [destination].
 *  @sample samples.collections.Collections.Filtering.filterTo */
inline fun <C : MutableCollection<in Float>> FloatBuffer.filterTo(destination: C, predicate: (Float) -> Boolean): C {
    for (element in this) if (predicate(element)) destination.add(element)
    return destination
}

/** Appends all elements matching the given [predicate] to the given [destination].
 *  @sample samples.collections.Collections.Filtering.filterTo */
inline fun <C : MutableCollection<in Double>> DoubleBuffer.filterTo(destination: C, predicate: (Double) -> Boolean): C {
    for (element in this) if (predicate(element)) destination.add(element)
    return destination
}

/** Appends all elements matching the given [predicate] to the given [destination].
 *  @sample samples.collections.Collections.Filtering.filterTo */
inline fun <C : MutableCollection<in Char>> CharBuffer.filterTo(destination: C, predicate: (Char) -> Boolean): C {
    for (element in this) if (predicate(element)) destination.add(element)
    return destination
}


/** Returns a list containing elements at indices in the specified [indices] range. */
fun ByteBuffer.slice(indices: IntRange): ByteBuffer {
    val backupPos = pos
    val backupLim = lim
    pos = indices.first
    lim = indices.last
    val res = slice()
    pos = backupPos
    lim = backupLim
    return res
}

/** Returns a list containing elements at indices in the specified [indices] range. */
fun ShortBuffer.slice(indices: IntRange): ShortBuffer {
    val backupPos = pos
    val backupLim = lim
    pos = indices.first
    lim = indices.last
    val res = slice()
    pos = backupPos
    lim = backupLim
    return res
}

/** Returns a list containing elements at indices in the specified [indices] range. */
fun IntBuffer.slice(indices: IntRange): IntBuffer {
    val backupPos = pos
    val backupLim = lim
    pos = indices.first
    lim = indices.last
    val res = slice()
    pos = backupPos
    lim = backupLim
    return res
}

/** Returns a list containing elements at indices in the specified [indices] range. */
fun LongBuffer.slice(indices: IntRange): LongBuffer {
    val backupPos = pos
    val backupLim = lim
    pos = indices.first
    lim = indices.last
    val res = slice()
    pos = backupPos
    lim = backupLim
    return res
}

/** Returns a list containing elements at indices in the specified [indices] range. */
fun FloatBuffer.slice(indices: IntRange): FloatBuffer {
    val backupPos = pos
    val backupLim = lim
    pos = indices.first
    lim = indices.last
    val res = slice()
    pos = backupPos
    lim = backupLim
    return res
}

/** Returns a list containing elements at indices in the specified [indices] range. */
fun DoubleBuffer.slice(indices: IntRange): DoubleBuffer {
    val backupPos = pos
    val backupLim = lim
    pos = indices.first
    lim = indices.last
    val res = slice()
    pos = backupPos
    lim = backupLim
    return res
}

/** Returns a list containing elements at indices in the specified [indices] range. */
fun CharBuffer.slice(indices: IntRange): CharBuffer {
    val backupPos = pos
    val backupLim = lim
    pos = indices.first
    lim = indices.last
    val res = slice()
    pos = backupPos
    lim = backupLim
    return res
}


/** rray containing elements of this array at specified [indices]. */
fun ByteBuffer.sliceArray(indices: Collection<Int>): ByteArray {
    val result = ByteArray(indices.size)
    var targetIndex = 0
    for (sourceIndex in indices)
        result[targetIndex++] = this[sourceIndex]
    return result
}

/** Returns an array containing elements of this array at specified [indices]. */
fun ShortBuffer.sliceArray(indices: Collection<Int>): ShortArray {
    val result = ShortArray(indices.size)
    var targetIndex = 0
    for (sourceIndex in indices)
        result[targetIndex++] = this[sourceIndex]
    return result
}

/** Returns an array containing elements of this array at specified [indices]. */
fun IntBuffer.sliceArray(indices: Collection<Int>): IntArray {
    val result = IntArray(indices.size)
    var targetIndex = 0
    for (sourceIndex in indices)
        result[targetIndex++] = this[sourceIndex]
    return result
}

/** Returns an array containing elements of this array at specified [indices]. */
fun LongBuffer.sliceArray(indices: Collection<Int>): LongArray {
    val result = LongArray(indices.size)
    var targetIndex = 0
    for (sourceIndex in indices)
        result[targetIndex++] = this[sourceIndex]
    return result
}

/** Returns an array containing elements of this array at specified [indices]. */
fun FloatBuffer.sliceArray(indices: Collection<Int>): FloatArray {
    val result = FloatArray(indices.size)
    var targetIndex = 0
    for (sourceIndex in indices)
        result[targetIndex++] = this[sourceIndex]
    return result
}

/** Returns an array containing elements of this array at specified [indices]. */
fun DoubleBuffer.sliceArray(indices: Collection<Int>): DoubleArray {
    val result = DoubleArray(indices.size)
    var targetIndex = 0
    for (sourceIndex in indices)
        result[targetIndex++] = this[sourceIndex]
    return result
}

/** Returns an array containing elements of this array at specified [indices]. */
fun CharBuffer.sliceArray(indices: Collection<Int>): CharArray {
    val result = CharArray(indices.size)
    var targetIndex = 0
    for (sourceIndex in indices)
        result[targetIndex++] = this[sourceIndex]
    return result
}


/** Returns an array containing elements at indices in the specified [indices] range. */
fun ByteBuffer.sliceArray(indices: IntRange): ByteBuffer {
    if (indices.isEmpty()) return ByteArray(0)
    return copyOfRange(indices.start, indices.endInclusive + 1)
}

/** Returns an array containing elements at indices in the specified [indices] range. */
fun ShortBuffer.sliceArray(indices: IntRange): ShortBuffer {
    if (indices.isEmpty()) return ShortArray(0)
    return copyOfRange(indices.start, indices.endInclusive + 1)
}

/** Returns an array containing elements at indices in the specified [indices] range. */
fun IntBuffer.sliceArray(indices: IntRange): IntBuffer {
    if (indices.isEmpty()) return IntArray(0)
    return copyOfRange(indices.start, indices.endInclusive + 1)
}

/** Returns an array containing elements at indices in the specified [indices] range. */
fun LongBuffer.sliceArray(indices: IntRange): LongBuffer {
    if (indices.isEmpty()) return LongArray(0)
    return copyOfRange(indices.start, indices.endInclusive + 1)
}

/** Returns an array containing elements at indices in the specified [indices] range. */
fun FloatBuffer.sliceArray(indices: IntRange): FloatBuffer {
    if (indices.isEmpty()) return FloatArray(0)
    return copyOfRange(indices.start, indices.endInclusive + 1)
}

/** Returns an array containing elements at indices in the specified [indices] range. */
fun DoubleBuffer.sliceArray(indices: IntRange): DoubleBuffer {
    if (indices.isEmpty()) return DoubleArray(0)
    return copyOfRange(indices.start, indices.endInclusive + 1)
}

/** Returns an array containing elements at indices in the specified [indices] range. */
fun CharBuffer.sliceArray(indices: IntRange): CharBuffer {
    if (indices.isEmpty()) return CharArray(0)
    return copyOfRange(indices.start, indices.endInclusive + 1)
}


/** Returns a list containing first [n] elements.
 *  @throws IllegalArgumentException if [n] is negative.
 *  @sample samples.collections.Collections.Transformations.take */
fun ByteBuffer.take(n: Int): List<Byte> {
    require(n >= 0) { "Requested element count $n is less than zero." }
    if (n == 0) return emptyList()
    if (n >= size) return toList()
    if (n == 1) return listOf(this[0])
    var count = 0
    val list = ArrayList<Byte>(n)
    for (item in this) {
        list.add(item)
        if (++count == n)
            break
    }
    return list
}

/** Returns a list containing first [n] elements.
 *  @throws IllegalArgumentException if [n] is negative.
 *  @sample samples.collections.Collections.Transformations.take */
fun ShortBuffer.take(n: Int): List<Short> {
    require(n >= 0) { "Requested element count $n is less than zero." }
    if (n == 0) return emptyList()
    if (n >= size) return toList()
    if (n == 1) return listOf(this[0])
    var count = 0
    val list = ArrayList<Short>(n)
    for (item in this) {
        list.add(item)
        if (++count == n)
            break
    }
    return list
}

/** Returns a list containing first [n] elements.
 *  @throws IllegalArgumentException if [n] is negative.
 *  @sample samples.collections.Collections.Transformations.take */
fun IntBuffer.take(n: Int): List<Int> {
    require(n >= 0) { "Requested element count $n is less than zero." }
    if (n == 0) return emptyList()
    if (n >= size) return toList()
    if (n == 1) return listOf(this[0])
    var count = 0
    val list = ArrayList<Int>(n)
    for (item in this) {
        list.add(item)
        if (++count == n)
            break
    }
    return list
}

/** Returns a list containing first [n] elements.
 *  @throws IllegalArgumentException if [n] is negative.
 *  @sample samples.collections.Collections.Transformations.take */
fun LongBuffer.take(n: Int): List<Long> {
    require(n >= 0) { "Requested element count $n is less than zero." }
    if (n == 0) return emptyList()
    if (n >= size) return toList()
    if (n == 1) return listOf(this[0])
    var count = 0
    val list = ArrayList<Long>(n)
    for (item in this) {
        list.add(item)
        if (++count == n)
            break
    }
    return list
}

/** Returns a list containing first [n] elements.
 *  @throws IllegalArgumentException if [n] is negative.
 *  @sample samples.collections.Collections.Transformations.take */
fun FloatBuffer.take(n: Int): List<Float> {
    require(n >= 0) { "Requested element count $n is less than zero." }
    if (n == 0) return emptyList()
    if (n >= size) return toList()
    if (n == 1) return listOf(this[0])
    var count = 0
    val list = ArrayList<Float>(n)
    for (item in this) {
        list.add(item)
        if (++count == n)
            break
    }
    return list
}

/** Returns a list containing first [n] elements.
 *  @throws IllegalArgumentException if [n] is negative.
 *  @sample samples.collections.Collections.Transformations.take */
fun DoubleBuffer.take(n: Int): List<Double> {
    require(n >= 0) { "Requested element count $n is less than zero." }
    if (n == 0) return emptyList()
    if (n >= size) return toList()
    if (n == 1) return listOf(this[0])
    var count = 0
    val list = ArrayList<Double>(n)
    for (item in this) {
        list.add(item)
        if (++count == n)
            break
    }
    return list
}

/** Returns a list containing first [n] elements.
 *  @throws IllegalArgumentException if [n] is negative.
 *  @sample samples.collections.Collections.Transformations.take */
fun CharBuffer.take(n: Int): List<Char> {
    require(n >= 0) { "Requested element count $n is less than zero." }
    if (n == 0) return emptyList()
    if (n >= size) return toList()
    if (n == 1) return listOf(this[0])
    var count = 0
    val list = ArrayList<Char>(n)
    for (item in this) {
        list.add(item)
        if (++count == n)
            break
    }
    return list
}


/** Returns a list containing last [n] elements. */
fun ByteBuffer.takeLast(n: Int): List<Byte> {
    require(n >= 0) { "Requested element count $n is less than zero." }
    if (n == 0) return emptyList()
    val size = lim
    if (n >= size) return toList()
    if (n == 1) return listOf(this[size - 1])
    val list = ArrayList<Byte>(n)
    for (index in size - n until size)
        list += this[index]
    return list
}

/** Returns a list containing last [n] elements. */
fun ShortBuffer.takeLast(n: Int): List<Short> {
    require(n >= 0) { "Requested element count $n is less than zero." }
    if (n == 0) return emptyList()
    val size = lim
    if (n >= size) return toList()
    if (n == 1) return listOf(this[size - 1])
    val list = ArrayList<Short>(n)
    for (index in size - n until size)
        list += this[index]
    return list
}

/** Returns a list containing last [n] elements. */
fun IntBuffer.takeLast(n: Int): List<Int> {
    require(n >= 0) { "Requested element count $n is less than zero." }
    if (n == 0) return emptyList()
    val size = lim
    if (n >= size) return toList()
    if (n == 1) return listOf(this[size - 1])
    val list = ArrayList<Int>(n)
    for (index in size - n until size)
        list += this[index]
    return list
}

/** Returns a list containing last [n] elements. */
fun LongBuffer.takeLast(n: Int): List<Long> {
    require(n >= 0) { "Requested element count $n is less than zero." }
    if (n == 0) return emptyList()
    val size = lim
    if (n >= size) return toList()
    if (n == 1) return listOf(this[size - 1])
    val list = ArrayList<Long>(n)
    for (index in size - n until size)
        list += this[index]
    return list
}

/** Returns a list containing last [n] elements. */
fun FloatBuffer.takeLast(n: Int): List<Float> {
    require(n >= 0) { "Requested element count $n is less than zero." }
    if (n == 0) return emptyList()
    val size = lim
    if (n >= size) return toList()
    if (n == 1) return listOf(this[size - 1])
    val list = ArrayList<Float>(n)
    for (index in size - n until size)
        list += this[index]
    return list
}

/** Returns a list containing last [n] elements. */
fun DoubleBuffer.takeLast(n: Int): List<Double> {
    require(n >= 0) { "Requested element count $n is less than zero." }
    if (n == 0) return emptyList()
    val size = lim
    if (n >= size) return toList()
    if (n == 1) return listOf(this[size - 1])
    val list = ArrayList<Double>(n)
    for (index in size - n until size)
        list += this[index]
    return list
}

/** Returns a list containing last [n] elements. */
fun CharBuffer.takeLast(n: Int): List<Char> {
    require(n >= 0) { "Requested element count $n is less than zero." }
    if (n == 0) return emptyList()
    val size = lim
    if (n >= size) return toList()
    if (n == 1) return listOf(this[size - 1])
    val list = ArrayList<Char>(n)
    for (index in size - n until size)
        list += this[index]
    return list
}


/** Returns a list containing last elements satisfying the given [predicate]. */
inline fun ByteBuffer.takeLastWhile(predicate: (Byte) -> Boolean): List<Byte> {
    for (index in lastIndex downTo 0)
        if (!predicate(this[index]))
            return drop(index + 1)
    return toList()
}


/** Returns a list containing last elements satisfying the given [predicate]. */
inline fun ShortBuffer.takeLastWhile(predicate: (Short) -> Boolean): List<Short> {
    for (index in lastIndex downTo 0)
        if (!predicate(this[index]))
            return drop(index + 1)
    return toList()
}

/** Returns a list containing last elements satisfying the given [predicate]. */
inline fun IntBuffer.takeLastWhile(predicate: (Int) -> Boolean): List<Int> {
    for (index in lastIndex downTo 0)
        if (!predicate(this[index]))
            return drop(index + 1)
    return toList()
}

/** Returns a list containing last elements satisfying the given [predicate]. */
inline fun LongBuffer.takeLastWhile(predicate: (Long) -> Boolean): List<Long> {
    for (index in lastIndex downTo 0)
        if (!predicate(this[index]))
            return drop(index + 1)
    return toList()
}

/** Returns a list containing last elements satisfying the given [predicate]. */
inline fun FloatBuffer.takeLastWhile(predicate: (Float) -> Boolean): List<Float> {
    for (index in lastIndex downTo 0)
        if (!predicate(this[index]))
            return drop(index + 1)
    return toList()
}

/** Returns a list containing last elements satisfying the given [predicate]. */
inline fun DoubleBuffer.takeLastWhile(predicate: (Double) -> Boolean): List<Double> {
    for (index in lastIndex downTo 0)
        if (!predicate(this[index]))
            return drop(index + 1)
    return toList()
}

/** Returns a list containing last elements satisfying the given [predicate]. */
inline fun CharBuffer.takeLastWhile(predicate: (Char) -> Boolean): List<Char> {
    for (index in lastIndex downTo 0)
        if (!predicate(this[index]))
            return drop(index + 1)
    return toList()
}


/** Returns a list containing first elements satisfying the given [predicate]. */
inline fun ByteBuffer.takeWhile(predicate: (Byte) -> Boolean): List<Byte> {
    val list = ArrayList<Byte>()
    for (item in this) {
        if (!predicate(item)) break
        list += item
    }
    return list
}

/** Returns a list containing first elements satisfying the given [predicate]. */
inline fun ShortBuffer.takeWhile(predicate: (Short) -> Boolean): List<Short> {
    val list = ArrayList<Short>()
    for (item in this) {
        if (!predicate(item)) break
        list += item
    }
    return list
}

/** Returns a list containing first elements satisfying the given [predicate]. */
inline fun IntBuffer.takeWhile(predicate: (Int) -> Boolean): List<Int> {
    val list = ArrayList<Int>()
    for (item in this) {
        if (!predicate(item)) break
        list += item
    }
    return list
}

/** Returns a list containing first elements satisfying the given [predicate]. */
inline fun LongBuffer.takeWhile(predicate: (Long) -> Boolean): List<Long> {
    val list = ArrayList<Long>()
    for (item in this) {
        if (!predicate(item)) break
        list += item
    }
    return list
}

/** Returns a list containing first elements satisfying the given [predicate]. */
inline fun FloatBuffer.takeWhile(predicate: (Float) -> Boolean): List<Float> {
    val list = ArrayList<Float>()
    for (item in this) {
        if (!predicate(item)) break
        list += item
    }
    return list
}

/** Returns a list containing first elements satisfying the given [predicate]. */
inline fun DoubleBuffer.takeWhile(predicate: (Double) -> Boolean): List<Double> {
    val list = ArrayList<Double>()
    for (item in this) {
        if (!predicate(item)) break
        list += item
    }
    return list
}

/** Returns a list containing first elements satisfying the given [predicate]. */
inline fun CharBuffer.takeWhile(predicate: (Char) -> Boolean): List<Char> {
    val list = ArrayList<Char>()
    for (item in this) {
        if (!predicate(item)) break
        list += item
    }
    return list
}


/** Reverses elements in the buffer in-place. */
fun ByteBuffer.reverse() {
    val midPoint = lim / 2 - 1
    if (midPoint < 0) return
    var reverseIndex = lastIndex
    for (index in 0..midPoint) {
        val tmp = this[index]
        this[index] = this[reverseIndex]
        this[reverseIndex] = tmp
        reverseIndex--
    }
}

/** Reverses elements in the buffer in-place. */
fun ShortBuffer.reverse() {
    val midPoint = lim / 2 - 1
    if (midPoint < 0) return
    var reverseIndex = lastIndex
    for (index in 0..midPoint) {
        val tmp = this[index]
        this[index] = this[reverseIndex]
        this[reverseIndex] = tmp
        reverseIndex--
    }
}

/** Reverses elements in the buffer in-place. */
fun IntBuffer.reverse() {
    val midPoint = lim / 2 - 1
    if (midPoint < 0) return
    var reverseIndex = lastIndex
    for (index in 0..midPoint) {
        val tmp = this[index]
        this[index] = this[reverseIndex]
        this[reverseIndex] = tmp
        reverseIndex--
    }
}

/** Reverses elements in the buffer in-place. */
fun LongBuffer.reverse() {
    val midPoint = lim / 2 - 1
    if (midPoint < 0) return
    var reverseIndex = lastIndex
    for (index in 0..midPoint) {
        val tmp = this[index]
        this[index] = this[reverseIndex]
        this[reverseIndex] = tmp
        reverseIndex--
    }
}

/** Reverses elements in the buffer in-place. */
fun FloatBuffer.reverse() {
    val midPoint = lim / 2 - 1
    if (midPoint < 0) return
    var reverseIndex = lastIndex
    for (index in 0..midPoint) {
        val tmp = this[index]
        this[index] = this[reverseIndex]
        this[reverseIndex] = tmp
        reverseIndex--
    }
}

/** Reverses elements in the buffer in-place. */
fun DoubleBuffer.reverse() {
    val midPoint = lim / 2 - 1
    if (midPoint < 0) return
    var reverseIndex = lastIndex
    for (index in 0..midPoint) {
        val tmp = this[index]
        this[index] = this[reverseIndex]
        this[reverseIndex] = tmp
        reverseIndex--
    }
}

/** Reverses elements in the buffer in-place. */
fun CharBuffer.reverse() {
    val midPoint = lim / 2 - 1
    if (midPoint < 0) return
    var reverseIndex = lastIndex
    for (index in 0..midPoint) {
        val tmp = this[index]
        this[index] = this[reverseIndex]
        this[reverseIndex] = tmp
        reverseIndex--
    }
}


/** Reverses elements of the array in the specified range in-place.
 *  @param fromIndex the start of the range (inclusive) to reverse.
 *  @param toIndex the end of the range (exclusive) to reverse.
 *  @throws IndexOutOfBoundsException if [fromIndex] is less than zero or [toIndex] is greater than the size of this array.
 *  @throws IllegalArgumentException if [fromIndex] is greater than [toIndex]. */
fun ByteBuffer.reverse(fromIndex: Int, toIndex: Int): Unit {
    checkRangeIndexes(fromIndex, toIndex, size)
    val midPoint = (fromIndex + toIndex) / 2
    if (fromIndex == midPoint) return
    var reverseIndex = toIndex - 1
    for (index in fromIndex until midPoint) {
        val tmp = this[index]
        this[index] = this[reverseIndex]
        this[reverseIndex] = tmp
        reverseIndex--
    }
}

/** Reverses elements of the array in the specified range in-place.
 *  @param fromIndex the start of the range (inclusive) to reverse.
 *  @param toIndex the end of the range (exclusive) to reverse.
 *  @throws IndexOutOfBoundsException if [fromIndex] is less than zero or [toIndex] is greater than the size of this array.
 *  @throws IllegalArgumentException if [fromIndex] is greater than [toIndex]. */
fun ShortBuffer.reverse(fromIndex: Int, toIndex: Int): Unit {
    checkRangeIndexes(fromIndex, toIndex, size)
    val midPoint = (fromIndex + toIndex) / 2
    if (fromIndex == midPoint) return
    var reverseIndex = toIndex - 1
    for (index in fromIndex until midPoint) {
        val tmp = this[index]
        this[index] = this[reverseIndex]
        this[reverseIndex] = tmp
        reverseIndex--
    }
}

/** Reverses elements of the array in the specified range in-place.
 *  @param fromIndex the start of the range (inclusive) to reverse.
 *  @param toIndex the end of the range (exclusive) to reverse.
 *  @throws IndexOutOfBoundsException if [fromIndex] is less than zero or [toIndex] is greater than the size of this array.
 *  @throws IllegalArgumentException if [fromIndex] is greater than [toIndex]. */
fun IntBuffer.reverse(fromIndex: Int, toIndex: Int): Unit {
    checkRangeIndexes(fromIndex, toIndex, size)
    val midPoint = (fromIndex + toIndex) / 2
    if (fromIndex == midPoint) return
    var reverseIndex = toIndex - 1
    for (index in fromIndex until midPoint) {
        val tmp = this[index]
        this[index] = this[reverseIndex]
        this[reverseIndex] = tmp
        reverseIndex--
    }
}

/** Reverses elements of the array in the specified range in-place.
 *  @param fromIndex the start of the range (inclusive) to reverse.
 *  @param toIndex the end of the range (exclusive) to reverse.
 *  @throws IndexOutOfBoundsException if [fromIndex] is less than zero or [toIndex] is greater than the size of this array.
 *  @throws IllegalArgumentException if [fromIndex] is greater than [toIndex]. */
fun LongBuffer.reverse(fromIndex: Int, toIndex: Int): Unit {
    checkRangeIndexes(fromIndex, toIndex, size)
    val midPoint = (fromIndex + toIndex) / 2
    if (fromIndex == midPoint) return
    var reverseIndex = toIndex - 1
    for (index in fromIndex until midPoint) {
        val tmp = this[index]
        this[index] = this[reverseIndex]
        this[reverseIndex] = tmp
        reverseIndex--
    }
}

/** Reverses elements of the array in the specified range in-place.
 *  @param fromIndex the start of the range (inclusive) to reverse.
 *  @param toIndex the end of the range (exclusive) to reverse.
 *  @throws IndexOutOfBoundsException if [fromIndex] is less than zero or [toIndex] is greater than the size of this array.
 *  @throws IllegalArgumentException if [fromIndex] is greater than [toIndex]. */
fun FloatBuffer.reverse(fromIndex: Int, toIndex: Int): Unit {
    checkRangeIndexes(fromIndex, toIndex, size)
    val midPoint = (fromIndex + toIndex) / 2
    if (fromIndex == midPoint) return
    var reverseIndex = toIndex - 1
    for (index in fromIndex until midPoint) {
        val tmp = this[index]
        this[index] = this[reverseIndex]
        this[reverseIndex] = tmp
        reverseIndex--
    }
}

/** Reverses elements of the array in the specified range in-place.
 *  @param fromIndex the start of the range (inclusive) to reverse.
 *  @param toIndex the end of the range (exclusive) to reverse.
 *  @throws IndexOutOfBoundsException if [fromIndex] is less than zero or [toIndex] is greater than the size of this array.
 *  @throws IllegalArgumentException if [fromIndex] is greater than [toIndex]. */
fun DoubleBuffer.reverse(fromIndex: Int, toIndex: Int): Unit {
    checkRangeIndexes(fromIndex, toIndex, size)
    val midPoint = (fromIndex + toIndex) / 2
    if (fromIndex == midPoint) return
    var reverseIndex = toIndex - 1
    for (index in fromIndex until midPoint) {
        val tmp = this[index]
        this[index] = this[reverseIndex]
        this[reverseIndex] = tmp
        reverseIndex--
    }
}

/** Reverses elements of the array in the specified range in-place.
 *  @param fromIndex the start of the range (inclusive) to reverse.
 *  @param toIndex the end of the range (exclusive) to reverse.
 *  @throws IndexOutOfBoundsException if [fromIndex] is less than zero or [toIndex] is greater than the size of this array.
 *  @throws IllegalArgumentException if [fromIndex] is greater than [toIndex]. */
fun CharBuffer.reverse(fromIndex: Int, toIndex: Int): Unit {
    checkRangeIndexes(fromIndex, toIndex, size)
    val midPoint = (fromIndex + toIndex) / 2
    if (fromIndex == midPoint) return
    var reverseIndex = toIndex - 1
    for (index in fromIndex until midPoint) {
        val tmp = this[index]
        this[index] = this[reverseIndex]
        this[reverseIndex] = tmp
        reverseIndex--
    }
}


/** Returns a list with elements in reversed order. */
fun ByteBuffer.reversed(): List<Byte> {
    if (isEmpty()) return emptyList()
    val list = toMutableList()
    list.reverse()
    return list
}

/** Returns a list with elements in reversed order. */
fun ShortBuffer.reversed(): List<Short> {
    if (isEmpty()) return emptyList()
    val list = toMutableList()
    list.reverse()
    return list
}

/** Returns a list with elements in reversed order. */
fun IntBuffer.reversed(): List<Int> {
    if (isEmpty()) return emptyList()
    val list = toMutableList()
    list.reverse()
    return list
}

/** Returns a list with elements in reversed order. */
fun LongBuffer.reversed(): List<Long> {
    if (isEmpty()) return emptyList()
    val list = toMutableList()
    list.reverse()
    return list
}

/** Returns a list with elements in reversed order. */
fun FloatBuffer.reversed(): List<Float> {
    if (isEmpty()) return emptyList()
    val list = toMutableList()
    list.reverse()
    return list
}

/** Returns a list with elements in reversed order. */
fun DoubleBuffer.reversed(): List<Double> {
    if (isEmpty()) return emptyList()
    val list = toMutableList()
    list.reverse()
    return list
}

/** Returns a list with elements in reversed order. */
fun CharBuffer.reversed(): List<Char> {
    if (isEmpty()) return emptyList()
    val list = toMutableList()
    list.reverse()
    return list
}


/** Returns an array with elements of this array in reversed order. */
fun ByteBuffer.reversedArray(): ByteArray {
    val result = ByteArray(size)
    val lastIndex = lastIndex
    for (i in 0..lastIndex)
        result[lastIndex - i] = this[i]
    return result
}

/** Returns an array with elements of this array in reversed order. */
fun ShortBuffer.reversedArray(): ShortArray {
    val result = ShortArray(size)
    val lastIndex = lastIndex
    for (i in 0..lastIndex)
        result[lastIndex - i] = this[i]
    return result
}

/** Returns an array with elements of this array in reversed order. */
fun IntBuffer.reversedArray(): IntArray {
    val result = IntArray(size)
    val lastIndex = lastIndex
    for (i in 0..lastIndex)
        result[lastIndex - i] = this[i]
    return result
}

/** Returns an array with elements of this array in reversed order. */
fun LongBuffer.reversedArray(): LongArray {
    val result = LongArray(size)
    val lastIndex = lastIndex
    for (i in 0..lastIndex)
        result[lastIndex - i] = this[i]
    return result
}

/** Returns an array with elements of this array in reversed order. */
fun FloatBuffer.reversedArray(): FloatArray {
    val result = FloatArray(size)
    val lastIndex = lastIndex
    for (i in 0..lastIndex)
        result[lastIndex - i] = this[i]
    return result
}

/** Returns an array with elements of this array in reversed order. */
fun DoubleBuffer.reversedArray(): DoubleArray {
    val result = DoubleArray(size)
    val lastIndex = lastIndex
    for (i in 0..lastIndex)
        result[lastIndex - i] = this[i]
    return result
}


/** Returns an array with elements of this array in reversed order. */
fun CharBuffer.reversedArray(): CharArray {
    val result = CharArray(size)
    val lastIndex = lastIndex
    for (i in 0..lastIndex)
        result[lastIndex - i] = this[i]
    return result
}


/** Randomly shuffles elements in this array in-place. */
fun ByteBuffer.shuffle(): Unit = shuffle(Random)

/** Randomly shuffles elements in this array in-place. */
fun ShortBuffer.shuffle(): Unit = shuffle(Random)

/** Randomly shuffles elements in this array in-place. */
fun IntBuffer.shuffle(): Unit = shuffle(Random)

/** Randomly shuffles elements in this array in-place. */
fun LongBuffer.shuffle(): Unit = shuffle(Random)

/** Randomly shuffles elements in this array in-place. */
fun FloatBuffer.shuffle(): Unit = shuffle(Random)

/** Randomly shuffles elements in this array in-place. */
fun DoubleBuffer.shuffle(): Unit = shuffle(Random)

/** Randomly shuffles elements in this array in-place. */
fun CharBuffer.shuffle(): Unit = shuffle(Random)


/** Randomly shuffles elements in this array in-place using the specified [random] instance as the source of randomness.
 *  See: https://en.wikipedia.org/wiki/Fisher%E2%80%93Yates_shuffle#The_modern_algorithm */
fun ByteBuffer.shuffle(random: Random): Unit {
    for (i in lastIndex downTo 1) {
        val j = random.nextInt(i + 1)
        val copy = this[i]
        this[i] = this[j]
        this[j] = copy
    }
}

/** Randomly shuffles elements in this array in-place using the specified [random] instance as the source of randomness.
 *  See: https://en.wikipedia.org/wiki/Fisher%E2%80%93Yates_shuffle#The_modern_algorithm */
fun ShortBuffer.shuffle(random: Random): Unit {
    for (i in lastIndex downTo 1) {
        val j = random.nextInt(i + 1)
        val copy = this[i]
        this[i] = this[j]
        this[j] = copy
    }
}

/** Randomly shuffles elements in this array in-place using the specified [random] instance as the source of randomness.
 *  See: https://en.wikipedia.org/wiki/Fisher%E2%80%93Yates_shuffle#The_modern_algorithm */
fun IntBuffer.shuffle(random: Random): Unit {
    for (i in lastIndex downTo 1) {
        val j = random.nextInt(i + 1)
        val copy = this[i]
        this[i] = this[j]
        this[j] = copy
    }

}

/** Randomly shuffles elements in this array in-place using the specified [random] instance as the source of randomness.
 *  See: https://en.wikipedia.org/wiki/Fisher%E2%80%93Yates_shuffle#The_modern_algorithm */
fun LongBuffer.shuffle(random: Random): Unit {
    for (i in lastIndex downTo 1) {
        val j = random.nextInt(i + 1)
        val copy = this[i]
        this[i] = this[j]
        this[j] = copy
    }
}

/** Randomly shuffles elements in this array in-place using the specified [random] instance as the source of randomness.
 *  See: https://en.wikipedia.org/wiki/Fisher%E2%80%93Yates_shuffle#The_modern_algorithm */
fun FloatBuffer.shuffle(random: Random): Unit {
    for (i in lastIndex downTo 1) {
        val j = random.nextInt(i + 1)
        val copy = this[i]
        this[i] = this[j]
        this[j] = copy
    }
}

/** Randomly shuffles elements in this array in-place using the specified [random] instance as the source of randomness.
 *  See: https://en.wikipedia.org/wiki/Fisher%E2%80%93Yates_shuffle#The_modern_algorithm */
fun DoubleBuffer.shuffle(random: Random): Unit {
    for (i in lastIndex downTo 1) {
        val j = random.nextInt(i + 1)
        val copy = this[i]
        this[i] = this[j]
        this[j] = copy
    }
}

/** Randomly shuffles elements in this array in-place using the specified [random] instance as the source of randomness.
 *  See: https://en.wikipedia.org/wiki/Fisher%E2%80%93Yates_shuffle#The_modern_algorithm */
fun CharBuffer.shuffle(random: Random): Unit {
    for (i in lastIndex downTo 1) {
        val j = random.nextInt(i + 1)
        val copy = this[i]
        this[i] = this[j]
        this[j] = copy
    }
}


/** Sorts elements in the array in-place descending according to their natural sort order. */
fun ByteBuffer.sortDescending(): Unit {
    if (size > 1) {
        sort()
        reverse()
    }
}

/** Sorts elements in the array in-place descending according to their natural sort order. */
fun ShortBuffer.sortDescending(): Unit {
    if (size > 1) {
        sort()
        reverse()
    }
}

/** Sorts elements in the array in-place descending according to their natural sort order. */
fun IntBuffer.sortDescending(): Unit {
    if (size > 1) {
        sort()
        reverse()
    }
}

/** Sorts elements in the array in-place descending according to their natural sort order. */
fun LongBuffer.sortDescending(): Unit {
    if (size > 1) {
        sort()
        reverse()
    }
}

/** Sorts elements in the array in-place descending according to their natural sort order. */
fun FloatBuffer.sortDescending(): Unit {
    if (size > 1) {
        sort()
        reverse()
    }
}

/** Sorts elements in the array in-place descending according to their natural sort order. */
fun DoubleBuffer.sortDescending(): Unit {
    if (size > 1) {
        sort()
        reverse()
    }
}

/** Sorts elements in the array in-place descending according to their natural sort order. */
fun CharBuffer.sortDescending(): Unit {
    if (size > 1) {
        sort()
        reverse()
    }
}


/** Returns a list of all elements sorted according to their natural sort order. */
fun ByteBuffer.sorted(): List<Byte> = toTypedArray().apply { sort() }.asList()

/** Returns a list of all elements sorted according to their natural sort order. */
fun ShortBuffer.sorted(): List<Short> = toTypedArray().apply { sort() }.asList()

/** Returns a list of all elements sorted according to their natural sort order. */
fun IntBuffer.sorted(): List<Int> = toTypedArray().apply { sort() }.asList()

/** Returns a list of all elements sorted according to their natural sort order. */
fun LongBuffer.sorted(): List<Long> = toTypedArray().apply { sort() }.asList()

/** Returns a list of all elements sorted according to their natural sort order. */
fun FloatBuffer.sorted(): List<Float> = toTypedArray().apply { sort() }.asList()

/** Returns a list of all elements sorted according to their natural sort order. */
fun DoubleBuffer.sorted(): List<Double> = toTypedArray().apply { sort() }.asList()

/** Returns a list of all elements sorted according to their natural sort order. */
fun CharBuffer.sorted(): List<Char> = toTypedArray().apply { sort() }.asList()


/** Returns an array with all elements of this array sorted according to their natural sort order. */
fun ByteBuffer.sortedArray(): ByteArray = toByteArray().apply { sort() }

/** Returns an array with all elements of this array sorted according to their natural sort order. */
fun ShortBuffer.sortedArray(): ShortArray = toShortArray().apply { sort() }

/** Returns an array with all elements of this array sorted according to their natural sort order. */
fun IntBuffer.sortedArray(): IntArray = toIntArray().apply { sort() }

/** Returns an array with all elements of this array sorted according to their natural sort order. */
fun LongBuffer.sortedArray(): LongArray = toLongArray().apply { sort() }

/** Returns an array with all elements of this array sorted according to their natural sort order. */
fun FloatBuffer.sortedArray(): FloatArray = toFloatArray().apply { sort() }

/** Returns an array with all elements of this array sorted according to their natural sort order. */
fun DoubleBuffer.sortedArray(): DoubleArray = toDoubleArray().apply { sort() }

/** Returns an array with all elements of this array sorted according to their natural sort order. */
fun CharBuffer.sortedArray(): CharArray = toCharArray().apply { sort() }


/** Returns an array with all elements of this array sorted descending according to their natural sort order. */
fun ByteBuffer.sortedArrayDescending(): ByteArray = toByteArray().apply { sortDescending() }

/** Returns an array with all elements of this array sorted descending according to their natural sort order. */
fun ShortBuffer.sortedArrayDescending(): ShortArray = toShortArray().apply { sortDescending() }

/** Returns an array with all elements of this array sorted descending according to their natural sort order. */
fun IntBuffer.sortedArrayDescending(): IntArray = toIntArray().apply { sortDescending() }

/** Returns an array with all elements of this array sorted descending according to their natural sort order. */
fun LongBuffer.sortedArrayDescending(): LongArray = toLongArray().apply { sortDescending() }

/** Returns an array with all elements of this array sorted descending according to their natural sort order. */
fun FloatBuffer.sortedArrayDescending(): FloatArray = toFloatArray().apply { sortDescending() }

/** Returns an array with all elements of this array sorted descending according to their natural sort order. */
fun DoubleBuffer.sortedArrayDescending(): DoubleArray = toDoubleArray().apply { sortDescending() }

/** Returns an array with all elements of this array sorted descending according to their natural sort order. */
fun CharBuffer.sortedArrayDescending(): CharArray = toCharArray().apply { sortDescending() }


/** Returns a list of all elements sorted according to natural sort order of the value returned by specified [selector] function.
 *  @sample samples.collections.Collections.Sorting.sortedBy */
inline fun <R : Comparable<R>> ByteBuffer.sortedBy(crossinline selector: (Byte) -> R?): List<Byte> = sortedWith(compareBy(selector))

/** Returns a list of all elements sorted according to natural sort order of the value returned by specified [selector] function.
 *  @sample samples.collections.Collections.Sorting.sortedBy */
inline fun <R : Comparable<R>> ShortBuffer.sortedBy(crossinline selector: (Short) -> R?): List<Short> = sortedWith(compareBy(selector))

/** Returns a list of all elements sorted according to natural sort order of the value returned by specified [selector] function.
 *  @sample samples.collections.Collections.Sorting.sortedBy */
inline fun <R : Comparable<R>> IntBuffer.sortedBy(crossinline selector: (Int) -> R?): List<Int> = sortedWith(compareBy(selector))

/** Returns a list of all elements sorted according to natural sort order of the value returned by specified [selector] function.
 *  @sample samples.collections.Collections.Sorting.sortedBy */
inline fun <R : Comparable<R>> LongBuffer.sortedBy(crossinline selector: (Long) -> R?): List<Long> = sortedWith(compareBy(selector))

/** Returns a list of all elements sorted according to natural sort order of the value returned by specified [selector] function.
 *  @sample samples.collections.Collections.Sorting.sortedBy */
inline fun <R : Comparable<R>> FloatBuffer.sortedBy(crossinline selector: (Float) -> R?): List<Float> = sortedWith(compareBy(selector))

/** Returns a list of all elements sorted according to natural sort order of the value returned by specified [selector] function.
 *  @sample samples.collections.Collections.Sorting.sortedBy */
inline fun <R : Comparable<R>> DoubleBuffer.sortedBy(crossinline selector: (Double) -> R?): List<Double> = sortedWith(compareBy(selector))

/** Returns a list of all elements sorted according to natural sort order of the value returned by specified [selector] function.
 *  @sample samples.collections.Collections.Sorting.sortedBy */
inline fun <R : Comparable<R>> CharBuffer.sortedBy(crossinline selector: (Char) -> R?): List<Char> = sortedWith(compareBy(selector))


/** Returns a list of all elements sorted descending according to natural sort order of the value returned by specified [selector] function. */
inline fun <R : Comparable<R>> ByteBuffer.sortedByDescending(crossinline selector: (Byte) -> R?): List<Byte> = sortedWith(compareByDescending(selector))

/** Returns a list of all elements sorted descending according to natural sort order of the value returned by specified [selector] function. */
inline fun <R : Comparable<R>> ShortBuffer.sortedByDescending(crossinline selector: (Short) -> R?): List<Short> = sortedWith(compareByDescending(selector))

/** Returns a list of all elements sorted descending according to natural sort order of the value returned by specified [selector] function. */
inline fun <R : Comparable<R>> IntBuffer.sortedByDescending(crossinline selector: (Int) -> R?): List<Int> = sortedWith(compareByDescending(selector))

/** Returns a list of all elements sorted descending according to natural sort order of the value returned by specified [selector] function. */
inline fun <R : Comparable<R>> LongBuffer.sortedByDescending(crossinline selector: (Long) -> R?): List<Long> = sortedWith(compareByDescending(selector))

/** Returns a list of all elements sorted descending according to natural sort order of the value returned by specified [selector] function. */
inline fun <R : Comparable<R>> FloatBuffer.sortedByDescending(crossinline selector: (Float) -> R?): List<Float> = sortedWith(compareByDescending(selector))

/** Returns a list of all elements sorted descending according to natural sort order of the value returned by specified [selector] function. */
inline fun <R : Comparable<R>> DoubleBuffer.sortedByDescending(crossinline selector: (Double) -> R?): List<Double> = sortedWith(compareByDescending(selector))

/** Returns a list of all elements sorted descending according to natural sort order of the value returned by specified [selector] function. */
inline fun <R : Comparable<R>> CharBuffer.sortedByDescending(crossinline selector: (Char) -> R?): List<Char> = sortedWith(compareByDescending(selector))


/** Returns a list of all elements sorted descending according to their natural sort order. */
fun ByteBuffer.sortedDescending(): List<Byte> = copyOf().apply { sort() }.reversed()

/** Returns a list of all elements sorted descending according to their natural sort order. */
fun ShortBuffer.sortedDescending(): List<Short> = copyOf().apply { sort() }.reversed()

/** Returns a list of all elements sorted descending according to their natural sort order. */
fun IntBuffer.sortedDescending(): List<Int> = copyOf().apply { sort() }.reversed()

/** Returns a list of all elements sorted descending according to their natural sort order. */
fun LongBuffer.sortedDescending(): List<Long> = copyOf().apply { sort() }.reversed()

/** Returns a list of all elements sorted descending according to their natural sort order. */
fun FloatBuffer.sortedDescending(): List<Float> = copyOf().apply { sort() }.reversed()

/** Returns a list of all elements sorted descending according to their natural sort order. */
fun DoubleBuffer.sortedDescending(): List<Double> = copyOf().apply { sort() }.reversed()

/** Returns a list of all elements sorted descending according to their natural sort order. */
fun CharBuffer.sortedDescending(): List<Char> = copyOf().apply { sort() }.reversed()


/** Returns a list of all elements sorted according to the specified [comparator]. */
fun ByteBuffer.sortedWith(comparator: Comparator<in Byte>): List<Byte> = toTypedArray().apply { sortWith(comparator) }.asList()

/** Returns a list of all elements sorted according to the specified [comparator]. */
fun ShortBuffer.sortedWith(comparator: Comparator<in Short>): List<Short> = toTypedArray().apply { sortWith(comparator) }.asList()

/** Returns a list of all elements sorted according to the specified [comparator]. */
fun IntBuffer.sortedWith(comparator: Comparator<in Int>): List<Int> = toTypedArray().apply { sortWith(comparator) }.asList()

/** Returns a list of all elements sorted according to the specified [comparator]. */
fun LongBuffer.sortedWith(comparator: Comparator<in Long>): List<Long> = toTypedArray().apply { sortWith(comparator) }.asList()

/** Returns a list of all elements sorted according to the specified [comparator]. */
fun FloatBuffer.sortedWith(comparator: Comparator<in Float>): List<Float> = toTypedArray().apply { sortWith(comparator) }.asList()

/** Returns a list of all elements sorted according to the specified [comparator]. */
fun DoubleBuffer.sortedWith(comparator: Comparator<in Double>): List<Double> = toTypedArray().apply { sortWith(comparator) }.asList()

/** Returns a list of all elements sorted according to the specified [comparator]. */
fun CharBuffer.sortedWith(comparator: Comparator<in Char>): List<Char> = toTypedArray().apply { sortWith(comparator) }.asList()


/** Returns a [List] that wraps the original buffer. */
fun ByteBuffer.asList(): List<Byte> = object : AbstractList<Byte>(), RandomAccess {
    override val size get() = lim
    override fun isEmpty(): Boolean = isEmpty()
    override fun contains(element: Byte): Boolean = contains(element)
    override fun get(index: Int): Byte = get(index)
    override fun indexOf(element: Byte): Int = indexOf(element)
    override fun lastIndexOf(element: Byte): Int = lastIndexOf(element)
}

/** Returns a [List] that wraps the original buffer. */
fun ShortBuffer.asList(): List<Short> = object : AbstractList<Short>(), RandomAccess {
    override val size: Int get() = lim
    override fun isEmpty(): Boolean = isEmpty()
    override fun contains(element: Short): Boolean = contains(element)
    override fun get(index: Int): Short = get(index)
    override fun indexOf(element: Short): Int = indexOf(element)
    override fun lastIndexOf(element: Short): Int = lastIndexOf(element)
}

/** Returns a [List] that wraps the original buffer. */
fun IntBuffer.asList(): List<Int> = object : AbstractList<Int>(), RandomAccess {
    override val size: Int get() = lim
    override fun isEmpty(): Boolean = isEmpty()
    override fun contains(element: Int): Boolean = contains(element)
    override fun get(index: Int): Int = get(index)
    override fun indexOf(element: Int): Int = indexOf(element)
    override fun lastIndexOf(element: Int): Int = lastIndexOf(element)
}

/** Returns a [List] that wraps the original buffer. */
fun LongBuffer.asList(): List<Long> = object : AbstractList<Long>(), RandomAccess {
    override val size: Int get() = lim
    override fun isEmpty(): Boolean = isEmpty()
    override fun contains(element: Long): Boolean = contains(element)
    override fun get(index: Int): Long = get(index)
    override fun indexOf(element: Long): Int = indexOf(element)
    override fun lastIndexOf(element: Long): Int = lastIndexOf(element)
}

/** Returns a [List] that wraps the original buffer. */
fun FloatBuffer.asList(): List<Float> = object : AbstractList<Float>(), RandomAccess {
    override val size: Int get() = lim
    override fun isEmpty(): Boolean = isEmpty()
    override fun contains(element: Float): Boolean = contains(element)
    override fun get(index: Int): Float = get(index)
    override fun indexOf(element: Float): Int = indexOf(element)
    override fun lastIndexOf(element: Float): Int = lastIndexOf(element)
}

/** Returns a [List] that wraps the original buffer. */
fun DoubleBuffer.asList(): List<Double> = object : AbstractList<Double>(), RandomAccess {
    override val size: Int get() = lim
    override fun isEmpty(): Boolean = isEmpty()
    override fun contains(element: Double): Boolean = contains(element)
    override fun get(index: Int): Double = get(index)
    override fun indexOf(element: Double): Int = indexOf(element)
    override fun lastIndexOf(element: Double): Int = lastIndexOf(element)
}

/** Returns a [List] that wraps the original buffer. */
fun CharBuffer.asList(): List<Char> = object : AbstractList<Char>(), RandomAccess {
    override val size: Int get() = lim
    override fun isEmpty(): Boolean = isEmpty()
    override fun contains(element: Char): Boolean = contains(element)
    override fun get(index: Int): Char = get(index)
    override fun indexOf(element: Char): Int = indexOf(element)
    override fun lastIndexOf(element: Char): Int = lastIndexOf(element)
}


/** Returns `true` if the two specified arrays are *structurally* equal to one another,
 *  i.e. contain the same number of the same elements in the same order.
 *  The elements are compared for equality with the [equals][Any.equals] function.
 *  For floating point numbers it means that `NaN` is equal to itself and `-0.0` is not equal to `0.0`. */
infix fun ByteBuffer?.contentEquals(other: ByteArray?): Boolean = this?.equals(other) == true

/** Returns `true` if the two specified arrays are *structurally* equal to one another,
 *  i.e. contain the same number of the same elements in the same order.
 *  The elements are compared for equality with the [equals][Any.equals] function.
 *  For floating point numbers it means that `NaN` is equal to itself and `-0.0` is not equal to `0.0`. */
infix fun ShortBuffer?.contentEquals(other: ShortArray?): Boolean = this?.equals(other) == true

/** Returns `true` if the two specified arrays are *structurally* equal to one another,
 *  i.e. contain the same number of the same elements in the same order.
 *  The elements are compared for equality with the [equals][Any.equals] function.
 *  For floating point numbers it means that `NaN` is equal to itself and `-0.0` is not equal to `0.0`. */
infix fun IntBuffer?.contentEquals(other: IntArray?): Boolean = this?.equals(other) == true

/** Returns `true` if the two specified arrays are *structurally* equal to one another,
 *  i.e. contain the same number of the same elements in the same order.
 *  The elements are compared for equality with the [equals][Any.equals] function.
 *  For floating point numbers it means that `NaN` is equal to itself and `-0.0` is not equal to `0.0`. */
infix fun LongBuffer?.contentEquals(other: LongArray?): Boolean = this?.equals(other) == true

/** Returns `true` if the two specified arrays are *structurally* equal to one another,
 *  i.e. contain the same number of the same elements in the same order.
 *  The elements are compared for equality with the [equals][Any.equals] function.
 *  For floating point numbers it means that `NaN` is equal to itself and `-0.0` is not equal to `0.0`. */
infix fun FloatBuffer?.contentEquals(other: FloatArray?): Boolean = this?.equals(other) == true

/** Returns `true` if the two specified arrays are *structurally* equal to one another,
 *  i.e. contain the same number of the same elements in the same order.
 *  The elements are compared for equality with the [equals][Any.equals] function.
 *  For floating point numbers it means that `NaN` is equal to itself and `-0.0` is not equal to `0.0`. */
infix fun DoubleBuffer?.contentEquals(other: DoubleArray?): Boolean = this?.equals(other) == true

/** Returns `true` if the two specified arrays are *structurally* equal to one another,
 *  i.e. contain the same number of the same elements in the same order.
 *  The elements are compared for equality with the [equals][Any.equals] function.
 *  For floating point numbers it means that `NaN` is equal to itself and `-0.0` is not equal to `0.0`. */
infix fun CharBuffer?.contentEquals(other: CharArray?): Boolean = this?.equals(other) == true


/** Returns a hash code based on the contents of this array as if it is [List]. */
fun ByteArray?.contentHashCode(): Int = this?.hashCode() ?: 0

/** Returns a hash code based on the contents of this array as if it is [List]. */
fun ShortArray?.contentHashCode(): Int = this?.hashCode() ?: 0

/** Returns a hash code based on the contents of this array as if it is [List]. */
fun IntArray?.contentHashCode(): Int = this?.hashCode() ?: 0

/** Returns a hash code based on the contents of this array as if it is [List]. */
fun LongArray?.contentHashCode(): Int = this?.hashCode() ?: 0

/** Returns a hash code based on the contents of this array as if it is [List]. */
fun FloatArray?.contentHashCode(): Int = this?.hashCode() ?: 0

/** Returns a hash code based on the contents of this array as if it is [List]. */
fun DoubleArray?.contentHashCode(): Int = this?.hashCode() ?: 0

/** Returns a hash code based on the contents of this array as if it is [List]. */
fun CharArray?.contentHashCode(): Int = this?.hashCode() ?: 0


/** Returns a string representation of the contents of the specified array as if it is [List].
 *  @sample samples.collections.Arrays.ContentOperations.contentToString */
fun ByteBuffer?.contentToString(): String {
    if (this == null) return "null"
    val iMax = size - 1
    if (iMax == -1) return "[]"
    val b = StringBuilder()
    b.append('[')
    var i = 0
    while (true) {
        b.append(this[i])
        if (i == iMax)
            return b.append(']').toString()
        b.append(", ")
    }
}

/** Returns a string representation of the contents of the specified array as if it is [List].
 *  @sample samples.collections.Arrays.ContentOperations.contentToString */
fun ShortBuffer?.contentToString(): String {
    if (this == null) return "null"
    val iMax = size - 1
    if (iMax == -1) return "[]"
    val b = StringBuilder()
    b.append('[')
    var i = 0
    while (true) {
        b.append(this[i])
        if (i == iMax)
            return b.append(']').toString()
        b.append(", ")
    }
}

/** Returns a string representation of the contents of the specified array as if it is [List].
 *  @sample samples.collections.Arrays.ContentOperations.contentToString */
fun IntBuffer?.contentToString(): String {
    if (this == null) return "null"
    val iMax = size - 1
    if (iMax == -1) return "[]"
    val b = StringBuilder()
    b.append('[')
    var i = 0
    while (true) {
        b.append(this[i])
        if (i == iMax)
            return b.append(']').toString()
        b.append(", ")
    }
}

/** Returns a string representation of the contents of the specified array as if it is [List].
 *  @sample samples.collections.Arrays.ContentOperations.contentToString */
fun LongBuffer?.contentToString(): String {
    if (this == null) return "null"
    val iMax = size - 1
    if (iMax == -1) return "[]"
    val b = StringBuilder()
    b.append('[')
    var i = 0
    while (true) {
        b.append(this[i])
        if (i == iMax)
            return b.append(']').toString()
        b.append(", ")
    }
}

/** Returns a string representation of the contents of the specified array as if it is [List].
 *  @sample samples.collections.Arrays.ContentOperations.contentToString */
fun FloatBuffer?.contentToString(): String {
    if (this == null) return "null"
    val iMax = size - 1
    if (iMax == -1) return "[]"
    val b = StringBuilder()
    b.append('[')
    var i = 0
    while (true) {
        b.append(this[i])
        if (i == iMax)
            return b.append(']').toString()
        b.append(", ")
    }
}

/** Returns a string representation of the contents of the specified array as if it is [List].
 *  @sample samples.collections.Arrays.ContentOperations.contentToString */
fun DoubleBuffer?.contentToString(): String {
    if (this == null) return "null"
    val iMax = size - 1
    if (iMax == -1) return "[]"
    val b = StringBuilder()
    b.append('[')
    var i = 0
    while (true) {
        b.append(this[i])
        if (i == iMax)
            return b.append(']').toString()
        b.append(", ")
    }
}

/** Returns a string representation of the contents of the specified array as if it is [List].
 *  @sample samples.collections.Arrays.ContentOperations.contentToString */
fun CharBuffer?.contentToString(): String {
    if (this == null) return "null"
    val iMax = size - 1
    if (iMax == -1) return "[]"
    val b = StringBuilder()
    b.append('[')
    var i = 0
    while (true) {
        b.append(this[i])
        if (i == iMax)
            return b.append(']').toString()
        b.append(", ")
    }
}


/**
 * Copies this array or its subrange into the [destination] array and returns that array.
 *
 * It's allowed to pass the same array in the [destination] and even specify the subrange so that it overlaps with the destination range.
 *
 * @param destination the array to copy to.
 * @param destinationOffset the position in the [destination] array to copy to, 0 by default.
 * @param startIndex the beginning (inclusive) of the subrange to copy, 0 by default.
 * @param endIndex the end (exclusive) of the subrange to copy, size of this array by default.
 *
 * @throws IndexOutOfBoundsException or [IllegalArgumentException] when [startIndex] or [endIndex] is out of range of this array indices or when `startIndex > endIndex`.
 * @throws IndexOutOfBoundsException when the subrange doesn't fit into the [destination] array starting at the specified [destinationOffset],
 * or when that index is out of the [destination] array indices range.
 *
 * @return the [destination] array.
 */
fun ByteBuffer.copyInto(destination: ByteBuffer, destinationOffset: Int = 0, startIndex: Int = 0, endIndex: Int = size): ByteBuffer {
    memCopy(adr + startIndex, destination.adr + destinationOffset, (endIndex - startIndex).toLong())
    return destination
}

/**
 * Copies this array or its subrange into the [destination] array and returns that array.
 *
 * It's allowed to pass the same array in the [destination] and even specify the subrange so that it overlaps with the destination range.
 *
 * @param destination the array to copy to.
 * @param destinationOffset the position in the [destination] array to copy to, 0 by default.
 * @param startIndex the beginning (inclusive) of the subrange to copy, 0 by default.
 * @param endIndex the end (exclusive) of the subrange to copy, size of this array by default.
 *
 * @throws IndexOutOfBoundsException or [IllegalArgumentException] when [startIndex] or [endIndex] is out of range of this array indices or when `startIndex > endIndex`.
 * @throws IndexOutOfBoundsException when the subrange doesn't fit into the [destination] array starting at the specified [destinationOffset],
 * or when that index is out of the [destination] array indices range.
 *
 * @return the [destination] array.
 */
fun ShortBuffer.copyInto(destination: ShortBuffer, destinationOffset: Int = 0, startIndex: Int = 0, endIndex: Int = size): ShortBuffer {
    memCopy(adr + startIndex * Short.BYTES, destination.adr + destinationOffset * Short.BYTES, (endIndex - startIndex).toLong() * Short.BYTES)
    return destination
}

/**
 * Copies this array or its subrange into the [destination] array and returns that array.
 *
 * It's allowed to pass the same array in the [destination] and even specify the subrange so that it overlaps with the destination range.
 *
 * @param destination the array to copy to.
 * @param destinationOffset the position in the [destination] array to copy to, 0 by default.
 * @param startIndex the beginning (inclusive) of the subrange to copy, 0 by default.
 * @param endIndex the end (exclusive) of the subrange to copy, size of this array by default.
 *
 * @throws IndexOutOfBoundsException or [IllegalArgumentException] when [startIndex] or [endIndex] is out of range of this array indices or when `startIndex > endIndex`.
 * @throws IndexOutOfBoundsException when the subrange doesn't fit into the [destination] array starting at the specified [destinationOffset],
 * or when that index is out of the [destination] array indices range.
 *
 * @return the [destination] array.
 */
fun IntBuffer.copyInto(destination: IntBuffer, destinationOffset: Int = 0, startIndex: Int = 0, endIndex: Int = size): IntBuffer {
    memCopy(adr + startIndex * Int.BYTES, destination.adr + destinationOffset * Int.BYTES, (endIndex - startIndex).toLong() * Int.BYTES)
    return destination
}

/**
 * Copies this array or its subrange into the [destination] array and returns that array.
 *
 * It's allowed to pass the same array in the [destination] and even specify the subrange so that it overlaps with the destination range.
 *
 * @param destination the array to copy to.
 * @param destinationOffset the position in the [destination] array to copy to, 0 by default.
 * @param startIndex the beginning (inclusive) of the subrange to copy, 0 by default.
 * @param endIndex the end (exclusive) of the subrange to copy, size of this array by default.
 *
 * @throws IndexOutOfBoundsException or [IllegalArgumentException] when [startIndex] or [endIndex] is out of range of this array indices or when `startIndex > endIndex`.
 * @throws IndexOutOfBoundsException when the subrange doesn't fit into the [destination] array starting at the specified [destinationOffset],
 * or when that index is out of the [destination] array indices range.
 *
 * @return the [destination] array.
 */
fun LongBuffer.copyInto(destination: LongBuffer, destinationOffset: Int = 0, startIndex: Int = 0, endIndex: Int = size): LongBuffer {
    memCopy(adr + startIndex * Long.BYTES, destination.adr + destinationOffset * Long.BYTES, (endIndex - startIndex).toLong() * Long.BYTES)
    return destination
}

/**
 * Copies this array or its subrange into the [destination] array and returns that array.
 *
 * It's allowed to pass the same array in the [destination] and even specify the subrange so that it overlaps with the destination range.
 *
 * @param destination the array to copy to.
 * @param destinationOffset the position in the [destination] array to copy to, 0 by default.
 * @param startIndex the beginning (inclusive) of the subrange to copy, 0 by default.
 * @param endIndex the end (exclusive) of the subrange to copy, size of this array by default.
 *
 * @throws IndexOutOfBoundsException or [IllegalArgumentException] when [startIndex] or [endIndex] is out of range of this array indices or when `startIndex > endIndex`.
 * @throws IndexOutOfBoundsException when the subrange doesn't fit into the [destination] array starting at the specified [destinationOffset],
 * or when that index is out of the [destination] array indices range.
 *
 * @return the [destination] array.
 */
fun FloatBuffer.copyInto(destination: FloatBuffer, destinationOffset: Int = 0, startIndex: Int = 0, endIndex: Int = size): FloatBuffer {
    memCopy(adr + startIndex * Float.BYTES, destination.adr + destinationOffset * Float.BYTES, (endIndex - startIndex).toLong() * Float.BYTES)
    return destination
}

/**
 * Copies this array or its subrange into the [destination] array and returns that array.
 *
 * It's allowed to pass the same array in the [destination] and even specify the subrange so that it overlaps with the destination range.
 *
 * @param destination the array to copy to.
 * @param destinationOffset the position in the [destination] array to copy to, 0 by default.
 * @param startIndex the beginning (inclusive) of the subrange to copy, 0 by default.
 * @param endIndex the end (exclusive) of the subrange to copy, size of this array by default.
 *
 * @throws IndexOutOfBoundsException or [IllegalArgumentException] when [startIndex] or [endIndex] is out of range of this array indices or when `startIndex > endIndex`.
 * @throws IndexOutOfBoundsException when the subrange doesn't fit into the [destination] array starting at the specified [destinationOffset],
 * or when that index is out of the [destination] array indices range.
 *
 * @return the [destination] array.
 */
fun DoubleBuffer.copyInto(destination: DoubleBuffer, destinationOffset: Int = 0, startIndex: Int = 0, endIndex: Int = size): DoubleBuffer {
    memCopy(adr + startIndex * Double.BYTES, destination.adr + destinationOffset * Double.BYTES, (endIndex - startIndex).toLong() * Double.BYTES)
    return destination
}

/**
 * Copies this array or its subrange into the [destination] array and returns that array.
 *
 * It's allowed to pass the same array in the [destination] and even specify the subrange so that it overlaps with the destination range.
 *
 * @param destination the array to copy to.
 * @param destinationOffset the position in the [destination] array to copy to, 0 by default.
 * @param startIndex the beginning (inclusive) of the subrange to copy, 0 by default.
 * @param endIndex the end (exclusive) of the subrange to copy, size of this array by default.
 *
 * @throws IndexOutOfBoundsException or [IllegalArgumentException] when [startIndex] or [endIndex] is out of range of this array indices or when `startIndex > endIndex`.
 * @throws IndexOutOfBoundsException when the subrange doesn't fit into the [destination] array starting at the specified [destinationOffset],
 * or when that index is out of the [destination] array indices range.
 *
 * @return the [destination] array.
 */
fun CharBuffer.copyInto(destination: CharBuffer, destinationOffset: Int = 0, startIndex: Int = 0, endIndex: Int = size): CharBuffer {
    memCopy(adr + startIndex * Char.BYTES, destination.adr + destinationOffset * Char.BYTES, (endIndex - startIndex).toLong() * Char.BYTES)
    return destination
}


/** Returns new array which is a copy of the original array.
 *  @sample samples.collections.Arrays.CopyOfOperations.copyOf */
fun ByteBuffer.copyOf(): ByteBuffer {
    val dst = memAlloc(lim)
    memCopy(adr, dst.adr, lim.toLong())
    return dst
}

/** Returns new array which is a copy of the original array.
 *  @sample samples.collections.Arrays.CopyOfOperations.copyOf */
fun ShortBuffer.copyOf(): ShortBuffer {
    val dst = memAllocShort(lim)
    memCopy(adr, dst.adr, lim.toLong() * Short.BYTES)
    return dst
}

/** Returns new array which is a copy of the original array.
 *  @sample samples.collections.Arrays.CopyOfOperations.copyOf */
fun IntBuffer.copyOf(): IntBuffer {
    val dst = memAllocInt(lim)
    memCopy(adr, dst.adr, lim.toLong() * Int.BYTES)
    return dst
}

/** Returns new array which is a copy of the original array.
 *  @sample samples.collections.Arrays.CopyOfOperations.copyOf */
fun LongBuffer.copyOf(): LongBuffer {
    val dst = memAllocLong(lim)
    memCopy(adr, dst.adr, lim.toLong() * Long.BYTES)
    return dst
}

/** Returns new array which is a copy of the original array.
 *  @sample samples.collections.Arrays.CopyOfOperations.copyOf */
fun FloatBuffer.copyOf(): FloatBuffer {
    val dst = memAllocFloat(lim)
    memCopy(adr, dst.adr, lim.toLong() * Float.BYTES)
    return dst
}

/** Returns new array which is a copy of the original array.
 *  @sample samples.collections.Arrays.CopyOfOperations.copyOf */
fun DoubleBuffer.copyOf(): DoubleBuffer {
    val dst = memAllocDouble(lim)
    memCopy(adr, dst.adr, lim.toLong() * Double.BYTES)
    return dst
}

/** Returns new array which is a copy of the original array.
 *  @sample samples.collections.Arrays.CopyOfOperations.copyOf */
fun CharBuffer.copyOf(): CharBuffer {
    val dst = memAlloc(lim * Char.BYTES)
    memCopy(adr, dst.adr, lim.toLong() * Char.BYTES)
    return dst.asCharBuffer()
}


/**
 * Returns new array which is a copy of the original array, resized to the given [newSize].
 * The copy is either truncated or padded at the end with zero values if necessary.
 *
 * - If [newSize] is less than the size of the original array, the copy array is truncated to the [newSize].
 * - If [newSize] is greater than the size of the original array, the extra elements in the copy array are filled with zero values.
 *
 * @sample samples.collections.Arrays.CopyOfOperations.resizedPrimitiveCopyOf
 */
fun ByteBuffer.copyOf(newSize: Int): ByteBuffer {
    val dst = memAlloc(newSize)
    memCopy(adr, dst.adr, size min newSize)
    return dst
}

/**
 * Returns new array which is a copy of the original array, resized to the given [newSize].
 * The copy is either truncated or padded at the end with zero values if necessary.
 *
 * - If [newSize] is less than the size of the original array, the copy array is truncated to the [newSize].
 * - If [newSize] is greater than the size of the original array, the extra elements in the copy array are filled with zero values.
 *
 * @sample samples.collections.Arrays.CopyOfOperations.resizedPrimitiveCopyOf
 */
fun ShortBuffer.copyOf(newSize: Int): ShortBuffer {
    val dst = memAllocShort(newSize)
    memCopy(adr, dst.adr, (size min newSize).toLong() * Short.BYTES)
    return dst
}

/**
 * Returns new array which is a copy of the original array, resized to the given [newSize].
 * The copy is either truncated or padded at the end with zero values if necessary.
 *
 * - If [newSize] is less than the size of the original array, the copy array is truncated to the [newSize].
 * - If [newSize] is greater than the size of the original array, the extra elements in the copy array are filled with zero values.
 *
 * @sample samples.collections.Arrays.CopyOfOperations.resizedPrimitiveCopyOf
 */
fun IntBuffer.copyOf(newSize: Int): IntBuffer {
    val dst = memAllocInt(newSize)
    memCopy(adr, dst.adr, (size min newSize).toLong() * Int.BYTES)
    return dst
}

/**
 * Returns new array which is a copy of the original array, resized to the given [newSize].
 * The copy is either truncated or padded at the end with zero values if necessary.
 *
 * - If [newSize] is less than the size of the original array, the copy array is truncated to the [newSize].
 * - If [newSize] is greater than the size of the original array, the extra elements in the copy array are filled with zero values.
 *
 * @sample samples.collections.Arrays.CopyOfOperations.resizedPrimitiveCopyOf
 */
fun LongBuffer.copyOf(newSize: Int): LongBuffer {
    val dst = memAllocLong(newSize)
    memCopy(adr, dst.adr, (size min newSize).toLong() * Long.BYTES)
    return dst
}

/**
 * Returns new array which is a copy of the original array, resized to the given [newSize].
 * The copy is either truncated or padded at the end with zero values if necessary.
 *
 * - If [newSize] is less than the size of the original array, the copy array is truncated to the [newSize].
 * - If [newSize] is greater than the size of the original array, the extra elements in the copy array are filled with zero values.
 *
 * @sample samples.collections.Arrays.CopyOfOperations.resizedPrimitiveCopyOf
 */
fun FloatBuffer.copyOf(newSize: Int): FloatBuffer {
    val dst = memAllocFloat(newSize)
    memCopy(adr, dst.adr, (size min newSize).toLong() * Float.BYTES)
    return dst
}

/**
 * Returns new array which is a copy of the original array, resized to the given [newSize].
 * The copy is either truncated or padded at the end with zero values if necessary.
 *
 * - If [newSize] is less than the size of the original array, the copy array is truncated to the [newSize].
 * - If [newSize] is greater than the size of the original array, the extra elements in the copy array are filled with zero values.
 *
 * @sample samples.collections.Arrays.CopyOfOperations.resizedPrimitiveCopyOf
 */
fun DoubleBuffer.copyOf(newSize: Int): DoubleBuffer {
    val dst = memAllocDouble(newSize)
    memCopy(adr, dst.adr, (size min newSize).toLong() * Double.BYTES)
    return dst
}

/**
 * Returns new array which is a copy of the original array, resized to the given [newSize].
 * The copy is either truncated or padded at the end with zero values if necessary.
 *
 * - If [newSize] is less than the size of the original array, the copy array is truncated to the [newSize].
 * - If [newSize] is greater than the size of the original array, the extra elements in the copy array are filled with zero values.
 *
 * @sample samples.collections.Arrays.CopyOfOperations.resizedPrimitiveCopyOf
 */
fun CharBuffer.copyOf(newSize: Int): CharBuffer {
    val dst = memAlloc(newSize * Char.BYTES)
    memCopy(adr, dst.adr, (size min newSize).toLong() * Char.BYTES)
    return dst.asCharBuffer()
}


/**
 * Returns a new array which is a copy of the specified range of the original array.
 *
 * @param fromIndex the start of the range (inclusive) to copy.
 * @param toIndex the end of the range (exclusive) to copy.
 *
 * @throws IndexOutOfBoundsException if [fromIndex] is less than zero or [toIndex] is greater than the size of this array.
 * @throws IllegalArgumentException if [fromIndex] is greater than [toIndex].
 */
fun ByteBuffer.copyOfRange(fromIndex: Int, toIndex: Int): ByteBuffer {
    val count = toIndex - fromIndex
    val dst = memAlloc(count)
    memCopy(adr, dst.adr, count.toLong() * Byte.BYTES)
    return dst
}

/**
 * Returns a new array which is a copy of the specified range of the original array.
 *
 * @param fromIndex the start of the range (inclusive) to copy.
 * @param toIndex the end of the range (exclusive) to copy.
 *
 * @throws IndexOutOfBoundsException if [fromIndex] is less than zero or [toIndex] is greater than the size of this array.
 * @throws IllegalArgumentException if [fromIndex] is greater than [toIndex].
 */
fun ShortBuffer.copyOfRange(fromIndex: Int, toIndex: Int): ShortBuffer {
    val count = toIndex - fromIndex
    val dst = memAllocShort(count)
    memCopy(adr, dst.adr, count.toLong() * Short.BYTES)
    return dst
}

/**
 * Returns a new array which is a copy of the specified range of the original array.
 *
 * @param fromIndex the start of the range (inclusive) to copy.
 * @param toIndex the end of the range (exclusive) to copy.
 *
 * @throws IndexOutOfBoundsException if [fromIndex] is less than zero or [toIndex] is greater than the size of this array.
 * @throws IllegalArgumentException if [fromIndex] is greater than [toIndex].
 */
fun IntBuffer.copyOfRange(fromIndex: Int, toIndex: Int): IntBuffer {
    val count = toIndex - fromIndex
    val dst = memAllocInt(count)
    memCopy(adr, dst.adr, count.toLong() * Int.BYTES)
    return dst
}

/**
 * Returns a new array which is a copy of the specified range of the original array.
 *
 * @param fromIndex the start of the range (inclusive) to copy.
 * @param toIndex the end of the range (exclusive) to copy.
 *
 * @throws IndexOutOfBoundsException if [fromIndex] is less than zero or [toIndex] is greater than the size of this array.
 * @throws IllegalArgumentException if [fromIndex] is greater than [toIndex].
 */
fun LongBuffer.copyOfRange(fromIndex: Int, toIndex: Int): LongBuffer {
    val count = toIndex - fromIndex
    val dst = memAllocLong(count)
    memCopy(adr, dst.adr, count.toLong() * Long.BYTES)
    return dst
}

/**
 * Returns a new array which is a copy of the specified range of the original array.
 *
 * @param fromIndex the start of the range (inclusive) to copy.
 * @param toIndex the end of the range (exclusive) to copy.
 *
 * @throws IndexOutOfBoundsException if [fromIndex] is less than zero or [toIndex] is greater than the size of this array.
 * @throws IllegalArgumentException if [fromIndex] is greater than [toIndex].
 */
fun FloatBuffer.copyOfRange(fromIndex: Int, toIndex: Int): FloatBuffer {
    val count = toIndex - fromIndex
    val dst = memAllocFloat(count)
    memCopy(adr, dst.adr, count.toLong() * Float.BYTES)
    return dst
}

/**
 * Returns a new array which is a copy of the specified range of the original array.
 *
 * @param fromIndex the start of the range (inclusive) to copy.
 * @param toIndex the end of the range (exclusive) to copy.
 *
 * @throws IndexOutOfBoundsException if [fromIndex] is less than zero or [toIndex] is greater than the size of this array.
 * @throws IllegalArgumentException if [fromIndex] is greater than [toIndex].
 */
fun DoubleBuffer.copyOfRange(fromIndex: Int, toIndex: Int): DoubleBuffer {
    val count = toIndex - fromIndex
    val dst = memAllocDouble(count)
    memCopy(adr, dst.adr, count.toLong() * Double.BYTES)
    return dst
}

/**
 * Returns a new array which is a copy of the specified range of the original array.
 *
 * @param fromIndex the start of the range (inclusive) to copy.
 * @param toIndex the end of the range (exclusive) to copy.
 *
 * @throws IndexOutOfBoundsException if [fromIndex] is less than zero or [toIndex] is greater than the size of this array.
 * @throws IllegalArgumentException if [fromIndex] is greater than [toIndex].
 */
fun CharBuffer.copyOfRange(fromIndex: Int, toIndex: Int): CharBuffer {
    val count = toIndex - fromIndex
    val dst = memAlloc(count * Char.BYTES)
    memCopy(adr, dst.adr, count.toLong() * Char.BYTES)
    return dst.asCharBuffer()
}


/** Fills original buffer with the provided value. */
fun ByteBuffer.fill(element: Byte, fromIndex: Int = 0, toIndex: Int = lim) {
    for (i in fromIndex until toIndex) put(i, element)
}

/** Fills original buffer with the provided value. */
fun ShortBuffer.fill(element: Short, fromIndex: Int = 0, toIndex: Int = lim) {
    for (i in fromIndex until toIndex) put(i, element)
}

/** Fills original buffer with the provided value. */
fun IntBuffer.fill(element: Int, fromIndex: Int = 0, toIndex: Int = lim) {
    for (i in fromIndex until toIndex) put(i, element)
}

/** Fills original buffer with the provided value. */
fun LongBuffer.fill(element: Long, fromIndex: Int = 0, toIndex: Int = lim) {
    for (i in fromIndex until toIndex) put(i, element)
}

/** Fills original buffer with the provided value. */
fun FloatBuffer.fill(element: Float, fromIndex: Int = 0, toIndex: Int = lim) {
    for (i in fromIndex until toIndex) put(i, element)
}

/** Fills original buffer with the provided value. */
fun DoubleBuffer.fill(element: Double, fromIndex: Int = 0, toIndex: Int = lim) {
    for (i in fromIndex until toIndex) put(i, element)
}

/** Fills original buffer with the provided value. */
fun CharBuffer.fill(element: Char, fromIndex: Int = 0, toIndex: Int = lim) {
    for (i in fromIndex until toIndex) put(i, element)
}


/** Returns the range of valid indices for the buffer. */
val ByteBuffer.indices: IntRange
    get() = IntRange(0, lastIndex)

/** Returns the range of valid indices for the buffer. */
val ShortBuffer.indices: IntRange
    get() = IntRange(0, lastIndex)

/** Returns the range of valid indices for the buffer. */
val IntBuffer.indices: IntRange
    get() = IntRange(0, lastIndex)

/** Returns the range of valid indices for the buffer. */
val LongBuffer.indices: IntRange
    get() = IntRange(0, lastIndex)

/** Returns the range of valid indices for the buffer. */
val FloatBuffer.indices: IntRange
    get() = IntRange(0, lastIndex)

/** Returns the range of valid indices for the buffer. */
val DoubleBuffer.indices: IntRange
    get() = IntRange(0, lastIndex)

/** Returns the range of valid indices for the buffer. */
val CharBuffer.indices: IntRange
    get() = IntRange(0, lastIndex)


/** Returns `true` if the buffer is empty. */
fun ByteBuffer.isEmpty(): Boolean = lim == 0

/** Returns `true` if the buffer is empty. */
fun ShortBuffer.isEmpty(): Boolean = lim == 0

/** Returns `true` if the buffer is empty. */
fun IntBuffer.isEmpty(): Boolean = lim == 0

/** Returns `true` if the buffer is empty. */
fun LongBuffer.isEmpty(): Boolean = lim == 0

/** Returns `true` if the buffer is empty. */
fun FloatBuffer.isEmpty(): Boolean = lim == 0

/** Returns `true` if the buffer is empty. */
fun DoubleBuffer.isEmpty(): Boolean = lim == 0

/** Returns `true` if the buffer is empty. */
fun CharBuffer.isEmpty(): Boolean = lim == 0


/** Returns `true` if the buffer is not empty. */
fun ByteBuffer.isNotEmpty(): Boolean = !isEmpty()

/** Returns `true` if the buffer is not empty. */
fun ShortBuffer.isNotEmpty(): Boolean = !isEmpty()

/** Returns `true` if the buffer is not empty. */
fun IntBuffer.isNotEmpty(): Boolean = !isEmpty()

/** Returns `true` if the buffer is not empty. */
fun LongBuffer.isNotEmpty(): Boolean = !isEmpty()

/** Returns `true` if the buffer is not empty. */
fun FloatBuffer.isNotEmpty(): Boolean = !isEmpty()

/** Returns `true` if the buffer is not empty. */
fun DoubleBuffer.isNotEmpty(): Boolean = !isEmpty()

/** Returns `true` if the buffer is not empty. */
fun CharBuffer.isNotEmpty(): Boolean = !isEmpty()


/** Returns the last valid index for the buffer. */
val ByteBuffer.lastIndex: Int
    get() = lim - 1

/** Returns the last valid index for the buffer. */
val ShortBuffer.lastIndex: Int
    get() = lim - 1

/** Returns the last valid index for the buffer. */
val IntBuffer.lastIndex: Int
    get() = lim - 1

/** Returns the last valid index for the buffer. */
val LongBuffer.lastIndex: Int
    get() = lim - 1

/** Returns the last valid index for the buffer. */
val FloatBuffer.lastIndex: Int
    get() = lim - 1

/** Returns the last valid index for the buffer. */
val DoubleBuffer.lastIndex: Int
    get() = lim - 1

/** Returns the last valid index for the buffer. */
val CharBuffer.lastIndex: Int
    get() = lim - 1


// TODO this is a delicated thematic

/** Returns a buffer containing all elements of the original buffer and then the given [element]. */
//operator fun ByteBuffer.plus(element: Byte): ByteBuffer {
//    val dst = memAlloc(cap + 1)
//    memCopy(this, dst)
//    return dst.put(cap, element)
//}
//
///** Returns a buffer containing all elements of the original buffer and then the given [element]. */
//operator fun ShortBuffer.plus(element: Short): ShortBuffer {
//    val dst = memAllocShort(cap + 1)
//    memCopy(this, dst)
//    return dst.put(cap, element)
//}
//
///** Returns a buffer containing all elements of the original buffer and then the given [element]. */
//operator fun IntBuffer.plus(element: Int): IntBuffer {
//    val dst = memAllocInt(cap + 1)
//    memCopy(this, dst)
//    return dst.put(cap, element)
//}
//
///** Returns a buffer containing all elements of the original buffer and then the given [element]. */
//operator fun LongBuffer.plus(element: Long): LongBuffer {
//    val dst = memAllocLong(cap + 1)
//    memCopy(this, dst)
//    return dst.put(cap, element)
//}
//
///** Returns a buffer containing all elements of the original buffer and then the given [element]. */
//operator fun FloatBuffer.plus(element: Float): FloatBuffer {
//    val dst = memAllocFloat(cap + 1)
//    memCopy(this, dst)
//    return dst.put(cap, element)
//}
//
///** Returns a buffer containing all elements of the original buffer and then the given [element]. */
//operator fun DoubleBuffer.plus(element: Double): DoubleBuffer {
//    val dst = memAllocDouble(cap + 1)
//    memCopy(this, dst)
//    return dst.put(cap, element)
//}
//
///** Returns a buffer containing all elements of the original buffer and then the given [element]. */
//operator fun CharBuffer.plus(element: Char): CharBuffer {
//    TODO()
//}


///** Returns a buffer containing all elements of the original buffer and then all elements of the given [elements] collection. */
//operator fun ByteBuffer.plus(elements: Collection<Byte>): ByteBuffer {
//    val dst = memAlloc(lim + elements.size)
//    memCopy(this, dst)
//    for (i in elements.indices) dst[lim + i] = elements.elementAt(i)
//    return dst
//}
//
///** Returns a buffer containing all elements of the original buffer and then all elements of the given [elements] collection. */
//operator fun ShortBuffer.plus(elements: Collection<Short>): ShortBuffer {
//    val dst = memAllocShort(lim + elements.size)
//    memCopy(this, dst)
//    for (i in elements.indices) dst[lim + i] = elements.elementAt(i)
//    return dst
//}
//
///** Returns a buffer containing all elements of the original buffer and then all elements of the given [elements] collection. */
//operator fun IntBuffer.plus(elements: Collection<Int>): IntBuffer {
//    val dst = memAllocInt(lim + elements.size)
//    memCopy(this, dst)
//    for (i in elements.indices) dst[lim + i] = elements.elementAt(i)
//    return dst
//}
//
///** Returns a buffer containing all elements of the original buffer and then all elements of the given [elements] collection. */
//operator fun LongBuffer.plus(elements: Collection<Long>): LongBuffer {
//    val dst = memAllocLong(lim + elements.size)
//    memCopy(this, dst)
//    for (i in elements.indices) dst[lim + i] = elements.elementAt(i)
//    return dst
//}
//
///** Returns a buffer containing all elements of the original buffer and then all elements of the given [elements] collection. */
//operator fun FloatBuffer.plus(elements: Collection<Float>): FloatBuffer {
//    val dst = memAllocFloat(lim + elements.size)
//    memCopy(this, dst)
//    for (i in elements.indices) dst[lim + i] = elements.elementAt(i)
//    return dst
//}
//
///** Returns a buffer containing all elements of the original buffer and then all elements of the given [elements] collection. */
//operator fun DoubleBuffer.plus(elements: Collection<Double>): DoubleBuffer {
//    val dst = memAllocDouble(lim + elements.size)
//    memCopy(this, dst)
//    for (i in elements.indices) dst[lim + i] = elements.elementAt(i)
//    return dst
//}
//
///** Returns a buffer containing all elements of the original buffer and then all elements of the given [elements] collection. */
//operator fun CharBuffer.plus(elements: Collection<Char>): CharBuffer {
//    TODO()
//}


/** Returns a buffer containing all elements of the original buffer and then all elements of the given [elements] buffer. */
//operator fun ByteBuffer.plus(elements: ByteBuffer): ByteBuffer {
//    val dst = memAlloc(cap + elements.size)
//    memCopy(this, dst)
//    memCopy(memAddress(elements), memAddress(dst, cap), elements.rem.L)
//    return dst
//}
//
///** Returns a buffer containing all elements of the original buffer and then all elements of the given [elements] buffer. */
//operator fun ShortBuffer.plus(elements: ShortBuffer): ShortBuffer {
//    val dst = memAllocShort(cap + elements.size)
//    memCopy(this, dst)
//    memCopy(memAddress(elements), memAddress(dst, cap), elements.rem.L)
//    return dst
//}
//
///** Returns a buffer containing all elements of the original buffer and then all elements of the given [elements] buffer. */
//operator fun IntBuffer.plus(elements: IntBuffer): IntBuffer {
//    val dst = memAllocInt(cap + elements.size)
//    memCopy(this, dst)
//    memCopy(memAddress(elements), memAddress(dst, cap), elements.rem.L)
//    return dst
//}
//
///** Returns a buffer containing all elements of the original buffer and then all elements of the given [elements] buffer. */
//operator fun LongBuffer.plus(elements: LongBuffer): LongBuffer {
//    val dst = memAllocLong(cap + elements.size)
//    memCopy(this, dst)
//    memCopy(memAddress(elements), memAddress(dst, cap), elements.rem.L)
//    return dst
//}
//
///** Returns a buffer containing all elements of the original buffer and then all elements of the given [elements] buffer. */
//operator fun FloatBuffer.plus(elements: FloatBuffer): FloatBuffer {
//    val dst = memAllocFloat(cap + elements.size)
//    memCopy(this, dst)
//    memCopy(memAddress(elements), memAddress(dst, cap), elements.rem.L)
//    return dst
//}
//
///** Returns a buffer containing all elements of the original buffer and then all elements of the given [elements] buffer. */
//operator fun DoubleBuffer.plus(elements: DoubleBuffer): DoubleBuffer {
//    val dst = memAllocDouble(cap + elements.size)
//    memCopy(this, dst)
//    memCopy(memAddress(elements), memAddress(dst, cap), elements.rem.L)
//    return dst
//}
//
///** Returns a buffer containing all elements of the original buffer and then all elements of the given [elements] buffer. */
//operator fun CharBuffer.plus(elements: CharBuffer): CharBuffer {
//    TODO()
//}


/** Sorts the array in-place.
 *  @sample samples.collections.Arrays.Sorting.sortArray */
fun ByteBuffer.sort() {
    val array = toByteArray().apply { sort() }
    for(i in array.indices)
        set(i, array[i])
}

/** Sorts the array in-place.
 *  @sample samples.collections.Arrays.Sorting.sortArray */
fun ShortBuffer.sort() {
    val array = toShortArray().apply { sort() }
    for(i in array.indices)
        set(i, array[i])
}

/** Sorts the array in-place.
 *  @sample samples.collections.Arrays.Sorting.sortArray */
fun IntBuffer.sort() {
    val array = toIntArray().apply { sort() }
    for(i in array.indices)
        set(i, array[i])
}

/** Sorts the array in-place.
 *  @sample samples.collections.Arrays.Sorting.sortArray */
fun LongBuffer.sort() {
    val array = toLongArray().apply { sort() }
    for(i in array.indices)
        set(i, array[i])
}

/** Sorts the array in-place.
 *  @sample samples.collections.Arrays.Sorting.sortArray */
fun DoubleBuffer.sort() {
    val array = toDoubleArray().apply { sort() }
    for(i in array.indices)
        set(i, array[i])
}

/** Sorts the array in-place.
 *  @sample samples.collections.Arrays.Sorting.sortArray */
fun FloatBuffer.sort() {
    val array = toFloatArray().apply { sort() }
    for(i in array.indices)
        set(i, array[i])
}

/** Sorts the array in-place.
 *  @sample samples.collections.Arrays.Sorting.sortArray */
fun CharBuffer.sort() {
    val array = toCharArray().apply { sort() }
    for(i in array.indices)
        set(i, array[i])
}


/**
 * Sorts a range in the array in-place.
 *
 * @param fromIndex the start of the range (inclusive) to sort, 0 by default.
 * @param toIndex the end of the range (exclusive) to sort, size of this array by default.
 *
 * @throws IndexOutOfBoundsException if [fromIndex] is less than zero or [toIndex] is greater than the size of this array.
 * @throws IllegalArgumentException if [fromIndex] is greater than [toIndex].
 *
 * @sample samples.collections.Arrays.Sorting.sortRangeOfArray
 */
fun ByteBuffer.sort(fromIndex: Int = 0, toIndex: Int = size) {
    val array = ByteArray(toIndex - fromIndex) { this[fromIndex + it] }.apply { sort() }
    for(i in fromIndex until toIndex)
        this[fromIndex + i] = array[i]
}

/**
 * Sorts a range in the array in-place.
 *
 * @param fromIndex the start of the range (inclusive) to sort, 0 by default.
 * @param toIndex the end of the range (exclusive) to sort, size of this array by default.
 *
 * @throws IndexOutOfBoundsException if [fromIndex] is less than zero or [toIndex] is greater than the size of this array.
 * @throws IllegalArgumentException if [fromIndex] is greater than [toIndex].
 *
 * @sample samples.collections.Arrays.Sorting.sortRangeOfArray
 */
fun ShortBuffer.sort(fromIndex: Int = 0, toIndex: Int = size) {
    val array = ShortArray(toIndex - fromIndex) { this[fromIndex + it] }.apply { sort() }
    for(i in fromIndex until toIndex)
        this[fromIndex + i] = array[i]
}

/**
 * Sorts a range in the array in-place.
 *
 * @param fromIndex the start of the range (inclusive) to sort, 0 by default.
 * @param toIndex the end of the range (exclusive) to sort, size of this array by default.
 *
 * @throws IndexOutOfBoundsException if [fromIndex] is less than zero or [toIndex] is greater than the size of this array.
 * @throws IllegalArgumentException if [fromIndex] is greater than [toIndex].
 *
 * @sample samples.collections.Arrays.Sorting.sortRangeOfArray
 */
fun IntBuffer.sort(fromIndex: Int = 0, toIndex: Int = size) {
    val array = IntArray(toIndex - fromIndex) { this[fromIndex + it] }.apply { sort() }
    for(i in fromIndex until toIndex)
        this[fromIndex + i] = array[i]
}

/**
 * Sorts a range in the array in-place.
 *
 * @param fromIndex the start of the range (inclusive) to sort, 0 by default.
 * @param toIndex the end of the range (exclusive) to sort, size of this array by default.
 *
 * @throws IndexOutOfBoundsException if [fromIndex] is less than zero or [toIndex] is greater than the size of this array.
 * @throws IllegalArgumentException if [fromIndex] is greater than [toIndex].
 *
 * @sample samples.collections.Arrays.Sorting.sortRangeOfArray
 */
fun LongBuffer.sort(fromIndex: Int = 0, toIndex: Int = size) {
    val array = LongArray(toIndex - fromIndex) { this[fromIndex + it] }.apply { sort() }
    for(i in fromIndex until toIndex)
        this[fromIndex + i] = array[i]
}

/**
 * Sorts a range in the array in-place.
 *
 * @param fromIndex the start of the range (inclusive) to sort, 0 by default.
 * @param toIndex the end of the range (exclusive) to sort, size of this array by default.
 *
 * @throws IndexOutOfBoundsException if [fromIndex] is less than zero or [toIndex] is greater than the size of this array.
 * @throws IllegalArgumentException if [fromIndex] is greater than [toIndex].
 *
 * @sample samples.collections.Arrays.Sorting.sortRangeOfArray
 */
fun FloatBuffer.sort(fromIndex: Int = 0, toIndex: Int = size) {
    val array = FloatArray(toIndex - fromIndex) { this[fromIndex + it] }.apply { sort() }
    for(i in fromIndex until toIndex)
        this[fromIndex + i] = array[i]
}

/**
 * Sorts a range in the array in-place.
 *
 * @param fromIndex the start of the range (inclusive) to sort, 0 by default.
 * @param toIndex the end of the range (exclusive) to sort, size of this array by default.
 *
 * @throws IndexOutOfBoundsException if [fromIndex] is less than zero or [toIndex] is greater than the size of this array.
 * @throws IllegalArgumentException if [fromIndex] is greater than [toIndex].
 *
 * @sample samples.collections.Arrays.Sorting.sortRangeOfArray
 */
fun DoubleBuffer.sort(fromIndex: Int = 0, toIndex: Int = size) {
    val array = DoubleArray(toIndex - fromIndex) { this[fromIndex + it] }.apply { sort() }
    for(i in fromIndex until toIndex)
        this[fromIndex + i] = array[i]
}

/**
 * Sorts a range in the array in-place.
 *
 * @param fromIndex the start of the range (inclusive) to sort, 0 by default.
 * @param toIndex the end of the range (exclusive) to sort, size of this array by default.
 *
 * @throws IndexOutOfBoundsException if [fromIndex] is less than zero or [toIndex] is greater than the size of this array.
 * @throws IllegalArgumentException if [fromIndex] is greater than [toIndex].
 *
 * @sample samples.collections.Arrays.Sorting.sortRangeOfArray
 */
fun CharBuffer.sort(fromIndex: Int = 0, toIndex: Int = size) {
    val array = CharArray(toIndex - fromIndex) { this[fromIndex + it] }.apply { sort() }
    for(i in fromIndex until toIndex)
        this[fromIndex + i] = array[i]
}


/**
 * Sorts elements of the array in the specified range in-place.
 * The elements are sorted descending according to their natural sort order.
 *
 * @param fromIndex the start of the range (inclusive) to sort.
 * @param toIndex the end of the range (exclusive) to sort.
 *
 * @throws IndexOutOfBoundsException if [fromIndex] is less than zero or [toIndex] is greater than the size of this array.
 * @throws IllegalArgumentException if [fromIndex] is greater than [toIndex].
 */
fun ByteArray.sortDescending(fromIndex: Int, toIndex: Int): Unit {
    sort(fromIndex, toIndex)
    reverse(fromIndex, toIndex)
}

/**
 * Sorts elements of the array in the specified range in-place.
 * The elements are sorted descending according to their natural sort order.
 *
 * @param fromIndex the start of the range (inclusive) to sort.
 * @param toIndex the end of the range (exclusive) to sort.
 *
 * @throws IndexOutOfBoundsException if [fromIndex] is less than zero or [toIndex] is greater than the size of this array.
 * @throws IllegalArgumentException if [fromIndex] is greater than [toIndex].
 */
fun ShortArray.sortDescending(fromIndex: Int, toIndex: Int): Unit {
    sort(fromIndex, toIndex)
    reverse(fromIndex, toIndex)
}

/**
 * Sorts elements of the array in the specified range in-place.
 * The elements are sorted descending according to their natural sort order.
 *
 * @param fromIndex the start of the range (inclusive) to sort.
 * @param toIndex the end of the range (exclusive) to sort.
 *
 * @throws IndexOutOfBoundsException if [fromIndex] is less than zero or [toIndex] is greater than the size of this array.
 * @throws IllegalArgumentException if [fromIndex] is greater than [toIndex].
 */
fun IntArray.sortDescending(fromIndex: Int, toIndex: Int): Unit {
    sort(fromIndex, toIndex)
    reverse(fromIndex, toIndex)
}

/**
 * Sorts elements of the array in the specified range in-place.
 * The elements are sorted descending according to their natural sort order.
 *
 * @param fromIndex the start of the range (inclusive) to sort.
 * @param toIndex the end of the range (exclusive) to sort.
 *
 * @throws IndexOutOfBoundsException if [fromIndex] is less than zero or [toIndex] is greater than the size of this array.
 * @throws IllegalArgumentException if [fromIndex] is greater than [toIndex].
 */
fun LongArray.sortDescending(fromIndex: Int, toIndex: Int): Unit {
    sort(fromIndex, toIndex)
    reverse(fromIndex, toIndex)
}

/**
 * Sorts elements of the array in the specified range in-place.
 * The elements are sorted descending according to their natural sort order.
 *
 * @param fromIndex the start of the range (inclusive) to sort.
 * @param toIndex the end of the range (exclusive) to sort.
 *
 * @throws IndexOutOfBoundsException if [fromIndex] is less than zero or [toIndex] is greater than the size of this array.
 * @throws IllegalArgumentException if [fromIndex] is greater than [toIndex].
 */
fun FloatArray.sortDescending(fromIndex: Int, toIndex: Int): Unit {
    sort(fromIndex, toIndex)
    reverse(fromIndex, toIndex)
}

/**
 * Sorts elements of the array in the specified range in-place.
 * The elements are sorted descending according to their natural sort order.
 *
 * @param fromIndex the start of the range (inclusive) to sort.
 * @param toIndex the end of the range (exclusive) to sort.
 *
 * @throws IndexOutOfBoundsException if [fromIndex] is less than zero or [toIndex] is greater than the size of this array.
 * @throws IllegalArgumentException if [fromIndex] is greater than [toIndex].
 */
fun DoubleArray.sortDescending(fromIndex: Int, toIndex: Int): Unit {
    sort(fromIndex, toIndex)
    reverse(fromIndex, toIndex)
}

/**
 * Sorts elements of the array in the specified range in-place.
 * The elements are sorted descending according to their natural sort order.
 *
 * @param fromIndex the start of the range (inclusive) to sort.
 * @param toIndex the end of the range (exclusive) to sort.
 *
 * @throws IndexOutOfBoundsException if [fromIndex] is less than zero or [toIndex] is greater than the size of this array.
 * @throws IllegalArgumentException if [fromIndex] is greater than [toIndex].
 */
fun CharArray.sortDescending(fromIndex: Int, toIndex: Int): Unit {
    sort(fromIndex, toIndex)
    reverse(fromIndex, toIndex)
}


// TODO?
///**
// * Returns an array of Boolean containing all of the elements of this generic array.
// */
//public fun Array<out Boolean>.toBooleanArray(): BooleanArray {
//    return BooleanArray(size) { index -> this[index] }
//}
//
///**
// * Returns an array of Byte containing all of the elements of this generic array.
// */
//public fun Array<out Byte>.toByteArray(): ByteArray {
//    return ByteArray(size) { index -> this[index] }
//}
//
///**
// * Returns an array of Char containing all of the elements of this generic array.
// */
//public fun Array<out Char>.toCharArray(): CharArray {
//    return CharArray(size) { index -> this[index] }
//}
//
///**
// * Returns an array of Double containing all of the elements of this generic array.
// */
//public fun Array<out Double>.toDoubleArray(): DoubleArray {
//    return DoubleArray(size) { index -> this[index] }
//}
//
///**
// * Returns an array of Float containing all of the elements of this generic array.
// */
//public fun Array<out Float>.toFloatArray(): FloatArray {
//    return FloatArray(size) { index -> this[index] }
//}
//
///**
// * Returns an array of Int containing all of the elements of this generic array.
// */
//public fun Array<out Int>.toIntArray(): IntArray {
//    return IntArray(size) { index -> this[index] }
//}
//
///**
// * Returns an array of Long containing all of the elements of this generic array.
// */
//public fun Array<out Long>.toLongArray(): LongArray {
//    return LongArray(size) { index -> this[index] }
//}
//
///**
// * Returns an array of Short containing all of the elements of this generic array.
// */
//public fun Array<out Short>.toShortArray(): ShortArray {
//    return ShortArray(size) { index -> this[index] }


/** Returns a buffer of Byte containing all of the elements of this primitive buffer. */
fun ByteBuffer.toByteArray(): ByteArray = ByteArray(lim) { get(it) }

/** Returns a buffer of Char containing all of the elements of this primitive buffer. */
fun CharBuffer.toCharArray(): CharArray = CharArray(lim) { get(it) }

/** Returns a buffer of Double containing all of the elements of this primitive buffer. */
fun DoubleBuffer.toDoubleArray(): DoubleArray = DoubleArray(lim) { get(it) }

/** Returns a buffer of Float containing all of the elements of this primitive buffer. */
fun FloatBuffer.toFloatArray(): FloatArray = FloatArray(lim) { get(it) }

/** Returns a buffer of Int containing all of the elements of this primitive buffer. */
fun IntBuffer.toIntArray(): IntArray = IntArray(lim) { get(it) }

/** Returns a buffer of Long containing all of the elements of this primitive buffer. */
fun LongBuffer.toLongArray(): LongArray = LongArray(lim) { get(it) }

/** Returns a buffer of Short containing all of the elements of this primitive buffer. */
fun ShortBuffer.toShortArray(): ShortArray = ShortArray(lim) { get(it) }


// [Kool] custom

/** Returns a direct primitive buffer containing all of the elements of this byte array. */
fun ByteArray.toByteBuffer(): ByteBuffer = ByteBuffer(size) { this[it] }

/** Returns a direct primitive buffer containing all of the elements of this short array. */
fun ShortArray.toShortBuffer(): ShortBuffer = ShortBuffer(size) { this[it] }

/** Returns a direct primitive buffer containing all of the elements of this int array. */
fun IntArray.toIntBuffer(): IntBuffer = IntBuffer(size) { this[it] }

/** Returns a direct primitive buffer containing all of the elements of this long array. */
fun LongArray.toLongBuffer(): LongBuffer = LongBuffer(size) { this[it] }

/** Returns a direct primitive buffer containing all of the elements of this float array. */
fun FloatArray.toFloatBuffer(): FloatBuffer = FloatBuffer(size) { this[it] }

/** Returns a direct primitive buffer containing all of the elements of this double array. */
fun DoubleArray.toDoubleBuffer(): DoubleBuffer = DoubleBuffer(size) { this[it] }

/** Returns a direct primitive buffer containing all of the elements of this char array. */
fun CharArray.toCharBuffer(): CharBuffer = CharBuffer(size) { this[it] }


/** Returns a *typed* object buffer containing all of the elements of this direct primitive buffer. */
fun ByteBuffer.toTypedArray(): Array<Byte> = Array(lim) { get(it) }

/** Returns a *typed* object buffer containing all of the elements of this direct primitive buffer. */
fun ShortBuffer.toTypedArray(): Array<Short> = Array(lim) { get(it) }

/** Returns a *typed* object buffer containing all of the elements of this direct primitive buffer. */
fun IntBuffer.toTypedArray(): Array<Int> = Array(lim) { get(it) }

/** Returns a *typed* object buffer containing all of the elements of this direct primitive buffer. */
fun LongBuffer.toTypedArray(): Array<Long> = Array(lim) { get(it) }

/** Returns a *typed* object buffer containing all of the elements of this direct primitive buffer. */
fun FloatBuffer.toTypedArray(): Array<Float> = Array(lim) { get(it) }

/** Returns a *typed* object buffer containing all of the elements of this direct primitive buffer. */
fun DoubleBuffer.toTypedArray(): Array<Double> = Array(lim) { get(it) }

/** Returns a *typed* object buffer containing all of the elements of this direct primitive buffer. */
fun CharBuffer.toTypedArray(): Array<Char> = Array(lim) { get(it) }


// [Kool] custom

/** Returns a direct Byte buffer containing all of the elements of this generic array. */
fun Array<out Byte>.toByteBuffer(): ByteBuffer = ByteBuffer(size) { get(it) }

/** Returns a direct Short buffer containing all of the elements of this generic array. */
fun Array<out Short>.toShortBuffer(): ShortBuffer = ShortBuffer(size) { get(it) }

/** Returns a direct Int buffer containing all of the elements of this generic array. */
fun Array<out Int>.toIntBuffer(): IntBuffer = IntBuffer(size) { get(it) }

/** Returns a direct Long buffer containing all of the elements of this generic array. */
fun Array<out Long>.toLongBuffer(): LongBuffer = LongBuffer(size) { get(it) }

/** Returns a direct Float buffer containing all of the elements of this generic array. */
fun Array<out Float>.toFloatBuffer(): FloatBuffer = FloatBuffer(size) { get(it) }

/** Returns a direct Double buffer containing all of the elements of this generic array. */
fun Array<out Double>.toDoubleBuffer(): DoubleBuffer = DoubleBuffer(size) { get(it) }

/** Returns a direct Char buffer containing all of the elements of this generic array. */
fun Array<out Char>.toCharBuffer(): CharBuffer = CharBuffer(size) { get(it) }


/**
 * Returns a [Map] containing key-value pairs provided by [transform] function
 * applied to elements of the given array.
 *
 * If any of two pairs would have the same key the last one gets added to the map.
 *
 * The returned map preserves the entry iteration order of the original array.
 *
 * @sample samples.collections.Arrays.Transformations.associateArrayOfPrimitives
 */
inline fun <K, V> ByteBuffer.associate(transform: (Byte) -> Pair<K, V>): Map<K, V> {
    val capacity = mapCapacity(size).coerceAtLeast(16)
    return associateTo(LinkedHashMap<K, V>(capacity), transform)
}

/**
 * Returns a [Map] containing key-value pairs provided by [transform] function
 * applied to elements of the given array.
 *
 * If any of two pairs would have the same key the last one gets added to the map.
 *
 * The returned map preserves the entry iteration order of the original array.
 *
 * @sample samples.collections.Arrays.Transformations.associateArrayOfPrimitives
 */
inline fun <K, V> ShortBuffer.associate(transform: (Short) -> Pair<K, V>): Map<K, V> {
    val capacity = mapCapacity(size).coerceAtLeast(16)
    return associateTo(LinkedHashMap<K, V>(capacity), transform)
}

/**
 * Returns a [Map] containing key-value pairs provided by [transform] function
 * applied to elements of the given array.
 *
 * If any of two pairs would have the same key the last one gets added to the map.
 *
 * The returned map preserves the entry iteration order of the original array.
 *
 * @sample samples.collections.Arrays.Transformations.associateArrayOfPrimitives
 */
inline fun <K, V> IntBuffer.associate(transform: (Int) -> Pair<K, V>): Map<K, V> {
    val capacity = mapCapacity(size).coerceAtLeast(16)
    return associateTo(LinkedHashMap<K, V>(capacity), transform)
}

/**
 * Returns a [Map] containing key-value pairs provided by [transform] function
 * applied to elements of the given array.
 *
 * If any of two pairs would have the same key the last one gets added to the map.
 *
 * The returned map preserves the entry iteration order of the original array.
 *
 * @sample samples.collections.Arrays.Transformations.associateArrayOfPrimitives
 */
inline fun <K, V> LongBuffer.associate(transform: (Long) -> Pair<K, V>): Map<K, V> {
    val capacity = mapCapacity(size).coerceAtLeast(16)
    return associateTo(LinkedHashMap<K, V>(capacity), transform)
}

/**
 * Returns a [Map] containing key-value pairs provided by [transform] function
 * applied to elements of the given array.
 *
 * If any of two pairs would have the same key the last one gets added to the map.
 *
 * The returned map preserves the entry iteration order of the original array.
 *
 * @sample samples.collections.Arrays.Transformations.associateArrayOfPrimitives
 */
inline fun <K, V> FloatBuffer.associate(transform: (Float) -> Pair<K, V>): Map<K, V> {
    val capacity = mapCapacity(size).coerceAtLeast(16)
    return associateTo(LinkedHashMap<K, V>(capacity), transform)
}

/**
 * Returns a [Map] containing key-value pairs provided by [transform] function
 * applied to elements of the given array.
 *
 * If any of two pairs would have the same key the last one gets added to the map.
 *
 * The returned map preserves the entry iteration order of the original array.
 *
 * @sample samples.collections.Arrays.Transformations.associateArrayOfPrimitives
 */
inline fun <K, V> DoubleBuffer.associate(transform: (Double) -> Pair<K, V>): Map<K, V> {
    val capacity = mapCapacity(size).coerceAtLeast(16)
    return associateTo(LinkedHashMap<K, V>(capacity), transform)
}

/**
 * Returns a [Map] containing key-value pairs provided by [transform] function
 * applied to elements of the given array.
 *
 * If any of two pairs would have the same key the last one gets added to the map.
 *
 * The returned map preserves the entry iteration order of the original array.
 *
 * @sample samples.collections.Arrays.Transformations.associateArrayOfPrimitives
 */
inline fun <K, V> CharBuffer.associate(transform: (Char) -> Pair<K, V>): Map<K, V> {
    val capacity = mapCapacity(size).coerceAtLeast(16)
    return associateTo(LinkedHashMap<K, V>(capacity), transform)
}


/**
 * Returns a [Map] containing the elements from the given array indexed by the key
 * returned from [keySelector] function applied to each element.
 *
 * If any two elements would have the same key returned by [keySelector] the last one gets added to the map.
 *
 * The returned map preserves the entry iteration order of the original array.
 *
 * @sample samples.collections.Arrays.Transformations.associateArrayOfPrimitivesBy
 */
inline fun <K> ByteBuffer.associateBy(keySelector: (Byte) -> K): Map<K, Byte> {
    val capacity = mapCapacity(size).coerceAtLeast(16)
    return associateByTo(LinkedHashMap<K, Byte>(capacity), keySelector)
}

/**
 * Returns a [Map] containing the elements from the given array indexed by the key
 * returned from [keySelector] function applied to each element.
 *
 * If any two elements would have the same key returned by [keySelector] the last one gets added to the map.
 *
 * The returned map preserves the entry iteration order of the original array.
 *
 * @sample samples.collections.Arrays.Transformations.associateArrayOfPrimitivesBy
 */
inline fun <K> ShortBuffer.associateBy(keySelector: (Short) -> K): Map<K, Short> {
    val capacity = mapCapacity(size).coerceAtLeast(16)
    return associateByTo(LinkedHashMap<K, Short>(capacity), keySelector)
}

/**
 * Returns a [Map] containing the elements from the given array indexed by the key
 * returned from [keySelector] function applied to each element.
 *
 * If any two elements would have the same key returned by [keySelector] the last one gets added to the map.
 *
 * The returned map preserves the entry iteration order of the original array.
 *
 * @sample samples.collections.Arrays.Transformations.associateArrayOfPrimitivesBy
 */
inline fun <K> IntBuffer.associateBy(keySelector: (Int) -> K): Map<K, Int> {
    val capacity = mapCapacity(size).coerceAtLeast(16)
    return associateByTo(LinkedHashMap<K, Int>(capacity), keySelector)
}

/**
 * Returns a [Map] containing the elements from the given array indexed by the key
 * returned from [keySelector] function applied to each element.
 *
 * If any two elements would have the same key returned by [keySelector] the last one gets added to the map.
 *
 * The returned map preserves the entry iteration order of the original array.
 *
 * @sample samples.collections.Arrays.Transformations.associateArrayOfPrimitivesBy
 */
inline fun <K> LongBuffer.associateBy(keySelector: (Long) -> K): Map<K, Long> {
    val capacity = mapCapacity(size).coerceAtLeast(16)
    return associateByTo(LinkedHashMap<K, Long>(capacity), keySelector)
}

/**
 * Returns a [Map] containing the elements from the given array indexed by the key
 * returned from [keySelector] function applied to each element.
 *
 * If any two elements would have the same key returned by [keySelector] the last one gets added to the map.
 *
 * The returned map preserves the entry iteration order of the original array.
 *
 * @sample samples.collections.Arrays.Transformations.associateArrayOfPrimitivesBy
 */
inline fun <K> FloatBuffer.associateBy(keySelector: (Float) -> K): Map<K, Float> {
    val capacity = mapCapacity(size).coerceAtLeast(16)
    return associateByTo(LinkedHashMap<K, Float>(capacity), keySelector)
}

/**
 * Returns a [Map] containing the elements from the given array indexed by the key
 * returned from [keySelector] function applied to each element.
 *
 * If any two elements would have the same key returned by [keySelector] the last one gets added to the map.
 *
 * The returned map preserves the entry iteration order of the original array.
 *
 * @sample samples.collections.Arrays.Transformations.associateArrayOfPrimitivesBy
 */
inline fun <K> DoubleBuffer.associateBy(keySelector: (Double) -> K): Map<K, Double> {
    val capacity = mapCapacity(size).coerceAtLeast(16)
    return associateByTo(LinkedHashMap<K, Double>(capacity), keySelector)
}

/**
 * Returns a [Map] containing the elements from the given array indexed by the key
 * returned from [keySelector] function applied to each element.
 *
 * If any two elements would have the same key returned by [keySelector] the last one gets added to the map.
 *
 * The returned map preserves the entry iteration order of the original array.
 *
 * @sample samples.collections.Arrays.Transformations.associateArrayOfPrimitivesBy
 */
inline fun <K> CharBuffer.associateBy(keySelector: (Char) -> K): Map<K, Char> {
    val capacity = mapCapacity(size).coerceAtLeast(16)
    return associateByTo(LinkedHashMap<K, Char>(capacity), keySelector)
}


/**
 * Returns a [Map] containing the values provided by [valueTransform] and indexed by [keySelector] functions applied to elements of the given array.
 *
 * If any two elements would have the same key returned by [keySelector] the last one gets added to the map.
 *
 * The returned map preserves the entry iteration order of the original array.
 *
 * @sample samples.collections.Arrays.Transformations.associateArrayOfPrimitivesByWithValueTransform
 */
inline fun <K, V> ByteBuffer.associateBy(keySelector: (Byte) -> K, valueTransform: (Byte) -> V): Map<K, V> {
    val capacity = mapCapacity(size).coerceAtLeast(16)
    return associateByTo(LinkedHashMap<K, V>(capacity), keySelector, valueTransform)
}

/**
 * Returns a [Map] containing the values provided by [valueTransform] and indexed by [keySelector] functions applied to elements of the given array.
 *
 * If any two elements would have the same key returned by [keySelector] the last one gets added to the map.
 *
 * The returned map preserves the entry iteration order of the original array.
 *
 * @sample samples.collections.Arrays.Transformations.associateArrayOfPrimitivesByWithValueTransform
 */
inline fun <K, V> ShortBuffer.associateBy(keySelector: (Short) -> K, valueTransform: (Short) -> V): Map<K, V> {
    val capacity = mapCapacity(size).coerceAtLeast(16)
    return associateByTo(LinkedHashMap<K, V>(capacity), keySelector, valueTransform)
}

/**
 * Returns a [Map] containing the values provided by [valueTransform] and indexed by [keySelector] functions applied to elements of the given array.
 *
 * If any two elements would have the same key returned by [keySelector] the last one gets added to the map.
 *
 * The returned map preserves the entry iteration order of the original array.
 *
 * @sample samples.collections.Arrays.Transformations.associateArrayOfPrimitivesByWithValueTransform
 */
inline fun <K, V> IntBuffer.associateBy(keySelector: (Int) -> K, valueTransform: (Int) -> V): Map<K, V> {
    val capacity = mapCapacity(size).coerceAtLeast(16)
    return associateByTo(LinkedHashMap<K, V>(capacity), keySelector, valueTransform)
}

/**
 * Returns a [Map] containing the values provided by [valueTransform] and indexed by [keySelector] functions applied to elements of the given array.
 *
 * If any two elements would have the same key returned by [keySelector] the last one gets added to the map.
 *
 * The returned map preserves the entry iteration order of the original array.
 *
 * @sample samples.collections.Arrays.Transformations.associateArrayOfPrimitivesByWithValueTransform
 */
inline fun <K, V> LongBuffer.associateBy(keySelector: (Long) -> K, valueTransform: (Long) -> V): Map<K, V> {
    val capacity = mapCapacity(size).coerceAtLeast(16)
    return associateByTo(LinkedHashMap<K, V>(capacity), keySelector, valueTransform)
}

/**
 * Returns a [Map] containing the values provided by [valueTransform] and indexed by [keySelector] functions applied to elements of the given array.
 *
 * If any two elements would have the same key returned by [keySelector] the last one gets added to the map.
 *
 * The returned map preserves the entry iteration order of the original array.
 *
 * @sample samples.collections.Arrays.Transformations.associateArrayOfPrimitivesByWithValueTransform
 */
inline fun <K, V> FloatBuffer.associateBy(keySelector: (Float) -> K, valueTransform: (Float) -> V): Map<K, V> {
    val capacity = mapCapacity(size).coerceAtLeast(16)
    return associateByTo(LinkedHashMap<K, V>(capacity), keySelector, valueTransform)
}

/**
 * Returns a [Map] containing the values provided by [valueTransform] and indexed by [keySelector] functions applied to elements of the given array.
 *
 * If any two elements would have the same key returned by [keySelector] the last one gets added to the map.
 *
 * The returned map preserves the entry iteration order of the original array.
 *
 * @sample samples.collections.Arrays.Transformations.associateArrayOfPrimitivesByWithValueTransform
 */
inline fun <K, V> DoubleBuffer.associateBy(keySelector: (Double) -> K, valueTransform: (Double) -> V): Map<K, V> {
    val capacity = mapCapacity(size).coerceAtLeast(16)
    return associateByTo(LinkedHashMap<K, V>(capacity), keySelector, valueTransform)
}

/**
 * Returns a [Map] containing the values provided by [valueTransform] and indexed by [keySelector] functions applied to elements of the given array.
 *
 * If any two elements would have the same key returned by [keySelector] the last one gets added to the map.
 *
 * The returned map preserves the entry iteration order of the original array.
 *
 * @sample samples.collections.Arrays.Transformations.associateArrayOfPrimitivesByWithValueTransform
 */
inline fun <K, V> CharBuffer.associateBy(keySelector: (Char) -> K, valueTransform: (Char) -> V): Map<K, V> {
    val capacity = mapCapacity(size).coerceAtLeast(16)
    return associateByTo(LinkedHashMap<K, V>(capacity), keySelector, valueTransform)
}


/**
 * Populates and returns the [destination] mutable map with key-value pairs,
 * where key is provided by the [keySelector] function applied to each element of the given array
 * and value is the element itself.
 *
 * If any two elements would have the same key returned by [keySelector] the last one gets added to the map.
 *
 * @sample samples.collections.Arrays.Transformations.associateArrayOfPrimitivesByTo
 */
inline fun <K, M : MutableMap<in K, in Byte>> ByteBuffer.associateByTo(destination: M, keySelector: (Byte) -> K): M {
    for (element in this) destination.put(keySelector(element), element)
    return destination
}

/**
 * Populates and returns the [destination] mutable map with key-value pairs,
 * where key is provided by the [keySelector] function applied to each element of the given array
 * and value is the element itself.
 *
 * If any two elements would have the same key returned by [keySelector] the last one gets added to the map.
 *
 * @sample samples.collections.Arrays.Transformations.associateArrayOfPrimitivesByTo
 */
inline fun <K, M : MutableMap<in K, in Short>> ShortBuffer.associateByTo(destination: M, keySelector: (Short) -> K): M {
    for (element in this) destination.put(keySelector(element), element)
    return destination
}

/**
 * Populates and returns the [destination] mutable map with key-value pairs,
 * where key is provided by the [keySelector] function applied to each element of the given array
 * and value is the element itself.
 *
 * If any two elements would have the same key returned by [keySelector] the last one gets added to the map.
 *
 * @sample samples.collections.Arrays.Transformations.associateArrayOfPrimitivesByTo
 */
inline fun <K, M : MutableMap<in K, in Int>> IntBuffer.associateByTo(destination: M, keySelector: (Int) -> K): M {
    for (element in this) destination.put(keySelector(element), element)
    return destination
}

/**
 * Populates and returns the [destination] mutable map with key-value pairs,
 * where key is provided by the [keySelector] function applied to each element of the given array
 * and value is the element itself.
 *
 * If any two elements would have the same key returned by [keySelector] the last one gets added to the map.
 *
 * @sample samples.collections.Arrays.Transformations.associateArrayOfPrimitivesByTo
 */
inline fun <K, M : MutableMap<in K, in Long>> LongBuffer.associateByTo(destination: M, keySelector: (Long) -> K): M {
    for (element in this) destination.put(keySelector(element), element)
    return destination
}

/**
 * Populates and returns the [destination] mutable map with key-value pairs,
 * where key is provided by the [keySelector] function applied to each element of the given array
 * and value is the element itself.
 *
 * If any two elements would have the same key returned by [keySelector] the last one gets added to the map.
 *
 * @sample samples.collections.Arrays.Transformations.associateArrayOfPrimitivesByTo
 */
inline fun <K, M : MutableMap<in K, in Float>> FloatBuffer.associateByTo(destination: M, keySelector: (Float) -> K): M {
    for (element in this) destination.put(keySelector(element), element)
    return destination
}

/**
 * Populates and returns the [destination] mutable map with key-value pairs,
 * where key is provided by the [keySelector] function applied to each element of the given array
 * and value is the element itself.
 *
 * If any two elements would have the same key returned by [keySelector] the last one gets added to the map.
 *
 * @sample samples.collections.Arrays.Transformations.associateArrayOfPrimitivesByTo
 */
inline fun <K, M : MutableMap<in K, in Double>> DoubleBuffer.associateByTo(destination: M, keySelector: (Double) -> K): M {
    for (element in this) destination.put(keySelector(element), element)
    return destination
}

/**
 * Populates and returns the [destination] mutable map with key-value pairs,
 * where key is provided by the [keySelector] function applied to each element of the given array
 * and value is the element itself.
 *
 * If any two elements would have the same key returned by [keySelector] the last one gets added to the map.
 *
 * @sample samples.collections.Arrays.Transformations.associateArrayOfPrimitivesByTo
 */
inline fun <K, M : MutableMap<in K, in Char>> CharBuffer.associateByTo(destination: M, keySelector: (Char) -> K): M {
    for (element in this) destination.put(keySelector(element), element)
    return destination
}


/**
 * Populates and returns the [destination] mutable map with key-value pairs,
 * where key is provided by the [keySelector] function and
 * and value is provided by the [valueTransform] function applied to elements of the given array.
 *
 * If any two elements would have the same key returned by [keySelector] the last one gets added to the map.
 *
 * @sample samples.collections.Arrays.Transformations.associateArrayOfPrimitivesByToWithValueTransform
 */
inline fun <K, V, M : MutableMap<in K, in V>> ByteBuffer.associateByTo(destination: M, keySelector: (Byte) -> K, valueTransform: (Byte) -> V): M {
    for (element in this) destination.put(keySelector(element), valueTransform(element))
    return destination
}

/**
 * Populates and returns the [destination] mutable map with key-value pairs,
 * where key is provided by the [keySelector] function and
 * and value is provided by the [valueTransform] function applied to elements of the given array.
 *
 * If any two elements would have the same key returned by [keySelector] the last one gets added to the map.
 *
 * @sample samples.collections.Arrays.Transformations.associateArrayOfPrimitivesByToWithValueTransform
 */
inline fun <K, V, M : MutableMap<in K, in V>> ShortBuffer.associateByTo(destination: M, keySelector: (Short) -> K, valueTransform: (Short) -> V): M {
    for (element in this) destination.put(keySelector(element), valueTransform(element))
    return destination
}

/**
 * Populates and returns the [destination] mutable map with key-value pairs,
 * where key is provided by the [keySelector] function and
 * and value is provided by the [valueTransform] function applied to elements of the given array.
 *
 * If any two elements would have the same key returned by [keySelector] the last one gets added to the map.
 *
 * @sample samples.collections.Arrays.Transformations.associateArrayOfPrimitivesByToWithValueTransform
 */
inline fun <K, V, M : MutableMap<in K, in V>> IntBuffer.associateByTo(destination: M, keySelector: (Int) -> K, valueTransform: (Int) -> V): M {
    for (element in this) destination.put(keySelector(element), valueTransform(element))
    return destination
}

/**
 * Populates and returns the [destination] mutable map with key-value pairs,
 * where key is provided by the [keySelector] function and
 * and value is provided by the [valueTransform] function applied to elements of the given array.
 *
 * If any two elements would have the same key returned by [keySelector] the last one gets added to the map.
 *
 * @sample samples.collections.Arrays.Transformations.associateArrayOfPrimitivesByToWithValueTransform
 */
inline fun <K, V, M : MutableMap<in K, in V>> LongBuffer.associateByTo(destination: M, keySelector: (Long) -> K, valueTransform: (Long) -> V): M {
    for (element in this) destination.put(keySelector(element), valueTransform(element))
    return destination
}

/**
 * Populates and returns the [destination] mutable map with key-value pairs,
 * where key is provided by the [keySelector] function and
 * and value is provided by the [valueTransform] function applied to elements of the given array.
 *
 * If any two elements would have the same key returned by [keySelector] the last one gets added to the map.
 *
 * @sample samples.collections.Arrays.Transformations.associateArrayOfPrimitivesByToWithValueTransform
 */
inline fun <K, V, M : MutableMap<in K, in V>> FloatBuffer.associateByTo(destination: M, keySelector: (Float) -> K, valueTransform: (Float) -> V): M {
    for (element in this) destination.put(keySelector(element), valueTransform(element))
    return destination
}

/**
 * Populates and returns the [destination] mutable map with key-value pairs,
 * where key is provided by the [keySelector] function and
 * and value is provided by the [valueTransform] function applied to elements of the given array.
 *
 * If any two elements would have the same key returned by [keySelector] the last one gets added to the map.
 *
 * @sample samples.collections.Arrays.Transformations.associateArrayOfPrimitivesByToWithValueTransform
 */
inline fun <K, V, M : MutableMap<in K, in V>> DoubleBuffer.associateByTo(destination: M, keySelector: (Double) -> K, valueTransform: (Double) -> V): M {
    for (element in this) destination.put(keySelector(element), valueTransform(element))
    return destination
}

/**
 * Populates and returns the [destination] mutable map with key-value pairs,
 * where key is provided by the [keySelector] function and
 * and value is provided by the [valueTransform] function applied to elements of the given array.
 *
 * If any two elements would have the same key returned by [keySelector] the last one gets added to the map.
 *
 * @sample samples.collections.Arrays.Transformations.associateArrayOfPrimitivesByToWithValueTransform
 */
inline fun <K, V, M : MutableMap<in K, in V>> CharBuffer.associateByTo(destination: M, keySelector: (Char) -> K, valueTransform: (Char) -> V): M {
    for (element in this) destination.put(keySelector(element), valueTransform(element))
    return destination
}


/**
 * Populates and returns the [destination] mutable map with key-value pairs
 * provided by [transform] function applied to each element of the given array.
 *
 * If any of two pairs would have the same key the last one gets added to the map.
 *
 * @sample samples.collections.Arrays.Transformations.associateArrayOfPrimitivesTo
 */
inline fun <K, V, M : MutableMap<in K, in V>> ByteBuffer.associateTo(destination: M, transform: (Byte) -> Pair<K, V>): M {
    for (element in this) destination += transform(element)
    return destination
}

/**
 * Populates and returns the [destination] mutable map with key-value pairs
 * provided by [transform] function applied to each element of the given array.
 *
 * If any of two pairs would have the same key the last one gets added to the map.
 *
 * @sample samples.collections.Arrays.Transformations.associateArrayOfPrimitivesTo
 */
inline fun <K, V, M : MutableMap<in K, in V>> ShortBuffer.associateTo(destination: M, transform: (Short) -> Pair<K, V>): M {
    for (element in this) destination += transform(element)
    return destination
}

/**
 * Populates and returns the [destination] mutable map with key-value pairs
 * provided by [transform] function applied to each element of the given array.
 *
 * If any of two pairs would have the same key the last one gets added to the map.
 *
 * @sample samples.collections.Arrays.Transformations.associateArrayOfPrimitivesTo
 */
inline fun <K, V, M : MutableMap<in K, in V>> IntBuffer.associateTo(destination: M, transform: (Int) -> Pair<K, V>): M {
    for (element in this) destination += transform(element)
    return destination
}

/**
 * Populates and returns the [destination] mutable map with key-value pairs
 * provided by [transform] function applied to each element of the given array.
 *
 * If any of two pairs would have the same key the last one gets added to the map.
 *
 * @sample samples.collections.Arrays.Transformations.associateArrayOfPrimitivesTo
 */
inline fun <K, V, M : MutableMap<in K, in V>> LongBuffer.associateTo(destination: M, transform: (Long) -> Pair<K, V>): M {
    for (element in this) destination += transform(element)
    return destination
}

/**
 * Populates and returns the [destination] mutable map with key-value pairs
 * provided by [transform] function applied to each element of the given array.
 *
 * If any of two pairs would have the same key the last one gets added to the map.
 *
 * @sample samples.collections.Arrays.Transformations.associateArrayOfPrimitivesTo
 */
inline fun <K, V, M : MutableMap<in K, in V>> FloatBuffer.associateTo(destination: M, transform: (Float) -> Pair<K, V>): M {
    for (element in this) destination += transform(element)
    return destination
}

/**
 * Populates and returns the [destination] mutable map with key-value pairs
 * provided by [transform] function applied to each element of the given array.
 *
 * If any of two pairs would have the same key the last one gets added to the map.
 *
 * @sample samples.collections.Arrays.Transformations.associateArrayOfPrimitivesTo
 */
inline fun <K, V, M : MutableMap<in K, in V>> DoubleBuffer.associateTo(destination: M, transform: (Double) -> Pair<K, V>): M {
    for (element in this) destination += transform(element)
    return destination
}

/**
 * Populates and returns the [destination] mutable map with key-value pairs
 * provided by [transform] function applied to each element of the given array.
 *
 * If any of two pairs would have the same key the last one gets added to the map.
 *
 * @sample samples.collections.Arrays.Transformations.associateArrayOfPrimitivesTo
 */
inline fun <K, V, M : MutableMap<in K, in V>> CharBuffer.associateTo(destination: M, transform: (Char) -> Pair<K, V>): M {
    for (element in this) destination += transform(element)
    return destination
}