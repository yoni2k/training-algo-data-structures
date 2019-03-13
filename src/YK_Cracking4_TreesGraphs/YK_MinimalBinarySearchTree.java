package YK_Cracking4_TreesGraphs;

import YK_Common.YK_BinaryTreeNode;

import java.util.Arrays;

/*
Source: Cracking p.109, 4.2
Minimal tree - Given a sorted increasing order integer array, write an algorithm to create a binary search tree with minimal height.

Implementation:
I overkilled it by creating a complete tree. (Bottom nodes are always full from the left.)
That's very tricky because of split up function (powers of 2 etc.).
However, it's not necessary to have a complete tree to have a minimal height. Splitting exactly in the middle also gives that.

Implementation below has both options.
 */

public class YK_MinimalBinarySearchTree {

    private YK_BinaryTreeNode<Integer> head;

    private int getRootIndexSimple(int arrayLen) {
        return arrayLen/2;
    }

    private int getRootIndexComplete(int arrayLen) {

        int numToSplit = arrayLen - 1;
        int k = 0;
        int indexToSplitBy;

        if(arrayLen == 1) {
            System.out.println("getRootIndex: Got arrayLen 1, return 0");
            return 0;
        }

        System.out.println("getRootIndex: splitting up index: " + arrayLen + ", numToSplit: " + numToSplit);

        /* Rule: Every full "half" is 2^N - 1, so there are 2 of 2^N - 1 and root node + 1 = 2^(N+1)-1.
            To make things simpler, we disregard root node and work with numToSplit.
            find a split that's 1st that's too big to have a complete 2 parts of the tree
         */
        while(((Math.pow(2,k) - 1) * 2) < numToSplit) {
            k++;
        }

        k--;

        /* Left tree is either same or bigger than right to make the tree complete.
            So there are 2 options:
            1. Left is complete with 2^(K+1) - 1 nodes and right is (2^K - 1) + leftovers if there are any
            2. Both right and left are 2^K - 1, with leftovers are in left.
        */

        System.out.println("getRootIndex: Last k that fits: " + k + ", 2 * Math.pow(2,k) - 2: " + (2 * Math.pow(2,k) - 2)  + ", Math.pow(2,k+1) + Math.pow(2,k) - 2: " + (Math.pow(2,k+1) + Math.pow(2,k) - 2) +", splitting up index: " + arrayLen + ", numToSplit: " + numToSplit);

        if((Math.pow(2,k+1) + Math.pow(2,k) - 2) <= numToSplit) {
            indexToSplitBy = (int)Math.pow(2,k+1) - 1;
            System.out.println("getRootIndex: Option 1: indexToSplitBy: " + indexToSplitBy + ", Math.pow(2,k) - 1: " + (Math.pow(2,k) - 1)  + ", Math.pow(2,k+1) - 1: " + (Math.pow(2,k+1) - 1) + ", splitting up index: " + arrayLen + ", numToSplit: " + numToSplit);
        }
        else { //option 2
            indexToSplitBy = (numToSplit - ((int)Math.pow(2,k) - 1));
            System.out.println("getRootIndex: Option 2: indexToSplitBy: " + indexToSplitBy + ", Math.pow(2,k) - 1: " + (Math.pow(2,k) - 1)  + ", Math.pow(2,k+1) - 1: " + (Math.pow(2,k+1) - 1) + ", splitting up index: " + arrayLen + ", numToSplit: " + numToSplit);
        }

        return indexToSplitBy;
    }

    private YK_BinaryTreeNode<Integer> createTreeRec(int[] array, int from, int to, boolean isComplete) {

        System.out.println("In createTreeRec, isComplete: " + isComplete + ", from: " + from + ", to: " + to + ", array: " + Arrays.toString(array));

        if (to <= from) {
            return null;
        }

        int rootIndex = from + (isComplete
                ? getRootIndexComplete(to - from)
                : getRootIndexSimple(to - from));

        YK_BinaryTreeNode<Integer> node = new YK_BinaryTreeNode<>(array[rootIndex]);
        node.setLeft(createTreeRec(array, from, rootIndex, isComplete));
        node.setRight(createTreeRec(array, rootIndex + 1, to, isComplete));

        return node;
    }

    public YK_MinimalBinarySearchTree(int[] arr, boolean isComplete) {

        System.out.println("Start YK_MinimalBinarySearchTree, isComplete: " + isComplete + ", arr: " + Arrays.toString(arr));

        head = createTreeRec(arr, 0, arr.length, isComplete);

        System.out.println("---------------------------------------------");
        System.out.println("End YK_MinimalBinarySearchTree, isComplete: " + isComplete + ", arr: " + Arrays.toString(arr) + ", tree: ");
        System.out.println(head.treeToString());
        System.out.println("=============================================");
    }

    public boolean equals(YK_BinaryTreeNode<Integer> other) {
        return head.equals(other);
    }
}
