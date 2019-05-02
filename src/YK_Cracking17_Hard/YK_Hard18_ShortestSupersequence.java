package YK_Cracking17_Hard;

import java.util.HashMap;

/*
Source: Cracking 17.18
Given 2 arrays, a short one with unique numbers, find a suparray of long that contains all the numbers,
    and return the indexes of start and end.

Implementation:
- Mine is O(length of long)
- In the book there are many other implementations, much more complicated
 */

public class YK_Hard18_ShortestSupersequence {
    private HashMap<Integer, Integer> getSeen(int[] shortArr) {
        HashMap<Integer, Integer> seen = new HashMap<>();

        for(int value : shortArr) {
            seen.put(value, 0);
        }

        return seen;
    }

    private int remove(int value, HashMap<Integer, Integer> seen, int numSeen) {
        int instances = seen.get(value);
        instances--;
        seen.put(value, instances);
        if(instances == 0) {
            numSeen--;
        }

        return numSeen;
    }

    private int add(int[] longArr, int index, HashMap<Integer, Integer> seen, int numSeen) {
        if((index < longArr.length) && (seen.containsKey(longArr[index]))) {
            int instances = seen.get(longArr[index]);
            instances++;
            seen.put(longArr[index], instances);
            if(instances == 1) {
                numSeen++;
            }
        }
        return numSeen;
    }

    public int[] getMinSubArray(int[] longArr, int[] shortArr) {
        int bestLen = Integer.MAX_VALUE;
        int bestStart = 0;
        int start = 0;
        int end = 0;
        int numSeen = 0;
        HashMap<Integer, Integer> seen = getSeen(shortArr);

        while((start <= (longArr.length - shortArr.length)) && (end <= longArr.length)) {
            if(seen.containsKey(longArr[start]) == false) {
                start++;
            } else if(seen.get(longArr[start]) > 1) {
                numSeen = remove(longArr[start], seen, numSeen);
                start++;
            } else if(numSeen == shortArr.length) {
                if((end - start) < bestLen) {
                    bestStart = start;
                    bestLen = (end - start);
                }
                numSeen = remove(longArr[start], seen, numSeen);
                start++;
            } else {
                numSeen = add(longArr, end, seen, numSeen);
                end++;
            }
        }


        if(bestLen != Integer.MAX_VALUE) {
            return new int[] {bestStart, bestStart + bestLen};
        } else {
            return new int[] {};
        }
    }
}
