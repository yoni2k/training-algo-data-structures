package YK_Cracking17_Hard;

/*
Source: Cracking 17.21
Given a histogram (see book), check how much water will be in it

Implementation without memorization - probably O(n^2). Will continue to improve
 */

public class YK_Hard21_VolumeHistogram {
    private int fill(int[] hist, int start, int end) {
        System.out.println("fill, start: " + start + ", end: " + end);
        int height = Integer.min(hist[start], hist[end]);
        int water = (end - start - 1) * height;

        for(int i = start + 1; i < end; i++) {
            water -= hist[i];
        }

        return water;
    }

    private int getWater(int[] hist, int start, int end) {
        System.out.println("getWater START, start: " + start + ", end: " + end);
        if((start >= hist.length) || ((end - start) < 2)) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int maxInd = 0;
        int maxIndPrev = 0; //just to make compiler happy, will always be filled since length >= 2

        for(int i = start; i <= end; i++) {
            if(hist[i] > max) {
                maxIndPrev = maxInd;
                maxInd = i;
                max = hist[i];
            }
        }
        if(maxInd == start) { //need to find the second smallest number, first was largest
            maxIndPrev = start;
            max = Integer.MIN_VALUE;
            for(int i = start + 1; i <= end; i++) {
                if(hist[i] > max) {
                    maxInd = i;
                    max = hist[i];
                }
            }
        }

        int water = 0;

        if(maxIndPrev == start) { //will go in even when both are borders, but getWater will return right away
            water += fill(hist, maxIndPrev, maxInd);
            water += getWater(hist, maxInd, end);
        } else if(maxInd == end) {
            water += fill(hist, maxIndPrev, maxInd);
            water += getWater(hist, start, maxIndPrev);
        } else { //none of the borders are max
            water += getWater(hist, start, maxInd);
            water += getWater(hist, maxInd, end);
        }
        System.out.println("getWater END, start: " + start + ", end: " + end + ", water: " + water);
        return water;

    }

    public int getWaterHistogram(int[] hist) {
        return getWater(hist, 0, hist.length - 1);
    }
}
