package YK_Cracking16_Moderate;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class YK_Mod6_SmallestDiffTest {
    @Test
    void simple() {
        int[] a1 = {1, 5, 10};
        int[] a2 = {3, 6, 12};

        assertEquals(1, new YK_Mod6_SmallestDiff().getMinDiff(a1, a2));
    }

    @Test
    void repeating() {
        int[] a1 = {5, 5, 5};
        int[] a2 = {3, 6, 12};

        assertEquals(1, new YK_Mod6_SmallestDiff().getMinDiff(a1, a2));
    }

    @Test
    void negative() {
        int[] a1 = {-10, -5, -1};
        int[] a2 = {-12, -6, -3};

        assertEquals(1, new YK_Mod6_SmallestDiff().getMinDiff(a1, a2));
    }

    @Test
    void posNeg() {
        int[] a1 = {1, 5, 10};
        int[] a2 = {-12, -6, -3};

        assertEquals(4, new YK_Mod6_SmallestDiff().getMinDiff(a1, a2));
    }

    @Test
    void shortArr() {
        int[] a1 = {1};
        int[] a2 = {2};

        assertEquals(1, new YK_Mod6_SmallestDiff().getMinDiff(a1, a2));
    }

    @Test
    void randoms() {
        for (int i = 0; i < 1000; i++) {
            singleRandom();
        }
    }

    private void singleRandom() {
        int[] a1;
        int[] a2;
        Random rand = new Random();

        a1 = new int[rand.nextInt(100)];
        a2 = new int[rand.nextInt(100)];

        for(int i = 0 ; i < a1.length; i++) {
            a1[i] = rand.nextInt(50);
            if ((i % 2) == 0) {
                a1[i] *= -1;
            }
        }

        for(int i = 0 ; i < a2.length; i++) {
            a2[i] = rand.nextInt(50);
            if ((i % 2) == 0) {
                a2[i] *= -1;
            }
        }

        int minExp = Integer.MAX_VALUE;
        int thisDiff;

        for(int memA1 : a1) {
            for (int memA2 : a2) {
                thisDiff = Math.abs(memA2 - memA1);
                minExp = Integer.min(minExp, thisDiff);
            }
        }

        assertEquals(minExp, new YK_Mod6_SmallestDiff().getMinDiff(a1, a2));
    }

}