package YK_Common;

import java.util.ArrayList;
import java.util.Arrays;

//TODO - Write tests and debug this class. Not a purpose in iself, small parts are currently used
public class YK_NodeSingle<E> {

    private E data;
    private YK_NodeSingle<E> next = null;

    public YK_NodeSingle(E data) {
        System.out.println("Node created with data: " + data);
        this.data = data;
    }

    public YK_NodeSingle(E data, YK_NodeSingle<E> next) {
        System.out.println("Node created with data: " + data + ", with next node with data: " + next.data);
        this.data = data;
        this.next = next;
    }

    public YK_NodeSingle(E[] array) {
        System.out.println("Nodes created from array: " + Arrays.toString(array));
        this.data = array[0];

        if(array.length > 1) {
            this.next = new YK_NodeSingle<>(Arrays.copyOfRange(array,1,array.length));
        }
    }

    public void set(E data) {
        System.out.println("Setting (overriding) data: " + this.data + " with " + data);
        this.data = data;
    }

    public void setNext(YK_NodeSingle<E> next) {
        if (next != null) {
            System.out.println("Setting next this data: " + this.data + ", next data " + next.data);
        }
        else {
            System.out.println("Setting next to null, this data: " + this.data);
        }
        this.next = next;
    }

    public E get() {
        System.out.println("Getting data: " + this.data);
        return data;
    }

    public YK_NodeSingle<E> getNext() {
        if(next != null) {
            System.out.println("Getting next this data: " + this.data + ", next data " + next.data);
        }
        else {
            System.out.println("Next is null of this data: " + this.data);
        }
        return next;
    }

    public YK_NodeSingle add(int index, E element) {
        System.out.println("Adding element " + element + " at index: " + index);
        YK_NodeSingle head = this;

        if(index == 0) {
            head = new YK_NodeSingle<>(element, this);
        }
        else {
            YK_NodeSingle<E> prev = findBeforeIndex(index);
            YK_NodeSingle<E> newNode = new YK_NodeSingle<>(element, prev.next);
            prev.next = newNode;
        }

        System.out.println("After add: " + Arrays.toString(toArray()));

        return head;
    }

    public void addAtTheEnd(E element) {

        System.out.println("Adding element at the end: " + element);

        findLast(this).next = new YK_NodeSingle<>(element);

        System.out.println("After add: " + Arrays.toString(toArray()));
    }

    public void addMultipleEnd(YK_NodeSingle<E> subHead) {

        System.out.println("Adding multiple elements at the end, current: " + Arrays.toString(this.toArray()) + ", adding: " + Arrays.toString(subHead.toArray()));

        findLast(this).next = subHead;

        System.out.println("After add: " + Arrays.toString(toArray()));
    }

    public YK_NodeSingle addMultiple(int index, YK_NodeSingle<E> subHead) {

        System.out.println("Adding multiple elements at index " + index + ", current: " + Arrays.toString(this.toArray()) + ", adding: " + Arrays.toString(subHead.toArray()));

        YK_NodeSingle secondListLastMember = findLast(subHead);
        YK_NodeSingle head = this;

        if(index == 0) {
            head = subHead;

            secondListLastMember.next = this;
        }
        else {
            YK_NodeSingle firstListPrevMember = findBeforeIndex(index);

            secondListLastMember.next = firstListPrevMember.next;
            firstListPrevMember.next = subHead;
        }

        System.out.println("After add: " + Arrays.toString(head.toArray()));

        return head;
    }

    public boolean contains(E element) {

        System.out.println("Checking if contains element " + element + ", in array: " + Arrays.toString(toArray()));

        YK_NodeSingle cur = this;

        while(cur != null) {
            if (cur.data == element) {
                System.out.println("Element found");
                return true;
            }

            cur = cur.next;
        }

        System.out.println("Element NOT found");
        return false;
    }

    public E get(int index) {
        E gotData = findIndex(index).data;

        System.out.println("Got element at index " + index + ", data: " + gotData + ", in array: " + Arrays.toString(toArray()));

        return gotData;
    }

    public E getLast() {
        E gotData = findLast(this).data;

        System.out.println("Got last node with data: " + gotData + ", in array: " + Arrays.toString(toArray()));

        return gotData;
    }

    public YK_NodeSingle<E> getLastNode() {
        YK_NodeSingle<E> last = findLast(this);

        System.out.println("Got last node with data: " + last.get() + ", in array: " + Arrays.toString(toArray()));

        return last;
    }

    public int indexOf(E element) {

        System.out.println("Looking for element " + element + ", in array: " + Arrays.toString(toArray()));

        YK_NodeSingle cur = this;
        int index = 0;

        while(cur != null) {
            if (cur.data == element) {
                System.out.println("Element: " + element + ", found at index: " + index);
                return index;
            }

            cur = cur.next;
            index++;
        }

        throw new YK_Exception("Element doesn't exist: " + element);

    }

    public int lastIndexOf(E element) {

        System.out.println("Looking for lastIndex of element: " + element + ", in array: " + Arrays.toString(toArray()));

        YK_NodeSingle cur = this;
        int lastIndex = -1;
        int index = 0;

        while(cur != null) {
            if (cur.data == element) {
                System.out.println("Found another instance of element: " + element + ", at index: " + index);
                lastIndex = index;
            }

            cur = cur.next;
            index++;
        }

        if (lastIndex == -1) {
            throw new YK_Exception("Element doesn't exist: " + element);
        }
        else {
            System.out.println("Last instance found of element: " + element + ", at index: " + lastIndex);
            return lastIndex;
        }
    }

    public YK_NodeSingle remove(int index) {

        System.out.println("Removing index " + index + ", in array: " + Arrays.toString(toArray()));

        YK_NodeSingle head = this;

        if (index == 0) {
            head = this.next;
        }
        else {
            YK_NodeSingle prev = findBeforeIndex(index);

            if (prev.next == null) {
                throw new YK_Exception("Invalid index given: " + index + ", only 1 before exists");
            }

            prev.next = prev.next.next;
        }

        System.out.println("After index " + index + ", array: " + Arrays.toString(head.toArray()));

        return head;
    }

    public void set(int index, E element) {
        System.out.println("Setting index: " + index + " with element: " + element + ", in array: " + Arrays.toString(toArray()));

        findIndex(index).data = element;

        System.out.println("After set, array: " + Arrays.toString(toArray()));
    }

    public int size() {
        int i = 1;
        YK_NodeSingle cur = this;

        while((cur = cur.next) != null) {
            i++;
        }

        System.out.println("Returning size: " + i + " of array: " + Arrays.toString(toArray()));

        return i;
    }

    public Object[] toArray() {
        ArrayList<E> array = new ArrayList<>();

        YK_NodeSingle<E> cur = this;

        while(cur != null) {
            array.add(cur.data);
            cur = cur.next;
        }

        return array.toArray();
    }

    private YK_NodeSingle<E> findLast(YK_NodeSingle<E> head) {
        if (head == null) {
            throw new YK_Exception("findLast got null head");
        }

        YK_NodeSingle<E> prev = null;
        YK_NodeSingle<E> cur = head;

        while (cur != null) {
            prev = cur;
            cur = cur.next;
        }

        System.out.println("In findLast, returning element: " + prev.data + ", from array: " + Arrays.toString(head.toArray()));

        return prev;
    }

    private YK_NodeSingle<E> findBeforeIndex(int index) {
        if (index < 1) throw new YK_Exception("getBeforeIndex(), Index < 1" + index);

        System.out.println("In findBeforeIndex index: " + index + ", array: " + Arrays.toString(toArray()));

        YK_NodeSingle<E> cur = this;
        int i = 0;

        while ((cur = cur.next) != null) {

            if(index == (i + 1)) {
                System.out.println("Found element number " + i + ", with data " + cur.data);
                return cur;
            }

            i++;
        }

        throw new YK_Exception("Invalid index given: " + index + ", reached maximum: " + i);
    }

    private YK_NodeSingle<E> findIndex(int index) {

        System.out.println("In findIndex index: " + index + ", array: " + Arrays.toString(toArray()));

        YK_NodeSingle<E> cur = this;
        int i = 0;

        while (cur != null) {
            if(index == i) {
                System.out.println("Found element with index: " + index + ", with data " + cur.data);
                return cur;
            }

            cur = cur.next;
            i++;
        }

        throw new YK_Exception("Invalid index given: " + index + ", reached maximum: " + i);
    }
}
