package io.github.alexengrig.nih.collections.util;

public class Sorting {
    private Sorting() {
    }

    /**
     * Example:
     * <pre>
     *     input: [3 5 4 1 2]
     *            [3 <u>5</u> 4 1 2]: 3 &lt 5
     *            [3 5 <u>4</u> 1 2]: 5 <b>&gt</b> 4, 3 &lt 4
     *            [3 4 5 <u>1</u> 2]: 5 <b>&gt</b> 1, 4 <b>&gt</b> 1, 3 <b>&gt</b> 1
     *            [1 3 4 5 <u>2</u>]: 5 <b>&gt</b> 2, 4 <b>&gt</b> 2, 3 <b>&gt</b> 2, 1 &lt 2
     *    output: [1 2 3 4 5]
     * </pre>
     *
     * @param input The array to sort
     */
    public static void insertion(int[] input) {
        for (int right = 1, length = input.length; right < length; ++right) {
            int key = input[right];
            int left = right - 1;
            for (; left >= 0 && input[left] > key; left--) {
                input[left + 1] = input[left];
            }
            input[left + 1] = key;
        }
    }

    /**
     * Example:
     * <pre>
     *     input: [3 5 4 1 2]
     *            [<u>3</u> 5 4 1 2]: 3 &lt 5
     *            [3 <u>5</u> 4 1 2]: 5 <b>&gt</b> 4
     *            [3 4 <u>5</u> 1 2]: 5 <b>&gt</b> 1
     *            [3 4 1 <u>5</u> 2]: 5 <b>&gt</b> 2
     *            [3 4 1 2 <u>5</u>]: 5 <b>&gt</b> 2
     *            [<u>3</u> 4 1 2 <b>5</b>]: 3 &lt 4
     *            [3 <u>4</u> 1 2 <b>5</b>]: 4 <b>&gt</b> 1
     *            [3 1 <u>4</u> 2 <b>5</b>]: 4 <b>&gt</b> 2
     *            [<u>3</u> 1 2 <b>4</b> <b>5</b>]: 3 <b>&gt</b> 1
     *            [1 <u>3</u> 2 <b>4</b> <b>5</b>]: 3 <b>&gt</b> 2
     *    output: [1 2 3 4 5]
     * </pre>
     *
     * @param input The array to sort
     */
    public static void bubble(int[] input) {
        for (int major = 0, length = input.length; major < length - 1; major++) {
            boolean swap = false;
            for (int minor = 0; minor < length - major - 1; minor++) {
                if (input[minor] > input[minor + 1]) {
                    int buffer = input[minor];
                    input[minor] = input[minor + 1];
                    input[minor + 1] = buffer;
                    swap = true;
                }
            }
            if (!swap) {
                break;
            }
        }
    }

    public static void selection(int[] input) {
        for (int major = 0, length = input.length; major < length - 1; major++) {
            int min = major;
            for (int minor = major + 1; minor < length; minor++) {
                if (input[min] > input[minor]) {
                    min = minor;
                }
            }
            int buffer = input[major];
            input[major] = input[min];
            input[min] = buffer;
        }
    }
}
