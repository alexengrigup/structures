package dev.alexengrig.structures.stack;

public class LinkedStackWithMaxTest extends BaseStackWithMaxTest {
    @Override
    protected <E extends Comparable<E>> StackWithMax<E> create() {
        return new LinkedStackWithMax<>();
    }
}