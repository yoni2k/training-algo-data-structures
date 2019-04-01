package YK_AmazonPrep;

/*
Given the root, print the values of the tree in Level Order - BFS
 */

import YK_Common.YK_BinaryTreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

public class YK_2LevelOrderTraversal {

    public static int[] levelOrder(YK_BinaryTreeNode root) {

        LinkedList<YK_BinaryTreeNode> arr = new LinkedList<>();
        ArrayList<Integer> results = new ArrayList<>();
        YK_BinaryTreeNode node;

        arr.add(root);

        while(arr.size() > 0) {
            node = arr.remove();
            results.add((Integer) node.get());
            if (node.getLeft() != null) {
                arr.add(node.getLeft());
            }
            if (node.getRight() != null) {
                arr.add(node.getRight());
            }
        }

        int[] resInts = new int[results.size()];

        for(int i = 0; i < results.size(); i++) {
            resInts[i] = results.get(i);
        }

        return resInts;
    }

}
