package kool

import kool.gen.Generator
import kool.gen.generate
import java.io.File

fun extensions() {

    generate("extensions") {

        //        suppressInlineWarning = true

        imports += listOf("org.lwjgl.system.MemoryUtil",
                          "java.nio.Buffer")

        for (type in types.filter { it[0] != 'U' })
            extensions(type)
    }
}

fun Generator.extensions(type: String) {

    val TypeBuffer = type + "Buffer"
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
                          )
        pointer -> listOf(
            "org.lwjgl.PointerBuffer",
            //            "org.lwjgl.system.Pointer",
                         )
        else -> listOf(
            "java.nio.$TypeBuffer",
                      )
    }

    // TODO rename sliceAt?, imgui conflicts maybe
    docs("""
        Creates a new byte buffer whose content is a shared subsequence of this buffer's content.
        The content of the new buffer will start at [offset]. Changes to this buffer's content will be visible in the
        new buffer, and vice versa; the two buffers' position, limit, and mark values will be independent.
        The new buffer's position will be zero, its capacity and its limit will be [size], and its mark will be undefined. 
        The new buffer will be direct if, and only if, this buffer is direct, and it will be read-only if, and only if, this buffer is read-only.
        @return The new byte buffer""")
    if (unsigned)
        +"fun sliceAs(offset: Int, size: Int = lim - offset): $TypeBuffer = $TypeBuffer(buffer.sliceAs(offset, size))"
    else
        +"""
            fun $TypeBuffer.sliceAs(offset: Int, size: Int = lim - offset): $TypeBuffer {
                val backupPos = pos
                val backupLim = lim
                pos = offset
                lim = offset + size
                val res = slice()
                pos = backupPos
                lim = backupLim
                return res
            }"""

    docs("""
        The standard C free function.
        A block of memory previously allocated by a call to `memAlloc`, `memCalloc` or `memRealloc` is deallocated, making it available again for further allocations.""")
    suppressInlineWarning = true
    if (unsigned)
        +"inline fun free() = buffer.free()"
    else if (!pointer)
        +"inline fun $TypeBuffer.free() = MemoryUtil.memFree(this)"

    docs("""
        Returns the memory address at the current position of the buffer. This is effectively a pointer value that can be used in native function calls.
        @return the memory address""")
    if (unsigned)
        +"""
            inline val adr: Adr
                get() = buffer.adr"""
    else
        +"""
            inline val $TypeBuffer.adr: Adr
                get() = MemoryUtil.memAddress(this).toULong()"""

    docs("""
            This buffer's position.
            When assigning it, if the mark is defined and larger than the new position then it is discarded.""")
    if (unsigned)
        +"""
            inline var pos: Int
                get() = buffer.pos
                set(value) { buffer.pos = value }"""
    else
        +"""
            inline var $TypeBuffer.pos: Int
                get() = position()
                set(value) { position(value) }"""


    docs("Returns this buffer's capacity.")
    if (unsigned)
        +"""
            inline val cap: Int
                get() = buffer.cap"""
    else
        +"""
            inline val $TypeBuffer.cap: Int
                get() = capacity()"""

    docs("""
            Returns the number of elements between the current position and the limit.
            @return The number of elements remaining in this buffer""")
    if (unsigned)
        +"""
            inline val rem: Int
                get() = buffer.rem"""
    else
        +"""
            inline val $TypeBuffer.rem: Int
                get() = remaining()"""

    docs("Returns the total size in Bytes between the current position and the limit.")
    if (unsigned)
        +"""
            inline val remByte: Int
                get() = rem * $type.BYTES"""
    else if (pointer)
        +"""
            inline val $TypeBuffer.remByte: Int
                get() = rem * org.lwjgl.system.Pointer.POINTER_SIZE"""
    else
        +"""
            inline val $TypeBuffer.remByte: Int
                get() = rem * $type.BYTES"""

    docs("""
            This buffer's limit.
            When assigning it, if the position is larger than the new limit then it is set to the new limit. 
            If the mark is defined and larger than the new limit then it is discarded.""")
    if (unsigned)
        +"""
            inline var lim: Int
                get() = buffer.limit()
                set(value) { buffer.limit(value) }"""
    else
        +"""
            inline var $TypeBuffer.lim: Int
                get() = limit()
                set(value) { limit(value) }"""

    val t = type.decapitalize()
    fun set() = docs("""
        Absolute put method  (optional operation).
        Writes the given uint into this buffer at the given index.
        @param index The index at which the uint will be written
        @param $t The uint value to be written
        @return This buffer
        @throws IndexOutOfBoundsException If index is negative or not smaller than the buffer's limit
        @throws ReadOnlyBufferException If this buffer is read-only""")
    set()
    if (unsigned)
        +"operator fun set(index: Int, $t: $type): $TypeBuffer = put(index, $t)"
    else if (pointer) {
        set()
        +"operator fun PointerBuffer.set(index: Int, pointer: org.lwjgl.system.Pointer): PointerBuffer = put(index, pointer)"
        set()
        +"operator fun PointerBuffer.set(index: Int, pointer: Pointer): PointerBuffer = put(index, pointer.toLong())"
        set()
        +"operator fun PointerBuffer.set(index: Int, buffer: Buffer): PointerBuffer = put(index, buffer.adr.toLong())"
        set()
        +"operator fun PointerBuffer.set(index: Int, pointer: Long): PointerBuffer = put(index, pointer)"
    } else
        +"operator fun $TypeBuffer.set(index: Int, $t: $type): $TypeBuffer = put(index, $t)"
}