package YK_Cracking8_RecDynamicMem;

/*
Source: Cracking 8.3
Magic Index - array[index] == index
Array - Unique (could be negative) sorted integers
 */

public class YK_MagicIndex {
    public int getMagicIndex(int[] arr) {
        return getMagicIndex(arr, 0, arr.length);
    }

    private int getMagicIndex(int[] arr, int from, int to) {
        if(from >= to) return -1;

        int middle = (from + to) / 2;

        if(arr[middle] == middle) {
            return middle;
        }
        else if(arr[middle] > middle) {
            return getMagicIndex(arr, from, middle);
        }
        else { // (arr[middle] < middle)
            return getMagicIndex(arr, middle + 1, to);
        }

    }
}
