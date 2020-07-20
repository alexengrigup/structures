package dev.alexengrig.structures.queue;

import dev.alexengrig.structures.stack.IntArrayStackWithMin;
import dev.alexengrig.structures.stack.IntStackWithMin;

public class IntQueueWithMinViaArrayStack extends BaseIntQueueWithMinViaStack {
    @Override
    protected IntStackWithMin createStack() {
        return new IntArrayStackWithMin();
    }
}
