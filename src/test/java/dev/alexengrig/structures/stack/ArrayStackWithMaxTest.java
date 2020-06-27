package dev.alexengrig.structures.stack;

public class ArrayStackWithMaxTest extends BaseStackWithMaxTest {
    @Override
    protected <E extends Comparable<E>> StackWithMax<E> create() {
        return new ArrayStackWithMax<>();
    }
}