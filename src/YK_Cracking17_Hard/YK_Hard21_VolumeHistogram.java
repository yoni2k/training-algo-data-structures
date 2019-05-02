package YK_Cracking17_Hard;

/*
Source: Cracking 17.21
Given a histogram (see book), check how much water will be in it

Implementation with memorization. Every pass is O(n),
    next pass is at worst case 1/2 n (the other half we either fill right away, or get with memorization.,
    therefore complexity is O(n log n).
    Space complexity O(n log n) - we put memotization for every point we touch

Includes another implementation after looking at the book of looking right and left -
    it's still O(n log n) both time and space, and not space O(n) both like in the book

Following optimization for memorization for solution 1, it's now O(n) memory, since it only saves points that either start with index 0
    or finish with index of the end.  It was probably the case before also, just wasn't that clear
 */

import java.awt.*;
import java.util.HashMap;

public class YK_Hard21_VolumeHistogram {

    private int fill(int[] hist, int start, int end) {
        if (start > (end - 2)) {
            return 0;
        }
        int height = Integer.min(hist[start], hist[end]);
        int water = (end - start - 1) * height;

        for (int i = start + 1; i < end; i++) {
            water -= hist[i];
        }

        System.out.println("fill, FINISH: " + start + ", end: " + end + ", water: " + water);
        return water;
    }

    private int getMaxInd(int[] hist, int start, int end, HashMap<Point, Integer> memMaxInds) {
        Point p = new Point(start, end);
        if (start == end) {
            return start;
        } else if (memMaxInds.containsKey(p)) {
            System.out.println("Statistics: getMaxInd returning from MEMORY: start: " + start + ", end: " + end);
            return memMaxInds.get(p);
        }
        System.out.println("Statistics: getMaxInd CALCULATING, start: " + start + ", end: " + end);

        int max = hist[start];
        int ind = start;

        for (int i = start + 1; i <= end; i++) {
            if (hist[i] > max) {
                max = hist[i];
                ind = i;
            }
            memMaxInds.put(new Point(start, i), ind);
        }
        return ind;
    }

    private int getWater(int[] hist, int start, int end, HashMap<Point, Integer> memMaxInds) {
        System.out.println("getWater START, start: " + start + ", end: " + end);
        if ((start >= hist.length) || ((end - start) < 2)) {
            return 0;
        }

        int water = 0;
        int maxInd = getMaxInd(hist, start, end, memMaxInds);
        if (maxInd < (end - 2)) {
            int maxRightInd = getMaxInd(hist, maxInd + 1, end, memMaxInds);
            water += fill(hist, maxInd, maxRightInd);
            water += getWater(hist, maxRightInd, end, memMaxInds);
        }
        if (maxInd > (start + 2)) {
            int maxLeftInd = getMaxInd(hist, start, maxInd - 1, memMaxInds);
            water += fill(hist, maxLeftInd, maxInd);
            water += getWater(hist, start, maxLeftInd, memMaxInds);
        }
        //System.out.println("getWater END, start: " + start + ", end: " + end + ", water: " + water);
        return water;

    }

    public int getWaterHistogramOrig(int[] hist) {
        HashMap<Point, Integer> memMaxInds = new HashMap<>();
        helpMemo(hist, memMaxInds);
        return getWater(hist, 0, hist.length - 1, memMaxInds);
    }

    private void helpMemo(int[] hist, HashMap<Point, Integer> memMaxInds) {
        int max = hist[0];
        int maxInd = 0;
        for(int i = 1; i < hist.length; i++) {
            if(hist[i] > max) {
                max = hist[i];
                maxInd = i;
            }
            memMaxInds.put(new Point(0, i), maxInd);
        }

        max = hist[hist.length - 1];
        maxInd = hist.length - 1;
        for(int i = (hist.length - 2); i >= 0; i--) {
            if(hist[i] > max) {
                max = hist[i];
                maxInd = i;
            }
            memMaxInds.put(new Point(i, hist.length - 1), maxInd);
        }
    }

    /**
     * After reading a tip in the book how to do it differently
     */

    private int getMax(int[] hist, int start, int end, HashMap<Point, Integer> memMaxInds) {
        if((start > end) || (start < 0) || (end > (hist.length - 1))) {
            return -1;
        }
        System.out.println("getMax - start: " + start + ", end: " + end);
        return hist[getMaxInd(hist, start, end, memMaxInds)];
    }

    private int getSingleWater(int value, int maxLeft, int maxRight) {
        if((maxLeft == -1) || (maxRight == -1)) {
            System.out.println("getSingleWater, one of max values negative, water: 0, value: " + value + ", maxLeft: " + maxLeft + ", maxRight: " + maxRight);
            return 0;
        }
        int thisWater = Integer.min(maxLeft, maxRight) - value;
        System.out.println("getSingleWater, value: " + value + ", maxLeft: " + maxLeft + ", maxRight: " + maxRight + ", water: " + ((thisWater > 0) ? thisWater : 0));
        return (thisWater > 0) ? thisWater : 0;
    }

    private int lookRightLeft(int[] hist, int start, int end, int maxLeft, int maxRight, HashMap<Point, Integer> memMaxInds) {
        System.out.println("lookRightLeft START - start: " + start + ", end: " + end + ", maxLeft: " + maxLeft + ", maxRight: " + maxRight);
        if((start > end) || (start < 0) || (end > (hist.length - 1))) {
            System.out.println("lookRightLeft SPECIAL FINISH (0)- start: " + start + ", end: " + end + ", maxLeft: " + maxLeft + ", maxRight: " + maxRight + ", water: 0");
            return 0;
        } else if(start == end) {
            System.out.println("lookRightLeft SPECIAL FINISH (1)- start: " + start + ", end: " + end + ", maxLeft: " + maxLeft + ", maxRight: " + maxRight);
            return getSingleWater(hist[start], maxLeft, maxRight);
        }
        int water = 0;
        int mid = (end + start) / 2;
        int newMaxLeft = getMax(hist, start, mid - 1, memMaxInds);
        int newMaxRight = getMax(hist, mid + 1, end, memMaxInds);
        //System.out.println("newMaxRight 1: " + newMaxRight + ", (mid + 1): " + (mid + 1) + ", end: " + end + ", value: " + hist[mid+1]);

        newMaxLeft = Integer.max(newMaxLeft, maxLeft);
        newMaxRight = Integer.max(newMaxRight, maxRight);
        //System.out.println("newMaxRight 2: " + newMaxRight);
        water += getSingleWater(hist[mid], newMaxLeft, newMaxRight);

        newMaxLeft = Integer.max(newMaxLeft, hist[mid]);
        newMaxRight = Integer.max(newMaxRight, hist[mid]);

        water += lookRightLeft(hist, start, mid - 1, maxLeft, newMaxRight, memMaxInds);
        water += lookRightLeft(hist, mid + 1, end, newMaxLeft, maxRight, memMaxInds);

        System.out.println("lookRightLeft FINISH - start: " + start + ", end: " + end + ", maxLeft: " + maxLeft + ", maxRight: " + maxRight + ", water: " + water);
        return water;
    }

    public int getWaterHistogramLookRightLeft(int[] hist) {
        HashMap<Point, Integer> memMaxInds = new HashMap<>();
        helpMemo(hist, memMaxInds);//TODO - didn't help, should leave?
        return lookRightLeft(hist, 0, hist.length - 1, -1, -1, memMaxInds);
    }
}
