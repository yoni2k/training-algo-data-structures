package YK_Cracking3_StacksQueues_TESTS;

import YK_Common.YK_Exception;
import YK_Cracking3_StacksQueues.YK_MultFlexStacksInOne;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class YK_MultFlexStacksInOneTest {

    @Test
    void maxThree() {
        YK_MultFlexStacksInOne stacks = new YK_MultFlexStacksInOne();

        assertTrue(stacks.empty(0));
        assertTrue(stacks.empty(1));
        assertTrue(stacks.empty(2));


        for (int i = 0; i < stacks.NUM_QUEUES; i++) {
            for (int j = 0; j < 10; j++) {
                stacks.push(i, 10*i + j);
                assertEquals(10*i + j, stacks.peep(i));

                assertFalse(stacks.empty(i));
            }
        }

        assertFalse(stacks.empty(0));
        assertFalse(stacks.empty(1));
        assertFalse(stacks.empty(2));

        for (int i = 0; i < stacks.NUM_QUEUES; i++) {
            for (int j = 10; j >= 0; j--) {

                if(j == 0) {
                    final int finalI = i;

                    assertTrue(stacks.empty(i));

                    YK_Exception exc = assertThrows(YK_Exception.class,()->stacks.pop(finalI));
                    assertTrue(exc.getMessage().contains("Empty"));

                    exc = assertThrows(YK_Exception.class, ()-> stacks.peep(finalI));
                    assertTrue(exc.getMessage().contains("Empty"));

                    assertTrue(stacks.empty(i));
                }
                else {
                    System.out.println("i: " + i + ", j: " + j + ", peep(i): " + stacks.peep(i));
                    assertEquals(10*i + j - 1, stacks.peep(i));
                    assertEquals(10*i + j - 1, stacks.pop(i));
                    if (j > 1) {
                        System.out.println("In IF: i: " + i + ", j: " + j + ", peep(i): " + stacks.peep(i));
                        assertEquals(10 * i + j - 2, stacks.peep(i));
                    }
                }
            }
        }
    }

    private int getArrayIndex_Last(int i) {
        switch(i % 6) {
            case 0:
                return 0;
            case 1:
            case 2:
            case 3:
                return 1;
            case 4:
            case 5:
                return 2;
        }

        throw new YK_Exception("Shouldn't get here");
    }

    private int getArrayIndex_Middle(int i) {
        switch(i % 6) {
            case 0:
                return 0;
            case 1:
            case 2:
            case 3:
                return 2;
            case 4:
            case 5:
                return 1;
        }

        throw new YK_Exception("Shouldn't get here");
    }

    private int getArrayIndex_Beg(int i) {
        switch(i % 6) {
            case 0:
                return 2;
            case 1:
            case 2:
            case 3:
                return 0;
            case 4:
            case 5:
                return 1;
        }

        throw new YK_Exception("Shouldn't get here");
    }

    @Test
    void diffLenThree() {
        YK_MultFlexStacksInOne stacks = new YK_MultFlexStacksInOne();

        assertTrue(stacks.empty(0));
        assertTrue(stacks.empty(1));
        assertTrue(stacks.empty(2));

        for (int i = 0; i <= stacks.MAX_QUEUES_SIZE; i++) {

            if(i == stacks.MAX_QUEUES_SIZE) {
                YK_Exception exc = assertThrows(YK_Exception.class,()->stacks.push(0,0));
                assertTrue(exc.getMessage().contains("No room"));

                exc = assertThrows(YK_Exception.class,()->stacks.push(1,0));
                assertTrue(exc.getMessage().contains("No room"));

                exc = assertThrows(YK_Exception.class,()->stacks.push(2,0));
                assertTrue(exc.getMessage().contains("No room"));

                stacks.printState();

                assertEquals(24, stacks.peep(0));
                assertEquals(27, stacks.peep(1));
                assertEquals(29, stacks.peep(2));
            }
            else {
                /*System.out.println("Before push i: " + i + " into array: " + getArrayIndex_Last(i));
                stacks.printState();*/

                stacks.push(getArrayIndex_Last(i), i);
                assertEquals(i, stacks.peep(getArrayIndex_Last(i)));

                System.out.println("After push i: " + i + " into array: " + getArrayIndex_Last(i));
                stacks.printState();

            }

            assertFalse(stacks.empty(getArrayIndex_Last(i)));
        }

        assertFalse(stacks.empty(0));
        assertFalse(stacks.empty(1));
        assertFalse(stacks.empty(2));

        for (int i = stacks.MAX_QUEUES_SIZE; i >= 0; i--) {
            if(i == 0) {

                assertTrue(stacks.empty(0));
                assertTrue(stacks.empty(1));
                assertTrue(stacks.empty(2));

                YK_Exception exc = assertThrows(YK_Exception.class,()->stacks.pop(0));
                assertTrue(exc.getMessage().contains("Empty"));

                exc = assertThrows(YK_Exception.class, ()-> stacks.peep(0));
                assertTrue(exc.getMessage().contains("Empty"));

                exc = assertThrows(YK_Exception.class,()->stacks.pop(1));
                assertTrue(exc.getMessage().contains("Empty"));

                exc = assertThrows(YK_Exception.class, ()-> stacks.peep(1));
                assertTrue(exc.getMessage().contains("Empty"));

                exc = assertThrows(YK_Exception.class,()->stacks.pop(2));
                assertTrue(exc.getMessage().contains("Empty"));

                exc = assertThrows(YK_Exception.class, ()-> stacks.peep(2));
                assertTrue(exc.getMessage().contains("Empty"));

                assertTrue(stacks.empty(0));
                assertTrue(stacks.empty(1));
                assertTrue(stacks.empty(2));
            }
            else {
                System.out.println("(i - 1)" + (i - 1) + ", getArrayIndex_Last(i - 1): " + getArrayIndex_Last(i - 1));

                stacks.printState();

                assertEquals(i - 1, stacks.peep(getArrayIndex_Last(i - 1)));
                assertEquals(i - 1, stacks.pop(getArrayIndex_Last(i - 1)));
            }
        }
    }
}