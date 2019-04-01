package YK_AmazonPrep;

import YK_Common.YK_BinaryTreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class YK_1TreeHeightTest {

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
        int[] exp = {1};

        assertArrayEquals(exp, YK_2LevelOrderTraversal.levelOrder(nodes.get(1)));
    }

    @Test
    void height1NotBalanced() {
        ArrayList<YK_BinaryTreeNode<Integer>> nodes = getNodes();
        int[] exp = {1,2};

        nodes.get(1).setLeft(nodes.get(2));

        assertArrayEquals(exp, YK_2LevelOrderTraversal.levelOrder(nodes.get(1)));
    }

    @Test
    void height1Balanced() {
        ArrayList<YK_BinaryTreeNode<Integer>> nodes = getNodes();
        int[] exp = {1,2,3};

        nodes.get(1).setLeft(nodes.get(2));
        nodes.get(1).setRight(nodes.get(3));

        assertArrayEquals(exp, YK_2LevelOrderTraversal.levelOrder(nodes.get(1)));
    }

    @Test
    void height2NotBalanced() {
        ArrayList<YK_BinaryTreeNode<Integer>> nodes = getNodes();
        int[] exp = {1,2,3};

        nodes.get(1).setLeft(nodes.get(2));
        nodes.get(2).setLeft(nodes.get(3));

        assertArrayEquals(exp, YK_2LevelOrderTraversal.levelOrder(nodes.get(1)));
    }

    @Test
    void height2NotBalanced2() {
        ArrayList<YK_BinaryTreeNode<Integer>> nodes = getNodes();
        int[] exp = {1,2,3,4};

        nodes.get(1).setLeft(nodes.get(2));
        nodes.get(1).setRight(nodes.get(3));
        nodes.get(2).setLeft(nodes.get(4));

        assertArrayEquals(exp, YK_2LevelOrderTraversal.levelOrder(nodes.get(1)));
    }

    @Test
    void height2NotBalanced3() {
        ArrayList<YK_BinaryTreeNode<Integer>> nodes = getNodes();
        int[] exp = {1,2,3,4};

        nodes.get(1).setLeft(nodes.get(2));
        nodes.get(1).setRight(nodes.get(3));
        nodes.get(2).setRight(nodes.get(4));

        assertArrayEquals(exp, YK_2LevelOrderTraversal.levelOrder(nodes.get(1)));
    }

    @Test
    void notBalanced3() {
        ArrayList<YK_BinaryTreeNode<Integer>> nodes = getNodes();
        int[] exp = {1,2,3,4,5,6};

        nodes.get(1).setLeft(nodes.get(2));
        nodes.get(1).setRight(nodes.get(3));

        nodes.get(2).setLeft(nodes.get(4));
        nodes.get(2).setRight(nodes.get(5));

        nodes.get(4).setLeft(nodes.get(6));

        assertArrayEquals(exp, YK_2LevelOrderTraversal.levelOrder(nodes.get(1)));
    }


    @Test
    void height3() {
        ArrayList<YK_BinaryTreeNode<Integer>> nodes = getNodes();
        int[] exp = {1,2,3,4,5,6,7,9};

        nodes.get(1).setLeft(nodes.get(2));
        nodes.get(1).setRight(nodes.get(3));

        nodes.get(2).setLeft(nodes.get(4));
        nodes.get(2).setRight(nodes.get(5));

        nodes.get(3).setLeft(nodes.get(6));
        nodes.get(3).setRight(nodes.get(7));

        nodes.get(7).setRight(nodes.get(9));

        assertArrayEquals(exp, YK_2LevelOrderTraversal.levelOrder(nodes.get(1)));
    }


    @Test
    void height3_2() {
        ArrayList<YK_BinaryTreeNode<Integer>> nodes = getNodes();
        int[] exp = {1,2,3,4,5,6,7,8,9};

        nodes.get(1).setLeft(nodes.get(2));
        nodes.get(1).setRight(nodes.get(3));

        nodes.get(2).setLeft(nodes.get(4));
        nodes.get(2).setRight(nodes.get(5));

        nodes.get(3).setLeft(nodes.get(6));
        nodes.get(3).setRight(nodes.get(7));

        nodes.get(4).setLeft(nodes.get(8));

        nodes.get(7).setRight(nodes.get(9));

        assertArrayEquals(exp, YK_2LevelOrderTraversal.levelOrder(nodes.get(1)));
    }

    @Test
    void height3_full() {
        ArrayList<YK_BinaryTreeNode<Integer>> nodes = getNodes();
        int[] exp = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};

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

        assertArrayEquals(exp, YK_2LevelOrderTraversal.levelOrder(nodes.get(1)));
    }

}