package dev.alexengrig.structures.array;

import java.util.function.IntFunction;

public class IntOnLockSynchronizedArray extends IntPlainArray {
    private final Object lock = new Object();

    public IntOnLockSynchronizedArray(int length) {
        super(length);
    }

    protected IntOnLockSynchronizedArray(int[] values) {
        super(values);
    }

    public static IntOnLockSynchronizedArray from(int[] values) {
        return new IntOnLockSynchronizedArray(values);
    }

    @Override
    public int compute(int index, IntFunction<Integer> updater) {
        synchronized (this.lock) {
            return super.compute(index, updater);
        }
    }

    @Override
    public int at(int index) {
        synchronized (this.lock) {
            return super.at(index);
        }
    }

    @Override
    public int set(int index, int value) {
        synchronized (this.lock) {
            return super.set(index, value);
        }
    }

    @Override
    public int hashCode() {
        synchronized (this.lock) {
            return super.hashCode();
        }
    }

    @Override
    public boolean equals(Object o) {
        synchronized (this.lock) {
            return super.equals(o);
        }
    }

    @Override
    public String toString() {
        synchronized (this.lock) {
            return super.toString();
        }
    }
}
