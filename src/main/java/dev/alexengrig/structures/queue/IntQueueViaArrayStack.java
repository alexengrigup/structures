package dev.alexengrig.structures.queue;

import dev.alexengrig.structures.stack.IntArrayStack;
import dev.alexengrig.structures.stack.IntStack;

public class IntQueueViaArrayStack extends BaseIntQueueViaStack<IntStack> {
    @Override
    protected IntStack createStack() {
        return new IntArrayStack();
    }
}
