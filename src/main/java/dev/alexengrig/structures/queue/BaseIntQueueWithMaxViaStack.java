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
        if (frontStack.empty()) {
            return backStack.max();
        } else if (backStack.empty()) {
            return frontStack.max();
        }
        return Math.max(frontStack.max(), backStack.max());
    }
}
