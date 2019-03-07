import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class YK_PolindromPermutationTest {

    @Test
    void emptyNullStrings() {
        Exception exc = assertThrows(YK_Exception.class, () -> YK_PolindromPermutation.isPermPolindrom(null));
        assertTrue(exc.getMessage().contains("Null"));

        assertTrue(YK_PolindromPermutation.isPermPolindrom(""));
    }

    @Test
    void palindroms() {
        assertTrue(YK_PolindromPermutation.isPermPolindrom("a"));
        assertTrue(YK_PolindromPermutation.isPermPolindrom("aa"));
        assertTrue(YK_PolindromPermutation.isPermPolindrom("aaa"));
        assertTrue(YK_PolindromPermutation.isPermPolindrom("aaaa"));

        //one instance
        assertTrue(YK_PolindromPermutation.isPermPolindrom("aba"));
        assertTrue(YK_PolindromPermutation.isPermPolindrom("aab"));
        assertTrue(YK_PolindromPermutation.isPermPolindrom("baa"));

        //only pairs
        assertTrue(YK_PolindromPermutation.isPermPolindrom("aabb"));
        assertTrue(YK_PolindromPermutation.isPermPolindrom("abab"));
        assertTrue(YK_PolindromPermutation.isPermPolindrom("abba"));
        assertTrue(YK_PolindromPermutation.isPermPolindrom("baab"));
        assertTrue(YK_PolindromPermutation.isPermPolindrom("baba"));
        assertTrue(YK_PolindromPermutation.isPermPolindrom("bbaa"));

        //3
        assertTrue(YK_PolindromPermutation.isPermPolindrom("aaabb"));
        assertTrue(YK_PolindromPermutation.isPermPolindrom("aabab"));
        assertTrue(YK_PolindromPermutation.isPermPolindrom("aabba"));
        assertTrue(YK_PolindromPermutation.isPermPolindrom("abaab"));
        assertTrue(YK_PolindromPermutation.isPermPolindrom("ababa"));
        assertTrue(YK_PolindromPermutation.isPermPolindrom("abbaa"));
        assertTrue(YK_PolindromPermutation.isPermPolindrom("baaab"));
        assertTrue(YK_PolindromPermutation.isPermPolindrom("baaba"));
        assertTrue(YK_PolindromPermutation.isPermPolindrom("babaa"));
        assertTrue(YK_PolindromPermutation.isPermPolindrom("bbaaa"));

    }

    @Test
    void notPalindroms() {
        //1+1 (+2)
        assertFalse(YK_PolindromPermutation.isPermPolindrom("ab"));
        //still, permutations
        assertFalse(YK_PolindromPermutation.isPermPolindrom("abcc"));
        assertFalse(YK_PolindromPermutation.isPermPolindrom("accb"));
        assertFalse(YK_PolindromPermutation.isPermPolindrom("acbc"));
        assertFalse(YK_PolindromPermutation.isPermPolindrom("bacc"));
        assertFalse(YK_PolindromPermutation.isPermPolindrom("bcac"));
        assertFalse(YK_PolindromPermutation.isPermPolindrom("bcca"));
        assertFalse(YK_PolindromPermutation.isPermPolindrom("cabc"));
        assertFalse(YK_PolindromPermutation.isPermPolindrom("cacb"));
        assertFalse(YK_PolindromPermutation.isPermPolindrom("cbac"));
        assertFalse(YK_PolindromPermutation.isPermPolindrom("cbca"));
        assertFalse(YK_PolindromPermutation.isPermPolindrom("ccab"));
        assertFalse(YK_PolindromPermutation.isPermPolindrom("ccba"));


        //3+1 (+2)
        assertFalse(YK_PolindromPermutation.isPermPolindrom("aaab"));
        assertFalse(YK_PolindromPermutation.isPermPolindrom("aaba"));
        assertFalse(YK_PolindromPermutation.isPermPolindrom("abaa"));
        assertFalse(YK_PolindromPermutation.isPermPolindrom("baaa"));
        //same, permutations
        assertFalse(YK_PolindromPermutation.isPermPolindrom("aaabcc"));
        assertFalse(YK_PolindromPermutation.isPermPolindrom("aaacbc"));
        assertFalse(YK_PolindromPermutation.isPermPolindrom("aaaccb"));
        assertFalse(YK_PolindromPermutation.isPermPolindrom("aabacc"));
        assertFalse(YK_PolindromPermutation.isPermPolindrom("aabcac"));
        assertFalse(YK_PolindromPermutation.isPermPolindrom("aabcca"));
        assertFalse(YK_PolindromPermutation.isPermPolindrom("aacabc"));
        assertFalse(YK_PolindromPermutation.isPermPolindrom("aacacb"));
        assertFalse(YK_PolindromPermutation.isPermPolindrom("aacbac"));
        assertFalse(YK_PolindromPermutation.isPermPolindrom("aacbca"));
        assertFalse(YK_PolindromPermutation.isPermPolindrom("aaccba"));

        assertFalse(YK_PolindromPermutation.isPermPolindrom("abaabc"));
        assertFalse(YK_PolindromPermutation.isPermPolindrom("abaacb"));
        assertFalse(YK_PolindromPermutation.isPermPolindrom("ababac"));
        assertFalse(YK_PolindromPermutation.isPermPolindrom("ababca"));
        assertFalse(YK_PolindromPermutation.isPermPolindrom("abacab"));
        assertFalse(YK_PolindromPermutation.isPermPolindrom("abacba"));
        assertFalse(YK_PolindromPermutation.isPermPolindrom("abbaac"));
        assertFalse(YK_PolindromPermutation.isPermPolindrom("abbaca"));
        assertFalse(YK_PolindromPermutation.isPermPolindrom("abbcaa"));
        // Not putting more here
    }

}