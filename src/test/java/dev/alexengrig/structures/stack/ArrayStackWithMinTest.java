package dev.alexengrig.structures.stack;

public class ArrayStackWithMinTest extends BaseStackWithMinTest {
    @Override
    protected <E extends Comparable<E>> StackWithMin<E> create() {
        return new ArrayStackWithMin<>();
    }
}