package YK_Cracking10_SortSearch;

/*
Source: Cracking 10.10

Find an algorithm that has 2 functions that are both efficient: adding element, and getting it's rank
(how many members are smaller than it).

Implementation: I handled duplicated.  In example duplicates are given in the book, but in the solution I don't think it's being handled.
Otherwise the implementation is close enough.
 */

public class YK_RankFromStream {

    private class TrackNode {
        int value;
        int numInstances = 1;
        int numSmaller = 0;
        TrackNode right = null;
        TrackNode left = null;

        private TrackNode(int value) {
            this.value = value;
        }
    }

    private TrackNode head = null;

    private void recTrack(TrackNode head, int num) {

        if (head == null) {
            this.head = new TrackNode(num);
        } else if(head.value == num) {
            head.numInstances++;
        } else if(head.value > num) {
            head.numSmaller++;
            if(head.left == null) {
                head.left = new TrackNode(num);
            } else {
                recTrack(head.left, num);
            }
        } else { //head.value < num
            if (head.right == null) {
                head.right = new TrackNode(num);
            } else {
                recTrack(head.right, num);
            }
        }
    }

    public void track(int num) {
        recTrack(head, num);
    }

    private int recGetRankOfNumber(TrackNode head, int num, int toAdd) {

        if (head == null) return -1;

        if (head.value == num) return (head.numSmaller + toAdd);

        if(head.value > num) 		return recGetRankOfNumber(head.left, num, toAdd);
        else /*head.value < num*/	return recGetRankOfNumber(head.right, num, toAdd + head.numInstances + head.numSmaller);
    }

    public int getRankOfNumber(int num) {
        return recGetRankOfNumber(head, num, 0);
    }
}
