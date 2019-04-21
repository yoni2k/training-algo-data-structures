package YK_Cracking16_Moderate;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class YK_Mod19_PondsSizesTest {

    @Test
    void noPonds() {
        int[][] plot = {
                {1,1,1},
                {1,1,1},
                {1,1,1}
        };

        int[] exp = {};

        assertArrayEquals(exp, new YK_Mod19_PondsSizes().getPondSizes(plot));
    }

    @Test
    void wholePond() {
        int[][] plot = {
                {0,0,0},
                {0,0,0},
                {0,0,0}
        };

        int[] exp = {9};

        assertArrayEquals(exp, new YK_Mod19_PondsSizes().getPondSizes(plot));
    }

    @Test
    void various() {
        int[] exp1 = {1};
        int[] exp2 = {2};
        int[] exp3 = {3};
        int[] exp4 = {4};
        int[] exp5 = {5};
        int[] exp7 = {7};

        int[] exp3_3 = {3,3};

        int[][] plot1 = {
                {0,1,1},
                {1,1,1},
                {1,1,1}
        };

        assertArrayEquals(exp1, new YK_Mod19_PondsSizes().getPondSizes(plot1));

        int[][] plot2 = {
                {1,0,1},
                {1,1,1},
                {1,1,1}
        };

        assertArrayEquals(exp1, new YK_Mod19_PondsSizes().getPondSizes(plot2));

        int[][] plot3 = {
                {1,1,0},
                {1,1,1},
                {1,1,1}
        };

        assertArrayEquals(exp1, new YK_Mod19_PondsSizes().getPondSizes(plot3));

        int[][] plot4 = {
                {1,1,1},
                {0,1,1},
                {1,1,1}
        };

        assertArrayEquals(exp1, new YK_Mod19_PondsSizes().getPondSizes(plot4));

        int[][] plot5 = {
                {1,0,1},
                {0,0,0},
                {1,0,1}
        };

        assertArrayEquals(exp5, new YK_Mod19_PondsSizes().getPondSizes(plot5));

        int[][] plot6 = {
                {0,1,1},
                {1,0,1},
                {1,1,0}
        };

        assertArrayEquals(exp3, new YK_Mod19_PondsSizes().getPondSizes(plot6));

        int[][] plot7 = {
                {1,1,0},
                {1,0,1},
                {0,1,1}
        };

        assertArrayEquals(exp3, new YK_Mod19_PondsSizes().getPondSizes(plot7));

        int[][] plot8 = {
                {0,0,0},
                {1,1,1},
                {0,0,0}
        };

        assertArrayEquals(exp3_3, new YK_Mod19_PondsSizes().getPondSizes(plot8));

        int[][] plot9 = {
                {0,1,0},
                {0,1,0},
                {0,1,0}
        };

        assertArrayEquals(exp3_3, new YK_Mod19_PondsSizes().getPondSizes(plot9));

        int[][] plot10 = {
                {0,0,0},
                {0,1,0},
                {0,1,0}
        };

        assertArrayEquals(exp7, new YK_Mod19_PondsSizes().getPondSizes(plot10));

        int[][] plot11 = {
                {0,0,0},
                {0,1,1},
                {0,0,0}
        };

        assertArrayEquals(exp7, new YK_Mod19_PondsSizes().getPondSizes(plot11));

        int[][] plot12 = {
                {0,1,0},
                {0,1,0},
                {0,0,0}
        };

        assertArrayEquals(exp7, new YK_Mod19_PondsSizes().getPondSizes(plot12));

        int[][] plot13 = {
                {0,0,0},
                {1,1,0},
                {0,0,0}
        };

        assertArrayEquals(exp7, new YK_Mod19_PondsSizes().getPondSizes(plot13));
    }

    /***
     * After reading the book, implemented a recursive algorithm
     */

    @Test
    void noPondsRecursive() {
        int[][] plot = {
                {1,1,1},
                {1,1,1},
                {1,1,1}
        };

        int[] exp = {};

        assertArrayEquals(exp, new YK_Mod19_PondsSizes().getPondSizesRecursive(plot));
    }

    @Test
    void wholePondRecursive() {
        int[][] plot = {
                {0,0,0},
                {0,0,0},
                {0,0,0}
        };

        int[] exp = {9};

        assertArrayEquals(exp, new YK_Mod19_PondsSizes().getPondSizesRecursive(plot));
    }

    @Test
    void variousRecursive() {
        int[] exp1 = {1};
        int[] exp2 = {2};
        int[] exp3 = {3};
        int[] exp4 = {4};
        int[] exp5 = {5};
        int[] exp7 = {7};

        int[] exp3_3 = {3,3};

        int[][] plot1 = {
                {0,1,1},
                {1,1,1},
                {1,1,1}
        };

        assertArrayEquals(exp1, new YK_Mod19_PondsSizes().getPondSizesRecursive(plot1));

        int[][] plot2 = {
                {1,0,1},
                {1,1,1},
                {1,1,1}
        };

        assertArrayEquals(exp1, new YK_Mod19_PondsSizes().getPondSizesRecursive(plot2));

        int[][] plot3 = {
                {1,1,0},
                {1,1,1},
                {1,1,1}
        };

        assertArrayEquals(exp1, new YK_Mod19_PondsSizes().getPondSizesRecursive(plot3));

        int[][] plot4 = {
                {1,1,1},
                {0,1,1},
                {1,1,1}
        };

        assertArrayEquals(exp1, new YK_Mod19_PondsSizes().getPondSizesRecursive(plot4));

        int[][] plot5 = {
                {1,0,1},
                {0,0,0},
                {1,0,1}
        };

        assertArrayEquals(exp5, new YK_Mod19_PondsSizes().getPondSizesRecursive(plot5));

        int[][] plot6 = {
                {0,1,1},
                {1,0,1},
                {1,1,0}
        };

        assertArrayEquals(exp3, new YK_Mod19_PondsSizes().getPondSizesRecursive(plot6));

        int[][] plot7 = {
                {1,1,0},
                {1,0,1},
                {0,1,1}
        };

        assertArrayEquals(exp3, new YK_Mod19_PondsSizes().getPondSizesRecursive(plot7));

        int[][] plot8 = {
                {0,0,0},
                {1,1,1},
                {0,0,0}
        };

        assertArrayEquals(exp3_3, new YK_Mod19_PondsSizes().getPondSizesRecursive(plot8));

        int[][] plot9 = {
                {0,1,0},
                {0,1,0},
                {0,1,0}
        };

        assertArrayEquals(exp3_3, new YK_Mod19_PondsSizes().getPondSizesRecursive(plot9));

        int[][] plot10 = {
                {0,0,0},
                {0,1,0},
                {0,1,0}
        };

        assertArrayEquals(exp7, new YK_Mod19_PondsSizes().getPondSizesRecursive(plot10));

        int[][] plot11 = {
                {0,0,0},
                {0,1,1},
                {0,0,0}
        };

        assertArrayEquals(exp7, new YK_Mod19_PondsSizes().getPondSizesRecursive(plot11));

        int[][] plot12 = {
                {0,1,0},
                {0,1,0},
                {0,0,0}
        };

        assertArrayEquals(exp7, new YK_Mod19_PondsSizes().getPondSizesRecursive(plot12));

        int[][] plot13 = {
                {0,0,0},
                {1,1,0},
                {0,0,0}
        };

        assertArrayEquals(exp7, new YK_Mod19_PondsSizes().getPondSizesRecursive(plot13));
    }
}