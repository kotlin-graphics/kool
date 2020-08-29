package kool

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import kool.lib.indices
import kool.lib.isNotEmpty
import kool.lib.toTypedArray
import kotlin.test.Test

// as https://github.com/JetBrains/kotlin/blob/master/libraries/stdlib/samples/test/samples/collections/collections.kt


class Buffers {

//    @Test
    fun indicesOfCollection() {
            val empty = emptyBuffer()
            empty.indices.isEmpty() shouldBe true
            val collection = charBufferOf('a', 'b', 'c')
            collection.indices.toString() shouldBe "0..2"
        }

//        "collectionIsNotEmpty" {
//            val empty = emptyBuffer()
//            empty.isNotEmpty() shouldBe false
//
//            val collection = charBufferOf('a', 'b', 'c')
//            collection.isNotEmpty() shouldBe true
//        }

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