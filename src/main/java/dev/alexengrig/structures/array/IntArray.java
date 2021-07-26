package dev.alexengrig.structures.array;

import java.util.function.IntFunction;

public interface IntArray {
    static void swap(IntArray array, int from, int to) {
        array.set(to, array.set(from, array.at(to)));
    }

    static void swap(int[] array, int from, int to) {
        int temp = array[from];
        array[from] = array[to];
        array[to] = temp;
    }

    static void swapSum(int[] array, int from, int to) {
        // array[from] = array[from] + array[to] - (array[to] = array[from])
        array[from] = array[from] + array[to];
        array[to] = array[from] - array[to];
        array[from] = array[from] - array[to];
    }

    static void swapDiff(int[] array, int from, int to) {
        array[from] = array[from] - array[to];
        array[to] = array[from] + array[to];
        array[from] = array[to] - array[from];
    }

    static void swapXor(int[] array, int from, int to) {
        array[from] = array[from] ^ array[to];
        array[to] = array[from] ^ array[to];
        array[from] = array[from] ^ array[to];
    }

    int compute(int index, IntFunction<Integer> updater);

    int at(int index);

    int set(int index, int value);

    int length();
}
