package YK_Cracking17_Hard;

/*
Source: 17.12
Given a binary search tree, convert it IN PLACE to a double linked list using the same data structure (YK_Hard12Util_BiNode in this case with data, and 2 pointers)

Implementations:
- mine is recursive, pretty straightforward, O(n) - fix the nodes as we go along in DFS
- in the book a completely different approach - create 2 trees for right and left and then merge.  Also O(n) - not simpler, possibly more complicated
 */

public class YK_Hard12_ChangeBSTtoListInPlace {
    private void connect(YK_Hard12Util_BiNode n1, YK_Hard12Util_BiNode n2) {
        if(n1 != null) {
            n1.node2 = n2;
        }

        if(n2 != null) {
            n2.node1 = n1;
        }
    }

    private YK_Hard12Util_BiNode privGetOrderedList(YK_Hard12Util_BiNode node, YK_Hard12Util_BiNode prev, YK_Hard12Util_BiNode next) {
        YK_Hard12Util_BiNode left = node.node1;
        YK_Hard12Util_BiNode right = node.node2;
        YK_Hard12Util_BiNode smallest;

        if(left != null) {
            smallest = privGetOrderedList(left, prev, node);
        } else {
            connect(prev, node);
            smallest = node;
        }

        if(right != null) {
            privGetOrderedList(right, node, next);
        } else {
            connect(node, next);
        }

        return smallest;
    }

    public YK_Hard12Util_BiNode getOrderedList(YK_Hard12Util_BiNode head) {
        return privGetOrderedList(head, null, null);
    }
}
