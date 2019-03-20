package YK_Cracking8_RecDynamicMem;

import YK_Common.YK_Exception;

import java.util.ArrayList;
import java.util.Stack;

/*
Source: Cracking 8.6
Towers of Hanoi

Implemented of actually moving. Just not returning the moves since:
    1. Need to know the structure in the test
    2. Anyways complicated in tests compare anything besides number of moves
    3. Asserts in the real code verify not doing something wrong

If would want to know the number of moves, the solution would be much simpler with memorization.

First understood and implemented wrong (that things can move only to adjacent node).

Tests and implementation contains both.


 */

public class YK_Hanoi {

    private class YK_HanoiMove {
        int numToMove;
        int from;
        int to;

        public YK_HanoiMove(int numToMove, int from, int to) {
            this.numToMove = numToMove;
            this.from = from;
            this.to = to;
        }
    }


    private void singleMoveAdjacent(int from, int to, Stack<Integer>[] stacks, ArrayList<YK_HanoiMove> moves) {

        if(stacks[from].empty() ) throw new YK_Exception("Moving from empty stack: " + from + " to: " + to);
        if( (to != (from + 1)) && (to != (from - 1))) throw new YK_Exception("Moving non-adjacent, from: " + from + " to: " + to);

        int numMoving = stacks[from].pop();

        if((stacks[to].empty() == false) && (stacks[to].peek() < numMoving)) {
            throw new YK_Exception("Moving to stack whose top (" + stacks[to].peek() + ") is smaller than moved num: " + numMoving + ", from: " + from + " to: " + to);
        }
        stacks[to].push(numMoving);

        moves.add(new YK_HanoiMove(numMoving, from, to));
    }

    private void recHanoiBackAdjacent(int numDisksToMove, Stack<Integer>[] stacks, ArrayList<YK_HanoiMove> moves) {
        if (numDisksToMove == 0) return;

        recHanoiBackAdjacent(numDisksToMove - 1, stacks, moves);
        singleMoveAdjacent(2, 1, stacks, moves);
        recHanoiAdjacent(numDisksToMove - 1, stacks, moves);
        singleMoveAdjacent(1, 0, stacks, moves);
        recHanoiBackAdjacent(numDisksToMove - 1, stacks, moves);
    }

    private void recHanoiAdjacent(int numDisksToMove, Stack<Integer>[] stacks, ArrayList<YK_HanoiMove> moves) {

        if (numDisksToMove == 0) return;

        recHanoiAdjacent(numDisksToMove - 1, stacks, moves);
        singleMoveAdjacent(0, 1, stacks, moves);
        recHanoiBackAdjacent(numDisksToMove - 1, stacks, moves);
        singleMoveAdjacent(1, 2, stacks, moves);
        recHanoiAdjacent(numDisksToMove - 1, stacks, moves);
    }

    public int countMovesHanoiAdjacent(int numDisksToMove) {
        ArrayList<YK_HanoiMove> moves = new ArrayList<>();

        Stack<Integer>[] stacks = (Stack<Integer>[])new Stack[3];
        stacks[0] = new Stack<>();
        stacks[1] = new Stack<>();
        stacks[2] = new Stack<>();

        for(int i = numDisksToMove; i > 0; i--) {
            stacks[0].push(i);
        }

        recHanoiAdjacent(numDisksToMove, stacks, moves);

        return moves.size();
    }


    public int countMovesHanoi(int numDisksToMove) {
        ArrayList<YK_HanoiMove> moves = new ArrayList<>();

        Stack<Integer>[] stacks = (Stack<Integer>[])new Stack[3];
        stacks[0] = new Stack<>();
        stacks[1] = new Stack<>();
        stacks[2] = new Stack<>();

        for(int i = numDisksToMove; i > 0; i--) {
            stacks[0].push(i);
        }

        recHanoi(numDisksToMove, 0, 2, stacks, moves);

        return moves.size();
    }

    private int findHelper(int one, int two) {
        return (3 - one - two);
    }

    private void singleMove(int from, int to, Stack<Integer>[] stacks, ArrayList<YK_HanoiMove> moves) {

        if(stacks[from].empty() ) throw new YK_Exception("Moving from empty stack: " + from + " to: " + to);

        int numMoving = stacks[from].pop();

        if((stacks[to].empty() == false) && (stacks[to].peek() < numMoving)) {
            throw new YK_Exception("Moving to stack whose top (" + stacks[to].peek() + ") is smaller than moved num: " + numMoving + ", from: " + from + " to: " + to);
        }
        stacks[to].push(numMoving);

        moves.add(new YK_HanoiMove(numMoving, from, to));
    }


    private void recHanoi(int numDisksToMove, int from, int to, Stack<Integer>[] stacks, ArrayList<YK_HanoiMove> moves) {

        if (numDisksToMove == 0) return;

        int empty = findHelper(from, to);

        recHanoi(numDisksToMove - 1, from, empty, stacks, moves);
        singleMove(from, to, stacks, moves);
        recHanoi(numDisksToMove - 1, empty, to, stacks, moves);
    }
}
