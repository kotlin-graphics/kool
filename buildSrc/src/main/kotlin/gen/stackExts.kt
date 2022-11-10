package gen

import gen.gen.Generator
import gen.gen.generate
import java.io.File

fun stackExts(target: File) {

    generate(target, "kool/stackExts.kt") {

        `package` = "kool"

        experimentals += Generator.Experimentals.UnsignedTypes
        //        suppressInlineWarning = true

        imports += listOf(
            "org.lwjgl.PointerBuffer",
            "org.lwjgl.system.Pointer",
            "org.lwjgl.system.MemoryStack",
            "org.lwjgl.system.MemoryUtil",
            "java.nio.Buffer",
            //            "kool.adr",
                         )

        for (type in types.filter { it != "Char" && it != "Pointer" }) {

            val `Ptr Type` = "Ptr<$type>"
            val PtrType = "Ptr$type"
            val typeBuffer = type + "Buffer"
            val ts = type.toLowerCase() + 's'

            for (i in 1..5) {
                var biJoint = (1..i).joinToString { "b$it: $type" }
                "fun MemoryStack.ptrOf($biJoint): $`Ptr Type`" {
                    +"val ptr = $PtrType($i)"
                    for (j in 0 until i)
                        +"ptr[$j] = b${j + 1}"
                    +"return ptr"
                }
                "fun MemoryStack.bufferOf($biJoint): $typeBuffer" {
                    +"val buf = $typeBuffer($i)"
                    for (j in 0 until i)
                        +"buf[$j] = b${j + 1}"
                    +"return buf"
                }
                if (type == "Pointer") {
                    biJoint = (1..i).joinToString { "b$it: Buffer" }
                    "fun MemoryStack.ptrOf($biJoint): $`Ptr Type`" {
                        +"val ptr = $PtrType($i)"
                        for (j in 0 until i)
                            +"ptr[$j] = b${j + 1}"
                        +"return ptr"
                    }
                    "fun MemoryStack.bufferOf($biJoint): $typeBuffer" {
                        +"val buf = $typeBuffer($i)"
                        for (j in 0 until i)
                            +"buf[$j] = b${j + 1}"
                        +"return buf"
                    }
                }
            }
            +"""
                fun MemoryStack.ptrOf(vararg $ts: $type): $`Ptr Type` {
                    val ptr = $PtrType($ts.size)
                    for (i in $ts.indices) 
                        ptr[i] = $ts[i]
                    return ptr
                }"""
            if (type == "Pointer")
                +"""
                    fun MemoryStack.ptrOf(vararg $ts: Buffer): $`Ptr Type` {
                        val ptr = $PtrType($ts.size)
                        for (i in $ts.indices) 
                            ptr[i] = $ts[i]
                        return ptr
                    }"""
        }

        +"// --------------------------------------------- getters ---------------------------------------------"

        +"""
            inline fun <R, reified T> MemoryStack.read(block: (Adr) -> R): T = when (T::class.java) {
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
            } as T"""

        for (Type in types.filter { it != "Char" && it != "Pointer" }) {

            val unsigned = Type[0] == 'U'

            if (Type != "Pointer") {
                imports += when {
                    unsigned -> "kool.ubuffers.${Type}Buffer"
                    else -> "java.nio.${Type}Buffer"
                }

                val invoke = if (unsigned) "invoke$Type" else "invoke"

                +"""
                    inline fun <R> MemoryStack.read${Type}FromAdr(block: (Adr) -> R): $Type = Ptr<$Type>().apply { block(adr) }.$invoke()
                    inline fun <R> MemoryStack.read${Type}FromBuf(block: (${Type}Buffer) -> R): $Type = ${Type}Buffer(1).also { block(it) }[0]
                    """
            }
        }

        +"""
            /*inline fun <R> MemoryStack.pointerAdr(block: (Adr) -> R): Ptr {
                val ptr = PointerPtr()
                block(ptr.adr)
                return ptr()
            }*/
            inline fun <R> MemoryStack.pointerBuffer(block: (PointerBuffer) -> R): Long {
                val buf = mallocPointer(1)
                block(buf)
                return buf[0]
            }"""

        for (enc in listOf("ascii", "utf8", "utf16")) {
            val ENC = enc.toUpperCase()
            val Enc = enc.capitalize()
            +"""
                /** It mallocs, passes the address and reads the null terminated string */
                inline fun <R> MemoryStack.read${Enc}FromAdr(maxSize: Int, block: (Adr) -> R): String {
                    val adr = nmalloc(1, maxSize)
                    block(adr.toULong())
                    return MemoryUtil.mem$ENC(adr, strlen64NT1(adr, maxSize))
                }
                
                /** It mallocs the buffer, passes it and reads the null terminated string */
                inline fun <R> MemoryStack.read${Enc}FromBuf(maxSize: Int, block: (ByteBuffer) -> R): String {
                    val buf = malloc(1, maxSize)
                    block(buf)
                    return MemoryUtil.mem$ENC(buf.adr.toLong(), maxSize)
                }"""
        }

        +"// --------------------------------------------- setters ---------------------------------------------"
        //        +"""
        //                inline fun MemoryStack.pointerAdr(ptr: Ptr): Adr = ptrOf(ptr).adr
        //                inline fun MemoryStack.pointerBuffer(ptr: Ptr): ByteBuffer = ${type}s($type)"""
        for (enc in listOf("ascii", "utf8", "utf16")) {
            val ENC = enc.toUpperCase()
            val Enc = enc.capitalize()
            +"""
                fun MemoryStack.write${Enc}ToAdr(chars: CharSequence, nullTerminated: Boolean = true): Adr = n$ENC(chars, nullTerminated).let { pointerAddress }.toULong()
                fun MemoryStack.write${Enc}ToBuffer(chars: CharSequence, nullTerminated: Boolean = true): ByteBuffer = $ENC(chars, nullTerminated)"""
        }
    }
}