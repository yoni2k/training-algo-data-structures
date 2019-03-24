package YK_Cracking4_TreesGraphs;

import YK_Common.YK_BinaryTreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class YK_IsBinaryBalancedTest {

    private ArrayList<YK_BinaryTreeNode<Integer>> getNodes() {
        ArrayList<YK_BinaryTreeNode<Integer>> nodes = new ArrayList<>();

        for(int i = 0; i <= 20; i++) {
            nodes.add(new YK_BinaryTreeNode<>(i));
        }

        return nodes;
    }

    @Test
    void singleNode() {
        ArrayList<YK_BinaryTreeNode<Integer>> nodes = getNodes();

        assertTrue(new YK_IsBinaryBalanced().isBalanced(nodes.get(1)));
    }

    @Test
    void balanced2() {
        ArrayList<YK_BinaryTreeNode<Integer>> nodes = getNodes();

        nodes.get(1).setLeft(nodes.get(2));

        assertTrue(new YK_IsBinaryBalanced().isBalanced(nodes.get(1)));
    }

    @Test
    void balanced3() {
        ArrayList<YK_BinaryTreeNode<Integer>> nodes = getNodes();

        nodes.get(1).setLeft(nodes.get(2));
        nodes.get(1).setRight(nodes.get(3));

        assertTrue(new YK_IsBinaryBalanced().isBalanced(nodes.get(1)));
    }

    @Test
    void notBalanced3() {
        ArrayList<YK_BinaryTreeNode<Integer>> nodes = getNodes();

        nodes.get(1).setLeft(nodes.get(2));
        nodes.get(2).setLeft(nodes.get(3));

        assertFalse(new YK_IsBinaryBalanced().isBalanced(nodes.get(1)));
    }

    @Test
    void balanced4() {
        ArrayList<YK_BinaryTreeNode<Integer>> nodes = getNodes();

        nodes.get(1).setLeft(nodes.get(2));
        nodes.get(1).setRight(nodes.get(3));
        nodes.get(2).setLeft(nodes.get(4));

        assertTrue(new YK_IsBinaryBalanced().isBalanced(nodes.get(1)));
    }

    @Test
    void balanced4_right() {
        ArrayList<YK_BinaryTreeNode<Integer>> nodes = getNodes();

        nodes.get(1).setLeft(nodes.get(2));
        nodes.get(1).setRight(nodes.get(3));
        nodes.get(2).setRight(nodes.get(4));

        assertTrue(new YK_IsBinaryBalanced().isBalanced(nodes.get(1)));
    }

    @Test
    void notBalanced_large() {
        ArrayList<YK_BinaryTreeNode<Integer>> nodes = getNodes();

        nodes.get(1).setLeft(nodes.get(2));
        nodes.get(1).setRight(nodes.get(3));

        nodes.get(2).setLeft(nodes.get(4));
        nodes.get(2).setRight(nodes.get(5));

        nodes.get(4).setLeft(nodes.get(6));

        assertFalse(new YK_IsBinaryBalanced().isBalanced(nodes.get(1)));
    }


    @Test
    void balancedLargeNotEven() {
        ArrayList<YK_BinaryTreeNode<Integer>> nodes = getNodes();

        nodes.get(1).setLeft(nodes.get(2));
        nodes.get(1).setRight(nodes.get(3));

        nodes.get(2).setLeft(nodes.get(4));
        nodes.get(2).setRight(nodes.get(5));

        nodes.get(3).setLeft(nodes.get(6));
        nodes.get(3).setRight(nodes.get(7));

        nodes.get(7).setRight(nodes.get(9));

        assertTrue(new YK_IsBinaryBalanced().isBalanced(nodes.get(1)));
    }


    @Test
    void balancedLargeMostlyEven() {
        ArrayList<YK_BinaryTreeNode<Integer>> nodes = getNodes();

        nodes.get(1).setLeft(nodes.get(2));
        nodes.get(1).setRight(nodes.get(3));

        nodes.get(2).setLeft(nodes.get(4));
        nodes.get(2).setRight(nodes.get(5));

        nodes.get(3).setLeft(nodes.get(6));
        nodes.get(3).setRight(nodes.get(7));

        nodes.get(4).setLeft(nodes.get(8));

        nodes.get(7).setRight(nodes.get(9));

        assertTrue(new YK_IsBinaryBalanced().isBalanced(nodes.get(1)));
    }

    @Test
    void balancedLargeFullyEven() {
        ArrayList<YK_BinaryTreeNode<Integer>> nodes = getNodes();

        nodes.get(1).setLeft(nodes.get(2));
        nodes.get(1).setRight(nodes.get(3));

        nodes.get(2).setLeft(nodes.get(4));
        nodes.get(2).setRight(nodes.get(5));

        nodes.get(3).setLeft(nodes.get(6));
        nodes.get(3).setRight(nodes.get(7));

        nodes.get(4).setLeft(nodes.get(8));
        nodes.get(4).setRight(nodes.get(9));

        nodes.get(5).setLeft(nodes.get(10));
        nodes.get(5).setRight(nodes.get(11));

        nodes.get(6).setLeft(nodes.get(12));
        nodes.get(6).setRight(nodes.get(13));

        nodes.get(7).setLeft(nodes.get(14));
        nodes.get(7).setRight(nodes.get(15));

        assertTrue(new YK_IsBinaryBalanced().isBalanced(nodes.get(1)));
    }
}