package YK_Cracking16_Moderate;

import java.util.Arrays;
import java.util.HashSet;

/*
Source: Cracking 16.21
Given two arrays, find member from each array such that their swap will give arrays with same sum.

Implementation:
- Original - O(n log n)
- Final optimized - after reading the book O(n)
 */

public class YK_Mod21_SumSwap {

    private int findSum1(int[] arr) {
        int sum = 0;

        for(int i : arr) {
            sum += i;
        }
        return sum;
    }

    private HashSet<Integer> getSet(int[] arr) {
        HashSet<Integer> set = new HashSet<>();

        for(int i : arr) {
            set.add(i);
        }

        return set;
    }

    public int[] findPairToSwapOptimized(int[] a1, int[] a2) {
        int sum1 = findSum1(a1);
        int sum2 = findSum1(a2);

        if(((sum2 - sum1) % 2) != 0) {
            return null;
        }

        int diff = (sum2 - sum1) / 2;
        HashSet<Integer> set2 = getSet(a2);
        int i2;

        for(int i1 : a1) {
            i2 = i1 + diff;
            if(set2.contains(i2)) {
                return new int[] {i1, i2};
            }
        }

        return null;
    }

    /**
     *  Not optimized - O(n log n) instead of O(n) solution
     */

    private int findSum(int[] arr) {
        int sum = 0;

        for(int i : arr) {
            sum += i;
        }
        return sum;
    }

    private int[] findPair(int[] a1, int[] a2, int diff) {
        System.out.println("Diff: " + diff);
        int i1 = 0;
        int i2 = 0;
        int tempDiff;

        while((i1 < a1.length) && (i2 < a2.length)) {
            tempDiff = a2[i2] - a1[i1];

            System.out.println("Diff: " + diff + ", tempDiff: " + tempDiff);

            if(tempDiff == diff) {
                return new int[] {a1[i1], a2[i2]};
            } else if(tempDiff > diff) {
                i1++;
            } else { //(tempDiff < diff)
                i2++;
            }
        }
        return null;
    }

    public int[] findPairToSwap(int[] a1, int[] a2) {

        Arrays.sort(a1);
        Arrays.sort(a2);

        int sum1 = findSum(a1);
        int sum2 = findSum(a2);

        if(((sum2 - sum1) % 2) != 0) {
            System.out.println("Modulus is not 2, sum2: " + sum2 + ", sum1: " + sum1 + ", diff: " + (sum2 - sum1));
            return null;
        }

        return findPair(a1, a2, (sum2 - sum1)/2);
    }
}
