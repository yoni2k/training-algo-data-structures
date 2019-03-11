package YK_Cracking3_StacksQueues;

import YK_Common.YK_Exception;
/*
Source: Cracking, p. 98, 3.1 - there are 2 classes, this and more complex YK_MultFlexStacksInOne

Implement multiple (3) stacks using the same array, with getting with O(1) and adding up to o(N).

This implementation assumes fixed capacity for each stack, addition O(1).
*/

public class YK_MultFixedStacksInOne {

    final public int NUM_STACKS = 3;
    final public int MAX_STACK_SIZE = 10;
    int[] array;
    int[] used;

    public YK_MultFixedStacksInOne() {
        array = new int[NUM_STACKS * MAX_STACK_SIZE];
        used = new int[NUM_STACKS];
    }

    public void push(int stackIndex, int num) {
        if (used[stackIndex] == MAX_STACK_SIZE) {
            throw new YK_Exception("No room");
        }

        array[stackIndex * MAX_STACK_SIZE + used[stackIndex]] = num;
        used[stackIndex]++;
    }

    public int pop(int stackIndex) {
        if (used[stackIndex] == 0) {
            throw new YK_Exception("Empty");
        }

        return array[stackIndex * MAX_STACK_SIZE + --used[stackIndex]];
    }

    public int peep(int stackIndex) {
        if (used[stackIndex] == 0) {
            throw new YK_Exception("Empty");
        }

        return array[stackIndex * MAX_STACK_SIZE + (used[stackIndex]-1)];
    }

    public boolean empty(int stackIndex) {
        return (used[stackIndex] == 0);
    }
}
