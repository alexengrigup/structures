package io.github.alexengrig.nih.collections;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayTest {
    @Test
    public void should_create_newArray_by_length() {
        final int length = 10;
        final Array<Object> array = new Array<>(length);
        assertEquals("Array length", length, array.length());
        assertEquals("Array size", 0, array.size());
        assertTrue("Array must be empty", array.isEmpty());
        assertFalse("Array must be full", array.isFull());
    }

    @Test
    public void should_create_newArray_by_values() {
        final Object[] expected = new Object[]{1, 2, 3};
        final int length = expected.length;
        final Array<Object> array = new Array<>(expected);
        assertEquals("Array length", length, array.length());
        assertEquals("Array size", length, array.size());
        assertFalse("Array must be empty", array.isEmpty());
        assertTrue("Array must be full", array.isFull());
    }

    @Test
    public void should_create_newArray_by_varargs() {
        final Object[] expected = new Object[]{1, 2, 3};
        final int length = expected.length;
        final Array<Object> array = new Array<>(expected[0], expected[1], expected[2]);
        assertEquals("Array length", length, array.length());
        assertEquals("Array size", length, array.size());
        assertFalse("Array must be empty", array.isEmpty());
        assertTrue("Array must be full", array.isFull());
    }

    @Test
    public void should_add_value_to_array() {
        final int length = 1;
        final Array<Object> array = new Array<>(length);
        array.add(new Object());
        assertEquals("Array length", length, array.length());
        assertEquals("Array size", length, array.size());
        assertFalse("Array must be empty", array.isEmpty());
        assertTrue("Array must be full", array.isFull());
    }

    @Test
    public void should_add_values_to_array() {
        final Object[] values = new Object[]{new Object(), new Object()};
        final int length = values.length;
        final Array<Object> array = new Array<>(length);
        array.addAll(values);
        assertEquals("Array length", length, array.length());
        assertEquals("Array size", length, array.size());
        assertFalse("Array must be empty", array.isEmpty());
        assertTrue("Array must be full", array.isFull());
    }

    @Test
    public void should_return_value_from_array() {
        final Object expected = new Object();
        final Array<Object> array = new Array<>(new Object(), expected);
        assertEquals("Element at index 1", expected, array.get(1));
    }

    @Test
    public void should_remove_value_from_array() {
        final Object expected = new Object();
        final Array<Object> array = new Array<>(expected);
        assertEquals("Array length", 1, array.length());
        assertEquals("Array size", 1, array.size());
        assertFalse("Array must be empty", array.isEmpty());
        assertTrue("Array must be full", array.isFull());
        final Object actual = array.remove(0);
        assertEquals("Array length", 1, array.length());
        assertEquals("Array size", 0, array.size());
        assertTrue("Array must be empty", array.isEmpty());
        assertFalse("Array must be full", array.isFull());
        assertEquals("Removed element", expected, actual);
    }

    @Test
    public void should_remove_firstValue_from_array() {
        final Object expected = new Object();
        final Array<Object> array = new Array<>(expected);
        assertEquals("Array length", 1, array.length());
        assertEquals("Array size", 1, array.size());
        assertFalse("Array must be empty", array.isEmpty());
        assertTrue("Array must be full", array.isFull());
        final Object actual = array.removeFirst();
        assertEquals("Array length", 1, array.length());
        assertEquals("Array size", 0, array.size());
        assertTrue("Array must be empty", array.isEmpty());
        assertFalse("Array must be full", array.isFull());
        assertEquals("Removed element", expected, actual);
    }

    @Test
    public void should_remove_lastValue_from_array() {
        final Object expected = new Object();
        final Array<Object> array = new Array<>(expected);
        assertEquals("Array length", 1, array.length());
        assertEquals("Array size", 1, array.size());
        assertFalse("Array must be empty", array.isEmpty());
        assertTrue("Array must be full", array.isFull());
        final Object actual = array.removeLast();
        assertEquals("Array length", 1, array.length());
        assertEquals("Array size", 0, array.size());
        assertTrue("Array must be empty", array.isEmpty());
        assertFalse("Array must be full", array.isFull());
        assertEquals("Removed element", expected, actual);
    }
}