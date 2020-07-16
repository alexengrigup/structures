package dev.alexengrig.structures.heap;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class IntMinBinaryHeapTest {
    protected IntMinBinaryHeap create() {
        return new IntMinBinaryHeap();
    }

    @Test
    public void should_create_emptyHeap() {
        IntMinHeap heap = create();
        assertTrue(heap.empty());
        assertEquals(0, heap.size());
    }

    @Test
    public void should_insert_oneValue() {
        IntMinHeap heap = create();
        assertTrue(heap.empty());
        IntHeap.Index oneIndex = heap.insert(1);
        assertTrue(oneIndex.valid());
        assertEquals(0, oneIndex.get());
        assertEquals(1, heap.min());
        assertEquals(1, heap.extractMin());
        assertTrue(heap.empty());
    }
}