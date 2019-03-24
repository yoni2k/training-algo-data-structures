package YK_Cracking10_SortSearch;

/*
Source: Cracking 10.1
Given 2 sorted arrays, merge into first where is room for second

Implementation similar to what's in the book
 */

public class YK_SortedMerge {
    public int[] mergeArrays(int[] a, int[] b) {

        int iB = b.length - 1;
        int iA = a.length - b.length - 1;
        int iM = a.length - 1;

        while((iB >= 0) && (iA >= 0)) {
            if(a[iA] > b[iB]) {
                a[iM--] = a[iA--];
            }
            else {
                a[iM--] = b[iB--];
            }
        }

        while (iB >= 0) a[iM--] = b[iB--];

        return a;//needed mostly for tests
    }
}
