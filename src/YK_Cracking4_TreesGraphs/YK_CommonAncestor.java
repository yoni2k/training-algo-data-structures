package YK_Cracking4_TreesGraphs;

import YK_Common.YK_BinaryTreeNode;

/* Source: Cracking, p.110, 4.8

First common ancestor: given head of a binary tree (not necessarily ordered/balanced), and given child doesn't have
pointer to father (book has solutions for this also), find the first common ancestor.

Implementation notes:
My solution is a bit longer / trickier, but in my opinion both
- slightly (not by O) more efficient (we are not looking for what was already found),
- and clearer since I don't use same parameter to signal many different things.
 */

public class YK_CommonAncestor {

    private class YK_Ancestor {
        YK_BinaryTreeNode<Integer> ancestor;
        boolean bFirstFound;
        boolean bSecondFound;

        YK_Ancestor(    YK_BinaryTreeNode<Integer> ancestor,
                        boolean bFirstFound,
                        boolean bSecondFound) {
            this.ancestor = ancestor;
            this.bFirstFound = bFirstFound;
            this.bSecondFound = bSecondFound;
        }
    }

    private YK_Ancestor mergeAncestors(YK_BinaryTreeNode<Integer> thisNode, YK_Ancestor first, YK_Ancestor second) {
        YK_BinaryTreeNode<Integer> ancestor = first.ancestor;

        if((ancestor == null) && (second.ancestor != null)) ancestor = second.ancestor;

        if (	(ancestor == null) &&
                (first.bFirstFound || second.bFirstFound) &&
                (first.bSecondFound || second.bSecondFound)) {
            ancestor = thisNode;
        }

        return new YK_Ancestor(	ancestor,
                first.bFirstFound || second.bFirstFound,
                first.bSecondFound || second.bSecondFound);
    }

    private YK_Ancestor handleThis(YK_BinaryTreeNode<Integer> thisNode, YK_BinaryTreeNode<Integer> first, YK_BinaryTreeNode<Integer> second) {
        YK_BinaryTreeNode<Integer> ancestor = null;
        boolean bFirstFound = false;
        boolean bSecondFound = false;

        if((first != null) && (thisNode.equals(first))) bFirstFound = true;

        if((second != null) && (thisNode.equals(second))) bSecondFound = true;

        if (bFirstFound && bSecondFound) ancestor = thisNode;

        return new YK_Ancestor(ancestor, bFirstFound, bSecondFound);
    }

    private YK_Ancestor getAncestor(YK_BinaryTreeNode<Integer> head,
                                    YK_BinaryTreeNode<Integer> first,
                                    YK_BinaryTreeNode<Integer> second) {

        if (head == null)
            return new YK_Ancestor(null, false, false);

        System.out.println("Start PRIVATE getAncestor - first: [" + first + "], second: [" + second + "], tree: ");
        System.out.println(head.treeToString());

        YK_Ancestor anc_this;
        YK_Ancestor anc_temp;

        anc_this = handleThis(head, first, second);

        if(anc_this.ancestor == null) {

            //handle left tree
            anc_temp = getAncestor(head.getLeft(),
                    (anc_this.bFirstFound ? null : first),
                    (anc_this.bSecondFound ? null : second));

            anc_this = mergeAncestors(head, anc_this, anc_temp);
            if (anc_this.ancestor == null) {

                //handle right tree
                anc_temp = getAncestor(head.getRight(),
                        (anc_this.bFirstFound ? null : first),
                        (anc_this.bSecondFound ? null : second));
                anc_this = mergeAncestors(head, anc_this, anc_temp);
            }
        }

        System.out.println("End PRIVATE getAncestor - first: [" + first + "], second: [" + second + "], tree: ");
        System.out.println(head.treeToString());
        System.out.println("End PRIVATE getAncestor - returning ancestor: " + anc_this.ancestor + ", 1st found: " + anc_this.bFirstFound + ", 2nd found: " + anc_this.bSecondFound);

        return anc_this;
    }

    public YK_BinaryTreeNode<Integer> getCommonAncestor(YK_BinaryTreeNode<Integer> head,
                                                        YK_BinaryTreeNode<Integer> first,
                                                        YK_BinaryTreeNode<Integer> second) {

        System.out.println("Start getCommonAncestor - first: [" + first + "], second: [" + second + "], tree: ");
        System.out.println(head.treeToString());

        YK_Ancestor ancestor = getAncestor(head, first, second);

        if (ancestor.ancestor == null) {
            System.out.println("End getCommonAncestor - ancestor null, first: [" + first + "], second: [" + second + "], tree: ");
            System.out.println(head.treeToString());
        }
        else {
            System.out.println("End getCommonAncestor - ancestor: " + ancestor.ancestor.get() + " +, first: " + first.get() + ", second: " + second + ", tree: ");
            System.out.println(head.treeToString());
        }

        return ancestor.ancestor;
    }
}
