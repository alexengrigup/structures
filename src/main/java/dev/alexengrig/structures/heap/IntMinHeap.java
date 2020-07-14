package dev.alexengrig.structures.heap;

public interface IntMinHeap extends IntHeap {
    int min();

    int extractMin();

    int decrease(Index index, int value);
}
