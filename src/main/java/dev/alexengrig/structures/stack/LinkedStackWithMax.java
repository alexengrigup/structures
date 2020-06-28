package dev.alexengrig.structures.stack;

import dev.alexengrig.structures.annotation.O;

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

    @O("1")
    @Override
    public E max() {
        requireNonEmpty();
        return maxStack.top();
    }

    @O("1")
    @Override
    public void push(E value) {
        super.push(value);
        if (maxStack.empty() || comparator.compare(value, maxStack.top()) >= 0) {
            maxStack.push(value);
        }
    }

    @O("1")
    @Override
    public E pop() {
        E target = super.pop();
        if (target == maxStack.top()) {
            maxStack.pop();
        }
        return target;
    }

    @O("1")
    @Override
    public E top() {
        E value = super.top();
        if (comparator.compare(value, maxStack.top()) > 0) {
            return maxStack.top();
        }
        return value;
    }
}
