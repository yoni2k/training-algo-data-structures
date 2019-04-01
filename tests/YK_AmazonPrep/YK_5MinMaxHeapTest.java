package YK_AmazonPrep;

import org.junit.jupiter.api.Test;

class YK_5MinMaxHeapTest {

    @Test
    void testEmptyMin() {
        YK_5Utils.testEmptyMin(new YK_5MinMaxMyHeap(YK_5MinMaxMyHeap.YK_MIN_MAX.MIN));
    }

    @Test
    void test1memberMin() {
        YK_5Utils.test1memberMin(new YK_5MinMaxMyHeap(YK_5MinMaxMyHeap.YK_MIN_MAX.MIN));
    }

    @Test
    void test2memberMin() {
        YK_5Utils.test2memberMin(new YK_5MinMaxMyHeap(YK_5MinMaxMyHeap.YK_MIN_MAX.MIN));
    }

    @Test
    void test2memberOppOrderMin() {
        YK_5Utils.test2memberOppOrderMin(new YK_5MinMaxMyHeap(YK_5MinMaxMyHeap.YK_MIN_MAX.MIN));
    }

    @Test
    void testLargeMin() {
        YK_5Utils.testLargeMin(new YK_5MinMaxMyHeap(YK_5MinMaxMyHeap.YK_MIN_MAX.MIN));
    }

    @Test
    void testEmptyMax() {
        YK_5Utils.testEmptyMax(new YK_5MinMaxMyHeap(YK_5MinMaxMyHeap.YK_MIN_MAX.MAX));
    }

    @Test
    void test1memberMax() {
        YK_5Utils.test1memberMax(new YK_5MinMaxMyHeap(YK_5MinMaxMyHeap.YK_MIN_MAX.MAX));
    }

    @Test
    void test2memberMax() {
        YK_5Utils.test2memberMax(new YK_5MinMaxMyHeap(YK_5MinMaxMyHeap.YK_MIN_MAX.MAX));
    }

    @Test
    void test2memberOppOrderMax() {
        YK_5Utils.test2memberOppOrderMax(new YK_5MinMaxMyHeap(YK_5MinMaxMyHeap.YK_MIN_MAX.MAX));
    }

    @Test
    void testLargeMax() {
        YK_5Utils.testLargeMax(new YK_5MinMaxMyHeap(YK_5MinMaxMyHeap.YK_MIN_MAX.MAX));
    }

}