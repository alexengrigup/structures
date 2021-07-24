package dev.alexengrig.structures.array;

import java.util.function.IntFunction;

public class IntOnValuesSynchronizedArray extends IntPlainArray {
    public IntOnValuesSynchronizedArray(int length) {
        super(length);
    }

    protected IntOnValuesSynchronizedArray(int[] values) {
        super(values);
    }

    public static IntOnValuesSynchronizedArray from(int[] values) {
        return new IntOnValuesSynchronizedArray(values);
    }

    @Override
    public int compute(int index, IntFunction<Integer> updater) {
        synchronized (this.values) {
            return super.compute(index, updater);
        }
    }

    @Override
    public int at(int index) {
        synchronized (this.values) {
            return super.at(index);
        }
    }

    @Override
    public int set(int index, int value) {
        synchronized (this.values) {
            return super.set(index, value);
        }
    }

    @Override
    public int hashCode() {
        synchronized (this.values) {
            return super.hashCode();
        }
    }

    @Override
    public boolean equals(Object o) {
        synchronized (this.values) {
            return super.equals(o);
        }
    }

    @Override
    public String toString() {
        synchronized (this.values) {
            return super.toString();
        }
    }
}
