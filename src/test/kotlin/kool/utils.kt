package kool

import java.nio.CharBuffer

infix fun <T> T.shouldBe(other: T) = assert(this == other)
infix fun Any.shouldPrint(string: String) = toString() shouldBe  string
infix fun CharBuffer.shouldPrint(string: String) = contentToString() shouldBe  string