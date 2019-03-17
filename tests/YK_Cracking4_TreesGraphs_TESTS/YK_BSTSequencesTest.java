package YK_Cracking4_TreesGraphs_TESTS;

import YK_Common.YK_BinaryTreeNode;
import YK_Cracking4_TreesGraphs.YK_BSTSequences;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static YK_Cracking4_TreesGraphs_TESTS.YK_TESTS_TreeUtils.YK_RIGHT_LEFT.*;
import static org.junit.jupiter.api.Assertions.*;

import static YK_Cracking4_TreesGraphs_TESTS.YK_TESTS_TreeUtils.*;

class YK_BSTSequencesTest {

    @Test
    void oneNode() {
        YK_BinaryTreeNode<Integer> head = new YK_BinaryTreeNode<>(1);

        ArrayList<ArrayList<Integer>> arrayOfArraysExp = new ArrayList<>();
        arrayOfArraysExp.add(new ArrayList<>());

        arrayOfArraysExp.get(0).add(1);

        assertEquals(arrayOfArraysExp, new YK_BSTSequences().getBSTSequences(head));
    }

    private ArrayList<ArrayList<Integer>> getExpected(int [][] arrays) {
        ArrayList<ArrayList<Integer>> arrayOfArraysExp = new ArrayList<>();

        for (int [] array: arrays) {

            ArrayList<Integer> singleArray = new ArrayList<>();
            for (int single : array) {
                singleArray.add(single);
            }
            arrayOfArraysExp.add(singleArray);
        }

        return arrayOfArraysExp;
    }

    @Test
    void oneSidedLeft() {
        ArrayList<YK_BinaryTreeNode<Integer>> nodes = getBinaryTreeNodes(6);

        setConn(nodes, 5,4,YK_LEFT);
        setConn(nodes, 4,3,YK_LEFT);
        setConn(nodes, 3,2,YK_LEFT);
        setConn(nodes, 2,1,YK_LEFT);

        YK_BinaryTreeNode<Integer> head = nodes.get(5);

        int [][] arrayOfArraysExpected = new int[1][];
        arrayOfArraysExpected[0] = new int[] {5,4,3,2,1};

        ArrayList<ArrayList<Integer>> arrayListOfArraysExp = getExpected(arrayOfArraysExpected);

        assertEquals(arrayListOfArraysExp, new YK_BSTSequences().getBSTSequences(head));
    }

    @Test
    void oneSidedRight() {
        ArrayList<YK_BinaryTreeNode<Integer>> nodes = getBinaryTreeNodes(6);

        setConn(nodes, 1,2,YK_RIGHT);
        setConn(nodes, 2,3,YK_RIGHT);
        setConn(nodes, 3,4,YK_RIGHT);
        setConn(nodes, 4,5,YK_RIGHT);

        YK_BinaryTreeNode<Integer> head = nodes.get(1);

        int [][] arrayOfArraysExpected = new int[1][];
        arrayOfArraysExpected[0] = new int[] {1,2,3,4,5};

        ArrayList<ArrayList<Integer>> arrayListOfArraysExp = getExpected(arrayOfArraysExpected);

        assertEquals(arrayListOfArraysExp, new YK_BSTSequences().getBSTSequences(head));
    }

    @Test
    void twoSidedThin() {
        ArrayList<YK_BinaryTreeNode<Integer>> nodes = getBinaryTreeNodes(6);

        setConn(nodes, 3,2,YK_LEFT);
        setConn(nodes, 3,4,YK_RIGHT);

        setConn(nodes, 2,1,YK_LEFT);

        setConn(nodes, 4,5,YK_RIGHT);

        YK_BinaryTreeNode<Integer> head = nodes.get(3);

        int [][] arrayOfArraysExpected = new int[6][];
        //3, 21, 45
        arrayOfArraysExpected[0] = new int[] {3,2,1,4,5};
        arrayOfArraysExpected[1] = new int[] {3,4,5,2,1};

        arrayOfArraysExpected[2] = new int[] {3,2,4,5,1};
        arrayOfArraysExpected[3] = new int[] {3,2,4,1,5};

        arrayOfArraysExpected[4] = new int[] {3,4,2,1,5};
        arrayOfArraysExpected[5] = new int[] {3,4,2,5,1};

        ArrayList<ArrayList<Integer>> arrayListOfArraysExp = getExpected(arrayOfArraysExpected);

        assertTrue(myCompare(arrayListOfArraysExp, new YK_BSTSequences().getBSTSequences(head)));
    }


    @Test
    void twoSidedPrettyThin() {
        ArrayList<YK_BinaryTreeNode<Integer>> nodes = getBinaryTreeNodes(6);

        setConn(nodes, 3,1,YK_LEFT);
        setConn(nodes, 3,5,YK_RIGHT);

        setConn(nodes, 1,2,YK_RIGHT);

        setConn(nodes, 5,4,YK_LEFT);

        YK_BinaryTreeNode<Integer> head = nodes.get(3);

        int [][] arrayOfArraysExpected = new int[6][];
        //3, 12, 54
        arrayOfArraysExpected[0] = new int[] {3,1,2,5,4};
        arrayOfArraysExpected[1] = new int[] {3,5,4,1,2};

        arrayOfArraysExpected[2] = new int[] {3,1,5,4,2};
        arrayOfArraysExpected[3] = new int[] {3,1,5,2,4};

        arrayOfArraysExpected[4] = new int[] {3,5,1,2,4};
        arrayOfArraysExpected[5] = new int[] {3,5,1,4,2};

        ArrayList<ArrayList<Integer>> arrayListOfArraysExp = getExpected(arrayOfArraysExpected);

        assertTrue(myCompare(arrayListOfArraysExp, new YK_BSTSequences().getBSTSequences(head)));
    }

    @Test
    void full() {
        ArrayList<YK_BinaryTreeNode<Integer>> nodes = getBinaryTreeNodes(8);

        setConn(nodes, 4,2,YK_LEFT);
        setConn(nodes, 4,6,YK_RIGHT);

        setConn(nodes, 2,1,YK_LEFT);
        setConn(nodes, 2,3,YK_RIGHT);

        setConn(nodes, 6,5,YK_LEFT);
        setConn(nodes, 6,7,YK_RIGHT);

        YK_BinaryTreeNode<Integer> head = nodes.get(4);

        //not spending time putting expected Arrays - a lot of options
        assertEquals(80, new YK_BSTSequences().getBSTSequences(head).size());
    }

    private boolean myCompare(ArrayList<ArrayList<Integer>> exp, ArrayList<ArrayList<Integer>> actual) {

        System.out.println("myCompare, expected: " + exp);
        System.out.println("myCompare, actual: " + actual);

        if(exp.size() != actual.size()) {
            System.out.println("myCompare, sizes differ, exp: " + exp.size() + ", actual: " + actual.size());
            return false;
        }

        for (ArrayList<Integer> single: exp) {
            if(actual.contains(single) == false) {
                System.out.println("Following expected doesn't appear: " + single);
                return false;
            }
        }

        return true;
    }
}