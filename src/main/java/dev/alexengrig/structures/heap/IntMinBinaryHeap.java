package dev.alexengrig.structures.heap;

import dev.alexengrig.structures.annotation.O;

import java.util.Arrays;
import java.util.Objects;

public class IntMinBinaryHeap implements IntMinHeap {
    protected static final int DEFAULT_CAPACITY = 15;

    protected int size;
    protected Node[] array;

    public IntMinBinaryHeap() {
        this.size = 0;
        this.array = new Node[DEFAULT_CAPACITY];
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

    @O("log(n)")
    @Override
    public Pointer insert(int value) {
        if (size >= array.length) grow();
        int index = size++;
        Node node = new Node(value, index);
        array[index] = node;
        siftUp(index);
        return node.pointer;
    }

    protected void grow() {
        array = Arrays.copyOf(array, array.length * 2 + 1);
    }

    @O("log(n)")
    @Override
    public int extract(Index index) {
        Objects.requireNonNull(index, "The index must not be null");
        requireNonEmpty();
        requireValidIndex(index);
        int target = value(index);
        update(index, value(0) - 1);
        extractFirst();
        return target;
    }

    @O("1")
    @Override
    public int min() {
        requireNonEmpty();
        return value(0);
    }

    @O("log(n)")
    @Override
    public int extractMin() {
        requireNonEmpty();
        return extractFirst();
    }

    @O("log(n)")
    @Override
    public int decrease(Index index, int newValue) {
        Objects.requireNonNull(index, "The index must not be null");
        requireNonEmpty();
        requireValidIndex(index);
        return update(index, newValue);
    }

    protected void requireNonEmpty() {
        if (empty()) throw new EmptyHeapException();
    }

    protected void requireValidIndex(Index index) {
        if (!index.valid() || !(index instanceof Pointer)) throw new InvalidHeapIndexException();
    }

    protected void swap(int from, int to) {
        Node temp = array[from];
        array[from] = array[to];
        array[from].setIndex(from);
        array[to] = temp;
        array[to].setIndex(to);
    }

    protected void siftUp(int index) {
        int child = index;
        int parent = parent(child);
        while (child > 0 && value(child) <= value(parent)) {
            swap(child, parent);
            child = parent;
            parent = parent(child);
        }
    }

    @SuppressWarnings("SameParameterValue")
    protected void siftDown(int index) {
        int parent = index;
        int left = left(parent);
        int right = right(parent);
        while ((left < size && value(left) < value(parent)) || (right < size && value(right) < value(parent))) {
            if (right < size && value(right) <= value(left)) {
                swap(parent, right);
                parent = right;
            } else {
                swap(parent, left);
                parent = left;
            }
            left = left(parent);
            right = right(parent);
        }
    }

    protected int update(Index index, int newValue) {
        Node node = node(index);
        int target = node.value;
        if (newValue >= target) {
            throw new IllegalArgumentException(
                    String.format("The new value must be less than the current value: %d >= %d", newValue, target));
        }
        node.value = newValue;
        siftUp(node.pointer.index);
        return target;
    }

    protected int extractFirst() {
        Node node = node(0);
        node.pointer.removed = true;
        swap(0, --size);
        siftDown(0);
        return node.value;
    }

    protected int parent(int index) {
        return (index - 1) / 2;
    }

    protected int left(int index) {
        return index * 2 + 1;
    }

    protected int right(int index) {
        return index * 2 + 2;
    }

    protected int value(int index) {
        return array[index].value;
    }

    protected int value(Index index) {
        return value(index.get());
    }

    protected Node node(int index) {
        return array[index];
    }

    protected Node node(Index index) {
        return node(index.get());
    }

    protected class Node {
        protected int value;
        protected Pointer pointer;

        protected Node(int value, int index) {
            this.value = value;
            this.pointer = new Pointer(index);
        }

        protected void setIndex(int index) {
            this.pointer.index = index;
        }

        @Override
        public String toString() {
            return String.format("Node(%d: %d%s)", pointer.index, value, pointer.removed ? " - REMOVED" : "");
        }
    }

    public class Pointer implements Index {
        protected int index;
        protected boolean removed;

        public Pointer(int index) {
            this.index = index;
        }

        @Override
        public int get() {
            return index;
        }

        @Override
        public boolean valid() {
            return !removed && index >= 0 && index < size;
        }
    }
}
