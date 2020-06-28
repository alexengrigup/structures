package dev.alexengrig.structures.queue;

import dev.alexengrig.structures.stack.IntArrayStackWithMax;
import dev.alexengrig.structures.stack.IntStackWithMax;

public class IntQueueWithMaxViaArrayStack extends BaseIntQueueWithMaxViaStack {
    @Override
    protected IntStackWithMax createStack() {
        return new IntArrayStackWithMax();
    }
}
