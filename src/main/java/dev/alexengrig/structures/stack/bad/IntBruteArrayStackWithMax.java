package dev.alexengrig.structures.stack.bad;


import dev.alexengrig.structures.annotation.Bad;
import dev.alexengrig.structures.stack.IntArrayStack;
import dev.alexengrig.structures.stack.IntStackWithMax;

@Bad
public class IntBruteArrayStackWithMax extends IntArrayStack implements IntStackWithMax {
    @Override
    public int max() {
        requireNonEmpty();
        int target = array[0];
        for (int i = 1, l = array.length; i < l; i++) {
            if (array[i] > target) {
                target = array[i];
            }
        }
        return target;
    }
}
