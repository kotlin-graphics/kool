package gen

import gen.gen.generate
import gen.gen.Generator
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

        for (Type in types.filter { it != "Char" }) {

            val TypeBuffer = Type + "Buffer"
            var maybeTimes = if ("Byte" in Type) "" else " * $Type.BYTES.toULong()"
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

            val PtrType = "Ptr<$Type>"
            if (Type == "Pointer") {
//                +"""
//                    inline operator fun $PtrType.get(index: Int = 0): Pointer = object : Pointer {
//                        override fun address(): Long = unsafe.getLong(null, adr + index * Pointer.POINTER_SIZE)
//                    }
//                    inline fun $PtrType.getPtr(index: Int): Pointer = get(index)
//                    inline fun $PtrType.getBuffer(index: Int, size: Int): ByteBuffer = getByteBuffer(index, size)"""
//                for (tipo in types.filter { it != "Char" }) {
//                    val ipo = if (tipo[0] == 'U') tipo.drop(1) else tipo
//                    val maybeAsU = if (tipo[0] == 'U') ".as${tipo}Buffer()" else ""
//                    val maybeTimes = if ("Byte" in tipo) "" else if (tipo == "Pointer") " * Pointer.POINTER_SIZE" else " * $tipo.BYTES"
//                    +"inline fun $PtrType.get${tipo}Buffer(index: Int, size: Int): ${tipo}Buffer = MemoryUtil.mem${ipo}Buffer(get(index).adr, size$maybeTimes)$maybeAsU"
//                }
//                +"""
//                    inline fun $PtrType.getPointer(index: Int): Pointer = object : Pointer {
//                        override fun address(): Ptr = get(index)
//                    }
//                    inline operator fun invoke(index: Int = 0): Ptr = get(index)
//                    inline operator fun set(index: Int, ptr: Ptr) = unsafe.putLong(null, adr + index * Pointer.POINTER_SIZE, ptr)
//                    inline fun setPtr(index: Int, ptr: Ptr) = set(index, ptr)
//                    operator inline fun set(index: Int, buffer: Buffer) = set(index, buffer.adr)"""
//                for (tipo in types.filter { it[0] == 'U' })
//                    +"operator inline fun set(index: Int, buffer: ${tipo}Buffer) = set(index, buffer.adr)"
//                +"""
//                    operator inline fun set(index: Int, pointer: Pointer) = set(index, pointer.adr)
//
//                    inline operator fun plus(offset: Int): ${Type}Ptr = ${Type}Ptr(adr + offset * Pointer.POINTER_SIZE)
//                    //    inline operator fun plus(pByte: BytePtr): BytePtr = BytePtr(adr + pByte.adr)
//
//                    companion object {
//                        val NULL: PointerPtr
//                            get() = PointerPtr(MemoryUtil.NULL)
//                    }"""
            } else {
                imports += "java.nio.ByteBuffer"
                if (unsigned)
                    +"""
                        inline fun $PtrType.get$Type(index: Int): $Type = get$Type(index.toULong())
                        inline fun $PtrType.get$Type(index: UInt): $Type = get$Type(index.toULong())
                        inline fun $PtrType.get$Type(index: Long): $Type = get$Type(index.toULong())
                        inline fun $PtrType.get$Type(index: ULong = 0uL): $Type = unsafe.get$Ype(adr + index$maybeTimes)$maybeToU
                        inline fun $PtrType.invoke$Type(index: Int): $Type = invoke$Type(index.toULong())
                        inline fun $PtrType.invoke$Type(index: UInt): $Type = invoke$Type(index.toULong())
                        inline fun $PtrType.invoke$Type(index: Long): $Type = invoke$Type(index.toULong())
                        inline fun $PtrType.invoke$Type(index: ULong = 0uL): $Type = get$Type(index)"""
                else
                    +"""
                        inline operator fun $PtrType.get(index: Int): $Type = get(index.toULong())
                        inline operator fun $PtrType.get(index: UInt): $Type = get(index.toULong())
                        inline operator fun $PtrType.get(index: Long): $Type = get(index.toULong())
                        inline operator fun $PtrType.get(index: ULong = 0uL): $Type = unsafe.get$Ype(adr + index$maybeTimes)$maybeToU
                        inline operator fun $PtrType.invoke(index: Int): $Type = invoke(index.toULong())
                        inline operator fun $PtrType.invoke(index: UInt): $Type = invoke(index.toULong())
                        inline operator fun $PtrType.invoke(index: Long): $Type = invoke(index.toULong())
                        inline operator fun $PtrType.invoke(index: ULong = 0uL): $Type = get(index)"""
                +"""
                    inline operator fun $PtrType.set(index: Int, $type: $Type) = set(index.toULong(), $type)
                    inline operator fun $PtrType.set(index: UInt, $type: $Type) = set(index.toULong(), $type)
                    inline operator fun $PtrType.set(index: Long, $type: $Type) = set(index.toULong(), $type)
                    inline operator fun $PtrType.set(index: ULong, $type: $Type) = unsafe.set(adr + index$maybeTimes, $type$maybeToS)

                    //    inline operator fun plus(pByte: BytePtr): BytePtr = BytePtr(adr + pByte.adr)
                    """
            }

            if (Type == "Pointer") {
//                +"""
//                    fun PointerPtr(size: Int = 1): PointerPtr = PointerPtr(MemoryUtil.nmemCalloc(size.toLong(), Pointer.POINTER_SIZE.toLong()))
//                    $overloadResolutionByLambdaReturnType
//                    inline fun PointerPtr(size: Int, init: (Int) -> Ptr): PointerPtr {
//                        val adr = MemoryUtil.nmemAlloc(size.toLong() * Pointer.POINTER_SIZE)
//                        for (i in 0 until size)
//                            MemoryUtil.memPutLong(adr + i * Pointer.POINTER_SIZE, init(i))
//                        return PointerPtr(adr)
//                    }
//                    $overloadResolutionByLambdaReturnType
//                    inline fun PointerPtr(size: Int, init: (Int) -> Pointer): PointerPtr {
//                        val adr = MemoryUtil.nmemAlloc(size.toLong() * Pointer.POINTER_SIZE)
//                        for (i in 0 until size)
//                            MemoryUtil.memPutLong(adr + i * Pointer.POINTER_SIZE, init(i).adr)
//                        return PointerPtr(adr)
//                    }
//                    $overloadResolutionByLambdaReturnType
//                    inline fun PointerPtr(size: Int, init: (Int) -> Buffer): PointerPtr {
//                        val adr = MemoryUtil.nmemAlloc(size.toLong() * Pointer.POINTER_SIZE)
//                        for (i in 0 until size)
//                            MemoryUtil.memPutLong(adr + i * Pointer.POINTER_SIZE, init(i).adr)
//                        return PointerPtr(adr)
//                    }"""
//                for (tipo in types.filter { it[0] == 'U' })
//                    +"""
//                        $overloadResolutionByLambdaReturnType
//                        inline fun PointerPtr(size: Int, init: (Int) -> ${tipo}Buffer): PointerPtr {
//                            val adr = MemoryUtil.nmemAlloc(size.toLong() * Pointer.POINTER_SIZE)
//                            for (i in 0 until size)
//                                MemoryUtil.memPutLong(adr + i * Pointer.POINTER_SIZE, init(i).adr)
//                            return PointerPtr(adr)
//                        }"""
//                +"""
//                    fun MemoryStack.PointerPtr(size: Int = 1): PointerPtr = PointerPtr(ncalloc(Pointer.POINTER_SIZE, size, Pointer.POINTER_SIZE))
//                    $overloadResolutionByLambdaReturnType
//                    inline fun MemoryStack.PointerPtr(size: Int, init: (Int) -> Ptr): PointerPtr {
//                        val adr = nmalloc(Pointer.POINTER_SIZE, size * Pointer.POINTER_SIZE)
//                        for (i in 0 until size)
//                            MemoryUtil.memPutLong(adr + i * Pointer.POINTER_SIZE, init(i))
//                        return PointerPtr(adr)
//                    }
//                    $overloadResolutionByLambdaReturnType
//                    inline fun MemoryStack.PointerPtr(size: Int, init: (Int) -> Pointer): PointerPtr {
//                        val adr = nmalloc(Pointer.POINTER_SIZE, size * Pointer.POINTER_SIZE)
//                        for (i in 0 until size)
//                            MemoryUtil.memPutLong(adr + i * Pointer.POINTER_SIZE, init(i).adr)
//                        return PointerPtr(adr)
//                    }
//                    $overloadResolutionByLambdaReturnType
//                    inline fun MemoryStack.PointerPtr(size: Int, init: (Int) -> Buffer): PointerPtr {
//                        val adr = nmalloc(Pointer.POINTER_SIZE, size * Pointer.POINTER_SIZE)
//                        for (i in 0 until size)
//                            MemoryUtil.memPutLong(adr + i * Pointer.POINTER_SIZE, init(i).adr)
//                        return PointerPtr(adr)
//                    }"""
//                for (tipo in types.filter { it[0] == 'U' })
//                    +"""
//                        $overloadResolutionByLambdaReturnType
//                        inline fun MemoryStack.PointerPtr(size: Int, init: (Int) -> ${tipo}Buffer): PointerPtr {
//                            val adr = nmalloc(Pointer.POINTER_SIZE, size * Pointer.POINTER_SIZE)
//                            for (i in 0 until size)
//                                MemoryUtil.memPutLong(adr + i * Pointer.POINTER_SIZE, init(i).adr)
//                            return PointerPtr(adr)
//                        }"""
            } else if (type != "char") {
                maybeTimes = if ("Byte" in Type) "" else " * $Type.BYTES.toLong()"
                +"""
                    inline fun Ptr$Type(size: Int = 1): $PtrType = MemoryUtil.nmemCalloc(size.toLong(), $Type.BYTES.toLong()).to$PtrType()
                    inline fun Ptr$Type(size: Int = 1, init: (Int) -> $Type): $PtrType {
                        val ptr = MemoryUtil.nmemAlloc(size.toLong()$maybeTimes).to$PtrType()
                        for (i in 0 until size) 
                            ptr[i] = init(i)
                        return ptr
                    }"""
                maybeTimes = if ("Byte" in Type) "" else " * $Type.BYTES"
                +"""
                    inline fun MemoryStack.Ptr$Type(size: Int = 1): $PtrType = $PtrType(ncalloc($Type.BYTES, size, $Type.BYTES))
                    inline fun MemoryStack.Ptr$Type(size: Int = 1, init: (Int) -> $Type): $PtrType {
                        val ptr = nmalloc($Type.BYTES, size$maybeTimes).to$PtrType()
                        for (i in 0 until size) 
                            ptr[i] = init(i)
                        return ptr
                    }"""
            } else
                +"\n"
        }
    }
}