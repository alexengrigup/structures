package io.github.alexengrig.nih.collections.util;

public class Sorting {
    private Sorting() {
    }

    public static int[] insertion(int[] input) {
        int length = input.length;
        if (length == 0) {
            return new int[]{};
        } else if (length == 1) {
            return new int[]{input[0]};
        } else if (length == 2) {
            int first = input[0];
            int second = input[1];
            return first < second
                    ? new int[]{first, second}
                    : new int[]{second, first};
        } else {
            int[] output = new int[length];
            output[0] = input[0];
            for (int i = 1; i < length; i++) {
                if (input[i] < output[i - 1]) {
                    output[i] = output[i - 1];
                    output[i - 1] = input[i];
                } else {
                    output[i] = input[i];
                }
            }
            return output;
        }
    }
}
