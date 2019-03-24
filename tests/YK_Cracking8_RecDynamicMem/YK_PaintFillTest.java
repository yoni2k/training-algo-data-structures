package YK_Cracking8_RecDynamicMem;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class YK_PaintFillTest {

    @Test
    void matrix1Replace() {
        int [][] colors = {{1}};
        int [][] expect = {{2}};

        assertTrue(Arrays.deepEquals(expect, new YK_PaintFill().paintFill(0, 0, 2, colors)));
    }

    private int[][] replace(int[][] toReplace) {

        int [][] replaced = new int[5][5];

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                replaced[i][j] = (toReplace[i][j] == 1) ? 2 : toReplace[i][j];
            }
        }

        return replaced;
    }

    @Test
    void fillAll() {
        int [][] colors = {{1,1,1,1,1},{1,1,1,1,1},{1,1,1,1,1},{1,1,1,1,1},{1,1,1,1,1}};
        int [][] expect = replace(colors);

        assertTrue(Arrays.deepEquals(expect, new YK_PaintFill().paintFill(2,2,2,colors)));
    }

    @Test
    void snake1() {
        int [][] colors = {{3,3,3,1,1},{3,3,1,1,3},{3,1,1,3,3},{1,1,3,3,3},{3,1,1,1,1}};
        int [][] expect = replace(colors);

        assertTrue(Arrays.deepEquals(expect, new YK_PaintFill().paintFill(2,2,2,colors)));
    }

    @Test
    void snake2() {
        //int [][] colors = {{},{},{},{},{}};
        int [][] colors = {{1,1,3,3,3},{3,1,1,3,3},{3,3,1,1,3},{3,3,3,1,1},{3,3,3,3,1}};
        int [][] expect = replace(colors);

        assertTrue(Arrays.deepEquals(expect, new YK_PaintFill().paintFill(2,2,2,colors)));
    }

    @Test
    void snake3() {
        int [][] colors = {{1,3,3,3,3},{1,1,3,3,3},{3,1,1,3,3},{3,3,1,1,3},{3,3,3,1,1}};
        int [][] expect = replace(colors);

        assertTrue(Arrays.deepEquals(expect, new YK_PaintFill().paintFill(2,2,2,colors)));
    }

    @Test
    void snake4() {
        int [][] colors = {{3,3,3,3,1},{3,3,3,1,1},{3,3,1,1,3},{3,1,1,3,3},{1,1,3,3,3}};
        int [][] expect = replace(colors);

        assertTrue(Arrays.deepEquals(expect, new YK_PaintFill().paintFill(2,2,2,colors)));
    }

    @Test
    void along() {
        int [][] colors = {{3,3,3,3,3},{3,3,3,3,3},{3,3,1,3,3},{3,3,3,3,3},{3,3,3,3,3}};
        int [][] expect = replace(colors);

        assertTrue(Arrays.deepEquals(expect, new YK_PaintFill().paintFill(2,2,2,colors)));
    }

    @Test
    void cornerOfPaint() {
        int [][] colors = {{3,3,1,1,1},{3,3,1,1,1},{3,3,1,1,1},{3,3,3,3,3},{3,3,3,3,3}};
        int [][] expect = replace(colors);

        assertTrue(Arrays.deepEquals(expect, new YK_PaintFill().paintFill(2,2,2,colors)));
    }

    @Test
    void middleOfPaintNotAll() {
        int [][] colors = {{3,1,1,1,1},{3,1,1,1,1},{3,1,1,1,1},{3,1,1,1,1},{3,3,3,3,3}};
        int [][] expect = replace(colors);

        assertTrue(Arrays.deepEquals(expect, new YK_PaintFill().paintFill(2,2,2,colors)));
    }

    @Test
    void changedColorAlready() {
        int [][] colors = {{1,1,1,1,1},{1,1,1,1,1},{1,1,2,1,1},{1,1,1,1,1},{1,1,1,1,1}};
        int [][] expect = {{1,1,1,1,1},{1,1,1,1,1},{1,1,2,1,1},{1,1,1,1,1},{1,1,1,1,1}};

        assertTrue(Arrays.deepEquals(expect, new YK_PaintFill().paintFill(2,2,2,colors)));

        System.out.println("Colors: " + Arrays.deepToString(colors));
        System.out.println("Expected: " + Arrays.deepToString(colors));
    }

    @Test
    void diagonals() {
        int [][] colors = {{1,3,1,3,1},{3,1,3,1,3},{1,3,1,3,1},{3,1,3,1,3},{1,3,1,3,1}};
        int [][] expect = {{1,3,1,3,1},{3,1,3,1,3},{1,3,2,3,1},{3,1,3,1,3},{1,3,1,3,1}};

        assertTrue(Arrays.deepEquals(expect, new YK_PaintFill().paintFill(2,2,2,colors)));
    }

    @Test
    void topLeftCorner() {
        int [][] colors = {{1,1,1,3,3},{3,3,3,3,3},{3,3,3,3,3},{3,3,3,3,3},{3,3,3,3,3}};
        int [][] expect = replace(colors);

        assertTrue(Arrays.deepEquals(expect, new YK_PaintFill().paintFill(0,0,2,colors)));
    }

    @Test
    void topRightCorner() {
        int [][] colors = {{3,3,3,3,1},{3,3,3,3,1},{3,3,3,3,3},{3,3,3,3,3},{3,3,3,3,3}};
        int [][] expect = replace(colors);

        assertTrue(Arrays.deepEquals(expect, new YK_PaintFill().paintFill(0,4,2,colors)));
    }

    @Test
    void bottomRightCorner() {
        int [][] colors = {{3,3,3,3,1},{3,3,3,3,1},{3,3,3,3,1},{3,3,3,3,1},{3,3,3,3,1}};
        int [][] expect = replace(colors);

        assertTrue(Arrays.deepEquals(expect, new YK_PaintFill().paintFill(4,4,2,colors)));
    }

    @Test
    void bottomLeftCorner() {
        int [][] colors = {{3,3,3,3,3},{3,3,3,3,3},{3,3,3,3,3},{3,3,3,3,3},{1,3,3,3,3}};
        int [][] expect = replace(colors);

        assertTrue(Arrays.deepEquals(expect, new YK_PaintFill().paintFill(4,0,2,colors)));
    }
}