package io.github.alexengrig.nih.collections;

public class YaArray<E> {
    protected static final Object NULL = new Object();
    protected int begin;
    protected int end;
    protected E[] elements;

    @SuppressWarnings("unchecked")
    public YaArray(int length) {
        begin = 0;
        end = 0;
        elements = (E[]) new Object[length];
        nullify(0);
    }

    public YaArray(E[] values) {
        this(values.length);
        addAll(values);
    }

    @SafeVarargs
    public YaArray(E value, E... values) {
        this(1 + values.length);
        add(value);
        addAll(values);
    }

    public int length() {
        return elements.length;
    }

    public int size() {
        if (begin != end) {
            return Math.abs(end - begin);
        } else {
            return isEmpty() ? 0 : length();
        }
    }

    public boolean isEmpty() {
        return begin == 0 && end == 0 || begin == end && elements[end] == NULL;
    }

    public boolean isFull() {
        return begin == 0 && end == length() || begin != 0 && begin == end && elements[end] != NULL;
    }

    public void add(E value) {
        if (isFull()) {
            throw new RuntimeException("Array is full");
        }
        elements[end++] = value;
        if (begin != 0 && begin == end) nullify(end);
    }

    public void addAll(E[] values) {
        if (isFull()) {
            throw new RuntimeException("Array is full");
        } else if (size() + values.length > length()) {
            throw new RuntimeException("Not enough array length to add");
        }
        for (E value : values) {
            elements[end++] = value;
        }
        if (begin != 0 && begin == end) nullify(end);
    }

    @SuppressWarnings("unchecked")
    protected void nullify(int index) {
        elements[index] = (E) NULL;
    }
}
