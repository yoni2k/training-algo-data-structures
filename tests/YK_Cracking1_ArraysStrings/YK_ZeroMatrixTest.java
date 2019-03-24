package YK_Cracking1_ArraysStrings;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class YK_ZeroMatrixTest {

    private int[][] build2x1Zeros = {{0},{0}};
    private int[][] build1x2Zeros = {{0,0}};
    private int[][] build4x3Zeros = {{0,0,0}, {0,0,0}, {0,0,0}, {0,0,0}};

    @Test
    void smallMatrixes() {

        assertTrue(Arrays.deepEquals(null,(new YK_ZeroMatrix()).zeroMatrix(null)));

        int[][] mat1x1Without = {{1}};
        int[][] mat1x1With = {{0}};

        assertTrue(Arrays.deepEquals(mat1x1Without,(new YK_ZeroMatrix()).zeroMatrix(mat1x1Without)));
        assertTrue(Arrays.deepEquals(mat1x1With,(new YK_ZeroMatrix()).zeroMatrix(mat1x1With)));

        int[][] mat2x1Without = {{1},{1}};
        int[][] mat2x1With1st = {{0},{1}};  //1st place
        int[][] mat2x1WithLast = {{1},{0}};  //last place

        assertTrue(Arrays.deepEquals(mat2x1Without,(new YK_ZeroMatrix()).zeroMatrix(mat2x1Without)));
        assertTrue(Arrays.deepEquals(build2x1Zeros,(new YK_ZeroMatrix()).zeroMatrix(mat2x1With1st)));
        assertTrue(Arrays.deepEquals(build2x1Zeros,(new YK_ZeroMatrix()).zeroMatrix(mat2x1WithLast)));

        int[][] mat1x2Without = {{1,1}};
        int[][] mat1x2With1st = {{0,1}};  //1st place
        int[][] mat1x2WithLast = {{1,0}};  //last place

        assertTrue(Arrays.deepEquals(mat1x2Without,(new YK_ZeroMatrix()).zeroMatrix(mat1x2Without)));
        assertTrue(Arrays.deepEquals(build1x2Zeros,(new YK_ZeroMatrix()).zeroMatrix(mat1x2With1st)));
        assertTrue(Arrays.deepEquals(build1x2Zeros,(new YK_ZeroMatrix()).zeroMatrix(mat1x2WithLast)));
    }

    @Test
    void mat4x3Without() {
        int[][] mat4x3Without = {{1,2,3}, {4,5,6}, {7,8,9}, {10,11,12}};

        assertTrue(Arrays.deepEquals(mat4x3Without,(new YK_ZeroMatrix()).zeroMatrix(mat4x3Without)));
    }

    @Test
    void mat4x3Corners() {
        int[][] mat4x3CornerTL = {{0,2,3}, {4,5,6}, {7,8,9}, {10,11,12}};
        int[][] exp_mat4x3CornerTL = {{0,0,0}, {0,5,6}, {0,8,9}, {0,11,12}};

        int[][] mat4x3CornerTR = {{1,2,0}, {4,5,6}, {7,8,9}, {10,11,12}};
        int[][] exp_mat4x3CornerTR = {{0,0,0}, {4,5,0}, {7,8,0}, {10,11,0}};

        int[][] mat4x3CornerBL = {{1,2,3}, {4,5,6}, {7,8,9}, {0,11,12}};
        int[][] exp_mat4x3CornerBL = {{0,2,3}, {0,5,6}, {0,8,9}, {0,0,0}};

        int[][] mat4x3CornerBR = {{1,2,3}, {4,5,6}, {7,8,9}, {10,11,0}};
        int[][] exp_mat4x3CornerBR = {{1,2,0}, {4,5,0}, {7,8,0}, {0,0,0}};

        assertTrue(Arrays.deepEquals(exp_mat4x3CornerTL,(new YK_ZeroMatrix()).zeroMatrix(mat4x3CornerTL)));
        assertTrue(Arrays.deepEquals(exp_mat4x3CornerTR,(new YK_ZeroMatrix()).zeroMatrix(mat4x3CornerTR)));
        assertTrue(Arrays.deepEquals(exp_mat4x3CornerBL,(new YK_ZeroMatrix()).zeroMatrix(mat4x3CornerBL)));
        assertTrue(Arrays.deepEquals(exp_mat4x3CornerBR,(new YK_ZeroMatrix()).zeroMatrix(mat4x3CornerBR)));
    }

    @Test
    void mat4x3Middle() {
        int[][] mat4x3Middle = {{1,2,3}, {4,0,6}, {7,8,9}, {10,11,12}};
        int[][] exp_mat4x3Middle = {{1,0,3}, {0,0,0}, {7,0,9}, {10,0,12}};

        int[][] mat4x3Many = {{0,2,3}, {4,0,6}, {7,8,9}, {0,11,12}};
        int[][] exp_mat4x3Many = {{0,0,0}, {0,0,0}, {0,0,9}, {0,0,0}};

        assertTrue(Arrays.deepEquals(exp_mat4x3Middle,(new YK_ZeroMatrix()).zeroMatrix(mat4x3Middle)));
        assertTrue(Arrays.deepEquals(exp_mat4x3Many,(new YK_ZeroMatrix()).zeroMatrix(mat4x3Many)));
    }

    @Test
    void mat4x3AllBecomeZeros() {
        int[][] mat4x3AllBecomeZeros = {{0,2,3}, {4,0,6}, {7,8,0}, {10,11,12}};

        assertTrue(Arrays.deepEquals(build4x3Zeros,(new YK_ZeroMatrix()).zeroMatrix(mat4x3AllBecomeZeros)));
        assertTrue(Arrays.deepEquals(build4x3Zeros,(new YK_ZeroMatrix()).zeroMatrix(build4x3Zeros)));
    }
}