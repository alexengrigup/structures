package dev.alexengrig.structures.stack;

public class IntArrayStackWithMinTest extends BaseIntStackWithMinTest {
    @Override
    protected IntStackWithMin create() {
        return new IntArrayStackWithMin();
    }
}