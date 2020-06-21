package dev.alexengrig.structures.stack;

public class IntLinkedStackWithMaxTest extends BaseIntStackWithMaxTest {
    @Override
    protected IntStackWithMax create() {
        return new IntLinkedStackWithMax();
    }
}