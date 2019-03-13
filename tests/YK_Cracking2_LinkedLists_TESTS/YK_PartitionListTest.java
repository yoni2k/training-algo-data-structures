package YK_Cracking2_LinkedLists_TESTS;

import YK_Common.YK_NodeSingle;
import YK_Cracking2_LinkedLists.YK_PartitionList;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class YK_PartitionListTest {

    @Test
    void classTest() {
        new YK_PartitionList();
    }

    private static Object[] partitionNotRec(Integer[] arr, Integer x) {
        YK_NodeSingle<Integer> listAfter = YK_PartitionList.partitionNotRecursion(new YK_NodeSingle<>(arr), x);
        return listAfter.toArray();
    }

    @Test
    void shortListsNotRec() {

        final Integer[] arr1 = {2};
        final Integer[] arr2Same = {2,2};
        final Integer[] arr2Diff = {3,2};
        final Integer[] arr2Ordered = {2,3};

        assertTrue(Arrays.deepEquals(arr1, partitionNotRec(arr1, 2)));
        assertTrue(Arrays.deepEquals(arr1, partitionNotRec(arr1, 1)));
        assertTrue(Arrays.deepEquals(arr1, partitionNotRec(arr1, 3)));

        assertTrue(Arrays.deepEquals(arr2Same, partitionNotRec(arr2Same, 2)));
        assertTrue(Arrays.deepEquals(arr2Same, partitionNotRec(arr2Same, 1)));
        assertTrue(Arrays.deepEquals(arr2Same, partitionNotRec(arr2Same, 3)));

        assertTrue(Arrays.deepEquals(arr2Ordered, partitionNotRec(arr2Diff, 2)));
        assertTrue(Arrays.deepEquals(arr2Ordered, partitionNotRec(arr2Diff, 1)));
        assertTrue(Arrays.deepEquals(arr2Ordered, partitionNotRec(arr2Diff, 3)));
        assertTrue(Arrays.deepEquals(arr2Ordered, partitionNotRec(arr2Diff, 4)));
    }

    @Test
    void xcomplicatedListNotRec() {
        final Integer[] arrDiff = {2,7,3,9,4,2};

        final Integer[] arrDiff_OppOrder = {2,4,9,3,7,2};

        final Integer[] arrDiff_3 = {2,2,4,9,3,7};
        final Integer[] arrDiff_4 = {2,3,2,4,9,7};
        final Integer[] arrDiff_567 = {2,4,3,2,9,7};
        final Integer[] arrDiff_89 = {2,4,3,7,2,9};

        assertTrue(Arrays.deepEquals(arrDiff_OppOrder, partitionNotRec(arrDiff, 1)));
        assertTrue(Arrays.deepEquals(arrDiff_OppOrder, partitionNotRec(arrDiff, 2)));
        assertTrue(Arrays.deepEquals(arrDiff_3, partitionNotRec(arrDiff, 3)));
        assertTrue(Arrays.deepEquals(arrDiff_4, partitionNotRec(arrDiff, 4)));
        assertTrue(Arrays.deepEquals(arrDiff_567, partitionNotRec(arrDiff, 5)));
        assertTrue(Arrays.deepEquals(arrDiff_567, partitionNotRec(arrDiff, 6)));
        assertTrue(Arrays.deepEquals(arrDiff_567, partitionNotRec(arrDiff, 7)));
        assertTrue(Arrays.deepEquals(arrDiff_89, partitionNotRec(arrDiff, 8)));
        assertTrue(Arrays.deepEquals(arrDiff_89, partitionNotRec(arrDiff, 9)));
        assertTrue(Arrays.deepEquals(arrDiff_OppOrder, partitionNotRec(arrDiff, 10)));
    }

    private static Object[] partitionRec(Integer[] arr, Integer x) {
        YK_NodeSingle<Integer> listAfter = YK_PartitionList.partitionRecursion(new YK_NodeSingle<>(arr), x);
        return listAfter.toArray();
    }

    @Test
    void shortListsRec() {

        final Integer[] arr1 = {2};
        final Integer[] arr2Same = {2,2};
        final Integer[] arr2Diff = {3,2};
        final Integer[] arr2Ordered = {2,3};

        assertTrue(Arrays.deepEquals(arr1, partitionRec(arr1, 2)));
        assertTrue(Arrays.deepEquals(arr1, partitionRec(arr1, 1)));
        assertTrue(Arrays.deepEquals(arr1, partitionRec(arr1, 3)));

        assertTrue(Arrays.deepEquals(arr2Same, partitionRec(arr2Same, 2)));
        assertTrue(Arrays.deepEquals(arr2Same, partitionRec(arr2Same, 1)));
        assertTrue(Arrays.deepEquals(arr2Same, partitionRec(arr2Same, 3)));

        assertTrue(Arrays.deepEquals(arr2Diff, partitionRec(arr2Diff, 2)));
        assertTrue(Arrays.deepEquals(arr2Diff, partitionRec(arr2Diff, 1)));
        assertTrue(Arrays.deepEquals(arr2Ordered, partitionRec(arr2Diff, 3)));
        assertTrue(Arrays.deepEquals(arr2Diff, partitionRec(arr2Diff, 4)));
    }

    @Test
    void xcomplicatedListRec() {
        final Integer[] arrDiff = {2,7,3,9,4,2};

        final Integer[] arrDiff_3 = {2,2,7,3,9,4};
        final Integer[] arrDiff_4 = {2,3,2,7,9,4};
        final Integer[] arrDiff_567 = {2,3,4,2,7,9};
        final Integer[] arrDiff_8 = {2,7,3,4,2,9};
        final Integer[] arrDiff_9 = {2,7,3,4,2,9};

        assertTrue(Arrays.deepEquals(arrDiff, partitionRec(arrDiff, 1)));
        assertTrue(Arrays.deepEquals(arrDiff, partitionRec(arrDiff, 2)));
        assertTrue(Arrays.deepEquals(arrDiff_3, partitionRec(arrDiff, 3)));
        assertTrue(Arrays.deepEquals(arrDiff_4, partitionRec(arrDiff, 4)));
        assertTrue(Arrays.deepEquals(arrDiff_567, partitionRec(arrDiff, 5)));
        assertTrue(Arrays.deepEquals(arrDiff_567, partitionRec(arrDiff, 6)));
        assertTrue(Arrays.deepEquals(arrDiff_567, partitionRec(arrDiff, 7)));
        assertTrue(Arrays.deepEquals(arrDiff_8, partitionRec(arrDiff, 8)));
        assertTrue(Arrays.deepEquals(arrDiff_9, partitionRec(arrDiff, 9)));
        assertTrue(Arrays.deepEquals(arrDiff, partitionRec(arrDiff, 10)));
    }

    /*
    @Test
    void shortLists() {

        final Integer[] arr1 = {2};
        final Integer[] arr2Same = {2,2};
        final Integer[] arr2Diff = {3,2};
        final Integer[] arr2Ordered = {2,3};

        assertTrue(Arrays.deepEquals(arr1, partition(arr1, 2)));
        assertTrue(Arrays.deepEquals(arr1, partition(arr1, 1)));
        assertTrue(Arrays.deepEquals(arr1, partition(arr1, 3)));

        assertTrue(Arrays.deepEquals(arr2Same, partition(arr2Same, 2)));
        assertTrue(Arrays.deepEquals(arr2Same, partition(arr2Same, 1)));
        assertTrue(Arrays.deepEquals(arr2Same, partition(arr2Same, 3)));

        assertTrue(Arrays.deepEquals(arr2Diff, partition(arr2Diff, 2)));
        assertTrue(Arrays.deepEquals(arr2Diff, partition(arr2Diff, 1)));
        assertTrue(Arrays.deepEquals(arr2Ordered, partition(arr2Diff, 3)));
        assertTrue(Arrays.deepEquals(arr2Diff, partition(arr2Diff, 4)));
    }

    @Test
    void xcomplicatedList() {
        final Integer[] arrDiff = {2,7,3,9,4,2};
        final Integer[] arrDiff_3 = {2,2,7,3,9,4};
        final Integer[] arrDiff_4 = {2,3,2,7,9,4};
        final Integer[] arrDiff_567 = {2,3,4,2,7,9};
        final Integer[] arrDiff_89 = {2,7,3,4,2,9};

        assertTrue(Arrays.deepEquals(arrDiff, partition(arrDiff, 1)));
        assertTrue(Arrays.deepEquals(arrDiff, partition(arrDiff, 2)));
        assertTrue(Arrays.deepEquals(arrDiff_3, partition(arrDiff, 3)));
        assertTrue(Arrays.deepEquals(arrDiff_4, partition(arrDiff, 4)));
        assertTrue(Arrays.deepEquals(arrDiff_567, partition(arrDiff, 5)));
        assertTrue(Arrays.deepEquals(arrDiff_567, partition(arrDiff, 6)));
        assertTrue(Arrays.deepEquals(arrDiff_567, partition(arrDiff, 7)));
        assertTrue(Arrays.deepEquals(arrDiff_89, partition(arrDiff, 8)));
        assertTrue(Arrays.deepEquals(arrDiff_89, partition(arrDiff, 9)));
        assertTrue(Arrays.deepEquals(arrDiff, partition(arrDiff, 10)));
    }
    */
}