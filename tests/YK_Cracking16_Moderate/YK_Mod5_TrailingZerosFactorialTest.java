package YK_Cracking16_Moderate;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class YK_Mod5_TrailingZerosFactorialTest {

    @Test
    void test() {
        assertEquals(0, new YK_Mod5_TrailingZerosFactorial().getNumTrailZerosFactorialWithMem(0));
        assertEquals(0, new YK_Mod5_TrailingZerosFactorial().getNumTrailZerosFactorialWithMem(1));
        assertEquals(0, new YK_Mod5_TrailingZerosFactorial().getNumTrailZerosFactorialWithMem(2));
        assertEquals(0, new YK_Mod5_TrailingZerosFactorial().getNumTrailZerosFactorialWithMem(3));
        assertEquals(0, new YK_Mod5_TrailingZerosFactorial().getNumTrailZerosFactorialWithMem(4));
        assertEquals(1, new YK_Mod5_TrailingZerosFactorial().getNumTrailZerosFactorialWithMem(5));
        assertEquals(1, new YK_Mod5_TrailingZerosFactorial().getNumTrailZerosFactorialWithMem(6));
        assertEquals(1, new YK_Mod5_TrailingZerosFactorial().getNumTrailZerosFactorialWithMem(8));
        assertEquals(2, new YK_Mod5_TrailingZerosFactorial().getNumTrailZerosFactorialWithMem(10));
        assertEquals(2, new YK_Mod5_TrailingZerosFactorial().getNumTrailZerosFactorialWithMem(13));
        assertEquals(3, new YK_Mod5_TrailingZerosFactorial().getNumTrailZerosFactorialWithMem(15));
        assertEquals(3, new YK_Mod5_TrailingZerosFactorial().getNumTrailZerosFactorialWithMem(18));
        assertEquals(4, new YK_Mod5_TrailingZerosFactorial().getNumTrailZerosFactorialWithMem(20));
        assertEquals(4, new YK_Mod5_TrailingZerosFactorial().getNumTrailZerosFactorialWithMem(22));
        assertEquals(6, new YK_Mod5_TrailingZerosFactorial().getNumTrailZerosFactorialWithMem(25));
        assertEquals(6, new YK_Mod5_TrailingZerosFactorial().getNumTrailZerosFactorialWithMem(26));
        assertEquals(7, new YK_Mod5_TrailingZerosFactorial().getNumTrailZerosFactorialWithMem(30));
    }

}