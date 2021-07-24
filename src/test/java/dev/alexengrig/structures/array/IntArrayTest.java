package dev.alexengrig.structures.array;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class IntArrayTest {
    @Test
    public void should_swap_elements_in_intArray() {
        IntArray array = IntPlainArray.from(new int[]{2, 1});
        IntArray.swap(array, 0, 1);
        assertEquals(1, array.at(0));
        assertEquals(2, array.at(1));
    }

    @Test
    public void should_swap_elements_in_array() {
        int[] array = {2, 1};
        IntArray.swap(array, 0, 1);
        assertArrayEquals(new int[]{1, 2}, array);
    }

    @Test
    public void should_swap_elements_in_array_via_sum() {
        int[] array = {2, 1};
        IntArray.swapSum(array, 0, 1);
        assertArrayEquals(new int[]{1, 2}, array);
    }

    @Test
    public void should_swap_elements_in_array_via_diff() {
        int[] array = {2, 1};
        IntArray.swapDiff(array, 0, 1);
        assertArrayEquals(new int[]{1, 2}, array);
    }

    @Test
    public void should_swap_elements_in_array_via_xor() {
        int[] array = {2, 1};
        IntArray.swapXor(array, 0, 1);
        assertArrayEquals(new int[]{1, 2}, array);
    }
}