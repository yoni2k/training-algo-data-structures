package YK_Cracking10_SortSearch;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class YK_RotatedArrayTest {

    @Test
    void delta1() {
        int[] arr = {1};
        assertEquals(0, new YK_RotatedArray().getRotationDelta(arr));
    }

    @Test
    void delta2ordered() {
        int[] arr = {1,2};
        assertEquals(0, new YK_RotatedArray().getRotationDelta(arr));
    }

    @Test
    void delta2notOrdered() {
        int[] arr = {2,1};
        assertEquals(1, new YK_RotatedArray().getRotationDelta(arr));
    }

    @Test
    void delta3ordered() {
        int[] arr = {1,2,3};
        assertEquals(0, new YK_RotatedArray().getRotationDelta(arr));
    }

    @Test
    void delta3rotated1() {
        int[] arr = {3,1,2};
        assertEquals(1, new YK_RotatedArray().getRotationDelta(arr));
    }

    @Test
    void delta3rotated2() {
        int[] arr = {2,3,1};
        assertEquals(2, new YK_RotatedArray().getRotationDelta(arr));
    }

    @Test
    void delta4ordered() {
        int[] arr = {1,2,3,4};
        assertEquals(0, new YK_RotatedArray().getRotationDelta(arr));
    }

    @Test
    void delta4rotated1() {
        int[] arr = {4,1,2,3};
        assertEquals(1, new YK_RotatedArray().getRotationDelta(arr));
    }

    @Test
    void delta4rotated2() {
        int[] arr = {3,4,1,2};
        assertEquals(2, new YK_RotatedArray().getRotationDelta(arr));
    }

    @Test
    void delta4rotated3() {
        int[] arr = {2,3,4,1};
        assertEquals(3, new YK_RotatedArray().getRotationDelta(arr));
    }

    @Test
    void delta5ordered() {
        int[] arr = {1,2,3,4,5};
        assertEquals(0, new YK_RotatedArray().getRotationDelta(arr));
    }

    @Test
    void delta5rotated1() {
        int[] arr = {5,1,2,3,4};
        assertEquals(1, new YK_RotatedArray().getRotationDelta(arr));
    }

    @Test
    void delta5rotated2() {
        int[] arr = {4,5,1,2,3};
        assertEquals(2, new YK_RotatedArray().getRotationDelta(arr));
    }

    @Test
    void delta5rotated3() {
        int[] arr = {3,4,5,1,2};
        assertEquals(3, new YK_RotatedArray().getRotationDelta(arr));
    }

    @Test
    void delta5rotated4() {
        int[] arr = {2,3,4,5,1};
        assertEquals(4, new YK_RotatedArray().getRotationDelta(arr));
    }
    
    /*************************** Regular binary search *********************************/
    
    @Test
    void search1Yes() {
        int[] arr = {5};
        assertEquals(0, new YK_RotatedArray().binarySearch(arr, 5));
    }

    @Test
    void search1NoHigh() {
        int[] arr = {4};
        assertEquals(-1, new YK_RotatedArray().binarySearch(arr, 5));
    }

    @Test
    void search1NoLow() {
        int[] arr = {6};
        assertEquals(-1, new YK_RotatedArray().binarySearch(arr, 5));
    }

    @Test
    void search2Yes0() {
        int[] arr = {5,6};
        assertEquals(0, new YK_RotatedArray().binarySearch(arr, 5));
    }

    @Test
    void search2Yes1() {
        int[] arr = {4,5};
        assertEquals(1, new YK_RotatedArray().binarySearch(arr, 5));
    }

    @Test
    void search2NoHigh() {
        int[] arr = {3,4};
        assertEquals(-1, new YK_RotatedArray().binarySearch(arr, 5));
    }

    @Test
    void search2NoLow() {
        int[] arr = {6,7};
        assertEquals(-1, new YK_RotatedArray().binarySearch(arr, 5));
    }

    @Test
    void search2NoMiddle() {
        int[] arr = {4,6};
        assertEquals(-1, new YK_RotatedArray().binarySearch(arr, 5));
    }

    @Test
    void search3Yes0() {
        int[] arr = {5,6,7};
        assertEquals(0, new YK_RotatedArray().binarySearch(arr, 5));
    }

    @Test
    void search3Yes1() {
        int[] arr = {4,5,6};
        assertEquals(1, new YK_RotatedArray().binarySearch(arr, 5));
    }

    @Test
    void search3Yes2() {
        int[] arr = {3,4,5};
        assertEquals(2, new YK_RotatedArray().binarySearch(arr, 5));
    }

    @Test
    void search3NoHigh() {
        int[] arr = {2,3,4};
        assertEquals(-1, new YK_RotatedArray().binarySearch(arr, 5));
    }

    @Test
    void search3NoLow() {
        int[] arr = {6,7,8};
        assertEquals(-1, new YK_RotatedArray().binarySearch(arr, 5));
    }

    @Test
    void search3NoMiddle() {
        int[] arr = {3,4,6};
        assertEquals(-1, new YK_RotatedArray().binarySearch(arr, 5));
    }


    @Test
    void search4Yes0() {
        int[] arr = {5,6,7,8};
        assertEquals(0, new YK_RotatedArray().binarySearch(arr, 5));
    }

    @Test
    void search4Yes1() {
        int[] arr = {4,5,6,7};
        assertEquals(1, new YK_RotatedArray().binarySearch(arr, 5));
    }

    @Test
    void search4Yes2() {
        int[] arr = {3,4,5,6};
        assertEquals(2, new YK_RotatedArray().binarySearch(arr, 5));
    }
    
    @Test
    void search4Yes3() {
        int[] arr = {2,3,4,5};
        assertEquals(3, new YK_RotatedArray().binarySearch(arr, 5));
    }

    @Test
    void search4NoHigh() {
        int[] arr = {1,2,3,4};
        assertEquals(-1, new YK_RotatedArray().binarySearch(arr, 5));
    }

    @Test
    void search4NoLow() {
        int[] arr = {6,7,8,9};
        assertEquals(-1, new YK_RotatedArray().binarySearch(arr, 5));
    }

    @Test
    void search4NoMiddle() {
        int[] arr = {3,4,6,7};
        assertEquals(-1, new YK_RotatedArray().binarySearch(arr, 5));
    }

    /*************************** Rotated binary search *********************************/

    @Test
    void rotatedSearch1Yes() {
        int[] arr = {5};
        assertEquals(0, new YK_RotatedArray().binaryRotatedSearch(arr, 5));
    }

    @Test
    void rotatedSearch1NoHigh() {
        int[] arr = {4};
        assertEquals(-1, new YK_RotatedArray().binaryRotatedSearch(arr, 5));
    }

    @Test
    void rotatedSearch1NoLow() {
        int[] arr = {6};
        assertEquals(-1, new YK_RotatedArray().binaryRotatedSearch(arr, 5));
    }

    @Test
    void rotatedSearch2Yes0_0() {
        int[] arr = {5,6};
        assertEquals(0, new YK_RotatedArray().binaryRotatedSearch(arr, 5));
    }

    @Test
    void rotatedSearch2Yes0_1() {
        int[] arr = {6,5};
        assertEquals(1, new YK_RotatedArray().binaryRotatedSearch(arr, 5));
    }

    @Test
    void rotatedSearch2Yes1_0() {
        int[] arr = {4,5};
        assertEquals(1, new YK_RotatedArray().binaryRotatedSearch(arr, 5));
    }

    @Test
    void rotatedSearch2Yes1_1() {
        int[] arr = {5,4};
        assertEquals(0, new YK_RotatedArray().binaryRotatedSearch(arr, 5));
    }

    @Test
    void rotatedSearch2NoHigh_0() {
        int[] arr = {3,4};
        assertEquals(-1, new YK_RotatedArray().binaryRotatedSearch(arr, 5));
    }

    @Test
    void rotatedSearch2NoHigh_1() {
        int[] arr = {4,3};
        assertEquals(-1, new YK_RotatedArray().binaryRotatedSearch(arr, 5));
    }

    @Test
    void rotatedSearch2NoLow_0() {
        int[] arr = {6,7};
        assertEquals(-1, new YK_RotatedArray().binaryRotatedSearch(arr, 5));
    }

    @Test
    void rotatedSearch2NoLow_1() {
        int[] arr = {7,6};
        assertEquals(-1, new YK_RotatedArray().binaryRotatedSearch(arr, 5));
    }

    @Test
    void rotatedSearch2NoMiddle_0() {
        int[] arr = {4,6};
        assertEquals(-1, new YK_RotatedArray().binaryRotatedSearch(arr, 5));
    }

    @Test
    void rotatedSearch2NoMiddle_1() {
        int[] arr = {6,4};
        assertEquals(-1, new YK_RotatedArray().binaryRotatedSearch(arr, 5));
    }

    @Test
    void rotatedSearch3Yes0_0() {
        int[] arr = {5,6,7};
        assertEquals(0, new YK_RotatedArray().binaryRotatedSearch(arr, 5));
    }

    @Test
    void rotatedSearch3Yes0_1() {
        int[] arr = {7,5,6};
        assertEquals(1, new YK_RotatedArray().binaryRotatedSearch(arr, 5));
    }

    @Test
    void rotatedSearch3Yes0_2() {
        int[] arr = {6,7,5};
        assertEquals(2, new YK_RotatedArray().binaryRotatedSearch(arr, 5));
    }

    @Test
    void rotatedSearch3Yes1_0() {
        int[] arr = {4,5,6};
        assertEquals(1, new YK_RotatedArray().binaryRotatedSearch(arr, 5));
    }

    @Test
    void rotatedSearch3Yes1_1() {
        int[] arr = {6,4,5};
        assertEquals(2, new YK_RotatedArray().binaryRotatedSearch(arr, 5));
    }

    @Test
    void rotatedSearch3Yes1_2() {
        int[] arr = {5,6,4};
        assertEquals(0, new YK_RotatedArray().binaryRotatedSearch(arr, 5));
    }

    @Test
    void rotatedSearch3Yes2_0() {
        int[] arr = {3,4,5};
        assertEquals(2, new YK_RotatedArray().binaryRotatedSearch(arr, 5));
    }

    @Test
    void rotatedSearch3Yes2_1() {
        int[] arr = {5,3,4};
        assertEquals(0, new YK_RotatedArray().binaryRotatedSearch(arr, 5));
    }

    @Test
    void rotatedSearch3Yes2_2() {
        int[] arr = {4,5,3};
        assertEquals(1, new YK_RotatedArray().binaryRotatedSearch(arr, 5));
    }

    @Test
    void rotatedSearch3NoHigh_0() {
        int[] arr = {2,3,4};
        assertEquals(-1, new YK_RotatedArray().binaryRotatedSearch(arr, 5));
    }

    @Test
    void rotatedSearch3NoHigh_1() {
        int[] arr = {4,2,3};
        assertEquals(-1, new YK_RotatedArray().binaryRotatedSearch(arr, 5));
    }

    @Test
    void rotatedSearch3NoHigh_2() {
        int[] arr = {3,4,2};
        assertEquals(-1, new YK_RotatedArray().binaryRotatedSearch(arr, 5));
    }

    @Test
    void rotatedSearch3NoLow_0() {
        int[] arr = {6,7,8};
        assertEquals(-1, new YK_RotatedArray().binaryRotatedSearch(arr, 5));
    }

    @Test
    void rotatedSearch3NoLow_1() {
        int[] arr = {8,6,7};
        assertEquals(-1, new YK_RotatedArray().binaryRotatedSearch(arr, 5));
    }

    @Test
    void rotatedSearch3NoLow_2() {
        int[] arr = {7,8,6};
        assertEquals(-1, new YK_RotatedArray().binaryRotatedSearch(arr, 5));
    }

    @Test
    void rotatedSearch3NoMiddle_0() {
        int[] arr = {3,4,6};
        assertEquals(-1, new YK_RotatedArray().binaryRotatedSearch(arr, 5));
    }

    @Test
    void rotatedSearch3NoMiddle_1() {
        int[] arr = {6,3,4};
        assertEquals(-1, new YK_RotatedArray().binaryRotatedSearch(arr, 5));
    }

    @Test
    void rotatedSearch3NoMiddle_2() {
        int[] arr = {4,6,3};
        assertEquals(-1, new YK_RotatedArray().binaryRotatedSearch(arr, 5));
    }


    @Test
    void rotatedSearch4Yes0_0() {
        int[] arr = {5,6,7,8};
        assertEquals(0, new YK_RotatedArray().binaryRotatedSearch(arr, 5));
    }

    @Test
    void rotatedSearch4Yes0_1() {
        int[] arr = {8,5,6,7};
        assertEquals(1, new YK_RotatedArray().binaryRotatedSearch(arr, 5));
    }

    @Test
    void rotatedSearch4Yes0_2() {
        int[] arr = {7,8,5,6};
        assertEquals(2, new YK_RotatedArray().binaryRotatedSearch(arr, 5));
    }

    @Test
    void rotatedSearch4Yes0_3() {
        int[] arr = {6,7,8,5};
        assertEquals(3, new YK_RotatedArray().binaryRotatedSearch(arr, 5));
    }


    @Test
    void rotatedSearch4Yes1_0() {
        int[] arr = {4,5,6,7};
        assertEquals(1, new YK_RotatedArray().binaryRotatedSearch(arr, 5));
    }

    @Test
    void rotatedSearch4Yes1_1() {
        int[] arr = {7,4,5,6};
        assertEquals(2, new YK_RotatedArray().binaryRotatedSearch(arr, 5));
    }

    @Test
    void rotatedSearch4Yes1_2() {
        int[] arr = {6,7,4,5};
        assertEquals(3, new YK_RotatedArray().binaryRotatedSearch(arr, 5));
    }

    @Test
    void rotatedSearch4Yes1_3() {
        int[] arr = {5,6,7,4};
        assertEquals(0, new YK_RotatedArray().binaryRotatedSearch(arr, 5));
    }

    @Test
    void rotatedSearch4Yes2_0() {
        int[] arr = {3,4,5,6};
        assertEquals(2, new YK_RotatedArray().binaryRotatedSearch(arr, 5));
    }

    @Test
    void rotatedSearch4Yes2_1() {
        int[] arr = {6,3,4,5};
        assertEquals(3, new YK_RotatedArray().binaryRotatedSearch(arr, 5));
    }

    @Test
    void rotatedSearch4Yes2_2() {
        int[] arr = {5,6,3,4};
        assertEquals(0, new YK_RotatedArray().binaryRotatedSearch(arr, 5));
    }

    @Test
    void rotatedSearch4Yes2_3() {
        int[] arr = {4,5,6,3};
        assertEquals(1, new YK_RotatedArray().binaryRotatedSearch(arr, 5));
    }

    @Test
    void rotatedSearch4Yes3_0() {
        int[] arr = {2,3,4,5};
        assertEquals(3, new YK_RotatedArray().binaryRotatedSearch(arr, 5));
    }

    @Test
    void rotatedSearch4Yes3_1() {
        int[] arr = {5,2,3,4};
        assertEquals(0, new YK_RotatedArray().binaryRotatedSearch(arr, 5));
    }

    @Test
    void rotatedSearch4Yes3_2() {
        int[] arr = {4,5,2,3};
        assertEquals(1, new YK_RotatedArray().binaryRotatedSearch(arr, 5));
    }

    @Test
    void rotatedSearch4Yes3_3() {
        int[] arr = {3,4,5,2};
        assertEquals(2, new YK_RotatedArray().binaryRotatedSearch(arr, 5));
    }

    @Test
    void rotatedSearch4NoHigh_0() {
        int[] arr = {1,2,3,4};
        assertEquals(-1, new YK_RotatedArray().binaryRotatedSearch(arr, 5));
    }

    @Test
    void rotatedSearch4NoHigh_1() {
        int[] arr = {4,1,2,3};
        assertEquals(-1, new YK_RotatedArray().binaryRotatedSearch(arr, 5));
    }

    @Test
    void rotatedSearch4NoHigh_2() {
        int[] arr = {3,4,1,2};
        assertEquals(-1, new YK_RotatedArray().binaryRotatedSearch(arr, 5));
    }

    @Test
    void rotatedSearch4NoHigh_3() {
        int[] arr = {2,3,4,1};
        assertEquals(-1, new YK_RotatedArray().binaryRotatedSearch(arr, 5));
    }

    @Test
    void rotatedSearch4NoLow_0() {
        int[] arr = {6,7,8,9};
        assertEquals(-1, new YK_RotatedArray().binaryRotatedSearch(arr, 5));
    }

    @Test
    void rotatedSearch4NoLow_1() {
        int[] arr = {9,6,7,8};
        assertEquals(-1, new YK_RotatedArray().binaryRotatedSearch(arr, 5));
    }

    @Test
    void rotatedSearch4NoLow_2() {
        int[] arr = {8,9,6,7};
        assertEquals(-1, new YK_RotatedArray().binaryRotatedSearch(arr, 5));
    }

    @Test
    void rotatedSearch4NoLow_3() {
        int[] arr = {7,8,9,6};
        assertEquals(-1, new YK_RotatedArray().binaryRotatedSearch(arr, 5));
    }

    @Test
    void rotatedSearch4NoMiddle_0() {
        int[] arr = {3,4,6,7};
        assertEquals(-1, new YK_RotatedArray().binaryRotatedSearch(arr, 5));
    }

    @Test
    void rotatedSearch4NoMiddle_1() {
        int[] arr = {7,3,4,6};
        assertEquals(-1, new YK_RotatedArray().binaryRotatedSearch(arr, 5));
    }

    @Test
    void rotatedSearch4NoMiddle_2() {
        int[] arr = {6,7,3,4};
        assertEquals(-1, new YK_RotatedArray().binaryRotatedSearch(arr, 5));
    }

    @Test
    void rotatedSearch4NoMiddle_3() {
        int[] arr = {4,6,7,3};
        assertEquals(-1, new YK_RotatedArray().binaryRotatedSearch(arr, 5));
    }
}