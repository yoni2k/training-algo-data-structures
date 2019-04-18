package YK_Cracking16_Moderate;

import java.util.HashMap;

/*
    Source: Cracking 16.5
    Return number of trailing zeros in a factorial

    The book has a completely different implementation.
    In any case, my implementation is O(n), heavy guns while in the book it's much simpler and lightweight
 */


public class YK_Mod5_TrailingZerosFactorial {

    private int getPowersOf5WithMem(int n, HashMap<Integer, Integer> powers) {
        if (n == 0) {
            return 0;
        }

        if(powers.containsKey(n)) {
            return powers.get(n);
        } else if ((n % 5) == 0) {
            int res = getPowersOf5WithMem(n / 5, powers) + 1;
            powers.put(n, res);
            return res;
        } else {
            return 0;
        }
    }

    private int getNumTrailZerosFactorialWithMem(int n, HashMap<Integer, Integer> powers) {
        if(n == 0) {
            return 0;
        } else if (n % 5 != 0) {
            return getNumTrailZerosFactorialWithMem(n - (n % 5), powers);
        } else {
            return getNumTrailZerosFactorialWithMem(n - 5, powers) + getPowersOf5WithMem(n, powers);
        }
}

    public int getNumTrailZerosFactorialWithMem(int n) {
        HashMap<Integer, Integer> powers = new HashMap<>();

        return getNumTrailZerosFactorialWithMem(n, powers);
    }
}
