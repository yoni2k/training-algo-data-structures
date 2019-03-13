package YK_Cracking2_LinkedLists_TESTS;

import YK_Common.YK_NodeSingle;
import YK_Cracking2_LinkedLists.YK_FindKth;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class YK_FindKthTest {

    private Integer[] arr1 = {1};
    private Integer[] arr2 = {1,2};
    private Integer[] arr3 = {1,2,3};

    @Test
    void classTest() {
        new YK_FindKth();
    }

    private Integer findSimple(Integer[] arr, int kFromEnd) {
        return YK_FindKth.findKthSimple(new YK_NodeSingle<>(arr), kFromEnd);
    }

    @Test
    void simple() {
        assertEquals(1, findSimple(arr1,0));
        assertNull(findSimple(arr1, 1));
        assertNull(findSimple(arr1, 2));

        assertEquals(2, findSimple(arr2, 0));
        assertEquals(1, findSimple(arr2, 1));
        assertNull(findSimple(arr2, 2));
        assertNull(findSimple(arr2, 3));

        assertEquals(3, findSimple(arr3, 0));
        assertEquals(2, findSimple(arr3, 1));
        assertEquals(1, findSimple(arr3, 2));
        assertNull(findSimple(arr3, 3));
        assertNull(findSimple(arr3, 4));
    }

    private Integer findRecursive(Integer[] arr, int kFromEnd) {
        return YK_FindKth.findKthRecursive(new YK_NodeSingle<>(arr), kFromEnd);
    }

    @Test
    void recursive() {
        assertEquals(1, findRecursive(arr1,0));
        assertNull(findRecursive(arr1, 1));
        assertNull(findRecursive(arr1, 2));

        assertEquals(2, findRecursive(arr2, 0));
        assertEquals(1, findRecursive(arr2, 1));
        assertNull(findRecursive(arr2, 2));
        assertNull(findRecursive(arr2, 3));

        assertEquals(3, findRecursive(arr3, 0));
        assertEquals(2, findRecursive(arr3, 1));
        assertEquals(1, findRecursive(arr3, 2));
        assertNull(findRecursive(arr3, 3));
        assertNull(findRecursive(arr3, 4));
    }
}