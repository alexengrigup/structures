package dev.alexengrig.structures.stack;

public class IntLinkedStackWithMinTest extends BaseIntStackWithMinTest {
    @Override
    protected IntStackWithMin create() {
        return new IntLinkedStackWithMin();
    }
}