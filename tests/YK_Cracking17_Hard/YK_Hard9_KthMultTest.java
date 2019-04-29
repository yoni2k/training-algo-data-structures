package YK_Cracking17_Hard;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class YK_Hard9_KthMultTest {
    @Test
    void testOriginalPQ() {
        assertEquals(1,new YK_Hard9_KthMult().getKthPQ(1));
        assertEquals(3,new YK_Hard9_KthMult().getKthPQ(2));
        assertEquals(5,new YK_Hard9_KthMult().getKthPQ(3));
        assertEquals(7,new YK_Hard9_KthMult().getKthPQ(4));
        assertEquals(9,new YK_Hard9_KthMult().getKthPQ(5));
        assertEquals(15,new YK_Hard9_KthMult().getKthPQ(6));
        assertEquals(21,new YK_Hard9_KthMult().getKthPQ(7));
        assertEquals(25,new YK_Hard9_KthMult().getKthPQ(8));
        assertEquals(27,new YK_Hard9_KthMult().getKthPQ(9));
        assertEquals(35,new YK_Hard9_KthMult().getKthPQ(10));

        for(int i = 11; i < 100; i++) {
            new YK_Hard9_KthMult().getKthPQ(i);
        }
    }

    @Test
    void testImproved3Lists() {
        assertEquals(1,new YK_Hard9_KthMult().getKthNoPQ(1));
        assertEquals(3,new YK_Hard9_KthMult().getKthNoPQ(2));
        assertEquals(5,new YK_Hard9_KthMult().getKthNoPQ(3));
        assertEquals(7,new YK_Hard9_KthMult().getKthNoPQ(4));
        assertEquals(9,new YK_Hard9_KthMult().getKthNoPQ(5));
        assertEquals(15,new YK_Hard9_KthMult().getKthNoPQ(6));
        assertEquals(21,new YK_Hard9_KthMult().getKthNoPQ(7));
        assertEquals(25,new YK_Hard9_KthMult().getKthNoPQ(8));
        assertEquals(27,new YK_Hard9_KthMult().getKthNoPQ(9));
        assertEquals(35,new YK_Hard9_KthMult().getKthNoPQ(10));

        for(int i = 11; i < 100; i++) {
            new YK_Hard9_KthMult().getKthNoPQ(i);
        }
    }

}