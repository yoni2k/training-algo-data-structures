package YK_Cracking16_Moderate;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class YK_Mod24_PairsWithSumTest {

    @Test
    void noneFound() {
        int[] arr = {5, 1, 7, -2};
        int[][] exp = {};
        int sum = 4;

        assertArrayEquals(exp, new YK_Mod24_PairsWithSum().getPairsWithValue(arr, sum));
    }

    @Test
    void oneFound() {
        int[] arr = {5, 1, 7, -2, 0};
        int[][] exp = {{5,1}};
        int sum = 6;

        assertArrayEquals(exp, new YK_Mod24_PairsWithSum().getPairsWithValue(arr, sum));
    }

    @Test
    void twoFound() {
        int[] arr = {5, 1, 7, -2, 0};
        int[][] exp = {{7,-2},{5,0}};
        int sum = 5;

        assertArrayEquals(exp, new YK_Mod24_PairsWithSum().getPairsWithValue(arr, sum));
    }

    /**
     * When ordered, to save space and do in O(1) in addition to O(n) time
     */

    @Test
    void noneFoundOrdered() {
        int[] arr = {-2, 1, 5, 7};
        int[][] exp = {};
        int sum = 4;

        assertArrayEquals(exp, new YK_Mod24_PairsWithSum().getPairsWithValueOrdered(arr, sum));
    }

    @Test
    void oneFoundOrdered() {
        int[] arr = {-2, 0, 1, 5, 7};
        int[][] exp = {{1,5}};
        int sum = 6;

        assertArrayEquals(exp, new YK_Mod24_PairsWithSum().getPairsWithValueOrdered(arr, sum));
    }

    @Test
    void twoFoundOrdered() {
        int[] arr = {-2, 0, 1, 5, 7};
        int[][] exp = {{-2,7},{0,5}};
        int sum = 5;

        assertArrayEquals(exp, new YK_Mod24_PairsWithSum().getPairsWithValueOrdered(arr, sum));
    }


}