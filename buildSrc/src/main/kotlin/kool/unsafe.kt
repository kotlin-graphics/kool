package kool

import kool.gen.generate
import java.io.File

fun unsafe(target: File) {

    generate(target, "kool/unsafe.kt") {

        `package` = "kool"

        //        experimentals += Generator.Experimentals.Contracts
        suppressInlineWarning = true

        imports += listOf(
            "sun.misc.Unsafe"
            //            "org.lwjgl.system.MemoryUtil",
            //            "org.lwjgl.system.MemoryStack",
            //            "java.nio.Buffer",
            //            "kool.adr",
                         )

        docs("""
            Different runtimes use different names for the Unsafe singleton, so we cannot use `.getDeclaredField` and
            we scan instead. For example:
            Oracle: theUnsafe
            PERC : m_unsafe_instance
            Android: THE_ONE""")
        +"""
            val unsafe: Unsafe by lazy {
                Unsafe::class.java.declaredFields
                        .find {
                            it.type == Unsafe::class.java &&
                                    java.lang.reflect.Modifier.isStatic(it.modifiers)
                                    && java.lang.reflect.Modifier.isFinal(it.modifiers)
                        }?.run {
                            isAccessible = true
                            get(null) as Unsafe
                        } ?: throw UnsupportedOperationException("LWJGL requires sun.misc.Unsafe to be available.")
            }
            """

        +"inline operator fun Unsafe.get(offset: ULong): Byte = getByte(offset.toLong())"
        +"inline operator fun Unsafe.get(offset: Long): Byte = getByte(offset)"
        val Tclass = "\${T::class}"
        +"""
            inline operator fun <reified T> Unsafe.get(offset: ULong): T = get<T>(offset.toLong())
            inline operator fun <reified T> Unsafe.get(offset: Long): T = when (T::class.java) {
                Byte::class.java -> getByte(offset)
                Short::class.java -> getShort(offset)
                Int::class.java -> getInt(offset)
                Long::class.java -> getLong(offset)
                UByte::class.java -> getUByte(offset)
                UShort::class.java -> getUShort(offset)
                UInt::class.java -> getUInt(offset)
                ULong::class.java -> getULong(offset)
                Float::class.java -> getFloat(offset)
                Double::class.java -> getDouble(offset)
                else -> error("type $Tclass unsupported")
            } as T"""
        for (Type in types.filter { it != "Pointer" }) {
            val unsigned = Type[0] == 'U'
            val ype = Type.drop(1)
            val type = Type.toLowerCase()
            if (unsigned)
                +"""
                    inline fun Unsafe.get$Type(offset: Int): $Type = get$Type(offset.toULong())
                    inline fun Unsafe.get$Type(offset: UInt): $Type = get$Type(offset.toULong())
                    inline fun Unsafe.get$Type(offset: Long): $Type = get$Type(offset.toULong())
                    inline fun Unsafe.get$Type(offset: ULong): $Type = get$ype(offset.toLong()).to$Type()
                    inline fun Unsafe.set(offset: Int, $type: $Type) = set(offset.toULong(), $type)
                    inline fun Unsafe.set(offset: Long, $type: $Type) = set(offset.toULong(), $type)
                    inline fun Unsafe.set(offset: ULong, $type: $Type) = put$ype(null, offset.toLong(), $type.to$ype())
                    """
            else
                +"""
                    inline fun Unsafe.get$Type(offset: Int): $Type = get$Type(offset.toULong())
                    inline fun Unsafe.get$Type(offset: UInt): $Type = get$Type(offset.toULong())
                    inline fun Unsafe.get$Type(offset: ULong): $Type = get$Type(offset.toLong())
                    inline fun Unsafe.set(offset: Int, $type: $Type) = set(offset.toULong(), $type)
                    inline fun Unsafe.set(offset: UInt, $type: $Type) = set(offset.toULong(), $type)
                    inline fun Unsafe.set(offset: ULong, $type: $Type) = put$Type(null, offset.toLong(), $type)"""
        }
    }
}