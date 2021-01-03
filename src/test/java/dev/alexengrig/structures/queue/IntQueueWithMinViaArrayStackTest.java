package dev.alexengrig.structures.queue;

public class IntQueueWithMinViaArrayStackTest extends BaseIntQueueWithMinTest {
    @Override
    protected IntQueueWithMin create() {
        return new IntQueueWithMinViaArrayStack();
    }
}