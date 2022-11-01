package kool

import kool.gen.generate
import kool.gen.Generator
import java.io.File

fun pointers(target: File) {

    generate(target, "kool/pointers.kt") {

        `package` = "kool"

        experimentals += Generator.Experimentals.TypeInference
        suppressInlineWarning = true

        imports += listOf(
            "org.lwjgl.system.MemoryUtil",
            "org.lwjgl.system.MemoryStack",
            "org.lwjgl.PointerBuffer",
            "org.lwjgl.system.Pointer",
            "java.nio.Buffer",
            "kool.adr",
                         )

        for (Type in types) {

            val TypeBuffer = Type + "Buffer"
            val maybeTimes = if ("Byte" in Type) "" else " * $Type.BYTES"
            val type = Type.decapitalize()
            val unsigned = Type[0] == 'U'
            imports += when {
                unsigned -> listOf("kool.ubuffers.$TypeBuffer", "kool.ubuffers.as$TypeBuffer")
                Type == "Pointer" -> listOf("org.lwjgl.PointerBuffer")
                else -> listOf("java.nio.$TypeBuffer")
            }
            val Ype = if (unsigned) Type.drop(1) else Type
            val maybeToU = if (unsigned) ".to$Type()" else ""
            val maybeAsU = if (unsigned) ".as$TypeBuffer()" else ""
            val maybeToS = if (unsigned) ".to$Ype()" else ""
            +jvmInline
            "value class ${Type}Ptr(val adr: Adr)" {
                if (Type == "Pointer") {
                    +"""
                        inline operator fun get(index: Int = 0): Ptr = UNSAFE.getLong(null, adr + index * Pointer.POINTER_SIZE)
                        inline fun getPtr(index: Int): Ptr = get(index)
                        inline fun getBuffer(index: Int, size: Int): ByteBuffer = getByteBuffer(index, size)"""
                    for (tipo in types) {
                        val ipo = if (tipo[0] == 'U') tipo.drop(1) else tipo
                        val maybeAsU = if (tipo[0] == 'U') ".as${tipo}Buffer()" else ""
                        val maybeTimes = if ("Byte" in tipo) "" else if (tipo == "Pointer") " * Pointer.POINTER_SIZE" else " * $tipo.BYTES"
                        +"inline fun get${tipo}Buffer(index: Int, size: Int): ${tipo}Buffer = MemoryUtil.mem${ipo}Buffer(get(index), size$maybeTimes)$maybeAsU"
                    }
                    +"""
                        inline fun getPointer(index: Int): Pointer = object : Pointer {
                            override fun address(): Ptr = get(index)	
                        }
                        inline operator fun invoke(index: Int = 0): Ptr = get(index)
                        inline operator fun set(index: Int, ptr: Ptr) = UNSAFE.putLong(null, adr + index * Pointer.POINTER_SIZE, ptr)
                        inline fun setPtr(index: Int, ptr: Ptr) = set(index, ptr)
                        operator inline fun set(index: Int, buffer: Buffer) = set(index, buffer.adr)"""
                    for (tipo in types.filter { it[0] == 'U' })
                        +"operator inline fun set(index: Int, buffer: ${tipo}Buffer) = set(index, buffer.adr)"
                    +"""
                        operator inline fun set(index: Int, pointer: Pointer) = set(index, pointer.adr)
        
                        inline operator fun plus(offset: Int): ${Type}Ptr = ${Type}Ptr(adr + offset * Pointer.POINTER_SIZE)
                        //    inline operator fun plus(pByte: BytePtr): BytePtr = BytePtr(adr + pByte.adr)
                        
                        companion object {
                            val NULL: PointerPtr
                                get() = PointerPtr(MemoryUtil.NULL)
                        }"""
                } else {
                    imports += "java.nio.ByteBuffer"
                    +"""
                        inline operator fun get(index: Int = 0): $Type = UNSAFE.get$Ype(null, adr + index$maybeTimes)$maybeToU
                        inline operator fun invoke(index: Int = 0): $Type = get(index)
                        inline operator fun set(index: Int, $type: $Type) = UNSAFE.put$Ype(null, adr + index$maybeTimes, $type$maybeToS)
        
                        inline operator fun plus(offset: Int): ${Type}Ptr = ${Type}Ptr(adr + offset$maybeTimes)
                        //    inline operator fun plus(pByte: BytePtr): BytePtr = BytePtr(adr + pByte.adr)
                        
                        companion object {
                            val NULL: ${Type}Ptr
                                get() = ${Type}Ptr(MemoryUtil.NULL)
                        }"""
                }
                for (tipo in types.filter { it != Type })
                    +"inline fun to${tipo}Ptr(): ${tipo}Ptr = ${tipo}Ptr(adr)"
            }
            val (t, c) = when {
                Type == "Char" -> "Short" to ".code.toShort()"
                unsigned -> Ype to maybeToS
                else -> Type to ""
            }
            if (Type == "Pointer") {
                +"""
                    fun PointerPtr(size: Int = 1): PointerPtr = PointerPtr(MemoryUtil.nmemCalloc(size.toLong(), Pointer.POINTER_SIZE.toLong()))
                    $overloadResolutionByLambdaReturnType
                    inline fun PointerPtr(size: Int, init: (Int) -> Ptr): PointerPtr {
                        val adr = MemoryUtil.nmemAlloc(size.toLong() * Pointer.POINTER_SIZE)
                        for (i in 0 until size) 
                            MemoryUtil.memPutLong(adr + i * Pointer.POINTER_SIZE, init(i))
                        return PointerPtr(adr)
                    }
                    $overloadResolutionByLambdaReturnType
                    inline fun PointerPtr(size: Int, init: (Int) -> Pointer): PointerPtr {
                        val adr = MemoryUtil.nmemAlloc(size.toLong() * Pointer.POINTER_SIZE)
                        for (i in 0 until size) 
                            MemoryUtil.memPutLong(adr + i * Pointer.POINTER_SIZE, init(i).adr)
                        return PointerPtr(adr)
                    }
                    $overloadResolutionByLambdaReturnType
                    inline fun PointerPtr(size: Int, init: (Int) -> Buffer): PointerPtr {
                        val adr = MemoryUtil.nmemAlloc(size.toLong() * Pointer.POINTER_SIZE)
                        for (i in 0 until size)
                            MemoryUtil.memPutLong(adr + i * Pointer.POINTER_SIZE, init(i).adr)
                        return PointerPtr(adr)
                    }"""
                for (tipo in types.filter { it[0] == 'U' })
                    +"""
                        $overloadResolutionByLambdaReturnType
                        inline fun PointerPtr(size: Int, init: (Int) -> ${tipo}Buffer): PointerPtr {
                            val adr = MemoryUtil.nmemAlloc(size.toLong() * Pointer.POINTER_SIZE)
                            for (i in 0 until size)
                                MemoryUtil.memPutLong(adr + i * Pointer.POINTER_SIZE, init(i).adr)
                            return PointerPtr(adr)
                        }"""
                +"""
                    fun MemoryStack.PointerPtr(size: Int = 1): PointerPtr = PointerPtr(ncalloc(Pointer.POINTER_SIZE, size, Pointer.POINTER_SIZE))
                    $overloadResolutionByLambdaReturnType
                    inline fun MemoryStack.PointerPtr(size: Int, init: (Int) -> Ptr): PointerPtr {
                        val adr = nmalloc(Pointer.POINTER_SIZE, size * Pointer.POINTER_SIZE)
                        for (i in 0 until size) 
                            MemoryUtil.memPutLong(adr + i * Pointer.POINTER_SIZE, init(i))
                        return PointerPtr(adr)
                    }
                    $overloadResolutionByLambdaReturnType
                    inline fun MemoryStack.PointerPtr(size: Int, init: (Int) -> Pointer): PointerPtr {
                        val adr = nmalloc(Pointer.POINTER_SIZE, size * Pointer.POINTER_SIZE)
                        for (i in 0 until size) 
                            MemoryUtil.memPutLong(adr + i * Pointer.POINTER_SIZE, init(i).adr)
                        return PointerPtr(adr)
                    }
                    $overloadResolutionByLambdaReturnType
                    inline fun MemoryStack.PointerPtr(size: Int, init: (Int) -> Buffer): PointerPtr {
                        val adr = nmalloc(Pointer.POINTER_SIZE, size * Pointer.POINTER_SIZE)
                        for (i in 0 until size)
                            MemoryUtil.memPutLong(adr + i * Pointer.POINTER_SIZE, init(i).adr)
                        return PointerPtr(adr)
                    }"""
                for (tipo in types.filter { it[0] == 'U' })
                    +"""
                        $overloadResolutionByLambdaReturnType
                        inline fun MemoryStack.PointerPtr(size: Int, init: (Int) -> ${tipo}Buffer): PointerPtr {
                            val adr = nmalloc(Pointer.POINTER_SIZE, size * Pointer.POINTER_SIZE)
                            for (i in 0 until size)
                                MemoryUtil.memPutLong(adr + i * Pointer.POINTER_SIZE, init(i).adr)
                            return PointerPtr(adr)
                        }"""
            } else
                +"""
                    fun ${Type}Ptr(size: Int = 1): ${Type}Ptr = ${Type}Ptr(MemoryUtil.nmemCalloc(size.toLong(), $Type.BYTES.toLong()))
                    inline fun ${Type}Ptr(size: Int = 1, init: (Int) -> $Type): ${Type}Ptr {
                        val adr = MemoryUtil.nmemAlloc(size.toLong()$maybeTimes)
                        for (i in 0 until size) 
                            MemoryUtil.memPut${t}(adr + i$maybeTimes, init(i)$c)
                        return ${Type}Ptr(adr)
                    }
                    
                    fun MemoryStack.${Type}Ptr(size: Int = 1): ${Type}Ptr = ${Type}Ptr(ncalloc($Type.BYTES, size, $Type.BYTES))
                    inline fun MemoryStack.${Type}Ptr(size: Int = 1, init: (Int) -> $Type): ${Type}Ptr {
                        val adr = nmalloc($Type.BYTES, size$maybeTimes)
                        for (i in 0 until size) 
                            MemoryUtil.memPut${t}(adr + i$maybeTimes, init(i)$c)
                        return ${Type}Ptr(adr)
                    }"""
        }
    }
}