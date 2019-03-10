package YK_Cracking2_LinkedLists;

import YK_Common.YK_NodeSingle;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

/*
Source: Cracking, ch.2, page 94, 2.1

Write code to remove duplicates from an unsorted linked list.

There are 2 solutions here:
- Space O(N) additional, Time O(N) using HashMap
- No additional space, Time O(N^2)

 */

public class YK_RemoveDups {

    //Space - inplace, Time O(N^2)
    static public YK_NodeSingle<Integer> removeDupsNoHash(YK_NodeSingle<Integer> head) {

        System.out.println("Start YK_RemoveDups, list: " + Arrays.toString(head.toArray()));

        YK_NodeSingle<Integer> lazy = head;

        while(lazy != null) {

            YK_NodeSingle<Integer> fastPrevious = lazy;
            YK_NodeSingle<Integer> fast = lazy.getNext();

            while(fast != null) {
                if (fast.get().equals(lazy.get())) {
                    fastPrevious.setNext(fast.getNext());

                    //fastPrevious doesn't get changed
                    fast = fast.getNext();
                } else {
                    fastPrevious = fast;
                    fast = fast.getNext();
                }
            }

            lazy = lazy.getNext();
        }

        System.out.println("End YK_RemoveDups, list: " + Arrays.toString(head.toArray()));

        return head;
    }

    //Space - O(N) for Hash, Time O(N)
    static public YK_NodeSingle<Integer> removeDupsWithHash(YK_NodeSingle<Integer> head) {

        System.out.println("Start YK_RemoveDups, list: " + Arrays.toString(head.toArray()));

        HashMap<Integer,Integer> hm = new HashMap<>();

        YK_NodeSingle<Integer> cur = head;

        //counting instances
        while(cur != null) {

            if(hm.containsKey(cur.get())) {
                Integer instances = hm.get(cur.get());

                hm.put(cur.get(), instances+1);
            }
            else {
                hm.put(cur.get(), 1);
            }

            cur = cur.getNext();
        }

        //removing duplicates
        cur = head;
        YK_NodeSingle<Integer> prev = head;

        while(cur != null) {

            Integer instances = hm.get(cur.get());

            if(instances == 0) {
                //meaning 1st instance was already seen, so this instance should be removed
                //Assumption: will never happen in the beginning of the list, since at least one instance should be seen
                prev.setNext(cur.getNext());

                //prev is not being updated
                cur = cur.getNext();

            } else {
                if (instances > 1) {
                    //first instance seen - reset to 0 instances to show that 1st instance was alrady seen
                    hm.put(cur.get(), 0);
                }

                prev = cur;
                cur = cur.getNext();
            }
        }

        System.out.println("End YK_RemoveDups, list: " + Arrays.toString(head.toArray()));

        return head;
    }
}
