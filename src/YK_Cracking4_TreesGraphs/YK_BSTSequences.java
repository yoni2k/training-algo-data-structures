package YK_Cracking4_TreesGraphs;

import YK_Common.YK_BinaryTreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

/*
Source: Cracking, p.110, 4.9

BST Sequences
Given a binary search tree, return all arrays whose reading could have created these.

I implemented with ArrayList<ArrayList<Integer>>.  In the book it's with ArrayList<LinedList<Integer>>.
Committing with ArrayList<ArrayList<Integer>> and then will change to ArrayList<LinedList<Integer>>
 */

public class YK_BSTSequences {

    private ArrayList<LinkedList<Integer>> getSinglePerm(LinkedList<Integer> list1, LinkedList<Integer> list2) {

        System.out.println("Start getSinglePerm - list1: " + list1 + ", list2: " + list2);

        ArrayList<LinkedList<Integer>> resultArrayOfArrays = new ArrayList<>();

        if (list1.size() == 0) {
            resultArrayOfArrays.add(new LinkedList<>(list2));
            System.out.println("getSinglePerm, list1.size() is 0, returning: " + resultArrayOfArrays);
            return resultArrayOfArrays;
        }
        if (list2.size() == 0) {
            resultArrayOfArrays.add(new LinkedList<>(list1));
            System.out.println("getSinglePerm, list2.size() is 0, returning: " + resultArrayOfArrays);
            return resultArrayOfArrays;
        }

        Integer intRemoved;
        ArrayList<LinkedList<Integer>> recurseResult;

        intRemoved = list1.get(0);
        System.out.println("intRemoved from list1: " + intRemoved + ", list1: " + list1 + ", list2: " + list2);
        recurseResult = getSinglePerm(new LinkedList<>(list1.subList(1, list1.size())), list2);
        for(LinkedList<Integer> singleArray : recurseResult) {
            singleArray.add(0, intRemoved);
        }
        resultArrayOfArrays.addAll(recurseResult);

        intRemoved = list2.get(0);
        System.out.println("intRemoved from list2: " + intRemoved + ", list1: " + list1 + ", list2: " + list2);
        recurseResult = getSinglePerm(list1,new LinkedList<>(list2.subList(1, list2.size())));
        for(LinkedList<Integer> singleArray : recurseResult) {
            singleArray.add(0, intRemoved);
        }
        resultArrayOfArrays.addAll(recurseResult);

        return resultArrayOfArrays;
    }

    private ArrayList<LinkedList<Integer>> getPerm(ArrayList<LinkedList<Integer>> arrayArrays1, ArrayList<LinkedList<Integer>> arrayArrays2) {

        if (arrayArrays1.size() == 0) return arrayArrays2;
        if (arrayArrays2.size() == 0) return arrayArrays1;

        ArrayList<LinkedList<Integer>> resultArrayOfArrays = new ArrayList<>();

        for(LinkedList<Integer> single1: arrayArrays1) {
            for(LinkedList<Integer> single2: arrayArrays2) {
                resultArrayOfArrays.addAll(getSinglePerm(single1, single2));
            }
        }

        return resultArrayOfArrays;
    }

    private ArrayList<LinkedList<Integer>> privateRecGetBSTSequences(YK_BinaryTreeNode<Integer> head) {

        if (head == null) return new ArrayList<>();

        ArrayList<LinkedList<Integer>> leftArrayOfArrays = privateRecGetBSTSequences(head.getLeft());
        ArrayList<LinkedList<Integer>> rightArrayOfArrays = privateRecGetBSTSequences(head.getRight());

        ArrayList<LinkedList<Integer>> resultArrayOfArrays = getPerm(leftArrayOfArrays, rightArrayOfArrays);

        if (resultArrayOfArrays.size() == 0) {
            LinkedList<Integer> singleArray = new LinkedList<>();
            singleArray.add(head.get());

            resultArrayOfArrays.add(singleArray);
            return resultArrayOfArrays;
        }

        for(LinkedList<Integer> singleArray : resultArrayOfArrays) {
            singleArray.add(0,head.get());
        }

        return resultArrayOfArrays;
    }


    public ArrayList<LinkedList<Integer>> getBSTSequences(YK_BinaryTreeNode<Integer> head) {

        ArrayList<LinkedList<Integer>> result = privateRecGetBSTSequences(head);

        int i = 0;
        for(LinkedList<Integer> singleList: result) {
            System.out.println("End getBSTSequences - Permutation " + (i++) + ": " + singleList);
        }

        return result;
    }
}
