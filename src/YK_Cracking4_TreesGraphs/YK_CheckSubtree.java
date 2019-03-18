package YK_Cracking4_TreesGraphs;

import YK_Common.YK_BinaryTreeNode;

/*
Source: Cracking p.111 4.10

Check subtree, given T1 and T2 heads of 2 trees, check if T2 is a sub-tree of T1.
Can't assume unique values/nodes.

Doing a recursive approach, there is a simpler but more expensive O-wise non-recursive solution in the book.

 */

public class YK_CheckSubtree {

    private boolean areTreesEqual(YK_BinaryTreeNode <Integer> t1, YK_BinaryTreeNode <Integer> t2) {

        if((t1 == null) && (t2 == null)) return true;

        if((t1 == null) || (t2 == null)) return false;

        if(t1.get().equals(t2.get()) == false) return false;

        if(areTreesEqual(t1.getLeft(), t2.getLeft()) == false) return false;

        if(areTreesEqual(t1.getRight(), t2.getRight()) == false) return false;

        return true;
    }

    public boolean isSubtree(YK_BinaryTreeNode <Integer> t1, YK_BinaryTreeNode <Integer> t2) {

        if((t1 == null) && (t2 == null)) return true;

        if((t1 == null) || (t2 == null)) return false;

        if(t1.get().equals(t2.get())) {
            if(areTreesEqual(t1, t2)) return true;
        }

        if(isSubtree(t1.getLeft(), t2)) return true;

        if(isSubtree(t1.getRight(), t2)) return true;

        return false;
    }
}
