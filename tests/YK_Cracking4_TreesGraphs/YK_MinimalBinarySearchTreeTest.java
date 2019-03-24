package YK_Cracking4_TreesGraphs;

import YK_Common.YK_BinaryTreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class YK_MinimalBinarySearchTreeTest {

    @Test
    void completeTree1() {
        int[] arr1 = {1};
        YK_MinimalBinarySearchTree tree1 = new YK_MinimalBinarySearchTree(arr1, true);
        YK_BinaryTreeNode<Integer> head = new YK_BinaryTreeNode<>(1);

        assertTrue(tree1.equals(head));
    }

    private ArrayList<YK_BinaryTreeNode<Integer>> getNodes() {
        ArrayList<YK_BinaryTreeNode<Integer>> nodes = new ArrayList<>();

        for(int i = 0; i <= 20; i++) {
            nodes.add(new YK_BinaryTreeNode<>(i));
        }

        return nodes;
    }

    @Test
    void completeTree2() {
        YK_BinaryTreeNode<Integer> head;
        int[] arr = {1,2};
        ArrayList<YK_BinaryTreeNode<Integer>> nodes = getNodes();

        YK_MinimalBinarySearchTree tree = new YK_MinimalBinarySearchTree(arr, true);

        head = nodes.get(2);

        nodes.get(2).setLeft(nodes.get(1));

        assertTrue(tree.equals(head));
    }

    @Test
    void completeTree3() {
        YK_BinaryTreeNode<Integer> head;
        int[] arr = {1,2,3};
        ArrayList<YK_BinaryTreeNode<Integer>> nodes = getNodes();

        YK_MinimalBinarySearchTree tree = new YK_MinimalBinarySearchTree(arr, true);

        head = nodes.get(2);

        nodes.get(2).setLeft(nodes.get(1));
        nodes.get(2).setRight(nodes.get(3));

        assertTrue(tree.equals(head));
    }

    @Test
    void completeTree4() {
        YK_BinaryTreeNode<Integer> head;
        int[] arr = {1,2,3,4};
        ArrayList<YK_BinaryTreeNode<Integer>> nodes = getNodes();

        YK_MinimalBinarySearchTree tree = new YK_MinimalBinarySearchTree(arr, true);

        head = nodes.get(3);

        nodes.get(3).setLeft(nodes.get(2));
        nodes.get(3).setRight(nodes.get(4));

        nodes.get(2).setLeft(nodes.get(1));

        assertTrue(tree.equals(head));
    }

    @Test
    void completeTree5() {
        YK_BinaryTreeNode<Integer> head;
        int[] arr = {1,2,3,4,5};
        ArrayList<YK_BinaryTreeNode<Integer>> nodes = getNodes();

        YK_MinimalBinarySearchTree tree = new YK_MinimalBinarySearchTree(arr, true);

        head = nodes.get(4);

        nodes.get(4).setLeft(nodes.get(2));
        nodes.get(4).setRight(nodes.get(5));

        nodes.get(2).setLeft(nodes.get(1));
        nodes.get(2).setRight(nodes.get(3));

        assertTrue(tree.equals(head));
    }

    @Test
    void completeTree6() {
        YK_BinaryTreeNode<Integer> head;
        int[] arr = {1,2,3,4,5,6};
        ArrayList<YK_BinaryTreeNode<Integer>> nodes = getNodes();

        YK_MinimalBinarySearchTree tree = new YK_MinimalBinarySearchTree(arr, true);

        head = nodes.get(4);

        nodes.get(4).setLeft(nodes.get(2));
        nodes.get(4).setRight(nodes.get(6));

        nodes.get(2).setLeft(nodes.get(1));
        nodes.get(2).setRight(nodes.get(3));

        nodes.get(6).setLeft(nodes.get(5));

        assertTrue(tree.equals(head));
    }

    @Test
    void completeTree7() {
        YK_BinaryTreeNode<Integer> head;
        int[] arr = {1,2,3,4,5,6, 7};
        ArrayList<YK_BinaryTreeNode<Integer>> nodes = getNodes();

        YK_MinimalBinarySearchTree tree = new YK_MinimalBinarySearchTree(arr, true);

        head = nodes.get(4);

        nodes.get(4).setLeft(nodes.get(2));
        nodes.get(4).setRight(nodes.get(6));

        nodes.get(2).setLeft(nodes.get(1));
        nodes.get(2).setRight(nodes.get(3));

        nodes.get(6).setLeft(nodes.get(5));
        nodes.get(6).setRight(nodes.get(7));

        assertTrue(tree.equals(head));
    }

    @Test
    void completeTree8() {
        YK_BinaryTreeNode<Integer> head;
        int[] arr = {1,2,3,4,5,6,7,8};
        ArrayList<YK_BinaryTreeNode<Integer>> nodes = getNodes();

        YK_MinimalBinarySearchTree tree = new YK_MinimalBinarySearchTree(arr, true);

        head = nodes.get(5);

        nodes.get(5).setLeft(nodes.get(3));
        nodes.get(5).setRight(nodes.get(7));

        nodes.get(3).setLeft(nodes.get(2));
        nodes.get(3).setRight(nodes.get(4));

        nodes.get(7).setLeft(nodes.get(6));
        nodes.get(7).setRight(nodes.get(8));

        nodes.get(2).setLeft(nodes.get(1));

        assertTrue(tree.equals(head));
    }


    @Test
    void completeTree9() {
        YK_BinaryTreeNode<Integer> head;
        int[] arr = {1,2,3,4,5,6,7,8,9};
        ArrayList<YK_BinaryTreeNode<Integer>> nodes = getNodes();

        YK_MinimalBinarySearchTree tree = new YK_MinimalBinarySearchTree(arr, true);

        head = nodes.get(6);

        nodes.get(6).setLeft(nodes.get(4));
        nodes.get(6).setRight(nodes.get(8));

        nodes.get(4).setLeft(nodes.get(2));
        nodes.get(4).setRight(nodes.get(5));

        nodes.get(8).setLeft(nodes.get(7));
        nodes.get(8).setRight(nodes.get(9));

        nodes.get(2).setLeft(nodes.get(1));
        nodes.get(2).setRight(nodes.get(3));

        assertTrue(tree.equals(head));
    }

    @Test
    void completeTree10() {
        YK_BinaryTreeNode<Integer> head;
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        ArrayList<YK_BinaryTreeNode<Integer>> nodes = getNodes();

        YK_MinimalBinarySearchTree tree = new YK_MinimalBinarySearchTree(arr, true);

        head = nodes.get(7);

        nodes.get(7).setLeft(nodes.get(4));
        nodes.get(7).setRight(nodes.get(9));

        nodes.get(4).setLeft(nodes.get(2));
        nodes.get(4).setRight(nodes.get(6));

        nodes.get(9).setLeft(nodes.get(8));
        nodes.get(9).setRight(nodes.get(10));

        nodes.get(2).setLeft(nodes.get(1));
        nodes.get(2).setRight(nodes.get(3));

        nodes.get(6).setLeft(nodes.get(5));

        assertTrue(tree.equals(head));
    }


    @Test
    void completeTree11() {
        YK_BinaryTreeNode<Integer> head;
        int[] arr = {1,2,3,4,5,6,7,8,9,10,11};
        ArrayList<YK_BinaryTreeNode<Integer>> nodes = getNodes();

        YK_MinimalBinarySearchTree tree = new YK_MinimalBinarySearchTree(arr, true);

        head = nodes.get(8);

        nodes.get(8).setLeft(nodes.get(4));
        nodes.get(8).setRight(nodes.get(10));

        nodes.get(4).setLeft(nodes.get(2));
        nodes.get(4).setRight(nodes.get(6));

        nodes.get(10).setLeft(nodes.get(9));
        nodes.get(10).setRight(nodes.get(11));

        nodes.get(2).setLeft(nodes.get(1));
        nodes.get(2).setRight(nodes.get(3));

        nodes.get(6).setLeft(nodes.get(5));
        nodes.get(6).setRight(nodes.get(7));

        assertTrue(tree.equals(head));
    }


    @Test
    void completeTree12() {
        YK_BinaryTreeNode<Integer> head;
        int[] arr = {1,2,3,4,5,6,7,8,9,10,11,12};
        ArrayList<YK_BinaryTreeNode<Integer>> nodes = getNodes();

        YK_MinimalBinarySearchTree tree = new YK_MinimalBinarySearchTree(arr, true);

        head = nodes.get(8);

        nodes.get(8).setLeft(nodes.get(4));
        nodes.get(8).setRight(nodes.get(11));

        nodes.get(4).setLeft(nodes.get(2));
        nodes.get(4).setRight(nodes.get(6));

        nodes.get(11).setLeft(nodes.get(10));
        nodes.get(11).setRight(nodes.get(12));

        nodes.get(2).setLeft(nodes.get(1));
        nodes.get(2).setRight(nodes.get(3));

        nodes.get(6).setLeft(nodes.get(5));
        nodes.get(6).setRight(nodes.get(7));

        nodes.get(10).setLeft(nodes.get(9));

        assertTrue(tree.equals(head));
    }

    /* --------------------------------------------------------------

    Simple trees from here, good enough

    ----------------------------------------------------------------*/

    @Test
    void simpleTree1() {
        int[] arr1 = {1};
        YK_MinimalBinarySearchTree tree1 = new YK_MinimalBinarySearchTree(arr1, false);
        YK_BinaryTreeNode<Integer> head = new YK_BinaryTreeNode<>(1);

        assertTrue(tree1.equals(head));
    }

    @Test
    void simpleTree2() {
        YK_BinaryTreeNode<Integer> head;
        int[] arr = {1,2};
        ArrayList<YK_BinaryTreeNode<Integer>> nodes = getNodes();

        YK_MinimalBinarySearchTree tree = new YK_MinimalBinarySearchTree(arr, false);

        head = nodes.get(2);

        nodes.get(2).setLeft(nodes.get(1));

        assertTrue(tree.equals(head));
    }

    @Test
    void simpleTree3() {
        YK_BinaryTreeNode<Integer> head;
        int[] arr = {1,2,3};
        ArrayList<YK_BinaryTreeNode<Integer>> nodes = getNodes();

        YK_MinimalBinarySearchTree tree = new YK_MinimalBinarySearchTree(arr, false);

        head = nodes.get(2);

        nodes.get(2).setLeft(nodes.get(1));
        nodes.get(2).setRight(nodes.get(3));

        assertTrue(tree.equals(head));
    }

    @Test
    void simpleTree4() {
        YK_BinaryTreeNode<Integer> head;
        int[] arr = {1,2,3,4};
        ArrayList<YK_BinaryTreeNode<Integer>> nodes = getNodes();

        YK_MinimalBinarySearchTree tree = new YK_MinimalBinarySearchTree(arr, false);

        head = nodes.get(3);

        nodes.get(3).setLeft(nodes.get(2));
        nodes.get(3).setRight(nodes.get(4));

        nodes.get(2).setLeft(nodes.get(1));

        assertTrue(tree.equals(head));
    }

    @Test
    void simpleTree5() {
        YK_BinaryTreeNode<Integer> head;
        int[] arr = {1,2,3,4,5};
        ArrayList<YK_BinaryTreeNode<Integer>> nodes = getNodes();

        YK_MinimalBinarySearchTree tree = new YK_MinimalBinarySearchTree(arr, false);

        head = nodes.get(3);

        nodes.get(3).setLeft(nodes.get(2));
        nodes.get(3).setRight(nodes.get(5));

        nodes.get(2).setLeft(nodes.get(1));

        nodes.get(5).setLeft(nodes.get(4));

        assertTrue(tree.equals(head));
    }

    @Test
    void simpleTree6() {
        YK_BinaryTreeNode<Integer> head;
        int[] arr = {1,2,3,4,5,6};
        ArrayList<YK_BinaryTreeNode<Integer>> nodes = getNodes();

        YK_MinimalBinarySearchTree tree = new YK_MinimalBinarySearchTree(arr, false);

        head = nodes.get(4);

        nodes.get(4).setLeft(nodes.get(2));
        nodes.get(4).setRight(nodes.get(6));

        nodes.get(2).setLeft(nodes.get(1));
        nodes.get(2).setRight(nodes.get(3));

        nodes.get(6).setLeft(nodes.get(5));

        assertTrue(tree.equals(head));
    }

    @Test
    void simpleTree7() {
        YK_BinaryTreeNode<Integer> head;
        int[] arr = {1,2,3,4,5,6, 7};
        ArrayList<YK_BinaryTreeNode<Integer>> nodes = getNodes();

        YK_MinimalBinarySearchTree tree = new YK_MinimalBinarySearchTree(arr, false);

        head = nodes.get(4);

        nodes.get(4).setLeft(nodes.get(2));
        nodes.get(4).setRight(nodes.get(6));

        nodes.get(2).setLeft(nodes.get(1));
        nodes.get(2).setRight(nodes.get(3));

        nodes.get(6).setLeft(nodes.get(5));
        nodes.get(6).setRight(nodes.get(7));

        assertTrue(tree.equals(head));
    }

    @Test
    void simpleTree8() {
        YK_BinaryTreeNode<Integer> head;
        int[] arr = {1,2,3,4,5,6,7,8};
        ArrayList<YK_BinaryTreeNode<Integer>> nodes = getNodes();

        YK_MinimalBinarySearchTree tree = new YK_MinimalBinarySearchTree(arr, false);

        head = nodes.get(5);

        nodes.get(5).setLeft(nodes.get(3));
        nodes.get(5).setRight(nodes.get(7));

        nodes.get(3).setLeft(nodes.get(2));
        nodes.get(3).setRight(nodes.get(4));

        nodes.get(7).setLeft(nodes.get(6));
        nodes.get(7).setRight(nodes.get(8));

        nodes.get(2).setLeft(nodes.get(1));

        assertTrue(tree.equals(head));
    }


    @Test
    void simpleTree9() {
        YK_BinaryTreeNode<Integer> head;
        int[] arr = {1,2,3,4,5,6,7,8,9};
        ArrayList<YK_BinaryTreeNode<Integer>> nodes = getNodes();

        YK_MinimalBinarySearchTree tree = new YK_MinimalBinarySearchTree(arr, false);

        head = nodes.get(5);

        nodes.get(5).setLeft(nodes.get(3));
        nodes.get(5).setRight(nodes.get(8));

        nodes.get(3).setLeft(nodes.get(2));
        nodes.get(3).setRight(nodes.get(4));

        nodes.get(8).setLeft(nodes.get(7));
        nodes.get(8).setRight(nodes.get(9));

        nodes.get(2).setLeft(nodes.get(1));

        nodes.get(7).setLeft(nodes.get(6));

        assertTrue(tree.equals(head));
    }

    @Test
    void simpleTree10() {
        YK_BinaryTreeNode<Integer> head;
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        ArrayList<YK_BinaryTreeNode<Integer>> nodes = getNodes();

        YK_MinimalBinarySearchTree tree = new YK_MinimalBinarySearchTree(arr, false);

        head = nodes.get(6);

        nodes.get(6).setLeft(nodes.get(3));
        nodes.get(6).setRight(nodes.get(9));

        nodes.get(3).setLeft(nodes.get(2));
        nodes.get(3).setRight(nodes.get(5));

        nodes.get(9).setLeft(nodes.get(8));
        nodes.get(9).setRight(nodes.get(10));

        nodes.get(2).setLeft(nodes.get(1));

        nodes.get(5).setLeft(nodes.get(4));

        nodes.get(8).setLeft(nodes.get(7));

        assertTrue(tree.equals(head));
    }


    @Test
    void simpleTree11() {
        YK_BinaryTreeNode<Integer> head;
        int[] arr = {1,2,3,4,5,6,7,8,9,10,11};
        ArrayList<YK_BinaryTreeNode<Integer>> nodes = getNodes();

        YK_MinimalBinarySearchTree tree = new YK_MinimalBinarySearchTree(arr, false);

        head = nodes.get(6);

        nodes.get(6).setLeft(nodes.get(3));
        nodes.get(6).setRight(nodes.get(9));

        nodes.get(3).setLeft(nodes.get(2));
        nodes.get(3).setRight(nodes.get(5));

        nodes.get(9).setLeft(nodes.get(8));
        nodes.get(9).setRight(nodes.get(11));

        nodes.get(2).setLeft(nodes.get(1));

        nodes.get(5).setLeft(nodes.get(4));

        nodes.get(8).setLeft(nodes.get(7));

        nodes.get(11).setLeft(nodes.get(10));

        assertTrue(tree.equals(head));
    }


    @Test
    void simpleTree12() {
        YK_BinaryTreeNode<Integer> head;
        int[] arr = {1,2,3,4,5,6,7,8,9,10,11,12};
        ArrayList<YK_BinaryTreeNode<Integer>> nodes = getNodes();

        YK_MinimalBinarySearchTree tree = new YK_MinimalBinarySearchTree(arr, false);

        head = nodes.get(7);

        nodes.get(7).setLeft(nodes.get(4));
        nodes.get(7).setRight(nodes.get(10));

        nodes.get(4).setLeft(nodes.get(2));
        nodes.get(4).setRight(nodes.get(6));

        nodes.get(10).setLeft(nodes.get(9));
        nodes.get(10).setRight(nodes.get(12));

        nodes.get(2).setLeft(nodes.get(1));
        nodes.get(2).setRight(nodes.get(3));

        nodes.get(6).setLeft(nodes.get(5));

        nodes.get(9).setLeft(nodes.get(8));

        nodes.get(12).setLeft(nodes.get(11));


        assertTrue(tree.equals(head));
    }
}