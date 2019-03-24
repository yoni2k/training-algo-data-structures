package YK_Cracking4_TreesGraphs;

import YK_Common.YK_BinaryTreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class YK_ListOfDepthsTest {

    @Test
    void tree1() {
        int[] arr1 = {1};
        YK_BinaryTreeNode<Integer> head = new YK_MinimalBinarySearchTree(arr1, true).getHead();

        ArrayList<LinkedList<YK_BinaryTreeNode<Integer>>> expDepths = new ArrayList<>();

        LinkedList<YK_BinaryTreeNode<Integer>> list1 = new LinkedList<>();
        expDepths.add(list1);
        list1.add(new YK_BinaryTreeNode<>(1,null,null));

        assertEquals(expDepths, new YK_ListOfDepths().getDepths(head));
    }

    private ArrayList<YK_BinaryTreeNode<Integer>> getNodes() {
        ArrayList<YK_BinaryTreeNode<Integer>> nodes = new ArrayList<>();

        for(int i = 0; i <= 20; i++) {
            nodes.add(new YK_BinaryTreeNode<>(i));
        }

        return nodes;
    }

    @Test
    void tree12() {
        int[] arr = {1,2,3,4,5,6,7,8,9,10,11,12};
        YK_BinaryTreeNode<Integer> head = new YK_MinimalBinarySearchTree(arr, true).getHead();

        ArrayList<LinkedList<YK_BinaryTreeNode<Integer>>> expDepths = new ArrayList<>();

        LinkedList<YK_BinaryTreeNode<Integer>> list1 = new LinkedList<>();
        expDepths.add(list1);

        LinkedList<YK_BinaryTreeNode<Integer>> list2 = new LinkedList<>();
        expDepths.add(list2);

        LinkedList<YK_BinaryTreeNode<Integer>> list3 = new LinkedList<>();
        expDepths.add(list3);

        LinkedList<YK_BinaryTreeNode<Integer>> list4 = new LinkedList<>();
        expDepths.add(list4);

        ArrayList<YK_BinaryTreeNode<Integer>> nodes = getNodes();

        nodes.get(8).setLeft(nodes.get(4));
        nodes.get(8).setRight(nodes.get(11));

        list1.add(nodes.get(8));

        nodes.get(4).setLeft(nodes.get(2));
        nodes.get(4).setRight(nodes.get(6));

        nodes.get(11).setLeft(nodes.get(10));
        nodes.get(11).setRight(nodes.get(12));

        list2.add(nodes.get(4));
        list2.add(nodes.get(11));

        nodes.get(2).setLeft(nodes.get(1));
        nodes.get(2).setRight(nodes.get(3));

        nodes.get(6).setLeft(nodes.get(5));
        nodes.get(6).setRight(nodes.get(7));

        nodes.get(10).setLeft(nodes.get(9));

        list3.add(nodes.get(2));
        list3.add(nodes.get(6));
        list3.add(nodes.get(10));
        list3.add(nodes.get(12));

        list4.add(nodes.get(1));
        list4.add(nodes.get(3));
        list4.add(nodes.get(5));
        list4.add(nodes.get(7));
        list4.add(nodes.get(9));

        assertEquals(expDepths, new YK_ListOfDepths().getDepths(head));
    }
}