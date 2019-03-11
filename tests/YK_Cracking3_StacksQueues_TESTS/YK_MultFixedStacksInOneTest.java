package YK_Cracking3_StacksQueues_TESTS;

import YK_Common.YK_Exception;
import YK_Cracking3_StacksQueues.YK_MultFixedStacksInOne;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class YK_MultFixedStacksInOneTest {

    @Test
    void maxThree() {
        YK_MultFixedStacksInOne stacks = new YK_MultFixedStacksInOne();

        assertTrue(stacks.empty(0));
        assertTrue(stacks.empty(1));
        assertTrue(stacks.empty(2));


        for (int i = 0; i < stacks.NUM_STACKS; i++) {
            for (int j = 0; j <= stacks.MAX_STACK_SIZE; j++) {

                if(j == stacks.MAX_STACK_SIZE) {
                    final int finalI = i;
                    YK_Exception exc = assertThrows(YK_Exception.class,()->stacks.push(finalI,0));
                    assertTrue(exc.getMessage().contains("No room"));
                    assertEquals(10*i + j - 1, stacks.peep(i));
                }
                else {
                    if(j > 0)
                        assertEquals(10*i + j - 1, stacks.peep(i));
                    stacks.push(i, 10*i + j);
                    assertEquals(10*i + j, stacks.peep(i));
                }

                assertFalse(stacks.empty(i));
            }
        }

        assertFalse(stacks.empty(0));
        assertFalse(stacks.empty(1));
        assertFalse(stacks.empty(2));

        for (int i = 0; i < stacks.NUM_STACKS; i++) {
            for (int j = stacks.MAX_STACK_SIZE; j >= 0; j--) {

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
                    assertEquals(10*i + j - 1, stacks.peep(i));
                    assertEquals(10*i + j - 1, stacks.pop(i));
                    if (j > 1) {
                        assertEquals(10 * i + j - 2, stacks.peep(i));
                    }
                }
            }
        }
    }
}