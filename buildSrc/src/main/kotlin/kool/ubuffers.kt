package kool

import kool.gen.Generator
import kool.gen.generate
import java.io.File

fun ubuffers(target: File) {

    for ((type, ext, conv) in numberTypeInformation.filter { it.type in unsignedTypes })
        generate(target, "kool/ubuffers/${type}Buffer.kt") {

            `package` = "kool.ubuffers"

            experimentals += Generator.Experimentals.TypeInference

            val t = type.drop(1)
            imports += listOf(
                "java.nio.ByteBuffer",
                "java.nio.${t}Buffer",
                "kool.iterator",
                "java.nio.ByteOrder",
                "kool.BYTES",
                             )
            ubuffer(type, ext, conv)
        }
}

fun Generator.ubuffer(TYpe: String, extension: String, conversion: String) {

    val type = TYpe.toLowerCase()
    val types = "${type}s"
    val tYpe = TYpe.replaceFirst('U', 'u')
    val Ype = TYpe.drop(1)
    val TypeBuffer = "${TYpe}Buffer"

    +jvmInline
    "value class $TypeBuffer(val buffer: ${Ype}Buffer)" {

        docs("""
            Relative get method. Reads the $type at this buffer's current position, and then increments the position.
            @return The $type at the buffer's current position
            @throws `BufferUnderflowException` If the buffer's current position is not smaller than its limit""")
        +"fun get(): $TYpe = buffer.get().to$TYpe()"

        docs("""
            Absolute get method. Reads the $type at the given index.
            @param index The index from which the $type will be read
            @return The $type at the given index
            @throws `IndexOutOfBoundsException` If index is negative or not smaller than the buffer's limit""")
        +"infix operator fun get(index: Int): $TYpe = buffer[index].to$TYpe()"

        docs("""
            Relative bulk get method.
            This method transfers $types from this buffer into the given destination array. An invocation of this method 
            of the form `src.get(a)` behaves in exactly the same way as the invocation
                `src.get(a, 0, a.length)`
            @param dst The destination array
            @return This buffer
            @throws `BufferUnderflowException` If there are fewer than length $types remaining in this buffer""")
        +"infix operator fun get(array: ${TYpe}Array): $TypeBuffer = $TypeBuffer(buffer[array.as${Ype}Array()])"

        docs("""
            Relative bulk get method.
            This method transfers $types from this buffer into the given destination array. If there are fewer $types
            remaining in the buffer than are required to satisfy the request, that is, if `length > remaining`, then no
            $types are transferred and a `BufferUnderflowException` is thrown.
            Otherwise, this method copies length $types from this buffer into the given array, starting at the current
            position of this buffer and at the given offset in the array.
            The position of this buffer is then incremented by length.
            In other words, an invocation of this method of the form `src.get(dst, off, len)` has exactly the same 
            effect as the loop
            ```
            for (i in off until off + len)
                dst[i] = src.get()
            ```
            except that it first checks that there are sufficient $types in this buffer and it is potentially much more efficient.
            @param dst The array into which $types are to be written
            @param offset The offset within the array of the first $type to be written; must be non-negative and no larger than `dst.length`
            @param length The maximum number of $types to be written to the given array; must be non-negative and no larger than `dst.length - offset`
            @return This buffer
            @throws `BufferUnderflowException` If there are fewer than length $types remaining in this buffer
            @throws `IndexOutOfBoundsException` If the preconditions on the offset and length parameters do not hold""")
        +"operator fun get(dst: ${TYpe}Array, offset: Int, length: Int): $TypeBuffer = $TypeBuffer(buffer[dst.to${Ype}Array(), offset, length])"

        if (type == "ubyte") {
            for ((Type, x) in listOf("Char" to "two", "Short" to "two", "Int" to "four", "Long" to "eight", "Float" to "four", "Double" to "eight")) {
                val type = Type.toLowerCase()
                val a = if (type.startsWith('i')) "an" else "a"
                val int = Type != "Char" && Type != "Float" && Type != "Double"
                docs("""
                    Absolute get method for reading $a $type value.
                    Reads $x bytes at the given index, composing them into $a $type value according to the current byte order.
                    @param index The index from which the bytes will be read
                    @return The $type value at the given index
                    @throws `IndexOutOfBoundsException` If index is negative or not smaller than the buffer's limit, minus one""")
                +"infix fun get$Type(index: Int): $Type = buffer.get$Type(index)"

                if (int) {
                    docs("""
                        Absolute get method for reading an u$type value.
                        Reads $x bytes at the given index, composing them into an u$type value according to the current byte order.
                        @param index The index from which the bytes will be read
                        @return The u$type value at the given index
                        @throws `IndexOutOfBoundsException` If index is negative or not smaller than the buffer's limit, minus one""")
                    +"infix fun getU$Type(index: Int): U$Type = buffer.get$Type(index).toU$Type()"
                }

                docs("""
                    Relative get method for reading/writing $a $type value.
                    Reads the next $x bytes at this buffer's current position, composing them into $a $type value according to the
                    current byte order, and then increments the position by $x.
                    Returns: The $type value at the buffer's current position
                    Throws: `BufferUnderflowException` If there are fewer than $x bytes remaining in this buffer
                    
                    Writes $x bytes containing the given $type value, in the current byte order, into this buffer at the current position, 
                    and then increments the position by $x.
                    Parameters:
                     - value, The $type value to be written
                    Returns: This buffer
                    Throws:
                        `BufferOverflowException` If there are fewer than $x bytes remaining in this buffer
                        `ReadOnlyBufferException` If this buffer is read-only""")
                "var $type: $Type".indented {
                    +"get() = buffer.$type"
                    +"set(value) { buffer.put$Type(value) }"
                }

                if (int) {
                    docs("""
                        Relative get method for reading an u$type value.
                        Reads the next $x bytes at this buffer's current position, composing them into an u$type value according to the
                        current byte order, and then increments the position by $x.
                        Returns: The $type value at the buffer's current position
                        Throws: `BufferUnderflowException` If there are fewer than $x bytes remaining in this buffer
                        
                        Writes $x bytes containing the given u$type value, in the current byte order, into this buffer at the current position, 
                        and then increments the position by $x.
                        Parameters:
                         - value, The u$type value to be written
                        Returns: This buffer
                        Throws:
                            `BufferOverflowException` If there are fewer than $x bytes remaining in this buffer
                            `ReadOnlyBufferException` If this buffer is read-only""")
                    "var u$type: U$Type".indented {
                        +"get() = buffer.$type.toU$Type()"
                        +"set(value) { buffer.put$Type(value.to$Type()) }"
                    }
                }
                docs("""
                    Absolute put method for writing $a $type value  (optional operation).
                    Writes $x bytes containing the given $type value, in the current byte order, into this buffer at the given index.
                    @param index The index at which the bytes will be written
                    @param value The $type value to be written
                    @return This buffer
                    @throws `IndexOutOfBoundsException` If index is negative or not smaller than the buffer's limit, minus one
                    @throws `ReadOnlyBufferException` - If this buffer is read-only""")
                +"fun put$Type(index: Int, value: $Type): UByteBuffer = buffer.put$Type(index, value).asUByteBuffer()"
                if (int) {
                    docs("""
                        Absolute put method for writing an u$type value  (optional operation).
                        Writes $x bytes containing the given u$type value, in the current byte order, into this buffer at the given index.
                        @param index The index at which the bytes will be written
                        @param value The u$type value to be written
                        @return This buffer
                        @throws `IndexOutOfBoundsException` If index is negative or not smaller than the buffer's limit, minus one
                        @throws `ReadOnlyBufferException` - If this buffer is read-only""")
                    +"fun putU$Type(index: Int, value: U$Type): UByteBuffer = buffer.put$Type(index, value.to$Type()).asUByteBuffer()"
                }
            }
        }

        docs("""
            Compacts this buffer  (optional operation).
            The $types between the buffer's current position and its limit, if any, are copied to the beginning of the buffer.
            That is, the $type at index `p = position` is copied to index zero, the $type at index `p + 1` is copied to index
            one, and so forth until the $type at index `limit - 1` is copied to index `n = limit - 1 - p`.
            The buffer's position is then set to `n+1` and its limit is set to its capacity. The mark, if defined, is discarded.
            The buffer's position is set to the number of ubytes copied, rather than to zero, so that an invocation of this
            method can be followed immediately by an invocation of another relative put method.
            @return This buffer
            @throws `ReadOnlyBufferException` If this buffer is read-only""")
        +"fun compact(): $TypeBuffer = $TypeBuffer(buffer.compact())"

        docs("""
            Creates a new $type buffer that shares this buffer's content.
            The content of the new buffer will be that of this buffer. Changes to this buffer's content will be visible in
            the new buffer, and vice versa; the two buffers' position, limit, and mark values will be independent.
            The new buffer's capacity, limit, position, and mark values will be identical to those of this buffer.
            The new buffer will be direct if, and only if, this buffer is direct, and it will be read-only if, and only if,
            this buffer is read-only.
            @return The new ubyte buffer""")
        +"fun duplicate(): $TypeBuffer = $TypeBuffer(buffer.duplicate())"

        docs("""
            Retrieves this buffer's byte order.
            The byte order of an $type buffer created by allocation or by wrapping an existing $type array is the native order
            of the underlying hardware. The byte order of an $type buffer created as a view of an $type buffer is that of the
            $type buffer at the moment that the view is created.
            @return This buffer's byte order""")
        "val order: ByteOrder".indented {
            +"get() = buffer.order()"
        }

        docs("""
            Relative put method  (optional operation).
            Writes the given $type into this buffer at the current position, and then increments the position.
            @param $tYpe The $type to be written
            @return This buffer
            @throws `BufferOverflowException` If this buffer's current position is not smaller than its limit
            @throws `ReadOnlyBufferException` If this buffer is read-only""")
        +"infix fun put($tYpe: $TYpe): $TypeBuffer = $TypeBuffer(buffer.put($tYpe.to$Ype()))"

        docs("""
            Absolute put method  (optional operation).
            Writes the given $type into this buffer at the given index.
            @param index The index at which the $type will be written
            @param $tYpe The $type value to be written
            @return This buffer
            @throws `IndexOutOfBoundsException` If index is negative or not smaller than the buffer's limit
            @throws `ReadOnlyBufferException` If this buffer is read-only""")
        +"fun put(index: Int, $tYpe: $TYpe): $TypeBuffer = $TypeBuffer(buffer.put(index, $tYpe.to$Ype()))"

        docs("""
            Relative bulk put method  (optional operation).
            This method transfers the entire content of the given source $type array into this buffer. An invocation of this
            method of the form `dst.put(a)` behaves in exactly the same way as the invocation
                 `dst.put(a, 0, a.length)`
            @param src The source array
            @return This buffer
            @throws `BufferOverflowException` If there is insufficient space in this buffer
            @throws `ReadOnlyBufferException` If this buffer is read-only""")
        +"infix fun put(src: ${TYpe}Array): $TypeBuffer = $TypeBuffer(buffer.put(src.to${Ype}Array()))"

        docs("""
            Relative bulk put method  (optional operation).
            This method transfers the $types remaining in the given source buffer into this buffer. If there are more $types
            remaining in the source buffer than in this buffer, that is, if `src.remaining > remaining`, then no $types are
            transferred and a `BufferOverflowException` is thrown.
            Otherwise, this method copies `n = src.remaining` $types from the given buffer into this buffer, starting at each
            buffer's current position. The positions of both buffers are then incremented by `n`.
            In other words, an invocation of this method of the form `dst.put(src)` has exactly the same effect as the loop
            ```
                 while (src.hasRemaining)
                     dst.put(src.get());
            ```
            except that it first checks that there is sufficient space in this buffer and it is potentially much more efficient.
            @param src The source buffer from which $types are to be read; must not be this buffer
            @return This buffer
            @throws `BufferOverflowException` If there is insufficient space in this buffer for the remaining $types in the source buffer
            @throws `IllegalArgumentException` If the source buffer is this buffer
            @throws `ReadOnlyBufferException` If this buffer is read-only""")
        +"infix fun put(src: $TypeBuffer): $TypeBuffer = $TypeBuffer(buffer.put(src.buffer))"

        docs("""
            Relative bulk put method  (optional operation).
            This method transfers $types into this buffer from the given source array. If there are more $types to be copied
            from the array than remain in this buffer, that is, if `length > remaining`, then no $types are transferred and
            a `BufferOverflowException` is thrown.
            Otherwise, this method copies length $types from the given array into this buffer, starting at the given offset in
            the array and at the current position of this buffer. The position of this buffer is then incremented by length.
            In other words, an invocation of this method of the form `dst.put(src, off, len)` has exactly the same effect as
            the loop
            ```
                 for (i in off until off + len)
                     dst.put(a[i])
            ``
            except that it first checks that there is sufficient space in this buffer and it is potentially much more efficient.
            @param src The array from which $types are to be read
            @param offset The offset within the array of the first $type to be read; must be non-negative and no larger than `array.length`
            @param length The number of $types to be read from the given array; must be non-negative and no larger than `array.length - offset`
            @return This buffer
            @throws `BufferOverflowException` If there is insufficient space in this buffer
            @throws `IndexOutOfBoundsException` If the preconditions on the offset and length parameters do not hold
            @throws `ReadOnlyBufferException` If this buffer is read-only""")
        +"fun put(src: ${TYpe}Array, offset: Int, length: Int): $TypeBuffer = $TypeBuffer(buffer.put(src.to${Ype}Array(), offset, length))"

        docs("""
            Creates a new, read-only $type buffer that shares this buffer's content.
            The content of the new buffer will be that of this buffer. Changes to this buffer's content will be visible in
            the new buffer; the new buffer itself, however, will be read-only and will not allow the shared content to be
            modified. The two buffers' position, limit, and mark values will be independent.
            The new buffer's capacity, limit, position, and mark values will be identical to those of this buffer.
            If this buffer is itself read-only then this method behaves in exactly the same way as the duplicate method.
            @return The new, read-only $type buffer""")
        +"fun asReadOnlyBuffer(): $TypeBuffer = $TypeBuffer(buffer.asReadOnlyBuffer())"

        docs("""
            Creates a new $type buffer whose content is a shared subsequence of this buffer's content.
            The content of the new buffer will start at this buffer's current position. Changes to this buffer's content will
            be visible in the new buffer, and vice versa; the two buffers' position, limit, and mark values will be independent.
            The new buffer's position will be zero, its capacity and its limit will be the number of $types remaining in this
            buffer, and its mark will be undefined. The new buffer will be direct if, and only if, this buffer is direct,
            and it will be read-only if, and only if, this buffer is read-only.
            @return The new $type buffer""")
        +"fun slice(): $TypeBuffer = $TypeBuffer(buffer.slice())"

        docs("""
            Tells whether or not this buffer is read-only.
            @return `true` if, and only if, this buffer is read-only""")
        +"fun isReadOnly(): Boolean = buffer.isReadOnly()"

        docs("""
            Tells whether or not this buffer is backed by an accessible byte array.
            If this method returns true then the array and arrayOffset methods may safely be invoked.
            Specified by:
                `hasArray` in class `Buffer`
            @return `true` if, and only if, this buffer is backed by an array and is not read-only""")
        +"fun hasArray(): Boolean = buffer.hasArray()"

        docs("""
            Returns the byte array that backs this buffer  (optional operation).
            Modifications to this buffer's content will cause the returned array's content to be modified, and vice versa.
            Invoke the hasArray method before invoking this method in order to ensure that this buffer has an accessible backing array.
            Specified by:
                `array` in class `Buffer`
            @return The array that backs this buffer
            @throws `ReadOnlyBufferException` If this buffer is backed by an array but is read-only
            @throws `UnsupportedOperationException` If this buffer is not backed by an accessible array""")
        +"fun array(): Any = buffer.array()"

        docs("""
            Returns the offset within this buffer's backing array of the first element of the buffer  (optional operation).
            If this buffer is backed by an array then buffer position p corresponds to array index p + arrayOffset().
            Invoke the hasArray method before invoking this method in order to ensure that this buffer has an accessible backing array.
            Specified by:
                `arrayOffset` in class `Buffer`
            @return The offset within this buffer's array of the first element of the buffer
            @throws `ReadOnlyBufferException` If this buffer is backed by an array but is read-only
            @throws `UnsupportedOperationException` If this buffer is not backed by an accessible array""")
        +"fun arrayOffset(): Int = buffer.arrayOffset()"

        docs("""
            Tells whether or not this byte buffer is direct.
            Specified by:
                `isDirect` in class `Buffer`
            @return `true` if, and only if, this buffer is direct""")
        +"fun isDirect(): Boolean = buffer.isDirect()"

        extensions(TYpe)

        bufferJvm(TYpe, Generator.Part.Class)
    }

    val maybeDivided = when(type) {
        "UByte" -> ""
        "UShort" -> " divided by two"
        "UInt" -> " divided by four"
        else -> " divided by eight"
    }
    fun asX() = docs("""
        Creates a view of this byte buffer as a ${type.decapitalize()} buffer.
        The content of the new buffer will start at this buffer's current position. Changes to this buffer's content 
        will be visible in the new buffer, and vice versa; the two buffers' position, limit, and mark values will be
        independent.
        The new buffer's position will be zero, its capacity and its limit will be the number of bytes remaining in this
        buffer$maybeDivided, and its mark will be undefined. The new buffer will be direct if, and only if, this buffer
        is direct, and it will be read-only if, and only if, this buffer is read-only.
        @return A new ${type.decapitalize()} buffer""")
    asX()
    +"fun ${Ype}Buffer.as$TypeBuffer(): $TypeBuffer = $TypeBuffer(this)"
    if (Ype != "Byte") {
        asX()
        +"fun ByteBuffer.as$TypeBuffer(): $TypeBuffer = $TypeBuffer(as${Ype}Buffer())"
    }
}