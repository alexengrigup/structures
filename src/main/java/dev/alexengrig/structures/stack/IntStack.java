package dev.alexengrig.structures.stack;

public interface IntStack {
    void push(int value);

    int pop();

    int top();

    int size();

    boolean empty();
}
