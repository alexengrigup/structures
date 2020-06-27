package dev.alexengrig.structures.stack;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public abstract class BaseIntStackWithMinTest {
    protected abstract IntStackWithMin create();

    @Test
    public void should_return_min() {
        IntStackWithMin stack = create();
        stack.push(3);
        stack.push(1);
        stack.push(2);
        stack.push(1);
        assertEquals(4, stack.size());
        assertEquals(1, stack.min());
        assertEquals(1, stack.pop());
        assertEquals(1, stack.min());
        assertEquals(2, stack.pop());
        assertEquals(1, stack.min());
        assertEquals(1, stack.pop());
        assertEquals(3, stack.min());
        assertEquals(3, stack.pop());
    }
}
