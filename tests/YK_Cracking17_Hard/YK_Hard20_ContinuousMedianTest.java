package YK_Cracking17_Hard;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class YK_Hard20_ContinuousMedianTest {

    private double getMedian(int[] arr, int endInd) {
        int[] arrToOrder = Arrays.copyOfRange(arr, 0, endInd + 1);

        Arrays.sort(arrToOrder);

        if((arrToOrder.length % 2) == 1) {
            return arrToOrder[arrToOrder.length / 2];
        } else {
            int mid = arrToOrder.length / 2;
            return (arrToOrder[mid] + arrToOrder[mid-1] ) / 2.0;
        }
    }

    @Test
    void test() {
        int[] arr;
        Random rand = new Random();
        YK_Hard20_ContinuousMedian medClass;

        for(int i = 0; i < 100; i++) {
            arr = new int[100];
            for(int j = 0; j < 100; j++) {
                arr[j] = rand.nextInt(100);
            }
            System.out.println("Testing main loop: " + i + ", arr: " + Arrays.toString(arr));
            medClass = new YK_Hard20_ContinuousMedian();

            for(int j = 0; j < 100; j++) {
                medClass.addNum(arr[j]);
                assertEquals(getMedian(arr,j), medClass.getMedian());
            }
        }
    }

}