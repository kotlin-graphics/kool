package kool.lib

internal fun checkRangeIndexes(fromIndex: Int, toIndex: Int, size: Int) {
    if (fromIndex < 0 || toIndex > size)
        throw IndexOutOfBoundsException("fromIndex: $fromIndex, toIndex: $toIndex, size: $size")
    if (fromIndex > toIndex)
        throw IllegalArgumentException("fromIndex: $fromIndex > toIndex: $toIndex")
}