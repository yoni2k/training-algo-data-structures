package YK_Cracking17_Hard;

import org.jetbrains.annotations.TestOnly;

/*
Source: Cracking 17.1
Addition of 2 numbers (positive) without using + or any other arithmentic operators

2 implementation:
1. Mine initial - log n - plusNoArithPositiveBitByBit
2. Book's - best case very quick, but worst case probably can be as bad as O(log n) - plusNoArithPositiveXorAnd
 */

public class YK_Hard1_PlusNoArithm {

    public int plusNoArithPositiveXorAnd(int one, int two) {

        int newOne;
        int newTwo;

        while(two > 0) {
            newOne = (one ^ two);
            newTwo = (one & two) << 1;

            one = newOne;
            two = newTwo;
        }

        return one;
    }

    private int privatePlusRecur(int one, int two, int carry) {

        if ((one | two | carry)	== 0) {
            return 0;
        }

        int lastBitOne = one & 1;
        int lastBitTwo = two & 1;
        int newCarry;
        int ansBit;

        if ((lastBitOne & lastBitTwo & carry) == 1) {  //all 3 ones
            newCarry = 1;
            ansBit = 1;
        } else if ((lastBitOne | lastBitTwo | carry) == 0) { //all 3 zeros
            newCarry = 0;
            ansBit = 0;
        } else if (((lastBitOne & lastBitTwo) | (lastBitTwo & carry) | (lastBitOne & carry)) == 1)  {  //2 ones, 1 zero
            newCarry = 1;
            ansBit = 0;
        } else { //1 one, 2 zeros
            newCarry = 0;
            ansBit = 1;
        }
        return ((privatePlusRecur(one >> 1, two >> 1, newCarry) << 1) | ansBit);

    }

    public int plusNoArithPositiveBitByBit(int one, int two) {
            return privatePlusRecur(one, two, 0);
    }
}
