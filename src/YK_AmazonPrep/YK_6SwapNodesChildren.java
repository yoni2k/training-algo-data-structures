package YK_AmazonPrep;

import java.util.ArrayList;
import java.util.LinkedList;

/*
Build a tree using indexes of children in BFS order with -1 meaning to children

Given a k, swap on a given tree all children of levels of multiples of k
 */

public class YK_6SwapNodesChildren {

    class Node {
        int value;
        int level;
        Node left = null;
        Node right = null;

        Node(int value, int level) {
            this.value = value;
            this.level = level;
        }

        void swap() {
            Node tmp = left;
            left = right;
            right = tmp;
        }

        void swap(int levelMultToSwap) {
            if((level % levelMultToSwap) == 0) {
                swap();
            }
            if(left != null) {
                left.swap(levelMultToSwap);
            }
            if(right != null) {
                right.swap(levelMultToSwap);
            }
        }

        void DFS_InOrder(ArrayList<Integer> arr) {
            if(left != null) {
                left.DFS_InOrder(arr);
            }
            arr.add(value);
            if(right != null) {
                right.DFS_InOrder(arr);
            }
        }
    }

    public int[][] swapNodes(int[][] indexesNextChildrenBFS, int[] queries) {

        Node root = new Node(1, 1);
        LinkedList<Node> nodes = new LinkedList<>();
        nodes.add(root);
        Node cur;

        for(int[] pair : indexesNextChildrenBFS) {
            cur = nodes.remove();
            if(pair[0] != -1) {
                cur.left = new Node(pair[0], cur.level + 1);
                nodes.add(cur.left);
            }
            if(pair[1] != -1) {
                cur.right = new Node(pair[1], cur.level + 1);
                nodes.add(cur.right);
            }
        }

        int[][] arrResults = new int[queries.length][];
        ArrayList<Integer> arr;

        for(int i = 0; i < queries.length; i++) {
            root.swap(queries[i]);
            arr = new ArrayList<>();
            root.DFS_InOrder(arr);

            arrResults[i] = new int[arr.size()];

            for(int j = 0; j < arr.size(); j++) {
                arrResults[i][j] = arr.get(j);
            }
        }

        return arrResults;
    }

}
