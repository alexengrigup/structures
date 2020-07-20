package dev.alexengrig.structures.queue;

import dev.alexengrig.structures.annotation.O;
import dev.alexengrig.structures.stack.IntStackWithMin;

public abstract class BaseIntQueueWithMinViaStack
        extends BaseIntQueueViaStack<IntStackWithMin>
        implements IntQueueWithMin {
    @O("1")
    @Override
    public int min() {
        requireNonEmpty();
        if (frontStack.empty()) {
            return backStack.min();
        } else if (backStack.empty()) {
            return frontStack.min();
        }
        return Math.min(frontStack.min(), backStack.min());
    }
}
