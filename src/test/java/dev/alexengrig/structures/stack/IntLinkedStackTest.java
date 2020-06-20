package dev.alexengrig.structures.stack;

import org.junit.Test;

import static org.junit.Assert.*;

public class IntLinkedStackTest {
    @Test
    public void should_create_empty() {
        IntLinkedStack stack = new IntLinkedStack();
        assertTrue(stack.empty());
        assertEquals(0, stack.size());
    }

    @Test
    public void should_push_24_elements() {
        IntLinkedStack stack = new IntLinkedStack();
        for (int i = 0; i < 24; i++) {
            stack.push(i);
        }
        assertFalse(stack.empty());
        assertEquals(24, stack.size());
    }

    @Test
    public void should_pop_24_elements() {
        IntLinkedStack stack = new IntLinkedStack();
        for (int i = 0; i < 24; i++) {
            stack.push(i);
        }
        for (int i = 23; i >= 0; i--) {
            assertEquals(i, stack.pop());
        }
        assertTrue(stack.empty());
        assertEquals(0, stack.size());
    }

    @Test
    public void should_return_actualTop() {
        IntLinkedStack stack = new IntLinkedStack();
        for (int i = 0; i < 24; i++) {
            stack.push(i);
            assertEquals(i, stack.top());
        }
        assertFalse(stack.empty());
        assertEquals(24, stack.size());
    }

    @Test
    public void should_beDone_workflow() {
        IntLinkedStack stack = new IntLinkedStack();
        for (int i = 0; i < 4; i++) {
            stack.push(i);
        }
        assertEquals(4, stack.size());
        for (int i = 3; i > 1; i--) {
            assertEquals(i, stack.pop());
        }
        assertEquals(2, stack.size());
        stack.push(5);
        assertEquals(3, stack.size());
        assertEquals(5, stack.top());
    }
}