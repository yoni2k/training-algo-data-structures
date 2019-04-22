package YK_Cracking16_Moderate;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class YK_Mod21_SumSwapTest {

    @Test
    void notFoundOptimized() {
        int[] a1 = {10,20,30};
        int[] a2 = {10,21,30};

        assertNull(new YK_Mod21_SumSwap().findPairToSwapOptimized(a1,a2));
    }

    @Test
    void found1_1Optimized() {
        int[] a1 = {10,21,30};
        int[] a2 = {11,20,32};

        assertArrayEquals(new int[] {10,11}, new YK_Mod21_SumSwap().findPairToSwapOptimized(a1,a2));
    }

    @Test
    void found2_2Optimized() {
        int[] a1 = {11,20,30};
        int[] a2 = {10,21,32};

        assertArrayEquals(new int[] {20,21}, new YK_Mod21_SumSwap().findPairToSwapOptimized(a1,a2));
    }

    @Test
    void found3_3Optimized() {
        int[] a1 = {10,21,30};
        int[] a2 = {12,20,31};

        assertArrayEquals(new int[] {30,31}, new YK_Mod21_SumSwap().findPairToSwapOptimized(a1,a2));
    }

    @Test
    void negDiffOptimized() {
        int[] a1 = {12,21,30};
        int[] a2 = {10,20,31};

        assertArrayEquals(new int[] {21,20}, new YK_Mod21_SumSwap().findPairToSwapOptimized(a1,a2));
    }

    @Test
    void negNumsOptimized() {
        int[] a1 = {-10,-21,-30};
        int[] a2 = {-12,-20,-31};

        assertArrayEquals(new int[] {-30, -31}, new YK_Mod21_SumSwap().findPairToSwapOptimized(a1,a2));
    }

    /**
     * Not optimized
     */

    @Test
    void notFound() {
        int[] a1 = {10,20,30};
        int[] a2 = {10,21,30};

        assertNull(new YK_Mod21_SumSwap().findPairToSwap(a1,a2));
    }

    @Test
    void found1_1() {
        int[] a1 = {10,21,30};
        int[] a2 = {11,20,32};

        assertArrayEquals(new int[] {10,11}, new YK_Mod21_SumSwap().findPairToSwap(a1,a2));
    }

    @Test
    void found2_2() {
        int[] a1 = {11,20,30};
        int[] a2 = {10,21,32};

        assertArrayEquals(new int[] {20,21}, new YK_Mod21_SumSwap().findPairToSwap(a1,a2));
    }

    @Test
    void found3_3() {
        int[] a1 = {10,21,30};
        int[] a2 = {12,20,31};

        assertArrayEquals(new int[] {30,31}, new YK_Mod21_SumSwap().findPairToSwap(a1,a2));
    }

    @Test
    void negDiff() {
        int[] a1 = {12,21,30};
        int[] a2 = {10,20,31};

        assertArrayEquals(new int[] {21,20}, new YK_Mod21_SumSwap().findPairToSwap(a1,a2));
    }

    @Test
    void negNums() {
        int[] a1 = {-10,-21,-30};
        int[] a2 = {-12,-20,-31};

        assertArrayEquals(new int[] {-30, -31}, new YK_Mod21_SumSwap().findPairToSwap(a1,a2));
    }

}