package YK_Cracking17_Hard;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class YK_Hard21_VolumeHistogramTest {

    @Test
    void testFromBookCoversMostOrig() {
        int[] hist = {0,0,4,0,0,6,0,0,3,0,5,0,1,0,0,0};

        assertEquals(26, new YK_Hard21_VolumeHistogram().getWaterHistogramOrig(hist));
    }

    @Test
    void testFromBookCoversMostLookRightLeft() {
        int[] hist = {0,0,4,0,0,6,0,0,3,0,5,0,1,0,0,0};

        assertEquals(26, new YK_Hard21_VolumeHistogram().getWaterHistogramLookRightLeft(hist));
    }

    @Test
    void testFromBookCoversMostLookRightLeftStatistics() {
        Random rand = new Random();
        int[] hist = new int[1000];
        for(int i = 0; i < hist.length; i++) {
            hist[i] = rand.nextInt(100);
        }
        new YK_Hard21_VolumeHistogram().getWaterHistogramLookRightLeft(hist);
    }

}