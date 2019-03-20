package YK_Cracking8_RecDynamicMem;

import java.util.ArrayList;

/*
Cracking 8.9
Given a number of parentheses pairs, give all variations of the opening and closing.

My implementation below is slightly less efficient than the book - up to 11 gives 75-80 ms for a test of parensPrintNums()
Committing before redoing.
 */

public class YK_Parentheses {

    private void addToAll(char c, ArrayList<StringBuilder> vars) {

        for(StringBuilder sb : vars) {
            sb.append(c);
        }
    }

    private void recParVars(int openLeft, int closeLeft, ArrayList<StringBuilder> vars) {

        ArrayList<StringBuilder> varsCopy = null;

        if((openLeft > 0) && (closeLeft > 0)) {
            varsCopy = new ArrayList<>();
            for (StringBuilder sb : vars) {
                varsCopy.add(new StringBuilder(sb));
            }
        }

        if (openLeft > 0) {
            addToAll('(', vars);
            recParVars(openLeft - 1, closeLeft + 1, vars);
        }
        if (closeLeft > 0) {
            if (varsCopy == null) {
                addToAll(')', vars);
                recParVars(openLeft, closeLeft - 1, vars);
            }
            else {
                addToAll(')', varsCopy);
                recParVars(openLeft, closeLeft - 1, varsCopy);
                vars.addAll(varsCopy);
            }
        }
    }

    public String[] parenthesisVariations(int num) {
        ArrayList<StringBuilder> vars = new ArrayList<>();

        vars.add(new StringBuilder());

        recParVars(num, 0, vars);

        String[] stringVars = new String[vars.size()];

        int i = 0;
        for(StringBuilder sb : vars) {
            stringVars[i] = sb.toString();
            i++;
        }

        return stringVars;
    }
}
