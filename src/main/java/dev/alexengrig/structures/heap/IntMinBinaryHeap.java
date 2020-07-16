package dev.alexengrig.structures.heap;

import java.util.Arrays;

public class IntMinBinaryHeap implements IntMinHeap {
    protected static final int DEFAULT_CAPACITY = 15;

    protected int size;
    protected Node[] array;

    public IntMinBinaryHeap() {
        this.size = 0;
        this.array = new Node[DEFAULT_CAPACITY];
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

    @Override
    public int extract(Index index) {
        requireValidIndex(index);
        decrease(index, value(0) - 1);
        return extractMin();
    }

    @Override
    public int min() {
        requireNonEmpty();
        return value(0);
    }

    @Override
    public int extractMin() {
        requireNonEmpty();
        Node node = node(0);
        node.pointer.removed = true;
        swap(0, --size);
        siftDown(0);
        return node.value;
    }

    @Override
    public int decrease(Index index, int newValue) {
        requireValidIndex(index);
        Node node = node(index.get());
        if (newValue >= node.value) {
            throw new IllegalArgumentException(
                    String.format("The new value must be less than the current value: %d >= %d",
                            newValue, node.value));
        }
        int target = node.value;
        node.value = newValue;
        siftUp(node.pointer.index);
        return target;
    }

    protected void requireNonEmpty() {
        if (empty()) throw new EmptyHeapException();
    }

    protected void requireValidIndex(Index index) {
        if (!index.valid()) throw new InvalidHeapIndexException();
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

    protected void siftDown(int index) {
        int parent = index;
        int rightChild = rightChild(parent);
        int leftChild = leftChild(parent);
        while (parent < size && (value(parent) >= value(rightChild) || value(parent) >= value(leftChild))) {
            if (value(parent) > value(rightChild)) {
                swap(parent, rightChild);
                parent = rightChild;
            } else {
                swap(parent, leftChild);
                parent = leftChild;
            }
            rightChild = rightChild(parent);
            leftChild = leftChild(parent);
        }
    }

    protected void swap(int from, int to) {
        Node temp = array[from];
        array[from] = array[to];
        array[from].setIndex(from);
        array[to] = temp;
        array[to].setIndex(to);
    }

    protected int value(int index) {
        return array[index].value;
    }

    protected int parent(int index) {
        return (index - 1) / 2;
    }

    protected int leftChild(int index) {
        return index * 2 + 1;
    }

    protected int rightChild(int index) {
        return index * 2 + 2;
    }

    protected Node node(int index) {
        return array[index];
    }

    protected class Node {
        public int value;
        public Pointer pointer;

        public Node(int value, int index) {
            this.value = value;
            this.pointer = new Pointer(index);
        }

        public void setIndex(int index) {
            this.pointer.index = index;
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
