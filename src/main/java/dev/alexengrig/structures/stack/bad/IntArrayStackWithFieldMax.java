package dev.alexengrig.structures.stack.bad;

import dev.alexengrig.structures.annotation.Bad;
import dev.alexengrig.structures.annotation.O;
import dev.alexengrig.structures.stack.IntStackWithMax;

@Bad
public class IntArrayStackWithFieldMax extends IntArrayStackWithBruteMax implements IntStackWithMax {
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
        super.push(value);
        if (null == max || value > max) {
            max = value;
        }
    }

    @O("n")
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
