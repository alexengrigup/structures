package dev.alexengrig.structures.queue;

public class IntQueueWithMaxViaArrayStackTest extends BaseIntQueueWithMaxTest {
    @Override
    protected IntQueueWithMax create() {
        return new IntQueueWithMaxViaArrayStack();
    }
}