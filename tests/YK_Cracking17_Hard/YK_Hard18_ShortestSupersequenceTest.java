package YK_Cracking17_Hard;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class YK_Hard18_ShortestSupersequenceTest {

    @Test
    void noSuperPartialBeg() {
        int[] longArr = {1,2,3,4,5};
        int[] shortArr = {1,7};
        int[] exp = {};

        assertArrayEquals(exp, new YK_Hard18_ShortestSupersequence().getMinSubArray(longArr, shortArr));
    }

    @Test
    void noSuperPartialMid() {
        int[] longArr = {1,2,3,4,5};
        int[] shortArr = {3,7};
        int[] exp = {};

        assertArrayEquals(exp, new YK_Hard18_ShortestSupersequence().getMinSubArray(longArr, shortArr));
    }

    @Test
    void noSuperPartialEnd() {
        int[] longArr = {1,2,3,4,5};
        int[] shortArr = {5,7};
        int[] exp = {};

        assertArrayEquals(exp, new YK_Hard18_ShortestSupersequence().getMinSubArray(longArr, shortArr));
    }

    @Test
    void noSuperNone() {
        int[] longArr = {1,2,3,4,5};
        int[] shortArr = {6,7};
        int[] exp = {};

        assertArrayEquals(exp, new YK_Hard18_ShortestSupersequence().getMinSubArray(longArr, shortArr));
    }

    @Test
    void superShortLen1Beg() {
        int[] longArr = {1,2,3,4,5};
        int[] shortArr = {1};
        int[] exp = {0,1};

        assertArrayEquals(exp, new YK_Hard18_ShortestSupersequence().getMinSubArray(longArr, shortArr));
    }

    @Test
    void superShortLen1Mid() {
        int[] longArr = {1,2,3,4,5};
        int[] shortArr = {3};
        int[] exp = {2,3};

        assertArrayEquals(exp, new YK_Hard18_ShortestSupersequence().getMinSubArray(longArr, shortArr));
    }

    @Test
    void superShortLen1End() {
        int[] longArr = {1,2,3,4,5};
        int[] shortArr = {5};
        int[] exp = {4,5};

        assertArrayEquals(exp, new YK_Hard18_ShortestSupersequence().getMinSubArray(longArr, shortArr));
    }

    @Test
    void superShortBegCons() {
        int[] longArr = {1,2,3,4,5};
        int[] shortArr = {1,2};
        int[] exp = {0,2};

        assertArrayEquals(exp, new YK_Hard18_ShortestSupersequence().getMinSubArray(longArr, shortArr));
    }

    @Test
    void superShortMidCons() {
        int[] longArr = {1,2,3,4,5};
        int[] shortArr = {3,4};
        int[] exp = {2,4};

        assertArrayEquals(exp, new YK_Hard18_ShortestSupersequence().getMinSubArray(longArr, shortArr));
    }

    @Test
    void superShortEndCons() {
        int[] longArr = {1,2,3,4,5};
        int[] shortArr = {4,5};
        int[] exp = {3,5};

        assertArrayEquals(exp, new YK_Hard18_ShortestSupersequence().getMinSubArray(longArr, shortArr));
    }

    @Test
    void superShortBegNotCons() {
        int[] longArr = {1,2,3,4,5};
        int[] shortArr = {1,3};
        int[] exp = {0,3};

        assertArrayEquals(exp, new YK_Hard18_ShortestSupersequence().getMinSubArray(longArr, shortArr));
    }

    @Test
    void superShortMidNotCons() {
        int[] longArr = {1,2,3,4,5};
        int[] shortArr = {2,4};
        int[] exp = {1,4};

        assertArrayEquals(exp, new YK_Hard18_ShortestSupersequence().getMinSubArray(longArr, shortArr));
    }

    @Test
    void superShortEndNotCons() {
        int[] longArr = {1,2,3,4,5};
        int[] shortArr = {3,5};
        int[] exp = {2,5};

        assertArrayEquals(exp, new YK_Hard18_ShortestSupersequence().getMinSubArray(longArr, shortArr));
    }

    @Test
    void superShortMoreThan1Second() {
        int[] longArr = {1,3,4,2,3,1};
        int[] shortArr = {1,2};
        int[] exp = {3,6};

        assertArrayEquals(exp, new YK_Hard18_ShortestSupersequence().getMinSubArray(longArr, shortArr));
    }

    @Test
    void superShortMoreThan1First() {
        int[] longArr = {1,3,2,3,4,1};
        int[] shortArr = {1,2};
        int[] exp = {0,3};

        assertArrayEquals(exp, new YK_Hard18_ShortestSupersequence().getMinSubArray(longArr, shortArr));
    }
}