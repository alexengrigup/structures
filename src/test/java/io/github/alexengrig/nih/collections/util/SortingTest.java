package io.github.alexengrig.nih.collections.util;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.assertArrayEquals;

public class SortingTest {
    @Test
    public void checkInsertionForEmpty() {
        int[] ints = {};
        Sorting.insertion(ints);
        assertArrayEquals(new int[]{}, ints);
    }

    @Test
    public void checkInsertionForSingleton() {
        int[] ints = {1};
        Sorting.insertion(ints);
        assertArrayEquals(new int[]{1}, ints);
    }

    @Test
    public void checkInsertionForDouble() {
        int[] ints = {2, 1};
        Sorting.insertion(ints);
        assertArrayEquals(new int[]{1, 2}, ints);
    }

    @Test
    public void checkInsertionForSimple() {
        int[] ints = {3, 1, 2};
        Sorting.insertion(ints);
        assertArrayEquals(new int[]{1, 2, 3}, ints);
    }

    @Test
    public void checkInsertionForRandom() {
        int[] ints = new Random().ints(100).toArray();
        Sorting.insertion(ints);
        assertArrayEquals(Arrays.stream(ints).sorted().toArray(), ints);
    }
}