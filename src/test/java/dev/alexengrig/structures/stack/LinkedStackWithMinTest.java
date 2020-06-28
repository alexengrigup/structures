package dev.alexengrig.structures.stack;

public class LinkedStackWithMinTest extends BaseStackWithMinTest {
    @Override
    protected <E extends Comparable<E>> StackWithMin<E> create() {
        return new LinkedStackWithMin<>();
    }
}