package YK_Cracking1_ArraysStrings;
/*
Source: Cracking p.91, 1.8

Write an algorithm such that if an element in an MxN matrix is 0, it's entire row and column are set to 0.

Great implementation: no additional space, O(MxN).

Implementation tool: must start from the end to check, otherwise orverridding what's being checked based on

 */

import java.util.Arrays;

public class YK_ZeroMatrix {

    private boolean bFirstColumnHasZero = false;
    private int[][] gMatrix = null;

    private void setFlag(int i, int j) {
        System.out.println("Setting frag for ["+ i +"]["+j+"]");
        System.out.println("Setting 0 in ["+ i +"][0]");
        gMatrix[i][0] = 0;
        if (j == 0) {
            System.out.println("Setting bFirstColumnHasZero");
            bFirstColumnHasZero = true;
        }
        else {
            System.out.println("Setting 0 in [0]["+ j +"]");
            gMatrix[0][j] = 0;
        }
    }

    private boolean isZero(int i, int j) {
        if (j == 0) {
            System.out.println("isZero, J==0!!! -  ["+i+"]["+j+"], matrix[i][0]: " + gMatrix[i][0] + ", bFirstColumnHasZero: " + bFirstColumnHasZero);
            return ((gMatrix[i][0] == 0) || bFirstColumnHasZero);
        }
        else {
            System.out.println("isZero, ["+i+"]["+j+"], matrix[i][0]: " + gMatrix[i][0] + ", matrix[0][j]: " + gMatrix[0][j]);
            return ((gMatrix[i][0] == 0) || (gMatrix[0][j] == 0));
        }
    }

    public int[][] zeroMatrix(int[][] matrix) {

        if(matrix == null)
            return null;

        System.out.println("Zeroing matrix: " + Arrays.deepToString(matrix));

        int M = matrix.length;
        int N = matrix[0].length;

        gMatrix = matrix.clone();

        //implementation without using extra room besides the matrix + 1 more room for (0,0)
        for(int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if(matrix[i][j] == 0) {
                    setFlag(i,j);
                }
            }
        }

        for(int i = M-1; i >= 0; i--) {
            for (int j = N-1; j >= 0; j--) {
                if(isZero(i, j)) {
                    matrix[i][j] = 0;
                }
            }
        }

        /* previous implementation with extra M + N room
        boolean[] mZeros = new boolean[M];
        boolean[] nZeros = new boolean[N];

        for(int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if(matrix[i][j] == 0) {
                    mZeros[i] = true;
                    nZeros[j] = true;
                }
            }
        }

        for(int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if(mZeros[i] || nZeros[j]) {
                    matrix[i][j] = 0;
                }
            }
        } */

        System.out.println("Final matrix: " + Arrays.deepToString(gMatrix));

        return gMatrix;
    }
}
