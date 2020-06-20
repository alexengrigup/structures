package dev.alexengrig.structures.stack;

import org.junit.Test;

import static org.junit.Assert.*;

public class IntArrayStackTest {
    protected IntArrayStack create() {
        return new IntArrayStack();
    }

    @Test
    public void should_create_empty() {
        IntArrayStack stack = create();
        assertTrue(stack.empty());
        assertEquals(0, stack.size());
        assertEquals(8, stack.array.length);
    }

    @Test
    public void should_create_emptyWithCustomCapacity() {
        IntArrayStack stack = new IntArrayStack(4);
        assertTrue(stack.empty());
        assertEquals(0, stack.size());
        assertEquals(4, stack.array.length);
    }

    @Test
    public void should_push_8_elements() {
        IntArrayStack stack = create();
        for (int i = 0; i < 8; i++) {
            stack.push(i);
        }
        assertFalse(stack.empty());
        assertEquals(8, stack.size());
        assertEquals(8, stack.array.length);
    }

    @Test
    public void should_push_12_elements() {
        IntArrayStack stack = create();
        for (int i = 0; i < 12; i++) {
            stack.push(i);
        }
        assertFalse(stack.empty());
        assertEquals(12, stack.size());
        assertEquals(16, stack.array.length);
    }

    @Test
    public void should_push_24_elements() {
        IntArrayStack stack = create();
        for (int i = 0; i < 24; i++) {
            stack.push(i);
        }
        assertFalse(stack.empty());
        assertEquals(24, stack.size());
        assertEquals(32, stack.array.length);
    }

    @Test
    public void should_pop_8_elements() {
        IntArrayStack stack = create();
        for (int i = 0; i < 8; i++) {
            stack.push(i);
        }
        for (int i = 7; i >= 0; i--) {
            assertEquals(i, stack.pop());
        }
        assertTrue(stack.empty());
        assertEquals(0, stack.size());
        assertEquals(8, stack.array.length);
    }

    @Test
    public void should_pop_12_elements() {
        IntArrayStack stack = create();
        for (int i = 0; i < 12; i++) {
            stack.push(i);
        }
        for (int i = 11; i >= 0; i--) {
            assertEquals(i, stack.pop());
        }
        assertTrue(stack.empty());
        assertEquals(0, stack.size());
        assertEquals(16, stack.array.length);
    }

    @Test
    public void should_pop_24_elements() {
        IntArrayStack stack = create();
        for (int i = 0; i < 24; i++) {
            stack.push(i);
        }
        for (int i = 23; i >= 0; i--) {
            assertEquals(i, stack.pop());
        }
        assertTrue(stack.empty());
        assertEquals(0, stack.size());
        assertEquals(32, stack.array.length);
    }

    @Test
    public void should_return_actualTop() {
        IntArrayStack stack = create();
        for (int i = 0; i < 24; i++) {
            stack.push(i);
            assertEquals(i, stack.top());
        }
        assertFalse(stack.empty());
        assertEquals(24, stack.size());
        assertEquals(32, stack.array.length);
    }
}