package YK_Cracking17_Hard;

/*
Source: Cracking 17.21
Given a histogram (see book), check how much water will be in it

Implementation with memorization - looks like it's going to be O(n*log n). Still not happy
    since seems we are doing unnecessary work calculation 2 halfs for calculation 2nd max
 */

import java.awt.*;
import java.util.HashMap;

public class YK_Hard21_VolumeHistogram {

    private class YK_Mem {
        int max;
        int ind;

        YK_Mem(int max, int ind) {
            this.max = max;
            this.ind = ind;
        }
    }

    private int fill(int[] hist, int start, int end) {
        System.out.println("fill, start: " + start + ", end: " + end);
        int height = Integer.min(hist[start], hist[end]);
        int water = (end - start - 1) * height;

        for(int i = start + 1; i < end; i++) {
            water -= hist[i];
        }

        return water;
    }

    private YK_Mem getMax(int[] hist, int start, int end, HashMap<Point, YK_Mem> memMax) {
        Point p = new Point(start, end);
        if(memMax.containsKey(p)) {
            return memMax.get(p);
        }

        YK_Mem singleMem = new YK_Mem(Integer.MIN_VALUE, 0);
        for(int i = start; i <= end; i++) {
            if(hist[i] > singleMem.max) {
                singleMem = new YK_Mem(hist[i], i);
            }
            if(singleMem.max > Integer.MIN_VALUE) {
                memMax.put(new Point(start, i), singleMem);
            }
        }
        return singleMem;
    }

    private int getSecondMax(int[] hist, int start, int end, HashMap<Point, YK_Mem> memMax) {
        YK_Mem maxInfo = getMax(hist, start, end, memMax);
        YK_Mem left = null;
        if((maxInfo.ind - 1) >= start) {
            left = getMax(hist, start, maxInfo.ind - 1, memMax);
        }
        YK_Mem right = null;
        if(end >= (maxInfo.ind + 1)) {
            right = getMax(hist, maxInfo.ind + 1, end, memMax);
        }
        if(left == null) {
            return right.ind;
        } else if(right == null) {
            return left.ind;
        } else {
            return (left.max > right.max) ? left.ind : right.ind;
        }
    }

    private int getWater(int[] hist, int start, int end, HashMap<Point, YK_Mem> memMax) {
        System.out.println("getWater START, start: " + start + ", end: " + end);
        if((start >= hist.length) || ((end - start) < 2)) {
            return 0;
        }
        int maxInd = getMax(hist, start, end, memMax).ind;
        int secondMaxInd = getSecondMax(hist, start, end, memMax);
        int maxIndPrev = Integer.min(maxInd, secondMaxInd);
        int maxIndNext = Integer.max(maxInd, secondMaxInd);

        int water = 0;

        if(maxIndPrev == start) { //will go in even when both are borders, but getWater will return right away
            water += fill(hist, maxIndPrev, maxIndNext);
            water += getWater(hist, maxIndNext, end, memMax);
        } else if(maxIndNext == end) {
            water += fill(hist, maxIndPrev, maxIndNext);
            water += getWater(hist, start, maxIndPrev, memMax);
        } else { //none of the borders are max
            water += getWater(hist, start, maxIndNext, memMax);
            water += getWater(hist, maxIndNext, end, memMax);
        }
        System.out.println("getWater END, start: " + start + ", end: " + end + ", water: " + water);
        return water;

    }

    public int getWaterHistogram(int[] hist) {
        HashMap<Point, YK_Mem> memMax = new HashMap<>();
        return getWater(hist, 0, hist.length - 1, memMax);
    }
}
