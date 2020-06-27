package dev.alexengrig.structures.stack;

public interface StackWithMax<E extends Comparable<E>> extends Stack<E> {
    E max();
}
