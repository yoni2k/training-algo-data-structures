package YK_Cracking8_RecDynamicMem;

import java.util.Arrays;

/*
Source: Cracking 8.12

Place 8 queens on 8*8 board (or general n queens on n*n board) so they don't threaten each other -
    no 2 queens on same row, column, and all the diagonals.

My implementation is a bit longer, a bit more memory intensive, and slightly longer (placing a queen is not O(1) like in the book),
but a little easier to follow
 */

public class YK_EightQueens {

    private void markTakenDiagonal(int size, int row, int column, int deltaRow, int deltaColumn, boolean[][] taken) {

        int r = row + deltaRow;
        int c = column + deltaColumn;

        while ((r >= 0) && (c >= 0) && (r < size) && (c < size)) {
            taken[r][c] = true;
            r += deltaRow;
            c += deltaColumn;
        }
    }

    private boolean[][] getNewTaken(int size, int row, int column, boolean[][] prevTaken) {
        boolean[][] newTaken = new boolean[size][size];

        //handle copying from prevTaken, rows and columns
        for(int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                if(prevTaken[r][c] || (r == row) || (c == column)) {
                    newTaken[r][c] = true;
                }
            }
        }

        markTakenDiagonal(size, row, column, 1, 1, newTaken);
        markTakenDiagonal(size, row, column, 1, -1, newTaken);
        markTakenDiagonal(size, row, column, -1, 1, newTaken);
        markTakenDiagonal(size, row, column, -1, -1, newTaken);

        return newTaken;
    }

    private int recPrintGetNumQueens(int size, int column, boolean[][]queens, boolean[][] taken) {

        if (column == size) { // finished going over all columns
            System.out.println("Way to arrange: " + Arrays.deepToString(queens));
            return 1;
        }

        boolean[][] newTaken;
        int numWays = 0;

        for(int i = 0; i < size; i++) {
            if(taken[i][column] == false) {
                queens[i][column] = true;

                newTaken = getNewTaken(size, i, column, taken);

                numWays += recPrintGetNumQueens(size, column + 1, queens, newTaken);

                queens[i][column] = false;
            }
        }

        return numWays;
    }

    public int printGetNumQueens(int size) {
        boolean[][] queens = new boolean[size][size];
        boolean[][] taken = new boolean[size][size];

        return recPrintGetNumQueens(size, 0, queens, taken);
    }
}
