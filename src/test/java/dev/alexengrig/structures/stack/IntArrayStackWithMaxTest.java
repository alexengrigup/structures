package dev.alexengrig.structures.stack;

public class IntArrayStackWithMaxTest extends BaseIntStackWithMaxTest {
    @Override
    protected IntStackWithMax create() {
        return new IntArrayStackWithMax();
    }
}