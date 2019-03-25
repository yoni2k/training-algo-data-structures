package YK_Cracking10_SortSearch;

/*
Cracking 10.5
Binary Search of strings, where some strings between sorted stings could be null.

Implementation: mine recursive, in the book there is a iterative one.
Also, I go down to find not null string, while the book does something slightly different.
 */

public class YK_BinarySearchWithNulls {

    private int recStringNullsBinarySearch(String[] array, int beg, int end, String string) {
        if (beg >= end) return -1;

        int mid = (beg + end) / 2;
        int midLow = mid;

        while ((midLow >= beg) && (array[midLow].equals(""))) midLow--;

        if(midLow < beg) return recStringNullsBinarySearch(array, mid + 1, end, string);

        int compareResult = array[midLow].compareTo(string);

        if (compareResult == 0)     return midLow;
        else if (compareResult > 0) return recStringNullsBinarySearch(array, beg, midLow, string);
        else /*compareResult < 0 */ return recStringNullsBinarySearch(array, mid + 1, end, string);
    }

    public int findString(String[] array, String string) {
        return recStringNullsBinarySearch(array, 0, array.length , string);
    }
}
