package dev.alexengrig.structures.stack;

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

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean empty() {
        return size == 0;
    }

    @Override
    public void push(int value) {
        if (size >= array.length) grow();
        array[size++] = value;
    }

    @Override
    public int pop() {
        requireNonEmpty();
        return array[--size];
    }

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
