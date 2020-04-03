package io.github.alexengrig.nih.collections;

public class Array<E> {
    protected E[] elements;
    protected int begin;
    protected int end;
    protected int size;

    @SuppressWarnings("unchecked")
    public Array(int length) {
        elements = (E[]) new Object[length];
        begin = 0;
        end = 0;
        size = 0;
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
        return size == 0;
    }

    public boolean isFull() {
        return size == elements.length;
    }

//    Add

    public void add(E value) {
        requireNonFull();
        elements[end] = value;
        end = incrementIndex(end);
        size++;
    }

    public void addAll(E[] values) {
        requireNonFull();
        requireCapacity(values.length);
        for (E value : values) {
            elements[end] = value;
            end = incrementIndex(end);
        }
        size += values.length;
    }

//    Get

    public E get(int index) {
        requireNonEmpty();
        return elements[getIndex(index)];
    }

    public E getFirst() {
        requireNonEmpty();
        return get(getFirstIndex());
    }

    public E getLast() {
        requireNonEmpty();
        return get(getLastIndex());
    }

//    Remove

    public E remove(int index) {
        requireNonEmpty();
        final int targetIndex = getIndex(index);
        final E target = elements[targetIndex];
        if (size < 3 || shiftSize(begin, index) >= shiftSize(index, end - 1)) {
            end = decrementIndex(end);
            shiftLeft(targetIndex, end);
        } else {
            shiftRight(begin, targetIndex);
            begin = incrementIndex(begin);
        }
        size--;
        return target;
    }

    public E removeFirst() {
        requireNonEmpty();
        final E target = elements[begin];
        elements[begin] = null;
        begin = incrementIndex(begin);
        size--;
        return target;
    }

    public E removeLast() {
        requireNonEmpty();
        end = decrementIndex(end);
        final E target = elements[end];
        elements[end] = null;
        size--;
        return target;
    }

//    Index

    private int getIndex(int index) {
        return incrementIndex(begin, index);
    }

    private int getFirstIndex() {
        return begin;
    }

    private int getLastIndex() {
        return isEmpty() ? begin : decrementIndex(end);
    }

    private int incrementIndex(int value) {
        return incrementIndex(value, 1);
    }

    private int incrementIndex(int value, int units) {
        return (value + units) % elements.length;
    }

    private int decrementIndex(int value) {
        return decrementIndex(value, 1);
    }

    private int decrementIndex(int value, int units) {
        return (value - units + elements.length) % elements.length;
    }

//    Shift

    private int shiftSize(int from, int to) {
        return (to + (elements.length - from)) % elements.length;
    }

    private void shiftLeft(int first, int last) {
        for (int i = first; i < last; i++) {
            elements[i] = elements[i + 1];
        }
        elements[last] = null;
    }

    private void shiftRight(int first, int last) {
        for (int i = last; i > first; i--) {
            elements[i] = elements[i - 1];
        }
        elements[first] = null;
    }

//    Require

    private void requireNonEmpty() {
        if (isEmpty()) throw new RuntimeException("Array is empty");
    }

    private void requireNonFull() {
        if (isFull()) throw new RuntimeException("Array is full");
    }

    private void requireCapacity(int length) {
        if (length + size > elements.length) {
            final String msg = String.format("Not enough array length to add %d value(-s)", length);
            throw new RuntimeException(msg);
        }
    }
}
