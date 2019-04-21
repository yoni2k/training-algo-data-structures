package YK_Cracking16_Moderate;

import java.awt.*;
import java.util.*;

/*
Source: Cracking 16.19
Given pools marked on matrix with 0s, and pool being everything that can connect up/down/right/left/diagonally,
return a list of all the sizes of connected pools

There are 2 implementations here:
- Not iterative - my initial implementation - very difficult especially regarding merges
- Iterative - after reading the book.  Will probably quickly fail on stack size.  Much simpler, can be implemented in an interview
 */

public class YK_Mod19_PondsSizes {

    private void addNonZeroOriginal(HashSet<Integer> set, int num, HashMap<Integer, Integer> mergedPonds) {
        if (num > 0) {
            if (mergedPonds.containsKey(num)) {
                num = mergedPonds.get(num);
            }
            set.add(num);
        }

    }

    private Integer[] getDifferentConnectedPonds(int one, int two, int three, int four, HashMap<Integer, Integer> mergedPonds) {
        HashSet<Integer> set = new HashSet<>();

        addNonZeroOriginal(set, one, mergedPonds);
        addNonZeroOriginal(set, two, mergedPonds);
        addNonZeroOriginal(set, three, mergedPonds);
        addNonZeroOriginal(set, four, mergedPonds);

        return set.toArray(new Integer[0]);
    }

    public int[] getPondSizes(int[][] plot) {

        HashMap<Integer, Integer> ponds = new HashMap<>();
        HashMap<Integer, Integer> mergedPonds = new HashMap<>();
        int numPond = 1;
        int[][] pondsBelongs = new int[plot.length][];
        for(int i = 0; i < pondsBelongs.length; i++) {
            pondsBelongs[i] = new int[plot[0].length];
        }

        int min1min1;
        int min1same;
        int sameMin1;
        int min1plus1;
        Integer[] diffConnectedPonds;
        int newPondSize;

        for(int i = 0; i < plot.length; i++) {
            for (int j = 0; j < plot[i].length; j++) {
                if(plot[i][j] == 0) {
                    min1min1 = 0;
                    min1same = 0;
                    sameMin1 = 0;
                    min1plus1 = 0;
                    if((i > 0) && (j > 0)) {
                        min1min1 = pondsBelongs[i-1][j-1];
                    }
                    if (i > 0) {
                        min1same = pondsBelongs[i-1][j];
                    }
                    if (j > 0) {
                        sameMin1 = pondsBelongs[i][j-1];
                    }
                    if ((i > 0) && (j < (plot[i].length - 1))) {
                        min1plus1 = pondsBelongs[i-1][j+1];
                    }
                    diffConnectedPonds = getDifferentConnectedPonds(min1min1, min1same, sameMin1, min1plus1, mergedPonds);
                    if (diffConnectedPonds.length == 0) {
                        pondsBelongs[i][j] = numPond;
                        ponds.put(numPond, 1);
                        numPond++;
                    } else if (diffConnectedPonds.length == 1)  {
                        pondsBelongs[i][j] = diffConnectedPonds[0];
                        ponds.put(pondsBelongs[i][j], ponds.get(pondsBelongs[i][j]) + 1);
                    } else { //merge needed
                        if(ponds.containsKey(diffConnectedPonds[0]) && ponds.containsKey(diffConnectedPonds[1])) {
                            pondsBelongs[i][j] = diffConnectedPonds[0];
                            newPondSize = ponds.get(diffConnectedPonds[0]) + 1;
                            newPondSize += ponds.remove(diffConnectedPonds[1]);
                            ponds.put(diffConnectedPonds[0], newPondSize);
                            mergedPonds.put(diffConnectedPonds[1], diffConnectedPonds[0]);
                        } else if (ponds.containsKey(diffConnectedPonds[0])) {
                            pondsBelongs[i][j] = diffConnectedPonds[0];
                            ponds.put(diffConnectedPonds[0], ponds.get(diffConnectedPonds[0]) + 1);
                        } else { //(ponds.containsKey(diffConnectedPonds[1]))
                            pondsBelongs[i][j] = diffConnectedPonds[1];
                            ponds.put(diffConnectedPonds[1], ponds.get(diffConnectedPonds[1]) + 1);
                        }
                    }
                }
            }
        }

        int[] ans = new int[ponds.size()];

        int i = 0;
        for (int newInt : ponds.values()) {
            ans[i++] = newInt;
        }
        return ans;
    }


    /***********
     *  After looking at the book, carefully doing recursive algorithm
     *  Didn't do initially since was afraid of the stack size, and recursion price
     */

    private int findWholePond(int[][] plot, int i, int j, HashSet<Point> visited) {

        if (    (i < 0) ||
                (j < 0) ||
                (i >= plot.length) ||
                (j >= plot[i].length) ||
                (plot[i][j] != 0) ||
                visited.contains(new Point(i,j))) {
            return 0;
        }

        int pondSize = 1;
        visited.add(new Point(i,j));
        int[] iAddArr = {-1,0,1};
        int[] jAddArr = {-1,0,1};

        for(int iAdd : iAddArr) {
            for (int jAdd : jAddArr) {
                if((iAdd != 0) || (jAdd != 0)) {
                    pondSize += findWholePond(plot, i + iAdd, j + jAdd, visited);
                }
            }
        }
        return pondSize;
    }

    public int[] getPondSizesRecursive(int[][] plot) {
        HashSet<Point> visited = new HashSet<>();
        ArrayList<Integer> ponds = new ArrayList<>();

        for(int i = 0 ; i < plot.length; i++) {
            for (int j = 0; j < plot[i].length; j++) {
                if((plot[i][j] == 0) && (visited.contains(new Point(i,j)) == false)) {
                    ponds.add(findWholePond(plot, i, j, visited));
                }
            }
        }

        int[] ans = new int[ponds.size()];

        for(int i = 0; i < ans.length; i++) {
            ans[i] = ponds.get(i);
        }
        return ans;
    }
}
