package YK_Cracking17_Hard;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class YK_Hard6_SumOf2sTest {

    @Test
    void test() {
        assertEquals(0, new YK_Hard6_SumOf2s().count2s(0));
        assertEquals(0, new YK_Hard6_SumOf2s().count2s(1));
        assertEquals(1, new YK_Hard6_SumOf2s().count2s(2));
        assertEquals(1, new YK_Hard6_SumOf2s().count2s(5));
        assertEquals(1, new YK_Hard6_SumOf2s().count2s(11));
        assertEquals(2, new YK_Hard6_SumOf2s().count2s(12));
        assertEquals(2, new YK_Hard6_SumOf2s().count2s(13));
        assertEquals(2, new YK_Hard6_SumOf2s().count2s(19));
        assertEquals(3, new YK_Hard6_SumOf2s().count2s(20));
        assertEquals(4, new YK_Hard6_SumOf2s().count2s(21));
        assertEquals(6, new YK_Hard6_SumOf2s().count2s(22));
        assertEquals(13, new YK_Hard6_SumOf2s().count2s(29));
        assertEquals(13, new YK_Hard6_SumOf2s().count2s(30));

        assertEquals(13, new YK_Hard6_SumOf2s().count2s(31));
        assertEquals(14, new YK_Hard6_SumOf2s().count2s(32));
        assertEquals(14, new YK_Hard6_SumOf2s().count2s(33));

        assertEquals(14, new YK_Hard6_SumOf2s().count2s(41));
        assertEquals(15, new YK_Hard6_SumOf2s().count2s(42));
        assertEquals(15, new YK_Hard6_SumOf2s().count2s(43));

        assertEquals(22, new YK_Hard6_SumOf2s().count2s(119));
        assertEquals(23, new YK_Hard6_SumOf2s().count2s(120));
        assertEquals(24, new YK_Hard6_SumOf2s().count2s(121));
        assertEquals(26, new YK_Hard6_SumOf2s().count2s(122));
        assertEquals(33, new YK_Hard6_SumOf2s().count2s(129));

        assertEquals(40, new YK_Hard6_SumOf2s().count2s(199));
        assertEquals(41, new YK_Hard6_SumOf2s().count2s(200));

        assertEquals(88, new YK_Hard6_SumOf2s().count2s(233));
    }

}