package dev.alexengrig.structures.stack;

import dev.alexengrig.structures.annotation.O;

import java.util.Comparator;

public class ArrayStackWithMin<E extends Comparable<E>> extends ArrayStack<E> implements StackWithMin<E> {
    protected final Comparator<E> comparator;
    protected final ArrayStack<E> minStack;

    public ArrayStackWithMin() {
        this(Comparator.naturalOrder());
    }

    public ArrayStackWithMin(Comparator<E> comparator) {
        this.comparator = comparator;
        this.minStack = createMinStack();
    }

    protected ArrayStack<E> createMinStack() {
        return new ArrayStack<>();
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
        if (target.equals(minStack.top())) {
            minStack.pop();
        }
        return target;
    }
}
