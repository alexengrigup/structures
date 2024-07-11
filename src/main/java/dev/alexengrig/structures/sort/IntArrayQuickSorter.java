package dev.alexengrig.structures.sort;

import java.util.Random;

import static dev.alexengrig.structures.sort.IntArraySorter.swap;

public abstract class IntArrayQuickSorter implements IntArraySorter {
    @Override
    public final void sort(int[] array, int low, int high) {
        if (low >= high) {
            throw new IllegalArgumentException("Invalid low and high: [" + low + ", " + high + ")");
        }
        quickSort(array, low, high - 1);
    }

    private void quickSort(int[] array, int begin, int end) {
        if (begin < end) {
            int partition = partition(array, begin, end);
            quickSort(array, begin, partition - 1);
            quickSort(array, partition + 1, end);
        }
    }

    private int partition(int[] array, int begin, int end) {
        int pivotIndex = getPivotIndex(array, begin, end);
        swap(array, pivotIndex, end);
        int pivot = array[end];
        int left = begin;
        for (int right = begin; right < end; right++) {
            if (array[right] < pivot) {
                swap(array, left, right);
                left++;
            }
        }
        swap(array, left, end);
        return left;
    }

    protected abstract int getPivotIndex(int[] array, int begin, int end);

    public static class FirstPivot extends IntArrayQuickSorter {
        @Override
        protected int getPivotIndex(int[] array, int begin, int end) {
            return begin;
        }
    }

    public static class LastPivot extends IntArrayQuickSorter {
        @Override
        protected int getPivotIndex(int[] array, int begin, int end) {
            return end;
        }
    }

    public static class RandomPivot extends IntArrayQuickSorter {
        private final Random random = new Random();

        @Override
        protected int getPivotIndex(int[] array, int begin, int end) {
            return random.nextInt(end - begin + 1) + begin;
        }
    }
}
