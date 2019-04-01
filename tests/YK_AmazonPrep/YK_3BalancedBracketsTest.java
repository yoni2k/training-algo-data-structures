package YK_AmazonPrep;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class YK_3BalancedBracketsTest {

    @Test
    void balancedBrackets() {
        //empty
        assertTrue(YK_3BalancedBrackets.isBalanced(""));

        //one pair
        assertTrue(YK_3BalancedBrackets.isBalanced("{}"));
        assertTrue(YK_3BalancedBrackets.isBalanced("[]"));
        assertTrue(YK_3BalancedBrackets.isBalanced("()"));

        //two pairs - one after another
        assertTrue(YK_3BalancedBrackets.isBalanced("{}{}"));
        assertTrue(YK_3BalancedBrackets.isBalanced("[][]"));
        assertTrue(YK_3BalancedBrackets.isBalanced("()()"));
        assertTrue(YK_3BalancedBrackets.isBalanced("{}[]"));
        assertTrue(YK_3BalancedBrackets.isBalanced("[]()"));
        assertTrue(YK_3BalancedBrackets.isBalanced("(){}"));

        //two pairs - one inside another
        assertTrue(YK_3BalancedBrackets.isBalanced("{{}}"));
        assertTrue(YK_3BalancedBrackets.isBalanced("[[]]"));
        assertTrue(YK_3BalancedBrackets.isBalanced("(())"));
        assertTrue(YK_3BalancedBrackets.isBalanced("{[]}"));
        assertTrue(YK_3BalancedBrackets.isBalanced("[()]"));
        assertTrue(YK_3BalancedBrackets.isBalanced("({})"));

        //complex
        assertTrue(YK_3BalancedBrackets.isBalanced("({{}()[()]})"));
    }

    @Test
    void notBalancedBrackets() {
        //only 1
        assertFalse(YK_3BalancedBrackets.isBalanced("{"));
        assertFalse(YK_3BalancedBrackets.isBalanced("["));
        assertFalse(YK_3BalancedBrackets.isBalanced("("));
        assertFalse(YK_3BalancedBrackets.isBalanced("}"));
        assertFalse(YK_3BalancedBrackets.isBalanced("]"));
        assertFalse(YK_3BalancedBrackets.isBalanced(")"));

        //one unmatching pair
        assertFalse(YK_3BalancedBrackets.isBalanced("{]"));
        assertFalse(YK_3BalancedBrackets.isBalanced("[)"));
        assertFalse(YK_3BalancedBrackets.isBalanced("(}"));

        //two pairs - one after another
        assertFalse(YK_3BalancedBrackets.isBalanced("{][}"));
        assertFalse(YK_3BalancedBrackets.isBalanced("[](]"));
        assertFalse(YK_3BalancedBrackets.isBalanced("(]()"));
        assertFalse(YK_3BalancedBrackets.isBalanced("[}{]"));

        //two pairs - one inside another
        assertFalse(YK_3BalancedBrackets.isBalanced("{[}]"));

        //complex - proper ({{}()[()]}), missing one of them
        assertFalse(YK_3BalancedBrackets.isBalanced("{{}()[()]})"));
        assertFalse(YK_3BalancedBrackets.isBalanced("({}()[()]})"));
        assertFalse(YK_3BalancedBrackets.isBalanced("({}()[()]})"));
        assertFalse(YK_3BalancedBrackets.isBalanced("({{()[()]})"));
        assertFalse(YK_3BalancedBrackets.isBalanced("({{})[()]})"));
        assertFalse(YK_3BalancedBrackets.isBalanced("({{}([()]})"));
        assertFalse(YK_3BalancedBrackets.isBalanced("({{}()()]})"));
        assertFalse(YK_3BalancedBrackets.isBalanced("({{}()[)]})"));
        assertFalse(YK_3BalancedBrackets.isBalanced("({{}()[(]})"));
        assertFalse(YK_3BalancedBrackets.isBalanced("({{}()[()})"));
        assertFalse(YK_3BalancedBrackets.isBalanced("({{}()[()])"));
        assertFalse(YK_3BalancedBrackets.isBalanced("({{}()[()]}"));

        //complex - proper ({{}()[()]}), one wrong
        assertFalse(YK_3BalancedBrackets.isBalanced("[{{}()[()]})"));
        assertFalse(YK_3BalancedBrackets.isBalanced("(({}()[()]})"));
        assertFalse(YK_3BalancedBrackets.isBalanced("({[}()[()]})"));
        assertFalse(YK_3BalancedBrackets.isBalanced("({{]()[()]})"));
        assertFalse(YK_3BalancedBrackets.isBalanced("({{}[)[()]})"));
        assertFalse(YK_3BalancedBrackets.isBalanced("({{}(}[()]})"));
        assertFalse(YK_3BalancedBrackets.isBalanced("({{}()(()]})"));
        assertFalse(YK_3BalancedBrackets.isBalanced("({{}()[{)]})"));
        assertFalse(YK_3BalancedBrackets.isBalanced("({{}()[(]]})"));
        assertFalse(YK_3BalancedBrackets.isBalanced("({{}()[()}})"));
        assertFalse(YK_3BalancedBrackets.isBalanced("({{}()[()]))"));
        assertFalse(YK_3BalancedBrackets.isBalanced("({{}()[()]}]"));

        //complex - proper ({{}()[()]}), one wrong direction
        assertFalse(YK_3BalancedBrackets.isBalanced("]{{}()[()]})"));
        assertFalse(YK_3BalancedBrackets.isBalanced("(}{}()[()]})"));
        assertFalse(YK_3BalancedBrackets.isBalanced("({}}()[()]})"));
        assertFalse(YK_3BalancedBrackets.isBalanced("({{{()[()]})"));
        assertFalse(YK_3BalancedBrackets.isBalanced("({{}))[()]})"));
        assertFalse(YK_3BalancedBrackets.isBalanced("({{}(([()]})"));
        assertFalse(YK_3BalancedBrackets.isBalanced("({{}()]()]})"));
        assertFalse(YK_3BalancedBrackets.isBalanced("({{}()[))]})"));
        assertFalse(YK_3BalancedBrackets.isBalanced("({{}()[((]})"));
        assertFalse(YK_3BalancedBrackets.isBalanced("({{}()[()[})"));
        assertFalse(YK_3BalancedBrackets.isBalanced("({{}()[()]{)"));
        assertFalse(YK_3BalancedBrackets.isBalanced("({{}()[()]}("));
    }

}