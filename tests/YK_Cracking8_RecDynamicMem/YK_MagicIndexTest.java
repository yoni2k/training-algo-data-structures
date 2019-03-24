package YK_Cracking8_RecDynamicMem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class YK_MagicIndexTest {

    @Test
    void oneYes() {
        int[] arr = {0};

        assertEquals(0, new YK_MagicIndex().getMagicIndex(arr));
    }

    @Test
    void oneNoUp() {
        int[] arr = {1};

        assertEquals(-1, new YK_MagicIndex().getMagicIndex(arr));
    }

    @Test
    void oneNoDown() {
        int[] arr = {-1};

        assertEquals(-1, new YK_MagicIndex().getMagicIndex(arr));
    }

    @Test
    void twoYes0() {
        int[] arr = {0,2};

        assertEquals(0, new YK_MagicIndex().getMagicIndex(arr));
    }

    @Test
    void twoYes1() {
        int[] arr = {-1,1};

        assertEquals(1, new YK_MagicIndex().getMagicIndex(arr));
    }

    @Test
    void twoNoAllSmaller() {
        int[] arr = {-1,0};

        assertEquals(-1, new YK_MagicIndex().getMagicIndex(arr));
    }

    @Test
    void twoNoAllLarger() {
        int[] arr = {1,2};

        assertEquals(-1, new YK_MagicIndex().getMagicIndex(arr));
    }

    @Test
    void threeYes0() {
        int[] arr = {0,2,3};

        assertEquals(0, new YK_MagicIndex().getMagicIndex(arr));
    }

    @Test
    void threeYes1() {
        int[] arr = {-1,1,3};

        assertEquals(1, new YK_MagicIndex().getMagicIndex(arr));
    }

    @Test
    void threeYes2() {
        int[] arr = {-1,0,2};

        assertEquals(2, new YK_MagicIndex().getMagicIndex(arr));
    }

    @Test
    void threeNoAllSmall() {
        int[] arr = {-1,0,1};

        assertEquals(-1, new YK_MagicIndex().getMagicIndex(arr));
    }

    @Test
    void threeNoAllLarge() {
        int[] arr = {1,2,3};

        assertEquals(-1, new YK_MagicIndex().getMagicIndex(arr));
    }

    @Test
    void largeEvenYesDown() {
        int[] arr = {-1,0,1,3,5,6,7,8,9,10};

        assertEquals(3, new YK_MagicIndex().getMagicIndex(arr));
    }

    @Test
    void largeEvenYesUp() {
        int[] arr = {-1,0,1,2,3,4,5,6,7,9};

        assertEquals(9, new YK_MagicIndex().getMagicIndex(arr));
    }

    @Test
    void largeOddYesDown() {
        int[] arr = {-1,0,1,3,5,6,7,8,9,10,11};

        assertEquals(3, new YK_MagicIndex().getMagicIndex(arr));
    }

    @Test
    void largeOddYesUp() {
        int[] arr = {-1,0,1,2,3,4,5,6,7,9,11};

        assertEquals(9, new YK_MagicIndex().getMagicIndex(arr));
    }

    @Test
    void allMatching() {
        int[] arr = {0,1,2,3};

        assertEquals(2, new YK_MagicIndex().getMagicIndex(arr));
    }
}