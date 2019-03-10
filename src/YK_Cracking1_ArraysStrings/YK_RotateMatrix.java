package YK_Cracking1_ArraysStrings;

/* Source: cracking p. 91, exercise 1.7

    Rotate matrix of size NxN by 90 degrees.
    Can you make it in-place?

    Implementation (x,y) --> (y, N-1-x)

    See picture of "Cracking 1.7" for details of how got to detailed solution

*/
public class YK_RotateMatrix {
    static public int[][] rotateOutPlace(int[][] matrix) {

        if(matrix == null) {
            return null;
        }

        int N = matrix.length;

        int[][] rotated = new int[N][N];

        for(int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                rotated[j][N - 1 - i] = matrix [i][j];
            }
        }

        return rotated;
    }

    static public int[][] rotateInPlace(int[][] matrix) {

        if(matrix == null) {
            return null;
        }

        int N = matrix.length;

        int temp1, temp2;

        for(int i = 0; i < (N/2); i++) {
            for (int j = i; j < (N-1-i); j++) {
                temp1 = matrix[j][N-1-i];
                matrix[j][N-1-i] = matrix[i][j];

                temp2 = matrix[N-1-i][N-1-j];
                matrix[N-1-i][N-1-j] = temp1;

                temp1 = matrix[N-1-j][i];
                matrix[N-1-j][i] = temp2;

                matrix[i][j] = temp1;
            }
        }

        return matrix;
    }
}
