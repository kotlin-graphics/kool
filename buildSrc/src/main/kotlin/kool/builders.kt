package kool

import kool.gen.Generator
import kool.gen.generate
import java.io.File

fun builders(target: File) {

    generate(target, "kool/builders.kt") {

        `package` = "kool"

        experimentals += Generator.Experimentals.TypeInference
        //        suppressInlineWarning = true

        imports += listOf(
            "org.lwjgl.system.MemoryUtil",
            "org.lwjgl.system.MemoryStack",
            "java.nio.Buffer",
            "kool.adr")

        fun size() = docs("Creates a new buffer of the specified [size], with all elements initialized to zero.")

        fun init() = docs("""
                Creates a new array of the specified [size], where each element is calculated by calling 
                the specified [init] function.
                
                The function [init] is called for each array element sequentially starting from the first one.
                It should return the value for an array element given its index.""")

        for (type in types) {

            val TypeBuffer = type + "Buffer"
            val unsigned = type[0] == 'U'
            val pointer = type[0] == 'P'

            imports += when {
                unsigned -> listOf("kool.ubuffers.$TypeBuffer", "kool.ubuffers.as$TypeBuffer")
                pointer -> listOf("org.lwjgl.PointerBuffer",
                                  "org.lwjgl.system.Pointer")
                else -> listOf("java.nio.$TypeBuffer")
            }

            val maybeAsUns = if (unsigned) ".as$TypeBuffer()" else ""
            val maybeAsChar = if (type == "Char") ".asCharBuffer()" else ""
            val maybeU = if (unsigned) "U" else ""

            if ("Byte" in type) {

                docs("Creates a new empty buffer.")
                +"fun empty${maybeU}Buffer(): ${maybeU}ByteBuffer = MemoryUtil.memAlloc(0)$maybeAsUns"

                size()
                +"fun ${maybeU}Buffer(size: Int): ${maybeU}ByteBuffer = MemoryUtil.memCalloc(size)$maybeAsUns"

                size()
                +"fun MemoryStack.${maybeU}Buffer(size: Int): ${maybeU}ByteBuffer = calloc(size)$maybeAsUns"

                init()
                +"""
                    inline fun ${maybeU}Buffer(size: Int, init: (Int) -> ${maybeU}Byte): ${maybeU}ByteBuffer {
                        val buffer = MemoryUtil.memAlloc(size)$maybeAsUns
                        for (i in 0 until size)
                            buffer[i] = init(i)
                        return buffer
                    }"""
                init()
                +"""
                    inline fun MemoryStack.${maybeU}Buffer(size: Int, init: (Int) -> ${maybeU}Byte): ${maybeU}ByteBuffer {
                        val buffer = malloc(size)$maybeAsUns
                        for (i in 0 until size)
                            buffer[i] = init(i)
                        return buffer
                    }"""
            }

            val (allocType, maybeTimes) = when {
                "Byte" in type -> "" to "" // unsigned as well
                type == "Char" -> "" to " * Char.BYTES"
                else -> (if (unsigned) type.drop(1) else type) to ""
            }

            docs("Creates a new empty buffer.")
            +"fun empty$TypeBuffer(): $TypeBuffer = MemoryUtil.memCalloc$allocType(0)$maybeAsUns$maybeAsChar"

            size()
            +"fun $TypeBuffer(size: Int): $TypeBuffer = MemoryUtil.memCalloc$allocType(size$maybeTimes)$maybeAsUns$maybeAsChar"
            size()
            +"fun MemoryStack.$TypeBuffer(size: Int): $TypeBuffer = malloc$allocType(size$maybeTimes)$maybeAsUns$maybeAsChar"

            val type = if (type == "Pointer") "Ptr" else type

            if (type == "Ptr")
                for ((ret, postfix) in listOf("Long" to "", "Pointer" to "", "Buffer" to ".adr")) {
                    init()
                    +"""
                        @OverloadResolutionByLambdaReturnType
                        @kotlin.jvm.JvmName("PointerBuffer$ret")
                        inline fun PointerBuffer(size: Int, init: (Int) -> $ret): PointerBuffer {
                            val buffer = MemoryUtil.memAllocPointer(size)
                            for (i in 0 until size)
                                buffer[i] = init(i)$postfix
                            return buffer
                        }"""
                    init()
                    +"""
                        @OverloadResolutionByLambdaReturnType
                        @kotlin.jvm.JvmName("PointerBuffer$ret")
                        inline fun MemoryStack.PointerBuffer(size: Int, init: (Int) -> $ret): PointerBuffer {
                            val buffer = mallocPointer(size)
                            for (i in 0 until size)
                                buffer[i] = init(i)$postfix
                            return buffer
                        }"""
                }
            else {
                val alloc = when {
                    type == "Char" -> "MemoryUtil.memAlloc(size * Char.BYTES).asCharBuffer()"
                    else -> "MemoryUtil.memAlloc$allocType(size)$maybeAsUns"
                }
                init()
                +"""
                    inline fun $TypeBuffer(size: Int, init: (Int) -> $type): $TypeBuffer {
                        val buffer = $alloc
                        for (i in 0 until size)
                            buffer[i] = init(i)
                        return buffer
                    }"""
                val malloc = when {
                    type == "Char" -> "malloc(size * Char.BYTES).asCharBuffer()"
                    else -> "malloc$allocType(size)$maybeAsUns"
                }
                init()
                +"""
                    inline fun MemoryStack.$TypeBuffer(size: Int, init: (Int) -> $type): $TypeBuffer {
                        val buffer = $malloc
                        for (i in 0 until size)
                            buffer[i] = init(i)
                        return buffer
                    }"""
            }
        }
    }
}