package io.github.alexengrig.nih.collections.util;

public class Sorting {
    private Sorting() {
    }

    public static void swap(int[] input, int from, int to) {
        int buffer = input[from];
        input[from] = input[to];
        input[to] = buffer;
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
        int length = input.length, right, key, left;
        for (right = 1; right < length; ++right) {
            key = input[right];
            left = right - 1;
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
        int length = input.length, major, minor;
        boolean swap;
        for (major = 0; major < length - 1; major++) {
            swap = false;
            for (minor = 0; minor < length - major - 1; minor++) {
                if (input[minor] > input[minor + 1]) {
                    swap(input, minor, minor + 1);
                    swap = true;
                }
            }
            if (!swap) {
                break;
            }
        }
    }

    /**
     * Example:
     * <pre>
     *     input: [3 5 4 1 2] <u>current</u>, <b>sorted</b>, <i>min</i>
     *            [<u>3</u> 5 4 <i>1</i> 2]
     *            [<b>1</b> <u>3</u> 5 4 <i>2</i>]
     *            [<b>1</b> <b>2</b> <u><i>3</i></u> 5 4]
     *            [<b>1</b> <b>2</b> <b>3</b> <u>5</u> <i>4</i>]
     *    output: [1 2 3 4 5]
     * </pre>
     *
     * @param input The array to sort
     */
    public static void selection(int[] input) {
        for (int major = 0, length = input.length; major < length - 1; major++) {
            int min = major;
            for (int minor = major + 1; minor < length; minor++) {
                if (input[min] > input[minor]) {
                    min = minor;
                }
            }
            swap(input, major, min);
        }
    }
}
