package YK_Cracking10_SortSearch;

/*
Source: Cracking 10.3

Given sorted, but rotated array, find index of a number.

Implementation: I implemented in 2 steps (actually 3):
1. Finding rotation point
2. Regular binary search - to make sure works well before doing 3
3. Binary search with given rotation point.
When there are no duplicated, this is a simpler solution with same O(log n) than solution in the book.

However, solution in the book (doing not in 2 steps, but together) works with duplicates, and mine doesn't work at all.
 */

public class YK_RotatedArray {

    private int recGetRotationDelta(int[] array, int start, int end) {
        if ((start + 1) == end) return start;

        if (array[start] < array[end - 1]) return start;

        int middle = (start + end) / 2;

        if (array[start] < array[middle]){
            return recGetRotationDelta(array, middle + 1, end);
        }
        else if(array[middle - 1] > array[middle]) { //assumption: middle >= start + 1.  If middle == start, then either array[start] < array[end - 1], or it's in recGetRotationDelta(array, middle + 1, end);
            return middle;
        }
        else {
            return recGetRotationDelta(array, start, middle);
        }
    }

    public int getRotationDelta(int[] array) {
        return recGetRotationDelta(array, 0, array.length);
    }

    private int recBinarySearch(int[] array, int beg, int end, int x) {
        if (beg >= end) return -1;

        int mid = (beg + end) / 2;

        if (array[mid] == x) {
            return mid;
        } else if (array[mid] > x) {
            return recBinarySearch(array, beg, mid, x);
        }
        else { //array[mid] < x
            return recBinarySearch(array, mid + 1, end, x);
        }
    }

    public int binarySearch(int[] array, int x) {
        return recBinarySearch(array, 0, array.length, x);
    }

    private int fixed(int index, int delta, int size) {
        return (index + delta) % size;
    }

    private int recRotatedBinarySearch(int[] array, int delta, int beg, int end, int x) {
//input - not fixed indexes, access to array - fixed indexes, return - fixed indexes

        if (beg >= end) return -1;

        int mid = (beg + end) / 2;

        int fixedMid = fixed(mid, delta, array.length);

        if (array[fixedMid] == x) {
            return fixedMid;
        } else if (array[fixedMid] > x) {
            return recRotatedBinarySearch(array, delta, beg, mid, x);
        }
        else { //array[fixedMid] < x
            return recRotatedBinarySearch(array, delta, mid + 1, end, x);
        }
    }

    public int binaryRotatedSearch(int[] array, int x) {
        int delta = getRotationDelta(array);

        return recRotatedBinarySearch(array, delta, 0, array.length, x);
    }
}
