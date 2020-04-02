package io.github.alexengrig.nih.collections;

public class Array<E> {
    protected int begin;
    protected int end;
    protected int size;
    protected E[] elements;

    @SuppressWarnings("unchecked")
    public Array(int length) {
        begin = 0;
        end = 0;
        size = 0;
        elements = (E[]) new Object[length];
    }

    public Array(E[] values) {
        this(values.length);
        addAll(values);
    }

    @SafeVarargs
    public Array(E value, E... values) {
        this(1 + values.length);
        add(value);
        if (values.length > 0) addAll(values);
    }

    public int size() {
        return size;
    }

    public int length() {
        return elements.length;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean isFull() {
        return size() == length();
    }

    public void add(E value) {
        requireNonFull();
        size++;
        elements[end++] = value;
        if (end >= length()) end = 0;
    }

    public void addAll(E[] values) {
        requireNonFull();
        if (size() + values.length > length()) throw new RuntimeException("Not enough array length to add");
        size += values.length;
        for (E value : values) {
            elements[end++] = value;
            if (end >= length()) end = 0;
        }
    }

    public E get(int index) {
        final int targetIndex = getIndex(index);
        return elements[targetIndex];
    }

    public E remove(int index) {
        requireNonEmpty();
        final int targetIndex = getIndex(index);
        final E target = elements[targetIndex];
        for (int i = targetIndex, last = --end; i < last; i++) {
            elements[i] = elements[i + 1];
        }
        if (end < 0) end = 0;
        elements[end] = null;
        size--;
        return target;
    }

    private int getIndex(int index) {
        return (begin + index) % length();
    }

    public E removeFirst() {
        requireNonEmpty();
        final E target = elements[begin];
        elements[begin++] = null;
        if (begin >= length()) begin = 0;
        size--;
        return target;
    }

    public E removeLast() {
        requireNonEmpty();
        if (--end < 0) end = length() - 1;
        final E target = elements[end];
        elements[end] = null;
        size--;
        return target;
    }

    private void requireNonEmpty() {
        if (isEmpty()) throw new RuntimeException("Array is empty");
    }

    private void requireNonFull() {
        if (isFull()) throw new RuntimeException("Array is full");
    }
}
