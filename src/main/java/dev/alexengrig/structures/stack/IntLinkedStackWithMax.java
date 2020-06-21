package dev.alexengrig.structures.stack;

public class IntLinkedStackWithMax extends IntLinkedStack implements IntStackWithMax {
    protected Integer max;

    @Override
    public int max() {
        requireNonEmpty();
        return max;
    }

    @Override
    public void push(int value) {
        if (empty()) {
            super.push(value);
            max = value;
        } else if (value > max) {
            super.push(2 * value - max);
            max = value;
        } else {
            super.push(value);
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
