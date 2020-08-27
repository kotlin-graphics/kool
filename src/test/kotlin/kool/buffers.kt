package kool

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import kool.lib.indices

// as https://github.com/JetBrains/kotlin/blob/master/libraries/stdlib/samples/test/samples/collections/collections.kt

class buffers : StringSpec() {

    init {
        "indicesOfCollection" {
            val empty = emptyBuffer()
            empty.indices.isEmpty() shouldBe true
            val collection = charBufferOf('a', 'b', 'c')
            collection.indices.toString() shouldBe "0..2"
        }
    }
}