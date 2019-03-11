package YK_Cracking2_LinkedLists;

import YK_Common.YK_NodeSingle;

import java.util.Arrays;

/* Source: Cracking, p. 95, 2.5

Add numbers that are represented as linked lists, where the numbers are either backwards (123 = {3)->{2}->{1}) - easier or regular /foward

Make sure to take care of different lengths lists.

Backwards can be solved as loop, forwards:
- either reorder to backwards, add, and then reorder again
- or pretty much must be done by recursion

*/

public class YK_SumLists {

    private class YK_SumNode {
        YK_NodeSingle<Integer> list;
        Integer addOne;
        private YK_SumNode(YK_NodeSingle<Integer> list, Integer addOne) {
            this.list = list;
            this.addOne = addOne;
        }
    }

    private YK_SumNode sumRecSameLen(YK_NodeSingle<Integer> head1, YK_NodeSingle<Integer> head2) {

        YK_SumNode nodeToReturn;
        YK_NodeSingle<Integer> newNode;
        YK_SumNode sumNodeTail = null;

        int addOne = 0;
        int intInNode = head1.get() + head2.get();

        if(head1.getNext() != null) {
            sumNodeTail = sumRecSameLen(head1.getNext(), head2.getNext());
            intInNode += sumNodeTail.addOne;
        }

        if (intInNode > 9) {
            addOne = 1;
            intInNode %= 10;
        }

        newNode = new YK_NodeSingle<>(intInNode);
        if(sumNodeTail != null) {
            newNode.setNext(sumNodeTail.list);
        }

        return new YK_SumNode(newNode, addOne);
    }

    public YK_NodeSingle<Integer> sumFront(YK_NodeSingle<Integer> head1, YK_NodeSingle<Integer> head2) {

        int size1 = head1.size();
        int size2 = head2.size();

        YK_NodeSingle<Integer> listLong;
        YK_NodeSingle<Integer> listShort;
        int sizeLong;
        int sizeShort;

        if (size1 >= size2) {
            listLong = head1;
            listShort = head2;

            sizeLong = size1;
            sizeShort = size2;
        }
        else {
            listLong = head2;
            listShort = head1;

            sizeLong = size2;
            sizeShort = size1;
        }

        YK_NodeSingle<Integer> headPaddedShort = pad(listShort, sizeLong - sizeShort);

        YK_SumNode sumNode = sumRecSameLen(listLong, headPaddedShort);

        YK_NodeSingle<Integer> headRes;

        if(sumNode.addOne > 0) {
            headRes = new YK_NodeSingle<>(1);
            headRes.setNext(sumNode.list);
        }
        else {
            headRes = sumNode.list;
        }

        System.out.println("Stop sumBack,  sum: " + Arrays.toString(headRes.toArray()) +", list1: " + Arrays.toString(head1.toArray()) + ", list2: " + Arrays.toString(head2.toArray()));

        return headRes;
    }

    private YK_NodeSingle<Integer> pad(YK_NodeSingle<Integer> listShort, int numToPad) {

        if(numToPad == 0) {
            return listShort;
        }

        YK_NodeSingle<Integer> head = null;
        YK_NodeSingle<Integer> prev = null;
        YK_NodeSingle<Integer> newNode;

        while(numToPad > 0) {
            newNode = new YK_NodeSingle<>(0);

            if(head == null) {
                head = newNode;
            }
            else {
                prev.setNext(newNode);
            }
            prev = newNode;
            numToPad--;
        }

        prev.setNext(listShort);

        return head;
    }

    public YK_NodeSingle<Integer> sumBack(YK_NodeSingle<Integer> head1, YK_NodeSingle<Integer> head2) {

        YK_NodeSingle<Integer> headRes = null;
        YK_NodeSingle<Integer> curRes = null;
        YK_NodeSingle<Integer> newNode;

        System.out.println("Start sumBack, Got to sum back to linked lists, list1: " + Arrays.toString(head1.toArray()) + ", list2: " + Arrays.toString(head2.toArray()));

        YK_NodeSingle<Integer> cur1 = head1;
        YK_NodeSingle<Integer> cur2 = head2;
        int addOne = 0;
        int digitRes;

        while((cur1 != null) || (cur2 != null)) {

            digitRes = 0;

            if (cur1 != null) {
                digitRes += cur1.get();
            }
            if(cur2 != null) {
                digitRes += cur2.get();
            }

            digitRes += addOne;
            addOne = 0;
            if(digitRes > 9) {
                addOne = 1;
                digitRes %= 10;
            }

            newNode = new YK_NodeSingle<>(digitRes);

            if(curRes == null) {
                curRes = newNode;
                headRes = newNode;
            }
            else {
                curRes.setNext(newNode);
                curRes = newNode;
            }

            if(cur1 != null) {
                cur1 = cur1.getNext();
            }
            if(cur2 != null) {
                cur2 = cur2.getNext();
            }
        }

        if(addOne == 1) {
            newNode = new YK_NodeSingle<>(1);
            curRes.setNext(newNode);
        }

        System.out.println("Stop sumBack,  sum: " + Arrays.toString(headRes.toArray()) +", list1: " + Arrays.toString(head1.toArray()) + ", list2: " + Arrays.toString(head2.toArray()));

        return headRes;
    }
}
