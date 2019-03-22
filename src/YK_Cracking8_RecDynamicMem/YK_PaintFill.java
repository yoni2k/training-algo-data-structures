package YK_Cracking8_RecDynamicMem;

/*
Cracking 8.9

PaintFill - given a matrix, and a specific square, change all squares touching (not diagonally) of the color being changed

Implementation: I first implemented using another matrix of booleans to show if square was handled, but actually it could be done
    by using the actual colors of the matrix
 */

public class YK_PaintFill {
    private void recPaintFill(int row, int column, int fromColor, int toColor, int[][]colors) {

        if((row >= colors.length) || (column >= colors[0].length) || (row < 0) || (column < 0)) return;

        if(colors[row][column] == toColor) return;

        if(colors[row][column] != fromColor) return;

        colors[row][column] = toColor;

        recPaintFill(row - 1, column, fromColor, toColor, colors);
        recPaintFill(row, column + 1, fromColor, toColor, colors);
        recPaintFill(row + 1, column, fromColor, toColor, colors);
        recPaintFill(row, column - 1, fromColor, toColor, colors);
    }

    public int [][] paintFill(int row, int column, int toColor, int[][] colors) {

        recPaintFill(row, column, colors[row][column], toColor, colors);

        return colors;
    }
}
