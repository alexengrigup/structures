package dev.alexengrig.structures.queue;

import dev.alexengrig.structures.annotation.O;
import dev.alexengrig.structures.stack.IntStackWithMax;

public abstract class BaseIntQueueWithMaxViaStack
        extends BaseIntQueueViaStack<IntStackWithMax>
        implements IntQueueWithMax {
    @O("1")
    @Override
    public int max() {
        requireNonEmpty();
        return frontStack.empty() ? backStack.max() : frontStack.max();
    }
}
