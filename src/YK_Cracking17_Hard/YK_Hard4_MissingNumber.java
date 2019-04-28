package YK_Cracking17_Hard;

/*
Source: Cracking 17.4
An array of size n has numbers 0..n besides one number missing.
Find the missing number under limitation:
can't read the number, need to read bit by bit

Book has an implementation that's better in most cases, in worst case same O(n log n) as here.
 */

public class YK_Hard4_MissingNumber {

    public int getNumExp(int bitNum, int maxNum) {

        int numOnes = 0;
        int shiftedOne = (1 << bitNum);

        for(int i = 0; i <= maxNum; i++) {
            if((i & shiftedOne) != 0) {
                numOnes++;
            }
        }

        return numOnes;
    }

    public int getNumAct(int[] arr, int bitNum) {
        int numOnes = 0;
        int shiftedOne = (1 << bitNum);

        for(int i : arr) {
            if((i & shiftedOne) != 0) {
                numOnes++;
            }
        }

        return numOnes;
    }


    public int getMissing(int[] arr) {

        int missing = 0;
        int bit;

        for(int bitNum = 0; (1 << bitNum) <= arr.length; bitNum++) {
            if( getNumExp(bitNum, arr.length) != getNumAct(arr, bitNum) ) {
                bit = 1;
            } else {
                bit = 0;
            }
            missing |= (bit << bitNum);
        }

        return missing;
    }
}
