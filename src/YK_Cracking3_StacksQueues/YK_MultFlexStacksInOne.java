package YK_Cracking3_StacksQueues;

import YK_Common.YK_Exception;

import java.util.Arrays;

/*
Source: Cracking, p. 98, 3.1 - there are 2 classes, this and simpler YK_MultFixedStacksInOne

Implement multiple (3) stacks using the same array, with getting with O(1) and adding up to o(N).

Here stacks run out of room if there are no room in the array at all.
 */

public class YK_MultFlexStacksInOne {

    final public int NUM_QUEUES = 3;
    final public int MAX_QUEUES_SIZE = 30;
    int[] array = new int[MAX_QUEUES_SIZE];
    int[] startIndex = {0, 10, 20};
    int[] capacity = {10, 10, 10};
    int[] used = {0, 0, 0};

    public YK_MultFlexStacksInOne() {
    }

    private int totalUsed() {
        return used[0] + used[1] + used[2];
    }

    public void push(int stackIndex, int num) {
        if (totalUsed() == MAX_QUEUES_SIZE) {
            throw new YK_Exception("No room");
        }

        if (used[stackIndex] == capacity[stackIndex]) {
            makeRoom(stackIndex);
        }

        array[(startIndex[stackIndex] + used[stackIndex]) % MAX_QUEUES_SIZE] = num;
        used[stackIndex]++;
    }

    private void move(int stackIndex) {

        int indexFrom;
        int indexTo;

        for(int i = (used[stackIndex]-1); i >= 0; i--) {
            indexFrom = ((startIndex[stackIndex] + i) % MAX_QUEUES_SIZE);
            indexTo = ((startIndex[stackIndex] + i + 1) % MAX_QUEUES_SIZE);

            array[indexTo] = array[indexFrom];
        }

        startIndex[stackIndex] = ((startIndex[stackIndex] + 1) % MAX_QUEUES_SIZE);
        capacity[stackIndex]--;
        capacity[(stackIndex + 2) % NUM_QUEUES]++;
    }

    private void makeRoom(int stackIndex) {
        int nextIndex = ((stackIndex + 1) % NUM_QUEUES);
        int secondnextIndex = ((stackIndex + 2) % NUM_QUEUES);

        if(used[nextIndex] < capacity[nextIndex]) {
            move(nextIndex);
        }
        else {
            move(secondnextIndex);
            move(nextIndex);
        }
    }

    public int pop(int stackIndex) {
        if (used[stackIndex] == 0) {
            throw new YK_Exception("Empty");
        }

        used[stackIndex]--;
        return array[(startIndex[stackIndex] + used[stackIndex] + MAX_QUEUES_SIZE) % MAX_QUEUES_SIZE];
    }

    public int peep(int stackIndex) {
        if (used[stackIndex] == 0) {
            throw new YK_Exception("Empty");
        }

        return array[(startIndex[stackIndex] + used[stackIndex] - 1 + MAX_QUEUES_SIZE) % MAX_QUEUES_SIZE];
    }

    public boolean empty(int stackIndex) {
        return (used[stackIndex] == 0);
    }

    public void printState() {

        System.out.println("printState, array: " + Arrays.toString(array));
        System.out.println("startIndex, array: " + Arrays.toString(startIndex));
        System.out.println("capacity, array: " + Arrays.toString(capacity));
        System.out.println("used, array: " + Arrays.toString(used));
    }
}
