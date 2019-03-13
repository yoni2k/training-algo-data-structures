package YK_Cracking4_TreesGraphs;

import YK_Common.YK_BinaryBFS;
import YK_Common.YK_BinaryTreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/*
Source: Cracking, p. 109, 4.3

List of depths. Given a binary tree, design an algorithm which creates a linked list of all the nodes at each depth.

Implementation: I thought by mistake one needs BFS, implemented BFS, and BFS' to do this algorithm.
Actually, whether it's BFS or DFS doesn't matter for O(), could be done with simpler DFS.

 */

public class YK_ListOfDepths {

    private class YK_PairValueLevel {
        YK_BinaryTreeNode<Integer> value;
        int level;

        YK_PairValueLevel(YK_BinaryTreeNode<Integer> value, int level) {
            this.value = value;
            this.level = level;
        }
    }

    public ArrayList<LinkedList<YK_BinaryTreeNode<Integer>>> getDepths(YK_BinaryTreeNode<Integer> head) {

        System.out.println("-------------------------------------------");
        System.out.println("In getDepths, received tree:");
        new YK_BinaryBFS(head); //for printing purposes
        System.out.println("===========================================");

        ArrayList<LinkedList<YK_BinaryTreeNode<Integer>>> depths = new ArrayList<>();

        LinkedList<YK_PairValueLevel> listToVisit = new LinkedList<>();

        listToVisit.add(new YK_PairValueLevel(head, 0));

        YK_PairValueLevel visiting;

        while(listToVisit.size() > 0) {

            visiting = listToVisit.remove();

            System.out.println("Visiting node: " + visiting.value.nodeToString());

            if((depths.size() - 1) < visiting.level) {
                depths.add(new LinkedList<>());
            }

            depths.get(visiting.level).add(visiting.value);

            if(visiting.value.getLeft() != null) {
                listToVisit.add(new YK_PairValueLevel(visiting.value.getLeft(), visiting.level + 1));
            }
            if(visiting.value.getRight() != null) {
                listToVisit.add(new YK_PairValueLevel(visiting.value.getRight(), visiting.level + 1));
            }
        }

        System.out.println("-------------------------------------------");

        int i = 1;
        for(LinkedList<YK_BinaryTreeNode<Integer>> linkedList : depths) {
            System.out.print("List level " + i + ": ");
            for(YK_BinaryTreeNode<Integer> node: linkedList) {
                System.out.println(node.get() + " ");
            }
            System.out.println();
            i++;
        }

        System.out.println("===========================================");

        return depths;
    }
}
