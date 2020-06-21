package dev.alexengrig.structures.stack.bad;


import dev.alexengrig.structures.stack.BaseIntStackWithMaxTest;

public class IntArrayStackWithStackMaxTest extends BaseIntStackWithMaxTest {
    @Override
    protected IntArrayStackWithStackMax create() {
        return new IntArrayStackWithStackMax();
    }
}