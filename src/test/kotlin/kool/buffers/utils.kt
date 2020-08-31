package kool.buffers

import io.kotest.matchers.shouldBe


infix fun Any.shouldPrint(string: String) = toString() shouldBe string