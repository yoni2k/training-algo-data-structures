package YK_Cracking17_Hard;

import java.util.Arrays;

/*
Source: 17.14
Given an array, return k smallest elements in the array

Implementation:
- Implemented both regular quicksort and this changed quicksort.  There are many ways to implement quicksort.
    Mine is not necessarily the most standard.
- In the book there are many other implementations, one of them similar to this.
- Not sure if mine are easier / better than the book or not, seems simpler
 */

public class YK_Hard14_SmallestK_QuickSortPivot {
    private int pivotOnce(int[] arr, int from, int to) {

        int slow = from;
        int fast = from + 1;
        int temp;
        int pivot = arr[from];

        while(fast < to)  {
            if(pivot > arr[fast]) {
                temp = arr[fast];
                arr[fast] = arr[slow];
                arr[slow] = temp;
                slow++;
            }
            fast++;
        }
        return slow;
    }

    private void privQuicksort(int[] arr, int from, int to) {

        //System.out.println("In privQuicksort, from: " + from + ", to: " + to + ", array: " + Arrays.toString(arr));
        if((to - from) <= 1) {
            return; //Nothing to sort, was already sorted
        }

        int newMiddle = pivotOnce(arr, from, to);

        privQuicksort(arr, from, newMiddle);
        if(newMiddle == from) {
            newMiddle++;
        }
        privQuicksort(arr, newMiddle, to);
        //System.out.println("In privQuicksort - finished, from: " + from + ", to: " + to + ", array: " + Arrays.toString(arr));
    }

    public void quicksort(int[] arr) {
        //System.out.println("-------------------------- New sort: " + Arrays.toString(arr));
        privQuicksort(arr, 0, arr.length);
    }


    private void sortKSmallest(int[] arr, int from, int to, int k) {
        //System.out.println("In sortKSmallest, BEG - from: " + from + ", to: " + to + ", k: " + k + ", array: " + Arrays.toString(arr));
        if((to - from) <= 1) {
            return; //Nothing to sort, was already sorted
        }

        int newMiddle = pivotOnce(arr, from, to);
        //System.out.println("In sortKSmallest, AFTER PIVOT, newMiddle: " + newMiddle + ", from: " + from + ", to: " + to + ", k: " + k + ", array: " + Arrays.toString(arr));

        if (newMiddle > k) {
            sortKSmallest(arr, from, newMiddle, k);
        } else if (newMiddle < k) {
            if(newMiddle == from) {
                //System.out.println("In sortKSmallest, IN++ from: " + from + ", to: " + to + ", k: " + k + ", array: " + Arrays.toString(arr));
                newMiddle++;
            }
            sortKSmallest(arr, newMiddle, to, k);
        } //if (newMiddle == k) - no need to do anything else, it's ready to be taken

        //System.out.println("In sortKSmallest, END - from: " + from + ", to: " + to + ", k: " + k + ", array: " + Arrays.toString(arr));
    }


    public int[] getKSmallest(int[] arr, int k) {
        if(k < arr.length) {
            sortKSmallest(arr, 0, arr.length, k);
        }

        return Arrays.copyOfRange(arr, 0, k);
    }
}
