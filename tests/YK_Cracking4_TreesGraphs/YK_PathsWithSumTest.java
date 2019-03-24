package YK_Cracking4_TreesGraphs;

import YK_Common.YK_BinaryTreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static YK_Cracking4_TreesGraphs.YK_TESTS_TreeUtils.YK_RIGHT_LEFT.YK_LEFT;
import static YK_Cracking4_TreesGraphs.YK_TESTS_TreeUtils.YK_RIGHT_LEFT.YK_RIGHT;
import static YK_Cracking4_TreesGraphs.YK_TESTS_TreeUtils.getBinaryTreeNodes;
import static YK_Cracking4_TreesGraphs.YK_TESTS_TreeUtils.setConn;
import static org.junit.jupiter.api.Assertions.*;

class YK_PathsWithSumTest {

    @Test
    void singleYes() {
        YK_BinaryTreeNode<Integer> head = new YK_BinaryTreeNode<>(10);

        assertEquals(1, new YK_PathsWithSum().getNumPathsWithSum(10,head));
    }

    @Test
    void singleNo() {
        YK_BinaryTreeNode<Integer> head = new YK_BinaryTreeNode<>(10);

        assertEquals(0, new YK_PathsWithSum().getNumPathsWithSum(11,head));
    }

    @Test
    void simpleYes() {
        ArrayList<YK_BinaryTreeNode<Integer>> nodes = getBinaryTreeNodes(9);

        setConn(nodes,1,2, YK_LEFT);
        setConn(nodes,1,3, YK_RIGHT);

        YK_BinaryTreeNode<Integer> head = nodes.get(1);

        assertEquals(2, new YK_PathsWithSum().getNumPathsWithSum(3,head));
    }

    @Test
    void simpleNo() {
        ArrayList<YK_BinaryTreeNode<Integer>> nodes = getBinaryTreeNodes(9);

        setConn(nodes,1,2, YK_LEFT);
        setConn(nodes,1,3, YK_RIGHT);

        YK_BinaryTreeNode<Integer> head = nodes.get(1);

        assertEquals(0, new YK_PathsWithSum().getNumPathsWithSum(6,head));
    }

    @Test
    void startFromMiddleYes() {
        ArrayList<YK_BinaryTreeNode<Integer>> nodes = getBinaryTreeNodes(9);

        setConn(nodes,1,2, YK_LEFT);
        setConn(nodes,1,3, YK_RIGHT);

        setConn(nodes,2,4, YK_LEFT);
        setConn(nodes,2,5, YK_RIGHT);

        setConn(nodes,3,6, YK_LEFT);
        setConn(nodes,3,7, YK_RIGHT);

        YK_BinaryTreeNode<Integer> head = nodes.get(1);

        assertEquals(3, new YK_PathsWithSum().getNumPathsWithSum(7,head));
    }

    @Test
    void startFromMiddleEndMiddleYes() {
        ArrayList<YK_BinaryTreeNode<Integer>> nodes = getBinaryTreeNodes(9);

        setConn(nodes,1,2, YK_LEFT);
        setConn(nodes,1,3, YK_RIGHT);

        setConn(nodes,2,4, YK_LEFT);
        setConn(nodes,2,5, YK_RIGHT);

        setConn(nodes,3,6, YK_LEFT);
        setConn(nodes,3,7, YK_RIGHT);

        setConn(nodes,5,8, YK_LEFT);

        YK_BinaryTreeNode<Integer> head = nodes.get(1);

        assertEquals(3, new YK_PathsWithSum().getNumPathsWithSum(7,head));
    }

    @Test
    void singleMiddle() {
        ArrayList<YK_BinaryTreeNode<Integer>> nodes = getBinaryTreeNodes(9);

        setConn(nodes,1,2, YK_LEFT);
        setConn(nodes,1,3, YK_RIGHT);

        setConn(nodes,2,4, YK_LEFT);
        setConn(nodes,2,5, YK_RIGHT);

        setConn(nodes,3,6, YK_LEFT);
        setConn(nodes,3,7, YK_RIGHT);

        setConn(nodes,5,8, YK_LEFT);

        YK_BinaryTreeNode<Integer> head = nodes.get(1);

        assertEquals(2, new YK_PathsWithSum().getNumPathsWithSum(3,head));
    }

    @Test
    void repeatingYes() {

        YK_BinaryTreeNode<Integer> node1 = new YK_BinaryTreeNode<>(1);
        YK_BinaryTreeNode<Integer> node2 = new YK_BinaryTreeNode<>(2);
        YK_BinaryTreeNode<Integer> nodeMin3 = new YK_BinaryTreeNode<>(-3);
        YK_BinaryTreeNode<Integer> node3 = new YK_BinaryTreeNode<>(3);

        node1.setLeft(node2);
        node2.setLeft(nodeMin3);
        nodeMin3.setLeft(node3);

        YK_BinaryTreeNode<Integer> head = node1;

        assertEquals(3, new YK_PathsWithSum().getNumPathsWithSum(3,head));
    }

    @Test
    void negativeYes() {

        YK_BinaryTreeNode<Integer> node1 = new YK_BinaryTreeNode<>(-1);
        YK_BinaryTreeNode<Integer> node2 = new YK_BinaryTreeNode<>(-2);
        YK_BinaryTreeNode<Integer> node3 = new YK_BinaryTreeNode<>(-3);
        YK_BinaryTreeNode<Integer> node4 = new YK_BinaryTreeNode<>(-4);
        YK_BinaryTreeNode<Integer> node5 = new YK_BinaryTreeNode<>(-5);
        YK_BinaryTreeNode<Integer> node6 = new YK_BinaryTreeNode<>(-6);
        YK_BinaryTreeNode<Integer> node7 = new YK_BinaryTreeNode<>(-7);

        node1.setLeft(node2);
        node1.setRight(node3);

        node2.setLeft(node4);
        node2.setRight(node5);

        node3.setLeft(node6);
        node3.setRight(node7);

        YK_BinaryTreeNode<Integer> head = node1;

        assertEquals(3, new YK_PathsWithSum().getNumPathsWithSum(-7,head));
    }
}