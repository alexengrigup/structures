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
        final Array<Object> array = new Array<>(expected);
        assertEquals(expected.length, array.length());
        assertEquals(expected.length, array.size());
        assertFalse("Array must be empty", array.isEmpty());
        assertTrue("Array must be full", array.isFull());
    }

    @Test
    public void should_create_newArray_by_varargs() {
        final Object[] expected = new Object[]{1, 2, 3};
        final Array<Object> array = new Array<>(expected[0], expected[1], expected[2]);
        assertEquals(expected.length, array.length());
        assertEquals(expected.length, array.size());
        assertFalse("Array must be empty", array.isEmpty());
        assertTrue("Array must be full", array.isFull());
    }

    @Test
    public void should_add_oneValue_to_array() {
        final int length = 1;
        final Array<Object> array = new Array<>(length);
        array.add(new Object());
        assertEquals(length, array.length());
        assertEquals(length, array.size());
        assertFalse("Array must be empty", array.isEmpty());
        assertTrue("Array must be full", array.isFull());
    }

    @Test
    public void should_add_twoValue_to_array() {
        final int length = 2;
        final Array<Object> array = new Array<>(length);
        array.add(new Object());
        array.add(new Object());
        assertEquals(length, array.length());
        assertEquals(length, array.size());
        assertFalse("Array must be empty", array.isEmpty());
        assertTrue("Array must be full", array.isFull());
    }
}