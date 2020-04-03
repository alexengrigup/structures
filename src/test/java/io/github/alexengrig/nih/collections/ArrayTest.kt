package io.github.alexengrig.nih.collections

import org.junit.Assert
import org.junit.Test

class ArrayTest {
    @Test
    fun should_create_newArray_by_length() {
        val length = 10
        val array = Array<Any>(length)
        Assert.assertEquals("Array length", length.toLong(), array.length().toLong())
        Assert.assertEquals("Array size", 0, array.size().toLong())
        Assert.assertTrue("Array must be empty", array.isEmpty)
        Assert.assertFalse("Array must be full", array.isFull)
    }

    @Test
    fun should_create_newArray_by_values() {
        val expected = arrayOf<Any>(1, 2, 3)
        val length = expected.size
        val array = Array(expected)
        Assert.assertEquals("Array length", length.toLong(), array.length().toLong())
        Assert.assertEquals("Array size", length.toLong(), array.size().toLong())
        Assert.assertFalse("Array must be empty", array.isEmpty)
        Assert.assertTrue("Array must be full", array.isFull)
    }

    @Test
    fun should_create_newArray_by_varargs() {
        val expected = arrayOf<Any>(1, 2, 3)
        val length = expected.size
        val array = Array(expected[0], expected[1], expected[2])
        Assert.assertEquals("Array length", length.toLong(), array.length().toLong())
        Assert.assertEquals("Array size", length.toLong(), array.size().toLong())
        Assert.assertFalse("Array must be empty", array.isEmpty)
        Assert.assertTrue("Array must be full", array.isFull)
    }

    @Test
    fun should_add_value_to_array() {
        val length = 1
        val array = Array<Any>(length)
        array.add(Any())
        Assert.assertEquals("Array length", length.toLong(), array.length().toLong())
        Assert.assertEquals("Array size", length.toLong(), array.size().toLong())
        Assert.assertFalse("Array must be empty", array.isEmpty)
        Assert.assertTrue("Array must be full", array.isFull)
    }

    @Test
    fun should_add_values_to_array() {
        val values = arrayOf(Any(), Any())
        val length = values.size
        val array = Array<Any>(length)
        array.addAll(values)
        Assert.assertEquals("Array length", length.toLong(), array.length().toLong())
        Assert.assertEquals("Array size", length.toLong(), array.size().toLong())
        Assert.assertFalse("Array must be empty", array.isEmpty)
        Assert.assertTrue("Array must be full", array.isFull)
    }

    @Test
    fun should_return_value_by_index_from_array() {
        val expected = Any()
        val array = Array(Any(), expected)
        Assert.assertEquals("Element at index 1", expected, array[1])
    }

    @Test
    fun should_return_firstValue_from_array() {
        val expected = Any()
        val array = Array(expected, Any())
        Assert.assertEquals("First element", expected, array.first)
    }

    @Test
    fun should_return_lastValue_from_array() {
        val expected = Any()
        val array = Array(Any(), expected)
        Assert.assertEquals("Last element", expected, array.last)
    }

    @Test
    fun should_remove_value_from_singletonArray() {
        val expected = Any()
        val array = Array(expected)
        Assert.assertEquals("Begin", 0, array.begin.toLong())
        Assert.assertEquals("End", 0, array.end.toLong())
        Assert.assertEquals("Array length", 1, array.length().toLong())
        Assert.assertEquals("Array size", 1, array.size().toLong())
        Assert.assertFalse("Array must be empty", array.isEmpty)
        Assert.assertTrue("Array must be full", array.isFull)
        val actual = array.remove(0)
        Assert.assertEquals("Begin", 0, array.begin.toLong())
        Assert.assertEquals("End", 0, array.end.toLong())
        Assert.assertEquals("Array length", 1, array.length().toLong())
        Assert.assertEquals("Array size", 0, array.size().toLong())
        Assert.assertTrue("Array must be empty", array.isEmpty)
        Assert.assertFalse("Array must be full", array.isFull)
        Assert.assertEquals("Removed element", expected, actual)
    }

    @Test
    fun should_remove_value_from_doubleArray() {
        val expected = Any()
        val array = Array(expected, Any())
        Assert.assertEquals("Begin", 0, array.begin.toLong())
        Assert.assertEquals("End", 0, array.end.toLong())
        Assert.assertEquals("Array length", 2, array.length().toLong())
        Assert.assertEquals("Array size", 2, array.size().toLong())
        Assert.assertFalse("Array must be empty", array.isEmpty)
        Assert.assertTrue("Array must be full", array.isFull)
        val actual = array.remove(0)
        Assert.assertEquals("Begin", 0, array.begin.toLong())
        Assert.assertEquals("End", 1, array.end.toLong())
        Assert.assertEquals("Array length", 2, array.length().toLong())
        Assert.assertEquals("Array size", 1, array.size().toLong())
        Assert.assertFalse("Array must be empty", array.isEmpty)
        Assert.assertFalse("Array must be full", array.isFull)
        Assert.assertEquals("Removed element", expected, actual)
    }

    @Test
    fun should_remove_firstValue_from_singletonArray() {
        val expected = Any()
        val array = Array(expected)
        Assert.assertEquals("Begin", 0, array.begin.toLong())
        Assert.assertEquals("End", 0, array.end.toLong())
        Assert.assertEquals("Array length", 1, array.length().toLong())
        Assert.assertEquals("Array size", 1, array.size().toLong())
        Assert.assertFalse("Array must be empty", array.isEmpty)
        Assert.assertTrue("Array must be full", array.isFull)
        val actual = array.removeFirst()
        Assert.assertEquals("Begin", 0, array.begin.toLong())
        Assert.assertEquals("End", 0, array.end.toLong())
        Assert.assertEquals("Array length", 1, array.length().toLong())
        Assert.assertEquals("Array size", 0, array.size().toLong())
        Assert.assertTrue("Array must be empty", array.isEmpty)
        Assert.assertFalse("Array must be full", array.isFull)
        Assert.assertEquals("Removed element", expected, actual)
    }

    @Test
    fun should_remove_firstValue_from_doubleArray() {
        val expected = Any()
        val array = Array(expected, Any())
        Assert.assertEquals("Begin", 0, array.begin.toLong())
        Assert.assertEquals("End", 0, array.end.toLong())
        Assert.assertEquals("Array length", 2, array.length().toLong())
        Assert.assertEquals("Array size", 2, array.size().toLong())
        Assert.assertFalse("Array must be empty", array.isEmpty)
        Assert.assertTrue("Array must be full", array.isFull)
        val actual = array.removeFirst()
        Assert.assertEquals("Begin", 1, array.begin.toLong())
        Assert.assertEquals("End", 0, array.end.toLong())
        Assert.assertEquals("Array length", 2, array.length().toLong())
        Assert.assertEquals("Array size", 1, array.size().toLong())
        Assert.assertFalse("Array must be empty", array.isEmpty)
        Assert.assertFalse("Array must be full", array.isFull)
        Assert.assertEquals("Removed element", expected, actual)
    }

    @Test
    fun should_remove_lastValue_from_singletonArray() {
        val expected = Any()
        val array = Array(expected)
        Assert.assertEquals("Begin", 0, array.begin.toLong())
        Assert.assertEquals("End", 0, array.end.toLong())
        Assert.assertEquals("Array length", 1, array.length().toLong())
        Assert.assertEquals("Array size", 1, array.size().toLong())
        Assert.assertFalse("Array must be empty", array.isEmpty)
        Assert.assertTrue("Array must be full", array.isFull)
        val actual = array.removeLast()
        Assert.assertEquals("Begin", 0, array.begin.toLong())
        Assert.assertEquals("End", 0, array.end.toLong())
        Assert.assertEquals("Array length", 1, array.length().toLong())
        Assert.assertEquals("Array size", 0, array.size().toLong())
        Assert.assertTrue("Array must be empty", array.isEmpty)
        Assert.assertFalse("Array must be full", array.isFull)
        Assert.assertEquals("Removed element", expected, actual)
    }

    @Test
    fun should_remove_lastValue_from_doubleArray() {
        val expected = Any()
        val array = Array(Any(), expected)
        Assert.assertEquals("Begin", 0, array.begin.toLong())
        Assert.assertEquals("End", 0, array.end.toLong())
        Assert.assertEquals("Array length", 2, array.length().toLong())
        Assert.assertEquals("Array size", 2, array.size().toLong())
        Assert.assertFalse("Array must be empty", array.isEmpty)
        Assert.assertTrue("Array must be full", array.isFull)
        val actual = array.removeLast()
        Assert.assertEquals("Begin", 0, array.begin.toLong())
        Assert.assertEquals("End", 1, array.end.toLong())
        Assert.assertEquals("Array length", 2, array.length().toLong())
        Assert.assertEquals("Array size", 1, array.size().toLong())
        Assert.assertFalse("Array must be empty", array.isEmpty)
        Assert.assertFalse("Array must be full", array.isFull)
        Assert.assertEquals("Removed element", expected, actual)
    }
}