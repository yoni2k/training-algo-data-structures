package YK_Cracking1_ArraysStrings_TESTS;

import YK_Cracking1_ArraysStrings.YK_StringPermutation;
import YK_Common.*;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class YK_StringPermutationTest {

    @Test
    void newClass() { new YK_StringPermutation(); }

    private void checkThrow(String s1, String s2, @SuppressWarnings("SameParameterValue") String excMessage) {
        Exception ex;
        ex = assertThrows(YK_Exception.class, () -> YK_StringPermutation.isPerm(s1, s2));
        assertTrue(ex.getMessage().contains(excMessage));
    }

    @Test
    void NullEmptyStrings() {
        checkThrow(null, "a", "Null");
        checkThrow("a", null, "Null");
        checkThrow(null, null, "Null");

        checkThrow(null, "", "Null");
        checkThrow("", null, "Null");
        checkThrow(null, null, "Null");

        assertTrue(YK_StringPermutation.isPerm("",""));
        assertFalse(YK_StringPermutation.isPerm("","a"));
        assertFalse(YK_StringPermutation.isPerm("a",""));
    }

    @Test
    void differentLengths() {
        assertFalse(YK_StringPermutation.isPerm("a",""));
        assertFalse(YK_StringPermutation.isPerm("","a"));
        assertFalse(YK_StringPermutation.isPerm("aa","a"));
    }

    @Test
    void permutations() {
        assertTrue(YK_StringPermutation.isPerm("abc","bac"));
        assertTrue(YK_StringPermutation.isPerm("aaa","aaa"));//same letter, multiple same letter
        assertTrue(YK_StringPermutation.isPerm("aab","aba"));//multiple same letters
    }

    @Test
    void notPermutations() {
        assertFalse(YK_StringPermutation.isPerm("a","A"));//case sensitivity
        //noinspection SpellCheckingInspection
        assertFalse(YK_StringPermutation.isPerm("aabb","abb"));//same letters, not same numbers
        assertFalse(YK_StringPermutation.isPerm("abc","abd"));//last letter different
        assertFalse(YK_StringPermutation.isPerm("Xbc","abc"));//first letter different
        assertFalse(YK_StringPermutation.isPerm("aab","abb"));//middle letter different

    }

    @Test
    void  randomEquals() {

        Random rand = new Random();

        StringBuilder sb = new StringBuilder();

        String s1;
        String s2;

        for (int numTimes = 0; numTimes < 10; numTimes++) {
            sb.delete(0,sb.length());

            for (int i = 0; i < 50; i++) {
                sb.append((char) rand.nextInt(127));
            }
            s1 = sb.toString();
            s2 = sb.toString();

            System.out.println("In randomEquals, string: " + s1);

            assertTrue(YK_StringPermutation.isPerm(s1,s2));
        }
    }

    @Test
    void  randomNotEquals() {

        Random rand = new Random();

        StringBuilder sb = new StringBuilder();

        String s1;
        String s2;

        for (int numTimes = 0; numTimes < 10; numTimes++) {

            sb.delete(0,sb.length());

            for (int i = 0; i < 50; i++) {
                sb.append((char) rand.nextInt(127));
            }
            s1 = sb.toString();

            sb.delete(0,sb.length());
            for (int i = 0; i < 50; i++) {
                sb.append((char) rand.nextInt(127));
            }
            s2 = sb.toString();

            System.out.println("In randomEquals, s1: " + s1);
            System.out.println("In randomEquals, s2: " + s2);

            assertFalse(YK_StringPermutation.isPerm(s1,s2));
        }
    }
}