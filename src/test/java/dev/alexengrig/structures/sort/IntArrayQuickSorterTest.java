package dev.alexengrig.structures.sort;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class IntArrayQuickSorterTest {
    @Test
    public void should_sort() {
        IntArrayQuickSorter sorter = new IntArrayQuickSorter.RandomPivot();
        int[] array = {2, 3, 1, 4, 7, 6, 5};
        sorter.sort(array);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7}, array);
    }

}
