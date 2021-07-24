package dev.alexengrig.structures.array;

public class IntOnValuesSynchronizedArrayTest extends BaseIntSynchronizedArrayTest {
    public IntOnValuesSynchronizedArrayTest(int length, int numberOfThreads, int expected) {
        super(length, numberOfThreads, expected);
    }

    @Override
    protected IntArray createArray(int[] values) {
        return IntOnValuesSynchronizedArray.from(values);
    }
}