package YK_Cracking8_RecDynamicMem_TESTS;

import YK_Cracking8_RecDynamicMem.YK_RecurseMult;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class YK_RecurseMultTest {

    @Test
    void testCorrectResult() {

        for(int i = 0; i < 500; i++) {
            for (int j = 0; j < i; j++) {
                assertEquals(i * j, new YK_RecurseMult().recursiveMultiple(j, i));
                assertEquals(i * j, new YK_RecurseMult().recursiveMultiple(i, j));
            }
        }
    }

    @Test
    void testNumActions() {
        int a = 0x123;
        int b = 1;

        int numActions = 0;
        int numActionsForI;
        int maxNumActionsForI = 0;

        for(int i = 0; i < 30; i++) {
            YK_RecurseMult recurseMult = new YK_RecurseMult();
            assertEquals(a * b, recurseMult.recursiveMultiple(a, b));
            numActionsForI = recurseMult.getActions();
            maxNumActionsForI = Math.max(maxNumActionsForI, numActionsForI);

            numActions += numActionsForI;
            System.out.println("i: " + i + ", b: " + b + ", numActionsForI: " + numActionsForI + ", maxNumActionsForI: " + maxNumActionsForI + ", numActions: " + numActions);

            b = (b*2 - i + 1);
        }

    }

}