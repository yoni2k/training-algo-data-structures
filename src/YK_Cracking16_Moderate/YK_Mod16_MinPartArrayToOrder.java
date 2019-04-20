package YK_Cracking16_Moderate;

/*
Source: Cracking 16.16
Given an array, return [m,n] indexes of array such that if [m,n] is ordered, the whole array will be ordered

Implementation in the book is similar but not exactly the same
 */

public class YK_Mod16_MinPartArrayToOrder {

    private int getFirstOrdered(int[] arr) {
        for (int i = 0 ; i < (arr.length - 1) ; i++) {
            if (arr[i] > arr[i+1]) {
                return i; //not fully ordered, return last ordered
            }
        }

        return arr.length;//fully ordered
    }

    private int getFirstOrderedLast(int[] arr) {
        for (int i = arr.length - 1 ; i > 0 ; i--) {
            if (arr[i] < arr[i-1]) {
                return i + 1; //not fully ordered, even in place i not ordered, return next place after i
            }
        }

        return 0;//fully ordered
    }

    private void minimizeFirstLast(int[] arr, int[] mnArr) {
        while (	(mnArr[0] != 0) &&
                (mnArr[1] != arr.length) &&
                (arr[mnArr[0] - 1] > arr[mnArr[1]])) {
            mnArr[0]--;
            mnArr[1]++;
        }
    }

    private void minimizeFirstMiddle(int[] arr, int[] mnArr) {

        int minMid = Integer.MAX_VALUE;

        for(int i = mnArr[0] ; i < mnArr[1]; i++) {
            minMid = Integer.min(minMid, arr[i]);
        }

        while((mnArr[0] > 0) && (arr[mnArr[0] - 1] > minMid)) {
            mnArr[0]--;
        }

    }

    private void minimizeLastMiddle(int[] arr, int[] mnArr) {

        int maxMid = Integer.MIN_VALUE;

        for(int i = mnArr[0] ; i < mnArr[1]; i++) {
            maxMid = Integer.max(maxMid, arr[i]);
        }

        while((mnArr[1] < arr.length) && (arr[mnArr[1]] < maxMid)) {
            mnArr[1]++;
        }

    }

    public int[] getIndexesToOrder(int[] arr) {
        int[] mnArr = new int[2]; //1st index to order, 1st index not to order

        mnArr[0] = getFirstOrdered(arr);//most can be not ordered in the beginning, might be less later
        if (mnArr[0] == arr.length) {
            //Don't need to order at all - already ordered
            return new int[] {0,0};
        }
        mnArr[1] = getFirstOrderedLast(arr);//most can be not ordered in the end, might be less later

        minimizeFirstLast(arr, mnArr);
        minimizeFirstMiddle(arr, mnArr);
        minimizeLastMiddle(arr, mnArr);

        return mnArr;
    }

    public int[] getIndexesToOrderOneFunc(int[] arr) {
        int m;
        int n;

        m = getFirstOrdered(arr);//most can be not ordered in the beginning, might be less later
        if (m == arr.length) {
            //Don't need to order at all - already ordered
            return new int[] {0,0};
        }
        n = getFirstOrderedLast(arr);//most can be not ordered in the end, might be less later

        //minimize ordered start and end such that max of start is not bigger than min of end
        while (	(m != 0) &&
                (n != arr.length) &&
                (arr[m - 1] > arr[n])) {
            m--;
            n++;
        }

        //Find min and max values of the middle
        int minMid = Integer.MAX_VALUE;
        int maxMid = Integer.MIN_VALUE;

        for(int i = m ; i < n; i++) {
            minMid = Integer.min(minMid, arr[i]);
            maxMid = Integer.max(maxMid, arr[i]);
        }

        //Minimize ordered start such that all values are smaller than middle (minimum of middle)
        while((m > 0) && (arr[m - 1] > minMid)) {
            m--;
        }

        //Minimize ordered end such that all values are larger than middle (maximum of middle)
        while((n < arr.length) && (arr[n] < maxMid)) {
            n++;
        }

        return new int[] {m, n};
    }
}
