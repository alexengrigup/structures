package dev.alexengrig.structures.array;

public class IntSynchronizedArrayTest extends BaseIntSynchronizedArrayTest {
    public IntSynchronizedArrayTest(int length, int numberOfThreads, int expected) {
        super(length, numberOfThreads, expected);
    }

    @Override
    protected IntArray createArray(int[] values) {
        return IntSynchronizedArray.from(values);
    }
}