package YK_Cracking16_Moderate;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class YK_Mod18_PatternMatchTest {

    @Test
    void singleLetterValue() {
        assertTrue(new YK_Mod18_PatternMatch().matchesPattern("a","c"));
        assertTrue(new YK_Mod18_PatternMatch().matchesPattern("b","c"));
        assertFalse(new YK_Mod18_PatternMatch().matchesPattern("ab","c"));
        assertFalse(new YK_Mod18_PatternMatch().matchesPattern("aa","c"));
        assertFalse(new YK_Mod18_PatternMatch().matchesPattern("bb","c"));
    }

    @Test
    void twoLetterValue() {
        assertTrue(new YK_Mod18_PatternMatch().matchesPattern("a","cu"));
        assertTrue(new YK_Mod18_PatternMatch().matchesPattern("b","cu"));
        assertTrue(new YK_Mod18_PatternMatch().matchesPattern("ab","cu"));
        assertTrue(new YK_Mod18_PatternMatch().matchesPattern("ba","cu"));

        assertFalse(new YK_Mod18_PatternMatch().matchesPattern("aba","cu"));
        assertFalse(new YK_Mod18_PatternMatch().matchesPattern("aa","cu"));
        assertFalse(new YK_Mod18_PatternMatch().matchesPattern("bb","cu"));
        assertFalse(new YK_Mod18_PatternMatch().matchesPattern("abb","cu"));
    }

    @Test
    void various() {
        assertTrue(new YK_Mod18_PatternMatch().matchesPattern("aabab","cutcutgocutgo"));
        assertTrue(new YK_Mod18_PatternMatch().matchesPattern("bbaba","cutcutgocutgo"));
        assertTrue(new YK_Mod18_PatternMatch().matchesPattern("abb","cutcutgocutgo"));
        assertTrue(new YK_Mod18_PatternMatch().matchesPattern("bba","cutcutgocutgo"));
        assertTrue(new YK_Mod18_PatternMatch().matchesPattern("ab","cutcutgocutgo"));
        assertTrue(new YK_Mod18_PatternMatch().matchesPattern("ba","cutcutgocutgo"));

        //Extra pattern
        assertFalse(new YK_Mod18_PatternMatch().matchesPattern("aababa","cutcutgocutgo"));
        assertFalse(new YK_Mod18_PatternMatch().matchesPattern("abbaba","cutcutgocutgo"));
        assertFalse(new YK_Mod18_PatternMatch().matchesPattern("abba","cutcutgocutgo"));
        assertFalse(new YK_Mod18_PatternMatch().matchesPattern("bbba","cutcutgocutgo"));
        assertFalse(new YK_Mod18_PatternMatch().matchesPattern("bab","cutcutgocutgo"));
        assertFalse(new YK_Mod18_PatternMatch().matchesPattern("aaa","cutcutgocutgo"));

        //Remove Pattern
        assertFalse(new YK_Mod18_PatternMatch().matchesPattern("abab","cutcutgocutgo"));
        assertFalse(new YK_Mod18_PatternMatch().matchesPattern("bbba","cutcutgocutgo"));
        assertFalse(new YK_Mod18_PatternMatch().matchesPattern("bb","cutcutgocutgo"));


        //Extra value
        assertFalse(new YK_Mod18_PatternMatch().matchesPattern("aabab","cutcutgocutgocut"));
        assertFalse(new YK_Mod18_PatternMatch().matchesPattern("bbaba","cutcutgocutgogo"));
        assertFalse(new YK_Mod18_PatternMatch().matchesPattern("abb","cutcutcutgocutgogogc"));

        //Remove value
        assertFalse(new YK_Mod18_PatternMatch().matchesPattern("aabab","cutcutcutgo"));
        assertFalse(new YK_Mod18_PatternMatch().matchesPattern("bbaba","cutcutcutgo"));
        assertFalse(new YK_Mod18_PatternMatch().matchesPattern("abb","cutcutgcutgo"));
        assertFalse(new YK_Mod18_PatternMatch().matchesPattern("bba","cutgccutgocugo"));
    }

    /*****************
     * Improved implementation
     */

    @Test
    void singleLetterValueImprovedBasedOnBook() {
        assertTrue(new YK_Mod18_PatternMatch().matchesPatternImprovedBasedOnBook("a","c"));
        assertTrue(new YK_Mod18_PatternMatch().matchesPatternImprovedBasedOnBook("b","c"));
        assertFalse(new YK_Mod18_PatternMatch().matchesPatternImprovedBasedOnBook("ab","c"));
        assertFalse(new YK_Mod18_PatternMatch().matchesPatternImprovedBasedOnBook("aa","c"));
        assertFalse(new YK_Mod18_PatternMatch().matchesPatternImprovedBasedOnBook("bb","c"));
    }

    @Test
    void twoLetterValueImprovedBasedOnBook() {
        assertTrue(new YK_Mod18_PatternMatch().matchesPatternImprovedBasedOnBook("a","cu"));
        assertTrue(new YK_Mod18_PatternMatch().matchesPatternImprovedBasedOnBook("b","cu"));
        assertTrue(new YK_Mod18_PatternMatch().matchesPatternImprovedBasedOnBook("ab","cu"));
        assertTrue(new YK_Mod18_PatternMatch().matchesPatternImprovedBasedOnBook("ba","cu"));

        assertFalse(new YK_Mod18_PatternMatch().matchesPatternImprovedBasedOnBook("aba","cu"));
        assertFalse(new YK_Mod18_PatternMatch().matchesPatternImprovedBasedOnBook("aa","cu"));
        assertFalse(new YK_Mod18_PatternMatch().matchesPatternImprovedBasedOnBook("bb","cu"));
        assertFalse(new YK_Mod18_PatternMatch().matchesPatternImprovedBasedOnBook("abb","cu"));
    }

    @Test
    void variousImprovedBasedOnBook() {
        assertTrue(new YK_Mod18_PatternMatch().matchesPatternImprovedBasedOnBook("aabab","cutcutgocutgo"));
        assertTrue(new YK_Mod18_PatternMatch().matchesPatternImprovedBasedOnBook("bbaba","cutcutgocutgo"));
        assertTrue(new YK_Mod18_PatternMatch().matchesPatternImprovedBasedOnBook("abb","cutcutgocutgo"));
        assertTrue(new YK_Mod18_PatternMatch().matchesPatternImprovedBasedOnBook("bba","cutcutgocutgo"));
        assertTrue(new YK_Mod18_PatternMatch().matchesPatternImprovedBasedOnBook("ab","cutcutgocutgo"));
        assertTrue(new YK_Mod18_PatternMatch().matchesPatternImprovedBasedOnBook("ba","cutcutgocutgo"));

        //Extra pattern
        assertFalse(new YK_Mod18_PatternMatch().matchesPatternImprovedBasedOnBook("aababa","cutcutgocutgo"));
        assertFalse(new YK_Mod18_PatternMatch().matchesPatternImprovedBasedOnBook("abbaba","cutcutgocutgo"));
        assertFalse(new YK_Mod18_PatternMatch().matchesPatternImprovedBasedOnBook("abba","cutcutgocutgo"));
        assertFalse(new YK_Mod18_PatternMatch().matchesPatternImprovedBasedOnBook("bbba","cutcutgocutgo"));
        assertFalse(new YK_Mod18_PatternMatch().matchesPatternImprovedBasedOnBook("bab","cutcutgocutgo"));
        assertFalse(new YK_Mod18_PatternMatch().matchesPatternImprovedBasedOnBook("aaa","cutcutgocutgo"));

        //Remove Pattern
        assertFalse(new YK_Mod18_PatternMatch().matchesPatternImprovedBasedOnBook("abab","cutcutgocutgo"));
        assertFalse(new YK_Mod18_PatternMatch().matchesPatternImprovedBasedOnBook("bbba","cutcutgocutgo"));
        assertFalse(new YK_Mod18_PatternMatch().matchesPatternImprovedBasedOnBook("bb","cutcutgocutgo"));


        //Extra value
        assertFalse(new YK_Mod18_PatternMatch().matchesPatternImprovedBasedOnBook("aabab","cutcutgocutgocut"));
        assertFalse(new YK_Mod18_PatternMatch().matchesPatternImprovedBasedOnBook("bbaba","cutcutgocutgogo"));
        assertFalse(new YK_Mod18_PatternMatch().matchesPatternImprovedBasedOnBook("abb","cutcutcutgocutgogogc"));

        //Remove value
        assertFalse(new YK_Mod18_PatternMatch().matchesPatternImprovedBasedOnBook("aabab","cutcutcutgo"));
        assertFalse(new YK_Mod18_PatternMatch().matchesPatternImprovedBasedOnBook("bbaba","cutcutcutgo"));
        assertFalse(new YK_Mod18_PatternMatch().matchesPatternImprovedBasedOnBook("abb","cutcutgcutgo"));
        assertFalse(new YK_Mod18_PatternMatch().matchesPatternImprovedBasedOnBook("bba","cutgccutgocugo"));
    }

}