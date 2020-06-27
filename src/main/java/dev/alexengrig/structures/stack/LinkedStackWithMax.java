package dev.alexengrig.structures.stack;

import java.util.Comparator;

public class LinkedStackWithMax<E extends Comparable<E>> extends LinkedStack<E> implements StackWithMax<E> {
    protected final Comparator<E> comparator;
    protected final LinkedStack<E> maxStack;

    public LinkedStackWithMax() {
        this(Comparator.naturalOrder());
    }

    public LinkedStackWithMax(Comparator<E> comparator) {
        this.comparator = comparator;
        this.maxStack = createMaxStack();
    }

    protected LinkedStack<E> createMaxStack() {
        return new LinkedStack<>();
    }

    @Override
    public E max() {
        requireNonEmpty();
        return maxStack.top();
    }

    @Override
    public void push(E value) {
        super.push(value);
        if (maxStack.empty() || comparator.compare(value, maxStack.top()) >= 0) {
            maxStack.push(value);
        }
    }

    @Override
    public E pop() {
        E target = super.pop();
        if (target == maxStack.top()) {
            maxStack.pop();
        }
        return target;
    }
}
