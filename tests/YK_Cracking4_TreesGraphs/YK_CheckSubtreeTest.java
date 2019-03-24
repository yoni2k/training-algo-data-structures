package YK_Cracking4_TreesGraphs;

import YK_Common.YK_BinaryTreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static YK_Cracking4_TreesGraphs.YK_TESTS_TreeUtils.YK_RIGHT_LEFT.YK_LEFT;
import static YK_Cracking4_TreesGraphs.YK_TESTS_TreeUtils.YK_RIGHT_LEFT.YK_RIGHT;
import static YK_Cracking4_TreesGraphs.YK_TESTS_TreeUtils.getBinaryTreeNodes;
import static YK_Cracking4_TreesGraphs.YK_TESTS_TreeUtils.setConn;
import static org.junit.jupiter.api.Assertions.*;

class YK_CheckSubtreeTest {

    @Test
    void oneSame() {
        YK_BinaryTreeNode<Integer> h1 = new YK_BinaryTreeNode<>(1);

        YK_BinaryTreeNode<Integer> h2 = new YK_BinaryTreeNode<>(1);

        assertTrue(new YK_CheckSubtree().isSubtree(h1,h2));
    }

    @Test
    void oneNotSame() {
        YK_BinaryTreeNode<Integer> h1 = new YK_BinaryTreeNode<>(1);

        YK_BinaryTreeNode<Integer> h2 = new YK_BinaryTreeNode<>(2);

        assertFalse(new YK_CheckSubtree().isSubtree(h1,h2));
    }

    @Test
    void subSetSame() {

        ArrayList<YK_BinaryTreeNode<Integer>> nodes1 = getBinaryTreeNodes(6);
        ArrayList<YK_BinaryTreeNode<Integer>> nodes2 = getBinaryTreeNodes(6);

        setConn(nodes1, 1, 2, YK_LEFT);
        setConn(nodes1, 2, 3, YK_LEFT);
        setConn(nodes1, 2, 4, YK_RIGHT);

        YK_BinaryTreeNode<Integer> h1 = nodes1.get(1);

        setConn(nodes2, 2, 3, YK_LEFT);
        setConn(nodes2, 2, 4, YK_RIGHT);

        YK_BinaryTreeNode<Integer> h2 = nodes2.get(2);

        assertTrue(new YK_CheckSubtree().isSubtree(h1,h2));
    }

    @Test
    void subSetNotSame() {

        ArrayList<YK_BinaryTreeNode<Integer>> nodes1 = getBinaryTreeNodes(6);
        ArrayList<YK_BinaryTreeNode<Integer>> nodes2 = getBinaryTreeNodes(6);

        setConn(nodes1, 1, 2, YK_LEFT);
        setConn(nodes1, 2, 3, YK_LEFT);
        setConn(nodes1, 2, 4, YK_RIGHT);

        YK_BinaryTreeNode<Integer> h1 = nodes1.get(1);

        setConn(nodes2, 2, 3, YK_LEFT);

        YK_BinaryTreeNode<Integer> h2 = nodes2.get(2);

        assertFalse(new YK_CheckSubtree().isSubtree(h1,h2));
    }

    @Test
    void wholeSame() {

        ArrayList<YK_BinaryTreeNode<Integer>> nodes1 = getBinaryTreeNodes(6);
        ArrayList<YK_BinaryTreeNode<Integer>> nodes2 = getBinaryTreeNodes(6);

        setConn(nodes1, 1, 2, YK_LEFT);
        setConn(nodes1, 2, 4, YK_RIGHT);

        setConn(nodes1, 1, 3, YK_RIGHT);
        setConn(nodes1, 3, 5, YK_LEFT);

        YK_BinaryTreeNode<Integer> h1 = nodes1.get(1);

        setConn(nodes2, 1, 2, YK_LEFT);
        setConn(nodes2, 2, 4, YK_RIGHT);

        setConn(nodes2, 1, 3, YK_RIGHT);
        setConn(nodes2, 3, 5, YK_LEFT);

        YK_BinaryTreeNode<Integer> h2 = nodes2.get(1);

        assertTrue(new YK_CheckSubtree().isSubtree(h1,h2));
    }

    @Test
    void wholeDiff() {

        ArrayList<YK_BinaryTreeNode<Integer>> nodes1 = getBinaryTreeNodes(6);
        ArrayList<YK_BinaryTreeNode<Integer>> nodes2 = getBinaryTreeNodes(6);

        setConn(nodes1, 1, 2, YK_LEFT);
        setConn(nodes1, 2, 4, YK_RIGHT);

        setConn(nodes1, 1, 3, YK_RIGHT);
        setConn(nodes1, 3, 5, YK_LEFT);

        YK_BinaryTreeNode<Integer> h1 = nodes1.get(1);

        setConn(nodes2, 1, 2, YK_LEFT);
        setConn(nodes2, 2, 4, YK_RIGHT);

        setConn(nodes2, 1, 3, YK_RIGHT);
        setConn(nodes2, 3, 5, YK_RIGHT);

        YK_BinaryTreeNode<Integer> h2 = nodes2.get(1);

        assertFalse(new YK_CheckSubtree().isSubtree(h1,h2));
    }

    @Test
    void repeatingSame() {

        YK_BinaryTreeNode<Integer> node1 = new YK_BinaryTreeNode<>(1);
        YK_BinaryTreeNode<Integer> node2a = new YK_BinaryTreeNode<>(2);
        YK_BinaryTreeNode<Integer> node3a = new YK_BinaryTreeNode<>(3);
        YK_BinaryTreeNode<Integer> node2b = new YK_BinaryTreeNode<>(2);
        YK_BinaryTreeNode<Integer> node3b = new YK_BinaryTreeNode<>(3);
        YK_BinaryTreeNode<Integer> node4 = new YK_BinaryTreeNode<>(4);

        node1.setLeft(node2a);
        node2a.setLeft(node3a);
        node1.setRight(node2b);
        node2b.setLeft(node3b);
        node2b.setRight(node4);

        YK_BinaryTreeNode<Integer> h1 = node1;

        node2b = new YK_BinaryTreeNode<>(2);
        node3b = new YK_BinaryTreeNode<>(3);
        node4 = new YK_BinaryTreeNode<>(4);

        node2b.setLeft(node3b);
        node2b.setRight(node4);

        YK_BinaryTreeNode<Integer> h2 = node2b;

        assertTrue(new YK_CheckSubtree().isSubtree(h1,h2));
    }

    @Test
    void repeatingDiff() {

        YK_BinaryTreeNode<Integer> node1 = new YK_BinaryTreeNode<>(1);
        YK_BinaryTreeNode<Integer> node2a = new YK_BinaryTreeNode<>(2);
        YK_BinaryTreeNode<Integer> node3a = new YK_BinaryTreeNode<>(3);
        YK_BinaryTreeNode<Integer> node2b = new YK_BinaryTreeNode<>(2);
        YK_BinaryTreeNode<Integer> node3b = new YK_BinaryTreeNode<>(3);
        YK_BinaryTreeNode<Integer> node4 = new YK_BinaryTreeNode<>(4);

        node1.setLeft(node2a);
        node2a.setLeft(node3a);
        node1.setRight(node2b);
        node2b.setLeft(node3b);
        node2b.setRight(node4);

        YK_BinaryTreeNode<Integer> h1 = node1;

        node1 = new YK_BinaryTreeNode<>(1);
        node2a = new YK_BinaryTreeNode<>(2);
        node3a = new YK_BinaryTreeNode<>(3);
        node2b = new YK_BinaryTreeNode<>(2);
        node4 = new YK_BinaryTreeNode<>(4);

        node1.setLeft(node2a);
        node2a.setLeft(node3a);
        node1.setRight(node2b);
        node2b.setRight(node4);

        YK_BinaryTreeNode<Integer> h2 = node1;

        assertFalse(new YK_CheckSubtree().isSubtree(h1,h2));
    }

}