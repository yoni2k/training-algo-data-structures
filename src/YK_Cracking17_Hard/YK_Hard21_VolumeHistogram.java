package YK_Cracking17_Hard;

/*
Source: Cracking 17.21
Given a histogram (see book), check how much water will be in it

Implementation with memorization - much better.  Also simplified logic, always filling 1 part, and doing 2 recursions,
    one of them is going to be O(1) because of memorization, gives O(n log n)
 */

import java.awt.*;
import java.util.HashMap;

public class YK_Hard21_VolumeHistogram {

    private class YK_Pair {
        int one;
        int two;

        YK_Pair(int one, int two) {
            this.one = one;
            this.two = two;
        }
    }

    private int fill(int[] hist, int start, int end) {
        int height = Integer.min(hist[start], hist[end]);
        int water = (end - start - 1) * height;

        for(int i = start + 1; i < end; i++) {
            water -= hist[i];
        }

        System.out.println("fill, FINISH: " + start + ", end: " + end + ", water: " + water);
        return water;
    }

    private int[] get2MaxIndexes(int[] hist, int start, int end, HashMap<Point, YK_Pair> memMaxesInds) {
        Point p = new Point(start, end);
        YK_Pair maxesIndexes;
        if(memMaxesInds.containsKey(p)) {
            maxesIndexes = memMaxesInds.get(p);
            return new int[] {maxesIndexes.one, maxesIndexes.two};
        }

        int indMax =        (hist[start] >= hist[start+1]) ? start          : start + 1;
        int max =           (hist[start] >= hist[start+1]) ? hist[start]    : hist[start + 1];
        int maxSecond =     (hist[start] >= hist[start+1]) ? hist[start + 1]: hist[start];
        int indSecondMax;

        maxesIndexes = new YK_Pair(start, start + 1);
        memMaxesInds.put(new Point(start, start + 1), maxesIndexes);

        for(int i = start + 2; i <= end; i++) {
            if(hist[i] > max) {
                max = hist[i];
                indSecondMax = indMax;
                indMax = i;
                maxesIndexes = new YK_Pair(Integer.min(indMax, indSecondMax), Integer.max(indMax, indSecondMax));
            } else if((indMax == start) && (hist[i] > maxSecond)) {
                maxSecond = hist[i];
                indSecondMax = i;
                maxesIndexes = new YK_Pair(Integer.min(indMax, indSecondMax), Integer.max(indMax, indSecondMax));
            }
            memMaxesInds.put(new Point(start, i), maxesIndexes);
        }
        System.out.print("get2MaxIndexes FINISH - start: " + start + ", end: " + end + ", return: ");
        System.out.println("[" + maxesIndexes.one + "," + maxesIndexes.two + "]");
        return new int[] {maxesIndexes.one, maxesIndexes.two};
    }

    private int getWater(int[] hist, int start, int end, HashMap<Point, YK_Pair> memMaxsIndexes) {
        System.out.println("getWater START, start: " + start + ", end: " + end);
        if((start >= hist.length) || ((end - start) < 2)) {
            return 0;
        }
        int[] maxsIndexes = get2MaxIndexes(hist, start, end, memMaxsIndexes);
        int water = 0;

        water += fill(hist, maxsIndexes[0], maxsIndexes[1]);
        water += getWater(hist, start, maxsIndexes[0], memMaxsIndexes);
        water += getWater(hist, maxsIndexes[1], end, memMaxsIndexes);

        System.out.println("getWater END, start: " + start + ", end: " + end + ", water: " + water);
        return water;

    }

    public int getWaterHistogram(int[] hist) {
        HashMap<Point, YK_Pair> memMaxsIndexes = new HashMap<>();
        return getWater(hist, 0, hist.length - 1, memMaxsIndexes);
    }
}
