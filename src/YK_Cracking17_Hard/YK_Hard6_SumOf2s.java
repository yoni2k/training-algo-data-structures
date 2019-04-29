package YK_Cracking17_Hard;

/*
Source: Cracking 17.6
Given a number n, count the number of "2"s in all numbers from 0 to n.

Implementation: the book follows a slightly different but similar logic. Same O(log n).
 */

public class YK_Hard6_SumOf2s {
    private int count2s(int num, int power) {
        int tenPower = (int)Math.pow(10, power);
        int tenPowerPlusOne = tenPower * 10;

        int num2s = (num / tenPowerPlusOne) * tenPower;
        int add = (num % tenPowerPlusOne - 2 * tenPower + 1);

        if(add < 0) {
            add = 0;
        } else if (add > tenPower) {
            add = tenPower;
        }
        num2s += add;

        return num2s;
    }

    public int count2s(int num) {
        int num2s = 0;
        int power = 0;

        while(Math.pow(10,power) <= num) {
            num2s += count2s(num, power);
            power++;
        }

        return num2s;
    }
}
