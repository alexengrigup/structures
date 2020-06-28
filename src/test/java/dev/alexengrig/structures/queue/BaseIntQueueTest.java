package dev.alexengrig.structures.queue;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public abstract class BaseIntQueueTest {
    protected abstract IntQueue create();

    @Test
    public void should_done_workflow() {
        IntQueue queue = create();
        int length = 5;
        for (int i = 0; i < length; i++) {
            assertEquals(i, queue.size());
            queue.enqueue(i);
            assertEquals(i, queue.back());
            assertEquals(0, queue.front());
        }
        assertEquals(length, queue.size());
        assertEquals(length - 1, queue.back());
        assertEquals(0, queue.front());
        for (int i = 0; i < length; i++) {
            assertEquals(length - 1, queue.back());
            assertEquals(i, queue.front());
            assertEquals(length - i, queue.size());
            assertEquals(i, queue.dequeue());
        }
        assertEquals(0, queue.size());
        assertTrue(queue.empty());
    }
}