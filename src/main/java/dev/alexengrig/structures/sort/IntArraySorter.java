package dev.alexengrig.structures.sort;

public interface IntArraySorter {
    static void swap(int[] array, int from, int to) {
        if (from != to) {
            int temp = array[from];
            array[from] = array[to];
            array[to] = temp;
        }
    }

    void sort(int[] array, int low, int high);

    default void sort(int[] array) {
        sort(array, 0, array.length);
    }
}
