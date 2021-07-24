package dev.alexengrig.structures.array;

public class IntOnThisSynchronizedArrayTest extends BaseIntSynchronizedArrayTest {
    public IntOnThisSynchronizedArrayTest(int length, int numberOfThreads, int expected) {
        super(length, numberOfThreads, expected);
    }

    @Override
    protected IntArray createArray(int[] values) {
        return IntOnThisSynchronizedArray.from(values);
    }
}