package YK_AmazonPrep;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class YK_6SwapNodesChildrenTest {

    @Test
    void swapTree0() {
        int[][] indexesNextChildrenBFS = {{2,3},{-1,-1},{-1,-1}};
        int[] queries = {1,1};

        int[][] expTrees = {{3,1,2},{2,1,3}};

        assertTrue(Arrays.deepEquals(expTrees, new YK_6SwapNodesChildren().swapNodes(indexesNextChildrenBFS, queries)));
    }

    @Test
    void swapTree1() {
        int[][] indexesNextChildrenBFS = {{2,3},{-1,4},{-1,5},{-1,-1},{-1,-1}};
        int[] queries = {2};

        int[][] expTrees = {{4,2,1,5,3}};

        assertTrue(Arrays.deepEquals(expTrees, new YK_6SwapNodesChildren().swapNodes(indexesNextChildrenBFS, queries)));
    }

    @Test
    void swapTree2() {
        int[][] indexesNextChildrenBFS = {
                {2,3},
                {4,-1},
                {5,-1},
                {6,-1},
                {7,8},
                {-1,9},
                {-1,-1},
                {10,11},
                {-1,-1},
                {-1,-1},
                {-1,-1}};
        int[] queries = {2,4};

        int[][] expTrees = {{2,9,6,4,1,3,7,5,11,8,10},
                            {2,6,9,4,1,3,7,5,10,8,11}};

        assertTrue(Arrays.deepEquals(expTrees, new YK_6SwapNodesChildren().swapNodes(indexesNextChildrenBFS, queries)));
    }

}