package io.github.alexengrig.nih.collections.util;

public class Sorting {
    private Sorting() {
    }

    public static void insertion(int[] input) {
        for (int right = 1, length = input.length; right < length; ++right) {
            int key = input[right];
            int left = right - 1;
            while (left >= 0 && input[left] > key) {
                input[left + 1] = input[left];
                left--;
            }
            input[left + 1] = key;
        }
    }
}
