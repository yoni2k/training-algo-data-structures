package YK_Cracking17_Hard;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class YK_Hard4_MissingNumberTest {

    private int[] arrIntegerToInt(Integer[] arrInteger) {
        int[] arr = new int[arrInteger.length];

        for(int i = 0; i < arrInteger.length; i++) {
            arr[i] = arrInteger[i];
        }

        return arr;
    }

    @Test
    void test() {
        ArrayList<Integer> list;

        for(int i = 1; i < 100; i++) { //length of array
            for(int j = 0; j <= i; j++) { //number missing
                list = new ArrayList<>();
                for(int k = 0; k <= i; k++) {
                    if(k == j) {
                        continue;
                    }
                    list.add(k);
                }
                assertEquals(j, new YK_Hard4_MissingNumber().getMissing(arrIntegerToInt(list.toArray(new Integer[0]))));
            }
        }
    }

}