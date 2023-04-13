package kool

import java.util.*

val jvmInline = "@JvmInline"
val overloadResolutionByLambdaReturnType = "@OverloadResolutionByLambdaReturnType"
fun jvmName(name: String) = "@kotlin.jvm.JvmName(\"$name\")"

fun CharSequence.decapitalized(): String =
    when {
        isEmpty() -> ""
        else -> get(0).let { initial ->
            when {
                initial.isUpperCase() -> initial.lowercase(Locale.getDefault()) + substring(1)
                else -> toString()
            }
        }
    }
