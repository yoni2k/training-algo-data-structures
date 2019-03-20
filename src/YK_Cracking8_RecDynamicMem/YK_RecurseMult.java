package YK_Cracking8_RecDynamicMem;

import java.util.HashMap;

/*
Source: Cracking 8.5

Multiple 2 numbers without using multiplication.

In the book there is  a better implementation:
1. It does the tricks on the smaller number of the 2
2. It doesn't loop again to find the index, but just divides by two and does special handling of odd numbers (solution 3)

In the book it's O(log s), while I think my solution is O(log s * log s)

Not deleting ways to count, although actual tests don't use the real counting

 */

public class YK_RecurseMult {

    HashMap<Integer, Integer> mem = new HashMap<>();

    int numActions = 0;

    public int getActions() { return numActions; }
    /*
    private int findShiftOrigWithCount(int num) {
        int i = 1;

        while ((1 << i) <= num) {
            numActions += 2;
            i++;
        }

        return (i - 1);
    }

    private int findShiftWithMemWithCount(int num) {
        int i = 1;

        if(mem.containsKey(num)) {
            numActions += 1;
            return mem.get(num);
        }

        while ((1 << i) <= num) {
            mem.put((1 << i), (i - 1));
            numActions += 3;
            i++;
        }

        mem.put(num, i - 1);
        return (i - 1);
    }*/

    private int findShiftOrig(int num) {
        int i = 1;

        while((1 << i) <=  num) i++;

        return (i - 1);
    }

    private int privateRecurseMultiple(int a, int b) {
        if (b == 0) return 0;
        if (b == 1) return a;

        int shiftBy = findShiftOrig(b);

        return (a << shiftBy) + privateRecurseMultiple(a, b - (1 << shiftBy));
    }

    public int recursiveMultiple(int a, int b) {

        return privateRecurseMultiple(a,b);
    }
}
