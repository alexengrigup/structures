package dev.alexengrig.structures.tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.function.IntConsumer;

public class IntBinaryTree {

    private final Node root;

    public IntBinaryTree(Node root) {
        this.root = root;
    }

    public static Node node(int value, Node left, Node right) {
        return new Node(value, left, right);
    }

    public static Node node(int value) {
        return node(value, null, null);
    }

    public static void depthFirstTraversalRecursively(IntBinaryTree tree, IntConsumer action) {
        depthFirstTraversalRecursively(tree.root, action);
    }

    private static void depthFirstTraversalRecursively(Node root, IntConsumer action) {
        if (root == null) {
            return;
        }
        action.accept(root.value);
        depthFirstTraversalRecursively(root.left, action);
        depthFirstTraversalRecursively(root.right, action);
    }

    public static void depthFirstTraversal(IntBinaryTree tree, IntConsumer action) {
        Deque<Node> stack = new LinkedList<>();
        stack.push(tree.root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            action.accept(node.value);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }

    public static void breadthFirstTraversal(IntBinaryTree tree, IntConsumer action) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(tree.root);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            action.accept(node.value);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
    }

    public static class Node {
        private int value;
        private Node left;
        private Node right;

        public Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
}
