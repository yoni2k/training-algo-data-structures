package YK_AmazonPrep;

import java.util.ArrayList;

public class YK_5MinHeap {

    enum YK_MIN_MAX{MIN, MAX}

    private ArrayList<Integer> arr = new ArrayList<>();
    private YK_MIN_MAX minMax;

    public YK_5MinHeap(YK_MIN_MAX minMax) {
        this.minMax = minMax;
    }

    private void bubbleUp(int index) {
        int tmp;

        while (index > 0) {
            int prevIndex;
            if ((index % 2) == 0) {
                prevIndex = (index / 2) - 1;
            } else { //index odd
                prevIndex = (index - 1) / 2;
            }
            if ((minMax == YK_MIN_MAX.MIN) && (arr.get(prevIndex) > arr.get(index)) ||
                    (minMax == YK_MIN_MAX.MAX) && (arr.get(prevIndex) < arr.get(index)))   {
                tmp = arr.get(index);
                arr.set(index, arr.get(prevIndex));
                arr.set(prevIndex, tmp);
                index = prevIndex;
            } else {
                break;
            }
        }
    }

    private void bubbleDown() {
        int index =  0;
        int nextIndex1;
        int nextIndex2;
        int nextIndexMatching;
        int next1;
        int next2;
        int nextMatching;
        int cur;

        while (index < arr.size()) {
            nextIndex1 = (index * 2) + 1;
            nextIndex2 = (index + 1) * 2;
            cur = arr.get(index);
            if (minMax == YK_MIN_MAX.MIN) {
                next1 = Integer.MAX_VALUE;
                next2 = Integer.MAX_VALUE;
            } else { //minMax == YK_MIN_MAX.MAX
                next1 = Integer.MIN_VALUE;
                next2 = Integer.MIN_VALUE;
            }
            if (nextIndex2 < arr.size()) {
                next2 = arr.get(nextIndex2);
            }
            if (nextIndex1 < arr.size()) {
                next1 = arr.get(nextIndex1);
            }
            if (minMax == YK_MIN_MAX.MIN) {
                nextMatching = (next1 < next2) ? next1 : next2;
                nextIndexMatching = (next1 < next2) ? nextIndex1 : nextIndex2;
                if(nextMatching > cur) {
                    break;
                }
            } else { //minMax == YK_MIN_MAX.MAX
                nextMatching = (next1 > next2) ? next1 : next2;
                nextIndexMatching = (next1 > next2) ? nextIndex1 : nextIndex2;
                if(nextMatching < cur) {
                    break;
                }
            }
            arr.set(index, nextMatching);
            arr.set(nextIndexMatching, cur);
            index = nextIndexMatching;
        }
    }

    public void push(int newInt) {
        arr.add(newInt);
        bubbleUp(arr.size() - 1);
    }

    public int pop() {
        if (arr.size() == 0) {
            return -1;
        }
        int ret = arr.get(0);
        int valueToSet = arr.remove(arr.size() - 1);
        if(arr.size() > 0) {
            arr.set(0,valueToSet);
            bubbleDown();
        }

        return ret;
    }

    public int peek() {
        if (arr.size() > 0) {
            return arr.get(0);
        } else { //array empty
            return -1;
        }
    }

    public boolean empty() {
        return (arr.size() == 0);
    }

    @Override
    public String toString() {
        return arr.toString();
    }
}
