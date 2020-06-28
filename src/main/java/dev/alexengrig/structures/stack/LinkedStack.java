package dev.alexengrig.structures.stack;

import dev.alexengrig.structures.annotation.O;

public class LinkedStack<E> implements Stack<E> {
    protected int size;
    protected Node top;

    @O("1")
    @Override
    public int size() {
        return size;
    }

    @O("1")
    @Override
    public boolean empty() {
        return null == top;
    }

    @O("1")
    @Override
    public void push(E value) {
        ++size;
        top = new Node(value, top);
    }

    @O("1")
    @Override
    public E pop() {
        requireNonEmpty();
        --size;
        E target = top.value;
        top = top.next;
        return target;
    }

    @O("1")
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
