package dev.alexengrig.structures.stack.bad;

import dev.alexengrig.structures.annotation.Bad;
import dev.alexengrig.structures.stack.IntStackWithMax;

@Bad
public class IntLinkedStackWithFieldMax extends IntLinkedStackWithBruteMax implements IntStackWithMax {
    protected Integer max;

    @Override
    public int max() {
        requireNonEmpty();
        return max;
    }

    @Override
    public void push(int value) {
        super.push(value);
        if (null == max || value > max) {
            max = value;
        }
    }

    @Override
    public int pop() {
        int target = super.pop();
        if (empty()) {
            max = null;
        } else if (target == max) {
            max = findMax();
        }
        return target;
    }
}
