package dev.alexengrig.structures.queue;

import dev.alexengrig.structures.annotation.O;
import dev.alexengrig.structures.stack.IntStack;

public abstract class BaseIntQueueViaStack<S extends IntStack> implements IntQueue {
    protected final S frontStack;
    protected final S backStack;

    protected BaseIntQueueViaStack() {
        this.frontStack = createStack();
        this.backStack = createStack();
    }

    protected abstract S createStack();

    @O("1")
    @Override
    public int size() {
        return frontStack.size() + backStack.size();
    }


    @O("1")
    @Override
    public boolean empty() {
        return size() == 0;
    }


    @O("1")
    @Override
    public void enqueue(int value) {
        backStack.push(value);
    }


    @O({"1", "n"})
    @Override
    public int dequeue() {
        requireNonEmpty();
        requireTransferToFront();
        return frontStack.pop();
    }

    @O({"1", "n"})
    @Override
    public int front() {
        requireNonEmpty();
        requireTransferToFront();
        return frontStack.top();
    }

    @O({"1", "n"})
    @Override
    public int back() {
        requireNonEmpty();
        requireTransferToBack();
        return backStack.top();
    }

    protected void requireNonEmpty() {
        if (empty()) throw new EmptyQueueException();
    }

    protected void requireTransferToFront() {
        if (frontStack.empty()) transfer(backStack, frontStack);
    }

    protected void requireTransferToBack() {
        if (backStack.empty()) transfer(frontStack, backStack);
    }

    protected void transfer(S from, S to) {
        while (!from.empty()) {
            to.push(from.pop());
        }
    }
}
