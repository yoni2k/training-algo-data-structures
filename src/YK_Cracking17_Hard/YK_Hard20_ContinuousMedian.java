package YK_Cracking17_Hard;

import org.jetbrains.annotations.NotNull;

import java.util.PriorityQueue;

/*
Source: Cracking 17.20
Numbers are constantly being added, and medium of previous numbers needs to be known.
 */

public class YK_Hard20_ContinuousMedian {

    private PriorityQueue<Integer> small = new PriorityQueue<>((x,y)->(y-x));
    private PriorityQueue<Integer> large = new PriorityQueue<>();

    public void addNum(int num) {
        //add to the larger
        if((large.size() == 0) || (num >= getMedian())) {
            large.add(num);
        } else {
            small.add(num);
        }

        //reshuffle to have equal size or large being 1 larger
        if(large.size() > (small.size())+1) {
            small.add(large.remove());
        } else if (large.size() < small.size()) {
            large.add(small.remove());
        }
        //System.out.println("In addNum after adding, small: " + small + ", large: " + large);
    }

    public double getMedian() {
        //System.out.println("In getMedian, small: " + small + ", large: " + large);
        if(small.size() == large.size()) {
            return (small.peek() + large.peek()) / 2.0;
        } else { //if the sizes are not equal, large is always bigger by one
            return large.peek();
        }
    }
}
