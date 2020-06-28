package dev.alexengrig.structures.stack;

import dev.alexengrig.structures.annotation.O;

public class IntArrayStackWithMin extends IntArrayStack implements IntStackWithMin {
    protected Integer min;

    @O("1")
    @Override
    public int min() {
        requireNonEmpty();
        return min;
    }

    @O("1")
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

    @O("1")
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
