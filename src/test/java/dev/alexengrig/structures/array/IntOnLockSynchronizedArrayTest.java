package dev.alexengrig.structures.array;

public class IntOnLockSynchronizedArrayTest extends BaseIntSynchronizedArrayTest {
    public IntOnLockSynchronizedArrayTest(int length, int numberOfThreads, int expected) {
        super(length, numberOfThreads, expected);
    }

    @Override
    protected IntArray createArray(int[] values) {
        return IntOnLockSynchronizedArray.from(values);
    }
}