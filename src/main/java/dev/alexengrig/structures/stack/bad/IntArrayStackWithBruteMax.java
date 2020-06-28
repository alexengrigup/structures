package dev.alexengrig.structures.stack.bad;

import dev.alexengrig.structures.annotation.Bad;
import dev.alexengrig.structures.annotation.O;
import dev.alexengrig.structures.stack.IntArrayStack;
import dev.alexengrig.structures.stack.IntStackWithMax;

@Bad
public class IntArrayStackWithBruteMax extends IntArrayStack implements IntStackWithMax {
    @O("n")
    @Override
    public int max() {
        requireNonEmpty();
        return findMax();
    }

    protected int findMax() {
        int target = array[0];
        for (int i = 1, l = size; i < l; i++) {
            if (array[i] > target) {
                target = array[i];
            }
        }
        return target;
    }
}
