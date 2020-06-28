package dev.alexengrig.structures.stack;

import dev.alexengrig.structures.annotation.O;

import java.util.Comparator;

public class LinkedStackWithMin<E extends Comparable<E>> extends LinkedStack<E> implements StackWithMin<E> {
    protected final Comparator<E> comparator;
    protected final LinkedStack<E> minStack;

    public LinkedStackWithMin() {
        this(Comparator.naturalOrder());
    }

    public LinkedStackWithMin(Comparator<E> comparator) {
        this.comparator = comparator;
        this.minStack = createMinStack();
    }

    protected LinkedStack<E> createMinStack() {
        return new LinkedStack<>();
    }

    @O("1")
    @Override
    public E min() {
        requireNonEmpty();
        return minStack.top();
    }

    @O("1")
    @Override
    public void push(E value) {
        super.push(value);
        if (minStack.empty() || comparator.compare(value, minStack.top()) <= 0) {
            minStack.push(value);
        }
    }

    @O("1")
    @Override
    public E pop() {
        E target = super.pop();
        if (target == minStack.top()) {
            minStack.pop();
        }
        return target;
    }
}
