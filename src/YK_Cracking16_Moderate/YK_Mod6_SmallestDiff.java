package YK_Cracking16_Moderate;

import java.util.Arrays;

/*
Source: Cracking 16.6
Given two arrays, return minimal positive difference between any 2 members from different arrays.
 */

public class YK_Mod6_SmallestDiff {

    public int getMinDiff(int[] a1, int[] a2) {
        int ind1 = 0;
        int ind2 = 0;
        int min = Integer.MAX_VALUE;
        int curDiff;

        Arrays.sort(a1);
        Arrays.sort(a2);

        while((ind1 < a1.length) && (ind2 < a2.length)) {
            if(a1[ind1] < a2[ind2]) {
                curDiff = a2[ind2] - a1[ind1];
                ind1++;
            } else {
                curDiff = a1[ind1] - a2[ind2];
                ind2++;
            }
            min = Math.min(min, curDiff);
        }

        return min;
    }
}
