package dev.alexengrig.structures.stack.bad;

import dev.alexengrig.structures.stack.IntArrayStackTest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IntBruteArrayStackWithMaxTest extends IntArrayStackTest {
    @Override
    protected IntBruteArrayStackWithMax create() {
        return new IntBruteArrayStackWithMax();
    }

    @Test
    public void should_return_max() {
        IntBruteArrayStackWithMax stack = create();
        for (int i = 0; i < 4; i++) {
            stack.push(i);
        }
        assertEquals(4, stack.size());
        assertEquals(3, stack.max());
    }
}