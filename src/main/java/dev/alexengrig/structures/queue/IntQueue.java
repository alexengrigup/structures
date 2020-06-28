package dev.alexengrig.structures.queue;

public interface IntQueue {
    void enqueue(int value);

    int dequeue();

    int front();

    int back();

    int size();

    boolean empty();
}
