package YK_Cracking10_SortSearch;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class YK_SearchNoSizeTest {

    @Test
    void search1Yes() {
        int[] arr = {5};
        assertEquals(0, new YK_SearchNoSize().binarySearchNoSize(arr, 5));
    }

    @Test
    void search1NoHigh() {
        int[] arr = {4};
        assertEquals(-1, new YK_SearchNoSize().binarySearchNoSize(arr, 5));
    }

    @Test
    void search1NoLow() {
        int[] arr = {6};
        assertEquals(-1, new YK_SearchNoSize().binarySearchNoSize(arr, 5));
    }

    @Test
    void search2Yes0() {
        int[] arr = {5,6};
        assertEquals(0, new YK_SearchNoSize().binarySearchNoSize(arr, 5));
    }

    @Test
    void search2Yes1() {
        int[] arr = {4,5};
        assertEquals(1, new YK_SearchNoSize().binarySearchNoSize(arr, 5));
    }

    @Test
    void search2NoHigh() {
        int[] arr = {3,4};
        assertEquals(-1, new YK_SearchNoSize().binarySearchNoSize(arr, 5));
    }

    @Test
    void search2NoLow() {
        int[] arr = {6,7};
        assertEquals(-1, new YK_SearchNoSize().binarySearchNoSize(arr, 5));
    }

    @Test
    void search2NoMiddle() {
        int[] arr = {4,6};
        assertEquals(-1, new YK_SearchNoSize().binarySearchNoSize(arr, 5));
    }

    @Test
    void search3Yes0() {
        int[] arr = {5,6,7};
        assertEquals(0, new YK_SearchNoSize().binarySearchNoSize(arr, 5));
    }

    @Test
    void search3Yes1() {
        int[] arr = {4,5,6};
        assertEquals(1, new YK_SearchNoSize().binarySearchNoSize(arr, 5));
    }

    @Test
    void search3Yes2() {
        int[] arr = {3,4,5};
        assertEquals(2, new YK_SearchNoSize().binarySearchNoSize(arr, 5));
    }

    @Test
    void search3NoHigh() {
        int[] arr = {2,3,4};
        assertEquals(-1, new YK_SearchNoSize().binarySearchNoSize(arr, 5));
    }

    @Test
    void search3NoLow() {
        int[] arr = {6,7,8};
        assertEquals(-1, new YK_SearchNoSize().binarySearchNoSize(arr, 5));
    }

    @Test
    void search3NoMiddle() {
        int[] arr = {3,4,6};
        assertEquals(-1, new YK_SearchNoSize().binarySearchNoSize(arr, 5));
    }


    @Test
    void search4Yes0() {
        int[] arr = {5,6,7,8};
        assertEquals(0, new YK_SearchNoSize().binarySearchNoSize(arr, 5));
    }

    @Test
    void search4Yes1() {
        int[] arr = {4,5,6,7};
        assertEquals(1, new YK_SearchNoSize().binarySearchNoSize(arr, 5));
    }

    @Test
    void search4Yes2() {
        int[] arr = {3,4,5,6};
        assertEquals(2, new YK_SearchNoSize().binarySearchNoSize(arr, 5));
    }

    @Test
    void search4Yes3() {
        int[] arr = {2,3,4,5};
        assertEquals(3, new YK_SearchNoSize().binarySearchNoSize(arr, 5));
    }

    @Test
    void search4NoHigh() {
        int[] arr = {1,2,3,4};
        assertEquals(-1, new YK_SearchNoSize().binarySearchNoSize(arr, 5));
    }

    @Test
    void search4NoLow() {
        int[] arr = {6,7,8,9};
        assertEquals(-1, new YK_SearchNoSize().binarySearchNoSize(arr, 5));
    }

    @Test
    void search4NoMiddle() {
        int[] arr = {3,4,6,7};
        assertEquals(-1, new YK_SearchNoSize().binarySearchNoSize(arr, 5));
    }

}