package dev.alexengrig.structures.stack.bad;

import dev.alexengrig.structures.annotation.Bad;
import dev.alexengrig.structures.stack.IntLinkedStack;
import dev.alexengrig.structures.stack.IntStackWithMax;

@Bad
public class IntLinkedStackWithStackMax extends IntLinkedStack implements IntStackWithMax {
    protected IntLinkedStack maxStack = new IntLinkedStack();

    @Override
    public int max() {
        requireNonEmpty();
        return maxStack.top();
    }

    @Override
    public void push(int value) {
        super.push(value);
        if (maxStack.empty() || value >= maxStack.top()) {
            maxStack.push(value);
        }
    }

    @Override
    public int pop() {
        int target = super.pop();
        if (target == maxStack.top()) {
            maxStack.pop();
        }
        return target;
    }
}
