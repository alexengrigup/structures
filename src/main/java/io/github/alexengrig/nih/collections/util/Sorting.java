package io.github.alexengrig.nih.collections.util;

public class Sorting {
    private Sorting() {
    }

    public static void insertion(int[] input) {
        for (int forth = 1, length = input.length; forth < length; ++forth) {
            int key = input[forth];
            int back = forth - 1;
            while (back >= 0 && input[back] > key) {
                input[back + 1] = input[back];
                back--;
            }
            input[back + 1] = key;
        }
    }
}
