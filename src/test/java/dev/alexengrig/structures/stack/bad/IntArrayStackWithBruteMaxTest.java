package dev.alexengrig.structures.stack.bad;

import dev.alexengrig.structures.stack.BaseIntStackWithMaxTest;

public class IntArrayStackWithBruteMaxTest extends BaseIntStackWithMaxTest {
    @Override
    protected IntArrayStackWithBruteMax create() {
        return new IntArrayStackWithBruteMax();
    }
}