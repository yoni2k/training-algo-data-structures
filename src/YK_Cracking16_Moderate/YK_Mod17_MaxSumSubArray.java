package YK_Cracking16_Moderate;

/*
 Source: Cracking 16.17
 Given an array (positive and negative integers), return a maximum sum of consequitive integers

 Implementation: first implemented recursive solution, after reading a tip in the book, implemented
    a much simpler iterative solution
 */

public class YK_Mod17_MaxSumSubArray {
    private int getMaxSumSubArray(int[] arr, int index, int sumSoFar) {
        if (index == (arr.length - 1)) {
            return Integer.max(arr[index], sumSoFar + arr[index]);
        }

        int maxTillNowIncludingThis = Integer.max(arr[index], sumSoFar + arr[index]);

        return Integer.max(	maxTillNowIncludingThis,
                getMaxSumSubArray(arr, index + 1, maxTillNowIncludingThis));
    }

    public int getMaxSumSubArray(int[] arr) {
        return getMaxSumSubArray(arr, 0, 0);
    }



    public int getMaxSumSubArrayIter(int[] arr) {

        int maxSumTillNow = Integer.MIN_VALUE;
        int maxTotal = Integer.MIN_VALUE;

        for(int newInt : arr) {
            if(maxSumTillNow < 0) {
                maxSumTillNow = newInt;
            } else {
                maxSumTillNow += newInt;
            }
            maxTotal = Integer.max(maxTotal, maxSumTillNow);
        }

        return maxTotal;
    }
}
