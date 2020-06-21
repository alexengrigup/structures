package dev.alexengrig.structures.stack;

public class IntArrayStackWithMax extends IntArrayStack implements IntStackWithMax {
    protected Integer max;

    @Override
    public int max() {
        requireNonEmpty();
        return max;
    }

    @Override
    public void push(int value) {
        requireCapacity();
        if (empty()) {
            append(value);
            max = value;
        } else if (value > max) {
            append(2 * value - max);
            max = value;
        } else {
            append(value);
        }
    }

    @Override
    public int pop() {
        int value = super.pop();
        if (value > max) {
            int target = max;
            max = 2 * max - value;
            return target;
        }
        return value;
    }
}
