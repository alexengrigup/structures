package dev.alexengrig.structures.queue;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public abstract class BaseIntQueueWithMaxTest {
    protected abstract IntQueueWithMax create();

    @Test
    public void should_return_max() {
        IntQueueWithMax queue = create();
        queue.enqueue(4);
        queue.enqueue(3);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(1);
        assertEquals(5, queue.size());
        assertEquals(4, queue.max());
        assertEquals(4, queue.dequeue());
        assertEquals(3, queue.max());
        assertEquals(3, queue.dequeue());
        assertEquals(3, queue.max());
        assertEquals(2, queue.dequeue());
        assertEquals(3, queue.max());
        assertEquals(3, queue.dequeue());
        assertEquals(1, queue.max());
        assertEquals(1, queue.dequeue());
        assertEquals(0, queue.size());
        assertTrue(queue.empty());
    }
}