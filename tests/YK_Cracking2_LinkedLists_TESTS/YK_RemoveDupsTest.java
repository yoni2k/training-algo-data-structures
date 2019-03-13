package YK_Cracking2_LinkedLists_TESTS;

import YK_Common.YK_NodeSingle;
import YK_Cracking2_LinkedLists.YK_RemoveDups;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class YK_RemoveDupsTest {

    @Test
    void classTest() {
        new YK_RemoveDups();
    }

    private Object[] initNodesRemoveDupsNoHash(Integer[] arr) {
        YK_NodeSingle<Integer> head = new YK_NodeSingle<>(arr);
        return YK_RemoveDups.removeDupsNoHash(head).toArray();
    }

    @Test
    void removeDupsNoHash() {
        Integer[] arr1 = {1};
        assertTrue(Arrays.deepEquals(arr1, initNodesRemoveDupsNoHash(arr1)));

        Integer[] arr2noDups = {1,2};
        assertTrue(Arrays.deepEquals(arr2noDups, initNodesRemoveDupsNoHash(arr2noDups)));

        Integer[] arr2Dups = {1,1};
        assertTrue(Arrays.deepEquals(arr1, initNodesRemoveDupsNoHash(arr2Dups)));

        Integer[] arrManySameDups_First = {0,1,0,2,0,3,0};
        Integer[] exp_0123 = {0,1,2,3};
        assertTrue(Arrays.deepEquals(exp_0123, initNodesRemoveDupsNoHash(arrManySameDups_First)));

        Integer[] arrManySameDups_NotFirst = {0,1,1,2,1,3,1};
        assertTrue(Arrays.deepEquals(exp_0123, initNodesRemoveDupsNoHash(arrManySameDups_NotFirst)));

        Integer[] arrManySameDups_IncludingLast = {0,1,0,2,0,3,0};
        assertTrue(Arrays.deepEquals(exp_0123, initNodesRemoveDupsNoHash(arrManySameDups_IncludingLast)));

        Integer[] arrManyDiffDups = {0,1,0,0,2,1,0,3,2,1,3};
        assertTrue(Arrays.deepEquals(exp_0123, initNodesRemoveDupsNoHash(arrManyDiffDups)));
    }

    private Object[] initNodesRemoveDupsWithHash(Integer[] arr) {
        YK_NodeSingle<Integer> head = new YK_NodeSingle<>(arr);
        return YK_RemoveDups.removeDupsWithHash(head).toArray();
    }

    @Test
    void removeDupsWithHash() {
        Integer[] arr1 = {1};
        assertTrue(Arrays.deepEquals(arr1, initNodesRemoveDupsWithHash(arr1)));

        Integer[] arr2noDups = {1,2};
        assertTrue(Arrays.deepEquals(arr2noDups, initNodesRemoveDupsWithHash(arr2noDups)));

        Integer[] arr2Dups = {1,1};
        assertTrue(Arrays.deepEquals(arr1, initNodesRemoveDupsWithHash(arr2Dups)));

        Integer[] arrManySameDups_First = {0,1,0,2,0,3,0};
        Integer[] exp_0123 = {0,1,2,3};
        assertTrue(Arrays.deepEquals(exp_0123, initNodesRemoveDupsWithHash(arrManySameDups_First)));

        Integer[] arrManySameDups_NotFirst = {0,1,1,2,1,3,1};
        assertTrue(Arrays.deepEquals(exp_0123, initNodesRemoveDupsWithHash(arrManySameDups_NotFirst)));

        Integer[] arrManySameDups_IncludingLast = {0,1,0,2,0,3,0};
        assertTrue(Arrays.deepEquals(exp_0123, initNodesRemoveDupsWithHash(arrManySameDups_IncludingLast)));

        Integer[] arrManyDiffDups = {0,1,0,0,2,1,0,3,2,1,3};
        assertTrue(Arrays.deepEquals(exp_0123, initNodesRemoveDupsWithHash(arrManyDiffDups)));
    }
}