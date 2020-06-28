package dev.alexengrig.structures.queue;

import dev.alexengrig.structures.stack.IntStackWithMax;

public abstract class BaseIntQueueWithMaxViaStack
        extends BaseIntQueueViaStack<IntStackWithMax>
        implements IntQueueWithMax {
    @Override
    public int max() {
        requireNonEmpty();
        return frontStack.empty() ? backStack.max() : frontStack.max();
    }
}
