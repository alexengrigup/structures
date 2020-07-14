package dev.alexengrig.structures.heap;

public interface IntHeap {
    Index insert(int value);

    int extract(Index index);

    int size();

    boolean empty();

    interface Index {
    }
}
