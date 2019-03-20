package YK_Cracking8_RecDynamicMem;

import java.util.ArrayList;

/*
Cracking 8.9
Given a number of parentheses pairs, give all variations of the opening and closing.

My implementation below is slightly less efficient than the book - up to 11 gives 75-80 ms for a test of parensPrintNums()
Committing before redoing.
 */

public class YK_Parentheses {

    private void recParVars(int openLeft, int closeLeft, int index, char[] singleStr, ArrayList<String> vars) {

        if ((openLeft == 0) && (closeLeft == 0)) {
            vars.add(new String(singleStr));
            return;
        }

        if (openLeft > 0) {
            singleStr[index] = '(';
            recParVars(openLeft - 1, closeLeft + 1, index + 1, singleStr, vars);
        }

        if (closeLeft > 0) {
            singleStr[index] = ')';
            recParVars(openLeft, closeLeft - 1, index + 1, singleStr, vars);
        }
    }

    public ArrayList<String> parenthesisVariations(int num) {

        ArrayList<String> vars = new ArrayList<>();
        char[] singleString = new char[num*2];

        recParVars(num, 0, 0, singleString, vars);

        return vars;
    }
}
