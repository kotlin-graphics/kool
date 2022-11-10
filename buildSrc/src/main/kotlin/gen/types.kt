package gen

val types = listOf("Char", "Byte", "Short", "Int", "Long", "UByte", "UShort", "UInt", "ULong", "Float", "Double", "Pointer")
val numberTypeInformation = listOf(
    TypeInformation("Char", "c", "toChar"),
    TypeInformation("Byte", "b", "toByte"),
    TypeInformation("Short", "s", "toShort"),
    TypeInformation("Int", "i", "toInt"),
    TypeInformation("Long", "L", "toLong"),
    TypeInformation("UByte", "ub", "toUByte"),
    TypeInformation("UShort", "us", "toUShort"),
    TypeInformation("UInt", "ui", "toUInt"),
    TypeInformation("ULong", "ul", "toULong"),
    TypeInformation("Float", "f", "toFloat"),
    TypeInformation("Double", "d", "toDouble"))
val extensionsToInformation = numberTypeInformation.associateBy {
    it.extension
}
val intPromotedTypes = listOf("Byte", "Short", "UByte", "UShort")
val unsignedTypes = listOf("UByte", "UShort", "UInt", "ULong")
val floatingPointTypes = listOf("Float", "Double")

//val String.unsignedToSigned get() = replace("U", "")

val String.`-1`
    get() = when (this) {
        "Int" -> "-1"
        "Float" -> "-1f"
        "Double" -> "-1.0"
        else -> error("invalid type")
    }
val String.`0`
    get() = when (this) {
        "Int" -> "0"
        "Float" -> "0f"
        "Double" -> "0.0"
        else -> error("invalid type")
    }
val String.`0,5`
    get() = when (this) {
        "Float" -> "0.5f"
        "Double" -> "0.5"
        else -> error("invalid type")
    }
val String.`1`
    get() = when (this) {
        "Int" -> "1"
        "Float" -> "1f"
        "Double" -> "1.0"
        else -> error("invalid type")
    }
val String.`2`
    get() = when (this) {
        "Int" -> "2"
        "Float" -> "2f"
        "Double" -> "2.0"
        else -> error("invalid type")
    }
val String.`3`
    get() = when (this) {
        "Int" -> "3"
        "Float" -> "3f"
        "Double" -> "3.0"
        else -> error("invalid type")
    }
val String.promotedExtensionOrThis
    get() = when (this) {
        "Byte" -> "i"
        "Short" -> "i"
        "UByte" -> "ui"
        "UShort" -> "ui"
        else -> "this"
    }
val String.promotedExtensionOrEmpty
    get() = when (this) {
        "Byte" -> ".i"
        "Short" -> ".i"
        "UByte" -> ".ui"
        "UShort" -> ".ui"
        else -> ""
    }
val String.maybePromotedBack
    get() = when (this) {
        "Byte" -> ".b"
        "Short" -> ".s"
        "UByte" -> ".ub"
        "UShort" -> ".us"
        else -> ""
    }
val String.counterpart
    get() = when (this) {
        "Float" -> "Int"
        "Double" -> "Long"
        "Int" -> "Float"
        "Long" -> "Double"
        else -> ""
    }

data class TypeInformation(val type: String, val extension: String, val conversionFunction: String) {
    val id: String
        get() = if (type == "Float") "" else extension

    operator fun component4() = id
}

operator fun Iterable<TypeInformation>.minus(types: Iterable<String>) = types.toSet().let { typeSet -> this.filter { it.type !in typeSet } }