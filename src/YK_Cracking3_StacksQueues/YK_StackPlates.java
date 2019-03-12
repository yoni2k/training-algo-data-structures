package YK_Cracking3_StacksQueues;

import YK_Common.YK_Exception;

import java.util.LinkedList;
import java.util.Stack;

/*
Stack of Plates.
Source: Cracking, p.99, 3.3

Stack of stacks (to make sure any stack is not too big).  Otherwise behave as a regular stack.

Follow up: popAt(index of stack).

Implemented follow up with leaving a whole bunch of half-empty stacks, best time-wise, not great memory-wise.
In the book there is an implementation of moving the whole stack when 1 removed in the middle - very bad time-wise,
 but better memory-wise.
 */

public class YK_StackPlates {

    private LinkedList<Stack<Integer>> stacks = new LinkedList<>();
    private int threshold;

    public YK_StackPlates(int threshold) {
        this.threshold = threshold;
    }

    public void push(int value) {
        if(stacks.size() == 0) {
            stacks.push(new Stack<>());
        }

        if (stacks.peek().size() == threshold) {
            stacks.push(new Stack<>());
        }

        stacks.peek().push(value);
    }

    public int pop() {

        int value = stacks.peek().pop();

        if (stacks.peek().size() == 0) {
            stacks.pop();
        }

        return value;
    }

    public int popAt(int index) {

        int fixedIndex = stacks.size() - index - 1;

        Stack<Integer> stack = stacks.get(fixedIndex);

        int value = stack.pop();

        if (stack.size() == 0) {
            stacks.remove(fixedIndex);
        }

        return value;
    }

    public int peek() {
        return stacks.peek().peek();
    }

    public boolean empty() {
        return (stacks.size() == 0);
    }
}
