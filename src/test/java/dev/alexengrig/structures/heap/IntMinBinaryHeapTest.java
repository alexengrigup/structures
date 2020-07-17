package dev.alexengrig.structures.heap;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class IntMinBinaryHeapTest {
    protected IntMinHeap create() {
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
    public void should_extract_values() {
        IntMinHeap heap = create();
        int[] numbers = {1, 2, 3, 4, 5};
        IntHeap.Index[] indices = new IntHeap.Index[numbers.length];
        for (int i = 0, numbersLength = numbers.length; i < numbersLength; i++) {
            indices[i] = heap.insert(numbers[i]);
        }
        for (int i = 0, indicesLength = indices.length; i < indicesLength; i++) {
            assertEquals(numbers[i], heap.extract(indices[i]));
        }
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

    @Test
    public void should_throw_invalidHeapIndexException_on_removed() {
        IntMinHeap heap = create();
        IntHeap.Index index = heap.insert(1);
        heap.insert(0);
        assertEquals(1, heap.extract(index));
        assertEquals(0, heap.min());
        try {
            heap.extract(index);
            fail();
        } catch (InvalidHeapIndexException ignored) {
        }
    }

    @Test(expected = EmptyHeapException.class)
    public void should_throw_emptyHeapException_on_extract() {
        IntMinHeap heap = create();
        heap.extract(new IntHeap.Index() {
            @Override
            public int get() {
                return 0;
            }

            @Override
            public boolean valid() {
                return false;
            }
        });
    }

    @Test(expected = EmptyHeapException.class)
    public void should_throw_emptyHeapException_on_min() {
        IntMinHeap heap = create();
        heap.min();
    }

    @Test(expected = EmptyHeapException.class)
    public void should_throw_emptyHeapException_on_decrease() {
        IntMinHeap heap = create();
        heap.decrease(new IntHeap.Index() {
            @Override
            public int get() {
                return 0;
            }

            @Override
            public boolean valid() {
                return false;
            }
        }, 0);
    }

    @Test(expected = NullPointerException.class)
    public void should_throw_nullPointerException_on_extract() {
        IntMinHeap heap = create();
        heap.extract(null);
    }

    @Test(expected = NullPointerException.class)
    public void should_throw_nullPointerException_on_decrease() {
        IntMinHeap heap = create();
        heap.decrease(null, 0);
    }

    @Test(expected = InvalidHeapIndexException.class)
    public void should_throw_invalidHeapIndexException_on_extract() {
        IntMinHeap heap = create();
        heap.insert(1);
        heap.extract(new IntHeap.Index() {
            @Override
            public int get() {
                return 0;
            }

            @Override
            public boolean valid() {
                return true;
            }
        });
    }

    @Test(expected = InvalidHeapIndexException.class)
    public void should_throw_invalidHeapIndexException_on_decrease() {
        IntMinHeap heap = create();
        heap.insert(1);
        heap.decrease(new IntHeap.Index() {
            @Override
            public int get() {
                return 0;
            }

            @Override
            public boolean valid() {
                return true;
            }
        }, 0);
    }
}