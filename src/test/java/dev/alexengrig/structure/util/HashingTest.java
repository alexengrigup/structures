package dev.alexengrig.structure.util;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HashingTest {
    @Test
    public void check_hashCode_boolean() {
        boolean value = Boolean.TRUE;
        //noinspection ConstantConditions
        int actual = Hashing.hashCode(value);
        int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    public void check_hashCode_byte() {
        byte value = Byte.MAX_VALUE;
        int actual = Hashing.hashCode(value);
        assertEquals(Byte.MAX_VALUE, actual);
    }

    @Test
    public void check_hashCode_char() {
        char value = Character.MAX_VALUE;
        int actual = Hashing.hashCode(value);
        assertEquals(Character.MAX_VALUE, actual);
    }

    @Test
    public void check_hashCode_short() {
        short value = Short.MAX_VALUE;
        int actual = Hashing.hashCode(value);
        assertEquals(Short.MAX_VALUE, actual);
    }

    @Test
    public void check_hashCode_int() {
        int value = Integer.MAX_VALUE;
        int actual = Hashing.hashCode(value);
        assertEquals(Integer.MAX_VALUE, actual);
    }

    @Test
    public void check_hashCode_long() {
        long value = Long.MAX_VALUE;
        int actual = Hashing.hashCode(value);
        assertEquals(Integer.MIN_VALUE, actual);
    }

    @Test
    public void check_hashCode_float() {
        float value = Float.MAX_VALUE;
        int actual = Hashing.hashCode(value);
        int expected = Float.floatToIntBits(Float.MAX_VALUE);
        assertEquals(expected, actual);
    }

    @Test
    public void check_hashCode_double() {
        double value = Double.MAX_VALUE;
        int actual = Hashing.hashCode(value);
        int expected = Hashing.hashCode(Double.doubleToLongBits(Double.MAX_VALUE));
        assertEquals(expected, actual);
    }

    @Test
    public void check_hashCode_object() {
        int actual = Hashing.hashCode(new Item(Integer.MAX_VALUE));
        assertEquals(Integer.MAX_VALUE, actual);
    }

    @Test
    public void check_hashCode_objects() {
        int[] values = new int[]{0, 10, 20};
        Object[] objects = new Item[3];
        int expected = 13;
        for (int i = 0, length = values.length; i < length; i++) {
            int value = values[i];
            objects[i] = new Item(value);
            expected = 31 * expected + value;
        }
        int actual = Hashing.hashCode(objects);
        assertEquals(387613, actual);
    }

    static class Item {
        private final int value;

        public Item(int value) {
            this.value = value;
        }

        @Override
        public int hashCode() {
            return value;
        }
    }
}