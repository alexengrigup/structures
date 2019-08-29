package io.github.alexengrig.nih.collections.util;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class SortingTest {

    @Test
    public void checkInsertion() {
        assertArrayEquals(new int[]{1, 2, 3}, Sorting.insertion(new int[]{3, 1, 2}));
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, Sorting.insertion(new int[]{3, 1, 2, 4, 5}));
    }
}