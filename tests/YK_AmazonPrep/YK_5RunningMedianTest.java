package YK_AmazonPrep;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class YK_5RunningMedianTest {

    @Test
    void testMyHeap() {
        YK_5Utils.testMedian(YK_5RunningMedian.YK_HEAP_TYPE.MY);
    }

    @Test
    void testPriorityHeadHeap() {
        YK_5Utils.testMedian(YK_5RunningMedian.YK_HEAP_TYPE.PRIORITY_QUEUE);
    }

}