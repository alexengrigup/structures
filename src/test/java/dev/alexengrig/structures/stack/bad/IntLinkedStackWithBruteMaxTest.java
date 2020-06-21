package dev.alexengrig.structures.stack.bad;

import dev.alexengrig.structures.stack.BaseIntStackWithMaxTest;

public class IntLinkedStackWithBruteMaxTest extends BaseIntStackWithMaxTest {
    @Override
    protected IntLinkedStackWithBruteMax create() {
        return new IntLinkedStackWithBruteMax();
    }
}