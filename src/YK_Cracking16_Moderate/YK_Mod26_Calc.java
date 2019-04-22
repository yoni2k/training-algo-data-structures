package YK_Cracking16_Moderate;

import java.util.Arrays;

/*
Source: Cracking 16.26
Given a String of numbers and *-/+ signs without brackets, compute the result based on operator preference

Implementation:
    In the book there are very different additional implementations, also O(n) and also not very simple
 */

public class YK_Mod26_Calc {
    class Num {
        double value;
        Sign next = null;

        Num(double value) {
            this.value = value;
        }
    }

    class Sign {
        char sign;
        Num next = null;

        Sign(char sign) {
            this.sign = sign;
        }
    }

    private void priorityPass(Num firstNum) {
        Num prevNum = firstNum;
        Sign sign = firstNum.next;
        Num nextNum;
        while(sign != null) {
            nextNum = sign.next;

            if((sign.sign == '*') || (sign.sign == '/')) {
                if(sign.sign == '*') {
                    prevNum.value *= nextNum.value;
                } else {
                    prevNum.value /= nextNum.value;
                }
                prevNum.next = nextNum.next;
            } else {
                prevNum = nextNum;
            }
            if(prevNum != null) {
                sign = prevNum.next;
            } else {
                sign = null;
            }
        }
    }

    private double nonPriorityPass(Num firstNum) {
        Sign sign = firstNum.next;
        Num nextNum;

        double res = firstNum.value;
        while(sign != null) {
            nextNum = sign.next;

            if(sign.sign == '+') {
                res += nextNum.value;
            } else {
                res -= nextNum.value;
            }

            sign = nextNum.next;
        }

        return res;
    }

    private int[] parseInt(char[] charStr, int index) {
        StringBuilder sb = new StringBuilder();
        while((index < charStr.length) && (Character.isDigit(charStr[index]))) {
            sb.append(charStr[index]);
            index++;
        }
        return new int[] {Integer.parseInt(sb.toString()), index - 1};
    }

    private Num parseStr(String str) {
        Num num = null;
        Sign sign = null;

        Num firstNum = null;
        boolean isNum = true;

        char[] charStr = str.toCharArray();
        int[] pair;

        for(int i = 0 ; i < charStr.length; i++) {
            if(isNum) {
                pair = parseInt(charStr, i);
                num = new Num(pair[0]);
                i = pair[1];
                if(firstNum == null) {
                    firstNum = num;
                } else {
                    sign.next = num;
                }
            } else {
                sign = new Sign(charStr[i]);
                num.next = sign;
            }

            isNum = !isNum;
        }
        return firstNum;
    }

    public double calc(String str) {

        Num firstNum = parseStr(str);

        //Pass for * and /
        priorityPass(firstNum);

        //Pass for + and -
        return nonPriorityPass(firstNum);
    }
}
