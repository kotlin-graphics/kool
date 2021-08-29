package kool.buffers

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import kool.*
import kool.lib.*
import org.junit.jupiter.api.assertThrows

// as https://github.com/JetBrains/kotlin/blob/master/libraries/stdlib/samples/test/samples/collections/collections.kt


class Collections : StringSpec() {

    init {

        "indicesOfCollection" {
            val empty = emptyBuffer()
            empty.indices.isEmpty() shouldBe true
            val collection = charBufferOf('a', 'b', 'c')
            collection.indices.toString() shouldBe "0..2"
        }

        "collectionIsNotEmpty" {
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
}

class Transformations : StringSpec() {

    init {

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

        "associateWith" {
            val words = intArrayOf(1, 1, 2, 3, 5)
            val withLength = words.associateWith { "$it" }
            withLength.keys shouldPrint "[1, 2, 3, 5]"
            withLength.values shouldPrint "[1, 2, 3, 5]"
        }

        "associateWithTo" {

            val scientists = intBufferOf(0, 1, 2, 3, 4)
            val withLengthOfNames = mutableMapOf<Int, Char>()
            withLengthOfNames.isEmpty() shouldBe true

            scientists.associateWithTo(withLengthOfNames) { 'a' + it }

            withLengthOfNames.isNotEmpty() shouldBe true
            // Jacob Bernoulli only occurs once in the map because only the last pair with the same key gets added
            withLengthOfNames shouldPrint "{0=a, 1=b, 2=c, 3=d, 4=e}"
        }

        //        @Sample
        //        fun distinctAndDistinctBy() {
        //            val list = listOf('a', 'A', 'b', 'B', 'A', 'a')
        //     +       assertPrints(list.distinct(), "[a, A, b, B]")
        //            assertPrints(list.distinctBy { it.toUpperCase() }, "[a, b]")
        //        }

        "groupBy" {
            val words = intBufferOf(1, 123, 12, 456, 1234)
            val byLength = words.groupBy { "$it".length }

            byLength.keys shouldPrint "[1, 3, 2, 4]"
            byLength.values shouldPrint "[[1], [123, 456], [12], [1234]]"

            val mutableByLength: MutableMap<Int, MutableList<Int>> =
                words.groupByTo(mutableMapOf()) { "$it".length }
            // same content as in byLength map, but the map is mutable
            mutableByLength shouldBe byLength
        }

        "groupByKeysAndValues" {
            val nameToTeam = charBufferOf('A', 'B', 'C')
            val namesByTeam = nameToTeam.groupBy({ it.code }, { it })
            namesByTeam shouldPrint "{${'A'.code}=[A], ${'B'.code}=[B], ${'C'.code}=[C]}"

            val mutableNamesByTeam = nameToTeam.groupByTo(HashMap(), { it.code }, { it })
            // same content as in namesByTeam map, but the map is mutable
            mutableNamesByTeam shouldBe namesByTeam
        }


        "joinTo" {
            val sb = StringBuilder("An existing string and a list: ")
            val numbers = intBufferOf(1, 2, 3)
            numbers.joinTo(sb, prefix = "[", postfix = "]") shouldPrint "An existing string and a list: [1, 2, 3]"

            val lotOfNumbers = intBufferOf(1..100)
            val firstNumbers = StringBuilder("First five numbers: ")
            lotOfNumbers.joinTo(firstNumbers, limit = 5) shouldPrint "First five numbers: 1, 2, 3, 4, 5, ..."
        }

        "joinToString" {
            val numbers = intBufferOf(1, 2, 3, 4, 5, 6)
            numbers.joinToString() shouldPrint "1, 2, 3, 4, 5, 6"
            numbers.joinToString(prefix = "[", postfix = "]") shouldPrint "[1, 2, 3, 4, 5, 6]"
            numbers.joinToString(prefix = "<", postfix = ">", separator = "•") shouldPrint "<1•2•3•4•5•6>"

            val chars = charBufferOf('a'..'q')
            chars.joinToString(limit = 5, truncated = "...!") {
                it.uppercaseChar().toString()
            } shouldPrint "A, B, C, D, E, ...!"
        }

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

        "flatMap" {
            val list = intBufferOf(123, 4567)
            list.flatMap { "$it".toList() }.toString() shouldBe "[1, 2, 3, 4, 5, 6, 7]"
        }

        "flatMapIndexed" {
            val data = charBufferOf('A', 'e', 'K')
            val selected = data.map { it.isUpperCase() }
            val result = data.flatMapIndexed { index, s -> if (selected[index]) listOf(s) else emptyList() }
            result shouldPrint "[A, K]"
        }

        "take" {
            val chars = charBufferOf('a'..'z')
            chars.take(3) shouldPrint "[a, b, c]"
            chars.takeWhile { it < 'f' } shouldPrint "[a, b, c, d, e]"
            chars.takeLast(2) shouldPrint "[y, z]"
            chars.takeLastWhile { it > 'w' } shouldPrint "[x, y, z]"
        }

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

        "distinctAndDistinctBy" {
            val list = charBufferOf('a', 'A', 'b', 'B', 'A', 'a')
            list.distinct() shouldPrint "[a, A, b, B]"
            list.distinctBy { it.uppercaseChar() } shouldPrint "[a, b]"
        }

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

        "drop" {
            val chars = charBufferOf('a'..'z')
            chars.drop(23) shouldPrint "[x, y, z]"
            chars.dropLast(23) shouldPrint "[a, b, c]"
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

class Aggregates : StringSpec() {

    init {

        //        @Sample
        //        fun all() {
        //            val isEven: (Int) -> Boolean = { it % 2 == 0 }
        //            val zeroToTen = 0..10
        //            assertFalse(zeroToTen.all { isEven(it) })
        //            assertFalse(zeroToTen.all(isEven))
        //
        //            val evens = zeroToTen.map { it * 2 }
        //            assertTrue(evens.all { isEven(it) })
        //
        //            val emptyList = emptyList<Int>()
        //            assertTrue(emptyList.all { false })
        //        }
        //
        //        @Sample
        //        fun none() {
        //            val emptyList = emptyList<Int>()
        //            assertTrue(emptyList.none())
        //
        //            val nonEmptyList = listOf("one", "two", "three")
        //            assertFalse(nonEmptyList.none())
        //        }
        //
        //        @Sample
        //        fun noneWithPredicate() {
        //            val isEven: (Int) -> Boolean = { it % 2 == 0 }
        //            val zeroToTen = 0..10
        //            assertFalse(zeroToTen.none { isEven(it) })
        //            assertFalse(zeroToTen.none(isEven))
        //
        //            val odds = zeroToTen.map { it * 2 + 1 }
        //            assertTrue(odds.none { isEven(it) })
        //
        //            val emptyList = emptyList<Int>()
        //            assertTrue(emptyList.none { true })
        //        }
        //
        //        @Sample
        //        fun any() {
        //            val emptyList = emptyList<Int>()
        //            assertFalse(emptyList.any())
        //
        //            val nonEmptyList = listOf(1, 2, 3)
        //            assertTrue(nonEmptyList.any())
        //        }
        //
        //        @Sample
        //        fun anyWithPredicate() {
        //            val isEven: (Int) -> Boolean = { it % 2 == 0 }
        //            val zeroToTen = 0..10
        //            assertTrue(zeroToTen.any { isEven(it) })
        //            assertTrue(zeroToTen.any(isEven))
        //
        //            val odds = zeroToTen.map { it * 2 + 1 }
        //            assertFalse(odds.any { isEven(it) })
        //
        //            val emptyList = emptyList<Int>()
        //            assertFalse(emptyList.any { true })
        //        }

        "maxByOrNull" {
            val nameToAge = intBufferOf(42, 28, 51)
            val oldestPerson = nameToAge.maxByOrNull { it }
            oldestPerson shouldBe 51

            val emptyList = emptyIntBuffer()
            val emptyMax = emptyList.maxByOrNull { it }
            emptyMax shouldBe null
        }

        "minByOrNull" {
            val list = charBufferOf('a'..'e')
            val shortestString = list.minByOrNull { it.code }
            shortestString shouldBe 'a'

            val emptyList = emptyCharBuffer()
            val emptyMin = emptyList.minByOrNull { it.code }
            emptyMin shouldBe null
        }

        "reduce" {
            val ints = intBufferOf(0..4)
            ints.reduce { acc, i -> acc + i } shouldBe 10
            ints.reduceIndexed { index, acc, i -> acc + i + index } shouldBe 20

            assertThrows<UnsupportedOperationException> { emptyIntBuffer().reduce { _, _ -> 0 } }
        }

        "reduceRight" {
            val ints = intBufferOf(0..4)
            ints.reduceRight { i, acc -> acc + i } shouldBe 10
            ints.reduceRightIndexed { index, i, acc -> acc + i + index } shouldBe 16

            assertThrows<UnsupportedOperationException> { emptyIntBuffer().reduceRight { _, _ -> 0 } }
        }

        "reduceOrNull" {
            val ints = intBufferOf(0..4)
            ints.reduceOrNull { acc, i -> acc + i } shouldBe 10
            ints.reduceIndexedOrNull { index, acc, i -> acc + i + index } shouldBe 20

            emptyIntBuffer().reduceOrNull { _, _ -> 0 } shouldBe null
        }

        "reduceRightOrNull" {
            val ints = intBufferOf(0..4)
            ints.reduceRightOrNull { i, acc -> acc + i } shouldBe 10
            ints.reduceRightIndexedOrNull { index, i, acc -> acc + i + index } shouldBe 16

            emptyIntBuffer().reduceRightOrNull { _, _ -> 0 } shouldBe null
        }

        "scan" {
            val strings = charBufferOf('a'..'d')
            strings.scan("s") { acc, string -> acc + string } shouldPrint "[s, sa, sab, sabc, sabcd]"
            strings.scanIndexed("s") { index, acc, string -> acc + string + index } shouldPrint "[s, sa0, sa0b1, sa0b1c2, sa0b1c2d3]"

            emptyCharBuffer().scan("s") { _, _ -> "X" } shouldPrint "[s]"
        }

        "runningFold" {
            val strings = charBufferOf('a'..'d')
            strings.runningFold("s") { acc, string -> acc + string } shouldPrint "[s, sa, sab, sabc, sabcd]"
            strings.runningFoldIndexed("s") { index, acc, string -> acc + string + index } shouldPrint "[s, sa0, sa0b1, sa0b1c2, sa0b1c2d3]"

            emptyCharBuffer().runningFold("s") { _, _ -> "X" } shouldPrint "[s]"
        }

        "runningReduce" {
            val chars = charBufferOf('a'..'d')
            chars.runningReduce { acc, char -> acc + (char - acc) } shouldPrint "[a, b, c, d]"
            chars.runningReduceIndexed { index, acc, char -> acc + (char - acc) + index } shouldPrint "[a, c, e, g]"

            emptyCharBuffer().runningReduce { _, _ -> 'X' } shouldPrint "[]"
        }
    }
}

class Sorting : StringSpec() {

    init {

        //        @Sample
        //        fun sortMutableList() {
        //            val mutableList = mutableListOf(4, 3, 2, 1)
        //
        //            // before sorting
        //            assertPrints(mutableList.joinToString(), "4, 3, 2, 1")
        //
        //            mutableList.sort()
        //
        //            // after sorting
        //            assertPrints(mutableList.joinToString(), "1, 2, 3, 4")
        //        }
        //
        //        @Sample
        //        fun sortMutableListWith() {
        //            // non-comparable class
        //            class Person(val firstName: String, val lastName: String) {
        //                override fun toString(): String = "$firstName $lastName"
        //            }
        //
        //            val people = mutableListOf(
        //                    Person("Ragnar", "Lodbrok"),
        //                    Person("Bjorn", "Ironside"),
        //                    Person("Sweyn", "Forkbeard")
        //            )
        //
        //            people.sortWith(compareByDescending { it.firstName })
        //
        //            // after sorting
        //            assertPrints(people.joinToString(), "Sweyn Forkbeard, Ragnar Lodbrok, Bjorn Ironside")
        //        }

        "sortedBy" {
            val list = intBufferOf(2, 3, 1)
            val sorted = list.sortedBy { it }

            list.contentToString() shouldBe "[2, 3, 1]"
            sorted shouldPrint "[1, 2, 3]"
        }
    }
}

class Filtering : StringSpec() {

    init {

        "filter" {
            val numbers = intBufferOf(1, 2, 3, 4, 5, 6, 7)
            val evenNumbers = numbers.filter { it % 2 == 0 }
            val notMultiplesOf3 = numbers.filterNot { number -> number % 3 == 0 }

            evenNumbers shouldPrint "[2, 4, 6]"
            notMultiplesOf3 shouldPrint "[1, 2, 4, 5, 7]"
        }

        "filterTo" {
            val numbers = intBufferOf(1, 2, 3, 4, 5, 6, 7)
            val evenNumbers = mutableListOf<Int>()
            val notMultiplesOf3 = mutableListOf<Int>()

            evenNumbers shouldPrint "[]"

            numbers.filterTo(evenNumbers) { it % 2 == 0 }
            numbers.filterNotTo(notMultiplesOf3) { number -> number % 3 == 0 }

            evenNumbers shouldPrint "[2, 4, 6]"
            notMultiplesOf3 shouldPrint "[1, 2, 4, 5, 7]"
        }

        // [Kool] it was filterNotNulla

        "filterNotZero" {
            val numbers = intBufferOf(1, 2, 0, 4)
            val nonNullNumbers = numbers.filterNotZero()

            nonNullNumbers shouldPrint "[1, 2, 4]"
        }

        "filterNotZeroTo" {
            val numbers = intBufferOf(1, 2, 0, 4)
            val nonNullNumbers = mutableListOf<Int>()

            nonNullNumbers shouldPrint "[]"

            numbers.filterNotZeroTo(nonNullNumbers)

            nonNullNumbers shouldPrint "[1, 2, 4]"
        }

        "filterIndexed" {
            val numbers = intBufferOf(0, 1, 2, 3, 4, 8, 6)
            val numbersOnSameIndexAsValue = numbers.filterIndexed { index, i -> index == i }

            numbersOnSameIndexAsValue shouldPrint "[0, 1, 2, 3, 4, 6]"
        }

        "filterIndexedTo" {
            val numbers = intBufferOf(0, 1, 2, 3, 4, 8, 6)
            val numbersOnSameIndexAsValue = mutableListOf<Int>()

            numbersOnSameIndexAsValue shouldPrint "[]"

            numbers.filterIndexedTo(numbersOnSameIndexAsValue) { index, i -> index == i }

            numbersOnSameIndexAsValue shouldPrint "[0, 1, 2, 3, 4, 6]"
        }

        //        @Sample
        //        fun filterIsInstance() {
        //            open class Animal(val name: String) {
        //                override fun toString(): String {
        //                    return name
        //                }
        //            }
        //            class Dog(name: String): Animal(name)
        //            class Cat(name: String): Animal(name)
        //
        //            val animals: List<Animal> = listOf(Cat("Scratchy"), Dog("Poochie"))
        //            val cats = animals.filterIsInstance<Cat>()
        //
        //            assertPrints(cats, "[Scratchy]")
        //        }
        //
        //        @Sample
        //        fun filterIsInstanceJVM() {
        //            open class Animal(val name: String) {
        //                override fun toString(): String {
        //                    return name
        //                }
        //            }
        //            class Dog(name: String): Animal(name)
        //            class Cat(name: String): Animal(name)
        //
        //            val animals: List<Animal> = listOf(Cat("Scratchy"), Dog("Poochie"))
        //            val cats = animals.filterIsInstance(Cat::class.java)
        //
        //            assertPrints(cats, "[Scratchy]")
        //        }
        //
        //        @Sample
        //        fun filterIsInstanceTo() {
        //            open class Animal(val name: String) {
        //                override fun toString(): String {
        //                    return name
        //                }
        //            }
        //            class Dog(name: String): Animal(name)
        //            class Cat(name: String): Animal(name)
        //
        //            val animals: List<Animal> = listOf(Cat("Scratchy"), Dog("Poochie"))
        //            val cats = mutableListOf<Cat>()
        //
        //            assertPrints(cats, "[]")
        //
        //            animals.filterIsInstanceTo<Cat, MutableList<Cat>>(cats)
        //
        //            assertPrints(cats, "[Scratchy]")
        //        }
        //
        //        @Sample
        //        fun filterIsInstanceToJVM() {
        //            open class Animal(val name: String) {
        //                override fun toString(): String {
        //                    return name
        //                }
        //            }
        //            class Dog(name: String): Animal(name)
        //            class Cat(name: String): Animal(name)
        //
        //            val animals: List<Animal> = listOf(Cat("Scratchy"), Dog("Poochie"))
        //            val cats = mutableListOf<Cat>()
        //
        //            assertPrints(cats, "[]")
        //
        //            animals.filterIsInstanceTo(cats, Cat::class.java)
        //
        //            assertPrints(cats, "[Scratchy]")
        //        }
    }
}