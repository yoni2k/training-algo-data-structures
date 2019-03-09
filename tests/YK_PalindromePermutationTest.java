import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class YK_PalindromePermutationTest {

    @Test
    void newClass() { new YK_PalindromePermutation(); }

    @Test
    void emptyNullStrings() {
        Exception exc = assertThrows(YK_Exception.class, () -> YK_PalindromePermutation.isPermPalindrome(null));
        assertTrue(exc.getMessage().contains("Null"));

        assertTrue(YK_PalindromePermutation.isPermPalindrome(""));
    }

    @SuppressWarnings("SpellCheckingInspection")
    @Test
    void palindromes() {
        assertTrue(YK_PalindromePermutation.isPermPalindrome("a"));
        assertTrue(YK_PalindromePermutation.isPermPalindrome("aa"));
        assertTrue(YK_PalindromePermutation.isPermPalindrome("aaa"));
        assertTrue(YK_PalindromePermutation.isPermPalindrome("aaaa"));

        //one instance
        assertTrue(YK_PalindromePermutation.isPermPalindrome("aba"));
        assertTrue(YK_PalindromePermutation.isPermPalindrome("aab"));
        assertTrue(YK_PalindromePermutation.isPermPalindrome("baa"));

        //only pairs
        assertTrue(YK_PalindromePermutation.isPermPalindrome("aabb"));
        assertTrue(YK_PalindromePermutation.isPermPalindrome("abab"));
        assertTrue(YK_PalindromePermutation.isPermPalindrome("abba"));
        assertTrue(YK_PalindromePermutation.isPermPalindrome("baab"));
        assertTrue(YK_PalindromePermutation.isPermPalindrome("baba"));
        assertTrue(YK_PalindromePermutation.isPermPalindrome("bbaa"));

        //3
        assertTrue(YK_PalindromePermutation.isPermPalindrome("aaabb"));
        assertTrue(YK_PalindromePermutation.isPermPalindrome("aabab"));
        assertTrue(YK_PalindromePermutation.isPermPalindrome("aabba"));
        assertTrue(YK_PalindromePermutation.isPermPalindrome("abaab"));
        assertTrue(YK_PalindromePermutation.isPermPalindrome("ababa"));
        assertTrue(YK_PalindromePermutation.isPermPalindrome("abbaa"));
        assertTrue(YK_PalindromePermutation.isPermPalindrome("baaab"));
        assertTrue(YK_PalindromePermutation.isPermPalindrome("baaba"));
        assertTrue(YK_PalindromePermutation.isPermPalindrome("babaa"));
        assertTrue(YK_PalindromePermutation.isPermPalindrome("bbaaa"));

    }

    @SuppressWarnings("SpellCheckingInspection")
    @Test
    void notPalindromes() {
        //1+1 (+2)
        assertFalse(YK_PalindromePermutation.isPermPalindrome("ab"));
        //still, permutations
        assertFalse(YK_PalindromePermutation.isPermPalindrome("abcc"));
        assertFalse(YK_PalindromePermutation.isPermPalindrome("accb"));
        assertFalse(YK_PalindromePermutation.isPermPalindrome("acbc"));
        assertFalse(YK_PalindromePermutation.isPermPalindrome("bacc"));
        assertFalse(YK_PalindromePermutation.isPermPalindrome("bcac"));
        assertFalse(YK_PalindromePermutation.isPermPalindrome("bcca"));
        assertFalse(YK_PalindromePermutation.isPermPalindrome("cabc"));
        assertFalse(YK_PalindromePermutation.isPermPalindrome("cacb"));
        assertFalse(YK_PalindromePermutation.isPermPalindrome("cbac"));
        assertFalse(YK_PalindromePermutation.isPermPalindrome("cbca"));
        assertFalse(YK_PalindromePermutation.isPermPalindrome("ccab"));
        assertFalse(YK_PalindromePermutation.isPermPalindrome("ccba"));


        //3+1 (+2)
        assertFalse(YK_PalindromePermutation.isPermPalindrome("aaab"));
        assertFalse(YK_PalindromePermutation.isPermPalindrome("aaba"));
        assertFalse(YK_PalindromePermutation.isPermPalindrome("abaa"));
        assertFalse(YK_PalindromePermutation.isPermPalindrome("baaa"));
        //same, permutations
        assertFalse(YK_PalindromePermutation.isPermPalindrome("aaabcc"));
        assertFalse(YK_PalindromePermutation.isPermPalindrome("aaacbc"));
        assertFalse(YK_PalindromePermutation.isPermPalindrome("aaaccb"));
        assertFalse(YK_PalindromePermutation.isPermPalindrome("aabacc"));
        assertFalse(YK_PalindromePermutation.isPermPalindrome("aabcac"));
        assertFalse(YK_PalindromePermutation.isPermPalindrome("aabcca"));
        assertFalse(YK_PalindromePermutation.isPermPalindrome("aacabc"));
        assertFalse(YK_PalindromePermutation.isPermPalindrome("aacacb"));
        assertFalse(YK_PalindromePermutation.isPermPalindrome("aacbac"));
        assertFalse(YK_PalindromePermutation.isPermPalindrome("aacbca"));
        assertFalse(YK_PalindromePermutation.isPermPalindrome("aaccba"));

        assertFalse(YK_PalindromePermutation.isPermPalindrome("abaabc"));
        assertFalse(YK_PalindromePermutation.isPermPalindrome("abaacb"));
        assertFalse(YK_PalindromePermutation.isPermPalindrome("ababac"));
        assertFalse(YK_PalindromePermutation.isPermPalindrome("ababca"));
        assertFalse(YK_PalindromePermutation.isPermPalindrome("abacab"));
        assertFalse(YK_PalindromePermutation.isPermPalindrome("abacba"));
        assertFalse(YK_PalindromePermutation.isPermPalindrome("abbaac"));
        assertFalse(YK_PalindromePermutation.isPermPalindrome("abbaca"));
        //noinspection SpellCheckingInspection
        assertFalse(YK_PalindromePermutation.isPermPalindrome("abbcaa"));
        // Not putting more here
    }

}