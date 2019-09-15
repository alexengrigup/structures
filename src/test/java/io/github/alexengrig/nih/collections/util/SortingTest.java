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

    @Test
    public void checkSelectionForEmpty() {
        int[] ints = {};
        Sorting.selection(ints);
        assertArrayEquals(new int[]{}, ints);
    }

    @Test
    public void checkSelectionForSingleton() {
        int[] ints = {1};
        Sorting.selection(ints);
        assertArrayEquals(new int[]{1}, ints);
    }

    @Test
    public void checkSelectionForDouble() {
        int[] ints = {2, 1};
        Sorting.selection(ints);
        assertArrayEquals(new int[]{1, 2}, ints);
    }

    @Test
    public void checkSelectionForSimple() {
        int[] ints = {3, 1, 2};
        Sorting.selection(ints);
        assertArrayEquals(new int[]{1, 2, 3}, ints);
    }

    @Test
    public void checkSelectionForRandom() {
        int[] ints = new Random().ints(100).toArray();
        Sorting.selection(ints);
        assertArrayEquals(Arrays.stream(ints).sorted().toArray(), ints);
    }

    @Test
    public void checkBubbleForEmpty() {
        int[] ints = {};
        Sorting.bubble(ints);
        assertArrayEquals(new int[]{}, ints);
    }

    @Test
    public void checkBubbleForSingleton() {
        int[] ints = {1};
        Sorting.bubble(ints);
        assertArrayEquals(new int[]{1}, ints);
    }

    @Test
    public void checkBubbleForDouble() {
        int[] ints = {2, 1};
        Sorting.bubble(ints);
        assertArrayEquals(new int[]{1, 2}, ints);
    }

    @Test
    public void checkBubbleForSimple() {
        int[] ints = {3, 1, 2};
        Sorting.bubble(ints);
        assertArrayEquals(new int[]{1, 2, 3}, ints);
    }

    @Test
    public void checkBubbleForRandom() {
        int[] ints = new Random().ints(100).toArray();
        Sorting.bubble(ints);
        assertArrayEquals(Arrays.stream(ints).sorted().toArray(), ints);
    }
}