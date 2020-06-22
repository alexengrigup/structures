package dev.alexengrig.structures.stack;

import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedStackTest {
    protected <T> LinkedStack<T> create() {
        return new LinkedStack<>();
    }

    @Test
    public void should_create_empty() {
        LinkedStack<String> stack = create();
        assertTrue(stack.empty());
        assertEquals(0, stack.size());
    }

    @Test
    public void should_push_24_elements() {
        LinkedStack<String> stack = create();
        for (int i = 0; i < 24; i++) {
            stack.push("" + i);
        }
        assertFalse(stack.empty());
        assertEquals(24, stack.size());
    }

    @Test
    public void should_pop_24_elements() {
        LinkedStack<String> stack = create();
        for (int i = 0; i < 24; i++) {
            stack.push("" + i);
        }
        for (int i = 23; i >= 0; i--) {
            assertEquals("" + i, stack.pop());
        }
        assertTrue(stack.empty());
        assertEquals(0, stack.size());
    }

    @Test
    public void should_return_actualTop() {
        LinkedStack<String> stack = create();
        for (int i = 0; i < 24; i++) {
            stack.push("" + i);
            assertEquals("" + i, stack.top());
        }
        assertFalse(stack.empty());
        assertEquals(24, stack.size());
    }

    @Test
    public void should_beDone_workflow() {
        LinkedStack<String> stack = create();
        for (int i = 0; i < 4; i++) {
            stack.push("" + i);
        }
        assertEquals(4, stack.size());
        for (int i = 3; i > 1; i--) {
            assertEquals("" + i, stack.pop());
        }
        assertEquals(2, stack.size());
        stack.push("5");
        assertEquals(3, stack.size());
        assertEquals("5", stack.top());
    }
}