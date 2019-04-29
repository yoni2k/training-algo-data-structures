package YK_Cracking17_Hard;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

/*
Source Cracking 17.11
There are actually 2 different problems (with pre-processing and without):
1. Without - given a list of words in a book, find the minimal distance between 2 given words
2. With - given a list of words in a book, optimize, such the time to find minimal distance between any 2 words is minimal
 */

public class YK_Hard11_WordDist {

    HashMap<String, ArrayList<Integer>> inds;

    public YK_Hard11_WordDist(String[] words) {
        inds = new HashMap<>();
        ArrayList<Integer> arr;

        for(int i = 0; i < words.length; i++) {
            if(inds.containsKey(words[i])) {
                inds.get(words[i]).add(i);
            } else {
                arr = new ArrayList<>();
                arr.add(i);
                inds.put(words[i], arr);
            }
        }
    }

    public int minDist(String w1, String w2) {

        ArrayList<Integer> arr1 = inds.get(w1);
        ArrayList<Integer> arr2 = inds.get(w2);

        int ind1 = 0;
        int ind2 = 0;
        int minDist = Integer.MAX_VALUE;

        while((ind1 < arr1.size()) && (ind2 < arr2.size())) {
            if(arr2.get(ind2) < arr1.get(ind1)) {
                ind2++;
            } else {
                minDist = Integer.min(minDist, arr2.get(ind2) - arr1.get(ind1));
                ind1++;
            }
        }

        return minDist;
    }


    public int minDist(String[] words, String w1, String w2) {
        int w1Ind = -1;
        int minDist = Integer.MAX_VALUE;

        for(int i = 0; i < words.length; i++) {
            if(words[i].equals(w1)) {
                w1Ind = i;
            } else if (words[i].equals(w2)) {
                if(w1Ind != -1) {
                    minDist = Integer.min(minDist, i - w1Ind);
                }
            }
        }
        return minDist;
    }
}
