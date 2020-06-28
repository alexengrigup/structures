package dev.alexengrig.structures.queue;

public class IntQueueViaArrayStackTest extends BaseIntQueueTest {
    @Override
    protected IntQueue create() {
        return new IntQueueViaArrayStack();
    }
}