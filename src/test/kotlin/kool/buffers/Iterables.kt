package kool.buffers

import io.kotest.core.spec.style.StringSpec
import kool.charBufferOf
import kool.lib.zip


class Building_ {

    //        @Sample
    //        fun iterable() {
    //            val iterable = Iterable {
    //                iterator {
    //                    yield(42)
    //                    yieldAll(1..5 step 2)
    //                }
    //            }
    //            val result = iterable.mapIndexed { index, value -> "$index: $value" }
    //            assertPrints(result, "[0: 42, 1: 1, 2: 3, 3: 5]")
    //
    //            // can be iterated many times
    //            repeat(2) {
    //                val sum = iterable.sum()
    //                assertPrints(sum, "51")
    //            }
    //        }

}

class Operations : StringSpec() {

    init {
        //        @Sample
        //        fun flattenIterable() {
        //            val deepList = listOf(listOf(1), listOf(2, 3), listOf(4, 5, 6))
        //            assertPrints(deepList.flatten(), "[1, 2, 3, 4, 5, 6]")
        //        }
        //
        //        @Sample
        //        fun unzipIterable() {
        //            val list = listOf(1 to 'a', 2 to 'b', 3 to 'c')
        //            assertPrints(list.unzip(), "([1, 2, 3], [a, b, c])")
        //        }

        "zipIterable" {
            val listA = charBufferOf('a'..'c')
            val listB = listOf(1, 2, 3, 4)
            (listA zip listB) shouldPrint "[(a, 1), (b, 2), (c, 3)]"
        }

        "zipIterableWithTransform" {
            val listA = charBufferOf('a'..'c')
            val listB = listOf(1, 2, 3, 4)
            val result = listA.zip(listB) { a, b -> "$a$b" }
            result shouldPrint "[a1, b2, c3]"
        }

        //        @Sample
        //        fun partition() {
        //            data class Person(val name: String, val age: Int) {
        //                override fun toString(): String {
        //                    return "$name - $age"
        //                }
        //            }
        //
        //            val list = listOf(Person("Tom", 18), Person("Andy", 32), Person("Sarah", 22))
        //            val result = list.partition { it.age < 30 }
        //            assertPrints(result, "([Tom - 18, Sarah - 22], [Andy - 32])")
        //        }
    }
}