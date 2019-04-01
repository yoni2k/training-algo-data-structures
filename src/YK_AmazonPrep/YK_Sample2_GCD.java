package YK_AmazonPrep;

import java.util.Arrays;

/*
GCD - Greatest common denominator of an array.

Implementation:
- Order from small to large
- stay on dividor until can't divide all members on same dividor
- stop when smallest member in the array that's left after dividing is smaller than the dividor

Another possible solution: Do pairs of previous GCD with another member of the array.
Pair recursive way:
static int gcd(int a, int b)
    {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }
 */

public class YK_Sample2_GCD {

    public int generalizedGCD(int num, int[] arr) {
        int gcd = 1;
        int divisor = 2;
        int[] arrTmp = new int[num];
        int ind;
        int smallestNum = Integer.MAX_VALUE;

        Arrays.sort(arr);
        System.arraycopy(arr,0,arrTmp,0,arr.length);

        while(smallestNum >= divisor) {
            for(ind = 0; ind < num; ind++) {
                if ((arrTmp[ind] % divisor) != 0) {
                    smallestNum = Math.min(arrTmp[ind], smallestNum);
                    break;
                }
                arrTmp[ind] /= divisor;
                smallestNum = Math.min(arrTmp[ind], smallestNum);
            }
            if (ind == num) { //got to the end of the for loop - all numbers can be divided into it
                gcd *= divisor;//try the same divisor again
                System.arraycopy(arrTmp,0,arr,0,arr.length);
            } else {
                divisor++;
                System.arraycopy(arr,0,arrTmp,0,arr.length);
            }
        }

        return gcd;
    }
}
