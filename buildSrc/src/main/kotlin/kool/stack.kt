package kool

import kool.gen.Generator
import kool.gen.generate
import java.io.File

fun stack(target: File) {

    generate(target, "kool/stack.kt") {

        `package` = "kool"

        experimentals += Generator.Experimentals.Contracts
        //        suppressInlineWarning = true

        imports += listOf(
            "org.lwjgl.system.MemoryUtil",
            "org.lwjgl.system.MemoryStack",
            "java.nio.Buffer",
            //            "kool.adr",
                         )

        "object stack" {
            +"""        
                // --------------------------------------------- getters ---------------------------------------------

                inline fun <R, reified T> read(block: (Adr) -> R): T = when (T::class.java) {
                    Byte::class.java -> readByteFromAdr(block)
                    UByte::class.java -> readUByteFromAdr(block)
                    Short::class.java -> readShortFromAdr(block)
                    UShort::class.java -> readUShortFromAdr(block)
                    Int::class.java -> readIntFromAdr(block)
                    UInt::class.java -> readUIntFromAdr(block)
                    Long::class.java -> readLongFromAdr(block)
                    ULong::class.java -> readULongFromAdr(block)
                    Float::class.java -> readFloatFromAdr(block)
                    Double::class.java -> readDoubleFromAdr(block)
                    else -> error("")
                } as T
                /*inline fun <R, reified T> read(block: (ByteBuffer) -> R): T = when (T::class.java) {
                    Byte::class.java -> readByte(block)
                    UByte::class.java -> readUByte(block)
                    Short::class.java -> readShort(block)
                    UShort::class.java -> readUShort(block)
                    Int::class.java -> readInt(block)
                    UInt::class.java -> readUInt(block)
                    Long::class.java -> readLong(block)
                    ULong::class.java -> readULong(block)
                    Float::class.java -> readFloat(block)
                    Double::class.java -> readDouble(block)
                    else -> error("")
                } as T*/"""
            for (type in types.filter { it != "Char" && it != "Pointer" }) {

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
                val maybeU = if (unsigned) "U" else ""
                val mallocType = when (type) {
                    "Byte", "UByte" -> ""
                    else -> if (unsigned) type.drop(1) else type
                }
                val invoke = if (unsigned) "invoke$type" else "invoke"

                +"""
                    inline fun <R> read${type}FromAdr(block: (Adr) -> R): $type = with { Ptr$type().apply { block(adr) }.$invoke() }
                
                    inline fun <R> read${type}FromBuf(block: ($TypeBuffer) -> R): $type = with {
                        val buf = malloc$mallocType(1)$maybeAsUns
                        block(buf)
                        buf[0]
                    }"""
            }

            for (enc in listOf("ascii", "utf8", "utf16")) {
                val ENC = enc.toUpperCase()
                val Enc = enc.capitalize()
                +"""
                    /** It mallocs, passes the address and reads the null terminated string */
                    inline fun <R> read${Enc}FromAdr(maxSize: Int, block: (Adr) -> R): String = with {
                        val adr = nmalloc(1, maxSize)
                        block(adr.toULong())
                        return MemoryUtil.mem$ENC(adr, strlen64NT1(adr, maxSize))
                    }
                    
                    /** It mallocs the buffer, passes it and reads the null terminated string */
                    inline fun <R> read${Enc}FromBuf(maxSize: Int, block: (ByteBuffer) -> R): String = with {
                        val buf = malloc(1, maxSize)
                        block(buf)
                        return MemoryUtil.mem$ENC(buf.adr.toLong(), maxSize)
                    }"""
            }

            +"""
                // TODO, when limitation is lifted on contracts in members, implement it
                // @OptIn(ExperimentalContracts::class)
                inline operator fun <R> invoke(block: (MemoryStack) -> R): R = with(block)
                
                // --------------------------------------------- setters ---------------------------------------------"""

            for (Type in types.filter { it != "Char" && it != "Pointer" }) {
                val type = Type.toLowerCase()
                +"""
                    inline fun <R> writeToAdr($type: $Type, block: (Adr) -> R): R = with { block(ptrOf($type).adr) }
                    inline fun <R> writeToBuf($type: $Type, block: (${Type}Buffer) -> R): R = with { block(bufferOf($type)) }"""
            }

            for (enc in listOf("ascii", "utf8", "utf16")) {
                val ENC = enc.toUpperCase()
                val Enc = enc.capitalize()
                +"""
                    inline fun <R> write${Enc}ToAdr(chars: CharSequence, nullTerminated: Boolean = true, block: (Adr) -> R): R = 
                        with {
                            n$ENC(chars, nullTerminated)
                            block(pointerAddress.toULong()) 
                        }
                
                    inline fun <R> write${Enc}ToBuf(chars: CharSequence, nullTerminated: Boolean = true, block: (ByteBuffer) -> R): R =
                        with { block($ENC(chars, nullTerminated)) }"""
            }
        }

        +"""
            inline fun <R> stack.with(block: MemoryStack.() -> R): R {
                ${contract("block")}
                val stack = MemoryStack.stackGet()
                val ptr = stack.pointer
                return block(stack).also {
                    stack.pointer = ptr
                }
            }"""
    }
}