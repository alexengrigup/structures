package dev.alexengrig.structures.array;

public class IntPlainArray implements IntArray {
    protected int[] array;

    public IntPlainArray(int length) {
        this.array = new int[length];
    }

    @Override
    public int at(int index) {
        return array[index];
    }

    @Override
    public int at(int index, int value) {
        int target = array[index];
        array[index] = value;
        return target;
    }

    @Override
    public int length() {
        return array.length;
    }
}
