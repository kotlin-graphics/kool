package kool

import io.kotest.matchers.shouldBe
import kool.lib.*
import kotlin.test.Test
import kotlin.text.dropLastWhile

// as https://github.com/JetBrains/kotlin/blob/master/libraries/stdlib/samples/test/samples/collections/collections.kt


class Buffers {

    class Collections {

        @Test
        fun indicesOfCollection() {
            val empty = emptyBuffer()
            empty.indices.isEmpty() shouldBe true
            val collection = charBufferOf('a', 'b', 'c')
            collection.indices.toString() shouldBe "0..2"
        }

        @Test
        fun collectionIsNotEmpty() {
            val empty = emptyBuffer()
            empty.isNotEmpty() shouldBe false

            val collection = charBufferOf('a', 'b', 'c')
            collection.isNotEmpty() shouldBe true
        }

//        @Sample
//        fun collectionOrEmpty() {
//            val nullCollection: Collection<Any>? = null
//            assertPrints(nullCollection.orEmpty(), "[]")
//
//            val collection: Collection<Char>? = listOf('a', 'b', 'c')
//            assertPrints(collection.orEmpty(), "[a, b, c]")
//        }
//
//        @Sample
//        fun collectionIsNullOrEmpty() {
//            val nullList: List<Any>? = null
//            assertTrue(nullList.isNullOrEmpty())
//
//            val empty: List<Any>? = emptyList<Any>()
//            assertTrue(empty.isNullOrEmpty())
//
//            val collection: List<Char>? = listOf('a', 'b', 'c')
//            assertFalse(collection.isNullOrEmpty())
//        }
//
//        @Sample
//        fun collectionIfEmpty() {
//            val empty: List<Int> = emptyList()
//
//            val emptyOrNull: List<Int>? = empty.ifEmpty { null }
//            assertPrints(emptyOrNull, "null")
//
//            val emptyOrDefault: List<Any> = empty.ifEmpty { listOf("default") }
//            assertPrints(emptyOrDefault, "[default]")
//
//            val nonEmpty = listOf("x")
//            val sameList: List<String> = nonEmpty.ifEmpty { listOf("empty") }
//            assertTrue(nonEmpty === sameList)
//        }
//
//        @Sample
//        fun collectionContainsAll() {
//            val collection = mutableListOf('a', 'b')
//            val test = listOf('a', 'b', 'c')
//            assertFalse(collection.containsAll(test))
//
//            collection.add('c')
//            assertTrue(collection.containsAll(test))
//        }

//        "collectionToTypedArray" {
//            val collection = intBufferOf(1, 2, 3)
//            val array = collection.toTypedArray()
//            array.contentToString() shouldBe "[1, 2, 3]"
//        }
//    }
    }

    class Transformations {

//        @Sample
//        fun associate() {
//            val names = listOf("Grace Hopper", "Jacob Bernoulli", "Johann Bernoulli")
//
//            val byLastName = names.associate { it.split(" ").let { (firstName, lastName) -> lastName to firstName } }
//
//            // Jacob Bernoulli does not occur in the map because only the last pair with the same key gets added
//            assertPrints(byLastName, "{Hopper=Grace, Bernoulli=Johann}")
//        }
//
//        @Sample
//        fun associateBy() {
//            data class Person(val firstName: String, val lastName: String) {
//                override fun toString(): String = "$firstName $lastName"
//            }
//
//            val scientists = listOf(Person("Grace", "Hopper"), Person("Jacob", "Bernoulli"), Person("Johann", "Bernoulli"))
//
//            val byLastName = scientists.associateBy { it.lastName }
//
//            // Jacob Bernoulli does not occur in the map because only the last pair with the same key gets added
//            assertPrints(byLastName, "{Hopper=Grace Hopper, Bernoulli=Johann Bernoulli}")
//        }
//
//        @Sample
//        fun associateByWithValueTransform() {
//            data class Person(val firstName: String, val lastName: String)
//
//            val scientists = listOf(Person("Grace", "Hopper"), Person("Jacob", "Bernoulli"), Person("Johann", "Bernoulli"))
//
//            val byLastName = scientists.associateBy({ it.lastName }, { it.firstName })
//
//            // Jacob Bernoulli does not occur in the map because only the last pair with the same key gets added
//            assertPrints(byLastName, "{Hopper=Grace, Bernoulli=Johann}")
//        }
//
//        @Sample
//        fun associateByTo() {
//            data class Person(val firstName: String, val lastName: String) {
//                override fun toString(): String = "$firstName $lastName"
//            }
//
//            val scientists = listOf(Person("Grace", "Hopper"), Person("Jacob", "Bernoulli"), Person("Johann", "Bernoulli"))
//
//            val byLastName = mutableMapOf<String, Person>()
//            assertTrue(byLastName.isEmpty())
//
//            scientists.associateByTo(byLastName) { it.lastName }
//
//            assertTrue(byLastName.isNotEmpty())
//            // Jacob Bernoulli does not occur in the map because only the last pair with the same key gets added
//            assertPrints(byLastName, "{Hopper=Grace Hopper, Bernoulli=Johann Bernoulli}")
//        }
//
//        @Sample
//        fun associateByToWithValueTransform() {
//            data class Person(val firstName: String, val lastName: String)
//
//            val scientists = listOf(Person("Grace", "Hopper"), Person("Jacob", "Bernoulli"), Person("Johann", "Bernoulli"))
//
//            val byLastName = mutableMapOf<String, String>()
//            assertTrue(byLastName.isEmpty())
//
//            scientists.associateByTo(byLastName, { it.lastName }, { it.firstName} )
//
//            assertTrue(byLastName.isNotEmpty())
//            // Jacob Bernoulli does not occur in the map because only the last pair with the same key gets added
//            assertPrints(byLastName, "{Hopper=Grace, Bernoulli=Johann}")
//        }
//
//        @Sample
//        fun associateTo() {
//            data class Person(val firstName: String, val lastName: String)
//
//            val scientists = listOf(Person("Grace", "Hopper"), Person("Jacob", "Bernoulli"), Person("Johann", "Bernoulli"))
//
//            val byLastName = mutableMapOf<String, String>()
//            assertTrue(byLastName.isEmpty())
//
//            scientists.associateTo(byLastName) { it.lastName to it.firstName }
//
//            assertTrue(byLastName.isNotEmpty())
//            // Jacob Bernoulli does not occur in the map because only the last pair with the same key gets added
//            assertPrints(byLastName, "{Hopper=Grace, Bernoulli=Johann}")
//        }
//
//        @Sample
//        fun associateWith() {
//            val words = listOf("a", "abc", "ab", "def", "abcd")
//            val withLength = words.associateWith { it.length }
//            assertPrints(withLength.keys, "[a, abc, ab, def, abcd]")
//            assertPrints(withLength.values, "[1, 3, 2, 3, 4]")
//        }
//
//        @Sample
//        fun associateWithTo() {
//            data class Person(val firstName: String, val lastName: String) {
//                override fun toString(): String = "$firstName $lastName"
//            }
//
//            val scientists = listOf(Person("Grace", "Hopper"), Person("Jacob", "Bernoulli"), Person("Jacob", "Bernoulli"))
//            val withLengthOfNames = mutableMapOf<Person, Int>()
//            assertTrue(withLengthOfNames.isEmpty())
//
//            scientists.associateWithTo(withLengthOfNames) { it.firstName.length + it.lastName.length }
//
//            assertTrue(withLengthOfNames.isNotEmpty())
//            // Jacob Bernoulli only occurs once in the map because only the last pair with the same key gets added
//            assertPrints(withLengthOfNames, "{Grace Hopper=11, Jacob Bernoulli=14}")
//        }
//
//        @Sample
//        fun distinctAndDistinctBy() {
//            val list = listOf('a', 'A', 'b', 'B', 'A', 'a')
//     +       assertPrints(list.distinct(), "[a, A, b, B]")
//            assertPrints(list.distinctBy { it.toUpperCase() }, "[a, b]")
//        }
//
//        @Sample
//        fun groupBy() {
//            val words = listOf("a", "abc", "ab", "def", "abcd")
//            val byLength = words.groupBy { it.length }
//
//            assertPrints(byLength.keys, "[1, 3, 2, 4]")
//            assertPrints(byLength.values, "[[a], [abc, def], [ab], [abcd]]")
//
//            val mutableByLength: MutableMap<Int, MutableList<String>> = words.groupByTo(mutableMapOf()) { it.length }
//            // same content as in byLength map, but the map is mutable
//            assertTrue(mutableByLength == byLength)
//        }
//
//        @Sample
//        fun groupByKeysAndValues() {
//            val nameToTeam = listOf("Alice" to "Marketing", "Bob" to "Sales", "Carol" to "Marketing")
//            val namesByTeam = nameToTeam.groupBy({ it.second }, { it.first })
//            assertPrints(namesByTeam, "{Marketing=[Alice, Carol], Sales=[Bob]}")
//
//            val mutableNamesByTeam = nameToTeam.groupByTo(HashMap(), { it.second }, { it.first })
//            // same content as in namesByTeam map, but the map is mutable
//            assertTrue(mutableNamesByTeam == namesByTeam)
//        }
//
//
//
//        @Sample
//        fun joinTo() {
//            val sb = StringBuilder("An existing string and a list: ")
//            val numbers = listOf(1, 2, 3)
//            assertPrints(numbers.joinTo(sb, prefix = "[", postfix = "]").toString(), "An existing string and a list: [1, 2, 3]")
//
//            val lotOfNumbers: Iterable<Int> = 1..100
//            val firstNumbers = StringBuilder("First five numbers: ")
//            assertPrints(lotOfNumbers.joinTo(firstNumbers, limit = 5).toString(), "First five numbers: 1, 2, 3, 4, 5, ...")
//        }
//
//        @Sample
//        fun joinToString() {
//            val numbers = listOf(1, 2, 3, 4, 5, 6)
//            assertPrints(numbers.joinToString(), "1, 2, 3, 4, 5, 6")
//            assertPrints(numbers.joinToString(prefix = "[", postfix = "]"), "[1, 2, 3, 4, 5, 6]")
//            assertPrints(numbers.joinToString(prefix = "<", postfix = ">", separator = "•"), "<1•2•3•4•5•6>")
//
//            val chars = charArrayOf('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q')
//            assertPrints(chars.joinToString(limit = 5, truncated = "...!") { it.toUpperCase().toString() }, "A, B, C, D, E, ...!")
//        }
//
//        @Sample
//        fun map() {
//            val numbers = listOf(1, 2, 3)
//            assertPrints(numbers.map { it * it }, "[1, 4, 9]")
//        }
//
//        @Sample
//        fun mapNotNull() {
//            val strings: List<String> = listOf("12a", "45", "", "3")
//            val ints: List<Int> = strings.mapNotNull { it.toIntOrNull() }
//
//            assertPrints(ints, "[45, 3]")
//            assertPrints(ints.sum(), "48")
//        }
//
//        @Sample
//        fun flatMap() {
//            val list = listOf("123", "45")
//            assertPrints(list.flatMap { it.toList() }, "[1, 2, 3, 4, 5]")
//        }
//
//        @Sample
//        fun flatMapIndexed() {
//            val data: List<String> = listOf("Abcd", "efgh", "Klmn")
//            val selected: List<Boolean> = data.map { it.any { c -> c.isUpperCase() } }
//            val result = data.flatMapIndexed { index, s -> if (selected[index]) s.toList() else emptyList() }
//            assertPrints(result, "[A, b, c, d, K, l, m, n]")
//        }
//
//        @Sample
//        fun take() {
//            val chars = ('a'..'z').toList()
//            assertPrints(chars.take(3), "[a, b, c]")
//            assertPrints(chars.takeWhile { it < 'f' }, "[a, b, c, d, e]")
//            assertPrints(chars.takeLast(2), "[y, z]")
//            assertPrints(chars.takeLastWhile { it > 'w' }, "[x, y, z]")
//        }
//
//        @Sample
//        fun drop() {
//            val chars = ('a'..'z').toList()
//            assertPrints(chars.drop(23), "[x, y, z]")
//            assertPrints(chars.dropLast(23), "[a, b, c]")
//            assertPrints(chars.dropWhile { it < 'x' }, "[x, y, z]")
//            assertPrints(chars.dropLastWhile { it > 'c' }, "[a, b, c]")
//        }
//
//        @Sample
//        fun chunked() {
//            val words = "one two three four five six seven eight nine ten".split(' ')
//            val chunks = words.chunked(3)
//
//            assertPrints(chunks, "[[one, two, three], [four, five, six], [seven, eight, nine], [ten]]")
//        }
//
//        @Sample
//        fun zipWithNext() {
//            val letters = ('a'..'f').toList()
//            val pairs = letters.zipWithNext()
//
//            assertPrints(letters, "[a, b, c, d, e, f]")
//            assertPrints(pairs, "[(a, b), (b, c), (c, d), (d, e), (e, f)]")
//        }
//
//        @Sample
//        fun zipWithNextToFindDeltas() {
//            val values = listOf(1, 4, 9, 16, 25, 36)
//            val deltas = values.zipWithNext { a, b -> b - a }
//
//            assertPrints(deltas, "[3, 5, 7, 9, 11]")
//        }
//        fun associate() {
//            val names = listOf("Grace Hopper", "Jacob Bernoulli", "Johann Bernoulli")
//
//            val byLastName = names.associate { it.split(" ").let { (firstName, lastName) -> lastName to firstName } }
//
//            // Jacob Bernoulli does not occur in the map because only the last pair with the same key gets added
//            assertPrints(byLastName, "{Hopper=Grace, Bernoulli=Johann}")
//        }
//
//        @Sample
//        fun associateBy() {
//            data class Person(val firstName: String, val lastName: String) {
//                override fun toString(): String = "$firstName $lastName"
//            }
//
//            val scientists = listOf(Person("Grace", "Hopper"), Person("Jacob", "Bernoulli"), Person("Johann", "Bernoulli"))
//
//            val byLastName = scientists.associateBy { it.lastName }
//
//            // Jacob Bernoulli does not occur in the map because only the last pair with the same key gets added
//            assertPrints(byLastName, "{Hopper=Grace Hopper, Bernoulli=Johann Bernoulli}")
//        }
//
//        @Sample
//        fun associateByWithValueTransform() {
//            data class Person(val firstName: String, val lastName: String)
//
//            val scientists = listOf(Person("Grace", "Hopper"), Person("Jacob", "Bernoulli"), Person("Johann", "Bernoulli"))
//
//            val byLastName = scientists.associateBy({ it.lastName }, { it.firstName })
//
//            // Jacob Bernoulli does not occur in the map because only the last pair with the same key gets added
//            assertPrints(byLastName, "{Hopper=Grace, Bernoulli=Johann}")
//        }
//
//        @Sample
//        fun associateByTo() {
//            data class Person(val firstName: String, val lastName: String) {
//                override fun toString(): String = "$firstName $lastName"
//            }
//
//            val scientists = listOf(Person("Grace", "Hopper"), Person("Jacob", "Bernoulli"), Person("Johann", "Bernoulli"))
//
//            val byLastName = mutableMapOf<String, Person>()
//            assertTrue(byLastName.isEmpty())
//
//            scientists.associateByTo(byLastName) { it.lastName }
//
//            assertTrue(byLastName.isNotEmpty())
//            // Jacob Bernoulli does not occur in the map because only the last pair with the same key gets added
//            assertPrints(byLastName, "{Hopper=Grace Hopper, Bernoulli=Johann Bernoulli}")
//        }
//
//        @Sample
//        fun associateByToWithValueTransform() {
//            data class Person(val firstName: String, val lastName: String)
//
//            val scientists = listOf(Person("Grace", "Hopper"), Person("Jacob", "Bernoulli"), Person("Johann", "Bernoulli"))
//
//            val byLastName = mutableMapOf<String, String>()
//            assertTrue(byLastName.isEmpty())
//
//            scientists.associateByTo(byLastName, { it.lastName }, { it.firstName} )
//
//            assertTrue(byLastName.isNotEmpty())
//            // Jacob Bernoulli does not occur in the map because only the last pair with the same key gets added
//            assertPrints(byLastName, "{Hopper=Grace, Bernoulli=Johann}")
//        }
//
//        @Sample
//        fun associateTo() {
//            data class Person(val firstName: String, val lastName: String)
//
//            val scientists = listOf(Person("Grace", "Hopper"), Person("Jacob", "Bernoulli"), Person("Johann", "Bernoulli"))
//
//            val byLastName = mutableMapOf<String, String>()
//            assertTrue(byLastName.isEmpty())
//
//            scientists.associateTo(byLastName) { it.lastName to it.firstName }
//
//            assertTrue(byLastName.isNotEmpty())
//            // Jacob Bernoulli does not occur in the map because only the last pair with the same key gets added
//            assertPrints(byLastName, "{Hopper=Grace, Bernoulli=Johann}")
//        }
//
//        @Sample
//        fun associateWith() {
//            val words = listOf("a", "abc", "ab", "def", "abcd")
//            val withLength = words.associateWith { it.length }
//            assertPrints(withLength.keys, "[a, abc, ab, def, abcd]")
//            assertPrints(withLength.values, "[1, 3, 2, 3, 4]")
//        }
//
//        @Sample
//        fun associateWithTo() {
//            data class Person(val firstName: String, val lastName: String) {
//                override fun toString(): String = "$firstName $lastName"
//            }
//
//            val scientists = listOf(Person("Grace", "Hopper"), Person("Jacob", "Bernoulli"), Person("Jacob", "Bernoulli"))
//            val withLengthOfNames = mutableMapOf<Person, Int>()
//            assertTrue(withLengthOfNames.isEmpty())
//
//            scientists.associateWithTo(withLengthOfNames) { it.firstName.length + it.lastName.length }
//
//            assertTrue(withLengthOfNames.isNotEmpty())
//            // Jacob Bernoulli only occurs once in the map because only the last pair with the same key gets added
//            assertPrints(withLengthOfNames, "{Grace Hopper=11, Jacob Bernoulli=14}")
//        }
//
//        @Sample
//        fun distinctAndDistinctBy() {
//            val list = listOf('a', 'A', 'b', 'B', 'A', 'a')
//     +       assertPrints(list.distinct(), "[a, A, b, B]")
//            assertPrints(list.distinctBy { it.toUpperCase() }, "[a, b]")
//        }
//
//        @Sample
//        fun groupBy() {
//            val words = listOf("a", "abc", "ab", "def", "abcd")
//            val byLength = words.groupBy { it.length }
//
//            assertPrints(byLength.keys, "[1, 3, 2, 4]")
//            assertPrints(byLength.values, "[[a], [abc, def], [ab], [abcd]]")
//
//            val mutableByLength: MutableMap<Int, MutableList<String>> = words.groupByTo(mutableMapOf()) { it.length }
//            // same content as in byLength map, but the map is mutable
//            assertTrue(mutableByLength == byLength)
//        }
//
//        @Sample
//        fun groupByKeysAndValues() {
//            val nameToTeam = listOf("Alice" to "Marketing", "Bob" to "Sales", "Carol" to "Marketing")
//            val namesByTeam = nameToTeam.groupBy({ it.second }, { it.first })
//            assertPrints(namesByTeam, "{Marketing=[Alice, Carol], Sales=[Bob]}")
//
//            val mutableNamesByTeam = nameToTeam.groupByTo(HashMap(), { it.second }, { it.first })
//            // same content as in namesByTeam map, but the map is mutable
//            assertTrue(mutableNamesByTeam == namesByTeam)
//        }
//
//
//
//        @Sample
//        fun joinTo() {
//            val sb = StringBuilder("An existing string and a list: ")
//            val numbers = listOf(1, 2, 3)
//            assertPrints(numbers.joinTo(sb, prefix = "[", postfix = "]").toString(), "An existing string and a list: [1, 2, 3]")
//
//            val lotOfNumbers: Iterable<Int> = 1..100
//            val firstNumbers = StringBuilder("First five numbers: ")
//            assertPrints(lotOfNumbers.joinTo(firstNumbers, limit = 5).toString(), "First five numbers: 1, 2, 3, 4, 5, ...")
//        }
//
//        @Sample
//        fun joinToString() {
//            val numbers = listOf(1, 2, 3, 4, 5, 6)
//            assertPrints(numbers.joinToString(), "1, 2, 3, 4, 5, 6")
//            assertPrints(numbers.joinToString(prefix = "[", postfix = "]"), "[1, 2, 3, 4, 5, 6]")
//            assertPrints(numbers.joinToString(prefix = "<", postfix = ">", separator = "•"), "<1•2•3•4•5•6>")
//
//            val chars = charArrayOf('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q')
//            assertPrints(chars.joinToString(limit = 5, truncated = "...!") { it.toUpperCase().toString() }, "A, B, C, D, E, ...!")
//        }
//
//        @Sample
//        fun map() {
//            val numbers = listOf(1, 2, 3)
//            assertPrints(numbers.map { it * it }, "[1, 4, 9]")
//        }
//
//        @Sample
//        fun mapNotNull() {
//            val strings: List<String> = listOf("12a", "45", "", "3")
//            val ints: List<Int> = strings.mapNotNull { it.toIntOrNull() }
//
//            assertPrints(ints, "[45, 3]")
//            assertPrints(ints.sum(), "48")
//        }
//
//        @Sample
//        fun flatMap() {
//            val list = listOf("123", "45")
//            assertPrints(list.flatMap { it.toList() }, "[1, 2, 3, 4, 5]")
//        }
//
//        @Sample
//        fun flatMapIndexed() {
//            val data: List<String> = listOf("Abcd", "efgh", "Klmn")
//            val selected: List<Boolean> = data.map { it.any { c -> c.isUpperCase() } }
//            val result = data.flatMapIndexed { index, s -> if (selected[index]) s.toList() else emptyList() }
//            assertPrints(result, "[A, b, c, d, K, l, m, n]")
//        }
//
//        @Sample
//        fun take() {
//            val chars = ('a'..'z').toList()
//            assertPrints(chars.take(3), "[a, b, c]")
//            assertPrints(chars.takeWhile { it < 'f' }, "[a, b, c, d, e]")
//            assertPrints(chars.takeLast(2), "[y, z]")
//            assertPrints(chars.takeLastWhile { it > 'w' }, "[x, y, z]")
//        }

        @Test
        fun drop() {
            val chars = charBufferOf('a'..'z')
            chars.drop(23) shouldPrint "[x, y, z]"
            chars.dropLast(23) shouldPrint  "[a, b, c]"
            chars.dropWhile_ { it < 'x' } shouldPrint "[x, y, z]"
            chars.dropLastWhile_ { it > 'c' } shouldPrint "[a, b, c]"

            val ints = intBufferOf(0..9)
            ints.drop(7) shouldPrint "[7, 8, 9]"
            ints.dropLast(7) shouldPrint "[0, 1, 2]"
            ints.dropWhile { it < 7 } shouldPrint "[7, 8, 9]"
            ints.dropLastWhile { it > 2 } shouldPrint "[0, 1, 2]"
        }

//        @Sample
//        fun chunked() {
//            val words = "one two three four five six seven eight nine ten".split(' ')
//            val chunks = words.chunked(3)
//
//            assertPrints(chunks, "[[one, two, three], [four, five, six], [seven, eight, nine], [ten]]")
//        }
//
//        @Sample
//        fun zipWithNext() {
//            val letters = ('a'..'f').toList()
//            val pairs = letters.zipWithNext()
//
//            assertPrints(letters, "[a, b, c, d, e, f]")
//            assertPrints(pairs, "[(a, b), (b, c), (c, d), (d, e), (e, f)]")
//        }
//
//        @Sample
//        fun zipWithNextToFindDeltas() {
//            val values = listOf(1, 4, 9, 16, 25, 36)
//            val deltas = values.zipWithNext { a, b -> b - a }
//
//            assertPrints(deltas, "[3, 5, 7, 9, 11]")
//        }
    }
}

infix fun Any.shouldPrint(string: String) = toString() shouldBe string