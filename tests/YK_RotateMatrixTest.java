import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class YK_RotateMatrixTest {

    private int[][] arrayNull = null;

    private int[][] array1x1 = {{1}};

    private int[][] array2x2 = {{1,2}, {3,4}};
    private int[][] exp2x2 = {{2, 4}, {1, 3}};

    private int[][] array3x3 = {{1,2,3}, {4,5,6}, {7,8,9}};
    private int[][] exp3x3 = {{3, 6, 9}, {2, 5, 8}, {1, 4, 7}};

    private int[][] array4x4 = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16}};
    private int[][] exp4x4 = {{4, 8, 12, 16}, {3, 7, 11, 15}, {2, 6, 10, 14}, {1, 5, 9, 13}};

    @Test
    void smallMatrixesOutPlace() {
        assertEquals(arrayNull, YK_RotateMatrix.rotateOutPlace(arrayNull));

        assertTrue(Arrays.deepEquals(array1x1, YK_RotateMatrix.rotateOutPlace(array1x1)));
    }

    @Test
    void largeMatrixesOutPlace() {

        assertTrue(Arrays.deepEquals(array2x2, YK_RotateMatrix.rotateOutPlace(exp2x2)));

        assertTrue(Arrays.deepEquals(array3x3, YK_RotateMatrix.rotateOutPlace(exp3x3)));

        assertTrue(Arrays.deepEquals(array4x4, YK_RotateMatrix.rotateOutPlace(exp4x4)));
    }

    @Test
    void smallMatrixesInPlace() {
        assertEquals(arrayNull, YK_RotateMatrix.rotateInPlace(arrayNull));

        assertTrue(Arrays.deepEquals(array1x1, YK_RotateMatrix.rotateInPlace(array1x1)));
    }

    @Test
    void largeMatrixesInPlace() {

        assertTrue(Arrays.deepEquals(array2x2, YK_RotateMatrix.rotateInPlace(exp2x2)));

        assertTrue(Arrays.deepEquals(array3x3, YK_RotateMatrix.rotateInPlace(exp3x3)));

        assertTrue(Arrays.deepEquals(array4x4, YK_RotateMatrix.rotateInPlace(exp4x4)));
    }
}