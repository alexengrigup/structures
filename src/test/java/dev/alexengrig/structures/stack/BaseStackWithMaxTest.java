package dev.alexengrig.structures.stack;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public abstract class BaseStackWithMaxTest {
    protected abstract <E extends Comparable<E>> StackWithMax<E> create();

    @Test
    public void should_return_max() {
        StackWithMax<String> stack = create();
        stack.push("2");
        stack.push("1");
        stack.push("2");
        stack.push("3");
        assertEquals(4, stack.size());
        assertEquals("3", stack.max());
        assertEquals("3", stack.pop());
        assertEquals("2", stack.max());
        assertEquals("2", stack.pop());
        assertEquals("2", stack.max());
        assertEquals("1", stack.pop());
        assertEquals("2", stack.max());
        assertEquals("2", stack.pop());
    }
}
