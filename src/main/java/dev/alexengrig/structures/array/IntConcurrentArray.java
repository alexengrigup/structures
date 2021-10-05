package dev.alexengrig.structures.array;

import java.util.function.IntFunction;

public class IntConcurrentArray implements IntArray {
    @Override
    public int compute(int index, IntFunction<Integer> updater) {
        return 0;
    }

    @Override
    public int at(int index) {
        return 0;
    }

    @Override
    public int set(int index, int value) {
        return 0;
    }

    @Override
    public int length() {
        return 0;
    }
}
