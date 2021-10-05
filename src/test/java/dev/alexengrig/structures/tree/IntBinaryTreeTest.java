package dev.alexengrig.structures.tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class IntBinaryTreeTest {

    /**
     * <pre>{@code
     *     4
     *   2   5
     *  1 3 6 7
     *  }</pre>
     */
    private final IntBinaryTree tree;

    {
        tree = new IntBinaryTree(IntBinaryTree.node(4,
                IntBinaryTree.node(2,
                        IntBinaryTree.node(1),
                        IntBinaryTree.node(3)),
                IntBinaryTree.node(5,
                        IntBinaryTree.node(6),
                        IntBinaryTree.node(7))));
    }

    @Test
    public void testDepthFirstTraversalRecursively() {
        ArrayList<Integer> holder = new ArrayList<>(7);
        IntBinaryTree.depthFirstTraversalRecursively(tree, holder::add);
        assertEquals(Arrays.asList(4, 2, 1, 3, 5, 6, 7), holder);
    }

    @Test
    public void testDepthFirstTraversal() {
        ArrayList<Integer> holder = new ArrayList<>(7);
        IntBinaryTree.depthFirstTraversal(tree, holder::add);
        assertEquals(Arrays.asList(4, 2, 1, 3, 5, 6, 7), holder);
    }

    @Test
    public void testBreadthFirstTraversal() {
        ArrayList<Integer> holder = new ArrayList<>(7);
        IntBinaryTree.breadthFirstTraversal(tree, holder::add);
        assertEquals(Arrays.asList(4, 2, 5, 1, 3, 6, 7), holder);
    }

}