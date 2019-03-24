package YK_Cracking2_LinkedLists;

import YK_Common.YK_NodeSingle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class YK_SumListsTest {

    private Object[] sumForwardArr(Integer[] arr1, Integer[] arr2) {
        YK_NodeSingle<Integer> list1 = new YK_NodeSingle<>(arr1);
        YK_NodeSingle<Integer> list2 = new YK_NodeSingle<>(arr2);
        YK_NodeSingle<Integer> listRes = new YK_SumLists().sumFront(list1, list2);
        return listRes.toArray();
    }

    @Test
    void sumForward() {
        final Integer[] arr1_s = {1};
        final Integer[] arr1_l = {9};
        final Integer[] arr2_s = {2,1};
        final Integer[] arr2_l = {9,8};
        final Integer[] arr3_s = {3,2,1};
        final Integer[] arr3_l = {9,8,9};

        final Integer[] res_1s_1s = {2};
        final Integer[] res_1s_1l = {1,0};
        final Integer[] res_1s_2s = {2,2};
        final Integer[] res_1s_3l = {9,9,0};
        final Integer[] res_1l_3l = {9,9,8};
        final Integer[] res_3s_3s = {6,4,2};
        final Integer[] res_3l_3l = {1,9,7,8};

        assertArrayEquals(res_1s_1s, sumForwardArr(arr1_s, arr1_s));

        assertArrayEquals(res_1s_1l, sumForwardArr(arr1_s, arr1_l));
        assertArrayEquals(res_1s_1l, sumForwardArr(arr1_l, arr1_s));

        assertArrayEquals(res_1s_2s, sumForwardArr(arr1_s, arr2_s));
        assertArrayEquals(res_1s_2s, sumForwardArr(arr2_s, arr1_s));

        assertArrayEquals(res_1s_3l, sumForwardArr(arr1_s, arr3_l));
        assertArrayEquals(res_1s_3l, sumForwardArr(arr3_l, arr1_s));

        assertArrayEquals(res_1l_3l, sumForwardArr(arr1_l, arr3_l));
        assertArrayEquals(res_1l_3l, sumForwardArr(arr3_l, arr1_l));

        assertArrayEquals(res_3s_3s, sumForwardArr(arr3_s, arr3_s));
        assertArrayEquals(res_3l_3l, sumForwardArr(arr3_l, arr3_l));
    }

    private Object[] sumBackArr(Integer[] arr1, Integer[] arr2) {
        YK_NodeSingle<Integer> list1 = new YK_NodeSingle<>(arr1);
        YK_NodeSingle<Integer> list2 = new YK_NodeSingle<>(arr2);
        YK_NodeSingle<Integer> listRes = new YK_SumLists().sumBack(list1, list2);
        return listRes.toArray();
    }

    @Test
    void sumBack() {
        final Integer[] arr1_s = {1};
        final Integer[] arr1_l = {9};
        final Integer[] arr2_s = {1,2};
        final Integer[] arr2_l = {8,9};
        final Integer[] arr3_s = {1,2,3};
        final Integer[] arr3_l = {9,8,9};

        final Integer[] res_1s_1s = {2};
        final Integer[] res_1s_1l = {0,1};
        final Integer[] res_1s_2s = {2,2};
        final Integer[] res_1s_3l = {0,9,9};
        final Integer[] res_1l_3l = {8,9,9};
        final Integer[] res_3s_3s = {2,4,6};
        final Integer[] res_3l_3l = {8,7,9,1};

        assertArrayEquals(res_1s_1s, sumBackArr(arr1_s, arr1_s));

        assertArrayEquals(res_1s_1l, sumBackArr(arr1_s, arr1_l));
        assertArrayEquals(res_1s_1l, sumBackArr(arr1_l, arr1_s));

        assertArrayEquals(res_1s_2s, sumBackArr(arr1_s, arr2_s));
        assertArrayEquals(res_1s_2s, sumBackArr(arr2_s, arr1_s));

        assertArrayEquals(res_1s_3l, sumBackArr(arr1_s, arr3_l));
        assertArrayEquals(res_1s_3l, sumBackArr(arr3_l, arr1_s));

        assertArrayEquals(res_1l_3l, sumBackArr(arr1_l, arr3_l));
        assertArrayEquals(res_1l_3l, sumBackArr(arr3_l, arr1_l));

        assertArrayEquals(res_3s_3s, sumBackArr(arr3_s, arr3_s));
        assertArrayEquals(res_3l_3l, sumBackArr(arr3_l, arr3_l));
    }

}