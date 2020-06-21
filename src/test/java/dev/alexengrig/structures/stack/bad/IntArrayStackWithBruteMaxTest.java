package dev.alexengrig.structures.stack.bad;

import dev.alexengrig.structures.stack.IntArrayStackTest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IntArrayStackWithBruteMaxTest extends IntArrayStackTest {
    @Override
    protected IntArrayStackWithBruteMax create() {
        return new IntArrayStackWithBruteMax();
    }

    @Test
    public void should_return_max() {
        IntArrayStackWithBruteMax stack = create();
        stack.push(2);
        stack.push(1);
        stack.push(3);
        assertEquals(3, stack.size());
        assertEquals(3, stack.max());
        assertEquals(3, stack.pop());
        assertEquals(2, stack.max());
        assertEquals(1, stack.pop());
        assertEquals(2, stack.max());
        assertEquals(2, stack.pop());
    }
}