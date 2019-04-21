package YK_Cracking16_Moderate;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class YK_Mod17_MaxSumSubArrayTest {

    @Test
    void array1member() {
        int[] arr = {1};

        assertEquals(1, new YK_Mod17_MaxSumSubArray().getMaxSumSubArray(arr));
    }

    @Test
    void negative() {
        int[] arr = {-3,-2,-1,-2,-3};

        assertEquals(-1, new YK_Mod17_MaxSumSubArray().getMaxSumSubArray(arr));
    }

    @Test
    void full() {
        int[] arr = {1,2,3};

        assertEquals(6, new YK_Mod17_MaxSumSubArray().getMaxSumSubArray(arr));
    }

    @Test
    void first() {
        int[] arr = {5,-2,-2};

        assertEquals(5, new YK_Mod17_MaxSumSubArray().getMaxSumSubArray(arr));
    }

    @Test
    void last() {
        int[] arr = {-2,-2,5};

        assertEquals(5, new YK_Mod17_MaxSumSubArray().getMaxSumSubArray(arr));
    }

    @Test
    void middle1() {
        int[] arr = {-2,5,-2};

        assertEquals(5, new YK_Mod17_MaxSumSubArray().getMaxSumSubArray(arr));
    }

    @Test
    void middle2cons() {
        int[] arr = {-2,5,5,-2};

        assertEquals(10, new YK_Mod17_MaxSumSubArray().getMaxSumSubArray(arr));
    }

    @Test
    void middleNonCons() {
        int[] arr = {-2,5,-1,5,-2};

        assertEquals(9, new YK_Mod17_MaxSumSubArray().getMaxSumSubArray(arr));
    }

    @Test
    void startNonCons() {
        int[] arr = {5,-1,5,-2};

        assertEquals(9, new YK_Mod17_MaxSumSubArray().getMaxSumSubArray(arr));
    }

    @Test
    void endNonCons() {
        int[] arr = {-2,5,-1,5};

        assertEquals(9, new YK_Mod17_MaxSumSubArray().getMaxSumSubArray(arr));
    }

    @Test
    void array1memberIter() {
        int[] arr = {1};

        assertEquals(1, new YK_Mod17_MaxSumSubArray().getMaxSumSubArrayIter(arr));
    }

    @Test
    void negativeIter() {
        int[] arr = {-3,-2,-1,-2,-3};

        assertEquals(-1, new YK_Mod17_MaxSumSubArray().getMaxSumSubArrayIter(arr));
    }

    @Test
    void fullIter() {
        int[] arr = {1,2,3};

        assertEquals(6, new YK_Mod17_MaxSumSubArray().getMaxSumSubArrayIter(arr));
    }

    @Test
    void firstIter() {
        int[] arr = {5,-2,-2};

        assertEquals(5, new YK_Mod17_MaxSumSubArray().getMaxSumSubArrayIter(arr));
    }

    @Test
    void lastIter() {
        int[] arr = {-2,-2,5};

        assertEquals(5, new YK_Mod17_MaxSumSubArray().getMaxSumSubArrayIter(arr));
    }

    @Test
    void middle1Iter() {
        int[] arr = {-2,5,-2};

        assertEquals(5, new YK_Mod17_MaxSumSubArray().getMaxSumSubArrayIter(arr));
    }

    @Test
    void middle2consIter() {
        int[] arr = {-2,5,5,-2};

        assertEquals(10, new YK_Mod17_MaxSumSubArray().getMaxSumSubArrayIter(arr));
    }

    @Test
    void middleNonConsIter() {
        int[] arr = {-2,5,-1,5,-2};

        assertEquals(9, new YK_Mod17_MaxSumSubArray().getMaxSumSubArrayIter(arr));
    }

    @Test
    void startNonConsIter() {
        int[] arr = {5,-1,5,-2};

        assertEquals(9, new YK_Mod17_MaxSumSubArray().getMaxSumSubArrayIter(arr));
    }

    @Test
    void endNonConsIter() {
        int[] arr = {-2,5,-1,5};

        assertEquals(9, new YK_Mod17_MaxSumSubArray().getMaxSumSubArrayIter(arr));
    }

}