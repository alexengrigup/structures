package dev.alexengrig.structures.array;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class IntPlainArrayTest {
    @Test
    public void should_create_array_with_length() {
        IntPlainArray array = new IntPlainArray(1);
        assertEquals(1, array.length());
    }

    @Test
    public void should_create_array_from_another() {
        IntPlainArray array = IntPlainArray.from(new int[]{1, 2});
        assertEquals(2, array.length());
        assertEquals(1, array.at(0));
        assertEquals(2, array.at(1));
    }

    @Test
    public void should_set_value() {
        IntPlainArray array = new IntPlainArray(1);
        int oldValue = array.set(0, 1);
        assertEquals(0, oldValue);
        int newValue = array.at(0);
        assertEquals(1, newValue);
    }

    @Test
    public void should_return_hashCode() {
        IntPlainArray array = IntPlainArray.from(new int[]{1});
        assertEquals(Arrays.hashCode(new int[]{1}), array.hashCode());
    }

    @Test
    public void should_return_toString() {
        IntPlainArray array = IntPlainArray.from(new int[]{1});
        assertEquals(Arrays.toString(new int[]{1}), array.toString());
    }

    @Test
    public void should_check_equals() {
        IntPlainArray array1 = IntPlainArray.from(new int[]{1});
        IntPlainArray array2 = IntPlainArray.from(new int[]{1});
        assertEquals(array1, array2);
    }
}