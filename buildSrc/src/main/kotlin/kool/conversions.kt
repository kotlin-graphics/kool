package kool

import kool.gen.Generator
import kool.gen.generate
import java.io.File

fun conversions() {

    generate("conversions") {

        experimentals += Generator.Experimentals.UnsignedTypes
        //        suppressInlineWarning = true

        imports += listOf("org.lwjgl.system.MemoryUtil",
                "java.nio.Buffer")

        for (type in types)
            arrays(type)
        for (type in types.filter { it != "Char" && it != "Pointer" })
            pointers(type)
    }
}

fun Generator.arrays(type: String) {

    val TypeBuffer = type + "Buffer"
    val TypeArray = type + "Array"
    val TypeArrayList = "ArrayList<$type>"
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
                "org.lwjgl.system.MemoryStack",
        )

        else -> listOf(
                "java.nio.$TypeBuffer",
        )
    }

    fun alloc(array: Boolean = true) = docs("""
        Allocates a block of memory for the array${if (array) "" else "list"} and copy the data from the array to the new allocated memory.
        @param: size the number of elements to allocate.
        @return on success, the buffer representing the memory block allocated by the function
        @throws `OutOfMemoryError` if the function failed to allocate the requested block of memory""")

    val t = when {
        "Byte" in type -> "" // unsigned as well
        type == "Pointer" -> return
        else -> if (unsigned) type.drop(1) else type
    }
    alloc()
    val maybeTimes = if ("Byte" in type) "" else if (type == "Pointer") " * Pointer.POINTER_SIZE" else " * $type.BYTES"
    val maybeU = if (unsigned && type != "UByte") "U" else ""
    val maybeU2 = if (unsigned) "U" else ""
    val maybeToUBuffer = if (unsigned) ".asUByteBuffer()" else ""
    for (receiver in listOf(TypeArray, TypeArrayList)) {
        if (receiver == TypeArrayList) +"@JvmName(\"${type}ToBuffer\")"
        +"""
        fun $receiver.to${maybeU}Buffer(): ${maybeU2}ByteBuffer {
            val res = MemoryUtil.memAlloc(size$maybeTimes)$maybeToUBuffer
            for (i in indices) 
                res.put$maybeU$t(i$maybeTimes, get(i))
            return res
        }"""
        if (receiver == TypeArrayList) +"@JvmName(\"${type}ToBuffer\")"
        +"""
        infix fun $receiver.to${maybeU}Buffer(stack: MemoryStack): ${maybeU2}ByteBuffer {
            val res = stack.malloc(size$maybeTimes)$maybeToUBuffer
            for (i in indices) 
                res.put$maybeU$t(i$maybeTimes, get(i))
            return res
        }"""
        alloc()
        if (receiver == TypeArrayList) +"@JvmName(\"${type}ToByteBuffer\")"
        +"fun $receiver.to${maybeU}ByteBuffer(): ${maybeU2}ByteBuffer = to${maybeU}Buffer()"
        if (receiver == TypeArrayList) +"@JvmName(\"${type}ToByteBuffer\")"
        +"infix fun $receiver.to${maybeU}ByteBuffer(stack: MemoryStack): ${maybeU2}ByteBuffer = to${maybeU}Buffer(stack)"
        if ("Byte" !in type) {
            alloc()
            +"fun $receiver.to$TypeBuffer(): $TypeBuffer = $TypeBuffer(size) { get(it) }"
            +"infix fun $receiver.to$TypeBuffer(stack: MemoryStack): $TypeBuffer = stack.$TypeBuffer(size) { get(it) }"
        }
    }
}

fun Generator.pointers(type: String) {

    val TypeArray = type + "Array"
//    val (maybeT, t) = if(type == "Pointer") "<T>" to "Long" else "" to ""

    +"""
        fun <T> $TypeArray.toPtr(): Ptr<T> {
            val res = MemoryUtil.nmemAlloc(size.toLong()).toPtr<$type>()
            for (i in indices) 
                res[i] = get(i)
            return res.toPtr()
        }
        fun <T> $TypeArray.toPtr(stack: MemoryStack): Ptr<T> {
            val res = stack.nmalloc(size).toPtr<$type>()
            for (i in indices) 
                res[i] = get(i)
            return res.toPtr()
        }"""
}