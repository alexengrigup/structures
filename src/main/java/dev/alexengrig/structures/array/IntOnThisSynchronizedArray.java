package dev.alexengrig.structures.array;

import java.util.function.IntFunction;

public class IntOnThisSynchronizedArray extends IntPlainArray {
    public IntOnThisSynchronizedArray(int length) {
        super(length);
    }

    protected IntOnThisSynchronizedArray(int[] values) {
        super(values);
    }

    public static IntOnThisSynchronizedArray from(int[] values) {
        return new IntOnThisSynchronizedArray(values);
    }

    @Override
    public int compute(int index, IntFunction<Integer> updater) {
        synchronized (this) {
            return super.compute(index, updater);
        }
    }

    @Override
    public int at(int index) {
        synchronized (this) {
            return super.at(index);
        }
    }

    @Override
    public int set(int index, int value) {
        synchronized (this) {
            return super.set(index, value);
        }
    }

    @Override
    public int hashCode() {
        synchronized (this) {
            return super.hashCode();
        }
    }

    @Override
    public boolean equals(Object o) {
        synchronized (this) {
            return super.equals(o);
        }
    }

    @Override
    public String toString() {
        synchronized (this) {
            return super.toString();
        }
    }
}
