package dev.alexengrig.structures.tree;

import dev.alexengrig.structures.stack.IntLinkedStack;
import dev.alexengrig.structures.stack.LinkedStack;
import dev.alexengrig.structures.stack.Stack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.function.IntConsumer;

public class IntPlainTree {

    private final Node root;

    public IntPlainTree(Node root) {
        this.root = root;
    }

    public static Node node(int value, Node... children) {
        return new Node(value, children);
    }

    public static void depthFirstTraversalRecursively(IntPlainTree tree, IntConsumer action) {
        depthFirstTraversalRecursively(tree.root, action);
    }

    private static void depthFirstTraversalRecursively(Node root, IntConsumer action) {
        action.accept(root.value);
        for (Node child : root.children) {
            depthFirstTraversalRecursively(child, action);
        }
    }

    public static void depthFirstTraversal(IntPlainTree tree, IntConsumer action) {
        Stack<Node> stack = new LinkedStack<>();
        stack.push(tree.root);
        while (!stack.empty()) {
            Node node = stack.pop();
            action.accept(node.value);
            for (int i = node.children.length - 1; i >= 0; i--) {
                stack.push(node.children[i]);
            }
        }
    }

    public static void breadthFirstTraversal(IntPlainTree tree, IntConsumer action) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(tree.root);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            action.accept(node.value);
            for (Node child : node.children) {
                queue.offer(child);
            }
        }
    }

    public static class Node {
        private int value;
        private Node[] children;

        private Node(int value, Node[] children) {
            this.value = value;
            this.children = children;
        }
    }
}
