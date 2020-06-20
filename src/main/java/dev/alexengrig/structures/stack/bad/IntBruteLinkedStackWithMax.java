package dev.alexengrig.structures.stack.bad;

import dev.alexengrig.structures.annotation.Bad;
import dev.alexengrig.structures.stack.IntLinkedStack;
import dev.alexengrig.structures.stack.IntStackWithMax;

@Bad
public class IntBruteLinkedStackWithMax extends IntLinkedStack implements IntStackWithMax {
    @Override
    public int max() {
        requireNonEmpty();
        int target = top.value;
        Node node = top;
        while (null != (node = node.next)) {
            if (node.value > target) {
                target = node.value;
            }
        }
        return target;
    }
}
