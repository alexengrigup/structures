package dev.alexengrig.structures.stack.bad;

import dev.alexengrig.structures.stack.IntLinkedStackTest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IntBruteLinkedStackWithMaxTest extends IntLinkedStackTest {
    @Override
    protected IntBruteLinkedStackWithMax create() {
        return new IntBruteLinkedStackWithMax();
    }

    @Test
    public void should_return_max() {
        IntBruteLinkedStackWithMax stack = create();
        for (int i = 0; i < 4; i++) {
            stack.push(i);
        }
        assertEquals(4, stack.size());
        assertEquals(3, stack.max());
    }
}