package YK_Cracking8_RecDynamicMem_TESTS;

import YK_Cracking8_RecDynamicMem.YK_Parentheses;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class YK_ParenthesesTest {

    @Test
    void parens1() {

        ArrayList<String> exp = new ArrayList<>();
        exp.add("()");

        assertEquals(exp, new YK_Parentheses().parenthesisVariations(1));
    }

    @Test
    void parens2() {
        ArrayList<String> exp = new ArrayList<>();
        exp.add("(())");
        exp.add("()()");

        assertEquals(exp, new YK_Parentheses().parenthesisVariations(2));
    }

    @Test
    void parens3() {
        ArrayList<String> exp = new ArrayList<>();

        exp.add("((()))");
        exp.add("(()())");
        exp.add("(())()");

        exp.add("()(())");
        exp.add("()()()");

        assertEquals(exp, new YK_Parentheses().parenthesisVariations(3));
    }

    @Test
    void parensPrintNums() {

        for(int i = 1; i < 12; i++) {
            System.out.println("Number of parentheses variations for num: " + i + ": " +
                    new YK_Parentheses().parenthesisVariations(i).size() +
                    ", n*2^(n*1.1): " + i * Math.pow(2,i*1.1));
        }
    }

}