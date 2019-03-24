package YK_Cracking3_StacksQueues;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class YK_StackPlatesTest {

    @Test
    void stacks() {
        YK_StackPlates stack = new YK_StackPlates(3);

        assertTrue(stack.empty());

        for (int i = 0; i < 12; i++)
        {
            stack.push(i*10);
            assertEquals(i*10, stack.peek());
            assertFalse(stack.empty());

            stack.push(i*10 + 1);
            assertEquals(i*10 + 1, stack.peek());
            assertFalse(stack.empty());

            assertEquals(i*10 + 1, stack.pop());
            assertEquals(i*10, stack.peek());
            assertFalse(stack.empty());
        }

        for (int i = 12; i < 24; i++) {

            assertFalse(stack.empty());

            stack.push(i*10);
            assertFalse(stack.empty());

            assertEquals(i*10, stack.peek());
            assertEquals(i*10, stack.pop());
            assertFalse(stack.empty());

            assertEquals((23-i)*10, stack.peek());
            assertEquals((23-i)*10, stack.pop());
        }
    }

    @Test
    void capacity1() {
        YK_StackPlates stack = new YK_StackPlates(1);

        assertTrue(stack.empty());

        for (int i = 0; i < 12; i++)
        {
            stack.push(i*10);
            assertEquals(i*10, stack.peek());
            assertFalse(stack.empty());

            stack.push(i*10 + 1);
            assertEquals(i*10 + 1, stack.peek());
            assertFalse(stack.empty());

            assertEquals(i*10 + 1, stack.pop());
            assertEquals(i*10, stack.peek());
            assertFalse(stack.empty());
        }

        for (int i = 12; i < 24; i++) {

            assertFalse(stack.empty());

            stack.push(i*10);
            assertFalse(stack.empty());

            assertEquals(i*10, stack.peek());
            assertEquals(i*10, stack.pop());
            assertFalse(stack.empty());

            assertEquals((23-i)*10, stack.peek());
            assertEquals((23-i)*10, stack.pop());
        }
    }

    private void checkThrowInvalidIndex(YK_StackPlates stack, int index) {
        assertThrows(IndexOutOfBoundsException.class, ()->stack.popAt(index));
    }

    @Test
    void stacksAt1Each() {
        YK_StackPlates stack = new YK_StackPlates(3);

        assertTrue(stack.empty());

        checkThrowInvalidIndex(stack,0);
        checkThrowInvalidIndex(stack,1);


        for (int i = 0; i < 12; i++)
        {
            stack.push(i*10);
            assertEquals(i*10, stack.peek());
            assertFalse(stack.empty());
        }

        checkThrowInvalidIndex(stack,4);

        assertEquals(5*10, stack.popAt(1));
        assertEquals(11*10, stack.peek());
        assertFalse(stack.empty());

        assertEquals(2*10, stack.popAt(0));
        assertEquals(11*10, stack.peek());
        assertFalse(stack.empty());

        assertEquals(11*10, stack.popAt(3));
        assertEquals(10*10, stack.peek());
        assertFalse(stack.empty());

        assertEquals(8*10, stack.popAt(2));
        assertEquals(10*10, stack.peek());
        assertFalse(stack.empty());

        for (int i = 11; i >= 0; i--) {

            if((i % 3) == 2) continue;

            assertFalse(stack.empty());
            assertEquals(i*10, stack.peek());
            assertEquals(i*10, stack.pop());
        }

        checkThrowInvalidIndex(stack,4);
        checkThrowInvalidIndex(stack,3);
        checkThrowInvalidIndex(stack,2);
        checkThrowInvalidIndex(stack,1);
        checkThrowInvalidIndex(stack,0);
        assertTrue(stack.empty());
    }

    @Test
    void stacksRemoveTopStack() {
        YK_StackPlates stack = new YK_StackPlates(3);

        assertTrue(stack.empty());

        for (int i = 0; i < 12; i++)
        {
            stack.push(i*10);
            assertEquals(i*10, stack.peek());
            assertFalse(stack.empty());
        }

        assertEquals(11*10, stack.popAt(3));
        assertEquals(10*10, stack.peek());
        assertFalse(stack.empty());

        assertEquals(10*10, stack.popAt(3));
        assertEquals(9*10, stack.peek());
        assertFalse(stack.empty());

        assertEquals(9*10, stack.popAt(3));
        assertEquals(8*10, stack.peek());
        assertFalse(stack.empty());

        checkThrowInvalidIndex(stack,3);

        for (int i = 8; i >= 0; i--) {

            assertFalse(stack.empty());
            assertEquals(i*10, stack.peek());
            assertEquals(i*10, stack.pop());
        }

        assertTrue(stack.empty());
    }

    @Test
    void stacksRemoveMiddleStack() {
        YK_StackPlates stack = new YK_StackPlates(3);

        assertTrue(stack.empty());

        for (int i = 0; i < 12; i++)
        {
            stack.push(i*10);
            assertEquals(i*10, stack.peek());
            assertFalse(stack.empty());
        }

        assertEquals(8*10, stack.popAt(2));
        assertEquals(11*10, stack.peek());
        assertFalse(stack.empty());

        assertEquals(7*10, stack.popAt(2));
        assertEquals(11*10, stack.peek());
        assertFalse(stack.empty());

        assertEquals(6*10, stack.popAt(2));
        assertEquals(11*10, stack.peek());
        assertFalse(stack.empty());

        checkThrowInvalidIndex(stack,3);

        for (int i = 11; i >= 0; i--) {

            if((i>= 6) && (i<=8)) continue;

            assertFalse(stack.empty());
            assertEquals(i*10, stack.peek());
            assertEquals(i*10, stack.pop());
        }

        assertTrue(stack.empty());
    }


    @Test
    void stacksRemoveBottomStack() {
        YK_StackPlates stack = new YK_StackPlates(3);

        assertTrue(stack.empty());

        for (int i = 0; i < 12; i++)
        {
            stack.push(i*10);
            assertEquals(i*10, stack.peek());
            assertFalse(stack.empty());
        }

        assertEquals(2*10, stack.popAt(0));
        assertEquals(11*10, stack.peek());
        assertFalse(stack.empty());

        assertEquals(1*10, stack.popAt(0));
        assertEquals(11*10, stack.peek());
        assertFalse(stack.empty());

        assertEquals(0*10, stack.popAt(0));
        assertEquals(11*10, stack.peek());
        assertFalse(stack.empty());

        checkThrowInvalidIndex(stack,3);

        for (int i = 11; i >= 3; i--) {

            assertFalse(stack.empty());
            assertEquals(i*10, stack.peek());
            assertEquals(i*10, stack.pop());
        }

        assertTrue(stack.empty());
    }
}