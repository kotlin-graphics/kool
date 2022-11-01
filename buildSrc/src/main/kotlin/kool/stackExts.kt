package kool

import kool.gen.Generator
import kool.gen.generate
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

        for (type in types) {

            val typePtr = type + "Ptr"
            val typeBuffer = type + "Buffer"
            val ts = type.toLowerCase() + 's'

            for (i in 1..5) {
                var biJoint = (1..i).joinToString { "b$it: $type" }
                "fun MemoryStack.ptrOf($biJoint): $typePtr" {
                    +"val ptr = $typePtr($i)"
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
                    "fun MemoryStack.ptrOf($biJoint): $typePtr" {
                        +"val ptr = $typePtr($i)"
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
                fun MemoryStack.ptrOf(vararg $ts: $type): $typePtr {
                    val ptr = $typePtr($ts.size)
                    for (i in $ts.indices) 
                        ptr[i] = $ts[i]
                    return ptr
                }"""
            if (type == "Pointer")
                +"""
                    fun MemoryStack.ptrOf(vararg $ts: Buffer): $typePtr {
                        val ptr = $typePtr($ts.size)
                        for (i in $ts.indices) 
                            ptr[i] = $ts[i]
                        return ptr
                    }"""
        }

        +"// --------------------------------------------- getters ---------------------------------------------"
        for (Type in types) {

            if (Type != "Pointer") {
                imports += when {
                    Type[0] == 'U' -> "kool.ubuffers.${Type}Buffer"
                    else -> "java.nio.${Type}Buffer"
                }

                val type = Type.decapitalize()
                +"""
                    inline fun <R> MemoryStack.${type}Adr(block: (Adr) -> R): $Type {
                        val ptr = ${Type}Ptr()
                        block(ptr.adr)
                        return ptr()
                    }
                    inline fun <R> MemoryStack.${type}Buffer(block: (${Type}Buffer) -> R): $Type {
                        val buf = ${Type}Buffer(1)
                        block(buf)
                        return buf[0]
                    }"""
            }
        }

        +"""
            inline fun <R> MemoryStack.pointerAdr(block: (Adr) -> R): Ptr {
                val ptr = PointerPtr()
                block(ptr.adr)
                return ptr()
            }
            inline fun <R> MemoryStack.pointerBuffer(block: (PointerBuffer) -> R): Ptr {
                val buf = mallocPointer(1)
                block(buf)
                return buf[0]
            }"""

        for (enc in listOf("ascii", "utf8", "utf16")) {
            val ENC = enc.toUpperCase()
            +"""
                /** It mallocs, passes the address and reads the null terminated string */
                inline fun <R> MemoryStack.${enc}Adr(maxSize: Int, block: (Adr) -> R): String {
                    val adr = nmalloc(1, maxSize)
                    block(adr)
                    return MemoryUtil.mem$ENC(adr, strlen64NT1(adr, maxSize))
                }
                
                /** It malloc the buffer, passes it and reads the null terminated string */
                inline fun <R> MemoryStack.${enc}Buffer(maxSize: Int, block: (ByteBuffer) -> R): String {
                    val buf = malloc(1, maxSize)
                    block(buf)
                    return MemoryUtil.mem$ENC(buf.adr, maxSize)
                }"""
        }

        +"// --------------------------------------------- setters ---------------------------------------------"
        //        +"""
        //                inline fun MemoryStack.pointerAdr(ptr: Ptr): Adr = ptrOf(ptr).adr
        //                inline fun MemoryStack.pointerBuffer(ptr: Ptr): ByteBuffer = ${type}s($type)"""
        for (enc in listOf("ascii", "utf8", "utf16")) {
            val ENC = enc.toUpperCase()
            +"""
                fun MemoryStack.${enc}Adr(chars: CharSequence, nullTerminated: Boolean = true): Adr = n$ENC(chars, nullTerminated).let { pointerAddress }
                fun MemoryStack.${enc}Buffer(chars: CharSequence, nullTerminated: Boolean = true): ByteBuffer = $ENC(chars, nullTerminated)"""
        }
    }
}