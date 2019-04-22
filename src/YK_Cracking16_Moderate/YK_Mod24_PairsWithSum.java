package YK_Cracking16_Moderate;

import java.util.ArrayList;
import java.util.HashSet;

/*
Given an array and expected sum, return all pairs with the sum.
There are 2 implementation:
- Initial, time O(n), space O(n)
- After challenge from book, assuming sorted array, with time O(n), space O(1).  If sort is needed, also O(n log n)
 */

public class YK_Mod24_PairsWithSum {
    class Pair {
        int one;
        int two;

        Pair(int one, int two) {
            this.one = one;
            this.two = two;
        }

        @Override
        public boolean equals(Object o) {
            if(o.getClass() == this.getClass()) {
                Pair other = (Pair)o;
                return ((one == other.one) && (two == other.two));
            }
            return false;
        }

        @Override
        public int hashCode() {
            return one + two;
        }

        int[] toArray() {
            return new int[] {one, two};
        }
    }

    public int[][] getPairsWithValue(int[] arr, int sum) {

        ArrayList<Pair> pairs = new ArrayList<>();
        HashSet<Integer> seen = new HashSet<>();
        int diff;

        for(int i : arr) {
            diff = sum - i;
            if(seen.contains(diff)) {
                pairs.add(new Pair(diff, i));
            }
            seen.add(i);
        }

        int[][] ans = new int[pairs.size()][];

        int i = 0;
        for(Pair p : pairs) {
            ans[i] = p.toArray();
            i++;
        }
        return ans;
    }

    public int[][] getPairsWithValueOrdered(int[] arr, int sum) {

        HashSet<Pair> pairs = new HashSet<>();
        int s = 0;
        int f = arr.length - 1;
        int curSum;

        while(s < f) {
            curSum = arr[s] + arr[f];
            if(curSum == sum) {
                pairs.add(new Pair(arr[s], arr[f]));
                s++;
                f--;
            } else if (curSum < sum) {
                s++;
            } else { //(curSum > sum)
                f--;
            }
        }

        int[][] ans = new int[pairs.size()][];

        int i = 0;
        for(Pair p : pairs.toArray(new Pair[0])) {
            ans[i] = p.toArray();
            i++;
        }
        return ans;
    }
}
