package YK_Cracking10_SortSearch;

/*
Source: Cracking 10.4
Search without knowing size of array.

My implementation combines what's in the book in 2 steps into 1 step
 */

public class YK_SearchNoSize {

    private class Listy {
        int[] array;
        private Listy(int[] array) {
            this.array = array;
        }

        private int elementAt(int index) {
            if (index >= array.length) return -1;

            return array[index];
        }
    }

    private int recBinarySearchNoSize(Listy listy, int beg, int last, int x) {

        if (beg > last) return -1;

        int mid = (beg + last)/ 2;

        if ((listy.elementAt(last) != -1) && (listy.elementAt(last) < x)) {
            return recBinarySearchNoSize(listy, last + 1, last * 2, x);
        } else if((listy.elementAt(mid) == -1) || (listy.elementAt(mid) > x)) {
                return recBinarySearchNoSize(listy, beg, mid - 1, x);
        } else if (listy.elementAt(mid) == x) {
                return mid;
        } else { //listy.elementAt(mid) < x
                return recBinarySearchNoSize(listy, mid + 1, last, x);
        }
    }

    public int binarySearchNoSize(int[] array, int x) {
        Listy listy = new Listy(array);
        return recBinarySearchNoSize(listy, 0, 1, x);
    }
}
