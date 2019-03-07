import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class YoniStringPermutationTest {

    private void checkThrow(String s1, String s2, String excMessage) {
        Exception ex;
        ex = assertThrows(YoniException.class, () -> YoniStringPermutation.isPerm(null, "a"));
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

        assertTrue(YoniStringPermutation.isPerm("",""));
        assertFalse(YoniStringPermutation.isPerm("","a"));
        assertFalse(YoniStringPermutation.isPerm("a",""));
    }

    @Test
    void differentLengths() {
        assertFalse(YoniStringPermutation.isPerm("a",""));
        assertFalse(YoniStringPermutation.isPerm("","a"));
        assertFalse(YoniStringPermutation.isPerm("aa","a"));
    }

    @Test
    void permutations() {
        assertTrue(YoniStringPermutation.isPerm("abc","bac"));
        assertTrue(YoniStringPermutation.isPerm("aaa","aaa"));//same letter, multiple same letter
        assertTrue(YoniStringPermutation.isPerm("aab","aba"));//multiple same letters
    }

    @Test
    void notPermutations() {
        assertFalse(YoniStringPermutation.isPerm("a","A"));//case sensitivity
        assertFalse(YoniStringPermutation.isPerm("aabb","abb"));//same letters, not same numbers
        assertFalse(YoniStringPermutation.isPerm("abc","abd"));//last letter different
        assertFalse(YoniStringPermutation.isPerm("Xbc","abc"));//first letter different
        assertFalse(YoniStringPermutation.isPerm("aab","abb"));//middle letter different

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

            assertTrue(YoniStringPermutation.isPerm(s1,s2));
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

            assertFalse(YoniStringPermutation.isPerm(s1,s2));
        }
    }
}