package dev.alexengrig.structures.stack;

public class LinkedStack<E> implements Stack<E> {
    protected int size;
    protected Node top;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean empty() {
        return null == top;
    }

    @Override
    public void push(E value) {
        ++size;
        top = new Node(value, top);
    }

    @Override
    public E pop() {
        requireNonEmpty();
        --size;
        E target = top.value;
        top = top.next;
        return target;
    }

    @Override
    public E top() {
        requireNonEmpty();
        return top.value;
    }

    protected void requireNonEmpty() {
        if (empty()) throw new EmptyStackException();
    }

    protected class Node {
        public E value;
        public Node next;

        public Node(E value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}
