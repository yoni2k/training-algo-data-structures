package YK_Cracking17_Hard;

import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class YK_Hard1_PlusNoArithmTest {

    private final int NUM_TIMES = 100;

    @Test
    void testLogSimple() {
        assertEquals(0, new YK_Hard1_PlusNoArithm().plusNoArithPositiveBitByBit(0,0));
        assertEquals(1, new YK_Hard1_PlusNoArithm().plusNoArithPositiveBitByBit(1,0));
        assertEquals(1, new YK_Hard1_PlusNoArithm().plusNoArithPositiveBitByBit(0,1));
        assertEquals(2, new YK_Hard1_PlusNoArithm().plusNoArithPositiveBitByBit(1,1));

        for(int i = 0; i < NUM_TIMES; i++) {
            for(int j = 0; j < NUM_TIMES; j++) {
                assertEquals(i+j, new YK_Hard1_PlusNoArithm().plusNoArithPositiveBitByBit(i,j));
            }
         }
    }

    @Test
    void testLog() {
        Random rand = new Random();
        int one;
        int two;
        for(int i = 0; i < NUM_TIMES; i++) {
            one = rand.nextInt();
            two = rand.nextInt();
            if ((one < 0) || (two < 0)) {
                continue;
            }
            if(((long)one + two) != (one + two)) {
                continue;
            }
            assertEquals(one+two, new YK_Hard1_PlusNoArithm().plusNoArithPositiveBitByBit(one,two));
        }
    }

    @Test
    void testXorAndSimple() {
        assertEquals(0, new YK_Hard1_PlusNoArithm().plusNoArithPositiveXorAnd(0,0));
        assertEquals(1, new YK_Hard1_PlusNoArithm().plusNoArithPositiveXorAnd(1,0));
        assertEquals(1, new YK_Hard1_PlusNoArithm().plusNoArithPositiveXorAnd(0,1));
        assertEquals(2, new YK_Hard1_PlusNoArithm().plusNoArithPositiveXorAnd(1,1));

        for(int i = 0; i < NUM_TIMES; i++) {
            for(int j = 0; j < NUM_TIMES; j++) {
                assertEquals(i+j, new YK_Hard1_PlusNoArithm().plusNoArithPositiveXorAnd(i,j));
            }
        }
    }

    @Test
    void testXorAnd() {
        Random rand = new Random();
        int one;
        int two;
        for(int i = 0; i < NUM_TIMES; i++) {
            one = rand.nextInt();
            two = rand.nextInt();
            if ((one < 0) || (two < 0)) {
                continue;
            }
            if(((long)one + two) != (one + two)) {
                continue;
            }
            assertEquals(one+two, new YK_Hard1_PlusNoArithm().plusNoArithPositiveXorAnd(one,two));
        }
    }

}