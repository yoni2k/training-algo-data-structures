package YK_Common;

import java.util.LinkedList;

public class YK_BinaryBFS<E> {

    public YK_BinaryBFS(YK_BinaryTreeNode<E> head) {
        LinkedList<YK_BinaryTreeNode<E>> listToVisit = new LinkedList<>();

        listToVisit.add(head);

        YK_BinaryTreeNode<E> visiting;

        while(listToVisit.size() > 0) {

            visiting = listToVisit.remove();

            System.out.println("Visiting node: " + visiting.nodeToString());

            if(visiting.getLeft() != null) listToVisit.add(visiting.getLeft());
            if(visiting.getRight() != null) listToVisit.add(visiting.getRight());
        }
    }
}
