package dev.alexengrig.structures.queue;

import dev.alexengrig.structures.stack.IntStack;

public abstract class BaseIntQueueViaStack implements IntQueue {
    protected final IntStack frontStack;
    protected final IntStack backStack;

    protected BaseIntQueueViaStack() {
        this.frontStack = createStack();
        this.backStack = createStack();
    }

    protected abstract IntStack createStack();

    @Override
    public int size() {
        return frontStack.size() + backStack.size();
    }

    @Override
    public boolean empty() {
        return size() == 0;
    }

    @Override
    public void enqueue(int value) {
        backStack.push(value);
    }

    @Override
    public int dequeue() {
        requireNonEmpty();
        requireTransferToFront();
        return frontStack.pop();
    }

    @Override
    public int front() {
        requireNonEmpty();
        requireTransferToFront();
        return frontStack.top();
    }

    @Override
    public int back() {
        requireNonEmpty();
        requireTransferToBack();
        return backStack.top();
    }

    private void requireNonEmpty() {
        if (empty()) throw new EmptyQueueException();
    }

    protected void requireTransferToFront() {
        if (frontStack.empty()) transfer(backStack, frontStack);
    }

    protected void requireTransferToBack() {
        if (backStack.empty()) transfer(frontStack, backStack);
    }

    protected void transfer(IntStack from, IntStack to) {
        while (!from.empty()) {
            to.push(from.pop());
        }
    }
}
