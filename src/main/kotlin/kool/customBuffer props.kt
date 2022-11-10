package kool

import org.lwjgl.system.CustomBuffer
import org.lwjgl.system.MemoryUtil.NULL

inline val <SELF : CustomBuffer<SELF>>CustomBuffer<SELF>.adr: Adr
    get() = address().toULong()

@get:JvmName("adrSafe")
inline val <SELF : CustomBuffer<SELF>>CustomBuffer<SELF>?.adr: Adr
    get() = this?.adr ?: 0uL

inline val <SELF : CustomBuffer<SELF>>CustomBuffer<SELF>.cap: Int
    get() = capacity()

inline var <SELF : CustomBuffer<SELF>>CustomBuffer<SELF>.lim: Int
    get() = limit()
    set(value) {
        limit(value)
    }

inline val <SELF : CustomBuffer<SELF>>CustomBuffer<SELF>.rem: Int
    get() = remaining()

inline val <SELF : CustomBuffer<SELF>>CustomBuffer<SELF>.indices: IntRange
    get() = IntRange(0, lastIndex)

inline val <SELF : CustomBuffer<SELF>>CustomBuffer<SELF>.lastIndex: Int
    get() = cap - 1