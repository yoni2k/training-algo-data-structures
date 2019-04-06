package YK_AmazonPrep;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class YK_Sample2_GCDTest {
    @Test
    void testIterativeInitial() {
        int[][] arrs = {
                {2, 4, 6},
                {2},
                {6, 4, 2},
                {6, 4},
                {1, 2, 4},
                {2, 4, 1},
                {4, 9},
                {4, 9, 25},
                {18, 8, 50},
                {54, 24, 150},
                {810, 360, 2250}
        };
        int[] gcds = {
                2,
                2,
                2,
                2,
                1,
                1,
                1,
                1,
                2,
                6,
                90
        };

        assertEquals(arrs.length, gcds.length);
        System.out.println("Last index: " + (arrs.length - 1));

        for (int i = 0; i < arrs.length; i++) {
            System.out.println("i: " + i + ", numbers: " + Arrays.toString(arrs[i]) + ", exp: " + gcds[i]);
            assertEquals(gcds[i], new YK_Sample2_GCD().generalizedGCD(arrs[i].length, arrs[i]));
        }

    }

    @Test
    void testRecOneByOne() {
        int[][] arrs = {
                {2, 4, 6},
                {2},
                {6,4,2},
                {6,4},
                {1,2,4},
                {2,4,1},
                {4,9},
                {4,9,25},
                {18,8,50},
                {54,24,150},
                {810,360,2250}
        };
        int[] gcds = {
                2,
                2,
                2,
                2,
                1,
                1,
                1,
                1,
                2,
                6,
                90
        };

        assertEquals(arrs.length, gcds.length);
        System.out.println("Last index: " + (arrs.length - 1));

        for(int i = 0; i < arrs.length; i++) {
            System.out.println("i: " + i + ", numbers: " + Arrays.toString(arrs[i]) + ", exp: " + gcds[i]);
            assertEquals(gcds[i], new YK_Sample2_GCD().recOneByOneGCD(arrs[i]));
        }
    }
}