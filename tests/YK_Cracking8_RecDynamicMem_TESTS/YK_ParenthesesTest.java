package YK_Cracking8_RecDynamicMem_TESTS;

import YK_Cracking8_RecDynamicMem.YK_Parentheses;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class YK_ParenthesesTest {

    @Test
    void parens1() {

        String[] exp = new String[1];
        exp[0] = "()";

        assertArrayEquals(exp, new YK_Parentheses().parenthesisVariations(1));
    }

    @Test
    void parens2() {

        String[] exp = new String[2];
        exp[0] = "(())";
        exp[1] = "()()";

        assertArrayEquals(exp, new YK_Parentheses().parenthesisVariations(2));
    }

    @Test
    void parens3() {

        String[] exp = new String[5];
        exp[0] = "((()))";
        exp[1] = "(()())";
        exp[2] = "(())()";

        exp[3] = "()(())";
        exp[4] = "()()()";

        assertArrayEquals(exp, new YK_Parentheses().parenthesisVariations(3));
    }

    @Test
    void parensPrintNums() {

        for(int i = 1; i < 12; i++) {
            System.out.println("Number of parentheses variations for num: " + i + ": " +
                    new YK_Parentheses().parenthesisVariations(i).length +
                    ", n*2^(n*1.1): " + i * Math.pow(2,i*1.1));
        }
    }

}