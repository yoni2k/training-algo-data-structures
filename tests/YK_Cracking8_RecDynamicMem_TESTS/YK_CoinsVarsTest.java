package YK_Cracking8_RecDynamicMem_TESTS;

import YK_Cracking8_RecDynamicMem.YK_CoinsVars;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class YK_CoinsVarsTest {

    @Test
    void coins1() {
        //25-10-05-01

        //00-00-00-01
        assertEquals(1, new YK_CoinsVars().numCoinsVariations(1));
    }

    @Test
    void coins2() {
        //25-10-05-01

        //00-00-00-02
        assertEquals(1, new YK_CoinsVars().numCoinsVariations(2));
    }

    @Test
    void coins5() {
        //25-10-05-01

        //00-00-01-00
        //00-00-00-05
        assertEquals(2, new YK_CoinsVars().numCoinsVariations(5));
    }

    @Test
    void coins6() {
        //25-10-05-01

        //00-00-01-01
        //00-00-00-06
        assertEquals(2, new YK_CoinsVars().numCoinsVariations(5));
    }

    @Test
    void coins10() {
        //25-10-05-01

        //00-01-00-00
        //00-00-02-00
        //00-00-01-05
        //00-00-00-10
        assertEquals(4, new YK_CoinsVars().numCoinsVariations(10));
    }

    @Test
    void coins11() {
        //25-10-05-01

        //00-01-00-01
        //00-00-02-01
        //00-00-01-06
        //00-00-00-11
        assertEquals(4, new YK_CoinsVars().numCoinsVariations(11));
    }

    @Test
    void coins15() {
        //25-10-05-01

        //00-01-01-00
        //00-01-00-05
        //00-00-03-00
        //00-00-02-05
        //00-00-01-10
        //00-00-00-15
        assertEquals(6, new YK_CoinsVars().numCoinsVariations(15));
    }

    @Test
    void coins16() {
        //25-10-05-01

        //00-01-01-01
        //00-01-00-06
        //00-00-03-01
        //00-00-02-06
        //00-00-01-11
        //00-00-00-16
        assertEquals(6, new YK_CoinsVars().numCoinsVariations(16));
    }

    @Test
    void coins20() {
        //25-10-05-01

        //00-02-00-00
        //00-01-02-00
        //00-01-01-05
        //00-01-00-10
        //00-00-04-00
        //00-00-03-05
        //00-00-02-10
        //00-00-01-15
        //00-00-00-20
        assertEquals(9, new YK_CoinsVars().numCoinsVariations(20));
    }

    @Test
    void coins21() {
        //25-10-05-01

        //00-02-00-01
        //00-01-02-01
        //00-01-01-06
        //00-01-00-11
        //00-00-04-01
        //00-00-03-06
        //00-00-02-11
        //00-00-01-16
        //00-00-00-21
        assertEquals(9, new YK_CoinsVars().numCoinsVariations(21));
    }

    @Test
    void coins25() {
        //25-10-05-01

        //01-00-00-00
        //00-02-01-00
        //00-02-00-05
        //00-01-03-00
        //00-01-02-05
        //00-01-01-10
        //00-01-00-15
        //00-00-05-00
        //00-00-04-05
        //00-00-03-10
        //00-00-02-15
        //00-00-01-20
        //00-00-00-25
        assertEquals(13, new YK_CoinsVars().numCoinsVariations(25));
    }
}