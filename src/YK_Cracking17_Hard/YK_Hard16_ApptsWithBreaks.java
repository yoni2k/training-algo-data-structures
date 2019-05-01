package YK_Cracking17_Hard;

import java.util.Arrays;

/*
Source: Cracking 17.16
Given a number of appointments (various number of slots) that were scheduled, the doctor needs a break between
    each of the appointments.  Which appointments should be attended to maximize number of time attended.

Implementation:
- Recursive - initial
- Iterative - after being challenged to do so in the book
- Iterative without extra room - after being challenged to do so in the book
 */

public class YK_Hard16_ApptsWithBreaks {
    private int getBestLen(int[] apps, int ind, int[] bestLens) {
        if(ind >= apps.length) {
            return 0;
        }
        if(bestLens[ind] == -1) {
            bestLens[ind] = Integer.max(	apps[ind] + getBestLen(apps, ind + 2, bestLens),
                    getBestLen(apps,ind + 1, bestLens));
        }

        return bestLens[ind];
    }

    public int getBestAppsLenRecursive(int[] apps) {
        int[] bestLens = new int[apps.length];
        Arrays.fill(bestLens,-1);

        return getBestLen(apps, 0, bestLens);
    }

    public int getBestAppsLenIterative(int[] apps) {
        int[] bestLens = new int[apps.length + 1];
        Arrays.fill(bestLens,-1);

        bestLens[apps.length - 1] = apps[apps.length - 1];
        bestLens[apps.length] = 0;

        for(int i = (apps.length - 2); i >= 0; i--) {
            bestLens[i] = Integer.max(bestLens[i+2] + apps[i], bestLens[i+1]);
        }

        return bestLens[0];
    }

    public int getBestAppsLenIterativeNoSpace(int[] apps) {
        int m2 = 0;
        int m1 = 0;
        int cur = 0;

        for(int i = (apps.length - 1); i >= 0; i--) {
            cur = Integer.max(m2 + apps[i], m1);
            m2 = m1;
            m1 = cur;
        }

        return cur;
    }
}
