package dev.alexengrig.structures.stack.bad;

import dev.alexengrig.structures.stack.BaseIntStackWithMaxTest;

public class IntBruteLinkedStackWithMaxTest extends BaseIntStackWithMaxTest {
    @Override
    protected IntBruteLinkedStackWithMax create() {
        return new IntBruteLinkedStackWithMax();
    }
}