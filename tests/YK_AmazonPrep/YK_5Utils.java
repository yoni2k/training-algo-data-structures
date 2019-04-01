package YK_AmazonPrep;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class YK_5Utils {

    static void testEmptyMin(YK_5MinMaxHeapInterface heap) {
        assertTrue(heap.empty());
        assertEquals(-1,heap.pop());
        assertEquals(-1,heap.peek());
        System.out.println(heap.toString());
    }

    static void test1memberMin(YK_5MinMaxHeapInterface heap) {
        heap.push(1);
        System.out.println("After adding 1: " + heap.toString());
        assertFalse(heap.empty());
        assertEquals(1,heap.peek());
        assertEquals(1,heap.pop());
        System.out.println("After removing 1: " + heap.toString());

        assertEquals(-1,heap.peek());
        assertEquals(-1,heap.pop());
        assertTrue(heap.empty());
    }

    static void test2memberMin(YK_5MinMaxHeapInterface heap) {
        heap.push(1);
        heap.push(2);
        System.out.println("After adding 1 & 2: " + heap.toString());
        assertFalse(heap.empty());
        assertEquals(1,heap.peek());
        assertEquals(1,heap.pop());
        System.out.println("After removing 1: " + heap.toString());

        assertFalse(heap.empty());
        assertEquals(2,heap.peek());
        assertEquals(2,heap.pop());
        System.out.println("After removing 2: " + heap.toString());

        assertEquals(-1,heap.peek());
        assertEquals(-1,heap.pop());
        assertTrue(heap.empty());
    }

    static void test2memberOppOrderMin(YK_5MinMaxHeapInterface heap) {
        heap.push(2);
        heap.push(1);
        System.out.println("After adding 1 & 2: " + heap.toString());
        assertFalse(heap.empty());
        assertEquals(1,heap.peek());
        assertEquals(1,heap.pop());
        System.out.println("After removing 1: " + heap.toString());

        assertFalse(heap.empty());
        assertEquals(2,heap.peek());
        assertEquals(2,heap.pop());
        System.out.println("After removing 2: " + heap.toString());

        assertEquals(-1,heap.peek());
        assertEquals(-1,heap.pop());
        assertTrue(heap.empty());
    }

    static void testLargeMin(YK_5MinMaxHeapInterface heap) {
        heap.push(4);
        assertEquals(4,heap.peek()); System.out.println("After Push 4: " + heap.toString());
        heap.push(7);
        assertEquals(4,heap.peek()); System.out.println("After Push 7: " + heap.toString());
        heap.push(9);
        assertEquals(4,heap.peek()); System.out.println("After Push 9: " + heap.toString());
        heap.push(2);
        assertEquals(2,heap.peek()); System.out.println("After Push 2: " + heap.toString());
        heap.push(6);
        assertEquals(2,heap.peek()); System.out.println("After Push 6: " + heap.toString());
        heap.push(3);
        assertEquals(2,heap.peek()); System.out.println("After Push 3: " + heap.toString());
        heap.push(8);
        assertEquals(2,heap.peek()); System.out.println("After Push 8: " + heap.toString());
        heap.push(1);
        assertEquals(1,heap.peek()); System.out.println("After Push 1: " + heap.toString());
        heap.push(5);
        assertEquals(1,heap.peek()); System.out.println("After Push 5: " + heap.toString());

        for(int i = 1; i <= 9; i++) {
            assertEquals(i,heap.pop()); System.out.println("After Pop " + i + ": " + heap.toString());
        }
        assertEquals(-1,heap.peek());
        assertTrue(heap.empty());
        assertEquals(-1,heap.pop());
        assertEquals(-1,heap.peek());
        assertTrue(heap.empty());
    }

    static void testEmptyMax(YK_5MinMaxHeapInterface heap) {
        assertTrue(heap.empty());
        assertEquals(-1,heap.pop());
        assertEquals(-1,heap.peek());
        System.out.println(heap.toString());
    }

    static void test1memberMax(YK_5MinMaxHeapInterface heap) {
        heap.push(1);
        System.out.println("After adding 1: " + heap.toString());
        assertFalse(heap.empty());
        assertEquals(1,heap.peek());
        assertEquals(1,heap.pop());
        System.out.println("After removing 1: " + heap.toString());

        assertEquals(-1,heap.peek());
        assertEquals(-1,heap.pop());
        assertTrue(heap.empty());
    }

    static void test2memberMax(YK_5MinMaxHeapInterface heap) {
        heap.push(2);
        heap.push(1);
        System.out.println("After adding 1 & 2: " + heap.toString());
        assertFalse(heap.empty());
        assertEquals(2,heap.peek());
        assertEquals(2,heap.pop());
        System.out.println("After removing 2: " + heap.toString());

        assertFalse(heap.empty());
        assertEquals(1,heap.peek());
        assertEquals(1,heap.pop());
        System.out.println("After removing 1: " + heap.toString());

        assertEquals(-1,heap.peek());
        assertEquals(-1,heap.pop());
        assertTrue(heap.empty());
    }

    static void test2memberOppOrderMax(YK_5MinMaxHeapInterface heap) {
        heap.push(1);
        heap.push(2);
        System.out.println("After adding 1 & 2: " + heap.toString());
        assertFalse(heap.empty());
        assertEquals(2,heap.peek());
        assertEquals(2,heap.pop());
        System.out.println("After removing 2: " + heap.toString());

        assertFalse(heap.empty());
        assertEquals(1,heap.peek());
        assertEquals(1,heap.pop());
        System.out.println("After removing 1: " + heap.toString());

        assertEquals(-1,heap.peek());
        assertEquals(-1,heap.pop());
        assertTrue(heap.empty());
    }

    static void testLargeMax(YK_5MinMaxHeapInterface heap) {
        heap.push(5);
        assertEquals(5,heap.peek()); System.out.println("After Push 5: " + heap.toString());
        heap.push(1);
        assertEquals(5,heap.peek()); System.out.println("After Push 1: " + heap.toString());
        heap.push(8);
        assertEquals(8,heap.peek()); System.out.println("After Push 8: " + heap.toString());
        heap.push(3);
        assertEquals(8,heap.peek()); System.out.println("After Push 3: " + heap.toString());
        heap.push(6);
        assertEquals(8,heap.peek()); System.out.println("After Push 6: " + heap.toString());
        heap.push(2);
        assertEquals(8,heap.peek()); System.out.println("After Push 2: " + heap.toString());
        heap.push(9);
        assertEquals(9,heap.peek()); System.out.println("After Push 9: " + heap.toString());
        heap.push(7);
        assertEquals(9,heap.peek()); System.out.println("After Push 7: " + heap.toString());
        heap.push(4);
        assertEquals(9,heap.peek()); System.out.println("After Push 4: " + heap.toString());


        for(int i = 9; i >= 1; i--) {
            assertEquals(i,heap.pop()); System.out.println("After Pop " + i + ": " + heap.toString());
        }
        assertEquals(-1,heap.peek());
        assertTrue(heap.empty());
        assertEquals(-1,heap.pop());
        assertEquals(-1,heap.peek());
        assertTrue(heap.empty());
    }

    static void testMedian(YK_5RunningMedian.YK_HEAP_TYPE type) {
        YK_5RunningMedian runningMedian = new YK_5RunningMedian(type);

        int[] nums = {4,7,9,2,6,3,8,1,5};
        double[] expRunningMedians = {4.0,5.5,7.0,5.5,6.0,5.0,6.0,5.0,5.0};

        assertArrayEquals(expRunningMedians, runningMedian.runningMedian(nums));
    }
}
