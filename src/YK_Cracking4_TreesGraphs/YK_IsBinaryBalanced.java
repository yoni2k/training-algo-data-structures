package YK_Cracking4_TreesGraphs;

import YK_Common.YK_BinaryBFS;
import YK_Common.YK_BinaryTreeNode;

/*
Source: Cracking p.110, 4.4 - Check balanced.

Implement a function to check if a tree is balanced (each nodes's two sub-trees can't be more than 1 diff in depth).
My implementation is slightly different:
It always returns max depth as a bonus, a bit longer but clearer than the book
 */

public class YK_IsBinaryBalanced {

    private class YK_BalancedAns {
        boolean isBalanced;
        int depth;

        YK_BalancedAns(boolean isBalanced, int depth) {
            this.isBalanced = isBalanced;
            this.depth = depth;
        }

        public String toString()
        {
            return "isBalanced: " + isBalanced + ", depth: " + depth;
        }
    }

    private YK_BalancedAns isBalancedPrivate(YK_BinaryTreeNode<Integer> head) {
        if (head == null) {
            return new YK_BalancedAns(true, 0);
        }

        YK_BalancedAns leftAns = isBalancedPrivate(head.getLeft());
        YK_BalancedAns rightAns = isBalancedPrivate(head.getRight());

        System.out.println("Checking node: " + head.get() + ", left: " + leftAns + ", right: " + rightAns);

        int newDepth = Math.max(leftAns.depth, rightAns.depth) + 1;

        if(     (leftAns.isBalanced == false) ||
                (rightAns.isBalanced == false) ||
                ((leftAns.depth > rightAns.depth) && (leftAns.depth > (rightAns.depth+1))) ||
                ((leftAns.depth < rightAns.depth) && ((leftAns.depth + 1) < rightAns.depth))) {
            return new YK_BalancedAns(false, newDepth);
        }

        return new YK_BalancedAns(true, newDepth);
    }

    public boolean isBalanced(YK_BinaryTreeNode<Integer> head) {
        System.out.println("--------------------------------------");
        System.out.println("Start YK_IsBinaryBalanced");
        new YK_BinaryBFS<>(head);

        YK_BalancedAns answerPair = isBalancedPrivate(head);

        System.out.println("End YK_IsBinaryBalanced, balanced: " + answerPair);
        new YK_BinaryBFS<>(head);
        System.out.println("======================================");

        return  answerPair.isBalanced;
    }
}
