package YK_Cracking10_SortSearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/*
Source: Cracking 10.8

Find duplicates with a hard RAM limitation.

Implementation using a bit vector that's better in the book since doesn't print duplicate twice.

Also implemented a subset of BitSet functionality - see in the book for a more complete implementation.
 */

public class YK_FindDupsLittleMemory {

    private void turnOn(int num, byte[] arr, int numFrom) {
        int numInArray = num - numFrom;

        int byteNum = (numInArray / 8);
        int bitNum = (numInArray % 8);

        arr[byteNum] |= (1 << bitNum);

    }

    private boolean isOn(int num, byte[] arr, int numFrom) {
        int numInArray = num - numFrom;

        int byteNum = (numInArray / 8);
        int bitNum = (numInArray % 8);

        return ((arr[byteNum] & (1 << bitNum)) != 0);
    }

    private void singlePass(int[] arr, byte[] appeared, byte[] dups, int numFrom, int numTill, HashMap<Integer, Boolean> hash) {

        for(int singleInt : arr) {
            if((singleInt < numFrom) || (singleInt > numTill)) continue;

            if(isOn(singleInt, dups, numFrom)) continue;

            if(isOn(singleInt, appeared, numFrom)) {
                turnOn(singleInt, dups, numFrom);
                hash.put(singleInt, true);
            } else {
                turnOn(singleInt, appeared, numFrom);
            }
        }
    }

    public HashMap<Integer, Boolean> getDups(int[] arr) {

        int arraySize = 2*(int)Math.pow(2,10);

        byte[] appeared = new byte[arraySize];
        byte[] dups = new byte[arraySize];

        assert(arraySize < 2100);

        HashMap<Integer, Boolean> hash = new HashMap<>();//not taking into account for memory, since really requested to print

        singlePass(arr, appeared, dups, 0, 16000, hash);

        Arrays.fill(appeared, (byte)0);
        Arrays.fill(dups, (byte)0);
        singlePass(arr, appeared, dups, 16001, 32000, hash);

        return hash;
    }
}
