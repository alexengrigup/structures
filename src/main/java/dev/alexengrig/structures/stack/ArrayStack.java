package dev.alexengrig.structures.stack;

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

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean empty() {
        return size == 0;
    }

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

    @Override
    public E pop() {
        requireNonEmpty();
        return array(--size);
    }

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
}
