package YK_Cracking2_LinkedLists;

import YK_Common.YK_NodeSingle;

import java.util.Arrays;

/*
Source: Cracking, ch.2 Linked Lists, page 94, Question 2.2
Return kth to Last: implement an algorithm to find the kth to last element of a singly linked list.

Implementation variations (besides unused terrible one due to misunderstanding):
- With going over the list twice - O(N) - don't know why need something different
- Book sent into recursion direction - a straightforward recursion implementation is terrible O(2^N), but if multiple return values
    are returned, it becomes time of O(N), but still space-wise it's worse and it's O(N) - not sure why we would use it
 */

public class YK_FindKth {

    static public Integer findKthSimple(YK_NodeSingle<Integer> head, int kFromEnd) {

        System.out.println("Start findKthSimple, asked for index: " + kFromEnd + " from end, got list: " + Arrays.toString(head.toArray()));

        int size = head.size();

        if (kFromEnd >= size) {
            System.out.println("Invalid index requested from end: " + kFromEnd + ", size: " + size);
            return null;
        }

        Integer element = head.get(size - 1 - kFromEnd);

        System.out.println("End findKthSimple, found index:" + kFromEnd + " from end, data: " + element + ", from list: " + Arrays.toString(head.toArray()));

        return element;
    }
/*
    static private YK_NodeSingle<Integer> findRecursiveTerribleO_2PN_NotToUse(YK_NodeSingle<Integer> head, int kFromEnd) {

        YK_NodeSingle<Integer> node;

        if (head == null) {
            System.out.println("findRecursiveTerribleO_2PN_NotToUse reached end of list");
            return null;
        }

        if ((kFromEnd == 0) && (head.getNext() == null)) {
            System.out.println("findRecursiveTerribleO_2PN_NotToUse found last member in the list: " + head.get());
            return head;
        }

        System.out.println("In findRecursiveTerribleO_2PN_NotToUse, looking for kfromEnd: " + kFromEnd + ", list: " + Arrays.toString(head.toArray()));

        node = findRecursiveTerribleO_2PN_NotToUse(head.getNext(), kFromEnd);

        if (node != null) {
            System.out.println("In findRecursiveTerribleO_2PN_NotToUse, Found kFromEnd: " + kFromEnd + " in tail: " + Arrays.toString(head.toArray()));
            return node;
        }
        else {
            node = findRecursiveTerribleO_2PN_NotToUse(head.getNext(), kFromEnd - 1);

            if (node != null) {
                System.out.println("In findRecursiveTerribleO_2PN_NotToUse, Found 1 less than original kFromEnd: " + kFromEnd + " in tail: " + Arrays.toString(head.toArray()) + ", returning current element: " + head.get());
                return head;
            }
        }

        System.out.println("In findRecursiveTerribleO_2PN_NotToUse, Didn't find kFromEnd: " + kFromEnd + " or 1 less in tail: " + Arrays.toString(head.toArray()) + ", returning current element: " + head.get());

        return null;

    }

    static public Integer findKthRecursiveTerribleO_2PN_NotToUse(YK_NodeSingle<Integer> head, int kFromEnd) {

        System.out.println("Start findKthRecursiveTerribleO_2PN_NotToUse, asked for index: " + kFromEnd + " from end, got list: " + Arrays.toString(head.toArray()));

        YK_NodeSingle<Integer> node = findRecursiveTerribleO_2PN_NotToUse(head, kFromEnd);

        if (node == null) {
            System.out.println("Didn't find found index:" + kFromEnd + " from end, from list: " + Arrays.toString(head.toArray()));
            return null;
        }

        System.out.println("End findKthRecursiveTerribleO_2PN_NotToUse, found index: " + kFromEnd + " from end, data: " + node.get() + ", from list: " + Arrays.toString(head.toArray()));

        return node.get();
    }
*/
    static private class YK_NodeKPair {
        YK_NodeSingle<Integer> node;
        Integer kFromEnd;

        private YK_NodeKPair(YK_NodeSingle<Integer> node, Integer kFromEnd) {
            this.node = node;
            this.kFromEnd = kFromEnd;
        }
    }

    static private YK_NodeKPair findRecursive(YK_NodeSingle<Integer> head, int kFromEnd) {

        YK_NodeKPair pair;
        YK_NodeSingle<Integer> node;

        System.out.println("In findRecursive, looking for kfromEnd: " + kFromEnd + ", list: " + Arrays.toString(head.toArray()));

        if (head.getNext() == null) {
            if (kFromEnd == 0) {
                System.out.println("findRecursive reached end of list, and found last member, data: " + head.get());
                pair = new YK_NodeKPair(head,0);//kFromEnd is not interesting once found it
            }
            else {
                System.out.println("findRecursive reached end of list, returning index");
                pair = new YK_NodeKPair(null, 0);
            }
        }
        else {

            pair = findRecursive(head.getNext(), kFromEnd);

            if (pair.node != null) {
                System.out.println("In findRecursive, Found kFromEnd: " + kFromEnd + " in tail: " + Arrays.toString(head.toArray()));
                //returning original pair
            }
            else if (pair.kFromEnd + 1 == kFromEnd) {
                System.out.println("In findRecursive, found kFromEnd: " + kFromEnd + " since tail was one less, data: " + head.get());
                pair = new YK_NodeKPair(head, 0);
            }
            else {
                System.out.println("In findRecursive, didn't find kFromEnd: " + kFromEnd + " returning current index from end: " + (pair.kFromEnd + 1));
                pair = new YK_NodeKPair(null, pair.kFromEnd + 1);
            }
        }

        return pair;
    }

    static public Integer findKthRecursive(YK_NodeSingle<Integer> head, int kFromEnd) {

        System.out.println("Start findKthRecursive, asked for index: " + kFromEnd + " from end, got list: " + Arrays.toString(head.toArray()));

        YK_NodeKPair pair = findRecursive(head, kFromEnd);

        if (pair.node == null) {
            System.out.println("Didn't find found index:" + kFromEnd + " from end, from list: " + Arrays.toString(head.toArray()));
            return null;
        }

        System.out.println("End findKthRecursive, found index: " + kFromEnd + " from end, data: " + pair.node.get() + ", from list: " + Arrays.toString(head.toArray()));

        return pair.node.get();
    }
}
