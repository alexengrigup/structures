package dev.alexengrig.structures.array;

import java.util.function.IntFunction;

public class IntSynchronizedArray extends IntPlainArray {
    public IntSynchronizedArray(int length) {
        super(length);
    }

    protected IntSynchronizedArray(int[] values) {
        super(values);
    }

    public static IntSynchronizedArray from(int[] values) {
        return new IntSynchronizedArray(values);
    }

    @Override
    public synchronized int compute(int index, IntFunction<Integer> updater) {
        return super.compute(index, updater);
    }

    @Override
    public synchronized int at(int index) {
        return super.at(index);
    }

    @Override
    public synchronized int set(int index, int value) {
        return super.set(index, value);
    }

    @Override
    public synchronized int hashCode() {
        return super.hashCode();
    }

    @Override
    public synchronized boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public synchronized String toString() {
        return super.toString();
    }
}
