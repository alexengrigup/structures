package dev.alexengrig.structures.stack;

import dev.alexengrig.structures.annotation.O;

public class IntLinkedStack implements IntStack {
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
    public void push(int value) {
        ++size;
        top = new Node(value, top);
    }

    @O("1")
    @Override
    public int pop() {
        requireNonEmpty();
        --size;
        int target = top.value;
        top = top.next;
        return target;
    }

    @O("1")
    @Override
    public int top() {
        requireNonEmpty();
        return top.value;
    }

    protected void requireNonEmpty() {
        if (empty()) throw new EmptyStackException();
    }

    protected static class Node {
        public int value;
        public Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}
