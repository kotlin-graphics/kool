package kool

import kool.gen.Generator
import kool.gen.generate
import java.io.File
import java.nio.ByteBuffer

fun conversions(target: File) {

    generate(target, "kool/conversions.kt") {

        `package` = "kool"

        //        suppressInlineWarning = true

        imports += listOf("org.lwjgl.system.MemoryUtil",
                          "java.nio.Buffer")

        for (type in types)
            conversions(type)
    }
}

fun Generator.conversions(type: String) {

    val TypeBuffer = type + "Buffer"
    val TypeArray = type + "Array"
    val unsigned = type[0] == 'U'
    val pointer = type[0] == 'P'

    imports += when {
        unsigned -> listOf(
            "kool.sliceAs",
            "kool.free",
            "kool.Adr",
            "kool.adr",
            "kool.rem",
            "kool.pos",
            "kool.cap",
            "kool.ubuffers.$TypeBuffer",
            "kool.ubuffers.as$TypeBuffer"
                          )
        pointer -> listOf(
            "org.lwjgl.PointerBuffer",
            "org.lwjgl.system.Pointer",
                         )
        else -> listOf(
            "java.nio.$TypeBuffer",
                      )
    }

    fun alloc() = docs("""
        Allocates a block of memory for the array and copy the data from the array to the new allocated memory.
        @param: size the number of elements to allocate.
        @return on success, the buffer representing the memory block allocated by the function
        @throws `OutOfMemoryError` if the function failed to allocate the requested block of memory""")

    val t = when {
        "Byte" in type -> "" // unsigned as well
        type == "Pointer" -> "Long"
        else -> if (unsigned) type.drop(1) else type
    }
    alloc()
    val maybeTimes = if ("Byte" in type) "" else if (type == "Pointer") " * Pointer.POINTER_SIZE" else " * $type.BYTES"
    val maybeU = if (unsigned && type != "UByte") "U" else ""
    val maybeU2 = if (unsigned) "U" else ""
    val maybeToUBuffer = if (unsigned) ".asUByteBuffer()" else ""
    +"""
        fun $TypeArray.to${maybeU}Buffer(): ${maybeU2}ByteBuffer {
            val res = MemoryUtil.memAlloc(size$maybeTimes)$maybeToUBuffer
            for (i in indices) 
                res.put$maybeU$t(i$maybeTimes, get(i))
            return res
        }"""
    alloc()
    +"fun $TypeArray.to${maybeU}ByteBuffer(): ${maybeU2}ByteBuffer = to${maybeU}Buffer()"
    if ("Byte" !in type) {
        alloc()
        +"fun $TypeArray.to$TypeBuffer(): $TypeBuffer = $TypeBuffer(size) { get(it) }"
    }
}