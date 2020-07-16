package dev.alexengrig.structures.heap;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

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
        assertFalse(oneIndex.valid());
        assertTrue(heap.empty());
    }

    @Test
    public void should_insert_twoValues() {
        IntMinHeap heap = create();
        assertTrue(heap.empty());
        IntHeap.Index oneIndex = heap.insert(1);
        assertTrue(oneIndex.valid());
        assertEquals(0, oneIndex.get());
        assertEquals(1, heap.min());
        IntHeap.Index zeroIndex = heap.insert(0);
        assertTrue(zeroIndex.valid());
        assertEquals(0, zeroIndex.get());
        assertEquals(2, heap.size());
        assertEquals(0, heap.min());
        assertEquals(0, heap.extractMin());
        assertFalse(zeroIndex.valid());
        assertEquals(1, heap.size());
        assertEquals(1, heap.min());
        assertTrue(oneIndex.valid());
        assertEquals(0, oneIndex.get());
        assertEquals(1, heap.extractMin());
        assertFalse(oneIndex.valid());
        assertTrue(heap.empty());
    }

    @Test
    public void should_sort_values_via_heap() {
        IntMinHeap heap = create();
        List<Integer> values = Arrays.asList(3, 1, 2, 5, 4);
        for (int value : values) {
            heap.insert(value);
        }
        int[] actual = new int[values.size()];
        int i = 0;
        while (!heap.empty()) {
            actual[i++] = heap.extractMin();
        }
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, actual);
    }
}