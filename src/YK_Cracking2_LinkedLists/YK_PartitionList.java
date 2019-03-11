package YK_Cracking2_LinkedLists;

import YK_Common.YK_NodeSingle;

import java.util.Arrays;

/* Source: Cracking, ch.2, p. 94, exercise 2.4

Given x, write code that partitions a linked list (final order is not important) in a way that all members < x appear
before all members >= x

Solution:
There are many ways to do it.
Keeping the order is a slightly more work, doesn't cost more O.
Can make simpler by paying another O(N) and not remembering the end of the list.
Here there are 2 solutions, 1st solution in the book I implemented, but then replaced with simpler.
2nd solution in the book is elegant, I didn't think of it - keeping 1 list, adding to beginning or end.

Recursion (one of my implemented solutions) was not proven to be worth it, adds O(N) memory, not much simpler.
 */

public class YK_PartitionList {

    static private class YK_NodePair<E> {

        YK_NodeSingle<E> smallHead;
        YK_NodeSingle<E> largeHead;

        private YK_NodePair(YK_NodeSingle<E> smallHead, YK_NodeSingle<E> largeHead) {
            this.smallHead = smallHead;
            this.largeHead = largeHead;
        }
    }

    static private YK_NodePair<Integer> partPrivate(YK_NodeSingle<Integer> head, Integer x) {

        YK_NodePair<Integer> pair;

        if(head == null) {
            System.out.println("Reached end of recursion");
            return new YK_NodePair<>(null,null);
        }

        YK_NodePair<Integer> nextPair = partPrivate(head.getNext(), x);

        if (head.get() < x) {
            head.setNext(nextPair.smallHead);
            pair = new YK_NodePair<>(head, nextPair.largeHead);
        }
        else {
            head.setNext(nextPair.largeHead);
            pair = new YK_NodePair<>(nextPair.smallHead, head);
        }

        return pair;
    }

    static public YK_NodeSingle<Integer> partitionRecursion(YK_NodeSingle<Integer> head, Integer x) {

        System.out.println("Start partitionRecursion, x: " + x + ", list: " + Arrays.toString(head.toArray()));

        //Can also last member of small to save the update of last pointer, but not saving any O like this and makes more complicated
        YK_NodePair<Integer> pair = partPrivate(head, x);

        YK_NodeSingle<Integer> newHead;

        if((pair.smallHead != null) && (pair.largeHead != null)) {
            System.out.println("In partitionRecursion, have 2 lists, small: " + Arrays.toString(pair.smallHead.toArray()) + ", large: " + Arrays.toString(pair.largeHead.toArray()));
            pair.smallHead.getLastNode().setNext(pair.largeHead);
            newHead = pair.smallHead;
        }
        else if (pair.smallHead != null) {
            System.out.println("In partitionRecursion, there is only small list: " + Arrays.toString(pair.smallHead.toArray()));
            newHead = pair.smallHead;
        }
        else { //largeHead != null
            System.out.println("In partitionRecursion, there is only large list: " + Arrays.toString(pair.largeHead.toArray()));
            newHead = pair.largeHead;
        }

        System.out.println("End partitionRecursion, x: " + x + ", list: " + Arrays.toString(newHead.toArray()));

        return newHead;
    }

    static public YK_NodeSingle<Integer> partitionNotRecursion(YK_NodeSingle<Integer> head, Integer x) {

        System.out.println("Start partitionNotRecursion, x: " + x + ", list: " + Arrays.toString(head.toArray()));

        //Can also last member of small to save the update of last pointer, but not saving any O like this and makes more complicated
        YK_NodeSingle<Integer> smallHead = null;
        YK_NodeSingle<Integer> largeHead = null;

        YK_NodeSingle<Integer> cur = head;
        YK_NodeSingle<Integer> next;

        while(cur != null) {
            next = cur.getNext();
            if (cur.get() < x) {
                cur.setNext(smallHead);
                smallHead = cur;
            } else {
                cur.setNext(largeHead);
                largeHead = cur;
            }
            cur = next;
        }

        YK_NodeSingle<Integer> newHead;

        if((smallHead != null) && (largeHead != null)) {
            System.out.println("In partitionNotRecursion, have 2 lists, small: " + Arrays.toString(smallHead.toArray()) + ", large: " + Arrays.toString(largeHead.toArray()));
            smallHead.getLastNode().setNext(largeHead);
            newHead = smallHead;
        }
        else if (smallHead != null) {
            System.out.println("In partitionNotRecursion, there is only small list: " + Arrays.toString(smallHead.toArray()));
            newHead = smallHead;
        }
        else { //largeHead != null
            System.out.println("In partitionNotRecursion, there is only large list: " + Arrays.toString(largeHead.toArray()));
            newHead = largeHead;
        }

        System.out.println("End partitionNotRecursion, x: " + x + ", list: " + Arrays.toString(newHead.toArray()));

        return newHead;
    }
}
