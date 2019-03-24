package YK_Cracking10_SortSearch;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class YK_SortedMergeTest {

    @Test
    void shortBothFirstSmaller() {
        int[] a = {1,0};
        int[] b = {2};
        int[] exp = {1,2};

        assertArrayEquals(exp, new YK_SortedMerge().mergeArrays(a,b));
    }

    @Test
    void shortBothFirstLarger() {
        int[] a = {2,0};
        int[] b = {1};
        int[] exp = {1,2};

        assertArrayEquals(exp, new YK_SortedMerge().mergeArrays(a,b));
    }

    @Test
    void shortAFirst() {
        int[] a = {1,0,0,0};
        int[] b = {2,3,4};
        int[] exp = {1,2,3,4};

        assertArrayEquals(exp, new YK_SortedMerge().mergeArrays(a,b));
    }

    @Test
    void shortAMiddle() {
        int[] a = {3,0,0,0};
        int[] b = {1,2,4};
        int[] exp = {1,2,3,4};

        assertArrayEquals(exp, new YK_SortedMerge().mergeArrays(a,b));
    }

    @Test
    void shortAEnd() {
        int[] a = {1,2,3,0};
        int[] b = {4};
        int[] exp = {1,2,3,4};

        assertArrayEquals(exp, new YK_SortedMerge().mergeArrays(a,b));
    }

    @Test
    void shortBFirst() {
        int[] a = {2,3,4,0};
        int[] b = {1};
        int[] exp = {1,2,3,4};

        assertArrayEquals(exp, new YK_SortedMerge().mergeArrays(a,b));
    }

    @Test
    void shortBMiddle() {
        int[] a = {1,2,4,0};
        int[] b = {3};
        int[] exp = {1,2,3,4};

        assertArrayEquals(exp, new YK_SortedMerge().mergeArrays(a,b));
    }

    @Test
    void shortBEnd() {
        int[] a = {1,2,3,0};
        int[] b = {4};
        int[] exp = {1,2,3,4};

        assertArrayEquals(exp, new YK_SortedMerge().mergeArrays(a,b));
    }

    @Test
    void regularABegEnd() {
        int[] a = {1,3,5,7,0,0,0};
        int[] b = {2,4,6};
        int[] exp = {1,2,3,4,5,6,7};

        assertArrayEquals(exp, new YK_SortedMerge().mergeArrays(a,b));
    }

    @Test
    void regularBBegEnd() {
        int[] a = {2,4,6,0,0,0,0};
        int[] b = {1,3,5,7};
        int[] exp = {1,2,3,4,5,6,7};

        assertArrayEquals(exp, new YK_SortedMerge().mergeArrays(a,b));
    }

    @Test
    void regularAAllBigger() {
        int[] a = {4,5,6,7,0,0,0};
        int[] b = {1,2,3};
        int[] exp = {1,2,3,4,5,6,7};

        assertArrayEquals(exp, new YK_SortedMerge().mergeArrays(a,b));
    }

    @Test
    void regularBAllBigger() {
        int[] a = {1,2,3,0,0,0,0};
        int[] b = {4,5,6,7};
        int[] exp = {1,2,3,4,5,6,7};

        assertArrayEquals(exp, new YK_SortedMerge().mergeArrays(a,b));
    }

}