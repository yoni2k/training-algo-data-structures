package YK_AmazonPrep;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class YK_Sample1_ActiveHousesTest {
    private ArrayList<Integer> arrToList(int[] arr) {

        ArrayList<Integer> list = new ArrayList<>();

        for(int single: arr) {
            list.add(single);
        }

        return list;
    }

    @Test
    void test1() {
        ArrayList<Integer> exp = new ArrayList<>();
        int[] initial = {0,1,1,0,1,1,1,0};
        int[] exp1 = {1,1,1,0,1,0,1,1};
        int[] exp2 = {1,0,1,0,0,0,1,1};
        int[] exp3 = {0,0,0,1,0,1,1,1};
        int[] exp4 = {0,0,1,0,0,1,0,1};

        assertEquals(arrToList(exp1), new YK_Sample1_ActiveHouses().cellCompete(initial, 1));
        assertEquals(arrToList(exp2), new YK_Sample1_ActiveHouses().cellCompete(initial, 2));
        assertEquals(arrToList(exp3), new YK_Sample1_ActiveHouses().cellCompete(initial, 3));
        assertEquals(arrToList(exp4), new YK_Sample1_ActiveHouses().cellCompete(initial, 4));
    }
}