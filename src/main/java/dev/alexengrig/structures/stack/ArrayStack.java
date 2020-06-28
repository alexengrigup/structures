package dev.alexengrig.structures.stack;

import dev.alexengrig.structures.annotation.O;

public class ArrayStack<E> implements Stack<E> {
    protected static final int DEFAULT_CAPACITY = 8;

    protected int size;
    protected Object[] array;

    public ArrayStack() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayStack(int initialCapacity) {
        size = 0;
        array = new Object[initialCapacity];
    }

    @O("1")
    @Override
    public int size() {
        return size;
    }

    @O("1")
    @Override
    public boolean empty() {
        return size == 0;
    }

    @O("1")
    @Override
    public void push(E value) {
        if (size >= array.length) grow();
        array[size++] = value;
    }

    protected void grow() {
        Object[] target = new Object[array.length * 2];
        System.arraycopy(array, 0, target, 0, array.length);
        array = target;
    }

    @O("1")
    @Override
    public E pop() {
        requireNonEmpty();
        E target = array(--size);
        nullify(size);
        return target;
    }

    @O("1")
    @Override
    public E top() {
        requireNonEmpty();
        return array(size - 1);
    }

    protected void requireNonEmpty() {
        if (empty()) throw new EmptyStackException();
    }

    @SuppressWarnings("unchecked")
    protected E array(int index) {
        return (E) array[index];
    }

    protected void nullify(int index) {
        array[index] = null;
    }
}
