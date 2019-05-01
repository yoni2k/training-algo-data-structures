package YK_Cracking17_Hard;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class YK_Hard16_ApptsWithBreaksTest {

    @Test
    void testRecursive() {
        int[] appts = {1,2,1,3,4,1,1,7};
        assertEquals(13, new YK_Hard16_ApptsWithBreaks().getBestAppsLenRecursive(appts));
    }

    @Test
    void testIterative() {
        int[] appts = {1,2,1,3,4,1,1,7};
        assertEquals(13, new YK_Hard16_ApptsWithBreaks().getBestAppsLenIterative(appts));
    }

    @Test
    void testIterativeNoExtraSpace() {
        int[] appts = {1,2,1,3,4,1,1,7};
        assertEquals(13, new YK_Hard16_ApptsWithBreaks().getBestAppsLenIterativeNoSpace(appts));
    }
}