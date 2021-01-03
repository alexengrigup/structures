package dev.alexengrig.structures.queue;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public abstract class BaseIntQueueWithMinTest {
    protected abstract IntQueueWithMin create();

    @Test
    public void should_return_min() {
        IntQueueWithMin queue = create();
        queue.enqueue(4);
        queue.enqueue(3);
        assertEquals(3, queue.back());
        /*
        assertEquals(4, queue.front());
        assertEquals(3, queue.min());
        queue.enqueue(2);
        assertEquals(2, queue.min());
        assertEquals(2, queue.back());
        queue.enqueue(3);
        assertEquals(2, queue.min());
        assertEquals(2, queue.back());
        assertEquals(4, queue.dequeue());
        assertEquals(3, queue.dequeue());
        assertEquals(2, queue.dequeue());
        assertEquals(3, queue.min());
        assertEquals(3, queue.front());
        assertEquals(3, queue.back());*/
    }
}