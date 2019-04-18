package YK_Cracking16_Moderate;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class YK_Mod1_SwapNoTempTest {

    @Test
    void testPlusMinus() {
        int[] input = {-20, -10, 0, 10, 20};
        int one;
        int two;

        for(int oneInt : input) {
            for (int twoInt: input) {
                one = oneInt;
                two = twoInt;
                int[] exp = {two, one};

                assertArrayEquals(exp, new YK_Mod1_SwapNoTemp().swapPlusMinus(one, two));
            }
        }
    }

    @Test
    void testXor() {
        int[] input = {-20, -10, 0, 10, 20};
        int one;
        int two;

        for(int oneInt : input) {
            for (int twoInt: input) {
                one = oneInt;
                two = twoInt;
                int[] exp = {two, one};

                assertArrayEquals(exp, new YK_Mod1_SwapNoTemp().swapXor(one, two));
            }
        }
    }

}