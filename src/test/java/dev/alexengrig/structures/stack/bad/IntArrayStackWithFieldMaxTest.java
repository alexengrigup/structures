package dev.alexengrig.structures.stack.bad;

public class IntArrayStackWithFieldMaxTest extends IntArrayStackWithBruteMaxTest {
    @Override
    protected IntArrayStackWithFieldMax create() {
        return new IntArrayStackWithFieldMax();
    }
}