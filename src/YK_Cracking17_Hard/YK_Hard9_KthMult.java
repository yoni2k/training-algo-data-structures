package YK_Cracking17_Hard;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;

/*
Return the value of k-th number of all numbers that are made up of powers of 3, 5, 7

Implementations:
1. Initial - with PriorityQueue - getKthPQ - O(n log n)
2. After reading the book using 3 separate lists - getKthNoPQ - O(n)
3. In the book (not here) - similar to #2, but using instead of HashMap a property of problem for visited numbers.
    Same O, a bit more complex, less memory
 */

public class YK_Hard9_KthMult {

    private void addProducts(PriorityQueue<Integer> pq, HashSet<Integer> appeared, int num) {
        int[] mults = {3, 5, 7};
        int res;

        for(int mult : mults) {
            res = mult * num;
            if(appeared.contains(res) == false) {
                pq.add(res);
                appeared.add(res);
            }
        }
    }


    public int getKthPQ(int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        HashSet<Integer> appeared = new HashSet<>();
        int ans = 1;
        addProducts(pq, appeared, 1);

        for(int i = 1; i < k; i++) {
            ans = pq.remove();
            addProducts(pq, appeared, ans);
        }

        return ans;
    }

    /****
     * Following reading the book
     */

    private int getInd(int num) {
        if(num == 3) {
            return 0;
        } else if (num == 5) {
            return 1;
        } else {
            return 2;
        }
    }

    private void addProducts(LinkedList<Integer>[] lists, HashSet<Integer> appeared, int num) {
        int[] mults = {3, 5, 7};
        int res;

        for(int mult : mults) {
            res = mult * num;
            if(appeared.contains(res) == false) {
                lists[getInd(mult)].add(res);
                appeared.add(res);
            }
        }

    }

    private int getMin(LinkedList<Integer>[] lists) {
        int indMin = -1;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < 3; i++) {
            if ((lists[i].size() > 0) && (lists[i].peek() < min)) {
                indMin = i;
                min = lists[i].peek();
            }
        }
        lists[indMin].remove();
        return min;
    }

    public int getKthNoPQ(int k) {
        LinkedList<Integer>[] lists = (LinkedList<Integer>[])new LinkedList[3];
        for(int i = 0; i < lists.length; i++) {
            lists[i] = new LinkedList<>();
        }

        HashSet<Integer> appeared = new HashSet<>();
        int ans = 1;
        addProducts(lists, appeared, 1);

        for(int i = 1; i < k; i++) {
            ans = getMin(lists);
            addProducts(lists, appeared, ans);
        }

        return ans;
    }
}
