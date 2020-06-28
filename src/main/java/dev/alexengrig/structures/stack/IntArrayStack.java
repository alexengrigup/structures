package dev.alexengrig.structures.stack;

import dev.alexengrig.structures.annotation.O;

public class IntArrayStack implements IntStack {
    protected static final int DEFAULT_CAPACITY = 8;

    protected int size;
    protected int[] array;

    public IntArrayStack() {
        this(DEFAULT_CAPACITY);
    }

    public IntArrayStack(int initialCapacity) {
        size = 0;
        array = new int[initialCapacity];
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
    public void push(int value) {
        if (size >= array.length) grow();
        array[size++] = value;
    }

    @O("1")
    @Override
    public int pop() {
        requireNonEmpty();
        return array[--size];
    }

    @O("1")
    @Override
    public int top() {
        requireNonEmpty();
        return array[size - 1];
    }

    protected void grow() {
        int[] target = new int[array.length * 2];
        System.arraycopy(array, 0, target, 0, array.length);
        array = target;
    }

    protected void requireNonEmpty() {
        if (empty()) throw new EmptyStackException();
    }
}
