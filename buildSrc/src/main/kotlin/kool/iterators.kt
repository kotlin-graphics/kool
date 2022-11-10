package kool

import kool.gen.generate
import java.io.File

fun iterators(target: File) {

    generate(target, "kool/iterators.kt") {

        `package` = "kool"

//        suppressInlineWarning = true

        imports += listOf(
            "kool.pos"
                         )

        for (Type in types) {

            val typeBuffer = Type + "Buffer"
            val typeBufferIterator = typeBuffer + "Iterator"

            val type = if (Type == "Pointer") "Long" else Type

            imports += when (Type[0]) {
                'U' -> "kool.ubuffers.$typeBuffer"
                'P' -> "org.lwjgl.PointerBuffer"
                else -> "java.nio.$typeBuffer"
            }
            +"""
                operator fun $typeBuffer.iterator(): $typeBufferIterator = $typeBufferIterator(this)
                
                class $typeBufferIterator(private val buffer: $typeBuffer) : Iterator<$type> {
                    private var position: Int = buffer.pos
                    override fun next(): $type = buffer[position++]
                    override fun hasNext(): Boolean = position < buffer.lim
                }"""
        }
    }
}