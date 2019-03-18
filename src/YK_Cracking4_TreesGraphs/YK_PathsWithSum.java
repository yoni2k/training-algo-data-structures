package YK_Cracking4_TreesGraphs;

import YK_Common.YK_BinaryTreeNode;

import java.util.HashMap;
import java.util.Map.*;

/*
Source: Cracking 4.12
Paths with Sum

Given a sum, count number of paths in a binary tree (with positive or negative integers) that give this sum.
I implemented something more expensive (Time O(N log N), Space O(log N)), but a bit more straightforward.
In the book there is a more efficient solution (Time O(N log N), Space O(log N)), but a bit harder to understand -
    with running sum.
 */

public class YK_PathsWithSum {
    private void addToMapEntriesCurrentValue(int sumToAdd, HashMap<Integer,Integer> map) {

        @SuppressWarnings("unchecked")
        HashMap<Integer,Integer> tempMap = (HashMap<Integer,Integer>)map.clone();

        for(Entry<Integer,Integer> entry : tempMap.entrySet()) {
            map.remove(entry.getKey());
            map.put(entry.getKey() + sumToAdd, entry.getValue());
        }
    }

    private void addToMap(int sumToAdd, HashMap<Integer,Integer> map) {

        int instances = 1;

        if(map.containsKey(sumToAdd)) instances += map.get(sumToAdd);

        map.put(sumToAdd, instances);
    }

    private void removeFromMap(int sumToRemove, HashMap<Integer,Integer> map) {

        int instances = map.get(sumToRemove) - 1;

        if ((instances == 0)) {
            map.remove(sumToRemove);
        } else {
            map.put(sumToRemove, instances);
        }
    }

    private int recPrivateGetNumPaths(int sum, YK_BinaryTreeNode<Integer> head, HashMap<Integer,Integer> map) {

        if(head == null) return 0;

        int numPaths = 0;

        addToMapEntriesCurrentValue(head.get(), map);
        addToMap(head.get(), map);

        if(map.containsKey(sum)) numPaths += map.get(sum);

        numPaths += recPrivateGetNumPaths(sum, head.getLeft(), map);
        numPaths += recPrivateGetNumPaths(sum, head.getRight(), map);

        removeFromMap(head.get(), map);
        addToMapEntriesCurrentValue(head.get()*(-1), map);

        return numPaths;
    }

    public int getNumPathsWithSum(int sum, YK_BinaryTreeNode<Integer> head) {
        return recPrivateGetNumPaths(sum, head, new HashMap<>());
    }
}
