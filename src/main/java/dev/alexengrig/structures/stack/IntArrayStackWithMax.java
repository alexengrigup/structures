package dev.alexengrig.structures.stack;

import dev.alexengrig.structures.annotation.O;

public class IntArrayStackWithMax extends IntArrayStack implements IntStackWithMax {
    protected Integer max;

    @O("1")
    @Override
    public int max() {
        requireNonEmpty();
        return max;
    }

    @O("1")
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

    @O("1")
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

    @O("1")
    @Override
    public int top() {
        int value = super.top();
        if (value > max) {
            return max;
        }
        return value;
    }
}
