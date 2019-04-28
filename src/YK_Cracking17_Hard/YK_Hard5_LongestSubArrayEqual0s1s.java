package YK_Cracking17_Hard;

import java.util.Arrays;
import java.util.HashMap;

/*
Source: Cracking 17.5
Given an array of 0s and 1s (in the book it's letters and numbers), find the longest subarray with number
of 0s = number of 1s.

Implementation:
- Improved from the book
- Initial without hashtable, similar O, just not as elegant/short
 */

public class YK_Hard5_LongestSubArrayEqual0s1s {

    public int[] getSubArrayWithHashtable(int[] arr) {
        HashMap<Integer,Integer> indFirstDiff = new HashMap<>();
        int maxLen = 0;
        int startIndex = Integer.MAX_VALUE;

        int num0 = 0;
        int num1 = 0;
        int diff;
        int indexDiff;
        int prevIndex;
        indFirstDiff.put(0, -1);

        for(int i = 0 ; i < arr.length ; i++) {
            if(arr[i] == 0) {
                num0++;
            } else {
                num1++;
            }
            diff = num1 - num0;
            if(indFirstDiff.containsKey(diff)) {
                prevIndex = indFirstDiff.get(diff);
                indexDiff = (i - prevIndex);
                if(indexDiff > maxLen) {
                    startIndex = prevIndex + 1;
                    maxLen = indexDiff;
                }
            } else {
                indFirstDiff.put(diff, i);
            }

        }

        if(maxLen == 0) {
            return new int[] {};
        } else {
            int[] ans;
            ans = Arrays.copyOfRange(arr, startIndex, startIndex + maxLen);
            System.out.println("Got array: " + Arrays.toString(arr) + ", returning: " + Arrays.toString(ans));
            return ans;
        }
    }

    public int[] getSubArrayInitial(int[] arr) {
        int[] mins = new int[arr.length + 1];
        int[] maxs = new int[arr.length + 1];
        int[] minsNeg = new int[arr.length + 1];
        int[] maxsNeg = new int[arr.length + 1];

        //initiate the 2 arrays
        for(int i = 0; i < arr.length + 1; i++) {
            mins[i] = Integer.MAX_VALUE;
            maxs[i] = Integer.MIN_VALUE;
            minsNeg[i] = Integer.MAX_VALUE;
            maxsNeg[i] = Integer.MIN_VALUE;
        }
        mins[0] = -1;
        int num0 = 0;
        int num1 = 0;
        int diff;

        for(int i = 0 ; i < arr.length ; i++) {
            if(arr[i] == 0) {
                num0++;
            } else {
                num1++;
            }
            diff = num1 - num0;
            if(diff >= 0) {
                if(i < mins[diff]) {
                    mins[diff] = i;
                }
                if(i > maxs[diff]) {
                    maxs[diff] = i;
                }
            } else {
                if(i < minsNeg[diff * -1]) {
                    minsNeg[diff * -1] = i;
                }
                if(i > maxsNeg[diff * -1]) {
                    maxsNeg[diff * -1] = i;
                }
            }

        }

        int indexDiff;
        int startIndex = Integer.MAX_VALUE;
        int maxLen = 0;

        for(int i = 0; i < arr.length + 1; i++) {
            if((mins[i] == Integer.MAX_VALUE) || (maxs[i] == Integer.MIN_VALUE)) {
                continue;
            }
            indexDiff = maxs[i] - mins[i];
            if(indexDiff > maxLen) {
                startIndex = mins[i] + 1;
                maxLen = indexDiff;
            }
        }
        for(int i = 1; i < arr.length + 1; i++) {
            if((minsNeg[i] == Integer.MAX_VALUE) || (maxsNeg[i] == Integer.MIN_VALUE)) {
                continue;
            }
            indexDiff = maxsNeg[i] - minsNeg[i];
            if(indexDiff > maxLen) {
                startIndex = minsNeg[i] + 1;
                maxLen = indexDiff;
            }
        }

        if(maxLen == 0) {
            return new int[] {};
        } else {
            int[] ans;
            ans = Arrays.copyOfRange(arr, startIndex, startIndex + maxLen);
            System.out.println("Got array: " + Arrays.toString(arr) + ", returning: " + Arrays.toString(ans));
            return ans;
        }
    }
}
