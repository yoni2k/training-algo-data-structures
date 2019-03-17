package YK_Cracking4_TreesGraphs;

import YK_Common.YK_BinaryTreeNode;

import java.util.ArrayList;

/*
Source: Cracking, p.110, 4.9

BST Sequences
Given a binary search tree, return all arrays whose reading could have created these.

I implemented with ArrayList<ArrayList<Integer>>.  In the book it's with ArrayList<LinedList<Integer>>.
Committing with ArrayList<ArrayList<Integer>> and then will change to ArrayList<LinedList<Integer>>
 */

public class YK_BSTSequences {

    private ArrayList<ArrayList<Integer>> getSinglePerm(ArrayList<Integer> array1, ArrayList<Integer> array2) {

        System.out.println("Start getSinglePerm - array1: " + array1 + ", array2: " + array2);

        ArrayList<ArrayList<Integer>> resultArrayOfArrays = new ArrayList<>();

        if (array1.size() == 0) {
            resultArrayOfArrays.add(new ArrayList<>(array2));
            System.out.println("getSinglePerm, array1.size() is 0, returning: " + resultArrayOfArrays);
            return resultArrayOfArrays;
        }
        if (array2.size() == 0) {
            resultArrayOfArrays.add(new ArrayList<>(array1));
            System.out.println("getSinglePerm, array2.size() is 0, returning: " + resultArrayOfArrays);
            return resultArrayOfArrays;
        }

        Integer intRemoved;
        ArrayList<ArrayList<Integer>> recurseResult;

        intRemoved = array1.get(0);
        System.out.println("intRemoved from array1: " + intRemoved + ", array1: " + array1 + ", array2: " + array2);
        recurseResult = getSinglePerm(new ArrayList<>(array1.subList(1, array1.size())), array2);
        for(ArrayList<Integer> singleArray : recurseResult) {
            singleArray.add(0, intRemoved);
        }
        resultArrayOfArrays.addAll(recurseResult);

        intRemoved = array2.get(0);
        System.out.println("intRemoved from array2: " + intRemoved + ", array1: " + array1 + ", array2: " + array2);
        recurseResult = getSinglePerm(array1,new ArrayList<>(array2.subList(1, array2.size())));
        for(ArrayList<Integer> singleArray : recurseResult) {
            singleArray.add(0, intRemoved);
        }
        resultArrayOfArrays.addAll(recurseResult);

        return resultArrayOfArrays;
    }

    private ArrayList<ArrayList<Integer>> getPerm(ArrayList<ArrayList<Integer>> arrayArrays1, ArrayList<ArrayList<Integer>> arrayArrays2) {

        if (arrayArrays1.size() == 0) return arrayArrays2;
        if (arrayArrays2.size() == 0) return arrayArrays1;

        ArrayList<ArrayList<Integer>> resultArrayOfArrays = new ArrayList<>();

        for(ArrayList<Integer> single1: arrayArrays1) {
            for(ArrayList<Integer> single2: arrayArrays2) {
                resultArrayOfArrays.addAll(getSinglePerm(single1, single2));
            }
        }

        return resultArrayOfArrays;
    }

    private ArrayList<ArrayList<Integer>> privateRecGetBSTSequences(YK_BinaryTreeNode<Integer> head) {

        if (head == null) return new ArrayList<>();

        ArrayList<ArrayList<Integer>> leftArrayOfArrays = privateRecGetBSTSequences(head.getLeft());
        ArrayList<ArrayList<Integer>> rightArrayOfArrays = privateRecGetBSTSequences(head.getRight());

        ArrayList<ArrayList<Integer>> resultArrayOfArrays = getPerm(leftArrayOfArrays, rightArrayOfArrays);

        if (resultArrayOfArrays.size() == 0) {
            ArrayList<Integer> singleArray = new ArrayList<>();
            singleArray.add(head.get());

            resultArrayOfArrays.add(singleArray);
            return resultArrayOfArrays;
        }

        for(ArrayList<Integer> singleArray : resultArrayOfArrays) {
            singleArray.add(0,head.get());
        }

        return resultArrayOfArrays;
    }


    public ArrayList<ArrayList<Integer>> getBSTSequences(YK_BinaryTreeNode<Integer> head) {

        ArrayList<ArrayList<Integer>> result = privateRecGetBSTSequences(head);

        int i = 0;
        for(ArrayList<Integer> singleList: result) {
            System.out.println("End getBSTSequences - Permutation " + (i++) + ": " + singleList);
        }

        return result;
    }
}
