package dev.alexengrig.structures.stack.bad;

import dev.alexengrig.structures.stack.BaseIntStackWithMaxTest;

public class IntLinkedStackWithStackMaxTest extends BaseIntStackWithMaxTest {
    @Override
    protected IntLinkedStackWithStackMax create() {
        return new IntLinkedStackWithStackMax();
    }
}