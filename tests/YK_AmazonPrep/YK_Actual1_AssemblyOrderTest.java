package YK_AmazonPrep;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class YK_Actual1_AssemblyOrderTest {

    private ArrayList<Integer> arrToList(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();

        for(int i : arr) {
            list.add(i);
        }

        return list;
    }

    @Test
    void test1() {
        int[] arr1 = {1,2,3};

        assertEquals(9, new YK_Actual1_AssemblyOrder().minimumTime(arrToList(arr1)));

        int[] arr1_opp = {3,2,1};

        assertEquals(9, new YK_Actual1_AssemblyOrder().minimumTime(arrToList(arr1_opp)));

        int[] arr2 = {8,4,6,12};

        assertEquals(58, new YK_Actual1_AssemblyOrder().minimumTime(arrToList(arr2)));

        int[] arr2_opp = {8,12,6,4};

        assertEquals(58, new YK_Actual1_AssemblyOrder().minimumTime(arrToList(arr2_opp)));

        int[] arr3 = {2,3};

        assertEquals(5, new YK_Actual1_AssemblyOrder().minimumTime(arrToList(arr3)));

        int[] arr3_opp = {3, 2};

        assertEquals(5, new YK_Actual1_AssemblyOrder().minimumTime(arrToList(arr3_opp)));

        int[] arr4 = {2,2,2};

        assertEquals(10, new YK_Actual1_AssemblyOrder().minimumTime(arrToList(arr4)));

        int[] arr5 = {1,1,1};

        assertEquals(5, new YK_Actual1_AssemblyOrder().minimumTime(arrToList(arr5)));

        int[] arr6 = {8,4,6,9};

        assertEquals(54, new YK_Actual1_AssemblyOrder().minimumTime(arrToList(arr6)));
    }
}