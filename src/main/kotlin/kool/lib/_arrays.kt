package kool.lib

import kool.*
import org.lwjgl.system.MemoryUtil.*
import java.nio.*
import kotlin.random.Random


//
///**
// * Returns a [Map] containing key-value pairs provided by [transform] function
// * applied to elements of the given buffer.
// *
// * If any of two pairs would have the same key the last one gets added to the map.
// *
// * The returned map preserves the entry iteration order of the original buffer.
// */
//inline fun <T, K, V> Array<out T>.associate(transform: (T) -> Pair<K, V>): Map<K, V> {
//    val capacity = mapCapacity(size).coerceAtLeast(16)
//    return associateTo(LinkedHashMap<K, V>(capacity), transform)
//}
//
///**
// * Returns a [Map] containing key-value pairs provided by [transform] function
// * applied to elements of the given buffer.
// *
// * If any of two pairs would have the same key the last one gets added to the map.
// *
// * The returned map preserves the entry iteration order of the original buffer.
// */
//inline fun <K, V> ByteBuffer.associate(transform: (Byte) -> Pair<K, V>): Map<K, V> {
//    val capacity = mapCapacity(size).coerceAtLeast(16)
//    return associateTo(LinkedHashMap<K, V>(capacity), transform)
//}
//
///**
// * Returns a [Map] containing key-value pairs provided by [transform] function
// * applied to elements of the given buffer.
// *
// * If any of two pairs would have the same key the last one gets added to the map.
// *
// * The returned map preserves the entry iteration order of the original buffer.
// */
//inline fun <K, V> ShortBuffer.associate(transform: (Short) -> Pair<K, V>): Map<K, V> {
//    val capacity = mapCapacity(size).coerceAtLeast(16)
//    return associateTo(LinkedHashMap<K, V>(capacity), transform)
//}
//
///**
// * Returns a [Map] containing key-value pairs provided by [transform] function
// * applied to elements of the given buffer.
// *
// * If any of two pairs would have the same key the last one gets added to the map.
// *
// * The returned map preserves the entry iteration order of the original buffer.
// */
//inline fun <K, V> IntBuffer.associate(transform: (Int) -> Pair<K, V>): Map<K, V> {
//    val capacity = mapCapacity(size).coerceAtLeast(16)
//    return associateTo(LinkedHashMap<K, V>(capacity), transform)
//}
//
///**
// * Returns a [Map] containing key-value pairs provided by [transform] function
// * applied to elements of the given buffer.
// *
// * If any of two pairs would have the same key the last one gets added to the map.
// *
// * The returned map preserves the entry iteration order of the original buffer.
// */
//inline fun <K, V> LongBuffer.associate(transform: (Long) -> Pair<K, V>): Map<K, V> {
//    val capacity = mapCapacity(size).coerceAtLeast(16)
//    return associateTo(LinkedHashMap<K, V>(capacity), transform)
//}
//
///**
// * Returns a [Map] containing key-value pairs provided by [transform] function
// * applied to elements of the given buffer.
// *
// * If any of two pairs would have the same key the last one gets added to the map.
// *
// * The returned map preserves the entry iteration order of the original buffer.
// */
//inline fun <K, V> FloatBuffer.associate(transform: (Float) -> Pair<K, V>): Map<K, V> {
//    val capacity = mapCapacity(size).coerceAtLeast(16)
//    return associateTo(LinkedHashMap<K, V>(capacity), transform)
//}
//
///**
// * Returns a [Map] containing key-value pairs provided by [transform] function
// * applied to elements of the given buffer.
// *
// * If any of two pairs would have the same key the last one gets added to the map.
// *
// * The returned map preserves the entry iteration order of the original buffer.
// */
//inline fun <K, V> DoubleBuffer.associate(transform: (Double) -> Pair<K, V>): Map<K, V> {
//    val capacity = mapCapacity(size).coerceAtLeast(16)
//    return associateTo(LinkedHashMap<K, V>(capacity), transform)
//}
//
///**
// * Returns a [Map] containing key-value pairs provided by [transform] function
// * applied to elements of the given buffer.
// *
// * If any of two pairs would have the same key the last one gets added to the map.
// *
// * The returned map preserves the entry iteration order of the original buffer.
// */
//inline fun <K, V> DELETE.associate(transform: (Boolean) -> Pair<K, V>): Map<K, V> {
//    val capacity = mapCapacity(size).coerceAtLeast(16)
//    return associateTo(LinkedHashMap<K, V>(capacity), transform)
//}
//
///**
// * Returns a [Map] containing key-value pairs provided by [transform] function
// * applied to elements of the given buffer.
// *
// * If any of two pairs would have the same key the last one gets added to the map.
// *
// * The returned map preserves the entry iteration order of the original buffer.
// */
//inline fun <K, V> CharBuffer.associate(transform: (Char) -> Pair<K, V>): Map<K, V> {
//    val capacity = mapCapacity(size).coerceAtLeast(16)
//    return associateTo(LinkedHashMap<K, V>(capacity), transform)
//}
//
///**
// * Returns a [Map] containing the elements from the given buffer indexed by the key
// * returned from [keySelector] function applied to each element.
// *
// * If any two elements would have the same key returned by [keySelector] the last one gets added to the map.
// *
// * The returned map preserves the entry iteration order of the original buffer.
// */
//inline fun <T, K> Array<out T>.associateBy(keySelector: (T) -> K): Map<K, T> {
//    val capacity = mapCapacity(size).coerceAtLeast(16)
//    return associateByTo(LinkedHashMap<K, T>(capacity), keySelector)
//}
//
///**
// * Returns a [Map] containing the elements from the given buffer indexed by the key
// * returned from [keySelector] function applied to each element.
// *
// * If any two elements would have the same key returned by [keySelector] the last one gets added to the map.
// *
// * The returned map preserves the entry iteration order of the original buffer.
// */
//inline fun <K> ByteBuffer.associateBy(keySelector: (Byte) -> K): Map<K, Byte> {
//    val capacity = mapCapacity(size).coerceAtLeast(16)
//    return associateByTo(LinkedHashMap<K, Byte>(capacity), keySelector)
//}
//
///**
// * Returns a [Map] containing the elements from the given buffer indexed by the key
// * returned from [keySelector] function applied to each element.
// *
// * If any two elements would have the same key returned by [keySelector] the last one gets added to the map.
// *
// * The returned map preserves the entry iteration order of the original buffer.
// */
//inline fun <K> ShortBuffer.associateBy(keySelector: (Short) -> K): Map<K, Short> {
//    val capacity = mapCapacity(size).coerceAtLeast(16)
//    return associateByTo(LinkedHashMap<K, Short>(capacity), keySelector)
//}
//
///**
// * Returns a [Map] containing the elements from the given buffer indexed by the key
// * returned from [keySelector] function applied to each element.
// *
// * If any two elements would have the same key returned by [keySelector] the last one gets added to the map.
// *
// * The returned map preserves the entry iteration order of the original buffer.
// */
//inline fun <K> IntBuffer.associateBy(keySelector: (Int) -> K): Map<K, Int> {
//    val capacity = mapCapacity(size).coerceAtLeast(16)
//    return associateByTo(LinkedHashMap<K, Int>(capacity), keySelector)
//}
//
///**
// * Returns a [Map] containing the elements from the given buffer indexed by the key
// * returned from [keySelector] function applied to each element.
// *
// * If any two elements would have the same key returned by [keySelector] the last one gets added to the map.
// *
// * The returned map preserves the entry iteration order of the original buffer.
// */
//inline fun <K> LongBuffer.associateBy(keySelector: (Long) -> K): Map<K, Long> {
//    val capacity = mapCapacity(size).coerceAtLeast(16)
//    return associateByTo(LinkedHashMap<K, Long>(capacity), keySelector)
//}
//
///**
// * Returns a [Map] containing the elements from the given buffer indexed by the key
// * returned from [keySelector] function applied to each element.
// *
// * If any two elements would have the same key returned by [keySelector] the last one gets added to the map.
// *
// * The returned map preserves the entry iteration order of the original buffer.
// */
//inline fun <K> FloatBuffer.associateBy(keySelector: (Float) -> K): Map<K, Float> {
//    val capacity = mapCapacity(size).coerceAtLeast(16)
//    return associateByTo(LinkedHashMap<K, Float>(capacity), keySelector)
//}
//
///**
// * Returns a [Map] containing the elements from the given buffer indexed by the key
// * returned from [keySelector] function applied to each element.
// *
// * If any two elements would have the same key returned by [keySelector] the last one gets added to the map.
// *
// * The returned map preserves the entry iteration order of the original buffer.
// */
//inline fun <K> DoubleBuffer.associateBy(keySelector: (Double) -> K): Map<K, Double> {
//    val capacity = mapCapacity(size).coerceAtLeast(16)
//    return associateByTo(LinkedHashMap<K, Double>(capacity), keySelector)
//}
//
///**
// * Returns a [Map] containing the elements from the given buffer indexed by the key
// * returned from [keySelector] function applied to each element.
// *
// * If any two elements would have the same key returned by [keySelector] the last one gets added to the map.
// *
// * The returned map preserves the entry iteration order of the original buffer.
// */
//inline fun <K> DELETE.associateBy(keySelector: (Boolean) -> K): Map<K, Boolean> {
//    val capacity = mapCapacity(size).coerceAtLeast(16)
//    return associateByTo(LinkedHashMap<K, Boolean>(capacity), keySelector)
//}
//
///**
// * Returns a [Map] containing the elements from the given buffer indexed by the key
// * returned from [keySelector] function applied to each element.
// *
// * If any two elements would have the same key returned by [keySelector] the last one gets added to the map.
// *
// * The returned map preserves the entry iteration order of the original buffer.
// */
//inline fun <K> CharBuffer.associateBy(keySelector: (Char) -> K): Map<K, Char> {
//    val capacity = mapCapacity(size).coerceAtLeast(16)
//    return associateByTo(LinkedHashMap<K, Char>(capacity), keySelector)
//}
//
///**
// * Returns a [Map] containing the values provided by [valueTransform] and indexed by [keySelector] functions applied to elements of the given buffer.
// *
// * If any two elements would have the same key returned by [keySelector] the last one gets added to the map.
// *
// * The returned map preserves the entry iteration order of the original buffer.
// */
//inline fun <T, K, V> Array<out T>.associateBy(keySelector: (T) -> K, valueTransform: (T) -> V): Map<K, V> {
//    val capacity = mapCapacity(size).coerceAtLeast(16)
//    return associateByTo(LinkedHashMap<K, V>(capacity), keySelector, valueTransform)
//}
//
///**
// * Returns a [Map] containing the values provided by [valueTransform] and indexed by [keySelector] functions applied to elements of the given buffer.
// *
// * If any two elements would have the same key returned by [keySelector] the last one gets added to the map.
// *
// * The returned map preserves the entry iteration order of the original buffer.
// */
//inline fun <K, V> ByteBuffer.associateBy(keySelector: (Byte) -> K, valueTransform: (Byte) -> V): Map<K, V> {
//    val capacity = mapCapacity(size).coerceAtLeast(16)
//    return associateByTo(LinkedHashMap<K, V>(capacity), keySelector, valueTransform)
//}
//
///**
// * Returns a [Map] containing the values provided by [valueTransform] and indexed by [keySelector] functions applied to elements of the given buffer.
// *
// * If any two elements would have the same key returned by [keySelector] the last one gets added to the map.
// *
// * The returned map preserves the entry iteration order of the original buffer.
// */
//inline fun <K, V> ShortBuffer.associateBy(keySelector: (Short) -> K, valueTransform: (Short) -> V): Map<K, V> {
//    val capacity = mapCapacity(size).coerceAtLeast(16)
//    return associateByTo(LinkedHashMap<K, V>(capacity), keySelector, valueTransform)
//}
//
///**
// * Returns a [Map] containing the values provided by [valueTransform] and indexed by [keySelector] functions applied to elements of the given buffer.
// *
// * If any two elements would have the same key returned by [keySelector] the last one gets added to the map.
// *
// * The returned map preserves the entry iteration order of the original buffer.
// */
//inline fun <K, V> IntBuffer.associateBy(keySelector: (Int) -> K, valueTransform: (Int) -> V): Map<K, V> {
//    val capacity = mapCapacity(size).coerceAtLeast(16)
//    return associateByTo(LinkedHashMap<K, V>(capacity), keySelector, valueTransform)
//}
//
///**
// * Returns a [Map] containing the values provided by [valueTransform] and indexed by [keySelector] functions applied to elements of the given buffer.
// *
// * If any two elements would have the same key returned by [keySelector] the last one gets added to the map.
// *
// * The returned map preserves the entry iteration order of the original buffer.
// */
//inline fun <K, V> LongBuffer.associateBy(keySelector: (Long) -> K, valueTransform: (Long) -> V): Map<K, V> {
//    val capacity = mapCapacity(size).coerceAtLeast(16)
//    return associateByTo(LinkedHashMap<K, V>(capacity), keySelector, valueTransform)
//}
//
///**
// * Returns a [Map] containing the values provided by [valueTransform] and indexed by [keySelector] functions applied to elements of the given buffer.
// *
// * If any two elements would have the same key returned by [keySelector] the last one gets added to the map.
// *
// * The returned map preserves the entry iteration order of the original buffer.
// */
//inline fun <K, V> FloatBuffer.associateBy(keySelector: (Float) -> K, valueTransform: (Float) -> V): Map<K, V> {
//    val capacity = mapCapacity(size).coerceAtLeast(16)
//    return associateByTo(LinkedHashMap<K, V>(capacity), keySelector, valueTransform)
//}
//
///**
// * Returns a [Map] containing the values provided by [valueTransform] and indexed by [keySelector] functions applied to elements of the given buffer.
// *
// * If any two elements would have the same key returned by [keySelector] the last one gets added to the map.
// *
// * The returned map preserves the entry iteration order of the original buffer.
// */
//inline fun <K, V> DoubleBuffer.associateBy(keySelector: (Double) -> K, valueTransform: (Double) -> V): Map<K, V> {
//    val capacity = mapCapacity(size).coerceAtLeast(16)
//    return associateByTo(LinkedHashMap<K, V>(capacity), keySelector, valueTransform)
//}
//
///**
// * Returns a [Map] containing the values provided by [valueTransform] and indexed by [keySelector] functions applied to elements of the given buffer.
// *
// * If any two elements would have the same key returned by [keySelector] the last one gets added to the map.
// *
// * The returned map preserves the entry iteration order of the original buffer.
// */
//inline fun <K, V> DELETE.associateBy(keySelector: (Boolean) -> K, valueTransform: (Boolean) -> V): Map<K, V> {
//    val capacity = mapCapacity(size).coerceAtLeast(16)
//    return associateByTo(LinkedHashMap<K, V>(capacity), keySelector, valueTransform)
//}
//
///**
// * Returns a [Map] containing the values provided by [valueTransform] and indexed by [keySelector] functions applied to elements of the given buffer.
// *
// * If any two elements would have the same key returned by [keySelector] the last one gets added to the map.
// *
// * The returned map preserves the entry iteration order of the original buffer.
// */
//inline fun <K, V> CharBuffer.associateBy(keySelector: (Char) -> K, valueTransform: (Char) -> V): Map<K, V> {
//    val capacity = mapCapacity(size).coerceAtLeast(16)
//    return associateByTo(LinkedHashMap<K, V>(capacity), keySelector, valueTransform)
//}
//
///**
// * Populates and returns the [destination] mutable map with key-value pairs,
// * where key is provided by the [keySelector] function applied to each element of the given buffer
// * and value is the element itself.
// *
// * If any two elements would have the same key returned by [keySelector] the last one gets added to the map.
// */
//inline fun <T, K, M : MutableMap<in K, in T>> Array<out T>.associateByTo(destination: M, keySelector: (T) -> K): M {
//    for (element in this) {
//        destination.put(keySelector(element), element)
//    }
//    return destination
//}
//
///**
// * Populates and returns the [destination] mutable map with key-value pairs,
// * where key is provided by the [keySelector] function applied to each element of the given buffer
// * and value is the element itself.
// *
// * If any two elements would have the same key returned by [keySelector] the last one gets added to the map.
// */
//inline fun <K, M : MutableMap<in K, in Byte>> ByteBuffer.associateByTo(destination: M, keySelector: (Byte) -> K): M {
//    for (element in this) {
//        destination.put(keySelector(element), element)
//    }
//    return destination
//}
//
///**
// * Populates and returns the [destination] mutable map with key-value pairs,
// * where key is provided by the [keySelector] function applied to each element of the given buffer
// * and value is the element itself.
// *
// * If any two elements would have the same key returned by [keySelector] the last one gets added to the map.
// */
//inline fun <K, M : MutableMap<in K, in Short>> ShortBuffer.associateByTo(destination: M, keySelector: (Short) -> K): M {
//    for (element in this) {
//        destination.put(keySelector(element), element)
//    }
//    return destination
//}
//
///**
// * Populates and returns the [destination] mutable map with key-value pairs,
// * where key is provided by the [keySelector] function applied to each element of the given buffer
// * and value is the element itself.
// *
// * If any two elements would have the same key returned by [keySelector] the last one gets added to the map.
// */
//inline fun <K, M : MutableMap<in K, in Int>> IntBuffer.associateByTo(destination: M, keySelector: (Int) -> K): M {
//    for (element in this) {
//        destination.put(keySelector(element), element)
//    }
//    return destination
//}
//
///**
// * Populates and returns the [destination] mutable map with key-value pairs,
// * where key is provided by the [keySelector] function applied to each element of the given buffer
// * and value is the element itself.
// *
// * If any two elements would have the same key returned by [keySelector] the last one gets added to the map.
// */
//inline fun <K, M : MutableMap<in K, in Long>> LongBuffer.associateByTo(destination: M, keySelector: (Long) -> K): M {
//    for (element in this) {
//        destination.put(keySelector(element), element)
//    }
//    return destination
//}
//
///**
// * Populates and returns the [destination] mutable map with key-value pairs,
// * where key is provided by the [keySelector] function applied to each element of the given buffer
// * and value is the element itself.
// *
// * If any two elements would have the same key returned by [keySelector] the last one gets added to the map.
// */
//inline fun <K, M : MutableMap<in K, in Float>> FloatBuffer.associateByTo(destination: M, keySelector: (Float) -> K): M {
//    for (element in this) {
//        destination.put(keySelector(element), element)
//    }
//    return destination
//}
//
///**
// * Populates and returns the [destination] mutable map with key-value pairs,
// * where key is provided by the [keySelector] function applied to each element of the given buffer
// * and value is the element itself.
// *
// * If any two elements would have the same key returned by [keySelector] the last one gets added to the map.
// */
//inline fun <K, M : MutableMap<in K, in Double>> DoubleBuffer.associateByTo(destination: M, keySelector: (Double) -> K): M {
//    for (element in this) {
//        destination.put(keySelector(element), element)
//    }
//    return destination
//}
//
///**
// * Populates and returns the [destination] mutable map with key-value pairs,
// * where key is provided by the [keySelector] function applied to each element of the given buffer
// * and value is the element itself.
// *
// * If any two elements would have the same key returned by [keySelector] the last one gets added to the map.
// */
//inline fun <K, M : MutableMap<in K, in Boolean>> DELETE.associateByTo(destination: M, keySelector: (Boolean) -> K): M {
//    for (element in this) {
//        destination.put(keySelector(element), element)
//    }
//    return destination
//}
//
///**
// * Populates and returns the [destination] mutable map with key-value pairs,
// * where key is provided by the [keySelector] function applied to each element of the given buffer
// * and value is the element itself.
// *
// * If any two elements would have the same key returned by [keySelector] the last one gets added to the map.
// */
//inline fun <K, M : MutableMap<in K, in Char>> CharBuffer.associateByTo(destination: M, keySelector: (Char) -> K): M {
//    for (element in this) {
//        destination.put(keySelector(element), element)
//    }
//    return destination
//}
//
///**
// * Populates and returns the [destination] mutable map with key-value pairs,
// * where key is provided by the [keySelector] function and
// * and value is provided by the [valueTransform] function applied to elements of the given buffer.
// *
// * If any two elements would have the same key returned by [keySelector] the last one gets added to the map.
// */
//inline fun <T, K, V, M : MutableMap<in K, in V>> Array<out T>.associateByTo(destination: M, keySelector: (T) -> K, valueTransform: (T) -> V): M {
//    for (element in this) {
//        destination.put(keySelector(element), valueTransform(element))
//    }
//    return destination
//}
//
///**
// * Populates and returns the [destination] mutable map with key-value pairs,
// * where key is provided by the [keySelector] function and
// * and value is provided by the [valueTransform] function applied to elements of the given buffer.
// *
// * If any two elements would have the same key returned by [keySelector] the last one gets added to the map.
// */
//inline fun <K, V, M : MutableMap<in K, in V>> ByteBuffer.associateByTo(destination: M, keySelector: (Byte) -> K, valueTransform: (Byte) -> V): M {
//    for (element in this) {
//        destination.put(keySelector(element), valueTransform(element))
//    }
//    return destination
//}
//
///**
// * Populates and returns the [destination] mutable map with key-value pairs,
// * where key is provided by the [keySelector] function and
// * and value is provided by the [valueTransform] function applied to elements of the given buffer.
// *
// * If any two elements would have the same key returned by [keySelector] the last one gets added to the map.
// */
//inline fun <K, V, M : MutableMap<in K, in V>> ShortBuffer.associateByTo(destination: M, keySelector: (Short) -> K, valueTransform: (Short) -> V): M {
//    for (element in this) {
//        destination.put(keySelector(element), valueTransform(element))
//    }
//    return destination
//}
//
///**
// * Populates and returns the [destination] mutable map with key-value pairs,
// * where key is provided by the [keySelector] function and
// * and value is provided by the [valueTransform] function applied to elements of the given buffer.
// *
// * If any two elements would have the same key returned by [keySelector] the last one gets added to the map.
// */
//inline fun <K, V, M : MutableMap<in K, in V>> IntBuffer.associateByTo(destination: M, keySelector: (Int) -> K, valueTransform: (Int) -> V): M {
//    for (element in this) {
//        destination.put(keySelector(element), valueTransform(element))
//    }
//    return destination
//}
//
///**
// * Populates and returns the [destination] mutable map with key-value pairs,
// * where key is provided by the [keySelector] function and
// * and value is provided by the [valueTransform] function applied to elements of the given buffer.
// *
// * If any two elements would have the same key returned by [keySelector] the last one gets added to the map.
// */
//inline fun <K, V, M : MutableMap<in K, in V>> LongBuffer.associateByTo(destination: M, keySelector: (Long) -> K, valueTransform: (Long) -> V): M {
//    for (element in this) {
//        destination.put(keySelector(element), valueTransform(element))
//    }
//    return destination
//}
//
///**
// * Populates and returns the [destination] mutable map with key-value pairs,
// * where key is provided by the [keySelector] function and
// * and value is provided by the [valueTransform] function applied to elements of the given buffer.
// *
// * If any two elements would have the same key returned by [keySelector] the last one gets added to the map.
// */
//inline fun <K, V, M : MutableMap<in K, in V>> FloatBuffer.associateByTo(destination: M, keySelector: (Float) -> K, valueTransform: (Float) -> V): M {
//    for (element in this) {
//        destination.put(keySelector(element), valueTransform(element))
//    }
//    return destination
//}
//
///**
// * Populates and returns the [destination] mutable map with key-value pairs,
// * where key is provided by the [keySelector] function and
// * and value is provided by the [valueTransform] function applied to elements of the given buffer.
// *
// * If any two elements would have the same key returned by [keySelector] the last one gets added to the map.
// */
//inline fun <K, V, M : MutableMap<in K, in V>> DoubleBuffer.associateByTo(destination: M, keySelector: (Double) -> K, valueTransform: (Double) -> V): M {
//    for (element in this) {
//        destination.put(keySelector(element), valueTransform(element))
//    }
//    return destination
//}
//
///**
// * Populates and returns the [destination] mutable map with key-value pairs,
// * where key is provided by the [keySelector] function and
// * and value is provided by the [valueTransform] function applied to elements of the given buffer.
// *
// * If any two elements would have the same key returned by [keySelector] the last one gets added to the map.
// */
//inline fun <K, V, M : MutableMap<in K, in V>> DELETE.associateByTo(destination: M, keySelector: (Boolean) -> K, valueTransform: (Boolean) -> V): M {
//    for (element in this) {
//        destination.put(keySelector(element), valueTransform(element))
//    }
//    return destination
//}
//
///**
// * Populates and returns the [destination] mutable map with key-value pairs,
// * where key is provided by the [keySelector] function and
// * and value is provided by the [valueTransform] function applied to elements of the given buffer.
// *
// * If any two elements would have the same key returned by [keySelector] the last one gets added to the map.
// */
//inline fun <K, V, M : MutableMap<in K, in V>> CharBuffer.associateByTo(destination: M, keySelector: (Char) -> K, valueTransform: (Char) -> V): M {
//    for (element in this) {
//        destination.put(keySelector(element), valueTransform(element))
//    }
//    return destination
//}
//
///**
// * Populates and returns the [destination] mutable map with key-value pairs
// * provided by [transform] function applied to each element of the given buffer.
// *
// * If any of two pairs would have the same key the last one gets added to the map.
// */
//inline fun <T, K, V, M : MutableMap<in K, in V>> Array<out T>.associateTo(destination: M, transform: (T) -> Pair<K, V>): M {
//    for (element in this) {
//        destination += transform(element)
//    }
//    return destination
//}
//
///**
// * Populates and returns the [destination] mutable map with key-value pairs
// * provided by [transform] function applied to each element of the given buffer.
// *
// * If any of two pairs would have the same key the last one gets added to the map.
// */
//inline fun <K, V, M : MutableMap<in K, in V>> ByteBuffer.associateTo(destination: M, transform: (Byte) -> Pair<K, V>): M {
//    for (element in this) {
//        destination += transform(element)
//    }
//    return destination
//}
//
///**
// * Populates and returns the [destination] mutable map with key-value pairs
// * provided by [transform] function applied to each element of the given buffer.
// *
// * If any of two pairs would have the same key the last one gets added to the map.
// */
//inline fun <K, V, M : MutableMap<in K, in V>> ShortBuffer.associateTo(destination: M, transform: (Short) -> Pair<K, V>): M {
//    for (element in this) {
//        destination += transform(element)
//    }
//    return destination
//}
//
///**
// * Populates and returns the [destination] mutable map with key-value pairs
// * provided by [transform] function applied to each element of the given buffer.
// *
// * If any of two pairs would have the same key the last one gets added to the map.
// */
//inline fun <K, V, M : MutableMap<in K, in V>> IntBuffer.associateTo(destination: M, transform: (Int) -> Pair<K, V>): M {
//    for (element in this) {
//        destination += transform(element)
//    }
//    return destination
//}
//
///**
// * Populates and returns the [destination] mutable map with key-value pairs
// * provided by [transform] function applied to each element of the given buffer.
// *
// * If any of two pairs would have the same key the last one gets added to the map.
// */
//inline fun <K, V, M : MutableMap<in K, in V>> LongBuffer.associateTo(destination: M, transform: (Long) -> Pair<K, V>): M {
//    for (element in this) {
//        destination += transform(element)
//    }
//    return destination
//}
//
///**
// * Populates and returns the [destination] mutable map with key-value pairs
// * provided by [transform] function applied to each element of the given buffer.
// *
// * If any of two pairs would have the same key the last one gets added to the map.
// */
//inline fun <K, V, M : MutableMap<in K, in V>> FloatBuffer.associateTo(destination: M, transform: (Float) -> Pair<K, V>): M {
//    for (element in this) {
//        destination += transform(element)
//    }
//    return destination
//}
//
///**
// * Populates and returns the [destination] mutable map with key-value pairs
// * provided by [transform] function applied to each element of the given buffer.
// *
// * If any of two pairs would have the same key the last one gets added to the map.
// */
//inline fun <K, V, M : MutableMap<in K, in V>> DoubleBuffer.associateTo(destination: M, transform: (Double) -> Pair<K, V>): M {
//    for (element in this) {
//        destination += transform(element)
//    }
//    return destination
//}
//
///**
// * Populates and returns the [destination] mutable map with key-value pairs
// * provided by [transform] function applied to each element of the given buffer.
// *
// * If any of two pairs would have the same key the last one gets added to the map.
// */
//inline fun <K, V, M : MutableMap<in K, in V>> DELETE.associateTo(destination: M, transform: (Boolean) -> Pair<K, V>): M {
//    for (element in this) {
//        destination += transform(element)
//    }
//    return destination
//}
//
///**
// * Populates and returns the [destination] mutable map with key-value pairs
// * provided by [transform] function applied to each element of the given buffer.
// *
// * If any of two pairs would have the same key the last one gets added to the map.
// */
//inline fun <K, V, M : MutableMap<in K, in V>> CharBuffer.associateTo(destination: M, transform: (Char) -> Pair<K, V>): M {
//    for (element in this) {
//        destination += transform(element)
//    }
//    return destination
//}


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
fun <T> Array<out T>.toHashSet() = toCollection(HashSet(maps.mapCapacity(size)))

/** Returns a [HashSet] of all elements. */
fun ByteBuffer.toHashSet() = toCollection(HashSet(maps.mapCapacity(lim)))

/** Returns a [HashSet] of all elements. */
fun ShortBuffer.toHashSet() = toCollection(HashSet(maps.mapCapacity(lim)))

/** Returns a [HashSet] of all elements. */
fun IntBuffer.toHashSet() = toCollection(HashSet(maps.mapCapacity(lim)))

/** Returns a [HashSet] of all elements. */
fun LongBuffer.toHashSet() = toCollection(HashSet(maps.mapCapacity(lim)))

/** Returns a [HashSet] of all elements. */
fun FloatBuffer.toHashSet() = toCollection(HashSet(maps.mapCapacity(lim)))

/** Returns a [HashSet] of all elements. */
fun DoubleBuffer.toHashSet() = toCollection(HashSet(maps.mapCapacity(lim)))

/** Returns a [HashSet] of all elements. */
fun CharBuffer.toHashSet() = toCollection(HashSet(maps.mapCapacity(lim)))


/** Returns a [List] containing all elements. */
fun ByteBuffer.toList(): List<Byte> {
    return when (lim) {
        0 -> emptyList()
        1 -> listOf(this[0])
        else -> toMutableList()
    }
}

/** Returns a [List] containing all elements. */
fun ShortBuffer.toList(): List<Short> {
    return when (lim) {
        0 -> emptyList()
        1 -> listOf(this[0])
        else -> toMutableList()
    }
}

/** Returns a [List] containing all elements. */
fun IntBuffer.toList(): List<Int> {
    return when (lim) {
        0 -> emptyList()
        1 -> listOf(this[0])
        else -> toMutableList()
    }
}

/** Returns a [List] containing all elements. */
fun LongBuffer.toList(): List<Long> {
    return when (lim) {
        0 -> emptyList()
        1 -> listOf(this[0])
        else -> toMutableList()
    }
}

/** Returns a [List] containing all elements. */
fun FloatBuffer.toList(): List<Float> {
    return when (lim) {
        0 -> emptyList()
        1 -> listOf(this[0])
        else -> toMutableList()
    }
}

/** Returns a [List] containing all elements. */
fun DoubleBuffer.toList(): List<Double> {
    return when (lim) {
        0 -> emptyList()
        1 -> listOf(this[0])
        else -> toMutableList()
    }
}

/** Returns a [List] containing all elements. */
fun CharBuffer.toList(): List<Char> {
    return when (lim) {
        0 -> emptyList()
        1 -> listOf(this[0])
        else -> toMutableList()
    }
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
fun ByteBuffer.toSet(): Set<Byte> {
    return when (lim) {
        0 -> emptySet()
        1 -> setOf(this[0])
        else -> toCollection(LinkedHashSet(maps.mapCapacity(lim)))
    }
}

/** Returns a [Set] of all elements.
 *  The returned set preserves the element iteration order of the original buffer. */
fun ShortBuffer.toSet(): Set<Short> {
    return when (lim) {
        0 -> emptySet()
        1 -> setOf(this[0])
        else -> toCollection(LinkedHashSet(maps.mapCapacity(lim)))
    }
}

/** Returns a [Set] of all elements.
 *  The returned set preserves the element iteration order of the original buffer. */
fun IntBuffer.toSet(): Set<Int> {
    return when (lim) {
        0 -> emptySet()
        1 -> setOf(this[0])
        else -> toCollection(LinkedHashSet(maps.mapCapacity(lim)))
    }
}

/** Returns a [Set] of all elements.
 *  The returned set preserves the element iteration order of the original buffer. */
fun LongBuffer.toSet(): Set<Long> {
    return when (lim) {
        0 -> emptySet()
        1 -> setOf(this[0])
        else -> toCollection(LinkedHashSet(maps.mapCapacity(lim)))
    }
}

/** Returns a [Set] of all elements.
 *  The returned set preserves the element iteration order of the original buffer. */
fun FloatBuffer.toSet(): Set<Float> {
    return when (lim) {
        0 -> emptySet()
        1 -> setOf(this[0])
        else -> toCollection(LinkedHashSet(maps.mapCapacity(lim)))
    }
}

/** Returns a [Set] of all elements.
 *  The returned set preserves the element iteration order of the original buffer. */
fun DoubleBuffer.toSet(): Set<Double> {
    return when (lim) {
        0 -> emptySet()
        1 -> setOf(this[0])
        else -> toCollection(LinkedHashSet(maps.mapCapacity(lim)))
    }
}

/** Returns a [Set] of all elements.
 *  The returned set preserves the element iteration order of the original buffer. */
fun CharBuffer.toSet(): Set<Char> {
    return when (lim) {
        0 -> emptySet()
        1 -> setOf(this[0])
        else -> toCollection(LinkedHashSet(maps.mapCapacity(lim)))
    }
}


/** Returns a [SortedSet] of all elements. */
fun ByteBuffer.toSortedSet(): java.util.SortedSet<Byte> = toCollection(sortedSetOf())

/** Returns a [SortedSet] of all elements. */
fun ShortBuffer.toSortedSet(): java.util.SortedSet<Short> = toCollection(sortedSetOf())

/** Returns a [SortedSet] of all elements. */
fun IntBuffer.toSortedSet(): java.util.SortedSet<Int> = toCollection(sortedSetOf())

/** Returns a [SortedSet] of all elements. */
fun LongBuffer.toSortedSet(): java.util.SortedSet<Long> = toCollection(sortedSetOf())

/** Returns a [SortedSet] of all elements. */
fun FloatBuffer.toSortedSet(): java.util.SortedSet<Float> = toCollection(sortedSetOf())

/** Returns a [SortedSet] of all elements. */
fun DoubleBuffer.toSortedSet(): java.util.SortedSet<Double> = toCollection(sortedSetOf())

/** Returns a [SortedSet] of all elements. */
fun CharBuffer.toSortedSet(): java.util.SortedSet<Char> = toCollection(sortedSetOf())


//
///**
// * Returns a single list of all elements yielded from results of [transform] function being invoked on each element of original buffer.
// */
//inline fun <T, R> Array<out T>.flatMap(transform: (T) -> Iterable<R>): List<R> {
//    return flatMapTo(ArrayList<R>(), transform)
//}
//
///**
// * Returns a single list of all elements yielded from results of [transform] function being invoked on each element of original buffer.
// */
//inline fun <R> ByteBuffer.flatMap(transform: (Byte) -> Iterable<R>): List<R> {
//    return flatMapTo(ArrayList<R>(), transform)
//}
//
///**
// * Returns a single list of all elements yielded from results of [transform] function being invoked on each element of original buffer.
// */
//inline fun <R> ShortBuffer.flatMap(transform: (Short) -> Iterable<R>): List<R> {
//    return flatMapTo(ArrayList<R>(), transform)
//}
//
///**
// * Returns a single list of all elements yielded from results of [transform] function being invoked on each element of original buffer.
// */
//inline fun <R> IntBuffer.flatMap(transform: (Int) -> Iterable<R>): List<R> {
//    return flatMapTo(ArrayList<R>(), transform)
//}
//
///**
// * Returns a single list of all elements yielded from results of [transform] function being invoked on each element of original buffer.
// */
//inline fun <R> LongBuffer.flatMap(transform: (Long) -> Iterable<R>): List<R> {
//    return flatMapTo(ArrayList<R>(), transform)
//}
//
///**
// * Returns a single list of all elements yielded from results of [transform] function being invoked on each element of original buffer.
// */
//inline fun <R> FloatBuffer.flatMap(transform: (Float) -> Iterable<R>): List<R> {
//    return flatMapTo(ArrayList<R>(), transform)
//}
//
///**
// * Returns a single list of all elements yielded from results of [transform] function being invoked on each element of original buffer.
// */
//inline fun <R> DoubleBuffer.flatMap(transform: (Double) -> Iterable<R>): List<R> {
//    return flatMapTo(ArrayList<R>(), transform)
//}
//
///**
// * Returns a single list of all elements yielded from results of [transform] function being invoked on each element of original buffer.
// */
//inline fun <R> DELETE.flatMap(transform: (Boolean) -> Iterable<R>): List<R> {
//    return flatMapTo(ArrayList<R>(), transform)
//}
//
///**
// * Returns a single list of all elements yielded from results of [transform] function being invoked on each element of original buffer.
// */
//inline fun <R> CharBuffer.flatMap(transform: (Char) -> Iterable<R>): List<R> {
//    return flatMapTo(ArrayList<R>(), transform)
//}
//
///**
// * Appends all elements yielded from results of [transform] function being invoked on each element of original buffer, to the given [destination].
// */
//inline fun <T, R, C : MutableCollection<in R>> Array<out T>.flatMapTo(destination: C, transform: (T) -> Iterable<R>): C {
//    for (element in this) {
//        val list = transform(element)
//        destination.addAll(list)
//    }
//    return destination
//}
//
///**
// * Appends all elements yielded from results of [transform] function being invoked on each element of original buffer, to the given [destination].
// */
//inline fun <R, C : MutableCollection<in R>> ByteBuffer.flatMapTo(destination: C, transform: (Byte) -> Iterable<R>): C {
//    for (element in this) {
//        val list = transform(element)
//        destination.addAll(list)
//    }
//    return destination
//}
//
///**
// * Appends all elements yielded from results of [transform] function being invoked on each element of original buffer, to the given [destination].
// */
//inline fun <R, C : MutableCollection<in R>> ShortBuffer.flatMapTo(destination: C, transform: (Short) -> Iterable<R>): C {
//    for (element in this) {
//        val list = transform(element)
//        destination.addAll(list)
//    }
//    return destination
//}
//
///**
// * Appends all elements yielded from results of [transform] function being invoked on each element of original buffer, to the given [destination].
// */
//inline fun <R, C : MutableCollection<in R>> IntBuffer.flatMapTo(destination: C, transform: (Int) -> Iterable<R>): C {
//    for (element in this) {
//        val list = transform(element)
//        destination.addAll(list)
//    }
//    return destination
//}
//
///**
// * Appends all elements yielded from results of [transform] function being invoked on each element of original buffer, to the given [destination].
// */
//inline fun <R, C : MutableCollection<in R>> LongBuffer.flatMapTo(destination: C, transform: (Long) -> Iterable<R>): C {
//    for (element in this) {
//        val list = transform(element)
//        destination.addAll(list)
//    }
//    return destination
//}
//
///**
// * Appends all elements yielded from results of [transform] function being invoked on each element of original buffer, to the given [destination].
// */
//inline fun <R, C : MutableCollection<in R>> FloatBuffer.flatMapTo(destination: C, transform: (Float) -> Iterable<R>): C {
//    for (element in this) {
//        val list = transform(element)
//        destination.addAll(list)
//    }
//    return destination
//}
//
///**
// * Appends all elements yielded from results of [transform] function being invoked on each element of original buffer, to the given [destination].
// */
//inline fun <R, C : MutableCollection<in R>> DoubleBuffer.flatMapTo(destination: C, transform: (Double) -> Iterable<R>): C {
//    for (element in this) {
//        val list = transform(element)
//        destination.addAll(list)
//    }
//    return destination
//}
//
///**
// * Appends all elements yielded from results of [transform] function being invoked on each element of original buffer, to the given [destination].
// */
//inline fun <R, C : MutableCollection<in R>> DELETE.flatMapTo(destination: C, transform: (Boolean) -> Iterable<R>): C {
//    for (element in this) {
//        val list = transform(element)
//        destination.addAll(list)
//    }
//    return destination
//}
//
///**
// * Appends all elements yielded from results of [transform] function being invoked on each element of original buffer, to the given [destination].
// */
//inline fun <R, C : MutableCollection<in R>> CharBuffer.flatMapTo(destination: C, transform: (Char) -> Iterable<R>): C {
//    for (element in this) {
//        val list = transform(element)
//        destination.addAll(list)
//    }
//    return destination
//}
//
///**
// * Groups elements of the original buffer by the key returned by the given [keySelector] function
// * applied to each element and returns a map where each group key is associated with a list of corresponding elements.
// *
// * The returned map preserves the entry iteration order of the keys produced from the original buffer.
// *
// * @sample samples.collections.Collections.Transformations.groupBy
// */
//inline fun <T, K> Array<out T>.groupBy(keySelector: (T) -> K): Map<K, List<T>> {
//    return groupByTo(LinkedHashMap<K, MutableList<T>>(), keySelector)
//}
//
///**
// * Groups elements of the original buffer by the key returned by the given [keySelector] function
// * applied to each element and returns a map where each group key is associated with a list of corresponding elements.
// *
// * The returned map preserves the entry iteration order of the keys produced from the original buffer.
// *
// * @sample samples.collections.Collections.Transformations.groupBy
// */
//inline fun <K> ByteBuffer.groupBy(keySelector: (Byte) -> K): Map<K, List<Byte>> {
//    return groupByTo(LinkedHashMap<K, MutableList<Byte>>(), keySelector)
//}
//
///**
// * Groups elements of the original buffer by the key returned by the given [keySelector] function
// * applied to each element and returns a map where each group key is associated with a list of corresponding elements.
// *
// * The returned map preserves the entry iteration order of the keys produced from the original buffer.
// *
// * @sample samples.collections.Collections.Transformations.groupBy
// */
//inline fun <K> ShortBuffer.groupBy(keySelector: (Short) -> K): Map<K, List<Short>> {
//    return groupByTo(LinkedHashMap<K, MutableList<Short>>(), keySelector)
//}
//
///**
// * Groups elements of the original buffer by the key returned by the given [keySelector] function
// * applied to each element and returns a map where each group key is associated with a list of corresponding elements.
// *
// * The returned map preserves the entry iteration order of the keys produced from the original buffer.
// *
// * @sample samples.collections.Collections.Transformations.groupBy
// */
//inline fun <K> IntBuffer.groupBy(keySelector: (Int) -> K): Map<K, List<Int>> {
//    return groupByTo(LinkedHashMap<K, MutableList<Int>>(), keySelector)
//}
//
///**
// * Groups elements of the original buffer by the key returned by the given [keySelector] function
// * applied to each element and returns a map where each group key is associated with a list of corresponding elements.
// *
// * The returned map preserves the entry iteration order of the keys produced from the original buffer.
// *
// * @sample samples.collections.Collections.Transformations.groupBy
// */
//inline fun <K> LongBuffer.groupBy(keySelector: (Long) -> K): Map<K, List<Long>> {
//    return groupByTo(LinkedHashMap<K, MutableList<Long>>(), keySelector)
//}
//
///**
// * Groups elements of the original buffer by the key returned by the given [keySelector] function
// * applied to each element and returns a map where each group key is associated with a list of corresponding elements.
// *
// * The returned map preserves the entry iteration order of the keys produced from the original buffer.
// *
// * @sample samples.collections.Collections.Transformations.groupBy
// */
//inline fun <K> FloatBuffer.groupBy(keySelector: (Float) -> K): Map<K, List<Float>> {
//    return groupByTo(LinkedHashMap<K, MutableList<Float>>(), keySelector)
//}
//
///**
// * Groups elements of the original buffer by the key returned by the given [keySelector] function
// * applied to each element and returns a map where each group key is associated with a list of corresponding elements.
// *
// * The returned map preserves the entry iteration order of the keys produced from the original buffer.
// *
// * @sample samples.collections.Collections.Transformations.groupBy
// */
//inline fun <K> DoubleBuffer.groupBy(keySelector: (Double) -> K): Map<K, List<Double>> {
//    return groupByTo(LinkedHashMap<K, MutableList<Double>>(), keySelector)
//}
//
///**
// * Groups elements of the original buffer by the key returned by the given [keySelector] function
// * applied to each element and returns a map where each group key is associated with a list of corresponding elements.
// *
// * The returned map preserves the entry iteration order of the keys produced from the original buffer.
// *
// * @sample samples.collections.Collections.Transformations.groupBy
// */
//inline fun <K> DELETE.groupBy(keySelector: (Boolean) -> K): Map<K, List<Boolean>> {
//    return groupByTo(LinkedHashMap<K, MutableList<Boolean>>(), keySelector)
//}
//
///**
// * Groups elements of the original buffer by the key returned by the given [keySelector] function
// * applied to each element and returns a map where each group key is associated with a list of corresponding elements.
// *
// * The returned map preserves the entry iteration order of the keys produced from the original buffer.
// *
// * @sample samples.collections.Collections.Transformations.groupBy
// */
//inline fun <K> CharBuffer.groupBy(keySelector: (Char) -> K): Map<K, List<Char>> {
//    return groupByTo(LinkedHashMap<K, MutableList<Char>>(), keySelector)
//}
//
///**
// * Groups values returned by the [valueTransform] function applied to each element of the original buffer
// * by the key returned by the given [keySelector] function applied to the element
// * and returns a map where each group key is associated with a list of corresponding values.
// *
// * The returned map preserves the entry iteration order of the keys produced from the original buffer.
// *
// * @sample samples.collections.Collections.Transformations.groupByKeysAndValues
// */
//inline fun <T, K, V> Array<out T>.groupBy(keySelector: (T) -> K, valueTransform: (T) -> V): Map<K, List<V>> {
//    return groupByTo(LinkedHashMap<K, MutableList<V>>(), keySelector, valueTransform)
//}
//
///**
// * Groups values returned by the [valueTransform] function applied to each element of the original buffer
// * by the key returned by the given [keySelector] function applied to the element
// * and returns a map where each group key is associated with a list of corresponding values.
// *
// * The returned map preserves the entry iteration order of the keys produced from the original buffer.
// *
// * @sample samples.collections.Collections.Transformations.groupByKeysAndValues
// */
//inline fun <K, V> ByteBuffer.groupBy(keySelector: (Byte) -> K, valueTransform: (Byte) -> V): Map<K, List<V>> {
//    return groupByTo(LinkedHashMap<K, MutableList<V>>(), keySelector, valueTransform)
//}
//
///**
// * Groups values returned by the [valueTransform] function applied to each element of the original buffer
// * by the key returned by the given [keySelector] function applied to the element
// * and returns a map where each group key is associated with a list of corresponding values.
// *
// * The returned map preserves the entry iteration order of the keys produced from the original buffer.
// *
// * @sample samples.collections.Collections.Transformations.groupByKeysAndValues
// */
//inline fun <K, V> ShortBuffer.groupBy(keySelector: (Short) -> K, valueTransform: (Short) -> V): Map<K, List<V>> {
//    return groupByTo(LinkedHashMap<K, MutableList<V>>(), keySelector, valueTransform)
//}
//
///**
// * Groups values returned by the [valueTransform] function applied to each element of the original buffer
// * by the key returned by the given [keySelector] function applied to the element
// * and returns a map where each group key is associated with a list of corresponding values.
// *
// * The returned map preserves the entry iteration order of the keys produced from the original buffer.
// *
// * @sample samples.collections.Collections.Transformations.groupByKeysAndValues
// */
//inline fun <K, V> IntBuffer.groupBy(keySelector: (Int) -> K, valueTransform: (Int) -> V): Map<K, List<V>> {
//    return groupByTo(LinkedHashMap<K, MutableList<V>>(), keySelector, valueTransform)
//}
//
///**
// * Groups values returned by the [valueTransform] function applied to each element of the original buffer
// * by the key returned by the given [keySelector] function applied to the element
// * and returns a map where each group key is associated with a list of corresponding values.
// *
// * The returned map preserves the entry iteration order of the keys produced from the original buffer.
// *
// * @sample samples.collections.Collections.Transformations.groupByKeysAndValues
// */
//inline fun <K, V> LongBuffer.groupBy(keySelector: (Long) -> K, valueTransform: (Long) -> V): Map<K, List<V>> {
//    return groupByTo(LinkedHashMap<K, MutableList<V>>(), keySelector, valueTransform)
//}
//
///**
// * Groups values returned by the [valueTransform] function applied to each element of the original buffer
// * by the key returned by the given [keySelector] function applied to the element
// * and returns a map where each group key is associated with a list of corresponding values.
// *
// * The returned map preserves the entry iteration order of the keys produced from the original buffer.
// *
// * @sample samples.collections.Collections.Transformations.groupByKeysAndValues
// */
//inline fun <K, V> FloatBuffer.groupBy(keySelector: (Float) -> K, valueTransform: (Float) -> V): Map<K, List<V>> {
//    return groupByTo(LinkedHashMap<K, MutableList<V>>(), keySelector, valueTransform)
//}
//
///**
// * Groups values returned by the [valueTransform] function applied to each element of the original buffer
// * by the key returned by the given [keySelector] function applied to the element
// * and returns a map where each group key is associated with a list of corresponding values.
// *
// * The returned map preserves the entry iteration order of the keys produced from the original buffer.
// *
// * @sample samples.collections.Collections.Transformations.groupByKeysAndValues
// */
//inline fun <K, V> DoubleBuffer.groupBy(keySelector: (Double) -> K, valueTransform: (Double) -> V): Map<K, List<V>> {
//    return groupByTo(LinkedHashMap<K, MutableList<V>>(), keySelector, valueTransform)
//}
//
///**
// * Groups values returned by the [valueTransform] function applied to each element of the original buffer
// * by the key returned by the given [keySelector] function applied to the element
// * and returns a map where each group key is associated with a list of corresponding values.
// *
// * The returned map preserves the entry iteration order of the keys produced from the original buffer.
// *
// * @sample samples.collections.Collections.Transformations.groupByKeysAndValues
// */
//inline fun <K, V> DELETE.groupBy(keySelector: (Boolean) -> K, valueTransform: (Boolean) -> V): Map<K, List<V>> {
//    return groupByTo(LinkedHashMap<K, MutableList<V>>(), keySelector, valueTransform)
//}
//
///**
// * Groups values returned by the [valueTransform] function applied to each element of the original buffer
// * by the key returned by the given [keySelector] function applied to the element
// * and returns a map where each group key is associated with a list of corresponding values.
// *
// * The returned map preserves the entry iteration order of the keys produced from the original buffer.
// *
// * @sample samples.collections.Collections.Transformations.groupByKeysAndValues
// */
//inline fun <K, V> CharBuffer.groupBy(keySelector: (Char) -> K, valueTransform: (Char) -> V): Map<K, List<V>> {
//    return groupByTo(LinkedHashMap<K, MutableList<V>>(), keySelector, valueTransform)
//}
//
///**
// * Groups elements of the original buffer by the key returned by the given [keySelector] function
// * applied to each element and puts to the [destination] map each group key associated with a list of corresponding elements.
// *
// * @return The [destination] map.
// *
// * @sample samples.collections.Collections.Transformations.groupBy
// */
//inline fun <T, K, M : MutableMap<in K, MutableList<T>>> Array<out T>.groupByTo(destination: M, keySelector: (T) -> K): M {
//    for (element in this) {
//        val key = keySelector(element)
//        val list = destination.getOrPut(key) { ArrayList<T>() }
//        list.add(element)
//    }
//    return destination
//}
//
///**
// * Groups elements of the original buffer by the key returned by the given [keySelector] function
// * applied to each element and puts to the [destination] map each group key associated with a list of corresponding elements.
// *
// * @return The [destination] map.
// *
// * @sample samples.collections.Collections.Transformations.groupBy
// */
//inline fun <K, M : MutableMap<in K, MutableList<Byte>>> ByteBuffer.groupByTo(destination: M, keySelector: (Byte) -> K): M {
//    for (element in this) {
//        val key = keySelector(element)
//        val list = destination.getOrPut(key) { ArrayList<Byte>() }
//        list.add(element)
//    }
//    return destination
//}
//
///**
// * Groups elements of the original buffer by the key returned by the given [keySelector] function
// * applied to each element and puts to the [destination] map each group key associated with a list of corresponding elements.
// *
// * @return The [destination] map.
// *
// * @sample samples.collections.Collections.Transformations.groupBy
// */
//inline fun <K, M : MutableMap<in K, MutableList<Short>>> ShortBuffer.groupByTo(destination: M, keySelector: (Short) -> K): M {
//    for (element in this) {
//        val key = keySelector(element)
//        val list = destination.getOrPut(key) { ArrayList<Short>() }
//        list.add(element)
//    }
//    return destination
//}
//
///**
// * Groups elements of the original buffer by the key returned by the given [keySelector] function
// * applied to each element and puts to the [destination] map each group key associated with a list of corresponding elements.
// *
// * @return The [destination] map.
// *
// * @sample samples.collections.Collections.Transformations.groupBy
// */
//inline fun <K, M : MutableMap<in K, MutableList<Int>>> IntBuffer.groupByTo(destination: M, keySelector: (Int) -> K): M {
//    for (element in this) {
//        val key = keySelector(element)
//        val list = destination.getOrPut(key) { ArrayList<Int>() }
//        list.add(element)
//    }
//    return destination
//}
//
///**
// * Groups elements of the original buffer by the key returned by the given [keySelector] function
// * applied to each element and puts to the [destination] map each group key associated with a list of corresponding elements.
// *
// * @return The [destination] map.
// *
// * @sample samples.collections.Collections.Transformations.groupBy
// */
//inline fun <K, M : MutableMap<in K, MutableList<Long>>> LongBuffer.groupByTo(destination: M, keySelector: (Long) -> K): M {
//    for (element in this) {
//        val key = keySelector(element)
//        val list = destination.getOrPut(key) { ArrayList<Long>() }
//        list.add(element)
//    }
//    return destination
//}
//
///**
// * Groups elements of the original buffer by the key returned by the given [keySelector] function
// * applied to each element and puts to the [destination] map each group key associated with a list of corresponding elements.
// *
// * @return The [destination] map.
// *
// * @sample samples.collections.Collections.Transformations.groupBy
// */
//inline fun <K, M : MutableMap<in K, MutableList<Float>>> FloatBuffer.groupByTo(destination: M, keySelector: (Float) -> K): M {
//    for (element in this) {
//        val key = keySelector(element)
//        val list = destination.getOrPut(key) { ArrayList<Float>() }
//        list.add(element)
//    }
//    return destination
//}
//
///**
// * Groups elements of the original buffer by the key returned by the given [keySelector] function
// * applied to each element and puts to the [destination] map each group key associated with a list of corresponding elements.
// *
// * @return The [destination] map.
// *
// * @sample samples.collections.Collections.Transformations.groupBy
// */
//inline fun <K, M : MutableMap<in K, MutableList<Double>>> DoubleBuffer.groupByTo(destination: M, keySelector: (Double) -> K): M {
//    for (element in this) {
//        val key = keySelector(element)
//        val list = destination.getOrPut(key) { ArrayList<Double>() }
//        list.add(element)
//    }
//    return destination
//}
//
///**
// * Groups elements of the original buffer by the key returned by the given [keySelector] function
// * applied to each element and puts to the [destination] map each group key associated with a list of corresponding elements.
// *
// * @return The [destination] map.
// *
// * @sample samples.collections.Collections.Transformations.groupBy
// */
//inline fun <K, M : MutableMap<in K, MutableList<Boolean>>> DELETE.groupByTo(destination: M, keySelector: (Boolean) -> K): M {
//    for (element in this) {
//        val key = keySelector(element)
//        val list = destination.getOrPut(key) { ArrayList<Boolean>() }
//        list.add(element)
//    }
//    return destination
//}
//
///**
// * Groups elements of the original buffer by the key returned by the given [keySelector] function
// * applied to each element and puts to the [destination] map each group key associated with a list of corresponding elements.
// *
// * @return The [destination] map.
// *
// * @sample samples.collections.Collections.Transformations.groupBy
// */
//inline fun <K, M : MutableMap<in K, MutableList<Char>>> CharBuffer.groupByTo(destination: M, keySelector: (Char) -> K): M {
//    for (element in this) {
//        val key = keySelector(element)
//        val list = destination.getOrPut(key) { ArrayList<Char>() }
//        list.add(element)
//    }
//    return destination
//}
//
///**
// * Groups values returned by the [valueTransform] function applied to each element of the original buffer
// * by the key returned by the given [keySelector] function applied to the element
// * and puts to the [destination] map each group key associated with a list of corresponding values.
// *
// * @return The [destination] map.
// *
// * @sample samples.collections.Collections.Transformations.groupByKeysAndValues
// */
//inline fun <T, K, V, M : MutableMap<in K, MutableList<V>>> Array<out T>.groupByTo(destination: M, keySelector: (T) -> K, valueTransform: (T) -> V): M {
//    for (element in this) {
//        val key = keySelector(element)
//        val list = destination.getOrPut(key) { ArrayList<V>() }
//        list.add(valueTransform(element))
//    }
//    return destination
//}
//
///**
// * Groups values returned by the [valueTransform] function applied to each element of the original buffer
// * by the key returned by the given [keySelector] function applied to the element
// * and puts to the [destination] map each group key associated with a list of corresponding values.
// *
// * @return The [destination] map.
// *
// * @sample samples.collections.Collections.Transformations.groupByKeysAndValues
// */
//inline fun <K, V, M : MutableMap<in K, MutableList<V>>> ByteBuffer.groupByTo(destination: M, keySelector: (Byte) -> K, valueTransform: (Byte) -> V): M {
//    for (element in this) {
//        val key = keySelector(element)
//        val list = destination.getOrPut(key) { ArrayList<V>() }
//        list.add(valueTransform(element))
//    }
//    return destination
//}
//
///**
// * Groups values returned by the [valueTransform] function applied to each element of the original buffer
// * by the key returned by the given [keySelector] function applied to the element
// * and puts to the [destination] map each group key associated with a list of corresponding values.
// *
// * @return The [destination] map.
// *
// * @sample samples.collections.Collections.Transformations.groupByKeysAndValues
// */
//inline fun <K, V, M : MutableMap<in K, MutableList<V>>> ShortBuffer.groupByTo(destination: M, keySelector: (Short) -> K, valueTransform: (Short) -> V): M {
//    for (element in this) {
//        val key = keySelector(element)
//        val list = destination.getOrPut(key) { ArrayList<V>() }
//        list.add(valueTransform(element))
//    }
//    return destination
//}
//
///**
// * Groups values returned by the [valueTransform] function applied to each element of the original buffer
// * by the key returned by the given [keySelector] function applied to the element
// * and puts to the [destination] map each group key associated with a list of corresponding values.
// *
// * @return The [destination] map.
// *
// * @sample samples.collections.Collections.Transformations.groupByKeysAndValues
// */
//inline fun <K, V, M : MutableMap<in K, MutableList<V>>> IntBuffer.groupByTo(destination: M, keySelector: (Int) -> K, valueTransform: (Int) -> V): M {
//    for (element in this) {
//        val key = keySelector(element)
//        val list = destination.getOrPut(key) { ArrayList<V>() }
//        list.add(valueTransform(element))
//    }
//    return destination
//}
//
///**
// * Groups values returned by the [valueTransform] function applied to each element of the original buffer
// * by the key returned by the given [keySelector] function applied to the element
// * and puts to the [destination] map each group key associated with a list of corresponding values.
// *
// * @return The [destination] map.
// *
// * @sample samples.collections.Collections.Transformations.groupByKeysAndValues
// */
//inline fun <K, V, M : MutableMap<in K, MutableList<V>>> LongBuffer.groupByTo(destination: M, keySelector: (Long) -> K, valueTransform: (Long) -> V): M {
//    for (element in this) {
//        val key = keySelector(element)
//        val list = destination.getOrPut(key) { ArrayList<V>() }
//        list.add(valueTransform(element))
//    }
//    return destination
//}
//
///**
// * Groups values returned by the [valueTransform] function applied to each element of the original buffer
// * by the key returned by the given [keySelector] function applied to the element
// * and puts to the [destination] map each group key associated with a list of corresponding values.
// *
// * @return The [destination] map.
// *
// * @sample samples.collections.Collections.Transformations.groupByKeysAndValues
// */
//inline fun <K, V, M : MutableMap<in K, MutableList<V>>> FloatBuffer.groupByTo(destination: M, keySelector: (Float) -> K, valueTransform: (Float) -> V): M {
//    for (element in this) {
//        val key = keySelector(element)
//        val list = destination.getOrPut(key) { ArrayList<V>() }
//        list.add(valueTransform(element))
//    }
//    return destination
//}
//
///**
// * Groups values returned by the [valueTransform] function applied to each element of the original buffer
// * by the key returned by the given [keySelector] function applied to the element
// * and puts to the [destination] map each group key associated with a list of corresponding values.
// *
// * @return The [destination] map.
// *
// * @sample samples.collections.Collections.Transformations.groupByKeysAndValues
// */
//inline fun <K, V, M : MutableMap<in K, MutableList<V>>> DoubleBuffer.groupByTo(destination: M, keySelector: (Double) -> K, valueTransform: (Double) -> V): M {
//    for (element in this) {
//        val key = keySelector(element)
//        val list = destination.getOrPut(key) { ArrayList<V>() }
//        list.add(valueTransform(element))
//    }
//    return destination
//}
//
///**
// * Groups values returned by the [valueTransform] function applied to each element of the original buffer
// * by the key returned by the given [keySelector] function applied to the element
// * and puts to the [destination] map each group key associated with a list of corresponding values.
// *
// * @return The [destination] map.
// *
// * @sample samples.collections.Collections.Transformations.groupByKeysAndValues
// */
//inline fun <K, V, M : MutableMap<in K, MutableList<V>>> DELETE.groupByTo(destination: M, keySelector: (Boolean) -> K, valueTransform: (Boolean) -> V): M {
//    for (element in this) {
//        val key = keySelector(element)
//        val list = destination.getOrPut(key) { ArrayList<V>() }
//        list.add(valueTransform(element))
//    }
//    return destination
//}
//
///**
// * Groups values returned by the [valueTransform] function applied to each element of the original buffer
// * by the key returned by the given [keySelector] function applied to the element
// * and puts to the [destination] map each group key associated with a list of corresponding values.
// *
// * @return The [destination] map.
// *
// * @sample samples.collections.Collections.Transformations.groupByKeysAndValues
// */
//inline fun <K, V, M : MutableMap<in K, MutableList<V>>> CharBuffer.groupByTo(destination: M, keySelector: (Char) -> K, valueTransform: (Char) -> V): M {
//    for (element in this) {
//        val key = keySelector(element)
//        val list = destination.getOrPut(key) { ArrayList<V>() }
//        list.add(valueTransform(element))
//    }
//    return destination
//}
//
///**
// * Creates a [Grouping] source from a buffer to be used later with one of group-and-fold operations
// * using the specified [keySelector] function to extract a key from each element.
// *
// * @sample samples.collections.Collections.Transformations.groupingByEachCount
// */
//@SinceKotlin("1.1")
//inline fun <T, K> Array<out T>.groupingBy(crossinline keySelector: (T) -> K): Grouping<T, K> {
//    return object : Grouping<T, K> {
//        override fun sourceIterator(): Iterator<T> = this@groupingBy.iterator()
//        override fun keyOf(element: T): K = keySelector(element)
//    }
//}


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


///**
// * Returns a lazy [Iterable] of [IndexedValue] for each element of the original buffer.
// */
//fun <T> Array<out T>.withIndex(): Iterable<IndexedValue<T>> {
//    return IndexingIterable { iterator() }
//}
//
///**
// * Returns a lazy [Iterable] of [IndexedValue] for each element of the original buffer.
// */
//fun ByteBuffer.withIndex(): Iterable<IndexedValue<Byte>> {
//    return IndexingIterable { iterator() }
//}
//
///**
// * Returns a lazy [Iterable] of [IndexedValue] for each element of the original buffer.
// */
//fun ShortBuffer.withIndex(): Iterable<IndexedValue<Short>> {
//    return IndexingIterable { iterator() }
//}
//
///**
// * Returns a lazy [Iterable] of [IndexedValue] for each element of the original buffer.
// */
//fun IntBuffer.withIndex(): Iterable<IndexedValue<Int>> {
//    return IndexingIterable { iterator() }
//}
//
///**
// * Returns a lazy [Iterable] of [IndexedValue] for each element of the original buffer.
// */
//fun LongBuffer.withIndex(): Iterable<IndexedValue<Long>> {
//    return IndexingIterable { iterator() }
//}
//
///**
// * Returns a lazy [Iterable] of [IndexedValue] for each element of the original buffer.
// */
//fun FloatBuffer.withIndex(): Iterable<IndexedValue<Float>> {
//    return IndexingIterable { iterator() }
//}
//
///**
// * Returns a lazy [Iterable] of [IndexedValue] for each element of the original buffer.
// */
//fun DoubleBuffer.withIndex(): Iterable<IndexedValue<Double>> {
//    return IndexingIterable { iterator() }
//}
//
///**
// * Returns a lazy [Iterable] of [IndexedValue] for each element of the original buffer.
// */
//fun DELETE.withIndex(): Iterable<IndexedValue<Boolean>> {
//    return IndexingIterable { iterator() }
//}
//
///**
// * Returns a lazy [Iterable] of [IndexedValue] for each element of the original buffer.
// */
//fun CharBuffer.withIndex(): Iterable<IndexedValue<Char>> {
//    return IndexingIterable { iterator() }
//}
//
///**
// * Returns a list containing only distinct elements from the given buffer.
// *
// * The elements in the resulting list are in the same order as they were in the source buffer.
// */
//fun <T> Array<out T>.distinct(): List<T> {
//    return this.toMutableSet().toList()
//}
//
///**
// * Returns a list containing only distinct elements from the given buffer.
// *
// * The elements in the resulting list are in the same order as they were in the source buffer.
// */
//fun ByteBuffer.distinct(): List<Byte> {
//    return this.toMutableSet().toList()
//}
//
///**
// * Returns a list containing only distinct elements from the given buffer.
// *
// * The elements in the resulting list are in the same order as they were in the source buffer.
// */
//fun ShortBuffer.distinct(): List<Short> {
//    return this.toMutableSet().toList()
//}
//
///**
// * Returns a list containing only distinct elements from the given buffer.
// *
// * The elements in the resulting list are in the same order as they were in the source buffer.
// */
//fun IntBuffer.distinct(): List<Int> {
//    return this.toMutableSet().toList()
//}
//
///**
// * Returns a list containing only distinct elements from the given buffer.
// *
// * The elements in the resulting list are in the same order as they were in the source buffer.
// */
//fun LongBuffer.distinct(): List<Long> {
//    return this.toMutableSet().toList()
//}
//
///**
// * Returns a list containing only distinct elements from the given buffer.
// *
// * The elements in the resulting list are in the same order as they were in the source buffer.
// */
//fun FloatBuffer.distinct(): List<Float> {
//    return this.toMutableSet().toList()
//}
//
///**
// * Returns a list containing only distinct elements from the given buffer.
// *
// * The elements in the resulting list are in the same order as they were in the source buffer.
// */
//fun DoubleBuffer.distinct(): List<Double> {
//    return this.toMutableSet().toList()
//}
//
///**
// * Returns a list containing only distinct elements from the given buffer.
// *
// * The elements in the resulting list are in the same order as they were in the source buffer.
// */
//fun DELETE.distinct(): List<Boolean> {
//    return this.toMutableSet().toList()
//}
//
///**
// * Returns a list containing only distinct elements from the given buffer.
// *
// * The elements in the resulting list are in the same order as they were in the source buffer.
// */
//fun CharBuffer.distinct(): List<Char> {
//    return this.toMutableSet().toList()
//}
//
///**
// * Returns a list containing only elements from the given buffer
// * having distinct keys returned by the given [selector] function.
// *
// * The elements in the resulting list are in the same order as they were in the source buffer.
// */
//inline fun <T, K> Array<out T>.distinctBy(selector: (T) -> K): List<T> {
//    val set = HashSet<K>()
//    val list = ArrayList<T>()
//    for (e in this) {
//        val key = selector(e)
//        if (set.add(key))
//            list.add(e)
//    }
//    return list
//}
//
///**
// * Returns a list containing only elements from the given buffer
// * having distinct keys returned by the given [selector] function.
// *
// * The elements in the resulting list are in the same order as they were in the source buffer.
// */
//inline fun <K> ByteBuffer.distinctBy(selector: (Byte) -> K): List<Byte> {
//    val set = HashSet<K>()
//    val list = ArrayList<Byte>()
//    for (e in this) {
//        val key = selector(e)
//        if (set.add(key))
//            list.add(e)
//    }
//    return list
//}
//
///**
// * Returns a list containing only elements from the given buffer
// * having distinct keys returned by the given [selector] function.
// *
// * The elements in the resulting list are in the same order as they were in the source buffer.
// */
//inline fun <K> ShortBuffer.distinctBy(selector: (Short) -> K): List<Short> {
//    val set = HashSet<K>()
//    val list = ArrayList<Short>()
//    for (e in this) {
//        val key = selector(e)
//        if (set.add(key))
//            list.add(e)
//    }
//    return list
//}
//
///**
// * Returns a list containing only elements from the given buffer
// * having distinct keys returned by the given [selector] function.
// *
// * The elements in the resulting list are in the same order as they were in the source buffer.
// */
//inline fun <K> IntBuffer.distinctBy(selector: (Int) -> K): List<Int> {
//    val set = HashSet<K>()
//    val list = ArrayList<Int>()
//    for (e in this) {
//        val key = selector(e)
//        if (set.add(key))
//            list.add(e)
//    }
//    return list
//}
//
///**
// * Returns a list containing only elements from the given buffer
// * having distinct keys returned by the given [selector] function.
// *
// * The elements in the resulting list are in the same order as they were in the source buffer.
// */
//inline fun <K> LongBuffer.distinctBy(selector: (Long) -> K): List<Long> {
//    val set = HashSet<K>()
//    val list = ArrayList<Long>()
//    for (e in this) {
//        val key = selector(e)
//        if (set.add(key))
//            list.add(e)
//    }
//    return list
//}
//
///**
// * Returns a list containing only elements from the given buffer
// * having distinct keys returned by the given [selector] function.
// *
// * The elements in the resulting list are in the same order as they were in the source buffer.
// */
//inline fun <K> FloatBuffer.distinctBy(selector: (Float) -> K): List<Float> {
//    val set = HashSet<K>()
//    val list = ArrayList<Float>()
//    for (e in this) {
//        val key = selector(e)
//        if (set.add(key))
//            list.add(e)
//    }
//    return list
//}
//
///**
// * Returns a list containing only elements from the given buffer
// * having distinct keys returned by the given [selector] function.
// *
// * The elements in the resulting list are in the same order as they were in the source buffer.
// */
//inline fun <K> DoubleBuffer.distinctBy(selector: (Double) -> K): List<Double> {
//    val set = HashSet<K>()
//    val list = ArrayList<Double>()
//    for (e in this) {
//        val key = selector(e)
//        if (set.add(key))
//            list.add(e)
//    }
//    return list
//}
//
///**
// * Returns a list containing only elements from the given buffer
// * having distinct keys returned by the given [selector] function.
// *
// * The elements in the resulting list are in the same order as they were in the source buffer.
// */
//inline fun <K> DELETE.distinctBy(selector: (Boolean) -> K): List<Boolean> {
//    val set = HashSet<K>()
//    val list = ArrayList<Boolean>()
//    for (e in this) {
//        val key = selector(e)
//        if (set.add(key))
//            list.add(e)
//    }
//    return list
//}
//
///**
// * Returns a list containing only elements from the given buffer
// * having distinct keys returned by the given [selector] function.
// *
// * The elements in the resulting list are in the same order as they were in the source buffer.
// */
//inline fun <K> CharBuffer.distinctBy(selector: (Char) -> K): List<Char> {
//    val set = HashSet<K>()
//    val list = ArrayList<Char>()
//    for (e in this) {
//        val key = selector(e)
//        if (set.add(key))
//            list.add(e)
//    }
//    return list
//}
//
///**
// * Returns a set containing all elements that are contained by both this set and the specified collection.
// *
// * The returned set preserves the element iteration order of the original buffer.
// */
//infix fun <T> Array<out T>.intersect(other: Iterable<T>): Set<T> {
//    val set = this.toMutableSet()
//    set.retainAll(other)
//    return set
//}
//
///**
// * Returns a set containing all elements that are contained by both this set and the specified collection.
// *
// * The returned set preserves the element iteration order of the original buffer.
// */
//infix fun ByteBuffer.intersect(other: Iterable<Byte>): Set<Byte> {
//    val set = this.toMutableSet()
//    set.retainAll(other)
//    return set
//}
//
///**
// * Returns a set containing all elements that are contained by both this set and the specified collection.
// *
// * The returned set preserves the element iteration order of the original buffer.
// */
//infix fun ShortBuffer.intersect(other: Iterable<Short>): Set<Short> {
//    val set = this.toMutableSet()
//    set.retainAll(other)
//    return set
//}
//
///**
// * Returns a set containing all elements that are contained by both this set and the specified collection.
// *
// * The returned set preserves the element iteration order of the original buffer.
// */
//infix fun IntBuffer.intersect(other: Iterable<Int>): Set<Int> {
//    val set = this.toMutableSet()
//    set.retainAll(other)
//    return set
//}
//
///**
// * Returns a set containing all elements that are contained by both this set and the specified collection.
// *
// * The returned set preserves the element iteration order of the original buffer.
// */
//infix fun LongBuffer.intersect(other: Iterable<Long>): Set<Long> {
//    val set = this.toMutableSet()
//    set.retainAll(other)
//    return set
//}
//
///**
// * Returns a set containing all elements that are contained by both this set and the specified collection.
// *
// * The returned set preserves the element iteration order of the original buffer.
// */
//infix fun FloatBuffer.intersect(other: Iterable<Float>): Set<Float> {
//    val set = this.toMutableSet()
//    set.retainAll(other)
//    return set
//}
//
///**
// * Returns a set containing all elements that are contained by both this set and the specified collection.
// *
// * The returned set preserves the element iteration order of the original buffer.
// */
//infix fun DoubleBuffer.intersect(other: Iterable<Double>): Set<Double> {
//    val set = this.toMutableSet()
//    set.retainAll(other)
//    return set
//}
//
///**
// * Returns a set containing all elements that are contained by both this set and the specified collection.
// *
// * The returned set preserves the element iteration order of the original buffer.
// */
//infix fun DELETE.intersect(other: Iterable<Boolean>): Set<Boolean> {
//    val set = this.toMutableSet()
//    set.retainAll(other)
//    return set
//}
//
///**
// * Returns a set containing all elements that are contained by both this set and the specified collection.
// *
// * The returned set preserves the element iteration order of the original buffer.
// */
//infix fun CharBuffer.intersect(other: Iterable<Char>): Set<Char> {
//    val set = this.toMutableSet()
//    set.retainAll(other)
//    return set
//}
//
///**
// * Returns a set containing all elements that are contained by this buffer and not contained by the specified collection.
// *
// * The returned set preserves the element iteration order of the original buffer.
// */
//infix fun <T> Array<out T>.subtract(other: Iterable<T>): Set<T> {
//    val set = this.toMutableSet()
//    set.removeAll(other)
//    return set
//}
//
///**
// * Returns a set containing all elements that are contained by this buffer and not contained by the specified collection.
// *
// * The returned set preserves the element iteration order of the original buffer.
// */
//infix fun ByteBuffer.subtract(other: Iterable<Byte>): Set<Byte> {
//    val set = this.toMutableSet()
//    set.removeAll(other)
//    return set
//}
//
///**
// * Returns a set containing all elements that are contained by this buffer and not contained by the specified collection.
// *
// * The returned set preserves the element iteration order of the original buffer.
// */
//infix fun ShortBuffer.subtract(other: Iterable<Short>): Set<Short> {
//    val set = this.toMutableSet()
//    set.removeAll(other)
//    return set
//}
//
///**
// * Returns a set containing all elements that are contained by this buffer and not contained by the specified collection.
// *
// * The returned set preserves the element iteration order of the original buffer.
// */
//infix fun IntBuffer.subtract(other: Iterable<Int>): Set<Int> {
//    val set = this.toMutableSet()
//    set.removeAll(other)
//    return set
//}
//
///**
// * Returns a set containing all elements that are contained by this buffer and not contained by the specified collection.
// *
// * The returned set preserves the element iteration order of the original buffer.
// */
//infix fun LongBuffer.subtract(other: Iterable<Long>): Set<Long> {
//    val set = this.toMutableSet()
//    set.removeAll(other)
//    return set
//}
//
///**
// * Returns a set containing all elements that are contained by this buffer and not contained by the specified collection.
// *
// * The returned set preserves the element iteration order of the original buffer.
// */
//infix fun FloatBuffer.subtract(other: Iterable<Float>): Set<Float> {
//    val set = this.toMutableSet()
//    set.removeAll(other)
//    return set
//}
//
///**
// * Returns a set containing all elements that are contained by this buffer and not contained by the specified collection.
// *
// * The returned set preserves the element iteration order of the original buffer.
// */
//infix fun DoubleBuffer.subtract(other: Iterable<Double>): Set<Double> {
//    val set = this.toMutableSet()
//    set.removeAll(other)
//    return set
//}
//
///**
// * Returns a set containing all elements that are contained by this buffer and not contained by the specified collection.
// *
// * The returned set preserves the element iteration order of the original buffer.
// */
//infix fun DELETE.subtract(other: Iterable<Boolean>): Set<Boolean> {
//    val set = this.toMutableSet()
//    set.removeAll(other)
//    return set
//}
//
///**
// * Returns a set containing all elements that are contained by this buffer and not contained by the specified collection.
// *
// * The returned set preserves the element iteration order of the original buffer.
// */
//infix fun CharBuffer.subtract(other: Iterable<Char>): Set<Char> {
//    val set = this.toMutableSet()
//    set.removeAll(other)
//    return set
//}


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
// * Returns a set containing all distinct elements from both collections.
// *
// * The returned set preserves the element iteration order of the original buffer.
// * Those elements of the [other] collection that are unique are iterated in the end
// * in the order of the [other] collection.
// */
//infix fun <T> Array<out T>.union(other: Iterable<T>): Set<T> {
//    val set = this.toMutableSet()
//    set.addAll(other)
//    return set
//}
//
///**
// * Returns a set containing all distinct elements from both collections.
// *
// * The returned set preserves the element iteration order of the original buffer.
// * Those elements of the [other] collection that are unique are iterated in the end
// * in the order of the [other] collection.
// */
//infix fun ByteBuffer.union(other: Iterable<Byte>): Set<Byte> {
//    val set = this.toMutableSet()
//    set.addAll(other)
//    return set
//}
//
///**
// * Returns a set containing all distinct elements from both collections.
// *
// * The returned set preserves the element iteration order of the original buffer.
// * Those elements of the [other] collection that are unique are iterated in the end
// * in the order of the [other] collection.
// */
//infix fun ShortBuffer.union(other: Iterable<Short>): Set<Short> {
//    val set = this.toMutableSet()
//    set.addAll(other)
//    return set
//}
//
///**
// * Returns a set containing all distinct elements from both collections.
// *
// * The returned set preserves the element iteration order of the original buffer.
// * Those elements of the [other] collection that are unique are iterated in the end
// * in the order of the [other] collection.
// */
//infix fun IntBuffer.union(other: Iterable<Int>): Set<Int> {
//    val set = this.toMutableSet()
//    set.addAll(other)
//    return set
//}
//
///**
// * Returns a set containing all distinct elements from both collections.
// *
// * The returned set preserves the element iteration order of the original buffer.
// * Those elements of the [other] collection that are unique are iterated in the end
// * in the order of the [other] collection.
// */
//infix fun LongBuffer.union(other: Iterable<Long>): Set<Long> {
//    val set = this.toMutableSet()
//    set.addAll(other)
//    return set
//}
//
///**
// * Returns a set containing all distinct elements from both collections.
// *
// * The returned set preserves the element iteration order of the original buffer.
// * Those elements of the [other] collection that are unique are iterated in the end
// * in the order of the [other] collection.
// */
//infix fun FloatBuffer.union(other: Iterable<Float>): Set<Float> {
//    val set = this.toMutableSet()
//    set.addAll(other)
//    return set
//}
//
///**
// * Returns a set containing all distinct elements from both collections.
// *
// * The returned set preserves the element iteration order of the original buffer.
// * Those elements of the [other] collection that are unique are iterated in the end
// * in the order of the [other] collection.
// */
//infix fun DoubleBuffer.union(other: Iterable<Double>): Set<Double> {
//    val set = this.toMutableSet()
//    set.addAll(other)
//    return set
//}
//
///**
// * Returns a set containing all distinct elements from both collections.
// *
// * The returned set preserves the element iteration order of the original buffer.
// * Those elements of the [other] collection that are unique are iterated in the end
// * in the order of the [other] collection.
// */
//infix fun DELETE.union(other: Iterable<Boolean>): Set<Boolean> {
//    val set = this.toMutableSet()
//    set.addAll(other)
//    return set
//}
//
///**
// * Returns a set containing all distinct elements from both collections.
// *
// * The returned set preserves the element iteration order of the original buffer.
// * Those elements of the [other] collection that are unique are iterated in the end
// * in the order of the [other] collection.
// */
//infix fun CharBuffer.union(other: Iterable<Char>): Set<Char> {
//    val set = this.toMutableSet()
//    set.addAll(other)
//    return set
//}


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
fun CharBuffer.any() = !isEmpty()


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
fun ByteBuffer.count() = lim

/** Returns the number of elements in this buffer. */
fun ShortBuffer.count() = lim

/** Returns the number of elements in this buffer. */
fun IntBuffer.count() = lim

/** Returns the number of elements in this buffer. */
fun LongBuffer.count() = lim

/** Returns the number of elements in this buffer. */
fun FloatBuffer.count() = lim

/** Returns the number of elements in this buffer. */
fun DoubleBuffer.count() = lim

/** Returns the number of elements in this buffer. */
fun CharBuffer.count() = lim


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


///**
// * Accumulates value starting with [initial] value and applying [operation] from left to right to current accumulator value and each element.
// */
//inline fun <T, R> Array<out T>.fold(initial: R, operation: (acc: R, T) -> R): R {
//    var accumulator = initial
//    for (element in this) accumulator = operation(accumulator, element)
//    return accumulator
//}
//
///**
// * Accumulates value starting with [initial] value and applying [operation] from left to right to current accumulator value and each element.
// */
//inline fun <R> ByteBuffer.fold(initial: R, operation: (acc: R, Byte) -> R): R {
//    var accumulator = initial
//    for (element in this) accumulator = operation(accumulator, element)
//    return accumulator
//}
//
///**
// * Accumulates value starting with [initial] value and applying [operation] from left to right to current accumulator value and each element.
// */
//inline fun <R> ShortBuffer.fold(initial: R, operation: (acc: R, Short) -> R): R {
//    var accumulator = initial
//    for (element in this) accumulator = operation(accumulator, element)
//    return accumulator
//}
//
///**
// * Accumulates value starting with [initial] value and applying [operation] from left to right to current accumulator value and each element.
// */
//inline fun <R> IntBuffer.fold(initial: R, operation: (acc: R, Int) -> R): R {
//    var accumulator = initial
//    for (element in this) accumulator = operation(accumulator, element)
//    return accumulator
//}
//
///**
// * Accumulates value starting with [initial] value and applying [operation] from left to right to current accumulator value and each element.
// */
//inline fun <R> LongBuffer.fold(initial: R, operation: (acc: R, Long) -> R): R {
//    var accumulator = initial
//    for (element in this) accumulator = operation(accumulator, element)
//    return accumulator
//}
//
///**
// * Accumulates value starting with [initial] value and applying [operation] from left to right to current accumulator value and each element.
// */
//inline fun <R> FloatBuffer.fold(initial: R, operation: (acc: R, Float) -> R): R {
//    var accumulator = initial
//    for (element in this) accumulator = operation(accumulator, element)
//    return accumulator
//}
//
///**
// * Accumulates value starting with [initial] value and applying [operation] from left to right to current accumulator value and each element.
// */
//inline fun <R> DoubleBuffer.fold(initial: R, operation: (acc: R, Double) -> R): R {
//    var accumulator = initial
//    for (element in this) accumulator = operation(accumulator, element)
//    return accumulator
//}
//
///**
// * Accumulates value starting with [initial] value and applying [operation] from left to right to current accumulator value and each element.
// */
//inline fun <R> DELETE.fold(initial: R, operation: (acc: R, Boolean) -> R): R {
//    var accumulator = initial
//    for (element in this) accumulator = operation(accumulator, element)
//    return accumulator
//}
//
///**
// * Accumulates value starting with [initial] value and applying [operation] from left to right to current accumulator value and each element.
// */
//inline fun <R> CharBuffer.fold(initial: R, operation: (acc: R, Char) -> R): R {
//    var accumulator = initial
//    for (element in this) accumulator = operation(accumulator, element)
//    return accumulator
//}
//
///**
// * Accumulates value starting with [initial] value and applying [operation] from left to right
// * to current accumulator value and each element with its index in the original buffer.
// * @param [operation] function that takes the index of an element, current accumulator value
// * and the element itself, and calculates the next accumulator value.
// */
//inline fun <T, R> Array<out T>.foldIndexed(initial: R, operation: (index: Int, acc: R, T) -> R): R {
//    var index = 0
//    var accumulator = initial
//    for (element in this) accumulator = operation(index++, accumulator, element)
//    return accumulator
//}
//
///**
// * Accumulates value starting with [initial] value and applying [operation] from left to right
// * to current accumulator value and each element with its index in the original buffer.
// * @param [operation] function that takes the index of an element, current accumulator value
// * and the element itself, and calculates the next accumulator value.
// */
//inline fun <R> ByteBuffer.foldIndexed(initial: R, operation: (index: Int, acc: R, Byte) -> R): R {
//    var index = 0
//    var accumulator = initial
//    for (element in this) accumulator = operation(index++, accumulator, element)
//    return accumulator
//}
//
///**
// * Accumulates value starting with [initial] value and applying [operation] from left to right
// * to current accumulator value and each element with its index in the original buffer.
// * @param [operation] function that takes the index of an element, current accumulator value
// * and the element itself, and calculates the next accumulator value.
// */
//inline fun <R> ShortBuffer.foldIndexed(initial: R, operation: (index: Int, acc: R, Short) -> R): R {
//    var index = 0
//    var accumulator = initial
//    for (element in this) accumulator = operation(index++, accumulator, element)
//    return accumulator
//}
//
///**
// * Accumulates value starting with [initial] value and applying [operation] from left to right
// * to current accumulator value and each element with its index in the original buffer.
// * @param [operation] function that takes the index of an element, current accumulator value
// * and the element itself, and calculates the next accumulator value.
// */
//inline fun <R> IntBuffer.foldIndexed(initial: R, operation: (index: Int, acc: R, Int) -> R): R {
//    var index = 0
//    var accumulator = initial
//    for (element in this) accumulator = operation(index++, accumulator, element)
//    return accumulator
//}
//
///**
// * Accumulates value starting with [initial] value and applying [operation] from left to right
// * to current accumulator value and each element with its index in the original buffer.
// * @param [operation] function that takes the index of an element, current accumulator value
// * and the element itself, and calculates the next accumulator value.
// */
//inline fun <R> LongBuffer.foldIndexed(initial: R, operation: (index: Int, acc: R, Long) -> R): R {
//    var index = 0
//    var accumulator = initial
//    for (element in this) accumulator = operation(index++, accumulator, element)
//    return accumulator
//}
//
///**
// * Accumulates value starting with [initial] value and applying [operation] from left to right
// * to current accumulator value and each element with its index in the original buffer.
// * @param [operation] function that takes the index of an element, current accumulator value
// * and the element itself, and calculates the next accumulator value.
// */
//inline fun <R> FloatBuffer.foldIndexed(initial: R, operation: (index: Int, acc: R, Float) -> R): R {
//    var index = 0
//    var accumulator = initial
//    for (element in this) accumulator = operation(index++, accumulator, element)
//    return accumulator
//}
//
///**
// * Accumulates value starting with [initial] value and applying [operation] from left to right
// * to current accumulator value and each element with its index in the original buffer.
// * @param [operation] function that takes the index of an element, current accumulator value
// * and the element itself, and calculates the next accumulator value.
// */
//inline fun <R> DoubleBuffer.foldIndexed(initial: R, operation: (index: Int, acc: R, Double) -> R): R {
//    var index = 0
//    var accumulator = initial
//    for (element in this) accumulator = operation(index++, accumulator, element)
//    return accumulator
//}
//
///**
// * Accumulates value starting with [initial] value and applying [operation] from left to right
// * to current accumulator value and each element with its index in the original buffer.
// * @param [operation] function that takes the index of an element, current accumulator value
// * and the element itself, and calculates the next accumulator value.
// */
//inline fun <R> DELETE.foldIndexed(initial: R, operation: (index: Int, acc: R, Boolean) -> R): R {
//    var index = 0
//    var accumulator = initial
//    for (element in this) accumulator = operation(index++, accumulator, element)
//    return accumulator
//}
//
///**
// * Accumulates value starting with [initial] value and applying [operation] from left to right
// * to current accumulator value and each element with its index in the original buffer.
// * @param [operation] function that takes the index of an element, current accumulator value
// * and the element itself, and calculates the next accumulator value.
// */
//inline fun <R> CharBuffer.foldIndexed(initial: R, operation: (index: Int, acc: R, Char) -> R): R {
//    var index = 0
//    var accumulator = initial
//    for (element in this) accumulator = operation(index++, accumulator, element)
//    return accumulator
//}
//
///**
// * Accumulates value starting with [initial] value and applying [operation] from right to left to each element and current accumulator value.
// */
//inline fun <T, R> Array<out T>.foldRight(initial: R, operation: (T, acc: R) -> R): R {
//    var index = lastIndex
//    var accumulator = initial
//    while (index >= 0) {
//        accumulator = operation(get(index--), accumulator)
//    }
//    return accumulator
//}
//
///**
// * Accumulates value starting with [initial] value and applying [operation] from right to left to each element and current accumulator value.
// */
//inline fun <R> ByteBuffer.foldRight(initial: R, operation: (Byte, acc: R) -> R): R {
//    var index = lastIndex
//    var accumulator = initial
//    while (index >= 0) {
//        accumulator = operation(get(index--), accumulator)
//    }
//    return accumulator
//}
//
///**
// * Accumulates value starting with [initial] value and applying [operation] from right to left to each element and current accumulator value.
// */
//inline fun <R> ShortBuffer.foldRight(initial: R, operation: (Short, acc: R) -> R): R {
//    var index = lastIndex
//    var accumulator = initial
//    while (index >= 0) {
//        accumulator = operation(get(index--), accumulator)
//    }
//    return accumulator
//}
//
///**
// * Accumulates value starting with [initial] value and applying [operation] from right to left to each element and current accumulator value.
// */
//inline fun <R> IntBuffer.foldRight(initial: R, operation: (Int, acc: R) -> R): R {
//    var index = lastIndex
//    var accumulator = initial
//    while (index >= 0) {
//        accumulator = operation(get(index--), accumulator)
//    }
//    return accumulator
//}
//
///**
// * Accumulates value starting with [initial] value and applying [operation] from right to left to each element and current accumulator value.
// */
//inline fun <R> LongBuffer.foldRight(initial: R, operation: (Long, acc: R) -> R): R {
//    var index = lastIndex
//    var accumulator = initial
//    while (index >= 0) {
//        accumulator = operation(get(index--), accumulator)
//    }
//    return accumulator
//}
//
///**
// * Accumulates value starting with [initial] value and applying [operation] from right to left to each element and current accumulator value.
// */
//inline fun <R> FloatBuffer.foldRight(initial: R, operation: (Float, acc: R) -> R): R {
//    var index = lastIndex
//    var accumulator = initial
//    while (index >= 0) {
//        accumulator = operation(get(index--), accumulator)
//    }
//    return accumulator
//}
//
///**
// * Accumulates value starting with [initial] value and applying [operation] from right to left to each element and current accumulator value.
// */
//inline fun <R> DoubleBuffer.foldRight(initial: R, operation: (Double, acc: R) -> R): R {
//    var index = lastIndex
//    var accumulator = initial
//    while (index >= 0) {
//        accumulator = operation(get(index--), accumulator)
//    }
//    return accumulator
//}
//
///**
// * Accumulates value starting with [initial] value and applying [operation] from right to left to each element and current accumulator value.
// */
//inline fun <R> DELETE.foldRight(initial: R, operation: (Boolean, acc: R) -> R): R {
//    var index = lastIndex
//    var accumulator = initial
//    while (index >= 0) {
//        accumulator = operation(get(index--), accumulator)
//    }
//    return accumulator
//}
//
///**
// * Accumulates value starting with [initial] value and applying [operation] from right to left to each element and current accumulator value.
// */
//inline fun <R> CharBuffer.foldRight(initial: R, operation: (Char, acc: R) -> R): R {
//    var index = lastIndex
//    var accumulator = initial
//    while (index >= 0) {
//        accumulator = operation(get(index--), accumulator)
//    }
//    return accumulator
//}
//
///**
// * Accumulates value starting with [initial] value and applying [operation] from right to left
// * to each element with its index in the original buffer and current accumulator value.
// * @param [operation] function that takes the index of an element, the element itself
// * and current accumulator value, and calculates the next accumulator value.
// */
//inline fun <T, R> Array<out T>.foldRightIndexed(initial: R, operation: (index: Int, T, acc: R) -> R): R {
//    var index = lastIndex
//    var accumulator = initial
//    while (index >= 0) {
//        accumulator = operation(index, get(index), accumulator)
//        --index
//    }
//    return accumulator
//}
//
///**
// * Accumulates value starting with [initial] value and applying [operation] from right to left
// * to each element with its index in the original buffer and current accumulator value.
// * @param [operation] function that takes the index of an element, the element itself
// * and current accumulator value, and calculates the next accumulator value.
// */
//inline fun <R> ByteBuffer.foldRightIndexed(initial: R, operation: (index: Int, Byte, acc: R) -> R): R {
//    var index = lastIndex
//    var accumulator = initial
//    while (index >= 0) {
//        accumulator = operation(index, get(index), accumulator)
//        --index
//    }
//    return accumulator
//}
//
///**
// * Accumulates value starting with [initial] value and applying [operation] from right to left
// * to each element with its index in the original buffer and current accumulator value.
// * @param [operation] function that takes the index of an element, the element itself
// * and current accumulator value, and calculates the next accumulator value.
// */
//inline fun <R> ShortBuffer.foldRightIndexed(initial: R, operation: (index: Int, Short, acc: R) -> R): R {
//    var index = lastIndex
//    var accumulator = initial
//    while (index >= 0) {
//        accumulator = operation(index, get(index), accumulator)
//        --index
//    }
//    return accumulator
//}
//
///**
// * Accumulates value starting with [initial] value and applying [operation] from right to left
// * to each element with its index in the original buffer and current accumulator value.
// * @param [operation] function that takes the index of an element, the element itself
// * and current accumulator value, and calculates the next accumulator value.
// */
//inline fun <R> IntBuffer.foldRightIndexed(initial: R, operation: (index: Int, Int, acc: R) -> R): R {
//    var index = lastIndex
//    var accumulator = initial
//    while (index >= 0) {
//        accumulator = operation(index, get(index), accumulator)
//        --index
//    }
//    return accumulator
//}
//
///**
// * Accumulates value starting with [initial] value and applying [operation] from right to left
// * to each element with its index in the original buffer and current accumulator value.
// * @param [operation] function that takes the index of an element, the element itself
// * and current accumulator value, and calculates the next accumulator value.
// */
//inline fun <R> LongBuffer.foldRightIndexed(initial: R, operation: (index: Int, Long, acc: R) -> R): R {
//    var index = lastIndex
//    var accumulator = initial
//    while (index >= 0) {
//        accumulator = operation(index, get(index), accumulator)
//        --index
//    }
//    return accumulator
//}
//
///**
// * Accumulates value starting with [initial] value and applying [operation] from right to left
// * to each element with its index in the original buffer and current accumulator value.
// * @param [operation] function that takes the index of an element, the element itself
// * and current accumulator value, and calculates the next accumulator value.
// */
//inline fun <R> FloatBuffer.foldRightIndexed(initial: R, operation: (index: Int, Float, acc: R) -> R): R {
//    var index = lastIndex
//    var accumulator = initial
//    while (index >= 0) {
//        accumulator = operation(index, get(index), accumulator)
//        --index
//    }
//    return accumulator
//}
//
///**
// * Accumulates value starting with [initial] value and applying [operation] from right to left
// * to each element with its index in the original buffer and current accumulator value.
// * @param [operation] function that takes the index of an element, the element itself
// * and current accumulator value, and calculates the next accumulator value.
// */
//inline fun <R> DoubleBuffer.foldRightIndexed(initial: R, operation: (index: Int, Double, acc: R) -> R): R {
//    var index = lastIndex
//    var accumulator = initial
//    while (index >= 0) {
//        accumulator = operation(index, get(index), accumulator)
//        --index
//    }
//    return accumulator
//}
//
///**
// * Accumulates value starting with [initial] value and applying [operation] from right to left
// * to each element with its index in the original buffer and current accumulator value.
// * @param [operation] function that takes the index of an element, the element itself
// * and current accumulator value, and calculates the next accumulator value.
// */
//inline fun <R> DELETE.foldRightIndexed(initial: R, operation: (index: Int, Boolean, acc: R) -> R): R {
//    var index = lastIndex
//    var accumulator = initial
//    while (index >= 0) {
//        accumulator = operation(index, get(index), accumulator)
//        --index
//    }
//    return accumulator
//}
//
///**
// * Accumulates value starting with [initial] value and applying [operation] from right to left
// * to each element with its index in the original buffer and current accumulator value.
// * @param [operation] function that takes the index of an element, the element itself
// * and current accumulator value, and calculates the next accumulator value.
// */
//inline fun <R> CharBuffer.foldRightIndexed(initial: R, operation: (index: Int, Char, acc: R) -> R): R {
//    var index = lastIndex
//    var accumulator = initial
//    while (index >= 0) {
//        accumulator = operation(index, get(index), accumulator)
//        --index
//    }
//    return accumulator
//}


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


/** Returns the largest element or `null` if there are no elements. */
fun ByteBuffer.max(): Byte? {
    if (isEmpty()) return null
    var max = this[0]
    for (i in 1..lastIndex) {
        val e = this[i]
        if (max < e) max = e
    }
    return max
}

/** Returns the largest element or `null` if there are no elements. */
fun ShortBuffer.max(): Short? {
    if (isEmpty()) return null
    var max = this[0]
    for (i in 1..lastIndex) {
        val e = this[i]
        if (max < e) max = e
    }
    return max
}

/** Returns the largest element or `null` if there are no elements. */
fun IntBuffer.max(): Int? {
    if (isEmpty()) return null
    var max = this[0]
    for (i in 1..lastIndex) {
        val e = this[i]
        if (max < e) max = e
    }
    return max
}

/** Returns the largest element or `null` if there are no elements. */
fun LongBuffer.max(): Long? {
    if (isEmpty()) return null
    var max = this[0]
    for (i in 1..lastIndex) {
        val e = this[i]
        if (max < e) max = e
    }
    return max
}

/** Returns the largest element or `null` if there are no elements. If any of elements is `NaN` returns `NaN`. */
fun FloatBuffer.max(): Float? {
    if (isEmpty()) return null
    var max = this[0]
    if (max.isNaN()) return max
    for (i in 1..lastIndex) {
        val e = this[i]
        if (e.isNaN()) return e
        if (max < e) max = e
    }
    return max
}

/** Returns the largest element or `null` if there are no elements. If any of elements is `NaN` returns `NaN`. */
fun DoubleBuffer.max(): Double? {
    if (isEmpty()) return null
    var max = this[0]
    if (max.isNaN()) return max
    for (i in 1..lastIndex) {
        val e = this[i]
        if (e.isNaN()) return e
        if (max < e) max = e
    }
    return max
}

/** Returns the largest element or `null` if there are no elements. */
fun CharBuffer.max(): Char? {
    if (isEmpty()) return null
    var max = this[0]
    for (i in 1..lastIndex) {
        val e = this[i]
        if (max < e) max = e
    }
    return max
}


/** Returns the first element yielding the largest value of the given function or `null` if there are no elements. */
inline fun <R : Comparable<R>> ByteBuffer.maxBy(selector: (Byte) -> R): Byte? {
    if (isEmpty()) return null
    var maxElem = this[0]
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
inline fun <R : Comparable<R>> ShortBuffer.maxBy(selector: (Short) -> R): Short? {
    if (isEmpty()) return null
    var maxElem = this[0]
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
inline fun <R : Comparable<R>> IntBuffer.maxBy(selector: (Int) -> R): Int? {
    if (isEmpty()) return null
    var maxElem = this[0]
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
inline fun <R : Comparable<R>> LongBuffer.maxBy(selector: (Long) -> R): Long? {
    if (isEmpty()) return null
    var maxElem = this[0]
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
inline fun <R : Comparable<R>> FloatBuffer.maxBy(selector: (Float) -> R): Float? {
    if (isEmpty()) return null
    var maxElem = this[0]
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
inline fun <R : Comparable<R>> DoubleBuffer.maxBy(selector: (Double) -> R): Double? {
    if (isEmpty()) return null
    var maxElem = this[0]
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
inline fun <R : Comparable<R>> CharBuffer.maxBy(selector: (Char) -> R): Char? {
    if (isEmpty()) return null
    var maxElem = this[0]
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

///**
// * Returns the first element having the largest value according to the provided [comparator] or `null` if there are no elements.
// */
//fun <T> Array<out T>.maxWith(comparator: Comparator<in T>): T? {
//    if (isEmpty()) return null
//    var max = this[0]
//    for (i in 1..lastIndex) {
//        val e = this[i]
//        if (comparator.compare(max, e) < 0) max = e
//    }
//    return max
//}
//
///**
// * Returns the first element having the largest value according to the provided [comparator] or `null` if there are no elements.
// */
//fun ByteBuffer.maxWith(comparator: Comparator<in Byte>): Byte? {
//    if (isEmpty()) return null
//    var max = this[0]
//    for (i in 1..lastIndex) {
//        val e = this[i]
//        if (comparator.compare(max, e) < 0) max = e
//    }
//    return max
//}
//
///**
// * Returns the first element having the largest value according to the provided [comparator] or `null` if there are no elements.
// */
//fun ShortBuffer.maxWith(comparator: Comparator<in Short>): Short? {
//    if (isEmpty()) return null
//    var max = this[0]
//    for (i in 1..lastIndex) {
//        val e = this[i]
//        if (comparator.compare(max, e) < 0) max = e
//    }
//    return max
//}
//
///**
// * Returns the first element having the largest value according to the provided [comparator] or `null` if there are no elements.
// */
//fun IntBuffer.maxWith(comparator: Comparator<in Int>): Int? {
//    if (isEmpty()) return null
//    var max = this[0]
//    for (i in 1..lastIndex) {
//        val e = this[i]
//        if (comparator.compare(max, e) < 0) max = e
//    }
//    return max
//}
//
///**
// * Returns the first element having the largest value according to the provided [comparator] or `null` if there are no elements.
// */
//fun LongBuffer.maxWith(comparator: Comparator<in Long>): Long? {
//    if (isEmpty()) return null
//    var max = this[0]
//    for (i in 1..lastIndex) {
//        val e = this[i]
//        if (comparator.compare(max, e) < 0) max = e
//    }
//    return max
//}
//
///**
// * Returns the first element having the largest value according to the provided [comparator] or `null` if there are no elements.
// */
//fun FloatBuffer.maxWith(comparator: Comparator<in Float>): Float? {
//    if (isEmpty()) return null
//    var max = this[0]
//    for (i in 1..lastIndex) {
//        val e = this[i]
//        if (comparator.compare(max, e) < 0) max = e
//    }
//    return max
//}
//
///**
// * Returns the first element having the largest value according to the provided [comparator] or `null` if there are no elements.
// */
//fun DoubleBuffer.maxWith(comparator: Comparator<in Double>): Double? {
//    if (isEmpty()) return null
//    var max = this[0]
//    for (i in 1..lastIndex) {
//        val e = this[i]
//        if (comparator.compare(max, e) < 0) max = e
//    }
//    return max
//}
//
///**
// * Returns the first element having the largest value according to the provided [comparator] or `null` if there are no elements.
// */
//fun DELETE.maxWith(comparator: Comparator<in Boolean>): Boolean? {
//    if (isEmpty()) return null
//    var max = this[0]
//    for (i in 1..lastIndex) {
//        val e = this[i]
//        if (comparator.compare(max, e) < 0) max = e
//    }
//    return max
//}
//
///**
// * Returns the first element having the largest value according to the provided [comparator] or `null` if there are no elements.
// */
//fun CharBuffer.maxWith(comparator: Comparator<in Char>): Char? {
//    if (isEmpty()) return null
//    var max = this[0]
//    for (i in 1..lastIndex) {
//        val e = this[i]
//        if (comparator.compare(max, e) < 0) max = e
//    }
//    return max
//}


/** Returns the smallest element or `null` if there are no elements. */
fun ByteBuffer.min(): Byte? {
    if (isEmpty()) return null
    var min = this[0]
    for (i in 1..lastIndex) {
        val e = this[i]
        if (min > e) min = e
    }
    return min
}

/** Returns the smallest element or `null` if there are no elements. */
fun ShortBuffer.min(): Short? {
    if (isEmpty()) return null
    var min = this[0]
    for (i in 1..lastIndex) {
        val e = this[i]
        if (min > e) min = e
    }
    return min
}

/** Returns the smallest element or `null` if there are no elements. */
fun IntBuffer.min(): Int? {
    if (isEmpty()) return null
    var min = this[0]
    for (i in 1..lastIndex) {
        val e = this[i]
        if (min > e) min = e
    }
    return min
}

/** Returns the smallest element or `null` if there are no elements. */
fun LongBuffer.min(): Long? {
    if (isEmpty()) return null
    var min = this[0]
    for (i in 1..lastIndex) {
        val e = this[i]
        if (min > e) min = e
    }
    return min
}

/** Returns the smallest element or `null` if there are no elements. If any of elements is `NaN` returns `NaN`. */
fun FloatBuffer.min(): Float? {
    if (isEmpty()) return null
    var min = this[0]
    if (min.isNaN()) return min
    for (i in 1..lastIndex) {
        val e = this[i]
        if (e.isNaN()) return e
        if (min > e) min = e
    }
    return min
}

/** Returns the smallest element or `null` if there are no elements. If any of elements is `NaN` returns `NaN`. */
fun DoubleBuffer.min(): Double? {
    if (isEmpty()) return null
    var min = this[0]
    if (min.isNaN()) return min
    for (i in 1..lastIndex) {
        val e = this[i]
        if (e.isNaN()) return e
        if (min > e) min = e
    }
    return min
}

/** Returns the smallest element or `null` if there are no elements. */
fun CharBuffer.min(): Char? {
    if (isEmpty()) return null
    var min = this[0]
    for (i in 1..lastIndex) {
        val e = this[i]
        if (min > e) min = e
    }
    return min
}


/** Returns the first element yielding the smallest value of the given function or `null` if there are no elements. */
inline fun <R : Comparable<R>> ByteBuffer.minBy(selector: (Byte) -> R): Byte? {
    if (isEmpty()) return null
    var minElem = this[0]
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

/** Returns the first element yielding the smallest value of the given function or `null` if there are no elements. */
inline fun <R : Comparable<R>> ShortBuffer.minBy(selector: (Short) -> R): Short? {
    if (isEmpty()) return null
    var minElem = this[0]
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

/** Returns the first element yielding the smallest value of the given function or `null` if there are no elements. */
inline fun <R : Comparable<R>> IntBuffer.minBy(selector: (Int) -> R): Int? {
    if (isEmpty()) return null
    var minElem = this[0]
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

/** Returns the first element yielding the smallest value of the given function or `null` if there are no elements. */
inline fun <R : Comparable<R>> LongBuffer.minBy(selector: (Long) -> R): Long? {
    if (isEmpty()) return null
    var minElem = this[0]
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

/** Returns the first element yielding the smallest value of the given function or `null` if there are no elements. */
inline fun <R : Comparable<R>> FloatBuffer.minBy(selector: (Float) -> R): Float? {
    if (isEmpty()) return null
    var minElem = this[0]
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

/** Returns the first element yielding the smallest value of the given function or `null` if there are no elements. */
inline fun <R : Comparable<R>> DoubleBuffer.minBy(selector: (Double) -> R): Double? {
    if (isEmpty()) return null
    var minElem = this[0]
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

/** Returns the first element yielding the smallest value of the given function or `null` if there are no elements. */
inline fun <R : Comparable<R>> CharBuffer.minBy(selector: (Char) -> R): Char? {
    if (isEmpty()) return null
    var minElem = this[0]
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


///**
// * Returns the first element having the smallest value according to the provided [comparator] or `null` if there are no elements.
// */
//fun <T> Array<out T>.minWith(comparator: Comparator<in T>): T? {
//    if (isEmpty()) return null
//    var min = this[0]
//    for (i in 1..lastIndex) {
//        val e = this[i]
//        if (comparator.compare(min, e) > 0) min = e
//    }
//    return min
//}
//
///**
// * Returns the first element having the smallest value according to the provided [comparator] or `null` if there are no elements.
// */
//fun ByteBuffer.minWith(comparator: Comparator<in Byte>): Byte? {
//    if (isEmpty()) return null
//    var min = this[0]
//    for (i in 1..lastIndex) {
//        val e = this[i]
//        if (comparator.compare(min, e) > 0) min = e
//    }
//    return min
//}
//
///**
// * Returns the first element having the smallest value according to the provided [comparator] or `null` if there are no elements.
// */
//fun ShortBuffer.minWith(comparator: Comparator<in Short>): Short? {
//    if (isEmpty()) return null
//    var min = this[0]
//    for (i in 1..lastIndex) {
//        val e = this[i]
//        if (comparator.compare(min, e) > 0) min = e
//    }
//    return min
//}
//
///**
// * Returns the first element having the smallest value according to the provided [comparator] or `null` if there are no elements.
// */
//fun IntBuffer.minWith(comparator: Comparator<in Int>): Int? {
//    if (isEmpty()) return null
//    var min = this[0]
//    for (i in 1..lastIndex) {
//        val e = this[i]
//        if (comparator.compare(min, e) > 0) min = e
//    }
//    return min
//}
//
///**
// * Returns the first element having the smallest value according to the provided [comparator] or `null` if there are no elements.
// */
//fun LongBuffer.minWith(comparator: Comparator<in Long>): Long? {
//    if (isEmpty()) return null
//    var min = this[0]
//    for (i in 1..lastIndex) {
//        val e = this[i]
//        if (comparator.compare(min, e) > 0) min = e
//    }
//    return min
//}
//
///**
// * Returns the first element having the smallest value according to the provided [comparator] or `null` if there are no elements.
// */
//fun FloatBuffer.minWith(comparator: Comparator<in Float>): Float? {
//    if (isEmpty()) return null
//    var min = this[0]
//    for (i in 1..lastIndex) {
//        val e = this[i]
//        if (comparator.compare(min, e) > 0) min = e
//    }
//    return min
//}
//
///**
// * Returns the first element having the smallest value according to the provided [comparator] or `null` if there are no elements.
// */
//fun DoubleBuffer.minWith(comparator: Comparator<in Double>): Double? {
//    if (isEmpty()) return null
//    var min = this[0]
//    for (i in 1..lastIndex) {
//        val e = this[i]
//        if (comparator.compare(min, e) > 0) min = e
//    }
//    return min
//}
//
///**
// * Returns the first element having the smallest value according to the provided [comparator] or `null` if there are no elements.
// */
//fun DELETE.minWith(comparator: Comparator<in Boolean>): Boolean? {
//    if (isEmpty()) return null
//    var min = this[0]
//    for (i in 1..lastIndex) {
//        val e = this[i]
//        if (comparator.compare(min, e) > 0) min = e
//    }
//    return min
//}
//
///**
// * Returns the first element having the smallest value according to the provided [comparator] or `null` if there are no elements.
// */
//fun CharBuffer.minWith(comparator: Comparator<in Char>): Char? {
//    if (isEmpty()) return null
//    var min = this[0]
//    for (i in 1..lastIndex) {
//        val e = this[i]
//        if (comparator.compare(min, e) > 0) min = e
//    }
//    return min
//}


/** Returns `true` if the buffer has no elements. */
fun ByteBuffer.none() = isEmpty()

/** Returns `true` if the buffer has no elements. */
fun ShortBuffer.none() = isEmpty()

/** Returns `true` if the buffer has no elements. */
fun IntBuffer.none() = isEmpty()

/** Returns `true` if the buffer has no elements. */
fun LongBuffer.none() = isEmpty()

/** Returns `true` if the buffer has no elements. */
fun FloatBuffer.none() = isEmpty()

/** Returns `true` if the buffer has no elements. */
fun DoubleBuffer.none() = isEmpty()

/** Returns `true` if the buffer has no elements. */
fun CharBuffer.none() = isEmpty()


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

///**
// * Accumulates value starting with the first element and applying [operation] from left to right to current accumulator value and each element.
// */
//inline fun <S, T : S> Array<out T>.reduce(operation: (acc: S, T) -> S): S {
//    if (isEmpty())
//        throw UnsupportedOperationException("Empty buffer can't be reduced.")
//    var accumulator: S = this[0]
//    for (index in 1..lastIndex) {
//        accumulator = operation(accumulator, this[index])
//    }
//    return accumulator
//}
//
///**
// * Accumulates value starting with the first element and applying [operation] from left to right to current accumulator value and each element.
// */
//inline fun ByteBuffer.reduce(operation: (acc: Byte, Byte) -> Byte): Byte {
//    if (isEmpty())
//        throw UnsupportedOperationException("Empty buffer can't be reduced.")
//    var accumulator = this[0]
//    for (index in 1..lastIndex) {
//        accumulator = operation(accumulator, this[index])
//    }
//    return accumulator
//}
//
///**
// * Accumulates value starting with the first element and applying [operation] from left to right to current accumulator value and each element.
// */
//inline fun ShortBuffer.reduce(operation: (acc: Short, Short) -> Short): Short {
//    if (isEmpty())
//        throw UnsupportedOperationException("Empty buffer can't be reduced.")
//    var accumulator = this[0]
//    for (index in 1..lastIndex) {
//        accumulator = operation(accumulator, this[index])
//    }
//    return accumulator
//}
//
///**
// * Accumulates value starting with the first element and applying [operation] from left to right to current accumulator value and each element.
// */
//inline fun IntBuffer.reduce(operation: (acc: Int, Int) -> Int): Int {
//    if (isEmpty())
//        throw UnsupportedOperationException("Empty buffer can't be reduced.")
//    var accumulator = this[0]
//    for (index in 1..lastIndex) {
//        accumulator = operation(accumulator, this[index])
//    }
//    return accumulator
//}
//
///**
// * Accumulates value starting with the first element and applying [operation] from left to right to current accumulator value and each element.
// */
//inline fun LongBuffer.reduce(operation: (acc: Long, Long) -> Long): Long {
//    if (isEmpty())
//        throw UnsupportedOperationException("Empty buffer can't be reduced.")
//    var accumulator = this[0]
//    for (index in 1..lastIndex) {
//        accumulator = operation(accumulator, this[index])
//    }
//    return accumulator
//}
//
///**
// * Accumulates value starting with the first element and applying [operation] from left to right to current accumulator value and each element.
// */
//inline fun FloatBuffer.reduce(operation: (acc: Float, Float) -> Float): Float {
//    if (isEmpty())
//        throw UnsupportedOperationException("Empty buffer can't be reduced.")
//    var accumulator = this[0]
//    for (index in 1..lastIndex) {
//        accumulator = operation(accumulator, this[index])
//    }
//    return accumulator
//}
//
///**
// * Accumulates value starting with the first element and applying [operation] from left to right to current accumulator value and each element.
// */
//inline fun DoubleBuffer.reduce(operation: (acc: Double, Double) -> Double): Double {
//    if (isEmpty())
//        throw UnsupportedOperationException("Empty buffer can't be reduced.")
//    var accumulator = this[0]
//    for (index in 1..lastIndex) {
//        accumulator = operation(accumulator, this[index])
//    }
//    return accumulator
//}
//
///**
// * Accumulates value starting with the first element and applying [operation] from left to right to current accumulator value and each element.
// */
//inline fun DELETE.reduce(operation: (acc: Boolean, Boolean) -> Boolean): Boolean {
//    if (isEmpty())
//        throw UnsupportedOperationException("Empty buffer can't be reduced.")
//    var accumulator = this[0]
//    for (index in 1..lastIndex) {
//        accumulator = operation(accumulator, this[index])
//    }
//    return accumulator
//}
//
///**
// * Accumulates value starting with the first element and applying [operation] from left to right to current accumulator value and each element.
// */
//inline fun CharBuffer.reduce(operation: (acc: Char, Char) -> Char): Char {
//    if (isEmpty())
//        throw UnsupportedOperationException("Empty buffer can't be reduced.")
//    var accumulator = this[0]
//    for (index in 1..lastIndex) {
//        accumulator = operation(accumulator, this[index])
//    }
//    return accumulator
//}
//
///**
// * Accumulates value starting with the first element and applying [operation] from left to right
// * to current accumulator value and each element with its index in the original buffer.
// * @param [operation] function that takes the index of an element, current accumulator value
// * and the element itself and calculates the next accumulator value.
// */
//inline fun <S, T : S> Array<out T>.reduceIndexed(operation: (index: Int, acc: S, T) -> S): S {
//    if (isEmpty())
//        throw UnsupportedOperationException("Empty buffer can't be reduced.")
//    var accumulator: S = this[0]
//    for (index in 1..lastIndex) {
//        accumulator = operation(index, accumulator, this[index])
//    }
//    return accumulator
//}
//
///**
// * Accumulates value starting with the first element and applying [operation] from left to right
// * to current accumulator value and each element with its index in the original buffer.
// * @param [operation] function that takes the index of an element, current accumulator value
// * and the element itself and calculates the next accumulator value.
// */
//inline fun ByteBuffer.reduceIndexed(operation: (index: Int, acc: Byte, Byte) -> Byte): Byte {
//    if (isEmpty())
//        throw UnsupportedOperationException("Empty buffer can't be reduced.")
//    var accumulator = this[0]
//    for (index in 1..lastIndex) {
//        accumulator = operation(index, accumulator, this[index])
//    }
//    return accumulator
//}
//
///**
// * Accumulates value starting with the first element and applying [operation] from left to right
// * to current accumulator value and each element with its index in the original buffer.
// * @param [operation] function that takes the index of an element, current accumulator value
// * and the element itself and calculates the next accumulator value.
// */
//inline fun ShortBuffer.reduceIndexed(operation: (index: Int, acc: Short, Short) -> Short): Short {
//    if (isEmpty())
//        throw UnsupportedOperationException("Empty buffer can't be reduced.")
//    var accumulator = this[0]
//    for (index in 1..lastIndex) {
//        accumulator = operation(index, accumulator, this[index])
//    }
//    return accumulator
//}
//
///**
// * Accumulates value starting with the first element and applying [operation] from left to right
// * to current accumulator value and each element with its index in the original buffer.
// * @param [operation] function that takes the index of an element, current accumulator value
// * and the element itself and calculates the next accumulator value.
// */
//inline fun IntBuffer.reduceIndexed(operation: (index: Int, acc: Int, Int) -> Int): Int {
//    if (isEmpty())
//        throw UnsupportedOperationException("Empty buffer can't be reduced.")
//    var accumulator = this[0]
//    for (index in 1..lastIndex) {
//        accumulator = operation(index, accumulator, this[index])
//    }
//    return accumulator
//}
//
///**
// * Accumulates value starting with the first element and applying [operation] from left to right
// * to current accumulator value and each element with its index in the original buffer.
// * @param [operation] function that takes the index of an element, current accumulator value
// * and the element itself and calculates the next accumulator value.
// */
//inline fun LongBuffer.reduceIndexed(operation: (index: Int, acc: Long, Long) -> Long): Long {
//    if (isEmpty())
//        throw UnsupportedOperationException("Empty buffer can't be reduced.")
//    var accumulator = this[0]
//    for (index in 1..lastIndex) {
//        accumulator = operation(index, accumulator, this[index])
//    }
//    return accumulator
//}
//
///**
// * Accumulates value starting with the first element and applying [operation] from left to right
// * to current accumulator value and each element with its index in the original buffer.
// * @param [operation] function that takes the index of an element, current accumulator value
// * and the element itself and calculates the next accumulator value.
// */
//inline fun FloatBuffer.reduceIndexed(operation: (index: Int, acc: Float, Float) -> Float): Float {
//    if (isEmpty())
//        throw UnsupportedOperationException("Empty buffer can't be reduced.")
//    var accumulator = this[0]
//    for (index in 1..lastIndex) {
//        accumulator = operation(index, accumulator, this[index])
//    }
//    return accumulator
//}
//
///**
// * Accumulates value starting with the first element and applying [operation] from left to right
// * to current accumulator value and each element with its index in the original buffer.
// * @param [operation] function that takes the index of an element, current accumulator value
// * and the element itself and calculates the next accumulator value.
// */
//inline fun DoubleBuffer.reduceIndexed(operation: (index: Int, acc: Double, Double) -> Double): Double {
//    if (isEmpty())
//        throw UnsupportedOperationException("Empty buffer can't be reduced.")
//    var accumulator = this[0]
//    for (index in 1..lastIndex) {
//        accumulator = operation(index, accumulator, this[index])
//    }
//    return accumulator
//}
//
///**
// * Accumulates value starting with the first element and applying [operation] from left to right
// * to current accumulator value and each element with its index in the original buffer.
// * @param [operation] function that takes the index of an element, current accumulator value
// * and the element itself and calculates the next accumulator value.
// */
//inline fun DELETE.reduceIndexed(operation: (index: Int, acc: Boolean, Boolean) -> Boolean): Boolean {
//    if (isEmpty())
//        throw UnsupportedOperationException("Empty buffer can't be reduced.")
//    var accumulator = this[0]
//    for (index in 1..lastIndex) {
//        accumulator = operation(index, accumulator, this[index])
//    }
//    return accumulator
//}
//
///**
// * Accumulates value starting with the first element and applying [operation] from left to right
// * to current accumulator value and each element with its index in the original buffer.
// * @param [operation] function that takes the index of an element, current accumulator value
// * and the element itself and calculates the next accumulator value.
// */
//inline fun CharBuffer.reduceIndexed(operation: (index: Int, acc: Char, Char) -> Char): Char {
//    if (isEmpty())
//        throw UnsupportedOperationException("Empty buffer can't be reduced.")
//    var accumulator = this[0]
//    for (index in 1..lastIndex) {
//        accumulator = operation(index, accumulator, this[index])
//    }
//    return accumulator
//}
//
///**
// * Accumulates value starting with last element and applying [operation] from right to left to each element and current accumulator value.
// */
//inline fun <S, T : S> Array<out T>.reduceRight(operation: (T, acc: S) -> S): S {
//    var index = lastIndex
//    if (index < 0) throw UnsupportedOperationException("Empty buffer can't be reduced.")
//    var accumulator: S = get(index--)
//    while (index >= 0) {
//        accumulator = operation(get(index--), accumulator)
//    }
//    return accumulator
//}
//
///**
// * Accumulates value starting with last element and applying [operation] from right to left to each element and current accumulator value.
// */
//inline fun ByteBuffer.reduceRight(operation: (Byte, acc: Byte) -> Byte): Byte {
//    var index = lastIndex
//    if (index < 0) throw UnsupportedOperationException("Empty buffer can't be reduced.")
//    var accumulator = get(index--)
//    while (index >= 0) {
//        accumulator = operation(get(index--), accumulator)
//    }
//    return accumulator
//}
//
///**
// * Accumulates value starting with last element and applying [operation] from right to left to each element and current accumulator value.
// */
//inline fun ShortBuffer.reduceRight(operation: (Short, acc: Short) -> Short): Short {
//    var index = lastIndex
//    if (index < 0) throw UnsupportedOperationException("Empty buffer can't be reduced.")
//    var accumulator = get(index--)
//    while (index >= 0) {
//        accumulator = operation(get(index--), accumulator)
//    }
//    return accumulator
//}
//
///**
// * Accumulates value starting with last element and applying [operation] from right to left to each element and current accumulator value.
// */
//inline fun IntBuffer.reduceRight(operation: (Int, acc: Int) -> Int): Int {
//    var index = lastIndex
//    if (index < 0) throw UnsupportedOperationException("Empty buffer can't be reduced.")
//    var accumulator = get(index--)
//    while (index >= 0) {
//        accumulator = operation(get(index--), accumulator)
//    }
//    return accumulator
//}
//
///**
// * Accumulates value starting with last element and applying [operation] from right to left to each element and current accumulator value.
// */
//inline fun LongBuffer.reduceRight(operation: (Long, acc: Long) -> Long): Long {
//    var index = lastIndex
//    if (index < 0) throw UnsupportedOperationException("Empty buffer can't be reduced.")
//    var accumulator = get(index--)
//    while (index >= 0) {
//        accumulator = operation(get(index--), accumulator)
//    }
//    return accumulator
//}
//
///**
// * Accumulates value starting with last element and applying [operation] from right to left to each element and current accumulator value.
// */
//inline fun FloatBuffer.reduceRight(operation: (Float, acc: Float) -> Float): Float {
//    var index = lastIndex
//    if (index < 0) throw UnsupportedOperationException("Empty buffer can't be reduced.")
//    var accumulator = get(index--)
//    while (index >= 0) {
//        accumulator = operation(get(index--), accumulator)
//    }
//    return accumulator
//}
//
///**
// * Accumulates value starting with last element and applying [operation] from right to left to each element and current accumulator value.
// */
//inline fun DoubleBuffer.reduceRight(operation: (Double, acc: Double) -> Double): Double {
//    var index = lastIndex
//    if (index < 0) throw UnsupportedOperationException("Empty buffer can't be reduced.")
//    var accumulator = get(index--)
//    while (index >= 0) {
//        accumulator = operation(get(index--), accumulator)
//    }
//    return accumulator
//}
//
///**
// * Accumulates value starting with last element and applying [operation] from right to left to each element and current accumulator value.
// */
//inline fun DELETE.reduceRight(operation: (Boolean, acc: Boolean) -> Boolean): Boolean {
//    var index = lastIndex
//    if (index < 0) throw UnsupportedOperationException("Empty buffer can't be reduced.")
//    var accumulator = get(index--)
//    while (index >= 0) {
//        accumulator = operation(get(index--), accumulator)
//    }
//    return accumulator
//}
//
///**
// * Accumulates value starting with last element and applying [operation] from right to left to each element and current accumulator value.
// */
//inline fun CharBuffer.reduceRight(operation: (Char, acc: Char) -> Char): Char {
//    var index = lastIndex
//    if (index < 0) throw UnsupportedOperationException("Empty buffer can't be reduced.")
//    var accumulator = get(index--)
//    while (index >= 0) {
//        accumulator = operation(get(index--), accumulator)
//    }
//    return accumulator
//}
//
///**
// * Accumulates value starting with last element and applying [operation] from right to left
// * to each element with its index in the original buffer and current accumulator value.
// * @param [operation] function that takes the index of an element, the element itself
// * and current accumulator value, and calculates the next accumulator value.
// */
//inline fun <S, T : S> Array<out T>.reduceRightIndexed(operation: (index: Int, T, acc: S) -> S): S {
//    var index = lastIndex
//    if (index < 0) throw UnsupportedOperationException("Empty buffer can't be reduced.")
//    var accumulator: S = get(index--)
//    while (index >= 0) {
//        accumulator = operation(index, get(index), accumulator)
//        --index
//    }
//    return accumulator
//}
//
///**
// * Accumulates value starting with last element and applying [operation] from right to left
// * to each element with its index in the original buffer and current accumulator value.
// * @param [operation] function that takes the index of an element, the element itself
// * and current accumulator value, and calculates the next accumulator value.
// */
//inline fun ByteBuffer.reduceRightIndexed(operation: (index: Int, Byte, acc: Byte) -> Byte): Byte {
//    var index = lastIndex
//    if (index < 0) throw UnsupportedOperationException("Empty buffer can't be reduced.")
//    var accumulator = get(index--)
//    while (index >= 0) {
//        accumulator = operation(index, get(index), accumulator)
//        --index
//    }
//    return accumulator
//}
//
///**
// * Accumulates value starting with last element and applying [operation] from right to left
// * to each element with its index in the original buffer and current accumulator value.
// * @param [operation] function that takes the index of an element, the element itself
// * and current accumulator value, and calculates the next accumulator value.
// */
//inline fun ShortBuffer.reduceRightIndexed(operation: (index: Int, Short, acc: Short) -> Short): Short {
//    var index = lastIndex
//    if (index < 0) throw UnsupportedOperationException("Empty buffer can't be reduced.")
//    var accumulator = get(index--)
//    while (index >= 0) {
//        accumulator = operation(index, get(index), accumulator)
//        --index
//    }
//    return accumulator
//}
//
///**
// * Accumulates value starting with last element and applying [operation] from right to left
// * to each element with its index in the original buffer and current accumulator value.
// * @param [operation] function that takes the index of an element, the element itself
// * and current accumulator value, and calculates the next accumulator value.
// */
//inline fun IntBuffer.reduceRightIndexed(operation: (index: Int, Int, acc: Int) -> Int): Int {
//    var index = lastIndex
//    if (index < 0) throw UnsupportedOperationException("Empty buffer can't be reduced.")
//    var accumulator = get(index--)
//    while (index >= 0) {
//        accumulator = operation(index, get(index), accumulator)
//        --index
//    }
//    return accumulator
//}
//
///**
// * Accumulates value starting with last element and applying [operation] from right to left
// * to each element with its index in the original buffer and current accumulator value.
// * @param [operation] function that takes the index of an element, the element itself
// * and current accumulator value, and calculates the next accumulator value.
// */
//inline fun LongBuffer.reduceRightIndexed(operation: (index: Int, Long, acc: Long) -> Long): Long {
//    var index = lastIndex
//    if (index < 0) throw UnsupportedOperationException("Empty buffer can't be reduced.")
//    var accumulator = get(index--)
//    while (index >= 0) {
//        accumulator = operation(index, get(index), accumulator)
//        --index
//    }
//    return accumulator
//}
//
///**
// * Accumulates value starting with last element and applying [operation] from right to left
// * to each element with its index in the original buffer and current accumulator value.
// * @param [operation] function that takes the index of an element, the element itself
// * and current accumulator value, and calculates the next accumulator value.
// */
//inline fun FloatBuffer.reduceRightIndexed(operation: (index: Int, Float, acc: Float) -> Float): Float {
//    var index = lastIndex
//    if (index < 0) throw UnsupportedOperationException("Empty buffer can't be reduced.")
//    var accumulator = get(index--)
//    while (index >= 0) {
//        accumulator = operation(index, get(index), accumulator)
//        --index
//    }
//    return accumulator
//}
//
///**
// * Accumulates value starting with last element and applying [operation] from right to left
// * to each element with its index in the original buffer and current accumulator value.
// * @param [operation] function that takes the index of an element, the element itself
// * and current accumulator value, and calculates the next accumulator value.
// */
//inline fun DoubleBuffer.reduceRightIndexed(operation: (index: Int, Double, acc: Double) -> Double): Double {
//    var index = lastIndex
//    if (index < 0) throw UnsupportedOperationException("Empty buffer can't be reduced.")
//    var accumulator = get(index--)
//    while (index >= 0) {
//        accumulator = operation(index, get(index), accumulator)
//        --index
//    }
//    return accumulator
//}
//
///**
// * Accumulates value starting with last element and applying [operation] from right to left
// * to each element with its index in the original buffer and current accumulator value.
// * @param [operation] function that takes the index of an element, the element itself
// * and current accumulator value, and calculates the next accumulator value.
// */
//inline fun DELETE.reduceRightIndexed(operation: (index: Int, Boolean, acc: Boolean) -> Boolean): Boolean {
//    var index = lastIndex
//    if (index < 0) throw UnsupportedOperationException("Empty buffer can't be reduced.")
//    var accumulator = get(index--)
//    while (index >= 0) {
//        accumulator = operation(index, get(index), accumulator)
//        --index
//    }
//    return accumulator
//}
//
///**
// * Accumulates value starting with last element and applying [operation] from right to left
// * to each element with its index in the original buffer and current accumulator value.
// * @param [operation] function that takes the index of an element, the element itself
// * and current accumulator value, and calculates the next accumulator value.
// */
//inline fun CharBuffer.reduceRightIndexed(operation: (index: Int, Char, acc: Char) -> Char): Char {
//    var index = lastIndex
//    if (index < 0) throw UnsupportedOperationException("Empty buffer can't be reduced.")
//    var accumulator = get(index--)
//    while (index >= 0) {
//        accumulator = operation(index, get(index), accumulator)
//        --index
//    }
//    return accumulator
//}


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


///**
// * Returns the sum of all values produced by [selector] function applied to each element in the buffer.
// */
//inline fun <T> Array<out T>.sumByDouble(selector: (T) -> Double): Double {
//    var sum: Double = 0.0
//    for (element in this) {
//        sum += selector(element)
//    }
//    return sum
//}
//
///**
// * Returns the sum of all values produced by [selector] function applied to each element in the buffer.
// */
//inline fun ByteBuffer.sumByDouble(selector: (Byte) -> Double): Double {
//    var sum: Double = 0.0
//    for (element in this) {
//        sum += selector(element)
//    }
//    return sum
//}
//
///**
// * Returns the sum of all values produced by [selector] function applied to each element in the buffer.
// */
//inline fun ShortBuffer.sumByDouble(selector: (Short) -> Double): Double {
//    var sum: Double = 0.0
//    for (element in this) {
//        sum += selector(element)
//    }
//    return sum
//}
//
///**
// * Returns the sum of all values produced by [selector] function applied to each element in the buffer.
// */
//inline fun IntBuffer.sumByDouble(selector: (Int) -> Double): Double {
//    var sum: Double = 0.0
//    for (element in this) {
//        sum += selector(element)
//    }
//    return sum
//}
//
///**
// * Returns the sum of all values produced by [selector] function applied to each element in the buffer.
// */
//inline fun LongBuffer.sumByDouble(selector: (Long) -> Double): Double {
//    var sum: Double = 0.0
//    for (element in this) {
//        sum += selector(element)
//    }
//    return sum
//}
//
///**
// * Returns the sum of all values produced by [selector] function applied to each element in the buffer.
// */
//inline fun FloatBuffer.sumByDouble(selector: (Float) -> Double): Double {
//    var sum: Double = 0.0
//    for (element in this) {
//        sum += selector(element)
//    }
//    return sum
//}
//
///**
// * Returns the sum of all values produced by [selector] function applied to each element in the buffer.
// */
//inline fun DoubleBuffer.sumByDouble(selector: (Double) -> Double): Double {
//    var sum: Double = 0.0
//    for (element in this) {
//        sum += selector(element)
//    }
//    return sum
//}
//
///**
// * Returns the sum of all values produced by [selector] function applied to each element in the buffer.
// */
//inline fun DELETE.sumByDouble(selector: (Boolean) -> Double): Double {
//    var sum: Double = 0.0
//    for (element in this) {
//        sum += selector(element)
//    }
//    return sum
//}
//
///**
// * Returns the sum of all values produced by [selector] function applied to each element in the buffer.
// */
//inline fun CharBuffer.sumByDouble(selector: (Char) -> Double): Double {
//    var sum: Double = 0.0
//    for (element in this) {
//        sum += selector(element)
//    }
//    return sum
//}
//
///**
// * Returns an original collection containing all the non-`null` elements, throwing an [IllegalArgumentException] if there are any `null` elements.
// */
//fun <T : Any> Array<T?>.requireNoNulls(): Array<T> {
//    for (element in this) {
//        if (element == null) {
//            throw IllegalArgumentException("null element found in $this.")
//        }
//    }
//    @Suppress("UNCHECKED_CAST")
//    return this as Array<T>
//}
//
///**
// * Splits the original buffer into pair of lists,
// * where *first* list contains elements for which [predicate] yielded `true`,
// * while *second* list contains elements for which [predicate] yielded `false`.
// */
//inline fun <T> Array<out T>.partition(predicate: (T) -> Boolean): Pair<List<T>, List<T>> {
//    val first = ArrayList<T>()
//    val second = ArrayList<T>()
//    for (element in this) {
//        if (predicate(element)) {
//            first.add(element)
//        } else {
//            second.add(element)
//        }
//    }
//    return Pair(first, second)
//}
//
///**
// * Splits the original buffer into pair of lists,
// * where *first* list contains elements for which [predicate] yielded `true`,
// * while *second* list contains elements for which [predicate] yielded `false`.
// */
//inline fun ByteBuffer.partition(predicate: (Byte) -> Boolean): Pair<List<Byte>, List<Byte>> {
//    val first = ArrayList<Byte>()
//    val second = ArrayList<Byte>()
//    for (element in this) {
//        if (predicate(element)) {
//            first.add(element)
//        } else {
//            second.add(element)
//        }
//    }
//    return Pair(first, second)
//}
//
///**
// * Splits the original buffer into pair of lists,
// * where *first* list contains elements for which [predicate] yielded `true`,
// * while *second* list contains elements for which [predicate] yielded `false`.
// */
//inline fun ShortBuffer.partition(predicate: (Short) -> Boolean): Pair<List<Short>, List<Short>> {
//    val first = ArrayList<Short>()
//    val second = ArrayList<Short>()
//    for (element in this) {
//        if (predicate(element)) {
//            first.add(element)
//        } else {
//            second.add(element)
//        }
//    }
//    return Pair(first, second)
//}
//
///**
// * Splits the original buffer into pair of lists,
// * where *first* list contains elements for which [predicate] yielded `true`,
// * while *second* list contains elements for which [predicate] yielded `false`.
// */
//inline fun IntBuffer.partition(predicate: (Int) -> Boolean): Pair<List<Int>, List<Int>> {
//    val first = ArrayList<Int>()
//    val second = ArrayList<Int>()
//    for (element in this) {
//        if (predicate(element)) {
//            first.add(element)
//        } else {
//            second.add(element)
//        }
//    }
//    return Pair(first, second)
//}
//
///**
// * Splits the original buffer into pair of lists,
// * where *first* list contains elements for which [predicate] yielded `true`,
// * while *second* list contains elements for which [predicate] yielded `false`.
// */
//inline fun LongBuffer.partition(predicate: (Long) -> Boolean): Pair<List<Long>, List<Long>> {
//    val first = ArrayList<Long>()
//    val second = ArrayList<Long>()
//    for (element in this) {
//        if (predicate(element)) {
//            first.add(element)
//        } else {
//            second.add(element)
//        }
//    }
//    return Pair(first, second)
//}
//
///**
// * Splits the original buffer into pair of lists,
// * where *first* list contains elements for which [predicate] yielded `true`,
// * while *second* list contains elements for which [predicate] yielded `false`.
// */
//inline fun FloatBuffer.partition(predicate: (Float) -> Boolean): Pair<List<Float>, List<Float>> {
//    val first = ArrayList<Float>()
//    val second = ArrayList<Float>()
//    for (element in this) {
//        if (predicate(element)) {
//            first.add(element)
//        } else {
//            second.add(element)
//        }
//    }
//    return Pair(first, second)
//}
//
///**
// * Splits the original buffer into pair of lists,
// * where *first* list contains elements for which [predicate] yielded `true`,
// * while *second* list contains elements for which [predicate] yielded `false`.
// */
//inline fun DoubleBuffer.partition(predicate: (Double) -> Boolean): Pair<List<Double>, List<Double>> {
//    val first = ArrayList<Double>()
//    val second = ArrayList<Double>()
//    for (element in this) {
//        if (predicate(element)) {
//            first.add(element)
//        } else {
//            second.add(element)
//        }
//    }
//    return Pair(first, second)
//}
//
///**
// * Splits the original buffer into pair of lists,
// * where *first* list contains elements for which [predicate] yielded `true`,
// * while *second* list contains elements for which [predicate] yielded `false`.
// */
//inline fun DELETE.partition(predicate: (Boolean) -> Boolean): Pair<List<Boolean>, List<Boolean>> {
//    val first = ArrayList<Boolean>()
//    val second = ArrayList<Boolean>()
//    for (element in this) {
//        if (predicate(element)) {
//            first.add(element)
//        } else {
//            second.add(element)
//        }
//    }
//    return Pair(first, second)
//}
//
///**
// * Splits the original buffer into pair of lists,
// * where *first* list contains elements for which [predicate] yielded `true`,
// * while *second* list contains elements for which [predicate] yielded `false`.
// */
//inline fun CharBuffer.partition(predicate: (Char) -> Boolean): Pair<List<Char>, List<Char>> {
//    val first = ArrayList<Char>()
//    val second = ArrayList<Char>()
//    for (element in this) {
//        if (predicate(element)) {
//            first.add(element)
//        } else {
//            second.add(element)
//        }
//    }
//    return Pair(first, second)
//}
//
///**
// * Returns a list of pairs built from elements of both collections with same indexes. List has length of shortest collection.
// */
//infix fun <T, R> Array<out T>.zip(other: Array<out R>): List<Pair<T, R>> {
//    return zip(other) { t1, t2 -> t1 to t2 }
//}
//
///**
// * Returns a list of pairs built from elements of both collections with same indexes. List has length of shortest collection.
// */
//infix fun <R> ByteBuffer.zip(other: Array<out R>): List<Pair<Byte, R>> {
//    return zip(other) { t1, t2 -> t1 to t2 }
//}
//
///**
// * Returns a list of pairs built from elements of both collections with same indexes. List has length of shortest collection.
// */
//infix fun <R> ShortBuffer.zip(other: Array<out R>): List<Pair<Short, R>> {
//    return zip(other) { t1, t2 -> t1 to t2 }
//}
//
///**
// * Returns a list of pairs built from elements of both collections with same indexes. List has length of shortest collection.
// */
//infix fun <R> IntBuffer.zip(other: Array<out R>): List<Pair<Int, R>> {
//    return zip(other) { t1, t2 -> t1 to t2 }
//}
//
///**
// * Returns a list of pairs built from elements of both collections with same indexes. List has length of shortest collection.
// */
//infix fun <R> LongBuffer.zip(other: Array<out R>): List<Pair<Long, R>> {
//    return zip(other) { t1, t2 -> t1 to t2 }
//}
//
///**
// * Returns a list of pairs built from elements of both collections with same indexes. List has length of shortest collection.
// */
//infix fun <R> FloatBuffer.zip(other: Array<out R>): List<Pair<Float, R>> {
//    return zip(other) { t1, t2 -> t1 to t2 }
//}
//
///**
// * Returns a list of pairs built from elements of both collections with same indexes. List has length of shortest collection.
// */
//infix fun <R> DoubleBuffer.zip(other: Array<out R>): List<Pair<Double, R>> {
//    return zip(other) { t1, t2 -> t1 to t2 }
//}
//
///**
// * Returns a list of pairs built from elements of both collections with same indexes. List has length of shortest collection.
// */
//infix fun <R> DELETE.zip(other: Array<out R>): List<Pair<Boolean, R>> {
//    return zip(other) { t1, t2 -> t1 to t2 }
//}
//
///**
// * Returns a list of pairs built from elements of both collections with same indexes. List has length of shortest collection.
// */
//infix fun <R> CharBuffer.zip(other: Array<out R>): List<Pair<Char, R>> {
//    return zip(other) { t1, t2 -> t1 to t2 }
//}
//
///**
// * Returns a list of values built from elements of both collections with same indexes using provided [transform]. List has length of shortest collection.
// */
//inline fun <T, R, V> Array<out T>.zip(other: Array<out R>, transform: (a: T, b: R) -> V): List<V> {
//    val size = minOf(size, other.size)
//    val list = ArrayList<V>(size)
//    for (i in 0 until size) {
//        list.add(transform(this[i], other[i]))
//    }
//    return list
//}
//
///**
// * Returns a list of values built from elements of both collections with same indexes using provided [transform]. List has length of shortest collection.
// */
//inline fun <R, V> ByteBuffer.zip(other: Array<out R>, transform: (a: Byte, b: R) -> V): List<V> {
//    val size = minOf(size, other.size)
//    val list = ArrayList<V>(size)
//    for (i in 0 until size) {
//        list.add(transform(this[i], other[i]))
//    }
//    return list
//}
//
///**
// * Returns a list of values built from elements of both collections with same indexes using provided [transform]. List has length of shortest collection.
// */
//inline fun <R, V> ShortBuffer.zip(other: Array<out R>, transform: (a: Short, b: R) -> V): List<V> {
//    val size = minOf(size, other.size)
//    val list = ArrayList<V>(size)
//    for (i in 0 until size) {
//        list.add(transform(this[i], other[i]))
//    }
//    return list
//}
//
///**
// * Returns a list of values built from elements of both collections with same indexes using provided [transform]. List has length of shortest collection.
// */
//inline fun <R, V> IntBuffer.zip(other: Array<out R>, transform: (a: Int, b: R) -> V): List<V> {
//    val size = minOf(size, other.size)
//    val list = ArrayList<V>(size)
//    for (i in 0 until size) {
//        list.add(transform(this[i], other[i]))
//    }
//    return list
//}
//
///**
// * Returns a list of values built from elements of both collections with same indexes using provided [transform]. List has length of shortest collection.
// */
//inline fun <R, V> LongBuffer.zip(other: Array<out R>, transform: (a: Long, b: R) -> V): List<V> {
//    val size = minOf(size, other.size)
//    val list = ArrayList<V>(size)
//    for (i in 0 until size) {
//        list.add(transform(this[i], other[i]))
//    }
//    return list
//}
//
///**
// * Returns a list of values built from elements of both collections with same indexes using provided [transform]. List has length of shortest collection.
// */
//inline fun <R, V> FloatBuffer.zip(other: Array<out R>, transform: (a: Float, b: R) -> V): List<V> {
//    val size = minOf(size, other.size)
//    val list = ArrayList<V>(size)
//    for (i in 0 until size) {
//        list.add(transform(this[i], other[i]))
//    }
//    return list
//}
//
///**
// * Returns a list of values built from elements of both collections with same indexes using provided [transform]. List has length of shortest collection.
// */
//inline fun <R, V> DoubleBuffer.zip(other: Array<out R>, transform: (a: Double, b: R) -> V): List<V> {
//    val size = minOf(size, other.size)
//    val list = ArrayList<V>(size)
//    for (i in 0 until size) {
//        list.add(transform(this[i], other[i]))
//    }
//    return list
//}
//
///**
// * Returns a list of values built from elements of both collections with same indexes using provided [transform]. List has length of shortest collection.
// */
//inline fun <R, V> DELETE.zip(other: Array<out R>, transform: (a: Boolean, b: R) -> V): List<V> {
//    val size = minOf(size, other.size)
//    val list = ArrayList<V>(size)
//    for (i in 0 until size) {
//        list.add(transform(this[i], other[i]))
//    }
//    return list
//}
//
///**
// * Returns a list of values built from elements of both collections with same indexes using provided [transform]. List has length of shortest collection.
// */
//inline fun <R, V> CharBuffer.zip(other: Array<out R>, transform: (a: Char, b: R) -> V): List<V> {
//    val size = minOf(size, other.size)
//    val list = ArrayList<V>(size)
//    for (i in 0 until size) {
//        list.add(transform(this[i], other[i]))
//    }
//    return list
//}
//
///**
// * Returns a list of pairs built from elements of both collections with same indexes. List has length of shortest collection.
// */
//infix fun <T, R> Array<out T>.zip(other: Iterable<R>): List<Pair<T, R>> {
//    return zip(other) { t1, t2 -> t1 to t2 }
//}
//
///**
// * Returns a list of pairs built from elements of both collections with same indexes. List has length of shortest collection.
// */
//infix fun <R> ByteBuffer.zip(other: Iterable<R>): List<Pair<Byte, R>> {
//    return zip(other) { t1, t2 -> t1 to t2 }
//}
//
///**
// * Returns a list of pairs built from elements of both collections with same indexes. List has length of shortest collection.
// */
//infix fun <R> ShortBuffer.zip(other: Iterable<R>): List<Pair<Short, R>> {
//    return zip(other) { t1, t2 -> t1 to t2 }
//}
//
///**
// * Returns a list of pairs built from elements of both collections with same indexes. List has length of shortest collection.
// */
//infix fun <R> IntBuffer.zip(other: Iterable<R>): List<Pair<Int, R>> {
//    return zip(other) { t1, t2 -> t1 to t2 }
//}
//
///**
// * Returns a list of pairs built from elements of both collections with same indexes. List has length of shortest collection.
// */
//infix fun <R> LongBuffer.zip(other: Iterable<R>): List<Pair<Long, R>> {
//    return zip(other) { t1, t2 -> t1 to t2 }
//}
//
///**
// * Returns a list of pairs built from elements of both collections with same indexes. List has length of shortest collection.
// */
//infix fun <R> FloatBuffer.zip(other: Iterable<R>): List<Pair<Float, R>> {
//    return zip(other) { t1, t2 -> t1 to t2 }
//}
//
///**
// * Returns a list of pairs built from elements of both collections with same indexes. List has length of shortest collection.
// */
//infix fun <R> DoubleBuffer.zip(other: Iterable<R>): List<Pair<Double, R>> {
//    return zip(other) { t1, t2 -> t1 to t2 }
//}
//
///**
// * Returns a list of pairs built from elements of both collections with same indexes. List has length of shortest collection.
// */
//infix fun <R> DELETE.zip(other: Iterable<R>): List<Pair<Boolean, R>> {
//    return zip(other) { t1, t2 -> t1 to t2 }
//}
//
///**
// * Returns a list of pairs built from elements of both collections with same indexes. List has length of shortest collection.
// */
//infix fun <R> CharBuffer.zip(other: Iterable<R>): List<Pair<Char, R>> {
//    return zip(other) { t1, t2 -> t1 to t2 }
//}
//
///**
// * Returns a list of values built from elements of both collections with same indexes using provided [transform]. List has length of shortest collection.
// */
//inline fun <T, R, V> Array<out T>.zip(other: Iterable<R>, transform: (a: T, b: R) -> V): List<V> {
//    val bufferSize = size
//    val list = ArrayList<V>(minOf(other.collectionSizeOrDefault(10), bufferSize))
//    var i = 0
//    for (element in other) {
//        if (i >= bufferSize) break
//        list.add(transform(this[i++], element))
//    }
//    return list
//}
//
///**
// * Returns a list of values built from elements of both collections with same indexes using provided [transform]. List has length of shortest collection.
// */
//inline fun <R, V> ByteBuffer.zip(other: Iterable<R>, transform: (a: Byte, b: R) -> V): List<V> {
//    val bufferSize = size
//    val list = ArrayList<V>(minOf(other.collectionSizeOrDefault(10), bufferSize))
//    var i = 0
//    for (element in other) {
//        if (i >= bufferSize) break
//        list.add(transform(this[i++], element))
//    }
//    return list
//}
//
///**
// * Returns a list of values built from elements of both collections with same indexes using provided [transform]. List has length of shortest collection.
// */
//inline fun <R, V> ShortBuffer.zip(other: Iterable<R>, transform: (a: Short, b: R) -> V): List<V> {
//    val bufferSize = size
//    val list = ArrayList<V>(minOf(other.collectionSizeOrDefault(10), bufferSize))
//    var i = 0
//    for (element in other) {
//        if (i >= bufferSize) break
//        list.add(transform(this[i++], element))
//    }
//    return list
//}
//
///**
// * Returns a list of values built from elements of both collections with same indexes using provided [transform]. List has length of shortest collection.
// */
//inline fun <R, V> IntBuffer.zip(other: Iterable<R>, transform: (a: Int, b: R) -> V): List<V> {
//    val bufferSize = size
//    val list = ArrayList<V>(minOf(other.collectionSizeOrDefault(10), bufferSize))
//    var i = 0
//    for (element in other) {
//        if (i >= bufferSize) break
//        list.add(transform(this[i++], element))
//    }
//    return list
//}
//
///**
// * Returns a list of values built from elements of both collections with same indexes using provided [transform]. List has length of shortest collection.
// */
//inline fun <R, V> LongBuffer.zip(other: Iterable<R>, transform: (a: Long, b: R) -> V): List<V> {
//    val bufferSize = size
//    val list = ArrayList<V>(minOf(other.collectionSizeOrDefault(10), bufferSize))
//    var i = 0
//    for (element in other) {
//        if (i >= bufferSize) break
//        list.add(transform(this[i++], element))
//    }
//    return list
//}
//
///**
// * Returns a list of values built from elements of both collections with same indexes using provided [transform]. List has length of shortest collection.
// */
//inline fun <R, V> FloatBuffer.zip(other: Iterable<R>, transform: (a: Float, b: R) -> V): List<V> {
//    val bufferSize = size
//    val list = ArrayList<V>(minOf(other.collectionSizeOrDefault(10), bufferSize))
//    var i = 0
//    for (element in other) {
//        if (i >= bufferSize) break
//        list.add(transform(this[i++], element))
//    }
//    return list
//}
//
///**
// * Returns a list of values built from elements of both collections with same indexes using provided [transform]. List has length of shortest collection.
// */
//inline fun <R, V> DoubleBuffer.zip(other: Iterable<R>, transform: (a: Double, b: R) -> V): List<V> {
//    val bufferSize = size
//    val list = ArrayList<V>(minOf(other.collectionSizeOrDefault(10), bufferSize))
//    var i = 0
//    for (element in other) {
//        if (i >= bufferSize) break
//        list.add(transform(this[i++], element))
//    }
//    return list
//}
//
///**
// * Returns a list of values built from elements of both collections with same indexes using provided [transform]. List has length of shortest collection.
// */
//inline fun <R, V> DELETE.zip(other: Iterable<R>, transform: (a: Boolean, b: R) -> V): List<V> {
//    val bufferSize = size
//    val list = ArrayList<V>(minOf(other.collectionSizeOrDefault(10), bufferSize))
//    var i = 0
//    for (element in other) {
//        if (i >= bufferSize) break
//        list.add(transform(this[i++], element))
//    }
//    return list
//}
//
///**
// * Returns a list of values built from elements of both collections with same indexes using provided [transform]. List has length of shortest collection.
// */
//inline fun <R, V> CharBuffer.zip(other: Iterable<R>, transform: (a: Char, b: R) -> V): List<V> {
//    val bufferSize = size
//    val list = ArrayList<V>(minOf(other.collectionSizeOrDefault(10), bufferSize))
//    var i = 0
//    for (element in other) {
//        if (i >= bufferSize) break
//        list.add(transform(this[i++], element))
//    }
//    return list
//}
//
///**
// * Returns a list of pairs built from elements of both collections with same indexes. List has length of shortest collection.
// */
//infix fun ByteBuffer.zip(other: ByteBuffer): List<Pair<Byte, Byte>> {
//    return zip(other) { t1, t2 -> t1 to t2 }
//}
//
///**
// * Returns a list of pairs built from elements of both collections with same indexes. List has length of shortest collection.
// */
//infix fun ShortBuffer.zip(other: ShortBuffer): List<Pair<Short, Short>> {
//    return zip(other) { t1, t2 -> t1 to t2 }
//}
//
///**
// * Returns a list of pairs built from elements of both collections with same indexes. List has length of shortest collection.
// */
//infix fun IntBuffer.zip(other: IntBuffer): List<Pair<Int, Int>> {
//    return zip(other) { t1, t2 -> t1 to t2 }
//}
//
///**
// * Returns a list of pairs built from elements of both collections with same indexes. List has length of shortest collection.
// */
//infix fun LongBuffer.zip(other: LongBuffer): List<Pair<Long, Long>> {
//    return zip(other) { t1, t2 -> t1 to t2 }
//}
//
///**
// * Returns a list of pairs built from elements of both collections with same indexes. List has length of shortest collection.
// */
//infix fun FloatBuffer.zip(other: FloatBuffer): List<Pair<Float, Float>> {
//    return zip(other) { t1, t2 -> t1 to t2 }
//}
//
///**
// * Returns a list of pairs built from elements of both collections with same indexes. List has length of shortest collection.
// */
//infix fun DoubleBuffer.zip(other: DoubleBuffer): List<Pair<Double, Double>> {
//    return zip(other) { t1, t2 -> t1 to t2 }
//}
//
///**
// * Returns a list of pairs built from elements of both collections with same indexes. List has length of shortest collection.
// */
//infix fun DELETE.zip(other: DELETE): List<Pair<Boolean, Boolean>> {
//    return zip(other) { t1, t2 -> t1 to t2 }
//}
//
///**
// * Returns a list of pairs built from elements of both collections with same indexes. List has length of shortest collection.
// */
//infix fun CharBuffer.zip(other: CharBuffer): List<Pair<Char, Char>> {
//    return zip(other) { t1, t2 -> t1 to t2 }
//}
//
///**
// * Returns a list of values built from elements of both collections with same indexes using provided [transform]. List has length of shortest collection.
// */
//inline fun <V> ByteBuffer.zip(other: ByteBuffer, transform: (a: Byte, b: Byte) -> V): List<V> {
//    val size = minOf(size, other.size)
//    val list = ArrayList<V>(size)
//    for (i in 0 until size) {
//        list.add(transform(this[i], other[i]))
//    }
//    return list
//}
//
///**
// * Returns a list of values built from elements of both collections with same indexes using provided [transform]. List has length of shortest collection.
// */
//inline fun <V> ShortBuffer.zip(other: ShortBuffer, transform: (a: Short, b: Short) -> V): List<V> {
//    val size = minOf(size, other.size)
//    val list = ArrayList<V>(size)
//    for (i in 0 until size) {
//        list.add(transform(this[i], other[i]))
//    }
//    return list
//}
//
///**
// * Returns a list of values built from elements of both collections with same indexes using provided [transform]. List has length of shortest collection.
// */
//inline fun <V> IntBuffer.zip(other: IntBuffer, transform: (a: Int, b: Int) -> V): List<V> {
//    val size = minOf(size, other.size)
//    val list = ArrayList<V>(size)
//    for (i in 0 until size) {
//        list.add(transform(this[i], other[i]))
//    }
//    return list
//}
//
///**
// * Returns a list of values built from elements of both collections with same indexes using provided [transform]. List has length of shortest collection.
// */
//inline fun <V> LongBuffer.zip(other: LongBuffer, transform: (a: Long, b: Long) -> V): List<V> {
//    val size = minOf(size, other.size)
//    val list = ArrayList<V>(size)
//    for (i in 0 until size) {
//        list.add(transform(this[i], other[i]))
//    }
//    return list
//}
//
///**
// * Returns a list of values built from elements of both collections with same indexes using provided [transform]. List has length of shortest collection.
// */
//inline fun <V> FloatBuffer.zip(other: FloatBuffer, transform: (a: Float, b: Float) -> V): List<V> {
//    val size = minOf(size, other.size)
//    val list = ArrayList<V>(size)
//    for (i in 0 until size) {
//        list.add(transform(this[i], other[i]))
//    }
//    return list
//}
//
///**
// * Returns a list of values built from elements of both collections with same indexes using provided [transform]. List has length of shortest collection.
// */
//inline fun <V> DoubleBuffer.zip(other: DoubleBuffer, transform: (a: Double, b: Double) -> V): List<V> {
//    val size = minOf(size, other.size)
//    val list = ArrayList<V>(size)
//    for (i in 0 until size) {
//        list.add(transform(this[i], other[i]))
//    }
//    return list
//}
//
///**
// * Returns a list of values built from elements of both collections with same indexes using provided [transform]. List has length of shortest collection.
// */
//inline fun <V> DELETE.zip(other: DELETE, transform: (a: Boolean, b: Boolean) -> V): List<V> {
//    val size = minOf(size, other.size)
//    val list = ArrayList<V>(size)
//    for (i in 0 until size) {
//        list.add(transform(this[i], other[i]))
//    }
//    return list
//}
//
///**
// * Returns a list of values built from elements of both collections with same indexes using provided [transform]. List has length of shortest collection.
// */
//inline fun <V> CharBuffer.zip(other: CharBuffer, transform: (a: Char, b: Char) -> V): List<V> {
//    val size = minOf(size, other.size)
//    val list = ArrayList<V>(size)
//    for (i in 0 until size) {
//        list.add(transform(this[i], other[i]))
//    }
//    return list
//}
//
///**
// * Appends the string from all the elements separated using [separator] and using the given [prefix] and [postfix] if supplied.
// *
// * If the collection could be huge, you can specify a non-negative value of [limit], in which case only the first [limit]
// * elements will be appended, followed by the [truncated] string (which defaults to "...").
// */
//fun <T, A : Appendable> Array<out T>.joinTo(buffer: A, separator: CharSequence = ", ", prefix: CharSequence = "", postfix: CharSequence = "", limit: Int = -1, truncated: CharSequence = "...", transform: ((T) -> CharSequence)? = null): A {
//    buffer.append(prefix)
//    var count = 0
//    for (element in this) {
//        if (++count > 1) buffer.append(separator)
//        if (limit < 0 || count <= limit) {
//            buffer.appendElement(element, transform)
//        } else break
//    }
//    if (limit >= 0 && count > limit) buffer.append(truncated)
//    buffer.append(postfix)
//    return buffer
//}
//
///**
// * Appends the string from all the elements separated using [separator] and using the given [prefix] and [postfix] if supplied.
// *
// * If the collection could be huge, you can specify a non-negative value of [limit], in which case only the first [limit]
// * elements will be appended, followed by the [truncated] string (which defaults to "...").
// */
//fun <A : Appendable> ByteBuffer.joinTo(buffer: A, separator: CharSequence = ", ", prefix: CharSequence = "", postfix: CharSequence = "", limit: Int = -1, truncated: CharSequence = "...", transform: ((Byte) -> CharSequence)? = null): A {
//    buffer.append(prefix)
//    var count = 0
//    for (element in this) {
//        if (++count > 1) buffer.append(separator)
//        if (limit < 0 || count <= limit) {
//            if (transform != null)
//                buffer.append(transform(element))
//            else
//                buffer.append(element.toString())
//        } else break
//    }
//    if (limit >= 0 && count > limit) buffer.append(truncated)
//    buffer.append(postfix)
//    return buffer
//}
//
///**
// * Appends the string from all the elements separated using [separator] and using the given [prefix] and [postfix] if supplied.
// *
// * If the collection could be huge, you can specify a non-negative value of [limit], in which case only the first [limit]
// * elements will be appended, followed by the [truncated] string (which defaults to "...").
// */
//fun <A : Appendable> ShortBuffer.joinTo(buffer: A, separator: CharSequence = ", ", prefix: CharSequence = "", postfix: CharSequence = "", limit: Int = -1, truncated: CharSequence = "...", transform: ((Short) -> CharSequence)? = null): A {
//    buffer.append(prefix)
//    var count = 0
//    for (element in this) {
//        if (++count > 1) buffer.append(separator)
//        if (limit < 0 || count <= limit) {
//            if (transform != null)
//                buffer.append(transform(element))
//            else
//                buffer.append(element.toString())
//        } else break
//    }
//    if (limit >= 0 && count > limit) buffer.append(truncated)
//    buffer.append(postfix)
//    return buffer
//}
//
///**
// * Appends the string from all the elements separated using [separator] and using the given [prefix] and [postfix] if supplied.
// *
// * If the collection could be huge, you can specify a non-negative value of [limit], in which case only the first [limit]
// * elements will be appended, followed by the [truncated] string (which defaults to "...").
// */
//fun <A : Appendable> IntBuffer.joinTo(buffer: A, separator: CharSequence = ", ", prefix: CharSequence = "", postfix: CharSequence = "", limit: Int = -1, truncated: CharSequence = "...", transform: ((Int) -> CharSequence)? = null): A {
//    buffer.append(prefix)
//    var count = 0
//    for (element in this) {
//        if (++count > 1) buffer.append(separator)
//        if (limit < 0 || count <= limit) {
//            if (transform != null)
//                buffer.append(transform(element))
//            else
//                buffer.append(element.toString())
//        } else break
//    }
//    if (limit >= 0 && count > limit) buffer.append(truncated)
//    buffer.append(postfix)
//    return buffer
//}
//
///**
// * Appends the string from all the elements separated using [separator] and using the given [prefix] and [postfix] if supplied.
// *
// * If the collection could be huge, you can specify a non-negative value of [limit], in which case only the first [limit]
// * elements will be appended, followed by the [truncated] string (which defaults to "...").
// */
//fun <A : Appendable> LongBuffer.joinTo(buffer: A, separator: CharSequence = ", ", prefix: CharSequence = "", postfix: CharSequence = "", limit: Int = -1, truncated: CharSequence = "...", transform: ((Long) -> CharSequence)? = null): A {
//    buffer.append(prefix)
//    var count = 0
//    for (element in this) {
//        if (++count > 1) buffer.append(separator)
//        if (limit < 0 || count <= limit) {
//            if (transform != null)
//                buffer.append(transform(element))
//            else
//                buffer.append(element.toString())
//        } else break
//    }
//    if (limit >= 0 && count > limit) buffer.append(truncated)
//    buffer.append(postfix)
//    return buffer
//}
//
///**
// * Appends the string from all the elements separated using [separator] and using the given [prefix] and [postfix] if supplied.
// *
// * If the collection could be huge, you can specify a non-negative value of [limit], in which case only the first [limit]
// * elements will be appended, followed by the [truncated] string (which defaults to "...").
// */
//fun <A : Appendable> FloatBuffer.joinTo(buffer: A, separator: CharSequence = ", ", prefix: CharSequence = "", postfix: CharSequence = "", limit: Int = -1, truncated: CharSequence = "...", transform: ((Float) -> CharSequence)? = null): A {
//    buffer.append(prefix)
//    var count = 0
//    for (element in this) {
//        if (++count > 1) buffer.append(separator)
//        if (limit < 0 || count <= limit) {
//            if (transform != null)
//                buffer.append(transform(element))
//            else
//                buffer.append(element.toString())
//        } else break
//    }
//    if (limit >= 0 && count > limit) buffer.append(truncated)
//    buffer.append(postfix)
//    return buffer
//}
//
///**
// * Appends the string from all the elements separated using [separator] and using the given [prefix] and [postfix] if supplied.
// *
// * If the collection could be huge, you can specify a non-negative value of [limit], in which case only the first [limit]
// * elements will be appended, followed by the [truncated] string (which defaults to "...").
// */
//fun <A : Appendable> DoubleBuffer.joinTo(buffer: A, separator: CharSequence = ", ", prefix: CharSequence = "", postfix: CharSequence = "", limit: Int = -1, truncated: CharSequence = "...", transform: ((Double) -> CharSequence)? = null): A {
//    buffer.append(prefix)
//    var count = 0
//    for (element in this) {
//        if (++count > 1) buffer.append(separator)
//        if (limit < 0 || count <= limit) {
//            if (transform != null)
//                buffer.append(transform(element))
//            else
//                buffer.append(element.toString())
//        } else break
//    }
//    if (limit >= 0 && count > limit) buffer.append(truncated)
//    buffer.append(postfix)
//    return buffer
//}
//
///**
// * Appends the string from all the elements separated using [separator] and using the given [prefix] and [postfix] if supplied.
// *
// * If the collection could be huge, you can specify a non-negative value of [limit], in which case only the first [limit]
// * elements will be appended, followed by the [truncated] string (which defaults to "...").
// */
//fun <A : Appendable> DELETE.joinTo(buffer: A, separator: CharSequence = ", ", prefix: CharSequence = "", postfix: CharSequence = "", limit: Int = -1, truncated: CharSequence = "...", transform: ((Boolean) -> CharSequence)? = null): A {
//    buffer.append(prefix)
//    var count = 0
//    for (element in this) {
//        if (++count > 1) buffer.append(separator)
//        if (limit < 0 || count <= limit) {
//            if (transform != null)
//                buffer.append(transform(element))
//            else
//                buffer.append(element.toString())
//        } else break
//    }
//    if (limit >= 0 && count > limit) buffer.append(truncated)
//    buffer.append(postfix)
//    return buffer
//}
//
///**
// * Appends the string from all the elements separated using [separator] and using the given [prefix] and [postfix] if supplied.
// *
// * If the collection could be huge, you can specify a non-negative value of [limit], in which case only the first [limit]
// * elements will be appended, followed by the [truncated] string (which defaults to "...").
// */
//fun <A : Appendable> CharBuffer.joinTo(buffer: A, separator: CharSequence = ", ", prefix: CharSequence = "", postfix: CharSequence = "", limit: Int = -1, truncated: CharSequence = "...", transform: ((Char) -> CharSequence)? = null): A {
//    buffer.append(prefix)
//    var count = 0
//    for (element in this) {
//        if (++count > 1) buffer.append(separator)
//        if (limit < 0 || count <= limit) {
//            if (transform != null)
//                buffer.append(transform(element))
//            else
//                buffer.append(element)
//        } else break
//    }
//    if (limit >= 0 && count > limit) buffer.append(truncated)
//    buffer.append(postfix)
//    return buffer
//}
//
///**
// * Creates a string from all the elements separated using [separator] and using the given [prefix] and [postfix] if supplied.
// *
// * If the collection could be huge, you can specify a non-negative value of [limit], in which case only the first [limit]
// * elements will be appended, followed by the [truncated] string (which defaults to "...").
// */
//fun <T> Array<out T>.joinToString(separator: CharSequence = ", ", prefix: CharSequence = "", postfix: CharSequence = "", limit: Int = -1, truncated: CharSequence = "...", transform: ((T) -> CharSequence)? = null): String {
//    return joinTo(StringBuilder(), separator, prefix, postfix, limit, truncated, transform).toString()
//}
//
///**
// * Creates a string from all the elements separated using [separator] and using the given [prefix] and [postfix] if supplied.
// *
// * If the collection could be huge, you can specify a non-negative value of [limit], in which case only the first [limit]
// * elements will be appended, followed by the [truncated] string (which defaults to "...").
// */
//fun ByteBuffer.joinToString(separator: CharSequence = ", ", prefix: CharSequence = "", postfix: CharSequence = "", limit: Int = -1, truncated: CharSequence = "...", transform: ((Byte) -> CharSequence)? = null): String {
//    return joinTo(StringBuilder(), separator, prefix, postfix, limit, truncated, transform).toString()
//}
//
///**
// * Creates a string from all the elements separated using [separator] and using the given [prefix] and [postfix] if supplied.
// *
// * If the collection could be huge, you can specify a non-negative value of [limit], in which case only the first [limit]
// * elements will be appended, followed by the [truncated] string (which defaults to "...").
// */
//fun ShortBuffer.joinToString(separator: CharSequence = ", ", prefix: CharSequence = "", postfix: CharSequence = "", limit: Int = -1, truncated: CharSequence = "...", transform: ((Short) -> CharSequence)? = null): String {
//    return joinTo(StringBuilder(), separator, prefix, postfix, limit, truncated, transform).toString()
//}
//
///**
// * Creates a string from all the elements separated using [separator] and using the given [prefix] and [postfix] if supplied.
// *
// * If the collection could be huge, you can specify a non-negative value of [limit], in which case only the first [limit]
// * elements will be appended, followed by the [truncated] string (which defaults to "...").
// */
//fun IntBuffer.joinToString(separator: CharSequence = ", ", prefix: CharSequence = "", postfix: CharSequence = "", limit: Int = -1, truncated: CharSequence = "...", transform: ((Int) -> CharSequence)? = null): String {
//    return joinTo(StringBuilder(), separator, prefix, postfix, limit, truncated, transform).toString()
//}
//
///**
// * Creates a string from all the elements separated using [separator] and using the given [prefix] and [postfix] if supplied.
// *
// * If the collection could be huge, you can specify a non-negative value of [limit], in which case only the first [limit]
// * elements will be appended, followed by the [truncated] string (which defaults to "...").
// */
//fun LongBuffer.joinToString(separator: CharSequence = ", ", prefix: CharSequence = "", postfix: CharSequence = "", limit: Int = -1, truncated: CharSequence = "...", transform: ((Long) -> CharSequence)? = null): String {
//    return joinTo(StringBuilder(), separator, prefix, postfix, limit, truncated, transform).toString()
//}
//
///**
// * Creates a string from all the elements separated using [separator] and using the given [prefix] and [postfix] if supplied.
// *
// * If the collection could be huge, you can specify a non-negative value of [limit], in which case only the first [limit]
// * elements will be appended, followed by the [truncated] string (which defaults to "...").
// */
//fun FloatBuffer.joinToString(separator: CharSequence = ", ", prefix: CharSequence = "", postfix: CharSequence = "", limit: Int = -1, truncated: CharSequence = "...", transform: ((Float) -> CharSequence)? = null): String {
//    return joinTo(StringBuilder(), separator, prefix, postfix, limit, truncated, transform).toString()
//}
//
///**
// * Creates a string from all the elements separated using [separator] and using the given [prefix] and [postfix] if supplied.
// *
// * If the collection could be huge, you can specify a non-negative value of [limit], in which case only the first [limit]
// * elements will be appended, followed by the [truncated] string (which defaults to "...").
// */
//fun DoubleBuffer.joinToString(separator: CharSequence = ", ", prefix: CharSequence = "", postfix: CharSequence = "", limit: Int = -1, truncated: CharSequence = "...", transform: ((Double) -> CharSequence)? = null): String {
//    return joinTo(StringBuilder(), separator, prefix, postfix, limit, truncated, transform).toString()
//}
//
///**
// * Creates a string from all the elements separated using [separator] and using the given [prefix] and [postfix] if supplied.
// *
// * If the collection could be huge, you can specify a non-negative value of [limit], in which case only the first [limit]
// * elements will be appended, followed by the [truncated] string (which defaults to "...").
// */
//fun DELETE.joinToString(separator: CharSequence = ", ", prefix: CharSequence = "", postfix: CharSequence = "", limit: Int = -1, truncated: CharSequence = "...", transform: ((Boolean) -> CharSequence)? = null): String {
//    return joinTo(StringBuilder(), separator, prefix, postfix, limit, truncated, transform).toString()
//}
//
///**
// * Creates a string from all the elements separated using [separator] and using the given [prefix] and [postfix] if supplied.
// *
// * If the collection could be huge, you can specify a non-negative value of [limit], in which case only the first [limit]
// * elements will be appended, followed by the [truncated] string (which defaults to "...").
// */
//fun CharBuffer.joinToString(separator: CharSequence = ", ", prefix: CharSequence = "", postfix: CharSequence = "", limit: Int = -1, truncated: CharSequence = "...", transform: ((Char) -> CharSequence)? = null): String {
//    return joinTo(StringBuilder(), separator, prefix, postfix, limit, truncated, transform).toString()
//}


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
 *  @sample samples.collections.Sequences.Building.sequenceFromArray */
fun ByteBuffer.asSequence(): Sequence<Byte> {
    if (isEmpty()) return emptySequence()
    return Sequence { iterator() }
}

/** Creates a [Sequence] instance that wraps the original buffer returning its elements when being iterated.
 *  @sample samples.collections.Sequences.Building.sequenceFromArray */
fun ShortBuffer.asSequence(): Sequence<Short> {
    if (isEmpty()) return emptySequence()
    return Sequence { iterator() }
}

/** Creates a [Sequence] instance that wraps the original buffer returning its elements when being iterated.
 *  @sample samples.collections.Sequences.Building.sequenceFromArray */
fun IntBuffer.asSequence(): Sequence<Int> {
    if (isEmpty()) return emptySequence()
    return Sequence { iterator() }
}

/** Creates a [Sequence] instance that wraps the original buffer returning its elements when being iterated.
 *  @sample samples.collections.Sequences.Building.sequenceFromArray */
fun LongBuffer.asSequence(): Sequence<Long> {
    if (isEmpty()) return emptySequence()
    return Sequence { iterator() }
}

/** Creates a [Sequence] instance that wraps the original buffer returning its elements when being iterated.
 *  @sample samples.collections.Sequences.Building.sequenceFromArray */
fun FloatBuffer.asSequence(): Sequence<Float> {
    if (isEmpty()) return emptySequence()
    return Sequence { iterator() }
}

/** Creates a [Sequence] instance that wraps the original buffer returning its elements when being iterated.
 *  @sample samples.collections.Sequences.Building.sequenceFromArray */
fun DoubleBuffer.asSequence(): Sequence<Double> {
    if (isEmpty()) return emptySequence()
    return Sequence { iterator() }
}

/** Creates a [Sequence] instance that wraps the original buffer returning its elements when being iterated.
 *  @sample samples.collections.Sequences.Building.sequenceFromArray */
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