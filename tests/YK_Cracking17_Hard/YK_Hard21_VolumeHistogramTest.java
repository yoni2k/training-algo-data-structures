package YK_Cracking17_Hard;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class YK_Hard21_VolumeHistogramTest {

    @Test
    void testFromBookCoversMost() {
        int[] hist = {0,0,4,0,0,6,0,0,3,0,5,0,1,0,0,0};

        assertEquals(26, new YK_Hard21_VolumeHistogram().getWaterHistogram(hist));
    }

}