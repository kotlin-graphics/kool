package kool

import org.lwjgl.system.CustomBuffer

inline val <SELF : CustomBuffer<SELF>>CustomBuffer<SELF>.adr
    get() = address()

inline val <SELF : CustomBuffer<SELF>>CustomBuffer<SELF>.cap
    get() = capacity()

inline var <SELF : CustomBuffer<SELF>>CustomBuffer<SELF>.lim
    get() = limit()
    set(value) {
        limit(value)
    }

inline val <SELF : CustomBuffer<SELF>>CustomBuffer<SELF>.rem
    get() = remaining()

inline val <SELF : CustomBuffer<SELF>>CustomBuffer<SELF>.indices: IntRange
    get() = IntRange(0, lastIndex)

inline val <SELF : CustomBuffer<SELF>>CustomBuffer<SELF>.lastIndex: Int
    get() = cap - 1