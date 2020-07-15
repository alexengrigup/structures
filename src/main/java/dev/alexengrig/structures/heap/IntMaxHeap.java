package dev.alexengrig.structures.heap;

public interface IntMaxHeap extends IntHeap {
    int max();

    int extractMax();

    int increase(Index index, int value);
}
