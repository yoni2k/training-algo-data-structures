package YK_Cracking4_TreesGraphs_TESTS;

import YK_Common.YK_BinaryTreeNode;

import java.util.ArrayList;

public class YK_TESTS_TreeUtils {

    enum YK_RIGHT_LEFT {YK_RIGHT, YK_LEFT}

    public static ArrayList<YK_BinaryTreeNode<Integer>> getBinaryTreeNodes(int num) {
        ArrayList<YK_BinaryTreeNode<Integer>> nodes = new ArrayList<>();

        for(int i = 0; i <= num; i++) {
            nodes.add(new YK_BinaryTreeNode<>(i));
        }

        return nodes;
    }

    public static void setConn(ArrayList<YK_BinaryTreeNode<Integer>> nodes, int from, int to, YK_RIGHT_LEFT direction) {

        if ((direction == YK_RIGHT_LEFT.YK_RIGHT)) {
            nodes.get(from).setRight(nodes.get(to));
        } else {
            nodes.get(from).setLeft(nodes.get(to));
        }
    }
}
