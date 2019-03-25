package YK_Cracking10_SortSearch;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class YK_FindDupsLittleMemoryTest {

    private final int LARGE_SIZE = 1000000;

    @Test
    void sameDupLargeSize() {
        int[] arr = new int[LARGE_SIZE];

        Arrays.fill(arr,1);

        HashMap<Integer, Boolean> hash = new HashMap<>();
        hash.put(1,true);

        assertEquals(hash, new YK_FindDupsLittleMemory().getDups(arr));
    }

    @Test
    void allDupsLargeSize() {
        int[] arr = new int[LARGE_SIZE];
        HashMap<Integer, Boolean> hash = new HashMap<>();

        for(int i = 0; i < arr.length; i++) {
            arr[i] = i % 32000;
            hash.put(i % 32000,true);
        }

        assertEquals(hash, new YK_FindDupsLittleMemory().getDups(arr));
    }

    @Test
    void noDups32Size() {
        int[] arr = new int[32000];

        for(int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }

        HashMap<Integer, Boolean> hash = new HashMap<>();

        assertEquals(hash, new YK_FindDupsLittleMemory().getDups(arr));
    }

    @Test
    void someDups32Size() {
        int[] arr = new int[32032];
        HashMap<Integer, Boolean> hash = new HashMap<>();

        int delta = 0;
        for(int i = 0; (i + delta) < arr.length; i++) {
            arr[i + delta] = i;

            if ((i+2 < arr.length) && (i % (delta + 1)) == 0) {
                arr[i + delta] = i;
                arr[i + delta + 1] = i;
                hash.put(i,true);
                delta++;
                i++;
            }
        }

        System.out.println("someDupsLargeSize, dups: " + hash);

        assertEquals(hash, new YK_FindDupsLittleMemory().getDups(arr));
    }

}