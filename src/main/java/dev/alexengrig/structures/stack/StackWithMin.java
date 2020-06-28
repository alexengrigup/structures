package dev.alexengrig.structures.stack;

public interface StackWithMin<E extends Comparable<E>> extends Stack<E> {
    E min();
}
