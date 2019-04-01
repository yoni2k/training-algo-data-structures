package YK_AmazonPrep;

import java.util.PriorityQueue;

public class YK_5MinMaxHeapPriorityQueue implements YK_5MinMaxHeapInterface {

    enum YK_MIN_MAX{MIN, MAX}

    PriorityQueue<Integer> prq;

    public YK_5MinMaxHeapPriorityQueue(YK_MIN_MAX type) {
        if (type == YK_MIN_MAX.MIN) {
            prq = new PriorityQueue<>();
        } else {
            prq = new PriorityQueue<>((x,y) -> y-x);
        }
    }

    public void push(int newInt) {
        prq.add(newInt);
    }

    public int pop() {
        return prq.remove();
    }

    public int peek() {
        return prq.peek();
    }

    public boolean empty() {
        return prq.isEmpty();
    }
}
