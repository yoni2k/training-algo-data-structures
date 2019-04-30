package YK_Cracking17_Hard;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class YK_Hard14_SmallestK_QuickSortPivotTest {

    private int[] getArray(int len) {
        Random rand = new Random();

        int[] arr = new int[len];

        for(int i = 0; i < len; i++) {
            arr[i] = rand.nextInt(200);
        }

        return arr;
    }

    @Test
    void quickSortTest() {

        for(int len = 1; len < 20; len++) {
            for(int times = 0; times < 100; times++) {
                int[] arrOrg = getArray(len);
                System.out.println("Len: " + len + ", times: " + times + ", original array: " + Arrays.toString(arrOrg));
                int[] toSortArrays = Arrays.copyOf(arrOrg, arrOrg.length);
                int[] toSortMine = Arrays.copyOf(arrOrg, arrOrg.length);

                Arrays.sort(toSortArrays);
                new YK_Hard14_SmallestK_QuickSortPivot().quicksort(toSortMine);
                assertArrayEquals(toSortArrays,toSortMine);
            }
        }
    }

    @Test
    void quickGetFirstK() {

        for(int len = 1; len < 20; len++) {
            for(int times = 0; times < 100; times++) {
                for(int k = 1; k <= len; k++) {
                    int[] arrOrg = getArray(len);
                    //System.out.println("Len: " + len + ", times: " + times + ",k: " + k + ", original array: " + Arrays.toString(arrOrg));
                    int[] toSortArrays = Arrays.copyOf(arrOrg, arrOrg.length);
                    int[] toSortMine = Arrays.copyOf(arrOrg, arrOrg.length);

                    Arrays.sort(toSortArrays);
                    int[] firstk = new YK_Hard14_SmallestK_QuickSortPivot().getKSmallest(toSortMine, k);
                    Arrays.sort(firstk);
                    assertArrayEquals(Arrays.copyOfRange(toSortArrays, 0, k), firstk);
                }
            }
        }
    }

    /*
    @Test
    void getFirstKNotWorking() {
        //int[] arrOrg = {44, 134, 138, 83};
        int[] arrOrg = {1, 3, 4, 2};
        System.out.println("Original array: " + Arrays.toString(arrOrg));
        int[] toSortArrays = Arrays.copyOf(arrOrg, arrOrg.length);
        int[] toSortMine = Arrays.copyOf(arrOrg, arrOrg.length);

        Arrays.sort(toSortArrays);
        int[] firstk = new YK_Hard14_SmallestK_QuickSortPivot().getKSmallest(toSortMine, 3);
        Arrays.sort(firstk);
        assertArrayEquals(Arrays.copyOfRange(toSortArrays, 0, 3), firstk);
    }*/
}