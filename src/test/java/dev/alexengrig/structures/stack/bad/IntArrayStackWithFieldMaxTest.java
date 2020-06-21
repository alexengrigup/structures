package dev.alexengrig.structures.stack.bad;

import dev.alexengrig.structures.stack.BaseIntStackWithMaxTest;

public class IntArrayStackWithFieldMaxTest extends BaseIntStackWithMaxTest {
    @Override
    protected IntArrayStackWithFieldMax create() {
        return new IntArrayStackWithFieldMax();
    }
}