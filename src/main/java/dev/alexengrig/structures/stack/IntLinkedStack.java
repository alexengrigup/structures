package dev.alexengrig.structures.stack;

public class IntLinkedStack implements IntStack {
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
    public void push(int value) {
        ++size;
        top = new Node(value, top);
    }

    @Override
    public int pop() {
        if (empty()) throw new EmptyStackException();
        --size;
        int target = top.value;
        top = top.next;
        return target;
    }

    @Override
    public int top() {
        if (empty()) throw new EmptyStackException();
        return top.value;
    }

    protected static class Node {
        int value;
        Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}
