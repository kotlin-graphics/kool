package kool.buffers

import kool.*
import kotlin.test.Test

class Usage {

    //        @Sample
    //        fun arrayOrEmpty() {
    //            val nullArray: Array<Any>? = null
    //            assertPrints(nullArray.orEmpty().contentToString(), "[]")
    //
    //            val array: Array<Char>? = arrayOf('a', 'b', 'c')
    //            assertPrints(array.orEmpty().contentToString(), "[a, b, c]")
    //        }
    //
    //        @Sample
    //        fun arrayIsNullOrEmpty() {
    //            val nullArray: Array<Any>? = null
    //            assertTrue(nullArray.isNullOrEmpty())
    //
    //            val emptyArray: Array<Any>? = emptyArray<Any>()
    //            assertTrue(emptyArray.isNullOrEmpty())
    //
    //            val array: Array<Char>? = arrayOf('a', 'b', 'c')
    //            assertFalse(array.isNullOrEmpty())
    //        }
    //
    //        @Sample
    //        fun arrayIfEmpty() {
    //            val emptyArray: Array<Any> = emptyArray()
    //
    //            val emptyOrNull: Array<Any>? = emptyArray.ifEmpty { null }
    //            assertPrints(emptyOrNull, "null")
    //
    //            val emptyOrDefault: Array<Any> = emptyArray.ifEmpty { arrayOf("default") }
    //            assertPrints(emptyOrDefault.contentToString(), "[default]")
    //
    //            val nonEmptyArray = arrayOf(1)
    //            val sameArray = nonEmptyArray.ifEmpty { arrayOf(2) }
    //            assertTrue(nonEmptyArray === sameArray)
    //        }
}

class Transformations_ {
    @Test
    fun associateArrayOfPrimitives() {
        val charCodes = intBufferOf(72, 69, 76, 76, 79)

        val byCharCode = charCodes.associate { it to it.toChar() }

        // 76=L only occurs once because only the last pair with the same key gets added
        byCharCode shouldPrint "{72=H, 69=E, 76=L, 79=O}"
    }

    @Test
    fun associateArrayOfPrimitivesBy() {
        val charCodes = intBufferOf(72, 69, 76, 76, 79)

        val byChar = charCodes.associateBy { it.toChar() }

        // L=76 only occurs once because only the last pair with the same key gets added
        byChar shouldPrint "{H=72, E=69, L=76, O=79}"
    }

    @Test
    fun associateArrayOfPrimitivesByWithValueTransform() {
        val charCodes = intBufferOf(65, 65, 66, 67, 68, 69)

        val byUpperCase = charCodes.associateBy({ it.toChar() }, { (it + 32).toChar() })

        // A=a only occurs once because only the last pair with the same key gets added
        byUpperCase shouldPrint "{A=a, B=b, C=c, D=d, E=e}"
    }

    @Test
    fun associateArrayOfPrimitivesByTo() {
        val charCodes = intBufferOf(72, 69, 76, 76, 79)
        val byChar = mutableMapOf<Char, Int>()

        byChar.isEmpty() shouldBe true
        charCodes.associateByTo(byChar) { it.toChar() }

        byChar.isNotEmpty() shouldBe true
        // L=76 only occurs once because only the last pair with the same key gets added
        byChar shouldPrint "{H=72, E=69, L=76, O=79}"
    }

    @Test
    fun associateArrayOfPrimitivesByToWithValueTransform() {
        val charCodes = intBufferOf(65, 65, 66, 67, 68, 69)

        val byUpperCase = mutableMapOf<Char, Char>()
        charCodes.associateByTo(byUpperCase, { it.toChar() }, { (it + 32).toChar() })

        // A=a only occurs once because only the last pair with the same key gets added
        byUpperCase shouldPrint "{A=a, B=b, C=c, D=d, E=e}"
    }

    @Test
    fun associateArrayOfPrimitivesTo() {
        val charCodes = intBufferOf(72, 69, 76, 76, 79)

        val byChar = mutableMapOf<Int, Char>()
        charCodes.associateTo(byChar) { it to it.toChar() }

        // 76=L only occurs once because only the last pair with the same key gets added
        byChar shouldPrint "{72=H, 69=E, 76=L, 79=O}"
    }

        //        @Sample
        //        fun flattenArray() {
        //            val deepArray = arrayOf(
        //                    arrayOf(1),
        //                    arrayOf(2, 3),
        //                    arrayOf(4, 5, 6)
        //            )
        //
        //            assertPrints(deepArray.flatten(), "[1, 2, 3, 4, 5, 6]")
        //        }
        //
        //        @Sample
        //        fun unzipArray() {
        //            val array = arrayOf(1 to 'a', 2 to 'b', 3 to 'c')
        //            assertPrints(array.unzip(), "([1, 2, 3], [a, b, c])")
        //        }

    @Test
    fun partitionArrayOfPrimitives() {
        val array = intBufferOf(1, 2, 3, 4, 5)
        val (even, odd) = array.partition { it % 2 == 0 }
        even shouldPrint "[2, 4]"
        odd shouldPrint "[1, 3, 5]"
    }
}

class ContentOperations {
    @Test
    fun contentToString() {
        val array = intBufferOf(1, 2, 3)

        array.contentToString() shouldPrint "[1, 2, 3]"
    }

        //        @Sample
        //        fun contentDeepToString() {
        //            val matrix = arrayOf(
        //                    intArrayOf(3, 7, 9),
        //                    intArrayOf(0, 1, 0),
        //                    intArrayOf(2, 4, 8)
        //            )
        //
        //            assertPrints(matrix.contentDeepToString(), "[[3, 7, 9], [0, 1, 0], [2, 4, 8]]")
        //        }
    }

class CopyOfOperations {

//    @Test
//    fun copyOf() {
//        val array = intBufferOf(1, 1, 2, 3, 5)
//        val arrayCopy = array.copyOf()
//        arrayCopy.contentToString() shouldPrint "[1, 1, 2, 3, 5]"
//    }

        //        @Test
        //        fun resizingCopyOf() {
        //            val array = intBufferOf(3, 2, 1)
        //            val arrayCopyPadded = array.copyOf(5)
        //            arrayCopyPadded.contentToString() shouldPrint "[3, 2, 1, 0, 0]"
        //            val arrayCopyTruncated = array.copyOf(2)
        //            arrayCopyTruncated.contentToString() shouldPrint "[3, 2]"
        //        }
        //
        //        @Test
        //        fun resizedPrimitiveCopyOf() {
        //            val array = intBufferOf(1, 2, 3)
        //            val arrayCopyPadded = array.copyOf(5)
        //            arrayCopyPadded.contentToString() shouldPrint "[1, 2, 3, 0, 0]"
        //            val arrayCopyTruncated = array.copyOf(2)
        //            arrayCopyTruncated.contentToString() shouldPrint "[1, 2]"
        //        }
}

class Sorting_ {

    @Test
    fun sortArray() {
        val intArray = intBufferOf(4, 3, 2, 1)

        // before sorting
        intArray.joinToString() shouldPrint "4, 3, 2, 1"

        intArray.sort()

        // after sorting
        intArray.joinToString() shouldPrint "1, 2, 3, 4"
    }

        //        @Sample
        //        fun sortArrayOfComparable() {
        //            class Person(val firstName: String, val lastName: String) : Comparable<Person> {
        //                override fun compareTo(other: Person): Int = this.lastName.compareTo(other.lastName)
        //                override fun toString(): String = "$firstName $lastName"
        //            }
        //
        //            val people = arrayOf(
        //                    Person("Ragnar", "Lodbrok"),
        //                    Person("Bjorn", "Ironside"),
        //                    Person("Sweyn", "Forkbeard")
        //            )
        //
        //            // before sorting
        //            assertPrints(people.joinToString(), "Ragnar Lodbrok, Bjorn Ironside, Sweyn Forkbeard")
        //
        //            people.sort()
        //
        //            // after sorting
        //            assertPrints(people.joinToString(), "Sweyn Forkbeard, Bjorn Ironside, Ragnar Lodbrok")
        //
        //        }

    @Test
    fun sortRangeOfArray() {
        val intArray = intBufferOf(4, 3, 2, 1)

        // before sorting
        intArray.joinToString() shouldPrint "4, 3, 2, 1"

//        intArray.sort(0, 3)
//
//        // after sorting
//        intArray.joinToString() shouldPrint "2, 3, 4, 1"
    }

        //        @Sample
        //        fun sortRangeOfArrayOfComparable() {
        //            class Person(val firstName: String, val lastName: String) : Comparable<Person> {
        //                override fun compareTo(other: Person): Int = this.lastName.compareTo(other.lastName)
        //                override fun toString(): String = "$firstName $lastName"
        //            }
        //
        //            val people = arrayOf(
        //                    Person("Ragnar", "Lodbrok"),
        //                    Person("Bjorn", "Ironside"),
        //                    Person("Sweyn", "Forkbeard")
        //            )
        //
        //            // before sorting
        //            assertPrints(people.joinToString(), "Ragnar Lodbrok, Bjorn Ironside, Sweyn Forkbeard")
        //
        //            people.sort(0, 2)
        //
        //            // after sorting
        //            assertPrints(people.joinToString(), "Bjorn Ironside, Ragnar Lodbrok, Sweyn Forkbeard")
        //        }
}