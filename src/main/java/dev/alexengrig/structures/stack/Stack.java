package dev.alexengrig.structures.stack;

public interface Stack<E> {
    void push(E value);

    E pop();

    E top();

    int size();

    boolean empty();
}
