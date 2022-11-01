package kool

import kool.gen.Generator
import kool.gen.generate
import java.io.File

fun buffersJvm(target: File) {

    generate(target, "kool/buffersJvm.kt") {

        `package` = "kool"

        suppressInlineWarning = true
        experimentals += Generator.Experimentals.TypeInference
        experimentals += Generator.Experimentals.UnsignedTypes

        imports += listOf(
            "kool.rem",
            "kool.set",
            "kool.iterator",
            "kool.lib.collectionSizeOrDefault",
            "kool.lib.mapCapacity",
                         )

        for (type in types)
            bufferJvm(type, Generator.Part.TopLevel)
    }
}

fun Generator.bufferJvm(type: String, part: Generator.Part) {

    val TypeBuffer = "${type}Buffer"
    val TypeArray = "${type}Array"

    imports += when (type[0]) {
        'U' -> "kool.ubuffers.$TypeBuffer"
        'P' -> "org.lwjgl.PointerBuffer"
        else -> "java.nio.$TypeBuffer"
    }
    if (part == Generator.Part.Class)
        imports += listOf(
            "kool.isEmpty",
            "kool.lastIndex",
            "kool.forEachIndexed",
            )

    val type = if (type == "Pointer") "Ptr" else type

    if (part == Generator.Part.TopLevel) {

        for (n in listOf("1st", "2nd", "3rd", "4th", "5th")) {
            val x = n[0]
            docs("""
            Returns $n *element* from the buffer.
            
            If the size of this array is less than $x, throws an [IndexOutOfBoundsException]""")
            +"inline operator fun $TypeBuffer.component$x(): $type = get(${x - '1'})"
        }

        docs("Returns `true` if [element] is found in the array.")
        +"operator fun $TypeBuffer.contains(element: $type): Boolean = indexOf(element) >= 0"

        docs("Returns an element at the given [index] or throws an [IndexOutOfBoundsException] if the [index] is out of bounds of this array.")
        +"inline fun <T> $TypeBuffer.elementAt(index: Int): $type = get(index)"

        docs("Returns an element at the given [index] or the result of calling the [defaultValue] function if the [index] is out of bounds of this array.")
        +"inline fun $TypeBuffer.elementAtOrElse(index: Int, defaultValue: (Int) -> $type): $type = if (index >= 0 && index <= lastIndex) get(index) else defaultValue(index)"

        docs("Returns an element at the given [index] or `null` if the [index] is out of bounds of this array.")
        +"inline fun $TypeBuffer.elementAtOrNull(index: Int): $type? = this.getOrNull(index)"

        docs("Returns the first element matching the given [predicate], or `null` if no such element was found.")
        +"inline fun $TypeBuffer.find(predicate: ($type) -> Boolean): $type? = firstOrNull(predicate)"

        docs("Returns the last element matching the given [predicate], or `null` if no such element was found.")
        +"inline fun $TypeBuffer.findLast(predicate: ($type) -> Boolean): $type? = lastOrNull(predicate)"

        docs("""
            Returns the first element.
            
            @throws NoSuchElementException if the array is empty.""")
        +"""
            fun $TypeBuffer.first(): $type {
                if (isEmpty())
                    throw NoSuchElementException("Array is empty.")
                return this[0]
            }"""

        docs("""
            Returns the first element matching the given [predicate].
            @throws [NoSuchElementException] if no such element is found.""")
        +"""
            inline fun $TypeBuffer.first(predicate: ($type) -> Boolean): $type {
                for (element in this) if (predicate(element)) return element
                throw NoSuchElementException("Array contains no element matching the predicate.")
            }"""

        docs("Returns the first element, or `null` if the array is empty.")
        +"fun $TypeBuffer.firstOrNull(): $type? = if (isEmpty()) null else this[0]"

        docs("Returns the first element matching the given [predicate], or `null` if element was not found.")
        +"""
            inline fun $TypeBuffer.firstOrNull(predicate: ($type) -> Boolean): $type? {
                for (element in this) if (predicate(element)) return element
                return null
            }"""

        docs("Returns an element at the given [index] or the result of calling the [defaultValue] function if the [index] is out of bounds of this array.")
        +"inline fun $TypeBuffer.getOrElse(index: Int, defaultValue: (Int) -> $type): $type = if (index >= 0 && index <= lastIndex) get(index) else defaultValue(index)"

        docs("Returns an element at the given [index] or `null` if the [index] is out of bounds of this array.")
        +"fun $TypeBuffer.getOrNull(index: Int): $type? = if (index >= 0 && index <= lastIndex) get(index) else null"

        docs("Returns first index of [element], or -1 if the array does not contain element.")
        +"""
            fun $TypeBuffer.indexOf(element: $type): Int {
                for (index in indices)
                    if (element == this[index])
                        return index
                return -1
            }"""

        docs("Returns index of the first element matching the given [predicate], or -1 if the array does not contain such element.")
        +"""
            inline fun $TypeBuffer.indexOfFirst(predicate: ($type) -> Boolean): Int {
                for (index in indices)
                    if (predicate(this[index]))
                        return index
                return -1
            }"""

        docs("Returns index of the last element matching the given [predicate], or -1 if the array does not contain such element.")
        +"""
            inline fun $TypeBuffer.indexOfLast(predicate: ($type) -> Boolean): Int {
                for (index in indices.reversed())
                    if (predicate(this[index]))
                        return index
                return -1
            }"""

        docs("""
            Returns the last element.
            
            @throws NoSuchElementException if the array is empty.""")
        +"""
            fun $TypeBuffer.last(): $type {
                if (isEmpty())
                    throw NoSuchElementException("Array is empty.")
                return this[lastIndex]
            }"""

        docs("""
            Returns the last element matching the given [predicate].
            
            @throws NoSuchElementException if no such element is found.""")
        +"""
            inline fun $TypeBuffer.last(predicate: ($type) -> Boolean): $type {
                for (index in this.indices.reversed()) {
                    val element = this[index]
                    if (predicate(element)) return element
                }
                throw NoSuchElementException("Array contains no element matching the predicate.")
            }"""

        docs("Returns last index of [element], or -1 if the array does not contain element.")
        +"""
            fun $TypeBuffer.lastIndexOf(element: $type): Int {
                for (index in indices.reversed())
                    if (element == this[index])
                        return index
                return -1
            }"""

        docs("Returns the last element, or `null` if the array is empty.")
        +"fun $TypeBuffer.lastOrNull(): $type? = if (isEmpty()) null else this[rem - 1]"

        docs("Returns the last element matching the given [predicate], or `null` if no such element was found.")
        +"""
            inline fun $TypeBuffer.lastOrNull(predicate: ($type) -> Boolean): $type? {
                for (index in this.indices.reversed()) {
                    val element = this[index]
                    if (predicate(element)) return element
                }
                return null
            }"""

        // random, randomOrNull?

        docs("Returns the single element, or throws an exception if the array is empty or has more than one element.")
        +"""
            fun $TypeBuffer.single(): $type = when (rem) {
                0 -> throw NoSuchElementException("Array is empty.")
                1 -> this[0]
                else -> throw IllegalArgumentException("Array has more than one element.")
            }"""

        docs("Returns the single element matching the given [predicate], or throws exception if there is no or more than one matching element.")
        +"""
            inline fun $TypeBuffer.single(predicate: ($type) -> Boolean): $type {
                var single: $type? = null
                var found = false
                for (element in this)
                    if (predicate(element)) {
                        if (found) throw IllegalArgumentException("Array contains more than one matching element.")
                        single = element
                        found = true
                    }
                if (!found) throw NoSuchElementException("Array contains no element matching the predicate.")
                @Suppress("UNCHECKED_CAST")
                return single as $type
            }"""

        docs("Returns single element, or `null` if the array is empty or has more than one element.")
        +"fun $TypeBuffer.singleOrNull(): $type? = if (rem == 1) this[0] else null"

        docs("Returns the single element matching the given [predicate], or `null` if element was not found or more than one element was found.")
        +"""
            inline fun $TypeBuffer.singleOrNull(predicate: ($type) -> Boolean): $type? {
                var single: $type? = null
                var found = false
                for (element in this)
                    if (predicate(element)) {
                        if (found) return null
                        single = element
                        found = true
                    }
                if (!found) return null
                return single
            }"""

        // drop, dropLast, dropLastWhile, dropWhile?

        docs("Returns a list containing only elements matching the given [predicate].")
        +"inline fun $TypeBuffer.filter(predicate: ($type) -> Boolean): List<$type> = filterTo(ArrayList<$type>(), predicate)"

        docs("""
            Returns a list containing only elements matching the given [predicate].
            @param [predicate] function that takes the index of an element and the element itself and returns the result of predicate evaluation on the element.""")
        +"inline fun $TypeBuffer.filterIndexed(predicate: (index: Int, $type) -> Boolean): List<$type> = filterIndexedTo(ArrayList<$type>(), predicate)"

        docs("""
            Appends all elements matching the given [predicate] to the given [destination].
            @param [predicate] function that takes the index of an element and the element itself and returns the result of predicate evaluation on the element.""")
        +"""
            inline fun <C : MutableCollection<in $type>> $TypeBuffer.filterIndexedTo(destination: C, predicate: (index: Int, $type) -> Boolean): C {
                forEachIndexed { index, element ->
                    if (predicate(index, element)) destination.add(element)
                }
                return destination
            }"""

        docs("Returns a list containing all elements not matching the given [predicate].")
        +"inline fun $TypeBuffer.filterNot(predicate: ($type) -> Boolean): List<$type> = filterNotTo(ArrayList<$type>(), predicate)"

        docs("Appends all elements not matching the given [predicate] to the given [destination].")
        +"""
            inline fun <C : MutableCollection<in $type>> $TypeBuffer.filterNotTo(destination: C, predicate: ($type) -> Boolean): C {
                 for (element in this) if (!predicate(element)) destination.add(element)
                 return destination
            }"""

        docs("Appends all elements matching the given [predicate] to the given [destination].")
        +"""
            inline fun <C : MutableCollection<in $type>> $TypeBuffer.filterTo(destination: C, predicate: ($type) -> Boolean): C {
                 for (element in this) if (predicate(element)) destination.add(element)
                 return destination
            }"""

        //    docs("Returns a list containing elements at indices in the specified [indices] range.")
        //    +"""
        //        fun $TypeBuffer.slice(indices: IntRange): List<$type> {
        //            if (indices.isEmpty()) return listOf()
        //            return copyOfRange(indices.start, indices.endInclusive + 1).asList()
        //        }"""

        docs("Returns a list containing elements at specified [indices].")
        +"""
            fun $TypeBuffer.slice(indices: Iterable<Int>): List<$type> {
                val size = indices.collectionSizeOrDefault(10)
                if (size == 0) return emptyList()
                val list = ArrayList<$type>(size)
                for (index in indices)
                    list.add(get(index))
                return list
            }"""

        docs("Returns an array containing elements of this array at specified [indices].")
        +"""
            fun $TypeBuffer.sliceArray(indices: Collection<Int>): $TypeArray {
                val result = $TypeArray(indices.size)
                var targetIndex = 0
                for (sourceIndex in indices)
                    result[targetIndex++] = this[sourceIndex]
                return result
            }"""

        //    docs("Returns an array containing elements at indices in the specified [indices] range.")
        //    +"""
        //        fun $TypeBuffer.sliceArray(indices: IntRange): $TypeArray {
        //            if (indices.isEmpty()) return $TypeArray(0)
        //            return copyOfRange(indices.start, indices.endInclusive + 1)
        //        }"""

        // take, takeLast, takeLastWhile, takeWhile, reverse, reversed, reversedArray, shuffle,

        docs("Sorts elements in the array in-place descending according to their natural sort order.")
        +"""
            fun $TypeBuffer.sortDescending() {
                if (rem > 1) {
                    val array = to$TypeArray().apply{ sortDescending() }
                    for (i in 0 until rem)
                        this[pos + i] = array[i]
                }
            }"""

        docs("Returns a list of all elements sorted according to their natural sort order.")
        +"fun $TypeBuffer.sorted(): List<$type> = toTypedArray().apply { sort() }.asList()"

        docs("Returns an array with all elements of this array sorted according to their natural sort order.")
        +"fun $TypeBuffer.sortedArray(): $TypeArray = to$TypeArray().apply { sort() }"

        docs("Returns an array with all elements of this array sorted descending according to their natural sort order.")
        +"fun $TypeBuffer.sortedArrayDescending(): $TypeArray = to$TypeArray().apply { sortDescending() }"

        docs("Returns a list of all elements sorted according to natural sort order of the value returned by specified [selector] function.")
        +"inline fun <R : Comparable<R>> $TypeBuffer.sortedBy(crossinline selector: ($type) -> R?): List<$type> = to$TypeArray().sortedWith(compareBy(selector))"

        docs("Returns a list of all elements sorted descending according to natural sort order of the value returned by specified [selector] function.")
        +"inline fun <R : Comparable<R>> $TypeBuffer.sortedByDescending(crossinline selector: ($type) -> R?): List<$type> = to$TypeArray().sortedWith(compareByDescending(selector))"

        docs("Returns a list of all elements sorted descending according to their natural sort order.")
        +"fun $TypeBuffer.sortedDescending(): List<$type> = to$TypeArray().apply { sort() }.reversed()"

        docs("Returns a list of all elements sorted according to the specified [comparator].")
        +"fun $TypeBuffer.sortedWith(comparator: Comparator<in $type>): List<$type> = toTypedArray().apply { sortWith(comparator) }.asList()"

        // asList,
        // contentEquals, contentHashCode


        docs("Sorts the array in-place.")
        +"""
            fun $TypeBuffer.sort() {
                if (rem > 1) {
                    val array = to$TypeArray().apply{ sort() }
                    for (i in 0 until rem)
                        this[pos + i] = array[i]
                }
            }"""



        docs("Returns a string representation of the contents of the specified array as if it is [List].")
        // this goes in the clashed version with nullable receiver
        //    if (this == null) return "null"
        +"""
            fun $TypeBuffer.contentToString(): String {
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
            }"""

        // TODO check, platform clash with nullable, but stdlib seems fine
        // https://github.com/JetBrains/kotlin/blob/master/libraries/stdlib/common/src/generated/_Arrays.kt
        //    docs("Returns a string representation of the contents of the specified array as if it is [List].")
        //    +"fun $TypeBuffer?.contentToString(): String = if (this == null) \"null\" else contentToString()"

        // copyInto, copyOf, copyOfRange?

        docs("""
            Fills this array or its subrange with the specified [element] value.
    
            @param fromIndex the start of the range (inclusive) to fill, 0 by default.
            @param toIndex the end of the range (exclusive) to fill, size of this array by default.
    
            @throws IndexOutOfBoundsException if [fromIndex] is less than zero or [toIndex] is greater than the size of this array.
            @throws IllegalArgumentException if [fromIndex] is greater than [toIndex].""")
        +"""
            fun $TypeBuffer.fill(element: $type, fromIndex: Int = pos, toIndex: Int = rem) {
                for (i in fromIndex until toIndex)
                    this[i] = element
            }"""

        docs("Returns the range of valid indices for the array.")
        +"""
            val $TypeBuffer.indices: IntRange
                get() = IntRange(0, lastIndex)"""

        docs("Returns `true` if the array is empty.")
        +"inline fun $TypeBuffer.isEmpty(): Boolean = rem == 0"

        docs("Returns `true` if the array is not empty.")
        +"inline fun $TypeBuffer.isNotEmpty(): Boolean = !isEmpty()"

        docs("Returns the last valid index for the array.")
        +"""
            val $TypeBuffer.lastIndex: Int
                get() = rem - 1"""

        // plus, sort

        docs("Returns an array of Byte containing all of the elements of this generic array.")
        +"fun $TypeBuffer.to$TypeArray(): $TypeArray = $TypeArray(rem) { index -> this[index] }"

        docs("Returns a *typed* object array containing all of the elements of this primitive array.")
        +"fun $TypeBuffer.toTypedArray(): Array<$type> = Array(rem) { index -> this[index] }"

        docs("""
            Returns a [Map] containing key-value pairs provided by [transform] function applied to elements of the given array.
    
            If any of two pairs would have the same key the last one gets added to the map.
    
            The returned map preserves the entry iteration order of the original array.""")
        +"""
            inline fun <K, V> $TypeBuffer.associate(transform: ($type) -> Pair<K, V>): Map<K, V> {
                val capacity = mapCapacity(rem).coerceAtLeast(16)
                return associateTo(LinkedHashMap<K, V>(capacity), transform)
            }"""

        docs("""
            Returns a [Map] containing the elements from the given array indexed by the key returned from [keySelector] function applied to each element.
    
            If any two elements would have the same key returned by [keySelector] the last one gets added to the map.
    
            The returned map preserves the entry iteration order of the original array.""")
        +"""
            inline fun <K> $TypeBuffer.associateBy(keySelector: ($type) -> K): Map<K, $type> {
                val capacity = mapCapacity(rem).coerceAtLeast(16)
                return associateByTo(LinkedHashMap<K, $type>(capacity), keySelector)
            }"""

        docs("""
            Returns a [Map] containing the values provided by [valueTransform] and indexed by [keySelector] functions applied to elements of the given array.
    
            If any two elements would have the same key returned by [keySelector] the last one gets added to the map.
    
            The returned map preserves the entry iteration order of the original array.""")
        +"""
            inline fun <K, V> $TypeBuffer.associateBy(keySelector: ($type) -> K, valueTransform: ($type) -> V): Map<K, V> {
                val capacity = mapCapacity(rem).coerceAtLeast(16)
                return associateByTo(LinkedHashMap<K, V>(capacity), keySelector, valueTransform)
            }"""

        docs("""
            Populates and returns the [destination] mutable map with key-value pairs, where key is provided by
            the [keySelector] function applied to each element of the given array and value is the element itself.
    
            If any two elements would have the same key returned by [keySelector] the last one gets added to the map.""")
        +"""
            inline fun <K, M : MutableMap<in K, in $type>> $TypeBuffer.associateByTo(destination: M, keySelector: ($type) -> K): M {
                for (element in this)
                    destination.put(keySelector(element), element)
                return destination
            }"""

        docs("""
            Populates and returns the [destination] mutable map with key-value pairs, where key is provided by the [keySelector]
            function and and value is provided by the [valueTransform] function applied to elements of the given array.
    
            If any two elements would have the same key returned by [keySelector] the last one gets added to the map.""")
        +"""
            inline fun <K, V, M : MutableMap<in K, in V>> $TypeBuffer.associateByTo(destination: M, keySelector: ($type) -> K, valueTransform: ($type) -> V): M {
                for (element in this)
                    destination.put(keySelector(element), valueTransform(element))
                return destination
            }"""

        docs("""
            Populates and returns the [destination] mutable map with key-value pairs provided by [transform] function
            applied to each element of the given array.
    
            If any of two pairs would have the same key the last one gets added to the map.""")
        +"""
            inline fun <K, V, M : MutableMap<in K, in V>> $TypeBuffer.associateTo(destination: M, transform: ($type) -> Pair<K, V>): M {
                for (element in this)
                    destination += transform(element)
                return destination
            }"""

        docs("""
            Returns a [Map] where keys are elements from the given array and values are produced by the [valueSelector] function applied to each element.
    
            If any two elements are equal, the last one gets added to the map.
    
            The returned map preserves the entry iteration order of the original array.""")
        +"""
            inline fun <V> $TypeBuffer.associateWith(valueSelector: ($type) -> V): Map<$type, V> {
                val result = LinkedHashMap<$type, V>(mapCapacity(rem).coerceAtLeast(16))
                return associateWithTo(result, valueSelector)
            }"""

        docs("""
            Populates and returns the [destination] mutable map with key-value pairs for each element of the given array,
            where key is the element itself and value is provided by the [valueSelector] function applied to that key.
    
            If any two elements are equal, the last one overwrites the former value in the map.""")
        +"""
            inline fun <V, M : MutableMap<in $type, in V>> $TypeBuffer.associateWithTo(destination: M, valueSelector: ($type) -> V): M {
                for (element in this)
                    destination.put(element, valueSelector(element))
                return destination
            }"""

        docs("Appends all elements to the given [destination] collection.")
        +"""
            fun <C : MutableCollection<in $type>> $TypeBuffer.toCollection(destination: C): C {
                for (item in this)
                    destination.add(item)
                return destination
            }"""

        // toHashSet, toList, toMutableList, toSet

        docs("Returns a single list of all elements yielded from results of [transform] function being invoked on each element of original array.")
        +"inline fun <R> $TypeBuffer.flatMap(transform: ($type) -> Iterable<R>): List<R> = flatMapTo(ArrayList<R>(), transform)"
    }
    if (part == Generator.Part.Class) {

        docs("Returns a single list of all elements yielded from results of [transform] function being invoked on each element and its index in the original array.")
        +"inline fun <R> flatMapIndexed(transform: (index: Int, $type) -> Iterable<R>): List<R> = flatMapIndexedTo(ArrayList<R>(), transform)"

        docs("Appends all elements yielded from results of [transform] function being invoked on each element and its index in the original array, to the given [destination].")
        +"""
            inline fun <R, C : MutableCollection<in R>> flatMapIndexedTo(destination: C, transform: (index: Int, $type) -> Iterable<R>): C {
                var index = 0
                for (element in this) {
                    val list = transform(index++, element)
                    destination.addAll(list)
                }
                return destination
            }"""
    }
    if (part == Generator.Part.TopLevel) {

        docs("Appends all elements yielded from results of [transform] function being invoked on each element of original array, to the given [destination].")
        +"""
            inline fun <R, C : MutableCollection<in R>> $TypeBuffer.flatMapTo(destination: C, transform: ($type) -> Iterable<R>): C {
                for (element in this) {
                    val list = transform(element)
                    destination.addAll(list)
                }
                return destination
            }"""

        docs("""
            Groups elements of the original array by the key returned by the given [keySelector] function applied to
            each element and returns a map where each group key is associated with a list of corresponding elements.
    
            The returned map preserves the entry iteration order of the keys produced from the original array.""")
        +"inline fun <K> $TypeBuffer.groupBy(keySelector: ($type) -> K): Map<K, List<$type>> = groupByTo(LinkedHashMap<K, MutableList<$type>>(), keySelector)"

        docs("""
            Groups values returned by the [valueTransform] function applied to each element of the original array
            by the key returned by the given [keySelector] function applied to the element
            and returns a map where each group key is associated with a list of corresponding values.
    
            The returned map preserves the entry iteration order of the keys produced from the original array.""")
        +"inline fun <K, V> $TypeBuffer.groupBy(keySelector: ($type) -> K, valueTransform: ($type) -> V): Map<K, List<V>> = groupByTo(LinkedHashMap<K, MutableList<V>>(), keySelector, valueTransform)"

        docs("""
            Groups elements of the original array by the key returned by the given [keySelector] function applied to each
            element and puts to the [destination] map each group key associated with a list of corresponding elements.
    
            @return The [destination] map.""")
        +"""
            inline fun <K, M : MutableMap<in K, MutableList<$type>>> $TypeBuffer.groupByTo(destination: M, keySelector: ($type) -> K): M {
                for (element in this) {
                    val key = keySelector(element)
                    val list = destination.getOrPut(key) { ArrayList<$type>() }
                    list.add(element)
                }
                return destination
            }"""

        docs("""
            Groups values returned by the [valueTransform] function applied to each element of the original array
            by the key returned by the given [keySelector] function applied to the element
            and puts to the [destination] map each group key associated with a list of corresponding values.
    
            @return The [destination] map.""")
        +"""
            inline fun <K, V, M : MutableMap<in K, MutableList<V>>> $TypeBuffer.groupByTo(destination: M, keySelector: ($type) -> K, valueTransform: ($type) -> V): M {
                for (element in this) {
                    val key = keySelector(element)
                    val list = destination.getOrPut(key) { ArrayList<V>() }
                    list.add(valueTransform(element))
                }
                return destination
            }"""

        // withIndex,

        docs("""
            Returns a list containing only distinct elements from the given array.
            
            The elements in the resulting list are in the same order as they were in the source array.""")
        +"fun $TypeBuffer.distinct(): List<$type> = this.toMutableSet().toList()"

        docs("""
            Returns a list containing only elements from the given array having distinct keys returned by the given [selector] function.
            
            The elements in the resulting list are in the same order as they were in the source array.""")
        +"""
            inline fun <K> $TypeBuffer.distinctBy(selector: ($type) -> K): List<$type> {
                val set = HashSet<K>()
                val list = ArrayList<$type>()
                for (e in this) {
                    val key = selector(e)
                    if (set.add(key))
                        list.add(e)
                }
                return list
            }"""

        // intersect, subtract,

        docs("""
            Returns a new [MutableSet] containing all distinct elements from the given array.
            
            The returned set preserves the element iteration order of the original array.""")
        +"fun $TypeBuffer.toMutableSet(): MutableSet<$type> = toCollection(LinkedHashSet<$type>(mapCapacity(rem)))"

        // union

        docs("Returns a list containing the results of applying the given [transform] function to each element in the original array.")
        +"inline fun <R> $TypeBuffer.map(transform: ($type) -> R): List<R> = mapTo(ArrayList<R>(rem), transform)"

        docs("""
            Returns a list containing the results of applying the given [transform] function to each element and its index in the original array.
            @param [transform] function that takes the index of an element and the element itself and returns the result of the transform applied to the element.""")
        +"inline fun <R> $TypeBuffer.mapIndexed(transform: (index: Int, $type) -> R): List<R> = mapIndexedTo(ArrayList<R>(rem), transform)"

        docs("""
            Applies the given [transform] function to each element and its index in the original array and appends the results to the given [destination].
            @param [transform] function that takes the index of an element and the element itself and returns the result of the transform applied to the element.""")
        +"""
            inline fun <R, C : MutableCollection<in R>> $TypeBuffer.mapIndexedTo(destination: C, transform: (index: Int, $type) -> R): C {
                var index = 0
                for (item in this)
                    destination.add(transform(index++, item))
                return destination
            }"""

        docs("Applies the given [transform] function to each element of the original array and appends the results to the given [destination].")
        +"""
            inline fun <R, C : MutableCollection<in R>> $TypeBuffer.mapTo(destination: C, transform: ($type) -> R): C {
                for (item in this)
                    destination.add(transform(item))
                return destination
            }"""

        docs("Returns `true` if all elements match the given [predicate].")
        +"""
            inline fun $TypeBuffer.all(predicate: ($type) -> Boolean): Boolean {
                for (element in this) if (!predicate(element)) return false
                return true
            }"""

        docs("Returns `true` if array has at least one element.")
        +"fun $TypeBuffer.any(): Boolean = !isEmpty()"

        docs("Returns `true` if at least one element matches the given [predicate].")
        +"""
            inline fun $TypeBuffer.any(predicate: ($type) -> Boolean): Boolean {
                for (element in this) if (predicate(element)) return true
                return false
            }"""

        docs("Returns the number of elements in this array.")
        +"inline fun $TypeBuffer.count(): Int = rem"

        docs("Returns the number of elements matching the given [predicate].")
        +"""
            inline fun $TypeBuffer.count(predicate: ($type) -> Boolean): Int {
                var count = 0
                for (element in this) if (predicate(element)) ++count
                return count
            }"""

        // fold, foldIndexed, foldRight, foldRightIndexed

        docs("Performs the given [action] on each element.")
        +"inline fun $TypeBuffer.forEach(action: ($type) -> Unit) { for (element in this) action(element) }"

        docs("""
            Performs the given [action] on each element, providing sequential index with the element.
            @param [action] function that takes the index of an element and the element itself and performs the action on the element.""")
        +"""
            inline fun $TypeBuffer.forEachIndexed(action: (index: Int, $type) -> Unit): Unit {
                var index = 0
                for (item in this) action(index++, item)
            }"""

        docs("""
            Returns the largest element.
    
            @throws NoSuchElementException if the array is empty.""")
        +"""
            fun $TypeBuffer.max(): $type {
                if (isEmpty()) throw NoSuchElementException()
                var max = this[0]
                for (i in 1..lastIndex) {
                    val e = this[i]
                    if (max < e) max = e
                }
                return max
            }"""

        docs("""
            Returns the first element yielding the largest value of the given function.
    
            @throws NoSuchElementException if the array is empty.""")
        +"""
            inline fun <R : Comparable<R>> $TypeBuffer.maxBy(selector: ($type) -> R): $type {
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
            }"""

        docs("Returns the first element yielding the largest value of the given function or `null` if there are no elements.")
        +"""
            inline fun <R : Comparable<R>> $TypeBuffer.maxByOrNull(selector: ($type) -> R): $type? {
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
            }"""
    }
    if (part == Generator.Part.Class) {

        docs("""
            Returns the largest value among all values produced by [selector] function applied to each element in the array.

            If any of values produced by [selector] function is `NaN`, the returned result is `NaN`.

            @throws NoSuchElementException if the array is empty.""")
        +"""
            inline fun maxOf(selector: ($type) -> Double): Double {
                if (isEmpty()) throw NoSuchElementException()
                var maxValue = selector(this[0])
                for (i in 1..lastIndex) {
                    val v = selector(this[i])
                    maxValue = maxOf(maxValue, v)
                }
                return maxValue
            }"""

        docs("""
            Returns the largest value among all values produced by [selector] function applied to each element in the array.

            If any of values produced by [selector] function is `NaN`, the returned result is `NaN`.

            @throws NoSuchElementException if the array is empty.""")
        +"""
            inline fun maxOf(selector: ($type) -> Float): Float {
                if (isEmpty()) throw NoSuchElementException()
                var maxValue = selector(this[0])
                for (i in 1..lastIndex) {
                    val v = selector(this[i])
                    maxValue = maxOf(maxValue, v)
                }
                return maxValue
            }"""

        docs("""
            Returns the largest value among all values produced by [selector] function applied to each element in the array.

            @throws NoSuchElementException if the array is empty.""")
        +"""
            inline fun <R : Comparable<R>> maxOf(selector: ($type) -> R): R {
                if (isEmpty()) throw NoSuchElementException()
                var maxValue = selector(this[0])
                for (i in 1..lastIndex) {
                    val v = selector(this[i])
                    if (maxValue < v)
                        maxValue = v
                }
                return maxValue
            }"""
    }
    if (part == Generator.Part.Class) {

        docs("""
            Returns the largest value among all values produced by [selector] function applied to each element in the array or `null` if there are no elements.
    
            If any of values produced by [selector] function is `NaN`, the returned result is `NaN`.""")
        +"""
            inline fun maxOfOrNull(selector: ($type) -> Double): Double? {
                if (isEmpty()) return null
                var maxValue = selector(this[0])
                for (i in 1..lastIndex) {
                    val v = selector(this[i])
                    maxValue = maxOf(maxValue, v)
                }
                return maxValue
            }"""

        docs("Returns the largest value among all values produced by [selector] function applied to each element in the array or `null` if there are no elements.")
        +"""
            inline fun <R : Comparable<R>> maxOfOrNull(selector: ($type) -> R): R? {
                if (isEmpty()) return null
                var maxValue = selector(this[0])
                for (i in 1..lastIndex) {
                    val v = selector(this[i])
                    if (maxValue < v)
                        maxValue = v
                }
                return maxValue
            }"""

        docs("""
            Returns the largest value according to the provided [comparator] among all values produced by [selector] function applied to each element in the array.
    
            @throws NoSuchElementException if the array is empty.""")
        +"""
            inline fun <R> maxOfWith(comparator: Comparator<in R>, selector: ($type) -> R): R {
                if (isEmpty()) throw NoSuchElementException()
                var maxValue = selector(this[0])
                for (i in 1..lastIndex) {
                    val v = selector(this[i])
                    if (comparator.compare(maxValue, v) < 0)
                        maxValue = v
                }
                return maxValue
            }"""

        docs("""
            Returns the largest value according to the provided [comparator] among all values produced by [selector]
            function applied to each element in the array or `null` if there are no elements.""")
        +"""
            inline fun <R> maxOfWithOrNull(comparator: Comparator<in R>, selector: ($type) -> R): R? {
                if (isEmpty()) return null
                var maxValue = selector(this[0])
                for (i in 1..lastIndex) {
                    val v = selector(this[i])
                    if (comparator.compare(maxValue, v) < 0)
                        maxValue = v
                }
                return maxValue
            }"""
    }
    if (part == Generator.Part.TopLevel) {

        docs("Returns the largest element or `null` if there are no elements.")
        +"""
            fun $TypeBuffer.maxOrNull(): $type? {
                if (isEmpty()) return null
                var max = this[0]
                for (i in 1..lastIndex) {
                    val e = this[i]
                    if (max < e) max = e
                }
                return max
            }"""

        docs("""
            Returns the first element having the largest value according to the provided [comparator].
    
            @throws NoSuchElementException if the array is empty.""")
        +"""
            fun $TypeBuffer.maxWith(comparator: Comparator<in $type>): $type {
                if (isEmpty()) throw NoSuchElementException()
                var max = this[0]
                for (i in 1..lastIndex) {
                    val e = this[i]
                    if (comparator.compare(max, e) < 0) max = e
                }
                return max
            }"""

        docs("Returns the first element having the largest value according to the provided [comparator] or `null` if there are no elements.")
        +"""
            fun $TypeBuffer.maxWithOrNull(comparator: Comparator<in $type>): $type? {
                if (isEmpty()) return null
                var max = this[0]
                for (i in 1..lastIndex) {
                    val e = this[i]
                    if (comparator.compare(max, e) < 0) max = e
                }
                return max
            }"""

        docs("""
            Returns the smallest element.
    
            @throws NoSuchElementException if the array is empty.""")
        +"""
            fun $TypeBuffer.min(): $type {
                if (isEmpty()) throw NoSuchElementException()
                var min = this[0]
                for (i in 1..lastIndex) {
                    val e = this[i]
                    if (min > e) min = e
                }
                return min
            }"""

        docs("""
            Returns the first element yielding the smallest value of the given function.
    
            @throws NoSuchElementException if the array is empty.""")
        +"""
            inline fun <R : Comparable<R>> $TypeBuffer.minBy(selector: ($type) -> R): $type {
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
            }"""

        docs("""
            Returns the first element yielding the smallest value of the given function or `null` if there are no elements.
    
            @sample samples.collections.Collections.Aggregates.minByOrNull""")
        +"""
            inline fun <R : Comparable<R>> $TypeBuffer.minByOrNull(selector: ($type) -> R): $type? {
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
            }"""

        docs("""
            Returns the smallest value among all values produced by [selector] function applied to each element in the array.
    
            If any of values produced by [selector] function is `NaN`, the returned result is `NaN`.
    
            @throws NoSuchElementException if the array is empty.""")
        +"""
            inline fun $TypeBuffer.minOf(selector: ($type) -> Double): Double {
                if (isEmpty()) throw NoSuchElementException()
                var minValue = selector(this[0])
                for (i in 1..lastIndex) {
                    val v = selector(this[i])
                    minValue = minOf(minValue, v)
                }
                return minValue
            }"""

        docs("""
            Returns the smallest value among all values produced by [selector] function applied to each element in the array.
    
            If any of values produced by [selector] function is `NaN`, the returned result is `NaN`.
    
            @throws NoSuchElementException if the array is empty.""")
        +"""
            inline fun $TypeBuffer.minOf(selector: ($type) -> Float): Float {
                if (isEmpty()) throw NoSuchElementException()
                var minValue = selector(this[0])
                for (i in 1..lastIndex) {
                    val v = selector(this[i])
                    minValue = minOf(minValue, v)
                }
                return minValue
            }"""

        docs("""
            Returns the smallest value among all values produced by [selector] function applied to each element in the array.
    
            @throws NoSuchElementException if the array is empty.""")
        +"""
            inline fun <R : Comparable<R>> $TypeBuffer.minOf(selector: ($type) -> R): R {
                if (isEmpty()) throw NoSuchElementException()
                var minValue = selector(this[0])
                for (i in 1..lastIndex) {
                    val v = selector(this[i])
                    if (minValue > v)
                        minValue = v
                }
                return minValue
            }"""

        docs("""
            Returns the smallest value among all values produced by [selector] function applied to each element in the array or `null` if there are no elements.
    
            If any of values produced by [selector] function is `NaN`, the returned result is `NaN`.""")
        +"""
            inline fun $TypeBuffer.minOfOrNull(selector: ($type) -> Double): Double? {
                if (isEmpty()) return null
                var minValue = selector(this[0])
                for (i in 1..lastIndex) {
                    val v = selector(this[i])
                    minValue = minOf(minValue, v)
                }
                return minValue
            }"""

        docs("""
            Returns the smallest value among all values produced by [selector] function applied to each element in the array or `null` if there are no elements.
    
            If any of values produced by [selector] function is `NaN`, the returned result is `NaN`.""")
        +"""
            inline fun $TypeBuffer.minOfOrNull(selector: ($type) -> Float): Float? {
                if (isEmpty()) return null
                var minValue = selector(this[0])
                for (i in 1..lastIndex) {
                    val v = selector(this[i])
                    minValue = minOf(minValue, v)
                }
                return minValue
            }"""

        docs("Returns the smallest value among all values produced by [selector] function applied to each element in the array or `null` if there are no elements.")
        +"""
            inline fun <R : Comparable<R>> $TypeBuffer.minOfOrNull(selector: ($type) -> R): R? {
                if (isEmpty()) return null
                var minValue = selector(this[0])
                for (i in 1..lastIndex) {
                    val v = selector(this[i])
                    if (minValue > v)
                        minValue = v
                }
                return minValue
            }"""

        docs("""
            Returns the smallest value according to the provided [comparator] among all values produced by [selector] function applied to each element in the array.
    
            @throws NoSuchElementException if the array is empty.""")
        +"""
            inline fun <R> $TypeBuffer.minOfWith(comparator: Comparator<in R>, selector: ($type) -> R): R {
                if (isEmpty()) throw NoSuchElementException()
                var minValue = selector(this[0])
                for (i in 1..lastIndex) {
                    val v = selector(this[i])
                    if (comparator.compare(minValue, v) > 0)
                        minValue = v
                }
                return minValue
            }"""

        docs("""
            Returns the smallest value according to the provided [comparator] among all values produced by [selector]
            function applied to each element in the array or `null` if there are no elements.""")
        +"""
            inline fun <R> $TypeBuffer.minOfWithOrNull(comparator: Comparator<in R>, selector: ($type) -> R): R? {
                if (isEmpty()) return null
                var minValue = selector(this[0])
                for (i in 1..lastIndex) {
                    val v = selector(this[i])
                    if (comparator.compare(minValue, v) > 0)
                        minValue = v
                }
                return minValue
            }"""

        docs("Returns the smallest element or `null` if there are no elements.")
        +"""
            fun $TypeBuffer.minOrNull(): $type? {
                 if (isEmpty()) return null
                 var min = this[0]
                 for (i in 1..lastIndex) {
                     val e = this[i]
                     if (min > e) min = e
                 }
                 return min
             }"""

        docs("""
            Returns the first element having the smallest value according to the provided [comparator].
    
            @throws NoSuchElementException if the array is empty.""")
        +"""
            fun $TypeBuffer.minWith(comparator: Comparator<in $type>): $type {
                if (isEmpty()) throw NoSuchElementException()
                var min = this[0]
                for (i in 1..lastIndex) {
                    val e = this[i]
                    if (comparator.compare(min, e) > 0) min = e
                }
                return min
            }"""

        docs("Returns the first element having the smallest value according to the provided [comparator] or `null` if there are no elements.")
        +"""
            fun $TypeBuffer.minWithOrNull(comparator: Comparator<in $type>): $type? {
                if (isEmpty()) return null
                var min = this[0]
                for (i in 1..lastIndex) {
                    val e = this[i]
                    if (comparator.compare(min, e) > 0) min = e
                }
                return min
            }"""

        docs("Returns `true` if the array has no elements.")
        +"fun $TypeBuffer.none(): Boolean = isEmpty()"

        docs("Returns `true` if no elements match the given [predicate].")
        +"""
            inline fun $TypeBuffer.none(predicate: ($type) -> Boolean): Boolean {
                for (element in this) if (predicate(element)) return false
                return true
            }"""

        docs("Performs the given [action] on each element and returns the array itself afterwards.")
        +"inline fun $TypeBuffer.onEach(action: ($type) -> Unit): $TypeBuffer = apply { for (element in this) action(element) }"

        docs("""
            Performs the given [action] on each element, providing sequential index with the element, and returns the array itself afterwards.
            @param [action] function that takes the index of an element and the element itself and performs the action on the element.""")
        +"inline fun $TypeBuffer.onEachIndexed(action: (index: Int, $type) -> Unit): $TypeBuffer = apply { forEachIndexed(action) }"

        docs("""
            Accumulates value starting with the first element and applying [operation] from left to right to current accumulator value and each element.
            
            Throws an exception if this array is empty. If the array can be empty in an expected way,
            please use [reduceOrNull] instead. It returns `null` when its receiver is empty.
            
            @param [operation] function that takes current accumulator value and an element, and calculates the next accumulator value.""")
        +"""
            inline fun $TypeBuffer.reduce(operation: (acc: $type, $type) -> $type): $type {
                if (isEmpty())
                    throw UnsupportedOperationException("Empty array can't be reduced.")
                var accumulator = this[0]
                for (index in 1..lastIndex)
                    accumulator = operation(accumulator, this[index])
                return accumulator
            }"""

        docs("""
            Accumulates value starting with the first element and applying [operation] from left to right
            to current accumulator value and each element with its index in the original array.
            
            Throws an exception if this array is empty. If the array can be empty in an expected way,
            please use [reduceIndexedOrNull] instead. It returns `null` when its receiver is empty.
            
            @param [operation] function that takes the index of an element, current accumulator value and the element itself,
            and calculates the next accumulator value.""")
        +"""
            inline fun $TypeBuffer.reduceIndexed(operation: (index: Int, acc: $type, $type) -> $type): $type {
                if (isEmpty())
                    throw UnsupportedOperationException("Empty array can't be reduced.")
                var accumulator = this[0]
                for (index in 1..lastIndex)
                    accumulator = operation(index, accumulator, this[index])
                return accumulator
            }"""

        docs("""
            Accumulates value starting with the first element and applying [operation] from left to right
            to current accumulator value and each element with its index in the original array.
            
            Returns `null` if the array is empty.
            
            @param [operation] function that takes the index of an element, current accumulator value and the element itself,
            and calculates the next accumulator value.""")
        +"""
            inline fun $TypeBuffer.reduceIndexedOrNull(operation: (index: Int, acc: $type, $type) -> $type): $type? {
                if (isEmpty())
                    return null
                var accumulator = this[0]
                for (index in 1..lastIndex)
                    accumulator = operation(index, accumulator, this[index])
                return accumulator
            }"""

        docs("""
            Accumulates value starting with the first element and applying [operation] from left to right to current accumulator value and each element.
            
            Returns `null` if the array is empty.
            
            @param [operation] function that takes current accumulator value and an element, and calculates the next accumulator value.""")
        +"""
            inline fun $TypeBuffer.reduceOrNull(operation: (acc: $type, $type) -> $type): $type? {
                if (isEmpty())
                    return null
                var accumulator = this[0]
                for (index in 1..lastIndex)
                    accumulator = operation(accumulator, this[index])
                 return accumulator
            }"""

        docs("""
            Accumulates value starting with the last element and applying [operation] from right to left to each element and current accumulator value.
            
            Throws an exception if this array is empty. If the array can be empty in an expected way,
            please use [reduceRightOrNull] instead. It returns `null` when its receiver is empty.
            
            @param [operation] function that takes an element and current accumulator value, and calculates the next accumulator value.""")
        +"""
            inline fun $TypeBuffer.reduceRight(operation: ($type, acc: $type) -> $type): $type {
                var index = lastIndex
                if (index < 0) throw UnsupportedOperationException("Empty array can't be reduced.")
                var accumulator = get(index--)
                while (index >= 0)
                    accumulator = operation(get(index--), accumulator)
                return accumulator
            }"""

        docs("""
            Accumulates value starting with the last element and applying [operation] from right to left
            to each element with its index in the original array and current accumulator value.
            
            Throws an exception if this array is empty. If the array can be empty in an expected way,
            please use [reduceRightIndexedOrNull] instead. It returns `null` when its receiver is empty.
            
            @param [operation] function that takes the index of an element, the element itself and current accumulator value,
            and calculates the next accumulator value.""")
        +"""
            inline fun $TypeBuffer.reduceRightIndexed(operation: (index: Int, $type, acc: $type) -> $type): $type {
                var index = lastIndex
                if (index < 0) throw UnsupportedOperationException("Empty array can't be reduced.")
                var accumulator = get(index--)
                while (index >= 0) {
                    accumulator = operation(index, get(index), accumulator)
                    --index
                }
                return accumulator
            }"""

        docs("""
            Accumulates value starting with the last element and applying [operation] from right to left
            to each element with its index in the original array and current accumulator value.
            
            Returns `null` if the array is empty.
            
            @param [operation] function that takes the index of an element, the element itself and current accumulator value,
            and calculates the next accumulator value.""")
        +"""
            inline fun $TypeBuffer.reduceRightIndexedOrNull(operation: (index: Int, $type, acc: $type) -> $type): $type? {
                var index = lastIndex
                if (index < 0) return null
                var accumulator = get(index--)
                while (index >= 0) {
                    accumulator = operation(index, get(index), accumulator)
                    --index
                }
                return accumulator
            }"""

        docs("""
            Accumulates value starting with the last element and applying [operation] from right to left to each element and current accumulator value.
            
            Returns `null` if the array is empty.
            
            @param [operation] function that takes an element and current accumulator value, and calculates the next accumulator value.""")
        +"""
            inline fun $TypeBuffer.reduceRightOrNull(operation: ($type, acc: $type) -> $type): $type? {
                var index = lastIndex
                if (index < 0) return null
                var accumulator = get(index--)
                while (index >= 0)
                     accumulator = operation(get(index--), accumulator)
                return accumulator
            }"""

        // runningFold, runningFoldIndexed, runningReduce,
        // runningReduceIndexed, scan, scanIndexed
    }
    if (part == Generator.Part.Class) {
        docs("Returns the sum of all values produced by [selector] function applied to each element in the array.")
        +"""
            inline fun sumOf(selector: ($type) -> Double): Double {
                var sum: Double = 0.toDouble()
                for (element in this)
                    sum += selector(element)
                return sum
            }"""

        docs("Returns the sum of all values produced by [selector] function applied to each element in the array.")
        +"""
            inline fun sumOf(selector: ($type) -> Int): Int {
                var sum: Int = 0.toInt()
                for (element in this)
                    sum += selector(element)
                return sum
            }"""

        docs("Returns the sum of all values produced by [selector] function applied to each element in the array.")
        +"""
            inline fun sumOf(selector: ($type) -> Long): Long {
                var sum: Long = 0.toLong()
                for (element in this)
                    sum += selector(element)
                return sum
            }"""

        docs("Returns the sum of all values produced by [selector] function applied to each element in the array.")
        +"""
            inline fun sumOf(selector: ($type) -> UInt): UInt {
                var sum: UInt = 0.toUInt()
                for (element in this)
                    sum += selector(element)
                return sum
            }"""

        docs("Returns the sum of all values produced by [selector] function applied to each element in the array.")
        +"""
            inline fun sumOf(selector: ($type) -> ULong): ULong {
                var sum: ULong = 0.toULong()
                for (element in this)
                    sum += selector(element)
                return sum
            }"""
    }
    if (part == Generator.Part.TopLevel) {

        docs("""
            Splits the original array into pair of lists, where *first* list contains elements for which [predicate] 
            yielded `true`, while *second* list contains elements for which [predicate] yielded `false`.""")
        +"""
            inline fun $TypeBuffer.partition(predicate: ($type) -> Boolean): Pair<List<$type>, List<$type>> {
                val first = ArrayList<$type>()
                val second = ArrayList<$type>()
                for (element in this)
                    if (predicate(element))
                        first.add(element)
                    else
                        second.add(element)
                return Pair(first, second)
            }"""

        docs("""
            Returns a list of pairs built from the elements of `this` array and the [other] array with the same index.
            The returned list has length of the shortest collection.""")
        +"infix fun <R> $TypeBuffer.zip(other: Array<out R>): List<Pair<$type, R>> = zip(other) { t1, t2 -> t1 to t2 }"

        docs("""
            Returns a list of values built from the elements of `this` array and the [other] array with the same index
            using the provided [transform] function applied to each pair of elements.
            The returned list has length of the shortest collection.""")
        +"""
            inline fun <R, V> $TypeBuffer.zip(other: Array<out R>, transform: (a: $type, b: R) -> V): List<V> {
                val size = minOf(rem, other.size)
                val list = ArrayList<V>(size)
                for (i in 0 until size)
                    list.add(transform(this[i], other[i]))
                return list
            }"""

        docs("""
            Returns a list of pairs built from the elements of `this` collection and [other] array with the same index.
            The returned list has length of the shortest collection.""")
        +"infix fun <R> $TypeBuffer.zip(other: Iterable<R>): List<Pair<$type, R>> = zip(other) { t1, t2 -> t1 to t2 }"

        docs("""
            Returns a list of values built from the elements of `this` array and the [other] collection with the same index
            using the provided [transform] function applied to each pair of elements.
            The returned list has length of the shortest collection.""")
        +"""
            inline fun <R, V> $TypeBuffer.zip(other: Iterable<R>, transform: (a: $type, b: R) -> V): List<V> {
                val arraySize = rem
                val list = ArrayList<V>(minOf(other.collectionSizeOrDefault(10), arraySize))
                var i = 0
                for (element in other) {
                    if (i >= arraySize) break
                    list.add(transform(this[i++], element))
                }
                return list
            }"""

        docs("""
            Returns a list of pairs built from the elements of `this` array and the [other] array with the same index.
            The returned list has length of the shortest collection.""")
        +"infix fun $TypeBuffer.zip(other: $TypeArray): List<Pair<$type, $type>> = zip(other) { t1, t2 -> t1 to t2 }"

        docs("""
            Returns a list of values built from the elements of `this` array and the [other] array with the same index
            using the provided [transform] function applied to each pair of elements.
            The returned list has length of the shortest array.""")
        +"""
            inline fun <V> $TypeBuffer.zip(other: $TypeArray, transform: (a: $type, b: $type) -> V): List<V> {
                val size = minOf(rem, other.size)
                val list = ArrayList<V>(size)
                for (i in 0 until size)
                    list.add(transform(this[i], other[i]))
                return list
            }"""

        docs("""
            Appends the string from all the elements separated using [separator] and using the given [prefix] and [postfix] if supplied.
    
            If the collection could be huge, you can specify a non-negative value of [limit], in which case only the first [limit]
            elements will be appended, followed by the [truncated] string (which defaults to "...").""")
        +"""
            fun <A : Appendable> $TypeBuffer.joinTo(buffer: A, separator: CharSequence = ", ", prefix: CharSequence = "", postfix: CharSequence = "", limit: Int = -1, truncated: CharSequence = "...", transform: (($type) -> CharSequence)? = null): A {
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
            }"""

        docs("""
            Creates a string from all the elements separated using [separator] and using the given [prefix] and [postfix] if supplied.
    
            If the collection could be huge, you can specify a non-negative value of [limit], in which case only the first [limit]
            elements will be appended, followed by the [truncated] string (which defaults to "...").""")
        +"""
            fun $TypeBuffer.joinToString(separator: CharSequence = ", ", prefix: CharSequence = "", postfix: CharSequence = "", limit: Int = -1, truncated: CharSequence = "...", transform: (($type) -> CharSequence)? = null): String =
                joinTo(StringBuilder(), separator, prefix, postfix, limit, truncated, transform).toString()"""
    }
    // asIterable, asSequence, average, sum
}

//class Logger
//interface LoggingContext {
//    val log: Logger // This context provides a reference to a logger
//}
//
//context(LoggingContext)
//fun startBusinessOperation() {
//    // You can access the log property since LoggingContext is an implicit receiver
//    log.info("Operation has started")
//}
//
//fun test(loggingContext: LoggingContext) {
//    with(loggingContext) {
//        // You need to have LoggingContext in a scope as an implicit receiver
//        // to call startBusinessOperation()
//        startBusinessOperation()
//    }
//}