package dev.alexengrig.structures.queue;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public abstract class BaseIntQueueWithMaxTest extends BaseIntQueueTest {
    protected abstract IntQueueWithMax create();

    @Test
    public void should_return_max() {
        IntQueueWithMax queue = create();
        queue.enqueue(4);
        queue.enqueue(3);
        assertEquals(3, queue.back());
        assertEquals(4, queue.front());
        assertEquals(4, queue.max());
        queue.enqueue(5);
        assertEquals(5, queue.max());
        assertEquals(5, queue.back());
        queue.enqueue(3);
        assertEquals(5, queue.max());
        assertEquals(3, queue.back());
        assertEquals(4, queue.dequeue());
        assertEquals(3, queue.dequeue());
        assertEquals(5, queue.dequeue());
        assertEquals(3, queue.max());
        assertEquals(3, queue.front());
        assertEquals(3, queue.back());
    }
}