package kool

import kotlin.test.Test

class PointersTest {

    val count = 100
    val range =  0..99
    @Test
    fun testByte() = stack {
        var p = Ptr<Byte>(it.calloc(count).adr)
        for (i in range)
            p[i] = i.toByte()
        for (i in range)
            assert(p[i] == i.toByte())
        for (i in range)
            assert(p++[0] == i.toByte())
        p--
        for (i in range.reversed())
            assert(p--[0] == i.toByte())
    }
    @Test
    fun testShort() = stack {
        var p = Ptr<Short>(it.callocShort(count).adr)
        for (i in range)
            p[i] = i.toShort()
        for (i in range)
            assert(p[i] == i.toShort())
        for (i in range)
            assert(p++[0] == i.toShort())
        p--
        for (i in range.reversed())
            assert(p--[0] == i.toShort())
    }
    @Test
    fun testInt() = stack {
        var p = Ptr<Int>(it.callocInt(count).adr)
        for (i in range)
            p[i] = i
        for (i in range)
            assert(p[i] == i)
        for (i in range)
            assert(p++[0] == i)
        p--
        for (i in range.reversed())
            assert(p--[0] == i)
    }
    @Test
    fun testLong() = stack {
        var p = Ptr<Long>(it.callocLong(count).adr)
        for (i in range)
            p[i] = i.toLong()
        for (i in range)
            assert(p[i] == i.toLong())
        for (i in range)
            assert(p++[0] == i.toLong())
        p--
        for (i in range.reversed())
            assert(p--[0] == i.toLong())
    }
    @Test
    fun testUByte() = stack {
        var p = Ptr<UByte>(it.calloc(count).adr)
        for (i in range)
            p[i] = i.toUByte()
        for (i in range)
            assert(p[i] == i.toUByte())
        for (i in range)
            assert(p++[0] == i.toUByte())
        p--
        for (i in range.reversed())
            assert(p--[0] == i.toUByte())
    }
    @Test
    fun testUShort() = stack {
        var p = Ptr<UShort>(it.callocShort(count).adr)
        for (i in range)
            p[i] = i.toUShort()
        for (i in range)
            assert(p[i] == i.toUShort())
        for (i in range)
            assert(p++[0] == i.toUShort())
        p--
        for (i in range.reversed())
            assert(p--[0] == i.toUShort())
    }
    @Test
    fun testUInt() = stack {
        var p = Ptr<UInt>(it.callocInt(count).adr)
        for (i in range)
            p[i] = i.toUInt()
        for (i in range)
            assert(p[i] == i.toUInt())
        for (i in range)
            assert(p++[0] == i.toUInt())
        p--
        for (i in range.reversed())
            assert(p--[0] == i.toUInt())
    }
    @Test
    fun testULong() = stack {
        var p = Ptr<ULong>(it.callocLong(count).adr)
        for (i in range)
            p[i] = i.toULong()
        for (i in range)
            assert(p[i] == i.toULong())
        for (i in range)
            assert(p++[0] == i.toULong())
        p--
        for (i in range.reversed())
            assert(p--[0] == i.toULong())
    }
}