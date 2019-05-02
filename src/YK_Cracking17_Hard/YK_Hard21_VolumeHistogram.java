package YK_Cracking17_Hard;

/*
Source: Cracking 17.21
Given a histogram (see book), check how much water will be in it

Implementation with memorization. Every pass is O(n),
    next pass is at worst case 1/2 n (the other half we either fill right away, or get with memorization.,
    therefore complexity is O(n log n).
    Space complexity O(n log n) - we put memotization for every point we touch
 */

import java.awt.*;
import java.util.HashMap;

public class YK_Hard21_VolumeHistogram {

    private int fill(int[] hist, int start, int end) {
        if(start > (end - 2)) {
            return 0;
        }
        int height = Integer.min(hist[start], hist[end]);
        int water = (end - start - 1) * height;

        for(int i = start + 1; i < end; i++) {
            water -= hist[i];
        }

        System.out.println("fill, FINISH: " + start + ", end: " + end + ", water: " + water);
        return water;
    }

    private int getMaxInd(int[] hist, int start, int end, HashMap<Point, Integer> memMaxInds) {
        Point p = new Point(start, end);
        if(start == end) {
            return hist[start];
        } else if(memMaxInds.containsKey(p)) {
            return memMaxInds.get(p);
        }

        int max = hist[start];
        int ind = start;

        for(int i = start + 1; i <= end; i++) {
            if(hist[i] > max) {
                max = hist[i];
                ind = i;
            }
            memMaxInds.put(new Point(start, i), ind);
        }
        return ind;
    }

    private int getWater(int[] hist, int start, int end, HashMap<Point, Integer> memMaxInds) {
        System.out.println("getWater START, start: " + start + ", end: " + end);
        if((start >= hist.length) || ((end - start) < 2)) {
            return 0;
        }

        int water = 0;
        int maxInd = getMaxInd(hist, start, end, memMaxInds);
        if(maxInd < (end - 2)) {
            int maxRightInd = getMaxInd(hist, maxInd + 1, end, memMaxInds);
            water += fill(hist, maxInd, maxRightInd);
            water += getWater(hist, maxRightInd, end, memMaxInds);
        }
        if(maxInd > (start + 2)) {
            int maxLeftInd = getMaxInd(hist, start, maxInd - 1, memMaxInds);
            water += fill(hist, maxLeftInd, maxInd);
            water += getWater(hist, start, maxLeftInd, memMaxInds);
        }
        System.out.println("getWater END, start: " + start + ", end: " + end + ", water: " + water);
        return water;

    }

    public int getWaterHistogram(int[] hist) {
        HashMap<Point, Integer> memMaxInds = new HashMap<>();
        return getWater(hist, 0, hist.length - 1, memMaxInds);
    }
}
