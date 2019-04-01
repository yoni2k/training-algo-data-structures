package YK_AmazonPrep;

import java.util.ArrayList;

/*
Given a stream of numbers, add them to a list, and give for every number added a running median
 */

public class YK_5RunningMedian {

    enum YK_HEAP_TYPE {MY, PRIORITY_QUEUE}

    YK_HEAP_TYPE heapType;

    YK_5RunningMedian(YK_HEAP_TYPE heapType) {
        this.heapType = heapType;
    }

    public double[] runningMedian(int[] a) {
        ArrayList<Double> medians = new ArrayList<>();
        YK_5MinMaxHeapInterface smallInts;
        YK_5MinMaxHeapInterface largeInts;
        if (heapType == YK_HEAP_TYPE.MY) {
            smallInts = new YK_5MinMaxMyHeap(YK_5MinMaxMyHeap.YK_MIN_MAX.MAX);
            largeInts = new YK_5MinMaxMyHeap(YK_5MinMaxMyHeap.YK_MIN_MAX.MIN);
        } else {
            smallInts = new YK_5MinMaxHeapPriorityQueue(YK_5MinMaxHeapPriorityQueue.YK_MIN_MAX.MAX);
            largeInts = new YK_5MinMaxHeapPriorityQueue(YK_5MinMaxHeapPriorityQueue.YK_MIN_MAX.MIN);
        }

        int median;
        int newInt;
        int prev;
        int next;

        median = a[0];
        medians.add((double) median);

        for (int i = 1; i < a.length; i++) {
            newInt = a[i];
            prev = Integer.MIN_VALUE;
            if (smallInts.empty() == false) {
                prev = smallInts.peek();
            }
            next = Integer.MAX_VALUE;
            if (largeInts.empty() == false) {
                next = largeInts.peek();
            }

            if (median == -1) {
                if ((newInt >= prev) && (newInt < next)) {
                    median = newInt;
                } else if (newInt < prev) {
                    median = smallInts.pop();
                    smallInts.push(newInt);
                } else {
                    median = largeInts.pop();
                    largeInts.push(newInt);
                }
                medians.add((double) median);
            } else { //median exists
                if (newInt > median) {
                    smallInts.push(median);
                    largeInts.push(newInt);
                    median = -1;
                } else { //newInt <= median
                    smallInts.push(newInt);
                    largeInts.push(median);
                    median = -1;
                }
                medians.add(((double) smallInts.peek() + largeInts.peek()) / 2);
            }
        }

        double[] arrToReturn = new double[medians.size()];
        for (int i = 0; i < arrToReturn.length; i++) {
            arrToReturn[i] = medians.get(i);
        }

        return arrToReturn;
    }
}
