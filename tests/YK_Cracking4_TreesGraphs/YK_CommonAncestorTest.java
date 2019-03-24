package YK_Cracking4_TreesGraphs;

import YK_Common.YK_BinaryTreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static YK_Cracking4_TreesGraphs.YK_TESTS_TreeUtils.*;
import static YK_Cracking4_TreesGraphs.YK_TESTS_TreeUtils.YK_RIGHT_LEFT.*;


import static org.junit.jupiter.api.Assertions.*;

class YK_CommonAncestorTest {

    private class YK_TESTS_CommonAncestorsPair {
        ArrayList<YK_BinaryTreeNode<Integer>> nodes;
        YK_BinaryTreeNode<Integer> head;

        YK_TESTS_CommonAncestorsPair(ArrayList<YK_BinaryTreeNode<Integer>> nodes,
                                    YK_BinaryTreeNode<Integer> head) {
            this.nodes = nodes;
            this.head = head;
        }
    }

    private YK_TESTS_CommonAncestorsPair buildExampleTree() {
        ArrayList<YK_BinaryTreeNode<Integer>> nodes = getBinaryTreeNodes(14);

        setConn(nodes, 1, 2, YK_LEFT);
        setConn(nodes, 1, 3, YK_RIGHT);
        setConn(nodes, 2, 4, YK_LEFT);
        setConn(nodes, 3, 5, YK_LEFT);
        setConn(nodes, 3,6, YK_RIGHT);
        setConn(nodes, 4,7, YK_LEFT);
        setConn(nodes, 5, 8, YK_LEFT);
        setConn(nodes, 6, 9, YK_LEFT);
        setConn(nodes, 6,10, YK_RIGHT);
        setConn(nodes, 8, 11, YK_LEFT);
        setConn(nodes, 8, 12, YK_RIGHT);
        setConn(nodes, 10, 13, YK_LEFT);

        return new YK_TESTS_CommonAncestorsPair(nodes, nodes.get(1));
    }

    @Test
    void oneNode() {
        YK_TESTS_CommonAncestorsPair nodesHead = buildExampleTree();

        nodesHead.head.setLeft(null);
        nodesHead.head.setRight(null);

        assertEquals(nodesHead.head,
                new YK_CommonAncestor().getCommonAncestor(
                        nodesHead.head,
                        nodesHead.head,
                        nodesHead.head));
    }

    @Test
    void oneOfEachOther() {
        YK_TESTS_CommonAncestorsPair nodesHead = buildExampleTree();

        assertEquals(nodesHead.nodes.get(8),
                new YK_CommonAncestor().getCommonAncestor(
                    nodesHead.head,
                    nodesHead.nodes.get(8),
                    nodesHead.nodes.get(12)));

        assertEquals(nodesHead.nodes.get(8),
                new YK_CommonAncestor().getCommonAncestor(
                        nodesHead.head,
                        nodesHead.nodes.get(12),
                        nodesHead.nodes.get(8)));

        assertEquals(nodesHead.nodes.get(5),
                new YK_CommonAncestor().getCommonAncestor(
                        nodesHead.head,
                        nodesHead.nodes.get(12),
                        nodesHead.nodes.get(5)));

        assertEquals(nodesHead.nodes.get(5),
                new YK_CommonAncestor().getCommonAncestor(
                        nodesHead.head,
                        nodesHead.nodes.get(12),
                        nodesHead.nodes.get(5)));

        assertEquals(nodesHead.nodes.get(1),
                new YK_CommonAncestor().getCommonAncestor(
                        nodesHead.head,
                        nodesHead.nodes.get(1),
                        nodesHead.nodes.get(2)));

        assertEquals(nodesHead.nodes.get(1),
                new YK_CommonAncestor().getCommonAncestor(
                        nodesHead.head,
                        nodesHead.nodes.get(2),
                        nodesHead.nodes.get(1)));

        assertEquals(nodesHead.nodes.get(1),
                new YK_CommonAncestor().getCommonAncestor(
                        nodesHead.head,
                        nodesHead.nodes.get(1),
                        nodesHead.nodes.get(3)));

        assertEquals(nodesHead.nodes.get(1),
                new YK_CommonAncestor().getCommonAncestor(
                        nodesHead.head,
                        nodesHead.nodes.get(3),
                        nodesHead.nodes.get(1)));

    }

    @Test
    void brothers() {
        YK_TESTS_CommonAncestorsPair nodesHead = buildExampleTree();

        assertEquals(nodesHead.nodes.get(8),
                new YK_CommonAncestor().getCommonAncestor(
                        nodesHead.head,
                        nodesHead.nodes.get(11),
                        nodesHead.nodes.get(12)));

        assertEquals(nodesHead.nodes.get(8),
                new YK_CommonAncestor().getCommonAncestor(
                        nodesHead.head,
                        nodesHead.nodes.get(12),
                        nodesHead.nodes.get(11)));

        assertEquals(nodesHead.nodes.get(1),
                new YK_CommonAncestor().getCommonAncestor(
                        nodesHead.head,
                        nodesHead.nodes.get(2),
                        nodesHead.nodes.get(3)));

        assertEquals(nodesHead.nodes.get(1),
                new YK_CommonAncestor().getCommonAncestor(
                        nodesHead.head,
                        nodesHead.nodes.get(3),
                        nodesHead.nodes.get(2)));
    }

    @Test
    void far() {
        YK_TESTS_CommonAncestorsPair nodesHead = buildExampleTree();

        assertEquals(nodesHead.nodes.get(3),
                new YK_CommonAncestor().getCommonAncestor(
                        nodesHead.head,
                        nodesHead.nodes.get(12),
                        nodesHead.nodes.get(13)));

        assertEquals(nodesHead.nodes.get(3),
                new YK_CommonAncestor().getCommonAncestor(
                        nodesHead.head,
                        nodesHead.nodes.get(13),
                        nodesHead.nodes.get(12)));
    }

    @Test
    void noAncestor() {
        YK_TESTS_CommonAncestorsPair nodesHead = buildExampleTree();

        assertNull(new YK_CommonAncestor().getCommonAncestor(
                        nodesHead.head,
                        nodesHead.nodes.get(1),
                        nodesHead.nodes.get(14)));

        assertNull(new YK_CommonAncestor().getCommonAncestor(
                        nodesHead.head,
                        nodesHead.nodes.get(14),
                        nodesHead.nodes.get(1)));

        assertNull(new YK_CommonAncestor().getCommonAncestor(
                        nodesHead.head,
                        nodesHead.nodes.get(7),
                        nodesHead.nodes.get(14)));

        assertNull(new YK_CommonAncestor().getCommonAncestor(
                        nodesHead.head,
                        nodesHead.nodes.get(14),
                        nodesHead.nodes.get(7)));

        assertNull(new YK_CommonAncestor().getCommonAncestor(
                        nodesHead.head,
                        nodesHead.nodes.get(6),
                        nodesHead.nodes.get(14)));

        assertNull(new YK_CommonAncestor().getCommonAncestor(
                        nodesHead.head,
                        nodesHead.nodes.get(14),
                        nodesHead.nodes.get(6)));

        assertNull(new YK_CommonAncestor().getCommonAncestor(
                        nodesHead.head,
                        nodesHead.nodes.get(13),
                        nodesHead.nodes.get(14)));

        assertNull(new YK_CommonAncestor().getCommonAncestor(
                        nodesHead.head,
                        nodesHead.nodes.get(14),
                        nodesHead.nodes.get(13)));
    }
}