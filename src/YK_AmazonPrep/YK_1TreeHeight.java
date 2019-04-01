package YK_AmazonPrep;

/*
Get height of a binary tree.  Root only - 0, etc.
 */

import YK_Common.YK_BinaryTreeNode;
import org.w3c.dom.Node;

public class YK_1TreeHeight {

    private static int getHeight(YK_BinaryTreeNode node, int height) {
        int newHeight = height;

        if (node.getLeft() != null) {
            newHeight = getHeight(node.getLeft(), height + 1);
        }
        if (node.getRight() != null) {
            newHeight = Math.max(newHeight, getHeight(node.getRight(), height + 1));
        }

        return newHeight;
    }

    public static int getHeight(YK_BinaryTreeNode root) {
        return getHeight(root, 0);
    }
}
