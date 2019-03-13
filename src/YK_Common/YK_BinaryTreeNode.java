package YK_Common;

public class YK_BinaryTreeNode<E> {

    private E value;
    private YK_BinaryTreeNode<E> left;
    private YK_BinaryTreeNode<E> right;

    public YK_BinaryTreeNode() {
        this.value = null;
        left = null;
        right = null;
    }

    public YK_BinaryTreeNode(E value) {
        this.value = value;
        left = null;
        right = null;
    }

    public YK_BinaryTreeNode(E value, YK_BinaryTreeNode<E> left, YK_BinaryTreeNode<E> right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public void set(E value) {
        this.value = value;
    }

    public E get() {
        return value;
    }

    public void setLeft(YK_BinaryTreeNode<E> left) {
        this.left = left;
    }

    public YK_BinaryTreeNode<E> getLeft() {
        return left;
    }

    public void setRight(YK_BinaryTreeNode<E> right) {
        this.right = right;
    }

    public YK_BinaryTreeNode<E> getRight() {
        return right;
    }

    public String nodeToString() {
        String str = "Value: " + value + ", Left: ";
        str += ((left == null) ? "Null" : left.value);
        str += ", Right: ";
        str += ((right == null) ? "Null" : right.value);

        return str;
    }

    public String treeToString() {
        String str = this.nodeToString();
        str += (left != null) ? ("\n" + left.treeToString()) : "";
        str += (right != null) ? ("\n" + right.treeToString()) : "";

        return str;
    }

    public boolean equals(YK_BinaryTreeNode<E> obj) {

        if(
                (obj.value != this.value) ||
                        ((obj.right == null) & (this.right != null)) ||
                                ((obj.right != null) & (this.right == null)) ||
                                        ((obj.left == null) & (this.left != null)) ||
                                                ((obj.left != null) & (this.left == null))
        ) {
            return false;
        }

        if (obj.left != null)
            if(this.left.equals(obj.left) == false) return false;

        if (obj.right != null)
            if(this.right.equals(obj.right) == false) return false;

        return true;
    }
}