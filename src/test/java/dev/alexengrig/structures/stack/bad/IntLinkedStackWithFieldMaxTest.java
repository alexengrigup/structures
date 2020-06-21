package dev.alexengrig.structures.stack.bad;

import dev.alexengrig.structures.stack.BaseIntStackWithMaxTest;

public class IntLinkedStackWithFieldMaxTest extends BaseIntStackWithMaxTest {
    @Override
    protected IntLinkedStackWithFieldMax create() {
        return new IntLinkedStackWithFieldMax();
    }
}