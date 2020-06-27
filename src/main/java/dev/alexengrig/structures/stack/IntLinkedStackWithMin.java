package dev.alexengrig.structures.stack;

public class IntLinkedStackWithMin extends IntLinkedStack implements IntStackWithMin {
    protected Integer min;

    @Override
    public int min() {
        requireNonEmpty();
        return min;
    }

    @Override
    public void push(int value) {
        if (empty()) {
            super.push(value);
            min = value;
        } else if (value < min) {
            super.push(2 * value - min);
            min = value;
        } else {
            super.push(value);
        }
    }

    @Override
    public int pop() {
        int value = super.pop();
        if (value < min) {
            int target = min;
            min = 2 * min - value;
            return target;
        }
        return value;
    }
}
