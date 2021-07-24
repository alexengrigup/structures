package dev.alexengrig.structures.array;

import java.util.Arrays;

public class IntPlainArray implements IntArray {
    protected final int[] values;

    public IntPlainArray(int length) {
        this(new int[length]);
    }

    protected IntPlainArray(int[] values) {
        this.values = values;
    }

    public static IntPlainArray from(int[] values) {
        return new IntPlainArray(values);
    }

    @Override
    public int at(int index) {
        return values[index];
    }

    @Override
    public int set(int index, int value) {
        int target = values[index];
        values[index] = value;
        return target;
    }

    @Override
    public int length() {
        return values.length;
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(values);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IntPlainArray that = (IntPlainArray) o;
        return Arrays.equals(values, that.values);
    }

    @Override
    public String toString() {
        return Arrays.toString(values);
    }
}
