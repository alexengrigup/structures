package dev.alexengrig.structures.tree;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class IntPlainTreeTest {

    /**
     * <pre>{@code
     *      5
     *   4     6
     * 1 2 3 7 8 9
     *  }</pre>
     */
    private final IntPlainTree tree;

    {
        tree = new IntPlainTree(IntPlainTree.node(5,
                IntPlainTree.node(4,
                        IntPlainTree.node(1),
                        IntPlainTree.node(2),
                        IntPlainTree.node(3)),
                IntPlainTree.node(6,
                        IntPlainTree.node(7),
                        IntPlainTree.node(8),
                        IntPlainTree.node(9))));
    }

    @Test
    public void testDepthFirstTraversalRecursively() {
        ArrayList<Integer> holder = new ArrayList<>(9);
        IntPlainTree.depthFirstTraversalRecursively(tree, holder::add);
        assertEquals(Arrays.asList(5, 4, 1, 2, 3, 6, 7, 8, 9), holder);
    }

    @Test
    public void testDepthFirstTraversal() {
        ArrayList<Integer> holder = new ArrayList<>(9);
        IntPlainTree.depthFirstTraversal(tree, holder::add);
        assertEquals(Arrays.asList(5, 4, 1, 2, 3, 6, 7, 8, 9), holder);
    }

    @Test
    public void testBreadthFirstTraversal() {
        ArrayList<Integer> holder = new ArrayList<>(9);
        IntPlainTree.breadthFirstTraversal(tree, holder::add);
        assertEquals(Arrays.asList(5, 4, 6, 1, 2, 3, 7, 8, 9), holder);
    }
}