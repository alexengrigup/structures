package dev.alexengrig.structure;

import java.util.Collection;
import java.util.stream.Collectors;

public abstract class AbstractCollection<E> implements Collection<E> {
    @Override
    public int size() {
        return (int) parallelStream().count();
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean contains(Object o) {
        return parallelStream().anyMatch(e -> e.equals(o));
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return c.parallelStream().allMatch(this::contains);
    }

    @Override
    public Object[] toArray() {
        return parallelStream().toArray();
    }

    @Override
    public String toString() {
        return stream()
                .map(e -> e == this ? "(this collection)" : String.valueOf(e))
                .collect(Collectors.joining(", ", "[", "]"));
    }
}
